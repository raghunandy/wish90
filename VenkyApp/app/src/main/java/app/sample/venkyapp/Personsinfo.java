package app.sample.venkyapp;


import android.graphics.Bitmap;
import android.net.Uri;

import java.io.InputStream;

/**
 * Created by VENKY on 10/12/2015.
 */
public class Personsinfo {
    String name;
    String dateofbirth;
    String image;

    Personsinfo(String image,String x,String y){
        name=x;
        dateofbirth=y;
        this.image=image;
    }
}
