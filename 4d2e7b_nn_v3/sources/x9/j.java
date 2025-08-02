package x9;

import com.alibaba.pdns.model.DomainUhfReportModel;
import ha.c;
import ha.e;
import java.net.URI;
import java.security.KeyStore;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import s9.a;

public class j extends d {
    public static final Set R0 = Collections.unmodifiableSet(new HashSet(Arrays.asList(new a[]{a.f13255i, a.f13256j, a.f13257w, a.C})));
    private final c N0;
    private final byte[] O0;
    private final c P0;
    private final byte[] Q0;
    private final a Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(a aVar, c cVar, h hVar, Set set, a aVar2, String str, URI uri, c cVar2, c cVar3, List list, Date date, Date date2, Date date3, KeyStore keyStore) {
        super(g.f13289f, hVar, set, aVar2, str, uri, cVar2, cVar3, list, date, date2, date3, keyStore);
        a aVar3 = aVar;
        c cVar4 = cVar;
        if (aVar3 == null) {
            throw new IllegalArgumentException("The curve must not be null");
        } else if (R0.contains(aVar3)) {
            this.Z = aVar3;
            c cVar5 = cVar;
            if (cVar5 != null) {
                this.N0 = cVar5;
                this.O0 = cVar.a();
                this.P0 = null;
                this.Q0 = null;
                return;
            }
            throw new IllegalArgumentException("The 'x' parameter must not be null");
        } else {
            throw new IllegalArgumentException("Unknown / unsupported curve: " + aVar3);
        }
    }

    public static j e(Map map) {
        Map map2 = map;
        g gVar = g.f13289f;
        if (gVar.equals(e.f(map))) {
            try {
                a b10 = a.b(e.g(map2, "crv"));
                c a10 = e.a(map2, "x");
                c a11 = e.a(map2, DomainUhfReportModel.ENCRYPTDATA);
                if (a11 != null) {
                    return new j(b10, a10, a11, e.g(map), e.e(map), e.a(map), e.d(map), e.l(map), e.k(map), e.j(map), e.i(map), e.b(map), e.h(map), e.c(map), (KeyStore) null);
                }
                try {
                    return new j(b10, a10, e.g(map), e.e(map), e.a(map), e.d(map), e.l(map), e.k(map), e.j(map), e.i(map), e.b(map), e.h(map), e.c(map), (KeyStore) null);
                } catch (IllegalArgumentException e10) {
                    throw new ParseException(e10.getMessage(), 0);
                }
            } catch (IllegalArgumentException e11) {
                throw new ParseException(e11.getMessage(), 0);
            }
        } else {
            throw new ParseException("The key type kty must be " + gVar.a(), 0);
        }
    }

    public boolean b() {
        if (this.P0 != null) {
            return true;
        }
        return false;
    }

    public Map d() {
        Map d10 = super.d();
        d10.put("crv", this.Z.toString());
        d10.put("x", this.N0.toString());
        c cVar = this.P0;
        if (cVar != null) {
            d10.put(DomainUhfReportModel.ENCRYPTDATA, cVar.toString());
        }
        return d10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j) || !super.equals(obj)) {
            return false;
        }
        j jVar = (j) obj;
        if (!Objects.equals(this.Z, jVar.Z) || !Objects.equals(this.N0, jVar.N0) || !Arrays.equals(this.O0, jVar.O0) || !Objects.equals(this.P0, jVar.P0) || !Arrays.equals(this.Q0, jVar.Q0)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.Z, this.N0, this.P0}) * 31) + Arrays.hashCode(this.O0)) * 31) + Arrays.hashCode(this.Q0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(a aVar, c cVar, c cVar2, h hVar, Set set, a aVar2, String str, URI uri, c cVar3, c cVar4, List list, Date date, Date date2, Date date3, KeyStore keyStore) {
        super(g.f13289f, hVar, set, aVar2, str, uri, cVar3, cVar4, list, date, date2, date3, keyStore);
        a aVar3 = aVar;
        c cVar5 = cVar;
        c cVar6 = cVar2;
        if (aVar3 == null) {
            throw new IllegalArgumentException("The curve must not be null");
        } else if (R0.contains(aVar3)) {
            this.Z = aVar3;
            c cVar7 = cVar;
            if (cVar7 != null) {
                this.N0 = cVar7;
                this.O0 = cVar.a();
                c cVar8 = cVar2;
                if (cVar8 != null) {
                    this.P0 = cVar8;
                    this.Q0 = cVar2.a();
                    return;
                }
                throw new IllegalArgumentException("The 'd' parameter must not be null");
            }
            throw new IllegalArgumentException("The 'x' parameter must not be null");
        } else {
            throw new IllegalArgumentException("Unknown / unsupported curve: " + aVar3);
        }
    }
}
