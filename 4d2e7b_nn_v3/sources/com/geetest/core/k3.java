package com.geetest.core;

public class k3 extends IllegalStateException {
    private Throwable cause;

    public k3(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
