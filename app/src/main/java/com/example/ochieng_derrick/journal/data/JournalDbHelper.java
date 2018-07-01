package com.example.ochieng_derrick.journal.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ochieng_derrick.journal.data.JournalContract.JournalEntry;

import static com.example.ochieng_derrick.journal.data.JournalContract.JournalEntry.TABLE_NAME;

public class JournalDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "uJournal.db";
    public static final String SQL_DELETE_ENTRIES = "DROP TABLE TABLE_NAME";

    public JournalDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
       String SQL_CREATE_JOURNAL_TABLE = "CREATE TABLE " + JournalEntry.TABLE_NAME + "("
                   + JournalEntry.COLUMN_JOURNAL_ID + "TEXT PRIMARY KEY,"
                    + JournalEntry.COLUMN_JOURNAL_TITLE + "TEXT NOT NULL,"
                     +JournalEntry.COLUMN_JOURNAL_DETAILS + "TEXT NOT NULL);";
        db.execSQL(SQL_CREATE_JOURNAL_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }
}
