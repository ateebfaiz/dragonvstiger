package x9;

import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public enum f {
    SIGN("sign"),
    VERIFY("verify"),
    ENCRYPT("encrypt"),
    DECRYPT("decrypt"),
    WRAP_KEY("wrapKey"),
    UNWRAP_KEY("unwrapKey"),
    DERIVE_KEY("deriveKey"),
    DERIVE_BITS("deriveBits");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f13285a;

    private f(String str) {
        if (str != null) {
            this.f13285a = str;
            return;
        }
        throw new IllegalArgumentException("The key operation identifier must not be null");
    }

    public static Set b(List list) {
        f fVar;
        if (list == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null) {
                f[] values = values();
                int length = values.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        fVar = null;
                        break;
                    }
                    fVar = values[i10];
                    if (str.equals(fVar.a())) {
                        break;
                    }
                    i10++;
                }
                if (fVar != null) {
                    linkedHashSet.add(fVar);
                } else {
                    throw new ParseException("Invalid JWK operation: " + str, 0);
                }
            }
        }
        return linkedHashSet;
    }

    public String a() {
        return this.f13285a;
    }

    public String toString() {
        return a();
    }
}
