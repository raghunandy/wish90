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
package com.fernandocejas.android10.sample.data.net;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

    private static final String CONTENT_TYPE_LABEL = "Content-Type";
    private static final String CONTENT_TYPE_VALUE_JSON = "application/json; charset=utf-8";
    public static List<ContactDetailsTemplate> persons;
    String name,displayBirthday;
    private URL url;
    private String response;

    public ApiConnection(Context context) throws MalformedURLException {
        this.context=context;
       // this.url = new URL(url);
    }

   /* public static ApiConnection createGET(String url) throws MalformedURLException {
        return new ApiConnection(url);
    }*/

    public static JSONObject getJsonFromMyFormObject(List<ContactDetailsTemplate> persons) throws JSONException
    {
        JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < persons.size(); i++)
        {
            JSONObject formDetailsJson = new JSONObject();
            formDetailsJson.put("person_name", persons.get(i).getName());
            formDetailsJson.put("person_dob", persons.get(i).getDateofbirth());
            jsonArray.put(formDetailsJson);
        }
        responseDetailsJson.put("forms", jsonArray);
        return responseDetailsJson;
    }

    /**
     * Do a request to an api synchronously.
     * It should not be executed in the main thread of the application.
     *
     * @return A string response
     */


    @Nullable
    public String requestSyncCall() throws JSONException{
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
    private void connectToApi() throws JSONException{


        List<ContactDetailsTemplate> persons;
        persons=new ArrayList<>();

        Cursor cursor = getContacts(context);
        while (cursor.moveToNext()) {
            name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            displayBirthday = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Event.START_DATE));
            persons.add(new ContactDetailsTemplate(name,displayBirthday));
        }
        JSONObject personJson=ApiConnection.getJsonFromMyFormObject(persons);
        this.response=personJson.toString();
        //MyAdapter adapter = new MyAdapter(persons);
        //rc.setAdapter(adapter);
    }

    private OkHttpClient createClient() {
        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(10000, TimeUnit.MILLISECONDS);
        okHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS);

        return okHttpClient;
    }

    @Override public String call() throws Exception {
        return requestSyncCall();
    }
}
