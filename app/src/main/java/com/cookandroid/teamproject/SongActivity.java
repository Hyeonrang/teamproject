package com.cookandroid.teamproject;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.widget.GridLayout;
import android.widget.TabHost;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;


public class SongActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private GridLayout track1;
    private GridLayout track2;
    private GridLayout track3;

    private ProgressBar progressBar;
    private Handler handler;
    private int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_main);



        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        final LinearLayout rightContainer = findViewById(R.id.rightContainer);
        track1 = findViewById(R.id.track1);
        track2 = findViewById(R.id.track2);
        track3 = findViewById(R.id.track3);
        progressBar = findViewById(R.id.progressBar);
        handler = new Handler();

        Button playButton = findViewById(R.id.button1_group4);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.pianosound_c); // 적절한 초기 소리 지정
                progressBar.setVisibility(View.VISIBLE);
                progressStatus = 0;
                progressBar.setProgress(progressStatus);
                startProgressBarAnimation(); // 막대바 애니메이션 시작
            }
        });





        // 버튼 그룹 1
        Button button1_group1 = findViewById(R.id.button1_group1);
        Button button2_group1 = findViewById(R.id.button2_group1);
        Button button3_group1 = findViewById(R.id.button3_group1);
        Button button4_group1 = findViewById(R.id.button4_group1);
        Button button5_group1 = findViewById(R.id.button5_group1);
        Button button6_group1 = findViewById(R.id.button6_group1);
        Button button7_group1 = findViewById(R.id.button7_group1);
        Button button1_group2 = findViewById(R.id.button1_group2);
        Button button2_group2 = findViewById(R.id.button2_group2);
        Button button3_group2 = findViewById(R.id.button3_group2);
        Button button4_group2 = findViewById(R.id.button4_group2);
        Button button5_group2 = findViewById(R.id.button5_group2);
        Button button6_group2 = findViewById(R.id.button6_group2);
        Button button7_group2 = findViewById(R.id.button7_group2);
        Button button1_group3 = findViewById(R.id.button1_group3);
        Button button2_group3 = findViewById(R.id.button2_group3);
        Button button3_group3 = findViewById(R.id.button3_group3);
        Button button4_group3 = findViewById(R.id.button4_group3);
        Button button5_group3 = findViewById(R.id.button5_group3);
        Button button6_group3 = findViewById(R.id.button6_group3);
        Button button7_group3 = findViewById(R.id.button7_group3);
        Button button8_group3 = findViewById(R.id.button8_group3);



        // 오른쪽 영역에 추가할 뷰




        // 각 버튼의 클릭 리스너 설정
        button1_group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                copyAndPasteButton((Button) v, track1, R.raw.pianosound_c);
            }
        });


        button2_group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                copyAndPasteButton((Button) v, track1, R.raw.pianosound_d);
            }
        });
        button3_group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track1, R.raw.pianosound_e); }
        });
        button4_group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track1, R.raw.pianosound_f); }
        });
        button5_group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track1,R.raw.pianosound_g); }
        });
        button6_group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track1,R.raw.pianosound_a); }
        });
        button7_group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track1,R.raw.pianosound_b); }
        });

        button1_group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track2,R.raw.guitarsound_c); }
        });
        button2_group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track2,R.raw.guitarsound_d); }
        });
        button3_group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track2,R.raw.guitarsound_em); }
        });
        button4_group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track2,R.raw.guitarsound_f); }
        });
        button5_group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track2,R.raw.guitarsound_g); }
        });
        button6_group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track2,R.raw.guitarsound_am); }

        });
        button7_group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track2,R.raw.guitarsound_b); }
        });
        button1_group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track3,R.raw.socalcrush); }
        });
        button2_group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track3,R.raw.socalhat); }
        });
        button3_group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track3,R.raw.socalhitom); }
        });
        button4_group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track3,R.raw.socalkick); }
        });
        button5_group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track3,R.raw.socallowtom); }
        });
        button6_group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track3,R.raw.socalmidtom); }
        });
        button7_group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track3,R.raw.socalride); }
        });
        button8_group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { copyAndPasteButton((Button) v, track3,R.raw.socalsnare); }
        });
        // 나머지 버튼 및 그룹에 대한 설정 추가
    }

    private void startProgressBarAnimation() {
        handler.postDelayed(new Runnable() {
            public void run() {
                if (progressStatus < 100) {
                    progressStatus += 1;
                    progressBar.setProgress(progressStatus);
                    handler.postDelayed(this, 50); // 막대 이동 속도 조절
                } else {
                    progressBar.setVisibility(View.INVISIBLE);
                    resetProgressBar(); // 애니메이션 종료 후 초기화
                }
            }
        }, 50);
    }
    private void resetProgressBar() {
        handler.removeCallbacksAndMessages(null); // 애니메이션 중지
        progressStatus = 0;
        progressBar.setProgress(progressStatus);
    }
    private void copyAndPasteButton(Button sourceButton, GridLayout targetGrid, final int soundResourceId) {
        // Create a new button
        Button newButton = new Button(this);
        newButton.setText(sourceButton.getText());

        // Set layout parameters for the new button (adjust as needed)
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = 120; // Adjust width as needed
        params.height = 120; // Adjust height as needed

        // Add the new button to the track GridLayout
        targetGrid.addView(newButton, params);

        // Set the sound resource for the new button
        newButton.setTag(soundResourceId);

        // Set click listener for the new button
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 여기에서 해당 버튼의 소리 리소스 ID를 가져와 소리를 재생
                int audioRes = (int) v.getTag();
                playSound(audioRes);
            }
        });
    }

    private void playSound(int soundResourceId) {
        // MediaPlayer를 사용하여 소리를 재생
        if (mediaPlayer != null) {
            mediaPlayer.release(); // 이전 MediaPlayer 해제
        }
        mediaPlayer = MediaPlayer.create(SongActivity.this, soundResourceId);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release(); // 재생이 끝나면 MediaPlayer 해제
            }
        });
    }


}

// 나머지 버튼과 그룹에 대한 설정 메서드 추가

