package wish90.android.gygafun.wish90;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Wish90MainActivity extends AppCompatActivity {

    private static Button conveyButton;
    private static EditText friendName;
    private static TextView txtlabel;

    private static String txt="default"; //for debugging

    NotificationCompat.Builder notification;
    private static final int uniqueID=23;


    public void buttonClick(View view){

        conveyButton=(Button)findViewById(R.id.btnNotify);
        txtlabel=(TextView)findViewById(R.id.textView);
        friendName=(EditText)findViewById(R.id.txtfriendName);
        txt=friendName.getText().toString();

        notification.setSmallIcon(R.mipmap.wish90_icon);
        notification.setTicker("One of your friends has an event");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Wish90");
        notification.setContentText("Click here to wish " + txt);

        Intent intent = new Intent(this, Wish90ConveyWishActivity.class);
        intent.putExtra("friendname", txt);
        PendingIntent pendingIntent= PendingIntent.getActivity(this,0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID,notification.build());

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish90_main);

        notification=new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

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