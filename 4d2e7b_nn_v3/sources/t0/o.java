package t0;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import r0.a;
import y0.f;
import y0.k;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private final List f24019a;

    /* renamed from: b  reason: collision with root package name */
    private PointF f24020b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24021c;

    public o(PointF pointF, boolean z10, List list) {
        this.f24020b = pointF;
        this.f24021c = z10;
        this.f24019a = new ArrayList(list);
    }

    public List a() {
        return this.f24019a;
    }

    public PointF b() {
        return this.f24020b;
    }

    public void c(o oVar, o oVar2, float f10) {
        boolean z10;
        if (this.f24020b == null) {
            this.f24020b = new PointF();
        }
        if (oVar.d() || oVar2.d()) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f24021c = z10;
        if (oVar.a().size() != oVar2.a().size()) {
            f.c("Curves must have the same number of control points. Shape 1: " + oVar.a().size() + "\tShape 2: " + oVar2.a().size());
        }
        int min = Math.min(oVar.a().size(), oVar2.a().size());
        if (this.f24019a.size() < min) {
            for (int size = this.f24019a.size(); size < min; size++) {
                this.f24019a.add(new a());
            }
        } else if (this.f24019a.size() > min) {
            for (int size2 = this.f24019a.size() - 1; size2 >= min; size2--) {
                List list = this.f24019a;
                list.remove(list.size() - 1);
            }
        }
        PointF b10 = oVar.b();
        PointF b11 = oVar2.b();
        f(k.i(b10.x, b11.x, f10), k.i(b10.y, b11.y, f10));
        for (int size3 = this.f24019a.size() - 1; size3 >= 0; size3--) {
            a aVar = (a) oVar.a().get(size3);
            a aVar2 = (a) oVar2.a().get(size3);
            PointF a10 = aVar.a();
            PointF b12 = aVar.b();
            PointF c10 = aVar.c();
            PointF a11 = aVar2.a();
            PointF b13 = aVar2.b();
            PointF c11 = aVar2.c();
            ((a) this.f24019a.get(size3)).d(k.i(a10.x, a11.x, f10), k.i(a10.y, a11.y, f10));
            ((a) this.f24019a.get(size3)).e(k.i(b12.x, b13.x, f10), k.i(b12.y, b13.y, f10));
            ((a) this.f24019a.get(size3)).f(k.i(c10.x, c11.x, f10), k.i(c10.y, c11.y, f10));
        }
    }

    public boolean d() {
        return this.f24021c;
    }

    public void e(boolean z10) {
        this.f24021c = z10;
    }

    public void f(float f10, float f11) {
        if (this.f24020b == null) {
            this.f24020b = new PointF();
        }
        this.f24020b.set(f10, f11);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f24019a.size() + "closed=" + this.f24021c + '}';
    }

    public o() {
        this.f24019a = new ArrayList();
    }
}
