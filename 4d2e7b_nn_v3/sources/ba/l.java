package ba;

import ba.j;
import ga.a;
import ga.c;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import y9.d;
import y9.r;

final class l extends r {

    /* renamed from: a  reason: collision with root package name */
    private final d f2564a;

    /* renamed from: b  reason: collision with root package name */
    private final r f2565b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f2566c;

    l(d dVar, r rVar, Type type) {
        this.f2564a = dVar;
        this.f2565b = rVar;
        this.f2566c = type;
    }

    private static Type e(Type type, Object obj) {
        if (obj == null) {
            return type;
        }
        if ((type instanceof Class) || (type instanceof TypeVariable)) {
            return obj.getClass();
        }
        return type;
    }

    private static boolean f(r rVar) {
        r e10;
        while ((rVar instanceof k) && (e10 = ((k) rVar).e()) != rVar) {
            rVar = e10;
        }
        return rVar instanceof j.b;
    }

    public Object b(a aVar) {
        return this.f2565b.b(aVar);
    }

    public void d(c cVar, Object obj) {
        r rVar = this.f2565b;
        Type e10 = e(this.f2566c, obj);
        if (e10 != this.f2566c) {
            rVar = this.f2564a.k(fa.a.b(e10));
            if ((rVar instanceof j.b) && !f(this.f2565b)) {
                rVar = this.f2565b;
            }
        }
        rVar.d(cVar, obj);
    }
}
