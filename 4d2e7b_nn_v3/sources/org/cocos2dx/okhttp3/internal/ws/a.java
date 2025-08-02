package org.cocos2dx.okhttp3.internal.ws;

import java.io.IOException;
import java.util.Random;
import okhttp3.internal.ws.WebSocketProtocol;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSink;
import org.cocos2dx.okio.ByteString;
import org.cocos2dx.okio.Sink;
import org.cocos2dx.okio.Timeout;

final class a {

    /* renamed from: a  reason: collision with root package name */
    final boolean f1749a;

    /* renamed from: b  reason: collision with root package name */
    final Random f1750b;

    /* renamed from: c  reason: collision with root package name */
    final BufferedSink f1751c;

    /* renamed from: d  reason: collision with root package name */
    final Buffer f1752d;

    /* renamed from: e  reason: collision with root package name */
    boolean f1753e;

    /* renamed from: f  reason: collision with root package name */
    final Buffer f1754f = new Buffer();

    /* renamed from: g  reason: collision with root package name */
    final C0029a f1755g = new C0029a();

    /* renamed from: h  reason: collision with root package name */
    boolean f1756h;

    /* renamed from: i  reason: collision with root package name */
    private final byte[] f1757i;

    /* renamed from: j  reason: collision with root package name */
    private final Buffer.UnsafeCursor f1758j;

    /* renamed from: org.cocos2dx.okhttp3.internal.ws.a$a  reason: collision with other inner class name */
    final class C0029a implements Sink {

        /* renamed from: a  reason: collision with root package name */
        int f1759a;

        /* renamed from: b  reason: collision with root package name */
        long f1760b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1761c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1762d;

        C0029a() {
        }

        public void close() {
            if (!this.f1762d) {
                a aVar = a.this;
                aVar.d(this.f1759a, aVar.f1754f.size(), this.f1761c, true);
                this.f1762d = true;
                a.this.f1756h = false;
                return;
            }
            throw new IOException("closed");
        }

        public void flush() {
            if (!this.f1762d) {
                a aVar = a.this;
                aVar.d(this.f1759a, aVar.f1754f.size(), this.f1761c, false);
                this.f1761c = false;
                return;
            }
            throw new IOException("closed");
        }

        public Timeout timeout() {
            return a.this.f1751c.timeout();
        }

        public void write(Buffer buffer, long j10) {
            boolean z10;
            if (!this.f1762d) {
                a.this.f1754f.write(buffer, j10);
                if (!this.f1761c || this.f1760b == -1 || a.this.f1754f.size() <= this.f1760b - 8192) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                long completeSegmentByteCount = a.this.f1754f.completeSegmentByteCount();
                if (completeSegmentByteCount > 0 && !z10) {
                    a.this.d(this.f1759a, completeSegmentByteCount, this.f1761c, false);
                    this.f1761c = false;
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }
    }

    a(boolean z10, BufferedSink bufferedSink, Random random) {
        byte[] bArr;
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        } else if (random != null) {
            this.f1749a = z10;
            this.f1751c = bufferedSink;
            this.f1752d = bufferedSink.buffer();
            this.f1750b = random;
            Buffer.UnsafeCursor unsafeCursor = null;
            if (z10) {
                bArr = new byte[4];
            } else {
                bArr = null;
            }
            this.f1757i = bArr;
            this.f1758j = z10 ? new Buffer.UnsafeCursor() : unsafeCursor;
        } else {
            throw new NullPointerException("random == null");
        }
    }

    private void c(int i10, ByteString byteString) {
        if (!this.f1753e) {
            int size = byteString.size();
            if (((long) size) <= 125) {
                this.f1752d.writeByte(i10 | 128);
                if (this.f1749a) {
                    this.f1752d.writeByte(size | 128);
                    this.f1750b.nextBytes(this.f1757i);
                    this.f1752d.write(this.f1757i);
                    if (size > 0) {
                        long size2 = this.f1752d.size();
                        this.f1752d.write(byteString);
                        this.f1752d.readAndWriteUnsafe(this.f1758j);
                        this.f1758j.seek(size2);
                        WebSocketProtocol.toggleMask(this.f1758j, this.f1757i);
                        this.f1758j.close();
                    }
                } else {
                    this.f1752d.writeByte(size);
                    this.f1752d.write(byteString);
                }
                this.f1751c.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException("closed");
    }

    /* access modifiers changed from: package-private */
    public Sink a(int i10, long j10) {
        if (!this.f1756h) {
            this.f1756h = true;
            C0029a aVar = this.f1755g;
            aVar.f1759a = i10;
            aVar.f1760b = j10;
            aVar.f1761c = true;
            aVar.f1762d = false;
            return aVar;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    /* access modifiers changed from: package-private */
    public void b(int i10, ByteString byteString) {
        ByteString byteString2 = ByteString.EMPTY;
        if (!(i10 == 0 && byteString == null)) {
            if (i10 != 0) {
                WebSocketProtocol.validateCloseCode(i10);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i10);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            c(8, byteString2);
        } finally {
            this.f1753e = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i10, long j10, boolean z10, boolean z11) {
        if (!this.f1753e) {
            int i11 = 0;
            if (!z10) {
                i10 = 0;
            }
            if (z11) {
                i10 |= 128;
            }
            this.f1752d.writeByte(i10);
            if (this.f1749a) {
                i11 = 128;
            }
            if (j10 <= 125) {
                this.f1752d.writeByte(((int) j10) | i11);
            } else if (j10 <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                this.f1752d.writeByte(i11 | WebSocketProtocol.PAYLOAD_SHORT);
                this.f1752d.writeShort((int) j10);
            } else {
                this.f1752d.writeByte(i11 | 127);
                this.f1752d.writeLong(j10);
            }
            if (this.f1749a) {
                this.f1750b.nextBytes(this.f1757i);
                this.f1752d.write(this.f1757i);
                if (j10 > 0) {
                    long size = this.f1752d.size();
                    this.f1752d.write(this.f1754f, j10);
                    this.f1752d.readAndWriteUnsafe(this.f1758j);
                    this.f1758j.seek(size);
                    WebSocketProtocol.toggleMask(this.f1758j, this.f1757i);
                    this.f1758j.close();
                }
            } else {
                this.f1752d.write(this.f1754f, j10);
            }
            this.f1751c.emit();
            return;
        }
        throw new IOException("closed");
    }

    /* access modifiers changed from: package-private */
    public void e(ByteString byteString) {
        c(9, byteString);
    }

    /* access modifiers changed from: package-private */
    public void f(ByteString byteString) {
        c(10, byteString);
    }
}
