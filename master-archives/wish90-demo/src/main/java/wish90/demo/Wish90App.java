/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wish90.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Raghu
 */
public class Wish90App {
//    private static String incomingDate="06-08-1982"; // Siva
//    private static String incomingDate="07-26-1982"; //Rrazata
//    private static String incomingDate="06-29-1994"; //Deepthi
//    private static String incomingDate="08-05-1993"; //Venky
//    private static String incomingDate="02-10-1993"; //Irani
    private static String incomingDate="04-09-1984"; //Raghu
//    
    public static void main(String[] args) throws ParseException {
        
        Date dateOfBirth=new SimpleDateFormat("MM-dd-yyyy").parse(incomingDate);
        System.out.println("Date="+dateOfBirth);
        Date now=new Date();
        System.out.println("in:"+incomingDate);
        long diffMilliSeocnds=now.getTime()-dateOfBirth.getTime();
        System.out.println("Total Milli Seconds:"+diffMilliSeocnds);
        System.out.println("Total  Seconds:"+(long)(diffMilliSeocnds/1000));
        System.out.println("Total  Min:"+(long)(diffMilliSeocnds/(60*1000)));
        System.out.println("Total  Hrs:"+(long)(diffMilliSeocnds/(60*60*1000)));
        System.out.println("Total  Days:"+(long)(diffMilliSeocnds/(24*60*60*1000)));
        
        System.out.println("Total  Weeks:"+(int)(diffMilliSeocnds/(7*24*60*60*1000)));
        
        //System.out.println("Total  Weeks:"+(int)(diffMilliSeocnds/(7*24*60*60*1000)));
    }
}
