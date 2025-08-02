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
import nd.a;

public class f extends l {

    /* renamed from: a  reason: collision with root package name */
    private j f586a;

    /* renamed from: b  reason: collision with root package name */
    private m f587b;

    /* renamed from: c  reason: collision with root package name */
    private byte[][] f588c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f589d;

    /* renamed from: e  reason: collision with root package name */
    private byte[][] f590e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f591f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f592g;

    /* renamed from: h  reason: collision with root package name */
    private a[] f593h;

    private f(s sVar) {
        s sVar2 = sVar;
        int i10 = 0;
        if (sVar2.q(0) instanceof j) {
            this.f586a = j.o(sVar2.q(0));
        } else {
            this.f587b = m.t(sVar2.q(0));
        }
        s sVar3 = (s) sVar2.q(1);
        this.f588c = new byte[sVar3.size()][];
        for (int i11 = 0; i11 < sVar3.size(); i11++) {
            this.f588c[i11] = ((n) sVar3.q(i11)).q();
        }
        this.f589d = ((n) ((s) sVar2.q(2)).q(0)).q();
        s sVar4 = (s) sVar2.q(3);
        this.f590e = new byte[sVar4.size()][];
        for (int i12 = 0; i12 < sVar4.size(); i12++) {
            this.f590e[i12] = ((n) sVar4.q(i12)).q();
        }
        this.f591f = ((n) ((s) sVar2.q(4)).q(0)).q();
        this.f592g = ((n) ((s) sVar2.q(5)).q(0)).q();
        s sVar5 = (s) sVar2.q(6);
        byte[][][][] bArr = new byte[sVar5.size()][][][];
        byte[][][][] bArr2 = new byte[sVar5.size()][][][];
        byte[][][] bArr3 = new byte[sVar5.size()][][];
        byte[][] bArr4 = new byte[sVar5.size()][];
        int i13 = 0;
        while (i13 < sVar5.size()) {
            s sVar6 = (s) sVar5.q(i13);
            s sVar7 = (s) sVar6.q(i10);
            bArr[i13] = new byte[sVar7.size()][][];
            for (int i14 = i10; i14 < sVar7.size(); i14++) {
                s sVar8 = (s) sVar7.q(i14);
                bArr[i13][i14] = new byte[sVar8.size()][];
                for (int i15 = 0; i15 < sVar8.size(); i15++) {
                    bArr[i13][i14][i15] = ((n) sVar8.q(i15)).q();
                }
            }
            s sVar9 = (s) sVar6.q(1);
            bArr2[i13] = new byte[sVar9.size()][][];
            for (int i16 = 0; i16 < sVar9.size(); i16++) {
                s sVar10 = (s) sVar9.q(i16);
                bArr2[i13][i16] = new byte[sVar10.size()][];
                for (int i17 = 0; i17 < sVar10.size(); i17++) {
                    bArr2[i13][i16][i17] = ((n) sVar10.q(i17)).q();
                }
            }
            s sVar11 = (s) sVar6.q(2);
            bArr3[i13] = new byte[sVar11.size()][];
            for (int i18 = 0; i18 < sVar11.size(); i18++) {
                bArr3[i13][i18] = ((n) sVar11.q(i18)).q();
            }
            bArr4[i13] = ((n) sVar6.q(3)).q();
            i13++;
            i10 = 0;
        }
        int length = this.f592g.length - 1;
        this.f593h = new a[length];
        int i19 = 0;
        while (i19 < length) {
            byte[] bArr5 = this.f592g;
            int i20 = i19 + 1;
            this.f593h[i19] = new a(bArr5[i19], bArr5[i20], od.a.f(bArr[i19]), od.a.f(bArr2[i19]), od.a.d(bArr3[i19]), od.a.b(bArr4[i19]));
            i19 = i20;
        }
    }

    public static f j(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(s.o(obj));
        }
        return null;
    }

    public r c() {
        e eVar = new e();
        j jVar = this.f586a;
        if (jVar != null) {
            eVar.a(jVar);
        } else {
            eVar.a(this.f587b);
        }
        e eVar2 = new e();
        int i10 = 0;
        while (true) {
            byte[][] bArr = this.f588c;
            if (i10 >= bArr.length) {
                break;
            }
            eVar2.a(new v0(bArr[i10]));
            i10++;
        }
        eVar.a(new z0(eVar2));
        e eVar3 = new e();
        eVar3.a(new v0(this.f589d));
        eVar.a(new z0(eVar3));
        e eVar4 = new e();
        int i11 = 0;
        while (true) {
            byte[][] bArr2 = this.f590e;
            if (i11 >= bArr2.length) {
                break;
            }
            eVar4.a(new v0(bArr2[i11]));
            i11++;
        }
        eVar.a(new z0(eVar4));
        e eVar5 = new e();
        eVar5.a(new v0(this.f591f));
        eVar.a(new z0(eVar5));
        e eVar6 = new e();
        eVar6.a(new v0(this.f592g));
        eVar.a(new z0(eVar6));
        e eVar7 = new e();
        for (int i12 = 0; i12 < this.f593h.length; i12++) {
            e eVar8 = new e();
            byte[][][] e10 = od.a.e(this.f593h[i12].a());
            e eVar9 = new e();
            for (byte[][] bArr3 : e10) {
                e eVar10 = new e();
                int i13 = 0;
                while (true) {
                    if (i13 >= bArr3.length) {
                        break;
                    }
                    eVar10.a(new v0(bArr3[i13]));
                    i13++;
                }
                eVar9.a(new z0(eVar10));
            }
            eVar8.a(new z0(eVar9));
            byte[][][] e11 = od.a.e(this.f593h[i12].b());
            e eVar11 = new e();
            for (byte[][] bArr4 : e11) {
                e eVar12 = new e();
                int i14 = 0;
                while (true) {
                    if (i14 >= bArr4.length) {
                        break;
                    }
                    eVar12.a(new v0(bArr4[i14]));
                    i14++;
                }
                eVar11.a(new z0(eVar12));
            }
            eVar8.a(new z0(eVar11));
            byte[][] c10 = od.a.c(this.f593h[i12].d());
            e eVar13 = new e();
            for (byte[] v0Var : c10) {
                eVar13.a(new v0(v0Var));
            }
            eVar8.a(new z0(eVar13));
            eVar8.a(new v0(od.a.a(this.f593h[i12].c())));
            eVar7.a(new z0(eVar8));
        }
        eVar.a(new z0(eVar7));
        return new z0(eVar);
    }

    public short[] g() {
        return od.a.b(this.f589d);
    }

    public short[] i() {
        return od.a.b(this.f591f);
    }

    public short[][] k() {
        return od.a.d(this.f588c);
    }

    public short[][] l() {
        return od.a.d(this.f590e);
    }

    public a[] m() {
        return this.f593h;
    }

    public int[] n() {
        return od.a.g(this.f592g);
    }

    public f(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, a[] aVarArr) {
        this.f586a = new j(1);
        this.f588c = od.a.c(sArr);
        this.f589d = od.a.a(sArr2);
        this.f590e = od.a.c(sArr3);
        this.f591f = od.a.a(sArr4);
        this.f592g = od.a.h(iArr);
        this.f593h = aVarArr;
    }
}
