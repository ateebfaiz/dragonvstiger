package x9;

import com.alibaba.pdns.model.DomainUhfReportModel;
import ha.c;
import ha.d;
import ha.e;
import java.io.Serializable;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class l extends d {
    private final c N0;
    private final c O0;
    private final c P0;
    private final c Q0;
    private final c R0;
    private final c S0;
    private final c T0;
    private final List U0;
    private final PrivateKey V0;
    private final c Z;

    public static class a implements Serializable {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final c f13296a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final c f13297b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final c f13298c;

        public a(c cVar, c cVar2, c cVar3) {
            if (cVar != null) {
                this.f13296a = cVar;
                if (cVar2 != null) {
                    this.f13297b = cVar2;
                    if (cVar3 != null) {
                        this.f13298c = cVar3;
                        return;
                    }
                    throw new IllegalArgumentException("The factor CRT coefficient must not be null");
                }
                throw new IllegalArgumentException("The factor CRT exponent must not be null");
            }
            throw new IllegalArgumentException("The prime factor must not be null");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0096 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public l(ha.c r17, ha.c r18, ha.c r19, ha.c r20, ha.c r21, ha.c r22, ha.c r23, ha.c r24, java.util.List r25, java.security.PrivateKey r26, x9.h r27, java.util.Set r28, s9.a r29, java.lang.String r30, java.net.URI r31, ha.c r32, ha.c r33, java.util.List r34, java.util.Date r35, java.util.Date r36, java.util.Date r37, java.security.KeyStore r38) {
        /*
            r16 = this;
            r14 = r16
            r15 = r17
            r13 = r18
            r12 = r20
            r11 = r21
            r10 = r22
            r9 = r23
            r8 = r24
            x9.g r1 = x9.g.f13287d
            r0 = r16
            r2 = r27
            r3 = r28
            r4 = r29
            r5 = r30
            r6 = r31
            r7 = r32
            r8 = r33
            r9 = r34
            r10 = r35
            r11 = r36
            r12 = r37
            r13 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            if (r15 == 0) goto L_0x0108
            r14.Z = r15
            r0 = r18
            if (r0 == 0) goto L_0x0100
            r14.N0 = r0
            java.util.List r0 = r16.a()
            if (r0 == 0) goto L_0x0050
            java.util.List r0 = r16.a()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            boolean r0 = r14.e(r0)
            if (r0 == 0) goto L_0x0053
        L_0x0050:
            r0 = r19
            goto L_0x005b
        L_0x0053:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The public subject key info of the first X.509 certificate in the chain must match the JWK type and public parameters"
            r0.<init>(r1)
            throw r0
        L_0x005b:
            r14.O0 = r0
            r0 = r20
            r1 = r21
            r2 = r22
            if (r0 == 0) goto L_0x0090
            if (r1 == 0) goto L_0x0090
            r3 = r23
            if (r2 == 0) goto L_0x008d
            r4 = r24
            if (r3 == 0) goto L_0x0093
            if (r4 == 0) goto L_0x0093
            r14.P0 = r0
            r14.Q0 = r1
            r14.R0 = r2
            r14.S0 = r3
            r14.T0 = r4
            if (r25 == 0) goto L_0x0086
            java.util.List r0 = java.util.Collections.unmodifiableList(r25)
            r14.U0 = r0
        L_0x0083:
            r0 = r26
            goto L_0x00cd
        L_0x0086:
            java.util.List r0 = java.util.Collections.emptyList()
            r14.U0 = r0
            goto L_0x0083
        L_0x008d:
            r4 = r24
            goto L_0x0093
        L_0x0090:
            r3 = r23
            goto L_0x008d
        L_0x0093:
            r5 = 0
            if (r0 != 0) goto L_0x00b1
            if (r1 != 0) goto L_0x00b1
            if (r2 != 0) goto L_0x00b1
            if (r3 != 0) goto L_0x00b1
            if (r4 != 0) goto L_0x00b1
            if (r25 != 0) goto L_0x00b1
            r14.P0 = r5
            r14.Q0 = r5
            r14.R0 = r5
            r14.S0 = r5
            r14.T0 = r5
            java.util.List r0 = java.util.Collections.emptyList()
            r14.U0 = r0
            goto L_0x0083
        L_0x00b1:
            if (r0 != 0) goto L_0x00d0
            if (r1 != 0) goto L_0x00d0
            if (r2 != 0) goto L_0x00d0
            if (r3 != 0) goto L_0x00d0
            if (r4 == 0) goto L_0x00bc
            goto L_0x00d0
        L_0x00bc:
            r14.P0 = r5
            r14.Q0 = r5
            r14.R0 = r5
            r14.S0 = r5
            r14.T0 = r5
            java.util.List r0 = java.util.Collections.emptyList()
            r14.U0 = r0
            goto L_0x0083
        L_0x00cd:
            r14.V0 = r0
            return
        L_0x00d0:
            if (r0 == 0) goto L_0x00f8
            if (r1 == 0) goto L_0x00f0
            if (r2 == 0) goto L_0x00e8
            if (r3 != 0) goto L_0x00e0
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Incomplete second private (CRT) representation: The second factor CRT exponent must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00e0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Incomplete second private (CRT) representation: The first CRT coefficient must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00e8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Incomplete second private (CRT) representation: The first factor CRT exponent must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00f0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Incomplete second private (CRT) representation: The second prime factor must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00f8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Incomplete second private (CRT) representation: The first prime factor must not be null"
            r0.<init>(r1)
            throw r0
        L_0x0100:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The public exponent value must not be null"
            r0.<init>(r1)
            throw r0
        L_0x0108:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The modulus value must not be null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x9.l.<init>(ha.c, ha.c, ha.c, ha.c, ha.c, ha.c, ha.c, ha.c, java.util.List, java.security.PrivateKey, x9.h, java.util.Set, s9.a, java.lang.String, java.net.URI, ha.c, ha.c, java.util.List, java.util.Date, java.util.Date, java.util.Date, java.security.KeyStore):void");
    }

    public static l f(Map map) {
        ArrayList arrayList;
        List d10;
        Map map2 = map;
        if (g.f13287d.equals(e.f(map))) {
            c a10 = e.a(map2, "n");
            c a11 = e.a(map2, "e");
            c a12 = e.a(map2, DomainUhfReportModel.ENCRYPTDATA);
            c a13 = e.a(map2, "p");
            c a14 = e.a(map2, "q");
            c a15 = e.a(map2, "dp");
            c a16 = e.a(map2, "dq");
            c a17 = e.a(map2, "qi");
            if (!map2.containsKey("oth") || (d10 = e.d(map2, "oth")) == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(d10.size());
                for (Object next : d10) {
                    if (next instanceof Map) {
                        Map map3 = (Map) next;
                        try {
                            arrayList.add(new a(e.a(map3, "r"), e.a(map3, "dq"), e.a(map3, "t")));
                        } catch (IllegalArgumentException e10) {
                            throw new ParseException(e10.getMessage(), 0);
                        }
                    }
                }
            }
            try {
                return new l(a10, a11, a12, a13, a14, a15, a16, a17, arrayList, (PrivateKey) null, e.g(map), e.e(map), e.a(map), e.d(map), e.l(map), e.k(map), e.j(map), e.i(map), e.b(map), e.h(map), e.c(map), (KeyStore) null);
            } catch (IllegalArgumentException e11) {
                throw new ParseException(e11.getMessage(), 0);
            }
        } else {
            throw new ParseException("The key type \"kty\" must be RSA", 0);
        }
    }

    public boolean b() {
        if (this.O0 == null && this.P0 == null && this.V0 == null) {
            return false;
        }
        return true;
    }

    public Map d() {
        Map d10 = super.d();
        d10.put("n", this.Z.toString());
        d10.put("e", this.N0.toString());
        c cVar = this.O0;
        if (cVar != null) {
            d10.put(DomainUhfReportModel.ENCRYPTDATA, cVar.toString());
        }
        c cVar2 = this.P0;
        if (cVar2 != null) {
            d10.put("p", cVar2.toString());
        }
        c cVar3 = this.Q0;
        if (cVar3 != null) {
            d10.put("q", cVar3.toString());
        }
        c cVar4 = this.R0;
        if (cVar4 != null) {
            d10.put("dp", cVar4.toString());
        }
        c cVar5 = this.S0;
        if (cVar5 != null) {
            d10.put("dq", cVar5.toString());
        }
        c cVar6 = this.T0;
        if (cVar6 != null) {
            d10.put("qi", cVar6.toString());
        }
        List list = this.U0;
        if (list != null && !list.isEmpty()) {
            List a10 = d.a();
            for (a aVar : this.U0) {
                Map k10 = e.k();
                k10.put("r", aVar.f13296a.toString());
                k10.put(DomainUhfReportModel.ENCRYPTDATA, aVar.f13297b.toString());
                k10.put("t", aVar.f13298c.toString());
                a10.add(k10);
            }
            d10.put("oth", a10);
        }
        return d10;
    }

    public boolean e(X509Certificate x509Certificate) {
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) ((X509Certificate) a().get(0)).getPublicKey();
            if (!this.N0.b().equals(rSAPublicKey.getPublicExponent())) {
                return false;
            }
            return this.Z.b().equals(rSAPublicKey.getModulus());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l) || !super.equals(obj)) {
            return false;
        }
        l lVar = (l) obj;
        if (!Objects.equals(this.Z, lVar.Z) || !Objects.equals(this.N0, lVar.N0) || !Objects.equals(this.O0, lVar.O0) || !Objects.equals(this.P0, lVar.P0) || !Objects.equals(this.Q0, lVar.Q0) || !Objects.equals(this.R0, lVar.R0) || !Objects.equals(this.S0, lVar.S0) || !Objects.equals(this.T0, lVar.T0) || !Objects.equals(this.U0, lVar.U0) || !Objects.equals(this.V0, lVar.V0)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.Z, this.N0, this.O0, this.P0, this.Q0, this.R0, this.S0, this.T0, this.U0, this.V0});
    }
}
