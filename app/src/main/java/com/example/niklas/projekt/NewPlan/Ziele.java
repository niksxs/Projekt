package com.example.niklas.projekt.NewPlan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.niklas.projekt.MainActivity7;
import com.example.niklas.projekt.R;

public class Ziele extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ziele);

        // Dropdown Menü
        String [] items = new String[]{"", "Muskelmasse aufbauen", "Gewicht reduzieren", "Ausdauer aufbauen", "Rücken stärken"};
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));

        // Eigenes Ziel definieren
        final TextView owntarget = (TextView) findViewById(R.id.textView3);

        // Button
        final Button weiter = (Button) findViewById(R.id.zieleWeiter);
        weiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String read;
                // Beide Felder leer = Skip
                if(owntarget.getText().toString().equals("") && spinner.getSelectedItem().toString().equals(""))
                {
                    read = "";
                    Toast.makeText(Ziele.this, "Skipped", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity7.class));
                }
                // Eines der beiden Felder leer
                else if(spinner.getSelectedItem().toString().equals("") && !"".equals(owntarget.getText().toString()))
                {
                    read = owntarget.getText().toString();
                    Toast.makeText(Ziele.this, read, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity7.class));
                }
                // 2. Fall bzgl. 1mal leeres Feld
                else if(owntarget.getText().toString().equals("") && !"".equals(spinner.getSelectedItem().toString()))
                {
                    read = spinner.getSelectedItem().toString();
                    Toast.makeText(Ziele.this, read, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity7.class));
                }
                else if(!"".equals(owntarget.getText().toString()) && !"".equals(spinner.getSelectedItem().toString()))
                {
                    read = "";
                    Toast.makeText(Ziele.this, "Bitte entscheiden Sie sich für eines der beiden Ziele", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

}
