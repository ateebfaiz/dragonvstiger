package kd;

import hc.e;
import hc.l;
import hc.r;
import hc.s;
import hc.z0;
import qc.a;

public class j extends l {

    /* renamed from: a  reason: collision with root package name */
    private final hc.j f605a;

    /* renamed from: b  reason: collision with root package name */
    private final int f606b;

    /* renamed from: c  reason: collision with root package name */
    private final int f607c;

    /* renamed from: d  reason: collision with root package name */
    private final a f608d;

    public j(int i10, int i11, a aVar) {
        this.f605a = new hc.j(0);
        this.f606b = i10;
        this.f607c = i11;
        this.f608d = aVar;
    }

    public static j i(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj != null) {
            return new j(s.o(obj));
        }
        return null;
    }

    public r c() {
        e eVar = new e();
        eVar.a(this.f605a);
        eVar.a(new hc.j((long) this.f606b));
        eVar.a(new hc.j((long) this.f607c));
        eVar.a(this.f608d);
        return new z0(eVar);
    }

    public int g() {
        return this.f606b;
    }

    public int j() {
        return this.f607c;
    }

    public a k() {
        return this.f608d;
    }

    private j(s sVar) {
        this.f605a = hc.j.o(sVar.q(0));
        this.f606b = hc.j.o(sVar.q(1)).p().intValue();
        this.f607c = hc.j.o(sVar.q(2)).p().intValue();
        this.f608d = a.i(sVar.q(3));
    }
}
