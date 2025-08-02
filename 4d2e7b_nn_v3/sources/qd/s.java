package qd;

import qd.f;
import qd.h;

abstract class s {
    static r a(j jVar, m mVar, h hVar) {
        double d10;
        if (mVar == null) {
            throw new NullPointerException("publicKey == null");
        } else if (hVar != null) {
            int c10 = jVar.d().c();
            byte[][] a10 = mVar.a();
            r[] rVarArr = new r[a10.length];
            for (int i10 = 0; i10 < a10.length; i10++) {
                rVarArr[i10] = new r(0, a10[i10]);
            }
            n l10 = ((h.b) ((h.b) ((h.b) new h.b().g(hVar.b())).h(hVar.c())).n(hVar.e()).o(0).p(hVar.g()).f(hVar.a())).l();
            while (true) {
                h hVar2 = (h) l10;
                if (c10 <= 1) {
                    return rVarArr[0];
                }
                int i11 = 0;
                while (true) {
                    d10 = (double) (c10 / 2);
                    if (i11 >= ((int) Math.floor(d10))) {
                        break;
                    }
                    hVar2 = (h) ((h.b) ((h.b) ((h.b) new h.b().g(hVar2.b())).h(hVar2.c())).n(hVar2.e()).o(hVar2.f()).p(i11).f(hVar2.a())).l();
                    int i12 = i11 * 2;
                    rVarArr[i11] = b(jVar, rVarArr[i12], rVarArr[i12 + 1], hVar2);
                    i11++;
                }
                if (c10 % 2 == 1) {
                    rVarArr[(int) Math.floor(d10)] = rVarArr[c10 - 1];
                }
                c10 = (int) Math.ceil(((double) c10) / 2.0d);
                l10 = ((h.b) ((h.b) ((h.b) new h.b().g(hVar2.b())).h(hVar2.c())).n(hVar2.e()).o(hVar2.f() + 1).p(hVar2.g()).f(hVar2.a())).l();
            }
        } else {
            throw new NullPointerException("address == null");
        }
    }

    static r b(j jVar, r rVar, r rVar2, n nVar) {
        if (rVar == null) {
            throw new NullPointerException("left == null");
        } else if (rVar2 == null) {
            throw new NullPointerException("right == null");
        } else if (rVar.b() != rVar2.b()) {
            throw new IllegalStateException("height of both nodes must be equal");
        } else if (nVar != null) {
            byte[] f10 = jVar.f();
            if (nVar instanceof h) {
                h hVar = (h) nVar;
                nVar = (h) ((h.b) ((h.b) ((h.b) new h.b().g(hVar.b())).h(hVar.c())).n(hVar.e()).o(hVar.f()).p(hVar.g()).f(0)).l();
            } else if (nVar instanceof f) {
                f fVar = (f) nVar;
                nVar = (f) ((f.b) ((f.b) ((f.b) new f.b().g(fVar.b())).h(fVar.c())).m(fVar.e()).n(fVar.f()).f(0)).k();
            }
            byte[] c10 = jVar.c().c(f10, nVar.d());
            if (nVar instanceof h) {
                h hVar2 = (h) nVar;
                nVar = (h) ((h.b) ((h.b) ((h.b) new h.b().g(hVar2.b())).h(hVar2.c())).n(hVar2.e()).o(hVar2.f()).p(hVar2.g()).f(1)).l();
            } else if (nVar instanceof f) {
                f fVar2 = (f) nVar;
                nVar = (f) ((f.b) ((f.b) ((f.b) new f.b().g(fVar2.b())).h(fVar2.c())).m(fVar2.e()).n(fVar2.f()).f(1)).k();
            }
            byte[] c11 = jVar.c().c(f10, nVar.d());
            if (nVar instanceof h) {
                h hVar3 = (h) nVar;
                nVar = (h) ((h.b) ((h.b) ((h.b) new h.b().g(hVar3.b())).h(hVar3.c())).n(hVar3.e()).o(hVar3.f()).p(hVar3.g()).f(2)).l();
            } else if (nVar instanceof f) {
                f fVar3 = (f) nVar;
                nVar = (f) ((f.b) ((f.b) ((f.b) new f.b().g(fVar3.b())).h(fVar3.c())).m(fVar3.e()).n(fVar3.f()).f(2)).k();
            }
            byte[] c12 = jVar.c().c(f10, nVar.d());
            int b10 = jVar.d().b();
            byte[] bArr = new byte[(b10 * 2)];
            for (int i10 = 0; i10 < b10; i10++) {
                bArr[i10] = (byte) (rVar.c()[i10] ^ c11[i10]);
            }
            for (int i11 = 0; i11 < b10; i11++) {
                bArr[i11 + b10] = (byte) (rVar2.c()[i11] ^ c12[i11]);
            }
            return new r(rVar.b(), jVar.c().b(c10, bArr));
        } else {
            throw new NullPointerException("address == null");
        }
    }
}
