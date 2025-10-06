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
        System.out.println("--- School Administration & Attendance System (Part 8) ---");

        // --- Setup FileStorage & AttendanceService ---
        FileStorageService storageService = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storageService);

        // --- Create Students ---
        List<Student> allStudents = new ArrayList<>();
        Student s1 = new Student("Alice Wonderland", "Grade 10");
        Student s2 = new Student("Bob The Builder", "Grade 9");
        allStudents.add(s1);
        allStudents.add(s2);

        // --- Create Courses ---
        List<Course> allCourses = new ArrayList<>();
        Course c1 = new Course("Intro to Quantum Physics");
        Course c2 = new Course("Advanced Algorithms");
        allCourses.add(c1);
        allCourses.add(c2);

        // --- Create Teachers & Staff ---
        Teacher t1 = new Teacher("Dr. Strange", "Quantum Physics");
        Teacher t2 = new Teacher("Prof. Turing", "Algorithms");
        Staff st1 = new Staff("Mr. John Doe", "Librarian");
        Staff st2 = new Staff("Mrs. Smith", "Administrator");

        // --- Combine People for Directory ---
        List<Person> schoolPeople = new ArrayList<>();
        schoolPeople.addAll(allStudents);
        schoolPeople.add(t1);
        schoolPeople.add(t2);
        schoolPeople.add(st1);
        schoolPeople.add(st2);

        displaySchoolDirectory(schoolPeople);

        // --- Mark Attendance (using both overloads) ---
        attendanceService.markAttendance(s1, c1, "Present");
        attendanceService.markAttendance(s2, c1, "Absent");
        attendanceService.markAttendance(s1, c2, "Present");

        // Using overloaded method with IDs:
        attendanceService.markAttendance(s2.getId(), c2.getCourseId(), "Present", allStudents, allCourses);

        // --- Display full log ---
        attendanceService.displayAttendanceLog();

        // --- Display filtered logs ---
        attendanceService.displayAttendanceLog(s1);
        attendanceService.displayAttendanceLog(c1);

        // --- Save Data ---
        System.out.println("\n--- Saving Data to Files ---");
        storageService.saveData(allStudents, "students.txt");
        storageService.saveData(allCourses, "courses.txt");
        attendanceService.saveAttendanceData();

        System.out.println("\nSession 8: Attendance Service Integration Complete.");
        System.out.println("Check attendance_log.txt for updated data.");
    }
}
