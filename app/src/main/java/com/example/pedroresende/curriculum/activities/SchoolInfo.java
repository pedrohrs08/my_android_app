package com.example.pedroresende.curriculum.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.pedroresende.curriculum.activities.fragments.BlankFragment;
import com.example.pedroresende.curriculum.R;
import com.example.pedroresende.curriculum.custom.intent.filters.IntentFilters;
import com.example.pedroresende.curriculum.helpers.navigation.Navigator;

public class SchoolInfo extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

    private Button btnGeneralInfo;
    private Button btnWorkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_info);
        initializeComponents();
        setEventListeners();
    }

    private void setEventListeners() {
        btnGeneralInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Navigator.getCustomIntentWithFilter(IntentFilters.GENERAL_INFO));
            }
        });

        btnWorkInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Navigator.getCustomIntentWithFilter(IntentFilters.WORK_INFO));
            }
        });
    }

    private void initializeComponents() {
        btnGeneralInfo = (Button)findViewById(R.id.btnGeneralInfo);
        btnWorkInfo = (Button)findViewById(R.id.btnWorkInfo);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
