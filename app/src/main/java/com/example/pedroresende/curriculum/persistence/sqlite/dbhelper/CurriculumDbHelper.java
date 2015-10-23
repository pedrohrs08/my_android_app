package com.example.pedroresende.curriculum.persistence.sqlite.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pedroresende.curriculum.persistence.sqllite.contract.CurriculumContract.*;

/**
 * Created by pedroresende on 10/23/15.
 */
public class CurriculumDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Curriculum.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_WORK_ENTRIES =
            "CREATE TABLE " + WorkExperienceEntry.TABLE_NAME + " (" +
                    WorkExperienceEntry._ID + " INTEGER PRIMARY KEY," +
                    WorkExperienceEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    WorkExperienceEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    WorkExperienceEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE +
            " )";

    private static final String SQL_CREATE_SCHOOL_ENTRIES =
            "CREATE TABLE " + SchoolInformationEntry.TABLE_NAME + " (" +
                    SchoolInformationEntry._ID + " INTEGER PRIMARY KEY," +
                    SchoolInformationEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    SchoolInformationEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    SchoolInformationEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE +
                    " )";

    private static final String SQL_DELETE_WORK =
            "DROP TABLE IF EXISTS " + WorkExperienceEntry.TABLE_NAME;

    private static final String SQL_DELETE_SCHOOL =
            "DROP TABLE IF EXISTS " + SchoolInformationEntry.TABLE_NAME;

    public CurriculumDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_SCHOOL_ENTRIES);
        db.execSQL(SQL_CREATE_WORK_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == 1){
            onCreate(db);
        }
    }

}
