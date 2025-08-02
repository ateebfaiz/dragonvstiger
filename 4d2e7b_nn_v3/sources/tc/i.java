package tc;

import sc.b;

public class i extends b implements b {
    public i(int i10) {
        super(w(i10));
    }

    private static int w(int i10) {
        if (i10 == 128 || i10 == 256) {
            return i10;
        }
        throw new IllegalArgumentException("'bitLength' " + i10 + " not supported for SHAKE");
    }

    public int a(byte[] bArr, int i10) {
        return b(bArr, i10, c());
    }

    public int b(byte[] bArr, int i10, int i11) {
        int x10 = x(bArr, i10, i11);
        s();
        return x10;
    }

    public String getAlgorithmName() {
        return "SHAKE" + this.f2102e;
    }

    public int x(byte[] bArr, int i10, int i11) {
        if (!this.f2103f) {
            i(15, 4);
        }
        u(bArr, i10, ((long) i11) * 8);
        return i11;
    }
}
