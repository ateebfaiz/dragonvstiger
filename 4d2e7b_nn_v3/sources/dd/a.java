package dd;

import id.f;
import java.math.BigInteger;

public abstract class a {
    public static boolean a(c cVar) {
        return b(cVar.o());
    }

    public static boolean b(id.a aVar) {
        if (aVar.b() <= 1 || !aVar.c().equals(b.f123c) || !(aVar instanceof f)) {
            return false;
        }
        return true;
    }

    public static boolean c(c cVar) {
        return d(cVar.o());
    }

    public static boolean d(id.a aVar) {
        if (aVar.b() == 1) {
            return true;
        }
        return false;
    }

    public static void e(d[] dVarArr, int i10, int i11, d dVar) {
        d[] dVarArr2 = new d[i11];
        int i12 = 0;
        dVarArr2[0] = dVarArr[i10];
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= i11) {
                break;
            }
            dVarArr2[i13] = dVarArr2[i12].i(dVarArr[i10 + i13]);
            i12 = i13;
        }
        if (dVar != null) {
            dVarArr2[i12] = dVarArr2[i12].i(dVar);
        }
        d f10 = dVarArr2[i12].f();
        while (i12 > 0) {
            int i14 = i12 - 1;
            int i15 = i12 + i10;
            d dVar2 = dVarArr[i15];
            dVarArr[i15] = dVarArr2[i14].i(f10);
            f10 = f10.i(dVar2);
            i12 = i14;
        }
        dVarArr[i10] = f10;
    }

    public static f f(f fVar, BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        f q10 = fVar.g().q();
        int bitLength = abs.bitLength();
        if (bitLength > 0) {
            if (abs.testBit(0)) {
                q10 = fVar;
            }
            for (int i10 = 1; i10 < bitLength; i10++) {
                fVar = fVar.w();
                if (abs.testBit(i10)) {
                    q10 = q10.a(fVar);
                }
            }
        }
        if (bigInteger.signum() < 0) {
            return q10.r();
        }
        return q10;
    }
}
