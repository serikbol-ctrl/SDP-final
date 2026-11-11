package com.school;

import com.school.builder.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {
    @Test
    void buildsCourse() {
        var c=new CourseBuilder().id("c1").title("Math").teacherId("t1").addModule("Algebra").build();
        assertEquals("Math", c.getTitle());
        assertEquals(1, c.getModules().size());
        assertThrows(UnsupportedOperationException.class, () -> c.getModules().add("Geometry"));
    }
}
