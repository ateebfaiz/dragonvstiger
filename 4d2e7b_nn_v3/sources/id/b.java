package id;

import java.math.BigInteger;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    static final a f464a = new g(BigInteger.valueOf(2));

    /* renamed from: b  reason: collision with root package name */
    static final a f465b = new g(BigInteger.valueOf(3));

    public static f a(int[] iArr) {
        if (iArr[0] == 0) {
            int i10 = 1;
            while (i10 < iArr.length) {
                if (iArr[i10] > iArr[i10 - 1]) {
                    i10++;
                } else {
                    throw new IllegalArgumentException("Polynomial exponents must be montonically increasing");
                }
            }
            return new d(f464a, new c(iArr));
        }
        throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
    }

    public static a b(BigInteger bigInteger) {
        int bitLength = bigInteger.bitLength();
        if (bigInteger.signum() <= 0 || bitLength < 2) {
            throw new IllegalArgumentException("'characteristic' must be >= 2");
        }
        if (bitLength < 3) {
            int intValue = bigInteger.intValue();
            if (intValue == 2) {
                return f464a;
            }
            if (intValue == 3) {
                return f465b;
            }
        }
        return new g(bigInteger);
    }
}
