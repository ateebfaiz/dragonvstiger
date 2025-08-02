package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.g;
import com.fasterxml.jackson.core.i;

public abstract class f extends i {
    protected f(String str, g gVar, Throwable th) {
        super(str, gVar, th);
    }

    public abstract void e(Object obj, String str);

    protected f(String str) {
        super(str);
    }

    protected f(String str, Throwable th) {
        this(str, (g) null, th);
    }
}
