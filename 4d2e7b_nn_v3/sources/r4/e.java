package r4;

import c3.a;
import java.util.List;
import y2.l;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final c f23681a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23682b;

    /* renamed from: c  reason: collision with root package name */
    private String f23683c;

    /* renamed from: d  reason: collision with root package name */
    private a f23684d;

    /* renamed from: e  reason: collision with root package name */
    private List f23685e;

    e(f fVar) {
        this.f23681a = (c) l.g(fVar.e());
        this.f23682b = fVar.d();
        this.f23684d = fVar.f();
        this.f23685e = fVar.c();
        fVar.b();
        this.f23683c = fVar.g();
    }

    public static e b(c cVar) {
        return new e(cVar);
    }

    public static f f(c cVar) {
        return new f(cVar);
    }

    public synchronized void a() {
        a.m(this.f23684d);
        this.f23684d = null;
        a.n(this.f23685e);
        this.f23685e = null;
    }

    public n5.a c() {
        return null;
    }

    public c d() {
        return this.f23681a;
    }

    public String e() {
        return this.f23683c;
    }

    private e(c cVar) {
        this.f23681a = (c) l.g(cVar);
        this.f23682b = 0;
    }
}
