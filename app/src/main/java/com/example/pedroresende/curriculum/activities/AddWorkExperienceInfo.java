package com.example.pedroresende.curriculum.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pedroresende.curriculum.R;

public class AddWorkExperienceInfo extends AppCompatActivity {

    private EditText txtTitle;
    private EditText txtDescription;
    private Button btnSave;
    private Button btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work_experience_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeComponents();
        setListeners();
    }

    private void setListeners() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAndReturn();
            }
        });
    }

    private void saveAndReturn() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("title",txtTitle.getText().toString());
        bundle.putString("description",txtDescription.getText().toString());
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }

    private void initializeComponents() {
        txtTitle = (EditText)findViewById(R.id.txtTitle);
        txtDescription = (EditText)findViewById(R.id.txtDescription);
        btnSave = (Button)findViewById(R.id.btnSave);
        btnCancel = (Button)findViewById(R.id.btnCancel);
    }

}
