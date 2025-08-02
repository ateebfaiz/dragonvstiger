package aa;

import ga.c;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import y9.r;
import y9.s;
import z9.e;

public final class d implements s, Cloneable {

    /* renamed from: g  reason: collision with root package name */
    public static final d f2281g = new d();

    /* renamed from: a  reason: collision with root package name */
    private double f2282a = -1.0d;

    /* renamed from: b  reason: collision with root package name */
    private int f2283b = 136;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2284c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2285d;

    /* renamed from: e  reason: collision with root package name */
    private List f2286e = Collections.emptyList();

    /* renamed from: f  reason: collision with root package name */
    private List f2287f = Collections.emptyList();

    class a extends r {

        /* renamed from: a  reason: collision with root package name */
        private r f2288a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f2289b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f2290c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ y9.d f2291d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ fa.a f2292e;

        a(boolean z10, boolean z11, y9.d dVar, fa.a aVar) {
            this.f2289b = z10;
            this.f2290c = z11;
            this.f2291d = dVar;
            this.f2292e = aVar;
        }

        private r e() {
            r rVar = this.f2288a;
            if (rVar != null) {
                return rVar;
            }
            r m10 = this.f2291d.m(d.this, this.f2292e);
            this.f2288a = m10;
            return m10;
        }

        public Object b(ga.a aVar) {
            if (!this.f2289b) {
                return e().b(aVar);
            }
            aVar.Y();
            return null;
        }

        public void d(c cVar, Object obj) {
            if (this.f2290c) {
                cVar.B();
            } else {
                e().d(cVar, obj);
            }
        }
    }

    private boolean d(Class cls) {
        if (this.f2282a != -1.0d && !l((z9.d) cls.getAnnotation(z9.d.class), (e) cls.getAnnotation(e.class))) {
            return true;
        }
        if (this.f2284c || !h(cls)) {
            return g(cls);
        }
        return true;
    }

    private boolean e(Class cls, boolean z10) {
        List list;
        if (z10) {
            list = this.f2286e;
        } else {
            list = this.f2287f;
        }
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        c.d.a(it.next());
        throw null;
    }

    private boolean g(Class cls) {
        if (Enum.class.isAssignableFrom(cls) || i(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) {
            return false;
        }
        return true;
    }

    private boolean h(Class cls) {
        if (!cls.isMemberClass() || i(cls)) {
            return false;
        }
        return true;
    }

    private boolean i(Class cls) {
        if ((cls.getModifiers() & 8) != 0) {
            return true;
        }
        return false;
    }

    private boolean j(z9.d dVar) {
        if (dVar == null) {
            return true;
        }
        if (this.f2282a >= dVar.value()) {
            return true;
        }
        return false;
    }

    private boolean k(e eVar) {
        if (eVar == null) {
            return true;
        }
        if (this.f2282a < eVar.value()) {
            return true;
        }
        return false;
    }

    private boolean l(z9.d dVar, e eVar) {
        if (!j(dVar) || !k(eVar)) {
            return false;
        }
        return true;
    }

    public r a(y9.d dVar, fa.a aVar) {
        boolean z10;
        boolean z11;
        Class d10 = aVar.d();
        boolean d11 = d(d10);
        if (d11 || e(d10, true)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (d11 || e(d10, false)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 || z11) {
            return new a(z11, z10, dVar, aVar);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean c(Class cls, boolean z10) {
        if (d(cls) || e(cls, z10)) {
            return true;
        }
        return false;
    }

    public boolean f(Field field, boolean z10) {
        List list;
        z9.a aVar;
        if ((this.f2283b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f2282a != -1.0d && !l((z9.d) field.getAnnotation(z9.d.class), (e) field.getAnnotation(e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f2285d && ((aVar = (z9.a) field.getAnnotation(z9.a.class)) == null || (!z10 ? !aVar.deserialize() : !aVar.serialize()))) {
            return true;
        }
        if ((!this.f2284c && h(field.getType())) || g(field.getType())) {
            return true;
        }
        if (z10) {
            list = this.f2286e;
        } else {
            list = this.f2287f;
        }
        if (list.isEmpty()) {
            return false;
        }
        new y9.a(field);
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        c.d.a(it.next());
        throw null;
    }
}
