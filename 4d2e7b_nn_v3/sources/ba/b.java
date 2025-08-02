package ba;

import aa.c;
import aa.i;
import java.lang.reflect.Type;
import java.util.Collection;
import y9.d;
import y9.r;
import y9.s;

public final class b implements s {

    /* renamed from: a  reason: collision with root package name */
    private final c f2514a;

    private static final class a extends r {

        /* renamed from: a  reason: collision with root package name */
        private final r f2515a;

        /* renamed from: b  reason: collision with root package name */
        private final i f2516b;

        public a(d dVar, Type type, r rVar, i iVar) {
            this.f2515a = new l(dVar, rVar, type);
            this.f2516b = iVar;
        }

        /* renamed from: e */
        public Collection b(ga.a aVar) {
            if (aVar.O() == ga.b.NULL) {
                aVar.K();
                return null;
            }
            Collection collection = (Collection) this.f2516b.construct();
            aVar.a();
            while (aVar.y()) {
                collection.add(this.f2515a.b(aVar));
            }
            aVar.m();
            return collection;
        }

        /* renamed from: f */
        public void d(ga.c cVar, Collection collection) {
            if (collection == null) {
                cVar.B();
                return;
            }
            cVar.h();
            for (Object d10 : collection) {
                this.f2515a.d(cVar, d10);
            }
            cVar.m();
        }
    }

    public b(c cVar) {
        this.f2514a = cVar;
    }

    public r a(d dVar, fa.a aVar) {
        Type e10 = aVar.e();
        Class d10 = aVar.d();
        if (!Collection.class.isAssignableFrom(d10)) {
            return null;
        }
        Type h10 = aa.b.h(e10, d10);
        return new a(dVar, h10, dVar.k(fa.a.b(h10)), this.f2514a.b(aVar));
    }
}
