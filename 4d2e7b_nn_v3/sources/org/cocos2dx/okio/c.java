package org.cocos2dx.okio;

import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class c implements BufferedSource {

    /* renamed from: a  reason: collision with root package name */
    public final Buffer f1785a = new Buffer();

    /* renamed from: b  reason: collision with root package name */
    public final Source f1786b;

    /* renamed from: c  reason: collision with root package name */
    boolean f1787c;

    c(Source source) {
        if (source != null) {
            this.f1786b = source;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public Buffer buffer() {
        return this.f1785a;
    }

    public void close() {
        if (!this.f1787c) {
            this.f1787c = true;
            this.f1786b.close();
            this.f1785a.clear();
        }
    }

    public boolean exhausted() {
        if (this.f1787c) {
            throw new IllegalStateException("closed");
        } else if (!this.f1785a.exhausted() || this.f1786b.read(this.f1785a, 8192) != -1) {
            return false;
        } else {
            return true;
        }
    }

    public long indexOf(byte b10) {
        return indexOf(b10, 0, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public InputStream inputStream() {
        return new a();
    }

    public boolean isOpen() {
        return !this.f1787c;
    }

    public boolean rangeEquals(long j10, ByteString byteString) {
        return rangeEquals(j10, byteString, 0, byteString.size());
    }

    public long read(Buffer buffer, long j10) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        } else if (!this.f1787c) {
            Buffer buffer2 = this.f1785a;
            if (buffer2.size == 0 && this.f1786b.read(buffer2, 8192) == -1) {
                return -1;
            }
            return this.f1785a.read(buffer, Math.min(j10, this.f1785a.size));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public long readAll(Sink sink) {
        if (sink != null) {
            long j10 = 0;
            while (this.f1786b.read(this.f1785a, 8192) != -1) {
                long completeSegmentByteCount = this.f1785a.completeSegmentByteCount();
                if (completeSegmentByteCount > 0) {
                    j10 += completeSegmentByteCount;
                    sink.write(this.f1785a, completeSegmentByteCount);
                }
            }
            if (this.f1785a.size() <= 0) {
                return j10;
            }
            long size = j10 + this.f1785a.size();
            Buffer buffer = this.f1785a;
            sink.write(buffer, buffer.size());
            return size;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public byte readByte() {
        require(1);
        return this.f1785a.readByte();
    }

    public byte[] readByteArray() {
        this.f1785a.writeAll(this.f1786b);
        return this.f1785a.readByteArray();
    }

    public ByteString readByteString() {
        this.f1785a.writeAll(this.f1786b);
        return this.f1785a.readByteString();
    }

    public long readDecimalLong() {
        require(1);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (!request((long) i11)) {
                break;
            }
            byte b10 = this.f1785a.getByte((long) i10);
            if ((b10 >= 48 && b10 <= 57) || (i10 == 0 && b10 == 45)) {
                i10 = i11;
            } else if (i10 == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[]{Byte.valueOf(b10)}));
            }
        }
        return this.f1785a.readDecimalLong();
    }

    public void readFully(byte[] bArr) {
        try {
            require((long) bArr.length);
            this.f1785a.readFully(bArr);
        } catch (EOFException e10) {
            int i10 = 0;
            while (true) {
                Buffer buffer = this.f1785a;
                long j10 = buffer.size;
                if (j10 > 0) {
                    int read = buffer.read(bArr, i10, (int) j10);
                    if (read != -1) {
                        i10 += read;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e10;
                }
            }
        }
    }

    public long readHexadecimalUnsignedLong() {
        require(1);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (!request((long) i11)) {
                break;
            }
            byte b10 = this.f1785a.getByte((long) i10);
            if ((b10 >= 48 && b10 <= 57) || ((b10 >= 97 && b10 <= 102) || (b10 >= 65 && b10 <= 70))) {
                i10 = i11;
            } else if (i10 == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b10)}));
            }
        }
        return this.f1785a.readHexadecimalUnsignedLong();
    }

    public int readInt() {
        require(4);
        return this.f1785a.readInt();
    }

    public int readIntLe() {
        require(4);
        return this.f1785a.readIntLe();
    }

    public long readLong() {
        require(8);
        return this.f1785a.readLong();
    }

    public long readLongLe() {
        require(8);
        return this.f1785a.readLongLe();
    }

    public short readShort() {
        require(2);
        return this.f1785a.readShort();
    }

    public short readShortLe() {
        require(2);
        return this.f1785a.readShortLe();
    }

    public String readString(Charset charset) {
        if (charset != null) {
            this.f1785a.writeAll(this.f1786b);
            return this.f1785a.readString(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public String readUtf8() {
        this.f1785a.writeAll(this.f1786b);
        return this.f1785a.readUtf8();
    }

    public int readUtf8CodePoint() {
        require(1);
        byte b10 = this.f1785a.getByte(0);
        if ((b10 & 224) == 192) {
            require(2);
        } else if ((b10 & 240) == 224) {
            require(3);
        } else if ((b10 & 248) == 240) {
            require(4);
        }
        return this.f1785a.readUtf8CodePoint();
    }

    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return this.f1785a.readUtf8Line(indexOf);
        }
        long j10 = this.f1785a.size;
        if (j10 != 0) {
            return readUtf8(j10);
        }
        return null;
    }

    public String readUtf8LineStrict() {
        return readUtf8LineStrict(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public boolean request(long j10) {
        Buffer buffer;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        } else if (!this.f1787c) {
            do {
                buffer = this.f1785a;
                if (buffer.size >= j10) {
                    return true;
                }
            } while (this.f1786b.read(buffer, 8192) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public void require(long j10) {
        if (!request(j10)) {
            throw new EOFException();
        }
    }

    public int select(Options options) {
        if (!this.f1787c) {
            do {
                int selectPrefix = this.f1785a.selectPrefix(options, true);
                if (selectPrefix == -1) {
                    return -1;
                }
                if (selectPrefix != -2) {
                    this.f1785a.skip((long) options.byteStrings[selectPrefix].size());
                    return selectPrefix;
                }
            } while (this.f1786b.read(this.f1785a, 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed");
    }

    public void skip(long j10) {
        if (!this.f1787c) {
            while (j10 > 0) {
                Buffer buffer = this.f1785a;
                if (buffer.size == 0 && this.f1786b.read(buffer, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j10, this.f1785a.size());
                this.f1785a.skip(min);
                j10 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public Timeout timeout() {
        return this.f1786b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f1786b + ")";
    }

    public long indexOf(byte b10, long j10) {
        return indexOf(b10, j10, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public long indexOfElement(ByteString byteString, long j10) {
        if (!this.f1787c) {
            while (true) {
                long indexOfElement = this.f1785a.indexOfElement(byteString, j10);
                if (indexOfElement != -1) {
                    return indexOfElement;
                }
                Buffer buffer = this.f1785a;
                long j11 = buffer.size;
                if (this.f1786b.read(buffer, 8192) == -1) {
                    return -1;
                }
                j10 = Math.max(j10, j11);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public boolean rangeEquals(long j10, ByteString byteString, int i10, int i11) {
        if (this.f1787c) {
            throw new IllegalStateException("closed");
        } else if (j10 < 0 || i10 < 0 || i11 < 0 || byteString.size() - i10 < i11) {
            return false;
        } else {
            for (int i12 = 0; i12 < i11; i12++) {
                long j11 = ((long) i12) + j10;
                if (!request(1 + j11) || this.f1785a.getByte(j11) != byteString.getByte(i10 + i12)) {
                    return false;
                }
            }
            return true;
        }
    }

    public String readUtf8LineStrict(long j10) {
        if (j10 >= 0) {
            long j11 = j10 == LocationRequestCompat.PASSIVE_INTERVAL ? Long.MAX_VALUE : j10 + 1;
            long indexOf = indexOf((byte) 10, 0, j11);
            if (indexOf != -1) {
                return this.f1785a.readUtf8Line(indexOf);
            }
            if (j11 < LocationRequestCompat.PASSIVE_INTERVAL && request(j11) && this.f1785a.getByte(j11 - 1) == 13 && request(1 + j11) && this.f1785a.getByte(j11) == 10) {
                return this.f1785a.readUtf8Line(j11);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.f1785a;
            buffer2.copyTo(buffer, 0, Math.min(32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f1785a.size(), j10) + " content=" + buffer.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j10);
    }

    public long indexOf(byte b10, long j10, long j11) {
        if (this.f1787c) {
            throw new IllegalStateException("closed");
        } else if (j10 < 0 || j11 < j10) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j10), Long.valueOf(j11)}));
        } else {
            while (j10 < j11) {
                long indexOf = this.f1785a.indexOf(b10, j10, j11);
                if (indexOf == -1) {
                    Buffer buffer = this.f1785a;
                    long j12 = buffer.size;
                    if (j12 >= j11 || this.f1786b.read(buffer, 8192) == -1) {
                        break;
                    }
                    j10 = Math.max(j10, j12);
                } else {
                    return indexOf;
                }
            }
            return -1;
        }
    }

    public byte[] readByteArray(long j10) {
        require(j10);
        return this.f1785a.readByteArray(j10);
    }

    public ByteString readByteString(long j10) {
        require(j10);
        return this.f1785a.readByteString(j10);
    }

    public String readUtf8(long j10) {
        require(j10);
        return this.f1785a.readUtf8(j10);
    }

    public String readString(long j10, Charset charset) {
        require(j10);
        if (charset != null) {
            return this.f1785a.readString(j10, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    class a extends InputStream {
        a() {
        }

        public int available() {
            c cVar = c.this;
            if (!cVar.f1787c) {
                return (int) Math.min(cVar.f1785a.size, 2147483647L);
            }
            throw new IOException("closed");
        }

        public void close() {
            c.this.close();
        }

        public int read() {
            c cVar = c.this;
            if (!cVar.f1787c) {
                Buffer buffer = cVar.f1785a;
                if (buffer.size == 0 && cVar.f1786b.read(buffer, 8192) == -1) {
                    return -1;
                }
                return c.this.f1785a.readByte() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return c.this + ".inputStream()";
        }

        public int read(byte[] bArr, int i10, int i11) {
            if (!c.this.f1787c) {
                g.b((long) bArr.length, (long) i10, (long) i11);
                c cVar = c.this;
                Buffer buffer = cVar.f1785a;
                if (buffer.size == 0 && cVar.f1786b.read(buffer, 8192) == -1) {
                    return -1;
                }
                return c.this.f1785a.read(bArr, i10, i11);
            }
            throw new IOException("closed");
        }
    }

    public void readFully(Buffer buffer, long j10) {
        try {
            require(j10);
            this.f1785a.readFully(buffer, j10);
        } catch (EOFException e10) {
            buffer.writeAll(this.f1785a);
            throw e10;
        }
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i10, int i11) {
        long j10 = (long) i11;
        g.b((long) bArr.length, (long) i10, j10);
        Buffer buffer = this.f1785a;
        if (buffer.size == 0 && this.f1786b.read(buffer, 8192) == -1) {
            return -1;
        }
        return this.f1785a.read(bArr, i10, (int) Math.min(j10, this.f1785a.size));
    }

    public long indexOf(ByteString byteString) {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j10) {
        if (!this.f1787c) {
            while (true) {
                long indexOf = this.f1785a.indexOf(byteString, j10);
                if (indexOf != -1) {
                    return indexOf;
                }
                Buffer buffer = this.f1785a;
                long j11 = buffer.size;
                if (this.f1786b.read(buffer, 8192) == -1) {
                    return -1;
                }
                j10 = Math.max(j10, (j11 - ((long) byteString.size())) + 1);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public int read(ByteBuffer byteBuffer) {
        Buffer buffer = this.f1785a;
        if (buffer.size == 0 && this.f1786b.read(buffer, 8192) == -1) {
            return -1;
        }
        return this.f1785a.read(byteBuffer);
    }
}
