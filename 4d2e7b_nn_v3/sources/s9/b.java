package s9;

import ha.a;
import ha.c;
import io.jsonwebtoken.JwsHeader;
import java.net.URI;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import x9.d;

abstract class b extends c {
    private final c C;
    private final List X;
    private final String Y;

    /* renamed from: h  reason: collision with root package name */
    private final URI f12988h;

    /* renamed from: i  reason: collision with root package name */
    private final d f12989i;

    /* renamed from: j  reason: collision with root package name */
    private final URI f12990j;

    /* renamed from: w  reason: collision with root package name */
    private final c f12991w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected b(a aVar, f fVar, String str, Set set, URI uri, d dVar, URI uri2, c cVar, c cVar2, List list, String str2, Map map, c cVar3) {
        super(aVar, fVar, str, set, map, cVar3);
        List list2 = list;
        this.f12988h = uri;
        this.f12989i = dVar;
        this.f12990j = uri2;
        this.f12991w = cVar;
        this.C = cVar2;
        if (list2 != null) {
            this.X = Collections.unmodifiableList(new ArrayList(list2));
        } else {
            this.X = null;
        }
        this.Y = str2;
    }

    static d f(Map map) {
        if (map == null) {
            return null;
        }
        d c10 = d.c(map);
        if (!c10.b()) {
            return c10;
        }
        throw new ParseException("Non-public key in jwk header parameter", 0);
    }

    public Map e() {
        Map e10 = super.e();
        URI uri = this.f12988h;
        if (uri != null) {
            e10.put(JwsHeader.JWK_SET_URL, uri.toString());
        }
        d dVar = this.f12989i;
        if (dVar != null) {
            e10.put(JwsHeader.JSON_WEB_KEY, dVar.d());
        }
        URI uri2 = this.f12990j;
        if (uri2 != null) {
            e10.put(JwsHeader.X509_URL, uri2.toString());
        }
        c cVar = this.f12991w;
        if (cVar != null) {
            e10.put(JwsHeader.X509_CERT_SHA1_THUMBPRINT, cVar.toString());
        }
        c cVar2 = this.C;
        if (cVar2 != null) {
            e10.put(JwsHeader.X509_CERT_SHA256_THUMBPRINT, cVar2.toString());
        }
        List list = this.X;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.X.size());
            for (a aVar : this.X) {
                arrayList.add(aVar.toString());
            }
            e10.put(JwsHeader.X509_CERT_CHAIN, arrayList);
        }
        String str = this.Y;
        if (str != null) {
            e10.put(JwsHeader.KEY_ID, str);
        }
        return e10;
    }
}
