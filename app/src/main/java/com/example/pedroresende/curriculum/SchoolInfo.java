package com.example.pedroresende.curriculum;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.pedroresende.curriculum.helpers.Navigator;

public class SchoolInfo extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

    private Button btnGeneralInfo;

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
                startActivity(Navigator.navigateToGeneralInfoIntent());
            }
        });
    }

    private void initializeComponents() {
        btnGeneralInfo = (Button)findViewById(R.id.button);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
