package com.generation.service;

//Import Course and Student Only for Assignment
import com.generation.model.Course;
import com.generation.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

//TODO Unit Testing

class StudentServiceTest {

    StudentService studentService = new StudentService();          // private

    @BeforeEach
    void setUp() {
        studentService = new StudentService();      // create a new instance of StudentService before the test is run
    }

    @Test
    void testFindStudent() {
        Student student = StudentService.findStudent("stu01");                                                          // find the student created by StudentService
        assertNotNull(student, "Student should be found");                                                              // Check whether the student exists through assertions to det. we have found the student and details
        assertEquals("Adrian", student.getFirstname(), "Firstname of student should be Adrian");
        assertEquals("Tan", student.getLastname(), "Lastname of student should be Tan" );
        assertEquals("adriantan@gmail.com", student.getEmail(), "email should be adriantan@gmail.com");

    }

    @Test
    void testNotFoundStudent(){
        Student student = studentService.findStudent("stu09");
        assertNull(student, "Student should NOT be found");
    }

    @Test
    void testIsSubscribed() {
        assertTrue(studentService.isSubscribed("stu01"));   // Test that the student exists
        assertFalse(studentService.isSubscribed("stu00"));  // Test that the student does NOT exist
    }

    @Test
    void testIsAttendingCourse(){
        Course courseJava = new Course("Introduction to Java", "INTRO-CS-J", 1);
        Student student = new Student(
                "Tony",
                "Stark",
                "tonystak@gmail.com", Date(),
                1, "stu001");
        student.enrollToCourse(courseJava);
        assertTrue(student.isAttendingCourse("INTRO-CS-J"), "Student should be attend course");
        assertFalse(student.isAttendingCourse("INTRO-CS-X"), "Student should NOT be attending this course");
    }

    private Date Date() {
        return null;
    }

    @Test
    void findStudent() {
    }

    @Test
    void isSubscribed() {
    }
}

