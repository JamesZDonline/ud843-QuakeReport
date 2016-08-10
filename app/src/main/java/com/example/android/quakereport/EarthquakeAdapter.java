package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
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

        //Get particular earthquake item
        Earthquake earthquake=getItem(position);

        //Find Magnitude Text View and get the magnitude circle
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        //Get the Magnitude
        double magnitude = earthquake.getMag();

        //Find the correct color for that magnitude
        int magnitudeColor = getMagnitudeColor(magnitude);

        //Set the background circle to the correct color
        magnitudeCircle.setColor(magnitudeColor);

        //Format Magnitude Decimal Correctly
        DecimalFormat formatter = new DecimalFormat("0.00");
        String mag = formatter.format(magnitude);
        magnitudeTextView.setText(mag);

        TextView placeTextView = (TextView) listItemView.findViewById(R.id.placename_text_view);
        TextView offsetTextView = (TextView) listItemView.findViewById(R.id.offset_text_view);
        String placeName = earthquake.getPlaceName();
        String locationOffset;
        int oflocation = placeName.indexOf(" of ");
        if (oflocation != -1){
            locationOffset = placeName.substring(0,oflocation+4);
            placeName = placeName.substring(oflocation+4,placeName.length());
        }else {locationOffset = "Near the ";}

        offsetTextView.setText(locationOffset);
        placeTextView.setText(placeName);

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        dateTextView.setText(earthquake.getQuakeDate());

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);
        timeTextView.setText(earthquake.getQuakeTime());


        return listItemView;
    }

    private int getMagnitudeColor(double mag){
        int magColorResourceID;
        int magnitudeFloor = (int) Math.floor(mag);
        switch (magnitudeFloor){
            case 0:
                magColorResourceID = R.color.white;
                break;
            case 1:
                magColorResourceID = R.color.magnitude1;
                break;
            case 2:
                magColorResourceID = R.color.magnitude2;
                break;
            case 3:
                magColorResourceID = R.color.magnitude3;
                break;
            case 4:
                magColorResourceID = R.color.magnitude4;
                break;
            case 5:
                magColorResourceID = R.color.magnitude5;
                break;
            case 6:
                magColorResourceID = R.color.magnitude6;
                break;
            case 7:
                magColorResourceID = R.color.magnitude7;
                break;
            case 8:
                magColorResourceID = R.color.magnitude8;
                break;
            case 9:
                magColorResourceID = R.color.magnitude9;
                break;
            default:
                magColorResourceID = R.color.magnitude10plus;
                break;

        }
        return ContextCompat.getColor(getContext(),magColorResourceID);

    }
}
