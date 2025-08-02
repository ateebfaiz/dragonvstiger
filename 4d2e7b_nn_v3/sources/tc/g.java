package tc;

import zd.d;

public class g extends c {
    public int a(byte[] bArr, int i10) {
        k();
        d.h(this.f2109e, bArr, i10);
        d.h(this.f2110f, bArr, i10 + 8);
        d.h(this.f2111g, bArr, i10 + 16);
        d.h(this.f2112h, bArr, i10 + 24);
        d.h(this.f2113i, bArr, i10 + 32);
        d.h(this.f2114j, bArr, i10 + 40);
        o();
        return 48;
    }

    public int c() {
        return 48;
    }

    public String getAlgorithmName() {
        return "SHA-384";
    }

    public void o() {
        super.o();
        this.f2109e = -3766243637369397544L;
        this.f2110f = 7105036623409894663L;
        this.f2111g = -7973340178411365097L;
        this.f2112h = 1526699215303891257L;
        this.f2113i = 7436329637833083697L;
        this.f2114j = -8163818279084223215L;
        this.f2115k = -2662702644619276377L;
        this.f2116l = 5167115440072839076L;
    }
}
