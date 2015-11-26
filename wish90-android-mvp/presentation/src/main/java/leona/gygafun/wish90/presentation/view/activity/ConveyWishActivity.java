package leona.gygafun.wish90.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import leona.gygafun.wish90.presentation.R;
import leona.gygafun.wish90.presentation.di.components.DaggerUserComponent;
import leona.gygafun.wish90.presentation.di.components.UserComponent;


public class ConveyWishActivity extends BaseActivity {

    @Bind(R.id.imgIconWithWish) ImageView imgView;
    private UserComponent userComponent;

    public Bitmap drawTextToBitmap(Context context, int resourceId,  String mText) { //function copied from http://stackoverflow.com/questions/7320392/how-to-draw-text-on-image
        try {
            Resources resources = context.getResources();
            float scale = resources.getDisplayMetrics().density;
            Bitmap bitmap = BitmapFactory.decodeResource(resources, resourceId);

            Bitmap.Config bitmapConfig =   bitmap.getConfig();
            // set default bitmap config if none
            if(bitmapConfig == null) {

                bitmapConfig = Bitmap.Config.ARGB_8888;
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
            paint.setTextSize((int) (40*scale));
            paint.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));


            // draw text to the Canvas center
            Rect bounds = new Rect();
            paint.getTextBounds(mText, 0, mText.length(), bounds);
            int x = (bitmap.getWidth() - bounds.width())/7;
            int y = (bitmap.getHeight() + bounds.height())/7;

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
        setContentView(R.layout.activity_convey_wish);
        ButterKnife.bind(this);
        this.initializeInjector();
        Intent intent=getIntent();
        String contactName=intent.getStringExtra("contactName");
        Bitmap bmp=drawTextToBitmap(this, R.drawable.bgthreehands,"Happy Birthday "+contactName+"!");
        imgView.setImageBitmap(bmp);
    }
    private void initializeInjector() {
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }
}
