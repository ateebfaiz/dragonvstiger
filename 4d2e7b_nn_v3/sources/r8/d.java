package r8;

import com.fasterxml.jackson.annotation.c0;
import q8.e;

public class d extends a {

    /* renamed from: c  reason: collision with root package name */
    protected final String f12947c;

    public d(e eVar, com.fasterxml.jackson.databind.d dVar, String str) {
        super(eVar, dVar);
        this.f12947c = str;
    }

    public String b() {
        return this.f12947c;
    }

    public c0.a c() {
        return c0.a.PROPERTY;
    }

    /* renamed from: n */
    public d m(com.fasterxml.jackson.databind.d dVar) {
        if (this.f12968b == dVar) {
            return this;
        }
        return new d(this.f12967a, dVar, this.f12947c);
    }
}
