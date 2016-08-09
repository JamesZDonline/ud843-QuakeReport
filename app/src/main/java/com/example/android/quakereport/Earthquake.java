/**
 * Created by jameszd on 8/9/16.
 */

package com.example.android.quakereport;

public class Earthquake {

    //Information about the magnitude of the earthquake
    private String magnitude;

    //The name of the place the earthquake took place
    private String placeName;

    //The date the earthquake occurred
    private String date;


    /*
    Constructor for Earthquake object

    @param magnitude is the magnitude of the earthquake
    @param placeName is the place the earthquake took place
    @param date is the date the earthquake occurred
     */
    public Earthquake(String xmagnitude, String xplaceName, String xdate){
        magnitude = xmagnitude;
        placeName = xplaceName;
        date = xdate;
    }

    /**
     * Get the magnitude of the Eartquake
     */

    public String getMag(){
        return magnitude;
    }

    /**
     * Get the Location of the earthquake
     */
    public String getPlaceName(){
        return placeName;
    }

    /**
     * Get the Location of the earthquake
     */
    public String getQuakeDate(){
        return date;
    }

}
