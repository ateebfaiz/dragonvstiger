package v9;

import java.math.BigInteger;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;

public abstract class a {
    public static boolean a(BigInteger bigInteger, BigInteger bigInteger2, ECParameterSpec eCParameterSpec) {
        EllipticCurve curve = eCParameterSpec.getCurve();
        BigInteger a10 = curve.getA();
        BigInteger b10 = curve.getB();
        BigInteger p10 = ((ECFieldFp) curve.getField()).getP();
        return bigInteger2.pow(2).mod(p10).equals(bigInteger.pow(3).add(a10.multiply(bigInteger)).add(b10).mod(p10));
    }
}
