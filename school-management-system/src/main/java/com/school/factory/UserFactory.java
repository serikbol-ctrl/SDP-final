package com.school.factory;
import com.school.model.*;
public final class UserFactory {
 public enum Type {STUDENT,TEACHER}
 public User create(Type type,String id,String name){if(type==null)throw new IllegalArgumentException("Type required");return switch(type){case STUDENT->new Student(id,name);case TEACHER->new Teacher(id,name);};}
}
