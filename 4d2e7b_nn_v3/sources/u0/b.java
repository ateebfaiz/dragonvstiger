package u0;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.core.graphics.PaintCompat;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.j;
import com.airbnb.lottie.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import n0.e;
import o0.a;
import o0.d;
import o0.h;
import o0.p;
import r0.f;
import t0.i;
import u0.e;
import y0.l;
import z0.c;

public abstract class b implements e, a.b, f {
    private Paint A;
    float B;
    BlurMaskFilter C;
    m0.a D;

    /* renamed from: a  reason: collision with root package name */
    private final Path f24175a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f24176b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f24177c = new Matrix();

    /* renamed from: d  reason: collision with root package name */
    private final Paint f24178d = new m0.a(1);

    /* renamed from: e  reason: collision with root package name */
    private final Paint f24179e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f24180f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f24181g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f24182h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f24183i;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f24184j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f24185k;

    /* renamed from: l  reason: collision with root package name */
    private final RectF f24186l;

    /* renamed from: m  reason: collision with root package name */
    private final RectF f24187m;

    /* renamed from: n  reason: collision with root package name */
    private final String f24188n;

    /* renamed from: o  reason: collision with root package name */
    final Matrix f24189o;

    /* renamed from: p  reason: collision with root package name */
    final k0 f24190p;

    /* renamed from: q  reason: collision with root package name */
    final e f24191q;

    /* renamed from: r  reason: collision with root package name */
    private h f24192r;

    /* renamed from: s  reason: collision with root package name */
    private d f24193s;

    /* renamed from: t  reason: collision with root package name */
    private b f24194t;

    /* renamed from: u  reason: collision with root package name */
    private b f24195u;

    /* renamed from: v  reason: collision with root package name */
    private List f24196v;

    /* renamed from: w  reason: collision with root package name */
    private final List f24197w;

