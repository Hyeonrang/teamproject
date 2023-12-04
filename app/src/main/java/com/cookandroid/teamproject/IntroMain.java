package com.cookandroid.teamproject;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class IntroMain extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        TextView itv1 = (TextView)findViewById(R.id.introText1);
        TextView itv2 = (TextView)findViewById(R.id.introText2);
        TextView itv3 = (TextView)findViewById(R.id.introText3);
        TextView itv4 = (TextView)findViewById(R.id.introText4);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
