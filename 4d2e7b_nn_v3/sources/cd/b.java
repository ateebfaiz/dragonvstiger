package cd;

import dd.c;
import dd.f;
import id.a;
import id.e;
import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

public class b extends ECParameterSpec {

    /* renamed from: a  reason: collision with root package name */
    private String f115a;

    public b(String str, c cVar, f fVar, BigInteger bigInteger) {
        super(a(cVar, (byte[]) null), c(fVar), bigInteger, 1);
        this.f115a = str;
    }

    private static EllipticCurve a(c cVar, byte[] bArr) {
        return new EllipticCurve(b(cVar.o()), cVar.k().r(), cVar.l().r(), bArr);
    }

    private static ECField b(a aVar) {
        if (dd.a.d(aVar)) {
            return new ECFieldFp(aVar.c());
        }
        e a10 = ((id.f) aVar).a();
        int[] a11 = a10.a();
        return new ECFieldF2m(a10.b(), zd.a.u(zd.a.j(a11, 1, a11.length - 1)));
    }

    private static ECPoint c(f fVar) {
        f s10 = fVar.s();
        return new ECPoint(s10.e().r(), s10.f().r());
    }
}
