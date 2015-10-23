package com.example.pedroresende.curriculum.persistence.sqlite.services;

import android.database.sqlite.SQLiteDatabase;

import com.example.pedroresende.curriculum.persistence.sqlite.dbhelper.CurriculumDbHelper;

import java.util.List;

/**
 * Created by pedroresende on 10/23/15.
 */
public abstract class GenericService<T> {

    protected CurriculumDbHelper dbHelper;
    protected SQLiteDatabase database;
    public GenericService(CurriculumDbHelper helper){
        dbHelper = helper;
        database = dbHelper.getWritableDatabase();
    }

    public abstract long insert(T entity);
    public abstract List<T> getAll();
    public abstract T get(long id);
    public abstract void delete(long id);

}
