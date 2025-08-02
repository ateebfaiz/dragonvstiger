package s9;

public final class g extends a {
    public static final g C;
    public static final g N0;
    public static final g O0;
    public static final g P0;
    public static final g Q0;
    public static final g R0;
    public static final g S0;
    public static final g T0;
    public static final g U0;
    public static final g V0;
    public static final g W0;
    public static final g X;
    public static final g X0;
    public static final g Y;
    public static final g Z;

    /* renamed from: d  reason: collision with root package name */
    public static final g f13005d = new g("RSA1_5", m.REQUIRED);

    /* renamed from: e  reason: collision with root package name */
    public static final g f13006e;

    /* renamed from: f  reason: collision with root package name */
    public static final g f13007f;

    /* renamed from: g  reason: collision with root package name */
    public static final g f13008g;

    /* renamed from: h  reason: collision with root package name */
    public static final g f13009h;

    /* renamed from: i  reason: collision with root package name */
    public static final g f13010i;

    /* renamed from: j  reason: collision with root package name */
    public static final g f13011j;

    /* renamed from: w  reason: collision with root package name */
    public static final g f13012w;

    static {
        m mVar = m.OPTIONAL;
        f13006e = new g("RSA-OAEP", mVar);
        f13007f = new g("RSA-OAEP-256", mVar);
        f13008g = new g("RSA-OAEP-384", mVar);
        f13009h = new g("RSA-OAEP-512", mVar);
        m mVar2 = m.RECOMMENDED;
        f13010i = new g("A128KW", mVar2);
        f13011j = new g("A192KW", mVar);
        f13012w = new g("A256KW", mVar2);
        C = new g("dir", mVar2);
        X = new g("ECDH-ES", mVar2);
        Y = new g("ECDH-ES+A128KW", mVar2);
        Z = new g("ECDH-ES+A192KW", mVar);
        N0 = new g("ECDH-ES+A256KW", mVar2);
        O0 = new g("ECDH-1PU", mVar);
        P0 = new g("ECDH-1PU+A128KW", mVar);
        Q0 = new g("ECDH-1PU+A192KW", mVar);
        R0 = new g("ECDH-1PU+A256KW", mVar);
        S0 = new g("A128GCMKW", mVar);
        T0 = new g("A192GCMKW", mVar);
        U0 = new g("A256GCMKW", mVar);
        V0 = new g("PBES2-HS256+A128KW", mVar);
        W0 = new g("PBES2-HS384+A192KW", mVar);
        X0 = new g("PBES2-HS512+A256KW", mVar);
    }

    public g(String str, m mVar) {
        super(str, mVar);
    }

    public static g c(String str) {
        g gVar = f13005d;
        if (str.equals(gVar.a())) {
            return gVar;
        }
        g gVar2 = f13006e;
        if (str.equals(gVar2.a())) {
            return gVar2;
        }
        g gVar3 = f13007f;
        if (str.equals(gVar3.a())) {
            return gVar3;
        }
        g gVar4 = f13008g;
        if (str.equals(gVar4.a())) {
            return gVar4;
        }
        g gVar5 = f13009h;
        if (str.equals(gVar5.a())) {
            return gVar5;
        }
        g gVar6 = f13010i;
        if (str.equals(gVar6.a())) {
            return gVar6;
        }
        g gVar7 = f13011j;
        if (str.equals(gVar7.a())) {
            return gVar7;
        }
        g gVar8 = f13012w;
        if (str.equals(gVar8.a())) {
            return gVar8;
        }
        g gVar9 = C;
        if (str.equals(gVar9.a())) {
            return gVar9;
        }
        g gVar10 = X;
        if (str.equals(gVar10.a())) {
            return gVar10;
        }
        g gVar11 = Y;
        if (str.equals(gVar11.a())) {
            return gVar11;
        }
        g gVar12 = Z;
        if (str.equals(gVar12.a())) {
            return gVar12;
        }
        g gVar13 = N0;
        if (str.equals(gVar13.a())) {
            return gVar13;
        }
        g gVar14 = O0;
        if (str.equals(gVar14.a())) {
            return gVar14;
        }
        g gVar15 = P0;
        if (str.equals(gVar15.a())) {
            return gVar15;
        }
        g gVar16 = Q0;
        if (str.equals(gVar16.a())) {
            return gVar16;
        }
        g gVar17 = R0;
        if (str.equals(gVar17.a())) {
            return gVar17;
        }
        g gVar18 = S0;
        if (str.equals(gVar18.a())) {
            return gVar18;
        }
        g gVar19 = T0;
        if (str.equals(gVar19.a())) {
            return gVar19;
        }
        g gVar20 = U0;
        if (str.equals(gVar20.a())) {
            return gVar20;
        }
        g gVar21 = V0;
        if (str.equals(gVar21.a())) {
            return gVar21;
        }
        g gVar22 = W0;
        if (str.equals(gVar22.a())) {
            return gVar22;
        }
        g gVar23 = X0;
        if (str.equals(gVar23.a())) {
            return gVar23;
        }
        return new g(str);
    }

    public g(String str) {
        super(str, (m) null);
    }
}
