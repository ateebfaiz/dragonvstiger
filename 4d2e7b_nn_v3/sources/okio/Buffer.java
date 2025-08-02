package okio;

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
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.text.d;
import okhttp3.internal.connection.RealConnection;
import okio.internal.BufferKt;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public Segment head;
    private long size;

    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public int end = -1;
        public long offset = -1;
        public boolean readWrite;
        private Segment segment;
        public int start = -1;

        public void close() {
            boolean z10;
            if (this.buffer != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.buffer = null;
                this.segment = null;
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final long expandBuffer(int i10) {
            boolean z10;
            boolean z11 = false;
            if (i10 > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                if (i10 <= 8192) {
                    z11 = true;
                }
                if (z11) {
                    Buffer buffer2 = this.buffer;
                    if (buffer2 == null) {
                        throw new IllegalStateException("not attached to a buffer".toString());
                    } else if (this.readWrite) {
                        long size = buffer2.size();
                        Segment writableSegment$okio = buffer2.writableSegment$okio(i10);
                        int i11 = 8192 - writableSegment$okio.limit;
                        writableSegment$okio.limit = 8192;
                        long j10 = (long) i11;
                        buffer2.setSize$okio(size + j10);
                        this.segment = writableSegment$okio;
                        this.offset = size;
                        this.data = writableSegment$okio.data;
                        this.start = 8192 - i11;
                        this.end = 8192;
                        return j10;
                    } else {
                        throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                    }
                } else {
                    throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i10).toString());
                }
            } else {
                throw new IllegalArgumentException(("minByteCount <= 0: " + i10).toString());
            }
        }

        public final int next() {
            boolean z10;
            long j10;
            long j11 = this.offset;
            Buffer buffer2 = this.buffer;
            m.c(buffer2);
            if (j11 != buffer2.size()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                long j12 = this.offset;
                if (j12 == -1) {
                    j10 = 0;
                } else {
                    j10 = j12 + ((long) (this.end - this.start));
                }
                return seek(j10);
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        public final long resizeBuffer(long j10) {
            boolean z10;
            long j11 = j10;
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else if (this.readWrite) {
                long size = buffer2.size();
                int i10 = (j11 > size ? 1 : (j11 == size ? 0 : -1));
                int i11 = 1;
                if (i10 <= 0) {
                    if (j11 >= 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        long j12 = size - j11;
                        while (true) {
                            if (j12 <= 0) {
                                break;
                            }
                            Segment segment2 = buffer2.head;
                            m.c(segment2);
                            Segment segment3 = segment2.prev;
                            m.c(segment3);
                            int i12 = segment3.limit;
                            long j13 = (long) (i12 - segment3.pos);
                            if (j13 > j12) {
                                segment3.limit = i12 - ((int) j12);
                                break;
                            }
                            buffer2.head = segment3.pop();
                            SegmentPool.recycle(segment3);
                            j12 -= j13;
                        }
                        this.segment = null;
                        this.offset = j11;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else {
                        throw new IllegalArgumentException(("newSize < 0: " + j11).toString());
                    }
                } else if (i10 > 0) {
                    long j14 = j11 - size;
                    boolean z11 = true;
                    while (j14 > 0) {
                        Segment writableSegment$okio = buffer2.writableSegment$okio(i11);
                        int min = (int) Math.min(j14, (long) (8192 - writableSegment$okio.limit));
                        int i13 = writableSegment$okio.limit + min;
                        writableSegment$okio.limit = i13;
                        j14 -= (long) min;
                        if (z11) {
                            this.segment = writableSegment$okio;
                            this.offset = size;
                            this.data = writableSegment$okio.data;
                            this.start = i13 - min;
                            this.end = i13;
                            z11 = false;
                        }
                        i11 = 1;
                    }
                }
                buffer2.setSize$okio(j11);
                return size;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
        }

        public final int seek(long j10) {
            Segment segment2;
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else if (j10 < ((long) -1) || j10 > buffer2.size()) {
                b0 b0Var = b0.f709a;
                String format = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(j10), Long.valueOf(buffer2.size())}, 2));
                m.e(format, "java.lang.String.format(format, *args)");
                throw new ArrayIndexOutOfBoundsException(format);
            } else if (j10 == -1 || j10 == buffer2.size()) {
                this.segment = null;
                this.offset = j10;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            } else {
                long size = buffer2.size();
                Segment segment3 = buffer2.head;
                Segment segment4 = this.segment;
                long j11 = 0;
                if (segment4 != null) {
                    long j12 = this.offset;
                    int i10 = this.start;
                    m.c(segment4);
                    long j13 = j12 - ((long) (i10 - segment4.pos));
                    if (j13 > j10) {
                        segment2 = segment3;
                        segment3 = this.segment;
                        size = j13;
                    } else {
                        segment2 = this.segment;
                        j11 = j13;
                    }
                } else {
                    segment2 = segment3;
                }
                if (size - j10 > j10 - j11) {
                    while (true) {
                        m.c(segment2);
                        int i11 = segment2.limit;
                        int i12 = segment2.pos;
                        if (j10 < ((long) (i11 - i12)) + j11) {
                            break;
                        }
                        j11 += (long) (i11 - i12);
                        segment2 = segment2.next;
                    }
                } else {
                    while (size > j10) {
                        m.c(segment3);
                        segment3 = segment3.prev;
                        m.c(segment3);
                        size -= (long) (segment3.limit - segment3.pos);
                    }
                    segment2 = segment3;
                    j11 = size;
                }
                if (this.readWrite) {
                    m.c(segment2);
                    if (segment2.shared) {
                        Segment unsharedCopy = segment2.unsharedCopy();
                        if (buffer2.head == segment2) {
                            buffer2.head = unsharedCopy;
                        }
                        segment2 = segment2.push(unsharedCopy);
                        Segment segment5 = segment2.prev;
                        m.c(segment5);
                        segment5.pop();
                    }
                }
                this.segment = segment2;
                this.offset = j10;
                m.c(segment2);
                this.data = segment2.data;
                int i13 = segment2.pos + ((int) (j10 - j11));
                this.start = i13;
                int i14 = segment2.limit;
                this.end = i14;
                return i14 - i13;
            }
        }
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        return buffer.copyTo(buffer2, j10);
    }

    private final ByteString digest(String str) {
        MessageDigest instance = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            byte[] bArr = segment.data;
            int i10 = segment.pos;
            instance.update(bArr, i10, segment.limit - i10);
            Segment segment2 = segment.next;
            m.c(segment2);
            while (segment2 != segment) {
                byte[] bArr2 = segment2.data;
                int i11 = segment2.pos;
                instance.update(bArr2, i11, segment2.limit - i11);
                segment2 = segment2.next;
                m.c(segment2);
            }
        }
        byte[] digest = instance.digest();
        m.e(digest, "messageDigest.digest()");
        return new ByteString(digest);
    }

    private final ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i10 = segment.pos;
                instance.update(bArr, i10, segment.limit - i10);
                Segment segment2 = segment.next;
                m.c(segment2);
                while (segment2 != segment) {
                    byte[] bArr2 = segment2.data;
                    int i11 = segment2.pos;
                    instance.update(bArr2, i11, segment2.limit - i11);
                    segment2 = segment2.next;
                    m.c(segment2);
                }
            }
            byte[] doFinal = instance.doFinal();
            m.e(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j10, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            j10 = buffer.size;
        }
        return buffer.writeTo(outputStream, j10);
    }

    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m135deprecated_getByte(long j10) {
        return getByte(j10);
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final long m136deprecated_size() {
        return this.size;
    }

    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        skip(size());
    }

    public void close() {
    }

    public final long completeSegmentByteCount() {
        long size2 = size();
        if (size2 == 0) {
            return 0;
        }
        Segment segment = this.head;
        m.c(segment);
        Segment segment2 = segment.prev;
        m.c(segment2);
        int i10 = segment2.limit;
        if (i10 < 8192 && segment2.owner) {
            size2 -= (long) (i10 - segment2.pos);
        }
        return size2;
    }

    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() != 0) {
            Segment segment = this.head;
            m.c(segment);
            Segment sharedCopy = segment.sharedCopy();
            buffer.head = sharedCopy;
            sharedCopy.prev = sharedCopy;
            sharedCopy.next = sharedCopy;
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                Segment segment3 = sharedCopy.prev;
                m.c(segment3);
                m.c(segment2);
                segment3.push(segment2.sharedCopy());
            }
            buffer.setSize$okio(size());
        }
        return buffer;
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo$default(this, outputStream, 0, 0, 6, (Object) null);
    }

    public Buffer emit() {
        return this;
    }

    public Buffer emitCompleteSegments() {
        return this;
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 1
            if (r0 != r1) goto L_0x0009
            goto L_0x0081
        L_0x0009:
            boolean r3 = r1 instanceof okio.Buffer
            r4 = 0
            if (r3 != 0) goto L_0x0011
        L_0x000e:
            r2 = r4
            goto L_0x0081
        L_0x0011:
            long r5 = r18.size()
            okio.Buffer r1 = (okio.Buffer) r1
            long r7 = r1.size()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0020
            goto L_0x000e
        L_0x0020:
            long r5 = r18.size()
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x002b
            goto L_0x0081
        L_0x002b:
            okio.Segment r3 = r0.head
            kotlin.jvm.internal.m.c(r3)
            okio.Segment r1 = r1.head
            kotlin.jvm.internal.m.c(r1)
            int r5 = r3.pos
            int r6 = r1.pos
            r9 = r7
        L_0x003a:
            long r11 = r18.size()
            int r11 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0081
            int r11 = r3.limit
            int r11 = r11 - r5
            int r12 = r1.limit
            int r12 = r12 - r6
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            r13 = r7
        L_0x004e:
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 >= 0) goto L_0x0069
            byte[] r15 = r3.data
            int r16 = r5 + 1
            byte r5 = r15[r5]
            byte[] r15 = r1.data
            int r17 = r6 + 1
            byte r6 = r15[r6]
            if (r5 == r6) goto L_0x0061
            goto L_0x000e
        L_0x0061:
            r5 = 1
            long r13 = r13 + r5
            r5 = r16
            r6 = r17
            goto L_0x004e
        L_0x0069:
            int r13 = r3.limit
            if (r5 != r13) goto L_0x0074
            okio.Segment r3 = r3.next
            kotlin.jvm.internal.m.c(r3)
            int r5 = r3.pos
        L_0x0074:
            int r13 = r1.limit
            if (r6 != r13) goto L_0x007f
            okio.Segment r1 = r1.next
            kotlin.jvm.internal.m.c(r1)
            int r6 = r1.pos
        L_0x007f:
            long r9 = r9 + r11
            goto L_0x003a
        L_0x0081:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.equals(java.lang.Object):boolean");
    }

    public boolean exhausted() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public void flush() {
    }

    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long j10) {
        Util.checkOffsetAndCount(size(), j10, 1);
        Segment segment = this.head;
        if (segment == null) {
            m.c((Object) null);
            throw null;
        } else if (size() - j10 < j10) {
            long size2 = size();
            while (size2 > j10) {
                segment = segment.prev;
                m.c(segment);
                size2 -= (long) (segment.limit - segment.pos);
            }
            m.c(segment);
            return segment.data[(int) ((((long) segment.pos) + j10) - size2)];
        } else {
            long j11 = 0;
            while (true) {
                long j12 = ((long) (segment.limit - segment.pos)) + j11;
                if (j12 > j10) {
                    m.c(segment);
                    return segment.data[(int) ((((long) segment.pos) + j10) - j11)];
                }
                segment = segment.next;
                m.c(segment);
                j11 = j12;
            }
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = segment.limit;
            for (int i12 = segment.pos; i12 < i11; i12++) {
                i10 = (i10 * 31) + segment.data[i12];
            }
            segment = segment.next;
            m.c(segment);
        } while (segment != this.head);
        return i10;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        m.f(byteString, "key");
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        m.f(byteString, "key");
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        m.f(byteString, "key");
        return hmac("HmacSHA512", byteString);
    }

    public long indexOf(byte b10) {
        return indexOf(b10, 0, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public long indexOfElement(ByteString byteString) {
        m.f(byteString, "targetBytes");
        return indexOfElement(byteString, 0);
    }

    public InputStream inputStream() {
        return new Buffer$inputStream$1(this);
    }

    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest(j.f17955b);
    }

    public OutputStream outputStream() {
        return new Buffer$outputStream$1(this);
    }

    public BufferedSource peek() {
        return Okio.buffer((Source) new PeekSource(this));
    }

    public boolean rangeEquals(long j10, ByteString byteString) {
        m.f(byteString, "bytes");
        return rangeEquals(j10, byteString, 0, byteString.size());
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        m.f(byteBuffer, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        int i10 = segment.pos + min;
        segment.pos = i10;
        this.size -= (long) min;
        if (i10 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public long readAll(Sink sink) throws IOException {
        m.f(sink, "sink");
        long size2 = size();
        if (size2 > 0) {
            sink.write(this, size2);
        }
        return size2;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, (UnsafeCursor) null, 1, (Object) null);
    }

    public byte readByte() throws EOFException {
        if (size() != 0) {
            Segment segment = this.head;
            m.c(segment);
            int i10 = segment.pos;
            int i11 = segment.limit;
            int i12 = i10 + 1;
            byte b10 = segment.data[i10];
            setSize$okio(size() - 1);
            if (i12 == i11) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i12;
            }
            return b10;
        }
        throw new EOFException();
    }

    public byte[] readByteArray() {
        return readByteArray(size());
    }

    public ByteString readByteString() {
        return readByteString(size());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r1 != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        r0.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r0.readUtf8());
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009f A[EDGE_INSN: B:47:0x009f->B:29:0x009f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.size()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00c1
            r0 = 0
            r4 = -7
            r1 = r0
            r5 = r4
            r3 = r2
            r2 = r1
        L_0x0011:
            okio.Segment r7 = r15.head
            kotlin.jvm.internal.m.c(r7)
            byte[] r8 = r7.data
            int r9 = r7.pos
            int r10 = r7.limit
        L_0x001c:
            if (r9 >= r10) goto L_0x009f
            byte r11 = r8[r9]
            r12 = 48
            byte r12 = (byte) r12
            if (r11 < r12) goto L_0x006f
            r13 = 57
            byte r13 = (byte) r13
            if (r11 > r13) goto L_0x006f
            int r12 = r12 - r11
            r13 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r13 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r13 < 0) goto L_0x0042
            if (r13 != 0) goto L_0x003c
            long r13 = (long) r12
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 >= 0) goto L_0x003c
            goto L_0x0042
        L_0x003c:
            r13 = 10
            long r3 = r3 * r13
            long r11 = (long) r12
            long r3 = r3 + r11
            goto L_0x007b
        L_0x0042:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeDecimalLong((long) r3)
            okio.Buffer r0 = r0.writeByte((int) r11)
            if (r1 != 0) goto L_0x0054
            r0.readByte()
        L_0x0054:
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
            r12 = 45
            byte r12 = (byte) r12
            r13 = 1
            if (r11 != r12) goto L_0x0080
            if (r0 != 0) goto L_0x0080
            r11 = 1
            long r5 = r5 - r11
            r1 = r13
        L_0x007b:
            int r9 = r9 + 1
            int r0 = r0 + 1
            goto L_0x001c
        L_0x0080:
            if (r0 == 0) goto L_0x0084
            r2 = r13
            goto L_0x009f
        L_0x0084:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9] or '-' character but was 0x"
            r1.append(r2)
            java.lang.String r2 = okio.Util.toHexString((byte) r11)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x009f:
            if (r9 != r10) goto L_0x00ab
            okio.Segment r8 = r7.pop()
            r15.head = r8
            okio.SegmentPool.recycle(r7)
            goto L_0x00ad
        L_0x00ab:
            r7.pos = r9
        L_0x00ad:
            if (r2 != 0) goto L_0x00b3
            okio.Segment r7 = r15.head
            if (r7 != 0) goto L_0x0011
        L_0x00b3:
            long r5 = r15.size()
            long r7 = (long) r0
            long r5 = r5 - r7
            r15.setSize$okio(r5)
            if (r1 == 0) goto L_0x00bf
            goto L_0x00c0
        L_0x00bf:
            long r3 = -r3
        L_0x00c0:
            return r3
        L_0x00c1:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        m.f(inputStream, "input");
        readFrom(inputStream, LocationRequestCompat.PASSIVE_INTERVAL, true);
        return this;
    }

    public void readFully(Buffer buffer, long j10) throws EOFException {
        m.f(buffer, "sink");
        if (size() >= j10) {
            buffer.write(this, j10);
        } else {
            buffer.write(this, size());
            throw new EOFException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009a, code lost:
        if (r8 != r9) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009c, code lost:
        r14.head = r6.pop();
        okio.SegmentPool.recycle(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a6, code lost:
        r6.pos = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a8, code lost:
        if (r1 != false) goto L_0x00ae;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
            r14 = this;
            long r0 = r14.size()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00b8
            r0 = 0
            r1 = r0
            r4 = r2
        L_0x000d:
            okio.Segment r6 = r14.head
            kotlin.jvm.internal.m.c(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L_0x0018:
            if (r8 >= r9) goto L_0x009a
            byte r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0029
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0029
            int r11 = r10 - r11
            goto L_0x0043
        L_0x0029:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0038
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0038
        L_0x0033:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L_0x0043
        L_0x0038:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x007b
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x007b
            goto L_0x0033
        L_0x0043:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0053
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0018
        L_0x0053:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong((long) r4)
            okio.Buffer r0 = r0.writeByte((int) r10)
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
        L_0x007b:
            if (r0 == 0) goto L_0x007f
            r1 = 1
            goto L_0x009a
        L_0x007f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = okio.Util.toHexString((byte) r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x009a:
            if (r8 != r9) goto L_0x00a6
            okio.Segment r7 = r6.pop()
            r14.head = r7
            okio.SegmentPool.recycle(r6)
            goto L_0x00a8
        L_0x00a6:
            r6.pos = r8
        L_0x00a8:
            if (r1 != 0) goto L_0x00ae
            okio.Segment r6 = r14.head
            if (r6 != 0) goto L_0x000d
        L_0x00ae:
            long r1 = r14.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.setSize$okio(r1)
            return r4
        L_0x00b8:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    public int readInt() throws EOFException {
        if (size() >= 4) {
            Segment segment = this.head;
            m.c(segment);
            int i10 = segment.pos;
            int i11 = segment.limit;
            if (((long) (i11 - i10)) < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.data;
            byte b10 = ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10] & 255) << 24);
            int i12 = i10 + 3;
            int i13 = i10 + 4;
            byte b11 = (bArr[i12] & 255) | b10 | ((bArr[i10 + 2] & 255) << 8);
            setSize$okio(size() - 4);
            if (i13 == i11) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return b11;
        }
        throw new EOFException();
    }

    public int readIntLe() throws EOFException {
        return Util.reverseBytes(readInt());
    }

    public long readLong() throws EOFException {
        if (size() >= 8) {
            Segment segment = this.head;
            m.c(segment);
            int i10 = segment.pos;
            int i11 = segment.limit;
            if (((long) (i11 - i10)) < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = segment.data;
            long j10 = ((((long) bArr[i10]) & 255) << 56) | ((((long) bArr[i10 + 1]) & 255) << 48) | ((((long) bArr[i10 + 2]) & 255) << 40);
            int i12 = i10 + 7;
            int i13 = i10 + 8;
            long j11 = j10 | ((((long) bArr[i10 + 3]) & 255) << 32) | ((((long) bArr[i10 + 4]) & 255) << 24) | ((((long) bArr[i10 + 5]) & 255) << 16) | ((((long) bArr[i10 + 6]) & 255) << 8) | (((long) bArr[i12]) & 255);
            setSize$okio(size() - 8);
            if (i13 == i11) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return j11;
        }
        throw new EOFException();
    }

    public long readLongLe() throws EOFException {
        return Util.reverseBytes(readLong());
    }

    public short readShort() throws EOFException {
        if (size() >= 2) {
            Segment segment = this.head;
            m.c(segment);
            int i10 = segment.pos;
            int i11 = segment.limit;
            if (i11 - i10 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.data;
            int i12 = i10 + 1;
            int i13 = i10 + 2;
            byte b10 = (bArr[i12] & 255) | ((bArr[i10] & 255) << 8);
            setSize$okio(size() - 2);
            if (i13 == i11) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return (short) b10;
        }
        throw new EOFException();
    }

    public short readShortLe() throws EOFException {
        return Util.reverseBytes(readShort());
    }

    public String readString(Charset charset) {
        m.f(charset, "charset");
        return readString(this.size, charset);
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, (UnsafeCursor) null, 1, (Object) null);
    }

    public String readUtf8() {
        return readString(this.size, d.f797b);
    }

    public int readUtf8CodePoint() throws EOFException {
        byte b10;
        int i10;
        byte b11;
        if (size() != 0) {
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
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            long j10 = (long) i10;
            if (size() >= j10) {
                while (i11 < i10) {
                    long j11 = (long) i11;
                    byte b13 = getByte(j11);
                    if ((b13 & 192) == 128) {
                        b11 = (b11 << 6) | (b13 & Utf8.REPLACEMENT_BYTE);
                        i11++;
                    } else {
                        skip(j11);
                        return Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                skip(j10);
                if (b11 > 1114111) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                if ((55296 <= b11 && 57343 >= b11) || b11 < b10) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                return b11;
            }
            throw new EOFException("size < " + i10 + ": " + size() + " (to read code point prefixed 0x" + Util.toHexString(b12) + ')');
        }
        throw new EOFException();
    }

    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(this, indexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
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

    public int select(Options options) {
        m.f(options, "options");
        int selectPrefix$default = BufferKt.selectPrefix$default(this, options, false, 2, (Object) null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        skip((long) options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public final void setSize$okio(long j10) {
        this.size = j10;
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
            Segment segment = this.head;
            if (segment != null) {
                int min = (int) Math.min(j10, (long) (segment.limit - segment.pos));
                long j11 = (long) min;
                setSize$okio(size() - j11);
                j10 -= j11;
                int i10 = segment.pos + min;
                segment.pos = i10;
                if (i10 == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final ByteString snapshot() {
        if (size() <= ((long) Integer.MAX_VALUE)) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public final Segment writableSegment$okio(int i10) {
        boolean z10 = true;
        if (i10 < 1 || i10 > 8192) {
            z10 = false;
        }
        if (z10) {
            Segment segment = this.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                this.head = take;
                take.prev = take;
                take.next = take;
                return take;
            }
            m.c(segment);
            Segment segment2 = segment.prev;
            m.c(segment2);
            if (segment2.limit + i10 > 8192 || !segment2.owner) {
                return segment2.push(SegmentPool.take());
            }
            return segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    public long writeAll(Source source) throws IOException {
        m.f(source, "source");
        long j10 = 0;
        while (true) {
            long read = source.read(this, (long) 8192);
            if (read == -1) {
                return j10;
            }
            j10 += read;
        }
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo$default(this, outputStream, 0, 2, (Object) null);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j10, long j11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        return buffer.copyTo(buffer2, j10, j11);
    }

    public Buffer clone() {
        return copy();
    }

    public final Buffer copyTo(OutputStream outputStream, long j10) throws IOException {
        return copyTo$default(this, outputStream, j10, 0, 4, (Object) null);
    }

    public long indexOf(byte b10, long j10) {
        return indexOf(b10, j10, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public long indexOfElement(ByteString byteString, long j10) {
        long j11;
        int i10;
        int i11;
        int i12;
        m.f(byteString, "targetBytes");
        long j12 = 0;
        if (j10 >= 0) {
            Segment segment = this.head;
            if (segment == null) {
                return -1;
            }
            if (size() - j10 < j10) {
                j11 = size();
                while (j11 > j10) {
                    segment = segment.prev;
                    m.c(segment);
                    j11 -= (long) (segment.limit - segment.pos);
                }
                if (byteString.size() == 2) {
                    byte b10 = byteString.getByte(0);
                    byte b11 = byteString.getByte(1);
                    while (j11 < size()) {
                        byte[] bArr = segment.data;
                        i11 = (int) ((((long) segment.pos) + j10) - j11);
                        int i13 = segment.limit;
                        while (i11 < i13) {
                            byte b12 = bArr[i11];
                            if (!(b12 == b10 || b12 == b11)) {
                                i11++;
                            }
                        }
                        j11 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        m.c(segment);
                        j10 = j11;
                    }
                    return -1;
                }
                byte[] internalArray$okio = byteString.internalArray$okio();
                while (j11 < size()) {
                    byte[] bArr2 = segment.data;
                    i10 = (int) ((((long) segment.pos) + j10) - j11);
                    int i14 = segment.limit;
                    while (i10 < i14) {
                        byte b13 = bArr2[i10];
                        for (byte b14 : internalArray$okio) {
                            if (b13 == b14) {
                                i12 = segment.pos;
                                return ((long) (i11 - i12)) + j11;
                            }
                        }
                        i10++;
                    }
                    j11 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    m.c(segment);
                    j10 = j11;
                }
                return -1;
            }
            while (true) {
                long j13 = ((long) (segment.limit - segment.pos)) + j12;
                if (j13 > j10) {
                    break;
                }
                segment = segment.next;
                m.c(segment);
                j12 = j13;
            }
            if (byteString.size() == 2) {
                byte b15 = byteString.getByte(0);
                byte b16 = byteString.getByte(1);
                while (j11 < size()) {
                    byte[] bArr3 = segment.data;
                    int i15 = (int) ((((long) segment.pos) + j10) - j11);
                    int i16 = segment.limit;
                    while (i11 < i16) {
                        byte b17 = bArr3[i11];
                        if (!(b17 == b15 || b17 == b16)) {
                            i15 = i11 + 1;
                        }
                    }
                    j12 = j11 + ((long) (segment.limit - segment.pos));
                    segment = segment.next;
                    m.c(segment);
                    j10 = j12;
                }
                return -1;
            }
            byte[] internalArray$okio2 = byteString.internalArray$okio();
            while (j11 < size()) {
                byte[] bArr4 = segment.data;
                int i17 = (int) ((((long) segment.pos) + j10) - j11);
                int i18 = segment.limit;
                while (i10 < i18) {
                    byte b18 = bArr4[i10];
                    for (byte b19 : internalArray$okio2) {
                        if (b18 == b19) {
                            i12 = segment.pos;
                            return ((long) (i11 - i12)) + j11;
                        }
                    }
                    i17 = i10 + 1;
                }
                j12 = j11 + ((long) (segment.limit - segment.pos));
                segment = segment.next;
                m.c(segment);
                j10 = j12;
            }
            return -1;
            i12 = segment.pos;
            return ((long) (i11 - i12)) + j11;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j10).toString());
    }

    public boolean rangeEquals(long j10, ByteString byteString, int i10, int i11) {
        m.f(byteString, "bytes");
        if (j10 < 0 || i10 < 0 || i11 < 0 || size() - j10 < ((long) i11) || byteString.size() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (getByte(((long) i12) + j10) != byteString.getByte(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        m.f(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public byte[] readByteArray(long j10) throws EOFException {
        if (!(j10 >= 0 && j10 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        } else if (size() >= j10) {
            byte[] bArr = new byte[((int) j10)];
            readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    public ByteString readByteString(long j10) throws EOFException {
        if (!(j10 >= 0 && j10 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        } else if (size() < j10) {
            throw new EOFException();
        } else if (j10 < ((long) 4096)) {
            return new ByteString(readByteArray(j10));
        } else {
            ByteString snapshot = snapshot((int) j10);
            skip(j10);
            return snapshot;
        }
    }

    public final Buffer readFrom(InputStream inputStream, long j10) throws IOException {
        m.f(inputStream, "input");
        if (j10 >= 0) {
            readFrom(inputStream, j10, false);
            return this;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
    }

    public String readString(long j10, Charset charset) throws EOFException {
        m.f(charset, "charset");
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (!(i10 >= 0 && j10 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        } else if (this.size < j10) {
            throw new EOFException();
        } else if (i10 == 0) {
            return "";
        } else {
            Segment segment = this.head;
            m.c(segment);
            int i11 = segment.pos;
            if (((long) i11) + j10 > ((long) segment.limit)) {
                return new String(readByteArray(j10), charset);
            }
            int i12 = (int) j10;
            String str = new String(segment.data, i11, i12, charset);
            int i13 = segment.pos + i12;
            segment.pos = i13;
            this.size -= j10;
            if (i13 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return str;
        }
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        m.f(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public String readUtf8(long j10) throws EOFException {
        return readString(j10, d.f797b);
    }

    public String readUtf8LineStrict(long j10) throws EOFException {
        if (j10 >= 0) {
            long j11 = LocationRequestCompat.PASSIVE_INTERVAL;
            if (j10 != LocationRequestCompat.PASSIVE_INTERVAL) {
                j11 = j10 + 1;
            }
            byte b10 = (byte) 10;
            long indexOf = indexOf(b10, 0, j11);
            if (indexOf != -1) {
                return BufferKt.readUtf8Line(this, indexOf);
            }
            if (j11 < size() && getByte(j11 - 1) == ((byte) 13) && getByte(j11) == b10) {
                return BufferKt.readUtf8Line(this, j11);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0, Math.min((long) 32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j10) + " content=" + buffer.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j10).toString());
    }

    public Buffer writeByte(int i10) {
        Segment writableSegment$okio = writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        writableSegment$okio.limit = i11 + 1;
        bArr[i11] = (byte) i10;
        setSize$okio(size() + 1);
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
        Segment writableSegment$okio = writableSegment$okio(i11);
        byte[] bArr = writableSegment$okio.data;
        int i12 = writableSegment$okio.limit + i11;
        while (j10 != 0) {
            long j11 = (long) 10;
            i12--;
            bArr[i12] = BufferKt.getHEX_DIGIT_BYTES()[(int) (j10 % j11)];
            j10 /= j11;
        }
        if (z10) {
            bArr[i12 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i11;
        setSize$okio(size() + ((long) i11));
        return this;
    }

    public Buffer writeHexadecimalUnsignedLong(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        long j11 = (j10 >>> 1) | j10;
        long j12 = j11 | (j11 >>> 2);
        long j13 = j12 | (j12 >>> 4);
        long j14 = j13 | (j13 >>> 8);
        long j15 = j14 | (j14 >>> 16);
        long j16 = j15 | (j15 >>> 32);
        long j17 = j16 - ((j16 >>> 1) & 6148914691236517205L);
        long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
        long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
        long j20 = j19 + (j19 >>> 8);
        long j21 = j20 + (j20 >>> 16);
        int i10 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment writableSegment$okio = writableSegment$okio(i10);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = BufferKt.getHEX_DIGIT_BYTES()[(int) (15 & j10)];
            j10 >>>= 4;
        }
        writableSegment$okio.limit += i10;
        setSize$okio(size() + ((long) i10));
        return this;
    }

    public Buffer writeInt(int i10) {
        Segment writableSegment$okio = writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & 255);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 3] = (byte) (i10 & 255);
        writableSegment$okio.limit = i11 + 4;
        setSize$okio(size() + 4);
        return this;
    }

    public Buffer writeIntLe(int i10) {
        return writeInt(Util.reverseBytes(i10));
    }

    public Buffer writeLong(long j10) {
        Segment writableSegment$okio = writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i10 = writableSegment$okio.limit;
        bArr[i10] = (byte) ((int) ((j10 >>> 56) & 255));
        bArr[i10 + 1] = (byte) ((int) ((j10 >>> 48) & 255));
        bArr[i10 + 2] = (byte) ((int) ((j10 >>> 40) & 255));
        bArr[i10 + 3] = (byte) ((int) ((j10 >>> 32) & 255));
        bArr[i10 + 4] = (byte) ((int) ((j10 >>> 24) & 255));
        bArr[i10 + 5] = (byte) ((int) ((j10 >>> 16) & 255));
        bArr[i10 + 6] = (byte) ((int) ((j10 >>> 8) & 255));
        bArr[i10 + 7] = (byte) ((int) (j10 & 255));
        writableSegment$okio.limit = i10 + 8;
        setSize$okio(size() + 8);
        return this;
    }

    public Buffer writeLongLe(long j10) {
        return writeLong(Util.reverseBytes(j10));
    }

    public Buffer writeShort(int i10) {
        Segment writableSegment$okio = writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 1] = (byte) (i10 & 255);
        writableSegment$okio.limit = i11 + 2;
        setSize$okio(size() + 2);
        return this;
    }

    public Buffer writeShortLe(int i10) {
        return writeShort((int) Util.reverseBytes((short) i10));
    }

    public final Buffer writeTo(OutputStream outputStream, long j10) throws IOException {
        m.f(outputStream, "out");
        Util.checkOffsetAndCount(this.size, 0, j10);
        Segment segment = this.head;
        while (j10 > 0) {
            m.c(segment);
            int min = (int) Math.min(j10, (long) (segment.limit - segment.pos));
            outputStream.write(segment.data, segment.pos, min);
            int i10 = segment.pos + min;
            segment.pos = i10;
            long j11 = (long) min;
            this.size -= j11;
            j10 -= j11;
            if (i10 == segment.limit) {
                Segment pop = segment.pop();
                this.head = pop;
                SegmentPool.recycle(segment);
                segment = pop;
            }
        }
        return this;
    }

    public Buffer writeUtf8CodePoint(int i10) {
        if (i10 < 128) {
            writeByte(i10);
        } else if (i10 < 2048) {
            Segment writableSegment$okio = writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i11 = writableSegment$okio.limit;
            bArr[i11] = (byte) ((i10 >> 6) | 192);
            bArr[i11 + 1] = (byte) ((i10 & 63) | 128);
            writableSegment$okio.limit = i11 + 2;
            setSize$okio(size() + 2);
        } else if (55296 <= i10 && 57343 >= i10) {
            writeByte(63);
        } else if (i10 < 65536) {
            Segment writableSegment$okio2 = writableSegment$okio(3);
            byte[] bArr2 = writableSegment$okio2.data;
            int i12 = writableSegment$okio2.limit;
            bArr2[i12] = (byte) ((i10 >> 12) | 224);
            bArr2[i12 + 1] = (byte) (((i10 >> 6) & 63) | 128);
            bArr2[i12 + 2] = (byte) ((i10 & 63) | 128);
            writableSegment$okio2.limit = i12 + 3;
            setSize$okio(size() + 3);
        } else if (i10 <= 1114111) {
            Segment writableSegment$okio3 = writableSegment$okio(4);
            byte[] bArr3 = writableSegment$okio3.data;
            int i13 = writableSegment$okio3.limit;
            bArr3[i13] = (byte) ((i10 >> 18) | 240);
            bArr3[i13 + 1] = (byte) (((i10 >> 12) & 63) | 128);
            bArr3[i13 + 2] = (byte) (((i10 >> 6) & 63) | 128);
            bArr3[i13 + 3] = (byte) ((i10 & 63) | 128);
            writableSegment$okio3.limit = i13 + 4;
            setSize$okio(size() + 4);
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(i10));
        }
        return this;
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j10, long j11, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        long j12 = j10;
        if ((i10 & 4) != 0) {
            j11 = buffer.size - j12;
        }
        return buffer.copyTo(outputStream, j12, j11);
    }

    public final Buffer copyTo(OutputStream outputStream, long j10, long j11) throws IOException {
        m.f(outputStream, "out");
        Util.checkOffsetAndCount(this.size, j10, j11);
        if (j11 == 0) {
            return this;
        }
        Segment segment = this.head;
        while (true) {
            m.c(segment);
            int i10 = segment.limit;
            int i11 = segment.pos;
            if (j10 < ((long) (i10 - i11))) {
                break;
            }
            j10 -= (long) (i10 - i11);
            segment = segment.next;
        }
        while (j11 > 0) {
            m.c(segment);
            int i12 = (int) (((long) segment.pos) + j10);
            int min = (int) Math.min((long) (segment.limit - i12), j11);
            outputStream.write(segment.data, i12, min);
            j11 -= (long) min;
            segment = segment.next;
            j10 = 0;
        }
        return this;
    }

    public long indexOf(ByteString byteString) throws IOException {
        m.f(byteString, "bytes");
        return indexOf(byteString, 0);
    }

    public Buffer writeString(String str, Charset charset) {
        m.f(str, "string");
        m.f(charset, "charset");
        return writeString(str, 0, str.length(), charset);
    }

    public Buffer writeUtf8(String str) {
        m.f(str, "string");
        return writeUtf8(str, 0, str.length());
    }

    private final void readFrom(InputStream inputStream, long j10, boolean z10) throws IOException {
        while (true) {
            if (j10 > 0 || z10) {
                Segment writableSegment$okio = writableSegment$okio(1);
                int read = inputStream.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j10, (long) (8192 - writableSegment$okio.limit)));
                if (read == -1) {
                    if (writableSegment$okio.pos == writableSegment$okio.limit) {
                        this.head = writableSegment$okio.pop();
                        SegmentPool.recycle(writableSegment$okio);
                    }
                    if (!z10) {
                        throw new EOFException();
                    }
                    return;
                }
                writableSegment$okio.limit += read;
                long j11 = (long) read;
                this.size += j11;
                j10 -= j11;
            } else {
                return;
            }
        }
    }

    public long indexOf(byte b10, long j10, long j11) {
        Segment segment;
        long j12;
        int i10;
        long j13 = 0;
        if (0 <= j10 && j11 >= j10) {
            if (j11 > size()) {
                j11 = size();
            }
            if (j10 == j11 || (segment = this.head) == null) {
                return -1;
            }
            if (size() - j10 < j10) {
                j12 = size();
                while (j12 > j10) {
                    segment = segment.prev;
                    m.c(segment);
                    j12 -= (long) (segment.limit - segment.pos);
                }
                while (j12 < j11) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + j11) - j12);
                    i10 = (int) ((((long) segment.pos) + j10) - j12);
                    while (i10 < min) {
                        if (bArr[i10] != b10) {
                            i10++;
                        }
                    }
                    j12 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    m.c(segment);
                    j10 = j12;
                }
                return -1;
            }
            while (true) {
                long j14 = ((long) (segment.limit - segment.pos)) + j13;
                if (j14 > j10) {
                    break;
                }
                segment = segment.next;
                m.c(segment);
                j13 = j14;
            }
            while (j12 < j11) {
                byte[] bArr2 = segment.data;
                int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + j11) - j12);
                int i11 = (int) ((((long) segment.pos) + j10) - j12);
                while (i10 < min2) {
                    if (bArr2[i10] != b10) {
                        i11 = i10 + 1;
                    }
                }
                j13 = j12 + ((long) (segment.limit - segment.pos));
                segment = segment.next;
                m.c(segment);
                j10 = j13;
            }
            return -1;
            return ((long) (i10 - segment.pos)) + j12;
        }
        throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j10 + " toIndex=" + j11).toString());
    }

    public final ByteString snapshot(int i10) {
        if (i10 == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(size(), 0, (long) i10);
        Segment segment = this.head;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            m.c(segment);
            int i14 = segment.limit;
            int i15 = segment.pos;
            if (i14 != i15) {
                i12 += i14 - i15;
                i13++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i13][];
        int[] iArr = new int[(i13 * 2)];
        Segment segment2 = this.head;
        int i16 = 0;
        while (i11 < i10) {
            m.c(segment2);
            bArr[i16] = segment2.data;
            i11 += segment2.limit - segment2.pos;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = segment2.pos;
            segment2.shared = true;
            i16++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    public Buffer writeString(String str, int i10, int i11, Charset charset) {
        m.f(str, "string");
        m.f(charset, "charset");
        boolean z10 = true;
        if (i10 >= 0) {
            if (i11 >= i10) {
                if (i11 > str.length()) {
                    z10 = false;
                }
                if (!z10) {
                    throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + str.length()).toString());
                } else if (m.b(charset, d.f797b)) {
                    return writeUtf8(str, i10, i11);
                } else {
                    String substring = str.substring(i10, i11);
                    m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring != null) {
                        byte[] bytes = substring.getBytes(charset);
                        m.e(bytes, "(this as java.lang.String).getBytes(charset)");
                        return write(bytes, 0, bytes.length);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
        }
    }

    public Buffer writeUtf8(String str, int i10, int i11) {
        m.f(str, "string");
        if (i10 >= 0) {
            if (i11 >= i10) {
                if (i11 <= str.length()) {
                    while (i10 < i11) {
                        char charAt = str.charAt(i10);
                        if (charAt < 128) {
                            Segment writableSegment$okio = writableSegment$okio(1);
                            byte[] bArr = writableSegment$okio.data;
                            int i12 = writableSegment$okio.limit - i10;
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
                            int i14 = writableSegment$okio.limit;
                            int i15 = (i12 + i13) - i14;
                            writableSegment$okio.limit = i14 + i15;
                            setSize$okio(size() + ((long) i15));
                            i10 = i13;
                        } else {
                            if (charAt < 2048) {
                                Segment writableSegment$okio2 = writableSegment$okio(2);
                                byte[] bArr2 = writableSegment$okio2.data;
                                int i16 = writableSegment$okio2.limit;
                                bArr2[i16] = (byte) ((charAt >> 6) | 192);
                                bArr2[i16 + 1] = (byte) ((charAt & '?') | 128);
                                writableSegment$okio2.limit = i16 + 2;
                                setSize$okio(size() + 2);
                            } else if (charAt < 55296 || charAt > 57343) {
                                Segment writableSegment$okio3 = writableSegment$okio(3);
                                byte[] bArr3 = writableSegment$okio3.data;
                                int i17 = writableSegment$okio3.limit;
                                bArr3[i17] = (byte) ((charAt >> 12) | 224);
                                bArr3[i17 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                                bArr3[i17 + 2] = (byte) ((charAt & '?') | 128);
                                writableSegment$okio3.limit = i17 + 3;
                                setSize$okio(size() + 3);
                            } else {
                                int i18 = i10 + 1;
                                char charAt3 = i18 < i11 ? str.charAt(i18) : 0;
                                if (charAt > 56319 || 56320 > charAt3 || 57343 < charAt3) {
                                    writeByte(63);
                                    i10 = i18;
                                } else {
                                    int i19 = (((charAt & 1023) << 10) | (charAt3 & 1023)) + 0;
                                    Segment writableSegment$okio4 = writableSegment$okio(4);
                                    byte[] bArr4 = writableSegment$okio4.data;
                                    int i20 = writableSegment$okio4.limit;
                                    bArr4[i20] = (byte) ((i19 >> 18) | 240);
                                    bArr4[i20 + 1] = (byte) (((i19 >> 12) & 63) | 128);
                                    bArr4[i20 + 2] = (byte) (((i19 >> 6) & 63) | 128);
                                    bArr4[i20 + 3] = (byte) ((i19 & 63) | 128);
                                    writableSegment$okio4.limit = i20 + 4;
                                    setSize$okio(size() + 4);
                                    i10 += 2;
                                }
                            }
                            i10++;
                        }
                    }
                    return this;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
    }

    public void readFully(byte[] bArr) throws EOFException {
        m.f(bArr, "sink");
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

    public int write(ByteBuffer byteBuffer) throws IOException {
        m.f(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i10 = remaining;
        while (i10 > 0) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i10, 8192 - writableSegment$okio.limit);
            byteBuffer.get(writableSegment$okio.data, writableSegment$okio.limit, min);
            i10 -= min;
            writableSegment$okio.limit += min;
        }
        this.size += (long) remaining;
        return remaining;
    }

    public int read(byte[] bArr) {
        m.f(bArr, "sink");
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i10, int i11) {
        m.f(bArr, "sink");
        Util.checkOffsetAndCount((long) bArr.length, (long) i10, (long) i11);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i11, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i12 = segment.pos;
        kotlin.collections.j.d(bArr2, bArr, i10, i12, i12 + min);
        segment.pos += min;
        setSize$okio(size() - ((long) min));
        if (segment.pos != segment.limit) {
            return min;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return min;
    }

    public final Buffer copyTo(Buffer buffer, long j10) {
        m.f(buffer, "out");
        return copyTo(buffer, j10, this.size - j10);
    }

    public Buffer write(ByteString byteString) {
        m.f(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    public final Buffer copyTo(Buffer buffer, long j10, long j11) {
        m.f(buffer, "out");
        Util.checkOffsetAndCount(size(), j10, j11);
        if (j11 != 0) {
            buffer.setSize$okio(buffer.size() + j11);
            Segment segment = this.head;
            while (true) {
                m.c(segment);
                int i10 = segment.limit;
                int i11 = segment.pos;
                if (j10 < ((long) (i10 - i11))) {
                    break;
                }
                j10 -= (long) (i10 - i11);
                segment = segment.next;
            }
            while (j11 > 0) {
                m.c(segment);
                Segment sharedCopy = segment.sharedCopy();
                int i12 = sharedCopy.pos + ((int) j10);
                sharedCopy.pos = i12;
                sharedCopy.limit = Math.min(i12 + ((int) j11), sharedCopy.limit);
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy;
                    buffer.head = sharedCopy;
                } else {
                    m.c(segment2);
                    Segment segment3 = segment2.prev;
                    m.c(segment3);
                    segment3.push(sharedCopy);
                }
                j11 -= (long) (sharedCopy.limit - sharedCopy.pos);
                segment = segment.next;
                j10 = 0;
            }
        }
        return this;
    }

    public Buffer write(ByteString byteString, int i10, int i11) {
        m.f(byteString, "byteString");
        byteString.write$okio(this, i10, i11);
        return this;
    }

    public Buffer write(byte[] bArr) {
        m.f(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    public Buffer write(byte[] bArr, int i10, int i11) {
        m.f(bArr, "source");
        long j10 = (long) i11;
        Util.checkOffsetAndCount((long) bArr.length, (long) i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i12 - i10, 8192 - writableSegment$okio.limit);
            int i13 = i10 + min;
            kotlin.collections.j.d(bArr, writableSegment$okio.data, writableSegment$okio.limit, i10, i13);
            writableSegment$okio.limit += min;
            i10 = i13;
        }
        setSize$okio(size() + j10);
        return this;
    }

    public long read(Buffer buffer, long j10) {
        m.f(buffer, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (size() == 0) {
            return -1;
        } else {
            if (j10 > size()) {
                j10 = size();
            }
            buffer.write(this, j10);
            return j10;
        }
    }

    public Buffer write(Source source, long j10) throws IOException {
        m.f(source, "source");
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

    public long indexOf(ByteString byteString, long j10) throws IOException {
        long j11 = j10;
        m.f(byteString, "bytes");
        if (byteString.size() > 0) {
            long j12 = 0;
            if (j11 >= 0) {
                Segment segment = this.head;
                if (segment != null) {
                    if (size() - j11 < j11) {
                        long size2 = size();
                        while (size2 > j11) {
                            segment = segment.prev;
                            m.c(segment);
                            size2 -= (long) (segment.limit - segment.pos);
                        }
                        byte[] internalArray$okio = byteString.internalArray$okio();
                        byte b10 = internalArray$okio[0];
                        int size3 = byteString.size();
                        long size4 = (size() - ((long) size3)) + 1;
                        while (size2 < size4) {
                            byte[] bArr = segment.data;
                            long j13 = size2;
                            int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + size4) - size2);
                            long j14 = ((long) segment.pos) + j11;
                            long j15 = j13;
                            for (int i10 = (int) (j14 - j15); i10 < min; i10++) {
                                if (bArr[i10] == b10 && BufferKt.rangeEquals(segment, i10 + 1, internalArray$okio, 1, size3)) {
                                    return ((long) (i10 - segment.pos)) + j15;
                                }
                            }
                            size2 = j15 + ((long) (segment.limit - segment.pos));
                            segment = segment.next;
                            m.c(segment);
                            j11 = size2;
                        }
                    } else {
                        while (true) {
                            long j16 = ((long) (segment.limit - segment.pos)) + j12;
                            if (j16 > j11) {
                                break;
                            }
                            segment = segment.next;
                            m.c(segment);
                            j12 = j16;
                        }
                        byte[] internalArray$okio2 = byteString.internalArray$okio();
                        byte b11 = internalArray$okio2[0];
                        int size5 = byteString.size();
                        long size6 = (size() - ((long) size5)) + 1;
                        while (j12 < size6) {
                            byte[] bArr2 = segment.data;
                            long j17 = size6;
                            int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + size6) - j12);
                            for (int i11 = (int) ((((long) segment.pos) + j11) - j12); i11 < min2; i11++) {
                                if (bArr2[i11] == b11) {
                                    if (BufferKt.rangeEquals(segment, i11 + 1, internalArray$okio2, 1, size5)) {
                                        return ((long) (i11 - segment.pos)) + j12;
                                    }
                                }
                            }
                            j12 += (long) (segment.limit - segment.pos);
                            segment = segment.next;
                            m.c(segment);
                            j11 = j12;
                            size6 = j17;
                        }
                    }
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex < 0: " + j11).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    public void write(Buffer buffer, long j10) {
        Segment segment;
        m.f(buffer, "source");
        if (buffer != this) {
            Util.checkOffsetAndCount(buffer.size(), 0, j10);
            while (j10 > 0) {
                Segment segment2 = buffer.head;
                m.c(segment2);
                int i10 = segment2.limit;
                Segment segment3 = buffer.head;
                m.c(segment3);
                if (j10 < ((long) (i10 - segment3.pos))) {
                    Segment segment4 = this.head;
                    if (segment4 != null) {
                        m.c(segment4);
                        segment = segment4.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((((long) segment.limit) + j10) - ((long) (segment.shared ? 0 : segment.pos)) <= ((long) 8192)) {
                            Segment segment5 = buffer.head;
                            m.c(segment5);
                            segment5.writeTo(segment, (int) j10);
                            buffer.setSize$okio(buffer.size() - j10);
                            setSize$okio(size() + j10);
                            return;
                        }
                    }
                    Segment segment6 = buffer.head;
                    m.c(segment6);
                    buffer.head = segment6.split((int) j10);
                }
                Segment segment7 = buffer.head;
                m.c(segment7);
                long j11 = (long) (segment7.limit - segment7.pos);
                buffer.head = segment7.pop();
                Segment segment8 = this.head;
                if (segment8 == null) {
                    this.head = segment7;
                    segment7.prev = segment7;
                    segment7.next = segment7;
                } else {
                    m.c(segment8);
                    Segment segment9 = segment8.prev;
                    m.c(segment9);
                    segment9.push(segment7).compact();
                }
                buffer.setSize$okio(buffer.size() - j11);
                setSize$okio(size() + j11);
                j10 -= j11;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }
}
