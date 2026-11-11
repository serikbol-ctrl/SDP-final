package com.school.decorator;

import java.util.Set;

public interface Permission {
    Set<String> actions();
    default boolean allows(String action) {
        return actions().contains(action);
    }
}
