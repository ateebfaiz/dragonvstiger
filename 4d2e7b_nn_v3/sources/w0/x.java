package w0;

abstract class x {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static t0.i a(x0.c r11, com.airbnb.lottie.j r12) {
        /*
            r0 = 3
            r1 = 2
            r2 = 1
            r3 = -1
            r11.h()
            r4 = 0
            r5 = 0
            r6 = r4
            r7 = r6
            r8 = r5
        L_0x000c:
            boolean r9 = r11.m()
            if (r9 == 0) goto L_0x00d6
            java.lang.String r9 = r11.w()
            r9.hashCode()
            int r10 = r9.hashCode()
            switch(r10) {
                case 111: goto L_0x0043;
                case 3588: goto L_0x0038;
                case 104433: goto L_0x002d;
                case 3357091: goto L_0x0022;
                default: goto L_0x0020;
            }
        L_0x0020:
            r10 = r3
            goto L_0x004d
        L_0x0022:
            java.lang.String r10 = "mode"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x002b
            goto L_0x0020
        L_0x002b:
            r10 = r0
            goto L_0x004d
        L_0x002d:
            java.lang.String r10 = "inv"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x0036
            goto L_0x0020
        L_0x0036:
            r10 = r1
            goto L_0x004d
        L_0x0038:
            java.lang.String r10 = "pt"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x0041
            goto L_0x0020
        L_0x0041:
            r10 = r2
            goto L_0x004d
        L_0x0043:
            java.lang.String r10 = "o"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x004c
            goto L_0x0020
        L_0x004c:
            r10 = r5
        L_0x004d:
            switch(r10) {
                case 0: goto L_0x00d0;
                case 1: goto L_0x00ca;
                case 2: goto L_0x00c4;
                case 3: goto L_0x0054;
                default: goto L_0x0050;
            }
        L_0x0050:
            r11.G()
            goto L_0x000c
        L_0x0054:
            java.lang.String r4 = r11.y()
            r4.hashCode()
            int r10 = r4.hashCode()
            switch(r10) {
                case 97: goto L_0x0085;
                case 105: goto L_0x007a;
                case 110: goto L_0x006f;
                case 115: goto L_0x0064;
                default: goto L_0x0062;
            }
        L_0x0062:
            r4 = r3
            goto L_0x008f
        L_0x0064:
            java.lang.String r10 = "s"
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x006d
            goto L_0x0062
        L_0x006d:
            r4 = r0
            goto L_0x008f
        L_0x006f:
            java.lang.String r10 = "n"
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x0078
            goto L_0x0062
        L_0x0078:
            r4 = r1
            goto L_0x008f
        L_0x007a:
            java.lang.String r10 = "i"
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x0083
            goto L_0x0062
        L_0x0083:
            r4 = r2
            goto L_0x008f
        L_0x0085:
            java.lang.String r10 = "a"
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x008e
            goto L_0x0062
        L_0x008e:
            r4 = r5
        L_0x008f:
            switch(r4) {
                case 0: goto L_0x00c0;
                case 1: goto L_0x00b7;
                case 2: goto L_0x00b3;
                case 3: goto L_0x00af;
                default: goto L_0x0092;
            }
        L_0x0092:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r10 = "Unknown mask mode "
            r4.append(r10)
            r4.append(r9)
            java.lang.String r9 = ". Defaulting to Add."
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            y0.f.c(r4)
            t0.i$a r4 = t0.i.a.MASK_MODE_ADD
            goto L_0x000c
        L_0x00af:
            t0.i$a r4 = t0.i.a.MASK_MODE_SUBTRACT
            goto L_0x000c
        L_0x00b3:
            t0.i$a r4 = t0.i.a.MASK_MODE_NONE
            goto L_0x000c
        L_0x00b7:
            java.lang.String r4 = "Animation contains intersect masks. They are not supported but will be treated like add masks."
            r12.a(r4)
            t0.i$a r4 = t0.i.a.MASK_MODE_INTERSECT
            goto L_0x000c
        L_0x00c0:
            t0.i$a r4 = t0.i.a.MASK_MODE_ADD
            goto L_0x000c
        L_0x00c4:
            boolean r8 = r11.n()
            goto L_0x000c
        L_0x00ca:
            s0.h r6 = w0.d.k(r11, r12)
            goto L_0x000c
        L_0x00d0:
            s0.d r7 = w0.d.h(r11, r12)
            goto L_0x000c
        L_0x00d6:
            r11.k()
            t0.i r11 = new t0.i
            r11.<init>(r4, r6, r7, r8)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.x.a(x0.c, com.airbnb.lottie.j):t0.i");
    }
}
