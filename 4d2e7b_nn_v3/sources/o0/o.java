package o0;

import java.util.List;
import z0.b;
import z0.c;

public class o extends g {

    class a extends c {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f22930d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f22931e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ r0.b f22932f;

        a(b bVar, c cVar, r0.b bVar2) {
            this.f22930d = bVar;
            this.f22931e = cVar;
            this.f22932f = bVar2;
        }

        /* renamed from: d */
        public r0.b a(b bVar) {
            Object g10;
            this.f22930d.h(bVar.f(), bVar.a(), ((r0.b) bVar.g()).f23595a, ((r0.b) bVar.b()).f23595a, bVar.d(), bVar.c(), bVar.e());
            String str = (String) this.f22931e.a(this.f22930d);
            if (bVar.c() == 1.0f) {
                g10 = bVar.b();
            } else {
                g10 = bVar.g();
            }
            r0.b bVar2 = (r0.b) g10;
            this.f22932f.a(str, bVar2.f23596b, bVar2.f23597c, bVar2.f23598d, bVar2.f23599e, bVar2.f23600f, bVar2.f23601g, bVar2.f23602h, bVar2.f23603i, bVar2.f23604j, bVar2.f23605k, bVar2.f23606l, bVar2.f23607m);
            return this.f22932f;
        }
    }

    public o(List list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public r0.b i(z0.a aVar, float f10) {
        Object obj;
        float f11;
        r0.b bVar;
        c cVar = this.f22882e;
        if (cVar != null) {
            float f12 = aVar.f24975g;
            Float f13 = aVar.f24976h;
            if (f13 == null) {
                f11 = Float.MAX_VALUE;
            } else {
                f11 = f13.floatValue();
            }
            Object obj2 = aVar.f24970b;
            r0.b bVar2 = (r0.b) obj2;
            Object obj3 = aVar.f24971c;
            if (obj3 == null) {
                bVar = (r0.b) obj2;
            } else {
                bVar = (r0.b) obj3;
            }
            return (r0.b) cVar.b(f12, f11, bVar2, bVar, f10, d(), f());
        } else if (f10 != 1.0f || (obj = aVar.f24971c) == null) {
            return (r0.b) aVar.f24970b;
        } else {
            return (r0.b) obj;
        }
    }

    public void r(c cVar) {
        super.o(new a(new b(), cVar, new r0.b()));
    }
}
