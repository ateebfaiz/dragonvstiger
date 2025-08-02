package zd;

import java.math.BigInteger;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final BigInteger f2244a = BigInteger.valueOf(0);

    public static BigInteger a(byte[] bArr, int i10, int i11) {
        if (!(i10 == 0 && i11 == bArr.length)) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            bArr = bArr2;
        }
        return new BigInteger(1, bArr);
    }
}
