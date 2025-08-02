package com.geetest.core;

public class q3 extends Exception {
    private static final long serialVersionUID = 8839905301881841410L;

    public q3(String str) {
        super(str);
    }

    public q3(Throwable th) {
        super(th);
    }

    public q3(String str, Throwable th) {
        super(str, th);
    }
}
