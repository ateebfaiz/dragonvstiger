package com.geetest.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;

public abstract class l0 extends p0 implements m0 {

    /* renamed from: a  reason: collision with root package name */
    public static final d1 f6064a = new a(l0.class, 4);

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f6065b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    public byte[] f6066c;

    public class a extends d1 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        public p0 a(d2 d2Var) {
            return d2Var;
        }

        public p0 a(s0 s0Var) {
            return s0Var.o();
        }
    }

    public l0(byte[] bArr) {
        if (bArr != null) {
            this.f6066c = bArr;
            return;
        }
        throw new NullPointerException("'string' cannot be null");
    }

    public boolean a(p0 p0Var) {
        if (!(p0Var instanceof l0)) {
            return false;
        }
        return Arrays.equals(this.f6066c, ((l0) p0Var).f6066c);
    }

    public p0 b() {
        return this;
    }

    public InputStream c() {
        return new ByteArrayInputStream(this.f6066c);
    }

    public p0 h() {
        return new d2(this.f6066c);
    }

    public int hashCode() {
        return c.c(this.f6066c);
    }

    public p0 i() {
        return new d2(this.f6066c);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("#");
        byte[] bArr = this.f6066c;
        m3 m3Var = l3.f6067a;
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m3 m3Var2 = l3.f6067a;
            m3Var2.getClass();
            if (length >= 0) {
                byte[] bArr2 = new byte[72];
                int i10 = 0;
                while (length > 0) {
                    int min = Math.min(36, length);
                    int i11 = i10 + min;
                    int i12 = 0;
                    while (i10 < i11) {
                        int i13 = i10 + 1;
                        byte b10 = bArr[i10];
                        int i14 = i12 + 1;
                        byte[] bArr3 = m3Var2.f6076a;
                        bArr2[i12] = bArr3[(b10 & 255) >>> 4];
                        i12 += 2;
                        bArr2[i14] = bArr3[b10 & 15];
                        i10 = i13;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i12);
                    length -= min;
                    i10 = i11;
                }
            }
            sb2.append(j3.a(byteArrayOutputStream.toByteArray()));
            return sb2.toString();
        } catch (Exception e10) {
            throw new k3("exception encoding Hex string: " + e10.getMessage(), e10);
        }
    }
}
