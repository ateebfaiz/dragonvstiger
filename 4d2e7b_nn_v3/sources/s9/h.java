package s9;

public final class h extends a {
    public static final h C;
    public static final h N0;
    public static final h O0;
    public static final h X;
    public static final h Y;
    public static final h Z;

    /* renamed from: d  reason: collision with root package name */
    public static final h f13013d = new h("HS256", m.REQUIRED);

    /* renamed from: e  reason: collision with root package name */
    public static final h f13014e;

    /* renamed from: f  reason: collision with root package name */
    public static final h f13015f;

    /* renamed from: g  reason: collision with root package name */
    public static final h f13016g;

    /* renamed from: h  reason: collision with root package name */
    public static final h f13017h;

    /* renamed from: i  reason: collision with root package name */
    public static final h f13018i;

    /* renamed from: j  reason: collision with root package name */
    public static final h f13019j;

    /* renamed from: w  reason: collision with root package name */
    public static final h f13020w;

    static {
        m mVar = m.OPTIONAL;
        f13014e = new h("HS384", mVar);
        f13015f = new h("HS512", mVar);
        m mVar2 = m.RECOMMENDED;
        f13016g = new h("RS256", mVar2);
        f13017h = new h("RS384", mVar);
        f13018i = new h("RS512", mVar);
        f13019j = new h("ES256", mVar2);
        f13020w = new h("ES256K", mVar);
        C = new h("ES384", mVar);
        X = new h("ES512", mVar);
        Y = new h("PS256", mVar);
        Z = new h("PS384", mVar);
        N0 = new h("PS512", mVar);
        O0 = new h("EdDSA", mVar);
    }

    public h(String str, m mVar) {
        super(str, mVar);
    }

    public static h c(String str) {
        h hVar = f13013d;
        if (str.equals(hVar.a())) {
            return hVar;
        }
        h hVar2 = f13014e;
        if (str.equals(hVar2.a())) {
            return hVar2;
        }
        h hVar3 = f13015f;
        if (str.equals(hVar3.a())) {
            return hVar3;
        }
        h hVar4 = f13016g;
        if (str.equals(hVar4.a())) {
            return hVar4;
        }
        h hVar5 = f13017h;
        if (str.equals(hVar5.a())) {
            return hVar5;
        }
        h hVar6 = f13018i;
        if (str.equals(hVar6.a())) {
            return hVar6;
        }
        h hVar7 = f13019j;
        if (str.equals(hVar7.a())) {
            return hVar7;
        }
        h hVar8 = f13020w;
        if (str.equals(hVar8.a())) {
            return hVar8;
        }
        h hVar9 = C;
        if (str.equals(hVar9.a())) {
            return hVar9;
        }
        h hVar10 = X;
        if (str.equals(hVar10.a())) {
            return hVar10;
        }
        h hVar11 = Y;
        if (str.equals(hVar11.a())) {
            return hVar11;
        }
        h hVar12 = Z;
        if (str.equals(hVar12.a())) {
            return hVar12;
        }
        h hVar13 = N0;
        if (str.equals(hVar13.a())) {
            return hVar13;
        }
        h hVar14 = O0;
        if (str.equals(hVar14.a())) {
            return hVar14;
        }
        return new h(str);
    }

    public h(String str) {
        super(str, (m) null);
    }
}
