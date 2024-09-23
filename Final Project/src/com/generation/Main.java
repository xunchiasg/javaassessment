package com.generation;

//Java Assessment - MAIN//


//Imports
import com.generation.model.Course;
import com.generation.model.Student;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import com.generation.utils.PrinterHelper;

import java.text.ParseException;
import java.util.Scanner;


//Printout Main
public class Main

{

    public static void main( String[] args )
        throws ParseException
    {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        Scanner scanner = new Scanner( System.in );
        int option = 0;
        do
        {
            PrinterHelper.showMainMenu();
            option = scanner.nextInt();
            switch ( option )
            {
                case 1:
                    registerStudent( studentService, scanner );     //Register
                    break;
                case 2:
                    findStudent( studentService, scanner );         //Find
                    break;
                case 3:
                    gradeStudent( studentService, scanner );        //Grade
                    break;
                case 4:
                    enrollStudentToCourse( studentService, courseService, scanner );        //Enroll
                    break;
                case 5:
                    showStudentsSummary( studentService, scanner );         //Students
                    break;
                case 6:
                    showCoursesSummary( courseService, scanner );           //Courses
                    break;
            }
        }
        while ( option != 7 );
    }

    //Methods (Enrollment)
    private static void enrollStudentToCourse( StudentService studentService, CourseService courseService,
                                               Scanner scanner )
    {
        System.out.println( "Insert student ID" );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Invalid Student ID" );
            return;
        }
        System.out.println( student );
        System.out.println( "Insert course ID" );
        String courseId = scanner.next();
        Course course = courseService.getCourse( courseId );
        if ( course == null )
        {
            System.out.println( "Invalid Course ID" );
            return;
        }
        System.out.println( course );
        courseService.enrollStudent( courseId, student );
        studentService.enrollToCourse( studentId, course );
        System.out.println( "Student with ID: " + studentId + " enrolled successfully to " + courseId );

    }


    //Methods (Courses, Students, Grade, Find)
    private static void showCoursesSummary( CourseService courseService, Scanner scanner )
    {
        courseService.showSummary();
    }

    private static void showStudentsSummary( StudentService studentService, Scanner scanner )
    {
        studentService.showSummary();
    }

    //TODO show summary of student grades
    private static void gradeStudent(StudentService studentService, Scanner scanner) {
        System.out.println("Enter student ID: ");
        String studentId = scanner.next();
        Student student = studentService.findStudent(studentId);

        if (student == null) {
            System.out.println("Student with ID: " + studentId + " not found.");
            return;
        }

        System.out.println("Student Found: " + student);
        if (student.getEnrolledCourses().isEmpty()) {
            System.out.println("This student is not enrolled in any courses.");
            return;
        }

        System.out.println("Courses the student is enrolled in:");
        for (Course course : student.getEnrolledCourses()) {
            System.out.println(course);
        }

        System.out.println("Enter the course ID to grade: ");
        String courseId = scanner.next();
        Course course = student.getEnrolledCourse(courseId);

        if (course == null) {
            System.out.println("Student is not enrolled in the course with ID: " + courseId);
            return;
        }

        System.out.println("Enter grade for the course (0-100): ");
        double grade = scanner.nextDouble();

        if (grade < 0 || grade > 100) {
            System.out.println("Please enter a value between 0 and 100.");
            return;
        }

        student.setGrade(courseId, grade);
        System.out.println("Grade " + grade + " has been assigned to course " + courseId + " for student " + studentId);
    }

    //Method (Find Student)
    private static void findStudent( StudentService studentService, Scanner scanner )
    {
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student != null )
        {
            System.out.println( "Student Found: " );
            System.out.println( student );
        }
        else
        {
            System.out.println( "Student with Id = " + studentId + " not found" );
        }
    }

    //Method (Register Student)
    private static void registerStudent( StudentService studentService, Scanner scanner )
        throws ParseException
    {
        Student student = PrinterHelper.createStudentMenu( scanner );
        studentService.subscribeStudent( student );
    }
}
