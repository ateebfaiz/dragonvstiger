package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import r0.e;
import r0.h;
import u0.c;
import w0.v;
import y0.f;
import y0.g;
import y0.i;
import y0.k;

public class k0 extends Drawable implements Drawable.Callback, Animatable {

    /* renamed from: r1  reason: collision with root package name */
    private static final boolean f17679r1;

    /* renamed from: s1  reason: collision with root package name */
    private static final List f17680s1 = Arrays.asList(new String[]{"reduced motion", "reduced_motion", "reduced-motion", "reducedmotion"});

    /* renamed from: t1  reason: collision with root package name */
    private static final Executor f17681t1 = new ThreadPoolExecutor(0, 2, 35, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new g());
    String C;
    private boolean N0 = false;
    private boolean O0 = true;
    private c P0;
    private int Q0 = 255;
    private boolean R0;
    private boolean S0;
    private boolean T0;
    private boolean U0 = false;
    private y0 V0 = y0.AUTOMATIC;
    private boolean W0 = false;
    b X;
    private final Matrix X0 = new Matrix();
    a1 Y;
    private Bitmap Y0;
    private final m0 Z = new m0();
    private Canvas Z0;

    /* renamed from: a  reason: collision with root package name */
    private j f17682a;

    /* renamed from: a1  reason: collision with root package name */
    private Rect f17683a1;

    /* renamed from: b  reason: collision with root package name */
    private final i f17684b;

    /* renamed from: b1  reason: collision with root package name */
    private RectF f17685b1;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17686c = true;

    /* renamed from: c1  reason: collision with root package name */
    private Paint f17687c1;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17688d = false;

    /* renamed from: d1  reason: collision with root package name */
    private Rect f17689d1;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17690e = false;

    /* renamed from: e1  reason: collision with root package name */
    private Rect f17691e1;

    /* renamed from: f  reason: collision with root package name */
    private b f17692f = b.NONE;

    /* renamed from: f1  reason: collision with root package name */
    private RectF f17693f1;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList f17694g = new ArrayList();

    /* renamed from: g1  reason: collision with root package name */
    private RectF f17695g1;

    /* renamed from: h  reason: collision with root package name */
    private q0.b f17696h;

    /* renamed from: h1  reason: collision with root package name */
    private Matrix f17697h1;

    /* renamed from: i  reason: collision with root package name */
    private String f17698i;

    /* renamed from: i1  reason: collision with root package name */
    private Matrix f17699i1;

    /* renamed from: j  reason: collision with root package name */
    private q0.a f17700j;

    /* renamed from: j1  reason: collision with root package name */
    private boolean f17701j1 = false;

    /* renamed from: k1  reason: collision with root package name */
    private a f17702k1;

    /* renamed from: l1  reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f17703l1;

    /* renamed from: m1  reason: collision with root package name */
    private final Semaphore f17704m1;

    /* renamed from: n1  reason: collision with root package name */
    private Handler f17705n1;

    /* renamed from: o1  reason: collision with root package name */
    private Runnable f17706o1;

    /* renamed from: p1  reason: collision with root package name */
    private final Runnable f17707p1;

    /* renamed from: q1  reason: collision with root package name */
    private float f17708q1;

    /* renamed from: w  reason: collision with root package name */
    private Map f17709w;

    private interface a {
        void a(j jVar);
    }

    private enum b {
        NONE,
        PLAY,
        RESUME
    }

    static {
        boolean z10;
        if (Build.VERSION.SDK_INT <= 25) {
            z10 = true;
        } else {
            z10 = false;
        }
        f17679r1 = z10;
    }

    public k0() {
        i iVar = new i();
        this.f17684b = iVar;
        e0 e0Var = new e0(this);
        this.f17703l1 = e0Var;
        this.f17704m1 = new Semaphore(1);
        this.f17707p1 = new f0(this);
        this.f17708q1 = -3.4028235E38f;
        iVar.addUpdateListener(e0Var);
    }

    private void C(int i10, int i11) {
        Bitmap bitmap = this.Y0;
        if (bitmap == null || bitmap.getWidth() < i10 || this.Y0.getHeight() < i11) {
            Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
            this.Y0 = createBitmap;
            this.Z0.setBitmap(createBitmap);
            this.f17701j1 = true;
        } else if (this.Y0.getWidth() > i10 || this.Y0.getHeight() > i11) {
            Bitmap createBitmap2 = Bitmap.createBitmap(this.Y0, 0, 0, i10, i11);
            this.Y0 = createBitmap2;
            this.Z0.setBitmap(createBitmap2);
            this.f17701j1 = true;
        }
    }

