package com.dgvc.placement.mbafresherrecruitment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Studentlist extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public SectionsPagerAdapter mSectionsPagerAdapter2;
    public ViewPager mViewPager2;
    public  DatabaseReference mFirebaseDatabase;
    public  FirebaseDatabase mFirebaseInstance;
    public  ArrayList<String> studentlistkeys=new ArrayList<String>();
    public int cleared;
    public static boolean connected = false;
    public static boolean pg60=false;
    public static  boolean ug60=false;
    public static  boolean we1=false;
    public static boolean shortist=false;
    public static boolean waitist=false;
    public  ArrayList<DataModel> shortlisted=new ArrayList<DataModel>();
    public  ArrayList<DataModel> waitlisted=new ArrayList<DataModel>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cleared=0;
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fragmentstart();
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else {
            connected = false;
            showalert();
        }

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("Studentlist");
        mFirebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onCancelled(DatabaseError firebaseError) {
            }
        });
        Splash.act=null;
        SelectedStudents.ss=false;
    }
public void fragmentstart(){
    mSectionsPagerAdapter2 = new SectionsPagerAdapter(getSupportFragmentManager());
    mViewPager2 = (ViewPager) findViewById(R.id.container2);
    mViewPager2.setAdapter(mSectionsPagerAdapter2);
    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs2);
    tabLayout.setupWithViewPager(mViewPager2);
}
    @Override
    public void onBackPressed() {
            exit();
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
        return super.onOptionsItemSelected(item);}

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){
            case R.id.allstudents:
            pg60=false;
            ug60=false;
            we1=false;
            shortist=false;
            waitist=false;
            fragmentstart();
                break;
            case R.id.shortlistedstudents:
            pg60=false;
            ug60=false;
            we1=false;
            shortist=true;
            waitist=false;
            fragmentstart();
                break;
            case R.id.waitlistedstudents:
            pg60=false;
            ug60=false;
            we1=false;
            shortist=false;
            waitist=true;
            fragmentstart();
                break;
            case R.id.ug:
            pg60=false;
            ug60=true;
            we1=false;
            shortist=false;
            waitist=false;
            fragmentstart();
                break;

            case R.id.pg:
            pg60=true;
            ug60=false;
            we1=false;
            shortist=false;
            waitist=false;
            fragmentstart();
                break;
            case R.id.we:
            pg60=false;
            ug60=false;
            we1=true;
            shortist=false;
            waitist=false;
            fragmentstart();
                break;
            case R.id.contact:
                Intent i=new Intent(this,Contactus.class);
                startActivity(i);
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        Finandhr fhr = new Finandhr();
        Finandmrkt fmrkt = new Finandmrkt();
        Finandscm fscm = new Finandscm();
        Mrktandhr mhr = new Mrktandhr();
        Mrktandscm mscm = new Mrktandscm();

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return fhr;
                case 1:

                    return fmrkt;
                case 2:

                    return fscm;
                case 3:

                    return mhr;
                case 4:

                    return mscm;
                default:
                    return fhr;
            }


        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }

            @Override
            public CharSequence getPageTitle ( int position){
                switch (position) {
                    case 0:
                        return "FIN & HR";
                    case 1:
                        return "FIN & MRKT";
                    case 2:
                        return "FIN & SCM";
                    case 3:
                        return "MRKT & HR";
                    case 4:
                        return "MRKT & SCM";
                }
                return null;
            }
        }

public void exit()
{AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
    alertDialogBuilder.setTitle("Exit Application?");
    alertDialogBuilder
            .setMessage("Click yes to exit!")
            .setCancelable(false)
            .setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            moveTaskToBack(true);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);
                        }
                    })

            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                    dialog.cancel();
                }
            });

    AlertDialog alertDialog = alertDialogBuilder.create();
    alertDialog.show();
}
    private void showalert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if(connected==false) {
            builder.setTitle("No Internet Access");
            builder.setMessage("Error occured. Please Try Connecting To The Internet To Refresh Data .");
        }

        String positiveText = "OK";
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }
}

