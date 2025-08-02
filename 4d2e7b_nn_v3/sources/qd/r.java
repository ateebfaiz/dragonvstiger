package qd;

import java.io.Serializable;

public final class r implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final int f1950a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f1951b;

    protected r(int i10, byte[] bArr) {
        this.f1950a = i10;
        this.f1951b = bArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public r clone() {
        return new r(b(), c());
    }

    public int b() {
        return this.f1950a;
    }

    public byte[] c() {
        return x.c(this.f1951b);
    }
}
