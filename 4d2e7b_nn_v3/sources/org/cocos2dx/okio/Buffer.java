package org.cocos2dx.okio;

import androidx.core.location.LocationRequestCompat;
import androidx.work.WorkRequest;
import com.alibaba.pdns.j;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.internal.connection.RealConnection;
import okio.Utf8;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;
    d head;
    long size;

    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public int end = -1;
        public long offset = -1;
        public boolean readWrite;
        private d segment;
        public int start = -1;

        public void close() {
            if (this.buffer != null) {
                this.buffer = null;
                this.segment = null;
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }

        public final long expandBuffer(int i10) {
            if (i10 <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i10);
            } else if (i10 <= 8192) {
                Buffer buffer2 = this.buffer;
                if (buffer2 == null) {
                    throw new IllegalStateException("not attached to a buffer");
                } else if (this.readWrite) {
                    long j10 = buffer2.size;
                    d writableSegment = buffer2.writableSegment(i10);
                    int i11 = 8192 - writableSegment.f1791c;
                    writableSegment.f1791c = 8192;
                    long j11 = (long) i11;
                    this.buffer.size = j10 + j11;
                    this.segment = writableSegment;
                    this.offset = j10;
                    this.data = writableSegment.f1789a;
                    this.start = 8192 - i11;
                    this.end = 8192;
                    return j11;
                } else {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                }
            } else {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i10);
            }
        }

        public final int next() {
            long j10 = this.offset;
            if (j10 == this.buffer.size) {
                throw new IllegalStateException();
            } else if (j10 == -1) {
                return seek(0);
            } else {
                return seek(j10 + ((long) (this.end - this.start)));
            }
        }

        public final long resizeBuffer(long j10) {
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer");
            } else if (this.readWrite) {
                long j11 = buffer2.size;
                int i10 = (j10 > j11 ? 1 : (j10 == j11 ? 0 : -1));
                if (i10 <= 0) {
                    if (j10 >= 0) {
                        long j12 = j11 - j10;
                        while (true) {
                            if (j12 <= 0) {
                                break;
                            }
                            Buffer buffer3 = this.buffer;
                            d dVar = buffer3.head.f1795g;
                            int i11 = dVar.f1791c;
                            long j13 = (long) (i11 - dVar.f1790b);
                            if (j13 > j12) {
                                dVar.f1791c = (int) (((long) i11) - j12);
                                break;
                            }
                            buffer3.head = dVar.b();
                            e.a(dVar);
                            j12 -= j13;
                        }
                        this.segment = null;
                        this.offset = j10;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else {
                        throw new IllegalArgumentException("newSize < 0: " + j10);
                    }
                } else if (i10 > 0) {
                    long j14 = j10 - j11;
                    boolean z10 = true;
                    while (j14 > 0) {
                        d writableSegment = this.buffer.writableSegment(1);
                        int min = (int) Math.min(j14, (long) (8192 - writableSegment.f1791c));
                        int i12 = writableSegment.f1791c + min;
                        writableSegment.f1791c = i12;
                        j14 -= (long) min;
                        if (z10) {
                            this.segment = writableSegment;
                            this.offset = j11;
                            this.data = writableSegment.f1789a;
                            this.start = i12 - min;
                            this.end = i12;
                            z10 = false;
                        }
                    }
                }
                this.buffer.size = j10;
                return j11;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
        }

        public final int seek(long j10) {
            int i10 = (j10 > -1 ? 1 : (j10 == -1 ? 0 : -1));
            if (i10 >= 0) {
                Buffer buffer2 = this.buffer;
                long j11 = buffer2.size;
                if (j10 <= j11) {
                    if (i10 == 0 || j10 == j11) {
                        this.segment = null;
                        this.offset = j10;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    d dVar = buffer2.head;
                    d dVar2 = this.segment;
                    long j12 = 0;
                    if (dVar2 != null) {
                        long j13 = this.offset - ((long) (this.start - dVar2.f1790b));
                        if (j13 > j10) {
                            j11 = j13;
                            d dVar3 = dVar2;
                            dVar2 = dVar;
                            dVar = dVar3;
                        } else {
                            j12 = j13;
                        }
                    } else {
                        dVar2 = dVar;
                    }
                    if (j11 - j10 > j10 - j12) {
                        while (true) {
                            int i11 = dVar2.f1791c;
                            int i12 = dVar2.f1790b;
                            if (j10 < ((long) (i11 - i12)) + j12) {
                                break;
                            }
                            j12 += (long) (i11 - i12);
                            dVar2 = dVar2.f1794f;
                        }
                    } else {
                        while (j11 > j10) {
                            dVar = dVar.f1795g;
                            j11 -= (long) (dVar.f1791c - dVar.f1790b);
                        }
                        dVar2 = dVar;
                        j12 = j11;
                    }
                    if (this.readWrite && dVar2.f1792d) {
                        d f10 = dVar2.f();
                        Buffer buffer3 = this.buffer;
                        if (buffer3.head == dVar2) {
                            buffer3.head = f10;
                        }
                        dVar2 = dVar2.c(f10);
                        dVar2.f1795g.b();
                    }
                    this.segment = dVar2;
                    this.offset = j10;
                    this.data = dVar2.f1789a;
                    int i13 = dVar2.f1790b + ((int) (j10 - j12));
                    this.start = i13;
                    int i14 = dVar2.f1791c;
                    this.end = i14;
                    return i14 - i13;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(j10), Long.valueOf(this.buffer.size)}));
        }
    }

    class a extends OutputStream {
        a() {
        }

        public void close() {
        }

        public void flush() {
        }

        public String toString() {
            return Buffer.this + ".outputStream()";
        }

        public void write(int i10) {
            Buffer.this.writeByte((int) (byte) i10);
        }

        public void write(byte[] bArr, int i10, int i11) {
            Buffer.this.write(bArr, i10, i11);
        }
    }

    class b extends InputStream {
        b() {
        }

        public int available() {
            return (int) Math.min(Buffer.this.size, 2147483647L);
        }

        public void close() {
        }

        public int read() {
            Buffer buffer = Buffer.this;
            if (buffer.size > 0) {
                return buffer.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return Buffer.this + ".inputStream()";
        }

        public int read(byte[] bArr, int i10, int i11) {
            return Buffer.this.read(bArr, i10, i11);
        }
    }

    private ByteString digest(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            d dVar = this.head;
            if (dVar != null) {
                byte[] bArr = dVar.f1789a;
                int i10 = dVar.f1790b;
                instance.update(bArr, i10, dVar.f1791c - i10);
                d dVar2 = this.head;
                while (true) {
                    dVar2 = dVar2.f1794f;
                    if (dVar2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = dVar2.f1789a;
                    int i11 = dVar2.f1790b;
                    instance.update(bArr2, i11, dVar2.f1791c - i11);
                }
            }
            return ByteString.of(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            d dVar = this.head;
            if (dVar != null) {
                byte[] bArr = dVar.f1789a;
                int i10 = dVar.f1790b;
                instance.update(bArr, i10, dVar.f1791c - i10);
                d dVar2 = this.head;
                while (true) {
                    dVar2 = dVar2.f1794f;
                    if (dVar2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = dVar2.f1789a;
                    int i11 = dVar2.f1790b;
                    instance.update(bArr2, i11, dVar2.f1791c - i11);
                }
            }
            return ByteString.of(instance.doFinal());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j10 = this.size;
        if (j10 == 0) {
            return 0;
        }
        d dVar = this.head.f1795g;
        int i10 = dVar.f1791c;
        if (i10 >= 8192 || !dVar.f1793e) {
            return j10;
        }
        return j10 - ((long) (i10 - dVar.f1790b));
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0, this.size);
    }

    public BufferedSink emit() {
        return this;
    }

    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j10 = this.size;
        if (j10 != buffer.size) {
            return false;
        }
        long j11 = 0;
        if (j10 == 0) {
            return true;
        }
        d dVar = this.head;
        d dVar2 = buffer.head;
        int i10 = dVar.f1790b;
        int i11 = dVar2.f1790b;
        while (j11 < this.size) {
            long min = (long) Math.min(dVar.f1791c - i10, dVar2.f1791c - i11);
            int i12 = 0;
            while (((long) i12) < min) {
                int i13 = i10 + 1;
                int i14 = i11 + 1;
                if (dVar.f1789a[i10] != dVar2.f1789a[i11]) {
                    return false;
                }
                i12++;
                i10 = i13;
                i11 = i14;
            }
            if (i10 == dVar.f1791c) {
                dVar = dVar.f1794f;
                i10 = dVar.f1790b;
            }
            if (i11 == dVar2.f1791c) {
                dVar2 = dVar2.f1794f;
                i11 = dVar2.f1790b;
            }
            j11 += min;
        }
        return true;
    }

    public boolean exhausted() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public void flush() {
    }

    public final byte getByte(long j10) {
        int i10;
        g.b(this.size, j10, 1);
        long j11 = this.size;
        if (j11 - j10 > j10) {
            d dVar = this.head;
            while (true) {
                int i11 = dVar.f1791c;
                int i12 = dVar.f1790b;
                long j12 = (long) (i11 - i12);
                if (j10 < j12) {
                    return dVar.f1789a[i12 + ((int) j10)];
                }
                j10 -= j12;
                dVar = dVar.f1794f;
            }
        } else {
            long j13 = j10 - j11;
            d dVar2 = this.head;
            do {
                dVar2 = dVar2.f1795g;
                int i13 = dVar2.f1791c;
                i10 = dVar2.f1790b;
                j13 += (long) (i13 - i10);
            } while (j13 < 0);
            return dVar2.f1789a[i10 + ((int) j13)];
        }
    }

    public int hashCode() {
        d dVar = this.head;
        if (dVar == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = dVar.f1791c;
            for (int i12 = dVar.f1790b; i12 < i11; i12++) {
                i10 = (i10 * 31) + dVar.f1789a[i12];
            }
            dVar = dVar.f1794f;
        } while (dVar != this.head);
        return i10;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    public long indexOf(byte b10) {
        return indexOf(b10, 0, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public InputStream inputStream() {
        return new b();
    }

    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest(j.f17955b);
    }

    public OutputStream outputStream() {
        return new a();
    }

    public boolean rangeEquals(long j10, ByteString byteString) {
        return rangeEquals(j10, byteString, 0, byteString.size());
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public long readAll(Sink sink) throws IOException {
        long j10 = this.size;
        if (j10 > 0) {
            sink.write(this, j10);
        }
        return j10;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public byte readByte() {
        long j10 = this.size;
        if (j10 != 0) {
            d dVar = this.head;
            int i10 = dVar.f1790b;
            int i11 = dVar.f1791c;
            int i12 = i10 + 1;
            byte b10 = dVar.f1789a[i10];
            this.size = j10 - 1;
            if (i12 == i11) {
                this.head = dVar.b();
                e.a(dVar);
            } else {
                dVar.f1790b = i12;
            }
            return b10;
        }
        throw new IllegalStateException("size == 0");
    }

    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r1 != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004b, code lost:
        r0.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r0.readUtf8());
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0098 A[EDGE_INSN: B:47:0x0098->B:29:0x0098 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() {
        /*
            r15 = this;
            long r0 = r15.size
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00b7
            r0 = 0
            r4 = -7
            r1 = r0
            r5 = r4
            r3 = r2
            r2 = r1
        L_0x000f:
            org.cocos2dx.okio.d r7 = r15.head
            byte[] r8 = r7.f1789a
            int r9 = r7.f1790b
            int r10 = r7.f1791c
        L_0x0017:
            if (r9 >= r10) goto L_0x0098
            byte r11 = r8[r9]
            r12 = 48
            if (r11 < r12) goto L_0x0069
            r12 = 57
            if (r11 > r12) goto L_0x0069
            int r12 = 48 - r11
            r13 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r13 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r13 < 0) goto L_0x003c
            if (r13 != 0) goto L_0x0036
            long r13 = (long) r12
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 >= 0) goto L_0x0036
            goto L_0x003c
        L_0x0036:
            r13 = 10
            long r3 = r3 * r13
            long r11 = (long) r12
            long r3 = r3 + r11
            goto L_0x0074
        L_0x003c:
            org.cocos2dx.okio.Buffer r0 = new org.cocos2dx.okio.Buffer
            r0.<init>()
            org.cocos2dx.okio.Buffer r0 = r0.writeDecimalLong((long) r3)
            org.cocos2dx.okio.Buffer r0 = r0.writeByte((int) r11)
            if (r1 != 0) goto L_0x004e
            r0.readByte()
        L_0x004e:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0069:
            r12 = 45
            r13 = 1
            if (r11 != r12) goto L_0x0079
            if (r0 != 0) goto L_0x0079
            r11 = 1
            long r5 = r5 - r11
            r1 = r13
        L_0x0074:
            int r9 = r9 + 1
            int r0 = r0 + 1
            goto L_0x0017
        L_0x0079:
            if (r0 == 0) goto L_0x007d
            r2 = r13
            goto L_0x0098
        L_0x007d:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9] or '-' character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r11)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0098:
            if (r9 != r10) goto L_0x00a4
            org.cocos2dx.okio.d r8 = r7.b()
            r15.head = r8
            org.cocos2dx.okio.e.a(r7)
            goto L_0x00a6
        L_0x00a4:
            r7.f1790b = r9
        L_0x00a6:
            if (r2 != 0) goto L_0x00ac
            org.cocos2dx.okio.d r7 = r15.head
            if (r7 != 0) goto L_0x000f
        L_0x00ac:
            long r5 = r15.size
            long r7 = (long) r0
            long r5 = r5 - r7
            r15.size = r5
            if (r1 == 0) goto L_0x00b5
            goto L_0x00b6
        L_0x00b5:
            long r3 = -r3
        L_0x00b6:
            return r3
        L_0x00b7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okio.Buffer.readDecimalLong():long");
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, LocationRequestCompat.PASSIVE_INTERVAL, true);
        return this;
    }

    public void readFully(Buffer buffer, long j10) throws EOFException {
        long j11 = this.size;
        if (j11 >= j10) {
            buffer.write(this, j10);
        } else {
            buffer.write(this, j11);
            throw new EOFException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008e, code lost:
        if (r8 != r9) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0090, code lost:
        r14.head = r6.b();
        org.cocos2dx.okio.e.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009a, code lost:
        r6.f1790b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        if (r1 != false) goto L_0x00a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0073 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() {
        /*
            r14 = this;
            long r0 = r14.size
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00a9
            r0 = 0
            r1 = r0
            r4 = r2
        L_0x000b:
            org.cocos2dx.okio.d r6 = r14.head
            byte[] r7 = r6.f1789a
            int r8 = r6.f1790b
            int r9 = r6.f1791c
        L_0x0013:
            if (r8 >= r9) goto L_0x008e
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x0037
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002d
            int r11 = r10 + -87
            goto L_0x0037
        L_0x002d:
            r11 = 65
            if (r10 < r11) goto L_0x006f
            r11 = 70
            if (r10 > r11) goto L_0x006f
            int r11 = r10 + -55
        L_0x0037:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0047
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0013
        L_0x0047:
            org.cocos2dx.okio.Buffer r0 = new org.cocos2dx.okio.Buffer
            r0.<init>()
            org.cocos2dx.okio.Buffer r0 = r0.writeHexadecimalUnsignedLong((long) r4)
            org.cocos2dx.okio.Buffer r0 = r0.writeByte((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x006f:
            if (r0 == 0) goto L_0x0073
            r1 = 1
            goto L_0x008e
        L_0x0073:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x008e:
            if (r8 != r9) goto L_0x009a
            org.cocos2dx.okio.d r7 = r6.b()
            r14.head = r7
            org.cocos2dx.okio.e.a(r6)
            goto L_0x009c
        L_0x009a:
            r6.f1790b = r8
        L_0x009c:
            if (r1 != 0) goto L_0x00a2
            org.cocos2dx.okio.d r6 = r14.head
            if (r6 != 0) goto L_0x000b
        L_0x00a2:
            long r1 = r14.size
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.size = r1
            return r4
        L_0x00a9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    public int readInt() {
        long j10 = this.size;
        if (j10 >= 4) {
            d dVar = this.head;
            int i10 = dVar.f1790b;
            int i11 = dVar.f1791c;
            if (i11 - i10 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = dVar.f1789a;
            byte b10 = ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10] & 255) << 24);
            int i12 = i10 + 3;
            int i13 = i10 + 4;
            byte b11 = (bArr[i12] & 255) | b10 | ((bArr[i10 + 2] & 255) << 8);
            this.size = j10 - 4;
            if (i13 == i11) {
                this.head = dVar.b();
                e.a(dVar);
            } else {
                dVar.f1790b = i13;
            }
            return b11;
        }
        throw new IllegalStateException("size < 4: " + this.size);
    }

    public int readIntLe() {
        return g.c(readInt());
    }

    public long readLong() {
        long j10 = this.size;
        if (j10 >= 8) {
            d dVar = this.head;
            int i10 = dVar.f1790b;
            int i11 = dVar.f1791c;
            if (i11 - i10 < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = dVar.f1789a;
            long j11 = ((((long) bArr[i10 + 1]) & 255) << 48) | ((((long) bArr[i10]) & 255) << 56) | ((((long) bArr[i10 + 2]) & 255) << 40) | ((((long) bArr[i10 + 3]) & 255) << 32) | ((((long) bArr[i10 + 4]) & 255) << 24);
            int i12 = i10 + 7;
            int i13 = i10 + 8;
            long j12 = j11 | ((((long) bArr[i10 + 5]) & 255) << 16) | ((((long) bArr[i10 + 6]) & 255) << 8) | (((long) bArr[i12]) & 255);
            this.size = j10 - 8;
            if (i13 == i11) {
                this.head = dVar.b();
                e.a(dVar);
            } else {
                dVar.f1790b = i13;
            }
            return j12;
        }
        throw new IllegalStateException("size < 8: " + this.size);
    }

    public long readLongLe() {
        return g.d(readLong());
    }

    public short readShort() {
        long j10 = this.size;
        if (j10 >= 2) {
            d dVar = this.head;
            int i10 = dVar.f1790b;
            int i11 = dVar.f1791c;
            if (i11 - i10 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = dVar.f1789a;
            int i12 = i10 + 1;
            int i13 = i10 + 2;
            byte b10 = (bArr[i12] & 255) | ((bArr[i10] & 255) << 8);
            this.size = j10 - 2;
            if (i13 == i11) {
                this.head = dVar.b();
                e.a(dVar);
            } else {
                dVar.f1790b = i13;
            }
            return (short) b10;
        }
        throw new IllegalStateException("size < 2: " + this.size);
    }

    public short readShortLe() {
        return g.e(readShort());
    }

    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public String readUtf8() {
        try {
            return readString(this.size, g.f1800a);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    public int readUtf8CodePoint() throws EOFException {
        byte b10;
        int i10;
        byte b11;
        if (this.size != 0) {
            byte b12 = getByte(0);
            int i11 = 1;
            if ((b12 & 128) == 0) {
                b11 = b12 & Byte.MAX_VALUE;
                b10 = 0;
                i10 = 1;
            } else if ((b12 & 224) == 192) {
                b11 = b12 & 31;
                i10 = 2;
                b10 = 128;
            } else if ((b12 & 240) == 224) {
                b11 = b12 & 15;
                i10 = 3;
                b10 = 2048;
            } else if ((b12 & 248) == 240) {
                b11 = b12 & 7;
                i10 = 4;
                b10 = 65536;
            } else {
                skip(1);
                return 65533;
            }
            long j10 = (long) i10;
            if (this.size >= j10) {
                while (i11 < i10) {
                    long j11 = (long) i11;
                    byte b13 = getByte(j11);
                    if ((b13 & 192) == 128) {
                        b11 = (b11 << 6) | (b13 & Utf8.REPLACEMENT_BYTE);
                        i11++;
                    } else {
                        skip(j11);
                        return 65533;
                    }
                }
                skip(j10);
                if (b11 > 1114111) {
                    return 65533;
                }
                if ((b11 < 55296 || b11 > 57343) && b11 >= b10) {
                    return b11;
                }
                return 65533;
            }
            throw new EOFException("size < " + i10 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b12) + ")");
        }
        throw new EOFException();
    }

    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(indexOf);
        }
        long j10 = this.size;
        if (j10 != 0) {
            return readUtf8(j10);
        }
        return null;
    }

    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public boolean request(long j10) {
        if (this.size >= j10) {
            return true;
        }
        return false;
    }

    public void require(long j10) throws EOFException {
        if (this.size < j10) {
            throw new EOFException();
        }
    }

    /* access modifiers changed from: package-private */
    public List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        d dVar = this.head;
        arrayList.add(Integer.valueOf(dVar.f1791c - dVar.f1790b));
        d dVar2 = this.head;
        while (true) {
            dVar2 = dVar2.f1794f;
            if (dVar2 == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(dVar2.f1791c - dVar2.f1790b));
        }
    }

    public int select(Options options) {
        int selectPrefix = selectPrefix(options, false);
        if (selectPrefix == -1) {
            return -1;
        }
        try {
            skip((long) options.byteStrings[selectPrefix].size());
            return selectPrefix;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public int selectPrefix(Options options, boolean z10) {
        int i10;
        int i11;
        boolean z11;
        int i12;
        d dVar;
        int i13;
        Options options2 = options;
        d dVar2 = this.head;
        int i14 = -2;
        if (dVar2 != null) {
            byte[] bArr = dVar2.f1789a;
            int i15 = dVar2.f1790b;
            int i16 = dVar2.f1791c;
            int[] iArr = options2.trie;
            d dVar3 = dVar2;
            int i17 = 0;
            int i18 = -1;
            loop0:
            while (true) {
                int i19 = i17 + 1;
                int i20 = iArr[i17];
                int i21 = i17 + 2;
                int i22 = iArr[i19];
                if (i22 != -1) {
                    i18 = i22;
                }
                if (dVar3 == null) {
                    break;
                }
                if (i20 < 0) {
                    int i23 = i21 + (i20 * -1);
                    while (true) {
                        int i24 = i15 + 1;
                        int i25 = i21 + 1;
                        if ((bArr[i15] & 255) != iArr[i21]) {
                            return i18;
                        }
                        if (i25 == i23) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (i24 == i16) {
                            d dVar4 = dVar3.f1794f;
                            i13 = dVar4.f1790b;
                            byte[] bArr2 = dVar4.f1789a;
                            i12 = dVar4.f1791c;
                            if (dVar4 != dVar2) {
                                byte[] bArr3 = bArr2;
                                dVar = dVar4;
                                bArr = bArr3;
                            } else if (!z11) {
                                break loop0;
                            } else {
                                bArr = bArr2;
                                dVar = null;
                            }
                        } else {
                            dVar = dVar3;
                            i12 = i16;
                            i13 = i24;
                        }
                        if (z11) {
                            i10 = iArr[i25];
                            i11 = i13;
                            i16 = i12;
                            dVar3 = dVar;
                            break;
                        }
                        i15 = i13;
                        i16 = i12;
                        dVar3 = dVar;
                        i21 = i25;
                    }
                } else {
                    int i26 = i15 + 1;
                    byte b10 = bArr[i15] & 255;
                    int i27 = i21 + i20;
                    while (i21 != i27) {
                        if (b10 == iArr[i21]) {
                            i10 = iArr[i21 + i20];
                            if (i26 == i16) {
                                dVar3 = dVar3.f1794f;
                                i11 = dVar3.f1790b;
                                bArr = dVar3.f1789a;
                                i16 = dVar3.f1791c;
                                if (dVar3 == dVar2) {
                                    dVar3 = null;
                                }
                            } else {
                                i11 = i26;
                            }
                        } else {
                            i21++;
                        }
                    }
                    return i18;
                }
                if (i10 >= 0) {
                    return i10;
                }
                i17 = -i10;
                i15 = i11;
                i14 = -2;
            }
            if (z10) {
                return i14;
            }
            return i18;
        } else if (z10) {
            return -2;
        } else {
            return options2.indexOf(ByteString.EMPTY);
        }
    }

    public final ByteString sha1() {
        return digest(j.f17956c);
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    public void skip(long j10) throws EOFException {
        while (j10 > 0) {
            d dVar = this.head;
            if (dVar != null) {
                int min = (int) Math.min(j10, (long) (dVar.f1791c - dVar.f1790b));
                long j11 = (long) min;
                this.size -= j11;
                j10 -= j11;
                d dVar2 = this.head;
                int i10 = dVar2.f1790b + min;
                dVar2.f1790b = i10;
                if (i10 == dVar2.f1791c) {
                    this.head = dVar2.b();
                    e.a(dVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final ByteString snapshot() {
        long j10 = this.size;
        if (j10 <= 2147483647L) {
            return snapshot((int) j10);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    /* access modifiers changed from: package-private */
    public d writableSegment(int i10) {
        if (i10 < 1 || i10 > 8192) {
            throw new IllegalArgumentException();
        }
        d dVar = this.head;
        if (dVar == null) {
            d b10 = e.b();
            this.head = b10;
            b10.f1795g = b10;
            b10.f1794f = b10;
            return b10;
        }
        d dVar2 = dVar.f1795g;
        if (dVar2.f1791c + i10 > 8192 || !dVar2.f1793e) {
            return dVar2.c(e.b());
        }
        return dVar2;
    }

    public long writeAll(Source source) throws IOException {
        if (source != null) {
            long j10 = 0;
            while (true) {
                long read = source.read(this, 8192);
                if (read == -1) {
                    return j10;
                }
                j10 += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.size);
    }

    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        d d10 = this.head.d();
        buffer.head = d10;
        d10.f1795g = d10;
        d10.f1794f = d10;
        d dVar = this.head;
        while (true) {
            dVar = dVar.f1794f;
            if (dVar != this.head) {
                buffer.head.f1795g.c(dVar.d());
            } else {
                buffer.size = this.size;
                return buffer;
            }
        }
    }

    public final Buffer copyTo(OutputStream outputStream, long j10, long j11) throws IOException {
        if (outputStream != null) {
            g.b(this.size, j10, j11);
            if (j11 == 0) {
                return this;
            }
            d dVar = this.head;
            while (true) {
                int i10 = dVar.f1791c;
                int i11 = dVar.f1790b;
                if (j10 < ((long) (i10 - i11))) {
                    break;
                }
                j10 -= (long) (i10 - i11);
                dVar = dVar.f1794f;
            }
            while (j11 > 0) {
                int i12 = (int) (((long) dVar.f1790b) + j10);
                int min = (int) Math.min((long) (dVar.f1791c - i12), j11);
                outputStream.write(dVar.f1789a, i12, min);
                j11 -= (long) min;
                dVar = dVar.f1794f;
                j10 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public long indexOf(byte b10, long j10) {
        return indexOf(b10, j10, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public long indexOfElement(ByteString byteString, long j10) {
        int i10;
        int i11;
        long j11 = 0;
        if (j10 >= 0) {
            d dVar = this.head;
            if (dVar == null) {
                return -1;
            }
            long j12 = this.size;
            if (j12 - j10 < j10) {
                while (j12 > j10) {
                    dVar = dVar.f1795g;
                    j12 -= (long) (dVar.f1791c - dVar.f1790b);
                }
            } else {
                while (true) {
                    long j13 = ((long) (dVar.f1791c - dVar.f1790b)) + j11;
                    if (j13 >= j10) {
                        break;
                    }
                    dVar = dVar.f1794f;
                    j11 = j13;
                }
                j12 = j11;
            }
            if (byteString.size() == 2) {
                byte b10 = byteString.getByte(0);
                byte b11 = byteString.getByte(1);
                while (j12 < this.size) {
                    byte[] bArr = dVar.f1789a;
                    i10 = (int) ((((long) dVar.f1790b) + j10) - j12);
                    int i12 = dVar.f1791c;
                    while (i10 < i12) {
                        byte b12 = bArr[i10];
                        if (b12 == b10 || b12 == b11) {
                            i11 = dVar.f1790b;
                        } else {
                            i10++;
                        }
                    }
                    j12 += (long) (dVar.f1791c - dVar.f1790b);
                    dVar = dVar.f1794f;
                    j10 = j12;
                }
                return -1;
            }
            byte[] internalArray = byteString.internalArray();
            while (j12 < this.size) {
                byte[] bArr2 = dVar.f1789a;
                int i13 = (int) ((((long) dVar.f1790b) + j10) - j12);
                int i14 = dVar.f1791c;
                while (i10 < i14) {
                    byte b13 = bArr2[i10];
                    int length = internalArray.length;
                    int i15 = 0;
                    while (i15 < length) {
                        if (b13 == internalArray[i15]) {
                            i11 = dVar.f1790b;
                        } else {
                            i15++;
                        }
                    }
                    i13 = i10 + 1;
                }
                j12 += (long) (dVar.f1791c - dVar.f1790b);
                dVar = dVar.f1794f;
                j10 = j12;
            }
            return -1;
            return ((long) (i10 - i11)) + j12;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    public boolean rangeEquals(long j10, ByteString byteString, int i10, int i11) {
        if (j10 < 0 || i10 < 0 || i11 < 0 || this.size - j10 < ((long) i11) || byteString.size() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (getByte(((long) i12) + j10) != byteString.getByte(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    public int read(byte[] bArr, int i10, int i11) {
        g.b((long) bArr.length, (long) i10, (long) i11);
        d dVar = this.head;
        if (dVar == null) {
            return -1;
        }
        int min = Math.min(i11, dVar.f1791c - dVar.f1790b);
        System.arraycopy(dVar.f1789a, dVar.f1790b, bArr, i10, min);
        int i12 = dVar.f1790b + min;
        dVar.f1790b = i12;
        this.size -= (long) min;
        if (i12 == dVar.f1791c) {
            this.head = dVar.b();
            e.a(dVar);
        }
        return min;
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public ByteString readByteString(long j10) throws EOFException {
        return new ByteString(readByteArray(j10));
    }

    public final Buffer readFrom(InputStream inputStream, long j10) throws IOException {
        if (j10 >= 0) {
            readFrom(inputStream, j10, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j10);
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public String readUtf8LineStrict(long j10) throws EOFException {
        if (j10 >= 0) {
            long j11 = LocationRequestCompat.PASSIVE_INTERVAL;
            if (j10 != LocationRequestCompat.PASSIVE_INTERVAL) {
                j11 = j10 + 1;
            }
            long indexOf = indexOf((byte) 10, 0, j11);
            if (indexOf != -1) {
                return readUtf8Line(indexOf);
            }
            if (j11 < size() && getByte(j11 - 1) == 13 && getByte(j11) == 10) {
                return readUtf8Line(j11);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0, Math.min(32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j10) + " content=" + buffer.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j10);
    }

    public Buffer writeByte(int i10) {
        d writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.f1789a;
        int i11 = writableSegment.f1791c;
        writableSegment.f1791c = i11 + 1;
        bArr[i11] = (byte) i10;
        this.size++;
        return this;
    }

    public Buffer writeDecimalLong(long j10) {
        boolean z10;
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 == 0) {
            return writeByte(48);
        }
        int i11 = 1;
        if (i10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (j10 >= 100000000) {
            i11 = j10 < 1000000000000L ? j10 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j10 < 1000000000 ? 9 : 10 : j10 < 100000000000L ? 11 : 12 : j10 < 1000000000000000L ? j10 < 10000000000000L ? 13 : j10 < 100000000000000L ? 14 : 15 : j10 < 100000000000000000L ? j10 < 10000000000000000L ? 16 : 17 : j10 < 1000000000000000000L ? 18 : 19;
        } else if (j10 >= WorkRequest.MIN_BACKOFF_MILLIS) {
            i11 = j10 < 1000000 ? j10 < 100000 ? 5 : 6 : j10 < 10000000 ? 7 : 8;
        } else if (j10 >= 100) {
            i11 = j10 < 1000 ? 3 : 4;
        } else if (j10 >= 10) {
            i11 = 2;
        }
        if (z10) {
            i11++;
        }
        d writableSegment = writableSegment(i11);
        byte[] bArr = writableSegment.f1789a;
        int i12 = writableSegment.f1791c + i11;
        while (j10 != 0) {
            i12--;
            bArr[i12] = DIGITS[(int) (j10 % 10)];
            j10 /= 10;
        }
        if (z10) {
            bArr[i12 - 1] = 45;
        }
        writableSegment.f1791c += i11;
        this.size += (long) i11;
        return this;
    }

    public Buffer writeHexadecimalUnsignedLong(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j10)) / 4) + 1;
        d writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.f1789a;
        int i10 = writableSegment.f1791c;
        for (int i11 = (i10 + numberOfTrailingZeros) - 1; i11 >= i10; i11--) {
            bArr[i11] = DIGITS[(int) (15 & j10)];
            j10 >>>= 4;
        }
        writableSegment.f1791c += numberOfTrailingZeros;
        this.size += (long) numberOfTrailingZeros;
        return this;
    }

    public Buffer writeInt(int i10) {
        d writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.f1789a;
        int i11 = writableSegment.f1791c;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & 255);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 3] = (byte) (i10 & 255);
        writableSegment.f1791c = i11 + 4;
        this.size += 4;
        return this;
    }

    public Buffer writeIntLe(int i10) {
        return writeInt(g.c(i10));
    }

    public Buffer writeLong(long j10) {
        d writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.f1789a;
        int i10 = writableSegment.f1791c;
        bArr[i10] = (byte) ((int) ((j10 >>> 56) & 255));
        bArr[i10 + 1] = (byte) ((int) ((j10 >>> 48) & 255));
        bArr[i10 + 2] = (byte) ((int) ((j10 >>> 40) & 255));
        bArr[i10 + 3] = (byte) ((int) ((j10 >>> 32) & 255));
        bArr[i10 + 4] = (byte) ((int) ((j10 >>> 24) & 255));
        bArr[i10 + 5] = (byte) ((int) ((j10 >>> 16) & 255));
        bArr[i10 + 6] = (byte) ((int) ((j10 >>> 8) & 255));
        bArr[i10 + 7] = (byte) ((int) (j10 & 255));
        writableSegment.f1791c = i10 + 8;
        this.size += 8;
        return this;
    }

    public Buffer writeLongLe(long j10) {
        return writeLong(g.d(j10));
    }

    public Buffer writeShort(int i10) {
        d writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.f1789a;
        int i11 = writableSegment.f1791c;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 1] = (byte) (i10 & 255);
        writableSegment.f1791c = i11 + 2;
        this.size += 2;
        return this;
    }

    public Buffer writeShortLe(int i10) {
        return writeShort((int) g.e((short) i10));
    }

    public final Buffer writeTo(OutputStream outputStream, long j10) throws IOException {
        if (outputStream != null) {
            g.b(this.size, 0, j10);
            d dVar = this.head;
            while (j10 > 0) {
                int min = (int) Math.min(j10, (long) (dVar.f1791c - dVar.f1790b));
                outputStream.write(dVar.f1789a, dVar.f1790b, min);
                int i10 = dVar.f1790b + min;
                dVar.f1790b = i10;
                long j11 = (long) min;
                this.size -= j11;
                j10 -= j11;
                if (i10 == dVar.f1791c) {
                    d b10 = dVar.b();
                    this.head = b10;
                    e.a(dVar);
                    dVar = b10;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public Buffer writeUtf8CodePoint(int i10) {
        if (i10 < 128) {
            writeByte(i10);
        } else if (i10 < 2048) {
            writeByte((i10 >> 6) | 192);
            writeByte((i10 & 63) | 128);
        } else if (i10 < 65536) {
            if (i10 < 55296 || i10 > 57343) {
                writeByte((i10 >> 12) | 224);
                writeByte(((i10 >> 6) & 63) | 128);
                writeByte((i10 & 63) | 128);
            } else {
                writeByte(63);
            }
        } else if (i10 <= 1114111) {
            writeByte((i10 >> 18) | 240);
            writeByte(((i10 >> 12) & 63) | 128);
            writeByte(((i10 >> 6) & 63) | 128);
            writeByte((i10 & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i10));
        }
        return this;
    }

    public long indexOf(byte b10, long j10, long j11) {
        d dVar;
        long j12 = 0;
        if (j10 < 0 || j11 < j10) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.size), Long.valueOf(j10), Long.valueOf(j11)}));
        }
        long j13 = this.size;
        long j14 = j11 > j13 ? j13 : j11;
        if (j10 == j14 || (dVar = this.head) == null) {
            return -1;
        }
        if (j13 - j10 < j10) {
            while (j13 > j10) {
                dVar = dVar.f1795g;
                j13 -= (long) (dVar.f1791c - dVar.f1790b);
            }
        } else {
            while (true) {
                long j15 = ((long) (dVar.f1791c - dVar.f1790b)) + j12;
                if (j15 >= j10) {
                    break;
                }
                dVar = dVar.f1794f;
                j12 = j15;
            }
            j13 = j12;
        }
        long j16 = j10;
        while (j13 < j14) {
            byte[] bArr = dVar.f1789a;
            int min = (int) Math.min((long) dVar.f1791c, (((long) dVar.f1790b) + j14) - j13);
            for (int i10 = (int) ((((long) dVar.f1790b) + j16) - j13); i10 < min; i10++) {
                if (bArr[i10] == b10) {
                    return ((long) (i10 - dVar.f1790b)) + j13;
                }
            }
            byte b11 = b10;
            j13 += (long) (dVar.f1791c - dVar.f1790b);
            dVar = dVar.f1794f;
            j16 = j13;
        }
        return -1;
    }

    public byte[] readByteArray(long j10) throws EOFException {
        g.b(this.size, 0, j10);
        if (j10 <= 2147483647L) {
            byte[] bArr = new byte[((int) j10)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j10);
    }

    public String readString(long j10, Charset charset) throws EOFException {
        g.b(this.size, 0, j10);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j10 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j10);
        } else if (j10 == 0) {
            return "";
        } else {
            d dVar = this.head;
            int i10 = dVar.f1790b;
            if (((long) i10) + j10 > ((long) dVar.f1791c)) {
                return new String(readByteArray(j10), charset);
            }
            String str = new String(dVar.f1789a, i10, (int) j10, charset);
            int i11 = (int) (((long) dVar.f1790b) + j10);
            dVar.f1790b = i11;
            this.size -= j10;
            if (i11 == dVar.f1791c) {
                this.head = dVar.b();
                e.a(dVar);
            }
            return str;
        }
    }

    public String readUtf8(long j10) throws EOFException {
        return readString(j10, g.f1800a);
    }

    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    private void readFrom(InputStream inputStream, long j10, boolean z10) throws IOException {
        if (inputStream != null) {
            while (true) {
                if (j10 > 0 || z10) {
                    d writableSegment = writableSegment(1);
                    int read = inputStream.read(writableSegment.f1789a, writableSegment.f1791c, (int) Math.min(j10, (long) (8192 - writableSegment.f1791c)));
                    if (read != -1) {
                        writableSegment.f1791c += read;
                        long j11 = (long) read;
                        this.size += j11;
                        j10 -= j11;
                    } else if (!z10) {
                        throw new EOFException();
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("in == null");
        }
    }

    /* access modifiers changed from: package-private */
    public String readUtf8Line(long j10) throws EOFException {
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (getByte(j11) == 13) {
                String readUtf8 = readUtf8(j11);
                skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8(j10);
        skip(1);
        return readUtf82;
    }

    public final ByteString snapshot(int i10) {
        if (i10 == 0) {
            return ByteString.EMPTY;
        }
        return new f(this, i10);
    }

    public Buffer write(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public Buffer writeString(String str, int i10, int i11, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i10 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i10);
        } else if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        } else if (i11 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(g.f1800a)) {
            return writeUtf8(str, i10, i11);
        } else {
            byte[] bytes = str.substring(i10, i11).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
    }

    public Buffer writeUtf8(String str, int i10, int i11) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i10 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i10);
        } else if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        } else if (i11 <= str.length()) {
            while (i10 < i11) {
                char charAt = str.charAt(i10);
                if (charAt < 128) {
                    d writableSegment = writableSegment(1);
                    byte[] bArr = writableSegment.f1789a;
                    int i12 = writableSegment.f1791c - i10;
                    int min = Math.min(i11, 8192 - i12);
                    int i13 = i10 + 1;
                    bArr[i10 + i12] = (byte) charAt;
                    while (i13 < min) {
                        char charAt2 = str.charAt(i13);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i13 + i12] = (byte) charAt2;
                        i13++;
                    }
                    int i14 = writableSegment.f1791c;
                    int i15 = (i12 + i13) - i14;
                    writableSegment.f1791c = i14 + i15;
                    this.size += (long) i15;
                    i10 = i13;
                } else {
                    if (charAt < 2048) {
                        writeByte((charAt >> 6) | 192);
                        writeByte((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        writeByte((charAt >> 12) | 224);
                        writeByte(((charAt >> 6) & 63) | 128);
                        writeByte((int) (charAt & '?') | 128);
                    } else {
                        int i16 = i10 + 1;
                        char charAt3 = i16 < i11 ? str.charAt(i16) : 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            writeByte(63);
                            i10 = i16;
                        } else {
                            int i17 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 0;
                            writeByte((i17 >> 18) | 240);
                            writeByte(((i17 >> 12) & 63) | 128);
                            writeByte(((i17 >> 6) & 63) | 128);
                            writeByte((i17 & 63) | 128);
                            i10 += 2;
                        }
                    }
                    i10++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
        }
    }

    private boolean rangeEquals(d dVar, int i10, ByteString byteString, int i11, int i12) {
        int i13 = dVar.f1791c;
        byte[] bArr = dVar.f1789a;
        while (i11 < i12) {
            if (i10 == i13) {
                dVar = dVar.f1794f;
                byte[] bArr2 = dVar.f1789a;
                int i14 = dVar.f1790b;
                bArr = bArr2;
                i10 = i14;
                i13 = dVar.f1791c;
            }
            if (bArr[i10] != byteString.getByte(i11)) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public void readFully(byte[] bArr) throws EOFException {
        int i10 = 0;
        while (i10 < bArr.length) {
            int read = read(bArr, i10, bArr.length - i10);
            if (read != -1) {
                i10 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public Buffer write(byte[] bArr, int i10, int i11) {
        if (bArr != null) {
            long j10 = (long) i11;
            g.b((long) bArr.length, (long) i10, j10);
            int i12 = i11 + i10;
            while (i10 < i12) {
                d writableSegment = writableSegment(1);
                int min = Math.min(i12 - i10, 8192 - writableSegment.f1791c);
                System.arraycopy(bArr, i10, writableSegment.f1789a, writableSegment.f1791c, min);
                i10 += min;
                writableSegment.f1791c += min;
            }
            this.size += j10;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final Buffer copyTo(Buffer buffer, long j10, long j11) {
        if (buffer != null) {
            g.b(this.size, j10, j11);
            if (j11 == 0) {
                return this;
            }
            buffer.size += j11;
            d dVar = this.head;
            while (true) {
                int i10 = dVar.f1791c;
                int i11 = dVar.f1790b;
                if (j10 < ((long) (i10 - i11))) {
                    break;
                }
                j10 -= (long) (i10 - i11);
                dVar = dVar.f1794f;
            }
            while (j11 > 0) {
                d d10 = dVar.d();
                int i12 = (int) (((long) d10.f1790b) + j10);
                d10.f1790b = i12;
                d10.f1791c = Math.min(i12 + ((int) j11), d10.f1791c);
                d dVar2 = buffer.head;
                if (dVar2 == null) {
                    d10.f1795g = d10;
                    d10.f1794f = d10;
                    buffer.head = d10;
                } else {
                    dVar2.f1795g.c(d10);
                }
                j11 -= (long) (d10.f1791c - d10.f1790b);
                dVar = dVar.f1794f;
                j10 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        d dVar = this.head;
        if (dVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), dVar.f1791c - dVar.f1790b);
        byteBuffer.put(dVar.f1789a, dVar.f1790b, min);
        int i10 = dVar.f1790b + min;
        dVar.f1790b = i10;
        this.size -= (long) min;
        if (i10 == dVar.f1791c) {
            this.head = dVar.b();
            e.a(dVar);
        }
        return min;
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i10 = remaining;
            while (i10 > 0) {
                d writableSegment = writableSegment(1);
                int min = Math.min(i10, 8192 - writableSegment.f1791c);
                byteBuffer.get(writableSegment.f1789a, writableSegment.f1791c, min);
                i10 -= min;
                writableSegment.f1791c += min;
            }
            this.size += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j10) throws IOException {
        byte[] bArr;
        if (byteString.size() != 0) {
            long j11 = 0;
            if (j10 >= 0) {
                d dVar = this.head;
                long j12 = -1;
                if (dVar == null) {
                    return -1;
                }
                long j13 = this.size;
                if (j13 - j10 < j10) {
                    while (j13 > j10) {
                        dVar = dVar.f1795g;
                        j13 -= (long) (dVar.f1791c - dVar.f1790b);
                    }
                } else {
                    while (true) {
                        long j14 = ((long) (dVar.f1791c - dVar.f1790b)) + j11;
                        if (j14 >= j10) {
                            break;
                        }
                        dVar = dVar.f1794f;
                        j11 = j14;
                    }
                    j13 = j11;
                }
                byte b10 = byteString.getByte(0);
                int size2 = byteString.size();
                long j15 = 1 + (this.size - ((long) size2));
                long j16 = j10;
                d dVar2 = dVar;
                long j17 = j13;
                while (j17 < j15) {
                    byte[] bArr2 = dVar2.f1789a;
                    int min = (int) Math.min((long) dVar2.f1791c, (((long) dVar2.f1790b) + j15) - j17);
                    int i10 = (int) ((((long) dVar2.f1790b) + j16) - j17);
                    while (i10 < min) {
                        if (bArr2[i10] == b10) {
                            bArr = bArr2;
                            if (rangeEquals(dVar2, i10 + 1, byteString, 1, size2)) {
                                return ((long) (i10 - dVar2.f1790b)) + j17;
                            }
                        } else {
                            bArr = bArr2;
                        }
                        i10++;
                        bArr2 = bArr;
                    }
                    j17 += (long) (dVar2.f1791c - dVar2.f1790b);
                    dVar2 = dVar2.f1794f;
                    j16 = j17;
                    j12 = -1;
                }
                return j12;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    public long read(Buffer buffer, long j10) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j10 >= 0) {
            long j11 = this.size;
            if (j11 == 0) {
                return -1;
            }
            if (j10 > j11) {
                j10 = j11;
            }
            buffer.write(this, j10);
            return j10;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
    }

    public BufferedSink write(Source source, long j10) throws IOException {
        while (j10 > 0) {
            long read = source.read(this, j10);
            if (read != -1) {
                j10 -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    public void write(Buffer buffer, long j10) {
        int i10;
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        } else if (buffer != this) {
            g.b(buffer.size, 0, j10);
            while (j10 > 0) {
                d dVar = buffer.head;
                if (j10 < ((long) (dVar.f1791c - dVar.f1790b))) {
                    d dVar2 = this.head;
                    d dVar3 = dVar2 != null ? dVar2.f1795g : null;
                    if (dVar3 != null && dVar3.f1793e) {
                        long j11 = ((long) dVar3.f1791c) + j10;
                        if (dVar3.f1792d) {
                            i10 = 0;
                        } else {
                            i10 = dVar3.f1790b;
                        }
                        if (j11 - ((long) i10) <= 8192) {
                            dVar.g(dVar3, (int) j10);
                            buffer.size -= j10;
                            this.size += j10;
                            return;
                        }
                    }
                    buffer.head = dVar.e((int) j10);
                }
                d dVar4 = buffer.head;
                long j12 = (long) (dVar4.f1791c - dVar4.f1790b);
                buffer.head = dVar4.b();
                d dVar5 = this.head;
                if (dVar5 == null) {
                    this.head = dVar4;
                    dVar4.f1795g = dVar4;
                    dVar4.f1794f = dVar4;
                } else {
                    dVar5.f1795g.c(dVar4).a();
                }
                buffer.size -= j12;
                this.size += j12;
                j10 -= j12;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }
}
