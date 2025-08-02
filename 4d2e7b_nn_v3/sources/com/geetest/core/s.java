package com.geetest.core;

import androidx.core.view.InputDeviceCompat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class s extends p0 implements t {

    /* renamed from: a  reason: collision with root package name */
    public static final d1 f6167a = new a(s.class, 3);

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f6168b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f6169c;

    public class a extends d1 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        public p0 a(s0 s0Var) {
            return s0Var.n();
        }

        public p0 a(d2 d2Var) {
            return s.a(d2Var.f6066c);
        }
    }

    public s(byte[] bArr, int i10) {
        if (bArr == null) {
            throw new NullPointerException("'data' cannot be null");
        } else if (bArr.length == 0 && i10 != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        } else if (i10 > 7 || i10 < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        } else {
            this.f6169c = c.a(bArr, (byte) i10);
        }
    }

    public InputStream a() throws IOException {
        byte[] bArr = this.f6169c;
        return new ByteArrayInputStream(bArr, 1, bArr.length - 1);
    }

    public p0 b() {
        return this;
    }

    public int e() {
        return this.f6169c[0] & 255;
    }

    public p0 h() {
        return new u1(this.f6169c, false);
    }

    public int hashCode() {
        byte[] bArr = this.f6169c;
        if (bArr.length < 2) {
            return 1;
        }
        int length = bArr.length;
        int i10 = length - 1;
        byte b10 = (byte) ((255 << (bArr[0] & 255)) & bArr[i10]);
        while (true) {
            i10--;
            if (i10 < 0) {
                return (length * InputDeviceCompat.SOURCE_KEYBOARD) ^ b10;
            }
            length = (length * InputDeviceCompat.SOURCE_KEYBOARD) ^ bArr[i10];
        }
    }

    public p0 i() {
        return new p2(this.f6169c, false);
    }

    public String toString() {
        try {
            byte[] f10 = f();
            StringBuffer stringBuffer = new StringBuffer((f10.length * 2) + 1);
            stringBuffer.append('#');
            for (int i10 = 0; i10 != f10.length; i10++) {
                byte b10 = f10[i10];
                char[] cArr = f6168b;
                stringBuffer.append(cArr[(b10 >>> 4) & 15]);
                stringBuffer.append(cArr[b10 & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e10) {
            throw new o0("Internal error encoding BitString: " + e10.getMessage(), e10);
        }
    }

    public boolean a(p0 p0Var) {
        if (!(p0Var instanceof s)) {
            return false;
        }
        byte[] bArr = this.f6169c;
        byte[] bArr2 = ((s) p0Var).f6169c;
        int length = bArr.length;
        if (bArr2.length != length) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        int i10 = length - 1;
        for (int i11 = 0; i11 < i10; i11++) {
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
        }
        int i12 = 255 << (bArr[0] & 255);
        if (((byte) (bArr[i10] & i12)) == ((byte) (bArr2[i10] & i12))) {
            return true;
        }
        return false;
    }

    public s(byte[] bArr, boolean z10) {
        if (z10) {
            if (bArr == null) {
                throw new NullPointerException("'contents' cannot be null");
            } else if (bArr.length >= 1) {
                byte b10 = bArr[0] & 255;
                if (b10 > 0) {
                    if (bArr.length < 2) {
                        throw new IllegalArgumentException("zero length data with non-zero pad bits");
                    } else if (b10 > 7) {
                        throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
                    }
                }
            } else {
                throw new IllegalArgumentException("'contents' cannot be empty");
            }
        }
        this.f6169c = bArr;
    }

    public static s a(byte[] bArr) {
        int length = bArr.length;
        if (length >= 1) {
            byte b10 = bArr[0] & 255;
            if (b10 > 0) {
                if (b10 > 7 || length < 2) {
                    throw new IllegalArgumentException("invalid pad bits detected");
                }
                byte b11 = bArr[length - 1];
                if (b11 != ((byte) ((255 << b10) & b11))) {
                    return new p2(bArr, false);
                }
            }
            return new u1(bArr, false);
        }
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }
}
