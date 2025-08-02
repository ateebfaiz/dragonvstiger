package hc;

import com.alibaba.pdns.f;
import io.jsonwebtoken.JwtParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class m extends r {

    /* renamed from: c  reason: collision with root package name */
    private static final ConcurrentMap f390c = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final String f391a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f392b;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f393a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f394b;

        a(byte[] bArr) {
            this.f393a = zd.a.m(bArr);
            this.f394b = bArr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return zd.a.a(this.f394b, ((a) obj).f394b);
            }
            return false;
        }

        public int hashCode() {
            return this.f393a;
        }
    }

    m(byte[] bArr) {
        int i10;
        byte[] bArr2 = bArr;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z10 = true;
        BigInteger bigInteger = null;
        int i11 = 0;
        long j10 = 0;
        while (i11 != bArr2.length) {
            byte b10 = bArr2[i11];
            if (j10 <= 72057594037927808L) {
                i10 = i11;
                long j11 = j10 + ((long) (b10 & Byte.MAX_VALUE));
                if ((b10 & 128) == 0) {
                    if (z10) {
                        if (j11 < 40) {
                            stringBuffer.append('0');
                        } else if (j11 < 80) {
                            stringBuffer.append('1');
                            j11 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j11 -= 80;
                        }
                        z10 = false;
                    }
                    stringBuffer.append(JwtParser.SEPARATOR_CHAR);
                    stringBuffer.append(j11);
                } else {
                    j10 = j11 << 7;
                    i11 = i10 + 1;
                }
            } else {
                i10 = i11;
                BigInteger or = (bigInteger == null ? BigInteger.valueOf(j10) : bigInteger).or(BigInteger.valueOf((long) (b10 & Byte.MAX_VALUE)));
                if ((b10 & 128) == 0) {
                    if (z10) {
                        stringBuffer.append('2');
                        or = or.subtract(BigInteger.valueOf(80));
                        z10 = false;
                    }
                    stringBuffer.append(JwtParser.SEPARATOR_CHAR);
                    stringBuffer.append(or);
                    bigInteger = null;
                } else {
                    bigInteger = or.shiftLeft(7);
                    i11 = i10 + 1;
                }
            }
            j10 = 0;
            i11 = i10 + 1;
        }
        this.f391a = stringBuffer.toString();
        this.f392b = zd.a.e(bArr);
    }

    private void p(ByteArrayOutputStream byteArrayOutputStream) {
        u1 u1Var = new u1(this.f391a);
        int parseInt = Integer.parseInt(u1Var.b()) * 40;
        String b10 = u1Var.b();
        if (b10.length() <= 18) {
            w(byteArrayOutputStream, ((long) parseInt) + Long.parseLong(b10));
        } else {
            x(byteArrayOutputStream, new BigInteger(b10).add(BigInteger.valueOf((long) parseInt)));
        }
        while (u1Var.a()) {
            String b11 = u1Var.b();
            if (b11.length() <= 18) {
                w(byteArrayOutputStream, Long.parseLong(b11));
            } else {
                x(byteArrayOutputStream, new BigInteger(b11));
            }
        }
    }

    static m q(byte[] bArr) {
        m mVar = (m) f390c.get(new a(bArr));
        if (mVar == null) {
            return new m(bArr);
        }
        return mVar;
    }

    private synchronized byte[] r() {
        try {
            if (this.f392b == null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                p(byteArrayOutputStream);
                this.f392b = byteArrayOutputStream.toByteArray();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f392b;
    }

    public static m t(Object obj) {
        if (obj == null || (obj instanceof m)) {
            return (m) obj;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (dVar.c() instanceof m) {
                return (m) dVar.c();
            }
        }
        if (obj instanceof byte[]) {
            try {
                return (m) r.k((byte[]) obj);
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct object identifier from byte[]: " + e10.getMessage());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    private static boolean u(String str, int i10) {
        boolean z10;
        char charAt;
        int length = str.length();
        do {
            z10 = false;
            while (true) {
                length--;
                if (length < i10) {
                    return z10;
                }
                charAt = str.charAt(length);
                if ('0' <= charAt && charAt <= '9') {
                    z10 = true;
                }
            }
            if (charAt != '.') {
                break;
            }
        } while (z10);
        return false;
    }

    private static boolean v(String str) {
        char charAt;
        if (str.length() < 3 || str.charAt(1) != '.' || (charAt = str.charAt(0)) < '0' || charAt > '2') {
            return false;
        }
        return u(str, 2);
    }

    private void w(ByteArrayOutputStream byteArrayOutputStream, long j10) {
        byte[] bArr = new byte[9];
        int i10 = 8;
        bArr[8] = (byte) (((int) j10) & 127);
        while (j10 >= 128) {
            j10 >>= 7;
            i10--;
            bArr[i10] = (byte) ((((int) j10) & 127) | 128);
        }
        byteArrayOutputStream.write(bArr, i10, 9 - i10);
    }

    private void x(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[bitLength];
        int i10 = bitLength - 1;
        for (int i11 = i10; i11 >= 0; i11--) {
            bArr[i11] = (byte) ((bigInteger.intValue() & 127) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i10] = (byte) (bArr[i10] & Byte.MAX_VALUE);
        byteArrayOutputStream.write(bArr, 0, bitLength);
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (rVar == this) {
            return true;
        }
        if (!(rVar instanceof m)) {
            return false;
        }
        return this.f391a.equals(((m) rVar).f391a);
    }

    public int hashCode() {
        return this.f391a.hashCode();
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        byte[] r10 = r();
        pVar.c(6);
        pVar.i(r10.length);
        pVar.d(r10);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        int length = r().length;
        return v1.a(length) + 1 + length;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    public m o(String str) {
        return new m(this, str);
    }

    public String s() {
        return this.f391a;
    }

    public String toString() {
        return s();
    }

    public m(String str) {
        if (str == null) {
            throw new IllegalArgumentException("'identifier' cannot be null");
        } else if (v(str)) {
            this.f391a = str;
        } else {
            throw new IllegalArgumentException("string " + str + " not an OID");
        }
    }

    m(m mVar, String str) {
        if (u(str, 0)) {
            this.f391a = mVar.s() + f.G + str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not a valid OID branch");
    }
}
