package q5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import q5.s0;
import q5.w;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f23513a;

    /* renamed from: b  reason: collision with root package name */
    private static final s0 f23514b = new s0(8, (Executor) null, 2, (DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private static final s0 f23515c = new s0(2, (Executor) null, 2, (DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    private static final Map f23516d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final v f23517e = new v();

    private static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final d f23518a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f23519b;

        public a(d dVar, boolean z10) {
            m.f(dVar, "key");
            this.f23518a = dVar;
            this.f23519b = z10;
        }

        public void run() {
            if (!v5.a.d(this)) {
                try {
                    v.f23517e.k(this.f23518a, this.f23519b);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    private static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final d f23520a;

        public b(d dVar) {
            m.f(dVar, "key");
            this.f23520a = dVar;
        }

        public void run() {
            if (!v5.a.d(this)) {
                try {
                    v.f23517e.d(this.f23520a);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private s0.b f23521a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f23522b;

        /* renamed from: c  reason: collision with root package name */
        private w f23523c;

        public c(w wVar) {
            m.f(wVar, "request");
            this.f23523c = wVar;
        }

        public final w a() {
            return this.f23523c;
        }

        public final s0.b b() {
            return this.f23521a;
        }

        public final boolean c() {
            return this.f23522b;
        }

        public final void d(boolean z10) {
            this.f23522b = z10;
        }

        public final void e(w wVar) {
            m.f(wVar, "<set-?>");
            this.f23523c = wVar;
        }

        public final void f(s0.b bVar) {
            this.f23521a = bVar;
        }
    }

    public static final class d {

        /* renamed from: c  reason: collision with root package name */
        public static final a f23524c = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private Uri f23525a;

        /* renamed from: b  reason: collision with root package name */
        private Object f23526b;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public d(Uri uri, Object obj) {
            m.f(uri, "uri");
            m.f(obj, "tag");
            this.f23525a = uri;
            this.f23526b = obj;
        }

        public final Object a() {
            return this.f23526b;
        }

        public final Uri b() {
            return this.f23525a;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (dVar.f23525a == this.f23525a && dVar.f23526b == this.f23526b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((1073 + this.f23525a.hashCode()) * 37) + this.f23526b.hashCode();
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f23527a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Exception f23528b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f23529c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Bitmap f23530d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ w.b f23531e;

        e(w wVar, Exception exc, boolean z10, Bitmap bitmap, w.b bVar) {
            this.f23527a = wVar;
            this.f23528b = exc;
            this.f23529c = z10;
            this.f23530d = bitmap;
            this.f23531e = bVar;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    this.f23531e.a(new x(this.f23527a, this.f23528b, this.f23529c, this.f23530d));
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    private v() {
    }

    public static final boolean c(w wVar) {
        boolean z10;
        m.f(wVar, "request");
        d dVar = new d(wVar.c(), wVar.b());
        Map map = f23516d;
        synchronized (map) {
            try {
                c cVar = (c) map.get(dVar);
                if (cVar != null) {
                    s0.b b10 = cVar.b();
                    z10 = true;
                    if (b10 == null || !b10.cancel()) {
                        cVar.d(true);
                    } else {
                        map.remove(dVar);
                    }
                } else {
                    z10 = false;
                }
                Unit unit = Unit.f12577a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.io.IOException} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006a, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00aa, code lost:
        r5 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ab, code lost:
        r2 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0018] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(q5.v.d r11) {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            r2 = 1
            java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00c6, all -> 0x00c3 }
            android.net.Uri r4 = r11.b()     // Catch:{ IOException -> 0x00c6, all -> 0x00c3 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00c6, all -> 0x00c3 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00c6, all -> 0x00c3 }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x00c6, all -> 0x00c3 }
            if (r3 == 0) goto L_0x00ca
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x00c6, all -> 0x00c3 }
            r3.setInstanceFollowRedirects(r0)     // Catch:{ IOException -> 0x006d, all -> 0x006a }
            int r4 = r3.getResponseCode()     // Catch:{ IOException -> 0x006d, all -> 0x006a }
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 == r5) goto L_0x00b1
            r5 = 301(0x12d, float:4.22E-43)
            if (r4 == r5) goto L_0x0071
            r5 = 302(0x12e, float:4.23E-43)
            if (r4 == r5) goto L_0x0071
            java.io.InputStream r4 = r3.getErrorStream()     // Catch:{ IOException -> 0x006d, all -> 0x006a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            r5.<init>()     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            if (r4 == 0) goto L_0x0054
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            r6.<init>(r4)     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            r7 = 128(0x80, float:1.794E-43)
            char[] r8 = new char[r7]     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
        L_0x003f:
            int r9 = r6.read(r8, r0, r7)     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            if (r9 <= 0) goto L_0x0050
            r5.append(r8, r0, r9)     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            goto L_0x003f
        L_0x0049:
            r11 = move-exception
            r1 = r4
            goto L_0x00d2
        L_0x004d:
            r5 = move-exception
            goto L_0x00d9
        L_0x0050:
            q5.p0.i(r6)     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            goto L_0x005e
        L_0x0054:
            java.lang.String r6 = "Unexpected error while downloading an image."
            r5.append(r6)     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            java.lang.String r6 = "errorMessageBuilder.appe…e downloading an image.\")"
            kotlin.jvm.internal.m.e(r5, r6)     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
        L_0x005e:
            com.facebook.l r6 = new com.facebook.l     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            r6.<init>((java.lang.String) r5)     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            r5 = r1
        L_0x0068:
            r1 = r4
            goto L_0x00bb
        L_0x006a:
            r11 = move-exception
            goto L_0x00d2
        L_0x006d:
            r5 = move-exception
        L_0x006e:
            r4 = r1
            goto L_0x00d9
        L_0x0071:
            java.lang.String r2 = "location"
            java.lang.String r2 = r3.getHeaderField(r2)     // Catch:{ IOException -> 0x00aa, all -> 0x006a }
            boolean r4 = q5.p0.Y(r2)     // Catch:{ IOException -> 0x00aa, all -> 0x006a }
            if (r4 != 0) goto L_0x00ad
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ IOException -> 0x00aa, all -> 0x006a }
            android.net.Uri r4 = r11.b()     // Catch:{ IOException -> 0x00aa, all -> 0x006a }
            q5.k0.a(r4, r2)     // Catch:{ IOException -> 0x00aa, all -> 0x006a }
            q5.v$c r4 = r10.l(r11)     // Catch:{ IOException -> 0x00aa, all -> 0x006a }
            if (r4 == 0) goto L_0x00ad
            boolean r5 = r4.c()     // Catch:{ IOException -> 0x00aa, all -> 0x006a }
            if (r5 != 0) goto L_0x00ad
            q5.w r4 = r4.a()     // Catch:{ IOException -> 0x00aa, all -> 0x006a }
            q5.v$d r5 = new q5.v$d     // Catch:{ IOException -> 0x00aa, all -> 0x006a }
            java.lang.String r6 = "redirectUri"
            kotlin.jvm.internal.m.e(r2, r6)     // Catch:{ IOException -> 0x00aa, all -> 0x006a }
            java.lang.Object r6 = r11.a()     // Catch:{ IOException -> 0x00aa, all -> 0x006a }
            r5.<init>(r2, r6)     // Catch:{ IOException -> 0x00aa, all -> 0x006a }
            r10.f(r4, r5, r0)     // Catch:{ IOException -> 0x00aa, all -> 0x006a }
            goto L_0x00ad
        L_0x00aa:
            r5 = move-exception
            r2 = r0
            goto L_0x006e
        L_0x00ad:
            r2 = r0
            r5 = r1
            r6 = r5
            goto L_0x00bb
        L_0x00b1:
            java.io.InputStream r4 = q5.y.c(r3)     // Catch:{ IOException -> 0x006d, all -> 0x006a }
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r4)     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            r6 = r1
            goto L_0x0068
        L_0x00bb:
            q5.p0.i(r1)
            q5.p0.q(r3)
            r1 = r5
            goto L_0x00e0
        L_0x00c3:
            r11 = move-exception
            r3 = r1
            goto L_0x00d2
        L_0x00c6:
            r5 = move-exception
            r3 = r1
            r4 = r3
            goto L_0x00d9
        L_0x00ca:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch:{ IOException -> 0x00c6, all -> 0x00c3 }
            java.lang.String r4 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r3.<init>(r4)     // Catch:{ IOException -> 0x00c6, all -> 0x00c3 }
            throw r3     // Catch:{ IOException -> 0x00c6, all -> 0x00c3 }
        L_0x00d2:
            q5.p0.i(r1)
            q5.p0.q(r3)
            throw r11
        L_0x00d9:
            q5.p0.i(r4)
            q5.p0.q(r3)
            r6 = r5
        L_0x00e0:
            if (r2 == 0) goto L_0x00e5
            r10.j(r11, r6, r1, r0)
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.v.d(q5.v$d):void");
    }

    public static final void e(w wVar) {
        if (wVar != null) {
            d dVar = new d(wVar.c(), wVar.b());
            Map map = f23516d;
            synchronized (map) {
                try {
                    c cVar = (c) map.get(dVar);
                    if (cVar != null) {
                        cVar.e(wVar);
                        cVar.d(false);
                        s0.b b10 = cVar.b();
                        if (b10 != null) {
                            b10.a();
                            Unit unit = Unit.f12577a;
                        }
                    } else {
                        f23517e.f(wVar, dVar, wVar.e());
                        Unit unit2 = Unit.f12577a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private final void f(w wVar, d dVar, boolean z10) {
        h(wVar, dVar, f23515c, new a(dVar, z10));
    }

    private final void g(w wVar, d dVar) {
        h(wVar, dVar, f23514b, new b(dVar));
    }

    private final void h(w wVar, d dVar, s0 s0Var, Runnable runnable) {
        Map map = f23516d;
        synchronized (map) {
            c cVar = new c(wVar);
            map.put(dVar, cVar);
            cVar.f(s0.g(s0Var, runnable, false, 2, (Object) null));
            Unit unit = Unit.f12577a;
        }
    }

    private final synchronized Handler i() {
        try {
            if (f23513a == null) {
                f23513a = new Handler(Looper.getMainLooper());
            }
        } catch (Throwable th) {
            throw th;
        }
        return f23513a;
    }

    private final void j(d dVar, Exception exc, Bitmap bitmap, boolean z10) {
        w.b bVar;
        Handler i10;
        c l10 = l(dVar);
        if (l10 != null && !l10.c()) {
            w a10 = l10.a();
            if (a10 != null) {
                bVar = a10.a();
            } else {
                bVar = null;
            }
            w.b bVar2 = bVar;
            if (bVar2 != null && (i10 = i()) != null) {
                i10.post(new e(a10, exc, z10, bitmap, bVar2));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void k(d dVar, boolean z10) {
        InputStream inputStream;
        Uri c10;
        w wVar = null;
        boolean z11 = false;
        if (!z10 || (c10 = k0.c(dVar.b())) == null) {
            inputStream = null;
        } else {
            inputStream = y.b(c10);
            if (inputStream != null) {
                z11 = true;
            }
        }
        if (!z11) {
            inputStream = y.b(dVar.b());
        }
        if (inputStream != null) {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            p0.i(inputStream);
            j(dVar, (Exception) null, decodeStream, z11);
            return;
        }
        c l10 = l(dVar);
        if (l10 != null) {
            wVar = l10.a();
        }
        if (l10 != null && !l10.c() && wVar != null) {
            g(wVar, dVar);
        }
    }

    private final c l(d dVar) {
        c cVar;
        Map map = f23516d;
        synchronized (map) {
            cVar = (c) map.remove(dVar);
        }
        return cVar;
    }
}
