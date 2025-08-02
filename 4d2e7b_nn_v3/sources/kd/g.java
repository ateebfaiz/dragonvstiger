package kd;

import hc.e;
import hc.j;
import hc.l;
import hc.m;
import hc.n;
import hc.r;
import hc.s;
import hc.v0;
import hc.z0;
import od.a;

public class g extends l {

    /* renamed from: a  reason: collision with root package name */
    private j f594a;

    /* renamed from: b  reason: collision with root package name */
    private m f595b;

    /* renamed from: c  reason: collision with root package name */
    private j f596c;

    /* renamed from: d  reason: collision with root package name */
    private byte[][] f597d;

    /* renamed from: e  reason: collision with root package name */
    private byte[][] f598e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f599f;

    private g(s sVar) {
        if (sVar.q(0) instanceof j) {
            this.f594a = j.o(sVar.q(0));
        } else {
            this.f595b = m.t(sVar.q(0));
        }
        this.f596c = j.o(sVar.q(1));
        s o10 = s.o(sVar.q(2));
        this.f597d = new byte[o10.size()][];
        for (int i10 = 0; i10 < o10.size(); i10++) {
            this.f597d[i10] = n.p(o10.q(i10)).q();
        }
        s sVar2 = (s) sVar.q(3);
        this.f598e = new byte[sVar2.size()][];
        for (int i11 = 0; i11 < sVar2.size(); i11++) {
            this.f598e[i11] = n.p(sVar2.q(i11)).q();
        }
        this.f599f = n.p(((s) sVar.q(4)).q(0)).q();
    }

    public static g l(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(s.o(obj));
        }
        return null;
    }

    public r c() {
        e eVar = new e();
        j jVar = this.f594a;
        if (jVar != null) {
            eVar.a(jVar);
        } else {
            eVar.a(this.f595b);
        }
        eVar.a(this.f596c);
        e eVar2 = new e();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[][] bArr = this.f597d;
            if (i11 >= bArr.length) {
                break;
            }
            eVar2.a(new v0(bArr[i11]));
            i11++;
        }
        eVar.a(new z0(eVar2));
        e eVar3 = new e();
        while (true) {
            byte[][] bArr2 = this.f598e;
            if (i10 < bArr2.length) {
                eVar3.a(new v0(bArr2[i10]));
                i10++;
            } else {
                eVar.a(new z0(eVar3));
                e eVar4 = new e();
                eVar4.a(new v0(this.f599f));
                eVar.a(new z0(eVar4));
                return new z0(eVar);
            }
        }
    }

    public short[][] g() {
        return a.d(this.f597d);
    }

    public short[] i() {
        return a.b(this.f599f);
    }

    public short[][] j() {
        return a.d(this.f598e);
    }

    public int k() {
        return this.f596c.p().intValue();
    }

    public g(int i10, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f594a = new j(0);
        this.f596c = new j((long) i10);
        this.f597d = a.c(sArr);
        this.f598e = a.c(sArr2);
        this.f599f = a.a(sArr3);
    }
}
