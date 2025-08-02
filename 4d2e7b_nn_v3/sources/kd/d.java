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

public class d extends l {

    /* renamed from: a  reason: collision with root package name */
    private final int f557a;

    /* renamed from: b  reason: collision with root package name */
    private final int f558b;

    /* renamed from: c  reason: collision with root package name */
    private final a f559c;

    public d(int i10, int i11, a aVar) {
        this.f557a = i10;
        this.f558b = i11;
        this.f559c = new a(aVar);
    }

    public static d i(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(s.o(obj));
        }
        return null;
    }

    public r c() {
        e eVar = new e();
        eVar.a(new j((long) this.f557a));
        eVar.a(new j((long) this.f558b));
        eVar.a(new v0(this.f559c.c()));
        return new z0(eVar);
    }

    public a g() {
        return new a(this.f559c);
    }

    public int j() {
        return this.f557a;
    }

    public int k() {
        return this.f558b;
    }

    private d(s sVar) {
        this.f557a = ((j) sVar.q(0)).p().intValue();
        this.f558b = ((j) sVar.q(1)).p().intValue();
        this.f559c = new a(((n) sVar.q(2)).q());
    }
}
