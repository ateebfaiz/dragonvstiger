package com.geetest.core;

import com.geetest.core.k0;
import io.jsonwebtoken.JwtParser;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class r0 extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentMap<k0.a, r0> f6149a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f6150b;

    /* renamed from: c  reason: collision with root package name */
    public String f6151c = null;

    public r0(byte[] bArr, String str) {
        this.f6150b = bArr;
    }

    public boolean a(p0 p0Var) {
        if (this == p0Var) {
            return true;
        }
        if (!(p0Var instanceof r0)) {
            return false;
        }
        return Arrays.equals(this.f6150b, ((r0) p0Var).f6150b);
    }

    public boolean g() {
        return false;
    }

    public int hashCode() {
        return c.c(this.f6150b);
    }

    public String toString() {
        String str;
        synchronized (this) {
            try {
                if (this.f6151c == null) {
                    byte[] bArr = this.f6150b;
                    StringBuffer stringBuffer = new StringBuffer();
                    boolean z10 = true;
                    long j10 = 0;
                    BigInteger bigInteger = null;
                    for (int i10 = 0; i10 != bArr.length; i10++) {
                        byte b10 = bArr[i10];
                        if (j10 <= 72057594037927808L) {
                            long j11 = j10 + ((long) (b10 & Byte.MAX_VALUE));
                            if ((b10 & 128) == 0) {
                                if (z10) {
                                    z10 = false;
                                } else {
                                    stringBuffer.append(JwtParser.SEPARATOR_CHAR);
                                }
                                stringBuffer.append(j11);
                                j10 = 0;
                            } else {
                                j10 = j11 << 7;
                            }
                        } else {
                            if (bigInteger == null) {
                                bigInteger = BigInteger.valueOf(j10);
                            }
                            BigInteger or = bigInteger.or(BigInteger.valueOf((long) (b10 & Byte.MAX_VALUE)));
                            if ((b10 & 128) == 0) {
                                if (z10) {
                                    z10 = false;
                                } else {
                                    stringBuffer.append(JwtParser.SEPARATOR_CHAR);
                                }
                                stringBuffer.append(or);
                                j10 = 0;
                                bigInteger = null;
                            } else {
                                bigInteger = or.shiftLeft(7);
                            }
                        }
                    }
                    this.f6151c = stringBuffer.toString();
                }
                str = this.f6151c;
            } finally {
            }
        }
        return str;
    }

    public int a(boolean z10) {
        return n0.a(z10, this.f6150b.length);
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.a(z10, 13, this.f6150b);
    }

    public static r0 a(byte[] bArr, boolean z10) {
        if (bArr.length <= 4096) {
            r0 r0Var = f6149a.get(new k0.a(bArr));
            if (r0Var != null) {
                return r0Var;
            }
            if (a(bArr)) {
                if (z10) {
                    bArr = c.a(bArr);
                }
                return new r0(bArr, (String) null);
            }
            throw new IllegalArgumentException("invalid relative OID contents");
        }
        throw new IllegalArgumentException("exceeded relative OID contents length limit");
    }

    public static boolean a(byte[] bArr) {
        if (bArr.length < 1) {
            return false;
        }
        boolean z10 = true;
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (z10 && (bArr[i10] & 255) == 128) {
                return false;
            }
            z10 = (bArr[i10] & 128) == 0;
        }
        return z10;
    }
}