    private void D() {
        if (this.Z0 == null) {
            this.Z0 = new Canvas();
            this.f17695g1 = new RectF();
            this.f17697h1 = new Matrix();
            this.f17699i1 = new Matrix();
            this.f17683a1 = new Rect();
            this.f17685b1 = new RectF();
            this.f17687c1 = new m0.a();
            this.f17689d1 = new Rect();
            this.f17691e1 = new Rect();
            this.f17693f1 = new RectF();
        }
    }

    private void D0(RectF rectF, float f10, float f11) {
        rectF.set(rectF.left * f10, rectF.top * f11, rectF.right * f10, rectF.bottom * f11);
    }

    private Context K() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private q0.a L() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f17700j == null) {
            q0.a aVar = new q0.a(getCallback(), this.X);
            this.f17700j = aVar;
            String str = this.C;
            if (str != null) {
                aVar.c(str);
            }
        }
        return this.f17700j;
    }

    private q0.b N() {
        q0.b bVar = this.f17696h;
        if (bVar != null && !bVar.b(K())) {
            this.f17696h = null;
        }
        if (this.f17696h == null) {
            this.f17696h = new q0.b(getCallback(), this.f17698i, (c) null, this.f17682a.j());
        }
        return this.f17696h;
    }

    private boolean c0() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        if (parent instanceof ViewGroup) {
            return !((ViewGroup) parent).getClipChildren();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h0(e eVar, Object obj, z0.c cVar, j jVar) {
        r(eVar, obj, cVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0(ValueAnimator valueAnimator) {
        if (F()) {
            invalidateSelf();
            return;
        }
        c cVar = this.P0;
        if (cVar != null) {
            cVar.M(this.f17684b.j());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    private boolean j1() {
        j jVar = this.f17682a;
        if (jVar == null) {
            return false;
        }
        float f10 = this.f17708q1;
        float j10 = this.f17684b.j();
        this.f17708q1 = j10;
        if (Math.abs(j10 - f10) * jVar.d() >= 50.0f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k0() {
        c cVar = this.P0;
        if (cVar != null) {
            try {
                this.f17704m1.acquire();
                cVar.M(this.f17684b.j());
                if (f17679r1 && this.f17701j1) {
                    if (this.f17705n1 == null) {
                        this.f17705n1 = new Handler(Looper.getMainLooper());
                        this.f17706o1 = new a0(this);
                    }
                    this.f17705n1.post(this.f17706o1);
                }
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                this.f17704m1.release();
                throw th;
            }
            this.f17704m1.release();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(j jVar) {
        y0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(j jVar) {
        B0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0(int i10, j jVar) {
        M0(i10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o0(String str, j jVar) {
        S0(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p0(int i10, j jVar) {
        R0(i10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q0(float f10, j jVar) {
        T0(f10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r0(String str, j jVar) {
        V0(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s0(int i10, int i11, j jVar) {
        U0(i10, i11);
    }

    private void t() {
        j jVar = this.f17682a;
        if (jVar != null) {
            c cVar = new c(this, v.a(jVar), jVar.k(), jVar);
            this.P0 = cVar;
            if (this.S0) {
                cVar.K(true);
            }
            this.P0.Q(this.O0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t0(int i10, j jVar) {
        W0(i10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u0(String str, j jVar) {
        X0(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v0(float f10, j jVar) {
        Y0(f10);
    }

    private void w() {
        j jVar = this.f17682a;
        if (jVar != null) {
            this.W0 = this.V0.b(Build.VERSION.SDK_INT, jVar.q(), jVar.m());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w0(float f10, j jVar) {
        b1(f10);
    }

    private void x(Rect rect, RectF rectF) {
        rectF.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
    }

    private void y(RectF rectF, Rect rect) {
        rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
    }

    private void z(Canvas canvas) {
        c cVar = this.P0;
        j jVar = this.f17682a;
        if (cVar != null && jVar != null) {
            this.X0.reset();
            Rect bounds = getBounds();
            if (!bounds.isEmpty()) {
                this.X0.preScale(((float) bounds.width()) / ((float) jVar.b().width()), ((float) bounds.height()) / ((float) jVar.b().height()));
                this.X0.preTranslate((float) bounds.left, (float) bounds.top);
            }
            cVar.g(canvas, this.X0, this.Q0);
        }
    }

    private void z0(Canvas canvas, c cVar) {
        if (this.f17682a != null && cVar != null) {
            D();
            canvas.getMatrix(this.f17697h1);
            canvas.getClipBounds(this.f17683a1);
            x(this.f17683a1, this.f17685b1);
            this.f17697h1.mapRect(this.f17685b1);
            y(this.f17685b1, this.f17683a1);
            if (this.O0) {
                this.f17695g1.set(0.0f, 0.0f, (float) getIntrinsicWidth(), (float) getIntrinsicHeight());
            } else {
                cVar.e(this.f17695g1, (Matrix) null, false);
            }
            this.f17697h1.mapRect(this.f17695g1);
            Rect bounds = getBounds();
            float width = ((float) bounds.width()) / ((float) getIntrinsicWidth());
            float height = ((float) bounds.height()) / ((float) getIntrinsicHeight());
            D0(this.f17695g1, width, height);
            if (!c0()) {
                RectF rectF = this.f17695g1;
                Rect rect = this.f17683a1;
                rectF.intersect((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
            }
            int ceil = (int) Math.ceil((double) this.f17695g1.width());
            int ceil2 = (int) Math.ceil((double) this.f17695g1.height());
            if (ceil > 0 && ceil2 > 0) {
                C(ceil, ceil2);
                if (this.f17701j1) {
                    this.X0.set(this.f17697h1);
                    this.X0.preScale(width, height);
                    Matrix matrix = this.X0;
                    RectF rectF2 = this.f17695g1;
                    matrix.postTranslate(-rectF2.left, -rectF2.top);
                    this.Y0.eraseColor(0);
                    cVar.g(this.Z0, this.X0, this.Q0);
                    this.f17697h1.invert(this.f17699i1);
                    this.f17699i1.mapRect(this.f17693f1, this.f17695g1);
                    y(this.f17693f1, this.f17691e1);
                }
                this.f17689d1.set(0, 0, ceil, ceil2);
                canvas.drawBitmap(this.Y0, this.f17689d1, this.f17691e1, this.f17687c1);
            }
        }
    }

    public void A(l0 l0Var, boolean z10) {
        boolean a10 = this.Z.a(l0Var, z10);
        if (this.f17682a != null && a10) {
            t();
        }
    }

    public List A0(e eVar) {
        if (this.P0 == null) {
            f.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.P0.d(eVar, 0, arrayList, new e(new String[0]));
        return arrayList;
    }

    public void B() {
        this.f17694g.clear();
        this.f17684b.i();
        if (!isVisible()) {
            this.f17692f = b.NONE;
        }
    }

    public void B0() {
        float f10;
        if (this.P0 == null) {
            this.f17694g.add(new b0(this));
            return;
        }
        w();
        if (s(K()) || X() == 0) {
            if (isVisible()) {
                this.f17684b.v();
                this.f17692f = b.NONE;
            } else {
                this.f17692f = b.RESUME;
            }
        }
        if (!s(K())) {
            if (Z() < 0.0f) {
                f10 = T();
            } else {
                f10 = S();
            }
            M0((int) f10);
            this.f17684b.i();
            if (!isVisible()) {
                this.f17692f = b.NONE;
            }
        }
    }

    public void C0() {
        this.f17684b.w();
    }

    public a E() {
        a aVar = this.f17702k1;
        if (aVar != null) {
            return aVar;
        }
        return e.d();
    }

    public void E0(boolean z10) {
        this.T0 = z10;
    }

    public boolean F() {
        if (E() == a.ENABLED) {
            return true;
        }
        return false;
    }

    public void F0(a aVar) {
        this.f17702k1 = aVar;
    }

    public Bitmap G(String str) {
        q0.b N = N();
        if (N != null) {
            return N.a(str);
        }
        return null;
    }

    public void G0(boolean z10) {
        if (z10 != this.U0) {
            this.U0 = z10;
            invalidateSelf();
        }
    }

    public boolean H() {
        return this.U0;
    }

    public void H0(boolean z10) {
        if (z10 != this.O0) {
            this.O0 = z10;
            c cVar = this.P0;
            if (cVar != null) {
                cVar.Q(z10);
            }
            invalidateSelf();
        }
    }

    public boolean I() {
        return this.O0;
    }

    public boolean I0(j jVar) {
        if (this.f17682a == jVar) {
            return false;
        }
        this.f17701j1 = true;
        v();
        this.f17682a = jVar;
        t();
        this.f17684b.x(jVar);
        b1(this.f17684b.getAnimatedFraction());
        Iterator it = new ArrayList(this.f17694g).iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.a(jVar);
            }
            it.remove();
        }
        this.f17694g.clear();
        jVar.v(this.R0);
        w();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable((Drawable) null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public j J() {
        return this.f17682a;
    }

    public void J0(String str) {
        this.C = str;
        q0.a L = L();
        if (L != null) {
            L.c(str);
        }
    }

    public void K0(b bVar) {
        this.X = bVar;
        q0.a aVar = this.f17700j;
        if (aVar != null) {
            aVar.d(bVar);
        }
    }

    public void L0(Map map) {
        if (map != this.f17709w) {
            this.f17709w = map;
            invalidateSelf();
        }
    }

    public int M() {
        return (int) this.f17684b.k();
    }

    public void M0(int i10) {
        if (this.f17682a == null) {
            this.f17694g.add(new j0(this, i10));
        } else {
            this.f17684b.y((float) i10);
        }
    }

    public void N0(boolean z10) {
        this.f17688d = z10;
    }

    public String O() {
        return this.f17698i;
    }

    public void O0(c cVar) {
        q0.b bVar = this.f17696h;
        if (bVar != null) {
            bVar.d(cVar);
        }
    }

    public n0 P(String str) {
        j jVar = this.f17682a;
        if (jVar == null) {
            return null;
        }
        return (n0) jVar.j().get(str);
    }

    public void P0(String str) {
        this.f17698i = str;
    }

    public boolean Q() {
        return this.N0;
    }

    public void Q0(boolean z10) {
        this.N0 = z10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0007 A[LOOP:0: B:1:0x0007->B:4:0x0019, LOOP_START, PHI: r1 
      PHI: (r1v1 r0.h) = (r1v0 r0.h), (r1v5 r0.h) binds: [B:0:0x0000, B:4:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public r0.h R() {
        /*
            r3 = this;
            java.util.List r0 = f17680s1
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0007:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x001b
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            com.airbnb.lottie.j r2 = r3.f17682a
            r0.h r1 = r2.l(r1)
            if (r1 == 0) goto L_0x0007
        L_0x001b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.k0.R():r0.h");
    }

    public void R0(int i10) {
        if (this.f17682a == null) {
            this.f17694g.add(new v(this, i10));
        } else {
            this.f17684b.z(((float) i10) + 0.99f);
        }
    }

    public float S() {
        return this.f17684b.m();
    }

    public void S0(String str) {
        j jVar = this.f17682a;
        if (jVar == null) {
            this.f17694g.add(new c0(this, str));
            return;
        }
        h l10 = jVar.l(str);
        if (l10 != null) {
            R0((int) (l10.f23629b + l10.f23630c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + com.alibaba.pdns.f.G);
    }

    public float T() {
        return this.f17684b.n();
    }

    public void T0(float f10) {
        j jVar = this.f17682a;
        if (jVar == null) {
            this.f17694g.add(new y(this, f10));
        } else {
            this.f17684b.z(k.i(jVar.p(), this.f17682a.f(), f10));
        }
    }

    public v0 U() {
        j jVar = this.f17682a;
        if (jVar != null) {
            return jVar.n();
        }
        return null;
    }

    public void U0(int i10, int i11) {
        if (this.f17682a == null) {
            this.f17694g.add(new z(this, i10, i11));
        } else {
            this.f17684b.A((float) i10, ((float) i11) + 0.99f);
        }
    }

    public float V() {
        return this.f17684b.j();
    }

    public void V0(String str) {
        j jVar = this.f17682a;
        if (jVar == null) {
            this.f17694g.add(new u(this, str));
            return;
        }
        h l10 = jVar.l(str);
        if (l10 != null) {
            int i10 = (int) l10.f23629b;
            U0(i10, ((int) l10.f23630c) + i10);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + com.alibaba.pdns.f.G);
    }

    public y0 W() {
        if (this.W0) {
            return y0.SOFTWARE;
        }
        return y0.HARDWARE;
    }

    public void W0(int i10) {
        if (this.f17682a == null) {
            this.f17694g.add(new w(this, i10));
        } else {
            this.f17684b.B(i10);
        }
    }

    public int X() {
        return this.f17684b.getRepeatCount();
    }

    public void X0(String str) {
        j jVar = this.f17682a;
        if (jVar == null) {
            this.f17694g.add(new d0(this, str));
            return;
        }
        h l10 = jVar.l(str);
        if (l10 != null) {
            W0((int) l10.f23629b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + com.alibaba.pdns.f.G);
    }

    public int Y() {
        return this.f17684b.getRepeatMode();
    }

    public void Y0(float f10) {
        j jVar = this.f17682a;
        if (jVar == null) {
            this.f17694g.add(new h0(this, f10));
        } else {
            W0((int) k.i(jVar.p(), this.f17682a.f(), f10));
        }
    }

    public float Z() {
        return this.f17684b.o();
    }

    public void Z0(boolean z10) {
        if (this.S0 != z10) {
            this.S0 = z10;
            c cVar = this.P0;
            if (cVar != null) {
                cVar.K(z10);
            }
        }
    }

    public a1 a0() {
        return this.Y;
    }

    public void a1(boolean z10) {
        this.R0 = z10;
        j jVar = this.f17682a;
        if (jVar != null) {
            jVar.v(z10);
        }
    }

    public Typeface b0(r0.c cVar) {
        Map map = this.f17709w;
        if (map != null) {
            String a10 = cVar.a();
            if (map.containsKey(a10)) {
                return (Typeface) map.get(a10);
            }
            String b10 = cVar.b();
            if (map.containsKey(b10)) {
                return (Typeface) map.get(b10);
            }
            String str = cVar.a() + "-" + cVar.c();
            if (map.containsKey(str)) {
                return (Typeface) map.get(str);
            }
        }
        q0.a L = L();
        if (L != null) {
            return L.b(cVar);
        }
        return null;
    }

    public void b1(float f10) {
        if (this.f17682a == null) {
            this.f17694g.add(new i0(this, f10));
            return;
        }
        if (e.h()) {
            e.b("Drawable#setProgress");
        }
        this.f17684b.y(this.f17682a.h(f10));
        if (e.h()) {
            e.c("Drawable#setProgress");
        }
    }

    public void c1(y0 y0Var) {
        this.V0 = y0Var;
        w();
    }

    public boolean d0() {
        i iVar = this.f17684b;
        if (iVar == null) {
            return false;
        }
        return iVar.isRunning();
    }

    public void d1(int i10) {
        this.f17684b.setRepeatCount(i10);
    }

    public void draw(Canvas canvas) {
        c cVar = this.P0;
        if (cVar != null) {
            boolean F = F();
            if (F) {
                try {
                    this.f17704m1.acquire();
                } catch (InterruptedException unused) {
                    if (e.h()) {
                        e.c("Drawable#draw");
                    }
                    if (F) {
                        this.f17704m1.release();
                        if (cVar.P() == this.f17684b.j()) {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    if (e.h()) {
                        e.c("Drawable#draw");
                    }
                    if (F) {
                        this.f17704m1.release();
                        if (cVar.P() != this.f17684b.j()) {
                            f17681t1.execute(this.f17707p1);
                        }
                    }
                    throw th;
                }
            }
            if (e.h()) {
                e.b("Drawable#draw");
            }
            if (F && j1()) {
                b1(this.f17684b.j());
            }
            if (this.f17690e) {
                try {
                    if (this.W0) {
                        z0(canvas, cVar);
                    } else {
                        z(canvas);
                    }
                } catch (Throwable th2) {
                    f.b("Lottie crashed in draw!", th2);
                }
            } else if (this.W0) {
                z0(canvas, cVar);
            } else {
                z(canvas);
            }
            this.f17701j1 = false;
            if (e.h()) {
                e.c("Drawable#draw");
            }
            if (F) {
                this.f17704m1.release();
                if (cVar.P() == this.f17684b.j()) {
                    return;
                }
                f17681t1.execute(this.f17707p1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e0() {
        if (isVisible()) {
            return this.f17684b.isRunning();
        }
        b bVar = this.f17692f;
        if (bVar == b.PLAY || bVar == b.RESUME) {
            return true;
        }
        return false;
    }

    public void e1(int i10) {
        this.f17684b.setRepeatMode(i10);
    }

    public boolean f0() {
        return this.T0;
    }

    public void f1(boolean z10) {
        this.f17690e = z10;
    }

    public boolean g0(l0 l0Var) {
        return this.Z.b(l0Var);
    }

    public void g1(float f10) {
        this.f17684b.C(f10);
    }

    public int getAlpha() {
        return this.Q0;
    }

    public int getIntrinsicHeight() {
        j jVar = this.f17682a;
        if (jVar == null) {
            return -1;
        }
        return jVar.b().height();
    }

    public int getIntrinsicWidth() {
        j jVar = this.f17682a;
        if (jVar == null) {
            return -1;
        }
        return jVar.b().width();
    }

    public int getOpacity() {
        return -3;
    }

    public void h1(a1 a1Var) {
        this.Y = a1Var;
    }

    public void i1(boolean z10) {
        this.f17684b.D(z10);
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void invalidateSelf() {
        Drawable.Callback callback;
        if (!this.f17701j1) {
            this.f17701j1 = true;
            if ((!f17679r1 || Looper.getMainLooper() == Looper.myLooper()) && (callback = getCallback()) != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public boolean isRunning() {
        return d0();
    }

    public boolean k1() {
        if (this.f17709w == null && this.Y == null && this.f17682a.c().size() > 0) {
            return true;
        }
        return false;
    }

    public void q(Animator.AnimatorListener animatorListener) {
        this.f17684b.addListener(animatorListener);
    }

    public void r(e eVar, Object obj, z0.c cVar) {
        c cVar2 = this.P0;
        if (cVar2 == null) {
            this.f17694g.add(new x(this, eVar, obj, cVar));
            return;
        }
        boolean z10 = true;
        if (eVar == e.f23623c) {
            cVar2.c(obj, cVar);
        } else if (eVar.d() != null) {
            eVar.d().c(obj, cVar);
        } else {
            List A0 = A0(eVar);
            for (int i10 = 0; i10 < A0.size(); i10++) {
                ((e) A0.get(i10)).d().c(obj, cVar);
            }
            z10 = true ^ A0.isEmpty();
        }
        if (z10) {
            invalidateSelf();
            if (obj == r0.E) {
                b1(V());
            }
        }
    }

    public boolean s(Context context) {
        if (this.f17688d) {
            return true;
        }
        if (!this.f17686c || e.f().a(context) != p0.a.STANDARD_MOTION) {
            return false;
        }
        return true;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    public void setAlpha(int i10) {
        this.Q0 = i10;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        f.c("Use addColorFilter instead.");
    }

    public boolean setVisible(boolean z10, boolean z11) {
        boolean z12 = !isVisible();
        boolean visible = super.setVisible(z10, z11);
        if (z10) {
            b bVar = this.f17692f;
            if (bVar == b.PLAY) {
                y0();
            } else if (bVar == b.RESUME) {
                B0();
            }
        } else if (this.f17684b.isRunning()) {
            x0();
            this.f17692f = b.RESUME;
        } else if (!z12) {
            this.f17692f = b.NONE;
        }
        return visible;
    }

    public void start() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View) || !((View) callback).isInEditMode()) {
            y0();
        }
    }

    public void stop() {
        B();
    }

    public void u() {
        this.f17694g.clear();
        this.f17684b.cancel();
        if (!isVisible()) {
            this.f17692f = b.NONE;
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v() {
        if (this.f17684b.isRunning()) {
            this.f17684b.cancel();
            if (!isVisible()) {
                this.f17692f = b.NONE;
            }
        }
        this.f17682a = null;
        this.P0 = null;
        this.f17696h = null;
        this.f17708q1 = -3.4028235E38f;
        this.f17684b.h();
        invalidateSelf();
    }

    public void x0() {
        this.f17694g.clear();
        this.f17684b.q();
        if (!isVisible()) {
            this.f17692f = b.NONE;
        }
    }

    public void y0() {
        float f10;
        if (this.P0 == null) {
            this.f17694g.add(new g0(this));
            return;
        }
        w();
        if (s(K()) || X() == 0) {
            if (isVisible()) {
                this.f17684b.r();
                this.f17692f = b.NONE;
            } else {
                this.f17692f = b.PLAY;
            }
        }
        if (!s(K())) {
            h R = R();
            if (R != null) {
                M0((int) R.f23629b);
            } else {
                if (Z() < 0.0f) {
                    f10 = T();
                } else {
                    f10 = S();
                }
                M0((int) f10);
            }
            this.f17684b.i();
            if (!isVisible()) {
                this.f17692f = b.NONE;
            }
        }
    }
}
