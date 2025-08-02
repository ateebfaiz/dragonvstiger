package okio;

import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.internal.m;
import kotlin.text.a;
import okio.internal.BufferKt;

public final class RealBufferedSource implements BufferedSource {
    public final Buffer bufferField = new Buffer();
    public boolean closed;
    public final Source source;

    public RealBufferedSource(Source source2) {
        m.f(source2, "source");
        this.source = source2;
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    public Buffer buffer() {
        return this.bufferField;
    }

    public void close() {
        if (!this.closed) {
            this.closed = true;
            this.source.close();
            this.bufferField.clear();
        }
    }

    public boolean exhausted() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (!this.bufferField.exhausted() || this.source.read(this.bufferField, (long) 8192) != -1) {
            return false;
        } else {
            return true;
        }
    }

    public Buffer getBuffer() {
        return this.bufferField;
    }

    public long indexOf(byte b10) {
        return indexOf(b10, 0, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public long indexOfElement(ByteString byteString) {
        m.f(byteString, "targetBytes");
        return indexOfElement(byteString, 0);
    }

    public InputStream inputStream() {
        return new RealBufferedSource$inputStream$1(this);
    }

    public boolean isOpen() {
        return !this.closed;
    }

    public BufferedSource peek() {
        return Okio.buffer((Source) new PeekSource(this));
    }

    public boolean rangeEquals(long j10, ByteString byteString) {
        m.f(byteString, "bytes");
        return rangeEquals(j10, byteString, 0, byteString.size());
    }

    public int read(byte[] bArr) {
        m.f(bArr, "sink");
        return read(bArr, 0, bArr.length);
    }

    public long readAll(Sink sink) {
        m.f(sink, "sink");
        long j10 = 0;
        while (this.source.read(this.bufferField, (long) 8192) != -1) {
            long completeSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j10 += completeSegmentByteCount;
                sink.write(this.bufferField, completeSegmentByteCount);
            }
        }
        if (this.bufferField.size() <= 0) {
            return j10;
        }
        long size = j10 + this.bufferField.size();
        Buffer buffer = this.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    public byte readByte() {
        require(1);
        return this.bufferField.readByte();
    }

    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    public long readDecimalLong() {
        int i10;
        require(1);
        long j10 = 0;
        while (true) {
            long j11 = j10 + 1;
            if (!request(j11)) {
                break;
            }
            byte b10 = this.bufferField.getByte(j10);
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
        return this.bufferField.readDecimalLong();
    }

    public void readFully(byte[] bArr) {
        m.f(bArr, "sink");
        try {
            require((long) bArr.length);
            this.bufferField.readFully(bArr);
        } catch (EOFException e10) {
            int i10 = 0;
            while (this.bufferField.size() > 0) {
                Buffer buffer = this.bufferField;
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

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() {
        /*
            r5 = this;
            r0 = 1
            r5.require(r0)
            r0 = 0
        L_0x0006:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r5.request(r2)
            if (r2 == 0) goto L_0x0064
            okio.Buffer r2 = r5.bufferField
            long r3 = (long) r0
            byte r2 = r2.getByte(r3)
            r3 = 48
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x0020
            r3 = 57
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x0035
        L_0x0020:
            r3 = 97
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x002a
            r3 = 102(0x66, float:1.43E-43)
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x0035
        L_0x002a:
            r3 = 65
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x0037
            r3 = 70
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r0 = r1
            goto L_0x0006
        L_0x0037:
            if (r0 == 0) goto L_0x003a
            goto L_0x0064
        L_0x003a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r3)
            r3 = 16
            int r3 = kotlin.text.a.a(r3)
            int r3 = kotlin.text.a.a(r3)
            java.lang.String r2 = java.lang.Integer.toString(r2, r3)
            java.lang.String r3 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.m.e(r2, r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0064:
            okio.Buffer r0 = r5.bufferField
            long r0 = r0.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.readHexadecimalUnsignedLong():long");
    }

    public int readInt() {
        require(4);
        return this.bufferField.readInt();
    }

    public int readIntLe() {
        require(4);
        return this.bufferField.readIntLe();
    }

    public long readLong() {
        require(8);
        return this.bufferField.readLong();
    }

    public long readLongLe() {
        require(8);
        return this.bufferField.readLongLe();
    }

    public short readShort() {
        require(2);
        return this.bufferField.readShort();
    }

    public short readShortLe() {
        require(2);
        return this.bufferField.readShortLe();
    }

    public String readString(long j10, Charset charset) {
        m.f(charset, "charset");
        require(j10);
        return this.bufferField.readString(j10, charset);
    }

    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    public int readUtf8CodePoint() {
        require(1);
        byte b10 = this.bufferField.getByte(0);
        if ((b10 & 224) == 192) {
            require(2);
        } else if ((b10 & 240) == 224) {
            require(3);
        } else if ((b10 & 248) == 240) {
            require(4);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(this.bufferField, indexOf);
        }
        if (this.bufferField.size() != 0) {
            return readUtf8(this.bufferField.size());
        }
        return null;
    }

    public String readUtf8LineStrict() {
        return readUtf8LineStrict(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public boolean request(long j10) {
        boolean z10;
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (!this.closed) {
            while (this.bufferField.size() < j10) {
                if (this.source.read(this.bufferField, (long) 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public void require(long j10) {
        if (!request(j10)) {
            throw new EOFException();
        }
    }

    public int select(Options options) {
        m.f(options, "options");
        if (!this.closed) {
            while (true) {
                int selectPrefix = BufferKt.selectPrefix(this.bufferField, options, true);
                if (selectPrefix == -2) {
                    if (this.source.read(this.bufferField, (long) 8192) == -1) {
                        break;
                    }
                } else if (selectPrefix != -1) {
                    this.bufferField.skip((long) options.getByteStrings$okio()[selectPrefix].size());
                    return selectPrefix;
                }
            }
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public void skip(long j10) {
        if (!this.closed) {
            while (j10 > 0) {
                if (this.bufferField.size() == 0 && this.source.read(this.bufferField, (long) 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j10, this.bufferField.size());
                this.bufferField.skip(min);
                j10 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }

    public long indexOf(byte b10, long j10) {
        return indexOf(b10, j10, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public long indexOfElement(ByteString byteString, long j10) {
        m.f(byteString, "targetBytes");
        if (!this.closed) {
            while (true) {
                long indexOfElement = this.bufferField.indexOfElement(byteString, j10);
                if (indexOfElement != -1) {
                    return indexOfElement;
                }
                long size = this.bufferField.size();
                if (this.source.read(this.bufferField, (long) 8192) == -1) {
                    return -1;
                }
                j10 = Math.max(j10, size);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public long read(Buffer buffer, long j10) {
        m.f(buffer, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (this.bufferField.size() == 0 && this.source.read(this.bufferField, (long) 8192) == -1) {
            return -1;
        } else {
            return this.bufferField.read(buffer, Math.min(j10, this.bufferField.size()));
        }
    }

    public String readUtf8LineStrict(long j10) {
        if (j10 >= 0) {
            long j11 = j10 == LocationRequestCompat.PASSIVE_INTERVAL ? Long.MAX_VALUE : j10 + 1;
            byte b10 = (byte) 10;
            long indexOf = indexOf(b10, 0, j11);
            if (indexOf != -1) {
                return BufferKt.readUtf8Line(this.bufferField, indexOf);
            }
            if (j11 < LocationRequestCompat.PASSIVE_INTERVAL && request(j11) && this.bufferField.getByte(j11 - 1) == ((byte) 13) && request(1 + j11) && this.bufferField.getByte(j11) == b10) {
                return BufferKt.readUtf8Line(this.bufferField, j11);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.bufferField;
            buffer2.copyTo(buffer, 0, Math.min((long) 32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), j10) + " content=" + buffer.readByteString().hex() + "…");
        }
        throw new IllegalArgumentException(("limit < 0: " + j10).toString());
    }

    public long indexOf(ByteString byteString) {
        m.f(byteString, "bytes");
        return indexOf(byteString, 0);
    }

    public boolean rangeEquals(long j10, ByteString byteString, int i10, int i11) {
        m.f(byteString, "bytes");
        if (!this.closed) {
            if (j10 >= 0 && i10 >= 0 && i11 >= 0 && byteString.size() - i10 >= i11) {
                int i12 = 0;
                while (i12 < i11) {
                    long j11 = ((long) i12) + j10;
                    if (request(1 + j11) && this.bufferField.getByte(j11) == byteString.getByte(i10 + i12)) {
                        i12++;
                    }
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    public long indexOf(byte b10, long j10, long j11) {
        boolean z10 = true;
        if (!this.closed) {
            if (0 > j10 || j11 < j10) {
                z10 = false;
            }
            if (z10) {
                while (j10 < j11) {
                    long indexOf = this.bufferField.indexOf(b10, j10, j11);
                    if (indexOf != -1) {
                        return indexOf;
                    }
                    long size = this.bufferField.size();
                    if (size >= j11 || this.source.read(this.bufferField, (long) 8192) == -1) {
                        return -1;
                    }
                    j10 = Math.max(j10, size);
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    public String readString(Charset charset) {
        m.f(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    public byte[] readByteArray(long j10) {
        require(j10);
        return this.bufferField.readByteArray(j10);
    }

    public ByteString readByteString(long j10) {
        require(j10);
        return this.bufferField.readByteString(j10);
    }

    public String readUtf8(long j10) {
        require(j10);
        return this.bufferField.readUtf8(j10);
    }

    public void readFully(Buffer buffer, long j10) {
        m.f(buffer, "sink");
        try {
            require(j10);
            this.bufferField.readFully(buffer, j10);
        } catch (EOFException e10) {
            buffer.writeAll(this.bufferField);
            throw e10;
        }
    }

    public long indexOf(ByteString byteString, long j10) {
        m.f(byteString, "bytes");
        if (!this.closed) {
            while (true) {
                long indexOf = this.bufferField.indexOf(byteString, j10);
                if (indexOf != -1) {
                    return indexOf;
                }
                long size = this.bufferField.size();
                if (this.source.read(this.bufferField, (long) 8192) == -1) {
                    return -1;
                }
                j10 = Math.max(j10, (size - ((long) byteString.size())) + 1);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public int read(byte[] bArr, int i10, int i11) {
        m.f(bArr, "sink");
        long j10 = (long) i11;
        Util.checkOffsetAndCount((long) bArr.length, (long) i10, j10);
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, (long) 8192) == -1) {
            return -1;
        }
        return this.bufferField.read(bArr, i10, (int) Math.min(j10, this.bufferField.size()));
    }

    public int read(ByteBuffer byteBuffer) {
        m.f(byteBuffer, "sink");
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, (long) 8192) == -1) {
            return -1;
        }
        return this.bufferField.read(byteBuffer);
    }
}
