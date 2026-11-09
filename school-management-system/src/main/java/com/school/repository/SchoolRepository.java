package com.school.repository;
import com.school.model.*;import java.util.*;
public final class SchoolRepository {
 private final Map<String,User> users=new LinkedHashMap<>();private final Map<String,Course> courses=new LinkedHashMap<>();
 private final Map<String,Set<String>> enrollments=new HashMap<>();private final Map<String,List<Double>> grades=new HashMap<>();
 private String key(String studentId,String courseId){return studentId+"::"+courseId;}
 public void addUser(User user){if(users.putIfAbsent(user.getId(),user)!=null)throw new IllegalArgumentException("Duplicate user ID");}
 public User user(String id){User u=users.get(id);if(u==null)throw new IllegalArgumentException("Unknown user: "+id);return u;}
 public Collection<User> users(){return List.copyOf(users.values());}
 public void addCourse(Course course){if(courses.putIfAbsent(course.getId(),course)!=null)throw new IllegalArgumentException("Duplicate course ID");}
 public Course course(String id){Course c=courses.get(id);if(c==null)throw new IllegalArgumentException("Unknown course: "+id);return c;}
 public Collection<Course> courses(){return List.copyOf(courses.values());}
 public void enroll(String studentId,String courseId){enrollments.computeIfAbsent(courseId,k->new HashSet<>()).add(studentId);}
 public boolean enrolled(String studentId,String courseId){return enrollments.getOrDefault(courseId,Set.of()).contains(studentId);}
 public void addGrade(String studentId,String courseId,double grade){grades.computeIfAbsent(key(studentId,courseId),k->new ArrayList<>()).add(grade);}
 public List<Double> grades(String studentId,String courseId){return List.copyOf(grades.getOrDefault(key(studentId,courseId),List.of()));}
}
