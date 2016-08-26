package com.example.android.quakereport;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;

/**
 * Created by jameszd on 8/22/16.
 */
public class EarthquakeLoader extends AsyncTaskLoader<ArrayList<Earthquake>> {
    private String mUrl;
    public EarthquakeLoader(Context context, String url){
        super(context);
        mUrl=url;
    }

    @Override
    public ArrayList<Earthquake> loadInBackground() {
        ArrayList<Earthquake> result = QueryUtils.extractEarthquakes(mUrl);
        return result;
    }
}
