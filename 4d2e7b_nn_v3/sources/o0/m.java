package o0;

import android.graphics.Path;
import java.util.List;
import n0.s;
import t0.o;
import y0.k;
import z0.a;
import z0.c;

public class m extends a {

    /* renamed from: i  reason: collision with root package name */
    private final o f22919i = new o();

    /* renamed from: j  reason: collision with root package name */
    private final Path f22920j = new Path();

    /* renamed from: k  reason: collision with root package name */
    private Path f22921k;

    /* renamed from: l  reason: collision with root package name */
    private Path f22922l;

    /* renamed from: m  reason: collision with root package name */
    private List f22923m;

    public m(List list) {
        super(list);
    }

    /* renamed from: q */
    public Path i(a aVar, float f10) {
        o oVar;
        Path path;
        o oVar2 = (o) aVar.f24970b;
        o oVar3 = (o) aVar.f24971c;
        o oVar4 = this.f22919i;
        if (oVar3 == null) {
            oVar = oVar2;
        } else {
            oVar = oVar3;
        }
        oVar4.c(oVar2, oVar, f10);
        o oVar5 = this.f22919i;
        List list = this.f22923m;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                oVar5 = ((s) this.f22923m.get(size)).h(oVar5);
            }
        }
        k.h(oVar5, this.f22920j);
        if (this.f22882e == null) {
            return this.f22920j;
        }
        if (this.f22921k == null) {
            this.f22921k = new Path();
            this.f22922l = new Path();
        }
        k.h(oVar2, this.f22921k);
        if (oVar3 != null) {
            k.h(oVar3, this.f22922l);
        }
        c cVar = this.f22882e;
        float f11 = aVar.f24975g;
        float floatValue = aVar.f24976h.floatValue();
        Path path2 = this.f22921k;
        if (oVar3 == null) {
            path = path2;
        } else {
            path = this.f22922l;
        }
        return (Path) cVar.b(f11, floatValue, path2, path, f10, e(), f());
    }

    public void r(List list) {
        this.f22923m = list;
    }
}
