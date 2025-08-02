package n0;

import android.graphics.Path;
import com.airbnb.lottie.k0;
import com.airbnb.lottie.r0;
import java.util.ArrayList;
import java.util.List;
import o0.a;
import o0.m;
import r0.e;
import t0.t;
import u0.b;
import y0.k;
import z0.c;

public class r implements m, a.b, k {

    /* renamed from: a  reason: collision with root package name */
    private final Path f22792a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f22793b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f22794c;

    /* renamed from: d  reason: collision with root package name */
    private final k0 f22795d;

    /* renamed from: e  reason: collision with root package name */
    private final m f22796e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22797f;

    /* renamed from: g  reason: collision with root package name */
    private final b f22798g = new b();

    public r(k0 k0Var, b bVar, t0.r rVar) {
        this.f22793b = rVar.b();
        this.f22794c = rVar.d();
        this.f22795d = k0Var;
        m d10 = rVar.c().a();
        this.f22796e = d10;
        bVar.i(d10);
        d10.a(this);
    }

    private void f() {
        this.f22797f = false;
        this.f22795d.invalidateSelf();
    }

    public void a() {
        f();
    }

    public void b(List list, List list2) {
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = (c) list.get(i10);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.j() == t.a.SIMULTANEOUSLY) {
                    this.f22798g.a(uVar);
                    uVar.c(this);
                }
            }
            if (cVar instanceof s) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((s) cVar);
            }
        }
        this.f22796e.r(arrayList);
    }

    public void c(Object obj, c cVar) {
        if (obj == r0.P) {
            this.f22796e.o(cVar);
        }
    }

    public void d(e eVar, int i10, List list, e eVar2) {
        k.k(eVar, i10, list, eVar2, this);
    }

    public String getName() {
        return this.f22793b;
    }

    public Path getPath() {
        if (this.f22797f && !this.f22796e.k()) {
            return this.f22792a;
        }
        this.f22792a.reset();
        if (this.f22794c) {
            this.f22797f = true;
            return this.f22792a;
        }
        Path path = (Path) this.f22796e.h();
        if (path == null) {
            return this.f22792a;
        }
        this.f22792a.set(path);
        this.f22792a.setFillType(Path.FillType.EVEN_ODD);
        this.f22798g.b(this.f22792a);
        this.f22797f = true;
        return this.f22792a;
    }
}
