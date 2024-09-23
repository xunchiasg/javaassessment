package com.generation.service;

//Java Assessment - Student Service//

//Import Course and Student Only for Assignment
import com.generation.model.Course;
import com.generation.model.Student;

import java.util.*;

public class StudentService {
    private static final Map<String, Student> students = new HashMap<>();

    // Hashmap for students (first name, last name, id, email, birthdate / printer-helper
    public StudentService() {
        subscribeStudent(new Student("Adrian", "Tan", "Adriantan@gmail.com", new Date(2001 - 1900, Calendar.JANUARY, 17), 3, "stu001"));
        subscribeStudent(new Student("Goh", "Hui Xin", "gohhuixin@hotmail.com", new Date(2002 - 1900, Calendar.SEPTEMBER, 4), 2, "stu002"));
        subscribeStudent(new Student("Alex", "Lim", "Adriantan@gmail.com", new Date(2003 - 1900, Calendar.MAY, 30), 1, "stu003"));
    }

    // Subscribe student
    public void subscribeStudent(Student student) {
        students.put(student.getId(), student);
    }

    // Method to find student by ID
    public static Student findStudent(String studentId) {
        return students.get(studentId); // Returns null if not found
    }

    // Method to determine if student is subscribed to a course
    public boolean isSubscribed(String studentId) {
        Student student = findStudent(studentId);
        if (student != null) {
            return !student.getEnrolledCourses().isEmpty(); // Check if the student is enrolled
        }
        System.out.println("Student not found");
        return false; // Student is not found
    }

    // Show summary of students and their courses
    public void showSummary() {
        System.out.println("Students and the courses enrolled into:");

        for (Student student : students.values()) {
            student.printFullName();
            List<Course> courses = student.getApprovedCourses();

            if (courses.isEmpty()) {
                System.out.println("\t\tNo courses found");
            } else {
                for (Course course : courses) {
                    System.out.println("\t\t" + course);
                }
            }
        }
    }

    // Method to enroll a student in a course
    public void enrollToCourse(String studentId, Course course) {
        Student student = findStudent(studentId);
        if (student != null) {
            student.enrollToCourse(course);
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }
}