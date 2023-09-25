package com.dgvc.placement.mbafresherrecruitment;

import android.content.Intent;
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
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class Editlist extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public SectionsPagerAdapter mSectionsPagerAdapter3;
    public  ViewPager mViewPager3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mSectionsPagerAdapter3 = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager3 = (ViewPager) findViewById(R.id.container3);
        mViewPager3.setAdapter(mSectionsPagerAdapter3);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs3);
        tabLayout.setupWithViewPager(mViewPager3);
        Splash.act=this.toString();
        SelectedStudents.ss=false;

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.editlistmenu) {}
        else if (id == R.id.selectedstudentsmenu) {
            Intent i = new Intent(this,SelectedStudents.class);
            startActivity(i);}
        else if (id == R.id.home) {
            Intent i = new Intent(this,Institutionaloptions.class);
            startActivity(i);}

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void newprofile(View view){
        Intent i = new Intent(getApplicationContext(),newprofile.class);
        startActivity(i);
    }

    public static class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Finandhr fhr = new Finandhr();
                    return fhr;
                case 1:
                    Finandmrkt fmrkt = new Finandmrkt();
                    return fmrkt;
                case 2:
                    Finandscm fscm = new Finandscm();
                    return fscm;
                case 3:
                    Mrktandhr mhr = new Mrktandhr();
                    return  mhr;
                case 4:
                    Mrktandscm mscm = new Mrktandscm();
                    return mscm;
                default:
                    return null;
            }


        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
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

}