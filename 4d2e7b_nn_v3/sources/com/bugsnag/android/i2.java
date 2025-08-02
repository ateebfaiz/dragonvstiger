package com.bugsnag.android;

import android.content.Context;
import android.os.Build;
import android.os.storage.StorageManager;
import c1.j;
import c1.s;
import com.bugsnag.android.d2;
import d1.d;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

class i2 implements d2.a {

    /* renamed from: a  reason: collision with root package name */
    final s2 f18761a;

    /* renamed from: b  reason: collision with root package name */
    final j f18762b;

    /* renamed from: c  reason: collision with root package name */
    final StorageManager f18763c;

    /* renamed from: d  reason: collision with root package name */
    final j f18764d;

    /* renamed from: e  reason: collision with root package name */
    final d f18765e;

    /* renamed from: f  reason: collision with root package name */
    final Context f18766f;

    /* renamed from: g  reason: collision with root package name */
    final p3 f18767g;

    /* renamed from: h  reason: collision with root package name */
    final e3 f18768h;

    /* renamed from: i  reason: collision with root package name */
    final c1.a f18769i;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s1 f18770a;

        a(s1 s1Var) {
            this.f18770a = s1Var;
        }

        public void run() {
            try {
                i2.this.f18761a.d("InternalReportDelegate - sending internal event");
                r0 i10 = i2.this.f18762b.i();
                u0 o10 = i2.this.f18762b.o(this.f18770a);
                if (i10 instanceof p0) {
                    Map b10 = o10.b();
                    b10.put("Bugsnag-Internal-Error", "bugsnag-android");
                    b10.remove("Bugsnag-Api-Key");
                    ((p0) i10).c(o10.a(), this.f18770a.a(), this.f18770a.e(), b10);
                }
            } catch (Exception e10) {
                i2.this.f18761a.c("Failed to report internal event to Bugsnag", e10);
            }
        }
    }

    i2(Context context, s2 s2Var, j jVar, StorageManager storageManager, j jVar2, d dVar, p3 p3Var, e3 e3Var, c1.a aVar) {
        this.f18761a = s2Var;
        this.f18762b = jVar;
        this.f18763c = storageManager;
        this.f18764d = jVar2;
        this.f18765e = dVar;
        this.f18766f = context;
        this.f18767g = p3Var;
        this.f18768h = e3Var;
        this.f18769i = aVar;
    }

    public void a(Exception exc, File file, String str) {
        o1 o1Var = new o1(exc, this.f18762b, q3.h("unhandledException"), this.f18761a);
        o1Var.r(str);
        o1Var.b("BugsnagDiagnostics", "canRead", Boolean.valueOf(file.canRead()));
        o1Var.b("BugsnagDiagnostics", "canWrite", Boolean.valueOf(file.canWrite()));
        o1Var.b("BugsnagDiagnostics", "exists", Boolean.valueOf(file.exists()));
        o1Var.b("BugsnagDiagnostics", "usableSpace", Long.valueOf(this.f18766f.getCacheDir().getUsableSpace()));
        o1Var.b("BugsnagDiagnostics", "filename", file.getName());
        o1Var.b("BugsnagDiagnostics", "fileLength", Long.valueOf(file.length()));
        b(o1Var);
        c(o1Var);
    }

    /* access modifiers changed from: package-private */
    public void b(o1 o1Var) {
        if (this.f18763c != null && Build.VERSION.SDK_INT >= 26) {
            File file = new File(this.f18766f.getCacheDir(), "bugsnag/errors");
            try {
                boolean a10 = this.f18763c.isCacheBehaviorTombstone(file);
                boolean a11 = this.f18763c.isCacheBehaviorGroup(file);
                o1Var.b("BugsnagDiagnostics", "cacheTombstone", Boolean.valueOf(a10));
                o1Var.b("BugsnagDiagnostics", "cacheGroup", Boolean.valueOf(a11));
            } catch (IOException e10) {
                this.f18761a.c("Failed to record cache behaviour, skipping diagnostics", e10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(o1 o1Var) {
        o1Var.p(this.f18764d.e());
        o1Var.s(((b1) this.f18765e.get()).j(new Date().getTime()));
        o1Var.b("BugsnagDiagnostics", "notifierName", this.f18768h.b());
        o1Var.b("BugsnagDiagnostics", "notifierVersion", this.f18768h.d());
        o1Var.b("BugsnagDiagnostics", "apiKey", this.f18762b.a());
        try {
            this.f18769i.d(s.INTERNAL_REPORT, new a(new s1((String) null, o1Var, this.f18768h, this.f18762b)));
        } catch (RejectedExecutionException unused) {
        }
    }
}
