package com.cookandroid.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.app.AlertDialog;

import android.content.DialogInterface;

import android.media.MediaPlayer;

import android.text.InputType;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;

import com.github.adrielcafe.androidaudioconverter.callback.ILoadCallback;
import com.github.adrielcafe.androidaudioconverter.callback.IConvertCallback;
import com.github.adrielcafe.androidaudioconverter.AndroidAudioConverter;


public class SongActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private GridLayout track1;
    private GridLayout track2;
    private GridLayout track3;
    private ProgressBar progressBar;
    private Handler handler;
    private int progressStatus = 0;
    private List<Integer> soundResourceIds;
    private List<File> tempWavFiles;
    private DatabaseManager databaseManager;

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

        databaseManager = new DatabaseManager(this);
        databaseManager.open(); // 데이터베이스 열기

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

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveButtonClicked();
            }
        });

        soundResourceIds = new ArrayList<>();
        tempWavFiles = new ArrayList<>();


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
                int soundResourceId = R.raw.pianosound_c;
                copyAndPasteButton((Button) v, track1, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button2_group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.pianosound_d;
                copyAndPasteButton((Button) v, track1, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button3_group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.pianosound_e;
                copyAndPasteButton((Button) v, track1, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button4_group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.pianosound_f;
                copyAndPasteButton((Button) v, track1, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button5_group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.pianosound_g;
                copyAndPasteButton((Button) v, track1, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button6_group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.pianosound_a;
                copyAndPasteButton((Button) v, track1, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button7_group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.pianosound_b;
                copyAndPasteButton((Button) v, track1, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });

        button1_group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.guitarsound_c;
                copyAndPasteButton((Button) v, track2, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button2_group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.guitarsound_d;
                copyAndPasteButton((Button) v, track2, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button3_group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.guitarsound_em;
                copyAndPasteButton((Button) v, track2, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button4_group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.guitarsound_f;
                copyAndPasteButton((Button) v, track2, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button5_group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.guitarsound_g;
                copyAndPasteButton((Button) v, track2, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button6_group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.guitarsound_am;
                copyAndPasteButton((Button) v, track2, soundResourceId);
                saveSoundInfoToDatabase();
            }

        });
        button7_group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.guitarsound_b;
                copyAndPasteButton((Button) v, track2, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button1_group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.socalcrush;
                copyAndPasteButton((Button) v, track3, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button2_group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.socalhat;
                copyAndPasteButton((Button) v, track3, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button3_group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.socalhitom;
                copyAndPasteButton((Button) v, track3, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button4_group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.socalkick;
                copyAndPasteButton((Button) v, track3, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button5_group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.socallowtom;
                copyAndPasteButton((Button) v, track3, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button6_group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.socalmidtom;
                copyAndPasteButton((Button) v, track3, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button7_group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.socalride;
                copyAndPasteButton((Button) v, track3, soundResourceId);
                saveSoundInfoToDatabase();
            }
        });
        button8_group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soundResourceId = R.raw.socalsnare;
                copyAndPasteButton((Button) v, track3, soundResourceId);
                saveSoundInfoToDatabase();
            }
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

    private void saveButtonClicked() {
        saveSoundInfoToDatabase();
        copyMergeAndConvertToMP3();
    }

    private String mp3FileName;

    private void saveSoundInfoToDatabase() {
        // 가상의 파일 정보를 리스트에 저장
        String wavFilePath = ""; // 실제 파일 경로를 설정
        tempWavFiles.add(new File(wavFilePath));

        // 정보를 리스트에 저장
        soundResourceIds.addAll(getSoundResourceIds(tempWavFiles));

        // 데이터베이스에 저장
        databaseManager.insertSoundResources(soundResourceIds, getWavFilePaths(tempWavFiles), mp3FileName);

        Toast.makeText(this, "Sound saved to database", Toast.LENGTH_SHORT).show();
    }

    // tempWavFiles에서 soundResourceId를 얻어오는 메서드
    private List<Integer> getSoundResourceIds(List<File> tempWavFiles) {
        List<Integer> soundResourceIds = new ArrayList<>();
        // 각 파일에 대한 soundResourceId를 얻어와서 리스트에 추가
        for (File tempWavFile : tempWavFiles) {
            int soundResourceId = getSoundResourceId(tempWavFile);
            soundResourceIds.add(soundResourceId);
        }
        return soundResourceIds;
    }

    // 각각의 tempWavFile에 대한 가상의 soundResourceId를 얻어오는 메서드
    private int getSoundResourceId(File tempWavFile) {
        // 파일 이름에서 확장자를 제외한 부분을 추출
        String fileNameWithoutExtension = tempWavFile.getName().replaceFirst("[.][^.]+$", "");

        // 파일 이름을 해당 리소스 ID로 매핑하기 위해 switch 문을 사용
        switch (fileNameWithoutExtension) {
            case "guitarsound_am":
                return R.raw.guitarsound_am;
            case "guitarsound_b":
                return R.raw.guitarsound_b;
            case "guitarsound_c":
                return R.raw.guitarsound_c;
            case "guitarsound_d":
                return R.raw.guitarsound_d;
            case "guitarsound_em":
                return R.raw.guitarsound_em;
            case "guitarsound_f":
                return R.raw.guitarsound_f;
            case "guitarsound_g":
                return R.raw.guitarsound_g;

            case "pianosound_a":
                return R.raw.pianosound_a;
            case "pianosound_ab":
                return R.raw.pianosound_ab;
            case "pianosound_b":
                return R.raw.pianosound_b;
            case "pianosound_bb":
                return R.raw.pianosound_bb;
            case "pianosound_c":
                return R.raw.pianosound_c;
            case "pianosound_d":
                return R.raw.pianosound_d;
            case "pianosound_db":
                return R.raw.pianosound_db;
            case "pianosound_em":
                return R.raw.pianosound_e;
            case "pianosound_eb":
                return R.raw.pianosound_eb;
            case "pianosound_f":
                return R.raw.pianosound_f;
            case "pianosound_g":
                return R.raw.pianosound_g;
            case "pianosound_gb":
                return R.raw.pianosound_gb;

            case "socalcrush":
                return R.raw.socalcrush;
            case "socalhat":
                return R.raw.socalhat;
            case "socalhitom":
                return R.raw.socalhitom;
            case "socalkick":
                return R.raw.socalkick;
            case "socallowtom":
                return R.raw.socallowtom;
            case "socalmidtom":
                return R.raw.socalmidtom;
            case "socalride":
                return R.raw.socalride;
            case "socalsnare":
                return R.raw.socalsnare;

            default:
                return 0; // 파일 이름이 어떤 패턴과도 일치하지 않으면 기본값 반환
        }
    }


    // tempWavFiles에서 wav 파일 경로를 얻어오는 메서드
    private List<String> getWavFilePaths(List<File> tempWavFiles) {
        List<String> wavFilePaths = new ArrayList<>();
        // 각 파일에 대한 경로를 얻어와서 리스트에 추가
        for (File tempWavFile : tempWavFiles) {
            wavFilePaths.add(tempWavFile.getAbsolutePath());
        }
        return wavFilePaths;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        databaseManager.close(); // 데이터베이스 닫기
    }

    private void copyMergeAndConvertToMP3() {
        // 다이얼로그를 통해 사용자로부터 MP3 파일의 이름을 입력 받습니다.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter MP3 File Name");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mp3FileName = input.getText().toString();

                List<String> copiedWavFilePaths = new ArrayList<>();

                // WAV 파일을 배열에서 순서대로 복사
                for (int i = 0; i < soundResourceIds.size(); i++) {
                    String originalWavFilePath = tempWavFiles.get(i).getAbsolutePath();
                    String copiedWavFilePath = getFilesDir().getPath() + "/" + mp3FileName + "_copied_" + i + ".wav";
                    copyFile(originalWavFilePath, copiedWavFilePath);
                    copiedWavFilePaths.add(copiedWavFilePath);
                }

                // 복사된 WAV 파일들을 순서대로 병합
                String mergedWavFilePath = getFilesDir().getPath() + "/" + mp3FileName + "_merged.wav";
                mergeWavFiles(copiedWavFilePaths, mergedWavFilePath);

                // WAV 파일을 MP3로 변환
                String mp3FilePath = getFilesDir().getPath() + "/" + mp3FileName + ".mp3";
                convertWavToMP3(mergedWavFilePath, mp3FilePath);

                // 변환된 MP3 파일의 이름을 사용자에게 알립니다.
                Toast.makeText(SongActivity.this, "MP3 file saved as: " + mp3FileName + ".mp3", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }


    // copyFile 메서드: 파일을 복사하는 메서드
    private void copyFile(String sourcePath, String destinationPath) {
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destinationPath)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                     fos.write(buffer, 0, length);
                }
            } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mergeWavFiles(List<String> wavFilePaths, String mergedFilePath) {
        try {
            FileOutputStream fos = new FileOutputStream(mergedFilePath);

            for (File wavFile : tempWavFiles) {
                FileInputStream fis = new FileInputStream(wavFile);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }

                fis.close();
            }

            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void convertWavToMP3(final String wavFilePath, String mp3FileName) {
        AndroidAudioConverter.load(this, new ILoadCallback() {
            @Override
            public void onSuccess() {
                // WAV 파일을 MP3로 변환
                AndroidAudioConverter.with(SongActivity.this)
                        .setFile(new File(wavFilePath))
                        .setFormat(AndroidAudioConverter.AudioFormat.MP3)
                        .setCallback(new IConvertCallback() {
                            @Override
                            public void onSuccess(File convertedFile) {
                                // 변환 성공 시 실행되는 코드
                                Toast.makeText(SongActivity.this, "Conversion success", Toast.LENGTH_SHORT).show();
                                // 여기에서 convertedFile은 MP3 파일입니다. 원하는 대로 활용하세요.
                            }

                            @Override
                            public void onFailure(Exception error) {
                                // 변환 실패 시 실행되는 코드
                                Toast.makeText(SongActivity.this, "Conversion failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .convert();
            }

            @Override
            public void onFailure(Exception error) {
                // 라이브러리 로딩 실패 시 실행되는 코드
                Toast.makeText(SongActivity.this, "Library load failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    Button webButton = findViewById(R.id.webButton);
        webButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SongActivity.this, WebActivity.class);
            startActivity(intent);
        }
    });
}

// 나머지 버튼과 그룹에 대한 설정 메서드 추가

