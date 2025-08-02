package kd;

import hc.e;
import hc.j;
import hc.l;
import hc.r;
import hc.s;
import hc.z0;
import qc.a;

public class h extends l {

    /* renamed from: a  reason: collision with root package name */
    private final j f600a;

    /* renamed from: b  reason: collision with root package name */
    private final a f601b;

    public h(a aVar) {
        this.f600a = new j(0);
        this.f601b = aVar;
    }

    public static final h g(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(s.o(obj));
        }
        return null;
    }

    public r c() {
        e eVar = new e();
        eVar.a(this.f600a);
        eVar.a(this.f601b);
        return new z0(eVar);
    }

    public a i() {
        return this.f601b;
    }

    private h(s sVar) {
        this.f600a = j.o(sVar.q(0));
        this.f601b = a.i(sVar.q(1));
    }
}
