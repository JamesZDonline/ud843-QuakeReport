/**
 * Created by jameszd on 8/9/16.
 */

package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Earthquake {

    //Information about the magnitude of the earthquake
    private double magnitude;

    //The name of the place the earthquake took place
    private String placeName;

    //The date the earthquake occurred
    private String date;

    //The time the earthquake occured
    private String time;

    //The earthquake url
    private String url;


    /*
    Constructor for Earthquake object

    @param magnitude is the magnitude of the earthquake
    @param placeName is the place the earthquake took place
    @param date is the date the earthquake occurred
     */
    public Earthquake(double xmagnitude, String xplaceName, long xtime, String xurl){
        magnitude = xmagnitude;
        placeName = xplaceName;
        Date dateTime = new Date(xtime);
        SimpleDateFormat formatDate = new SimpleDateFormat("MMM d, y");
        SimpleDateFormat formatTime = new SimpleDateFormat("h:mm:ss a");
        date = formatDate.format(dateTime);
        time = formatTime.format(dateTime);
        url = xurl;
    }

    /**
     * Get the magnitude of the Eartquake
     */

    public double getMag(){
        return magnitude;
    }

    /**
     * Get the Location of the earthquake
     */
    public String getPlaceName(){
        return placeName;
    }

    /**
     * Get the Date of the earthquake
     */
    public String getQuakeDate(){
        return date;
    }

    /**
     * Get the time of the earthquake
     */
    public String getQuakeTime() {return time;}

    /**
     * Get the URL
     */
    public String getUrl() { return url;}

}
