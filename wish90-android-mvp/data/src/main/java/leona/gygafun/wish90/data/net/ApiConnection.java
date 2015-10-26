/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package leona.gygafun.wish90.data.net;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;

import leona.gygafun.wish90.data.entity.UserMomentEntity;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.squareup.okhttp.OkHttpClient;

import org.json.JSONException;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
//import android.support.v7.widget.RecyclerView;

/**
 * Api Connection class used to retrieve data from the cloud.
 * Implements {@link java.util.concurrent.Callable} so when executed asynchronously can
 * return a value.
 */

public class ApiConnection implements Callable<String> {
    private final Context context;
    public static final String[] DATE_FORMAT_STRINGS=new String[]{ "MMMM d, yyyy","yyyy-mm-dd"};
    private static final String CONTENT_TYPE_LABEL = "Content-Type";
    private static final String CONTENT_TYPE_VALUE_JSON = "application/json; charset=utf-8";
    public static List<UserMomentEntity> contact;
    String name,momentDate;
    private URL url;
    private String response;

    public ApiConnection(Context context) throws MalformedURLException {
        this.context=context;
       // this.url = new URL(url);
    }

   /* public static ApiConnection createGET(String url) throwsdous MalformedURLException {
        return new ApiConnection(url);
    }*/

    public static JsonArray getJsonFromMyObject(List<UserMomentEntity> contact) throws JSONException
    {
        return new Gson().toJsonTree(contact).getAsJsonArray();
    }

    /**
     * Do a request to an api synchronously.
     * It should not be executed in the main thread of the application.
     *
     * @return A string response
     */


    @Nullable
    public String requestSyncCall() throws JSONException, ParseException {
        connectToApi();
        return response;
    }

    private Cursor getContacts(Context context) {
        // Run query
        Uri uri = ContactsContract.Data.CONTENT_URI;

        String[] projection = new String[] {
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Event.CONTACT_ID,
                ContactsContract.CommonDataKinds.Event.START_DATE
        };

        String where =
                ContactsContract.Data.MIMETYPE + "= ? AND " +
                        ContactsContract.CommonDataKinds.Event.TYPE + "=" + ContactsContract.CommonDataKinds.Event.TYPE_BIRTHDAY;
        String[] selectionArgs = new String[] {ContactsContract.CommonDataKinds.Event.CONTENT_ITEM_TYPE};
        String sortOrder = null;
        ContentResolver cr=context.getApplicationContext().getContentResolver();

        return cr.query(uri, projection, where, selectionArgs, sortOrder);
    }

    /*  Added by: Deepti
        Converting date from String->Date->Calendar. Day,Month and Year can be obtained using cal.get(Calendar.DAY_OF_MONTH, etc.)
        see http://docs.oracle.com/javase/7/docs/api/java/util/Date.html for details
    */

    private Date convertStringToDate(String dateString,String formatString)  {
        DateFormat format = new SimpleDateFormat(formatString, Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(dateString);
            Calendar cal=Calendar.getInstance();
            cal.setTime(date);

        } catch (ParseException e) {

        }

        return date;
    }
        private Date convertStringToDate(String dateString) throws ParseException{
            for (String format:DATE_FORMAT_STRINGS
                 ) {
                Date d=convertStringToDate(dateString,format);
                if(d!=null){
                    return d;
                }
            }
        return null;

    }
    private void connectToApi() throws JSONException, ParseException{


        List<UserMomentEntity> contact=new ArrayList<>();
        Cursor cursor = getContacts(context);
        while (cursor.moveToNext()) {
            name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            momentDate = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Event.START_DATE));
            Date d=convertStringToDate(momentDate);
            if(d!=null)
                contact.add(new UserMomentEntity(d, name));

        }
        JsonArray personJson=ApiConnection.getJsonFromMyObject(contact);
        this.response=personJson.toString();
        //MyAdapter adapter = new MyAdapter(contact);
        //rc.setAdapter(adapter);
    }

    private OkHttpClient createClient() {
        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(10000, TimeUnit.MILLISECONDS);
        okHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS);

        return okHttpClient;
    }

    @Override
    public String call() throws Exception {
        return requestSyncCall();
    }
}
