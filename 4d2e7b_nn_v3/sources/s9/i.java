package s9;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import ha.c;
import ha.e;
import ha.g;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.JwsHeader;
import java.net.URI;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import x9.d;

public final class i extends b {
    private static final Set N0;
    private final boolean Z;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final h f13021a;

        /* renamed from: b  reason: collision with root package name */
        private f f13022b;

        /* renamed from: c  reason: collision with root package name */
        private String f13023c;

        /* renamed from: d  reason: collision with root package name */
        private Set f13024d;

        /* renamed from: e  reason: collision with root package name */
        private URI f13025e;

        /* renamed from: f  reason: collision with root package name */
        private d f13026f;

        /* renamed from: g  reason: collision with root package name */
        private URI f13027g;

        /* renamed from: h  reason: collision with root package name */
        private c f13028h;

        /* renamed from: i  reason: collision with root package name */
        private c f13029i;

        /* renamed from: j  reason: collision with root package name */
        private List f13030j;

        /* renamed from: k  reason: collision with root package name */
        private String f13031k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f13032l = true;

        /* renamed from: m  reason: collision with root package name */
        private Map f13033m;

        /* renamed from: n  reason: collision with root package name */
        private c f13034n;

        public a(h hVar) {
            if (!hVar.a().equals(a.f12985c.a())) {
                this.f13021a = hVar;
                return;
            }
            throw new IllegalArgumentException("The JWS algorithm \"alg\" cannot be \"none\"");
        }

        public a a(boolean z10) {
            this.f13032l = z10;
            return this;
        }

        public i b() {
            return new i(this.f13021a, this.f13022b, this.f13023c, this.f13024d, this.f13025e, this.f13026f, this.f13027g, this.f13028h, this.f13029i, this.f13030j, this.f13031k, this.f13032l, this.f13033m, this.f13034n);
        }

        public a c(String str) {
            this.f13023c = str;
            return this;
        }

        public a d(Set set) {
            this.f13024d = set;
            return this;
        }

        public a e(String str, Object obj) {
            if (!i.i().contains(str)) {
                if (this.f13033m == null) {
                    this.f13033m = new HashMap();
                }
                this.f13033m.put(str, obj);
                return this;
            }
            throw new IllegalArgumentException("The parameter name \"" + str + "\" matches a registered name");
        }

        public a f(d dVar) {
            if (dVar == null || !dVar.b()) {
                this.f13026f = dVar;
                return this;
            }
            throw new IllegalArgumentException("The JWK must be public");
        }

        public a g(URI uri) {
            this.f13025e = uri;
            return this;
        }

        public a h(String str) {
            this.f13031k = str;
            return this;
        }

        public a i(c cVar) {
            this.f13034n = cVar;
            return this;
        }

        public a j(f fVar) {
            this.f13022b = fVar;
            return this;
        }

        public a k(List list) {
            this.f13030j = list;
            return this;
        }

        public a l(c cVar) {
            this.f13029i = cVar;
            return this;
        }

        public a m(c cVar) {
            this.f13028h = cVar;
            return this;
        }

        public a n(URI uri) {
            this.f13027g = uri;
            return this;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(JwsHeader.ALGORITHM);
        hashSet.add(JwsHeader.JWK_SET_URL);
        hashSet.add(JwsHeader.JSON_WEB_KEY);
        hashSet.add(JwsHeader.X509_URL);
        hashSet.add(JwsHeader.X509_CERT_SHA1_THUMBPRINT);
        hashSet.add(JwsHeader.X509_CERT_SHA256_THUMBPRINT);
        hashSet.add(JwsHeader.X509_CERT_CHAIN);
        hashSet.add(JwsHeader.KEY_ID);
        hashSet.add("typ");
        hashSet.add(Header.CONTENT_TYPE);
        hashSet.add(JwsHeader.CRITICAL);
        hashSet.add("b64");
        N0 = Collections.unmodifiableSet(hashSet);
    }

    public i(h hVar, f fVar, String str, Set set, URI uri, d dVar, URI uri2, c cVar, c cVar2, List list, String str2, boolean z10, Map map, c cVar3) {
        super(hVar, fVar, str, set, uri, dVar, uri2, cVar, cVar2, list, str2, map, cVar3);
        if (hVar == null) {
            throw new IllegalArgumentException("The algorithm \"alg\" header parameter must not be null");
        } else if (!hVar.a().equals(a.f12985c.a())) {
            this.Z = z10;
        } else {
            throw new IllegalArgumentException("The JWS algorithm \"alg\" cannot be \"none\"");
        }
    }

    public static Set i() {
        return N0;
    }

    public static i k(c cVar) {
        return l(cVar.c(), cVar);
    }

    public static i l(String str, c cVar) {
        return m(e.m(str, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH), cVar);
    }

    public static i m(Map map, c cVar) {
        a c10 = c.c(map);
        if (c10 instanceof h) {
            a i10 = new a((h) c10).i(cVar);
            for (String str : map.keySet()) {
                if (!JwsHeader.ALGORITHM.equals(str)) {
                    if ("typ".equals(str)) {
                        String g10 = e.g(map, str);
                        if (g10 != null) {
                            i10 = i10.j(new f(g10));
                        }
                    } else if (Header.CONTENT_TYPE.equals(str)) {
                        i10 = i10.c(e.g(map, str));
                    } else if (JwsHeader.CRITICAL.equals(str)) {
                        List i11 = e.i(map, str);
                        if (i11 != null) {
                            i10 = i10.d(new HashSet(i11));
                        }
                    } else if (JwsHeader.JWK_SET_URL.equals(str)) {
                        i10 = i10.g(e.j(map, str));
                    } else if (JwsHeader.JSON_WEB_KEY.equals(str)) {
                        i10 = i10.f(b.f(e.e(map, str)));
                    } else if (JwsHeader.X509_URL.equals(str)) {
                        i10 = i10.n(e.j(map, str));
                    } else if (JwsHeader.X509_CERT_SHA1_THUMBPRINT.equals(str)) {
                        i10 = i10.m(c.f(e.g(map, str)));
                    } else if (JwsHeader.X509_CERT_SHA256_THUMBPRINT.equals(str)) {
                        i10 = i10.l(c.f(e.g(map, str)));
                    } else if (JwsHeader.X509_CERT_CHAIN.equals(str)) {
                        i10 = i10.k(g.b(e.d(map, str)));
                    } else if (JwsHeader.KEY_ID.equals(str)) {
                        i10 = i10.h(e.g(map, str));
                    } else if ("b64".equals(str)) {
                        i10 = i10.a(e.b(map, str));
                    } else {
                        i10 = i10.e(str, map.get(str));
                    }
                }
            }
            return i10.b();
        }
        throw new ParseException("Not a JWS header", 0);
    }

    public Map e() {
        Map e10 = super.e();
        if (!j()) {
            e10.put("b64", Boolean.FALSE);
        }
        return e10;
    }

    public h h() {
        return (h) super.a();
    }

    public boolean j() {
        return this.Z;
    }
}
