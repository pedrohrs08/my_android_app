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

public class WorkInfo extends AppCompatActivity implements ProfileFragment.OnFragmentInteractionListener {

    private Button btnSchoolInfo;
    private Button btnGeneralInfo;
    private Button btnAddWorkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_info);
        initializeComponent();
        setEventListeners();
    }

    private void setEventListeners() {
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
        btnAddWorkInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(Navigator.getCustomIntentWithFilter(IntentFilters.ADD_EXPERIENCE_INFO), 0);
            }
        });
    }

    private void initializeComponent() {
        btnGeneralInfo = (Button) findViewById(R.id.btnGeneralInfo);
        btnSchoolInfo = (Button) findViewById(R.id.btnSchoolInfo);
        btnAddWorkInfo = (Button) findViewById(R.id.addWorkInfo);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                createWorkInfoView(bundle);
            }
        }
    }

    private void createWorkInfoView(Bundle bundle) {
        TableRow tableRow = new TableRow(this);
        tableRow.setPadding(0, 0, 0, 10);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView largetTextView = new TextView(this);
        largetTextView.setText(bundle.getString(SharedBundleKeys.TITLE_KEY));
        largetTextView.setTextAppearance(this, android.R.style.TextAppearance_Large);
        largetTextView.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.bottom_border));
        linearLayout.addView(largetTextView);

        TextView smallTextView = new TextView(this);
        smallTextView.setText(bundle.getString(SharedBundleKeys.DESCRIPTION_KEY));
        smallTextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        linearLayout.addView(smallTextView);

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
