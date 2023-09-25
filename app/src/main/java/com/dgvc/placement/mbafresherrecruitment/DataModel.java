package com.dgvc.placement.mbafresherrecruitment;

/**
 * Created by NIKILSELVARAJ on 15/07/17.
 */

public class DataModel {

    public String Objectivex,name1x, specializationx, collegex, Expectedyearx, ugspecializationx, ugcollegex, ugyearofpassingx;
    public String emailx,mobilex;
    public int percentagex,ugpercentagex;
    public String hsnamex,hsyearofpassingx,hspercentagex,ssnamex,ssyearofpassingx,sspercentagex;
    public String computerskillsx,experiencex,internshipsx,achievementsx,ecactivitiesx;
    public String Linkedinidx,youtubepagex,blogx,imgdecodedstringx,keyx;

    public DataModel(String specialization,String college,String Expectedyear,  int percentage, String ugspecialization, String ugcollege, String ugyearofpassing, int ugpercentage, String email, String mobile, String hsname, String hsyearofpassing, String hspercentage, String ssname, String ssyearofpassing, String sspercentage, String computerskills, String experience, String internships, String achievements, String ecactivities, String linkedinid,String youtubepage,String blog, String objective, String name1,String imgdecodestring,String key) {
        this.imgdecodedstringx=imgdecodestring;
        this.Objectivex=objective;
        this.name1x=name1;
        this.specializationx=specialization;
        this.collegex=college;
        this.Expectedyearx=Expectedyear;
        this.percentagex=percentage;
        this.ugspecializationx= ugspecialization;
        this.ugcollegex=ugcollege;
        this.ugyearofpassingx=ugyearofpassing;
        this.ugpercentagex=ugpercentage;
        this.emailx= email;
        this.mobilex=mobile;
        this.hsnamex=hsname;
        this.hsyearofpassingx=hsyearofpassing;
        this.hspercentagex=hspercentage;
        this.ssnamex=ssname;
        this.ssyearofpassingx=ssyearofpassing;
        this.sspercentagex=sspercentage;
        this.computerskillsx=computerskills;
        this.experiencex= experience;
        this.internshipsx=internships;
        this.achievementsx=achievements;
        this.ecactivitiesx=ecactivities;
        this.Linkedinidx=linkedinid;
        this.youtubepagex=youtubepage;
        this.blogx=blog;
        keyx=key;
    }
    public String getName() {return name1x;}
    public String getType() {return emailx;}
    public String getKey() {return keyx;}
    public String getImgdecodestring(){return imgdecodedstringx;}
    public String getCollege(){return collegex;}
    public String getSpecialization(){return specializationx;}
    public String getObjective(){return Objectivex;}
    public String getExpectedyear(){return Expectedyearx;}
    public  String getPercentagex(){return (String.valueOf(percentagex));}
    public String getUgspecialization(){return ugspecializationx;}
    public String getUgcollege(){return ugcollegex;}
    public String getUgyearofpassing(){return ugyearofpassingx;}
    public String getUgpercentagex(){return  (String.valueOf(ugpercentagex));}
    public String getHsname(){return hsnamex;}
    public String getHsyearofpassing(){return hsyearofpassingx;}
    public String getHspercentage(){return hspercentagex;}
    public String getSsname(){return ssnamex;}
    public String getSsyearofpassing(){return ssyearofpassingx;}
    public String getSspercentage(){return sspercentagex;}
    public String getMobile(){return mobilex;}
    public String getComputerskills(){return computerskillsx;}
    public String getExperiencex(){return experiencex;}
    public String getInternships(){return internshipsx;}
    public String getEcactivities(){return ecactivitiesx;}
    public String getAchievements(){return achievementsx;}
    public String getYoutubepage(){return youtubepagex;}
    public String getLinkedinid(){return Linkedinidx;}
    public String getBlog(){return blogx;}


}