package com.cookandroid.teamproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class DatabaseManager {

    private static final String DATABASE_NAME = "sound_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "sound_table";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_SOUND_RESOURCE_ID = "sound_resource_id";
    private static final String COLUMN_WAV_FILE_PATH = "wav_file_path";
    private static final String COLUMN_TITLE = "title";

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public DatabaseManager(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // 새로운 메서드 추가
    public void insertSoundResources(List<Integer> soundResourceIds, List<String> wavFilePaths, String title) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // 테이블에 저장된 데이터 삭제
        db.delete(TABLE_NAME, null, null);

        // 새로운 데이터 추가
        for (int i = 0; i < soundResourceIds.size(); i++) {
            ContentValues values = new ContentValues(); // 새로운 인스턴스 생성
            values.put(COLUMN_SOUND_RESOURCE_ID, soundResourceIds.get(i));
            values.put(COLUMN_WAV_FILE_PATH, wavFilePaths.get(i));
            values.put(COLUMN_TITLE, title);
            db.insert(TABLE_NAME, null, values);
        }

        db.close();
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_SOUND_RESOURCE_ID + " INTEGER, " +
                    COLUMN_WAV_FILE_PATH + " TEXT, " +
                    COLUMN_TITLE + " TEXT)";
            db.execSQL(createTableQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}
