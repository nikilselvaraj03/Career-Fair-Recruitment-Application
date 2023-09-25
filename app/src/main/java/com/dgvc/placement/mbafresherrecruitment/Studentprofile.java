package com.dgvc.placement.mbafresherrecruitment;
/**
 * Created by NIKILSELVARAJ on 16/07/17.
 */

public class Studentprofile {
    public String Objective,name1, specialization, college, Expectedyear, percentage, ugspecialization, ugcollege, ugyearofpassing, ugpercentage;
    public String email,mobile;
    public String hsname,hsyearofpassing,hspercentage,ssname,ssyearofpassing,sspercentage;
    public String computerskills,experience,internships,achievements,ecactivities;
    public String Linkedinid,youtubepage,blog,imgdecodedstring;
    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)


    public  Studentprofile( String specialization,String college,String Expectedyear,  String percentage, String ugspecialization, String ugcollege, String ugyearofpassing, String ugpercentage, String email, String mobile, String hsname, String hsyearofpassing, String hspercentage, String ssname, String ssyearofpassing, String sspercentage, String computerskills, String experience, String internships, String achievements, String ecactivities, String linkedinid,String youtubepage,String blog, String objective, String name1,String imgdecodestring)
    {
        this.imgdecodedstring=imgdecodestring;
        this.Objective=objective;
        this.name1=name1;
        this.specialization=specialization;
        this.college=college;
        this.Expectedyear=Expectedyear;
        this.percentage=percentage;
        this.ugspecialization= ugspecialization;
        this.ugcollege=ugcollege;
        this.ugyearofpassing=ugyearofpassing;
        this.ugpercentage=ugpercentage;
        this.email= email;
        this.mobile=mobile;
        this.hsname=hsname;
        this.hsyearofpassing=hsyearofpassing;
        this.hspercentage=hspercentage;
        this.ssname=ssname;
        this.ssyearofpassing=ssyearofpassing;
        this.sspercentage=sspercentage;
        this.computerskills=computerskills;
        this.experience= experience;
        this.internships=internships;
        this.achievements=achievements;
        this.ecactivities=ecactivities;
        this.Linkedinid=linkedinid;
        this.youtubepage=youtubepage;
        this.blog=blog;

    }



}
