package com.example.android.quakereport;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;

/**
 * Created by jameszd on 8/22/16.
 */
public class EarthquakeLoader extends AsyncTaskLoader<ArrayList<Earthquake>> {
    public EarthquakeLoader(Context context){
        super(context);
    }

    @Override
    public ArrayList<Earthquake> loadInBackground() {
        ArrayList<Earthquake> result = QueryUtils.extractEarthquakes();
        return result;
    }
}
