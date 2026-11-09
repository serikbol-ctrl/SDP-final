package com.school.decorator;
import java.util.Set;
public final class BasicPermission implements Permission {public Set<String> actions(){return Set.of("VIEW_COURSES");}}
