package com.geetest.core;

public class o0 extends IllegalStateException {
    private Throwable cause;

    public o0(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public o0(String str, Throwable th) {
        super(str);
        this.cause = th;
    }
}
