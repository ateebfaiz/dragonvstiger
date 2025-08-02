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
import yd.b;
import yd.h;
import yd.i;

public class c extends l {

    /* renamed from: a  reason: collision with root package name */
    private int f550a;

    /* renamed from: b  reason: collision with root package name */
    private int f551b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f552c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f553d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f554e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f555f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f556g;

    public c(int i10, int i11, b bVar, i iVar, h hVar, h hVar2, a aVar) {
        this.f550a = i10;
        this.f551b = i11;
        this.f552c = bVar.e();
        this.f553d = iVar.h();
        this.f554e = aVar.c();
        this.f555f = hVar.a();
        this.f556g = hVar2.a();
    }

    public static c j(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(s.o(obj));
        }
        return null;
    }

    public r c() {
        e eVar = new e();
        eVar.a(new j((long) this.f550a));
        eVar.a(new j((long) this.f551b));
        eVar.a(new v0(this.f552c));
        eVar.a(new v0(this.f553d));
        eVar.a(new v0(this.f555f));
        eVar.a(new v0(this.f556g));
        eVar.a(new v0(this.f554e));
        return new z0(eVar);
    }

    public b g() {
        return new b(this.f552c);
    }

    public i i() {
        return new i(g(), this.f553d);
    }

    public int k() {
        return this.f551b;
    }

    public int l() {
        return this.f550a;
    }

    public h m() {
        return new h(this.f555f);
    }

    public h n() {
        return new h(this.f556g);
    }

    public a o() {
        return new a(this.f554e);
    }

    private c(s sVar) {
        this.f550a = ((j) sVar.q(0)).p().intValue();
        this.f551b = ((j) sVar.q(1)).p().intValue();
        this.f552c = ((n) sVar.q(2)).q();
        this.f553d = ((n) sVar.q(3)).q();
        this.f555f = ((n) sVar.q(4)).q();
        this.f556g = ((n) sVar.q(5)).q();
        this.f554e = ((n) sVar.q(6)).q();
    }
}
