package s9;

import com.alibaba.pdns.f;
import ha.c;
import io.jsonwebtoken.JwtParser;
import java.io.Serializable;
import java.text.ParseException;

public abstract class e implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private l f12999a = null;

    /* renamed from: b  reason: collision with root package name */
    private c[] f13000b = null;

    protected e() {
    }

    public static c[] e(String str) {
        String trim = str.trim();
        int indexOf = trim.indexOf(f.G);
        if (indexOf != -1) {
            int i10 = indexOf + 1;
            int indexOf2 = trim.indexOf(f.G, i10);
            if (indexOf2 != -1) {
                int i11 = indexOf2 + 1;
                int indexOf3 = trim.indexOf(f.G, i11);
                if (indexOf3 == -1) {
                    return new c[]{new c(trim.substring(0, indexOf)), new c(trim.substring(i10, indexOf2)), new c(trim.substring(i11))};
                }
                int i12 = indexOf3 + 1;
                int indexOf4 = trim.indexOf(f.G, i12);
                if (indexOf4 == -1) {
                    throw new ParseException("Invalid serialized JWE object: Missing fourth delimiter", 0);
                } else if (indexOf4 == -1 || trim.indexOf(f.G, indexOf4 + 1) == -1) {
                    return new c[]{new c(trim.substring(0, indexOf)), new c(trim.substring(i10, indexOf2)), new c(trim.substring(i11, indexOf3)), new c(trim.substring(i12, indexOf4)), new c(trim.substring(indexOf4 + 1))};
                } else {
                    throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Too many part delimiters", 0);
                }
            } else {
                throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Missing second delimiter", 0);
            }
        } else {
            throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Missing part delimiters", 0);
        }
    }

    public String a() {
        if (this.f13000b == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (c cVar : this.f13000b) {
            if (sb2.length() > 0) {
                sb2.append(JwtParser.SEPARATOR_CHAR);
            }
            if (cVar != null) {
                sb2.append(cVar);
            }
        }
        return sb2.toString();
    }

    public l b() {
        return this.f12999a;
    }

    /* access modifiers changed from: protected */
    public void c(c... cVarArr) {
        this.f13000b = cVarArr;
    }

    /* access modifiers changed from: protected */
    public void d(l lVar) {
        this.f12999a = lVar;
    }
}
