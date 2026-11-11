package com.school.decorator;

import java.util.*;

public abstract class PermissionDecorator implements Permission {
    protected final Permission delegate;
    protected PermissionDecorator(Permission delegate) {
        this.delegate=Objects.requireNonNull(delegate);
    }

    public Set<String> actions() {
        return delegate.actions();
    }
}
