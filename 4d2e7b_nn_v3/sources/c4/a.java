package c4;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import b4.a;
import b4.c;
import e4.a;
import e4.b;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import w4.d;

public final class a implements b4.a, c.b {

    /* renamed from: r  reason: collision with root package name */
    public static final C0224a f17295r = new C0224a((DefaultConstructorMarker) null);

    /* renamed from: s  reason: collision with root package name */
    private static final Class f17296s = a.class;

    /* renamed from: a  reason: collision with root package name */
    private final d f17297a;

    /* renamed from: b  reason: collision with root package name */
    private final b f17298b;

    /* renamed from: c  reason: collision with root package name */
    private final b4.d f17299c;

    /* renamed from: d  reason: collision with root package name */
    private final c f17300d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f17301e;

    /* renamed from: f  reason: collision with root package name */
    private final e4.a f17302f;

    /* renamed from: g  reason: collision with root package name */
    private final b f17303g;

    /* renamed from: h  reason: collision with root package name */
    private final float[] f17304h = null;

    /* renamed from: i  reason: collision with root package name */
    private final Bitmap.Config f17305i = Bitmap.Config.ARGB_8888;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f17306j = new Paint(6);

    /* renamed from: k  reason: collision with root package name */
    private Rect f17307k;

    /* renamed from: l  reason: collision with root package name */
    private int f17308l;

    /* renamed from: m  reason: collision with root package name */
    private int f17309m;

    /* renamed from: n  reason: collision with root package name */
    private final Path f17310n = new Path();

    /* renamed from: o  reason: collision with root package name */
    private final Matrix f17311o = new Matrix();

    /* renamed from: p  reason: collision with root package name */
    private int f17312p = -1;

    /* renamed from: q  reason: collision with root package name */
    private a.C0221a f17313q;

    /* renamed from: c4.a$a  reason: collision with other inner class name */
    public static final class C0224a {
        private C0224a() {
        }

        public /* synthetic */ C0224a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(d dVar, b bVar, b4.d dVar2, c cVar, boolean z10, e4.a aVar, b bVar2, n4.d dVar3) {
        m.f(dVar, "platformBitmapFactory");
        m.f(bVar, "bitmapFrameCache");
        m.f(dVar2, "animationInformation");
        m.f(cVar, "bitmapFrameRenderer");
        this.f17297a = dVar;
        this.f17298b = bVar;
        this.f17299c = dVar2;
        this.f17300d = cVar;
        this.f17301e = z10;
        this.f17302f = aVar;
        this.f17303g = bVar2;
        q();
    }

    private final void m(int i10, Bitmap bitmap, Canvas canvas) {
        Rect rect = this.f17307k;
        if (rect == null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f17306j);
        } else if (r(i10, bitmap, (float) rect.width(), (float) rect.height())) {
            canvas.drawPath(this.f17310n, this.f17306j);
        } else {
            canvas.drawBitmap(bitmap, (Rect) null, rect, this.f17306j);
        }
    }

    private final boolean n(int i10, c3.a aVar, Canvas canvas, int i11) {
        if (aVar == null || !c3.a.y(aVar)) {
            return false;
        }
        Object p10 = aVar.p();
        m.e(p10, "bitmapReference.get()");
        m(i10, (Bitmap) p10, canvas);
        if (i11 == 3 || this.f17301e) {
            return true;
        }
        this.f17298b.e(i10, aVar, i11);
        return true;
    }

