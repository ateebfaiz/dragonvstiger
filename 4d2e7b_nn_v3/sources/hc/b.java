package hc;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import zd.a;

public abstract class b extends r {

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f350c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    protected final byte[] f351a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f352b;

    public b(byte[] bArr, int i10) {
        if (bArr == null) {
            throw new NullPointerException("data cannot be null");
        } else if (bArr.length == 0 && i10 != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        } else if (i10 > 7 || i10 < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        } else {
            this.f351a = a.e(bArr);
            this.f352b = i10;
        }
    }

    protected static byte[] o(byte[] bArr, int i10) {
        byte[] e10 = a.e(bArr);
        if (i10 > 0) {
            int length = bArr.length - 1;
            e10[length] = (byte) ((255 << i10) & e10[length]);
        }
        return e10;
    }

    static b p(int i10, InputStream inputStream) {
        if (i10 >= 1) {
            int read = inputStream.read();
            int i11 = i10 - 1;
            byte[] bArr = new byte[i11];
            if (i11 != 0) {
                if (be.a.c(inputStream, bArr) != i11) {
                    throw new EOFException("EOF encountered in middle of BIT STRING");
                } else if (read > 0 && read < 8) {
                    byte b10 = bArr[i10 - 2];
                    if (b10 != ((byte) ((255 << read) & b10))) {
                        return new j1(bArr, read);
                    }
                }
            }
            return new m0(bArr, read);
        }
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    /* access modifiers changed from: protected */
    public boolean g(r rVar) {
        if (!(rVar instanceof b)) {
            return false;
        }
        b bVar = (b) rVar;
        if (this.f352b != bVar.f352b || !a.a(q(), bVar.q())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f352b ^ a.m(q());
    }

    /* access modifiers changed from: package-private */
    public r m() {
        return new m0(this.f351a, this.f352b);
    }

    /* access modifiers changed from: package-private */
    public r n() {
        return new j1(this.f351a, this.f352b);
    }

    public byte[] q() {
        return o(this.f351a, this.f352b);
    }

    public byte[] r() {
        if (this.f352b == 0) {
            return a.e(this.f351a);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    public int s() {
        return this.f352b;
    }

    public String t() {
        StringBuffer stringBuffer = new StringBuffer("#");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new p(byteArrayOutputStream).j(this);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            for (int i10 = 0; i10 != byteArray.length; i10++) {
                char[] cArr = f350c;
                stringBuffer.append(cArr[(byteArray[i10] >>> 4) & 15]);
                stringBuffer.append(cArr[byteArray[i10] & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e10) {
            throw new q("Internal error encoding BitString: " + e10.getMessage(), e10);
        }
    }

    public String toString() {
        return t();
    }
}
