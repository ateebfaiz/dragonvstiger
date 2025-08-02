package tc;

import zd.d;

public class h extends c {
    public int a(byte[] bArr, int i10) {
        k();
        d.h(this.f2109e, bArr, i10);
        d.h(this.f2110f, bArr, i10 + 8);
        d.h(this.f2111g, bArr, i10 + 16);
        d.h(this.f2112h, bArr, i10 + 24);
        d.h(this.f2113i, bArr, i10 + 32);
        d.h(this.f2114j, bArr, i10 + 40);
        d.h(this.f2115k, bArr, i10 + 48);
        d.h(this.f2116l, bArr, i10 + 56);
        o();
        return 64;
    }

    public int c() {
        return 64;
    }

    public String getAlgorithmName() {
        return "SHA-512";
    }

    public void o() {
        super.o();
        this.f2109e = 7640891576956012808L;
        this.f2110f = -4942790177534073029L;
        this.f2111g = 4354685564936845355L;
        this.f2112h = -6534734903238641935L;
        this.f2113i = 5840696475078001361L;
        this.f2114j = -7276294671716946913L;
        this.f2115k = 2270897969802886507L;
        this.f2116l = 6620516959819538809L;
    }
}
