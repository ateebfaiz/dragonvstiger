package kd;

import hc.e;
import hc.j;
import hc.l;
import hc.n;
import hc.r;
import hc.s;
import hc.v0;
import hc.z0;
import yd.a;

public class b extends l {

    /* renamed from: a  reason: collision with root package name */
    private final int f546a;

    /* renamed from: b  reason: collision with root package name */
    private final int f547b;

    /* renamed from: c  reason: collision with root package name */
    private final a f548c;

    /* renamed from: d  reason: collision with root package name */
    private final qc.a f549d;

    public b(int i10, int i11, a aVar, qc.a aVar2) {
        this.f546a = i10;
        this.f547b = i11;
        this.f548c = new a(aVar.c());
        this.f549d = aVar2;
    }

    public static b j(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(s.o(obj));
        }
        return null;
    }

    public r c() {
        e eVar = new e();
        eVar.a(new j((long) this.f546a));
        eVar.a(new j((long) this.f547b));
        eVar.a(new v0(this.f548c.c()));
        eVar.a(this.f549d);
        return new z0(eVar);
    }

    public qc.a g() {
        return this.f549d;
    }

    public a i() {
        return this.f548c;
    }

    public int k() {
        return this.f546a;
    }

    public int l() {
        return this.f547b;
    }

    private b(s sVar) {
        this.f546a = ((j) sVar.q(0)).p().intValue();
        this.f547b = ((j) sVar.q(1)).p().intValue();
        this.f548c = new a(((n) sVar.q(2)).q());
        this.f549d = qc.a.i(sVar.q(3));
    }
}
