package t7;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.m;
import z4.k;
import z4.o;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f13066a = new b();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final a f13067a;

        /* renamed from: b  reason: collision with root package name */
        public final a f13068b;

        public a(a aVar, a aVar2) {
            this.f13067a = aVar;
            this.f13068b = aVar2;
        }
    }

    private b() {
    }

    public static final a a(int i10, int i11, List list) {
        m.f(list, "sources");
        return b(i10, i11, list, 1.0d);
    }

    public static final a b(int i10, int i11, List list, double d10) {
        m.f(list, "sources");
        a aVar = null;
        if (list.isEmpty()) {
            return new a((a) null, (a) null);
        }
        if (list.size() == 1) {
            return new a((a) list.get(0), (a) null);
        }
        if (i10 <= 0 || i11 <= 0) {
            return new a((a) null, (a) null);
        }
        k l10 = o.n().l();
        m.e(l10, "getImagePipeline(...)");
        double d11 = ((double) (i10 * i11)) * d10;
        Iterator it = list.iterator();
        double d12 = Double.MAX_VALUE;
        double d13 = Double.MAX_VALUE;
        a aVar2 = null;
        a aVar3 = null;
        while (it.hasNext()) {
            a aVar4 = (a) it.next();
            double abs = Math.abs(1.0d - (aVar4.c() / d11));
            if (abs < d12) {
                aVar3 = aVar4;
                d12 = abs;
            }
            if (abs < d13 && (l10.p(aVar4.f()) || l10.r(aVar4.f()))) {
                aVar2 = aVar4;
                d13 = abs;
            }
        }
        if (aVar2 == null || aVar3 == null || !m.b(aVar2.d(), aVar3.d())) {
            aVar = aVar2;
        }
        return new a(aVar3, aVar);
    }
}
