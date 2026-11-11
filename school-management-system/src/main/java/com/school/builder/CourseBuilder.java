package com.school.builder;

import com.school.model.Course;
import java.util.*;

public final class CourseBuilder {
    private String id, title, teacherId;
    private final List<String> modules=new ArrayList<>();
    public CourseBuilder id(String value) {
        id=value;
        return this;
    }

    public CourseBuilder title(String value) {
        title=value;
        return this;
    }

    public CourseBuilder teacherId(String value) {
        teacherId=value;
        return this;
    }

    public CourseBuilder addModule(String value) {
        if (value==null||value.isBlank()) {
            throw new IllegalArgumentException("Module required");
        }
        modules.add(value);
        return this;
    }

    public Course build() {
        return new Course(id, title, teacherId, modules);
    }
}
