package com.facebook.soloader;

import a8.c;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.StrictMode;
import b8.d;
import b8.f;
import b8.g;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SoLoader {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f4773a = true;

    /* renamed from: b  reason: collision with root package name */
    static t f4774b;

    /* renamed from: c  reason: collision with root package name */
    private static final ReentrantReadWriteLock f4775c = new ReentrantReadWriteLock();

    /* renamed from: d  reason: collision with root package name */
    static Context f4776d = null;

    /* renamed from: e  reason: collision with root package name */
    private static volatile a0[] f4777e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicInteger f4778f = new AtomicInteger(0);

    /* renamed from: g  reason: collision with root package name */
    private static g f4779g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final HashSet f4780h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    private static final Map f4781i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    private static final Set f4782j = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: k  reason: collision with root package name */
    private static boolean f4783k = true;

    /* renamed from: l  reason: collision with root package name */
    private static int f4784l;

    /* renamed from: m  reason: collision with root package name */
    private static int f4785m = 0;

    public static final class a extends UnsatisfiedLinkError {
        a(Throwable th, String str) {
            super("APK was built for a different platform. Supported ABIs: " + Arrays.toString(SysUtil.j()) + " error: " + str);
            initCause(th);
        }
    }

    private static void a(ArrayList arrayList, int i10) {
        a aVar = new a(f4776d, i10);
        m.a("SoLoader", "Adding application source: " + aVar.toString());
        arrayList.add(0, aVar);
    }

    private static void b(Context context, ArrayList arrayList, int i10) {
        if ((f4784l & 8) != 0) {
            File n10 = c0.n(context, "lib-main");
            try {
                if (n10.exists()) {
                    SysUtil.c(n10);
                }
            } catch (Throwable th) {
                m.h("SoLoader", "Failed to delete " + n10.getCanonicalPath(), th);
            }
        } else {
            File file = new File(context.getApplicationInfo().sourceDir);
            ArrayList arrayList2 = new ArrayList();
            c cVar = new c(context, file, "lib-main", i10);
            arrayList2.add(cVar);
            m.a("SoLoader", "adding backup source from : " + cVar.toString());
            c(context, i10, arrayList2);
            arrayList.addAll(0, arrayList2);
        }
    }

    private static void c(Context context, int i10, ArrayList arrayList) {
        if (context.getApplicationInfo().splitSourceDirs != null) {
            m.a("SoLoader", "adding backup sources from split apks");
            String[] strArr = context.getApplicationInfo().splitSourceDirs;
            int length = strArr.length;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                File file = new File(strArr[i11]);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("lib-");
                int i13 = i12 + 1;
                sb2.append(i12);
                c cVar = new c(context, file, sb2.toString(), i10);
                m.a("SoLoader", "adding backup source: " + cVar.toString());
                if (cVar.v()) {
                    arrayList.add(cVar);
                }
                i11++;
                i12 = i13;
            }
        }
    }

    private static void d(Context context, ArrayList arrayList) {
        d dVar = new d(context);
        m.a("SoLoader", "validating/adding directApk source: " + dVar.toString());
        if (dVar.n()) {
            arrayList.add(0, dVar);
        }
    }

    private static void e(ArrayList arrayList) {
        String str;
        if (SysUtil.k()) {
            str = "/system/lib64:/vendor/lib64";
        } else {
            str = "/system/lib:/vendor/lib";
        }
        String str2 = System.getenv("LD_LIBRARY_PATH");
        if (str2 != null && !str2.equals("")) {
            str = str2 + ":" + str;
        }
        for (String str3 : new HashSet(Arrays.asList(str.split(":")))) {
            m.a("SoLoader", "adding system library source: " + str3);
            arrayList.add(new e(new File(str3), 2));
        }
    }

    private static void f(Context context, ArrayList arrayList) {
        b0 b0Var = new b0();
        m.a("SoLoader", "adding systemLoadWrapper source: " + b0Var);
        arrayList.add(0, b0Var);
    }

    private static void g() {
        if (!r()) {
            throw new IllegalStateException("SoLoader.init() not yet called");
        }
    }

    private static void h(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        boolean z10;
        ReentrantReadWriteLock reentrantReadWriteLock = f4775c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (f4777e != null) {
                reentrantReadWriteLock.readLock().unlock();
                if (threadPolicy == null) {
                    threadPolicy = StrictMode.allowThreadDiskReads();
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (f4773a) {
                    Api18TraceUtils.a("SoLoader.loadLibrary[", str, "]");
                }
                try {
                    reentrantReadWriteLock.readLock().lock();
                    for (a0 d10 : f4777e) {
                        if (d10.d(str, i10, threadPolicy) != 0) {
                            if (f4773a) {
                                Api18TraceUtils.b();
                            }
                            if (z10) {
                                StrictMode.setThreadPolicy(threadPolicy);
                                return;
                            }
                            return;
                        }
                    }
                    throw x.b(str, f4776d, f4777e);
                } catch (IOException e10) {
                    y yVar = new y(str, e10.toString());
                    yVar.initCause(e10);
                    throw yVar;
                } catch (Throwable th) {
                    if (f4773a) {
                        Api18TraceUtils.b();
                    }
                    if (z10) {
                        StrictMode.setThreadPolicy(threadPolicy);
                    }
                    throw th;
                }
            } else {
                m.b("SoLoader", "Could not load: " + str + " because SoLoader is not initialized");
                throw new UnsatisfiedLinkError("SoLoader not initialized, couldn't find DSO to load: " + str);
            }
        } finally {
            f4775c.readLock().unlock();
        }
    }

    private static int i(Context context) {
        int i10 = f4785m;
        if (i10 != 0) {
            return i10;
        }
        int i11 = 1;
        if (context == null) {
            m.a("SoLoader", "context is null, fallback to THIRD_PARTY_APP appType");
            return 1;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i12 = applicationInfo.flags;
        if ((i12 & 1) != 0) {
            if ((i12 & 128) != 0) {
                i11 = 3;
            } else {
                i11 = 2;
            }
        }
        m.a("SoLoader", "ApplicationInfo.flags is: " + applicationInfo.flags + " appType is: " + i11);
        return i11;
    }

    public static void init(Context context, int i10) throws IOException {
        l(context, i10, (t) null);
    }

    private static int j() {
        int i10 = f4785m;
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2 || i10 == 3) {
            return 1;
        }
        throw new RuntimeException("Unsupported app type, we should not reach here");
    }

    private static synchronized f k() {
        f fVar;
        synchronized (SoLoader.class) {
            g gVar = f4779g;
            if (gVar == null) {
                fVar = null;
            } else {
                fVar = gVar.get();
            }
        }
        return fVar;
    }

    public static void l(Context context, int i10, t tVar) {
        if (r()) {
            m.g("SoLoader", "SoLoader already initialized");
            return;
        }
        m.g("SoLoader", "Initializing SoLoader: " + i10);
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            boolean o10 = o(context);
            f4783k = o10;
            if (o10) {
                int i11 = i(context);
                f4785m = i11;
                if ((i10 & 128) == 0 && SysUtil.l(context, i11)) {
                    i10 |= 8;
                }
                p(context, tVar);
                q(context, i10);
                m.f("SoLoader", "Init SoLoader delegate");
                a8.a.b(new q());
            } else {
                n();
                m.f("SoLoader", "Init System Loader delegate");
                a8.a.b(new c());
            }
            m.g("SoLoader", "SoLoader initialized: " + i10);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    public static void m(Context context, boolean z10) {
        try {
            l(context, z10 ? 1 : 0, (t) null);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static void n() {
        if (f4777e == null) {
            ReentrantReadWriteLock reentrantReadWriteLock = f4775c;
            reentrantReadWriteLock.writeLock().lock();
            try {
                if (f4777e != null) {
                    reentrantReadWriteLock.writeLock().unlock();
                    return;
                }
                f4777e = new a0[0];
                reentrantReadWriteLock.writeLock().unlock();
            } catch (Throwable th) {
                f4775c.writeLock().unlock();
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean o(android.content.Context r4) {
        /*
            r0 = 0
            java.lang.String r1 = r4.getPackageName()     // Catch:{ Exception -> 0x0014 }
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ Exception -> 0x0012 }
            r2 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo(r1, r2)     // Catch:{ Exception -> 0x0012 }
            android.os.Bundle r0 = r4.metaData     // Catch:{ Exception -> 0x0012 }
            goto L_0x0031
        L_0x0012:
            r4 = move-exception
            goto L_0x0016
        L_0x0014:
            r4 = move-exception
            r1 = r0
        L_0x0016:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unexpected issue with package manager ("
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = ")"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "SoLoader"
            com.facebook.soloader.m.h(r2, r1, r4)
        L_0x0031:
            r4 = 1
            if (r0 == 0) goto L_0x003e
            java.lang.String r1 = "com.facebook.soloader.enabled"
            boolean r0 = r0.getBoolean(r1, r4)
            if (r0 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r4 = 0
        L_0x003e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.o(android.content.Context):boolean");
    }

    private static synchronized void p(Context context, t tVar) {
        synchronized (SoLoader.class) {
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext == null) {
                        m.g("SoLoader", "context.getApplicationContext returned null, holding reference to original context.ApplicationSoSource fallbacks to: " + context.getApplicationInfo().nativeLibraryDir);
                    } else {
                        context = applicationContext;
                    }
                    f4776d = context;
                    f4779g = new d(context);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (tVar == null && f4774b != null) {
                return;
            }
            if (tVar != null) {
                f4774b = tVar;
            } else {
                f4774b = new u();
            }
        }
    }

    private static void q(Context context, int i10) {
        if (f4777e == null) {
            ReentrantReadWriteLock reentrantReadWriteLock = f4775c;
            reentrantReadWriteLock.writeLock().lock();
            try {
                if (f4777e != null) {
                    reentrantReadWriteLock.writeLock().unlock();
                    return;
                }
                f4784l = i10;
                ArrayList arrayList = new ArrayList();
                if ((i10 & 512) != 0) {
                    f(context, arrayList);
                } else {
                    e(arrayList);
                    if (context != null) {
                        if ((i10 & 1) != 0) {
                            a(arrayList, j());
                            m.a("SoLoader", "Adding exo package source: lib-main");
                            arrayList.add(0, new j(context, "lib-main"));
                        } else {
                            if (SysUtil.l(context, f4785m)) {
                                d(context, arrayList);
                            }
                            a(arrayList, j());
                            b(context, arrayList, 1);
                        }
                    }
                }
                a0[] a0VarArr = (a0[]) arrayList.toArray(new a0[arrayList.size()]);
                int y10 = y();
                int length = a0VarArr.length;
                while (true) {
                    int i11 = length - 1;
                    if (length > 0) {
                        m.a("SoLoader", "Preparing SO source: " + a0VarArr[i11]);
                        boolean z10 = f4773a;
                        if (z10) {
                            Api18TraceUtils.a("SoLoader", "_", a0VarArr[i11].getClass().getSimpleName());
                        }
                        a0VarArr[i11].e(y10);
                        if (z10) {
                            Api18TraceUtils.b();
                        }
                        length = i11;
                    } else {
                        f4777e = a0VarArr;
                        f4778f.getAndIncrement();
                        m.a("SoLoader", "init finish: " + f4777e.length + " SO sources prepared");
                        f4775c.writeLock().unlock();
                        return;
                    }
                }
            } catch (Throwable th) {
                f4775c.writeLock().unlock();
                throw th;
            }
        }
    }

    public static boolean r() {
        boolean z10 = true;
        if (f4777e != null) {
            return true;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f4775c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (f4777e == null) {
                z10 = false;
            }
            reentrantReadWriteLock.readLock().unlock();
            return z10;
        } catch (Throwable th) {
            f4775c.readLock().unlock();
            throw th;
        }
    }

    static void s(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        w(str, (String) null, (String) null, i10 | 1, threadPolicy);
    }

    public static boolean t(String str) {
        if (f4783k) {
            return u(str, 0);
        }
        return a8.a.d(str);
    }

    public static boolean u(String str, int i10) {
        String str2;
        Boolean x10 = x(str);
        if (x10 != null) {
            return x10.booleanValue();
        }
        if (!f4783k) {
            return a8.a.d(str);
        }
        if (f4785m != 2) {
        }
        String b10 = n.b(str);
        if (b10 != null) {
            str2 = b10;
        } else {
            str2 = str;
        }
        return v(System.mapLibraryName(str2), str, b10, i10, (StrictMode.ThreadPolicy) null);
    }

    private static boolean v(String str, String str2, String str3, int i10, StrictMode.ThreadPolicy threadPolicy) {
        f fVar = null;
        while (true) {
            try {
                return w(str, str2, str3, i10, threadPolicy);
            } catch (UnsatisfiedLinkError e10) {
                m.h("SoLoader", "Starting recovery for " + str, e10);
                f4775c.writeLock().lock();
                if (fVar == null) {
                    try {
                        fVar = k();
                    } catch (r e11) {
                        m.c("SoLoader", "Base APK not found during recovery", e11);
                        throw e11;
                    } catch (Exception e12) {
                        m.c("SoLoader", "Got an exception during recovery, will throw the initial error instead", e12);
                        throw e10;
                    } catch (Throwable th) {
                        f4775c.writeLock().unlock();
                        throw th;
                    }
                }
                if (fVar == null || !fVar.a(e10, f4777e)) {
                    f4775c.writeLock().unlock();
                    m.g("SoLoader", "Failed to recover");
                    throw e10;
                }
                f4778f.getAndIncrement();
                m.g("SoLoader", "Attempting to load library again");
                f4775c.writeLock().unlock();
            }
        }
        f4775c.writeLock().unlock();
        m.g("SoLoader", "Failed to recover");
        throw e10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0141, code lost:
        r0.readLock().unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x014a, code lost:
        return !r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x014d, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x014e, code lost:
        f4775c.readLock().unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0157, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        r0 = f4775c;
        r0.readLock().lock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        if (r3 != false) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
        r6 = com.facebook.soloader.SoLoader.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0050, code lost:
        if (r2.contains(r9) == false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0052, code lost:
        if (r11 != null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0054, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0056, code lost:
        r0.readLock().unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005d, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0063, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0065, code lost:
        if (r3 != false) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        com.facebook.soloader.m.a("SoLoader", "About to load: " + r9);
        h(r9, r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        com.facebook.soloader.m.a("SoLoader", "Loaded: " + r9);
        r13 = com.facebook.soloader.SoLoader.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0098, code lost:
        monitor-enter(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r2.add(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009c, code lost:
        monitor-exit(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00a1, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00a2, code lost:
        r10 = r9.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00a6, code lost:
        if (r10 == null) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00bf, code lost:
        throw new com.facebook.soloader.SoLoader.a(r9, r10.substring(r10.lastIndexOf("unexpected e_machine:")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00c0, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00c5, code lost:
        if ((r12 & 16) != 0) goto L_0x0140;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00cb, code lost:
        if (android.text.TextUtils.isEmpty(r10) != false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00d3, code lost:
        if (f4782j.contains(r10) == false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00d5, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00d6, code lost:
        if (r11 == null) goto L_0x0140;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00d8, code lost:
        if (r1 != false) goto L_0x0140;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00da, code lost:
        r11 = f4773a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00dc, code lost:
        if (r11 == false) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00de, code lost:
        com.facebook.soloader.Api18TraceUtils.a("MergedSoMapping.invokeJniOnload[", r10, "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        com.facebook.soloader.m.a("SoLoader", "About to merge: " + r10 + " / " + r9);
        com.facebook.soloader.n.a(r10);
        f4782j.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x010b, code lost:
        if (r11 == false) goto L_0x0140;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        com.facebook.soloader.Api18TraceUtils.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0111, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0113, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0137, code lost:
        throw new java.lang.RuntimeException("Failed to call JNI_OnLoad from '" + r10 + "', which has been merged into '" + r9 + "'.  See comment for details.", r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x013a, code lost:
        if (f4773a != false) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x013c, code lost:
        com.facebook.soloader.Api18TraceUtils.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x013f, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0140, code lost:
        monitor-exit(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean w(java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, android.os.StrictMode.ThreadPolicy r13) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            r1 = 0
            if (r0 != 0) goto L_0x0010
            java.util.Set r0 = f4782j
            boolean r0 = r0.contains(r10)
            if (r0 == 0) goto L_0x0010
            return r1
        L_0x0010:
            java.lang.Class<com.facebook.soloader.SoLoader> r0 = com.facebook.soloader.SoLoader.class
            monitor-enter(r0)
            java.util.HashSet r2 = f4780h     // Catch:{ all -> 0x0020 }
            boolean r3 = r2.contains(r9)     // Catch:{ all -> 0x0020 }
            r4 = 1
            if (r3 == 0) goto L_0x0025
            if (r11 != 0) goto L_0x0023
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return r1
        L_0x0020:
            r9 = move-exception
            goto L_0x0158
        L_0x0023:
            r3 = r4
            goto L_0x0026
        L_0x0025:
            r3 = r1
        L_0x0026:
            java.util.Map r5 = f4781i     // Catch:{ all -> 0x0020 }
            boolean r6 = r5.containsKey(r9)     // Catch:{ all -> 0x0020 }
            if (r6 == 0) goto L_0x0033
            java.lang.Object r5 = r5.get(r9)     // Catch:{ all -> 0x0020 }
            goto L_0x003c
        L_0x0033:
            java.lang.Object r6 = new java.lang.Object     // Catch:{ all -> 0x0020 }
            r6.<init>()     // Catch:{ all -> 0x0020 }
            r5.put(r9, r6)     // Catch:{ all -> 0x0020 }
            r5 = r6
        L_0x003c:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f4775c
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r6 = r0.readLock()
            r6.lock()
            monitor-enter(r5)     // Catch:{ all -> 0x014d }
            if (r3 != 0) goto L_0x00c3
            java.lang.Class<com.facebook.soloader.SoLoader> r6 = com.facebook.soloader.SoLoader.class
            monitor-enter(r6)     // Catch:{ all -> 0x005e }
            boolean r7 = r2.contains(r9)     // Catch:{ all -> 0x0061 }
            if (r7 == 0) goto L_0x0064
            if (r11 != 0) goto L_0x0063
            monitor-exit(r6)     // Catch:{ all -> 0x0061 }
            monitor-exit(r5)     // Catch:{ all -> 0x005e }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r9 = r0.readLock()
            r9.unlock()
            return r1
        L_0x005e:
            r9 = move-exception
            goto L_0x014b
        L_0x0061:
            r9 = move-exception
            goto L_0x00c1
        L_0x0063:
            r3 = r4
        L_0x0064:
            monitor-exit(r6)     // Catch:{ all -> 0x0061 }
            if (r3 != 0) goto L_0x00c3
            java.lang.String r6 = "SoLoader"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x00a1 }
            r7.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x00a1 }
            java.lang.String r8 = "About to load: "
            r7.append(r8)     // Catch:{ UnsatisfiedLinkError -> 0x00a1 }
            r7.append(r9)     // Catch:{ UnsatisfiedLinkError -> 0x00a1 }
            java.lang.String r7 = r7.toString()     // Catch:{ UnsatisfiedLinkError -> 0x00a1 }
            com.facebook.soloader.m.a(r6, r7)     // Catch:{ UnsatisfiedLinkError -> 0x00a1 }
            h(r9, r12, r13)     // Catch:{ UnsatisfiedLinkError -> 0x00a1 }
            java.lang.String r13 = "SoLoader"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
            r6.<init>()     // Catch:{ all -> 0x005e }
            java.lang.String r7 = "Loaded: "
            r6.append(r7)     // Catch:{ all -> 0x005e }
            r6.append(r9)     // Catch:{ all -> 0x005e }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x005e }
            com.facebook.soloader.m.a(r13, r6)     // Catch:{ all -> 0x005e }
            java.lang.Class<com.facebook.soloader.SoLoader> r13 = com.facebook.soloader.SoLoader.class
            monitor-enter(r13)     // Catch:{ all -> 0x005e }
            r2.add(r9)     // Catch:{ all -> 0x009e }
            monitor-exit(r13)     // Catch:{ all -> 0x009e }
            goto L_0x00c3
        L_0x009e:
            r9 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x009e }
            throw r9     // Catch:{ all -> 0x005e }
        L_0x00a1:
            r9 = move-exception
            java.lang.String r10 = r9.getMessage()     // Catch:{ all -> 0x005e }
            if (r10 == 0) goto L_0x00c0
            java.lang.String r11 = "unexpected e_machine:"
            boolean r11 = r10.contains(r11)     // Catch:{ all -> 0x005e }
            if (r11 == 0) goto L_0x00c0
            java.lang.String r11 = "unexpected e_machine:"
            int r11 = r10.lastIndexOf(r11)     // Catch:{ all -> 0x005e }
            java.lang.String r10 = r10.substring(r11)     // Catch:{ all -> 0x005e }
            com.facebook.soloader.SoLoader$a r11 = new com.facebook.soloader.SoLoader$a     // Catch:{ all -> 0x005e }
            r11.<init>(r9, r10)     // Catch:{ all -> 0x005e }
            throw r11     // Catch:{ all -> 0x005e }
        L_0x00c0:
            throw r9     // Catch:{ all -> 0x005e }
        L_0x00c1:
            monitor-exit(r6)     // Catch:{ all -> 0x0061 }
            throw r9     // Catch:{ all -> 0x005e }
        L_0x00c3:
            r12 = r12 & 16
            if (r12 != 0) goto L_0x0140
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x005e }
            if (r12 != 0) goto L_0x00d6
            java.util.Set r12 = f4782j     // Catch:{ all -> 0x005e }
            boolean r12 = r12.contains(r10)     // Catch:{ all -> 0x005e }
            if (r12 == 0) goto L_0x00d6
            r1 = r4
        L_0x00d6:
            if (r11 == 0) goto L_0x0140
            if (r1 != 0) goto L_0x0140
            boolean r11 = f4773a     // Catch:{ all -> 0x005e }
            if (r11 == 0) goto L_0x00e5
            java.lang.String r12 = "MergedSoMapping.invokeJniOnload["
            java.lang.String r13 = "]"
            com.facebook.soloader.Api18TraceUtils.a(r12, r10, r13)     // Catch:{ all -> 0x005e }
        L_0x00e5:
            java.lang.String r12 = "SoLoader"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x0113 }
            r13.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x0113 }
            java.lang.String r1 = "About to merge: "
            r13.append(r1)     // Catch:{ UnsatisfiedLinkError -> 0x0113 }
            r13.append(r10)     // Catch:{ UnsatisfiedLinkError -> 0x0113 }
            java.lang.String r1 = " / "
            r13.append(r1)     // Catch:{ UnsatisfiedLinkError -> 0x0113 }
            r13.append(r9)     // Catch:{ UnsatisfiedLinkError -> 0x0113 }
            java.lang.String r13 = r13.toString()     // Catch:{ UnsatisfiedLinkError -> 0x0113 }
            com.facebook.soloader.m.a(r12, r13)     // Catch:{ UnsatisfiedLinkError -> 0x0113 }
            com.facebook.soloader.n.a(r10)     // Catch:{ UnsatisfiedLinkError -> 0x0113 }
            java.util.Set r12 = f4782j     // Catch:{ UnsatisfiedLinkError -> 0x0113 }
            r12.add(r10)     // Catch:{ UnsatisfiedLinkError -> 0x0113 }
            if (r11 == 0) goto L_0x0140
            com.facebook.soloader.Api18TraceUtils.b()     // Catch:{ all -> 0x005e }
            goto L_0x0140
        L_0x0111:
            r9 = move-exception
            goto L_0x0138
        L_0x0113:
            r11 = move-exception
            java.lang.RuntimeException r12 = new java.lang.RuntimeException     // Catch:{ all -> 0x0111 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0111 }
            r13.<init>()     // Catch:{ all -> 0x0111 }
            java.lang.String r0 = "Failed to call JNI_OnLoad from '"
            r13.append(r0)     // Catch:{ all -> 0x0111 }
            r13.append(r10)     // Catch:{ all -> 0x0111 }
            java.lang.String r10 = "', which has been merged into '"
            r13.append(r10)     // Catch:{ all -> 0x0111 }
            r13.append(r9)     // Catch:{ all -> 0x0111 }
            java.lang.String r9 = "'.  See comment for details."
            r13.append(r9)     // Catch:{ all -> 0x0111 }
            java.lang.String r9 = r13.toString()     // Catch:{ all -> 0x0111 }
            r12.<init>(r9, r11)     // Catch:{ all -> 0x0111 }
            throw r12     // Catch:{ all -> 0x0111 }
        L_0x0138:
            boolean r10 = f4773a     // Catch:{ all -> 0x005e }
            if (r10 == 0) goto L_0x013f
            com.facebook.soloader.Api18TraceUtils.b()     // Catch:{ all -> 0x005e }
        L_0x013f:
            throw r9     // Catch:{ all -> 0x005e }
        L_0x0140:
            monitor-exit(r5)     // Catch:{ all -> 0x005e }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r9 = r0.readLock()
            r9.unlock()
            r9 = r3 ^ 1
            return r9
        L_0x014b:
            monitor-exit(r5)     // Catch:{ all -> 0x005e }
            throw r9     // Catch:{ all -> 0x014d }
        L_0x014d:
            r9 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r10 = f4775c
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r10 = r10.readLock()
            r10.unlock()
            throw r9
        L_0x0158:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.w(java.lang.String, java.lang.String, java.lang.String, int, android.os.StrictMode$ThreadPolicy):boolean");
    }

    private static Boolean x(String str) {
        Boolean valueOf;
        if (f4777e != null) {
            return null;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f4775c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (f4777e == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    g();
                } else {
                    synchronized (SoLoader.class) {
                        boolean z10 = !f4780h.contains(str);
                        if (z10) {
                            System.loadLibrary(str);
                        }
                        valueOf = Boolean.valueOf(z10);
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return valueOf;
                }
            }
            reentrantReadWriteLock.readLock().unlock();
            return null;
        } catch (Throwable th) {
            f4775c.readLock().unlock();
            throw th;
        }
    }

    private static int y() {
        int i10;
        ReentrantReadWriteLock reentrantReadWriteLock = f4775c;
        reentrantReadWriteLock.writeLock().lock();
        try {
            int i11 = f4784l;
            if ((i11 & 2) != 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            if ((i11 & 256) != 0) {
                i10 |= 4;
            }
            reentrantReadWriteLock.writeLock().unlock();
            return i10;
        } catch (Throwable th) {
            f4775c.writeLock().unlock();
            throw th;
        }
    }
}
