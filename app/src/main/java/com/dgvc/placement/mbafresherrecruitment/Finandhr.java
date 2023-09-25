package com.dgvc.placement.mbafresherrecruitment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by NIKILSELVARAJ on 18/06/17.
 */

public class Finandhr extends Fragment{
    public  ArrayList<DataModel> dataModels=new ArrayList<DataModel>();
    public  ArrayList<DataModel> pggreaterthan60=new ArrayList<DataModel>();
    public  ArrayList<DataModel> uggreaterthan60=new ArrayList<DataModel>();
    public  ArrayList<DataModel> workexperienced=new ArrayList<DataModel>();
    public static ArrayList<DataModel> finandhrshortlisted=new ArrayList<DataModel>();
    public static ArrayList<DataModel> finandhrwaitlisted=new ArrayList<DataModel>();
    public String Objectivey,name1y, specializationy, collegey, Expectedyeary,  ugspecializationy, ugcollegey, ugyearofpassingy;
    public String emaily,mobiley;
    public String hsnamey,hsyearofpassingy,hspercentagey,ssnamey,ssyearofpassingy,sspercentagey;
    public String computerskillsy,experiencey,internshipsy,achievementsy,ecactivitiesy;
    public String Linkedinidy,youtubepagey,blogy,imgdecodedstringy,key1y;
    public int percentagey, ugpercentagey;
    public String we;
    public ListView listView;
    public static CustomAdapter adapter;
    public DatabaseReference mFirebaseDatabase;
    public DatabaseReference mFirebaseDatabase1;
    public FirebaseDatabase mFirebaseInstance;
    public DatabaseReference mref;
    public ListView lv;
    boolean arf=false;
    public ProgressBar spinner;
    public SwipeRefreshLayout mSwipeRefreshLayout;
    public  int index;
    public  String key4list=null;


    @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.finandhr, container, false);
        spinner = (ProgressBar)rootView.findViewById(R.id.progressBar1);
        spinner.setVisibility(rootView.VISIBLE);
        listView = (ListView) rootView.findViewById(R.id.ListView01);
        mFirebaseInstance= FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("Studentlist");
        mFirebaseDatabase1 = mFirebaseInstance.getReference("Selectedstudents");
        mFirebaseDatabase.keepSynced(true);
        loop();
        lv = (ListView) rootView.findViewById(R.id.ListView01);
        registerForContextMenu(lv);
        mFirebaseDatabase.child("Finandhr").addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                loop();
            }
            @Override
            public void onCancelled(DatabaseError firebaseError) {
                return;
            }
        });
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeToRefresh);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                loop();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position1, long id) {
                DataModel dataModel;
                if (Studentlist.pg60 == true) {
                    dataModel = pggreaterthan60.get(position1);
                }
                else if (Studentlist.ug60==true)
                {
                    dataModel = uggreaterthan60.get(position1);}
                else if (Studentlist.shortist == true){
                    dataModel = finandhrshortlisted.get(position1);
                }
                else if (Studentlist.waitist == true){
                    dataModel = finandhrwaitlisted.get(position1);
                }
                else if (Studentlist.we1 == true){
                    dataModel = workexperienced.get(position1);
                }
                else {
                    dataModel = dataModels.get(position1);
                }
                Showprofiledetails.clickeddm=dataModel;
                Intent i=new Intent(getActivity(),Showprofiledetails.class);
                startActivity(i);}
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                index=position;
                Log.d("Finandhr",String.valueOf(index));
                return false;
            }
        });
        return rootView;
        }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {if(Splash.act!=null) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(1, v.getId(), 1,"Move to SelectedStudents List");
        menu.add(1, v.getId(), 2,"Delete");
    }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (getUserVisibleHint()) {
            if (item.getTitle() == "Move to SelectedStudents List") {
                DataModel datamodel = dataModels.get(index);
                key4list = datamodel.getKey();
                moveGameRoom(mFirebaseDatabase.child("Finandhr").child(key4list).getRef(), mFirebaseDatabase1.child("Finandhr").push().getRef());
                remove(key4list);
                key4list = null;
                Toast.makeText(getActivity().getApplicationContext(), "Moved to selected students", Toast.LENGTH_LONG).show();
            } else if (item.getTitle() == "Delete") {
                    DataModel datamodel = dataModels.get(index);
                    key4list = datamodel.getKey();
                    remove(key4list);
                    key4list = null;
                    Toast.makeText(getActivity().getApplicationContext(), "deleted", Toast.LENGTH_LONG).show();
            } else {
                return false;
            }
        }
        return false;
    }
