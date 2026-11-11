package com.school.observer;

import java.util.*;

public final class GradePublisher {
    private final List<GradeObserver> observers=new ArrayList<>();
    public void subscribe(GradeObserver observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    public void unsubscribe(GradeObserver observer) {
        observers.remove(observer);
    }

    public void publish(String studentId, String courseId, double grade) {
        for (GradeObserver observer:List.copyOf(observers)) {
            observer.onGradeAssigned(studentId, courseId, grade);
        }
    }
}
