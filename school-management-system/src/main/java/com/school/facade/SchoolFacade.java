package com.school.facade;
import com.school.model.*;import com.school.factory.*;import com.school.builder.*;import com.school.strategy.*;import com.school.observer.*;import com.school.decorator.*;import com.school.repository.*;import java.util.*;
public final class SchoolFacade {
 private final SchoolRepository repository=new SchoolRepository();private final UserFactory factory=new UserFactory();private final GradePublisher publisher=new GradePublisher();private final StudentNotificationObserver notifications=new StudentNotificationObserver();private final Map<String,Permission> permissions=new HashMap<>();
 public SchoolFacade(){publisher.subscribe(notifications);}
 public User registerStudent(String id,String name){User u=factory.create(UserFactory.Type.STUDENT,id,name);repository.addUser(u);permissions.put(id,new BasicPermission());return u;}
 public User registerTeacher(String id,String name){User u=factory.create(UserFactory.Type.TEACHER,id,name);repository.addUser(u);permissions.put(id,new TeacherPermissionDecorator(new BasicPermission()));return u;}
 public Course createCourse(String id,String title,String teacherId,List<String> modules){if(!(repository.user(teacherId) instanceof Teacher))throw new IllegalArgumentException("Teacher required");CourseBuilder b=new CourseBuilder().id(id).title(title).teacherId(teacherId);for(String m:modules)b.addModule(m);Course c=b.build();repository.addCourse(c);return c;}
 public void enroll(String studentId,String courseId){if(!(repository.user(studentId) instanceof Student))throw new IllegalArgumentException("Student required");repository.course(courseId);repository.enroll(studentId,courseId);}
 public void assignGrade(String teacherId,String studentId,String courseId,double grade){if(!Double.isFinite(grade)||grade<0||grade>100)throw new IllegalArgumentException("Grade must be 0..100");User teacher=repository.user(teacherId);if(!(teacher instanceof Teacher)||!permissionFor(teacherId).allows("ASSIGN_GRADE"))throw new IllegalArgumentException("Permission denied");Course course=repository.course(courseId);if(!course.getTeacherId().equals(teacherId))throw new IllegalArgumentException("Teacher not assigned to course");if(!repository.enrolled(studentId,courseId))throw new IllegalArgumentException("Student not enrolled");repository.addGrade(studentId,courseId,grade);publisher.publish(studentId,courseId,grade);}
 public double finalGrade(String studentId,String courseId,GradeStrategy strategy){repository.user(studentId);repository.course(courseId);return Objects.requireNonNull(strategy).calculate(repository.grades(studentId,courseId));}
 public List<Double> grades(String studentId,String courseId){repository.user(studentId);repository.course(courseId);return repository.grades(studentId,courseId);}
 public List<String> notifications(String studentId){repository.user(studentId);return notifications.messagesFor(studentId);}
 public Permission permissionFor(String userId){repository.user(userId);return permissions.get(userId);}
 public void grantAdmin(String userId){permissions.put(userId,new AdminPermissionDecorator(permissionFor(userId)));}
 public Collection<User> users(){return repository.users();}public Collection<Course> courses(){return repository.courses();}
}
