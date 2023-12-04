package com.cookandroid.teamproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
    public void pianoCh(View view) {
     Intent intent = new Intent(this, PianoMain.class);
     startActivity(intent);
    }

    public void guitarCh(View view) {
        Intent intent = new Intent(this, GuitarMain.class);
        startActivity(intent);
    }
    public void drumCh(View view) {
        Intent intent = new Intent(this, DrumMain.class);
        startActivity(intent);
    }

    public void songCh(View view) {
        Intent intent = new Intent(this, SongActivity.class);
        startActivity(intent);
    }

}