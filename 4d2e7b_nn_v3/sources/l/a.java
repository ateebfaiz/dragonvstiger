package l;

import w.d;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final String f22339c = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final d f22340a = new d();

    /* renamed from: b  reason: collision with root package name */
    public f f22341b;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f22342a = new a((C0300a) null);
    }

    public a(C0300a aVar) {
    }

    public static a a() {
        return b.f22342a;
    }

    public void b(String str) {
        if (this.f22341b == null) {
            this.f22341b = new f(str, this.f22340a);
        }
    }

    public void c(b bVar) {
        if (bVar != null) {
            this.f22340a.c(bVar);
        }
    }

    public void d() {
        f fVar = this.f22341b;
        if (fVar != null) {
            fVar.g();
        }
    }

    public void e(b bVar) {
        this.f22340a.d(bVar);
    }

    public boolean f(String str) {
        f fVar = this.f22341b;
        if (fVar == null || !fVar.f().equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    public void g() {
        f fVar = this.f22341b;
        if (fVar != null) {
            fVar.h();
            this.f22341b = null;
        }
    }
}
