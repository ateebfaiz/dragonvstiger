package org.cocos2dx.okio;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class f extends ByteString {

    /* renamed from: a  reason: collision with root package name */
    final transient byte[][] f1798a;

    /* renamed from: b  reason: collision with root package name */
    final transient int[] f1799b;

    f(Buffer buffer, int i10) {
        super((byte[]) null);
        g.b(buffer.size, 0, (long) i10);
        d dVar = buffer.head;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            int i14 = dVar.f1791c;
            int i15 = dVar.f1790b;
            if (i14 != i15) {
                i12 += i14 - i15;
                i13++;
                dVar = dVar.f1794f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f1798a = new byte[i13][];
        this.f1799b = new int[(i13 * 2)];
        d dVar2 = buffer.head;
        int i16 = 0;
        while (i11 < i10) {
            byte[][] bArr = this.f1798a;
            bArr[i16] = dVar2.f1789a;
            int i17 = dVar2.f1791c;
            int i18 = dVar2.f1790b;
            i11 += i17 - i18;
            if (i11 > i10) {
                i11 = i10;
            }
            int[] iArr = this.f1799b;
            iArr[i16] = i11;
            iArr[bArr.length + i16] = i18;
            dVar2.f1792d = true;
            i16++;
            dVar2 = dVar2.f1794f;
        }
    }

    private int a(int i10) {
        int binarySearch = Arrays.binarySearch(this.f1799b, 0, this.f1798a.length, i10 + 1);
        if (binarySearch >= 0) {
            return binarySearch;
        }
        return ~binarySearch;
    }

    private ByteString b() {
        return new ByteString(toByteArray());
    }

    private Object writeReplace() {
        return b();
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public String base64() {
        return b().base64();
    }

    public String base64Url() {
        return b().base64Url();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    public byte getByte(int i10) {
        int i11;
        g.b((long) this.f1799b[this.f1798a.length - 1], (long) i10, 1);
        int a10 = a(i10);
        if (a10 == 0) {
            i11 = 0;
        } else {
            i11 = this.f1799b[a10 - 1];
        }
        int[] iArr = this.f1799b;
        byte[][] bArr = this.f1798a;
        return bArr[a10][(i10 - i11) + iArr[bArr.length + a10]];
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int length = this.f1798a.length;
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        while (i11 < length) {
            byte[] bArr = this.f1798a[i11];
            int[] iArr = this.f1799b;
            int i14 = iArr[length + i11];
            int i15 = iArr[i11];
            int i16 = (i15 - i13) + i14;
            while (i14 < i16) {
                i12 = (i12 * 31) + bArr[i14];
                i14++;
            }
            i11++;
            i13 = i15;
        }
        this.hashCode = i12;
        return i12;
    }

    public String hex() {
        return b().hex();
    }

    public ByteString hmacSha1(ByteString byteString) {
        return b().hmacSha1(byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return b().hmacSha256(byteString);
    }

    public int indexOf(byte[] bArr, int i10) {
        return b().indexOf(bArr, i10);
    }

    /* access modifiers changed from: package-private */
    public byte[] internalArray() {
        return toByteArray();
    }

    public int lastIndexOf(byte[] bArr, int i10) {
        return b().lastIndexOf(bArr, i10);
    }

    public ByteString md5() {
        return b().md5();
    }

    public boolean rangeEquals(int i10, ByteString byteString, int i11, int i12) {
        int i13;
        if (i10 < 0 || i10 > size() - i12) {
            return false;
        }
        int a10 = a(i10);
        while (i12 > 0) {
            if (a10 == 0) {
                i13 = 0;
            } else {
                i13 = this.f1799b[a10 - 1];
            }
            int min = Math.min(i12, ((this.f1799b[a10] - i13) + i13) - i10);
            int[] iArr = this.f1799b;
            byte[][] bArr = this.f1798a;
            if (!byteString.rangeEquals(i11, bArr[a10], (i10 - i13) + iArr[bArr.length + a10], min)) {
                return false;
            }
            i10 += min;
            i11 += min;
            i12 -= min;
            a10++;
        }
        return true;
    }

    public ByteString sha1() {
        return b().sha1();
    }

    public ByteString sha256() {
        return b().sha256();
    }

    public int size() {
        return this.f1799b[this.f1798a.length - 1];
    }

    public String string(Charset charset) {
        return b().string(charset);
    }

    public ByteString substring(int i10) {
        return b().substring(i10);
    }

    public ByteString toAsciiLowercase() {
        return b().toAsciiLowercase();
    }

    public ByteString toAsciiUppercase() {
        return b().toAsciiUppercase();
    }

    public byte[] toByteArray() {
        int[] iArr = this.f1799b;
        byte[][] bArr = this.f1798a;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr2 = this.f1799b;
            int i12 = iArr2[length + i10];
            int i13 = iArr2[i10];
            System.arraycopy(this.f1798a[i10], i12, bArr2, i11, i13 - i11);
            i10++;
            i11 = i13;
        }
        return bArr2;
    }

    public String toString() {
        return b().toString();
    }

    public String utf8() {
        return b().utf8();
    }

    public void write(OutputStream outputStream) {
        if (outputStream != null) {
            int length = this.f1798a.length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                int[] iArr = this.f1799b;
                int i12 = iArr[length + i10];
                int i13 = iArr[i10];
                outputStream.write(this.f1798a[i10], i12, i13 - i11);
                i10++;
                i11 = i13;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    public ByteString substring(int i10, int i11) {
        return b().substring(i10, i11);
    }

    /* access modifiers changed from: package-private */
    public void write(Buffer buffer) {
        int length = this.f1798a.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr = this.f1799b;
            int i12 = iArr[length + i10];
            int i13 = iArr[i10];
            d dVar = new d(this.f1798a[i10], i12, (i12 + i13) - i11, true, false);
            d dVar2 = buffer.head;
            if (dVar2 == null) {
                dVar.f1795g = dVar;
                dVar.f1794f = dVar;
                buffer.head = dVar;
            } else {
                dVar2.f1795g.c(dVar);
            }
            i10++;
            i11 = i13;
        }
        buffer.size += (long) i11;
    }

    public boolean rangeEquals(int i10, byte[] bArr, int i11, int i12) {
        int i13;
        if (i10 < 0 || i10 > size() - i12 || i11 < 0 || i11 > bArr.length - i12) {
            return false;
        }
        int a10 = a(i10);
        while (i12 > 0) {
            if (a10 == 0) {
                i13 = 0;
            } else {
                i13 = this.f1799b[a10 - 1];
            }
            int min = Math.min(i12, ((this.f1799b[a10] - i13) + i13) - i10);
            int[] iArr = this.f1799b;
            byte[][] bArr2 = this.f1798a;
            if (!g.a(bArr2[a10], (i10 - i13) + iArr[bArr2.length + a10], bArr, i11, min)) {
                return false;
            }
            i10 += min;
            i11 += min;
            i12 -= min;
            a10++;
        }
        return true;
    }
}
