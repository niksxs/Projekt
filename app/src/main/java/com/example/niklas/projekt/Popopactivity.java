package com.example.niklas.projekt;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;


public class Popopactivity extends  Activity {
        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_activity7);

            final Button btnOpenPopup = (Button)findViewById(R.id.button3);
            btnOpenPopup.setOnClickListener(new Button.OnClickListener(){

                @Override
                public void onClick(View arg0) {
                    LayoutInflater layoutInflater
                            = (LayoutInflater)getBaseContext()
                            .getSystemService(LAYOUT_INFLATER_SERVICE);
                    View popupView = layoutInflater.inflate(R.layout.popup, null);
                    final PopupWindow popupWindow = new PopupWindow(
                            popupView,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);

                    Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
                    btnDismiss.setOnClickListener(new Button.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            popupWindow.dismiss();
                            //startActivity(new Intent(getApplicationContext(), MainActivity6.class));
                        }});

                    popupWindow.showAsDropDown(btnOpenPopup, 50, -30);

                }});
        }
    }
