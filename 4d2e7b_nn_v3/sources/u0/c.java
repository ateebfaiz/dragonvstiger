package u0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.j;
import com.airbnb.lottie.k0;
import com.airbnb.lottie.r0;
import java.util.ArrayList;
import java.util.List;
import o0.d;
import o0.q;
import r0.e;
import s0.b;
import y0.l;

public class c extends b {
    private o0.a E;
    private final List F = new ArrayList();
    private final RectF G = new RectF();
    private final RectF H = new RectF();
    private final Paint I = new Paint();
    private float J;
    private boolean K = true;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24203a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                u0.e$b[] r0 = u0.e.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24203a = r0
                u0.e$b r1 = u0.e.b.ADD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24203a     // Catch:{ NoSuchFieldError -> 0x001d }
                u0.e$b r1 = u0.e.b.INVERT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: u0.c.a.<clinit>():void");
        }
    }

    public c(k0 k0Var, e eVar, List list, j jVar) {
        super(k0Var, eVar);
        int i10;
        b bVar;
        b v10 = eVar.v();
        if (v10 != null) {
            d d10 = v10.a();
            this.E = d10;
            i(d10);
            this.E.a(this);
        } else {
            this.E = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(jVar.k().size());
        int size = list.size() - 1;
        b bVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            e eVar2 = (e) list.get(size);
            b u10 = b.u(this, eVar2, k0Var, jVar);
            if (u10 != null) {
                longSparseArray.put(u10.z().e(), u10);
                if (bVar2 != null) {
                    bVar2.J(u10);
                    bVar2 = null;
                } else {
                    this.F.add(0, u10);
                    int i11 = a.f24203a[eVar2.i().ordinal()];
                    if (i11 == 1 || i11 == 2) {
                        bVar2 = u10;
                    }
                }
            }
            size--;
        }
        for (i10 = 0; i10 < longSparseArray.size(); i10++) {
            b bVar3 = (b) longSparseArray.get(longSparseArray.keyAt(i10));
            if (!(bVar3 == null || (bVar = (b) longSparseArray.get(bVar3.z().k())) == null)) {
                bVar3.L(bVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void I(e eVar, int i10, List list, e eVar2) {
        for (int i11 = 0; i11 < this.F.size(); i11++) {
            ((b) this.F.get(i11)).d(eVar, i10, list, eVar2);
        }
    }

    public void K(boolean z10) {
        super.K(z10);
        for (b K2 : this.F) {
            K2.K(z10);
        }
    }

    public void M(float f10) {
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.b("CompositionLayer#setProgress");
        }
        this.J = f10;
        super.M(f10);
        if (this.E != null) {
            f10 = ((((Float) this.E.h()).floatValue() * this.f24191q.c().i()) - this.f24191q.c().p()) / (this.f24190p.J().e() + 0.01f);
        }
        if (this.E == null) {
            f10 -= this.f24191q.s();
        }
        if (this.f24191q.w() != 0.0f && !"__container".equals(this.f24191q.j())) {
            f10 /= this.f24191q.w();
        }
        for (int size = this.F.size() - 1; size >= 0; size--) {
            ((b) this.F.get(size)).M(f10);
        }
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.c("CompositionLayer#setProgress");
        }
    }

    public float P() {
        return this.J;
    }

    public void Q(boolean z10) {
        this.K = z10;
    }

    public void c(Object obj, z0.c cVar) {
        super.c(obj, cVar);
        if (obj != r0.E) {
            return;
        }
        if (cVar == null) {
            o0.a aVar = this.E;
            if (aVar != null) {
                aVar.o((z0.c) null);
                return;
            }
            return;
        }
        q qVar = new q(cVar);
        this.E = qVar;
        qVar.a(this);
        i(this.E);
    }

    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.G.set(0.0f, 0.0f, 0.0f, 0.0f);
            ((b) this.F.get(size)).e(this.G, this.f24189o, true);
            rectF.union(this.G);
        }
    }

    /* access modifiers changed from: package-private */
    public void t(Canvas canvas, Matrix matrix, int i10) {
        boolean z10;
        boolean z11;
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.b("CompositionLayer#draw");
        }
        this.H.set(0.0f, 0.0f, this.f24191q.m(), this.f24191q.l());
        matrix.mapRect(this.H);
        if (!this.f24190p.f0() || this.F.size() <= 1 || i10 == 255) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            this.I.setAlpha(i10);
            l.n(canvas, this.H, this.I);
        } else {
            canvas.save();
        }
        if (z10) {
            i10 = 255;
        }
        for (int size = this.F.size() - 1; size >= 0; size--) {
            if ((this.K || !"__container".equals(this.f24191q.j())) && !this.H.isEmpty()) {
                z11 = canvas.clipRect(this.H);
            } else {
                z11 = true;
            }
            if (z11) {
                ((b) this.F.get(size)).g(canvas, matrix, i10);
            }
        }
        canvas.restore();
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.c("CompositionLayer#draw");
        }
    }
}
