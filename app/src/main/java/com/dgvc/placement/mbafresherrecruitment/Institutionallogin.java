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

/**
 * Created by NIKILSELVARAJ on 18/06/17.
 */

public class Institutionallogin  extends Fragment {
    public EditText mPasswordView2;
    private Button mEmailSignInButton;
    public EditText muserid2;
    private boolean mauthtask=false;
    public static EditText editText3obj;
    public static EditText editText4obj;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.institutionallogin, container, false);
        mPasswordView2 = (EditText)rootView.findViewById(R.id.password2);
        muserid2=(EditText)rootView.findViewById(R.id.userid2);
        mEmailSignInButton  = (Button)rootView.findViewById(R.id.email_sign_in_button2);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        editText3obj=(EditText)rootView.findViewById(R.id.userid2);
        editText4obj=(EditText)rootView.findViewById(R.id.password2);
        return rootView;


    }
    public void attemptLogin()
    {
        muserid2.setError(null);
        mPasswordView2.setError(null);

        // Store values at the time of the login attempt.
        String userid2 = muserid2.getText().toString();
        String password2 = mPasswordView2.getText().toString();

        boolean cancel = false;
        View focusView = null;



        // Check for a valid email address.
        if (TextUtils.isEmpty(userid2)) {
            muserid2.setError(getString(R.string.error_field_required));
            focusView = muserid2;
            cancel = true;
        } else if (!isUseridValid(userid2)) {
            muserid2.setError(getString(R.string.error_invalid_userid));
            focusView = muserid2;
            cancel = true;
        }

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password2)  ) {
            mPasswordView2.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView2;
            cancel = true;
        }
        else if(!isPasswordValid(password2)){
            mPasswordView2.setError(getString(R.string.error_invalid_credential));
            focusView = mPasswordView2;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            Intent i = new Intent(getActivity(),Institutionaloptions.class);
            startActivity(i);
            userid2=null;
            password2=null;
            focusView = muserid2;

        }
    }
    private boolean isPasswordValid(String password) {
        return password.contentEquals("mba16-18");
    }

    private boolean isUseridValid(String userid) {

        return userid.contentEquals("pgmba");
    }

    @Override
    public void onStart() {
        super.onStart();
    cleartext();
    }

    public  void cleartext()
    {
        Institutionallogin.editText3obj.setText(null);
        Institutionallogin.editText4obj.setText(null);
        muserid2.setError(null);
        mPasswordView2.setError(null);
    }
}
