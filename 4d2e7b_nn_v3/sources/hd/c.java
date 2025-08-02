package hd;

import java.math.BigInteger;

public class c {

    /* renamed from: a  reason: collision with root package name */
    protected final BigInteger f450a;

    /* renamed from: b  reason: collision with root package name */
    protected final BigInteger f451b;

    /* renamed from: c  reason: collision with root package name */
    protected final BigInteger f452c;

    /* renamed from: d  reason: collision with root package name */
    protected final BigInteger f453d;

    /* renamed from: e  reason: collision with root package name */
    protected final BigInteger f454e;

    /* renamed from: f  reason: collision with root package name */
    protected final BigInteger f455f;

    /* renamed from: g  reason: collision with root package name */
    protected final BigInteger f456g;

    /* renamed from: h  reason: collision with root package name */
    protected final BigInteger f457h;

    /* renamed from: i  reason: collision with root package name */
    protected final int f458i;

    public c(BigInteger bigInteger, BigInteger bigInteger2, BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2, BigInteger bigInteger3, BigInteger bigInteger4, int i10) {
        a(bigIntegerArr, "v1");
        a(bigIntegerArr2, "v2");
        this.f450a = bigInteger;
        this.f451b = bigInteger2;
        this.f452c = bigIntegerArr[0];
        this.f453d = bigIntegerArr[1];
        this.f454e = bigIntegerArr2[0];
        this.f455f = bigIntegerArr2[1];
        this.f456g = bigInteger3;
        this.f457h = bigInteger4;
        this.f458i = i10;
    }

    private static void a(BigInteger[] bigIntegerArr, String str) {
        if (bigIntegerArr == null || bigIntegerArr.length != 2 || bigIntegerArr[0] == null || bigIntegerArr[1] == null) {
            throw new IllegalArgumentException("'" + str + "' must consist of exactly 2 (non-null) values");
        }
    }

    public BigInteger b() {
        return this.f450a;
    }
}
