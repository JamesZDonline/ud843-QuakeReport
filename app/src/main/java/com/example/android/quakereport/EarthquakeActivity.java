/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Earthquake>> {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    private static final int EARTHQUAKE_LOADER_ID = 1;

    /** Adapter for the list of earthquakes */
    private EarthquakeAdapter earthquakeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        //use loader manager and loader to retrieve data async
        getSupportLoaderManager().initLoader(EARTHQUAKE_LOADER_ID,null,this).forceLoad();
    }

/* Update the to show the quake list*/
    private void updateUi(ArrayList<Earthquake> earthquakes){
        earthquakeAdapter = new EarthquakeAdapter(EarthquakeActivity.this,earthquakes);
        ListView listView = (ListView) findViewById(R.id.quakelist);
        listView.setEmptyView(findViewById(R.id.noEarthquakes));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String url = earthquakeAdapter.getItem(i).getUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);

            }
        });


        listView.setAdapter(earthquakeAdapter);
    }

    public Loader<ArrayList<Earthquake>> onCreateLoader(int id, Bundle args) {
        return new EarthquakeLoader(EarthquakeActivity.this);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Earthquake>> loader, ArrayList<Earthquake> earthquakes) {
        updateUi(earthquakes);
        TextView emptyText = (TextView) findViewById(R.id.noEarthquakes);
        emptyText.setText("No earthquakes found!");
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Earthquake>> loader) {
        earthquakeAdapter.clear();

    }

}
