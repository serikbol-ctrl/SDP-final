package com.school;

import com.school.decorator.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DecoratorTest {
    @Test
    void addsPermissions() {
        Permission p=new AdminPermissionDecorator(new TeacherPermissionDecorator(new BasicPermission()));
        assertTrue(p.allows("VIEW_COURSES"));
        assertTrue(p.allows("ASSIGN_GRADE"));
        assertTrue(p.allows("MANAGE_USERS"));
    }
}
