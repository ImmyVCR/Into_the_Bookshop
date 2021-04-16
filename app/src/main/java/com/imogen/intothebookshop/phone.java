package com.imogen.intothebookshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class phone extends AppCompatActivity {

    TextView windowOption;
    TextView streetOption;
    TextView shopOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        windowOption = findViewById(R.id.optionWindow_phone);
        streetOption = findViewById(R.id.optionStreet_phone);
        shopOption = findViewById(R.id.optionShop_phone);

        if (Constant.windowSelected && Constant.phoneSelected && Constant.streetSelected){
            if(shopOption.getVisibility() == View.INVISIBLE) {
                shopOption.setVisibility(View.VISIBLE);
            }
        }

        windowOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWindow();
            }
        });

        streetOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStreet();
            }
        });

        shopOption.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { openShop();}
        });
    }

    public void openWindow(){
        Intent intent = new Intent(this, window.class);
        Constant.windowSelected = true;
        startActivity(intent);
    }

    public void openStreet(){
        Intent intent = new Intent(this, street.class);
       Constant.streetSelected = true;
        startActivity(intent);
    }

    public void openShop(){
        Intent intent = new Intent(this, shop.class);
        startActivity(intent);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}