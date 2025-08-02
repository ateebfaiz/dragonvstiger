package e5;

import android.graphics.Bitmap;
import c3.a;
import c3.h;
import y2.l;

public class b extends a implements g {

    /* renamed from: i  reason: collision with root package name */
    private static boolean f21263i;

    /* renamed from: d  reason: collision with root package name */
    private a f21264d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Bitmap f21265e;

    /* renamed from: f  reason: collision with root package name */
    private final o f21266f;

    /* renamed from: g  reason: collision with root package name */
    private final int f21267g;

    /* renamed from: h  reason: collision with root package name */
    private final int f21268h;

    protected b(Bitmap bitmap, h hVar, o oVar, int i10, int i11) {
        this.f21265e = (Bitmap) l.g(bitmap);
        this.f21264d = a.B(this.f21265e, (h) l.g(hVar));
        this.f21266f = oVar;
        this.f21267g = i10;
        this.f21268h = i11;
    }

    private synchronized a C() {
        a aVar;
        aVar = this.f21264d;
        this.f21264d = null;
        this.f21265e = null;
        return aVar;
    }

    private static int E(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    private static int G(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    public static boolean H() {
        return f21263i;
    }

    public int F() {
        return this.f21268h;
    }

    public void close() {
        a C = C();
        if (C != null) {
            C.close();
        }
    }

    public int g() {
        return o5.a.g(this.f21265e);
    }

    public int getHeight() {
        int i10;
        if (this.f21267g % 180 != 0 || (i10 = this.f21268h) == 5 || i10 == 7) {
            return G(this.f21265e);
        }
        return E(this.f21265e);
    }

    public int getWidth() {
        int i10;
        if (this.f21267g % 180 != 0 || (i10 = this.f21268h) == 5 || i10 == 7) {
            return E(this.f21265e);
        }
        return G(this.f21265e);
    }

    public synchronized a i() {
        return a.j(this.f21264d);
    }

    public synchronized boolean isClosed() {
        boolean z10;
        if (this.f21264d == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }

    public int l() {
        return this.f21267g;
    }

    public o s() {
        return this.f21266f;
    }

    public Bitmap x() {
        return this.f21265e;
    }

    protected b(a aVar, o oVar, int i10, int i11) {
        a aVar2 = (a) l.g(aVar.h());
        this.f21264d = aVar2;
        this.f21265e = (Bitmap) aVar2.p();
        this.f21266f = oVar;
        this.f21267g = i10;
        this.f21268h = i11;
    }
}
