package t8;

import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.introspect.c;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.s;
import l8.l;
import q8.g;

public class a extends s {
    protected final String R0;

    protected a(String str, com.fasterxml.jackson.databind.introspect.s sVar, com.fasterxml.jackson.databind.util.a aVar, j jVar) {
        this(str, sVar, aVar, jVar, sVar.b());
    }

    public static a G(String str, com.fasterxml.jackson.databind.introspect.s sVar, com.fasterxml.jackson.databind.util.a aVar, j jVar) {
        return new a(str, sVar, aVar, jVar);
    }

    /* access modifiers changed from: protected */
    public Object E(Object obj, f fVar, b0 b0Var) {
        return b0Var.M(this.R0);
    }

    public s F(l lVar, c cVar, com.fasterxml.jackson.databind.introspect.s sVar, j jVar) {
        throw new IllegalStateException("Should not be called on this type");
    }

    protected a(String str, com.fasterxml.jackson.databind.introspect.s sVar, com.fasterxml.jackson.databind.util.a aVar, j jVar, p.b bVar) {
        super(sVar, aVar, jVar, (o) null, (g) null, (j) null, bVar, (Class[]) null);
        this.R0 = str;
    }
}
