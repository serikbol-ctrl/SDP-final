package com.school.model;

import java.util.*;

public final class Course {
    private final String id, title, teacherId;
    private final List<String> modules;
    public Course(String id, String title, String teacherId, List<String> modules) {
        if (id==null||id.isBlank() || title==null||title.isBlank() || teacherId==null||teacherId.isBlank()) {
            throw new IllegalArgumentException("Course fields required");
        }
        this.id=id;
        this.title=title;
        this.teacherId=teacherId;
        this.modules=List.copyOf(modules);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public List<String> getModules() {
        return modules;
    }

    public String toString() {
        return id+" | "+title+" | teacher="+teacherId+" | modules="+modules;
    }
}
