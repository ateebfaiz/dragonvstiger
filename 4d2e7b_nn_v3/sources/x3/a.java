package x3;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import l5.b;
import w3.f;
import w3.g;
import w3.o;
import w3.p;
import y2.l;
import z3.c;

public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f24715a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f24716b;

    /* renamed from: c  reason: collision with root package name */
    private e f24717c;

    /* renamed from: d  reason: collision with root package name */
    private final d f24718d;

    /* renamed from: e  reason: collision with root package name */
    private final f f24719e;

    /* renamed from: f  reason: collision with root package name */
    private final g f24720f;

    a(b bVar) {
        int i10;
        int i11;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        this.f24715a = colorDrawable;
        if (b.d()) {
            b.a("GenericDraweeHierarchy()");
        }
        this.f24716b = bVar.p();
        this.f24717c = bVar.s();
        g gVar = new g(colorDrawable);
        this.f24720f = gVar;
        int i12 = 1;
        if (bVar.j() != null) {
            i10 = bVar.j().size();
        } else {
            i10 = 1;
        }
        i10 = i10 == 0 ? 1 : i10;
        if (bVar.m() != null) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        int i13 = i10 + i11;
        Drawable[] drawableArr = new Drawable[(i13 + 6)];
        drawableArr[0] = j(bVar.e(), (p.b) null);
        drawableArr[1] = j(bVar.k(), bVar.l());
        drawableArr[2] = i(gVar, bVar.d(), bVar.c(), bVar.b());
        drawableArr[3] = j(bVar.n(), bVar.o());
        drawableArr[4] = j(bVar.q(), bVar.r());
        drawableArr[5] = j(bVar.h(), bVar.i());
        if (i13 > 0) {
            if (bVar.j() != null) {
                i12 = 0;
                for (Drawable j10 : bVar.j()) {
                    drawableArr[i12 + 6] = j(j10, (p.b) null);
                    i12++;
                }
            }
            if (bVar.m() != null) {
                drawableArr[i12 + 6] = j(bVar.m(), (p.b) null);
            }
        }
        f fVar = new f(drawableArr, false, 2);
        this.f24719e = fVar;
        fVar.u(bVar.g());
        d dVar = new d(f.e(fVar, this.f24717c));
        this.f24718d = dVar;
        dVar.mutate();
        u();
        if (b.d()) {
            b.b();
        }
    }

    private void A(float f10) {
        Drawable b10 = this.f24719e.b(3);
        if (b10 != null) {
            if (f10 >= 0.999f) {
                if (b10 instanceof Animatable) {
                    ((Animatable) b10).stop();
                }
                m(3);
            } else {
                if (b10 instanceof Animatable) {
                    ((Animatable) b10).start();
                }
                k(3);
            }
            b10.setLevel(Math.round(f10 * 10000.0f));
        }
    }

    private Drawable i(Drawable drawable, p.b bVar, PointF pointF, ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return f.g(drawable, bVar, pointF);
    }

    private Drawable j(Drawable drawable, p.b bVar) {
        return f.f(f.d(drawable, this.f24717c, this.f24716b), bVar);
    }

    private void k(int i10) {
        if (i10 >= 0) {
            this.f24719e.m(i10);
        }
    }

    private void l() {
        m(1);
        m(2);
        m(3);
        m(4);
        m(5);
    }

    private void m(int i10) {
        if (i10 >= 0) {
            this.f24719e.n(i10);
        }
    }

    private w3.c p(int i10) {
        w3.c d10 = this.f24719e.d(i10);
        d10.r();
        if (d10.r() instanceof o) {
            return (o) d10.r();
        }
        return d10;
    }

    private o r(int i10) {
        w3.c p10 = p(i10);
        if (p10 instanceof o) {
            return (o) p10;
        }
        return f.k(p10, p.b.f24582a);
    }

    private boolean s(int i10) {
        return p(i10) instanceof o;
    }

    private void t() {
        this.f24720f.setDrawable(this.f24715a);
    }

    private void u() {
        f fVar = this.f24719e;
        if (fVar != null) {
            fVar.h();
            this.f24719e.k();
            l();
            k(1);
            this.f24719e.o();
            this.f24719e.j();
        }
    }

    private void x(int i10, Drawable drawable) {
        if (drawable == null) {
            this.f24719e.f(i10, (Drawable) null);
            return;
        }
        p(i10).setDrawable(f.d(drawable, this.f24717c, this.f24716b));
    }

    public void B(Drawable drawable) {
        x(3, drawable);
    }

    public void C(e eVar) {
        this.f24717c = eVar;
        f.j(this.f24718d, eVar);
        for (int i10 = 0; i10 < this.f24719e.e(); i10++) {
            f.i(p(i10), this.f24717c, this.f24716b);
        }
    }

    public Rect a() {
        return this.f24718d.getBounds();
    }

    public void b(Drawable drawable) {
        this.f24718d.w(drawable);
    }

    public void c(Throwable th) {
        this.f24719e.h();
        l();
        if (this.f24719e.b(4) != null) {
            k(4);
        } else {
            k(1);
        }
        this.f24719e.j();
    }

    public void d(Throwable th) {
        this.f24719e.h();
        l();
        if (this.f24719e.b(5) != null) {
            k(5);
        } else {
            k(1);
        }
        this.f24719e.j();
    }

    public void e(float f10, boolean z10) {
        if (this.f24719e.b(3) != null) {
            this.f24719e.h();
            A(f10);
            if (z10) {
                this.f24719e.o();
            }
            this.f24719e.j();
        }
    }

    public Drawable f() {
        return this.f24718d;
    }

    public void g(Drawable drawable, float f10, boolean z10) {
        Drawable d10 = f.d(drawable, this.f24717c, this.f24716b);
        d10.mutate();
        this.f24720f.setDrawable(d10);
        this.f24719e.h();
        l();
        k(2);
        A(f10);
        if (z10) {
            this.f24719e.o();
        }
        this.f24719e.j();
    }

    public void h() {
        t();
        u();
    }

    public PointF n() {
        if (!s(2)) {
            return null;
        }
        return r(2).y();
    }

    public p.b o() {
        if (!s(2)) {
            return null;
        }
        return r(2).z();
    }

    public e q() {
        return this.f24717c;
    }

    public void v(p.b bVar) {
        l.g(bVar);
        r(2).B(bVar);
    }

    public void w(Drawable drawable) {
        x(0, drawable);
    }

    public void y(int i10) {
        this.f24719e.u(i10);
    }

    public void z(Drawable drawable, p.b bVar) {
        x(1, drawable);
        r(1).B(bVar);
    }
}
