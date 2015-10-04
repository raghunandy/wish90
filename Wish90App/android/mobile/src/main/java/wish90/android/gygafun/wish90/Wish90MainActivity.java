package wish90.android.gygafun.wish90;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class Wish90MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID=23;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish90_main);
        notification=new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }
    public void notificationButtonClick(View view){
        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setTicker("This is the ticker..........");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Here is the title");
        notification.setContentText("I am the body text of your notification");

        Intent intent=new Intent(this, Wish90MainActivity.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID,notification.build());
    }
}
