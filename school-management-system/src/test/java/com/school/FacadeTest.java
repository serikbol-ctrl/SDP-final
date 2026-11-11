package com.school;

import com.school.facade.*;
import com.school.strategy.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {
    @Test
    void completeWorkflow() {
        var school=new SchoolFacade();
        school.registerStudent("s1", "Alice");
        school.registerTeacher("t1", "Bob");
        school.createCourse("c1", "Math", "t1", List.of("Algebra"));
        school.enroll("s1", "c1");
        school.assignGrade("t1", "s1", "c1", 80);
        school.assignGrade("t1", "s1", "c1", 100);
        assertEquals(90, school.finalGrade("s1", "c1", new AverageGradeStrategy()), 0.001);
        assertEquals(2, school.notifications("s1").size());
        assertThrows(IllegalArgumentException.class, () -> school.assignGrade("t1", "s1", "c1", 110));
        school.grantAdmin("t1");
        assertTrue(school.permissionFor("t1").allows("MANAGE_USERS"));
    }
}
