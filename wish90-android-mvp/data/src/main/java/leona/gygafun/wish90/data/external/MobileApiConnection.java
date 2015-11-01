/**
 Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
 */
package leona.gygafun.wish90.data.external;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;

import leona.gygafun.wish90.data.entity.ContactEntity;
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



public class MobileApiConnection implements Callable<String> {
    private final Context context;
    public static final String[] DATE_FORMAT_STRINGS=new String[]{ "MMMM d, yyyy","yyyy-MM-dd"};
    String name,momentDate,contactImage;
    private String response;

    public MobileApiConnection(Context context) throws MalformedURLException {
        this.context=context;
    }


    public static JsonArray getJsonFromMyObject(List<UserMomentEntity> moment) throws JSONException
    {
        return new Gson().toJsonTree(moment).getAsJsonArray();
    }


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
                ContactsContract.CommonDataKinds.Event.START_DATE,
                ContactsContract.CommonDataKinds.Phone.PHOTO_URI

        };

        String where =
                ContactsContract.Data.MIMETYPE + "= ? AND " +
                        ContactsContract.CommonDataKinds.Event.TYPE + "=" + ContactsContract.CommonDataKinds.Event.TYPE_BIRTHDAY;
        String[] selectionArgs = new String[] {ContactsContract.CommonDataKinds.Event.CONTENT_ITEM_TYPE};
        String sortOrder = null;
        ContentResolver cr=context.getApplicationContext().getContentResolver();

        return cr.query(uri, projection, where, selectionArgs, sortOrder);
    }


    private Date convertStringToDate(String dateString,String formatString)  {
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        Date date = null;
        try {
            date = format.parse(dateString);


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


        List<UserMomentEntity> moments=new ArrayList<>();
        Cursor cursor = getContacts(context);
        while (cursor.moveToNext()) {
            name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            momentDate = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Event.START_DATE));
            contactImage=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));
            Date d=convertStringToDate(momentDate);
            if(d!=null) {
                ContactEntity contact=new ContactEntity(name,contactImage);
                moments.add(new UserMomentEntity(d, contact));
            }

        }
        JsonArray personJson= MobileApiConnection.getJsonFromMyObject(moments);
        this.response=personJson.toString();

    }

    @Override
    public String call() throws Exception {
        return requestSyncCall();
    }
}
