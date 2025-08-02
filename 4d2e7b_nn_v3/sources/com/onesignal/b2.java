package com.onesignal;

import com.onesignal.o3;

class b2 implements c2 {
    b2() {
    }

    public void a(String str, Throwable th) {
        o3.b(o3.v.ERROR, str, th);
    }

    public void b(String str) {
        o3.a(o3.v.DEBUG, str);
    }

    public void c(String str) {
        o3.a(o3.v.WARN, str);
    }

    public void d(String str) {
        o3.a(o3.v.ERROR, str);
    }

    public void e(String str) {
        o3.a(o3.v.VERBOSE, str);
    }

    public void f(String str) {
        o3.a(o3.v.INFO, str);
    }
}
