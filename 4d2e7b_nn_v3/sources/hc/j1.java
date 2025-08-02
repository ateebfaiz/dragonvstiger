package hc;

public class j1 extends b {
    public j1(byte[] bArr, int i10) {
        super(bArr, i10);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        byte[] bArr = this.f351a;
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 1)];
        bArr2[0] = (byte) s();
        System.arraycopy(bArr, 0, bArr2, 1, length);
        pVar.g(3, bArr2);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return v1.a(this.f351a.length + 1) + 1 + this.f351a.length + 1;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }
}
