package com.example.pedroresende.curriculum.persistence.domain.entities;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.pedroresende.curriculum.persistence.sqllite.contract.CurriculumContract;

import java.util.Locale;

/**
 * Created by pedroresende on 10/23/15.
 */
public class WorkInformation implements Convertable<WorkInformation> {

    private Long id;
    private String title;
    private String description;

    @Override
    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CurriculumContract.WorkExperienceEntry.COLUMN_NAME_ENTRY_ID,id);
        contentValues.put(CurriculumContract.WorkExperienceEntry.COLUMN_NAME_TITLE,title);
        contentValues.put(CurriculumContract.WorkExperienceEntry.COLUMN_NAME_DESCRIPTION,description);
        return contentValues;
    }

    @Override
    public WorkInformation buildFromContentValues(Cursor values) {
        id = values.getLong(values.getColumnIndexOrThrow(CurriculumContract.WorkExperienceEntry.COLUMN_NAME_ENTRY_ID));
        title = values.getString(values.getColumnIndexOrThrow(CurriculumContract.WorkExperienceEntry.COLUMN_NAME_TITLE));
        description = values.getString(values.getColumnIndexOrThrow(CurriculumContract.WorkExperienceEntry.COLUMN_NAME_DESCRIPTION));
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
