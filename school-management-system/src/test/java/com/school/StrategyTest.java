package com.school;

import com.school.strategy.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {
    @Test
    void algorithmsDiffer() {
        var grades=List.of(60.0, 90.0);
        assertEquals(75.0, new AverageGradeStrategy().calculate(grades), 0.001);
        assertEquals(80.0, new WeightedGradeStrategy().calculate(grades), 0.001);
        assertThrows(IllegalArgumentException.class, () -> new AverageGradeStrategy().calculate(List.of()));
    }
}
