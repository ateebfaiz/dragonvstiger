package l;

import android.util.SparseArray;
import i.v;
import j.c;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import w.d;

public class f extends c {

    /* renamed from: f  reason: collision with root package name */
    public static final String f22373f = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final d f22374a;

    /* renamed from: b  reason: collision with root package name */
    public final b f22375b;

    /* renamed from: c  reason: collision with root package name */
    public j.b f22376c;

    /* renamed from: d  reason: collision with root package name */
    public a f22377d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22378e = false;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final File f22379a;

        /* renamed from: b  reason: collision with root package name */
        public final int f22380b;

        /* renamed from: c  reason: collision with root package name */
        public RandomAccessFile f22381c = null;

        /* renamed from: d  reason: collision with root package name */
        public long f22382d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f22383e = 0;

        public a(String str, int i10) {
            this.f22379a = new File(str);
            this.f22380b = i10;
        }

        public final boolean a() {
            if (this.f22381c == null) {
                this.f22381c = d();
            }
            if (this.f22381c != null) {
                return true;
            }
            return false;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(9:6|7|8|10|11|12|13|14|15) */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r2.f22381c = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0019, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000c, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x000e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void b() {
            /*
                r2 = this;
                monitor-enter(r2)
                java.io.RandomAccessFile r0 = r2.f22381c     // Catch:{ all -> 0x0015 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r2)
                return
            L_0x0007:
                r1 = 0
                r0.close()     // Catch:{ IOException -> 0x000e }
                goto L_0x0011
            L_0x000c:
                r0 = move-exception
                goto L_0x0017
            L_0x000e:
                java.lang.String unused = l.f.f22373f     // Catch:{ all -> 0x000c }
            L_0x0011:
                r2.f22381c = r1     // Catch:{ all -> 0x0015 }
                monitor-exit(r2)
                return
            L_0x0015:
                r0 = move-exception
                goto L_0x001a
            L_0x0017:
                r2.f22381c = r1     // Catch:{ all -> 0x0015 }
                throw r0     // Catch:{ all -> 0x0015 }
            L_0x001a:
                monitor-exit(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: l.f.a.b():void");
        }

        public boolean c() {
            return this.f22379a.delete();
        }

        public final RandomAccessFile d() {
            try {
                return new RandomAccessFile(this.f22379a, "r");
            } catch (Exception unused) {
                String unused2 = f.f22373f;
                this.f22379a.getAbsolutePath();
                return null;
            }
        }

        public int e() {
            return this.f22383e;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(2:14|15) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            l.f.d();
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized java.util.ArrayList f() {
            /*
                r8 = this;
                monitor-enter(r8)
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0013 }
                r1 = 10
                r0.<init>(r1)     // Catch:{ all -> 0x0013 }
                boolean r2 = r8.a()     // Catch:{ all -> 0x0013 }
                if (r2 != 0) goto L_0x0015
                java.lang.String unused = l.f.f22373f     // Catch:{ all -> 0x0013 }
                monitor-exit(r8)
                return r0
            L_0x0013:
                r0 = move-exception
                goto L_0x0044
            L_0x0015:
                java.io.RandomAccessFile r2 = r8.f22381c     // Catch:{ all -> 0x003f }
                long r3 = r8.f22382d     // Catch:{ all -> 0x003f }
                r2.seek(r3)     // Catch:{ all -> 0x003f }
                r2 = 0
            L_0x001d:
                if (r2 >= r1) goto L_0x0042
                java.io.RandomAccessFile r3 = r8.f22381c     // Catch:{ all -> 0x003f }
                java.lang.String r3 = r3.readLine()     // Catch:{ all -> 0x003f }
                if (r3 == 0) goto L_0x0042
                r0.add(r3)     // Catch:{ all -> 0x003f }
                long r4 = r8.f22382d     // Catch:{ all -> 0x003f }
                int r3 = r3.length()     // Catch:{ all -> 0x003f }
                int r3 = r3 + 1
                long r6 = (long) r3     // Catch:{ all -> 0x003f }
                long r4 = r4 + r6
                r8.f22382d = r4     // Catch:{ all -> 0x003f }
                int r2 = r2 + 1
                int r3 = r8.f22383e     // Catch:{ all -> 0x003f }
                int r3 = r3 + 1
                r8.f22383e = r3     // Catch:{ all -> 0x003f }
                goto L_0x001d
            L_0x003f:
                java.lang.String unused = l.f.f22373f     // Catch:{ all -> 0x0013 }
            L_0x0042:
                monitor-exit(r8)
                return r0
            L_0x0044:
                monitor-exit(r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: l.f.a.f():java.util.ArrayList");
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f22384a;

        /* renamed from: b  reason: collision with root package name */
        public final SparseArray f22385b = new SparseArray();

        /* renamed from: c  reason: collision with root package name */
        public int f22386c;

        public b(String str) {
            this.f22384a = str;
        }

        public boolean a() {
            int i10 = this.f22386c - 1;
            if (i10 < 1) {
                return false;
            }
            boolean c10 = ((a) this.f22385b.get(i10)).c();
            this.f22385b.delete(i10);
            return c10;
        }

        public String b() {
            return this.f22384a;
        }

        public a c() {
            this.f22386c = 0;
            this.f22385b.append(0, new a(this.f22384a, 0));
            return (a) this.f22385b.get(this.f22386c);
        }

        public a d() {
            String e10 = e();
            int i10 = this.f22386c + 1;
            this.f22386c = i10;
            this.f22385b.append(i10, new a(e10, i10));
            return (a) this.f22385b.get(this.f22386c);
        }

        public String e() {
            return this.f22384a + "_" + (this.f22386c + 1);
        }
    }

    public f(String str, d dVar) {
        this.f22374a = dVar;
        this.f22375b = new b(str);
    }

    public long a() {
        return 2000;
    }

    public long b() {
        return 2000;
    }

    public void c() {
        try {
            ArrayList f10 = this.f22377d.f();
            if (!f10.isEmpty()) {
                String absolutePath = this.f22377d.f22379a.getAbsolutePath();
                long j10 = this.f22377d.f22382d;
                Iterator it = f10.iterator();
                while (it.hasNext()) {
                    this.f22374a.a(new c((String) it.next(), absolutePath, j10));
                }
            } else if (e()) {
                this.f22375b.a();
                this.f22377d.b();
                this.f22377d = this.f22375b.d();
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean e() {
        RandomAccessFile randomAccessFile;
        boolean z10 = false;
        if (this.f22377d.e() + 5 > 2000) {
            String e10 = this.f22375b.e();
            if (new File(e10).exists()) {
                RandomAccessFile randomAccessFile2 = null;
                try {
                    randomAccessFile = new RandomAccessFile(e10, "r");
                } catch (IOException unused) {
                    v.f(randomAccessFile2);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    v.f(randomAccessFile2);
                    throw th;
                }
                try {
                    if (randomAccessFile.length() > 0) {
                        z10 = true;
                    }
                    v.f(randomAccessFile);
                    return z10;
                } catch (IOException unused2) {
                    randomAccessFile2 = randomAccessFile;
                    v.f(randomAccessFile2);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile2 = randomAccessFile;
                    v.f(randomAccessFile2);
                    throw th;
                }
            }
        }
        return false;
    }

    public String f() {
        return this.f22375b.b();
    }

    public void g() {
        if (!this.f22378e) {
            String str = f22373f;
            this.f22377d = this.f22375b.c();
            j.b b10 = j.a.a().b(this);
            this.f22376c = b10;
            if (b10 == null) {
                d.k(str, "submit access schedule read fail");
            }
            this.f22378e = true;
        }
    }

    public void h() {
        if (this.f22378e) {
            this.f22378e = false;
            j.b bVar = this.f22376c;
            if (bVar != null) {
                bVar.a();
            }
            this.f22377d.b();
        }
    }
}
