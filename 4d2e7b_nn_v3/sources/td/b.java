package td;

import hc.t0;
import java.security.PublicKey;
import kd.e;
import kd.g;
import zd.a;

public class b implements PublicKey {

    /* renamed from: a  reason: collision with root package name */
    private short[][] f2154a;

    /* renamed from: b  reason: collision with root package name */
    private short[][] f2155b;

    /* renamed from: c  reason: collision with root package name */
    private short[] f2156c;

    /* renamed from: d  reason: collision with root package name */
    private int f2157d;

    public b(int i10, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f2157d = i10;
        this.f2154a = sArr;
        this.f2155b = sArr2;
        this.f2156c = sArr3;
    }

    public short[][] a() {
        return this.f2154a;
    }

    public short[] b() {
        return a.h(this.f2156c);
    }

    public short[][] c() {
        short[][] sArr = new short[this.f2155b.length][];
        int i10 = 0;
        while (true) {
            short[][] sArr2 = this.f2155b;
            if (i10 == sArr2.length) {
                return sArr;
            }
            sArr[i10] = a.h(sArr2[i10]);
            i10++;
        }
    }

    public int d() {
        return this.f2157d;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f2157d != bVar.d() || !od.a.j(this.f2154a, bVar.a()) || !od.a.j(this.f2155b, bVar.c()) || !od.a.i(this.f2156c, bVar.b())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "Rainbow";
    }

    public byte[] getEncoded() {
        return vd.a.a(new qc.a(e.f560a, t0.f424a), new g(this.f2157d, this.f2154a, this.f2155b, this.f2156c));
    }

    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return (((((this.f2157d * 37) + a.s(this.f2154a)) * 37) + a.s(this.f2155b)) * 37) + a.r(this.f2156c);
    }

    public b(xd.b bVar) {
        this(bVar.d(), bVar.a(), bVar.c(), bVar.b());
    }
}
