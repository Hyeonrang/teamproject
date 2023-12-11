package com.cookandroid.teamproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MAESTRO_APP_DB";
    private static final int DATABASE_VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 테이블 생성 SQL문
        String createTableQuery =
                "CREATE TABLE IF NOT EXISTS music_table (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "sound_resource_id INTEGER," +
                "wav_file_path TEXT," +
                "title VARCHAR(255));";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 데이터베이스 업그레이드 필요 시 수행할 작업 (유지 보수용)
    }
}
