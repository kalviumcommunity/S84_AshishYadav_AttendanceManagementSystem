package com.school;

public class AttendanceRecord implements Storable {
    private Student student;
    private Course course;
    private String status;

    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;

        if (!"Present".equalsIgnoreCase(status) && !"Absent".equalsIgnoreCase(status)) {
            this.status = "Invalid";
            System.out.println("Warning: Invalid attendance status provided. Set to 'Invalid'.");
        } else {
            this.status = status;
        }
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public void displayRecord() {
        System.out.println("Attendance: Student " + student.getName() +
                " (ID: " + student.getId() + ") in Course " + course.getCourseName() +
                " (C" + course.getCourseId() + ") - Status: " + status);
    }

    @Override
    public String toDataString() {
        // Format: studentId,courseId,status
        return student.getId() + "," + course.getCourseId() + "," + status;
    }
}
