package r3;

import f3.c;
import g5.a;
import m4.i;

public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private final c f23665a;

    /* renamed from: b  reason: collision with root package name */
    private final i f23666b;

    public b(c cVar, i iVar) {
        this.f23665a = cVar;
        this.f23666b = iVar;
    }

    public void a(k5.b bVar, Object obj, String str, boolean z10) {
        this.f23666b.q(this.f23665a.now());
        this.f23666b.o(bVar);
        this.f23666b.d(obj);
        this.f23666b.v(str);
        this.f23666b.u(z10);
    }

    public void i(k5.b bVar, String str, boolean z10) {
        this.f23666b.p(this.f23665a.now());
        this.f23666b.o(bVar);
        this.f23666b.v(str);
        this.f23666b.u(z10);
    }

    public void j(k5.b bVar, String str, Throwable th, boolean z10) {
        this.f23666b.p(this.f23665a.now());
        this.f23666b.o(bVar);
        this.f23666b.v(str);
        this.f23666b.u(z10);
    }

    public void k(String str) {
        this.f23666b.p(this.f23665a.now());
        this.f23666b.v(str);
    }
}
