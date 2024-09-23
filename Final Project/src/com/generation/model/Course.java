package com.generation.model;

public class Course
{

    //Course Attributes
    String coursename;        //Course name  "Intro to XXXYY"
    String courseid;          //id "INTRO-CS-2"
    int coursecredits;        //Credit associated with course "9" int


    //Generate Constructor instance

    public Course(String coursename, String courseid, int coursecredits) {
        this.coursename = coursename;
        this.courseid = courseid;
        this.coursecredits = coursecredits;
    }
    
    //Generate Getters and Setters


    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public int getCoursecredits() {
        return coursecredits;
    }

    public void setCoursecredits(int coursecredits) {
        this.coursecredits = coursecredits;
    }

    public String getId() {
        return null;
    }
}
