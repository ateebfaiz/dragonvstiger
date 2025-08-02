package okio.internal;

import java.io.EOFException;
import kotlin.jvm.internal.m;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class RealBufferedSinkKt {
    public static final void commonClose(RealBufferedSink realBufferedSink) {
        m.f(realBufferedSink, "$this$commonClose");
        if (!realBufferedSink.closed) {
            try {
                if (realBufferedSink.bufferField.size() > 0) {
                    Sink sink = realBufferedSink.sink;
                    Buffer buffer = realBufferedSink.bufferField;
                    sink.write(buffer, buffer.size());
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                realBufferedSink.sink.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            realBufferedSink.closed = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public static final BufferedSink commonEmit(RealBufferedSink realBufferedSink) {
        m.f(realBufferedSink, "$this$commonEmit");
        if (!realBufferedSink.closed) {
            long size = realBufferedSink.bufferField.size();
            if (size > 0) {
                realBufferedSink.sink.write(realBufferedSink.bufferField, size);
            }
            return realBufferedSink;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonEmitCompleteSegments(RealBufferedSink realBufferedSink) {
        m.f(realBufferedSink, "$this$commonEmitCompleteSegments");
        if (!realBufferedSink.closed) {
            long completeSegmentByteCount = realBufferedSink.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                realBufferedSink.sink.write(realBufferedSink.bufferField, completeSegmentByteCount);
            }
            return realBufferedSink;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonFlush(RealBufferedSink realBufferedSink) {
        m.f(realBufferedSink, "$this$commonFlush");
        if (!realBufferedSink.closed) {
            if (realBufferedSink.bufferField.size() > 0) {
                Sink sink = realBufferedSink.sink;
                Buffer buffer = realBufferedSink.bufferField;
                sink.write(buffer, buffer.size());
            }
            realBufferedSink.sink.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final Timeout commonTimeout(RealBufferedSink realBufferedSink) {
        m.f(realBufferedSink, "$this$commonTimeout");
        return realBufferedSink.sink.timeout();
    }

    public static final String commonToString(RealBufferedSink realBufferedSink) {
        m.f(realBufferedSink, "$this$commonToString");
        return "buffer(" + realBufferedSink.sink + ')';
    }

    public static final void commonWrite(RealBufferedSink realBufferedSink, Buffer buffer, long j10) {
        m.f(realBufferedSink, "$this$commonWrite");
        m.f(buffer, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(buffer, j10);
            realBufferedSink.emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonWriteAll(RealBufferedSink realBufferedSink, Source source) {
        m.f(realBufferedSink, "$this$commonWriteAll");
        m.f(source, "source");
        long j10 = 0;
        while (true) {
            long read = source.read(realBufferedSink.bufferField, (long) 8192);
            if (read == -1) {
                return j10;
            }
            j10 += read;
            realBufferedSink.emitCompleteSegments();
        }
    }

    public static final BufferedSink commonWriteByte(RealBufferedSink realBufferedSink, int i10) {
        m.f(realBufferedSink, "$this$commonWriteByte");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeByte(i10);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteDecimalLong(RealBufferedSink realBufferedSink, long j10) {
        m.f(realBufferedSink, "$this$commonWriteDecimalLong");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeDecimalLong(j10);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteHexadecimalUnsignedLong(RealBufferedSink realBufferedSink, long j10) {
        m.f(realBufferedSink, "$this$commonWriteHexadecimalUnsignedLong");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeHexadecimalUnsignedLong(j10);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteInt(RealBufferedSink realBufferedSink, int i10) {
        m.f(realBufferedSink, "$this$commonWriteInt");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeInt(i10);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteIntLe(RealBufferedSink realBufferedSink, int i10) {
        m.f(realBufferedSink, "$this$commonWriteIntLe");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeIntLe(i10);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteLong(RealBufferedSink realBufferedSink, long j10) {
        m.f(realBufferedSink, "$this$commonWriteLong");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeLong(j10);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteLongLe(RealBufferedSink realBufferedSink, long j10) {
        m.f(realBufferedSink, "$this$commonWriteLongLe");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeLongLe(j10);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteShort(RealBufferedSink realBufferedSink, int i10) {
        m.f(realBufferedSink, "$this$commonWriteShort");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeShort(i10);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteShortLe(RealBufferedSink realBufferedSink, int i10) {
        m.f(realBufferedSink, "$this$commonWriteShortLe");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeShortLe(i10);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8(RealBufferedSink realBufferedSink, String str) {
        m.f(realBufferedSink, "$this$commonWriteUtf8");
        m.f(str, "string");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8(str);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8CodePoint(RealBufferedSink realBufferedSink, int i10) {
        m.f(realBufferedSink, "$this$commonWriteUtf8CodePoint");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8CodePoint(i10);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, ByteString byteString) {
        m.f(realBufferedSink, "$this$commonWrite");
        m.f(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8(RealBufferedSink realBufferedSink, String str, int i10, int i11) {
        m.f(realBufferedSink, "$this$commonWriteUtf8");
        m.f(str, "string");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8(str, i10, i11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, ByteString byteString, int i10, int i11) {
        m.f(realBufferedSink, "$this$commonWrite");
        m.f(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString, i10, i11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, byte[] bArr) {
        m.f(realBufferedSink, "$this$commonWrite");
        m.f(bArr, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, byte[] bArr, int i10, int i11) {
        m.f(realBufferedSink, "$this$commonWrite");
        m.f(bArr, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr, i10, i11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, Source source, long j10) {
        m.f(realBufferedSink, "$this$commonWrite");
        m.f(source, "source");
        while (j10 > 0) {
            long read = source.read(realBufferedSink.bufferField, j10);
            if (read != -1) {
                j10 -= read;
                realBufferedSink.emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return realBufferedSink;
    }
}
