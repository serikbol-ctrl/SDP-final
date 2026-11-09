package com.school.decorator;
import java.util.*;
public final class TeacherPermissionDecorator extends PermissionDecorator {
 public TeacherPermissionDecorator(Permission delegate){super(delegate);}
 public Set<String> actions(){Set<String> actions=new HashSet<>(delegate.actions());actions.add("ASSIGN_GRADE");return Set.copyOf(actions);}
}
