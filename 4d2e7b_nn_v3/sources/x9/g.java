package x9;

import java.io.Serializable;
import s9.m;

public final class g implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final g f13286c = new g("EC", m.RECOMMENDED);

    /* renamed from: d  reason: collision with root package name */
    public static final g f13287d = new g("RSA", m.REQUIRED);

    /* renamed from: e  reason: collision with root package name */
    public static final g f13288e;

    /* renamed from: f  reason: collision with root package name */
    public static final g f13289f;

    /* renamed from: a  reason: collision with root package name */
    private final String f13290a;

    /* renamed from: b  reason: collision with root package name */
    private final m f13291b;

    static {
        m mVar = m.OPTIONAL;
        f13288e = new g("oct", mVar);
        f13289f = new g("OKP", mVar);
    }

    public g(String str, m mVar) {
        if (str != null) {
            this.f13290a = str;
            this.f13291b = mVar;
            return;
        }
        throw new IllegalArgumentException("The key type value must not be null");
    }

    public static g b(String str) {
        if (str != null) {
            g gVar = f13286c;
            if (str.equals(gVar.a())) {
                return gVar;
            }
            g gVar2 = f13287d;
            if (str.equals(gVar2.a())) {
                return gVar2;
            }
            g gVar3 = f13288e;
            if (str.equals(gVar3.a())) {
                return gVar3;
            }
            g gVar4 = f13289f;
            if (str.equals(gVar4.a())) {
                return gVar4;
            }
            return new g(str, (m) null);
        }
        throw new IllegalArgumentException("The key type to parse must not be null");
    }

    public String a() {
        return this.f13290a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g) || !toString().equals(obj.toString())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f13290a.hashCode();
    }

    public String toString() {
        return this.f13290a;
    }
}
