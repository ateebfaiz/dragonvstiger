package com.bugsnag.android;

import c1.s;
import java.util.concurrent.atomic.AtomicBoolean;

class r2 {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f18964a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    private boolean f18965b = false;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f18966a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z f18967b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h3 f18968c;

        a(String str, z zVar, h3 h3Var) {
            this.f18966a = str;
            this.f18967b = zVar;
            this.f18968c = h3Var;
        }

        public void run() {
            r2.this.b(this.f18966a, this.f18967b, this.f18968c);
        }
    }

    r2() {
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f18965b;
    }

    /* access modifiers changed from: package-private */
    public void b(String str, z zVar, h3 h3Var) {
        if (!this.f18964a.getAndSet(true)) {
            try {
                System.loadLibrary(str);
                this.f18965b = true;
            } catch (UnsatisfiedLinkError e10) {
                zVar.F(e10, h3Var);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(String str, z zVar, h3 h3Var) {
        try {
            zVar.f19183z.d(s.IO, new a(str, zVar, h3Var)).get();
            return this.f18965b;
        } catch (Throwable unused) {
            return false;
        }
    }
}
