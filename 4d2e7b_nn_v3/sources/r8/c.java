package r8;

import com.fasterxml.jackson.annotation.c0;
import com.fasterxml.jackson.databind.d;
import q8.e;

public class c extends m {

    /* renamed from: c  reason: collision with root package name */
    protected final String f12946c;

    public c(e eVar, d dVar, String str) {
        super(eVar, dVar);
        this.f12946c = str;
    }

    public String b() {
        return this.f12946c;
    }

    public c0.a c() {
        return c0.a.EXTERNAL_PROPERTY;
    }

    /* renamed from: m */
    public c a(d dVar) {
        if (this.f12968b == dVar) {
            return this;
        }
        return new c(this.f12967a, dVar, this.f12946c);
    }
}
