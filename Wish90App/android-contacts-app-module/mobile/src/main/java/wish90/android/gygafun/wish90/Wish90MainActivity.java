package wish90.android.gygafun.wish90;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Wish90MainActivity extends AppCompatActivity {
        String name,displayBirthday;
        Wish90MainActivity abc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish90_main);
        RecyclerView rc;
        rc=(RecyclerView)findViewById(R.id.rv);
        rc.setHasFixedSize(true);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        rc.setLayoutManager(llm);
         List<Personsinfo> persons;
        persons=new ArrayList<>();

        Cursor cursor = getContacts();
        while (cursor.moveToNext()) {
             name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            displayBirthday = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Event.START_DATE));
            persons.add(new Personsinfo(name,displayBirthday));


        }
        MyAdapter adapter = new MyAdapter(persons);
        rc.setAdapter(adapter);
    }

    private Cursor getContacts() {
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
        ContentResolver cr=getContentResolver();

        return cr.query(uri, projection, where, selectionArgs, sortOrder);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wish90_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
