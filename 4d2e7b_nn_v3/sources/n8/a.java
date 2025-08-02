package n8;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.h;
import com.fasterxml.jackson.databind.c;
import com.fasterxml.jackson.databind.introspect.s;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.l;

public class a extends l {

    /* renamed from: c  reason: collision with root package name */
    protected final j f12828c;

    /* renamed from: d  reason: collision with root package name */
    protected transient c f12829d;

    /* renamed from: e  reason: collision with root package name */
    protected transient s f12830e;

    protected a(h hVar, String str, j jVar) {
        super(hVar, str);
        this.f12828c = jVar;
        this.f12829d = null;
        this.f12830e = null;
    }

    public static a s(f fVar, String str, c cVar, s sVar) {
        return new a(fVar, str, cVar, sVar);
    }

    public static a t(f fVar, String str, j jVar) {
        return new a(fVar, str, jVar);
    }

    public static a u(h hVar, String str, j jVar) {
        return new a(hVar, str, jVar);
    }

    protected a(f fVar, String str, j jVar) {
        super(fVar, str);
        this.f12828c = jVar;
        this.f12829d = null;
        this.f12830e = null;
    }

    protected a(f fVar, String str, c cVar, s sVar) {
        super(fVar, str);
        j jVar;
        if (cVar == null) {
            jVar = null;
        } else {
            jVar = cVar.m();
        }
        this.f12828c = jVar;
        this.f12829d = cVar;
        this.f12830e = sVar;
    }
}
