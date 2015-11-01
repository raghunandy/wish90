package leona.gygafun.wish90.presentation.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Raghu on 11/1/2015.
 */
public class TextUtil {

    private  static final SimpleDateFormat sdf=new SimpleDateFormat("MMM-dd-yyyy");
    public static String makeSimpleDatString(Date date){
        String ds=sdf.format(date);
        return ds;
    }
}
