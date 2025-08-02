package qd;

final class m {

    /* renamed from: a  reason: collision with root package name */
    private final byte[][] f1914a;

    protected m(l lVar, byte[][] bArr) {
        if (lVar == null) {
            throw new NullPointerException("params == null");
        } else if (bArr == null) {
            throw new NullPointerException("publicKey == null");
        } else if (x.k(bArr)) {
            throw new NullPointerException("publicKey byte array == null");
        } else if (bArr.length == lVar.c()) {
            int i10 = 0;
            while (i10 < bArr.length) {
                if (bArr[i10].length == lVar.b()) {
                    i10++;
                } else {
                    throw new IllegalArgumentException("wrong publicKey format");
                }
            }
            this.f1914a = x.d(bArr);
        } else {
            throw new IllegalArgumentException("wrong publicKey size");
        }
    }

    /* access modifiers changed from: protected */
    public byte[][] a() {
        return x.d(this.f1914a);
    }
}
