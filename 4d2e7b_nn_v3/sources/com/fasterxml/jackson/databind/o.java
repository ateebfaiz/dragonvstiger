package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.util.l;
import q8.g;

public abstract class o {

    public static abstract class a extends o {
    }

    public abstract Class c();

    public boolean d(b0 b0Var, Object obj) {
        return obj == null;
    }

    public boolean e() {
        return false;
    }

    public abstract void f(Object obj, f fVar, b0 b0Var);

    public void h(Object obj, f fVar, b0 b0Var, g gVar) {
        Class<?> c10 = c();
        if (c10 == null) {
            c10 = obj.getClass();
        }
        b0Var.k(c10, String.format("Type id handling not implemented for type %s (by serializer of type %s)", new Object[]{c10.getName(), getClass().getName()}));
    }

    public o i(l lVar) {
        return this;
    }

    public boolean j() {
        return false;
    }
}
