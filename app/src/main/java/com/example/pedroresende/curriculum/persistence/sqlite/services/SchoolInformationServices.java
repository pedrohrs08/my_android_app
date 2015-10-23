package com.example.pedroresende.curriculum.persistence.sqlite.services;

import android.database.Cursor;

import com.example.pedroresende.curriculum.persistence.domain.entities.SchoolInformation;
import com.example.pedroresende.curriculum.persistence.domain.entities.WorkInformation;
import com.example.pedroresende.curriculum.persistence.sqlite.dbhelper.CurriculumDbHelper;
import com.example.pedroresende.curriculum.persistence.sqllite.contract.CurriculumContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedroresende on 10/23/15.
 */
public class SchoolInformationServices extends GenericService<SchoolInformation> {

    private String[] projection = new String[]{
        CurriculumContract.WorkExperienceEntry._ID,
                CurriculumContract.WorkExperienceEntry.COLUMN_NAME_TITLE,
                CurriculumContract.WorkExperienceEntry.COLUMN_NAME_DESCRIPTION
    };;

    public SchoolInformationServices(CurriculumDbHelper dbHelper){
        super(dbHelper);
    }

    @Override
    public long insert(SchoolInformation entity) {
        return database.insert(CurriculumContract.SchoolInformationEntry.TABLE_NAME,null,entity.toContentValues());
    }

    @Override
    public List<SchoolInformation> getAll() {
        Cursor cursor =  database.query(CurriculumContract.SchoolInformationEntry.TABLE_NAME, projection, null, null, null, null, null);
        List<SchoolInformation> workInformations = new ArrayList<SchoolInformation>();
        if(cursor.moveToFirst()) {
            do {
                SchoolInformation schoolInformation = new SchoolInformation();
                schoolInformation.buildFromContentValues(cursor);
                workInformations.add(schoolInformation);
            } while (cursor.moveToNext());
        }
        return workInformations;
    }

    @Override
    public SchoolInformation get(long id) {
        String selection = CurriculumContract.WorkExperienceEntry._ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };
        SchoolInformation schoolInformation = null;
        Cursor cursor =  database.query(CurriculumContract.SchoolInformationEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        if(cursor.moveToFirst()) {
            schoolInformation = new SchoolInformation();
            schoolInformation.buildFromContentValues(cursor);
        }
        return schoolInformation;
    }

    @Override
    public void delete(long id) {
        String selection = CurriculumContract.SchoolInformationEntry._ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };
        database.delete(CurriculumContract.SchoolInformationEntry.TABLE_NAME, selection, selectionArgs);
    }
}