    /* renamed from: x  reason: collision with root package name */
    public final p f24198x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f24199y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f24200z;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24201a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f24202b;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        static {
            /*
                t0.i$a[] r0 = t0.i.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24202b = r0
                r1 = 1
                t0.i$a r2 = t0.i.a.MASK_MODE_NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f24202b     // Catch:{ NoSuchFieldError -> 0x001d }
                t0.i$a r3 = t0.i.a.MASK_MODE_SUBTRACT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f24202b     // Catch:{ NoSuchFieldError -> 0x0028 }
                t0.i$a r4 = t0.i.a.MASK_MODE_INTERSECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f24202b     // Catch:{ NoSuchFieldError -> 0x0033 }
                t0.i$a r5 = t0.i.a.MASK_MODE_ADD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                u0.e$a[] r4 = u0.e.a.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f24201a = r4
                u0.e$a r5 = u0.e.a.SHAPE     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f24201a     // Catch:{ NoSuchFieldError -> 0x004e }
                u0.e$a r4 = u0.e.a.PRE_COMP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f24201a     // Catch:{ NoSuchFieldError -> 0x0058 }
                u0.e$a r1 = u0.e.a.SOLID     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f24201a     // Catch:{ NoSuchFieldError -> 0x0062 }
                u0.e$a r1 = u0.e.a.IMAGE     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f24201a     // Catch:{ NoSuchFieldError -> 0x006d }
                u0.e$a r1 = u0.e.a.NULL     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f24201a     // Catch:{ NoSuchFieldError -> 0x0078 }
                u0.e$a r1 = u0.e.a.TEXT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f24201a     // Catch:{ NoSuchFieldError -> 0x0083 }
                u0.e$a r1 = u0.e.a.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: u0.b.a.<clinit>():void");
        }
    }

    b(k0 k0Var, e eVar) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.f24179e = new m0.a(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f24180f = new m0.a(1, mode2);
        m0.a aVar = new m0.a(1);
        this.f24181g = aVar;
        this.f24182h = new m0.a(PorterDuff.Mode.CLEAR);
        this.f24183i = new RectF();
        this.f24184j = new RectF();
        this.f24185k = new RectF();
        this.f24186l = new RectF();
        this.f24187m = new RectF();
        this.f24189o = new Matrix();
        this.f24197w = new ArrayList();
        this.f24199y = true;
        this.B = 0.0f;
        this.f24190p = k0Var;
        this.f24191q = eVar;
        this.f24188n = eVar.j() + "#draw";
        if (eVar.i() == e.b.INVERT) {
            aVar.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(mode));
        }
        p b10 = eVar.x().b();
        this.f24198x = b10;
        b10.b(this);
        if (eVar.h() != null && !eVar.h().isEmpty()) {
            h hVar = new h(eVar.h());
            this.f24192r = hVar;
            for (o0.a a10 : hVar.a()) {
                a10.a(this);
            }
            for (o0.a aVar2 : this.f24192r.c()) {
                i(aVar2);
                aVar2.a(this);
            }
        }
        O();
    }

    private void C(RectF rectF, Matrix matrix) {
        this.f24185k.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (A()) {
            int size = this.f24192r.b().size();
            for (int i10 = 0; i10 < size; i10++) {
                i iVar = (i) this.f24192r.b().get(i10);
                Path path = (Path) ((o0.a) this.f24192r.a().get(i10)).h();
                if (path != null) {
                    this.f24175a.set(path);
                    this.f24175a.transform(matrix);
                    int i11 = a.f24202b[iVar.a().ordinal()];
                    if (i11 != 1 && i11 != 2) {
                        if ((i11 != 3 && i11 != 4) || !iVar.d()) {
                            this.f24175a.computeBounds(this.f24187m, false);
                            if (i10 == 0) {
                                this.f24185k.set(this.f24187m);
                            } else {
                                RectF rectF2 = this.f24185k;
                                rectF2.set(Math.min(rectF2.left, this.f24187m.left), Math.min(this.f24185k.top, this.f24187m.top), Math.max(this.f24185k.right, this.f24187m.right), Math.max(this.f24185k.bottom, this.f24187m.bottom));
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            if (!rectF.intersect(this.f24185k)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void D(RectF rectF, Matrix matrix) {
        if (B() && this.f24191q.i() != e.b.INVERT) {
            this.f24186l.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f24194t.e(this.f24186l, matrix, true);
            if (!rectF.intersect(this.f24186l)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void E() {
        this.f24190p.invalidateSelf();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F() {
        boolean z10;
        if (this.f24193s.q() == 1.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        N(z10);
    }

    private void G(float f10) {
        this.f24190p.J().n().a(this.f24191q.j(), f10);
    }

    private void N(boolean z10) {
        if (z10 != this.f24199y) {
            this.f24199y = z10;
            E();
        }
    }

    private void O() {
        boolean z10 = true;
        if (!this.f24191q.f().isEmpty()) {
            d dVar = new d(this.f24191q.f());
            this.f24193s = dVar;
            dVar.m();
            this.f24193s.a(new a(this));
            if (((Float) this.f24193s.h()).floatValue() != 1.0f) {
                z10 = false;
            }
            N(z10);
            i(this.f24193s);
            return;
        }
        N(true);
    }

    private void j(Canvas canvas, Matrix matrix, o0.a aVar, o0.a aVar2) {
        this.f24175a.set((Path) aVar.h());
        this.f24175a.transform(matrix);
        this.f24178d.setAlpha((int) (((float) ((Integer) aVar2.h()).intValue()) * 2.55f));
        canvas.drawPath(this.f24175a, this.f24178d);
    }

    private void k(Canvas canvas, Matrix matrix, o0.a aVar, o0.a aVar2) {
        l.n(canvas, this.f24183i, this.f24179e);
        this.f24175a.set((Path) aVar.h());
        this.f24175a.transform(matrix);
        this.f24178d.setAlpha((int) (((float) ((Integer) aVar2.h()).intValue()) * 2.55f));
        canvas.drawPath(this.f24175a, this.f24178d);
        canvas.restore();
    }

    private void l(Canvas canvas, Matrix matrix, o0.a aVar, o0.a aVar2) {
        l.n(canvas, this.f24183i, this.f24178d);
        canvas.drawRect(this.f24183i, this.f24178d);
        this.f24175a.set((Path) aVar.h());
        this.f24175a.transform(matrix);
        this.f24178d.setAlpha((int) (((float) ((Integer) aVar2.h()).intValue()) * 2.55f));
        canvas.drawPath(this.f24175a, this.f24180f);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix, o0.a aVar, o0.a aVar2) {
        l.n(canvas, this.f24183i, this.f24179e);
        canvas.drawRect(this.f24183i, this.f24178d);
        this.f24180f.setAlpha((int) (((float) ((Integer) aVar2.h()).intValue()) * 2.55f));
        this.f24175a.set((Path) aVar.h());
        this.f24175a.transform(matrix);
        canvas.drawPath(this.f24175a, this.f24180f);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, o0.a aVar, o0.a aVar2) {
        l.n(canvas, this.f24183i, this.f24180f);
        canvas.drawRect(this.f24183i, this.f24178d);
        this.f24180f.setAlpha((int) (((float) ((Integer) aVar2.h()).intValue()) * 2.55f));
        this.f24175a.set((Path) aVar.h());
        this.f24175a.transform(matrix);
        canvas.drawPath(this.f24175a, this.f24180f);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix) {
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.b("Layer#saveLayer");
        }
        l.o(canvas, this.f24183i, this.f24179e, 19);
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.c("Layer#saveLayer");
        }
        for (int i10 = 0; i10 < this.f24192r.b().size(); i10++) {
            i iVar = (i) this.f24192r.b().get(i10);
            o0.a aVar = (o0.a) this.f24192r.a().get(i10);
            o0.a aVar2 = (o0.a) this.f24192r.c().get(i10);
            int i11 = a.f24202b[iVar.a().ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    if (i10 == 0) {
                        this.f24178d.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.f24178d.setAlpha(255);
                        canvas.drawRect(this.f24183i, this.f24178d);
                    }
                    if (iVar.d()) {
                        n(canvas, matrix, aVar, aVar2);
                    } else {
                        p(canvas, matrix, aVar);
                    }
                } else if (i11 != 3) {
                    if (i11 == 4) {
                        if (iVar.d()) {
                            l(canvas, matrix, aVar, aVar2);
                        } else {
                            j(canvas, matrix, aVar, aVar2);
                        }
                    }
                } else if (iVar.d()) {
                    m(canvas, matrix, aVar, aVar2);
                } else {
                    k(canvas, matrix, aVar, aVar2);
                }
            } else if (q()) {
                this.f24178d.setAlpha(255);
                canvas.drawRect(this.f24183i, this.f24178d);
            }
        }
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.b("Layer#restoreLayer");
        }
        canvas.restore();
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.c("Layer#restoreLayer");
        }
    }

    private void p(Canvas canvas, Matrix matrix, o0.a aVar) {
        this.f24175a.set((Path) aVar.h());
        this.f24175a.transform(matrix);
        canvas.drawPath(this.f24175a, this.f24180f);
    }

    private boolean q() {
        if (this.f24192r.a().isEmpty()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f24192r.b().size(); i10++) {
            if (((i) this.f24192r.b().get(i10)).a() != i.a.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void r() {
        if (this.f24196v == null) {
            if (this.f24195u == null) {
                this.f24196v = Collections.emptyList();
                return;
            }
            this.f24196v = new ArrayList();
            for (b bVar = this.f24195u; bVar != null; bVar = bVar.f24195u) {
                this.f24196v.add(bVar);
            }
        }
    }

    private void s(Canvas canvas) {
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.b("Layer#clearLayer");
        }
        RectF rectF = this.f24183i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f24182h);
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.c("Layer#clearLayer");
        }
    }

    static b u(c cVar, e eVar, k0 k0Var, j jVar) {
        switch (a.f24201a[eVar.g().ordinal()]) {
            case 1:
                return new g(k0Var, eVar, cVar, jVar);
            case 2:
                return new c(k0Var, eVar, jVar.o(eVar.n()), jVar);
            case 3:
                return new h(k0Var, eVar);
            case 4:
                return new d(k0Var, eVar);
            case 5:
                return new f(k0Var, eVar);
            case 6:
                return new i(k0Var, eVar);
            default:
                y0.f.c("Unknown layer type " + eVar.g());
                return null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        h hVar = this.f24192r;
        if (hVar == null || hVar.a().isEmpty()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean B() {
        if (this.f24194t != null) {
            return true;
        }
        return false;
    }

    public void H(o0.a aVar) {
        this.f24197w.remove(aVar);
    }

    /* access modifiers changed from: package-private */
    public void I(r0.e eVar, int i10, List list, r0.e eVar2) {
    }

    /* access modifiers changed from: package-private */
    public void J(b bVar) {
        this.f24194t = bVar;
    }

    /* access modifiers changed from: package-private */
    public void K(boolean z10) {
        if (z10 && this.A == null) {
            this.A = new m0.a();
        }
        this.f24200z = z10;
    }

    /* access modifiers changed from: package-private */
    public void L(b bVar) {
        this.f24195u = bVar;
    }

    /* access modifiers changed from: package-private */
    public void M(float f10) {
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.b("BaseLayer#setProgress");
            com.airbnb.lottie.e.b("BaseLayer#setProgress.transform");
        }
        this.f24198x.j(f10);
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.c("BaseLayer#setProgress.transform");
        }
        if (this.f24192r != null) {
            if (com.airbnb.lottie.e.h()) {
                com.airbnb.lottie.e.b("BaseLayer#setProgress.mask");
            }
            for (int i10 = 0; i10 < this.f24192r.a().size(); i10++) {
                ((o0.a) this.f24192r.a().get(i10)).n(f10);
            }
            if (com.airbnb.lottie.e.h()) {
                com.airbnb.lottie.e.c("BaseLayer#setProgress.mask");
            }
        }
        if (this.f24193s != null) {
            if (com.airbnb.lottie.e.h()) {
                com.airbnb.lottie.e.b("BaseLayer#setProgress.inout");
            }
            this.f24193s.n(f10);
            if (com.airbnb.lottie.e.h()) {
                com.airbnb.lottie.e.c("BaseLayer#setProgress.inout");
            }
        }
        if (this.f24194t != null) {
            if (com.airbnb.lottie.e.h()) {
                com.airbnb.lottie.e.b("BaseLayer#setProgress.matte");
            }
            this.f24194t.M(f10);
            if (com.airbnb.lottie.e.h()) {
                com.airbnb.lottie.e.c("BaseLayer#setProgress.matte");
            }
        }
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.b("BaseLayer#setProgress.animations." + this.f24197w.size());
        }
        for (int i11 = 0; i11 < this.f24197w.size(); i11++) {
            ((o0.a) this.f24197w.get(i11)).n(f10);
        }
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.c("BaseLayer#setProgress.animations." + this.f24197w.size());
            com.airbnb.lottie.e.c("BaseLayer#setProgress");
        }
    }

    public void a() {
        E();
    }

    public void b(List list, List list2) {
    }

    public void c(Object obj, c cVar) {
        this.f24198x.c(obj, cVar);
    }

    public void d(r0.e eVar, int i10, List list, r0.e eVar2) {
        b bVar = this.f24194t;
        if (bVar != null) {
            r0.e a10 = eVar2.a(bVar.getName());
            if (eVar.c(this.f24194t.getName(), i10)) {
                list.add(a10.i(this.f24194t));
            }
            if (eVar.h(getName(), i10)) {
                this.f24194t.I(eVar, eVar.e(this.f24194t.getName(), i10) + i10, list, a10);
            }
        }
        if (eVar.g(getName(), i10)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.a(getName());
                if (eVar.c(getName(), i10)) {
                    list.add(eVar2.i(this));
                }
            }
            if (eVar.h(getName(), i10)) {
                I(eVar, i10 + eVar.e(getName(), i10), list, eVar2);
            }
        }
    }

    public void e(RectF rectF, Matrix matrix, boolean z10) {
        this.f24183i.set(0.0f, 0.0f, 0.0f, 0.0f);
        r();
        this.f24189o.set(matrix);
        if (z10) {
            List list = this.f24196v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f24189o.preConcat(((b) this.f24196v.get(size)).f24198x.f());
                }
            } else {
                b bVar = this.f24195u;
                if (bVar != null) {
                    this.f24189o.preConcat(bVar.f24198x.f());
                }
            }
        }
        this.f24189o.preConcat(this.f24198x.f());
    }

    public void g(Canvas canvas, Matrix matrix, int i10) {
        int i11;
        Paint paint;
        Integer num;
        com.airbnb.lottie.e.b(this.f24188n);
        if (!this.f24199y || this.f24191q.y()) {
            com.airbnb.lottie.e.c(this.f24188n);
            return;
        }
        r();
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.b("Layer#parentMatrix");
        }
        this.f24176b.reset();
        this.f24176b.set(matrix);
        for (int size = this.f24196v.size() - 1; size >= 0; size--) {
            this.f24176b.preConcat(((b) this.f24196v.get(size)).f24198x.f());
        }
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.c("Layer#parentMatrix");
        }
        o0.a h10 = this.f24198x.h();
        if (h10 == null || (num = (Integer) h10.h()) == null) {
            i11 = 100;
        } else {
            i11 = num.intValue();
        }
        int i12 = (int) ((((((float) i10) / 255.0f) * ((float) i11)) / 100.0f) * 255.0f);
        if (B() || A() || v() != t0.h.NORMAL) {
            if (com.airbnb.lottie.e.h()) {
                com.airbnb.lottie.e.b("Layer#computeBounds");
            }
            e(this.f24183i, this.f24176b, false);
            D(this.f24183i, matrix);
            this.f24176b.preConcat(this.f24198x.f());
            C(this.f24183i, this.f24176b);
            this.f24184j.set(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
            canvas.getMatrix(this.f24177c);
            if (!this.f24177c.isIdentity()) {
                Matrix matrix2 = this.f24177c;
                matrix2.invert(matrix2);
                this.f24177c.mapRect(this.f24184j);
            }
            if (!this.f24183i.intersect(this.f24184j)) {
                this.f24183i.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            if (com.airbnb.lottie.e.h()) {
                com.airbnb.lottie.e.c("Layer#computeBounds");
            }
            if (this.f24183i.width() >= 1.0f && this.f24183i.height() >= 1.0f) {
                if (com.airbnb.lottie.e.h()) {
                    com.airbnb.lottie.e.b("Layer#saveLayer");
                }
                this.f24178d.setAlpha(255);
                PaintCompat.setBlendMode(this.f24178d, v().b());
                l.n(canvas, this.f24183i, this.f24178d);
                if (com.airbnb.lottie.e.h()) {
                    com.airbnb.lottie.e.c("Layer#saveLayer");
                }
                if (v() != t0.h.MULTIPLY) {
                    s(canvas);
                } else {
                    if (this.D == null) {
                        m0.a aVar = new m0.a();
                        this.D = aVar;
                        aVar.setColor(-1);
                    }
                    RectF rectF = this.f24183i;
                    canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.D);
                }
                if (com.airbnb.lottie.e.h()) {
                    com.airbnb.lottie.e.b("Layer#drawLayer");
                }
                t(canvas, this.f24176b, i12);
                if (com.airbnb.lottie.e.h()) {
                    com.airbnb.lottie.e.c("Layer#drawLayer");
                }
                if (A()) {
                    o(canvas, this.f24176b);
                }
                if (B()) {
                    if (com.airbnb.lottie.e.h()) {
                        com.airbnb.lottie.e.b("Layer#drawMatte");
                        com.airbnb.lottie.e.b("Layer#saveLayer");
                    }
                    l.o(canvas, this.f24183i, this.f24181g, 19);
                    if (com.airbnb.lottie.e.h()) {
                        com.airbnb.lottie.e.c("Layer#saveLayer");
                    }
                    s(canvas);
                    this.f24194t.g(canvas, matrix, i12);
                    if (com.airbnb.lottie.e.h()) {
                        com.airbnb.lottie.e.b("Layer#restoreLayer");
                    }
                    canvas.restore();
                    if (com.airbnb.lottie.e.h()) {
                        com.airbnb.lottie.e.c("Layer#restoreLayer");
                        com.airbnb.lottie.e.c("Layer#drawMatte");
                    }
                }
                if (com.airbnb.lottie.e.h()) {
                    com.airbnb.lottie.e.b("Layer#restoreLayer");
                }
                canvas.restore();
                if (com.airbnb.lottie.e.h()) {
                    com.airbnb.lottie.e.c("Layer#restoreLayer");
                }
            }
            if (this.f24200z && (paint = this.A) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.A.setColor(-251901);
                this.A.setStrokeWidth(4.0f);
                canvas.drawRect(this.f24183i, this.A);
                this.A.setStyle(Paint.Style.FILL);
                this.A.setColor(1357638635);
                canvas.drawRect(this.f24183i, this.A);
            }
            G(com.airbnb.lottie.e.c(this.f24188n));
            return;
        }
        this.f24176b.preConcat(this.f24198x.f());
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.b("Layer#drawLayer");
        }
        t(canvas, this.f24176b, i12);
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.c("Layer#drawLayer");
        }
        G(com.airbnb.lottie.e.c(this.f24188n));
    }

    public String getName() {
        return this.f24191q.j();
    }

    public void i(o0.a aVar) {
        if (aVar != null) {
            this.f24197w.add(aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void t(Canvas canvas, Matrix matrix, int i10);

    public t0.h v() {
        return this.f24191q.a();
    }

    public t0.a w() {
        return this.f24191q.b();
    }

    public BlurMaskFilter x(float f10) {
        if (this.B == f10) {
            return this.C;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f10 / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.C = blurMaskFilter;
        this.B = f10;
        return blurMaskFilter;
    }

    public w0.j y() {
        return this.f24191q.d();
    }

    /* access modifiers changed from: package-private */
    public e z() {
        return this.f24191q;
    }
}
