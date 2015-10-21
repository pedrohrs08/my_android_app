package com.example.pedroresende.curriculum;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.pedroresende.curriculum.helpers.Navigator;

public class GeneralInfo extends AppCompatActivity {

    private TextView txtName;
    private TextView txtEmail;
    private TextView txtCourse;
    private Button btnSchoolInfo;
    private Button btnWorkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_info);
        initializeComponents();
        setListeners();
    }

    private void setListeners(){
        btnSchoolInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Navigator.navigateToSchoolInfoIntent());
            }
        });
    }

    private void initializeComponents() {
        txtName = (TextView)findViewById(R.id.txtName);
        txtEmail = (TextView)findViewById(R.id.txtEmail);
        txtCourse = (TextView)findViewById(R.id.txtCourse);
        btnSchoolInfo = (Button)findViewById(R.id.btnSchoolInfo);
        btnWorkInfo = (Button)findViewById(R.id.btnWorkInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_general_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
