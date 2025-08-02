package x9;

import java.io.Serializable;
import java.security.spec.ECParameterSpec;
import java.util.Objects;

public final class a implements Serializable {
    public static final a C = new a("X448", "X448", (String) null);

    /* renamed from: d  reason: collision with root package name */
    public static final a f13250d = new a("P-256", "secp256r1", "1.2.840.10045.3.1.7");

    /* renamed from: e  reason: collision with root package name */
    public static final a f13251e = new a("secp256k1", "secp256k1", "1.3.132.0.10");

    /* renamed from: f  reason: collision with root package name */
    public static final a f13252f = new a("P-256K", "secp256k1", "1.3.132.0.10");

    /* renamed from: g  reason: collision with root package name */
    public static final a f13253g = new a("P-384", "secp384r1", "1.3.132.0.34");

    /* renamed from: h  reason: collision with root package name */
    public static final a f13254h = new a("P-521", "secp521r1", "1.3.132.0.35");

    /* renamed from: i  reason: collision with root package name */
    public static final a f13255i = new a("Ed25519", "Ed25519", (String) null);

    /* renamed from: j  reason: collision with root package name */
    public static final a f13256j = new a("Ed448", "Ed448", (String) null);

    /* renamed from: w  reason: collision with root package name */
    public static final a f13257w = new a("X25519", "X25519", (String) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f13258a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13259b;

    /* renamed from: c  reason: collision with root package name */
    private final String f13260c;

    public a(String str) {
        this(str, (String) null, (String) null);
    }

    public static a b(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("The cryptographic curve string must not be null or empty");
        }
        a aVar = f13250d;
        if (str.equals(aVar.a())) {
            return aVar;
        }
        a aVar2 = f13252f;
        if (str.equals(aVar2.a())) {
            return aVar2;
        }
        a aVar3 = f13251e;
        if (str.equals(aVar3.a())) {
            return aVar3;
        }
        a aVar4 = f13253g;
        if (str.equals(aVar4.a())) {
            return aVar4;
        }
        a aVar5 = f13254h;
        if (str.equals(aVar5.a())) {
            return aVar5;
        }
        a aVar6 = f13255i;
        if (str.equals(aVar6.a())) {
            return aVar6;
        }
        a aVar7 = f13256j;
        if (str.equals(aVar7.a())) {
            return aVar7;
        }
        a aVar8 = f13257w;
        if (str.equals(aVar8.a())) {
            return aVar8;
        }
        a aVar9 = C;
        if (str.equals(aVar9.a())) {
            return aVar9;
        }
        return new a(str);
    }

    public String a() {
        return this.f13258a;
    }

    public ECParameterSpec c() {
        return c.a(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a) || !toString().equals(obj.toString())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{a()});
    }

    public String toString() {
        return a();
    }

    public a(String str, String str2, String str3) {
        if (str != null) {
            this.f13258a = str;
            this.f13259b = str2;
            this.f13260c = str3;
            return;
        }
        throw new IllegalArgumentException("The JOSE cryptographic curve name must not be null");
    }
}
