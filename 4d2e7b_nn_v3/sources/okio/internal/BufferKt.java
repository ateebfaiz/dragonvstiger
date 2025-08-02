package okio.internal;

import androidx.core.location.LocationRequestCompat;
import androidx.work.WorkRequest;
import java.io.EOFException;
import kotlin.collections.j;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Platform;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio.Util;

public final class BufferKt {
    private static final byte[] HEX_DIGIT_BYTES = Platform.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(Buffer buffer) {
        m.f(buffer, "$this$commonClear");
        buffer.skip(buffer.size());
    }

    public static final long commonCompleteSegmentByteCount(Buffer buffer) {
        m.f(buffer, "$this$commonCompleteSegmentByteCount");
        long size = buffer.size();
        if (size == 0) {
            return 0;
        }
        Segment segment = buffer.head;
        m.c(segment);
        Segment segment2 = segment.prev;
        m.c(segment2);
        int i10 = segment2.limit;
        if (i10 >= 8192 || !segment2.owner) {
            return size;
        }
        return size - ((long) (i10 - segment2.pos));
    }

    public static final Buffer commonCopy(Buffer buffer) {
        m.f(buffer, "$this$commonCopy");
        Buffer buffer2 = new Buffer();
        if (buffer.size() == 0) {
            return buffer2;
        }
        Segment segment = buffer.head;
        m.c(segment);
        Segment sharedCopy = segment.sharedCopy();
        buffer2.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            m.c(segment3);
            m.c(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer2.setSize$okio(buffer.size());
        return buffer2;
    }

    public static final Buffer commonCopyTo(Buffer buffer, Buffer buffer2, long j10, long j11) {
        m.f(buffer, "$this$commonCopyTo");
        m.f(buffer2, "out");
        Util.checkOffsetAndCount(buffer.size(), j10, j11);
        if (j11 == 0) {
            return buffer;
        }
        buffer2.setSize$okio(buffer2.size() + j11);
        Segment segment = buffer.head;
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
            Segment segment2 = buffer2.head;
            if (segment2 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy;
                buffer2.head = sharedCopy;
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
        return buffer;
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean commonEquals(okio.Buffer r18, java.lang.Object r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "$this$commonEquals"
            kotlin.jvm.internal.m.f(r0, r2)
            r2 = 1
            if (r0 != r1) goto L_0x000d
            return r2
        L_0x000d:
            boolean r3 = r1 instanceof okio.Buffer
            r4 = 0
            if (r3 != 0) goto L_0x0013
            return r4
        L_0x0013:
            long r5 = r18.size()
            okio.Buffer r1 = (okio.Buffer) r1
            long r7 = r1.size()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0022
            return r4
        L_0x0022:
            long r5 = r18.size()
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x002d
            return r2
        L_0x002d:
            okio.Segment r3 = r0.head
            kotlin.jvm.internal.m.c(r3)
            okio.Segment r1 = r1.head
            kotlin.jvm.internal.m.c(r1)
            int r5 = r3.pos
            int r6 = r1.pos
            r9 = r7
        L_0x003c:
            long r11 = r18.size()
            int r11 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0083
            int r11 = r3.limit
            int r11 = r11 - r5
            int r12 = r1.limit
            int r12 = r12 - r6
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            r13 = r7
        L_0x0050:
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 >= 0) goto L_0x006b
            byte[] r15 = r3.data
            int r16 = r5 + 1
            byte r5 = r15[r5]
            byte[] r15 = r1.data
            int r17 = r6 + 1
            byte r6 = r15[r6]
            if (r5 == r6) goto L_0x0063
            return r4
        L_0x0063:
            r5 = 1
            long r13 = r13 + r5
            r5 = r16
            r6 = r17
            goto L_0x0050
        L_0x006b:
            int r13 = r3.limit
            if (r5 != r13) goto L_0x0076
            okio.Segment r3 = r3.next
            kotlin.jvm.internal.m.c(r3)
            int r5 = r3.pos
        L_0x0076:
            int r13 = r1.limit
            if (r6 != r13) goto L_0x0081
            okio.Segment r1 = r1.next
            kotlin.jvm.internal.m.c(r1)
            int r6 = r1.pos
        L_0x0081:
            long r9 = r9 + r11
            goto L_0x003c
        L_0x0083:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonEquals(okio.Buffer, java.lang.Object):boolean");
    }

    public static final byte commonGet(Buffer buffer, long j10) {
        m.f(buffer, "$this$commonGet");
        Util.checkOffsetAndCount(buffer.size(), j10, 1);
        Segment segment = buffer.head;
        if (segment == null) {
            m.c((Object) null);
            throw null;
        } else if (buffer.size() - j10 < j10) {
            long size = buffer.size();
            while (size > j10) {
                segment = segment.prev;
                m.c(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            m.c(segment);
            return segment.data[(int) ((((long) segment.pos) + j10) - size)];
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

    public static final int commonHashCode(Buffer buffer) {
        m.f(buffer, "$this$commonHashCode");
        Segment segment = buffer.head;
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
        } while (segment != buffer.head);
        return i10;
    }

    public static final long commonIndexOf(Buffer buffer, byte b10, long j10, long j11) {
        Segment segment;
        long j12;
        int i10;
        m.f(buffer, "$this$commonIndexOf");
        long j13 = 0;
        if (0 <= j10 && j11 >= j10) {
            if (j11 > buffer.size()) {
                j11 = buffer.size();
            }
            if (j10 == j11 || (segment = buffer.head) == null) {
                return -1;
            }
            if (buffer.size() - j10 < j10) {
                j12 = buffer.size();
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
        throw new IllegalArgumentException(("size=" + buffer.size() + " fromIndex=" + j10 + " toIndex=" + j11).toString());
    }

    public static final long commonIndexOfElement(Buffer buffer, ByteString byteString, long j10) {
        boolean z10;
        long j11;
        int i10;
        int i11;
        int i12;
        m.f(buffer, "$this$commonIndexOfElement");
        m.f(byteString, "targetBytes");
        long j12 = 0;
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            Segment segment = buffer.head;
            if (segment == null) {
                return -1;
            }
            if (buffer.size() - j10 < j10) {
                j11 = buffer.size();
                while (j11 > j10) {
                    segment = segment.prev;
                    m.c(segment);
                    j11 -= (long) (segment.limit - segment.pos);
                }
                if (byteString.size() == 2) {
                    byte b10 = byteString.getByte(0);
                    byte b11 = byteString.getByte(1);
                    while (j11 < buffer.size()) {
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
                } else {
                    byte[] internalArray$okio = byteString.internalArray$okio();
                    while (j11 < buffer.size()) {
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
                while (j11 < buffer.size()) {
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
            } else {
                byte[] internalArray$okio2 = byteString.internalArray$okio();
                while (j11 < buffer.size()) {
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
            }
            return -1;
            i12 = segment.pos;
            return ((long) (i11 - i12)) + j11;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j10).toString());
    }

    public static final boolean commonRangeEquals(Buffer buffer, long j10, ByteString byteString, int i10, int i11) {
        m.f(buffer, "$this$commonRangeEquals");
        m.f(byteString, "bytes");
        if (j10 < 0 || i10 < 0 || i11 < 0 || buffer.size() - j10 < ((long) i11) || byteString.size() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (buffer.getByte(((long) i12) + j10) != byteString.getByte(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(Buffer buffer, byte[] bArr) {
        m.f(buffer, "$this$commonRead");
        m.f(bArr, "sink");
        return buffer.read(bArr, 0, bArr.length);
    }

    public static final long commonReadAll(Buffer buffer, Sink sink) {
        m.f(buffer, "$this$commonReadAll");
        m.f(sink, "sink");
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    public static final byte commonReadByte(Buffer buffer) {
        m.f(buffer, "$this$commonReadByte");
        if (buffer.size() != 0) {
            Segment segment = buffer.head;
            m.c(segment);
            int i10 = segment.pos;
            int i11 = segment.limit;
            int i12 = i10 + 1;
            byte b10 = segment.data[i10];
            buffer.setSize$okio(buffer.size() - 1);
            if (i12 == i11) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i12;
            }
            return b10;
        }
        throw new EOFException();
    }

    public static final byte[] commonReadByteArray(Buffer buffer) {
        m.f(buffer, "$this$commonReadByteArray");
        return buffer.readByteArray(buffer.size());
    }

    public static final ByteString commonReadByteString(Buffer buffer) {
        m.f(buffer, "$this$commonReadByteString");
        return buffer.readByteString(buffer.size());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a4, code lost:
        if (r9 != r10) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a6, code lost:
        r15.head = r7.pop();
        okio.SegmentPool.recycle(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b0, code lost:
        r7.pos = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b2, code lost:
        if (r2 != false) goto L_0x00b8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonReadDecimalLong(okio.Buffer r15) {
        /*
            java.lang.String r0 = "$this$commonReadDecimalLong"
            kotlin.jvm.internal.m.f(r15, r0)
            long r0 = r15.size()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00c6
            r0 = 0
            r4 = -7
            r1 = r0
            r5 = r4
            r3 = r2
            r2 = r1
        L_0x0016:
            okio.Segment r7 = r15.head
            kotlin.jvm.internal.m.c(r7)
            byte[] r8 = r7.data
            int r9 = r7.pos
            int r10 = r7.limit
        L_0x0021:
            if (r9 >= r10) goto L_0x00a4
            byte r11 = r8[r9]
            r12 = 48
            byte r12 = (byte) r12
            if (r11 < r12) goto L_0x0074
            r13 = 57
            byte r13 = (byte) r13
            if (r11 > r13) goto L_0x0074
            int r12 = r12 - r11
            r13 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r13 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r13 < 0) goto L_0x0047
            if (r13 != 0) goto L_0x0041
            long r13 = (long) r12
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 >= 0) goto L_0x0041
            goto L_0x0047
        L_0x0041:
            r13 = 10
            long r3 = r3 * r13
            long r11 = (long) r12
            long r3 = r3 + r11
            goto L_0x0080
        L_0x0047:
            okio.Buffer r15 = new okio.Buffer
            r15.<init>()
            okio.Buffer r15 = r15.writeDecimalLong((long) r3)
            okio.Buffer r15 = r15.writeByte((int) r11)
            if (r1 != 0) goto L_0x0059
            r15.readByte()
        L_0x0059:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r15 = r15.readUtf8()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L_0x0074:
            r12 = 45
            byte r12 = (byte) r12
            r13 = 1
            if (r11 != r12) goto L_0x0085
            if (r0 != 0) goto L_0x0085
            r11 = 1
            long r5 = r5 - r11
            r1 = r13
        L_0x0080:
            int r9 = r9 + 1
            int r0 = r0 + 1
            goto L_0x0021
        L_0x0085:
            if (r0 == 0) goto L_0x0089
            r2 = r13
            goto L_0x00a4
        L_0x0089:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9] or '-' character but was 0x"
            r0.append(r1)
            java.lang.String r1 = okio.Util.toHexString((byte) r11)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L_0x00a4:
            if (r9 != r10) goto L_0x00b0
            okio.Segment r8 = r7.pop()
            r15.head = r8
            okio.SegmentPool.recycle(r7)
            goto L_0x00b2
        L_0x00b0:
            r7.pos = r9
        L_0x00b2:
            if (r2 != 0) goto L_0x00b8
            okio.Segment r7 = r15.head
            if (r7 != 0) goto L_0x0016
        L_0x00b8:
            long r5 = r15.size()
            long r7 = (long) r0
            long r5 = r5 - r7
            r15.setSize$okio(r5)
            if (r1 == 0) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            long r3 = -r3
        L_0x00c5:
            return r3
        L_0x00c6:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadDecimalLong(okio.Buffer):long");
    }

    public static final void commonReadFully(Buffer buffer, byte[] bArr) {
        m.f(buffer, "$this$commonReadFully");
        m.f(bArr, "sink");
        int i10 = 0;
        while (i10 < bArr.length) {
            int read = buffer.read(bArr, i10, bArr.length - i10);
            if (read != -1) {
                i10 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009f A[EDGE_INSN: B:44:0x009f->B:28:0x009f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonReadHexadecimalUnsignedLong(okio.Buffer r14) {
        /*
            java.lang.String r0 = "$this$commonReadHexadecimalUnsignedLong"
            kotlin.jvm.internal.m.f(r14, r0)
            long r0 = r14.size()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00bd
            r0 = 0
            r1 = r0
            r4 = r2
        L_0x0012:
            okio.Segment r6 = r14.head
            kotlin.jvm.internal.m.c(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L_0x001d:
            if (r8 >= r9) goto L_0x009f
            byte r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x002e
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x002e
            int r11 = r10 - r11
            goto L_0x0048
        L_0x002e:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x003d
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x003d
        L_0x0038:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L_0x0048
        L_0x003d:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0080
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0080
            goto L_0x0038
        L_0x0048:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0058
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x001d
        L_0x0058:
            okio.Buffer r14 = new okio.Buffer
            r14.<init>()
            okio.Buffer r14 = r14.writeHexadecimalUnsignedLong((long) r4)
            okio.Buffer r14 = r14.writeByte((int) r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r14 = r14.readUtf8()
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            r0.<init>(r14)
            throw r0
        L_0x0080:
            if (r0 == 0) goto L_0x0084
            r1 = 1
            goto L_0x009f
        L_0x0084:
            java.lang.NumberFormatException r14 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = okio.Util.toHexString((byte) r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        L_0x009f:
            if (r8 != r9) goto L_0x00ab
            okio.Segment r7 = r6.pop()
            r14.head = r7
            okio.SegmentPool.recycle(r6)
            goto L_0x00ad
        L_0x00ab:
            r6.pos = r8
        L_0x00ad:
            if (r1 != 0) goto L_0x00b3
            okio.Segment r6 = r14.head
            if (r6 != 0) goto L_0x0012
        L_0x00b3:
            long r1 = r14.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.setSize$okio(r1)
            return r4
        L_0x00bd:
            java.io.EOFException r14 = new java.io.EOFException
            r14.<init>()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadHexadecimalUnsignedLong(okio.Buffer):long");
    }

    public static final int commonReadInt(Buffer buffer) {
        m.f(buffer, "$this$commonReadInt");
        if (buffer.size() >= 4) {
            Segment segment = buffer.head;
            m.c(segment);
            int i10 = segment.pos;
            int i11 = segment.limit;
            if (((long) (i11 - i10)) < 4) {
                return (buffer.readByte() & 255) | ((buffer.readByte() & 255) << 24) | ((buffer.readByte() & 255) << 16) | ((buffer.readByte() & 255) << 8);
            }
            byte[] bArr = segment.data;
            byte b10 = ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10] & 255) << 24);
            int i12 = i10 + 3;
            int i13 = i10 + 4;
            byte b11 = (bArr[i12] & 255) | b10 | ((bArr[i10 + 2] & 255) << 8);
            buffer.setSize$okio(buffer.size() - 4);
            if (i13 == i11) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return b11;
        }
        throw new EOFException();
    }

    public static final long commonReadLong(Buffer buffer) {
        m.f(buffer, "$this$commonReadLong");
        if (buffer.size() >= 8) {
            Segment segment = buffer.head;
            m.c(segment);
            int i10 = segment.pos;
            int i11 = segment.limit;
            if (((long) (i11 - i10)) < 8) {
                return ((((long) buffer.readInt()) & 4294967295L) << 32) | (4294967295L & ((long) buffer.readInt()));
            }
            byte[] bArr = segment.data;
            long j10 = ((((long) bArr[i10]) & 255) << 56) | ((((long) bArr[i10 + 1]) & 255) << 48) | ((((long) bArr[i10 + 2]) & 255) << 40);
            int i12 = i10 + 7;
            int i13 = i10 + 8;
            long j11 = j10 | ((((long) bArr[i10 + 3]) & 255) << 32) | ((((long) bArr[i10 + 4]) & 255) << 24) | ((((long) bArr[i10 + 5]) & 255) << 16) | ((((long) bArr[i10 + 6]) & 255) << 8) | (((long) bArr[i12]) & 255);
            buffer.setSize$okio(buffer.size() - 8);
            if (i13 == i11) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return j11;
        }
        throw new EOFException();
    }

    public static final short commonReadShort(Buffer buffer) {
        m.f(buffer, "$this$commonReadShort");
        if (buffer.size() >= 2) {
            Segment segment = buffer.head;
            m.c(segment);
            int i10 = segment.pos;
            int i11 = segment.limit;
            if (i11 - i10 < 2) {
                return (short) ((buffer.readByte() & 255) | ((buffer.readByte() & 255) << 8));
            }
            byte[] bArr = segment.data;
            int i12 = i10 + 1;
            int i13 = i10 + 2;
            byte b10 = (bArr[i12] & 255) | ((bArr[i10] & 255) << 8);
            buffer.setSize$okio(buffer.size() - 2);
            if (i13 == i11) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return (short) b10;
        }
        throw new EOFException();
    }

    public static final String commonReadUtf8(Buffer buffer, long j10) {
        boolean z10;
        m.f(buffer, "$this$commonReadUtf8");
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 < 0 || j10 > ((long) Integer.MAX_VALUE)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        } else if (buffer.size() < j10) {
            throw new EOFException();
        } else if (i10 == 0) {
            return "";
        } else {
            Segment segment = buffer.head;
            m.c(segment);
            int i11 = segment.pos;
            if (((long) i11) + j10 > ((long) segment.limit)) {
                return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j10), 0, 0, 3, (Object) null);
            }
            int i12 = (int) j10;
            String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i11, i11 + i12);
            segment.pos += i12;
            buffer.setSize$okio(buffer.size() - j10);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return commonToUtf8String;
        }
    }

    public static final int commonReadUtf8CodePoint(Buffer buffer) {
        byte b10;
        int i10;
        byte b11;
        m.f(buffer, "$this$commonReadUtf8CodePoint");
        if (buffer.size() != 0) {
            byte b12 = buffer.getByte(0);
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
                buffer.skip(1);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            long j10 = (long) i10;
            if (buffer.size() >= j10) {
                while (i11 < i10) {
                    long j11 = (long) i11;
                    byte b13 = buffer.getByte(j11);
                    if ((b13 & 192) == 128) {
                        b11 = (b11 << 6) | (b13 & Utf8.REPLACEMENT_BYTE);
                        i11++;
                    } else {
                        buffer.skip(j11);
                        return Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                buffer.skip(j10);
                if (b11 > 1114111) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                if ((55296 <= b11 && 57343 >= b11) || b11 < b10) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                return b11;
            }
            throw new EOFException("size < " + i10 + ": " + buffer.size() + " (to read code point prefixed 0x" + Util.toHexString(b12) + ')');
        }
        throw new EOFException();
    }

    public static final String commonReadUtf8Line(Buffer buffer) {
        m.f(buffer, "$this$commonReadUtf8Line");
        long indexOf = buffer.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(Buffer buffer, long j10) {
        boolean z10;
        m.f(buffer, "$this$commonReadUtf8LineStrict");
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            long j11 = LocationRequestCompat.PASSIVE_INTERVAL;
            if (j10 != LocationRequestCompat.PASSIVE_INTERVAL) {
                j11 = j10 + 1;
            }
            byte b10 = (byte) 10;
            long indexOf = buffer.indexOf(b10, 0, j11);
            if (indexOf != -1) {
                return readUtf8Line(buffer, indexOf);
            }
            if (j11 < buffer.size() && buffer.getByte(j11 - 1) == ((byte) 13) && buffer.getByte(j11) == b10) {
                return readUtf8Line(buffer, j11);
            }
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, Math.min((long) 32, buffer.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(buffer.size(), j10) + " content=" + buffer2.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j10).toString());
    }

    public static final int commonSelect(Buffer buffer, Options options) {
        m.f(buffer, "$this$commonSelect");
        m.f(options, "options");
        int selectPrefix$default = selectPrefix$default(buffer, options, false, 2, (Object) null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        buffer.skip((long) options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonSkip(Buffer buffer, long j10) {
        m.f(buffer, "$this$commonSkip");
        while (j10 > 0) {
            Segment segment = buffer.head;
            if (segment != null) {
                int min = (int) Math.min(j10, (long) (segment.limit - segment.pos));
                long j11 = (long) min;
                buffer.setSize$okio(buffer.size() - j11);
                j10 -= j11;
                int i10 = segment.pos + min;
                segment.pos = i10;
                if (i10 == segment.limit) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public static final ByteString commonSnapshot(Buffer buffer) {
        m.f(buffer, "$this$commonSnapshot");
        if (buffer.size() <= ((long) Integer.MAX_VALUE)) {
            return buffer.snapshot((int) buffer.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + buffer.size()).toString());
    }

    public static final Segment commonWritableSegment(Buffer buffer, int i10) {
        m.f(buffer, "$this$commonWritableSegment");
        boolean z10 = true;
        if (i10 < 1 || i10 > 8192) {
            z10 = false;
        }
        if (z10) {
            Segment segment = buffer.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                buffer.head = take;
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

    public static final Buffer commonWrite(Buffer buffer, ByteString byteString, int i10, int i11) {
        m.f(buffer, "$this$commonWrite");
        m.f(byteString, "byteString");
        byteString.write$okio(buffer, i10, i11);
        return buffer;
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer buffer, ByteString byteString, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = byteString.size();
        }
        m.f(buffer, "$this$commonWrite");
        m.f(byteString, "byteString");
        byteString.write$okio(buffer, i10, i11);
        return buffer;
    }

    public static final long commonWriteAll(Buffer buffer, Source source) {
        m.f(buffer, "$this$commonWriteAll");
        m.f(source, "source");
        long j10 = 0;
        while (true) {
            long read = source.read(buffer, (long) 8192);
            if (read == -1) {
                return j10;
            }
            j10 += read;
        }
    }

    public static final Buffer commonWriteByte(Buffer buffer, int i10) {
        m.f(buffer, "$this$commonWriteByte");
        Segment writableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        writableSegment$okio.limit = i11 + 1;
        bArr[i11] = (byte) i10;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    public static final Buffer commonWriteDecimalLong(Buffer buffer, long j10) {
        boolean z10;
        m.f(buffer, "$this$commonWriteDecimalLong");
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 == 0) {
            return buffer.writeByte(48);
        }
        int i11 = 1;
        if (i10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return buffer.writeUtf8("-9223372036854775808");
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (j10 < 100000000) {
            if (j10 < WorkRequest.MIN_BACKOFF_MILLIS) {
                if (j10 < 100) {
                    if (j10 >= 10) {
                        i11 = 2;
                    }
                } else if (j10 < 1000) {
                    i11 = 3;
                } else {
                    i11 = 4;
                }
            } else if (j10 < 1000000) {
                if (j10 < 100000) {
                    i11 = 5;
                } else {
                    i11 = 6;
                }
            } else if (j10 < 10000000) {
                i11 = 7;
            } else {
                i11 = 8;
            }
        } else if (j10 < 1000000000000L) {
            if (j10 < RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                if (j10 < 1000000000) {
                    i11 = 9;
                } else {
                    i11 = 10;
                }
            } else if (j10 < 100000000000L) {
                i11 = 11;
            } else {
                i11 = 12;
            }
        } else if (j10 < 1000000000000000L) {
            if (j10 < 10000000000000L) {
                i11 = 13;
            } else if (j10 < 100000000000000L) {
                i11 = 14;
            } else {
                i11 = 15;
            }
        } else if (j10 < 100000000000000000L) {
            if (j10 < 10000000000000000L) {
                i11 = 16;
            } else {
                i11 = 17;
            }
        } else if (j10 < 1000000000000000000L) {
            i11 = 18;
        } else {
            i11 = 19;
        }
        if (z10) {
            i11++;
        }
        Segment writableSegment$okio = buffer.writableSegment$okio(i11);
        byte[] bArr = writableSegment$okio.data;
        int i12 = writableSegment$okio.limit + i11;
        while (j10 != 0) {
            long j11 = (long) 10;
            i12--;
            bArr[i12] = getHEX_DIGIT_BYTES()[(int) (j10 % j11)];
            j10 /= j11;
        }
        if (z10) {
            bArr[i12 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i11;
        buffer.setSize$okio(buffer.size() + ((long) i11));
        return buffer;
    }

    public static final Buffer commonWriteHexadecimalUnsignedLong(Buffer buffer, long j10) {
        m.f(buffer, "$this$commonWriteHexadecimalUnsignedLong");
        if (j10 == 0) {
            return buffer.writeByte(48);
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
        Segment writableSegment$okio = buffer.writableSegment$okio(i10);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = getHEX_DIGIT_BYTES()[(int) (15 & j10)];
            j10 >>>= 4;
        }
        writableSegment$okio.limit += i10;
        buffer.setSize$okio(buffer.size() + ((long) i10));
        return buffer;
    }

    public static final Buffer commonWriteInt(Buffer buffer, int i10) {
        m.f(buffer, "$this$commonWriteInt");
        Segment writableSegment$okio = buffer.writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & 255);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 3] = (byte) (i10 & 255);
        writableSegment$okio.limit = i11 + 4;
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    public static final Buffer commonWriteLong(Buffer buffer, long j10) {
        m.f(buffer, "$this$commonWriteLong");
        Segment writableSegment$okio = buffer.writableSegment$okio(8);
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
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    public static final Buffer commonWriteShort(Buffer buffer, int i10) {
        m.f(buffer, "$this$commonWriteShort");
        Segment writableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 1] = (byte) (i10 & 255);
        writableSegment$okio.limit = i11 + 2;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    public static final Buffer commonWriteUtf8(Buffer buffer, String str, int i10, int i11) {
        boolean z10;
        boolean z11;
        boolean z12;
        char c10;
        m.f(buffer, "$this$commonWriteUtf8");
        m.f(str, "string");
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i11 >= i10) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (i11 <= str.length()) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    while (i10 < i11) {
                        char charAt = str.charAt(i10);
                        if (charAt < 128) {
                            Segment writableSegment$okio = buffer.writableSegment$okio(1);
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
                            buffer.setSize$okio(buffer.size() + ((long) i15));
                            i10 = i13;
                        } else {
                            if (charAt < 2048) {
                                Segment writableSegment$okio2 = buffer.writableSegment$okio(2);
                                byte[] bArr2 = writableSegment$okio2.data;
                                int i16 = writableSegment$okio2.limit;
                                bArr2[i16] = (byte) ((charAt >> 6) | 192);
                                bArr2[i16 + 1] = (byte) ((charAt & '?') | 128);
                                writableSegment$okio2.limit = i16 + 2;
                                buffer.setSize$okio(buffer.size() + 2);
                            } else if (charAt < 55296 || charAt > 57343) {
                                Segment writableSegment$okio3 = buffer.writableSegment$okio(3);
                                byte[] bArr3 = writableSegment$okio3.data;
                                int i17 = writableSegment$okio3.limit;
                                bArr3[i17] = (byte) ((charAt >> 12) | 224);
                                bArr3[i17 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                                bArr3[i17 + 2] = (byte) ((charAt & '?') | 128);
                                writableSegment$okio3.limit = i17 + 3;
                                buffer.setSize$okio(buffer.size() + 3);
                            } else {
                                int i18 = i10 + 1;
                                if (i18 < i11) {
                                    c10 = str.charAt(i18);
                                } else {
                                    c10 = 0;
                                }
                                if (charAt > 56319 || 56320 > c10 || 57343 < c10) {
                                    buffer.writeByte(63);
                                    i10 = i18;
                                } else {
                                    int i19 = (((charAt & 1023) << 10) | (c10 & 1023)) + 0;
                                    Segment writableSegment$okio4 = buffer.writableSegment$okio(4);
                                    byte[] bArr4 = writableSegment$okio4.data;
                                    int i20 = writableSegment$okio4.limit;
                                    bArr4[i20] = (byte) ((i19 >> 18) | 240);
                                    bArr4[i20 + 1] = (byte) (((i19 >> 12) & 63) | 128);
                                    bArr4[i20 + 2] = (byte) (((i19 >> 6) & 63) | 128);
                                    bArr4[i20 + 3] = (byte) ((i19 & 63) | 128);
                                    writableSegment$okio4.limit = i20 + 4;
                                    buffer.setSize$okio(buffer.size() + 4);
                                    i10 += 2;
                                }
                            }
                            i10++;
                        }
                    }
                    return buffer;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
    }

    public static final Buffer commonWriteUtf8CodePoint(Buffer buffer, int i10) {
        m.f(buffer, "$this$commonWriteUtf8CodePoint");
        if (i10 < 128) {
            buffer.writeByte(i10);
        } else if (i10 < 2048) {
            Segment writableSegment$okio = buffer.writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i11 = writableSegment$okio.limit;
            bArr[i11] = (byte) ((i10 >> 6) | 192);
            bArr[i11 + 1] = (byte) ((i10 & 63) | 128);
            writableSegment$okio.limit = i11 + 2;
            buffer.setSize$okio(buffer.size() + 2);
        } else if (55296 <= i10 && 57343 >= i10) {
            buffer.writeByte(63);
        } else if (i10 < 65536) {
            Segment writableSegment$okio2 = buffer.writableSegment$okio(3);
            byte[] bArr2 = writableSegment$okio2.data;
            int i12 = writableSegment$okio2.limit;
            bArr2[i12] = (byte) ((i10 >> 12) | 224);
            bArr2[i12 + 1] = (byte) (((i10 >> 6) & 63) | 128);
            bArr2[i12 + 2] = (byte) ((i10 & 63) | 128);
            writableSegment$okio2.limit = i12 + 3;
            buffer.setSize$okio(buffer.size() + 3);
        } else if (i10 <= 1114111) {
            Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
            byte[] bArr3 = writableSegment$okio3.data;
            int i13 = writableSegment$okio3.limit;
            bArr3[i13] = (byte) ((i10 >> 18) | 240);
            bArr3[i13 + 1] = (byte) (((i10 >> 12) & 63) | 128);
            bArr3[i13 + 2] = (byte) (((i10 >> 6) & 63) | 128);
            bArr3[i13 + 3] = (byte) ((i10 & 63) | 128);
            writableSegment$okio3.limit = i13 + 4;
            buffer.setSize$okio(buffer.size() + 4);
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(i10));
        }
        return buffer;
    }

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(Segment segment, int i10, byte[] bArr, int i11, int i12) {
        m.f(segment, "segment");
        m.f(bArr, "bytes");
        int i13 = segment.limit;
        byte[] bArr2 = segment.data;
        while (i11 < i12) {
            if (i10 == i13) {
                segment = segment.next;
                m.c(segment);
                byte[] bArr3 = segment.data;
                int i14 = segment.pos;
                bArr2 = bArr3;
                i10 = i14;
                i13 = segment.limit;
            }
            if (bArr2[i10] != bArr[i11]) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public static final String readUtf8Line(Buffer buffer, long j10) {
        m.f(buffer, "$this$readUtf8Line");
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (buffer.getByte(j11) == ((byte) 13)) {
                String readUtf8 = buffer.readUtf8(j11);
                buffer.skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = buffer.readUtf8(j10);
        buffer.skip(1);
        return readUtf82;
    }

    public static final <T> T seek(Buffer buffer, long j10, Function2<? super Segment, ? super Long, ? extends T> function2) {
        m.f(buffer, "$this$seek");
        m.f(function2, "lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return function2.invoke((Object) null, -1L);
        }
        if (buffer.size() - j10 < j10) {
            long size = buffer.size();
            while (size > j10) {
                segment = segment.prev;
                m.c(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            return function2.invoke(segment, Long.valueOf(size));
        }
        long j11 = 0;
        while (true) {
            long j12 = ((long) (segment.limit - segment.pos)) + j11;
            if (j12 > j10) {
                return function2.invoke(segment, Long.valueOf(j11));
            }
            segment = segment.next;
            m.c(segment);
            j11 = j12;
        }
    }

    public static final int selectPrefix(Buffer buffer, Options options, boolean z10) {
        int i10;
        int i11;
        boolean z11;
        int i12;
        Segment segment;
        int i13;
        Buffer buffer2 = buffer;
        m.f(buffer2, "$this$selectPrefix");
        m.f(options, "options");
        Segment segment2 = buffer2.head;
        if (segment2 != null) {
            byte[] bArr = segment2.data;
            int i14 = segment2.pos;
            int i15 = segment2.limit;
            int[] trie$okio = options.getTrie$okio();
            Segment segment3 = segment2;
            int i16 = -1;
            int i17 = 0;
            loop0:
            while (true) {
                int i18 = i17 + 1;
                int i19 = trie$okio[i17];
                int i20 = i17 + 2;
                int i21 = trie$okio[i18];
                if (i21 != -1) {
                    i16 = i21;
                }
                if (segment3 == null) {
                    break;
                }
                if (i19 < 0) {
                    int i22 = i20 + (i19 * -1);
                    while (true) {
                        int i23 = i14 + 1;
                        int i24 = i20 + 1;
                        if ((bArr[i14] & 255) != trie$okio[i20]) {
                            return i16;
                        }
                        if (i24 == i22) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (i23 == i15) {
                            m.c(segment3);
                            Segment segment4 = segment3.next;
                            m.c(segment4);
                            i13 = segment4.pos;
                            byte[] bArr2 = segment4.data;
                            i12 = segment4.limit;
                            if (segment4 != segment2) {
                                byte[] bArr3 = bArr2;
                                segment = segment4;
                                bArr = bArr3;
                            } else if (!z11) {
                                break loop0;
                            } else {
                                bArr = bArr2;
                                segment = null;
                            }
                        } else {
                            segment = segment3;
                            i12 = i15;
                            i13 = i23;
                        }
                        if (z11) {
                            i11 = trie$okio[i24];
                            i10 = i13;
                            i15 = i12;
                            segment3 = segment;
                            break;
                        }
                        i14 = i13;
                        i15 = i12;
                        segment3 = segment;
                        i20 = i24;
                    }
                } else {
                    i10 = i14 + 1;
                    byte b10 = bArr[i14] & 255;
                    int i25 = i20 + i19;
                    while (i20 != i25) {
                        if (b10 == trie$okio[i20]) {
                            i11 = trie$okio[i20 + i19];
                            if (i10 == i15) {
                                segment3 = segment3.next;
                                m.c(segment3);
                                i10 = segment3.pos;
                                bArr = segment3.data;
                                i15 = segment3.limit;
                                if (segment3 == segment2) {
                                    segment3 = null;
                                }
                            }
                        } else {
                            i20++;
                        }
                    }
                    return i16;
                }
                if (i11 >= 0) {
                    return i11;
                }
                i17 = -i11;
                i14 = i10;
            }
            if (z10) {
                return -2;
            }
            return i16;
        } else if (z10) {
            return -2;
        } else {
            return -1;
        }
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return selectPrefix(buffer, options, z10);
    }

    public static final int commonRead(Buffer buffer, byte[] bArr, int i10, int i11) {
        m.f(buffer, "$this$commonRead");
        m.f(bArr, "sink");
        Util.checkOffsetAndCount((long) bArr.length, (long) i10, (long) i11);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i11, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i12 = segment.pos;
        j.d(bArr2, bArr, i10, i12, i12 + min);
        segment.pos += min;
        buffer.setSize$okio(buffer.size() - ((long) min));
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public static final byte[] commonReadByteArray(Buffer buffer, long j10) {
        m.f(buffer, "$this$commonReadByteArray");
        if (!(j10 >= 0 && j10 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        } else if (buffer.size() >= j10) {
            byte[] bArr = new byte[((int) j10)];
            buffer.readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    public static final ByteString commonReadByteString(Buffer buffer, long j10) {
        m.f(buffer, "$this$commonReadByteString");
        if (!(j10 >= 0 && j10 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        } else if (buffer.size() < j10) {
            throw new EOFException();
        } else if (j10 < ((long) 4096)) {
            return new ByteString(buffer.readByteArray(j10));
        } else {
            ByteString snapshot = buffer.snapshot((int) j10);
            buffer.skip(j10);
            return snapshot;
        }
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] bArr) {
        m.f(buffer, "$this$commonWrite");
        m.f(bArr, "source");
        return buffer.write(bArr, 0, bArr.length);
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] bArr, int i10, int i11) {
        m.f(buffer, "$this$commonWrite");
        m.f(bArr, "source");
        long j10 = (long) i11;
        Util.checkOffsetAndCount((long) bArr.length, (long) i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int min = Math.min(i12 - i10, 8192 - writableSegment$okio.limit);
            int i13 = i10 + min;
            j.d(bArr, writableSegment$okio.data, writableSegment$okio.limit, i10, i13);
            writableSegment$okio.limit += min;
            i10 = i13;
        }
        buffer.setSize$okio(buffer.size() + j10);
        return buffer;
    }

    public static final void commonReadFully(Buffer buffer, Buffer buffer2, long j10) {
        m.f(buffer, "$this$commonReadFully");
        m.f(buffer2, "sink");
        if (buffer.size() >= j10) {
            buffer2.write(buffer, j10);
        } else {
            buffer2.write(buffer, buffer.size());
            throw new EOFException();
        }
    }

    public static final ByteString commonSnapshot(Buffer buffer, int i10) {
        m.f(buffer, "$this$commonSnapshot");
        if (i10 == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(buffer.size(), 0, (long) i10);
        Segment segment = buffer.head;
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
        Segment segment2 = buffer.head;
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

    public static final Buffer commonWrite(Buffer buffer, Source source, long j10) {
        m.f(buffer, "$this$commonWrite");
        m.f(source, "source");
        while (j10 > 0) {
            long read = source.read(buffer, j10);
            if (read != -1) {
                j10 -= read;
            } else {
                throw new EOFException();
            }
        }
        return buffer;
    }

    public static final long commonRead(Buffer buffer, Buffer buffer2, long j10) {
        m.f(buffer, "$this$commonRead");
        m.f(buffer2, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (buffer.size() == 0) {
            return -1;
        } else {
            if (j10 > buffer.size()) {
                j10 = buffer.size();
            }
            buffer2.write(buffer, j10);
            return j10;
        }
    }

    public static final void commonWrite(Buffer buffer, Buffer buffer2, long j10) {
        Segment segment;
        m.f(buffer, "$this$commonWrite");
        m.f(buffer2, "source");
        if (buffer2 != buffer) {
            Util.checkOffsetAndCount(buffer2.size(), 0, j10);
            while (j10 > 0) {
                Segment segment2 = buffer2.head;
                m.c(segment2);
                int i10 = segment2.limit;
                Segment segment3 = buffer2.head;
                m.c(segment3);
                if (j10 < ((long) (i10 - segment3.pos))) {
                    Segment segment4 = buffer.head;
                    if (segment4 != null) {
                        m.c(segment4);
                        segment = segment4.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((((long) segment.limit) + j10) - ((long) (segment.shared ? 0 : segment.pos)) <= ((long) 8192)) {
                            Segment segment5 = buffer2.head;
                            m.c(segment5);
                            segment5.writeTo(segment, (int) j10);
                            buffer2.setSize$okio(buffer2.size() - j10);
                            buffer.setSize$okio(buffer.size() + j10);
                            return;
                        }
                    }
                    Segment segment6 = buffer2.head;
                    m.c(segment6);
                    buffer2.head = segment6.split((int) j10);
                }
                Segment segment7 = buffer2.head;
                m.c(segment7);
                long j11 = (long) (segment7.limit - segment7.pos);
                buffer2.head = segment7.pop();
                Segment segment8 = buffer.head;
                if (segment8 == null) {
                    buffer.head = segment7;
                    segment7.prev = segment7;
                    segment7.next = segment7;
                } else {
                    m.c(segment8);
                    Segment segment9 = segment8.prev;
                    m.c(segment9);
                    segment9.push(segment7).compact();
                }
                buffer2.setSize$okio(buffer2.size() - j11);
                buffer.setSize$okio(buffer.size() + j11);
                j10 -= j11;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public static final long commonIndexOf(Buffer buffer, ByteString byteString, long j10) {
        Buffer buffer2 = buffer;
        long j11 = j10;
        m.f(buffer2, "$this$commonIndexOf");
        m.f(byteString, "bytes");
        boolean z10 = true;
        if (byteString.size() > 0) {
            long j12 = 0;
            if (j11 >= 0) {
                Segment segment = buffer2.head;
                if (segment == null) {
                    return -1;
                }
                if (buffer.size() - j11 < j11) {
                    long size = buffer.size();
                    while (size > j11) {
                        segment = segment.prev;
                        m.c(segment);
                        size -= (long) (segment.limit - segment.pos);
                    }
                    byte[] internalArray$okio = byteString.internalArray$okio();
                    byte b10 = internalArray$okio[0];
                    int size2 = byteString.size();
                    long size3 = (buffer.size() - ((long) size2)) + 1;
                    while (size < size3) {
                        byte[] bArr = segment.data;
                        int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + size3) - size);
                        for (int i10 = (int) ((((long) segment.pos) + j11) - size); i10 < min; i10++) {
                            if (bArr[i10] == b10 && rangeEquals(segment, i10 + 1, internalArray$okio, 1, size2)) {
                                return ((long) (i10 - segment.pos)) + size;
                            }
                        }
                        size += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        m.c(segment);
                        j11 = size;
                    }
                    return -1;
                }
                while (true) {
                    long j13 = ((long) (segment.limit - segment.pos)) + j12;
                    if (j13 > j11) {
                        break;
                    }
                    segment = segment.next;
                    m.c(segment);
                    j12 = j13;
                    z10 = z10;
                }
                byte[] internalArray$okio2 = byteString.internalArray$okio();
                byte b11 = internalArray$okio2[0];
                int size4 = byteString.size();
                long size5 = (buffer.size() - ((long) size4)) + 1;
                while (j12 < size5) {
                    byte[] bArr2 = segment.data;
                    long j14 = j12;
                    int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + size5) - j12);
                    long j15 = ((long) segment.pos) + j11;
                    long j16 = j14;
                    for (int i11 = (int) (j15 - j16); i11 < min2; i11++) {
                        if (bArr2[i11] == b11) {
                            if (rangeEquals(segment, i11 + 1, internalArray$okio2, 1, size4)) {
                                return ((long) (i11 - segment.pos)) + j16;
                            }
                        }
                    }
                    j12 = j16 + ((long) (segment.limit - segment.pos));
                    segment = segment.next;
                    m.c(segment);
                    j11 = j12;
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex < 0: " + j11).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }
}
