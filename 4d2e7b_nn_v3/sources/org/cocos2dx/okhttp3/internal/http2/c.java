package org.cocos2dx.okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.http2.a;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSink;

final class c implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    private static final Logger f1687g = Logger.getLogger(Http2.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSink f1688a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1689b;

    /* renamed from: c  reason: collision with root package name */
    private final Buffer f1690c;

    /* renamed from: d  reason: collision with root package name */
    private int f1691d = 16384;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1692e;

    /* renamed from: f  reason: collision with root package name */
    final a.b f1693f;

    c(BufferedSink bufferedSink, boolean z10) {
        this.f1688a = bufferedSink;
        this.f1689b = z10;
        Buffer buffer = new Buffer();
        this.f1690c = buffer;
        this.f1693f = new a.b(buffer);
    }

    private void E(int i10, long j10) {
        byte b10;
        while (j10 > 0) {
            int min = (int) Math.min((long) this.f1691d, j10);
            long j11 = (long) min;
            j10 -= j11;
            if (j10 == 0) {
                b10 = 4;
            } else {
                b10 = 0;
            }
            k(i10, min, (byte) 9, b10);
            this.f1688a.write(this.f1690c, j11);
        }
    }

    private static void G(BufferedSink bufferedSink, int i10) {
        bufferedSink.writeByte((i10 >>> 16) & 255);
        bufferedSink.writeByte((i10 >>> 8) & 255);
        bufferedSink.writeByte(i10 & 255);
    }

    public synchronized void A(boolean z10, int i10, List list) {
        if (!this.f1692e) {
            n(z10, i10, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void B(boolean z10, int i10, int i11, List list) {
        if (!this.f1692e) {
            n(z10, i10, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void C(int i10, long j10) {
        if (this.f1692e) {
            throw new IOException("closed");
        } else if (j10 == 0 || j10 > 2147483647L) {
            throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j10));
        } else {
            k(i10, 4, (byte) 8, (byte) 0);
            this.f1688a.writeInt((int) j10);
            this.f1688a.flush();
        }
    }

    public synchronized void a(Settings settings) {
        try {
            if (!this.f1692e) {
                this.f1691d = settings.getMaxFrameSize(this.f1691d);
                if (settings.getHeaderTableSize() != -1) {
                    this.f1693f.e(settings.getHeaderTableSize());
                }
                k(0, 0, (byte) 4, (byte) 1);
                this.f1688a.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void b() {
        try {
            if (this.f1692e) {
                throw new IOException("closed");
            } else if (this.f1689b) {
                Logger logger = f1687g;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.hex()));
                }
                this.f1688a.write(Http2.CONNECTION_PREFACE.toByteArray());
                this.f1688a.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void close() {
        this.f1692e = true;
        this.f1688a.close();
    }

    public synchronized void flush() {
        if (!this.f1692e) {
            this.f1688a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void h(boolean z10, int i10, Buffer buffer, int i11) {
        byte b10;
        if (!this.f1692e) {
            if (z10) {
                b10 = (byte) 1;
            } else {
                b10 = 0;
            }
            j(i10, b10, buffer, i11);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    public void j(int i10, byte b10, Buffer buffer, int i11) {
        k(i10, i11, (byte) 0, b10);
        if (i11 > 0) {
            this.f1688a.write(buffer, (long) i11);
        }
    }

    public void k(int i10, int i11, byte b10, byte b11) {
        Logger logger = f1687g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.frameLog(false, i10, i11, b10, b11));
        }
        int i12 = this.f1691d;
        if (i11 > i12) {
            throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i12), Integer.valueOf(i11));
        } else if ((Integer.MIN_VALUE & i10) == 0) {
            G(this.f1688a, i11);
            this.f1688a.writeByte(b10 & 255);
            this.f1688a.writeByte(b11 & 255);
            this.f1688a.writeInt(i10 & Integer.MAX_VALUE);
        } else {
            throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i10));
        }
    }

    public synchronized void m(int i10, ErrorCode errorCode, byte[] bArr) {
        try {
            if (this.f1692e) {
                throw new IOException("closed");
            } else if (errorCode.httpCode != -1) {
                k(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f1688a.writeInt(i10);
                this.f1688a.writeInt(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.f1688a.write(bArr);
                }
                this.f1688a.flush();
            } else {
                throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void n(boolean z10, int i10, List list) {
        byte b10;
        if (!this.f1692e) {
            this.f1693f.g(list);
            long size = this.f1690c.size();
            int min = (int) Math.min((long) this.f1691d, size);
            long j10 = (long) min;
            int i11 = (size > j10 ? 1 : (size == j10 ? 0 : -1));
            if (i11 == 0) {
                b10 = 4;
            } else {
                b10 = 0;
            }
            if (z10) {
                b10 = (byte) (b10 | 1);
            }
            k(i10, min, (byte) 1, b10);
            this.f1688a.write(this.f1690c, j10);
            if (i11 > 0) {
                E(i10, size - j10);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public int p() {
        return this.f1691d;
    }

    public synchronized void v(boolean z10, int i10, int i11) {
        if (!this.f1692e) {
            k(0, 8, (byte) 6, z10 ? (byte) 1 : 0);
            this.f1688a.writeInt(i10);
            this.f1688a.writeInt(i11);
            this.f1688a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void w(int i10, int i11, List list) {
        byte b10;
        if (!this.f1692e) {
            this.f1693f.g(list);
            long size = this.f1690c.size();
            int min = (int) Math.min((long) (this.f1691d - 4), size);
            long j10 = (long) min;
            int i12 = (size > j10 ? 1 : (size == j10 ? 0 : -1));
            if (i12 == 0) {
                b10 = 4;
            } else {
                b10 = 0;
            }
            k(i10, min + 4, (byte) 5, b10);
            this.f1688a.writeInt(i11 & Integer.MAX_VALUE);
            this.f1688a.write(this.f1690c, j10);
            if (i12 > 0) {
                E(i10, size - j10);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void y(int i10, ErrorCode errorCode) {
        if (this.f1692e) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            k(i10, 4, (byte) 3, (byte) 0);
            this.f1688a.writeInt(errorCode.httpCode);
            this.f1688a.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void z(Settings settings) {
        int i10;
        try {
            if (!this.f1692e) {
                k(0, settings.size() * 6, (byte) 4, (byte) 0);
                for (int i11 = 0; i11 < 10; i11++) {
                    if (settings.isSet(i11)) {
                        if (i11 == 4) {
                            i10 = 3;
                        } else if (i11 == 7) {
                            i10 = 4;
                        } else {
                            i10 = i11;
                        }
                        this.f1688a.writeShort(i10);
                        this.f1688a.writeInt(settings.get(i11));
                    }
                }
                this.f1688a.flush();
            } else {
                throw new IOException("closed");
            }
        } finally {
        }
    }
}
