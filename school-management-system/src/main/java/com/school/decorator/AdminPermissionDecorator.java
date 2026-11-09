package com.school.decorator;
import java.util.*;
public final class AdminPermissionDecorator extends PermissionDecorator {
 public AdminPermissionDecorator(Permission delegate){super(delegate);}
 public Set<String> actions(){Set<String> actions=new HashSet<>(delegate.actions());actions.add("MANAGE_USERS");actions.add("MANAGE_COURSES");return Set.copyOf(actions);}
}
