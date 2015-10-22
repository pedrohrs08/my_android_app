package com.example.pedroresende.curriculum.persistence;

import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * Created by pedroresende on 21/10/15.
 */
public class GeneralInfoPersistence {

    public static final String FILE_NAME = "GENERAL_INFO";

    private static final String NAME_KEY = "NAME";
    private static final String EMAIL_KEY = "EMAIL";
    private static final String COURSE_KEY = "COURSE";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private boolean modified;

    public GeneralInfoPersistence(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        this.editor = sharedPreferences.edit();
        this.modified = false;
    }

    private void flagModified() {
        this.modified = true;
    }

    public void putEmail(String email) {
        editor.putString(EMAIL_KEY, email);
        flagModified();
    }

    public void putName(String name) {
        editor.putString(NAME_KEY, name);
        flagModified();
    }

    public void putCourse(String course) {
        editor.putString(COURSE_KEY, course);
        flagModified();
    }

    public void saveInfo() {
        if (modified)
            editor.commit();
    }

    public String getEmail() {
        return sharedPreferences.getString(EMAIL_KEY, "");
    }

    public String getName() {
        return sharedPreferences.getString(NAME_KEY, "");
    }

    public String getCourse() {
        return sharedPreferences.getString(COURSE_KEY, "");
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(NAME_KEY,getName());
        bundle.putString(EMAIL_KEY,getEmail());
        bundle.putString(COURSE_KEY,getCourse());
        return bundle;
    }
}
