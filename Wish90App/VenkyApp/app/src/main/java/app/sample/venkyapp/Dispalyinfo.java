package app.sample.venkyapp;


import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import java.util.Date;


public class Dispalyinfo extends AppCompatActivity {
    String nameofperson;
    String image;
    String dateofbirth;
    TextView Name,DOB;
    ImageView DisplayPhoto;

    private TextView timerValueMilli;
    private TextView timerValueSec;
    private TextView timerValueMin;
    private TextView timerValueHour;
    private TextView timerValueDays;
    private TextView timerValueWeeks;


    private Handler customHandler = new Handler();
    // private long startTime = 0L;
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispalyinfo);
        nameofperson= getIntent().getStringExtra("Name");
        dateofbirth=getIntent().getStringExtra("dateofbirth");
        image=getIntent().getStringExtra("picture");
        Name=(TextView)findViewById(R.id.name);
        DOB=(TextView)findViewById(R.id.Dob);
        DisplayPhoto=(ImageView)findViewById(R.id.DisplayPhoto);
        Name.setText(nameofperson);
        DOB.setText(dateofbirth);
        if (image!= null){
            DisplayPhoto.setImageURI(Uri.parse(image));
        }
        else{
            DisplayPhoto.setImageResource(R.drawable.rsz_1rsz_default_image);
        }


        Typeface font = Typeface.createFromAsset(getAssets(), "DS-DIGII.TTF");

        //timer
        timerValueMilli = (TextView) findViewById(R.id.timerValueMilli);
        timerValueMilli.setTypeface(font);
        //customHandler.postDelayed(updateTimerThread, 0);
        timerValueSec = (TextView) findViewById(R.id.timerValueSec);
        timerValueSec.setTypeface(font);
        //customHandler.postDelayed(updateTimerThread, 0);
        timerValueMin = (TextView) findViewById(R.id.timerValueMin);
        timerValueMin.setTypeface(font);
        //customHandler.postDelayed(updateTimerThread, 0);
        timerValueHour = (TextView) findViewById(R.id.timerValueHour);
        timerValueHour.setTypeface(font);
        //customHandler.postDelayed(updateTimerThread, 0);
        timerValueDays = (TextView) findViewById(R.id.timerValueDays);
        timerValueDays.setTypeface(font);
        //customHandler.postDelayed(updateTimerThread, 0);
        timerValueWeeks = (TextView) findViewById(R.id.timerValueWeeks);
        timerValueWeeks.setTypeface(font);


        //startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimerThread, 0);




    }

    private Runnable updateTimerThread = new Runnable() {    //timer

            /* calculate time and update dynamically */

        public void run() {

            Date startDate= null;
            try {
                startDate = new SimpleDateFormat("MMM dd, yyyy").parse(dateofbirth);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date current=new Date();

            timeInMilliseconds = current.getTime()-startDate.getTime();
            updatedTime = timeSwapBuff + timeInMilliseconds;

            //convert millisecond values to required values



            //milli seconds
            long milliSecs =  (updatedTime);
            DecimalFormat formatterMilli = new DecimalFormat("  #,### ms");
            String formattedMilli = formatterMilli.format(milliSecs);

            timerValueMilli.setText(formattedMilli);




            //seconds
            long secs =  (updatedTime/1000);
            DecimalFormat formatterSecs = new DecimalFormat("  #,### sec");
            String formattedSecs = formatterSecs.format(secs);

            timerValueSec.setText( formattedSecs);


            //minutes
            long mins =  (secs/60);
            DecimalFormat formatterMins = new DecimalFormat("  #,### mins");
            String formattedMins = formatterMins.format(mins);

            timerValueMin.setText(formattedMins);


            //hours
            long hours =  (mins/60);
            DecimalFormat formatterHours = new DecimalFormat("  #,### hrs");
            String formattedHours = formatterHours.format(hours);

            timerValueHour.setText( formattedHours);


            //days
            long days =  (hours/24);
            DecimalFormat formatterDays = new DecimalFormat("  #,### days");
            String formattedDays = formatterDays.format(days);

            timerValueDays.setText(formattedDays);


            //weeks
            long weeks =  (days/7);
            DecimalFormat formatterWeeks = new DecimalFormat("  #,### weeks");
            String formattedWeeks = formatterWeeks.format(weeks);

            timerValueWeeks.setText( formattedWeeks);


            customHandler.postDelayed(this, 0);
        }

    };

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
