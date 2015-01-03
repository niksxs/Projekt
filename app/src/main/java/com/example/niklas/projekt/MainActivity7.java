package com.example.niklas.projekt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
Klasse zur Eingabe individueller Eingaben wie Name, Gewicht und Größe (Startangaben).
Klasse kann auch vor dem Training aufgerufen werden um die Daten zu aktualisieren
 */
public class MainActivity7 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity7);
    }


    public void buttonOnClick1(View v) {
        // next activity
        Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(),MainActivity8.class));
        Toast.makeText(this,
                "Daten gespeichert",
                Toast.LENGTH_SHORT).show();
    }

    public void buttonOnClick2(View v) {
        // next activity
        Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(),MainActivity8.class));
    }
}
