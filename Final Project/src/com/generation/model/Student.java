package com.generation.model;

import java.util.*;


//TODO 1: Set Attributes for Student class
//TODO 2: Arraylist for students
//TODO 2: Add Getters and Setters
//TODO 4: Add the following methods (per assignment)
//Per PrinterHelper
public class Student {

    //Student Attributes
    String firstname;       //first name
    String lastname;        //last name
    String email;           //email
    Date birthDate;         //DOB
    int grade;             //Grade
    String id;              //id

    //Array and Hashmap
    ArrayList<Course> enrolledCourses = new ArrayList<>();          // student's enrolled courses

    Map<String, Course> approvedCourses = new HashMap<>();          // approved courses taken by the student

    //Create a constructor for instance of one student

    public Student(String firstname, String lastname, String email, Date birthDate, int i, String stu001) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.birthDate = birthDate;
        this.grade = grade;
        this.id = id;
    }

    //Create Getters and Setters

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    //*********************************//

    //TODO Implement Methods for enrolToCourse,isApproved,isAttending Course, override if

    //TODO implement this method
    //TODO 1. if the course is not found in the Hashmap approvedCourses
    //TODO 2. put it to the student's approved courses
    //Check if a student is enrolled in a course
    public boolean enrollToCourse(Course course) {
        if (!approvedCourses.containsKey(course.getId())) //Not found
            approvedCourses.put(course.getId(), course);    //put it to student approved course
        return enrolledCourses.add(course);
    }

    public boolean unEnrolCourse (Course course){
        return enrolledCourses.remove(course);
    }

    public int totalEnrolledCourses(){
        return enrolledCourses.size();
    }

    //TODO Check if the course is approved

    public boolean isApproved(String coursename) {
        if (approvedCourses.containsKey(coursename)) {
            return true; // course in list, proceed
        } else {
            System.out.println("Course is not in approved list");
            return false;
        }
    }

    public ArrayList<Course> getEnrolledCourses() {return enrolledCourses;}

    //TODO return true if the student is attending the course by courseID
    //TODO use enrolledCourses to determine if student is attending
    public boolean isAttendingCourse(String courseId){
        boolean result = false;

        Course course = approvedCourses.get(courseId);

        for (int i = 0; i < enrolledCourses.size(); i++) {
            if (course == enrolledCourses.get(i)) {
            result = true;
        }
        return result;
    }
        return result;
    }

    public void printFullName() {
        System.out.println(firstname + " " + lastname);
    }

@Override
public String toString() {
    return "Student{'" +
            "firstName':'" +
            firstname + "', '" +
            "lastName':'" +
            lastname + "', '" +
            "grade':" +
            grade + ", '" +
            "email':" +
            email + ", '" +
            "birth date':" +
            birthDate + "', '" +
            "id':'" +
            id + "'}";
    }


//Unable to add @Override
    public List<Course> getApprovedCourses() {
        ArrayList<Course> approvedCourses = new ArrayList<>();

        boolean status = approvedCourses.addAll(this.getApprovedCourses());

        // if the list was modified successfully
        if (!status) {
            return null;
        }

        return approvedCourses;
    }

    public Course getEnrolledCourse(String courseId) {
        return null;
    }

    public void setGrade(String courseId, double grade) {

    }
}







