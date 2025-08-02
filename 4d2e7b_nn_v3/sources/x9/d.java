package x9;

import ha.c;
import ha.e;
import ha.g;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import java.io.Serializable;
import java.net.URI;
import java.security.KeyStore;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import s9.a;

public abstract class d implements Serializable {
    private final Date C;
    private final List X;
    private final KeyStore Y;

    /* renamed from: a  reason: collision with root package name */
    private final g f13265a;

    /* renamed from: b  reason: collision with root package name */
    private final h f13266b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f13267c;

    /* renamed from: d  reason: collision with root package name */
    private final a f13268d;

    /* renamed from: e  reason: collision with root package name */
    private final String f13269e;

    /* renamed from: f  reason: collision with root package name */
    private final URI f13270f;

    /* renamed from: g  reason: collision with root package name */
    private final c f13271g;

    /* renamed from: h  reason: collision with root package name */
    private final c f13272h;

    /* renamed from: i  reason: collision with root package name */
    private final List f13273i;

    /* renamed from: j  reason: collision with root package name */
    private final Date f13274j;

    /* renamed from: w  reason: collision with root package name */
    private final Date f13275w;

    protected d(g gVar, h hVar, Set set, a aVar, String str, URI uri, c cVar, c cVar2, List list, Date date, Date date2, Date date3, KeyStore keyStore) {
        if (gVar != null) {
            this.f13265a = gVar;
            if (i.a(hVar, set)) {
                this.f13266b = hVar;
                this.f13267c = set;
                this.f13268d = aVar;
                this.f13269e = str;
                this.f13270f = uri;
                this.f13271g = cVar;
                this.f13272h = cVar2;
                if (list == null || !list.isEmpty()) {
                    this.f13273i = list;
                    try {
                        this.X = g.a(list);
                        this.f13274j = date;
                        this.f13275w = date2;
                        this.C = date3;
                        this.Y = keyStore;
                    } catch (ParseException e10) {
                        throw new IllegalArgumentException("Invalid X.509 certificate chain \"x5c\": " + e10.getMessage(), e10);
                    }
                } else {
                    throw new IllegalArgumentException("The X.509 certificate chain \"x5c\" must not be empty");
                }
            } else {
                throw new IllegalArgumentException("The key use \"use\" and key options \"key_ops\" parameters are not consistent, see RFC 7517, section 4.3");
            }
        } else {
            throw new IllegalArgumentException("The key type \"kty\" parameter must not be null");
        }
    }

    public static d c(Map map) {
        String g10 = e.g(map, "kty");
        if (g10 != null) {
            g b10 = g.b(g10);
            if (b10 == g.f13286c) {
                return b.k(map);
            }
            if (b10 == g.f13287d) {
                return l.f(map);
            }
            if (b10 == g.f13288e) {
                return k.e(map);
            }
            if (b10 == g.f13289f) {
                return j.e(map);
            }
            throw new ParseException("Unsupported key type \"kty\" parameter: " + b10, 0);
        }
        throw new ParseException("Missing key type \"kty\" parameter", 0);
    }

    public List a() {
        List list = this.X;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public abstract boolean b();

    public Map d() {
        Map k10 = e.k();
        k10.put("kty", this.f13265a.a());
        h hVar = this.f13266b;
        if (hVar != null) {
            k10.put("use", hVar.a());
        }
        if (this.f13267c != null) {
            List a10 = ha.d.a();
            for (f a11 : this.f13267c) {
                a10.add(a11.a());
            }
            k10.put("key_ops", a10);
        }
        a aVar = this.f13268d;
        if (aVar != null) {
            k10.put(JwsHeader.ALGORITHM, aVar.a());
        }
        String str = this.f13269e;
        if (str != null) {
            k10.put(JwsHeader.KEY_ID, str);
        }
        URI uri = this.f13270f;
        if (uri != null) {
            k10.put(JwsHeader.X509_URL, uri.toString());
        }
        c cVar = this.f13271g;
        if (cVar != null) {
            k10.put(JwsHeader.X509_CERT_SHA1_THUMBPRINT, cVar.toString());
        }
        c cVar2 = this.f13272h;
        if (cVar2 != null) {
            k10.put(JwsHeader.X509_CERT_SHA256_THUMBPRINT, cVar2.toString());
        }
        if (this.f13273i != null) {
            List a12 = ha.d.a();
            for (ha.a aVar2 : this.f13273i) {
                a12.add(aVar2.toString());
            }
            k10.put(JwsHeader.X509_CERT_CHAIN, a12);
        }
        Date date = this.f13274j;
        if (date != null) {
            k10.put(Claims.EXPIRATION, Long.valueOf(ja.a.b(date)));
        }
        Date date2 = this.f13275w;
        if (date2 != null) {
            k10.put(Claims.NOT_BEFORE, Long.valueOf(ja.a.b(date2)));
        }
        Date date3 = this.C;
        if (date3 != null) {
            k10.put(Claims.ISSUED_AT, Long.valueOf(ja.a.b(date3)));
        }
        return k10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!Objects.equals(this.f13265a, dVar.f13265a) || !Objects.equals(this.f13266b, dVar.f13266b) || !Objects.equals(this.f13267c, dVar.f13267c) || !Objects.equals(this.f13268d, dVar.f13268d) || !Objects.equals(this.f13269e, dVar.f13269e) || !Objects.equals(this.f13270f, dVar.f13270f) || !Objects.equals(this.f13271g, dVar.f13271g) || !Objects.equals(this.f13272h, dVar.f13272h) || !Objects.equals(this.f13273i, dVar.f13273i) || !Objects.equals(this.f13274j, dVar.f13274j) || !Objects.equals(this.f13275w, dVar.f13275w) || !Objects.equals(this.C, dVar.C) || !Objects.equals(this.Y, dVar.Y)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f13265a, this.f13266b, this.f13267c, this.f13268d, this.f13269e, this.f13270f, this.f13271g, this.f13272h, this.f13273i, this.f13274j, this.f13275w, this.C, this.Y});
    }

    public String toString() {
        return e.n(d());
    }
}
