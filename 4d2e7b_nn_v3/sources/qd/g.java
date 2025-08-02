package qd;

import sc.a;
import sc.b;

final class g {

    /* renamed from: a  reason: collision with root package name */
    private final a f1886a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1887b;

    protected g(a aVar, int i10) {
        if (aVar != null) {
            this.f1886a = aVar;
            this.f1887b = i10;
            return;
        }
        throw new NullPointerException("digest == null");
    }

    private byte[] d(int i10, byte[] bArr, byte[] bArr2) {
        byte[] p10 = x.p((long) i10, this.f1887b);
        this.f1886a.update(p10, 0, p10.length);
        this.f1886a.update(bArr, 0, bArr.length);
        this.f1886a.update(bArr2, 0, bArr2.length);
        int i11 = this.f1887b;
        byte[] bArr3 = new byte[i11];
        a aVar = this.f1886a;
        if (aVar instanceof b) {
            ((b) aVar).b(bArr3, 0, i11);
        } else {
            aVar.a(bArr3, 0);
        }
        return bArr3;
    }

    /* access modifiers changed from: protected */
    public byte[] a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i10 = this.f1887b;
        if (length != i10) {
            throw new IllegalArgumentException("wrong key length");
        } else if (bArr2.length == i10) {
            return d(0, bArr, bArr2);
        } else {
            throw new IllegalArgumentException("wrong in length");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i10 = this.f1887b;
        if (length != i10) {
            throw new IllegalArgumentException("wrong key length");
        } else if (bArr2.length == i10 * 2) {
            return d(1, bArr, bArr2);
        } else {
            throw new IllegalArgumentException("wrong in length");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr.length != this.f1887b) {
            throw new IllegalArgumentException("wrong key length");
        } else if (bArr2.length == 32) {
            return d(3, bArr, bArr2);
        } else {
            throw new IllegalArgumentException("wrong address length");
        }
    }
}
