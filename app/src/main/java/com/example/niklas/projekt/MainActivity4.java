package com.example.niklas.projekt;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity4 extends Activity {

    ArrayList<String> vals = new ArrayList<String>();
    ArrayAdapter<String> ad;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4);

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
        for(int i = 0; i < values.length;i++)
        {
            vals.add(values[i]);
        }
        lv = (ListView)findViewById(R.id.listView3);

        ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, vals);
        lv.setAdapter(ad);
        lv.setTextFilterEnabled(true);

        // ListView Item Click Listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // Log.i("Selected Item in list", view.toString());
                String item = (String)lv.getAdapter().getItem(position);
                // Log.i("Selected Item in list", item);
                Toast.makeText(MainActivity4.this, " Position: " + position + "   Item: " + item , Toast.LENGTH_LONG).show();

                ad.remove(item);

                ad = new ArrayAdapter<String>(MainActivity4.this, android.R.layout.simple_list_item_1, android.R.id.text1, vals);

                lv.setAdapter(ad);
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity4, menu);
        return true;
    }

}
