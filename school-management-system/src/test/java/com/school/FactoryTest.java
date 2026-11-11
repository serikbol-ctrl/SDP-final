package com.school;

import com.school.factory.*;
import com.school.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {
    @Test
    void createsCorrectTypes() {
        UserFactory f=new UserFactory();
        assertInstanceOf(Student.class, f.create(UserFactory.Type.STUDENT, "s1", "Alice"));
        assertInstanceOf(Teacher.class, f.create(UserFactory.Type.TEACHER, "t1", "Bob"));
    }
}
