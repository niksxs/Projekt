package com.example.niklas.projekt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class slider extends Activity {

    private SeekBar ssat, swdh;

    private TextView tsat, twdh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        ssat = (SeekBar) findViewById(R.id.ssat);
        ssat.setMax((10 - 1) / 1);
        //ssat.setProgress(1);
        tsat = (TextView) findViewById(R.id.tsat);

        swdh = (SeekBar) findViewById(R.id.swdh);
        swdh.setMax((30 - 1) / 1);
        //swdh.setProgress(1);
        twdh = (TextView) findViewById(R.id.twdh);

        ssat.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = 1 + (progress * 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tsat.setText("Anzahl Sätze: " + progressChanged);
                Toast.makeText(slider.this,"seek bar progress:"+progressChanged,
                        Toast.LENGTH_SHORT).show();
            }
        });

        swdh.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = 1 + (progress * 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                twdh.setText("Anzahl Sätze: " + progressChanged);
                Toast.makeText(slider.this,"seek bar progress:"+progressChanged,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ButtonClicked(View v)
    {
        startActivity(new Intent(getApplicationContext(), MainActivity7.class));
    }


}
