package w0;

import com.alibaba.pdns.model.DomainUhfReportModel;
import x0.c;

abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24435a = c.a.a("ty", DomainUhfReportModel.ENCRYPTDATA);

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ce, code lost:
        if (r3.equals("fl") == false) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static t0.c a(x0.c r7, com.airbnb.lottie.j r8) {
        /*
            r0 = 1
            r7.h()
            r1 = 2
            r2 = r1
        L_0x0006:
            boolean r3 = r7.m()
            r4 = 0
            if (r3 == 0) goto L_0x0028
            x0.c$a r3 = f24435a
            int r3 = r7.C(r3)
            if (r3 == 0) goto L_0x0023
            if (r3 == r0) goto L_0x001e
            r7.E()
            r7.G()
            goto L_0x0006
        L_0x001e:
            int r2 = r7.v()
            goto L_0x0006
        L_0x0023:
            java.lang.String r3 = r7.y()
            goto L_0x0029
        L_0x0028:
            r3 = r4
        L_0x0029:
            if (r3 != 0) goto L_0x002c
            return r4
        L_0x002c:
            r5 = -1
            int r6 = r3.hashCode()
            switch(r6) {
                case 3239: goto L_0x00d2;
                case 3270: goto L_0x00c8;
                case 3295: goto L_0x00bc;
                case 3307: goto L_0x00b0;
                case 3308: goto L_0x00a5;
                case 3488: goto L_0x009a;
                case 3633: goto L_0x008f;
                case 3634: goto L_0x0084;
                case 3646: goto L_0x0078;
                case 3669: goto L_0x006b;
                case 3679: goto L_0x005e;
                case 3681: goto L_0x0051;
                case 3705: goto L_0x0044;
                case 3710: goto L_0x0037;
                default: goto L_0x0034;
            }
        L_0x0034:
            r0 = r5
            goto L_0x00dd
        L_0x0037:
            java.lang.String r0 = "tr"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0040
            goto L_0x0034
        L_0x0040:
            r0 = 13
            goto L_0x00dd
        L_0x0044:
            java.lang.String r0 = "tm"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x004d
            goto L_0x0034
        L_0x004d:
            r0 = 12
            goto L_0x00dd
        L_0x0051:
            java.lang.String r0 = "st"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x005a
            goto L_0x0034
        L_0x005a:
            r0 = 11
            goto L_0x00dd
        L_0x005e:
            java.lang.String r0 = "sr"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0067
            goto L_0x0034
        L_0x0067:
            r0 = 10
            goto L_0x00dd
        L_0x006b:
            java.lang.String r0 = "sh"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0074
            goto L_0x0034
        L_0x0074:
            r0 = 9
            goto L_0x00dd
        L_0x0078:
            java.lang.String r0 = "rp"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0081
            goto L_0x0034
        L_0x0081:
            r0 = 8
            goto L_0x00dd
        L_0x0084:
            java.lang.String r0 = "rd"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x008d
            goto L_0x0034
        L_0x008d:
            r0 = 7
            goto L_0x00dd
        L_0x008f:
            java.lang.String r0 = "rc"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0098
            goto L_0x0034
        L_0x0098:
            r0 = 6
            goto L_0x00dd
        L_0x009a:
            java.lang.String r0 = "mm"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00a3
            goto L_0x0034
        L_0x00a3:
            r0 = 5
            goto L_0x00dd
        L_0x00a5:
            java.lang.String r0 = "gs"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00ae
            goto L_0x0034
        L_0x00ae:
            r0 = 4
            goto L_0x00dd
        L_0x00b0:
            java.lang.String r0 = "gr"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00ba
            goto L_0x0034
        L_0x00ba:
            r0 = 3
            goto L_0x00dd
        L_0x00bc:
            java.lang.String r0 = "gf"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00c6
            goto L_0x0034
        L_0x00c6:
            r0 = r1
            goto L_0x00dd
        L_0x00c8:
            java.lang.String r1 = "fl"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x00dd
            goto L_0x0034
        L_0x00d2:
            java.lang.String r0 = "el"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00dc
            goto L_0x0034
        L_0x00dc:
            r0 = 0
        L_0x00dd:
            switch(r0) {
                case 0: goto L_0x013b;
                case 1: goto L_0x0136;
                case 2: goto L_0x0131;
                case 3: goto L_0x012c;
                case 4: goto L_0x0127;
                case 5: goto L_0x011d;
                case 6: goto L_0x0118;
                case 7: goto L_0x0113;
                case 8: goto L_0x010e;
                case 9: goto L_0x0109;
                case 10: goto L_0x0104;
                case 11: goto L_0x00ff;
                case 12: goto L_0x00fa;
                case 13: goto L_0x00f5;
                default: goto L_0x00e0;
            }
        L_0x00e0:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Unknown shape type "
            r8.append(r0)
            r8.append(r3)
            java.lang.String r8 = r8.toString()
            y0.f.c(r8)
            goto L_0x013f
        L_0x00f5:
            s0.n r4 = w0.c.g(r7, r8)
            goto L_0x013f
        L_0x00fa:
            t0.t r4 = w0.m0.a(r7, r8)
            goto L_0x013f
        L_0x00ff:
            t0.s r4 = w0.l0.a(r7, r8)
            goto L_0x013f
        L_0x0104:
            t0.k r4 = w0.c0.a(r7, r8, r2)
            goto L_0x013f
        L_0x0109:
            t0.r r4 = w0.k0.a(r7, r8)
            goto L_0x013f
        L_0x010e:
            t0.m r4 = w0.e0.a(r7, r8)
            goto L_0x013f
        L_0x0113:
            t0.n r4 = w0.f0.a(r7, r8)
            goto L_0x013f
        L_0x0118:
            t0.l r4 = w0.d0.a(r7, r8)
            goto L_0x013f
        L_0x011d:
            t0.j r4 = w0.y.a(r7)
            java.lang.String r0 = "Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove()."
            r8.a(r0)
            goto L_0x013f
        L_0x0127:
            t0.f r4 = w0.q.a(r7, r8)
            goto L_0x013f
        L_0x012c:
            t0.q r4 = w0.j0.a(r7, r8)
            goto L_0x013f
        L_0x0131:
            t0.e r4 = w0.p.a(r7, r8)
            goto L_0x013f
        L_0x0136:
            t0.p r4 = w0.i0.a(r7, r8)
            goto L_0x013f
        L_0x013b:
            t0.b r4 = w0.f.a(r7, r8, r2)
        L_0x013f:
            boolean r8 = r7.m()
            if (r8 == 0) goto L_0x0149
            r7.G()
            goto L_0x013f
        L_0x0149:
            r7.k()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.h.a(x0.c, com.airbnb.lottie.j):t0.c");
    }
}
