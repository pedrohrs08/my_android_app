package com.example.pedroresende.curriculum.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pedroresende.curriculum.R;
import com.example.pedroresende.curriculum.activities.helpers.keys.SharedBundleKeys;

public class AddExperienceInfo extends AppCompatActivity {

    private EditText txtTitle;
    private EditText txtDescription;
    private Button btnSave;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work_experience_info);
        initializeComponents();
        setListeners();
    }

    private void setListeners() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnWithBundle();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnCancel();
            }
        });
    }

    private void returnCancel() {
        setResult(RESULT_CANCELED);
        finish();
    }

    private void returnWithBundle() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(SharedBundleKeys.TITLE_KEY,txtTitle.getText().toString());
        bundle.putString(SharedBundleKeys.DESCRIPTION_KEY,txtDescription.getText().toString());
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
