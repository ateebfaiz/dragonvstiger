package q5;

import com.facebook.o;
import com.facebook.w;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import q5.d0;

public final class t {
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final String f23479i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final AtomicLong f23480j = new AtomicLong();

    /* renamed from: k  reason: collision with root package name */
    public static final c f23481k = new c((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final File f23482a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23483b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23484c;

    /* renamed from: d  reason: collision with root package name */
    private final ReentrantLock f23485d;

    /* renamed from: e  reason: collision with root package name */
    private final Condition f23486e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final AtomicLong f23487f = new AtomicLong(0);

    /* renamed from: g  reason: collision with root package name */
    private final String f23488g;

    /* renamed from: h  reason: collision with root package name */
    private final e f23489h;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final FilenameFilter f23490a = C0325a.f23493a;

        /* renamed from: b  reason: collision with root package name */
        private static final FilenameFilter f23491b = b.f23494a;

        /* renamed from: c  reason: collision with root package name */
        public static final a f23492c = new a();

        /* renamed from: q5.t$a$a  reason: collision with other inner class name */
        static final class C0325a implements FilenameFilter {

            /* renamed from: a  reason: collision with root package name */
            public static final C0325a f23493a = new C0325a();

            C0325a() {
            }

            public final boolean accept(File file, String str) {
                m.e(str, "filename");
                return !kotlin.text.j.F(str, "buffer", false, 2, (Object) null);
            }
        }

        static final class b implements FilenameFilter {

            /* renamed from: a  reason: collision with root package name */
            public static final b f23494a = new b();

            b() {
            }

            public final boolean accept(File file, String str) {
                m.e(str, "filename");
                return kotlin.text.j.F(str, "buffer", false, 2, (Object) null);
            }
        }

        private a() {
        }

        public final void a(File file) {
            m.f(file, "root");
            File[] listFiles = file.listFiles(c());
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }

        public final FilenameFilter b() {
            return f23490a;
        }

        public final FilenameFilter c() {
            return f23491b;
        }

        public final File d(File file) {
            return new File(file, "buffer" + String.valueOf(t.f23480j.incrementAndGet()));
        }
    }

    private static final class b extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        private final OutputStream f23495a;

        /* renamed from: b  reason: collision with root package name */
        private final g f23496b;

        public b(OutputStream outputStream, g gVar) {
            m.f(outputStream, "innerStream");
            m.f(gVar, "callback");
            this.f23495a = outputStream;
            this.f23496b = gVar;
        }

        public void close() {
            try {
                this.f23495a.close();
            } finally {
                this.f23496b.onClose();
            }
        }

        public void flush() {
            this.f23495a.flush();
        }

        public void write(byte[] bArr, int i10, int i11) {
            m.f(bArr, "buffer");
            this.f23495a.write(bArr, i10, i11);
        }

        public void write(byte[] bArr) {
            m.f(bArr, "buffer");
            this.f23495a.write(bArr);
        }

        public void write(int i10) {
            this.f23495a.write(i10);
        }
    }

    public static final class c {
        private c() {
        }

        public final String a() {
            return t.f23479i;
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        private int f23499a = 1048576;

        /* renamed from: b  reason: collision with root package name */
        private int f23500b = 1024;

        public final int a() {
            return this.f23499a;
        }

        public final int b() {
            return this.f23500b;
        }
    }

    private static final class f implements Comparable {

        /* renamed from: c  reason: collision with root package name */
        public static final a f23501c = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final long f23502a;

        /* renamed from: b  reason: collision with root package name */
        private final File f23503b;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public f(File file) {
            m.f(file, "file");
            this.f23503b = file;
            this.f23502a = file.lastModified();
        }

        /* renamed from: a */
        public int compareTo(f fVar) {
            m.f(fVar, "another");
            long j10 = this.f23502a;
            long j11 = fVar.f23502a;
            if (j10 < j11) {
                return -1;
            }
            if (j10 > j11) {
                return 1;
            }
            return this.f23503b.compareTo(fVar.f23503b);
        }

        public final File b() {
            return this.f23503b;
        }

