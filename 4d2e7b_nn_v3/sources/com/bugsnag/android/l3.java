package com.bugsnag.android;

import c1.f;
import c1.p;
import com.bugsnag.android.k2;
import com.bugsnag.android.q0;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class l3 implements k2.a, q0 {
    private final AtomicBoolean C;
    private final AtomicBoolean X;
    private String Y;

    /* renamed from: a  reason: collision with root package name */
    private final File f18832a;

    /* renamed from: b  reason: collision with root package name */
    private final e3 f18833b;

    /* renamed from: c  reason: collision with root package name */
    private String f18834c;

    /* renamed from: d  reason: collision with root package name */
    private Date f18835d;

    /* renamed from: e  reason: collision with root package name */
    private k4 f18836e;

    /* renamed from: f  reason: collision with root package name */
    private final s2 f18837f;

    /* renamed from: g  reason: collision with root package name */
    private f f18838g;

    /* renamed from: h  reason: collision with root package name */
    private w0 f18839h;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f18840i;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicInteger f18841j;

    /* renamed from: w  reason: collision with root package name */
    private final AtomicInteger f18842w;

    l3(Map map, s2 s2Var, String str) {
        this((File) null, (e3) null, s2Var, str);
        w((String) map.get("id"));
        x(f.a((String) map.get("startedAt")));
        Map map2 = (Map) map.get(DbParams.TABLE_EVENTS);
        this.f18842w.set(((Number) map2.get("handled")).intValue());
        this.f18841j.set(((Number) map2.get("unhandled")).intValue());
    }

    static l3 b(l3 l3Var) {
        l3 l3Var2 = new l3(l3Var.f18834c, l3Var.f18835d, l3Var.f18836e, l3Var.f18841j.get(), l3Var.f18842w.get(), l3Var.f18833b, l3Var.f18837f, l3Var.c());
        l3Var2.C.set(l3Var.C.get());
        l3Var2.f18840i = l3Var.k();
        return l3Var2;
    }

    private void n(String str) {
        s2 s2Var = this.f18837f;
        s2Var.a("Invalid null value supplied to session." + str + ", ignoring");
    }

    private void r(k2 k2Var) {
        k2Var.j();
        k2Var.v("notifier").P(this.f18833b);
        k2Var.v("app").P(this.f18838g);
        k2Var.v("device").P(this.f18839h);
        k2Var.v("sessions").h();
        k2Var.O(this.f18832a);
        k2Var.m();
        k2Var.n();
    }

    private void s(k2 k2Var) {
        k2Var.O(this.f18832a);
    }

    public byte[] a() {
        return p.f17266a.g(this);
    }

    public String c() {
        return this.Y;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f18842w.intValue();
    }

    public String e() {
        return this.f18834c;
    }

    public String f() {
        return q0.a.a(this);
    }

    public Date g() {
        return this.f18835d;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f18841j.intValue();
    }

    /* access modifiers changed from: package-private */
    public l3 i() {
        this.f18842w.incrementAndGet();
        return b(this);
    }

    /* access modifiers changed from: package-private */
    public l3 j() {
        this.f18841j.incrementAndGet();
        return b(this);
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.f18840i;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        File file = this.f18832a;
        if (file == null || (!file.getName().endsWith("_v2.json") && !this.f18832a.getName().endsWith("_v3.json"))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.X.get();
    }

    /* access modifiers changed from: package-private */
    public void o() {
        this.X.set(true);
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.X.compareAndSet(true, false);
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return this.C.compareAndSet(false, true);
    }

    /* access modifiers changed from: package-private */
    public void t(k2 k2Var) {
        k2Var.j();
        k2Var.v("id").K(this.f18834c);
        k2Var.v("startedAt").P(this.f18835d);
        k2Var.v("user").P(this.f18836e);
        k2Var.n();
    }

    public void toStream(k2 k2Var) {
        if (this.f18832a == null) {
            k2Var.j();
            k2Var.v("notifier").P(this.f18833b);
            k2Var.v("app").P(this.f18838g);
            k2Var.v("device").P(this.f18839h);
            k2Var.v("sessions").h();
            t(k2Var);
            k2Var.m();
            k2Var.n();
        } else if (!l()) {
            s(k2Var);
        } else {
            r(k2Var);
        }
    }

    /* access modifiers changed from: package-private */
    public void u(f fVar) {
        this.f18838g = fVar;
    }

    /* access modifiers changed from: package-private */
    public void v(w0 w0Var) {
        this.f18839h = w0Var;
    }

    public void w(String str) {
        if (str != null) {
            this.f18834c = str;
        } else {
            n("id");
        }
    }

    public void x(Date date) {
        if (date != null) {
            this.f18835d = date;
        } else {
            n("startedAt");
        }
    }

    l3(String str, Date date, k4 k4Var, boolean z10, e3 e3Var, s2 s2Var, String str2) {
        this((File) null, e3Var, s2Var, str2);
        this.f18834c = str;
        this.f18835d = new Date(date.getTime());
        this.f18836e = k4Var;
        this.f18840i = z10;
        this.Y = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    l3(String str, Date date, k4 k4Var, int i10, int i11, e3 e3Var, s2 s2Var, String str2) {
        this(str, date, k4Var, false, e3Var, s2Var, str2);
        int i12 = i10;
        this.f18841j.set(i10);
        int i13 = i11;
        this.f18842w.set(i11);
        this.C.set(true);
        this.Y = str2;
    }

    l3(File file, e3 e3Var, s2 s2Var, String str) {
        this.f18840i = false;
        this.f18841j = new AtomicInteger();
        this.f18842w = new AtomicInteger();
        this.C = new AtomicBoolean(false);
        this.X = new AtomicBoolean(false);
        this.f18832a = file;
        this.f18837f = s2Var;
        this.Y = m3.b(file, str);
        if (e3Var != null) {
            e3 e3Var2 = new e3(e3Var.b(), e3Var.d(), e3Var.c());
            e3Var2.e(new ArrayList(e3Var.a()));
            this.f18833b = e3Var2;
            return;
        }
        this.f18833b = null;
    }
}
