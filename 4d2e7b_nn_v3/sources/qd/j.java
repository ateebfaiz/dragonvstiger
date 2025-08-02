package qd;

import qd.i;

final class j {

    /* renamed from: a  reason: collision with root package name */
    private final l f1900a;

    /* renamed from: b  reason: collision with root package name */
    private final g f1901b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f1902c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f1903d;

    protected j(l lVar) {
        if (lVar != null) {
            this.f1900a = lVar;
            int b10 = lVar.b();
            this.f1901b = new g(lVar.a(), b10);
            this.f1902c = new byte[b10];
            this.f1903d = new byte[b10];
            return;
        }
        throw new NullPointerException("params == null");
    }

    private byte[] a(byte[] bArr, int i10, int i11, i iVar) {
        int b10 = this.f1900a.b();
        if (bArr == null) {
            throw new NullPointerException("startHash == null");
        } else if (bArr.length != b10) {
            throw new IllegalArgumentException("startHash needs to be " + b10 + "bytes");
        } else if (iVar == null) {
            throw new NullPointerException("otsHashAddress == null");
        } else if (iVar.d() != null) {
            int i12 = i10 + i11;
            if (i12 > this.f1900a.d() - 1) {
                throw new IllegalArgumentException("max chain length must not be greater than w");
            } else if (i11 == 0) {
                return bArr;
            } else {
                byte[] a10 = a(bArr, i10, i11 - 1, iVar);
                i iVar2 = (i) ((i.b) ((i.b) ((i.b) new i.b().g(iVar.b())).h(iVar.c())).p(iVar.g()).n(iVar.e()).o(i12 - 1).f(0)).l();
                byte[] c10 = this.f1901b.c(this.f1903d, iVar2.d());
                byte[] c11 = this.f1901b.c(this.f1903d, ((i) ((i.b) ((i.b) ((i.b) new i.b().g(iVar2.b())).h(iVar2.c())).p(iVar2.g()).n(iVar2.e()).o(iVar2.f()).f(1)).l()).d());
                byte[] bArr2 = new byte[b10];
                for (int i13 = 0; i13 < b10; i13++) {
                    bArr2[i13] = (byte) (a10[i13] ^ c11[i13]);
                }
                return this.f1901b.a(c10, bArr2);
            }
        } else {
            throw new NullPointerException("otsHashAddress byte array == null");
        }
    }

    private byte[] b(int i10) {
        if (i10 >= 0 && i10 < this.f1900a.c()) {
            return this.f1901b.c(this.f1902c, x.p((long) i10, 32));
        }
        throw new IllegalArgumentException("index out of bounds");
    }

    /* access modifiers changed from: protected */
    public g c() {
        return this.f1901b;
    }

    /* access modifiers changed from: protected */
    public l d() {
        return this.f1900a;
    }

    /* access modifiers changed from: protected */
    public m e(i iVar) {
        if (iVar != null) {
            byte[][] bArr = new byte[this.f1900a.c()][];
            for (int i10 = 0; i10 < this.f1900a.c(); i10++) {
                iVar = (i) ((i.b) ((i.b) ((i.b) new i.b().g(iVar.b())).h(iVar.c())).p(iVar.g()).n(i10).o(iVar.f()).f(iVar.a())).l();
                bArr[i10] = a(b(i10), 0, this.f1900a.d() - 1, iVar);
            }
            return new m(this.f1900a, bArr);
        }
        throw new NullPointerException("otsHashAddress == null");
    }

    /* access modifiers changed from: protected */
    public byte[] f() {
        return x.c(this.f1903d);
    }

    /* access modifiers changed from: protected */
    public byte[] g(byte[] bArr, i iVar) {
        return this.f1901b.c(bArr, ((i) ((i.b) ((i.b) new i.b().g(iVar.b())).h(iVar.c())).p(iVar.g()).l()).d());
    }

    /* access modifiers changed from: package-private */
    public void h(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new NullPointerException("secretKeySeed == null");
        } else if (bArr.length != this.f1900a.b()) {
            throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
        } else if (bArr2 == null) {
            throw new NullPointerException("publicSeed == null");
        } else if (bArr2.length == this.f1900a.b()) {
            this.f1902c = bArr;
            this.f1903d = bArr2;
        } else {
            throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
        }
    }
}
