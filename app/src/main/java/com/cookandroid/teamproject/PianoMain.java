package com.cookandroid.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class PianoMain extends AppCompatActivity implements View.OnClickListener {

    private SoundPool soundPool;
    private int soundIdC, soundIdDb, soundIdD, soundIdEb, soundIdE, soundIdF, soundIdGb, soundIdG, soundIdAb, soundIdA, soundIdBb, soundIdB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.piano_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // SoundPool 초기화
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setMaxStreams(30)
                .setAudioAttributes(audioAttributes)
                .build();


        soundIdC = soundPool.load(this, R.raw.pianosound_c, 1);

        soundIdDb = soundPool.load(this, R.raw.pianosound_db, 1);
        soundIdD = soundPool.load(this, R.raw.pianosound_d, 1);
        soundIdEb = soundPool.load(this, R.raw.pianosound_eb, 1);
        soundIdE = soundPool.load(this, R.raw.pianosound_e, 1);
        soundIdF = soundPool.load(this, R.raw.pianosound_f, 1);
        soundIdGb = soundPool.load(this, R.raw.pianosound_gb, 1);
        soundIdG = soundPool.load(this, R.raw.pianosound_g, 1);
        soundIdAb = soundPool.load(this, R.raw.pianosound_ab, 1);
        soundIdA = soundPool.load(this, R.raw.pianosound_a, 1);
        soundIdBb = soundPool.load(this, R.raw.pianosound_bb, 1);
        soundIdB = soundPool.load(this, R.raw.pianosound_b, 1);


        // 버튼에 클릭 리스너 설정
        Button buttonC = findViewById(R.id.button_c);
        Button buttonCC = findViewById(R.id.button_cc);
        Button buttonDb = findViewById(R.id.button_db);
        Button buttonD = findViewById(R.id.button_d);
        Button buttonDD = findViewById(R.id.button_dd);
        Button buttonEb = findViewById(R.id.button_eb);
        Button buttonE = findViewById(R.id.button_e);
        Button buttonF = findViewById(R.id.button_f);
        Button buttonFF = findViewById(R.id.button_ff);
        Button buttonGb = findViewById(R.id.button_gb);
        Button buttonG = findViewById(R.id.button_g);
        Button buttonGG = findViewById(R.id.button_gg);
        Button buttonAb = findViewById(R.id.button_ab);
        Button buttonA = findViewById(R.id.button_a);
        Button buttonBBB = findViewById(R.id.button_bbb);
        Button buttonBb = findViewById(R.id.button_bb);
        Button buttonB = findViewById(R.id.button_b);




        // 나머지 버튼들을 찾아서 클릭 리스너 설정

        buttonC.setOnClickListener(this);
        buttonCC.setOnClickListener(this);
        buttonDb.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonDD.setOnClickListener(this);
        buttonEb.setOnClickListener(this);
        buttonE.setOnClickListener(this);
        buttonF.setOnClickListener(this);
        buttonFF.setOnClickListener(this);
        buttonGb.setOnClickListener(this);
        buttonG.setOnClickListener(this);
        buttonGG.setOnClickListener(this);
        buttonAb.setOnClickListener(this);
        buttonA.setOnClickListener(this);
        buttonBBB.setOnClickListener(this);
        buttonBb.setOnClickListener(this);
        buttonB.setOnClickListener(this);


        // 나머지 버튼들에 대해서도 클릭 리스너 설정
    }

    public void pianochordsheetCh(View view) {
        Intent intent = new Intent(this, PianoChordSheetMain.class);
        startActivity(intent);
    }
        @Override
    public void onClick(View view) {
        // 버튼을 눌렀을 때 해당하는 소리 재생
        switch (view.getId()) {
            case R.id.button_c:
                soundPool.play(soundIdC, 1.0f, 1.0f, 0, 0, 0.0f);
                break;
            case R.id.button_db:
                soundPool.play(soundIdDb, 1.0f, 1.0f, 0, 0, 0.0f);
                break;
            case R.id.button_d:
                soundPool.play(soundIdD, 1.0f, 1.0f, 0, 0, 0.0f);
                break;
            case R.id.button_eb:
                soundPool.play(soundIdEb, 1.0f, 1.0f, 0, 0, 0.0f);
                break;
            case R.id.button_e:
                soundPool.play(soundIdE, 1.0f, 1.0f, 0, 0, 0.0f);
                break;
            case R.id.button_f:
                soundPool.play(soundIdF, 1.0f, 1.0f, 0, 0, 0.0f);
                break;
            case R.id.button_gb:
                soundPool.play(soundIdGb, 1.0f, 1.0f, 0, 0, 0.0f);
                break;
            case R.id.button_g:
                soundPool.play(soundIdG, 1.0f, 1.0f, 0, 0, 0.0f);
                break;
            case R.id.button_ab:
                soundPool.play(soundIdAb, 1.0f, 1.0f, 0, 0, 0.0f);
                break;
            case R.id.button_a:
                soundPool.play(soundIdA, 1.0f, 1.0f, 0, 0, 0.0f);
                break;
            case R.id.button_bb:
                soundPool.play(soundIdBb, 1.0f, 1.0f, 0, 0, 0.0f);
                break;
            case R.id.button_b:
                soundPool.play(soundIdB, 1.0f, 1.0f, 0, 0, 0.0f);
                break;

            // 나머지 버튼들에 대한 재생 코드 추가
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}