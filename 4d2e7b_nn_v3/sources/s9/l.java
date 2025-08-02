package s9;

import ha.c;
import ha.e;
import ha.f;
import ia.b;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Map;

public final class l implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final a f13043a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f13044b;

    /* renamed from: c  reason: collision with root package name */
    private final String f13045c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f13046d;

    /* renamed from: e  reason: collision with root package name */
    private final c f13047e;

    /* renamed from: f  reason: collision with root package name */
    private final j f13048f;

    /* renamed from: g  reason: collision with root package name */
    private final b f13049g;

    public enum a {
        JSON,
        STRING,
        BYTE_ARRAY,
        BASE64URL,
        JWS_OBJECT,
        SIGNED_JWT
    }

    public l(c cVar) {
        if (cVar != null) {
            this.f13044b = null;
            this.f13045c = null;
            this.f13046d = null;
            this.f13047e = cVar;
            this.f13048f = null;
            this.f13049g = null;
            this.f13043a = a.BASE64URL;
            return;
        }
        throw new IllegalArgumentException("The Base64URL-encoded object must not be null");
    }

    private static String a(byte[] bArr) {
        if (bArr != null) {
            return new String(bArr, f.f12313a);
        }
        return null;
    }

    private static byte[] b(String str) {
        if (str != null) {
            return str.getBytes(f.f12313a);
        }
        return null;
    }

    public c c() {
        c cVar = this.f13047e;
        if (cVar != null) {
            return cVar;
        }
        return c.e(d());
    }

    public byte[] d() {
        byte[] bArr = this.f13046d;
        if (bArr != null) {
            return bArr;
        }
        c cVar = this.f13047e;
        if (cVar != null) {
            return cVar.a();
        }
        return b(toString());
    }

    public Map e() {
        Map map = this.f13044b;
        if (map != null) {
            return map;
        }
        String lVar = toString();
        if (lVar == null) {
            return null;
        }
        try {
            return e.l(lVar);
        } catch (ParseException unused) {
            return null;
        }
    }

    public String toString() {
        String str = this.f13045c;
        if (str != null) {
            return str;
        }
        j jVar = this.f13048f;
        if (jVar == null) {
            Map map = this.f13044b;
            if (map != null) {
                return e.n(map);
            }
            byte[] bArr = this.f13046d;
            if (bArr != null) {
                return a(bArr);
            }
            c cVar = this.f13047e;
            if (cVar != null) {
                return cVar.c();
            }
            return null;
        } else if (jVar.a() != null) {
            return this.f13048f.a();
        } else {
            return this.f13048f.l();
        }
    }
}
