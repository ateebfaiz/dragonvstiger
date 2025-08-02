package com.facebook.imagepipeline.producers;

import z2.a;

public abstract class c implements n {

    /* renamed from: a  reason: collision with root package name */
    private boolean f20050a = false;

    public static boolean d(int i10) {
        return (i10 & 1) == 1;
    }

    public static boolean e(int i10) {
        return !d(i10);
    }

    public static int k(boolean z10) {
        return z10 ? 1 : 0;
    }

    public static boolean l(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    public static boolean m(int i10, int i11) {
        return (i10 & i11) == i11;
    }

    public static int n(int i10, int i11) {
        return i10 & (~i11);
    }

    public synchronized void a() {
        if (!this.f20050a) {
            this.f20050a = true;
            try {
                f();
            } catch (Exception e10) {
                j(e10);
            }
        } else {
            return;
        }
        return;
    }

    public synchronized void b(float f10) {
        if (!this.f20050a) {
            try {
                i(f10);
            } catch (Exception e10) {
                j(e10);
            }
        } else {
            return;
        }
        return;
    }

    public synchronized void c(Object obj, int i10) {
        if (!this.f20050a) {
            this.f20050a = d(i10);
            try {
                h(obj, i10);
            } catch (Exception e10) {
                j(e10);
            }
        } else {
            return;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void f();

    /* access modifiers changed from: protected */
    public abstract void g(Throwable th);

    /* access modifiers changed from: protected */
    public abstract void h(Object obj, int i10);

    /* access modifiers changed from: protected */
    public abstract void i(float f10);

    /* access modifiers changed from: protected */
    public void j(Exception exc) {
        a.K(getClass(), "unhandled exception", exc);
    }

    public synchronized void onFailure(Throwable th) {
        if (!this.f20050a) {
            this.f20050a = true;
            try {
                g(th);
            } catch (Exception e10) {
                j(e10);
            }
        } else {
            return;
        }
        return;
    }
}
