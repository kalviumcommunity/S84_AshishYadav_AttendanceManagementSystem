package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    // Constructor
    public AttendanceService(FileStorageService storageService) {
        this.storageService = storageService;
        this.attendanceLog = new ArrayList<>();
    }

    // --- 1. Mark attendance using Student & Course objects ---
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
        System.out.println("Attendance marked for " + student.getName() + " in " + course.getCourseName());
    }

    // --- 2. Mark attendance using IDs (lookup first) ---
    public void markAttendance(int studentId, int courseId, String status,
                               List<Student> allStudents, List<Course> allCourses) {
        Student foundStudent = findStudentById(studentId, allStudents);
        Course foundCourse = findCourseById(courseId, allCourses);

        if (foundStudent != null && foundCourse != null) {
            markAttendance(foundStudent, foundCourse, status);
        } else {
            System.out.println("Error: Could not find matching Student or Course for given IDs.");
        }
    }

    // --- Helper lookups ---
    private Student findStudentById(int id, List<Student> students) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    private Course findCourseById(int id, List<Course> courses) {
        for (Course c : courses) {
            if (c.getCourseId() == id) return c;
        }
        return null;
    }

    // --- Display all attendance records ---
    public void displayAttendanceLog() {
        System.out.println("\n--- Full Attendance Log ---");
        for (AttendanceRecord ar : attendanceLog) {
            ar.displayRecord();
        }
    }

    // --- Display attendance filtered by student ---
    public void displayAttendanceLog(Student student) {
        System.out.println("\n--- Attendance for Student: " + student.getName() + " ---");
        for (AttendanceRecord ar : attendanceLog) {
            if (ar.getStudent().getId() == student.getId()) {
                ar.displayRecord();
            }
        }
    }

    // --- Display attendance filtered by course ---
    public void displayAttendanceLog(Course course) {
        System.out.println("\n--- Attendance for Course: " + course.getCourseName() + " ---");
        for (AttendanceRecord ar : attendanceLog) {
            if (ar.getCourse().getCourseId() == course.getCourseId()) {
                ar.displayRecord();
            }
        }
    }

    // --- Save attendance data ---
    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}
