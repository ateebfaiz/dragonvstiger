package ba;

import aa.c;
import aa.f;
import aa.i;
import ga.b;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import y9.d;
import y9.l;
import y9.m;
import y9.r;
import y9.s;

public final class g implements s {

    /* renamed from: a  reason: collision with root package name */
    private final c f2524a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f2525b;

    private final class a extends r {

        /* renamed from: a  reason: collision with root package name */
        private final r f2526a;

        /* renamed from: b  reason: collision with root package name */
        private final r f2527b;

        /* renamed from: c  reason: collision with root package name */
        private final i f2528c;

        public a(d dVar, Type type, r rVar, Type type2, r rVar2, i iVar) {
            this.f2526a = new l(dVar, rVar, type);
            this.f2527b = new l(dVar, rVar2, type2);
            this.f2528c = iVar;
        }

        private String e(y9.g gVar) {
            if (gVar.i()) {
                l d10 = gVar.d();
                if (d10.o()) {
                    return String.valueOf(d10.k());
                }
                if (d10.m()) {
                    return Boolean.toString(d10.j());
                }
                if (d10.p()) {
                    return d10.l();
                }
                throw new AssertionError();
            } else if (gVar.f()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        /* renamed from: f */
        public Map b(ga.a aVar) {
            b O = aVar.O();
            if (O == b.NULL) {
                aVar.K();
                return null;
            }
            Map map = (Map) this.f2528c.construct();
            if (O == b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.y()) {
                    aVar.a();
                    Object b10 = this.f2526a.b(aVar);
                    if (map.put(b10, this.f2527b.b(aVar)) == null) {
                        aVar.m();
                    } else {
                        throw new m("duplicate key: " + b10);
                    }
                }
                aVar.m();
            } else {
                aVar.b();
                while (aVar.y()) {
                    f.f2295a.a(aVar);
                    Object b11 = this.f2526a.b(aVar);
                    if (map.put(b11, this.f2527b.b(aVar)) != null) {
                        throw new m("duplicate key: " + b11);
                    }
                }
                aVar.n();
            }
            return map;
        }

        /* renamed from: g */
        public void d(ga.c cVar, Map map) {
            boolean z10;
            if (map == null) {
                cVar.B();
            } else if (!g.this.f2525b) {
                cVar.j();
                for (Map.Entry entry : map.entrySet()) {
                    cVar.z(String.valueOf(entry.getKey()));
                    this.f2527b.d(cVar, entry.getValue());
                }
                cVar.n();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i10 = 0;
                boolean z11 = false;
                for (Map.Entry entry2 : map.entrySet()) {
                    y9.g c10 = this.f2526a.c(entry2.getKey());
                    arrayList.add(c10);
                    arrayList2.add(entry2.getValue());
                    if (c10.e() || c10.g()) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 |= z10;
                }
                if (z11) {
                    cVar.h();
                    int size = arrayList.size();
                    while (i10 < size) {
                        cVar.h();
                        aa.m.a((y9.g) arrayList.get(i10), cVar);
                        this.f2527b.d(cVar, arrayList2.get(i10));
                        cVar.m();
                        i10++;
                    }
                    cVar.m();
                    return;
                }
                cVar.j();
                int size2 = arrayList.size();
                while (i10 < size2) {
                    cVar.z(e((y9.g) arrayList.get(i10)));
                    this.f2527b.d(cVar, arrayList2.get(i10));
                    i10++;
                }
                cVar.n();
            }
        }
    }

    public g(c cVar, boolean z10) {
        this.f2524a = cVar;
        this.f2525b = z10;
    }

    private r b(d dVar, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return m.f2572f;
        }
        return dVar.k(fa.a.b(type));
    }

    public r a(d dVar, fa.a aVar) {
        Type e10 = aVar.e();
        Class d10 = aVar.d();
        if (!Map.class.isAssignableFrom(d10)) {
            return null;
        }
        Type[] j10 = aa.b.j(e10, d10);
        return new a(dVar, j10[0], b(dVar, j10[0]), j10[1], dVar.k(fa.a.b(j10[1])), this.f2524a.b(aVar));
    }
}
