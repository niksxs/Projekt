package com.example.niklas.projekt;

//import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/*
* Selbe wie MainActivity4 nur mit Swipe
* */
public class MainActivity5 extends ListActivity
{

    ArrayList<String> vals = new ArrayList<String>();
    ArrayAdapter<String> ad;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity5);

        String[] values = {"Aufwärmen",
                "Beine",
                "Brust",
                "Rücken",
                "Schulter",
                "Nacken",
                "Bauch",
                "Bizeps",
                "Trizeps",
                "Abkühlen"
        };

        // Fuege alle Werte aus dem Array values ind die ArrayList vals ein
        vals = new ArrayList<String>(Arrays.asList(values));

        // ArrayAdapter
        ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, vals);
        setListAdapter(ad);

        lv = getListView();
        // Quelle: https://github.com/romannurik/android-swipetodismiss
        // Create a ListView-specific touch listener. ListViews are given special treatment because
        // by default they handle touches for their list items... i.e. they're in charge of drawing
        // the pressed state (the list selector), handling list item clicks, etc.
        SwipeDismissListViewTouchListener touchListener =
                new SwipeDismissListViewTouchListener(
                        lv,
                        new SwipeDismissListViewTouchListener.DismissCallbacks() {
                            @Override
                            public boolean canDismiss(int position) {
                                return true;
                            }

                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
                                    ad.remove(ad.getItem(position));
                                }
                                ad.notifyDataSetChanged();
                            }
                        });
        lv.setOnTouchListener(touchListener);
        // Setting this scroll listener is required to ensure that during ListView scrolling,
        // we don't look for swipes.
        lv.setOnScrollListener(touchListener.makeScrollListener());

    }

    public void buttonOnClick(View v) {
        // do something when the button is clicked
        Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(),MainActivity6.class));
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        Toast.makeText(this,
                "Clicked " + getListAdapter().getItem(position).toString(),
                Toast.LENGTH_SHORT).show();
    }

}
