package com.example.pedroresende.curriculum.persistence.sqlite.services;

import android.database.Cursor;

import com.example.pedroresende.curriculum.persistence.domain.entities.WorkInformation;
import com.example.pedroresende.curriculum.persistence.sqlite.dbhelper.CurriculumDbHelper;
import com.example.pedroresende.curriculum.persistence.sqllite.contract.CurriculumContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedroresende on 10/23/15.
 */
public class WorkInformationService extends GenericService<WorkInformation> {

    private String[] projection = new String[]{
        CurriculumContract.WorkExperienceEntry.COLUMN_NAME_ENTRY_ID,
                CurriculumContract.WorkExperienceEntry.COLUMN_NAME_TITLE,
                CurriculumContract.WorkExperienceEntry.COLUMN_NAME_DESCRIPTION
    };;

    public WorkInformationService(CurriculumDbHelper dbHelper){
        super(dbHelper);
    }

    @Override
    public long insert(WorkInformation entity) {
        return database.insert(CurriculumContract.WorkExperienceEntry.TABLE_NAME,null,entity.toContentValues());
    }

    @Override
    public List<WorkInformation> getAll() {
        Cursor cursor =  database.query(CurriculumContract.WorkExperienceEntry.TABLE_NAME, projection, null, null, null, null, null);
        List<WorkInformation> workInformations = new ArrayList<WorkInformation>();
        if(cursor.moveToFirst()) {
            do {
                WorkInformation workInformation = new WorkInformation();
                workInformation.buildFromContentValues(cursor);
                workInformations.add(workInformation);
            } while (cursor.moveToNext());
        }
        return workInformations;
    }

    @Override
    public WorkInformation get(long id) {
        String selection = CurriculumContract.WorkExperienceEntry.COLUMN_NAME_ENTRY_ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };
        WorkInformation workInformation = null;
        Cursor cursor =  database.query(CurriculumContract.WorkExperienceEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        if(cursor.moveToFirst()) {
            workInformation = new WorkInformation();
            workInformation.buildFromContentValues(cursor);
        }
        return workInformation;
    }

    @Override
    public void delete(long id) {
        String selection = CurriculumContract.WorkExperienceEntry.COLUMN_NAME_ENTRY_ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };
        WorkInformation workInformation = null;
        database.delete(CurriculumContract.WorkExperienceEntry.TABLE_NAME, selection, selectionArgs);
    }
}
