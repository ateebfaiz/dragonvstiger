package qd;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class k implements t {

    /* renamed from: c  reason: collision with root package name */
    private static final Map f1904c;

    /* renamed from: a  reason: collision with root package name */
    private final int f1905a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1906b;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(a("SHA-256", 32, 16, 67), new k(16777217, "WOTSP_SHA2-256_W16"));
        hashMap.put(a("SHA-512", 64, 16, 131), new k(33554434, "WOTSP_SHA2-512_W16"));
        hashMap.put(a("SHAKE128", 32, 16, 67), new k(50331651, "WOTSP_SHAKE128_W16"));
        hashMap.put(a("SHAKE256", 64, 16, 131), new k(67108868, "WOTSP_SHAKE256_W16"));
        f1904c = Collections.unmodifiableMap(hashMap);
    }

    private k(int i10, String str) {
        this.f1905a = i10;
        this.f1906b = str;
    }

    private static String a(String str, int i10, int i11, int i12) {
        if (str != null) {
            return str + "-" + i10 + "-" + i11 + "-" + i12;
        }
        throw new NullPointerException("algorithmName == null");
    }

    protected static k b(String str, int i10, int i11, int i12) {
        if (str != null) {
            return (k) f1904c.get(a(str, i10, i11, i12));
        }
        throw new NullPointerException("algorithmName == null");
    }

    public String toString() {
        return this.f1906b;
    }
}
