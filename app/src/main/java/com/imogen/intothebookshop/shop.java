package com.imogen.intothebookshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.ImageView;

public class shop extends AppCompatActivity {

    ImageView door;
    ImageView bookshelves;
    ImageView display;
    ImageView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        door = findViewById(R.id.door);
        bookshelves = findViewById(R.id.bookshelves);
        display = findViewById(R.id.display);
        counter = findViewById(R.id.counter);

        door.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoor();
            }
        });
        bookshelves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBookshelves();
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDisplay();
            }
        });
        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCounter();
            }
        });
    }

    public void openDoor(){
        Intent intent = new Intent(this, door.class);
        startActivity(intent);
    }
    public void openBookshelves(){
        Intent intent = new Intent(this, bookshelves.class);
        startActivity(intent);
    }
    public void openDisplay(){
        Intent intent = new Intent(this, display.class);
        startActivity(intent);
    }
    public void openCounter(){
        Intent intent = new Intent(this, counter.class);
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