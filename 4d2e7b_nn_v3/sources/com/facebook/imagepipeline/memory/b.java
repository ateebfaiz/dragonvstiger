package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import y2.l;
import z2.a;

class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f19975a;

    /* renamed from: b  reason: collision with root package name */
    public final int f19976b;

    /* renamed from: c  reason: collision with root package name */
    final Queue f19977c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f19978d;

    /* renamed from: e  reason: collision with root package name */
    private int f19979e;

    public b(int i10, int i11, int i12, boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13 = false;
        if (i10 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        l.i(z11);
        if (i11 >= 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        l.i(z12);
        l.i(i12 >= 0 ? true : z13);
        this.f19975a = i10;
        this.f19976b = i11;
        this.f19977c = new LinkedList();
        this.f19979e = i12;
        this.f19978d = z10;
    }

    /* access modifiers changed from: package-private */
    public void a(Object obj) {
        this.f19977c.add(obj);
    }

    public void b() {
        boolean z10;
        if (this.f19979e > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.i(z10);
        this.f19979e--;
    }

    public Object c() {
        Object g10 = g();
        if (g10 != null) {
            this.f19979e++;
        }
        return g10;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f19977c.size();
    }

    public void e() {
        this.f19979e++;
    }

    public boolean f() {
        if (this.f19979e + d() > this.f19976b) {
            return true;
        }
        return false;
    }

    public Object g() {
        return this.f19977c.poll();
    }

    public void h(Object obj) {
        boolean z10 = false;
        l.g(obj);
        if (this.f19978d) {
            if (this.f19979e > 0) {
                z10 = true;
            }
            l.i(z10);
            this.f19979e--;
            a(obj);
            return;
        }
        int i10 = this.f19979e;
        if (i10 > 0) {
            this.f19979e = i10 - 1;
            a(obj);
            return;
        }
        a.l("BUCKET", "Tried to release value %s from an empty bucket!", obj);
    }
}
