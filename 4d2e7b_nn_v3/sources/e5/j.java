package e5;

import android.graphics.ColorSpace;
import c3.a;
import java.io.Closeable;
import java.io.InputStream;
import kotlin.Pair;
import o5.e;
import o5.h;
import q4.b;
import q4.c;
import q4.d;
import y2.l;
import y2.o;

public class j implements Closeable {
    private static boolean Y;
    private String C;
    private boolean X;

    /* renamed from: a  reason: collision with root package name */
    private final a f21271a;

    /* renamed from: b  reason: collision with root package name */
    private final o f21272b;

    /* renamed from: c  reason: collision with root package name */
    private c f21273c;

    /* renamed from: d  reason: collision with root package name */
    private int f21274d;

    /* renamed from: e  reason: collision with root package name */
    private int f21275e;

    /* renamed from: f  reason: collision with root package name */
    private int f21276f;

    /* renamed from: g  reason: collision with root package name */
    private int f21277g;

    /* renamed from: h  reason: collision with root package name */
    private int f21278h;

    /* renamed from: i  reason: collision with root package name */
    private int f21279i;

    /* renamed from: j  reason: collision with root package name */
    private y4.a f21280j;

    /* renamed from: w  reason: collision with root package name */
    private ColorSpace f21281w;

    public j(a aVar) {
        this.f21273c = c.f23230d;
        this.f21274d = -1;
        this.f21275e = 0;
        this.f21276f = -1;
        this.f21277g = -1;
        this.f21278h = 1;
        this.f21279i = -1;
        l.b(Boolean.valueOf(a.y(aVar)));
        this.f21271a = aVar.b();
        this.f21272b = null;
    }

    private void E() {
        Pair pair;
        c c10 = d.c(w());
        this.f21273c = c10;
        if (b.b(c10)) {
            pair = N();
        } else {
            pair = M().b();
        }
        if (c10 == b.f23216b && this.f21274d == -1) {
            if (pair != null) {
                int b10 = e.b(w());
                this.f21275e = b10;
                this.f21274d = e.a(b10);
            }
        } else if (c10 == b.f23226l && this.f21274d == -1) {
            int a10 = o5.c.a(w());
            this.f21275e = a10;
            this.f21274d = e.a(a10);
        } else if (this.f21274d == -1) {
            this.f21274d = 0;
        }
    }

    public static boolean H(j jVar) {
        if (jVar.f21274d < 0 || jVar.f21276f < 0 || jVar.f21277g < 0) {
            return false;
        }
        return true;
    }

    public static boolean J(j jVar) {
        if (jVar == null || !jVar.I()) {
            return false;
        }
        return true;
    }

