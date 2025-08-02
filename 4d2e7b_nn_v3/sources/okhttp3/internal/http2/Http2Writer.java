package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;

public final class Http2Writer implements Closeable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize = 16384;
    private final BufferedSink sink;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Http2Writer(BufferedSink bufferedSink, boolean z10) {
        m.f(bufferedSink, "sink");
        this.sink = bufferedSink;
        this.client = z10;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.hpackWriter = new Hpack.Writer(0, false, buffer, 3, (DefaultConstructorMarker) null);
    }

    private final void writeContinuationFrames(int i10, long j10) throws IOException {
        int i11;
        while (j10 > 0) {
            long min = Math.min((long) this.maxFrameSize, j10);
            j10 -= min;
            int i12 = (int) min;
            if (j10 == 0) {
                i11 = 4;
            } else {
                i11 = 0;
            }
            frameHeader(i10, i12, 9, i11);
            this.sink.write(this.hpackBuffer, min);
        }
    }

    public final synchronized void applyAndAckSettings(Settings settings) throws IOException {
        try {
            m.f(settings, "peerSettings");
            if (!this.closed) {
                this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
                if (settings.getHeaderTableSize() != -1) {
                    this.hpackWriter.resizeHeaderTable(settings.getHeaderTableSize());
                }
                frameHeader(0, 0, 4, 1);
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void connectionPreface() throws IOException {
        try {
            if (this.closed) {
                throw new IOException("closed");
            } else if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
                }
                this.sink.write(Http2.CONNECTION_PREFACE);
                this.sink.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void data(boolean z10, int i10, Buffer buffer, int i11) throws IOException {
        if (!this.closed) {
            dataFrame(i10, z10 ? 1 : 0, buffer, i11);
        } else {
            throw new IOException("closed");
        }
    }

    public final void dataFrame(int i10, int i11, Buffer buffer, int i12) throws IOException {
        frameHeader(i10, i12, 0, i11);
        if (i12 > 0) {
            BufferedSink bufferedSink = this.sink;
            m.c(buffer);
            bufferedSink.write(buffer, (long) i12);
        }
    }

    public final synchronized void flush() throws IOException {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final void frameHeader(int i10, int i11, int i12, int i13) throws IOException {
        boolean z10;
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.INSTANCE.frameLog(false, i10, i11, i12, i13));
        }
        boolean z11 = false;
        if (i11 <= this.maxFrameSize) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if ((((int) 2147483648L) & i10) == 0) {
                z11 = true;
            }
            if (z11) {
                Util.writeMedium(this.sink, i11);
                this.sink.writeByte(i12 & 255);
                this.sink.writeByte(i13 & 255);
                this.sink.writeInt(i10 & Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException(("reserved bit set: " + i10).toString());
        }
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i11).toString());
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int i10, ErrorCode errorCode, byte[] bArr) throws IOException {
        boolean z10;
        try {
            m.f(errorCode, "errorCode");
            m.f(bArr, "debugData");
            if (!this.closed) {
                boolean z11 = false;
                if (errorCode.getHttpCode() != -1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    frameHeader(0, bArr.length + 8, 7, 0);
                    this.sink.writeInt(i10);
                    this.sink.writeInt(errorCode.getHttpCode());
                    if (bArr.length == 0) {
                        z11 = true;
                    }
                    if (!z11) {
                        this.sink.write(bArr);
                    }
                    this.sink.flush();
                } else {
                    throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
                }
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void headers(boolean z10, int i10, List<Header> list) throws IOException {
        int i11;
        m.f(list, "headerBlock");
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            long min = Math.min((long) this.maxFrameSize, size);
            int i12 = (size > min ? 1 : (size == min ? 0 : -1));
            if (i12 == 0) {
                i11 = 4;
            } else {
                i11 = 0;
            }
            if (z10) {
                i11 |= 1;
            }
            frameHeader(i10, (int) min, 1, i11);
            this.sink.write(this.hpackBuffer, min);
            if (i12 > 0) {
                writeContinuationFrames(i10, size - min);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean z10, int i10, int i11) throws IOException {
        if (!this.closed) {
            frameHeader(0, 8, 6, z10 ? 1 : 0);
            this.sink.writeInt(i10);
            this.sink.writeInt(i11);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void pushPromise(int i10, int i11, List<Header> list) throws IOException {
        int i12;
        m.f(list, "requestHeaders");
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min(((long) this.maxFrameSize) - 4, size);
            int i13 = min + 4;
            long j10 = (long) min;
            int i14 = (size > j10 ? 1 : (size == j10 ? 0 : -1));
            if (i14 == 0) {
                i12 = 4;
            } else {
                i12 = 0;
            }
            frameHeader(i10, i13, 5, i12);
            this.sink.writeInt(i11 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j10);
            if (i14 > 0) {
                writeContinuationFrames(i10, size - j10);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void rstStream(int i10, ErrorCode errorCode) throws IOException {
        boolean z10;
        m.f(errorCode, "errorCode");
        if (!this.closed) {
            if (errorCode.getHttpCode() != -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                frameHeader(i10, 4, 3, 0);
                this.sink.writeInt(errorCode.getHttpCode());
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void settings(Settings settings) throws IOException {
        int i10;
        try {
            m.f(settings, "settings");
            if (!this.closed) {
                frameHeader(0, settings.size() * 6, 4, 0);
                for (int i11 = 0; i11 < 10; i11++) {
                    if (settings.isSet(i11)) {
                        if (i11 == 4) {
                            i10 = 3;
                        } else if (i11 != 7) {
                            i10 = i11;
                        } else {
                            i10 = 4;
                        }
                        this.sink.writeShort(i10);
                        this.sink.writeInt(settings.get(i11));
                    }
                }
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        } finally {
        }
    }

    public final synchronized void windowUpdate(int i10, long j10) throws IOException {
        boolean z10;
        if (!this.closed) {
            if (j10 == 0 || j10 > 2147483647L) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                frameHeader(i10, 4, 8, 0);
                this.sink.writeInt((int) j10);
                this.sink.flush();
            } else {
                throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j10).toString());
            }
        } else {
            throw new IOException("closed");
        }
    }
}
