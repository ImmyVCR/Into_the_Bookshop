package com.imogen.intothebookshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class counter extends AppCompatActivity {

    TextView backToShop;
    TextView torchText;
    ImageView torchImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        backToShop = findViewById(R.id.backToShop_counter);
        torchText = findViewById(R.id.torchText);
        torchImage = findViewById(R.id.torch_Counter);

        if (Constant.torchCollected == true){
            torchImage.setVisibility(View.INVISIBLE);
            torchText.setVisibility(View.VISIBLE);
        }

        backToShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShop();
            }
        });

       torchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                torchImage.setVisibility(View.INVISIBLE);
                torchText.setVisibility(View.VISIBLE);
                Constant.torchCollected = true;
            }
        });
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