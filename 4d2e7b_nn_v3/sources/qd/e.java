package qd;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class e implements t {

    /* renamed from: c  reason: collision with root package name */
    private static final Map f1878c;

    /* renamed from: a  reason: collision with root package name */
    private final int f1879a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1880b;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(a("SHA-256", 32, 16, 67, 10), new e(16777217, "XMSS_SHA2-256_W16_H10"));
        hashMap.put(a("SHA-256", 32, 16, 67, 16), new e(33554434, "XMSS_SHA2-256_W16_H16"));
        hashMap.put(a("SHA-256", 32, 16, 67, 20), new e(50331651, "XMSS_SHA2-256_W16_H20"));
        hashMap.put(a("SHA-512", 64, 16, 131, 10), new e(67108868, "XMSS_SHA2-512_W16_H10"));
        hashMap.put(a("SHA-512", 64, 16, 131, 16), new e(83886085, "XMSS_SHA2-512_W16_H16"));
        hashMap.put(a("SHA-512", 64, 16, 131, 20), new e(100663302, "XMSS_SHA2-512_W16_H20"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 10), new e(117440519, "XMSS_SHAKE128_W16_H10"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 16), new e(134217736, "XMSS_SHAKE128_W16_H16"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 20), new e(150994953, "XMSS_SHAKE128_W16_H20"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 10), new e(167772170, "XMSS_SHAKE256_W16_H10"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 16), new e(184549387, "XMSS_SHAKE256_W16_H16"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 20), new e(201326604, "XMSS_SHAKE256_W16_H20"));
        f1878c = Collections.unmodifiableMap(hashMap);
    }

    private e(int i10, String str) {
        this.f1879a = i10;
        this.f1880b = str;
    }

    private static String a(String str, int i10, int i11, int i12, int i13) {
        if (str != null) {
            return str + "-" + i10 + "-" + i11 + "-" + i12 + "-" + i13;
        }
        throw new NullPointerException("algorithmName == null");
    }

    public static e b(String str, int i10, int i11, int i12, int i13) {
        if (str != null) {
            return (e) f1878c.get(a(str, i10, i11, i12, i13));
        }
        throw new NullPointerException("algorithmName == null");
    }

    public String toString() {
        return this.f1880b;
    }
}