    private void L() {
        if (this.f21276f < 0 || this.f21277g < 0) {
            K();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A[SYNTHETIC, Splitter:B:15:0x0039] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private o5.d M() {
        /*
            r4 = this;
            java.io.InputStream r0 = r4.w()     // Catch:{ all -> 0x0035 }
            o5.d r1 = o5.a.c(r0)     // Catch:{ all -> 0x002d }
            android.graphics.ColorSpace r2 = r1.a()     // Catch:{ all -> 0x002d }
            r4.f21281w = r2     // Catch:{ all -> 0x002d }
            kotlin.Pair r2 = r1.b()     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002f
            java.lang.Object r3 = r2.a()     // Catch:{ all -> 0x002d }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x002d }
            int r3 = r3.intValue()     // Catch:{ all -> 0x002d }
            r4.f21276f = r3     // Catch:{ all -> 0x002d }
            java.lang.Object r2 = r2.b()     // Catch:{ all -> 0x002d }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x002d }
            int r2 = r2.intValue()     // Catch:{ all -> 0x002d }
            r4.f21277g = r2     // Catch:{ all -> 0x002d }
            goto L_0x002f
        L_0x002d:
            r1 = move-exception
            goto L_0x0037
        L_0x002f:
            if (r0 == 0) goto L_0x0034
            r0.close()     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            return r1
        L_0x0035:
            r1 = move-exception
            r0 = 0
        L_0x0037:
            if (r0 == 0) goto L_0x003c
            r0.close()     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.j.M():o5.d");
    }

    private Pair N() {
        InputStream w10 = w();
        if (w10 == null) {
            return null;
        }
        Pair f10 = h.f(w10);
        if (f10 != null) {
            this.f21276f = ((Integer) f10.a()).intValue();
            this.f21277g = ((Integer) f10.b()).intValue();
        }
        return f10;
    }

    public static j b(j jVar) {
        if (jVar != null) {
            return jVar.a();
        }
        return null;
    }

    public static void h(j jVar) {
        if (jVar != null) {
            jVar.close();
        }
    }

    public int A() {
        a aVar = this.f21271a;
        if (aVar == null || aVar.p() == null) {
            return this.f21279i;
        }
        return ((b3.h) this.f21271a.p()).size();
    }

    public String B() {
        return this.C;
    }

    /* access modifiers changed from: protected */
    public boolean C() {
        return this.X;
    }

    public int F() {
        L();
        return this.f21275e;
    }

    public boolean G(int i10) {
        c cVar = this.f21273c;
        if ((cVar != b.f23216b && cVar != b.f23227m) || this.f21272b != null) {
            return true;
        }
        l.g(this.f21271a);
        b3.h hVar = (b3.h) this.f21271a.p();
        if (hVar.c(i10 - 2) == -1 && hVar.c(i10 - 1) == -39) {
            return true;
        }
        return false;
    }

    public synchronized boolean I() {
        boolean z10;
        if (a.y(this.f21271a) || this.f21272b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }

    public void K() {
        if (!Y) {
            E();
        } else if (!this.X) {
            E();
            this.X = true;
        }
    }

    public void O(y4.a aVar) {
        this.f21280j = aVar;
    }

    public void P(int i10) {
        this.f21275e = i10;
    }

    public void Q(int i10) {
        this.f21277g = i10;
    }

    public void R(c cVar) {
        this.f21273c = cVar;
    }

    public void S(int i10) {
        this.f21274d = i10;
    }

    public void T(int i10) {
        this.f21278h = i10;
    }

    public void U(String str) {
        this.C = str;
    }

    public void V(int i10) {
        this.f21276f = i10;
    }

    public j a() {
        j jVar;
        o oVar = this.f21272b;
        if (oVar != null) {
            jVar = new j(oVar, this.f21279i);
        } else {
            a j10 = a.j(this.f21271a);
            if (j10 == null) {
                jVar = null;
            } else {
                try {
                    jVar = new j(j10);
                } catch (Throwable th) {
                    a.m(j10);
                    throw th;
                }
            }
            a.m(j10);
        }
        if (jVar != null) {
            jVar.j(this);
        }
        return jVar;
    }

    public void close() {
        a.m(this.f21271a);
    }

    public int getHeight() {
        L();
        return this.f21277g;
    }

    public int getWidth() {
        L();
        return this.f21276f;
    }

    public void j(j jVar) {
        this.f21273c = jVar.v();
        this.f21276f = jVar.getWidth();
        this.f21277g = jVar.getHeight();
        this.f21274d = jVar.l();
        this.f21275e = jVar.F();
        this.f21278h = jVar.z();
        this.f21279i = jVar.A();
        this.f21280j = jVar.m();
        this.f21281w = jVar.n();
        this.X = jVar.C();
    }

    public a k() {
        return a.j(this.f21271a);
    }

    public int l() {
        L();
        return this.f21274d;
    }

    public y4.a m() {
        return this.f21280j;
    }

    public ColorSpace n() {
        L();
        return this.f21281w;
    }

    public String p(int i10) {
        a k10 = k();
        if (k10 == null) {
            return "";
        }
        int min = Math.min(A(), i10);
        byte[] bArr = new byte[min];
        try {
            b3.h hVar = (b3.h) k10.p();
            if (hVar == null) {
                return "";
            }
            hVar.d(0, bArr, 0, min);
            k10.close();
            StringBuilder sb2 = new StringBuilder(min * 2);
            for (int i11 = 0; i11 < min; i11++) {
                sb2.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i11])}));
            }
            return sb2.toString();
        } finally {
            k10.close();
        }
    }

    public c v() {
        L();
        return this.f21273c;
    }

    public InputStream w() {
        o oVar = this.f21272b;
        if (oVar != null) {
            return (InputStream) oVar.get();
        }
        a j10 = a.j(this.f21271a);
        if (j10 == null) {
            return null;
        }
        try {
            return new b3.j((b3.h) j10.p());
        } finally {
            a.m(j10);
        }
    }

    public InputStream y() {
        return (InputStream) l.g(w());
    }

    public int z() {
        return this.f21278h;
    }

    public j(o oVar) {
        this.f21273c = c.f23230d;
        this.f21274d = -1;
        this.f21275e = 0;
        this.f21276f = -1;
        this.f21277g = -1;
        this.f21278h = 1;
        this.f21279i = -1;
        l.g(oVar);
        this.f21271a = null;
        this.f21272b = oVar;
    }

    public j(o oVar, int i10) {
        this(oVar);
        this.f21279i = i10;
    }
}
