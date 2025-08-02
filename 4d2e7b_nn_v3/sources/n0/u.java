package n0;

import java.util.ArrayList;
import java.util.List;
import o0.a;
import o0.d;
import t0.t;
import u0.b;

public class u implements c, a.b {

    /* renamed from: a  reason: collision with root package name */
    private final String f22804a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22805b;

    /* renamed from: c  reason: collision with root package name */
    private final List f22806c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final t.a f22807d;

    /* renamed from: e  reason: collision with root package name */
    private final a f22808e;

    /* renamed from: f  reason: collision with root package name */
    private final a f22809f;

    /* renamed from: g  reason: collision with root package name */
    private final a f22810g;

    public u(b bVar, t tVar) {
        this.f22804a = tVar.c();
        this.f22805b = tVar.g();
        this.f22807d = tVar.f();
        d d10 = tVar.e().a();
        this.f22808e = d10;
        d d11 = tVar.b().a();
        this.f22809f = d11;
        d d12 = tVar.d().a();
        this.f22810g = d12;
        bVar.i(d10);
        bVar.i(d11);
        bVar.i(d12);
        d10.a(this);
        d11.a(this);
        d12.a(this);
    }

    public void a() {
        for (int i10 = 0; i10 < this.f22806c.size(); i10++) {
            ((a.b) this.f22806c.get(i10)).a();
        }
    }

    public void b(List list, List list2) {
    }

    /* access modifiers changed from: package-private */
    public void c(a.b bVar) {
        this.f22806c.add(bVar);
    }

    public a d() {
        return this.f22809f;
    }

    public a f() {
        return this.f22810g;
    }

    public a i() {
        return this.f22808e;
    }

    /* access modifiers changed from: package-private */
    public t.a j() {
        return this.f22807d;
    }

    public boolean k() {
        return this.f22805b;
    }
}
