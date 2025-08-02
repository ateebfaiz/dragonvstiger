package okio.internal;

import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import kotlin.jvm.internal.m;
import kotlin.text.a;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import okio.Util;

public final class RealBufferedSourceKt {
    public static final void commonClose(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonClose");
        if (!realBufferedSource.closed) {
            realBufferedSource.closed = true;
            realBufferedSource.source.close();
            realBufferedSource.bufferField.clear();
        }
    }

    public static final boolean commonExhausted(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonExhausted");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (!realBufferedSource.bufferField.exhausted() || realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) != -1) {
            return false;
        } else {
            return true;
        }
    }

    public static final long commonIndexOf(RealBufferedSource realBufferedSource, byte b10, long j10, long j11) {
        m.f(realBufferedSource, "$this$commonIndexOf");
        boolean z10 = true;
        if (!realBufferedSource.closed) {
            if (0 > j10 || j11 < j10) {
                z10 = false;
            }
            if (z10) {
                while (j10 < j11) {
                    long indexOf = realBufferedSource.bufferField.indexOf(b10, j10, j11);
                    if (indexOf == -1) {
                        long size = realBufferedSource.bufferField.size();
                        if (size >= j11 || realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
                            break;
                        }
                        j10 = Math.max(j10, size);
                    } else {
                        return indexOf;
                    }
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOfElement(RealBufferedSource realBufferedSource, ByteString byteString, long j10) {
        m.f(realBufferedSource, "$this$commonIndexOfElement");
        m.f(byteString, "targetBytes");
        if (!realBufferedSource.closed) {
            while (true) {
                long indexOfElement = realBufferedSource.bufferField.indexOfElement(byteString, j10);
                if (indexOfElement != -1) {
                    return indexOfElement;
                }
                long size = realBufferedSource.bufferField.size();
                if (realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
                    return -1;
                }
                j10 = Math.max(j10, size);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public static final BufferedSource commonPeek(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonPeek");
        return Okio.buffer((Source) new PeekSource(realBufferedSource));
    }

    public static final boolean commonRangeEquals(RealBufferedSource realBufferedSource, long j10, ByteString byteString, int i10, int i11) {
        m.f(realBufferedSource, "$this$commonRangeEquals");
        m.f(byteString, "bytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (j10 < 0 || i10 < 0 || i11 < 0 || byteString.size() - i10 < i11) {
            return false;
        } else {
            for (int i12 = 0; i12 < i11; i12++) {
                long j11 = ((long) i12) + j10;
                if (!realBufferedSource.request(1 + j11) || realBufferedSource.bufferField.getByte(j11) != byteString.getByte(i10 + i12)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final long commonRead(RealBufferedSource realBufferedSource, Buffer buffer, long j10) {
        m.f(realBufferedSource, "$this$commonRead");
        m.f(buffer, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
            return -1;
        } else {
            return realBufferedSource.bufferField.read(buffer, Math.min(j10, realBufferedSource.bufferField.size()));
        }
    }

    public static final long commonReadAll(RealBufferedSource realBufferedSource, Sink sink) {
        m.f(realBufferedSource, "$this$commonReadAll");
        m.f(sink, "sink");
        long j10 = 0;
        while (realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) != -1) {
            long completeSegmentByteCount = realBufferedSource.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j10 += completeSegmentByteCount;
                sink.write(realBufferedSource.bufferField, completeSegmentByteCount);
            }
        }
        if (realBufferedSource.bufferField.size() <= 0) {
            return j10;
        }
        long size = j10 + realBufferedSource.bufferField.size();
        Buffer buffer = realBufferedSource.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    public static final byte commonReadByte(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonReadByte");
        realBufferedSource.require(1);
        return realBufferedSource.bufferField.readByte();
    }

    public static final byte[] commonReadByteArray(RealBufferedSource realBufferedSource, long j10) {
        m.f(realBufferedSource, "$this$commonReadByteArray");
        realBufferedSource.require(j10);
        return realBufferedSource.bufferField.readByteArray(j10);
    }

    public static final ByteString commonReadByteString(RealBufferedSource realBufferedSource, long j10) {
        m.f(realBufferedSource, "$this$commonReadByteString");
        realBufferedSource.require(j10);
        return realBufferedSource.bufferField.readByteString(j10);
    }

    public static final long commonReadDecimalLong(RealBufferedSource realBufferedSource) {
        int i10;
        m.f(realBufferedSource, "$this$commonReadDecimalLong");
        realBufferedSource.require(1);
        long j10 = 0;
        while (true) {
            long j11 = j10 + 1;
            if (!realBufferedSource.request(j11)) {
                break;
            }
            byte b10 = realBufferedSource.bufferField.getByte(j10);
            if ((b10 >= ((byte) 48) && b10 <= ((byte) 57)) || (j10 == 0 && b10 == ((byte) 45))) {
                j10 = j11;
            } else if (i10 == 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Expected leading [0-9] or '-' character but was 0x");
                String num = Integer.toString(b10, a.a(a.a(16)));
                m.e(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                sb2.append(num);
                throw new NumberFormatException(sb2.toString());
            }
        }
        return realBufferedSource.bufferField.readDecimalLong();
    }

    public static final void commonReadFully(RealBufferedSource realBufferedSource, byte[] bArr) {
        m.f(realBufferedSource, "$this$commonReadFully");
        m.f(bArr, "sink");
        try {
            realBufferedSource.require((long) bArr.length);
            realBufferedSource.bufferField.readFully(bArr);
        } catch (EOFException e10) {
            int i10 = 0;
            while (realBufferedSource.bufferField.size() > 0) {
                Buffer buffer = realBufferedSource.bufferField;
                int read = buffer.read(bArr, i10, (int) buffer.size());
                if (read != -1) {
                    i10 += read;
                } else {
                    throw new AssertionError();
                }
            }
            throw e10;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonReadHexadecimalUnsignedLong(okio.RealBufferedSource r5) {
        /*
            java.lang.String r0 = "$this$commonReadHexadecimalUnsignedLong"
            kotlin.jvm.internal.m.f(r5, r0)
            r0 = 1
            r5.require(r0)
            r0 = 0
        L_0x000b:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r5.request(r2)
            if (r2 == 0) goto L_0x0069
            okio.Buffer r2 = r5.bufferField
            long r3 = (long) r0
            byte r2 = r2.getByte(r3)
            r3 = 48
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x0025
            r3 = 57
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x003a
        L_0x0025:
            r3 = 97
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x002f
            r3 = 102(0x66, float:1.43E-43)
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x003a
        L_0x002f:
            r3 = 65
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x003c
            r3 = 70
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r0 = r1
            goto L_0x000b
        L_0x003c:
            if (r0 == 0) goto L_0x003f
            goto L_0x0069
        L_0x003f:
            java.lang.NumberFormatException r5 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            r1 = 16
            int r1 = kotlin.text.a.a(r1)
            int r1 = kotlin.text.a.a(r1)
            java.lang.String r1 = java.lang.Integer.toString(r2, r1)
            java.lang.String r2 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.m.e(r1, r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x0069:
            okio.Buffer r5 = r5.bufferField
            long r0 = r5.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.RealBufferedSourceKt.commonReadHexadecimalUnsignedLong(okio.RealBufferedSource):long");
    }

    public static final int commonReadInt(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonReadInt");
        realBufferedSource.require(4);
        return realBufferedSource.bufferField.readInt();
    }

    public static final int commonReadIntLe(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonReadIntLe");
        realBufferedSource.require(4);
        return realBufferedSource.bufferField.readIntLe();
    }

    public static final long commonReadLong(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonReadLong");
        realBufferedSource.require(8);
        return realBufferedSource.bufferField.readLong();
    }

    public static final long commonReadLongLe(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonReadLongLe");
        realBufferedSource.require(8);
        return realBufferedSource.bufferField.readLongLe();
    }

    public static final short commonReadShort(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonReadShort");
        realBufferedSource.require(2);
        return realBufferedSource.bufferField.readShort();
    }

    public static final short commonReadShortLe(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonReadShortLe");
        realBufferedSource.require(2);
        return realBufferedSource.bufferField.readShortLe();
    }

    public static final String commonReadUtf8(RealBufferedSource realBufferedSource, long j10) {
        m.f(realBufferedSource, "$this$commonReadUtf8");
        realBufferedSource.require(j10);
        return realBufferedSource.bufferField.readUtf8(j10);
    }

    public static final int commonReadUtf8CodePoint(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonReadUtf8CodePoint");
        realBufferedSource.require(1);
        byte b10 = realBufferedSource.bufferField.getByte(0);
        if ((b10 & 224) == 192) {
            realBufferedSource.require(2);
        } else if ((b10 & 240) == 224) {
            realBufferedSource.require(3);
        } else if ((b10 & 248) == 240) {
            realBufferedSource.require(4);
        }
        return realBufferedSource.bufferField.readUtf8CodePoint();
    }

    public static final String commonReadUtf8Line(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonReadUtf8Line");
        long indexOf = realBufferedSource.indexOf((byte) 10);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(realBufferedSource.bufferField, indexOf);
        }
        if (realBufferedSource.bufferField.size() != 0) {
            return realBufferedSource.readUtf8(realBufferedSource.bufferField.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(RealBufferedSource realBufferedSource, long j10) {
        boolean z10;
        long j11;
        m.f(realBufferedSource, "$this$commonReadUtf8LineStrict");
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (j10 == LocationRequestCompat.PASSIVE_INTERVAL) {
                j11 = Long.MAX_VALUE;
            } else {
                j11 = j10 + 1;
            }
            byte b10 = (byte) 10;
            long indexOf = realBufferedSource.indexOf(b10, 0, j11);
            if (indexOf != -1) {
                return BufferKt.readUtf8Line(realBufferedSource.bufferField, indexOf);
            }
            if (j11 < LocationRequestCompat.PASSIVE_INTERVAL && realBufferedSource.request(j11) && realBufferedSource.bufferField.getByte(j11 - 1) == ((byte) 13) && realBufferedSource.request(1 + j11) && realBufferedSource.bufferField.getByte(j11) == b10) {
                return BufferKt.readUtf8Line(realBufferedSource.bufferField, j11);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = realBufferedSource.bufferField;
            buffer2.copyTo(buffer, 0, Math.min((long) 32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(realBufferedSource.bufferField.size(), j10) + " content=" + buffer.readByteString().hex() + "…");
        }
        throw new IllegalArgumentException(("limit < 0: " + j10).toString());
    }

    public static final boolean commonRequest(RealBufferedSource realBufferedSource, long j10) {
        boolean z10;
        m.f(realBufferedSource, "$this$commonRequest");
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (!realBufferedSource.closed) {
            while (realBufferedSource.bufferField.size() < j10) {
                if (realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public static final void commonRequire(RealBufferedSource realBufferedSource, long j10) {
        m.f(realBufferedSource, "$this$commonRequire");
        if (!realBufferedSource.request(j10)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(RealBufferedSource realBufferedSource, Options options) {
        m.f(realBufferedSource, "$this$commonSelect");
        m.f(options, "options");
        if (!realBufferedSource.closed) {
            do {
                int selectPrefix = BufferKt.selectPrefix(realBufferedSource.bufferField, options, true);
                if (selectPrefix != -2) {
                    if (selectPrefix == -1) {
                        return -1;
                    }
                    realBufferedSource.bufferField.skip((long) options.getByteStrings$okio()[selectPrefix].size());
                    return selectPrefix;
                }
            } while (realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonSkip(RealBufferedSource realBufferedSource, long j10) {
        m.f(realBufferedSource, "$this$commonSkip");
        if (!realBufferedSource.closed) {
            while (j10 > 0) {
                if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j10, realBufferedSource.bufferField.size());
                realBufferedSource.bufferField.skip(min);
                j10 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final Timeout commonTimeout(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonTimeout");
        return realBufferedSource.source.timeout();
    }

    public static final String commonToString(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonToString");
        return "buffer(" + realBufferedSource.source + ')';
    }

    public static final byte[] commonReadByteArray(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonReadByteArray");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteArray();
    }

    public static final ByteString commonReadByteString(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonReadByteString");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteString();
    }

    public static final String commonReadUtf8(RealBufferedSource realBufferedSource) {
        m.f(realBufferedSource, "$this$commonReadUtf8");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readUtf8();
    }

    public static final void commonReadFully(RealBufferedSource realBufferedSource, Buffer buffer, long j10) {
        m.f(realBufferedSource, "$this$commonReadFully");
        m.f(buffer, "sink");
        try {
            realBufferedSource.require(j10);
            realBufferedSource.bufferField.readFully(buffer, j10);
        } catch (EOFException e10) {
            buffer.writeAll(realBufferedSource.bufferField);
            throw e10;
        }
    }

    public static final long commonIndexOf(RealBufferedSource realBufferedSource, ByteString byteString, long j10) {
        m.f(realBufferedSource, "$this$commonIndexOf");
        m.f(byteString, "bytes");
        if (!realBufferedSource.closed) {
            while (true) {
                long indexOf = realBufferedSource.bufferField.indexOf(byteString, j10);
                if (indexOf != -1) {
                    return indexOf;
                }
                long size = realBufferedSource.bufferField.size();
                if (realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
                    return -1;
                }
                j10 = Math.max(j10, (size - ((long) byteString.size())) + 1);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public static final int commonRead(RealBufferedSource realBufferedSource, byte[] bArr, int i10, int i11) {
        m.f(realBufferedSource, "$this$commonRead");
        m.f(bArr, "sink");
        long j10 = (long) i11;
        Util.checkOffsetAndCount((long) bArr.length, (long) i10, j10);
        if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
            return -1;
        }
        return realBufferedSource.bufferField.read(bArr, i10, (int) Math.min(j10, realBufferedSource.bufferField.size()));
    }
}
