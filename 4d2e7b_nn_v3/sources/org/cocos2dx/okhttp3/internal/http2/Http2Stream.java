package org.cocos2dx.okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import org.cocos2dx.okhttp3.Headers;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.http2.Header;
import org.cocos2dx.okio.AsyncTimeout;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSource;
import org.cocos2dx.okio.Sink;
import org.cocos2dx.okio.Source;
import org.cocos2dx.okio.Timeout;

public final class Http2Stream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    final Http2Connection connection;
    ErrorCode errorCode;
    private boolean hasResponseHeaders;
    private Header.a headersListener;
    /* access modifiers changed from: private */
    public final Deque<Headers> headersQueue;

    /* renamed from: id  reason: collision with root package name */
    final int f1644id;
    final c readTimeout;
    final a sink;
    private final b source;
    long unacknowledgedBytesRead = 0;
    final c writeTimeout;

    final class a implements Sink {

        /* renamed from: a  reason: collision with root package name */
        private final Buffer f1645a = new Buffer();

        /* renamed from: b  reason: collision with root package name */
        boolean f1646b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1647c;

        a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.writeTimeout.a();
            r11.f1648d.checkOutNotClosed();
            r9 = java.lang.Math.min(r11.f1648d.bytesLeftInWriteWindow, r11.f1645a.size());
            r1 = r11.f1648d;
            r1.bytesLeftInWriteWindow -= r9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(boolean r12) {
            /*
                r11 = this;
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r0 = org.cocos2dx.okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r0)
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r1 = org.cocos2dx.okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0079 }
                org.cocos2dx.okhttp3.internal.http2.Http2Stream$c r1 = r1.writeTimeout     // Catch:{ all -> 0x0079 }
                r1.enter()     // Catch:{ all -> 0x0079 }
            L_0x000a:
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r1 = org.cocos2dx.okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0024 }
                long r2 = r1.bytesLeftInWriteWindow     // Catch:{ all -> 0x0024 }
                r4 = 0
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 > 0) goto L_0x0026
                boolean r2 = r11.f1647c     // Catch:{ all -> 0x0024 }
                if (r2 != 0) goto L_0x0026
                boolean r2 = r11.f1646b     // Catch:{ all -> 0x0024 }
                if (r2 != 0) goto L_0x0026
                org.cocos2dx.okhttp3.internal.http2.ErrorCode r2 = r1.errorCode     // Catch:{ all -> 0x0024 }
                if (r2 != 0) goto L_0x0026
                r1.waitForIo()     // Catch:{ all -> 0x0024 }
                goto L_0x000a
            L_0x0024:
                r12 = move-exception
                goto L_0x007b
            L_0x0026:
                org.cocos2dx.okhttp3.internal.http2.Http2Stream$c r1 = r1.writeTimeout     // Catch:{ all -> 0x0079 }
                r1.a()     // Catch:{ all -> 0x0079 }
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r1 = org.cocos2dx.okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0079 }
                r1.checkOutNotClosed()     // Catch:{ all -> 0x0079 }
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r1 = org.cocos2dx.okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0079 }
                long r1 = r1.bytesLeftInWriteWindow     // Catch:{ all -> 0x0079 }
                org.cocos2dx.okio.Buffer r3 = r11.f1645a     // Catch:{ all -> 0x0079 }
                long r3 = r3.size()     // Catch:{ all -> 0x0079 }
                long r9 = java.lang.Math.min(r1, r3)     // Catch:{ all -> 0x0079 }
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r1 = org.cocos2dx.okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0079 }
                long r2 = r1.bytesLeftInWriteWindow     // Catch:{ all -> 0x0079 }
                long r2 = r2 - r9
                r1.bytesLeftInWriteWindow = r2     // Catch:{ all -> 0x0079 }
                monitor-exit(r0)     // Catch:{ all -> 0x0079 }
                org.cocos2dx.okhttp3.internal.http2.Http2Stream$c r0 = r1.writeTimeout
                r0.enter()
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r0 = org.cocos2dx.okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0060 }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r5 = r0.connection     // Catch:{ all -> 0x0060 }
                int r6 = r0.f1644id     // Catch:{ all -> 0x0060 }
                if (r12 == 0) goto L_0x0062
                org.cocos2dx.okio.Buffer r12 = r11.f1645a     // Catch:{ all -> 0x0060 }
                long r0 = r12.size()     // Catch:{ all -> 0x0060 }
                int r12 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r12 != 0) goto L_0x0062
                r12 = 1
            L_0x005e:
                r7 = r12
                goto L_0x0064
            L_0x0060:
                r12 = move-exception
                goto L_0x0071
            L_0x0062:
                r12 = 0
                goto L_0x005e
            L_0x0064:
                org.cocos2dx.okio.Buffer r8 = r11.f1645a     // Catch:{ all -> 0x0060 }
                r5.writeData(r6, r7, r8, r9)     // Catch:{ all -> 0x0060 }
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r12 = org.cocos2dx.okhttp3.internal.http2.Http2Stream.this
                org.cocos2dx.okhttp3.internal.http2.Http2Stream$c r12 = r12.writeTimeout
                r12.a()
                return
            L_0x0071:
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r0 = org.cocos2dx.okhttp3.internal.http2.Http2Stream.this
                org.cocos2dx.okhttp3.internal.http2.Http2Stream$c r0 = r0.writeTimeout
                r0.a()
                throw r12
            L_0x0079:
                r12 = move-exception
                goto L_0x0083
            L_0x007b:
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r1 = org.cocos2dx.okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0079 }
                org.cocos2dx.okhttp3.internal.http2.Http2Stream$c r1 = r1.writeTimeout     // Catch:{ all -> 0x0079 }
                r1.a()     // Catch:{ all -> 0x0079 }
                throw r12     // Catch:{ all -> 0x0079 }
            L_0x0083:
                monitor-exit(r0)     // Catch:{ all -> 0x0079 }
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.http2.Http2Stream.a.a(boolean):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            if (r8.f1648d.sink.f1647c != false) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
            if (r8.f1645a.size() <= 0) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
            if (r8.f1645a.size() <= 0) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
            a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
            r0 = r8.f1648d;
            r0.connection.writeData(r0.f1644id, true, (org.cocos2dx.okio.Buffer) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
            r2 = r8.f1648d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r8.f1646b = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
            r8.f1648d.connection.flush();
            r8.f1648d.cancelStreamIfNecessary();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
                r8 = this;
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r0 = org.cocos2dx.okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r0)
                boolean r1 = r8.f1646b     // Catch:{ all -> 0x0009 }
                if (r1 == 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                return
            L_0x0009:
                r1 = move-exception
                goto L_0x0052
            L_0x000b:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r0 = org.cocos2dx.okhttp3.internal.http2.Http2Stream.this
                org.cocos2dx.okhttp3.internal.http2.Http2Stream$a r0 = r0.sink
                boolean r0 = r0.f1647c
                r1 = 1
                if (r0 != 0) goto L_0x003c
                org.cocos2dx.okio.Buffer r0 = r8.f1645a
                long r2 = r0.size()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x002f
            L_0x0021:
                org.cocos2dx.okio.Buffer r0 = r8.f1645a
                long r2 = r0.size()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x003c
                r8.a(r1)
                goto L_0x0021
            L_0x002f:
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r0 = org.cocos2dx.okhttp3.internal.http2.Http2Stream.this
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r2 = r0.connection
                int r3 = r0.f1644id
                r5 = 0
                r6 = 0
                r4 = 1
                r2.writeData(r3, r4, r5, r6)
            L_0x003c:
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r2 = org.cocos2dx.okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r2)
                r8.f1646b = r1     // Catch:{ all -> 0x004f }
                monitor-exit(r2)     // Catch:{ all -> 0x004f }
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r0 = org.cocos2dx.okhttp3.internal.http2.Http2Stream.this
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r0 = r0.connection
                r0.flush()
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r0 = org.cocos2dx.okhttp3.internal.http2.Http2Stream.this
                r0.cancelStreamIfNecessary()
                return
            L_0x004f:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x004f }
                throw r0
            L_0x0052:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.http2.Http2Stream.a.close():void");
        }

        public void flush() {
            synchronized (Http2Stream.this) {
                Http2Stream.this.checkOutNotClosed();
            }
            while (this.f1645a.size() > 0) {
                a(false);
                Http2Stream.this.connection.flush();
            }
        }

        public Timeout timeout() {
            return Http2Stream.this.writeTimeout;
        }

        public void write(Buffer buffer, long j10) {
            this.f1645a.write(buffer, j10);
            while (this.f1645a.size() >= okhttp3.internal.http2.Http2Stream.EMIT_BUFFER_SIZE) {
                a(false);
            }
        }
    }

    private final class b implements Source {

        /* renamed from: a  reason: collision with root package name */
        private final Buffer f1649a = new Buffer();

        /* renamed from: b  reason: collision with root package name */
        private final Buffer f1650b = new Buffer();

        /* renamed from: c  reason: collision with root package name */
        private final long f1651c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1652d;

        /* renamed from: e  reason: collision with root package name */
        boolean f1653e;

        b(long j10) {
            this.f1651c = j10;
        }

        private void b(long j10) {
            Http2Stream.this.connection.updateConnectionFlowControl(j10);
        }

        /* access modifiers changed from: package-private */
        public void a(BufferedSource bufferedSource, long j10) {
            boolean z10;
            boolean z11;
            boolean z12;
            long j11;
            while (j10 > 0) {
                synchronized (Http2Stream.this) {
                    z10 = this.f1653e;
                    z11 = false;
                    if (this.f1650b.size() + j10 > this.f1651c) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                }
                if (z12) {
                    bufferedSource.skip(j10);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z10) {
                    bufferedSource.skip(j10);
                    return;
                } else {
                    long read = bufferedSource.read(this.f1649a, j10);
                    if (read != -1) {
                        j10 -= read;
                        synchronized (Http2Stream.this) {
                            try {
                                if (this.f1652d) {
                                    j11 = this.f1649a.size();
                                    this.f1649a.clear();
                                } else {
                                    if (this.f1650b.size() == 0) {
                                        z11 = true;
                                    }
                                    this.f1650b.writeAll(this.f1649a);
                                    if (z11) {
                                        Http2Stream.this.notifyAll();
                                    }
                                    j11 = 0;
                                }
                            } catch (Throwable th) {
                                while (true) {
                                    throw th;
                                }
                            }
                        }
                        if (j11 > 0) {
                            b(j11);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public void close() {
            long size;
            synchronized (Http2Stream.this) {
                try {
                    this.f1652d = true;
                    size = this.f1650b.size();
                    this.f1650b.clear();
                    if (!Http2Stream.this.headersQueue.isEmpty()) {
                        Header.a unused = Http2Stream.this.getClass();
                    }
                    Http2Stream.this.notifyAll();
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (size > 0) {
                b(size);
            }
            Http2Stream.this.cancelStreamIfNecessary();
        }

        /* JADX INFO: finally extract failed */
        public long read(Buffer buffer, long j10) {
            ErrorCode errorCode;
            long read;
            if (j10 >= 0) {
                while (true) {
                    synchronized (Http2Stream.this) {
                        try {
                            Http2Stream.this.readTimeout.enter();
                            Http2Stream http2Stream = Http2Stream.this;
                            errorCode = http2Stream.errorCode;
                            if (errorCode == null) {
                                errorCode = null;
                            }
                            if (!this.f1652d) {
                                if (!http2Stream.headersQueue.isEmpty()) {
                                    Header.a unused = Http2Stream.this.getClass();
                                }
                                if (this.f1650b.size() > 0) {
                                    Buffer buffer2 = this.f1650b;
                                    read = buffer2.read(buffer, Math.min(j10, buffer2.size()));
                                    Http2Stream http2Stream2 = Http2Stream.this;
                                    long j11 = http2Stream2.unacknowledgedBytesRead + read;
                                    http2Stream2.unacknowledgedBytesRead = j11;
                                    if (errorCode == null && j11 >= ((long) (http2Stream2.connection.okHttpSettings.getInitialWindowSize() / 2))) {
                                        Http2Stream http2Stream3 = Http2Stream.this;
                                        http2Stream3.connection.writeWindowUpdateLater(http2Stream3.f1644id, http2Stream3.unacknowledgedBytesRead);
                                        Http2Stream.this.unacknowledgedBytesRead = 0;
                                    }
                                } else if (this.f1653e || errorCode != null) {
                                    read = -1;
                                } else {
                                    Http2Stream.this.waitForIo();
                                    Http2Stream.this.readTimeout.a();
                                }
                            } else {
                                throw new IOException("stream closed");
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                Http2Stream.this.readTimeout.a();
                if (read != -1) {
                    b(read);
                    return read;
                } else if (errorCode == null) {
                    return -1;
                } else {
                    throw new StreamResetException(errorCode);
                }
            } else {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
        }

        public Timeout timeout() {
            return Http2Stream.this.readTimeout;
        }
    }

    class c extends AsyncTimeout {
        c() {
        }

        public void a() {
            if (exit()) {
                throw newTimeoutException((IOException) null);
            }
        }

        /* access modifiers changed from: protected */
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.connection.sendDegradedPingLater();
        }
    }

    Http2Stream(int i10, Http2Connection http2Connection, boolean z10, boolean z11, Headers headers) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.headersQueue = arrayDeque;
        this.readTimeout = new c();
        this.writeTimeout = new c();
        this.errorCode = null;
        if (http2Connection != null) {
            this.f1644id = i10;
            this.connection = http2Connection;
            this.bytesLeftInWriteWindow = (long) http2Connection.peerSettings.getInitialWindowSize();
            b bVar = new b((long) http2Connection.okHttpSettings.getInitialWindowSize());
            this.source = bVar;
            a aVar = new a();
            this.sink = aVar;
            bVar.f1653e = z11;
            aVar.f1647c = z10;
            if (headers != null) {
                arrayDeque.add(headers);
            }
            if (isLocallyInitiated() && headers != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!isLocallyInitiated() && headers == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    private boolean closeInternal(ErrorCode errorCode2) {
        synchronized (this) {
            try {
                if (this.errorCode != null) {
                    return false;
                }
                if (this.source.f1653e && this.sink.f1647c) {
                    return false;
                }
                this.errorCode = errorCode2;
                notifyAll();
                this.connection.removeStream(this.f1644id);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void addBytesToWriteWindow(long j10) {
        this.bytesLeftInWriteWindow += j10;
        if (j10 > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelStreamIfNecessary() throws IOException {
        boolean z10;
        boolean isOpen;
        synchronized (this) {
            try {
                b bVar = this.source;
                if (!bVar.f1653e && bVar.f1652d) {
                    a aVar = this.sink;
                    if (!aVar.f1647c) {
                        if (aVar.f1646b) {
                        }
                    }
                    z10 = true;
                    isOpen = isOpen();
                }
                z10 = false;
                isOpen = isOpen();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (z10) {
            close(ErrorCode.CANCEL);
        } else if (!isOpen) {
            this.connection.removeStream(this.f1644id);
        }
    }

    /* access modifiers changed from: package-private */
    public void checkOutNotClosed() throws IOException {
        a aVar = this.sink;
        if (aVar.f1646b) {
            throw new IOException("stream closed");
        } else if (aVar.f1647c) {
            throw new IOException("stream finished");
        } else if (this.errorCode != null) {
            throw new StreamResetException(this.errorCode);
        }
    }

    public void close(ErrorCode errorCode2) throws IOException {
        if (closeInternal(errorCode2)) {
            this.connection.writeSynReset(this.f1644id, errorCode2);
        }
    }

    public void closeLater(ErrorCode errorCode2) {
        if (closeInternal(errorCode2)) {
            this.connection.writeSynResetLater(this.f1644id, errorCode2);
        }
    }

    public Http2Connection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public int getId() {
        return this.f1644id;
    }

    public Sink getSink() {
        synchronized (this) {
            try {
                if (!this.hasResponseHeaders) {
                    if (!isLocallyInitiated()) {
                        throw new IllegalStateException("reply before requesting the sink");
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return this.sink;
    }

    public Source getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        boolean z10;
        if ((this.f1644id & 1) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.connection.client == z10) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isOpen() {
        /*
            r3 = this;
            monitor-enter(r3)
            org.cocos2dx.okhttp3.internal.http2.ErrorCode r0 = r3.errorCode     // Catch:{ all -> 0x0013 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r3)
            return r1
        L_0x0008:
            org.cocos2dx.okhttp3.internal.http2.Http2Stream$b r0 = r3.source     // Catch:{ all -> 0x0013 }
            boolean r2 = r0.f1653e     // Catch:{ all -> 0x0013 }
            if (r2 != 0) goto L_0x0015
            boolean r0 = r0.f1652d     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0025
            goto L_0x0015
        L_0x0013:
            r0 = move-exception
            goto L_0x0028
        L_0x0015:
            org.cocos2dx.okhttp3.internal.http2.Http2Stream$a r0 = r3.sink     // Catch:{ all -> 0x0013 }
            boolean r2 = r0.f1647c     // Catch:{ all -> 0x0013 }
            if (r2 != 0) goto L_0x001f
            boolean r0 = r0.f1646b     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0025
        L_0x001f:
            boolean r0 = r3.hasResponseHeaders     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0025
            monitor-exit(r3)
            return r1
        L_0x0025:
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x0028:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.http2.Http2Stream.isOpen():boolean");
    }

    public Timeout readTimeout() {
        return this.readTimeout;
    }

    /* access modifiers changed from: package-private */
    public void receiveData(BufferedSource bufferedSource, int i10) throws IOException {
        this.source.a(bufferedSource, (long) i10);
    }

    /* access modifiers changed from: package-private */
    public void receiveFin() {
        boolean isOpen;
        synchronized (this) {
            this.source.f1653e = true;
            isOpen = isOpen();
            notifyAll();
        }
        if (!isOpen) {
            this.connection.removeStream(this.f1644id);
        }
    }

    /* access modifiers changed from: package-private */
    public void receiveHeaders(List<Header> list) {
        boolean isOpen;
        synchronized (this) {
            this.hasResponseHeaders = true;
            this.headersQueue.add(Util.toHeaders(list));
            isOpen = isOpen();
            notifyAll();
        }
        if (!isOpen) {
            this.connection.removeStream(this.f1644id);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void receiveRstStream(ErrorCode errorCode2) {
        if (this.errorCode == null) {
            this.errorCode = errorCode2;
            notifyAll();
        }
    }

    public synchronized void setHeadersListener(Header.a aVar) {
        if (!this.headersQueue.isEmpty() && aVar != null) {
            notifyAll();
        }
    }

    /* JADX INFO: finally extract failed */
    public synchronized Headers takeHeaders() throws IOException {
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                waitForIo();
            } catch (Throwable th) {
                this.readTimeout.a();
                throw th;
            }
        }
        this.readTimeout.a();
        if (!this.headersQueue.isEmpty()) {
        } else {
            throw new StreamResetException(this.errorCode);
        }
        return this.headersQueue.removeFirst();
    }

    /* access modifiers changed from: package-private */
    public void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public void writeHeaders(List<Header> list, boolean z10) throws IOException {
        boolean z11;
        boolean z12;
        boolean z13;
        if (list != null) {
            synchronized (this) {
                z11 = true;
                try {
                    this.hasResponseHeaders = true;
                    if (!z10) {
                        this.sink.f1647c = true;
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z13 = z12;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (!z12) {
                synchronized (this.connection) {
                    if (this.connection.bytesLeftInWriteWindow != 0) {
                        z11 = false;
                    }
                }
                z12 = z11;
            }
            this.connection.writeSynReply(this.f1644id, z13, list);
            if (z12) {
                this.connection.flush();
                return;
            }
            return;
        }
        throw new NullPointerException("headers == null");
    }

    public Timeout writeTimeout() {
        return this.writeTimeout;
    }
}
