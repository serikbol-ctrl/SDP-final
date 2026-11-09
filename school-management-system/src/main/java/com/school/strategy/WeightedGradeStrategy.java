package com.school.strategy;
import java.util.*;
public final class WeightedGradeStrategy implements GradeStrategy {
 public double calculate(List<Double> grades){if(grades==null||grades.isEmpty())throw new IllegalArgumentException("No grades");double sum=0,weights=0;for(int i=0;i<grades.size();i++){double w=i+1;sum+=grades.get(i)*w;weights+=w;}return sum/weights;}
 public String name(){return "Weighted (later grades have greater weight)";}
}
