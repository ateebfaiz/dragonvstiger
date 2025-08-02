package com.facebook.soloader;

import android.content.Context;
import android.os.StrictMode;
import java.io.File;

public class a extends a0 implements s {

    /* renamed from: a  reason: collision with root package name */
    private final int f4786a;

    /* renamed from: b  reason: collision with root package name */
    private e f4787b;

    public a(Context context, int i10) {
        this.f4786a = i10;
        this.f4787b = new e(f(context), i10);
    }

    private static File f(Context context) {
        return new File(context.getApplicationInfo().nativeLibraryDir);
    }

    public a0 b(Context context) {
        this.f4787b = new e(f(context), this.f4786a | 1);
        return this;
    }

    public String c() {
        return "ApplicationSoSource";
    }

    public int d(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        return this.f4787b.d(str, i10, threadPolicy);
    }

    /* access modifiers changed from: protected */
    public void e(int i10) {
        this.f4787b.e(i10);
    }

    public String toString() {
        return c() + "[" + this.f4787b.toString() + "]";
    }
}
