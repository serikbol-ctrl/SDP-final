package com.school;


import com.school.facade.SchoolFacade;
import com.school.strategy.AverageGradeStrategy;
import com.school.strategy.GradeStrategy;
import com.school.strategy.WeightedGradeStrategy;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public final class Main {

    private static final Scanner IN = new Scanner(System.in);
    private static final SchoolFacade SCHOOL = new SchoolFacade();

    private static String ask(String label) {
        System.out.print(label + ": ");
        return IN.nextLine().trim();
    }

    private static List<String> modules(String raw) {
        if (raw.isBlank()) {
            return List.of();
        }

        return Arrays.stream(raw.split(","))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .toList();
    }

    private static void printMenu() {
        System.out.println("==========================================");
        System.out.println("        SCHOOL MANAGEMENT SYSTEM");
        System.out.println("==========================================");
        System.out.println("  1. Add Student");
        System.out.println("  2. Add Teacher");
        System.out.println("  3. Create Course");
        System.out.println("  4. Enroll Student");
        System.out.println("  5. Assign Grade");
        System.out.println("  6. Calculate Final Grade");
        System.out.println("  7. View Notifications");
        System.out.println("  8. Grant Admin");
        System.out.println("  9. List Users / Courses");
        System.out.println("  0. Exit");
        System.out.println("==========================================");
    }

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String choice = ask("Choice");

            try {
                switch (choice) {
                    case "1" -> {
                        System.out.println(SCHOOL.registerStudent(ask("Student ID"), ask("Name")));
                    }
                    case "2" -> {
                        System.out.println(SCHOOL.registerTeacher(ask("Teacher ID"), ask("Name")));
                    }
                    case "3" -> {
                        String id = ask("Course ID");
                        String title = ask("Title");
                        String teacher = ask("Teacher ID");
                        List<String> courseModules = modules(ask("Modules (comma separated)"));
                        System.out.println(SCHOOL.createCourse(id, title, teacher, courseModules));
                    }
                    case "4" -> {
                        String studentId = ask("Student ID");
                        String courseId = ask("Course ID");
                        SCHOOL.enroll(studentId, courseId);
                        System.out.println("Enrollment successful");
                    }
                    case "5" -> {
                        String teacherId = ask("Teacher ID");
                        String studentId = ask("Student ID");
                        String courseId = ask("Course ID");
                        double grade = Double.parseDouble(ask("Grade 0..100"));
                        SCHOOL.assignGrade(teacherId, studentId, courseId, grade);
                        System.out.println("Grade assigned; notification created");
                    }
                    case "6" -> {
                        String studentId = ask("Student ID");
                        String courseId = ask("Course ID");
                        String algorithm = ask("Algorithm (1 average, 2 weighted)");
                        GradeStrategy strategy;

                        if (algorithm.equals("1")) {
                            strategy = new AverageGradeStrategy();
                        } else if (algorithm.equals("2")) {
                            strategy = new WeightedGradeStrategy();
                        } else {
                            System.out.println("Invalid algorithm");
                            break;
                        }

                        double result = SCHOOL.finalGrade(studentId, courseId, strategy);
                        System.out.printf(Locale.US, "%s: %.2f%n", strategy.name(), result);
                    }
                    case "7" -> {
                        String studentId = ask("Student ID");
                        List<String> messages = SCHOOL.notifications(studentId);
                        if (messages.isEmpty()) {
                            System.out.println("No notifications");
                        } else {
                            messages.forEach(System.out::println);
                        }
                    }
                    case "8" -> {
                        String userId = ask("User ID");
                        SCHOOL.grantAdmin(userId);
                        System.out.println("Permissions: " + SCHOOL.permissionFor(userId).actions());
                    }
                    case "9" -> {
                        System.out.println("Users:");
                        SCHOOL.users().forEach(System.out::println);
                        System.out.println("Courses:");
                        SCHOOL.courses().forEach(System.out::println);
                    }
                    case "0" -> {
                        System.out.println("Goodbye");
                        return;
                    }
                    default -> System.out.println("Unknown choice");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}
