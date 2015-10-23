package com.example.pedroresende.curriculum.persistence.domain.entities;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by pedroresende on 10/23/15.
 */
public interface Convertable<T> {
    public ContentValues toContentValues();
    public T buildFromContentValues(Cursor values);
}
