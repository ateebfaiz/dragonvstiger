package okio;

import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.internal.m;

public final class RealBufferedSink implements BufferedSink {
    public final Buffer bufferField = new Buffer();
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink2) {
        m.f(sink2, "sink");
        this.sink = sink2;
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    public Buffer buffer() {
        return this.bufferField;
    }

    public void close() {
        if (!this.closed) {
            try {
                if (this.bufferField.size() > 0) {
                    Sink sink2 = this.sink;
                    Buffer buffer = this.bufferField;
                    sink2.write(buffer, buffer.size());
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.sink.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.closed = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public BufferedSink emit() {
        if (!this.closed) {
            long size = this.bufferField.size();
            if (size > 0) {
                this.sink.write(this.bufferField, size);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink emitCompleteSegments() {
        if (!this.closed) {
            long completeSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                this.sink.write(this.bufferField, completeSegmentByteCount);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public void flush() {
        if (!this.closed) {
            if (this.bufferField.size() > 0) {
                Sink sink2 = this.sink;
                Buffer buffer = this.bufferField;
                sink2.write(buffer, buffer.size());
            }
            this.sink.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public Buffer getBuffer() {
        return this.bufferField;
    }

    public boolean isOpen() {
        return !this.closed;
    }

    public OutputStream outputStream() {
        return new RealBufferedSink$outputStream$1(this);
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    public int write(ByteBuffer byteBuffer) {
        m.f(byteBuffer, "source");
        if (!this.closed) {
            int write = this.bufferField.write(byteBuffer);
            emitCompleteSegments();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    public long writeAll(Source source) {
        m.f(source, "source");
        long j10 = 0;
        while (true) {
            long read = source.read(this.bufferField, (long) 8192);
            if (read == -1) {
                return j10;
            }
            j10 += read;
            emitCompleteSegments();
        }
    }

    public BufferedSink writeByte(int i10) {
        if (!this.closed) {
            this.bufferField.writeByte(i10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeDecimalLong(long j10) {
        if (!this.closed) {
            this.bufferField.writeDecimalLong(j10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeHexadecimalUnsignedLong(long j10) {
        if (!this.closed) {
            this.bufferField.writeHexadecimalUnsignedLong(j10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeInt(int i10) {
        if (!this.closed) {
            this.bufferField.writeInt(i10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeIntLe(int i10) {
        if (!this.closed) {
            this.bufferField.writeIntLe(i10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeLong(long j10) {
        if (!this.closed) {
            this.bufferField.writeLong(j10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeLongLe(long j10) {
        if (!this.closed) {
            this.bufferField.writeLongLe(j10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeShort(int i10) {
        if (!this.closed) {
            this.bufferField.writeShort(i10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeShortLe(int i10) {
        if (!this.closed) {
            this.bufferField.writeShortLe(i10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeString(String str, Charset charset) {
        m.f(str, "string");
        m.f(charset, "charset");
        if (!this.closed) {
            this.bufferField.writeString(str, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeUtf8(String str) {
        m.f(str, "string");
        if (!this.closed) {
            this.bufferField.writeUtf8(str);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeUtf8CodePoint(int i10) {
        if (!this.closed) {
            this.bufferField.writeUtf8CodePoint(i10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public void write(Buffer buffer, long j10) {
        m.f(buffer, "source");
        if (!this.closed) {
            this.bufferField.write(buffer, j10);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeString(String str, int i10, int i11, Charset charset) {
        m.f(str, "string");
        m.f(charset, "charset");
        if (!this.closed) {
            this.bufferField.writeString(str, i10, i11, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeUtf8(String str, int i10, int i11) {
        m.f(str, "string");
        if (!this.closed) {
            this.bufferField.writeUtf8(str, i10, i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink write(ByteString byteString) {
        m.f(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink write(ByteString byteString, int i10, int i11) {
        m.f(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString, i10, i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink write(byte[] bArr) {
        m.f(bArr, "source");
        if (!this.closed) {
            this.bufferField.write(bArr);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink write(byte[] bArr, int i10, int i11) {
        m.f(bArr, "source");
        if (!this.closed) {
            this.bufferField.write(bArr, i10, i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink write(Source source, long j10) {
        m.f(source, "source");
        while (j10 > 0) {
            long read = source.read(this.bufferField, j10);
            if (read != -1) {
                j10 -= read;
                emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }
}
