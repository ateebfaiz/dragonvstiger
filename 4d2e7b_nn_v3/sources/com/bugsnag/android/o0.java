package com.bugsnag.android;

import android.util.Log;

public final class o0 implements s2 {

    /* renamed from: a  reason: collision with root package name */
    public static final o0 f18889a = new o0();

    private o0() {
    }

    public void a(String str) {
        Log.e("Bugsnag", str);
    }

    public void b(String str, Throwable th) {
        Log.d("Bugsnag", str, th);
    }

    public void c(String str, Throwable th) {
        Log.w("Bugsnag", str, th);
    }

    public void d(String str) {
        Log.d("Bugsnag", str);
    }

    public void e(String str, Throwable th) {
        Log.e("Bugsnag", str, th);
    }

    public void f(String str) {
        Log.i("Bugsnag", str);
    }

    public void g(String str) {
        Log.w("Bugsnag", str);
    }
}
