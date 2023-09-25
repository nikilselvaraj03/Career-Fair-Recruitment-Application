package com.dgvc.placement.mbafresherrecruitment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Showprofiledetails extends AppCompatActivity {
    public static DataModel clickeddm;
    String videoId;
    public String ssp,wsp;
    boolean i=false,j=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showprofiledetails);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(clickeddm.getName());
        ImageView propic=(ImageView)findViewById(R.id.studentimage);
        TextView  name=(TextView)findViewById(R.id.nameofstu);
        TextView  dep=(TextView)findViewById(R.id.depofstu);
        TextView  obj=(TextView)findViewById(R.id.objofstu);
        TextView  specialization=(TextView)findViewById(R.id.pgspecofstu);
        TextView  college=(TextView)findViewById(R.id.pgcollegeofstu);
        TextView  expectedyear=(TextView)findViewById(R.id.pgeyofstu);
        TextView  percentage=(TextView)findViewById(R.id.pgperofstu);
        TextView  ugspec=(TextView)findViewById(R.id.ugspecofstu);
        TextView  ugcolg=(TextView)findViewById(R.id.ugcollegeofstu);
        TextView  ugper=(TextView)findViewById(R.id.ugperofstu);
        TextView  ugyop=(TextView)findViewById(R.id.ugeyofstu);
        TextView  hsname=(TextView)findViewById(R.id.hsnameofstu);
        TextView  hsyop=(TextView)findViewById(R.id.hsyopofstu);
        TextView  hsper=(TextView)findViewById(R.id.hsperofstu);
        TextView  ssname=(TextView)findViewById(R.id.ssnameofstu);
        TextView  ssyop=(TextView)findViewById(R.id.ssyopofstu);
        TextView  ssper=(TextView)findViewById(R.id.ssperofstu);
        TextView  email=(TextView)findViewById(R.id.email1ofstu);
        TextView  mobile=(TextView)findViewById(R.id.mobileofstu);
        TextView  cs=(TextView)findViewById(R.id.csofstu);
        TextView  experience=(TextView)findViewById(R.id.reofstu);
        TextView  internships=(TextView)findViewById(R.id.aiofstu);
        TextView  achievements=(TextView)findViewById(R.id.achievementsofstu);
        TextView  ecativities=(TextView)findViewById(R.id.ecactivitiesofstu);
        Bitmap imagebitmap;
        try {
            imagebitmap = decodeFromFirebaseBase64(clickeddm.getImgdecodestring());
            propic.setImageBitmap(imagebitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        name.setText(clickeddm.getName());
        obj.setText(clickeddm.getObjective());
        dep.setText(clickeddm.getSpecialization());
        specialization.setText(clickeddm.getSpecialization());
        college.setText(clickeddm.getCollege());
        expectedyear.setText(clickeddm.getExpectedyear());
        percentage.setText(clickeddm.getPercentagex()+"%");
        ugcolg.setText(clickeddm.getUgcollege());
        ugspec.setText(clickeddm.getUgspecialization());
        ugper.setText(clickeddm.getUgpercentagex()+"%");
        ugyop.setText(clickeddm.getUgyearofpassing());
        hsname.setText(clickeddm.getHsname());
        hsyop.setText(clickeddm.getHsyearofpassing());
        hsper.setText(clickeddm.getHspercentage()+"%");
        ssname.setText(clickeddm.getSsname());
        ssyop.setText(clickeddm.getSsyearofpassing());
        ssper.setText(clickeddm.getSspercentage()+"%");
        email.setText(clickeddm.getType());
        mobile.setText(clickeddm.getMobile());
        cs.setText(clickeddm.getComputerskills());
        experience.setText(clickeddm.getExperiencex());
        internships.setText(clickeddm.getInternships());
        achievements.setText(clickeddm.getAchievements());
        ecativities.setText(clickeddm.getEcactivities());
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(),Studentlist.class);
        startActivityForResult(myIntent, 0);
        return super.onOptionsItemSelected(item);
        }
    public void shortlist(View view){
        if(i==false) {
                i = true;
                ssp = clickeddm.getSpecialization();
                if (ssp.equals("Finance and Hr")&& !Finandhr.finandhrshortlisted.contains(clickeddm)) {
                    Finandhr.finandhrshortlisted.add(clickeddm);
                } else if (ssp.equals("Finance and scm") && !Finandscm.finandscmshortlisted.contains(clickeddm)) {
                    Finandscm.finandscmshortlisted.add(clickeddm);
                } else if (ssp.equals("Finance and Market")&& !Finandmrkt.finandmrktshortlisted.contains(clickeddm)) {
                    Finandmrkt.finandmrktshortlisted.add(clickeddm);
                } else if (ssp.equals("Market and Hr")&& !Mrktandhr.mrktandhrshortlisted.contains(clickeddm)) {
                    Mrktandhr.mrktandhrshortlisted.add(clickeddm);
                } else if(ssp.equals("Market and scm")&& !Mrktandscm.mrktandscmshortlisted.contains(clickeddm)){
                    Mrktandscm.mrktandscmshortlisted.add(clickeddm);}
                ImageView i = (ImageView) findViewById(R.id.shortlistbutton);
                Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.shortlistblue);
                i.setImageBitmap(largeIcon);
                Toast.makeText(this, clickeddm.getName() + " has been shortlisted", Toast.LENGTH_SHORT).show();
            } else {
                i = false;
                ssp = clickeddm.getSpecialization();
                if (ssp.equals("Finance and Hr")) {
                    Finandhr.finandhrshortlisted.remove(clickeddm);
                } else if (ssp.equals("Finance and scm")) {
                    Finandscm.finandscmshortlisted.remove(clickeddm);
                } else if (ssp.equals("Finance and Market")) {
                    Finandmrkt.finandmrktshortlisted.remove(clickeddm);
                } else if (ssp.equals("Market and Hr")) {
                    Mrktandhr.mrktandhrshortlisted.remove(clickeddm);
                } else {
                    Mrktandscm.mrktandscmshortlisted.remove(clickeddm);
                }
                ImageView i = (ImageView) findViewById(R.id.shortlistbutton);
                Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.shortlistgrey);
                i.setImageBitmap(largeIcon);
                Toast.makeText(this, clickeddm.getName() + " has been Removed from shortlist", Toast.LENGTH_SHORT).show();
            }
        }

    public void waitlist(View view)
    { if(j==false) {
        j = true;
        wsp = clickeddm.getSpecialization();
        if (wsp.equals("Finance and Hr")&& !Finandhr.finandhrwaitlisted.contains(clickeddm)) {
            Finandhr.finandhrwaitlisted.add(clickeddm);
        } else if (wsp.equals("Finance and scm")&& ! Finandscm.finandscmwaitlisted.contains(clickeddm)) {
            Finandscm.finandscmwaitlisted.add(clickeddm);
        } else if (wsp.equals("Finance and Market")&& !Finandmrkt.finandmrktwaitlisted.contains(clickeddm)) {
            Finandmrkt.finandmrktwaitlisted.add(clickeddm);
        } else if (wsp.equals("Market and Hr")&& ! Mrktandhr.mrktandhrwaitlisted.contains(clickeddm)) {
            Mrktandhr.mrktandhrwaitlisted.add(clickeddm);
        } else if(wsp.equals("Market and scm")&& !Mrktandscm.mrktandscmwaitlisted.contains(clickeddm)){
            Mrktandscm.mrktandscmwaitlisted.add(clickeddm);}
        ImageView i = (ImageView) findViewById(R.id.waitlistbutton);
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.waitlistblue);
        i.setImageBitmap(largeIcon);
        Toast.makeText(this, clickeddm.getName() + " has been waitlisted", Toast.LENGTH_SHORT).show();
    }else {
        j=false;
        wsp = clickeddm.getSpecialization();
        if (wsp.equals("Finance and Hr")) {
            Finandhr.finandhrwaitlisted.remove(clickeddm);
        } else if (wsp.equals("Finance and scm")) {
            Finandscm.finandscmwaitlisted.remove(clickeddm);
        } else if (wsp.equals("Finance and Market")) {
            Finandmrkt.finandmrktwaitlisted.remove(clickeddm);
        } else if (wsp.equals("Market and Hr")) {
            Mrktandhr.mrktandhrwaitlisted.remove(clickeddm);
        } else {
            Mrktandscm.mrktandscmwaitlisted.remove(clickeddm);
        } ImageView i=(ImageView)findViewById(R.id.waitlistbutton);
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.waitlistgrey);
        i.setImageBitmap(largeIcon);Toast.makeText(this,clickeddm.getName()+" has been Removed from waitlist", Toast.LENGTH_SHORT).show();
    }
    }
    public  void youtubelink(View view) {
        ImageView i = (ImageView) findViewById(R.id.youtubebutton);
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.youtubered);
        i.setImageBitmap(largeIcon);
        videoId=clickeddm.getYoutubepage();
        String videoId1=getYoutubeVideoId(videoId);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId1));
        intent.putExtra("VIDEO_ID", videoId1);
        startActivity(intent);
        new CountDownTimer(2000, 1000) {
            public void onFinish() {
                ImageView i = (ImageView) findViewById(R.id.youtubebutton);
                Bitmap largeIcon1 = BitmapFactory.decodeResource(getResources(), R.drawable.youtubegrey);
                i.setImageBitmap(largeIcon1);
            }
            public void onTick(long millisUntilFinished) {
            }
        }.start();
    }
    public static String getYoutubeVideoId(String youtubeUrl)
    {
        String video_id="";
        if (youtubeUrl != null && youtubeUrl.trim().length() > 0 && youtubeUrl.startsWith("http"))
        {

            String expression = "^.*((youtu.be"+ "\\/)" + "|(v\\/)|(\\/u\\/w\\/)|(embed\\/)|(watch\\?))\\??v?=?([^#\\&\\?]*).*"; // var regExp = /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\?))\??v?=?([^#\&\?]*).*/;
            CharSequence input = youtubeUrl;
            Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches())
            {
                String groupIndex1 = matcher.group(7);
                if(groupIndex1!=null && groupIndex1.length()==11)
                    video_id = groupIndex1;
            }
        }
        return video_id;
    }
    public static Bitmap decodeFromFirebaseBase64(String image) throws IOException {
        byte[] decodedByteArray = android.util.Base64.decode(image, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedByteArray,0, decodedByteArray.length);
    }

}

