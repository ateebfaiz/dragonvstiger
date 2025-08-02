package h5;

import b3.h;
import c3.a;
import java.nio.ByteBuffer;
import y2.l;

public class x implements h {

    /* renamed from: a  reason: collision with root package name */
    private final int f21987a;

    /* renamed from: b  reason: collision with root package name */
    a f21988b;

    public x(a aVar, int i10) {
        boolean z10;
        l.g(aVar);
        if (i10 < 0 || i10 > ((v) aVar.p()).getSize()) {
            z10 = false;
        } else {
            z10 = true;
        }
        l.b(Boolean.valueOf(z10));
        this.f21988b = aVar.b();
        this.f21987a = i10;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        if (isClosed()) {
            throw new h.a();
        }
    }

    public synchronized byte c(int i10) {
        boolean z10;
        a();
        boolean z11 = false;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        if (i10 < this.f21987a) {
            z11 = true;
        }
        l.b(Boolean.valueOf(z11));
        l.g(this.f21988b);
        return ((v) this.f21988b.p()).c(i10);
    }

    public synchronized void close() {
        a.m(this.f21988b);
        this.f21988b = null;
    }

    public synchronized int d(int i10, byte[] bArr, int i11, int i12) {
        boolean z10;
        a();
        if (i10 + i12 <= this.f21987a) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        l.g(this.f21988b);
        return ((v) this.f21988b.p()).d(i10, bArr, i11, i12);
    }

    public synchronized ByteBuffer e() {
        l.g(this.f21988b);
        return ((v) this.f21988b.p()).e();
    }

    public synchronized long f() {
        a();
        l.g(this.f21988b);
        return ((v) this.f21988b.p()).f();
    }

    public synchronized boolean isClosed() {
        return !a.y(this.f21988b);
    }

    public synchronized int size() {
        a();
        return this.f21987a;
    }
}
