package com.cookandroid.teamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PianoChordSheetMain extends Activity {
                    @Override
                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setTitle("기타 코드표 선택");
                        setContentView(R.layout.piano_chordsheet);


                        Button cbtn = (Button) findViewById(R.id.Cbtn);
                        cbtn.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                Intent intent = new Intent(getApplicationContext(), PianoCcode.class);
                                startActivity(intent);
                            }
                        });

                        Button dbtn = (Button) findViewById(R.id.Dbtn);
                        dbtn.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                Intent intent = new Intent(getApplicationContext(), PianoDcode.class);
                                startActivity(intent);
                            }
                        });

                        Button ebtn = (Button) findViewById(R.id.Ebtn);
                        ebtn.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                Intent intent = new Intent(getApplicationContext(), PianoEcode.class);
                                startActivity(intent);
                            }
                        });

                        Button fbtn = (Button) findViewById(R.id.Fbtn);
                        fbtn.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                Intent intent = new Intent(getApplicationContext(), PianoFcode.class);
                                startActivity(intent);
                            }
                        });

                        Button gbtn = (Button) findViewById(R.id.Gbtn);
                        gbtn.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                Intent intent = new Intent(getApplicationContext(), PianoGcode.class);
                                startActivity(intent);
                            }
                        });

                        Button abtn = (Button) findViewById(R.id.Abtn);
                        abtn.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                Intent intent = new Intent(getApplicationContext(), PianoAcode.class);
                startActivity(intent);
            }
        });

        Button btn = (Button) findViewById(R.id.Bbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PianoBcode.class);
                startActivity(intent);
            }
        });

    }
}
