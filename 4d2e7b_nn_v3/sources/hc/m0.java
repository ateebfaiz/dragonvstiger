package hc;

public class m0 extends b {
    public m0(byte[] bArr, int i10) {
        super(bArr, i10);
    }

    public static m0 u(Object obj) {
        if (obj == null || (obj instanceof m0)) {
            return (m0) obj;
        }
        if (obj instanceof j1) {
            j1 j1Var = (j1) obj;
            return new m0(j1Var.f351a, j1Var.f352b);
        } else if (obj instanceof byte[]) {
            try {
                return (m0) r.k((byte[]) obj);
            } catch (Exception e10) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        byte[] o10 = b.o(this.f351a, this.f352b);
        int length = o10.length;
        byte[] bArr = new byte[(length + 1)];
        bArr[0] = (byte) s();
        System.arraycopy(o10, 0, bArr, 1, length);
        pVar.g(3, bArr);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return v1.a(this.f351a.length + 1) + 1 + this.f351a.length + 1;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    public m0(byte[] bArr) {
        this(bArr, 0);
    }

    public m0(d dVar) {
        super(dVar.c().f("DER"), 0);
    }
}
