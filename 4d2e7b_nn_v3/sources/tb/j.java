package tb;

import java.io.File;
import java.nio.charset.Charset;
import kotlin.jvm.internal.m;
import kotlin.text.d;

class j extends i {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        tb.c.a(r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.io.File r2, byte[] r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.m.f(r2, r0)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.m.f(r3, r0)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r1 = 1
            r0.<init>(r2, r1)
            r0.write(r3)     // Catch:{ all -> 0x001a }
            kotlin.Unit r2 = kotlin.Unit.f12577a     // Catch:{ all -> 0x001a }
            r2 = 0
            tb.c.a(r0, r2)
            return
        L_0x001a:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001c }
        L_0x001c:
            r3 = move-exception
            tb.c.a(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.j.a(java.io.File, byte[]):void");
    }

    public static final void b(File file, String str, Charset charset) {
        m.f(file, "<this>");
        m.f(str, "text");
        m.f(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        m.e(bytes, "getBytes(...)");
        h.a(file, bytes);
    }

    public static /* synthetic */ void c(File file, String str, Charset charset, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            charset = d.f797b;
        }
        b(file, str, charset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        tb.c.a(r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String d(java.io.File r2, java.nio.charset.Charset r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.m.f(r2, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.m.f(r3, r0)
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r2)
            r0.<init>(r1, r3)
            java.lang.String r2 = tb.o.f(r0)     // Catch:{ all -> 0x001d }
            r3 = 0
            tb.c.a(r0, r3)
            return r2
        L_0x001d:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001f }
        L_0x001f:
            r3 = move-exception
            tb.c.a(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.j.d(java.io.File, java.nio.charset.Charset):java.lang.String");
    }

    public static /* synthetic */ String e(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = d.f797b;
        }
        return d(file, charset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        tb.c.a(r0, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void f(java.io.File r1, byte[] r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.m.f(r1, r0)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.m.f(r2, r0)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r1)
            r0.write(r2)     // Catch:{ all -> 0x0019 }
            kotlin.Unit r1 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0019 }
            r1 = 0
            tb.c.a(r0, r1)
            return
        L_0x0019:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x001b }
        L_0x001b:
            r2 = move-exception
            tb.c.a(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.j.f(java.io.File, byte[]):void");
    }

    public static final void g(File file, String str, Charset charset) {
        m.f(file, "<this>");
        m.f(str, "text");
        m.f(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        m.e(bytes, "getBytes(...)");
        f(file, bytes);
    }

    public static /* synthetic */ void h(File file, String str, Charset charset, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            charset = d.f797b;
        }
        g(file, str, charset);
    }
}
