package com.generation.model;

import java.util.ArrayList;
import java.util.HashMap;



class  evaluation {

    private final HashMap<Object, Object> courseGrades;
    private final ArrayList<Object> enrolledCourses;
    private String firstname = "";
    private String lastname = "";
    private String id = "";

    public evaluation(String id, String name) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.courseGrades = new HashMap<>();
    this.enrolledCourses = new ArrayList<>();
}

}
