package com.school;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the School Attendance System Project!");
        System.out.println("Session 1: Project Setup and Orientation Complete.");

        Student[] students = new Student[2];
        Course[] courses = new Course[2];

        students[0] = new Student();
        students[0].setDetails(1, "Mayank");

        students[1] = new Student();
        students[1].setDetails(2, "Avinash");

        courses[0] = new Course();
        courses[0].setDetails(101, "Mathematics");

        courses[1] = new Course();
        courses[1].setDetails(102, "Physics");

        System.out.println("Students");
        for (Student student : students) {
            student.displayDetails();
        }
        System.out.println("Courses");
        for (Course course : courses) {
            course.displayDetails();
        }
    }
}