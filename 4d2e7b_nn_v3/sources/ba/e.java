package ba;

import aa.c;
import fa.a;
import y9.d;
import y9.r;
import y9.s;
import z9.b;

public final class e implements s {

    /* renamed from: a  reason: collision with root package name */
    private final c f2523a;

    public e(c cVar) {
        this.f2523a = cVar;
    }

    public r a(d dVar, a aVar) {
        b bVar = (b) aVar.d().getAnnotation(b.class);
        if (bVar == null) {
            return null;
        }
        return b(this.f2523a, dVar, aVar, bVar);
    }

    /* access modifiers changed from: package-private */
    public r b(c cVar, d dVar, a aVar, b bVar) {
        r rVar;
        Object construct = cVar.b(a.a(bVar.value())).construct();
        boolean nullSafe = bVar.nullSafe();
        if (construct instanceof r) {
            rVar = (r) construct;
        } else if (construct instanceof s) {
            rVar = ((s) construct).a(dVar, aVar);
        } else {
            throw new IllegalArgumentException("Invalid attempt to bind an instance of " + construct.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        }
        if (rVar == null || !nullSafe) {
            return rVar;
        }
        return rVar.a();
    }
}
