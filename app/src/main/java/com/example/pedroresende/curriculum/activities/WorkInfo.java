package com.example.pedroresende.curriculum.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.pedroresende.curriculum.activities.fragments.ProfileFragment;
import com.example.pedroresende.curriculum.R;
import com.example.pedroresende.curriculum.custom.intent.filters.IntentFilters;
import com.example.pedroresende.curriculum.helpers.navigation.Navigator;

public class WorkInfo extends AppCompatActivity implements ProfileFragment.OnFragmentInteractionListener {

    private Button btnSchoolInfo;
    private Button btnGeneralInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_info);
        initializeComponent();
        setEventListeners();
    }

    private void setEventListeners(){
        btnSchoolInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Navigator.getCustomIntentWithFilter(IntentFilters.SCHOOL_INFO));
            }
        });

        btnGeneralInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Navigator.getCustomIntentWithFilter(IntentFilters.GENERAL_INFO));
            }
        });
    }

    private void initializeComponent() {
        btnGeneralInfo = (Button)findViewById(R.id.btnGeneralInfo);
        btnSchoolInfo = (Button)findViewById(R.id.btnSchoolInfo);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
