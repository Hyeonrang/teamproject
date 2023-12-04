package com.cookandroid.teamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuitarChordSheetMain extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("기타 코드표 선택");
        setContentView(R.layout.guitar_chordsheet);


        Button cbtn = (Button) findViewById(R.id.guitarCbtn);
        cbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GuitarCcode.class);
                startActivity(intent);
            }
        });

        Button gdbtn = (Button) findViewById(R.id.guitarDbtn);
        gdbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GuitarDcode.class);
                startActivity(intent);
            }
        });

        Button gembtn = (Button) findViewById(R.id.guitarEmbtn);
        gembtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GuitarEmcode.class);
                startActivity(intent);
            }
        });

        Button gfbtn = (Button) findViewById(R.id.guitarFbtn);
        gfbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GuitarFcode.class);
                startActivity(intent);
            }
        });

        Button ggbtn = (Button) findViewById(R.id.guitarGbtn);
        ggbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GuitarGcode.class);
                startActivity(intent);
            }
        });

        Button gambtn = (Button) findViewById(R.id.guitarAmbtn);
        gambtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GuitarAmcode.class);
                startActivity(intent);
            }
        });

        Button gbbtn = (Button) findViewById(R.id.guitarBbtn);
        gbbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GuitarBcode.class);
                startActivity(intent);
            }
        });

    }
}
