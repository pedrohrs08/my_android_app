package com.example.pedroresende.curriculum.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pedroresende.curriculum.R;
import com.example.pedroresende.curriculum.persistence.GeneralInfoPersistence;

public class EditGeneralInfo extends AppCompatActivity {

    private TextView txtName;
    private TextView txtCourse;
    private TextView txtEmail;
    private Button btnSave;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_general_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeComponents();
        setInitialValues();
        setListeners();
    }

    private void setListeners() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAndReturn();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToParent();
            }
        });
    }

    private void saveAndReturn() {
        GeneralInfoPersistence generalInfoPersistence = new GeneralInfoPersistence(getSharedPreferences(GeneralInfoPersistence.FILE_NAME,MODE_PRIVATE));
        generalInfoPersistence.putCourse(txtCourse.getText().toString());
        generalInfoPersistence.putEmail(txtEmail.getText().toString());
        generalInfoPersistence.putName(txtName.getText().toString());
        generalInfoPersistence.saveInfo();
        returnToParent();
    }

    private void returnToParent(){
        NavUtils.navigateUpFromSameTask(this);
    }

    private void setInitialValues() {
        Bundle bundle = getIntent().getExtras();
        txtName.setText(bundle.getString("NAME"));
        txtEmail.setText(bundle.getString("EMAIL"));
        txtCourse.setText(bundle.getString("COURSE"));
    }

    private void initializeComponents() {
        txtName = (TextView)findViewById(R.id.txtName);
        txtCourse = (TextView)findViewById(R.id.txtCourse);
        txtEmail = (TextView)findViewById(R.id.txtEmail);
        btnSave = (Button)findViewById(R.id.btnSave);
        btnCancel = (Button)findViewById(R.id.btnCancel);
    }

}
