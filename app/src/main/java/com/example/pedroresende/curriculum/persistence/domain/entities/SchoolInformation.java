package com.example.pedroresende.curriculum.persistence.domain.entities;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.pedroresende.curriculum.persistence.sqllite.contract.CurriculumContract;

/**
 * Created by pedroresende on 10/23/15.
 */
public class SchoolInformation implements Convertable<SchoolInformation> {

    private Long id;
    private String title;
    private String description;

    @Override
    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CurriculumContract.SchoolInformationEntry._ID,id);
        contentValues.put(CurriculumContract.SchoolInformationEntry.COLUMN_NAME_TITLE,title);
        contentValues.put(CurriculumContract.SchoolInformationEntry.COLUMN_NAME_DESCRIPTION,description);
        return contentValues;
    }

    @Override
    public SchoolInformation buildFromContentValues(Cursor values) {
        id = values.getLong(values.getColumnIndexOrThrow(CurriculumContract.SchoolInformationEntry._ID));
        title = values.getString(values.getColumnIndexOrThrow(CurriculumContract.SchoolInformationEntry.COLUMN_NAME_TITLE));
        description = values.getString(values.getColumnIndexOrThrow(CurriculumContract.SchoolInformationEntry.COLUMN_NAME_DESCRIPTION));
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