public void loop(){
        spinner.setVisibility(View.VISIBLE);
        if (SelectedStudents.ss == true)
            mref = mFirebaseDatabase1.child("Finandhr");
        else
            mref = mFirebaseDatabase.child("Finandhr");
        mref.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataModels.clear();
                pggreaterthan60.clear();
                uggreaterthan60.clear();
                workexperienced.clear();
                Iterable<DataSnapshot> studentlist = dataSnapshot.getChildren();
                for (DataSnapshot studentlist1 : studentlist) {
                    key1y = studentlist1.getKey().toString();
                    name1y = studentlist1.child("name1").getValue(String.class);
                    emaily = studentlist1.child("email").getValue(String.class);
                    imgdecodedstringy = studentlist1.child("imgdecodedstring").getValue(String.class);
                    ugpercentagey = Float.valueOf((String) studentlist1.child("ugpercentage").getValue(String.class)).intValue();
                    percentagey = Float.valueOf((String) studentlist1.child("percentage").getValue(String.class)).intValue();
                    we = studentlist1.child("experience").getValue(String.class);
                    Objectivey = studentlist1.child("Objective").getValue(String.class);
                    specializationy = studentlist1.child("specialization").getValue(String.class);
                    collegey = studentlist1.child("college").getValue(String.class);
                    Expectedyeary = studentlist1.child("Expectedyear").getValue(String.class);
                    ugspecializationy = studentlist1.child("ugspecialization").getValue(String.class);
                    ugcollegey = studentlist1.child("ugcollege").getValue(String.class);
                    ugyearofpassingy = studentlist1.child("ugyearofpassing").getValue(String.class);
                    hsnamey = studentlist1.child("hsname").getValue(String.class);
                    hsyearofpassingy = studentlist1.child("hsyearofpassing").getValue(String.class);
                    hspercentagey = studentlist1.child("hspercentage").getValue(String.class);
                    ssnamey = studentlist1.child("ssname").getValue(String.class);
                    ssyearofpassingy = studentlist1.child("ssyearofpassing").getValue(String.class);
                    sspercentagey = studentlist1.child("sspercentage").getValue(String.class);
                    mobiley = studentlist1.child("mobile").getValue(String.class);
                    computerskillsy = studentlist1.child("computerskills").getValue(String.class);
                    experiencey = studentlist1.child("experience").getValue(String.class);
                    internshipsy = studentlist1.child("internships").getValue(String.class);
                    achievementsy = studentlist1.child("achievements").getValue(String.class);
                    ecactivitiesy = studentlist1.child("ecactivities").getValue(String.class);
                    youtubepagey = studentlist1.child("youtubepage").getValue(String.class);
                    blogy = studentlist1.child("blog").getValue(String.class);
                    Linkedinidy = studentlist1.child("Linkedinid").getValue(String.class);

                    addobj(specializationy, collegey, Expectedyeary, percentagey, ugspecializationy, ugcollegey, ugyearofpassingy, ugpercentagey, emaily, mobiley, hsnamey, hsyearofpassingy, hspercentagey, ssnamey, ssyearofpassingy, sspercentagey, computerskillsy, experiencey, internshipsy, achievementsy, ecactivitiesy, Linkedinidy, youtubepagey, blogy, Objectivey, name1y, imgdecodedstringy, key1y);
                    if ((we.equals("NIL")) || (we.equals(""))) {}
                    else if((we.equals("nil")) || (we.equals("Nil"))){}
                    else{
                        addwe(specializationy, collegey, Expectedyeary, percentagey, ugspecializationy, ugcollegey, ugyearofpassingy, ugpercentagey, emaily, mobiley, hsnamey, hsyearofpassingy, hspercentagey, ssnamey, ssyearofpassingy, sspercentagey, computerskillsy, experiencey, internshipsy, achievementsy, ecactivitiesy, Linkedinidy, youtubepagey, blogy, Objectivey, name1y, imgdecodedstringy, key1y);
                    }

                    if (ugpercentagey > 60) {
                        adduggreaterthan60(specializationy, collegey, Expectedyeary, percentagey, ugspecializationy, ugcollegey, ugyearofpassingy, ugpercentagey, emaily, mobiley, hsnamey, hsyearofpassingy, hspercentagey, ssnamey, ssyearofpassingy, sspercentagey, computerskillsy, experiencey, internshipsy, achievementsy, ecactivitiesy, Linkedinidy, youtubepagey, blogy, Objectivey, name1y, imgdecodedstringy, key1y);

                    }
                    if (percentagey > 60) {
                        addpggreaterthan60(specializationy, collegey, Expectedyeary, percentagey, ugspecializationy, ugcollegey, ugyearofpassingy, ugpercentagey, emaily, mobiley, hsnamey, hsyearofpassingy, hspercentagey, ssnamey, ssyearofpassingy, sspercentagey, computerskillsy, experiencey, internshipsy, achievementsy, ecactivitiesy, Linkedinidy, youtubepagey, blogy, Objectivey, name1y, imgdecodedstringy, key1y);
                    }

                    if (Studentlist.pg60 == true) {
                        adapter = new CustomAdapter(pggreaterthan60, getActivity().getApplicationContext());
                        listView.setAdapter(adapter);
                    } else if (Studentlist.ug60 == true) {
                        adapter = new CustomAdapter(uggreaterthan60, getActivity().getApplicationContext());
                        listView.setAdapter(adapter);
                    } else if (Studentlist.we1 == true) {
                        adapter = new CustomAdapter(workexperienced, getActivity().getApplicationContext());
                        listView.setAdapter(adapter);
                    } else if (Studentlist.shortist == true) {
                        adapter = new CustomAdapter(finandhrshortlisted, getActivity().getApplicationContext());
                        listView.setAdapter(adapter);
                    } else if (Studentlist.waitist == true) {
                        adapter = new CustomAdapter(finandhrwaitlisted, getActivity().getApplicationContext());
                        listView.setAdapter(adapter);
                    } else {
                        adapter = new CustomAdapter(dataModels, getActivity().getApplicationContext());
                        listView.setAdapter(adapter);
                    }
                }
                spinner.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
                return;
            }
        });

}
public void addobj(String specialization,String college,String Expectedyear,  int percentage, String ugspecialization, String ugcollege, String ugyearofpassing, int ugpercentage, String email, String mobile, String hsname, String hsyearofpassing, String hspercentage, String ssname, String ssyearofpassing, String sspercentage, String computerskills, String experience, String internships, String achievements, String ecactivities, String linkedinid,String youtubepage,String blog, String objective, String name1,String imgdecodestring,String key)
{
    for (int i=0;i<dataModels.size();i++)
    {
        if(key.equals(dataModels.get(i).getKey())){
            arf=true;
        }
    }
    if(arf==false) {
        DataModel temp = new DataModel(specialization,college,Expectedyear, percentage, ugspecialization, ugcollege, ugyearofpassing, ugpercentage, email, mobile,hsname, hsyearofpassing, hspercentage,ssname, ssyearofpassing,sspercentage, computerskills, experience, internships, achievements, ecactivities, linkedinid,youtubepage, blog,objective,name1,imgdecodestring,key);
        dataModels.add(temp);
    }
}
    public void addpggreaterthan60(String specialization,String college,String Expectedyear,  int percentage, String ugspecialization, String ugcollege, String ugyearofpassing, int ugpercentage, String email, String mobile, String hsname, String hsyearofpassing, String hspercentage, String ssname, String ssyearofpassing, String sspercentage, String computerskills, String experience, String internships, String achievements, String ecactivities, String linkedinid,String youtubepage,String blog, String objective, String name1,String imgdecodestring,String key)
    {
        for (int i=0;i<pggreaterthan60.size();i++)
        {
            if(key.equals(pggreaterthan60.get(i).getKey())){
                arf=true;
            }
        }
        if(arf==false) {
            DataModel temp = new DataModel(specialization,college,Expectedyear, percentage, ugspecialization, ugcollege, ugyearofpassing, ugpercentage, email, mobile,hsname, hsyearofpassing, hspercentage,ssname, ssyearofpassing,sspercentage, computerskills, experience, internships, achievements, ecactivities, linkedinid,youtubepage, blog,objective,name1,imgdecodestring,key);
            pggreaterthan60.add(temp);
        }
    }
    public void adduggreaterthan60(String specialization,String college,String Expectedyear,  int percentage, String ugspecialization, String ugcollege, String ugyearofpassing, int ugpercentage, String email, String mobile, String hsname, String hsyearofpassing, String hspercentage, String ssname, String ssyearofpassing, String sspercentage, String computerskills, String experience, String internships, String achievements, String ecactivities, String linkedinid,String youtubepage,String blog, String objective, String name1,String imgdecodestring,String key)
    {
        for (int i=0;i<uggreaterthan60.size();i++)
        {
            if(key.equals(uggreaterthan60.get(i).getKey())){
                arf=true;
            }
        }
        if(arf==false) {
            DataModel temp = new DataModel(specialization,college,Expectedyear, percentage, ugspecialization, ugcollege, ugyearofpassing, ugpercentage, email, mobile,hsname, hsyearofpassing, hspercentage,ssname, ssyearofpassing,sspercentage, computerskills, experience, internships, achievements, ecactivities, linkedinid,youtubepage, blog,objective,name1,imgdecodestring,key);
            uggreaterthan60.add(temp);
        }
    }
    public void addwe(String specialization,String college,String Expectedyear,  int percentage, String ugspecialization, String ugcollege, String ugyearofpassing, int ugpercentage, String email, String mobile, String hsname, String hsyearofpassing, String hspercentage, String ssname, String ssyearofpassing, String sspercentage, String computerskills, String experience, String internships, String achievements, String ecactivities, String linkedinid,String youtubepage,String blog, String objective, String name1,String imgdecodestring,String key)
    {
        for (int i=0;i<workexperienced.size();i++)
        {
            if(key.equals(workexperienced.get(i).getKey())){
                arf=true;
            }
        }
        if(arf==false) {
            DataModel temp = new DataModel(specialization,college,Expectedyear, percentage, ugspecialization, ugcollege, ugyearofpassing, ugpercentage, email, mobile,hsname, hsyearofpassing, hspercentage,ssname, ssyearofpassing,sspercentage, computerskills, experience, internships, achievements, ecactivities, linkedinid,youtubepage, blog,objective,name1,imgdecodestring,key);
            workexperienced.add(temp);
        }
    }
    public void remove(String key)
    {
        mFirebaseDatabase.child("Finandhr").child(key).removeValue();
        mFirebaseDatabase.child("Finandhr").child(key).setValue(null);
    }
    private void moveGameRoom(DatabaseReference fromPath, final DatabaseReference toPath) {
        fromPath.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                toPath.setValue(dataSnapshot.getValue(), new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError firebaseError, DatabaseReference firebase) {
                        if (firebaseError != null) {
                            System.out.println("Copy failed");
                        } else {
                            System.out.println("Success");
                        }
                    }
                });

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

