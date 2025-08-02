package x9;

import ha.c;
import ha.e;
import java.net.URI;
import java.security.KeyStore;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import s9.a;

public final class k extends d {
    private final c Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(c cVar, h hVar, Set set, a aVar, String str, URI uri, c cVar2, c cVar3, List list, Date date, Date date2, Date date3, KeyStore keyStore) {
        super(g.f13288e, hVar, set, aVar, str, uri, cVar2, cVar3, list, date, date2, date3, keyStore);
        c cVar4 = cVar;
        if (cVar4 != null) {
            this.Z = cVar4;
        } else {
            throw new IllegalArgumentException("The key value must not be null");
        }
    }

    public static k e(Map map) {
        g gVar = g.f13288e;
        if (gVar.equals(e.f(map))) {
            try {
                return new k(e.a(map, "k"), e.g(map), e.e(map), e.a(map), e.d(map), e.l(map), e.k(map), e.j(map), e.i(map), e.b(map), e.h(map), e.c(map), (KeyStore) null);
            } catch (IllegalArgumentException e10) {
                throw new ParseException(e10.getMessage(), 0);
            }
        } else {
            throw new ParseException("The key type kty must be " + gVar.a(), 0);
        }
    }

    public boolean b() {
        return true;
    }

    public Map d() {
        Map d10 = super.d();
        d10.put("k", this.Z.toString());
        return d10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof k) && super.equals(obj)) {
            return Objects.equals(this.Z, ((k) obj).Z);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.Z});
    }
}
