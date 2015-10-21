package com.example.pedroresende.curriculum.helpers;

import android.content.Intent;

/**
 * Created by pedroresende on 10/21/15.
 */
public class Navigator {
    private Navigator(){

    }

    public static Intent navigateToGeneralInfoIntent(){
        return new Intent("GENERAL_INFO");
    }

    public static Intent navigateToSchoolInfoIntent(){
        return new Intent("SCHOOL_INFO");
    }
}
