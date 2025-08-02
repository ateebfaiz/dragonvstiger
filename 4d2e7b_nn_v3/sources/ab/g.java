package ab;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class g {

    /* renamed from: m  reason: collision with root package name */
    public static final a f2388m = new a((DefaultConstructorMarker) null);

    /* renamed from: n  reason: collision with root package name */
    private static final PointF f2389n = new PointF();
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static final float[] f2390o = new float[2];
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static final Matrix f2391p = new Matrix();

    /* renamed from: q  reason: collision with root package name */
    private static final float[] f2392q = new float[2];

    /* renamed from: r  reason: collision with root package name */
    private static final Comparator f2393r = new f();

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f2394a;

    /* renamed from: b  reason: collision with root package name */
    private final h f2395b;

    /* renamed from: c  reason: collision with root package name */
    private final c0 f2396c;

    /* renamed from: d  reason: collision with root package name */
    private float f2397d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList f2398e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList f2399f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList f2400g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final HashSet f2401h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    private boolean f2402i;

    /* renamed from: j  reason: collision with root package name */
    private int f2403j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2404k;

    /* renamed from: l  reason: collision with root package name */
    private int f2405l;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final boolean h(d dVar, d dVar2) {
            if (dVar == dVar2 || dVar.J0(dVar2) || dVar2.J0(dVar)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final boolean i(int i10) {
            if (i10 == 3 || i10 == 1 || i10 == 5) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final boolean j(float f10, float f11, View view) {
            if (0.0f > f10 || f10 > ((float) view.getWidth()) || 0.0f > f11 || f11 > ((float) view.getHeight())) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public final boolean k(d dVar, d dVar2) {
            if (!dVar.W(dVar2) || h(dVar, dVar2)) {
                return false;
            }
            if (dVar == dVar2 || (!dVar.Y() && dVar.Q() != 4)) {
                return true;
            }
            return dVar.I0(dVar2);
        }

        /* access modifiers changed from: private */
        public final boolean l(d dVar, d dVar2) {
            if (dVar == dVar2 || (!dVar.L0(dVar2) && !dVar2.K0(dVar))) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public final boolean m(View view, float[] fArr) {
            if ((!(view instanceof ViewGroup) || view.getBackground() != null) && j(fArr[0], fArr[1], view)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final void n(float f10, float f11, ViewGroup viewGroup, View view, PointF pointF) {
            float scrollX = (f10 + ((float) viewGroup.getScrollX())) - ((float) view.getLeft());
            float scrollY = (f11 + ((float) viewGroup.getScrollY())) - ((float) view.getTop());
            Matrix matrix = view.getMatrix();
            if (!matrix.isIdentity()) {
                float[] c10 = g.f2390o;
                c10[0] = scrollX;
                c10[1] = scrollY;
                matrix.invert(g.f2391p);
                g.f2391p.mapPoints(c10);
                float f12 = c10[0];
                scrollY = c10[1];
                scrollX = f12;
            }
            pointF.set(scrollX, scrollY);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2406a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                ab.t[] r0 = ab.t.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                ab.t r1 = ab.t.NONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                ab.t r1 = ab.t.BOX_ONLY     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                ab.t r1 = ab.t.BOX_NONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                ab.t r1 = ab.t.AUTO     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f2406a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ab.g.b.<clinit>():void");
        }
    }

    static final class c extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f2407a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(d dVar) {
            super(0);
            this.f2407a = dVar;
        }

        public final void invoke() {
            this.f2407a.n();
            this.f2407a.i();
            this.f2407a.z();
        }
    }

    static final class d extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final d f2408a = new d();

        d() {
            super(1);
        }

        /* renamed from: a */
        public final Boolean invoke(d dVar) {
            boolean z10;
            m.f(dVar, "it");
            if (!g.f2388m.i(dVar.Q()) || dVar.Y()) {
                z10 = false;
            } else {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    public g(ViewGroup viewGroup, h hVar, c0 c0Var) {
        m.f(viewGroup, "wrapperView");
        m.f(hVar, "handlerRegistry");
        m.f(c0Var, "viewConfigHelper");
        this.f2394a = viewGroup;
        this.f2395b = hVar;
        this.f2396c = c0Var;
    }

    private final void A() {
        if (this.f2402i || this.f2403j != 0) {
            this.f2404k = true;
        } else {
            i();
        }
    }

    private final boolean C(d dVar) {
        ArrayList<d> arrayList = this.f2398e;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        for (d dVar2 : arrayList) {
            if (dVar.W(dVar2) && dVar2.Q() == 4 && !f2388m.h(dVar, dVar2) && dVar.a0(dVar2)) {
                return true;
            }
        }
        return false;
    }

    private final boolean D(d dVar) {
        ArrayList<d> arrayList = this.f2398e;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        for (d dVar2 : arrayList) {
            if (f2388m.l(dVar, dVar2) && dVar2.Q() == 5) {
                return true;
            }
        }
        return false;
    }

    private final boolean G(View view, float[] fArr, int i10, MotionEvent motionEvent) {
        boolean z10;
        int i11 = b.f2406a[this.f2396c.a(view).ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 == 4) {
                        if (view instanceof ViewGroup) {
                            z10 = n((ViewGroup) view, fArr, i10, motionEvent);
                        } else {
                            z10 = false;
                        }
                        if (z(view, fArr, i10, motionEvent) || z10 || f2388m.m(view, fArr)) {
                            return true;
                        }
                    } else {
                        throw new kotlin.n();
                    }
                } else if (view instanceof ViewGroup) {
                    boolean n10 = n((ViewGroup) view, fArr, i10, motionEvent);
                    if (!n10) {
                        return n10;
                    }
                    z(view, fArr, i10, motionEvent);
                    return n10;
                } else if (view instanceof EditText) {
                    return z(view, fArr, i10, motionEvent);
                }
            } else if (z(view, fArr, i10, motionEvent) || f2388m.m(view, fArr)) {
                return true;
            }
        }
        return false;
    }

    private final void H(d dVar) {
        if (D(dVar) || C(dVar)) {
            dVar.o();
        } else if (q(dVar)) {
            e(dVar);
        } else {
            v(dVar);
            dVar.u0(false);
        }
    }

    private final void e(d dVar) {
        if (!this.f2399f.contains(dVar)) {
            this.f2399f.add(dVar);
            this.f2401h.add(Integer.valueOf(dVar.R()));
            dVar.u0(true);
            int i10 = this.f2405l;
            this.f2405l = i10 + 1;
            dVar.s0(i10);
        }
    }

    private final boolean f(View view) {
        if (view.getVisibility() != 0 || view.getAlpha() < this.f2397d) {
            return false;
        }
        return true;
    }

    private final void g() {
        for (d o10 : r.m0(this.f2399f)) {
            o10.o();
        }
        this.f2400g.clear();
        this.f2400g.addAll(this.f2398e);
        for (d o11 : r.m0(this.f2398e)) {
            o11.o();
        }
    }

    private final void h() {
        for (d dVar : r.w0(this.f2399f)) {
            if (!dVar.Y()) {
                this.f2399f.remove(dVar);
                this.f2401h.remove(Integer.valueOf(dVar.R()));
            }
        }
    }

    private final void i() {
        for (d dVar : r.L(this.f2398e)) {
            if (f2388m.i(dVar.Q()) && !dVar.Y()) {
                dVar.n0();
                dVar.t0(false);
                dVar.u0(false);
                dVar.s0(Integer.MAX_VALUE);
            }
        }
        r.E(this.f2398e, d.f2408a);
        this.f2404k = false;
    }

    private final void j(d dVar, MotionEvent motionEvent) {
        boolean z10;
        if (!t(dVar.U())) {
            dVar.o();
        } else if (dVar.Q0()) {
            int actionMasked = motionEvent.getActionMasked();
            View U = dVar.U();
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            m.e(obtain, "obtain(...)");
            MotionEvent E = E(U, obtain);
            if (dVar.L() && dVar.Q() != 0) {
                dVar.P0(E, motionEvent);
            }
            if (!dVar.Y() || actionMasked != 2) {
                if (dVar.Q() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                dVar.V(E, motionEvent);
                if (dVar.X()) {
                    if (dVar.P()) {
                        dVar.F0(false);
                        dVar.p0();
                    }
                    dVar.t(E);
                }
                if (dVar.L() && z10) {
                    dVar.P0(E, motionEvent);
                }
                if (actionMasked == 1 || actionMasked == 6 || actionMasked == 10) {
                    dVar.N0(E.getPointerId(E.getActionIndex()));
                }
            }
            E.recycle();
        }
    }

    private final void k(MotionEvent motionEvent) {
        this.f2400g.clear();
        this.f2400g.addAll(this.f2398e);
        r.y(this.f2400g, f2393r);
        Iterator it = this.f2400g.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            m.c(dVar);
            j(dVar, motionEvent);
        }
    }

    private final boolean l(View view, float[] fArr, int i10) {
        boolean z10 = false;
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                ArrayList a10 = this.f2395b.a((View) parent);
                if (a10 != null) {
                    synchronized (a10) {
                        try {
                            Iterator it = a10.iterator();
                            while (it.hasNext()) {
                                d dVar = (d) it.next();
                                if (dVar.b0() && dVar.d0(view, fArr[0], fArr[1])) {
                                    m.c(dVar);
                                    y(dVar, viewGroup);
                                    dVar.M0(i10);
                                    z10 = true;
                                }
                            }
                            Unit unit = Unit.f12577a;
                        } finally {
                        }
                    }
                }
            }
        }
        return z10;
    }

    private final void m(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float[] fArr = f2392q;
        fArr[0] = motionEvent.getX(actionIndex);
        fArr[1] = motionEvent.getY(actionIndex);
        G(this.f2394a, fArr, pointerId, motionEvent);
        n(this.f2394a, fArr, pointerId, motionEvent);
    }

    private final boolean n(ViewGroup viewGroup, float[] fArr, int i10, MotionEvent motionEvent) {
        boolean z10;
        float[] fArr2 = fArr;
        for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
            View c10 = this.f2396c.c(viewGroup, childCount);
            if (f(c10)) {
                PointF pointF = f2389n;
                a aVar = f2388m;
                aVar.n(fArr2[0], fArr2[1], viewGroup, c10, pointF);
                float f10 = fArr2[0];
                float f11 = fArr2[1];
                fArr2[0] = pointF.x;
                fArr2[1] = pointF.y;
                if (!s(c10) || aVar.j(fArr2[0], fArr2[1], c10)) {
                    z10 = G(c10, fArr2, i10, motionEvent);
                } else {
                    int i11 = i10;
                    MotionEvent motionEvent2 = motionEvent;
                    z10 = false;
                }
                fArr2[0] = f10;
                fArr2[1] = f11;
                if (z10) {
                    return true;
                }
            } else {
                int i12 = i10;
                MotionEvent motionEvent3 = motionEvent;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final int p(d dVar, d dVar2) {
        if ((dVar.X() && dVar2.X()) || (dVar.Y() && dVar2.Y())) {
            return Integer.signum(dVar2.E() - dVar.E());
        }
        if (!dVar.X()) {
            if (!dVar2.X()) {
                if (!dVar.Y()) {
                    if (!dVar2.Y()) {
                        return 0;
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    private final boolean q(d dVar) {
        ArrayList<d> arrayList = this.f2398e;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        for (d dVar2 : arrayList) {
            a aVar = f2388m;
            if (!aVar.i(dVar2.Q()) && aVar.l(dVar, dVar2)) {
                return true;
            }
        }
        return false;
    }

    private final boolean s(View view) {
        if (!(view instanceof ViewGroup) || this.f2396c.b((ViewGroup) view)) {
            return true;
        }
        return false;
    }

    private final boolean t(View view) {
        if (view == null) {
            return false;
        }
        if (view == this.f2394a) {
            return true;
        }
        ViewParent parent = view.getParent();
        while (parent != null && parent != this.f2394a) {
            parent = parent.getParent();
        }
        if (parent == this.f2394a) {
            return true;
        }
        return false;
    }

    private final boolean u(View view) {
        ViewGroup viewGroup;
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return false;
        }
        Matrix matrix = view.getMatrix();
        float[] fArr = f2390o;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        matrix.mapPoints(fArr);
        float left = fArr[0] + ((float) view.getLeft());
        float top = fArr[1] + ((float) view.getTop());
        if (left < 0.0f || left + ((float) view.getWidth()) > ((float) viewGroup.getWidth()) || top < 0.0f || top + ((float) view.getHeight()) > ((float) viewGroup.getHeight())) {
            return true;
        }
        return false;
    }

    private final void v(d dVar) {
        int Q = dVar.Q();
        dVar.u0(false);
        dVar.t0(true);
        dVar.F0(true);
        int i10 = this.f2405l;
        this.f2405l = i10 + 1;
        dVar.s0(i10);
        for (d dVar2 : r.L(this.f2398e)) {
            if (f2388m.k(dVar2, dVar)) {
                dVar2.o();
            }
        }
        for (d dVar3 : r.m0(this.f2399f)) {
            if (f2388m.k(dVar3, dVar)) {
                dVar3.u0(false);
            }
        }
        h();
        if (Q != 1 && Q != 3) {
            dVar.u(4, 2);
            if (Q != 4) {
                dVar.u(5, 4);
                if (Q != 5) {
                    dVar.u(0, 5);
                }
            }
        }
    }

    private final void y(d dVar, View view) {
        if (!this.f2398e.contains(dVar)) {
            this.f2398e.add(dVar);
            dVar.t0(false);
            dVar.u0(false);
            dVar.s0(Integer.MAX_VALUE);
            dVar.m0(view, this);
        }
    }

    private final boolean z(View view, float[] fArr, int i10, MotionEvent motionEvent) {
        boolean z10;
        ArrayList a10 = this.f2395b.a(view);
        if (a10 != null) {
            synchronized (a10) {
                try {
                    Iterator it = a10.iterator();
                    z10 = false;
                    while (it.hasNext()) {
                        d dVar = (d) it.next();
                        if (dVar.b0()) {
                            if (dVar.d0(view, fArr[0], fArr[1])) {
                                if (!r.o(10, 9, 7).contains(Integer.valueOf(motionEvent.getAction())) || (dVar instanceof k)) {
                                    m.c(dVar);
                                    y(dVar, view);
                                    dVar.M0(i10);
                                    z10 = true;
                                }
                            }
                        }
                    }
                    Unit unit = Unit.f12577a;
                } finally {
                }
            }
        } else {
            z10 = false;
        }
        float width = (float) view.getWidth();
        float f10 = fArr[0];
        if (0.0f <= f10 && f10 <= width) {
            float height = (float) view.getHeight();
            float f11 = fArr[1];
            if (0.0f <= f11 && f11 <= height && u(view) && l(view, fArr, i10)) {
                return true;
            }
        }
        return z10;
    }

    public final void B(float f10) {
        this.f2397d = f10;
    }

    public final MotionEvent E(View view, MotionEvent motionEvent) {
        ViewGroup viewGroup;
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (view == null) {
            return motionEvent;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (!m.b(viewGroup, this.f2394a)) {
            E(viewGroup, motionEvent);
        }
        if (viewGroup != null) {
            motionEvent.setLocation((motionEvent.getX() + ((float) viewGroup.getScrollX())) - ((float) view.getLeft()), (motionEvent.getY() + ((float) viewGroup.getScrollY())) - ((float) view.getTop()));
        }
        if (!view.getMatrix().isIdentity()) {
            Matrix matrix = view.getMatrix();
            Matrix matrix2 = f2391p;
            matrix.invert(matrix2);
            motionEvent.transform(matrix2);
        }
        return motionEvent;
    }

    public final PointF F(View view, PointF pointF) {
        ViewGroup viewGroup;
        m.f(pointF, "point");
        if (view == null) {
            return pointF;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (!m.b(viewGroup, this.f2394a)) {
            F(viewGroup, pointF);
        }
        if (viewGroup != null) {
            pointF.x += (float) (viewGroup.getScrollX() - view.getLeft());
            pointF.y += (float) (viewGroup.getScrollY() - view.getTop());
        }
        if (!view.getMatrix().isIdentity()) {
            Matrix matrix = view.getMatrix();
            Matrix matrix2 = f2391p;
            matrix.invert(matrix2);
            float[] fArr = f2392q;
            fArr[0] = pointF.x;
            fArr[1] = pointF.y;
            matrix2.mapPoints(fArr);
            pointF.x = fArr[0];
            pointF.y = fArr[1];
        }
        return pointF;
    }

    public final void d(View view) {
        m.f(view, "view");
        ArrayList<d> a10 = this.f2395b.a(view);
        if (a10 != null) {
            for (d dVar : a10) {
                if (dVar instanceof o) {
                    y(dVar, view);
                    dVar.R0(new c(dVar));
                }
            }
        }
    }

    public final ArrayList o(View view) {
        m.f(view, "view");
        return this.f2395b.a(view);
    }

    public final boolean r() {
        ArrayList<d> arrayList = this.f2398e;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        for (d Q : arrayList) {
            if (Q.Q() == 4) {
                return true;
            }
        }
        return false;
    }

    public final void w(d dVar, int i10, int i11) {
        m.f(dVar, "handler");
        this.f2403j++;
        if (f2388m.i(i10)) {
            for (d dVar2 : r.w0(this.f2399f)) {
                if (f2388m.l(dVar2, dVar) && this.f2401h.contains(Integer.valueOf(dVar2.R()))) {
                    if (i10 == 5) {
                        dVar2.o();
                        if (dVar2.Q() == 5) {
                            dVar2.u(3, 2);
                        }
                        dVar2.u0(false);
                    } else {
                        H(dVar2);
                    }
                }
            }
            h();
        }
        if (i10 == 4) {
            H(dVar);
        } else if (i11 == 4 || i11 == 5) {
            if (dVar.X()) {
                dVar.u(i10, i11);
            } else if (i11 == 4 && (i10 == 3 || i10 == 1)) {
                dVar.u(i10, 2);
            }
        } else if (!(i11 == 0 && i10 == 3)) {
            dVar.u(i10, i11);
        }
        this.f2403j--;
        A();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r1 != 7) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean x(android.view.MotionEvent r4) {
        /*
            r3 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.m.f(r4, r0)
            r0 = 1
            r3.f2402i = r0
            int r1 = r4.getActionMasked()
            if (r1 == 0) goto L_0x001c
            r2 = 3
            if (r1 == r2) goto L_0x0018
            r2 = 5
            if (r1 == r2) goto L_0x001c
            r2 = 7
            if (r1 == r2) goto L_0x001c
            goto L_0x001f
        L_0x0018:
            r3.g()
            goto L_0x001f
        L_0x001c:
            r3.m(r4)
        L_0x001f:
            r3.k(r4)
            r4 = 0
            r3.f2402i = r4
            boolean r4 = r3.f2404k
            if (r4 == 0) goto L_0x0030
            int r4 = r3.f2403j
            if (r4 != 0) goto L_0x0030
            r3.i()
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ab.g.x(android.view.MotionEvent):boolean");
    }
}
