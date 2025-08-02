package ba;

import aa.b;
import ga.c;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import y9.d;
import y9.r;
import y9.s;

public final class a extends r {

    /* renamed from: c  reason: collision with root package name */
    public static final s f2511c = new C0042a();

    /* renamed from: a  reason: collision with root package name */
    private final Class f2512a;

    /* renamed from: b  reason: collision with root package name */
    private final r f2513b;

    /* renamed from: ba.a$a  reason: collision with other inner class name */
    class C0042a implements s {
        C0042a() {
        }

        public r a(d dVar, fa.a aVar) {
            Type e10 = aVar.e();
            if (!(e10 instanceof GenericArrayType) && (!(e10 instanceof Class) || !((Class) e10).isArray())) {
                return null;
            }
            Type g10 = b.g(e10);
            return new a(dVar, dVar.k(fa.a.b(g10)), b.k(g10));
        }
    }

    public a(d dVar, r rVar, Class cls) {
        this.f2513b = new l(dVar, rVar, cls);
        this.f2512a = cls;
    }

    public Object b(ga.a aVar) {
        if (aVar.O() == ga.b.NULL) {
            aVar.K();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.y()) {
            arrayList.add(this.f2513b.b(aVar));
        }
        aVar.m();
        int size = arrayList.size();
        if (!this.f2512a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance(this.f2512a, size));
        }
        Object newInstance = Array.newInstance(this.f2512a, size);
        for (int i10 = 0; i10 < size; i10++) {
            Array.set(newInstance, i10, arrayList.get(i10));
        }
        return newInstance;
    }

    public void d(c cVar, Object obj) {
        if (obj == null) {
            cVar.B();
            return;
        }
        cVar.h();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f2513b.d(cVar, Array.get(obj, i10));
        }
        cVar.m();
    }
}
