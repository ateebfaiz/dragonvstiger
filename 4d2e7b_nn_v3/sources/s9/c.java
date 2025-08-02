package s9;

import ha.e;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.JwsHeader;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class c implements Serializable {

    /* renamed from: g  reason: collision with root package name */
    private static final Map f12992g = Collections.unmodifiableMap(new HashMap());

    /* renamed from: a  reason: collision with root package name */
    private final a f12993a;

    /* renamed from: b  reason: collision with root package name */
    private final f f12994b;

    /* renamed from: c  reason: collision with root package name */
    private final String f12995c;

    /* renamed from: d  reason: collision with root package name */
    private final Set f12996d;

    /* renamed from: e  reason: collision with root package name */
    private final Map f12997e;

    /* renamed from: f  reason: collision with root package name */
    private final ha.c f12998f;

    protected c(a aVar, f fVar, String str, Set set, Map map, ha.c cVar) {
        this.f12993a = aVar;
        this.f12994b = fVar;
        this.f12995c = str;
        if (set != null) {
            this.f12996d = Collections.unmodifiableSet(new HashSet(set));
        } else {
            this.f12996d = null;
        }
        if (map != null) {
            this.f12997e = Collections.unmodifiableMap(new HashMap(map));
        } else {
            this.f12997e = f12992g;
        }
        this.f12998f = cVar;
    }

    public static a c(Map map) {
        String g10 = e.g(map, JwsHeader.ALGORITHM);
        if (g10 != null) {
            a aVar = a.f12985c;
            if (g10.equals(aVar.a())) {
                return aVar;
            }
            if (map.containsKey("enc")) {
                return g.c(g10);
            }
            return h.c(g10);
        }
        throw new ParseException("Missing \"alg\" in header JSON object", 0);
    }

    public a a() {
        return this.f12993a;
    }

    public Set b() {
        return this.f12996d;
    }

    public ha.c d() {
        ha.c cVar = this.f12998f;
        if (cVar == null) {
            return ha.c.d(toString());
        }
        return cVar;
    }

    public Map e() {
        Map k10 = e.k();
        k10.putAll(this.f12997e);
        a aVar = this.f12993a;
        if (aVar != null) {
            k10.put(JwsHeader.ALGORITHM, aVar.toString());
        }
        f fVar = this.f12994b;
        if (fVar != null) {
            k10.put("typ", fVar.toString());
        }
        String str = this.f12995c;
        if (str != null) {
            k10.put(Header.CONTENT_TYPE, str);
        }
        Set set = this.f12996d;
        if (set != null && !set.isEmpty()) {
            k10.put(JwsHeader.CRITICAL, new ArrayList(this.f12996d));
        }
        return k10;
    }

    public String toString() {
        return e.n(e());
    }
}
