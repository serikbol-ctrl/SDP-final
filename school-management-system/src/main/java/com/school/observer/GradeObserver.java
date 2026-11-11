package com.school.observer;

public interface GradeObserver {
    void onGradeAssigned(String studentId, String courseId, double grade);
}
