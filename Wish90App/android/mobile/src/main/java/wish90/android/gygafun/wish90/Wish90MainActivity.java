package wish90.android.gygafun.wish90;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Wish90MainActivity extends AppCompatActivity {

    private static ImageView imgView;
    private static Button conveyButton;
    private static EditText friendName;
    private static TextView txtlabel;

    private static String txt="default"; //for debugging
    private static Bitmap bmp;

    public Bitmap drawTextToBitmap( int resourceId,  String mText) { //function copied from http://stackoverflow.com/questions/7320392/how-to-draw-text-on-image
        try {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resourceId);

            android.graphics.Bitmap.Config bitmapConfig =   bitmap.getConfig();
            // set default bitmap config if none
            if(bitmapConfig == null) {

                bitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
            }
            // resource bitmaps are imutable,
            // so we need to convert it to mutable one
            bitmap = bitmap.copy(bitmapConfig, true);

            Canvas canvas = new Canvas(bitmap);
            // new antialised Paint
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            // text color - #3D3D3D
            paint.setColor(Color.rgb(110, 110, 110));
            // text size in pixels
            paint.setTextSize((int) (12));


            // draw text to the Canvas center
            Rect bounds = new Rect();
            paint.getTextBounds(mText, 0, mText.length(), bounds);
            int x = (bitmap.getWidth() - bounds.width())/6;
            int y = (bitmap.getHeight() + bounds.height())/5;

            canvas.drawText(mText, x , y , paint);

            return bitmap;
        } catch (Exception e) {
            // TODO: handle exception

            return null;
        }

    }
    public void buttonClick(){

        imgView=(ImageView)findViewById(R.id.imgIconWithWish);
        conveyButton=(Button)findViewById(R.id.btnConveyWish);
        txtlabel=(TextView)findViewById(R.id.textView);
        conveyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                friendName=(EditText)findViewById(R.id.txtfriendName);
                txt=friendName.getText().toString();

                bmp=drawTextToBitmap(R.mipmap.wish90_icon, "Happy Birthday "+txt+"!");
                txtlabel.setVisibility(View.INVISIBLE);
                friendName.setVisibility(View.INVISIBLE);
                imgView.setImageBitmap(bmp);
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish90_main);
        buttonClick();

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
