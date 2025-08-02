package n0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.j;
import com.airbnb.lottie.k0;
import java.util.ArrayList;
import java.util.List;
import o0.a;
import o0.p;
import r0.e;
import r0.f;
import s0.n;
import t0.c;
import t0.q;
import u0.b;
import y0.l;

public class d implements e, m, a.b, f {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f22679a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f22680b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f22681c;

    /* renamed from: d  reason: collision with root package name */
    private final Path f22682d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f22683e;

    /* renamed from: f  reason: collision with root package name */
    private final String f22684f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f22685g;

    /* renamed from: h  reason: collision with root package name */
    private final List f22686h;

    /* renamed from: i  reason: collision with root package name */
    private final k0 f22687i;

    /* renamed from: j  reason: collision with root package name */
    private List f22688j;

    /* renamed from: k  reason: collision with root package name */
    private p f22689k;

    public d(k0 k0Var, b bVar, q qVar, j jVar) {
        this(k0Var, bVar, qVar.c(), qVar.d(), f(k0Var, jVar, bVar, qVar.b()), i(qVar.b()));
    }

    private static List f(k0 k0Var, j jVar, b bVar, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            c a10 = ((c) list.get(i10)).a(k0Var, jVar, bVar);
            if (a10 != null) {
                arrayList.add(a10);
            }
        }
        return arrayList;
    }

    static n i(List list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = (c) list.get(i10);
            if (cVar instanceof n) {
                return (n) cVar;
            }
        }
        return null;
    }

    private boolean m() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f22686h.size(); i11++) {
            if ((this.f22686h.get(i11) instanceof e) && (i10 = i10 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        this.f22687i.invalidateSelf();
    }

    public void b(List list, List list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f22686h.size());
        arrayList.addAll(list);
        for (int size = this.f22686h.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f22686h.get(size);
            cVar.b(arrayList, this.f22686h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    public void c(Object obj, z0.c cVar) {
        p pVar = this.f22689k;
        if (pVar != null) {
            pVar.c(obj, cVar);
        }
    }

    public void d(e eVar, int i10, List list, e eVar2) {
        if (eVar.g(getName(), i10) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.a(getName());
                if (eVar.c(getName(), i10)) {
                    list.add(eVar2.i(this));
                }
            }
            if (eVar.h(getName(), i10)) {
                int e10 = i10 + eVar.e(getName(), i10);
                for (int i11 = 0; i11 < this.f22686h.size(); i11++) {
                    c cVar = (c) this.f22686h.get(i11);
                    if (cVar instanceof f) {
                        ((f) cVar).d(eVar, e10, list, eVar2);
                    }
                }
            }
        }
    }

    public void e(RectF rectF, Matrix matrix, boolean z10) {
        this.f22681c.set(matrix);
        p pVar = this.f22689k;
        if (pVar != null) {
            this.f22681c.preConcat(pVar.f());
        }
        this.f22683e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f22686h.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f22686h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).e(this.f22683e, this.f22681c, z10);
                rectF.union(this.f22683e);
            }
        }
    }

    public void g(Canvas canvas, Matrix matrix, int i10) {
        boolean z10;
        int i11;
        if (!this.f22685g) {
            this.f22681c.set(matrix);
            p pVar = this.f22689k;
            if (pVar != null) {
                this.f22681c.preConcat(pVar.f());
                if (this.f22689k.h() == null) {
                    i11 = 100;
                } else {
                    i11 = ((Integer) this.f22689k.h().h()).intValue();
                }
                i10 = (int) ((((((float) i11) / 100.0f) * ((float) i10)) / 255.0f) * 255.0f);
            }
            if (!this.f22687i.f0() || !m() || i10 == 255) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                this.f22680b.set(0.0f, 0.0f, 0.0f, 0.0f);
                e(this.f22680b, this.f22681c, true);
                this.f22679a.setAlpha(i10);
                l.n(canvas, this.f22680b, this.f22679a);
            }
            if (z10) {
                i10 = 255;
            }
            for (int size = this.f22686h.size() - 1; size >= 0; size--) {
                Object obj = this.f22686h.get(size);
                if (obj instanceof e) {
                    ((e) obj).g(canvas, this.f22681c, i10);
                }
            }
            if (z10) {
                canvas.restore();
            }
        }
    }

    public String getName() {
        return this.f22684f;
    }

    public Path getPath() {
        this.f22681c.reset();
        p pVar = this.f22689k;
        if (pVar != null) {
            this.f22681c.set(pVar.f());
        }
        this.f22682d.reset();
        if (this.f22685g) {
            return this.f22682d;
        }
        for (int size = this.f22686h.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f22686h.get(size);
            if (cVar instanceof m) {
                this.f22682d.addPath(((m) cVar).getPath(), this.f22681c);
            }
        }
        return this.f22682d;
    }

    public List j() {
        return this.f22686h;
    }

    /* access modifiers changed from: package-private */
    public List k() {
        if (this.f22688j == null) {
            this.f22688j = new ArrayList();
            for (int i10 = 0; i10 < this.f22686h.size(); i10++) {
                c cVar = (c) this.f22686h.get(i10);
                if (cVar instanceof m) {
                    this.f22688j.add((m) cVar);
                }
            }
        }
        return this.f22688j;
    }

    /* access modifiers changed from: package-private */
    public Matrix l() {
        p pVar = this.f22689k;
        if (pVar != null) {
            return pVar.f();
        }
        this.f22681c.reset();
        return this.f22681c;
    }

    d(k0 k0Var, b bVar, String str, boolean z10, List list, n nVar) {
        this.f22679a = new m0.a();
        this.f22680b = new RectF();
        this.f22681c = new Matrix();
        this.f22682d = new Path();
        this.f22683e = new RectF();
        this.f22684f = str;
        this.f22687i = k0Var;
        this.f22685g = z10;
        this.f22686h = list;
        if (nVar != null) {
            p b10 = nVar.b();
            this.f22689k = b10;
            b10.a(bVar);
            this.f22689k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = (c) list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).f(list.listIterator(list.size()));
        }
    }
}
