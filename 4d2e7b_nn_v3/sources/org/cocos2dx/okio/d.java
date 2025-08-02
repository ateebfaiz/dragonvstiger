package org.cocos2dx.okio;

final class d {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f1789a;

    /* renamed from: b  reason: collision with root package name */
    int f1790b;

    /* renamed from: c  reason: collision with root package name */
    int f1791c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1792d;

    /* renamed from: e  reason: collision with root package name */
    boolean f1793e;

    /* renamed from: f  reason: collision with root package name */
    d f1794f;

    /* renamed from: g  reason: collision with root package name */
    d f1795g;

    d() {
        this.f1789a = new byte[8192];
        this.f1793e = true;
        this.f1792d = false;
    }

    public final void a() {
        int i10;
        d dVar = this.f1795g;
        if (dVar == this) {
            throw new IllegalStateException();
        } else if (dVar.f1793e) {
            int i11 = this.f1791c - this.f1790b;
            int i12 = 8192 - dVar.f1791c;
            if (dVar.f1792d) {
                i10 = 0;
            } else {
                i10 = dVar.f1790b;
            }
            if (i11 <= i12 + i10) {
                g(dVar, i11);
                b();
                e.a(this);
            }
        }
    }

    public final d b() {
        d dVar;
        d dVar2 = this.f1794f;
        if (dVar2 != this) {
            dVar = dVar2;
        } else {
            dVar = null;
        }
        d dVar3 = this.f1795g;
        dVar3.f1794f = dVar2;
        this.f1794f.f1795g = dVar3;
        this.f1794f = null;
        this.f1795g = null;
        return dVar;
    }

    public final d c(d dVar) {
        dVar.f1795g = this;
        dVar.f1794f = this.f1794f;
        this.f1794f.f1795g = dVar;
        this.f1794f = dVar;
        return dVar;
    }

    /* access modifiers changed from: package-private */
    public final d d() {
        this.f1792d = true;
        return new d(this.f1789a, this.f1790b, this.f1791c, true, false);
    }

    public final d e(int i10) {
        d dVar;
        if (i10 <= 0 || i10 > this.f1791c - this.f1790b) {
            throw new IllegalArgumentException();
        }
        if (i10 >= 1024) {
            dVar = d();
        } else {
            dVar = e.b();
            System.arraycopy(this.f1789a, this.f1790b, dVar.f1789a, 0, i10);
        }
        dVar.f1791c = dVar.f1790b + i10;
        this.f1790b += i10;
        this.f1795g.c(dVar);
        return dVar;
    }

    /* access modifiers changed from: package-private */
    public final d f() {
        return new d((byte[]) this.f1789a.clone(), this.f1790b, this.f1791c, false, true);
    }

    public final void g(d dVar, int i10) {
        if (dVar.f1793e) {
            int i11 = dVar.f1791c;
            if (i11 + i10 > 8192) {
                if (!dVar.f1792d) {
                    int i12 = dVar.f1790b;
                    if ((i11 + i10) - i12 <= 8192) {
                        byte[] bArr = dVar.f1789a;
                        System.arraycopy(bArr, i12, bArr, 0, i11 - i12);
                        dVar.f1791c -= dVar.f1790b;
                        dVar.f1790b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f1789a, this.f1790b, dVar.f1789a, dVar.f1791c, i10);
            dVar.f1791c += i10;
            this.f1790b += i10;
            return;
        }
        throw new IllegalArgumentException();
    }

    d(byte[] bArr, int i10, int i11, boolean z10, boolean z11) {
        this.f1789a = bArr;
        this.f1790b = i10;
        this.f1791c = i11;
        this.f1792d = z10;
        this.f1793e = z11;
    }
}
