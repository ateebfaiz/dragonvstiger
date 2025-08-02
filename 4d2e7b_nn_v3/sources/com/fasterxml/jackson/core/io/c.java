package com.fasterxml.jackson.core.io;

import j8.a;

public class c {

    /* renamed from: a  reason: collision with root package name */
    protected final b f5142a;

    /* renamed from: b  reason: collision with root package name */
    protected final Object f5143b;

    /* renamed from: c  reason: collision with root package name */
    protected final boolean f5144c;

    /* renamed from: d  reason: collision with root package name */
    protected final a f5145d;

    /* renamed from: e  reason: collision with root package name */
    protected byte[] f5146e;

    /* renamed from: f  reason: collision with root package name */
    protected char[] f5147f;

    /* renamed from: g  reason: collision with root package name */
    protected char[] f5148g;

    public c(a aVar, b bVar, boolean z10) {
        this.f5145d = aVar;
        this.f5142a = bVar;
        this.f5143b = bVar.b();
        this.f5144c = z10;
    }

    private IllegalArgumentException j() {
        return new IllegalArgumentException("Trying to release buffer smaller than original");
    }

    /* access modifiers changed from: protected */
    public final void a(Object obj) {
        if (obj != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
    }

    /* access modifiers changed from: protected */
    public final void b(byte[] bArr, byte[] bArr2) {
        if (bArr != bArr2 && bArr.length < bArr2.length) {
            throw j();
        }
    }

    /* access modifiers changed from: protected */
    public final void c(char[] cArr, char[] cArr2) {
        if (cArr != cArr2 && cArr.length < cArr2.length) {
            throw j();
        }
    }

    public byte[] d() {
        a(this.f5146e);
        byte[] a10 = this.f5145d.a(3);
        this.f5146e = a10;
        return a10;
    }

    public char[] e() {
        a(this.f5147f);
        char[] c10 = this.f5145d.c(1);
        this.f5147f = c10;
        return c10;
    }

    public boolean f() {
        return this.f5144c;
    }

    public void g(byte[] bArr) {
        if (bArr != null) {
            b(bArr, this.f5146e);
            this.f5146e = null;
            this.f5145d.i(3, bArr);
        }
    }

    public void h(char[] cArr) {
        if (cArr != null) {
            c(cArr, this.f5147f);
            this.f5147f = null;
            this.f5145d.j(1, cArr);
        }
    }

    public void i(char[] cArr) {
        if (cArr != null) {
            c(cArr, this.f5148g);
            this.f5148g = null;
            this.f5145d.j(3, cArr);
        }
    }
}
