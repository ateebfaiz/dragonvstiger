package qd;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class d implements t {

    /* renamed from: c  reason: collision with root package name */
    private static final Map f1875c;

    /* renamed from: a  reason: collision with root package name */
    private final int f1876a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1877b;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(a("SHA-256", 32, 16, 67, 20, 2), new d(16777217, "XMSSMT_SHA2-256_W16_H20_D2"));
        hashMap.put(a("SHA-256", 32, 16, 67, 20, 4), new d(16777217, "XMSSMT_SHA2-256_W16_H20_D4"));
        hashMap.put(a("SHA-256", 32, 16, 67, 40, 2), new d(16777217, "XMSSMT_SHA2-256_W16_H40_D2"));
        hashMap.put(a("SHA-256", 32, 16, 67, 40, 2), new d(16777217, "XMSSMT_SHA2-256_W16_H40_D4"));
        hashMap.put(a("SHA-256", 32, 16, 67, 40, 4), new d(16777217, "XMSSMT_SHA2-256_W16_H40_D8"));
        hashMap.put(a("SHA-256", 32, 16, 67, 60, 8), new d(16777217, "XMSSMT_SHA2-256_W16_H60_D3"));
        hashMap.put(a("SHA-256", 32, 16, 67, 60, 6), new d(16777217, "XMSSMT_SHA2-256_W16_H60_D6"));
        hashMap.put(a("SHA-256", 32, 16, 67, 60, 12), new d(16777217, "XMSSMT_SHA2-256_W16_H60_D12"));
        hashMap.put(a("SHA2-512", 64, 16, 131, 20, 2), new d(16777217, "XMSSMT_SHA2-512_W16_H20_D2"));
        hashMap.put(a("SHA2-512", 64, 16, 131, 20, 4), new d(16777217, "XMSSMT_SHA2-512_W16_H20_D4"));
        hashMap.put(a("SHA2-512", 64, 16, 131, 40, 2), new d(16777217, "XMSSMT_SHA2-512_W16_H40_D2"));
        hashMap.put(a("SHA2-512", 64, 16, 131, 40, 4), new d(16777217, "XMSSMT_SHA2-512_W16_H40_D4"));
        hashMap.put(a("SHA2-512", 64, 16, 131, 40, 8), new d(16777217, "XMSSMT_SHA2-512_W16_H40_D8"));
        hashMap.put(a("SHA2-512", 64, 16, 131, 60, 3), new d(16777217, "XMSSMT_SHA2-512_W16_H60_D3"));
        hashMap.put(a("SHA2-512", 64, 16, 131, 60, 6), new d(16777217, "XMSSMT_SHA2-512_W16_H60_D6"));
        hashMap.put(a("SHA2-512", 64, 16, 131, 60, 12), new d(16777217, "XMSSMT_SHA2-512_W16_H60_D12"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 20, 2), new d(16777217, "XMSSMT_SHAKE128_W16_H20_D2"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 20, 4), new d(16777217, "XMSSMT_SHAKE128_W16_H20_D4"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 40, 2), new d(16777217, "XMSSMT_SHAKE128_W16_H40_D2"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 40, 4), new d(16777217, "XMSSMT_SHAKE128_W16_H40_D4"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 40, 8), new d(16777217, "XMSSMT_SHAKE128_W16_H40_D8"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 60, 3), new d(16777217, "XMSSMT_SHAKE128_W16_H60_D3"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 60, 6), new d(16777217, "XMSSMT_SHAKE128_W16_H60_D6"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 60, 12), new d(16777217, "XMSSMT_SHAKE128_W16_H60_D12"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 20, 2), new d(16777217, "XMSSMT_SHAKE256_W16_H20_D2"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 20, 4), new d(16777217, "XMSSMT_SHAKE256_W16_H20_D4"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 40, 2), new d(16777217, "XMSSMT_SHAKE256_W16_H40_D2"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 40, 4), new d(16777217, "XMSSMT_SHAKE256_W16_H40_D4"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 40, 8), new d(16777217, "XMSSMT_SHAKE256_W16_H40_D8"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 60, 3), new d(16777217, "XMSSMT_SHAKE256_W16_H60_D3"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 60, 6), new d(16777217, "XMSSMT_SHAKE256_W16_H60_D6"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 60, 12), new d(16777217, "XMSSMT_SHAKE256_W16_H60_D12"));
        f1875c = Collections.unmodifiableMap(hashMap);
    }

    private d(int i10, String str) {
        this.f1876a = i10;
        this.f1877b = str;
    }

    private static String a(String str, int i10, int i11, int i12, int i13, int i14) {
        if (str != null) {
            return str + "-" + i10 + "-" + i11 + "-" + i12 + "-" + i13 + "-" + i14;
        }
        throw new NullPointerException("algorithmName == null");
    }

    public static d b(String str, int i10, int i11, int i12, int i13, int i14) {
        if (str != null) {
            return (d) f1875c.get(a(str, i10, i11, i12, i13, i14));
        }
        throw new NullPointerException("algorithmName == null");
    }

    public String toString() {
        return this.f1877b;
    }
}
