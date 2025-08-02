package org.cocos2dx.okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.cocos2dx.okhttp3.Protocol;
import org.cocos2dx.okhttp3.internal.NamedRunnable;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.http2.b;
import org.cocos2dx.okhttp3.internal.platform.Platform;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSink;
import org.cocos2dx.okio.BufferedSource;
import org.cocos2dx.okio.ByteString;
import org.cocos2dx.okio.Okio;

public final class Http2Connection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int AWAIT_PING = 3;
    static final int DEGRADED_PING = 2;
    static final long DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    static final int INTERVAL_PING = 1;
    static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    /* access modifiers changed from: private */
    public static final ExecutorService listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
    private long awaitPingsSent = 0;
    private long awaitPongsReceived = 0;
    long bytesLeftInWriteWindow;
    final boolean client;
    final Set<Integer> currentPushRequests;
    private long degradedPingsSent = 0;
    private long degradedPongDeadlineNs = 0;
    private long degradedPongsReceived = 0;
    final String hostname;
    /* access modifiers changed from: private */
    public long intervalPingsSent = 0;
    /* access modifiers changed from: private */
    public long intervalPongsReceived = 0;
    int lastGoodStreamId;
    final Listener listener;
    int nextStreamId;
    Settings okHttpSettings = new Settings();
    final Settings peerSettings;
    private final ExecutorService pushExecutor;
    final PushObserver pushObserver;
    final j readerRunnable;
    /* access modifiers changed from: private */
    public boolean shutdown;
    final Socket socket;
    final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    long unacknowledgedBytesRead = 0;
    final c writer;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService writerExecutor;

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new a();

        class a extends Listener {
            a() {
            }

            public void onStream(Http2Stream http2Stream) {
                http2Stream.close(ErrorCode.REFUSED_STREAM);
            }
        }

        public void onSettings(Http2Connection http2Connection) {
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    class a extends NamedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1609a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ErrorCode f1610b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, int i10, ErrorCode errorCode) {
            super(str, objArr);
            this.f1609a = i10;
            this.f1610b = errorCode;
        }

        public void execute() {
            try {
                Http2Connection.this.writeSynReset(this.f1609a, this.f1610b);
            } catch (IOException unused) {
                Http2Connection.this.failConnection();
            }
        }
    }

    class b extends NamedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1612a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f1613b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, int i10, long j10) {
            super(str, objArr);
            this.f1612a = i10;
            this.f1613b = j10;
        }

        public void execute() {
            try {
                Http2Connection.this.writer.C(this.f1612a, this.f1613b);
            } catch (IOException unused) {
                Http2Connection.this.failConnection();
            }
        }
    }

    class c extends NamedRunnable {
        c(String str, Object... objArr) {
            super(str, objArr);
        }

        public void execute() {
            Http2Connection.this.writePing(false, 2, 0);
        }
    }

    class d extends NamedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1616a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f1617b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, int i10, List list) {
            super(str, objArr);
            this.f1616a = i10;
            this.f1617b = list;
        }

        public void execute() {
            if (Http2Connection.this.pushObserver.onRequest(this.f1616a, this.f1617b)) {
                try {
                    Http2Connection.this.writer.y(this.f1616a, ErrorCode.CANCEL);
                    synchronized (Http2Connection.this) {
                        Http2Connection.this.currentPushRequests.remove(Integer.valueOf(this.f1616a));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    class e extends NamedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1619a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f1620b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f1621c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, int i10, List list, boolean z10) {
            super(str, objArr);
            this.f1619a = i10;
            this.f1620b = list;
            this.f1621c = z10;
        }

        public void execute() {
            boolean onHeaders = Http2Connection.this.pushObserver.onHeaders(this.f1619a, this.f1620b, this.f1621c);
            if (onHeaders) {
                try {
                    Http2Connection.this.writer.y(this.f1619a, ErrorCode.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (onHeaders || this.f1621c) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.currentPushRequests.remove(Integer.valueOf(this.f1619a));
                }
            }
        }
    }

    class f extends NamedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1623a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Buffer f1624b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f1625c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f1626d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, int i10, Buffer buffer, int i11, boolean z10) {
            super(str, objArr);
            this.f1623a = i10;
            this.f1624b = buffer;
            this.f1625c = i11;
            this.f1626d = z10;
        }

        public void execute() {
            try {
                boolean onData = Http2Connection.this.pushObserver.onData(this.f1623a, this.f1624b, this.f1625c, this.f1626d);
                if (onData) {
                    Http2Connection.this.writer.y(this.f1623a, ErrorCode.CANCEL);
                }
                if (onData || this.f1626d) {
                    synchronized (Http2Connection.this) {
                        Http2Connection.this.currentPushRequests.remove(Integer.valueOf(this.f1623a));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    class g extends NamedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1628a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ErrorCode f1629b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(String str, Object[] objArr, int i10, ErrorCode errorCode) {
            super(str, objArr);
            this.f1628a = i10;
            this.f1629b = errorCode;
        }

        public void execute() {
            Http2Connection.this.pushObserver.onReset(this.f1628a, this.f1629b);
            synchronized (Http2Connection.this) {
                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(this.f1628a));
            }
        }
    }

    final class h extends NamedRunnable {
        h() {
            super("OkHttp %s ping", Http2Connection.this.hostname);
        }

        public void execute() {
            boolean z10;
            synchronized (Http2Connection.this) {
                if (Http2Connection.this.intervalPongsReceived < Http2Connection.this.intervalPingsSent) {
                    z10 = true;
                } else {
                    Http2Connection.access$208(Http2Connection.this);
                    z10 = false;
                }
            }
            if (z10) {
                Http2Connection.this.failConnection();
            } else {
                Http2Connection.this.writePing(false, 1, 0);
            }
        }
    }

    final class i extends NamedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final boolean f1632a;

        /* renamed from: b  reason: collision with root package name */
        final int f1633b;

        /* renamed from: c  reason: collision with root package name */
        final int f1634c;

        i(boolean z10, int i10, int i11) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.hostname, Integer.valueOf(i10), Integer.valueOf(i11));
            this.f1632a = z10;
            this.f1633b = i10;
            this.f1634c = i11;
        }

        public void execute() {
            Http2Connection.this.writePing(this.f1632a, this.f1633b, this.f1634c);
        }
    }

    class j extends NamedRunnable implements b.C0027b {

        /* renamed from: a  reason: collision with root package name */
        final b f1636a;

        class a extends NamedRunnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Http2Stream f1638a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str, Object[] objArr, Http2Stream http2Stream) {
                super(str, objArr);
                this.f1638a = http2Stream;
            }

            public void execute() {
                try {
                    Http2Connection.this.listener.onStream(this.f1638a);
                } catch (IOException e10) {
                    Platform platform = Platform.get();
                    platform.log(4, "Http2Connection.Listener failure for " + Http2Connection.this.hostname, e10);
                    try {
                        this.f1638a.close(ErrorCode.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        class b extends NamedRunnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f1640a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Settings f1641b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(String str, Object[] objArr, boolean z10, Settings settings) {
                super(str, objArr);
                this.f1640a = z10;
                this.f1641b = settings;
            }

            public void execute() {
                j.this.e(this.f1640a, this.f1641b);
            }
        }

        class c extends NamedRunnable {
            c(String str, Object... objArr) {
                super(str, objArr);
            }

            public void execute() {
                Http2Connection http2Connection = Http2Connection.this;
                http2Connection.listener.onSettings(http2Connection);
            }
        }

        j(b bVar) {
            super("OkHttp %s", Http2Connection.this.hostname);
            this.f1636a = bVar;
        }

        public void a(boolean z10, int i10, BufferedSource bufferedSource, int i11) {
            if (Http2Connection.this.pushedStream(i10)) {
                Http2Connection.this.pushDataLater(i10, bufferedSource, i11, z10);
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i10);
            if (stream == null) {
                Http2Connection.this.writeSynResetLater(i10, ErrorCode.PROTOCOL_ERROR);
                long j10 = (long) i11;
                Http2Connection.this.updateConnectionFlowControl(j10);
                bufferedSource.skip(j10);
                return;
            }
            stream.receiveData(bufferedSource, i11);
            if (z10) {
                stream.receiveFin();
            }
        }

        public void ackSettings() {
        }

        public void b(int i10, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                boolean unused = Http2Connection.this.shutdown = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i10 && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.removeStream(http2Stream.getId());
                }
            }
        }

        public void c(int i10, ErrorCode errorCode) {
            if (Http2Connection.this.pushedStream(i10)) {
                Http2Connection.this.pushResetLater(i10, errorCode);
                return;
            }
            Http2Stream removeStream = Http2Connection.this.removeStream(i10);
            if (removeStream != null) {
                removeStream.receiveRstStream(errorCode);
            }
        }

        public void d(boolean z10, Settings settings) {
            try {
                Http2Connection.this.writerExecutor.execute(new b("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.hostname}, z10, settings));
            } catch (RejectedExecutionException unused) {
            }
        }

        /* JADX WARNING: type inference failed for: r4v11, types: [java.lang.Object[]] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|9|19|20|22|23|24) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0069 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e(boolean r7, org.cocos2dx.okhttp3.internal.http2.Settings r8) {
            /*
                r6 = this;
                r0 = 1
                r1 = 0
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r2 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this
                org.cocos2dx.okhttp3.internal.http2.c r2 = r2.writer
                monitor-enter(r2)
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r3 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0067 }
                monitor-enter(r3)     // Catch:{ all -> 0x0067 }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r4 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x001c }
                org.cocos2dx.okhttp3.internal.http2.Settings r4 = r4.peerSettings     // Catch:{ all -> 0x001c }
                int r4 = r4.getInitialWindowSize()     // Catch:{ all -> 0x001c }
                if (r7 == 0) goto L_0x001f
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r7 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x001c }
                org.cocos2dx.okhttp3.internal.http2.Settings r7 = r7.peerSettings     // Catch:{ all -> 0x001c }
                r7.clear()     // Catch:{ all -> 0x001c }
                goto L_0x001f
            L_0x001c:
                r7 = move-exception
                goto L_0x0098
            L_0x001f:
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r7 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x001c }
                org.cocos2dx.okhttp3.internal.http2.Settings r7 = r7.peerSettings     // Catch:{ all -> 0x001c }
                r7.merge(r8)     // Catch:{ all -> 0x001c }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r7 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x001c }
                org.cocos2dx.okhttp3.internal.http2.Settings r7 = r7.peerSettings     // Catch:{ all -> 0x001c }
                int r7 = r7.getInitialWindowSize()     // Catch:{ all -> 0x001c }
                r8 = -1
                r5 = 0
                if (r7 == r8) goto L_0x005a
                if (r7 == r4) goto L_0x005a
                int r7 = r7 - r4
                long r7 = (long) r7     // Catch:{ all -> 0x001c }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r4 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x001c }
                java.util.Map<java.lang.Integer, org.cocos2dx.okhttp3.internal.http2.Http2Stream> r4 = r4.streams     // Catch:{ all -> 0x001c }
                boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x001c }
                if (r4 != 0) goto L_0x005c
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r4 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x001c }
                java.util.Map<java.lang.Integer, org.cocos2dx.okhttp3.internal.http2.Http2Stream> r4 = r4.streams     // Catch:{ all -> 0x001c }
                java.util.Collection r4 = r4.values()     // Catch:{ all -> 0x001c }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r5 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x001c }
                java.util.Map<java.lang.Integer, org.cocos2dx.okhttp3.internal.http2.Http2Stream> r5 = r5.streams     // Catch:{ all -> 0x001c }
                int r5 = r5.size()     // Catch:{ all -> 0x001c }
                org.cocos2dx.okhttp3.internal.http2.Http2Stream[] r5 = new org.cocos2dx.okhttp3.internal.http2.Http2Stream[r5]     // Catch:{ all -> 0x001c }
                java.lang.Object[] r4 = r4.toArray(r5)     // Catch:{ all -> 0x001c }
                r5 = r4
                org.cocos2dx.okhttp3.internal.http2.Http2Stream[] r5 = (org.cocos2dx.okhttp3.internal.http2.Http2Stream[]) r5     // Catch:{ all -> 0x001c }
                goto L_0x005c
            L_0x005a:
                r7 = 0
            L_0x005c:
                monitor-exit(r3)     // Catch:{ all -> 0x001c }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r3 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0069 }
                org.cocos2dx.okhttp3.internal.http2.c r4 = r3.writer     // Catch:{ IOException -> 0x0069 }
                org.cocos2dx.okhttp3.internal.http2.Settings r3 = r3.peerSettings     // Catch:{ IOException -> 0x0069 }
                r4.a(r3)     // Catch:{ IOException -> 0x0069 }
                goto L_0x006e
            L_0x0067:
                r7 = move-exception
                goto L_0x009a
            L_0x0069:
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r3 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0067 }
                r3.failConnection()     // Catch:{ all -> 0x0067 }
            L_0x006e:
                monitor-exit(r2)     // Catch:{ all -> 0x0067 }
                if (r5 == 0) goto L_0x0081
                int r2 = r5.length
                r3 = r1
            L_0x0073:
                if (r3 >= r2) goto L_0x0081
                r4 = r5[r3]
                monitor-enter(r4)
                r4.addBytesToWriteWindow(r7)     // Catch:{ all -> 0x007e }
                monitor-exit(r4)     // Catch:{ all -> 0x007e }
                int r3 = r3 + r0
                goto L_0x0073
            L_0x007e:
                r7 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x007e }
                throw r7
            L_0x0081:
                java.util.concurrent.ExecutorService r7 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.listenerExecutor
                org.cocos2dx.okhttp3.internal.http2.Http2Connection$j$c r8 = new org.cocos2dx.okhttp3.internal.http2.Http2Connection$j$c
                java.lang.String r2 = "OkHttp %s settings"
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r3 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this
                java.lang.String r3 = r3.hostname
                java.lang.Object[] r0 = new java.lang.Object[r0]
                r0[r1] = r3
                r8.<init>(r2, r0)
                r7.execute(r8)
                return
            L_0x0098:
                monitor-exit(r3)     // Catch:{ all -> 0x001c }
                throw r7     // Catch:{ all -> 0x0067 }
            L_0x009a:
                monitor-exit(r2)     // Catch:{ all -> 0x0067 }
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.http2.Http2Connection.j.e(boolean, org.cocos2dx.okhttp3.internal.http2.Settings):void");
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|20|21) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r0 = org.cocos2dx.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r4.f1637b.close(r0, r0);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0026 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r4 = this;
                org.cocos2dx.okhttp3.internal.http2.ErrorCode r0 = org.cocos2dx.okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR
                org.cocos2dx.okhttp3.internal.http2.b r1 = r4.f1636a     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                r1.h(r4)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
            L_0x0007:
                org.cocos2dx.okhttp3.internal.http2.b r1 = r4.f1636a     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                r2 = 0
                boolean r1 = r1.b(r2, r4)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                if (r1 == 0) goto L_0x0011
                goto L_0x0007
            L_0x0011:
                org.cocos2dx.okhttp3.internal.http2.ErrorCode r1 = org.cocos2dx.okhttp3.internal.http2.ErrorCode.NO_ERROR     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                org.cocos2dx.okhttp3.internal.http2.ErrorCode r0 = org.cocos2dx.okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x0026 }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r2 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x001a }
                r2.close(r1, r0)     // Catch:{ IOException -> 0x001a }
            L_0x001a:
                org.cocos2dx.okhttp3.internal.http2.b r0 = r4.f1636a
                org.cocos2dx.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
                goto L_0x002e
            L_0x0020:
                r2 = move-exception
                goto L_0x002f
            L_0x0022:
                r2 = move-exception
                r1 = r0
                goto L_0x002f
            L_0x0025:
                r1 = r0
            L_0x0026:
                org.cocos2dx.okhttp3.internal.http2.ErrorCode r0 = org.cocos2dx.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x0020 }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r1 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x001a }
                r1.close(r0, r0)     // Catch:{ IOException -> 0x001a }
                goto L_0x001a
            L_0x002e:
                return
            L_0x002f:
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r3 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0034 }
                r3.close(r1, r0)     // Catch:{ IOException -> 0x0034 }
            L_0x0034:
                org.cocos2dx.okhttp3.internal.http2.b r0 = r4.f1636a
                org.cocos2dx.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.http2.Http2Connection.j.execute():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0074, code lost:
            r1.receiveHeaders(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0077, code lost:
            if (r8 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0079, code lost:
            r1.receiveFin();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void headers(boolean r8, int r9, int r10, java.util.List r11) {
            /*
                r7 = this;
                r10 = 2
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r0 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this
                boolean r0 = r0.pushedStream(r9)
                if (r0 == 0) goto L_0x000f
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r10 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this
                r10.pushHeadersLater(r9, r11, r8)
                return
            L_0x000f:
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r0 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this
                monitor-enter(r0)
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r1 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0024 }
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r1 = r1.getStream(r9)     // Catch:{ all -> 0x0024 }
                if (r1 != 0) goto L_0x0073
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r1 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0024 }
                boolean r1 = r1.shutdown     // Catch:{ all -> 0x0024 }
                if (r1 == 0) goto L_0x0026
                monitor-exit(r0)     // Catch:{ all -> 0x0024 }
                return
            L_0x0024:
                r8 = move-exception
                goto L_0x007d
            L_0x0026:
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r1 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0024 }
                int r2 = r1.lastGoodStreamId     // Catch:{ all -> 0x0024 }
                if (r9 > r2) goto L_0x002e
                monitor-exit(r0)     // Catch:{ all -> 0x0024 }
                return
            L_0x002e:
                int r2 = r9 % 2
                int r1 = r1.nextStreamId     // Catch:{ all -> 0x0024 }
                int r1 = r1 % r10
                if (r2 != r1) goto L_0x0037
                monitor-exit(r0)     // Catch:{ all -> 0x0024 }
                return
            L_0x0037:
                org.cocos2dx.okhttp3.Headers r6 = org.cocos2dx.okhttp3.internal.Util.toHeaders(r11)     // Catch:{ all -> 0x0024 }
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r11 = new org.cocos2dx.okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x0024 }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r3 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0024 }
                r4 = 0
                r1 = r11
                r2 = r9
                r5 = r8
                r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0024 }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r8 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0024 }
                r8.lastGoodStreamId = r9     // Catch:{ all -> 0x0024 }
                java.util.Map<java.lang.Integer, org.cocos2dx.okhttp3.internal.http2.Http2Stream> r8 = r8.streams     // Catch:{ all -> 0x0024 }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0024 }
                r8.put(r1, r11)     // Catch:{ all -> 0x0024 }
                java.util.concurrent.ExecutorService r8 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.listenerExecutor     // Catch:{ all -> 0x0024 }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection$j$a r1 = new org.cocos2dx.okhttp3.internal.http2.Http2Connection$j$a     // Catch:{ all -> 0x0024 }
                java.lang.String r2 = "OkHttp %s stream %d"
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r3 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0024 }
                java.lang.String r3 = r3.hostname     // Catch:{ all -> 0x0024 }
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0024 }
                java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ all -> 0x0024 }
                r4 = 0
                r10[r4] = r3     // Catch:{ all -> 0x0024 }
                r3 = 1
                r10[r3] = r9     // Catch:{ all -> 0x0024 }
                r1.<init>(r2, r10, r11)     // Catch:{ all -> 0x0024 }
                r8.execute(r1)     // Catch:{ all -> 0x0024 }
                monitor-exit(r0)     // Catch:{ all -> 0x0024 }
                return
            L_0x0073:
                monitor-exit(r0)     // Catch:{ all -> 0x0024 }
                r1.receiveHeaders(r11)
                if (r8 == 0) goto L_0x007c
                r1.receiveFin()
            L_0x007c:
                return
            L_0x007d:
                monitor-exit(r0)     // Catch:{ all -> 0x0024 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.http2.Http2Connection.j.headers(boolean, int, int, java.util.List):void");
        }

        public void ping(boolean z10, int i10, int i11) {
            if (z10) {
                synchronized (Http2Connection.this) {
                    if (i10 == 1) {
                        try {
                            Http2Connection.access$108(Http2Connection.this);
                        } catch (Throwable th) {
                            throw th;
                        }
                    } else if (i10 == 2) {
                        Http2Connection.access$608(Http2Connection.this);
                    } else if (i10 == 3) {
                        Http2Connection.access$708(Http2Connection.this);
                        Http2Connection.this.notifyAll();
                    }
                }
                return;
            }
            try {
                Http2Connection.this.writerExecutor.execute(new i(true, i10, i11));
            } catch (RejectedExecutionException unused) {
            }
        }

        public void priority(int i10, int i11, int i12, boolean z10) {
        }

        public void pushPromise(int i10, int i11, List list) {
            Http2Connection.this.pushRequestLater(i11, list);
        }

        public void windowUpdate(int i10, long j10) {
            if (i10 == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.bytesLeftInWriteWindow += j10;
                    http2Connection.notifyAll();
                }
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i10);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j10);
                }
            }
        }
    }

    Http2Connection(Builder builder) {
        int i10;
        Builder builder2 = builder;
        Settings settings = new Settings();
        this.peerSettings = settings;
        this.currentPushRequests = new LinkedHashSet();
        this.pushObserver = builder2.pushObserver;
        boolean z10 = builder2.client;
        this.client = z10;
        this.listener = builder2.listener;
        if (z10) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        this.nextStreamId = i10;
        if (z10) {
            this.nextStreamId = i10 + 2;
        }
        if (z10) {
            this.okHttpSettings.set(7, 16777216);
        }
        String str = builder2.hostname;
        this.hostname = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", str), false));
        this.writerExecutor = scheduledThreadPoolExecutor;
        if (builder2.pingIntervalMillis != 0) {
            h hVar = new h();
            int i11 = builder2.pingIntervalMillis;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(hVar, (long) i11, (long) i11, TimeUnit.MILLISECONDS);
        }
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", str), true));
        settings.set(7, 65535);
        settings.set(5, 16384);
        this.bytesLeftInWriteWindow = (long) settings.getInitialWindowSize();
        this.socket = builder2.socket;
        this.writer = new c(builder2.sink, z10);
        this.readerRunnable = new j(new b(builder2.source, z10));
    }

    static /* synthetic */ long access$108(Http2Connection http2Connection) {
        long j10 = http2Connection.intervalPongsReceived;
        http2Connection.intervalPongsReceived = 1 + j10;
        return j10;
    }

    static /* synthetic */ long access$208(Http2Connection http2Connection) {
        long j10 = http2Connection.intervalPingsSent;
        http2Connection.intervalPingsSent = 1 + j10;
        return j10;
    }

    static /* synthetic */ long access$608(Http2Connection http2Connection) {
        long j10 = http2Connection.degradedPongsReceived;
        http2Connection.degradedPongsReceived = 1 + j10;
        return j10;
    }

    static /* synthetic */ long access$708(Http2Connection http2Connection) {
        long j10 = http2Connection.awaitPongsReceived;
        http2Connection.awaitPongsReceived = 1 + j10;
        return j10;
    }

    /* access modifiers changed from: private */
    public void failConnection() {
        try {
            ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
            close(errorCode, errorCode);
        } catch (IOException unused) {
        }
    }

    private synchronized void pushExecutorExecute(NamedRunnable namedRunnable) {
        if (!this.shutdown) {
            this.pushExecutor.execute(namedRunnable);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    public void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush() throws IOException {
        this.writer.flush();
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    /* access modifiers changed from: package-private */
    public synchronized Http2Stream getStream(int i10) {
        return this.streams.get(Integer.valueOf(i10));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001b, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isHealthy(long r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.shutdown     // Catch:{ all -> 0x0018 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r6)
            return r1
        L_0x0008:
            long r2 = r6.degradedPongsReceived     // Catch:{ all -> 0x0018 }
            long r4 = r6.degradedPingsSent     // Catch:{ all -> 0x0018 }
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x001a
            long r2 = r6.degradedPongDeadlineNs     // Catch:{ all -> 0x0018 }
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 < 0) goto L_0x001a
            monitor-exit(r6)
            return r1
        L_0x0018:
            r7 = move-exception
            goto L_0x001d
        L_0x001a:
            monitor-exit(r6)
            r7 = 1
            return r7
        L_0x001d:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.http2.Http2Connection.isHealthy(long):boolean");
    }

    public synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
    }

    public Http2Stream newStream(List<Header> list, boolean z10) throws IOException {
        return newStream(0, list, z10);
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    /* access modifiers changed from: package-private */
    public void pushDataLater(int i10, BufferedSource bufferedSource, int i11, boolean z10) throws IOException {
        Buffer buffer = new Buffer();
        long j10 = (long) i11;
        bufferedSource.require(j10);
        bufferedSource.read(buffer, j10);
        if (buffer.size() == j10) {
            pushExecutorExecute(new f("OkHttp %s Push Data[%s]", new Object[]{this.hostname, Integer.valueOf(i10)}, i10, buffer, i11, z10));
            return;
        }
        throw new IOException(buffer.size() + " != " + i11);
    }

    /* access modifiers changed from: package-private */
    public void pushHeadersLater(int i10, List<Header> list, boolean z10) {
        try {
            pushExecutorExecute(new e("OkHttp %s Push Headers[%s]", new Object[]{this.hostname, Integer.valueOf(i10)}, i10, list, z10));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void pushRequestLater(int i10, List<Header> list) {
        synchronized (this) {
            try {
                if (this.currentPushRequests.contains(Integer.valueOf(i10))) {
                    writeSynResetLater(i10, ErrorCode.PROTOCOL_ERROR);
                    return;
                }
                this.currentPushRequests.add(Integer.valueOf(i10));
                try {
                    pushExecutorExecute(new d("OkHttp %s Push Request[%s]", new Object[]{this.hostname, Integer.valueOf(i10)}, i10, list));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void pushResetLater(int i10, ErrorCode errorCode) {
        pushExecutorExecute(new g("OkHttp %s Push Reset[%s]", new Object[]{this.hostname, Integer.valueOf(i10)}, i10, errorCode));
    }

    public Http2Stream pushStream(int i10, List<Header> list, boolean z10) throws IOException {
        if (!this.client) {
            return newStream(i10, list, z10);
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    /* access modifiers changed from: package-private */
    public boolean pushedStream(int i10) {
        return i10 != 0 && (i10 & 1) == 0;
    }

    /* access modifiers changed from: package-private */
    public synchronized Http2Stream removeStream(int i10) {
        Http2Stream remove;
        remove = this.streams.remove(Integer.valueOf(i10));
        notifyAll();
        return remove;
    }

    /* access modifiers changed from: package-private */
    public void sendDegradedPingLater() {
        synchronized (this) {
            try {
                long j10 = this.degradedPongsReceived;
                long j11 = this.degradedPingsSent;
                if (j10 >= j11) {
                    this.degradedPingsSent = j11 + 1;
                    this.degradedPongDeadlineNs = System.nanoTime() + DEGRADED_PONG_TIMEOUT_NS;
                    try {
                        this.writerExecutor.execute(new c("OkHttp %s ping", this.hostname));
                    } catch (RejectedExecutionException unused) {
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public void setSettings(Settings settings) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.okHttpSettings.merge(settings);
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.writer.z(settings);
        }
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.shutdown = true;
                    int i10 = this.lastGoodStreamId;
                    this.writer.m(i10, errorCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public void start() throws IOException {
        start(true);
    }

    /* access modifiers changed from: package-private */
    public synchronized void updateConnectionFlowControl(long j10) {
        long j11 = this.unacknowledgedBytesRead + j10;
        this.unacknowledgedBytesRead = j11;
        if (j11 >= ((long) (this.okHttpSettings.getInitialWindowSize() / 2))) {
            writeWindowUpdateLater(0, this.unacknowledgedBytesRead);
            this.unacknowledgedBytesRead = 0;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:27|28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.writer.p());
        r6 = (long) r2;
        r8.bytesLeftInWriteWindow -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeData(int r9, boolean r10, org.cocos2dx.okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto L_0x000d
            org.cocos2dx.okhttp3.internal.http2.c r12 = r8.writer
            r12.h(r10, r9, r11, r3)
            return
        L_0x000d:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0067
            monitor-enter(r8)
        L_0x0012:
            long r4 = r8.bytesLeftInWriteWindow     // Catch:{ InterruptedException -> 0x0058 }
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0032
            java.util.Map<java.lang.Integer, org.cocos2dx.okhttp3.internal.http2.Http2Stream> r2 = r8.streams     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x0058 }
            boolean r2 = r2.containsKey(r4)     // Catch:{ InterruptedException -> 0x0058 }
            if (r2 == 0) goto L_0x002a
            r8.wait()     // Catch:{ InterruptedException -> 0x0058 }
            goto L_0x0012
        L_0x0028:
            r9 = move-exception
            goto L_0x0065
        L_0x002a:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x0058 }
            throw r9     // Catch:{ InterruptedException -> 0x0058 }
        L_0x0032:
            long r4 = java.lang.Math.min(r12, r4)     // Catch:{ all -> 0x0028 }
            int r2 = (int) r4     // Catch:{ all -> 0x0028 }
            org.cocos2dx.okhttp3.internal.http2.c r4 = r8.writer     // Catch:{ all -> 0x0028 }
            int r4 = r4.p()     // Catch:{ all -> 0x0028 }
            int r2 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x0028 }
            long r4 = r8.bytesLeftInWriteWindow     // Catch:{ all -> 0x0028 }
            long r6 = (long) r2     // Catch:{ all -> 0x0028 }
            long r4 = r4 - r6
            r8.bytesLeftInWriteWindow = r4     // Catch:{ all -> 0x0028 }
            monitor-exit(r8)     // Catch:{ all -> 0x0028 }
            long r12 = r12 - r6
            org.cocos2dx.okhttp3.internal.http2.c r4 = r8.writer
            if (r10 == 0) goto L_0x0053
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x0053
            r5 = 1
            goto L_0x0054
        L_0x0053:
            r5 = r3
        L_0x0054:
            r4.h(r5, r9, r11, r2)
            goto L_0x000d
        L_0x0058:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0028 }
            r9.interrupt()     // Catch:{ all -> 0x0028 }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0028 }
            r9.<init>()     // Catch:{ all -> 0x0028 }
            throw r9     // Catch:{ all -> 0x0028 }
        L_0x0065:
            monitor-exit(r8)     // Catch:{ all -> 0x0028 }
            throw r9
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.http2.Http2Connection.writeData(int, boolean, org.cocos2dx.okio.Buffer, long):void");
    }

    /* access modifiers changed from: package-private */
    public void writePing(boolean z10, int i10, int i11) {
        try {
            this.writer.v(z10, i10, i11);
        } catch (IOException unused) {
            failConnection();
        }
    }

    /* access modifiers changed from: package-private */
    public void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    /* access modifiers changed from: package-private */
    public void writeSynReply(int i10, boolean z10, List<Header> list) throws IOException {
        this.writer.A(z10, i10, list);
    }

    /* access modifiers changed from: package-private */
    public void writeSynReset(int i10, ErrorCode errorCode) throws IOException {
        this.writer.y(i10, errorCode);
    }

    /* access modifiers changed from: package-private */
    public void writeSynResetLater(int i10, ErrorCode errorCode) {
        try {
            this.writerExecutor.execute(new a("OkHttp %s stream %d", new Object[]{this.hostname, Integer.valueOf(i10)}, i10, errorCode));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void writeWindowUpdateLater(int i10, long j10) {
        try {
            this.writerExecutor.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.hostname, Integer.valueOf(i10)}, i10, j10));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[Catch:{ all -> 0x0013, all -> 0x0056 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.cocos2dx.okhttp3.internal.http2.Http2Stream newStream(int r11, java.util.List<org.cocos2dx.okhttp3.internal.http2.Header> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            org.cocos2dx.okhttp3.internal.http2.c r7 = r10.writer
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0056 }
            int r0 = r10.nextStreamId     // Catch:{ all -> 0x0013 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0015
            org.cocos2dx.okhttp3.internal.http2.ErrorCode r0 = org.cocos2dx.okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0013 }
            r10.shutdown(r0)     // Catch:{ all -> 0x0013 }
            goto L_0x0015
        L_0x0013:
            r11 = move-exception
            goto L_0x0078
        L_0x0015:
            boolean r0 = r10.shutdown     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x0072
            int r8 = r10.nextStreamId     // Catch:{ all -> 0x0013 }
            int r0 = r8 + 2
            r10.nextStreamId = r0     // Catch:{ all -> 0x0013 }
            org.cocos2dx.okhttp3.internal.http2.Http2Stream r9 = new org.cocos2dx.okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x0013 }
            r5 = 0
            r4 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0013 }
            if (r13 == 0) goto L_0x003d
            long r0 = r10.bytesLeftInWriteWindow     // Catch:{ all -> 0x0013 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x003d
            long r0 = r9.bytesLeftInWriteWindow     // Catch:{ all -> 0x0013 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r13 = 0
            goto L_0x003e
        L_0x003d:
            r13 = 1
        L_0x003e:
            boolean r0 = r9.isOpen()     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x004d
            java.util.Map<java.lang.Integer, org.cocos2dx.okhttp3.internal.http2.Http2Stream> r0 = r10.streams     // Catch:{ all -> 0x0013 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0013 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0013 }
        L_0x004d:
            monitor-exit(r10)     // Catch:{ all -> 0x0013 }
            if (r11 != 0) goto L_0x0058
            org.cocos2dx.okhttp3.internal.http2.c r0 = r10.writer     // Catch:{ all -> 0x0056 }
            r0.B(r6, r8, r11, r12)     // Catch:{ all -> 0x0056 }
            goto L_0x0061
        L_0x0056:
            r11 = move-exception
            goto L_0x007a
        L_0x0058:
            boolean r0 = r10.client     // Catch:{ all -> 0x0056 }
            if (r0 != 0) goto L_0x006a
            org.cocos2dx.okhttp3.internal.http2.c r0 = r10.writer     // Catch:{ all -> 0x0056 }
            r0.w(r11, r8, r12)     // Catch:{ all -> 0x0056 }
        L_0x0061:
            monitor-exit(r7)     // Catch:{ all -> 0x0056 }
            if (r13 == 0) goto L_0x0069
            org.cocos2dx.okhttp3.internal.http2.c r11 = r10.writer
            r11.flush()
        L_0x0069:
            return r9
        L_0x006a:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0056 }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x0056 }
            throw r11     // Catch:{ all -> 0x0056 }
        L_0x0072:
            org.cocos2dx.okhttp3.internal.http2.ConnectionShutdownException r11 = new org.cocos2dx.okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0013 }
            r11.<init>()     // Catch:{ all -> 0x0013 }
            throw r11     // Catch:{ all -> 0x0013 }
        L_0x0078:
            monitor-exit(r10)     // Catch:{ all -> 0x0013 }
            throw r11     // Catch:{ all -> 0x0056 }
        L_0x007a:
            monitor-exit(r7)     // Catch:{ all -> 0x0056 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.http2.Http2Connection.newStream(int, java.util.List, boolean):org.cocos2dx.okhttp3.internal.http2.Http2Stream");
    }

    /* access modifiers changed from: package-private */
    public void close(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        Http2Stream[] http2StreamArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e10) {
            e = e10;
        }
        synchronized (this) {
            try {
                if (!this.streams.isEmpty()) {
                    http2StreamArr = (Http2Stream[]) this.streams.values().toArray(new Http2Stream[this.streams.size()]);
                    this.streams.clear();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream close : http2StreamArr) {
                try {
                    close.close(errorCode2);
                } catch (IOException e11) {
                    if (e != null) {
                        e = e11;
                    }
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException e12) {
            if (e == null) {
                e = e12;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e13) {
            e = e13;
        }
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public void start(boolean z10) throws IOException {
        if (z10) {
            this.writer.b();
            this.writer.z(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.C(0, (long) (initialWindowSize - 65535));
            }
        }
        new Thread(this.readerRunnable).start();
    }

    public static class Builder {
        boolean client;
        String hostname;
        Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        int pingIntervalMillis;
        PushObserver pushObserver = PushObserver.CANCEL;
        BufferedSink sink;
        Socket socket;
        BufferedSource source;

        public Builder(boolean z10) {
            this.client = z10;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }

        public Builder listener(Listener listener2) {
            this.listener = listener2;
            return this;
        }

        public Builder pingIntervalMillis(int i10) {
            this.pingIntervalMillis = i10;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver2) {
            this.pushObserver = pushObserver2;
            return this;
        }

        public Builder socket(Socket socket2) throws IOException {
            return socket(socket2, ((InetSocketAddress) socket2.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket2)), Okio.buffer(Okio.sink(socket2)));
        }

        public Builder socket(Socket socket2, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket2;
            this.hostname = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public void writePing() {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }
}
