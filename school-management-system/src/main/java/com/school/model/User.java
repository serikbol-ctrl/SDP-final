package com.school.model;

public abstract class User {
    private final String id, name;
    protected User(String id, String name) {
        if (id==null||id.isBlank() || name==null||name.isBlank()) {
            throw new IllegalArgumentException("ID and name required");
        }
        this.id=id;
        this.name=name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract String getRole();
    public String toString() {
        return getRole() +"["+id+"] "+name;
    }
}
