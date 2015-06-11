package com.example.niklas.projekt.ErrorMsg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.niklas.projekt.R;

public class ErrorMessage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_message);

        TextView Uebung = (TextView) findViewById(R.id.Uebung);
        Intent i = getIntent();
        // Receiving the Data
        String uebung = i.getStringExtra("Uebung");
        Uebung.setText(uebung);

        // Dropdown Menü
        String [] items = new String[]{"", "Fehlender Stift", "Seil abgenutzt", "Lederauflage gerissen"};
        final Spinner spinner = (Spinner) findViewById(R.id.spinnerFehler);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));

        // Eigene Fehlermeldung definieren
        final TextView owntarget = (TextView) findViewById(R.id.editFehler);

        // Button
        final Intent in = new Intent(getApplicationContext(), Bestaetigung.class);
        final Button senden = (Button) findViewById(R.id.Senden);
        senden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Button pressed: ", "123");
                String read;
                if((spinner.getSelectedItem().toString().equals("") && owntarget.getText().toString().equals("")))
                {
                    read = "";
                    Log.v("3. Fall: ", read);
                    Toast.makeText(ErrorMessage.this, "Bitte definieren Sie den Fehler!", Toast.LENGTH_LONG).show();
                }
                else if(!"".equals(spinner.getSelectedItem().toString()) && !"".equals(owntarget.getText().toString()))
                {
                    read = "";
                    Log.v("4. Fall: ", read);
                    Toast.makeText(ErrorMessage.this, "Bitte nur eine Fehlermeldung auswählen!", Toast.LENGTH_LONG).show();
                }
                else if(!"".equals(spinner.getSelectedItem().toString()))
                {
                    read = spinner.getSelectedItem().toString();
                    Log.v("1. Fall: ", read);
                    in.putExtra("Fehler", read);
                    Toast.makeText(ErrorMessage.this, read, Toast.LENGTH_LONG).show();
                    startActivity(in);
                }
                else if(!"".equals(owntarget.getText().toString()))
                {
                    read = owntarget.getText().toString();
                    Log.v("2. Fall: ", read);
                    in.putExtra("Fehler", read);
                    Toast.makeText(ErrorMessage.this, read, Toast.LENGTH_LONG).show();
                    startActivity(in);
                }
            }
        });

    }

}
