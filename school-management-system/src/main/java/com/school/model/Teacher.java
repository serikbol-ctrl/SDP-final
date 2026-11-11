package com.school.model;

public final class Teacher extends User {
    public Teacher(String id, String name) {
        super(id, name);
    }

    public String getRole() {
        return "TEACHER";
    }
}
