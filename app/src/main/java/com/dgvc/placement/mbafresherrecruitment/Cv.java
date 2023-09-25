package com.dgvc.placement.mbafresherrecruitment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by NIKILSELVARAJ on 08/08/17.
 */

public class Cv extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.cv, container, false);
        return  rootView;
    }
}
