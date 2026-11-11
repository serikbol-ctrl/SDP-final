package com.school.observer;

import java.util.*;

public final class StudentNotificationObserver implements GradeObserver {
    private final Map<String, List<String>> messages=new HashMap<>();
    public void onGradeAssigned(String studentId, String courseId, double grade) {
        messages.computeIfAbsent(studentId, k->new ArrayList<>()).add("New grade " +grade+" in course "+courseId);
    }

    public List<String> messagesFor(String studentId) {
        return List.copyOf(messages.getOrDefault(studentId, List.of()));
    }
}
