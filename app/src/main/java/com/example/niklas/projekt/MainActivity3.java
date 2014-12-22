package com.example.niklas.projekt;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity3 extends Activity {

    String[] values;
    StringArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);
        values = new String[]{"Aufwärmen",
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
        ListView lv = (ListView)findViewById(R.id.listView2);
        ad = new StringArrayAdapter(values, this);
        lv.setAdapter(ad);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity3, menu);
        return true;
    }

}