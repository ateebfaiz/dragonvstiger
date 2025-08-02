package com.geetest.core;

import java.io.IOException;

public class y extends IOException {
    private Throwable cause;

    public y(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public y(String str, Throwable th) {
        super(str);
        this.cause = th;
    }
}
