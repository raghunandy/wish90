package wish90.android.gygafun.wish90;

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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class Wish90ConveyWishActivity extends AppCompatActivity {
    private static Bitmap bmp;
    private static ImageView imgView;

    public Bitmap drawTextToBitmap(Context context, int resourceId,  String mText) { //function copied from http://stackoverflow.com/questions/7320392/how-to-draw-text-on-image
        try {
            Resources resources = context.getResources();
            float scale = resources.getDisplayMetrics().density;
            Bitmap bitmap = BitmapFactory.decodeResource(resources, resourceId);

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
            paint.setTextSize((int) (30*scale));


            // draw text to the Canvas center
            Rect bounds = new Rect();
            paint.getTextBounds(mText, 0, mText.length(), bounds);
            int x = (bitmap.getWidth() - bounds.width())/5;
            int y = (bitmap.getHeight() + bounds.height())/4;

            canvas.drawText(mText, x , y , paint);

            return bitmap;
        } catch (Exception e) {
            // TODO: handle exception

            return null;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish90_convey_wish);
        Intent intent=getIntent();
        String friendname=intent.getStringExtra("friendname");
        bmp=drawTextToBitmap(this,R.mipmap.wish90_conveywish, "Happy Birthday "+friendname+"!");
        imgView=(ImageView)findViewById(R.id.imgIconWithWish);
        imgView.setImageBitmap(bmp);
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
