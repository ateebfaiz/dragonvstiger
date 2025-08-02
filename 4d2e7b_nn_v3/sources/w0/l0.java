package w0;

import com.alibaba.pdns.model.DomainUhfReportModel;
import com.alibaba.pdns.net.d;
import x0.c;

abstract class l0 {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24456a = c.a.a("nm", d.f18103f, "w", "o", "lc", "lj", "ml", "hd", DomainUhfReportModel.ENCRYPTDATA);

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f24457b = c.a.a("n", DomainUhfReportModel.ENCRYPTYPE);

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static t0.s a(x0.c r18, com.airbnb.lottie.j r19) {
        /*
            r0 = r18
            r1 = 1
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r3 = 0
            r4 = 0
            r11 = r3
            r12 = r4
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r13 = 0
        L_0x0013:
            boolean r14 = r18.m()
            if (r14 == 0) goto L_0x00fc
            x0.c$a r14 = f24456a
            int r14 = r0.C(r14)
            switch(r14) {
                case 0: goto L_0x00f4;
                case 1: goto L_0x00ec;
                case 2: goto L_0x00e4;
                case 3: goto L_0x00dc;
                case 4: goto L_0x00cd;
                case 5: goto L_0x00be;
                case 6: goto L_0x00b5;
                case 7: goto L_0x00ad;
                case 8: goto L_0x0026;
                default: goto L_0x0022;
            }
        L_0x0022:
            r18.G()
            goto L_0x0013
        L_0x0026:
            r18.b()
        L_0x0029:
            boolean r14 = r18.m()
            if (r14 == 0) goto L_0x0097
            r18.h()
            r14 = 0
            r15 = 0
        L_0x0034:
            boolean r16 = r18.m()
            if (r16 == 0) goto L_0x0055
            x0.c$a r2 = f24457b
            int r2 = r0.C(r2)
            if (r2 == 0) goto L_0x0050
            if (r2 == r1) goto L_0x004b
            r18.E()
            r18.G()
            goto L_0x0034
        L_0x004b:
            s0.b r15 = w0.d.e(r18, r19)
            goto L_0x0034
        L_0x0050:
            java.lang.String r14 = r18.y()
            goto L_0x0034
        L_0x0055:
            r18.k()
            r14.hashCode()
            int r17 = r14.hashCode()
            switch(r17) {
                case 100: goto L_0x007a;
                case 103: goto L_0x006f;
                case 111: goto L_0x0064;
                default: goto L_0x0062;
            }
        L_0x0062:
            r2 = -1
            goto L_0x0084
        L_0x0064:
            java.lang.String r2 = "o"
            boolean r2 = r14.equals(r2)
            if (r2 != 0) goto L_0x006d
            goto L_0x0062
        L_0x006d:
            r2 = 2
            goto L_0x0084
        L_0x006f:
            java.lang.String r2 = "g"
            boolean r2 = r14.equals(r2)
            if (r2 != 0) goto L_0x0078
            goto L_0x0062
        L_0x0078:
            r2 = r1
            goto L_0x0084
        L_0x007a:
            java.lang.String r2 = "d"
            boolean r2 = r14.equals(r2)
            if (r2 != 0) goto L_0x0083
            goto L_0x0062
        L_0x0083:
            r2 = r4
        L_0x0084:
            switch(r2) {
                case 0: goto L_0x008e;
                case 1: goto L_0x008e;
                case 2: goto L_0x008a;
                default: goto L_0x0087;
            }
        L_0x0087:
            r2 = r19
            goto L_0x0029
        L_0x008a:
            r2 = r19
            r6 = r15
            goto L_0x0029
        L_0x008e:
            r2 = r19
            r2.u(r1)
            r5.add(r15)
            goto L_0x0029
        L_0x0097:
            r2 = r19
            r18.j()
            int r14 = r5.size()
            if (r14 != r1) goto L_0x0013
            java.lang.Object r14 = r5.get(r4)
            s0.b r14 = (s0.b) r14
            r5.add(r14)
            goto L_0x0013
        L_0x00ad:
            r2 = r19
            boolean r12 = r18.n()
            goto L_0x0013
        L_0x00b5:
            r2 = r19
            double r14 = r18.p()
            float r11 = (float) r14
            goto L_0x0013
        L_0x00be:
            r2 = r19
            t0.s$c[] r13 = t0.s.c.values()
            int r14 = r18.v()
            int r14 = r14 - r1
            r13 = r13[r14]
            goto L_0x0013
        L_0x00cd:
            r2 = r19
            t0.s$b[] r10 = t0.s.b.values()
            int r14 = r18.v()
            int r14 = r14 - r1
            r10 = r10[r14]
            goto L_0x0013
        L_0x00dc:
            r2 = r19
            s0.d r9 = w0.d.h(r18, r19)
            goto L_0x0013
        L_0x00e4:
            r2 = r19
            s0.b r8 = w0.d.e(r18, r19)
            goto L_0x0013
        L_0x00ec:
            r2 = r19
            s0.a r7 = w0.d.c(r18, r19)
            goto L_0x0013
        L_0x00f4:
            r2 = r19
            java.lang.String r3 = r18.y()
            goto L_0x0013
        L_0x00fc:
            if (r9 != 0) goto L_0x0113
            s0.d r0 = new s0.d
            z0.a r1 = new z0.a
            r2 = 100
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.<init>(r2)
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r0.<init>(r1)
            goto L_0x0114
        L_0x0113:
            r0 = r9
        L_0x0114:
            if (r10 != 0) goto L_0x011a
            t0.s$b r1 = t0.s.b.BUTT
            r9 = r1
            goto L_0x011b
        L_0x011a:
            r9 = r10
        L_0x011b:
            if (r13 != 0) goto L_0x0121
            t0.s$c r1 = t0.s.c.MITER
            r10 = r1
            goto L_0x0122
        L_0x0121:
            r10 = r13
        L_0x0122:
            t0.s r1 = new t0.s
            r2 = r1
            r4 = r6
            r6 = r7
            r7 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.l0.a(x0.c, com.airbnb.lottie.j):t0.s");
    }
}
