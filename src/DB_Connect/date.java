/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connect;

/**
 *
 * @author EGUAVOEN BRIGHT
 */
import java.util.*;
import java.text.*;
public class date {
    public static void main(String args[]) {
       /*// Instantiate a Date object
       Date date = new Date();
        
       // display time and date using toString()
       System.out.println(date.toString());*/
       Date dNow = new Date( );
      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
      //new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        
      System.out.println("Current Date: " + ft.format(dNow));
   }
}
