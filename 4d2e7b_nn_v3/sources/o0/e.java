package o0;

import java.util.List;
import t0.d;
import z0.a;

public class e extends g {

    /* renamed from: i  reason: collision with root package name */
    private final d f22906i;

    public e(List list) {
        super(list);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            d dVar = (d) ((a) list.get(i11)).f24970b;
            if (dVar != null) {
                i10 = Math.max(i10, dVar.f());
            }
        }
        this.f22906i = new d(new float[i10], new int[i10]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public d i(a aVar, float f10) {
        this.f22906i.g((d) aVar.f24970b, (d) aVar.f24971c, f10);
        return this.f22906i;
    }
}
