package kd;

import hc.e;
import hc.j;
import hc.l;
import hc.r;
import hc.s;
import hc.z0;
import qc.a;

public class i extends l {

    /* renamed from: a  reason: collision with root package name */
    private final j f602a;

    /* renamed from: b  reason: collision with root package name */
    private final int f603b;

    /* renamed from: c  reason: collision with root package name */
    private final a f604c;

    public i(int i10, a aVar) {
        this.f602a = new j(0);
        this.f603b = i10;
        this.f604c = aVar;
    }

    public static i i(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(s.o(obj));
        }
        return null;
    }

    public r c() {
        e eVar = new e();
        eVar.a(this.f602a);
        eVar.a(new j((long) this.f603b));
        eVar.a(this.f604c);
        return new z0(eVar);
    }

    public int g() {
        return this.f603b;
    }

    public a j() {
        return this.f604c;
    }

    private i(s sVar) {
        this.f602a = j.o(sVar.q(0));
        this.f603b = j.o(sVar.q(1)).p().intValue();
        this.f604c = a.i(sVar.q(2));
    }
}
