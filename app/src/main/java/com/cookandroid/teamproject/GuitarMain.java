package com.cookandroid.teamproject;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class GuitarMain extends AppCompatActivity implements View.OnClickListener {

    private SoundPool soundPool;
    private int soundId1, soundId2, soundId3, soundId4, soundId5, soundId6, soundId7, soundId8, soundId9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guitar_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // SoundPool 초기화
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setMaxStreams(9)
                .setAudioAttributes(audioAttributes)
                .build();


        soundId1 = soundPool.load(this, R.raw.guitarsound_c, 1);
        soundId2 = soundPool.load(this, R.raw.guitarsound_d, 1);
        soundId3 = soundPool.load(this, R.raw.guitarsound_em, 1);
        soundId4 = soundPool.load(this, R.raw.guitarsound_f, 1);
        soundId5 = soundPool.load(this, R.raw.guitarsound_g, 1);
        soundId6 = soundPool.load(this, R.raw.guitarsound_am, 1);
        soundId7 = soundPool.load(this, R.raw.guitarsound_b, 1);


        // 각 버튼에 클릭 리스너 설정
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);

    }

    public void guitarchordsheetCh(View view) {
        Intent intent = new Intent(this, GuitarChordSheetMain.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        // 버튼을 눌렀을 때 해당하는 소리 재생
        switch (view.getId()) {
            case R.id.button1:
                soundPool.play(soundId1, 1.0f, 1.0f, 0, 0, 1.0f);
                break;
            case R.id.button2:
                soundPool.play(soundId2, 1.0f, 1.0f, 0, 0, 1.0f);
                break;
            case R.id.button3:
                soundPool.play(soundId3, 1.0f, 1.0f, 0, 0, 1.0f);
                break;
            case R.id.button4:
                soundPool.play(soundId4, 1.0f, 1.0f, 0, 0, 1.0f);
                break;
            case R.id.button5:
                soundPool.play(soundId5, 1.0f, 1.0f, 0, 0, 1.0f);
                break;
            case R.id.button6:
                soundPool.play(soundId6, 1.0f, 1.0f, 0, 0, 1.0f);
                break;
            case R.id.button7:
                soundPool.play(soundId7, 1.0f, 1.0f, 0, 0, 1.0f);
                break;

        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}