        public final long c() {
            return this.f23502a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f) || compareTo((f) obj) != 0) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((1073 + this.f23503b.hashCode()) * 37) + ((int) (this.f23502a % ((long) Integer.MAX_VALUE)));
        }
    }

    private interface g {
        void onClose();
    }

    private static final class h {

        /* renamed from: a  reason: collision with root package name */
        public static final h f23504a = new h();

        private h() {
        }

        public final JSONObject a(InputStream inputStream) {
            m.f(inputStream, "stream");
            if (inputStream.read() != 0) {
                return null;
            }
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < 3; i12++) {
                int read = inputStream.read();
                if (read == -1) {
                    d0.f23283f.b(w.CACHE, t.f23481k.a(), "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i11 = (i11 << 8) + (read & 255);
            }
            byte[] bArr = new byte[i11];
            while (i10 < i11) {
                int read2 = inputStream.read(bArr, i10, i11 - i10);
                if (read2 < 1) {
                    d0.f23283f.b(w.CACHE, t.f23481k.a(), "readHeader: stream.read stopped at " + Integer.valueOf(i10) + " when expected " + i11);
                    return null;
                }
                i10 += read2;
            }
            try {
                Object nextValue = new JSONTokener(new String(bArr, kotlin.text.d.f797b)).nextValue();
                if (nextValue instanceof JSONObject) {
                    return (JSONObject) nextValue;
                }
                d0.f23283f.b(w.CACHE, t.f23481k.a(), "readHeader: expected JSONObject, got " + nextValue.getClass().getCanonicalName());
                return null;
            } catch (JSONException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        public final void b(OutputStream outputStream, JSONObject jSONObject) {
            m.f(outputStream, "stream");
            m.f(jSONObject, "header");
            String jSONObject2 = jSONObject.toString();
            m.e(jSONObject2, "header.toString()");
            Charset charset = kotlin.text.d.f797b;
            if (jSONObject2 != null) {
                byte[] bytes = jSONObject2.getBytes(charset);
                m.e(bytes, "(this as java.lang.String).getBytes(charset)");
                outputStream.write(0);
                outputStream.write((bytes.length >> 16) & 255);
                outputStream.write((bytes.length >> 8) & 255);
                outputStream.write(bytes.length & 255);
                outputStream.write(bytes);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    static final class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File[] f23505a;

        i(File[] fileArr) {
            this.f23505a = fileArr;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    for (File delete : this.f23505a) {
                        delete.delete();
                    }
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    public static final class j implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f23506a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f23507b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f23508c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f23509d;

        j(t tVar, long j10, File file, String str) {
            this.f23506a = tVar;
            this.f23507b = j10;
            this.f23508c = file;
            this.f23509d = str;
        }

        public void onClose() {
            if (this.f23507b < this.f23506a.f23487f.get()) {
                this.f23508c.delete();
            } else {
                this.f23506a.o(this.f23509d, this.f23508c);
            }
        }
    }

    static final class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f23510a;

        k(t tVar) {
            this.f23510a = tVar;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    this.f23510a.p();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static {
        String simpleName = t.class.getSimpleName();
        m.e(simpleName, "FileLruCache::class.java.simpleName");
        f23479i = simpleName;
    }

    public t(String str, e eVar) {
        m.f(str, "tag");
        m.f(eVar, "limits");
        this.f23488g = str;
        this.f23489h = eVar;
        File file = new File(o.l(), str);
        this.f23482a = file;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f23485d = reentrantLock;
        this.f23486e = reentrantLock.newCondition();
        if (file.mkdirs() || file.isDirectory()) {
            a.f23492c.a(file);
        }
    }

    public static /* synthetic */ InputStream i(t tVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return tVar.h(str, str2);
    }

    public static /* synthetic */ OutputStream m(t tVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return tVar.l(str, str2);
    }

    private final void n() {
        ReentrantLock reentrantLock = this.f23485d;
        reentrantLock.lock();
        try {
            if (!this.f23483b) {
                this.f23483b = true;
                o.p().execute(new k(this));
            }
            Unit unit = Unit.f12577a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final void o(String str, File file) {
        if (!file.renameTo(new File(this.f23482a, p0.j0(str)))) {
            file.delete();
        }
        n();
    }

    /* access modifiers changed from: private */
    public final void p() {
        ReentrantLock reentrantLock;
        long j10;
        ReentrantLock reentrantLock2 = this.f23485d;
        reentrantLock2.lock();
        try {
            this.f23483b = false;
            this.f23484c = true;
            Unit unit = Unit.f12577a;
            try {
                d0.f23283f.b(w.CACHE, f23479i, "trim started");
                PriorityQueue priorityQueue = new PriorityQueue();
                File[] listFiles = this.f23482a.listFiles(a.f23492c.b());
                long j11 = 0;
                if (listFiles != null) {
                    j10 = 0;
                    for (File file : listFiles) {
                        m.e(file, "file");
                        f fVar = new f(file);
                        priorityQueue.add(fVar);
                        d0.f23283f.b(w.CACHE, f23479i, "  trim considering time=" + Long.valueOf(fVar.c()) + " name=" + fVar.b().getName());
                        j11 += file.length();
                        j10++;
                    }
                } else {
                    j10 = 0;
                }
                while (true) {
                    if (j11 > ((long) this.f23489h.a()) || j10 > ((long) this.f23489h.b())) {
                        File b10 = ((f) priorityQueue.remove()).b();
                        d0.f23283f.b(w.CACHE, f23479i, "  trim removing " + b10.getName());
                        j11 -= b10.length();
                        j10 += -1;
                        b10.delete();
                    } else {
                        reentrantLock = this.f23485d;
                        reentrantLock.lock();
                        try {
                            this.f23484c = false;
                            this.f23486e.signalAll();
                            Unit unit2 = Unit.f12577a;
                            return;
                        } finally {
                            reentrantLock.unlock();
                        }
                    }
                }
            } catch (Throwable th) {
                reentrantLock = this.f23485d;
                reentrantLock.lock();
                this.f23484c = false;
                this.f23486e.signalAll();
                Unit unit3 = Unit.f12577a;
                throw th;
            } finally {
                reentrantLock.unlock();
            }
        } finally {
            reentrantLock2.unlock();
        }
    }

    public final void f() {
        File[] listFiles = this.f23482a.listFiles(a.f23492c.b());
        this.f23487f.set(System.currentTimeMillis());
        if (listFiles != null) {
            o.p().execute(new i(listFiles));
        }
    }

    public final InputStream g(String str) {
        return i(this, str, (String) null, 2, (Object) null);
    }

    public final InputStream h(String str, String str2) {
        m.f(str, "key");
        File file = new File(this.f23482a, p0.j0(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
            try {
                JSONObject a10 = h.f23504a.a(bufferedInputStream);
                if (a10 == null) {
                    bufferedInputStream.close();
                    return null;
                } else if (!m.b(a10.optString("key"), str)) {
                    return null;
                } else {
                    String optString = a10.optString("tag", (String) null);
                    if (str2 != null || !(!m.b(str2, optString))) {
                        long time = new Date().getTime();
                        d0.a aVar = d0.f23283f;
                        w wVar = w.CACHE;
                        String str3 = f23479i;
                        aVar.b(wVar, str3, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                        file.setLastModified(time);
                        return bufferedInputStream;
                    }
                    bufferedInputStream.close();
                    return null;
                }
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public final InputStream j(String str, InputStream inputStream) {
        m.f(str, "key");
        m.f(inputStream, "input");
        return new d(inputStream, m(this, str, (String) null, 2, (Object) null));
    }

    public final OutputStream k(String str) {
        return m(this, str, (String) null, 2, (Object) null);
    }

    public final OutputStream l(String str, String str2) {
        m.f(str, "key");
        File d10 = a.f23492c.d(this.f23482a);
        d10.delete();
        if (d10.createNewFile()) {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new b(new FileOutputStream(d10), new j(this, System.currentTimeMillis(), d10, str)), 8192);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", str);
                    if (!p0.Y(str2)) {
                        jSONObject.put("tag", str2);
                    }
                    h.f23504a.b(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (JSONException e10) {
                    d0.a aVar = d0.f23283f;
                    w wVar = w.CACHE;
                    String str3 = f23479i;
                    aVar.a(wVar, 5, str3, "Error creating JSON header for cache file: " + e10);
                    throw new IOException(e10.getMessage());
                } catch (Throwable th) {
                    bufferedOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e11) {
                d0.a aVar2 = d0.f23283f;
                w wVar2 = w.CACHE;
                String str4 = f23479i;
                aVar2.a(wVar2, 5, str4, "Error creating buffer output stream: " + e11);
                throw new IOException(e11.getMessage());
            }
        } else {
            throw new IOException("Could not create file at " + d10.getAbsolutePath());
        }
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.f23488g + " file:" + this.f23482a.getName() + "}";
    }

    private static final class d extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f23497a;

        /* renamed from: b  reason: collision with root package name */
        private final OutputStream f23498b;

        public d(InputStream inputStream, OutputStream outputStream) {
            m.f(inputStream, "input");
            m.f(outputStream, "output");
            this.f23497a = inputStream;
            this.f23498b = outputStream;
        }

        public int available() {
            return this.f23497a.available();
        }

        public void close() {
            try {
                this.f23497a.close();
            } finally {
                this.f23498b.close();
            }
        }

        public void mark(int i10) {
            throw new UnsupportedOperationException();
        }

        public boolean markSupported() {
            return false;
        }

        public int read(byte[] bArr) {
            m.f(bArr, "buffer");
            int read = this.f23497a.read(bArr);
            if (read > 0) {
                this.f23498b.write(bArr, 0, read);
            }
            return read;
        }

        public synchronized void reset() {
            throw new UnsupportedOperationException();
        }

        public long skip(long j10) {
            int read;
            byte[] bArr = new byte[1024];
            long j11 = 0;
            while (j11 < j10 && (read = read(bArr, 0, (int) Math.min(j10 - j11, (long) 1024))) >= 0) {
                j11 += (long) read;
            }
            return j11;
        }

        public int read() {
            int read = this.f23497a.read();
            if (read >= 0) {
                this.f23498b.write(read);
            }
            return read;
        }

        public int read(byte[] bArr, int i10, int i11) {
            m.f(bArr, "buffer");
            int read = this.f23497a.read(bArr, i10, i11);
            if (read > 0) {
                this.f23498b.write(bArr, i10, read);
            }
            return read;
        }
    }
}
