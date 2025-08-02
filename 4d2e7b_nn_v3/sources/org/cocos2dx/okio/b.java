package org.cocos2dx.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class b implements BufferedSink {

    /* renamed from: a  reason: collision with root package name */
    public final Buffer f1781a = new Buffer();

    /* renamed from: b  reason: collision with root package name */
    public final Sink f1782b;

    /* renamed from: c  reason: collision with root package name */
    boolean f1783c;

    b(Sink sink) {
        if (sink != null) {
            this.f1782b = sink;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    public Buffer buffer() {
        return this.f1781a;
    }

    public void close() {
        if (!this.f1783c) {
            try {
                Buffer buffer = this.f1781a;
                long j10 = buffer.size;
                if (j10 > 0) {
                    this.f1782b.write(buffer, j10);
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f1782b.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.f1783c = true;
            if (th != null) {
                g.f(th);
            }
        }
    }

    public BufferedSink emit() {
        if (!this.f1783c) {
            long size = this.f1781a.size();
            if (size > 0) {
                this.f1782b.write(this.f1781a, size);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink emitCompleteSegments() {
        if (!this.f1783c) {
            long completeSegmentByteCount = this.f1781a.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                this.f1782b.write(this.f1781a, completeSegmentByteCount);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void flush() {
        if (!this.f1783c) {
            Buffer buffer = this.f1781a;
            long j10 = buffer.size;
            if (j10 > 0) {
                this.f1782b.write(buffer, j10);
            }
            this.f1782b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.f1783c;
    }

    public OutputStream outputStream() {
        return new a();
    }

    public Timeout timeout() {
        return this.f1782b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f1782b + ")";
    }

    public void write(Buffer buffer, long j10) {
        if (!this.f1783c) {
            this.f1781a.write(buffer, j10);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public long writeAll(Source source) {
        if (source != null) {
            long j10 = 0;
            while (true) {
                long read = source.read(this.f1781a, 8192);
                if (read == -1) {
                    return j10;
                }
                j10 += read;
                emitCompleteSegments();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public BufferedSink writeByte(int i10) {
        if (!this.f1783c) {
            this.f1781a.writeByte(i10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeDecimalLong(long j10) {
        if (!this.f1783c) {
            this.f1781a.writeDecimalLong(j10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeHexadecimalUnsignedLong(long j10) {
        if (!this.f1783c) {
            this.f1781a.writeHexadecimalUnsignedLong(j10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeInt(int i10) {
        if (!this.f1783c) {
            this.f1781a.writeInt(i10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeIntLe(int i10) {
        if (!this.f1783c) {
            this.f1781a.writeIntLe(i10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeLong(long j10) {
        if (!this.f1783c) {
            this.f1781a.writeLong(j10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeLongLe(long j10) {
        if (!this.f1783c) {
            this.f1781a.writeLongLe(j10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeShort(int i10) {
        if (!this.f1783c) {
            this.f1781a.writeShort(i10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeShortLe(int i10) {
        if (!this.f1783c) {
            this.f1781a.writeShortLe(i10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeString(String str, Charset charset) {
        if (!this.f1783c) {
            this.f1781a.writeString(str, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeUtf8(String str) {
        if (!this.f1783c) {
            this.f1781a.writeUtf8(str);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeUtf8CodePoint(int i10) {
        if (!this.f1783c) {
            this.f1781a.writeUtf8CodePoint(i10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    class a extends OutputStream {
        a() {
        }

        public void close() {
            b.this.close();
        }

        public void flush() {
            b bVar = b.this;
            if (!bVar.f1783c) {
                bVar.flush();
            }
        }

        public String toString() {
            return b.this + ".outputStream()";
        }

        public void write(int i10) {
            b bVar = b.this;
            if (!bVar.f1783c) {
                bVar.f1781a.writeByte((int) (byte) i10);
                b.this.emitCompleteSegments();
                return;
            }
            throw new IOException("closed");
        }

        public void write(byte[] bArr, int i10, int i11) {
            b bVar = b.this;
            if (!bVar.f1783c) {
                bVar.f1781a.write(bArr, i10, i11);
                b.this.emitCompleteSegments();
                return;
            }
            throw new IOException("closed");
        }
    }

    public BufferedSink write(ByteString byteString) {
        if (!this.f1783c) {
            this.f1781a.write(byteString);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeString(String str, int i10, int i11, Charset charset) {
        if (!this.f1783c) {
            this.f1781a.writeString(str, i10, i11, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeUtf8(String str, int i10, int i11) {
        if (!this.f1783c) {
            this.f1781a.writeUtf8(str, i10, i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink write(byte[] bArr) {
        if (!this.f1783c) {
            this.f1781a.write(bArr);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink write(byte[] bArr, int i10, int i11) {
        if (!this.f1783c) {
            this.f1781a.write(bArr, i10, i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public int write(ByteBuffer byteBuffer) {
        if (!this.f1783c) {
            int write = this.f1781a.write(byteBuffer);
            emitCompleteSegments();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink write(Source source, long j10) {
        while (j10 > 0) {
            long read = source.read(this.f1781a, j10);
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
