package app.sample.venkyapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.TextView;

public class Dispalyinfo extends AppCompatActivity {
    String nameofperson;
    String dateofbirth;
    TextView Name,DOB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispalyinfo);
        nameofperson= getIntent().getStringExtra("Name");
        dateofbirth=getIntent().getStringExtra("dateofbirth");
        Name=(TextView)findViewById(R.id.name);
        DOB=(TextView)findViewById(R.id.Dob);
        Name.setText(nameofperson);
        DOB.setText(dateofbirth);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_dispalyinfo, menu);
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
