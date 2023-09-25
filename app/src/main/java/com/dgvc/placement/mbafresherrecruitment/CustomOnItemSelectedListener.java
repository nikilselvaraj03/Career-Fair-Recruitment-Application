package com.dgvc.placement.mbafresherrecruitment;

/**
 * Created by NIKILSELVARAJ on 19/07/17.
 */
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class CustomOnItemSelectedListener implements OnItemSelectedListener {
public String pos1;
    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        parent.getContext();
        parent.getItemAtPosition(pos).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}