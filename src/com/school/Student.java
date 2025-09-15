package com.school;

public class Student extends Person implements Storable { // Implements Storable
    private String gradeLevel;

    public Student(String name, String gradeLevel) {
        super(name);
        this.gradeLevel = gradeLevel;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(", Grade Level: " + gradeLevel + " (Role: Student)");
    }

    @Override
    public String toDataString() {
        // Format: id,name,gradeLevel
        return getId() + "," + getName() + "," + gradeLevel;
    }
}