package com.example.pedroresende.curriculum.persistence;

import android.content.SharedPreferences;

/**
 * Created by pedroresende on 21/10/15.
 */
public class GeneralInfoPersistence {

    private static final String NAME_KEY = "NAME";
    private static final String EMAIL_KEY = "EMAIL";
    private static final String COURSE_KEY = "COURSE";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private boolean modified;

    public GeneralInfoPersistence(SharedPreferences sharedPreferences){
        this.sharedPreferences = sharedPreferences;
        this.editor = sharedPreferences.edit();
        this.modified = false;
    }

    private void flagModified(){
        this.modified = true;
    }

    public void putEmail(String email){
        editor.putString(EMAIL_KEY,email);
        flagModified();
    }

    public void putName(String name){
        editor.putString(NAME_KEY,name);
        flagModified();
    }

    public void putCourse(String course){
        editor.putString(COURSE_KEY,course);
        flagModified();
    }

    public void saveInfo(){
        if(modified)
            editor.commit();
    }

}
