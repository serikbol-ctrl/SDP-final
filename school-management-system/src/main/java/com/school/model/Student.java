package com.school.model;

public final class Student extends User {
    public Student(String id, String name) {
        super(id, name);
    }

    public String getRole() {
        return "STUDENT";
    }
}
