package com.geetest.core;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;

public class d3 extends s0 {

    /* renamed from: b  reason: collision with root package name */
    public byte[] f5952b;

    public d3(byte[] bArr) throws IOException {
        this.f5952b = bArr;
    }

    public v a(int i10) {
        p();
        return this.f6170a[i10];
    }

    public p0 h() {
        p();
        return super.h();
    }

    public int hashCode() {
        p();
        return super.hashCode();
    }

    public p0 i() {
        p();
        return super.i();
    }

    public Iterator<v> iterator() {
        p();
        return super.iterator();
    }

    public int m() {
        p();
        return this.f6170a.length;
    }

    public s n() {
        p();
        return ((s0) super.i()).n();
    }

    public l0 o() {
        p();
        return ((s0) super.i()).o();
    }

    public final synchronized void p() {
        if (this.f5952b != null) {
            byte[] bArr = this.f5952b;
            e0 e0Var = new e0(new ByteArrayInputStream(bArr), bArr.length, true);
            try {
                w b10 = e0Var.b();
                e0Var.close();
                this.f6170a = b10.c();
                this.f5952b = null;
            } catch (IOException e10) {
                throw new o0("malformed ASN.1: " + e10, e10);
            }
        }
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f5952b;
        }
        if (bArr != null) {
            n0Var.a(z10, 48, bArr);
        } else {
            super.i().a(n0Var, z10);
        }
    }

    public int a(boolean z10) throws IOException {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f5952b;
        }
        if (bArr != null) {
            return n0.a(z10, bArr.length);
        }
        return n0.a(z10, ((u2) super.i()).p());
    }
}
