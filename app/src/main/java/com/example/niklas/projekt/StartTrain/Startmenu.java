package com.example.niklas.projekt.StartTrain;

import android.app.Activity;
import android.os.Bundle;

import com.example.niklas.projekt.R;

/* StartTraining Klasse, benötigt:
 * Anzeige der bereits hinterlegten Trainingspläne, mit Markierung des aktuellen
 * Möglichkeit zum hinzufügen eines neuen Plans
 */
public class Startmenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startmenu);
    }

}
