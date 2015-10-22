package com.example.pedroresende.curriculum.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pedroresende.curriculum.R;
import com.example.pedroresende.curriculum.custom.intent.filters.IntentFilters;
import com.example.pedroresende.curriculum.helpers.navigation.Navigator;
import com.example.pedroresende.curriculum.persistence.GeneralInfoPersistence;

import java.io.FileNotFoundException;

public class GeneralInfo extends AppCompatActivity {

    private TextView txtName;
    private TextView txtEmail;
    private TextView txtCourse;
    private Button btnSchoolInfo;
    private Button btnWorkInfo;
    private Button btnEditInfo;
    private GeneralInfoPersistence generalInfoPersistence;
    private ImageView imgViewProfilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_info);
        initializeComponents();
        setComponentsInitialValues();
        setListeners();
    }

    private void setComponentsInitialValues() {
        generalInfoPersistence = new GeneralInfoPersistence(getSharedPreferences(GeneralInfoPersistence.FILE_NAME,MODE_PRIVATE));
        txtName.setText(generalInfoPersistence.getName());
        txtCourse.setText(generalInfoPersistence.getCourse());
        txtEmail.setText(generalInfoPersistence.getEmail());
        try {
            imgViewProfilePicture.setImageBitmap(getBitmap(Uri.parse(generalInfoPersistence.getImageUri())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setListeners(){
        btnSchoolInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Navigator.getCustomIntentWithFilter(IntentFilters.SCHOOL_INFO));
            }
        });

        btnWorkInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Navigator.getCustomIntentWithFilter(IntentFilters.WORK_INFO));
            }
        });

        btnEditInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customIntentWithFilter = Navigator.getCustomIntentWithFilter(IntentFilters.GENERAL_INFO_EDIT);
                customIntentWithFilter.putExtras(generalInfoPersistence.toBundle());
                startActivity(customIntentWithFilter);
            }
        });
        imgViewProfilePicture.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
                return true;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            Uri targetUri = data.getData();
            Bitmap bitmap;
            try {
                bitmap = getBitmap(targetUri);
                imgViewProfilePicture.setImageBitmap(bitmap);
                generalInfoPersistence.putImageUrI(targetUri.toString());
                generalInfoPersistence.saveInfo();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private Bitmap getBitmap(Uri targetUri) throws FileNotFoundException {
        Bitmap bitmap;
        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
        bitmap = Bitmap.createScaledBitmap(bitmap,100,130,true);
        return bitmap;
    }

    private void initializeComponents() {
        txtName = (TextView)findViewById(R.id.txtName);
        txtEmail = (TextView)findViewById(R.id.txtEmail);
        txtCourse = (TextView)findViewById(R.id.txtCourse);
        btnSchoolInfo = (Button)findViewById(R.id.btnSchoolInfo);
        btnWorkInfo = (Button)findViewById(R.id.btnWorkInfo);
        btnEditInfo = (Button)findViewById(R.id.btnEditInfo);
        imgViewProfilePicture = (ImageView)findViewById(R.id.imgProfilePicture);
    }
}
