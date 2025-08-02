package org.cocos2dx.okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.cocos2dx.okhttp3.Headers;
import org.cocos2dx.okhttp3.Request;
import org.cocos2dx.okhttp3.Response;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.cache.CacheRequest;
import org.cocos2dx.okhttp3.internal.cache.CacheStrategy;
import org.cocos2dx.okhttp3.internal.cache.DiskLruCache;
import org.cocos2dx.okhttp3.internal.cache.InternalCache;
import org.cocos2dx.okhttp3.internal.http.HttpHeaders;
import org.cocos2dx.okhttp3.internal.http.HttpMethod;
import org.cocos2dx.okhttp3.internal.http.StatusLine;
import org.cocos2dx.okhttp3.internal.io.FileSystem;
import org.cocos2dx.okhttp3.internal.platform.Platform;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSink;
import org.cocos2dx.okio.BufferedSource;
import org.cocos2dx.okio.ByteString;
import org.cocos2dx.okio.ForwardingSink;
import org.cocos2dx.okio.ForwardingSource;
import org.cocos2dx.okio.Okio;
import org.cocos2dx.okio.Sink;
import org.cocos2dx.okio.Source;

public final class Cache implements Closeable, Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    int writeAbortCount;
    int writeSuccessCount;

    class a implements InternalCache {
        a() {
        }

        public Response get(Request request) {
            return Cache.this.get(request);
        }

        public CacheRequest put(Response response) {
            return Cache.this.put(response);
        }

        public void remove(Request request) {
            Cache.this.remove(request);
        }

        public void trackConditionalCacheHit() {
            Cache.this.trackConditionalCacheHit();
        }

        public void trackResponse(CacheStrategy cacheStrategy) {
            Cache.this.trackResponse(cacheStrategy);
        }

        public void update(Response response, Response response2) {
            Cache.this.update(response, response2);
        }
    }

    class b implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        final Iterator f1500a;

        /* renamed from: b  reason: collision with root package name */
        String f1501b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1502c;

        b() {
            this.f1500a = Cache.this.cache.snapshots();
        }

        /* renamed from: a */
        public String next() {
            if (hasNext()) {
                String str = this.f1501b;
                this.f1501b = null;
                this.f1502c = true;
                return str;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f1501b != null) {
                return true;
            }
            this.f1502c = false;
            while (this.f1500a.hasNext()) {
                DiskLruCache.Snapshot snapshot = (DiskLruCache.Snapshot) this.f1500a.next();
                try {
                    this.f1501b = Okio.buffer(snapshot.getSource(0)).readUtf8LineStrict();
                    return true;
                } catch (IOException unused) {
                } finally {
                    snapshot.close();
                }
            }
            return false;
        }

        public void remove() {
            if (this.f1502c) {
                this.f1500a.remove();
                return;
            }
            throw new IllegalStateException("remove() before next()");
        }
    }

    private final class c implements CacheRequest {

        /* renamed from: a  reason: collision with root package name */
        private final DiskLruCache.Editor f1504a;

        /* renamed from: b  reason: collision with root package name */
        private Sink f1505b;

        /* renamed from: c  reason: collision with root package name */
        private Sink f1506c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1507d;

        class a extends ForwardingSink {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Cache f1509a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ DiskLruCache.Editor f1510b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Sink sink, Cache cache, DiskLruCache.Editor editor) {
                super(sink);
                this.f1509a = cache;
                this.f1510b = editor;
            }

            public void close() {
                synchronized (Cache.this) {
                    try {
                        c cVar = c.this;
                        if (!cVar.f1507d) {
                            cVar.f1507d = true;
                            Cache.this.writeSuccessCount++;
                            super.close();
                            this.f1510b.commit();
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
        }

        c(DiskLruCache.Editor editor) {
            this.f1504a = editor;
            Sink newSink = editor.newSink(1);
            this.f1505b = newSink;
            this.f1506c = new a(newSink, Cache.this, editor);
        }

        public void abort() {
            synchronized (Cache.this) {
                try {
                    if (!this.f1507d) {
                        this.f1507d = true;
                        Cache.this.writeAbortCount++;
                        Util.closeQuietly((Closeable) this.f1505b);
                        try {
                            this.f1504a.abort();
                        } catch (IOException unused) {
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public Sink body() {
            return this.f1506c;
        }
    }

    private static class d extends ResponseBody {

        /* renamed from: a  reason: collision with root package name */
        final DiskLruCache.Snapshot f1512a;

        /* renamed from: b  reason: collision with root package name */
        private final BufferedSource f1513b;

        /* renamed from: c  reason: collision with root package name */
        private final String f1514c;

        /* renamed from: d  reason: collision with root package name */
        private final String f1515d;

        class a extends ForwardingSource {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ DiskLruCache.Snapshot f1516a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Source source, DiskLruCache.Snapshot snapshot) {
                super(source);
                this.f1516a = snapshot;
            }

            public void close() {
                this.f1516a.close();
                super.close();
            }
        }

        d(DiskLruCache.Snapshot snapshot, String str, String str2) {
            this.f1512a = snapshot;
            this.f1514c = str;
            this.f1515d = str2;
            this.f1513b = Okio.buffer((Source) new a(snapshot.getSource(1), snapshot));
        }

        public long contentLength() {
            try {
                String str = this.f1515d;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public MediaType contentType() {
            String str = this.f1514c;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        public BufferedSource source() {
            return this.f1513b;
        }
    }

    public Cache(File file, long j10) {
        this(file, j10, FileSystem.SYSTEM);
    }

    private void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static String key(HttpUrl httpUrl) {
        return ByteString.encodeUtf8(httpUrl.toString()).md5().hex();
    }

    static int readInt(BufferedSource bufferedSource) throws IOException {
        try {
            long readDecimalLong = bufferedSource.readDecimalLong();
            String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L && readUtf8LineStrict.isEmpty()) {
                return (int) readDecimalLong;
            }
            throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + "\"");
        } catch (NumberFormatException e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public void close() throws IOException {
        this.cache.close();
    }

    public void delete() throws IOException {
        this.cache.delete();
    }

    public File directory() {
        return this.cache.getDirectory();
    }

    public void evictAll() throws IOException {
        this.cache.evictAll();
    }

    public void flush() throws IOException {
        this.cache.flush();
    }

    /* access modifiers changed from: package-private */
    public Response get(Request request) {
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                e eVar = new e(snapshot.getSource(0));
                Response d10 = eVar.d(snapshot);
                if (eVar.b(request, d10)) {
                    return d10;
                }
                Util.closeQuietly((Closeable) d10.body());
                return null;
            } catch (IOException unused) {
                Util.closeQuietly((Closeable) snapshot);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public synchronized int hitCount() {
        return this.hitCount;
    }

    public void initialize() throws IOException {
        this.cache.initialize();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    public long maxSize() {
        return this.cache.getMaxSize();
    }

    public synchronized int networkCount() {
        return this.networkCount;
    }

    /* access modifiers changed from: package-private */
    public CacheRequest put(Response response) {
        DiskLruCache.Editor editor;
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!method.equals("GET") || HttpHeaders.hasVaryAll(response)) {
            return null;
        } else {
            e eVar = new e(response);
            try {
                editor = this.cache.edit(key(response.request().url()));
                if (editor == null) {
                    return null;
                }
                try {
                    eVar.f(editor);
                    return new c(editor);
                } catch (IOException unused2) {
                    abortQuietly(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
                abortQuietly(editor);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void remove(Request request) throws IOException {
        this.cache.remove(key(request.url()));
    }

    public synchronized int requestCount() {
        return this.requestCount;
    }

    public long size() throws IOException {
        return this.cache.size();
    }

    /* access modifiers changed from: package-private */
    public synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    /* access modifiers changed from: package-private */
    public synchronized void trackResponse(CacheStrategy cacheStrategy) {
        try {
            this.requestCount++;
            if (cacheStrategy.networkRequest != null) {
                this.networkCount++;
            } else if (cacheStrategy.cacheResponse != null) {
                this.hitCount++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void update(Response response, Response response2) {
        DiskLruCache.Editor editor;
        e eVar = new e(response2);
        try {
            editor = ((d) response.body()).f1512a.edit();
            if (editor != null) {
                try {
                    eVar.f(editor);
                    editor.commit();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            editor = null;
            abortQuietly(editor);
        }
    }

    public Iterator<String> urls() throws IOException {
        return new b();
    }

    public synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    Cache(File file, long j10, FileSystem fileSystem) {
        this.internalCache = new a();
        this.cache = DiskLruCache.create(fileSystem, file, VERSION, 2, j10);
    }

    private static final class e {

        /* renamed from: k  reason: collision with root package name */
        private static final String f1518k = (Platform.get().getPrefix() + "-Sent-Millis");

        /* renamed from: l  reason: collision with root package name */
        private static final String f1519l = (Platform.get().getPrefix() + "-Received-Millis");

        /* renamed from: a  reason: collision with root package name */
        private final String f1520a;

        /* renamed from: b  reason: collision with root package name */
        private final Headers f1521b;

        /* renamed from: c  reason: collision with root package name */
        private final String f1522c;

        /* renamed from: d  reason: collision with root package name */
        private final Protocol f1523d;

        /* renamed from: e  reason: collision with root package name */
        private final int f1524e;

        /* renamed from: f  reason: collision with root package name */
        private final String f1525f;

        /* renamed from: g  reason: collision with root package name */
        private final Headers f1526g;

        /* renamed from: h  reason: collision with root package name */
        private final Handshake f1527h;

        /* renamed from: i  reason: collision with root package name */
        private final long f1528i;

        /* renamed from: j  reason: collision with root package name */
        private final long f1529j;

        e(Source source) {
            TlsVersion tlsVersion;
            try {
                BufferedSource buffer = Okio.buffer(source);
                this.f1520a = buffer.readUtf8LineStrict();
                this.f1522c = buffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int readInt = Cache.readInt(buffer);
                for (int i10 = 0; i10 < readInt; i10++) {
                    builder.addLenient(buffer.readUtf8LineStrict());
                }
                this.f1521b = builder.build();
                StatusLine parse = StatusLine.parse(buffer.readUtf8LineStrict());
                this.f1523d = parse.protocol;
                this.f1524e = parse.code;
                this.f1525f = parse.message;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt2 = Cache.readInt(buffer);
                for (int i11 = 0; i11 < readInt2; i11++) {
                    builder2.addLenient(buffer.readUtf8LineStrict());
                }
                String str = f1518k;
                String str2 = builder2.get(str);
                String str3 = f1519l;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                long j10 = 0;
                this.f1528i = str2 != null ? Long.parseLong(str2) : 0;
                this.f1529j = str4 != null ? Long.parseLong(str4) : j10;
                this.f1526g = builder2.build();
                if (a()) {
                    String readUtf8LineStrict = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() <= 0) {
                        CipherSuite forJavaName = CipherSuite.forJavaName(buffer.readUtf8LineStrict());
                        List c10 = c(buffer);
                        List c11 = c(buffer);
                        if (!buffer.exhausted()) {
                            tlsVersion = TlsVersion.forJavaName(buffer.readUtf8LineStrict());
                        } else {
                            tlsVersion = TlsVersion.SSL_3_0;
                        }
                        this.f1527h = Handshake.get(tlsVersion, forJavaName, c10, c11);
                    } else {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict + "\"");
                    }
                } else {
                    this.f1527h = null;
                }
            } finally {
                source.close();
            }
        }

        private boolean a() {
            return this.f1520a.startsWith(com.alibaba.pdns.s.e.c.f18247l);
        }

        private List c(BufferedSource bufferedSource) {
            int readInt = Cache.readInt(bufferedSource);
            if (readInt == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 < readInt; i10++) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    buffer.write(ByteString.decodeBase64(readUtf8LineStrict));
                    arrayList.add(instance.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        private void e(BufferedSink bufferedSink, List list) {
            try {
                bufferedSink.writeDecimalLong((long) list.size()).writeByte(10);
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    bufferedSink.writeUtf8(ByteString.of(((Certificate) list.get(i10)).getEncoded()).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        public boolean b(Request request, Response response) {
            if (!this.f1520a.equals(request.url().toString()) || !this.f1522c.equals(request.method()) || !HttpHeaders.varyMatches(response, this.f1521b, request)) {
                return false;
            }
            return true;
        }

        public Response d(DiskLruCache.Snapshot snapshot) {
            String str = this.f1526g.get("Content-Type");
            String str2 = this.f1526g.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.f1520a).method(this.f1522c, (RequestBody) null).headers(this.f1521b).build()).protocol(this.f1523d).code(this.f1524e).message(this.f1525f).headers(this.f1526g).body(new d(snapshot, str, str2)).handshake(this.f1527h).sentRequestAtMillis(this.f1528i).receivedResponseAtMillis(this.f1529j).build();
        }

        public void f(DiskLruCache.Editor editor) {
            BufferedSink buffer = Okio.buffer(editor.newSink(0));
            buffer.writeUtf8(this.f1520a).writeByte(10);
            buffer.writeUtf8(this.f1522c).writeByte(10);
            buffer.writeDecimalLong((long) this.f1521b.size()).writeByte(10);
            int size = this.f1521b.size();
            for (int i10 = 0; i10 < size; i10++) {
                buffer.writeUtf8(this.f1521b.name(i10)).writeUtf8(": ").writeUtf8(this.f1521b.value(i10)).writeByte(10);
            }
            buffer.writeUtf8(new StatusLine(this.f1523d, this.f1524e, this.f1525f).toString()).writeByte(10);
            buffer.writeDecimalLong((long) (this.f1526g.size() + 2)).writeByte(10);
            int size2 = this.f1526g.size();
            for (int i11 = 0; i11 < size2; i11++) {
                buffer.writeUtf8(this.f1526g.name(i11)).writeUtf8(": ").writeUtf8(this.f1526g.value(i11)).writeByte(10);
            }
            buffer.writeUtf8(f1518k).writeUtf8(": ").writeDecimalLong(this.f1528i).writeByte(10);
            buffer.writeUtf8(f1519l).writeUtf8(": ").writeDecimalLong(this.f1529j).writeByte(10);
            if (a()) {
                buffer.writeByte(10);
                buffer.writeUtf8(this.f1527h.cipherSuite().javaName()).writeByte(10);
                e(buffer, this.f1527h.peerCertificates());
                e(buffer, this.f1527h.localCertificates());
                buffer.writeUtf8(this.f1527h.tlsVersion().javaName()).writeByte(10);
            }
            buffer.close();
        }

        e(Response response) {
            this.f1520a = response.request().url().toString();
            this.f1521b = HttpHeaders.varyHeaders(response);
            this.f1522c = response.request().method();
            this.f1523d = response.protocol();
            this.f1524e = response.code();
            this.f1525f = response.message();
            this.f1526g = response.headers();
            this.f1527h = response.handshake();
            this.f1528i = response.sentRequestAtMillis();
            this.f1529j = response.receivedResponseAtMillis();
        }
    }
}
