package h5;

import android.graphics.Bitmap;
import b3.d;

public class t implements i {

    /* renamed from: a  reason: collision with root package name */
    protected final a0 f21979a = new j();

    /* renamed from: b  reason: collision with root package name */
    private final int f21980b;

    /* renamed from: c  reason: collision with root package name */
    private int f21981c;

    /* renamed from: d  reason: collision with root package name */
    private final g0 f21982d;

    /* renamed from: e  reason: collision with root package name */
    private int f21983e;

    public t(int i10, int i11, g0 g0Var, d dVar) {
        this.f21980b = i10;
        this.f21981c = i11;
        this.f21982d = g0Var;
        if (dVar != null) {
            dVar.a(this);
        }
    }

    private Bitmap g(int i10) {
        this.f21982d.a(i10);
        return Bitmap.createBitmap(1, i10, Bitmap.Config.ALPHA_8);
    }

    private synchronized void j(int i10) {
        while (true) {
            if (this.f21983e <= i10) {
                break;
            }
            Bitmap bitmap = (Bitmap) this.f21979a.pop();
            if (bitmap == null) {
                break;
            }
            int a10 = this.f21979a.a(bitmap);
            this.f21983e -= a10;
            this.f21982d.e(a10);
        }
    }

    /* renamed from: h */
    public synchronized Bitmap get(int i10) {
        try {
            int i11 = this.f21983e;
            int i12 = this.f21980b;
            if (i11 > i12) {
                j(i12);
            }
            Bitmap bitmap = (Bitmap) this.f21979a.get(i10);
            if (bitmap != null) {
                int a10 = this.f21979a.a(bitmap);
                this.f21983e -= a10;
                this.f21982d.b(a10);
                return bitmap;
            }
            return g(i10);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: i */
    public void release(Bitmap bitmap) {
        int a10 = this.f21979a.a(bitmap);
        if (a10 <= this.f21981c) {
            this.f21982d.g(a10);
            this.f21979a.put(bitmap);
            synchronized (this) {
                this.f21983e += a10;
            }
        }
    }
}
