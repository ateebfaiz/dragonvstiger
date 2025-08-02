package o0;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.j;
import y0.l;
import z0.a;

public class i extends a {

    /* renamed from: q  reason: collision with root package name */
    private Path f22910q;

    /* renamed from: r  reason: collision with root package name */
    private final a f22911r;

    public i(j jVar, a aVar) {
        super(jVar, (PointF) aVar.f24970b, (PointF) aVar.f24971c, aVar.f24972d, aVar.f24973e, aVar.f24974f, aVar.f24975g, aVar.f24976h);
        this.f22911r = aVar;
        j();
    }

    public void j() {
        boolean z10;
        Object obj;
        Object obj2;
        Object obj3 = this.f24971c;
        if (obj3 == null || (obj2 = this.f24970b) == null || !((PointF) obj2).equals(((PointF) obj3).x, ((PointF) obj3).y)) {
            z10 = false;
        } else {
            z10 = true;
        }
        Object obj4 = this.f24970b;
        if (obj4 != null && (obj = this.f24971c) != null && !z10) {
            a aVar = this.f22911r;
            this.f22910q = l.d((PointF) obj4, (PointF) obj, aVar.f24983o, aVar.f24984p);
        }
    }

    /* access modifiers changed from: package-private */
    public Path k() {
        return this.f22910q;
    }
}
