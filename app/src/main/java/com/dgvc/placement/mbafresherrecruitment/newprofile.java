package com.dgvc.placement.mbafresherrecruitment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by NIKILSELVARAJ on 16/07/17.
 */

public class newprofile extends AppCompatActivity {
    private static final String TAG =newprofile.class.getSimpleName();
    private TextView txtDetails;
    protected EditText Objective,name1,college1,Expectedyear1,percentage1, ugspecialization1,ugcollege1,ugyearofpassing1,ugpercentage1,email1,mobile1;
    protected EditText hsname1,hsyearofpassing1,hspercentage1,ssname1,ssyearofpassing1,sspercentage1,computerskills1,experience1,internships1,achievements1,ecactivities1;
    protected EditText Linkedinid1,youtubepage1,blog1;
    protected Button save1;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private String userId;
    private int PICK_IMAGE_REQUEST = 1;
    String imgDecodableString;
    boolean cancel = false;
    private Spinner spinner1;
    boolean msg,imgselect=false;
    View focusView = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newprofile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Objective = (EditText) findViewById(R.id.Objective);
        name1 = (EditText) findViewById(R.id.name1);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        college1 = (EditText) findViewById(R.id.college);
        Expectedyear1 = (EditText) findViewById(R.id.expectedyear);
        percentage1 = (EditText) findViewById(R.id.percentage);
        ugspecialization1 = (EditText) findViewById(R.id.ugspecialization);
        ugcollege1 = (EditText) findViewById(R.id.ugcollege);
        ugyearofpassing1 = (EditText) findViewById(R.id.ugyearofpassing);
        ugpercentage1 = (EditText) findViewById(R.id.ugpercentage);
        email1 = (EditText) findViewById(R.id.email);
        mobile1 = (EditText) findViewById(R.id.mobileno);
        hsname1 = (EditText) findViewById(R.id.highschool);
        hsyearofpassing1 = (EditText) findViewById(R.id.hsyearofpassing);
        hspercentage1 = (EditText) findViewById(R.id.hspercentage);
        ssname1 = (EditText) findViewById(R.id.secondaryschool);
        ssyearofpassing1 = (EditText) findViewById(R.id.ssyearofpassing);
        sspercentage1 = (EditText) findViewById(R.id.sspercentage);
        computerskills1 = (EditText) findViewById(R.id.computerskills);
        experience1 = (EditText) findViewById(R.id.experience);
        internships1 = (EditText) findViewById(R.id.internships);
        achievements1 = (EditText) findViewById(R.id.achievements);
        ecactivities1 = (EditText) findViewById(R.id.ecactivities);
        Linkedinid1 = (EditText) findViewById(R.id.Linkedinid);
        youtubepage1 = (EditText) findViewById(R.id.Youtubepage);
        blog1 = (EditText) findViewById(R.id.Blog);
        save1 = (Button) findViewById(R.id.save);


        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("Studentlist");
        addListenerOnSpinnerItemSelection();
    }
        public void addListenerOnSpinnerItemSelection() {
            spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        }

    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
    }
        public void createprofile(View view) {
            if(imgselect==false)
            {
                Toast.makeText(this, "Please select an image for the student", Toast.LENGTH_SHORT).show();
            }
            else {
                cancel=false;
                String name = name1.getText().toString();
                String specialization = String.valueOf(spinner1.getSelectedItem());
                String objective = Objective.getText().toString();
                String college = college1.getText().toString();
                String Expectedyear = Expectedyear1.getText().toString();
                String percentage = percentage1.getText().toString();
                String ugspecialization = ugspecialization1.getText().toString();
                String ugcollege = ugcollege1.getText().toString();
                String ugyearofpassing = ugyearofpassing1.getText().toString();
                String ugpercentage = ugpercentage1.getText().toString();
                String email = email1.getText().toString();
                String mobile = mobile1.getText().toString();
                String hsname = hsname1.getText().toString();
                String hsyearofpassing = hsyearofpassing1.getText().toString();
                String hspercentage = hspercentage1.getText().toString();
                String ssname = ssname1.getText().toString();
                String ssyearofpassing = ssyearofpassing1.getText().toString();
                String sspercentage = sspercentage1.getText().toString();
                String computerskills = computerskills1.getText().toString();
                String experience = experience1.getText().toString();
                String internships = internships1.getText().toString();
                String achievements = achievements1.getText().toString();
                String ecactivities = ecactivities1.getText().toString();
                String Linkedinid = Linkedinid1.getText().toString();
                String youtubepage = youtubepage1.getText().toString();
                String blog = blog1.getText().toString();
                String imagedecoded = imgDecodableString.toString();
                if (TextUtils.isEmpty(name.toString())) {
                    name1.setError(getString(R.string.error_field_required));
                    focusView = name1;
                    cancel = true;
                } else if (TextUtils.isEmpty(college.toString())) {
                    college1.setError(getString(R.string.error_field_required));
                    focusView = college1;
                    cancel = true;
                } else if (TextUtils.isEmpty(Expectedyear.toString())) {
                    Expectedyear1.setError(getString(R.string.error_field_required));
                    focusView = Expectedyear1;
                    cancel = true;
                } else if (TextUtils.isEmpty(percentage.toString())) {
                    percentage1.setError(getString(R.string.error_field_required));
                    focusView = percentage1;
                    cancel = true;
                } else if (TextUtils.isEmpty(ugspecialization.toString())) {
                    ugspecialization1.setError(getString(R.string.error_field_required));
                    focusView = ugspecialization1;
                    cancel = true;
                } else if (TextUtils.isEmpty(ugcollege.toString())) {
                    ugcollege1.setError(getString(R.string.error_field_required));
                    focusView = ugcollege1;
                    cancel = true;
                } else if (TextUtils.isEmpty(ugyearofpassing.toString())) {
                    ugyearofpassing1.setError(getString(R.string.error_field_required));
                    focusView = ugyearofpassing1;
                    cancel = true;
                } else if (TextUtils.isEmpty(ugpercentage.toString())) {
                    ugpercentage1.setError(getString(R.string.error_field_required));
                    focusView = ugpercentage1;
                    cancel = true;
                } else if (TextUtils.isEmpty(hsname.toString())) {
                    hsname1.setError(getString(R.string.error_field_required));
                    focusView = hsname1;
                    cancel = true;
                } else if (TextUtils.isEmpty(hsyearofpassing.toString())) {
                    hsyearofpassing1.setError(getString(R.string.error_field_required));
                    focusView = hsyearofpassing1;
                    cancel = true;
                } else if (TextUtils.isEmpty(hspercentage.toString())) {
                    hspercentage1.setError(getString(R.string.error_field_required));
                    focusView = hspercentage1;
                    cancel = true;
                } else if (TextUtils.isEmpty(ssname.toString())) {
                    ssname1.setError(getString(R.string.error_field_required));
                    focusView = ssname1;
                    cancel = true;
                } else if (TextUtils.isEmpty(ssyearofpassing.toString())) {
                    ssyearofpassing1.setError(getString(R.string.error_field_required));
                    focusView = ssyearofpassing1;
                    cancel = true;
                } else if (TextUtils.isEmpty(sspercentage.toString())) {
                    sspercentage1.setError(getString(R.string.error_field_required));
                    focusView = sspercentage1;
                    cancel = true;
                } else if (TextUtils.isEmpty(email.toString())) {
                    email1.setError(getString(R.string.error_field_required));
                    focusView = email1;
                    cancel = true;
                } else if (TextUtils.isEmpty(mobile.toString())) {
                    mobile1.setError(getString(R.string.error_field_required));
                    focusView = mobile1;
                    cancel = true;
                } else if (TextUtils.isEmpty(computerskills.toString())) {
                    computerskills1.setError(getString(R.string.error_field_required));
                    focusView = computerskills1;
                    cancel = true;
                } else if (TextUtils.isEmpty(experience.toString())) {
                    experience1.setError(getString(R.string.error_field_required));
                    focusView = experience1;
                    cancel = true;
                } else if (TextUtils.isEmpty(internships.toString())) {
                    internships1.setError(getString(R.string.error_field_required));
                    focusView = internships1;
                    cancel = true;
                } else if (TextUtils.isEmpty(achievements.toString())) {
                    achievements1.setError(getString(R.string.error_field_required));
                    focusView = achievements1;
                    cancel = true;
                } else if (TextUtils.isEmpty(ecactivities.toString())) {
                    ecactivities1.setError(getString(R.string.error_field_required));
                    focusView = ecactivities1;
                    cancel = true;
                } else if (TextUtils.isEmpty(objective.toString())) {
                    Objective.setError(getString(R.string.error_field_required));
                    focusView = Objective;
                    cancel = true;
                } else if (TextUtils.isEmpty(youtubepage.toString())) {
                    youtubepage1.setError(getString(R.string.error_field_required));
                    focusView = youtubepage1;
                    cancel = true;
                }
                if (cancel == true) {
                    focusView.requestFocus();
                    Toast.makeText(this, "Please fill all the required columns ", Toast.LENGTH_SHORT).show();
                } else {
                    createUser(objective, name, specialization, college, Expectedyear, percentage, ugspecialization, ugcollege, ugyearofpassing, ugpercentage,
                            email, mobile, hsname, hsyearofpassing, hspercentage, ssname, ssyearofpassing, sspercentage, computerskills, experience, internships, achievements, ecactivities, Linkedinid, youtubepage, blog, imagedecoded);
                    toggleButton();
                }
            }
        }

    protected void toggleButton() {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED && userId==mFirebaseDatabase.child(userId).getKey())
            msg=true;
        else
            msg=false;
            showalert();
    }
        private void createUser(String Objective,String name1, String specialization , String college, String Expectedyear , String percentage,String ugspecialization , String ugcollege, String ugyearofpassing , String ugpercentage
                ,String email, String  mobile, String hsname, String hsyearofpassing , String hspercentage, String ssname, String ssyearofpassing, String sspercentage,
                String computerskills, String experience, String internships, String achievements, String ecactivities,String Linkedinid, String youtubepage, String blog,String imgdecodestring)
    {

       Studentprofile sp = new Studentprofile(specialization,college,Expectedyear, percentage, ugspecialization, ugcollege, ugyearofpassing, ugpercentage, email, mobile,hsname, hsyearofpassing, hspercentage,ssname, ssyearofpassing,sspercentage, computerskills, experience, internships, achievements, ecactivities, Linkedinid,youtubepage, blog,Objective,name1,imgdecodestring);
        if(specialization.equals("Finance and Hr")) {

            mFirebaseDatabase.child("Finandhr").push().setValue(sp);
        }
        else  if (specialization.equals("Finance and scm")) {
            mFirebaseDatabase.child("Finandscm").push().setValue(sp);

        }

        else  if (specialization.equals("Finance and Market")) {
            mFirebaseDatabase.child("Finandmrkt").push().setValue(sp);

        }
        else  if (specialization.equals("Market and Hr")) {
            mFirebaseDatabase.child("Mrktandhr").push().setValue(sp);
        }
        else {
            mFirebaseDatabase.child("Mrktandscm").push().setValue(sp);
        }
        Toast.makeText(this,specialization, Toast.LENGTH_SHORT).show();

    }
    private void showalert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if(msg==true) {
            builder.setTitle("SUCCESS");
            builder.setMessage("New Student Profile is Created Successfully and is added to the list");
        }
        else{
            builder.setTitle("Process Fail");
            builder.setMessage("Error occured.Please Try connecting to the internet or try again later.");
        }


        String positiveText = "OK";
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }

public  void setpicture(View view)
{
    Intent intent = new Intent();
// Show only images, no videos or anything else
    intent.setType("image/*");
    intent.setAction(Intent.ACTION_GET_CONTENT);
// Always show the chooser (if there are multiple options available)
    startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));
                ImageView imageView = (ImageView) findViewById(R.id.studentimage);
                imageView.setImageBitmap(bitmap);
                encodeBitmapAndSaveToFirebase(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void encodeBitmapAndSaveToFirebase(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        imgDecodableString= Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
        imgselect=true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(),Editlist.class);
        startActivityForResult(myIntent, 0);
        return super.onOptionsItemSelected(item);
    }
}

