package x9;

import com.alibaba.pdns.model.DomainUhfReportModel;
import ha.c;
import ha.e;
import java.net.URI;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
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

public final class b extends d {
    public static final Set R0 = Collections.unmodifiableSet(new HashSet(Arrays.asList(new a[]{a.f13250d, a.f13251e, a.f13253g, a.f13254h})));
    private final c N0;
    private final c O0;
    private final c P0;
    private final PrivateKey Q0;
    private final a Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(a aVar, c cVar, c cVar2, h hVar, Set set, a aVar2, String str, URI uri, c cVar3, c cVar4, List list, Date date, Date date2, Date date3, KeyStore keyStore) {
        super(g.f13286c, hVar, set, aVar2, str, uri, cVar3, cVar4, list, date, date2, date3, keyStore);
        a aVar3 = aVar;
        c cVar5 = cVar;
        c cVar6 = cVar2;
        if (aVar3 != null) {
            this.Z = aVar3;
            c cVar7 = cVar;
            if (cVar7 != null) {
                this.N0 = cVar7;
                c cVar8 = cVar2;
                if (cVar8 != null) {
                    this.O0 = cVar8;
                    f(aVar, cVar, cVar2);
                    e(a());
                    this.P0 = null;
                    this.Q0 = null;
                    return;
                }
                throw new IllegalArgumentException("The 'y' coordinate must not be null");
            }
            throw new IllegalArgumentException("The 'x' coordinate must not be null");
        }
        throw new IllegalArgumentException("The curve must not be null");
    }

    private void e(List list) {
        if (list != null && !j((X509Certificate) list.get(0))) {
            throw new IllegalArgumentException("The public subject key info of the first X.509 certificate in the chain must match the JWK type and public parameters");
        }
    }

    private static void f(a aVar, c cVar, c cVar2) {
        if (!R0.contains(aVar)) {
            throw new IllegalArgumentException("Unknown / unsupported curve: " + aVar);
        } else if (!v9.a.a(cVar.b(), cVar2.b(), aVar.c())) {
            throw new IllegalArgumentException("Invalid EC JWK: The 'x' and 'y' public coordinates are not on the " + aVar + " curve");
        }
    }

    public static b k(Map map) {
        Map map2 = map;
        if (g.f13286c.equals(e.f(map))) {
            try {
                a b10 = a.b(e.g(map2, "crv"));
                c a10 = e.a(map2, "x");
                c a11 = e.a(map2, "y");
                c a12 = e.a(map2, DomainUhfReportModel.ENCRYPTDATA);
                if (a12 != null) {
                    return new b(b10, a10, a11, a12, e.g(map), e.e(map), e.a(map), e.d(map), e.l(map), e.k(map), e.j(map), e.i(map), e.b(map), e.h(map), e.c(map), (KeyStore) null);
                }
                try {
                    return new b(b10, a10, a11, e.g(map), e.e(map), e.a(map), e.d(map), e.l(map), e.k(map), e.j(map), e.i(map), e.b(map), e.h(map), e.c(map), (KeyStore) null);
                } catch (IllegalArgumentException e10) {
                    throw new ParseException(e10.getMessage(), 0);
                }
            } catch (IllegalArgumentException e11) {
                throw new ParseException(e11.getMessage(), 0);
            }
        } else {
            throw new ParseException("The key type \"kty\" must be EC", 0);
        }
    }

    public boolean b() {
        if (this.P0 == null && this.Q0 == null) {
            return false;
        }
        return true;
    }

    public Map d() {
        Map d10 = super.d();
        d10.put("crv", this.Z.toString());
        d10.put("x", this.N0.toString());
        d10.put("y", this.O0.toString());
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
        if (!(obj instanceof b) || !super.equals(obj)) {
            return false;
        }
        b bVar = (b) obj;
        if (!Objects.equals(this.Z, bVar.Z) || !Objects.equals(this.N0, bVar.N0) || !Objects.equals(this.O0, bVar.O0) || !Objects.equals(this.P0, bVar.P0) || !Objects.equals(this.Q0, bVar.Q0)) {
            return false;
        }
        return true;
    }

    public c h() {
        return this.N0;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.Z, this.N0, this.O0, this.P0, this.Q0});
    }

    public c i() {
        return this.O0;
    }

    public boolean j(X509Certificate x509Certificate) {
        try {
            ECPublicKey eCPublicKey = (ECPublicKey) ((X509Certificate) a().get(0)).getPublicKey();
            if (!h().b().equals(eCPublicKey.getW().getAffineX())) {
                return false;
            }
            return i().b().equals(eCPublicKey.getW().getAffineY());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(a aVar, c cVar, c cVar2, c cVar3, h hVar, Set set, a aVar2, String str, URI uri, c cVar4, c cVar5, List list, Date date, Date date2, Date date3, KeyStore keyStore) {
        super(g.f13286c, hVar, set, aVar2, str, uri, cVar4, cVar5, list, date, date2, date3, keyStore);
        a aVar3 = aVar;
        c cVar6 = cVar;
        c cVar7 = cVar2;
        c cVar8 = cVar3;
        if (aVar3 != null) {
            this.Z = aVar3;
            c cVar9 = cVar;
            if (cVar9 != null) {
                this.N0 = cVar9;
                c cVar10 = cVar2;
                if (cVar10 != null) {
                    this.O0 = cVar10;
                    f(aVar, cVar, cVar2);
                    e(a());
                    c cVar11 = cVar3;
                    if (cVar11 != null) {
                        this.P0 = cVar11;
                        this.Q0 = null;
                        return;
                    }
                    throw new IllegalArgumentException("The 'd' coordinate must not be null");
                }
                throw new IllegalArgumentException("The 'y' coordinate must not be null");
            }
            throw new IllegalArgumentException("The 'x' coordinate must not be null");
        }
        throw new IllegalArgumentException("The curve must not be null");
    }
}
