package com.geetest.core;

import io.jsonwebtoken.JwtParser;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class k0 extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentMap<a, k0> f6054a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f6055b;

    /* renamed from: c  reason: collision with root package name */
    public String f6056c = null;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f6057a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f6058b;

        public a(byte[] bArr) {
            this.f6057a = c.c(bArr);
            this.f6058b = bArr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return Arrays.equals(this.f6058b, ((a) obj).f6058b);
            }
            return false;
        }

        public int hashCode() {
            return this.f6057a;
        }
    }

    public k0(byte[] bArr, String str) {
        this.f6055b = bArr;
    }

    public int a(boolean z10) {
        return n0.a(z10, this.f6055b.length);
    }

    public boolean g() {
        return false;
    }

    public int hashCode() {
        return c.c(this.f6055b);
    }

    public String toString() {
        String str;
        synchronized (this) {
            try {
                if (this.f6056c == null) {
                    byte[] bArr = this.f6055b;
                    StringBuilder sb2 = new StringBuilder();
                    boolean z10 = true;
                    long j10 = 0;
                    BigInteger bigInteger = null;
                    for (int i10 = 0; i10 != bArr.length; i10++) {
                        byte b10 = bArr[i10];
                        if (j10 <= 72057594037927808L) {
                            long j11 = j10 + ((long) (b10 & Byte.MAX_VALUE));
                            if ((b10 & 128) == 0) {
                                if (z10) {
                                    if (j11 < 40) {
                                        sb2.append('0');
                                    } else if (j11 < 80) {
                                        sb2.append('1');
                                        j11 -= 40;
                                    } else {
                                        sb2.append('2');
                                        j11 -= 80;
                                    }
                                    z10 = false;
                                }
                                sb2.append(JwtParser.SEPARATOR_CHAR);
                                sb2.append(j11);
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
                                    sb2.append('2');
                                    or = or.subtract(BigInteger.valueOf(80));
                                    z10 = false;
                                }
                                sb2.append(JwtParser.SEPARATOR_CHAR);
                                sb2.append(or);
                                j10 = 0;
                                bigInteger = null;
                            } else {
                                bigInteger = or.shiftLeft(7);
                            }
                        }
                    }
                    this.f6056c = sb2.toString();
                }
                str = this.f6056c;
            } finally {
            }
        }
        return str;
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.a(z10, 6, this.f6055b);
    }

    public boolean a(p0 p0Var) {
        if (this == p0Var) {
            return true;
        }
        if (!(p0Var instanceof k0)) {
            return false;
        }
        return Arrays.equals(this.f6055b, ((k0) p0Var).f6055b);
    }

    public static k0 a(byte[] bArr, boolean z10) {
        if (bArr.length <= 4096) {
            k0 k0Var = f6054a.get(new a(bArr));
            if (k0Var != null) {
                return k0Var;
            }
            if (r0.a(bArr)) {
                if (z10) {
                    bArr = c.a(bArr);
                }
                return new k0(bArr, (String) null);
            }
            throw new IllegalArgumentException("invalid OID contents");
        }
        throw new IllegalArgumentException("exceeded OID contents length limit");
    }
}
