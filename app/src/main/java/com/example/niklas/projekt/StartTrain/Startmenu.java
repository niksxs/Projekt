package com.example.niklas.projekt.StartTrain;

import android.app.Activity;
import android.os.Bundle;

import com.example.niklas.projekt.R;

/* StartTraining Klasse, benötigt 2 Menüpunkte.
 * 1. QR-Codes scannen
 * 2. Trainingsplan auswählen
 */
public class Startmenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startmenu);
    }

}
