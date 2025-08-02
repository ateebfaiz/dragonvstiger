package com.google.android.gms.tasks;

import java.util.concurrent.ExecutionException;

final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private final Object f7840a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final int f7841b;

    /* renamed from: c  reason: collision with root package name */
    private final c0 f7842c;

    /* renamed from: d  reason: collision with root package name */
    private int f7843d;

    /* renamed from: e  reason: collision with root package name */
    private int f7844e;

    /* renamed from: f  reason: collision with root package name */
    private int f7845f;

    /* renamed from: g  reason: collision with root package name */
    private Exception f7846g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7847h;

    public f(int i10, c0 c0Var) {
        this.f7841b = i10;
        this.f7842c = c0Var;
    }

    private final void a() {
        if (this.f7843d + this.f7844e + this.f7845f != this.f7841b) {
            return;
        }
        if (this.f7846g != null) {
            c0 c0Var = this.f7842c;
            int i10 = this.f7844e;
            int i11 = this.f7841b;
            c0Var.a(new ExecutionException(i10 + " out of " + i11 + " underlying tasks failed", this.f7846g));
        } else if (this.f7847h) {
            this.f7842c.c();
        } else {
            this.f7842c.b((Object) null);
        }
    }

    public final void onCanceled() {
        synchronized (this.f7840a) {
            this.f7845f++;
            this.f7847h = true;
            a();
        }
    }

    public final void onFailure(Exception exc) {
        synchronized (this.f7840a) {
            this.f7844e++;
            this.f7846g = exc;
            a();
        }
    }

    public final void onSuccess(Object obj) {
        synchronized (this.f7840a) {
            this.f7843d++;
            a();
        }
    }
}
