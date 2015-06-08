package com.example.niklas.projekt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.niklas.projekt.ErrorMsg.ScanQRCode;
import com.example.niklas.projekt.NewPlan.Ziele;

/*
Layoutklasse
Je nach gedrückten Button gibts eine Weiterleitung zur entsprechenden Kategorie
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button startTrain = (Button) findViewById(R.id.StartTrain);
        startTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity6.class));
            }
        });

        final Button neuerPlan = (Button) findViewById(R.id.NewPlan);
        neuerPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Ziele.class));
            }
        });

        final Button error = (Button) findViewById(R.id.ErrorMsg);
        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ScanQRCode.class));
            }
        });
    }

}
