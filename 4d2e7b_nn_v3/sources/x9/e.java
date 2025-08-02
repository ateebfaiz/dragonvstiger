package x9;

import ha.c;
import ha.g;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import java.net.URI;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import s9.a;

abstract class e {
    static a a(Map map) {
        return a.b(ha.e.g(map, JwsHeader.ALGORITHM));
    }

    static Date b(Map map) {
        if (map.get(Claims.EXPIRATION) == null) {
            return null;
        }
        return ja.a.a(ha.e.f(map, Claims.EXPIRATION));
    }

    static Date c(Map map) {
        if (map.get(Claims.ISSUED_AT) == null) {
            return null;
        }
        return ja.a.a(ha.e.f(map, Claims.ISSUED_AT));
    }

    static String d(Map map) {
        return ha.e.g(map, JwsHeader.KEY_ID);
    }

    static Set e(Map map) {
        return f.b(ha.e.i(map, "key_ops"));
    }

    static g f(Map map) {
        try {
            return g.b(ha.e.g(map, "kty"));
        } catch (IllegalArgumentException e10) {
            throw new ParseException(e10.getMessage(), 0);
        }
    }

    static h g(Map map) {
        return h.b(ha.e.g(map, "use"));
    }

    static Date h(Map map) {
        if (map.get(Claims.NOT_BEFORE) == null) {
            return null;
        }
        return ja.a.a(ha.e.f(map, Claims.NOT_BEFORE));
    }

    static List i(Map map) {
        List b10 = g.b(ha.e.d(map, JwsHeader.X509_CERT_CHAIN));
        if (b10 == null || !b10.isEmpty()) {
            return b10;
        }
        return null;
    }

    static c j(Map map) {
        return ha.e.a(map, JwsHeader.X509_CERT_SHA256_THUMBPRINT);
    }

    static c k(Map map) {
        return ha.e.a(map, JwsHeader.X509_CERT_SHA1_THUMBPRINT);
    }

    static URI l(Map map) {
        return ha.e.j(map, JwsHeader.X509_URL);
    }
}
