# School Management System

Java 17 console project demonstrating **six integrated design patterns**: Factory, Builder, Strategy, Observer, Decorator and Facade.

## Requirements
- JDK 17+
- Apache Maven 3.8+

## Run
```bash
mvn clean test
mvn exec:java
```

## Example demo
1. Add teacher (`t1`, Bob)
2. Add student (`s1`, Alice)
3. Create course (`c1`, Mathematics, teacher `t1`, modules `Algebra, Geometry`)
4. Enroll `s1` in `c1`
5. Assign grades 80 and 100 using teacher `t1`
6. Calculate average (90) or weighted (93.33)
7. View notifications for `s1`
8. Grant admin to `t1` and inspect permissions

## Notes
- In-memory storage: data resets when the app exits.
- No authentication or production security. Admin granting is a demonstration feature.
- Weighted grading assigns weight 1 to first grade, 2 to second, etc.
- `docs/class-diagram.puml` contains the UML source.