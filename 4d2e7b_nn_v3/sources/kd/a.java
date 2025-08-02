package kd;

import hc.e;
import hc.j;
import hc.l;
import hc.n;
import hc.r;
import hc.s;
import hc.v0;
import hc.z0;
import yd.b;
import yd.h;
import yd.i;

public class a extends l {

    /* renamed from: a  reason: collision with root package name */
    private int f540a;

    /* renamed from: b  reason: collision with root package name */
    private int f541b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f542c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f543d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f544e;

    /* renamed from: f  reason: collision with root package name */
    private qc.a f545f;

    public a(int i10, int i11, b bVar, i iVar, h hVar, qc.a aVar) {
        this.f540a = i10;
        this.f541b = i11;
        this.f542c = bVar.e();
        this.f543d = iVar.h();
        this.f544e = hVar.a();
        this.f545f = aVar;
    }

    public static a k(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(s.o(obj));
        }
        return null;
    }

    public r c() {
        e eVar = new e();
        eVar.a(new j((long) this.f540a));
        eVar.a(new j((long) this.f541b));
        eVar.a(new v0(this.f542c));
        eVar.a(new v0(this.f543d));
        eVar.a(new v0(this.f544e));
        eVar.a(this.f545f);
        return new z0(eVar);
    }

    public qc.a g() {
        return this.f545f;
    }

    public b i() {
        return new b(this.f542c);
    }

    public i j() {
        return new i(i(), this.f543d);
    }

    public int l() {
        return this.f541b;
    }

    public int m() {
        return this.f540a;
    }

    public h n() {
        return new h(this.f544e);
    }

    private a(s sVar) {
        this.f540a = ((j) sVar.q(0)).p().intValue();
        this.f541b = ((j) sVar.q(1)).p().intValue();
        this.f542c = ((n) sVar.q(2)).q();
        this.f543d = ((n) sVar.q(3)).q();
        this.f544e = ((n) sVar.q(4)).q();
        this.f545f = qc.a.i(sVar.q(5));
    }
}
