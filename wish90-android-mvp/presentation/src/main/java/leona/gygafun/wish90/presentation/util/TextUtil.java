package leona.gygafun.wish90.presentation.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Raghu on 11/1/2015.
 */
public class TextUtil {

    private  static final SimpleDateFormat sdf=new SimpleDateFormat("MMM dd yyyy");
    public static String makeSimpleDatString(Date date){
        String ds=sdf.format(date);
        return ds;
    }

    /**
     * Code is refered by a blog discussion
     * http://stackoverflow.com/questions/12387492/how-do-i-convert-a-string-to-title-case-in-android
     * @param title
     * @return
     */
    public static String makeStringCamelCase(String title){
        String[] words = title.split(" ");
        StringBuilder sb = new StringBuilder();
        if (words[0].length() > 0) {
            sb.append(Character.toUpperCase(words[0].charAt(0)) + words[0].subSequence(1, words[0].length()).toString().toLowerCase());
            for (int i = 1; i < words.length; i++) {
                sb.append(" ");
                sb.append(Character.toUpperCase(words[i].charAt(0)) + words[i].subSequence(1, words[i].length()).toString().toLowerCase());
            }
        }
        String titleCaseValue = sb.toString();
        return titleCaseValue;
    }
}
