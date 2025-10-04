package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n--- School Directory ---");
        for (Person p : people) {
            p.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School Administration & Attendance System ---");

        // --- Students ---
        List<Student> students = new ArrayList<>();
        Student s1 = new Student("Alice Wonderland", "Grade 10");
        Student s2 = new Student("Bob The Builder", "Grade 9");
        students.add(s1);
        students.add(s2);

        // --- Teachers ---
        Teacher t1 = new Teacher("Dr. Strange", "Quantum Physics");
        Teacher t2 = new Teacher("Prof. Turing", "Algorithms");

        // --- Staff ---
        Staff st1 = new Staff("Mr. John Doe", "Librarian");
        Staff st2 = new Staff("Mrs. Smith", "Administrator");

        // --- Courses ---
        List<Course> courses = new ArrayList<>();
        Course c1 = new Course("Intro to Quantum Physics");
        Course c2 = new Course("Advanced Algorithms");
        courses.add(c1);
        courses.add(c2);

        // --- School People Directory ---
        List<Person> schoolPeople = new ArrayList<>();
        schoolPeople.addAll(students);
        schoolPeople.add(t1);
        schoolPeople.add(t2);
        schoolPeople.add(st1);
        schoolPeople.add(st2);

        displaySchoolDirectory(schoolPeople);

        // --- Attendance Log ---
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(s1, c1, "Present"));
        attendanceLog.add(new AttendanceRecord(s2, c1, "Absent"));
        attendanceLog.add(new AttendanceRecord(s1, c2, "Present"));

        System.out.println("\n--- Attendance Log ---");
        for (AttendanceRecord ar : attendanceLog) {
            ar.displayRecord();
        }

        // --- Saving Data ---
        System.out.println("\n--- Saving Data to Files ---");
        FileStorageService storageService = new FileStorageService();

        // Save only students (filter from schoolPeople if needed)
        storageService.saveData(students, "students.txt");
        storageService.saveData(courses, "courses.txt");
        storageService.saveData(attendanceLog, "attendance_log.txt");

        System.out.println("\nSession 7: Polymorphism & Directory + Attendance Complete.");
        System.out.println("Check students.txt, courses.txt, and attendance_log.txt for output.");
    }
}
