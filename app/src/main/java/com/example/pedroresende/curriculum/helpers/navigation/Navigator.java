package com.example.pedroresende.curriculum.helpers.navigation;

import android.content.Intent;

import com.example.pedroresende.curriculum.custom.intent.filters.IntentFilters;

/**
 * Created by pedroresende on 10/21/15.
 */
public class Navigator {
    private Navigator(){

    }

    public static Intent getCustomIntentWithFilter(IntentFilters filter){
        return new Intent(filter.name());
    }
}
