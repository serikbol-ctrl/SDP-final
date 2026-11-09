package com.school.strategy;
import java.util.*;
public final class AverageGradeStrategy implements GradeStrategy {
 public double calculate(List<Double> grades){if(grades==null||grades.isEmpty())throw new IllegalArgumentException("No grades");return grades.stream().mapToDouble(Double::doubleValue).average().orElseThrow();}
 public String name(){return "Average";}
}
