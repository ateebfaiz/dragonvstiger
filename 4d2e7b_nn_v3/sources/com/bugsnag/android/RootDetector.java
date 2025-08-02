package com.bugsnag.android;

import java.io.File;
import java.io.Reader;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.n;
import kotlin.o;
import kotlin.p;
import kotlin.text.h;
import kotlin.text.j;

public final class RootDetector {

    /* renamed from: f  reason: collision with root package name */
    public static final a f18590f = new a((DefaultConstructorMarker) null);

    /* renamed from: g  reason: collision with root package name */
    private static final File f18591g = new File("/system/build.prop");

    /* renamed from: h  reason: collision with root package name */
    private static final List f18592h = r.o("/system/xbin/su", "/system/bin/su", "/system/app/Superuser.apk", "/system/app/SuperSU.apk", "/system/app/Superuser", "/system/app/SuperSU", "/system/xbin/daemonsu", "/su/bin");

    /* renamed from: a  reason: collision with root package name */
    private final x0 f18593a;

    /* renamed from: b  reason: collision with root package name */
    private final List f18594b;

    /* renamed from: c  reason: collision with root package name */
    private final File f18595c;

    /* renamed from: d  reason: collision with root package name */
    private final s2 f18596d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f18597e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f18598a = new b();

        b() {
            super(1);
        }

        /* renamed from: a */
        public final String invoke(String str) {
            return new h("\\s").d(str, "");
        }
    }

    static final class c extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final c f18599a = new c();

        c() {
            super(1);
        }

        /* renamed from: a */
        public final Boolean invoke(String str) {
            boolean z10 = false;
            if (j.F(str, "ro.debuggable=[1]", false, 2, (Object) null) || j.F(str, "ro.secure=[0]", false, 2, (Object) null)) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    public RootDetector(x0 x0Var, List list, File file, s2 s2Var) {
        this.f18593a = x0Var;
        this.f18594b = list;
        this.f18595c = file;
        this.f18596d = s2Var;
        try {
            System.loadLibrary("bugsnag-root-detection");
            this.f18597e = true;
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    private final boolean d() {
        return e(new ProcessBuilder(new String[0]));
    }

    private final boolean f(Reader reader) {
        int read;
        do {
            read = reader.read();
            if (read == -1) {
                return false;
            }
        } while (kotlin.text.a.c((char) read));
        return true;
    }

    private final boolean h() {
        if (this.f18597e) {
            return performNativeRootChecks();
        }
        return false;
    }

    private final native boolean performNativeRootChecks();

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        tb.c.a(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r3 = this;
            kotlin.o$a r0 = kotlin.o.f12592b     // Catch:{ all -> 0x0017 }
            java.io.File r0 = r3.f18595c     // Catch:{ all -> 0x0017 }
            java.nio.charset.Charset r1 = kotlin.text.d.f797b     // Catch:{ all -> 0x0017 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0017 }
            r2.<init>(r0)     // Catch:{ all -> 0x0017 }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ all -> 0x0017 }
            r0.<init>(r2, r1)     // Catch:{ all -> 0x0017 }
            boolean r1 = r0 instanceof java.io.BufferedReader     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x0019
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0     // Catch:{ all -> 0x0017 }
            goto L_0x0021
        L_0x0017:
            r0 = move-exception
            goto L_0x0041
        L_0x0019:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0017 }
            r2 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r0, r2)     // Catch:{ all -> 0x0017 }
            r0 = r1
        L_0x0021:
            kotlin.sequences.Sequence r1 = tb.o.d(r0)     // Catch:{ all -> 0x003a }
            com.bugsnag.android.RootDetector$b r2 = com.bugsnag.android.RootDetector.b.f18598a     // Catch:{ all -> 0x003a }
            kotlin.sequences.Sequence r1 = kotlin.sequences.h.q(r1, r2)     // Catch:{ all -> 0x003a }
            com.bugsnag.android.RootDetector$c r2 = com.bugsnag.android.RootDetector.c.f18599a     // Catch:{ all -> 0x003a }
            kotlin.sequences.Sequence r1 = kotlin.sequences.h.j(r1, r2)     // Catch:{ all -> 0x003a }
            boolean r1 = kotlin.sequences.h.g(r1)     // Catch:{ all -> 0x003a }
            r2 = 0
            tb.c.a(r0, r2)     // Catch:{ all -> 0x0017 }
            return r1
        L_0x003a:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x003c }
        L_0x003c:
            r2 = move-exception
            tb.c.a(r0, r1)     // Catch:{ all -> 0x0017 }
            throw r2     // Catch:{ all -> 0x0017 }
        L_0x0041:
            kotlin.o$a r1 = kotlin.o.f12592b
            java.lang.Object r0 = kotlin.p.a(r0)
            kotlin.o.b(r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.RootDetector.a():boolean");
    }

    public final boolean b() {
        String i10 = this.f18593a.i();
        if (i10 != null && j.K(i10, "test-keys", false, 2, (Object) null)) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        try {
            o.a aVar = o.f12592b;
            for (String file : this.f18594b) {
                if (new File(file).exists()) {
                    return true;
                }
            }
            o.b(Unit.f12577a);
            return false;
        } catch (Throwable th) {
            o.a aVar2 = o.f12592b;
            o.b(p.a(th));
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        tb.c.a(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0043, code lost:
        throw r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(java.lang.ProcessBuilder r6) {
        /*
            r5 = this;
            java.lang.String r0 = "which"
            java.lang.String r1 = "su"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            java.util.List r0 = kotlin.collections.r.o(r0)
            r6.command(r0)
            r0 = 0
            java.lang.Process r6 = r6.start()     // Catch:{ IOException -> 0x004f, all -> 0x0044 }
            java.io.InputStream r1 = r6.getInputStream()     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            java.nio.charset.Charset r2 = kotlin.text.d.f797b     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            r3.<init>(r1, r2)     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            boolean r1 = r3 instanceof java.io.BufferedReader     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            if (r1 == 0) goto L_0x002a
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            goto L_0x0032
        L_0x0026:
            r0 = move-exception
            goto L_0x0048
        L_0x0028:
            r0 = r6
            goto L_0x004f
        L_0x002a:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            r2 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r3, r2)     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            r3 = r1
        L_0x0032:
            boolean r1 = r5.f(r3)     // Catch:{ all -> 0x003d }
            tb.c.a(r3, r0)     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            r6.destroy()
            goto L_0x0056
        L_0x003d:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x003f }
        L_0x003f:
            r1 = move-exception
            tb.c.a(r3, r0)     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            throw r1     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
        L_0x0044:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x0048:
            if (r6 != 0) goto L_0x004b
            goto L_0x004e
        L_0x004b:
            r6.destroy()
        L_0x004e:
            throw r0
        L_0x004f:
            if (r0 != 0) goto L_0x0052
            goto L_0x0055
        L_0x0052:
            r0.destroy()
        L_0x0055:
            r1 = 0
        L_0x0056:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.RootDetector.e(java.lang.ProcessBuilder):boolean");
    }

    public final boolean g() {
        try {
            if (b() || d() || a() || c() || h()) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            this.f18596d.c("Root detection failed", th);
            return false;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RootDetector(x0 x0Var, List list, File file, s2 s2Var, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? x0.f19119j.a() : x0Var, (i10 & 2) != 0 ? f18592h : list, (i10 & 4) != 0 ? f18591g : file, s2Var);
    }
}
