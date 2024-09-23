package com.generation.utils;

//Java Assessment - PrinterHelper//


//Imports

import com.generation.model.Student;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;                          //Java8
import java.util.Scanner;


//PrinterHelper
public class PrinterHelper
{

    public static void showMainMenu(){
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Welcome to StudentGen         |" );
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Select 1 option:              |" );
        System.out.println( "| . 1 Register Student          |" );
        System.out.println( "| . 2 Find Student              |" );
        System.out.println( "| . 3 Grade Student             |" );
        System.out.println( "| . 4 Enroll Student to Course  |" );
        System.out.println( "| . 5 Show Students Summary     |" );
        System.out.println( "| . 6 Show Courses Summary      |" );
        System.out.println( "| . 7 Exit                      |" );
        System.out.println( "|-------------------------------|" );
    }

    public static Student createStudentMenu( Scanner scanner )
        throws ParseException
    {
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| . 1 Register Student                |" );
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| Enter first name:                   |" );        //Add: First name
        String firstname = scanner.next();
        System.out.println( "| Enter last name:                    |" );        //Add: Last name
        String lastname = scanner.next();
        System.out.println( "| Enter student ID:                   |" );
        String id = scanner.next();
        System.out.println( "| Enter student email:                |" );
        String email = scanner.next();
        System.out.println( "| Enter student birth date(mm/dd/yyyy)|" );
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT);;  // SimpleDateFormat to DateFormat
        //TODO validate date format and catch exception to avoid crash
        Date birthDate = formatter.parse( scanner.next());
        System.out.println( "|-------------------------------------|" );
        Student student = new Student( firstname, lastname, email, birthDate, 1, "stu001"); //Modified printout//TODO error within constructor in student java
        System.out.println( "Student Successfully Registered! " );
        System.out.println(student);
        return student;
    }

}

