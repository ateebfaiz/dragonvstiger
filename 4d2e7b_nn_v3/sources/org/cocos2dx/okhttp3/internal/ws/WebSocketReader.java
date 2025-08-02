package org.cocos2dx.okhttp3.internal.ws;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.ws.WebSocketProtocol;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSource;
import org.cocos2dx.okio.ByteString;

final class WebSocketReader {

    /* renamed from: a  reason: collision with root package name */
    final boolean f1737a;

    /* renamed from: b  reason: collision with root package name */
    final BufferedSource f1738b;

    /* renamed from: c  reason: collision with root package name */
    final FrameCallback f1739c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1740d;

    /* renamed from: e  reason: collision with root package name */
    int f1741e;

    /* renamed from: f  reason: collision with root package name */
    long f1742f;

    /* renamed from: g  reason: collision with root package name */
    boolean f1743g;

    /* renamed from: h  reason: collision with root package name */
    boolean f1744h;

    /* renamed from: i  reason: collision with root package name */
    private final Buffer f1745i = new Buffer();

    /* renamed from: j  reason: collision with root package name */
    private final Buffer f1746j = new Buffer();

    /* renamed from: k  reason: collision with root package name */
    private final byte[] f1747k;

    /* renamed from: l  reason: collision with root package name */
    private final Buffer.UnsafeCursor f1748l;

    public interface FrameCallback {
        void onReadClose(int i10, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    WebSocketReader(boolean z10, BufferedSource bufferedSource, FrameCallback frameCallback) {
        byte[] bArr;
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        } else if (frameCallback != null) {
            this.f1737a = z10;
            this.f1738b = bufferedSource;
            this.f1739c = frameCallback;
            Buffer.UnsafeCursor unsafeCursor = null;
            if (z10) {
                bArr = null;
            } else {
                bArr = new byte[4];
            }
            this.f1747k = bArr;
            this.f1748l = !z10 ? new Buffer.UnsafeCursor() : unsafeCursor;
        } else {
            throw new NullPointerException("frameCallback == null");
        }
    }

    private void b() {
        String str;
        short s10;
        long j10 = this.f1742f;
        if (j10 > 0) {
            this.f1738b.readFully(this.f1745i, j10);
            if (!this.f1737a) {
                this.f1745i.readAndWriteUnsafe(this.f1748l);
                this.f1748l.seek(0);
                WebSocketProtocol.toggleMask(this.f1748l, this.f1747k);
                this.f1748l.close();
            }
        }
        switch (this.f1741e) {
            case 8:
                long size = this.f1745i.size();
                if (size != 1) {
                    if (size != 0) {
                        s10 = this.f1745i.readShort();
                        str = this.f1745i.readUtf8();
                        String closeCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(s10);
                        if (closeCodeExceptionMessage != null) {
                            throw new ProtocolException(closeCodeExceptionMessage);
                        }
                    } else {
                        s10 = 1005;
                        str = "";
                    }
                    this.f1739c.onReadClose(s10, str);
                    this.f1740d = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.f1739c.onReadPing(this.f1745i.readByteString());
                return;
            case 10:
                this.f1739c.onReadPong(this.f1745i.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f1741e));
        }
    }

    /* JADX INFO: finally extract failed */
    private void c() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        String str;
        if (!this.f1740d) {
            long timeoutNanos = this.f1738b.timeout().timeoutNanos();
            this.f1738b.timeout().clearTimeout();
            try {
                byte readByte = this.f1738b.readByte();
                this.f1738b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                this.f1741e = readByte & 15;
                boolean z15 = false;
                if ((readByte & 128) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.f1743g = z10;
                if ((readByte & 8) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                this.f1744h = z11;
                if (!z11 || z10) {
                    if ((readByte & 64) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if ((readByte & 32) != 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if ((readByte & 16) != 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (z12 || z13 || z14) {
                        throw new ProtocolException("Reserved flags are unsupported.");
                    }
                    byte readByte2 = this.f1738b.readByte();
                    if ((readByte2 & 128) != 0) {
                        z15 = true;
                    }
                    if (z15 == this.f1737a) {
                        if (this.f1737a) {
                            str = "Server-sent frames must not be masked.";
                        } else {
                            str = "Client-sent frames must be masked.";
                        }
                        throw new ProtocolException(str);
                    }
                    long j10 = (long) (readByte2 & Byte.MAX_VALUE);
                    this.f1742f = j10;
                    if (j10 == 126) {
                        this.f1742f = ((long) this.f1738b.readShort()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                    } else if (j10 == 127) {
                        long readLong = this.f1738b.readLong();
                        this.f1742f = readLong;
                        if (readLong < 0) {
                            throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f1742f) + " > 0x7FFFFFFFFFFFFFFF");
                        }
                    }
                    if (this.f1744h && this.f1742f > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (z15) {
                        this.f1738b.readFully(this.f1747k);
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.f1738b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    private void d() {
        while (!this.f1740d) {
            long j10 = this.f1742f;
            if (j10 > 0) {
                this.f1738b.readFully(this.f1746j, j10);
                if (!this.f1737a) {
                    this.f1746j.readAndWriteUnsafe(this.f1748l);
                    this.f1748l.seek(this.f1746j.size() - this.f1742f);
                    WebSocketProtocol.toggleMask(this.f1748l, this.f1747k);
                    this.f1748l.close();
                }
            }
            if (!this.f1743g) {
                f();
                if (this.f1741e != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f1741e));
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }

    private void e() {
        int i10 = this.f1741e;
        if (i10 == 1 || i10 == 2) {
            d();
            if (i10 == 1) {
                this.f1739c.onReadMessage(this.f1746j.readUtf8());
            } else {
                this.f1739c.onReadMessage(this.f1746j.readByteString());
            }
        } else {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i10));
        }
    }

    private void f() {
        while (!this.f1740d) {
            c();
            if (this.f1744h) {
                b();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        c();
        if (this.f1744h) {
            b();
        } else {
            e();
        }
    }
}
