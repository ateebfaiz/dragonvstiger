package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.j;
import kotlin.jvm.internal.m;
import okio.internal.ByteStringKt;
import okio.internal.SegmentedByteStringKt;

public final class SegmentedByteString extends ByteString {
    private final transient int[] directory;
    private final transient byte[][] segments;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.EMPTY.getData$okio());
        m.f(bArr, "segments");
        m.f(iArr, "directory");
        this.segments = bArr;
        this.directory = iArr;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        if (byteString != null) {
            return byteString;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        m.e(asReadOnlyBuffer, "ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    public String base64() {
        return toByteString().base64();
    }

    public String base64Url() {
        return toByteString().base64Url();
    }

    public ByteString digest$okio(String str) {
        m.f(str, "algorithm");
        return ByteStringKt.commonSegmentDigest(this, str);
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

    public final int[] getDirectory$okio() {
        return this.directory;
    }

    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i10 < length) {
            int i13 = getDirectory$okio()[length + i10];
            int i14 = getDirectory$okio()[i10];
            byte[] bArr = getSegments$okio()[i10];
            int i15 = (i14 - i12) + i13;
            while (i13 < i15) {
                i11 = (i11 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i12 = i14;
        }
        setHashCode$okio(i11);
        return i11;
    }

    public String hex() {
        return toByteString().hex();
    }

    public ByteString hmac$okio(String str, ByteString byteString) {
        m.f(str, "algorithm");
        m.f(byteString, "key");
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            int length = getSegments$okio().length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                int i12 = getDirectory$okio()[length + i10];
                int i13 = getDirectory$okio()[i10];
                instance.update(getSegments$okio()[i10], i12, i13 - i11);
                i10++;
                i11 = i13;
            }
            byte[] doFinal = instance.doFinal();
            m.e(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public int indexOf(byte[] bArr, int i10) {
        m.f(bArr, "other");
        return toByteString().indexOf(bArr, i10);
    }

    public byte[] internalArray$okio() {
        return toByteArray();
    }

    public byte internalGet$okio(int i10) {
        int i11;
        Util.checkOffsetAndCount((long) getDirectory$okio()[getSegments$okio().length - 1], (long) i10, 1);
        int segment = SegmentedByteStringKt.segment(this, i10);
        if (segment == 0) {
            i11 = 0;
        } else {
            i11 = getDirectory$okio()[segment - 1];
        }
        return getSegments$okio()[segment][(i10 - i11) + getDirectory$okio()[getSegments$okio().length + segment]];
    }

    public int lastIndexOf(byte[] bArr, int i10) {
        m.f(bArr, "other");
        return toByteString().lastIndexOf(bArr, i10);
    }

    public boolean rangeEquals(int i10, ByteString byteString, int i11, int i12) {
        int i13;
        m.f(byteString, "other");
        if (i10 < 0 || i10 > size() - i12) {
            return false;
        }
        int i14 = i12 + i10;
        int segment = SegmentedByteStringKt.segment(this, i10);
        while (i10 < i14) {
            if (segment == 0) {
                i13 = 0;
            } else {
                i13 = getDirectory$okio()[segment - 1];
            }
            int i15 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i14, (getDirectory$okio()[segment] - i13) + i13) - i10;
            if (!byteString.rangeEquals(i11, getSegments$okio()[segment], i15 + (i10 - i13), min)) {
                return false;
            }
            i11 += min;
            i10 += min;
            segment++;
        }
        return true;
    }

    public String string(Charset charset) {
        m.f(charset, "charset");
        return toByteString().string(charset);
    }

    public ByteString substring(int i10, int i11) {
        boolean z10;
        boolean z11;
        boolean z12;
        int i12 = 0;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i11 <= size()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                int i13 = i11 - i10;
                if (i13 >= 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    throw new IllegalArgumentException(("endIndex=" + i11 + " < beginIndex=" + i10).toString());
                } else if (i10 == 0 && i11 == size()) {
                    return this;
                } else {
                    if (i10 == i11) {
                        return ByteString.EMPTY;
                    }
                    int segment = SegmentedByteStringKt.segment(this, i10);
                    int segment2 = SegmentedByteStringKt.segment(this, i11 - 1);
                    byte[][] bArr = (byte[][]) j.i(getSegments$okio(), segment, segment2 + 1);
                    int[] iArr = new int[(bArr.length * 2)];
                    if (segment <= segment2) {
                        int i14 = 0;
                        int i15 = segment;
                        while (true) {
                            iArr[i14] = Math.min(getDirectory$okio()[i15] - i10, i13);
                            int i16 = i14 + 1;
                            iArr[i14 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i15];
                            if (i15 == segment2) {
                                break;
                            }
                            i15++;
                            i14 = i16;
                        }
                    }
                    if (segment != 0) {
                        i12 = getDirectory$okio()[segment - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = iArr[length] + (i10 - i12);
                    return new SegmentedByteString(bArr, iArr);
                }
            } else {
                throw new IllegalArgumentException(("endIndex=" + i11 + " > length(" + size() + ')').toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex=" + i10 + " < 0").toString());
        }
    }

    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = getDirectory$okio()[length + i10];
            int i14 = getDirectory$okio()[i10];
            int i15 = i14 - i11;
            j.d(getSegments$okio()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    public String toString() {
        return toByteString().toString();
    }

    public void write(OutputStream outputStream) throws IOException {
        m.f(outputStream, "out");
        int length = getSegments$okio().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = getDirectory$okio()[length + i10];
            int i13 = getDirectory$okio()[i10];
            outputStream.write(getSegments$okio()[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
    }

    public void write$okio(Buffer buffer, int i10, int i11) {
        int i12;
        m.f(buffer, "buffer");
        int i13 = i10 + i11;
        int segment = SegmentedByteStringKt.segment(this, i10);
        while (i10 < i13) {
            if (segment == 0) {
                i12 = 0;
            } else {
                i12 = getDirectory$okio()[segment - 1];
            }
            int i14 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i13, (getDirectory$okio()[segment] - i12) + i12) - i10;
            int i15 = i14 + (i10 - i12);
            Segment segment2 = new Segment(getSegments$okio()[segment], i15, i15 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                m.c(segment3);
                Segment segment4 = segment3.prev;
                m.c(segment4);
                segment4.push(segment2);
            }
            i10 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + ((long) i11));
    }

    public boolean rangeEquals(int i10, byte[] bArr, int i11, int i12) {
        int i13;
        m.f(bArr, "other");
        if (i10 < 0 || i10 > size() - i12 || i11 < 0 || i11 > bArr.length - i12) {
            return false;
        }
        int i14 = i12 + i10;
        int segment = SegmentedByteStringKt.segment(this, i10);
        while (i10 < i14) {
            if (segment == 0) {
                i13 = 0;
            } else {
                i13 = getDirectory$okio()[segment - 1];
            }
            int i15 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i14, (getDirectory$okio()[segment] - i13) + i13) - i10;
            if (!Util.arrayRangeEquals(getSegments$okio()[segment], i15 + (i10 - i13), bArr, i11, min)) {
                return false;
            }
            i11 += min;
            i10 += min;
            segment++;
        }
        return true;
    }
}