    private final boolean o(Canvas canvas, int i10, int i11) {
        boolean z10;
        c3.a aVar;
        c3.a aVar2 = null;
        try {
            boolean z11 = false;
            int i12 = 1;
            if (this.f17301e) {
                e4.a aVar3 = this.f17302f;
                if (aVar3 != null) {
                    aVar = aVar3.b(i10, canvas.getWidth(), canvas.getHeight());
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    try {
                        if (aVar.w()) {
                            Object p10 = aVar.p();
                            m.e(p10, "bitmapReference.get()");
                            m(i10, (Bitmap) p10, canvas);
                            c3.a.m(aVar);
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        aVar2 = aVar;
                        c3.a.m(aVar2);
                        throw th;
                    }
                }
                e4.a aVar4 = this.f17302f;
                if (aVar4 != null) {
                    aVar4.a(canvas.getWidth(), canvas.getHeight(), (Function0) null);
                }
                c3.a.m(aVar);
                return false;
            }
            if (i11 == 0) {
                aVar2 = this.f17298b.d(i10);
                z10 = n(i10, aVar2, canvas, 0);
            } else if (i11 == 1) {
                aVar2 = this.f17298b.c(i10, this.f17308l, this.f17309m);
                if (p(i10, aVar2) && n(i10, aVar2, canvas, 1)) {
                    z11 = true;
                }
                z10 = z11;
                i12 = 2;
            } else if (i11 == 2) {
                aVar2 = this.f17297a.b(this.f17308l, this.f17309m, this.f17305i);
                if (p(i10, aVar2) && n(i10, aVar2, canvas, 2)) {
                    z11 = true;
                }
                z10 = z11;
                i12 = 3;
            } else if (i11 != 3) {
                c3.a.m((c3.a) null);
                return false;
            } else {
                aVar2 = this.f17298b.f(i10);
                z10 = n(i10, aVar2, canvas, 3);
                i12 = -1;
            }
            c3.a.m(aVar2);
            if (z10 || i12 == -1) {
                return z10;
            }
            return o(canvas, i10, i12);
        } catch (RuntimeException e10) {
            z2.a.D(f17296s, "Failed to create frame bitmap", e10);
            c3.a.m((c3.a) null);
            return false;
        } catch (Throwable th2) {
            th = th2;
            c3.a.m(aVar2);
            throw th;
        }
    }

    private final boolean p(int i10, c3.a aVar) {
        if (aVar == null || !aVar.w()) {
            return false;
        }
        c cVar = this.f17300d;
        Object p10 = aVar.p();
        m.e(p10, "targetBitmap.get()");
        boolean d10 = cVar.d(i10, (Bitmap) p10);
        if (!d10) {
            c3.a.m(aVar);
        }
        return d10;
    }

    private final void q() {
        int i10;
        int c10 = this.f17300d.c();
        this.f17308l = c10;
        int i11 = -1;
        if (c10 == -1) {
            Rect rect = this.f17307k;
            if (rect != null) {
                i10 = rect.width();
            } else {
                i10 = -1;
            }
            this.f17308l = i10;
        }
        int a10 = this.f17300d.a();
        this.f17309m = a10;
        if (a10 == -1) {
            Rect rect2 = this.f17307k;
            if (rect2 != null) {
                i11 = rect2.height();
            }
            this.f17309m = i11;
        }
    }

    private final boolean r(int i10, Bitmap bitmap, float f10, float f11) {
        if (this.f17304h == null) {
            return false;
        }
        if (i10 == this.f17312p) {
            return true;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f17311o.setRectToRect(new RectF(0.0f, 0.0f, (float) this.f17308l, (float) this.f17309m), new RectF(0.0f, 0.0f, f10, f11), Matrix.ScaleToFit.FILL);
        bitmapShader.setLocalMatrix(this.f17311o);
        this.f17306j.setShader(bitmapShader);
        this.f17310n.addRoundRect(new RectF(0.0f, 0.0f, f10, f11), this.f17304h, Path.Direction.CW);
        this.f17312p = i10;
        return true;
    }

    public int a() {
        return this.f17309m;
    }

    public void b(Rect rect) {
        this.f17307k = rect;
        this.f17300d.b(rect);
        q();
    }

    public int c() {
        return this.f17308l;
    }

    public void clear() {
        if (this.f17301e) {
            e4.a aVar = this.f17302f;
            if (aVar != null) {
                aVar.c();
                return;
            }
            return;
        }
        this.f17298b.clear();
    }

    public void d() {
        if (this.f17301e) {
            e4.a aVar = this.f17302f;
            if (aVar != null) {
                aVar.onStop();
                return;
            }
            return;
        }
        clear();
    }

    public void e(ColorFilter colorFilter) {
        this.f17306j.setColorFilter(colorFilter);
    }

    public int f() {
        return this.f17299c.f();
    }

    public int g() {
        return this.f17299c.g();
    }

    public int getFrameCount() {
        return this.f17299c.getFrameCount();
    }

    public int getLoopCount() {
        return this.f17299c.getLoopCount();
    }

    public void h(a.C0221a aVar) {
        this.f17313q = aVar;
    }

    public int i(int i10) {
        return this.f17299c.i(i10);
    }

    public void j(int i10) {
        this.f17306j.setAlpha(i10);
    }

    public int k() {
        return this.f17299c.k();
    }

    public boolean l(Drawable drawable, Canvas canvas, int i10) {
        b bVar;
        e4.a aVar;
        m.f(drawable, "parent");
        m.f(canvas, "canvas");
        boolean o10 = o(canvas, i10, 0);
        if (!(this.f17301e || (bVar = this.f17303g) == null || (aVar = this.f17302f) == null)) {
            a.C0267a.f(aVar, bVar, this.f17298b, this, i10, (Function0) null, 16, (Object) null);
        }
        return o10;
    }
}
