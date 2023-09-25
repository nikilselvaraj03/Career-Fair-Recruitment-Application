package com.dgvc.placement.mbafresherrecruitment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Recruiterlogin extends Fragment {
    private EditText mPasswordView;
    private Button mEmailSignInButton;
    private EditText muserid;
    private boolean mauthtask=false;
    public static EditText editText1obj;
    public static EditText editText2obj;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recruiterlogin, container, false);
        mPasswordView = (EditText)rootView.findViewById(R.id.password);
        muserid=(EditText)rootView.findViewById(R.id.userid);
        mEmailSignInButton  = (Button)rootView.findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        editText1obj=(EditText)rootView.findViewById(R.id.userid);
        editText2obj=(EditText)rootView.findViewById(R.id.password);
        return rootView;
    }

    public void attemptLogin()
    {
        muserid.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String userid = muserid.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;



        // Check for a valid email address.
        if (TextUtils.isEmpty(userid)) {
            muserid.setError(getString(R.string.error_field_required));
            focusView = muserid;
            cancel = true;
        } else if (!isUseridValid(userid)) {
            muserid.setError(getString(R.string.error_invalid_userid));
            focusView = muserid;
            cancel = true;
        }

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)  ) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }
        else if(!isPasswordValid(password)){
            mPasswordView.setError(getString(R.string.error_invalid_credential));
            focusView = mPasswordView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            Intent i = new Intent(getActivity(),Studentlist.class);
            startActivity(i);
            userid=null;
            password=null;
            focusView = muserid;

        }
    }
    private boolean isPasswordValid(String password) {
        return password.contentEquals("dgvc");
    }

    private boolean isUseridValid(String userid) {
        //TODO: Replace this with your own logic
        return userid.contentEquals("pgdom");

    }
    @Override
    public void onStart() {
        super.onStart();
        cleartext();
    }
    public void cleartext()
    {
        Recruiterlogin.editText1obj.setText(null);
        Recruiterlogin.editText2obj.setText(null);
        muserid.setError(null);
        mPasswordView.setError(null);

    }
}

