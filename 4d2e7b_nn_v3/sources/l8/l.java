package l8;

import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.annotation.z;
import com.fasterxml.jackson.core.io.h;
import com.fasterxml.jackson.core.n;
import com.fasterxml.jackson.databind.c;
import com.fasterxml.jackson.databind.introspect.a;
import com.fasterxml.jackson.databind.introspect.a0;
import com.fasterxml.jackson.databind.introspect.b;
import com.fasterxml.jackson.databind.introspect.j0;
import com.fasterxml.jackson.databind.introspect.t;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.q;
import com.fasterxml.jackson.databind.type.o;
import com.fasterxml.jackson.databind.util.f;
import com.fasterxml.jackson.databind.x;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;
import q8.e;
import r8.g;

public abstract class l implements t.a, Serializable {

    /* renamed from: c  reason: collision with root package name */
    protected static final p.b f12723c = p.b.c();

    /* renamed from: d  reason: collision with root package name */
    protected static final i.d f12724d = i.d.b();

    /* renamed from: a  reason: collision with root package name */
    protected final long f12725a;

    /* renamed from: b  reason: collision with root package name */
    protected final a f12726b;

    protected l(a aVar, long j10) {
        this.f12726b = aVar;
        this.f12725a = j10;
    }

    public static int c(Class cls) {
        int i10 = 0;
        for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
            f fVar = (f) enumR;
            if (fVar.a()) {
                i10 |= fVar.b();
            }
        }
        return i10;
    }

    public final TimeZone A() {
        return this.f12726b.k();
    }

    public final o B() {
        return this.f12726b.l();
    }

    public c C(j jVar) {
        return j().a(this, jVar, this);
    }

    public c D(Class cls) {
        return C(e(cls));
    }

    public final boolean E() {
        return F(q.USE_ANNOTATIONS);
    }

    public final boolean F(q qVar) {
        return qVar.d(this.f12725a);
    }

    public final boolean G() {
        return F(q.SORT_PROPERTIES_ALPHABETICALLY);
    }

    public e H(b bVar, Class cls) {
        w();
        return (e) f.k(cls, b());
    }

    public q8.f I(b bVar, Class cls) {
        w();
        return (q8.f) f.k(cls, b());
    }

    public final boolean b() {
        return F(q.CAN_OVERRIDE_ACCESS_MODIFIERS);
    }

    public n d(String str) {
        return new h(str);
    }

    public final j e(Class cls) {
        return B().E(cls);
    }

    public final a.C0071a f() {
        return this.f12726b.a();
    }

    public com.fasterxml.jackson.databind.b h() {
        if (F(q.USE_ANNOTATIONS)) {
            return this.f12726b.b();
        }
        return a0.f5259a;
    }

    public com.fasterxml.jackson.core.a i() {
        return this.f12726b.c();
    }

    public t j() {
        return this.f12726b.d();
    }

    public abstract g k(Class cls);

    public final DateFormat l() {
        return this.f12726b.e();
    }

    public abstract p.b m(Class cls, Class cls2);

    public p.b n(Class cls, Class cls2, p.b bVar) {
        return p.b.k(bVar, k(cls).d(), k(cls2).e());
    }

    public abstract Boolean o();

    public abstract i.d p(Class cls);

    public abstract p.b q(Class cls);

    public p.b s(Class cls, p.b bVar) {
        p.b d10 = k(cls).d();
        if (d10 != null) {
            return d10;
        }
        return bVar;
    }

    public abstract z.a t();

    public final q8.f u(j jVar) {
        return this.f12726b.m();
    }

    public abstract j0 v(Class cls, com.fasterxml.jackson.databind.introspect.c cVar);

    public final k w() {
        this.f12726b.f();
        return null;
    }

    public final Locale x() {
        return this.f12726b.h();
    }

    public q8.c y() {
        q8.c i10 = this.f12726b.i();
        if (i10 != g.f12949a || !F(q.BLOCK_UNSAFE_POLYMORPHIC_BASE_TYPES)) {
            return i10;
        }
        return new q8.a();
    }

    public final x z() {
        this.f12726b.j();
        return null;
    }

    protected l(l lVar, long j10) {
        this.f12726b = lVar.f12726b;
        this.f12725a = j10;
    }
}
