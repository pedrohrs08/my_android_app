package com.example.pedroresende.curriculum.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.pedroresende.curriculum.activities.fragments.ProfileFragment;
import com.example.pedroresende.curriculum.R;
import com.example.pedroresende.curriculum.activities.helpers.keys.SharedBundleKeys;
import com.example.pedroresende.curriculum.custom.intent.filters.IntentFilters;
import com.example.pedroresende.curriculum.helpers.navigation.Navigator;
import com.example.pedroresende.curriculum.persistence.domain.entities.SchoolInformation;
import com.example.pedroresende.curriculum.persistence.sqlite.dbhelper.CurriculumDbHelper;
import com.example.pedroresende.curriculum.persistence.sqlite.services.SchoolInformationServices;

import java.util.List;

public class SchoolInfo extends AppCompatActivity implements ProfileFragment.OnFragmentInteractionListener {

    private Button btnGeneralInfo;
    private Button btnWorkInfo;
    private Button btnAddInfo;
    private SchoolInformationServices schoolInformationServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_info);
        initializeComponents();
        setEventListeners();
        schoolInformationServices = new SchoolInformationServices(new CurriculumDbHelper(this));
        populateInformation(schoolInformationServices.getAll());
    }

    private void populateInformation(List<SchoolInformation> schoolInformationServicesAll) {
        for(SchoolInformation schoolInformation: schoolInformationServicesAll)
            createWorkInfoView(schoolInformation);
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

        btnAddInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(Navigator.getCustomIntentWithFilter(IntentFilters.ADD_EXPERIENCE_INFO),0);
            }
        });
    }

    private void initializeComponents() {
        btnGeneralInfo = (Button)findViewById(R.id.btnGeneralInfo);
        btnWorkInfo = (Button)findViewById(R.id.btnWorkInfo);
        btnAddInfo = (Button)findViewById(R.id.btnAddInfo);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                SchoolInformation schoolInformation = new SchoolInformation();
                schoolInformation.setTitle(bundle.getString(SharedBundleKeys.TITLE_KEY));
                schoolInformation.setDescription(bundle.getString(SharedBundleKeys.DESCRIPTION_KEY));
                long tableRowId = schoolInformationServices.insert(schoolInformation);
                schoolInformation.setId(tableRowId);
                createWorkInfoView(schoolInformation);
            }
        }
    }

    private void createWorkInfoView(SchoolInformation schoolInformation) {
        TableRow tableRow = new TableRow(this);
        tableRow.setPadding(0, 0, 0, 10);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView largetTextView = new TextView(this);
        largetTextView.setText(schoolInformation.getTitle());
        largetTextView.setTextAppearance(this, android.R.style.TextAppearance_Large);
        largetTextView.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.bottom_border));
        linearLayout.addView(largetTextView);

        TextView smallTextView = new TextView(this);
        smallTextView.setText(schoolInformation.getDescription());
        smallTextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        linearLayout.addView(smallTextView);

        tableRow.setTag(schoolInformation.getId());
        tableRow.addView(linearLayout);

        ((TableLayout) findViewById(R.id.tableLayout)).addView(tableRow);

        tableRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showDeleteDialog(v);
                return true;
            }
        });
    }

    private void showDeleteDialog(final View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE) {
                    schoolInformationServices.delete((long)v.getTag());
                    ((ViewGroup) v.getParent()).removeView(v);
                }
            }
        };

        builder.setMessage("Deseja excluir este item?").setPositiveButton("Sim", dialog).setNegativeButton("Nao",dialog).show();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
