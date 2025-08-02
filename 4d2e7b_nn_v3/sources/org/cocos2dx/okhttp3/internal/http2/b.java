package org.cocos2dx.okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.http2.a;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSource;
import org.cocos2dx.okio.ByteString;
import org.cocos2dx.okio.Source;
import org.cocos2dx.okio.Timeout;

final class b implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    static final Logger f1676e = Logger.getLogger(Http2.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSource f1677a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1678b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1679c;

    /* renamed from: d  reason: collision with root package name */
    final a.C0026a f1680d;

    static final class a implements Source {

        /* renamed from: a  reason: collision with root package name */
        private final BufferedSource f1681a;

        /* renamed from: b  reason: collision with root package name */
        int f1682b;

        /* renamed from: c  reason: collision with root package name */
        byte f1683c;

        /* renamed from: d  reason: collision with root package name */
        int f1684d;

        /* renamed from: e  reason: collision with root package name */
        int f1685e;

        /* renamed from: f  reason: collision with root package name */
        short f1686f;

        a(BufferedSource bufferedSource) {
            this.f1681a = bufferedSource;
        }

        private void a() {
            int i10 = this.f1684d;
            int p10 = b.p(this.f1681a);
            this.f1685e = p10;
            this.f1682b = p10;
            byte readByte = (byte) (this.f1681a.readByte() & 255);
            this.f1683c = (byte) (this.f1681a.readByte() & 255);
            Logger logger = b.f1676e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.frameLog(true, this.f1684d, this.f1682b, readByte, this.f1683c));
            }
            int readInt = this.f1681a.readInt() & Integer.MAX_VALUE;
            this.f1684d = readInt;
            if (readByte != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            } else if (readInt != i10) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        public void close() {
        }

        public long read(Buffer buffer, long j10) {
            while (true) {
                int i10 = this.f1685e;
                if (i10 == 0) {
                    this.f1681a.skip((long) this.f1686f);
                    this.f1686f = 0;
                    if ((this.f1683c & 4) != 0) {
                        return -1;
                    }
                    a();
                } else {
                    long read = this.f1681a.read(buffer, Math.min(j10, (long) i10));
                    if (read == -1) {
                        return -1;
                    }
                    this.f1685e = (int) (((long) this.f1685e) - read);
                    return read;
                }
            }
        }

        public Timeout timeout() {
            return this.f1681a.timeout();
        }
    }

    /* renamed from: org.cocos2dx.okhttp3.internal.http2.b$b  reason: collision with other inner class name */
    interface C0027b {
        void a(boolean z10, int i10, BufferedSource bufferedSource, int i11);

        void ackSettings();

        void b(int i10, ErrorCode errorCode, ByteString byteString);

        void c(int i10, ErrorCode errorCode);

        void d(boolean z10, Settings settings);

        void headers(boolean z10, int i10, int i11, List list);

        void ping(boolean z10, int i10, int i11);

        void priority(int i10, int i11, int i12, boolean z10);

        void pushPromise(int i10, int i11, List list);

        void windowUpdate(int i10, long j10);
    }

    b(BufferedSource bufferedSource, boolean z10) {
        this.f1677a = bufferedSource;
        this.f1679c = z10;
        a aVar = new a(bufferedSource);
        this.f1678b = aVar;
        this.f1680d = new a.C0026a(4096, aVar);
    }

    private void A(C0027b bVar, int i10, byte b10, int i11) {
        if (i10 != 4) {
            throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i10));
        } else if (i11 != 0) {
            int readInt = this.f1677a.readInt();
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
            if (fromHttp2 != null) {
                bVar.c(i11, fromHttp2);
                return;
            }
            throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
        } else {
            throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    private void B(C0027b bVar, int i10, byte b10, int i11) {
        if (i11 != 0) {
            throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b10 & 1) != 0) {
            if (i10 == 0) {
                bVar.ackSettings();
                return;
            }
            throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i10 % 6 == 0) {
            Settings settings = new Settings();
            for (int i12 = 0; i12 < i10; i12 += 6) {
                short readShort = this.f1677a.readShort() & com.alibaba.pdns.net.f.a.f18108a;
                int readInt = this.f1677a.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort != 4) {
                        if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        }
                    } else if (readInt >= 0) {
                        readShort = 7;
                    } else {
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                } else if (!(readInt == 0 || readInt == 1)) {
                    throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                settings.set(readShort, readInt);
            }
            bVar.d(false, settings);
        } else {
            throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i10));
        }
    }

    private void C(C0027b bVar, int i10, byte b10, int i11) {
        if (i10 == 4) {
            long readInt = ((long) this.f1677a.readInt()) & 2147483647L;
            if (readInt != 0) {
                bVar.windowUpdate(i11, readInt);
            } else {
                throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(readInt));
            }
        } else {
            throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i10));
        }
    }

    static int a(int i10, byte b10, short s10) {
        if ((b10 & 8) != 0) {
            i10--;
        }
        if (s10 <= i10) {
            return (short) (i10 - s10);
        }
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s10), Integer.valueOf(i10));
    }

    private void j(C0027b bVar, int i10, byte b10, int i11) {
        boolean z10;
        short s10 = 0;
        if (i11 != 0) {
            if ((b10 & 1) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if ((b10 & 32) == 0) {
                if ((b10 & 8) != 0) {
                    s10 = (short) (this.f1677a.readByte() & 255);
                }
                bVar.a(z10, i11, this.f1677a, a(i10, b10, s10));
                this.f1677a.skip((long) s10);
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    private void k(C0027b bVar, int i10, byte b10, int i11) {
        if (i10 < 8) {
            throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i10));
        } else if (i11 == 0) {
            int readInt = this.f1677a.readInt();
            int readInt2 = this.f1677a.readInt();
            int i12 = i10 - 8;
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
            if (fromHttp2 != null) {
                ByteString byteString = ByteString.EMPTY;
                if (i12 > 0) {
                    byteString = this.f1677a.readByteString((long) i12);
                }
                bVar.b(readInt, fromHttp2, byteString);
                return;
            }
            throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        } else {
            throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    private List m(int i10, short s10, byte b10, int i11) {
        a aVar = this.f1678b;
        aVar.f1685e = i10;
        aVar.f1682b = i10;
        aVar.f1686f = s10;
        aVar.f1683c = b10;
        aVar.f1684d = i11;
        this.f1680d.k();
        return this.f1680d.e();
    }

    private void n(C0027b bVar, int i10, byte b10, int i11) {
        boolean z10;
        short s10 = 0;
        if (i11 != 0) {
            if ((b10 & 1) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if ((b10 & 8) != 0) {
                s10 = (short) (this.f1677a.readByte() & 255);
            }
            if ((b10 & 32) != 0) {
                w(bVar, i11);
                i10 -= 5;
            }
            bVar.headers(z10, i11, -1, m(a(i10, b10, s10), s10, b10, i11));
            return;
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    static int p(BufferedSource bufferedSource) {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    private void v(C0027b bVar, int i10, byte b10, int i11) {
        boolean z10 = true;
        if (i10 != 8) {
            throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i10));
        } else if (i11 == 0) {
            int readInt = this.f1677a.readInt();
            int readInt2 = this.f1677a.readInt();
            if ((b10 & 1) == 0) {
                z10 = false;
            }
            bVar.ping(z10, readInt, readInt2);
        } else {
            throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    private void w(C0027b bVar, int i10) {
        boolean z10;
        int readInt = this.f1677a.readInt();
        if ((Integer.MIN_VALUE & readInt) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        bVar.priority(i10, readInt & Integer.MAX_VALUE, (this.f1677a.readByte() & 255) + 1, z10);
    }

    private void y(C0027b bVar, int i10, byte b10, int i11) {
        if (i10 != 5) {
            throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i10));
        } else if (i11 != 0) {
            w(bVar, i11);
        } else {
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    private void z(C0027b bVar, int i10, byte b10, int i11) {
        short s10 = 0;
        if (i11 != 0) {
            if ((b10 & 8) != 0) {
                s10 = (short) (this.f1677a.readByte() & 255);
            }
            bVar.pushPromise(i11, this.f1677a.readInt() & Integer.MAX_VALUE, m(a(i10 - 4, b10, s10), s10, b10, i11));
            return;
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    public boolean b(boolean z10, C0027b bVar) {
        try {
            this.f1677a.require(9);
            int p10 = p(this.f1677a);
            if (p10 < 0 || p10 > 16384) {
                throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(p10));
            }
            byte readByte = (byte) (this.f1677a.readByte() & 255);
            if (!z10 || readByte == 4) {
                byte readByte2 = (byte) (this.f1677a.readByte() & 255);
                int readInt = this.f1677a.readInt() & Integer.MAX_VALUE;
                Logger logger = f1676e;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Http2.frameLog(true, readInt, p10, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        j(bVar, p10, readByte2, readInt);
                        break;
                    case 1:
                        n(bVar, p10, readByte2, readInt);
                        break;
                    case 2:
                        y(bVar, p10, readByte2, readInt);
                        break;
                    case 3:
                        A(bVar, p10, readByte2, readInt);
                        break;
                    case 4:
                        B(bVar, p10, readByte2, readInt);
                        break;
                    case 5:
                        z(bVar, p10, readByte2, readInt);
                        break;
                    case 6:
                        v(bVar, p10, readByte2, readInt);
                        break;
                    case 7:
                        k(bVar, p10, readByte2, readInt);
                        break;
                    case 8:
                        C(bVar, p10, readByte2, readInt);
                        break;
                    default:
                        this.f1677a.skip((long) p10);
                        break;
                }
                return true;
            }
            throw Http2.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
        } catch (IOException unused) {
            return false;
        }
    }

    public void close() {
        this.f1677a.close();
    }

    public void h(C0027b bVar) {
        if (!this.f1679c) {
            BufferedSource bufferedSource = this.f1677a;
            ByteString byteString = Http2.CONNECTION_PREFACE;
            ByteString readByteString = bufferedSource.readByteString((long) byteString.size());
            Logger logger = f1676e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format("<< CONNECTION %s", readByteString.hex()));
            }
            if (!byteString.equals(readByteString)) {
                throw Http2.ioException("Expected a connection header but was %s", readByteString.utf8());
            }
        } else if (!b(true, bVar)) {
            throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
        }
    }
}
