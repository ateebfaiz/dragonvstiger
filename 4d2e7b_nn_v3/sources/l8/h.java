package l8;

import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.annotation.z;
import com.fasterxml.jackson.databind.introspect.j0;
import java.io.Serializable;
import java.util.Map;

public class h implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    protected Map f12703a;

    /* renamed from: b  reason: collision with root package name */
    protected p.b f12704b;

    /* renamed from: c  reason: collision with root package name */
    protected z.a f12705c;

    /* renamed from: d  reason: collision with root package name */
    protected j0 f12706d;

    /* renamed from: e  reason: collision with root package name */
    protected Boolean f12707e;

    /* renamed from: f  reason: collision with root package name */
    protected Boolean f12708f;

    public h() {
        this((Map) null, p.b.c(), z.a.c(), j0.a.p(), (Boolean) null, (Boolean) null);
    }

    public i.d a(Class cls) {
        g gVar;
        i.d b10;
        Map map = this.f12703a;
        if (map == null || (gVar = (g) map.get(cls)) == null || (b10 = gVar.b()) == null) {
            Boolean bool = this.f12708f;
            if (bool == null) {
                return i.d.b();
            }
            return i.d.c(bool.booleanValue());
        } else if (!b10.k()) {
            return b10.q(this.f12708f);
        } else {
            return b10;
        }
    }

    public g b(Class cls) {
        Map map = this.f12703a;
        if (map == null) {
            return null;
        }
        return (g) map.get(cls);
    }

    public p.b c() {
        return this.f12704b;
    }

    public Boolean d() {
        return this.f12707e;
    }

    public z.a e() {
        return this.f12705c;
    }

    public j0 f() {
        return this.f12706d;
    }

    protected h(Map map, p.b bVar, z.a aVar, j0 j0Var, Boolean bool, Boolean bool2) {
        this.f12703a = map;
        this.f12704b = bVar;
        this.f12705c = aVar;
        this.f12706d = j0Var;
        this.f12707e = bool;
        this.f12708f = bool2;
    }
}
