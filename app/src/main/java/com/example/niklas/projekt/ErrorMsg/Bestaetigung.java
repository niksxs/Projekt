package com.example.niklas.projekt.ErrorMsg;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.niklas.projekt.R;

public class Bestaetigung extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestaetigung);

        final TextView sent = (TextView) findViewById(R.id.fehler);
        int random = (int) ((Math.random()*30)+1);
        Bundle fehler = getIntent().getExtras();
        String text2 = fehler.getString("fehler");
        sent.setText("Ihre Fehlermeldung ist bei uns eingangen. \r\n" +"Fehlermeldung: " + text2 + "\r\n" + "Status-ID: #" +  random);
    }

}
