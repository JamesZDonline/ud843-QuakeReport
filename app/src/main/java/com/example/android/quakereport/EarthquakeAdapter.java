package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jameszd on 8/9/16.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){


        super(context,0,earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check if existing view is being reused otherwise inflate a view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake earthquake=getItem(position);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        magnitudeTextView.setText(earthquake.getMag());

        TextView placeTextView = (TextView) listItemView.findViewById(R.id.placename_text_view);
        placeTextView.setText(earthquake.getPlaceName());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        dateTextView.setText(earthquake.getQuakeDate());


        return listItemView;
    }
}
