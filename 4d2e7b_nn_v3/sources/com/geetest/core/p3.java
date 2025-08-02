package com.geetest.core;

import java.io.InputStream;

public class p3 {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f6127a;

    /* renamed from: b  reason: collision with root package name */
    public final c4 f6128b;

    /* renamed from: c  reason: collision with root package name */
    public final x3 f6129c;

    /* renamed from: d  reason: collision with root package name */
    public final t3 f6130d;

    /* renamed from: e  reason: collision with root package name */
    public final b4 f6131e;

    /* renamed from: f  reason: collision with root package name */
    public final s3 f6132f;

    /* renamed from: g  reason: collision with root package name */
    public final w3 f6133g;

    /* renamed from: h  reason: collision with root package name */
    public final a4 f6134h;

    /* renamed from: i  reason: collision with root package name */
    public final z3 f6135i;

    public p3(InputStream inputStream) {
        this.f6127a = inputStream;
        this.f6128b = new c4(this, inputStream);
        this.f6129c = new x3(this, inputStream);
        this.f6130d = new t3(this, inputStream);
        this.f6131e = new b4(this, inputStream);
        this.f6132f = new s3(this, inputStream);
        this.f6133g = new w3(this, inputStream);
        this.f6134h = new a4(this, inputStream);
        this.f6135i = new z3(this, inputStream);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:116:0x028d, code lost:
        throw new com.geetest.core.q3("Unexpected end of stream");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.geetest.core.i4 a() throws com.geetest.core.q3 {
        /*
            r15 = this;
            java.io.InputStream r0 = r15.f6127a     // Catch:{ IOException -> 0x0421 }
            int r0 = r0.read()     // Catch:{ IOException -> 0x0421 }
            r1 = 0
            r2 = -1
            if (r0 != r2) goto L_0x000b
            return r1
        L_0x000b:
            com.geetest.core.m4 r3 = com.geetest.core.m4.ofByte(r0)
            int r3 = r3.ordinal()
            java.lang.String r4 = "Unexpected major type "
            r5 = 1
            r7 = 0
            r9 = -1
            java.lang.String r11 = "Unexpected end of stream"
            r12 = 0
            r13 = 2
            r14 = 1
            switch(r3) {
                case 0: goto L_0x0415;
                case 1: goto L_0x0403;
                case 2: goto L_0x039c;
                case 3: goto L_0x0323;
                case 4: goto L_0x02c7;
                case 5: goto L_0x0246;
                case 6: goto L_0x0175;
                case 7: goto L_0x003a;
                default: goto L_0x0023;
            }
        L_0x0023:
            com.geetest.core.q3 r1 = new com.geetest.core.q3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Not implemented major type "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x003a:
            com.geetest.core.z3 r1 = r15.f6135i
            r1.getClass()
            com.geetest.core.v4 r3 = com.geetest.core.v4.ofByte(r0)
            int r3 = r3.ordinal()
            r4 = 31
            java.lang.String r5 = "Not implemented"
            r6 = 5
            r7 = 3
            if (r3 == 0) goto L_0x0149
            if (r3 == r14) goto L_0x013f
            r0 = 8
            if (r3 == r13) goto L_0x00da
            r2 = 4
            if (r3 == r7) goto L_0x00b1
            if (r3 == r2) goto L_0x0066
            if (r3 != r6) goto L_0x0060
            com.geetest.core.u4 r0 = com.geetest.core.u4.f6190c
            goto L_0x0174
        L_0x0060:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            r0.<init>((java.lang.String) r5)
            throw r0
        L_0x0066:
            com.geetest.core.u3 r1 = r1.f6233e
            byte[] r1 = r1.c(r0)
            byte r3 = r1[r12]
            r3 = r3 & 255(0xff, float:3.57E-43)
            long r3 = (long) r3
            long r3 = r3 << r0
            byte r5 = r1[r14]
            r5 = r5 & 255(0xff, float:3.57E-43)
            long r8 = (long) r5
            long r3 = r3 | r8
            long r3 = r3 << r0
            byte r5 = r1[r13]
            r5 = r5 & 255(0xff, float:3.57E-43)
            long r8 = (long) r5
            long r3 = r3 | r8
            long r3 = r3 << r0
            byte r5 = r1[r7]
            r5 = r5 & 255(0xff, float:3.57E-43)
            long r7 = (long) r5
            long r3 = r3 | r7
            long r3 = r3 << r0
            byte r2 = r1[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            long r7 = (long) r2
            long r2 = r3 | r7
            long r2 = r2 << r0
            byte r4 = r1[r6]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r4 = (long) r4
            long r2 = r2 | r4
            long r2 = r2 << r0
            r4 = 6
            byte r4 = r1[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r4 = (long) r4
            long r2 = r2 | r4
            long r2 = r2 << r0
            r0 = 7
            byte r0 = r1[r0]
            r0 = r0 & 255(0xff, float:3.57E-43)
            long r0 = (long) r0
            long r0 = r0 | r2
            com.geetest.core.j4 r2 = new com.geetest.core.j4
            double r0 = java.lang.Double.longBitsToDouble(r0)
            r2.<init>(r0)
            r0 = r2
            goto L_0x0174
        L_0x00b1:
            com.geetest.core.y3 r1 = r1.f6232d
            byte[] r1 = r1.c(r2)
            byte r2 = r1[r12]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r0
            byte r3 = r1[r14]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r2 = r2 | r3
            int r2 = r2 << r0
            byte r3 = r1[r13]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r2 = r2 | r3
            int r0 = r2 << 8
            byte r1 = r1[r7]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r0 = r0 | r1
            com.geetest.core.t4 r1 = new com.geetest.core.t4
            float r0 = java.lang.Float.intBitsToFloat(r0)
            r1.<init>(r0)
        L_0x00d7:
            r0 = r1
            goto L_0x0174
        L_0x00da:
            com.geetest.core.v3 r1 = r1.f6231c
            byte[] r1 = r1.c(r13)
            byte r3 = r1[r12]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r0 = r3 << 8
            byte r1 = r1[r14]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r0 = r0 | r1
            com.geetest.core.k4 r1 = new com.geetest.core.k4
            r3 = 32768(0x8000, float:4.5918E-41)
            r3 = r3 & r0
            int r3 = r3 >> 15
            r5 = r0 & 31744(0x7c00, float:4.4483E-41)
            int r5 = r5 >> 10
            r0 = r0 & 1023(0x3ff, float:1.434E-42)
            r6 = 4621819117588971520(0x4024000000000000, double:10.0)
            r8 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r5 != 0) goto L_0x0114
            if (r3 == 0) goto L_0x0102
            goto L_0x0103
        L_0x0102:
            r2 = r14
        L_0x0103:
            double r2 = (double) r2
            r4 = -4599301119452119040(0xc02c000000000000, double:-14.0)
            double r4 = java.lang.Math.pow(r8, r4)
            double r2 = r2 * r4
            double r4 = (double) r0
            double r6 = java.lang.Math.pow(r8, r6)
            double r4 = r4 / r6
        L_0x0111:
            double r2 = r2 * r4
            float r0 = (float) r2
            goto L_0x013b
        L_0x0114:
            if (r5 != r4) goto L_0x0124
            if (r0 == 0) goto L_0x011b
            r0 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x013b
        L_0x011b:
            if (r3 == 0) goto L_0x011e
            goto L_0x011f
        L_0x011e:
            r2 = r14
        L_0x011f:
            float r0 = (float) r2
            r2 = 2139095040(0x7f800000, float:Infinity)
            float r0 = r0 * r2
            goto L_0x013b
        L_0x0124:
            if (r3 == 0) goto L_0x0127
            goto L_0x0128
        L_0x0127:
            r2 = r14
        L_0x0128:
            double r2 = (double) r2
            int r5 = r5 + -15
            double r4 = (double) r5
            double r4 = java.lang.Math.pow(r8, r4)
            double r2 = r2 * r4
            double r4 = (double) r0
            double r6 = java.lang.Math.pow(r8, r6)
            double r4 = r4 / r6
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = r4 + r6
            goto L_0x0111
        L_0x013b:
            r1.<init>(r0)
            goto L_0x00d7
        L_0x013f:
            com.geetest.core.r4 r0 = new com.geetest.core.r4
            int r1 = r1.a()
            r0.<init>((int) r1)
            goto L_0x0174
        L_0x0149:
            com.geetest.core.s4 r1 = com.geetest.core.s4.ofByte(r0)
            int r1 = r1.ordinal()
            if (r1 == 0) goto L_0x0172
            if (r1 == r14) goto L_0x016f
            if (r1 == r13) goto L_0x016c
            if (r1 == r7) goto L_0x0169
            if (r1 != r6) goto L_0x0163
            com.geetest.core.r4 r1 = new com.geetest.core.r4
            r0 = r0 & r4
            r1.<init>((int) r0)
            goto L_0x00d7
        L_0x0163:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            r0.<init>((java.lang.String) r5)
            throw r0
        L_0x0169:
            com.geetest.core.r4 r0 = com.geetest.core.r4.f6163h
            goto L_0x0174
        L_0x016c:
            com.geetest.core.r4 r0 = com.geetest.core.r4.f6162g
            goto L_0x0174
        L_0x016f:
            com.geetest.core.r4 r0 = com.geetest.core.r4.f6161f
            goto L_0x0174
        L_0x0172:
            com.geetest.core.r4 r0 = com.geetest.core.r4.f6160e
        L_0x0174:
            return r0
        L_0x0175:
            com.geetest.core.a4 r1 = r15.f6134h
            com.geetest.core.w4 r2 = new com.geetest.core.w4
            long r0 = r1.a((int) r0)
            r2.<init>(r0)
            com.geetest.core.i4 r0 = r15.a()
            if (r0 == 0) goto L_0x023e
            long r3 = r2.f6205c
            r5 = 30
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x01de
            boolean r1 = r0 instanceof com.geetest.core.f4
            if (r1 == 0) goto L_0x01d6
            com.geetest.core.f4 r0 = (com.geetest.core.f4) r0
            java.util.ArrayList<com.geetest.core.i4> r1 = r0.f5976d
            int r1 = r1.size()
            if (r1 != r13) goto L_0x01ce
            java.util.ArrayList<com.geetest.core.i4> r1 = r0.f5976d
            java.lang.Object r1 = r1.get(r12)
            com.geetest.core.i4 r1 = (com.geetest.core.i4) r1
            boolean r2 = r1 instanceof com.geetest.core.p4
            if (r2 == 0) goto L_0x01c6
            java.util.ArrayList<com.geetest.core.i4> r0 = r0.f5976d
            java.lang.Object r0 = r0.get(r14)
            com.geetest.core.i4 r0 = (com.geetest.core.i4) r0
            boolean r2 = r0 instanceof com.geetest.core.p4
            if (r2 == 0) goto L_0x01be
            com.geetest.core.p4 r1 = (com.geetest.core.p4) r1
            com.geetest.core.p4 r0 = (com.geetest.core.p4) r0
            com.geetest.core.q4 r2 = new com.geetest.core.q4
            r2.<init>(r1, r0)
            return r2
        L_0x01be:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            java.lang.String r1 = "Error decoding RationalNumber: second data item is not a number"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x01c6:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            java.lang.String r1 = "Error decoding RationalNumber: first data item is not a number"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x01ce:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            java.lang.String r1 = "Error decoding RationalNumber: array size is not 2"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x01d6:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            java.lang.String r1 = "Error decoding RationalNumber: not an array"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x01de:
            r5 = 38
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0234
            boolean r1 = r0 instanceof com.geetest.core.f4
            if (r1 == 0) goto L_0x022c
            com.geetest.core.f4 r0 = (com.geetest.core.f4) r0
            java.util.ArrayList<com.geetest.core.i4> r1 = r0.f5976d
            int r1 = r1.size()
            if (r1 != r13) goto L_0x0224
            java.util.ArrayList<com.geetest.core.i4> r1 = r0.f5976d
            java.lang.Object r1 = r1.get(r12)
            com.geetest.core.i4 r1 = (com.geetest.core.i4) r1
            boolean r2 = r1 instanceof com.geetest.core.x4
            if (r2 == 0) goto L_0x021c
            java.util.ArrayList<com.geetest.core.i4> r0 = r0.f5976d
            java.lang.Object r0 = r0.get(r14)
            com.geetest.core.i4 r0 = (com.geetest.core.i4) r0
            boolean r2 = r0 instanceof com.geetest.core.x4
            if (r2 == 0) goto L_0x0214
            com.geetest.core.x4 r1 = (com.geetest.core.x4) r1
            com.geetest.core.x4 r0 = (com.geetest.core.x4) r0
            com.geetest.core.l4 r2 = new com.geetest.core.l4
            r2.<init>(r1, r0)
            return r2
        L_0x0214:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            java.lang.String r1 = "Error decoding LanguageTaggedString: second data item is not an UnicodeString"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x021c:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            java.lang.String r1 = "Error decoding LanguageTaggedString: first data item is not an UnicodeString"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0224:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            java.lang.String r1 = "Error decoding LanguageTaggedString: array size is not 2"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x022c:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            java.lang.String r1 = "Error decoding LanguageTaggedString: not an array"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0234:
            r1 = r0
        L_0x0235:
            com.geetest.core.w4 r3 = r1.f6020b
            if (r3 == 0) goto L_0x023b
            r1 = r3
            goto L_0x0235
        L_0x023b:
            r1.f6020b = r2
            return r0
        L_0x023e:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            java.lang.String r1 = "Unexpected end of stream: tag without following data item."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0246:
            com.geetest.core.w3 r1 = r15.f6133g
            long r2 = r1.a((int) r0)
            int r0 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r0 != 0) goto L_0x028e
            com.geetest.core.n4 r0 = new com.geetest.core.n4
            r0.<init>()
            r0.f6010c = r14
            com.geetest.core.p3 r2 = r1.f6159b
            r2.getClass()
        L_0x025c:
            com.geetest.core.p3 r2 = r1.f6159b
            com.geetest.core.i4 r2 = r2.a()
            com.geetest.core.u4 r3 = com.geetest.core.u4.f6190c
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x026b
            goto L_0x02c6
        L_0x026b:
            com.geetest.core.p3 r3 = r1.f6159b
            com.geetest.core.i4 r3 = r3.a()
            if (r2 == 0) goto L_0x0288
            if (r3 == 0) goto L_0x0288
            com.geetest.core.p3 r4 = r1.f6159b
            r4.getClass()
            java.util.LinkedHashMap<com.geetest.core.i4, com.geetest.core.i4> r4 = r0.f6113d
            java.lang.Object r3 = r4.put(r2, r3)
            if (r3 != 0) goto L_0x025c
            java.util.List<com.geetest.core.i4> r3 = r0.f6114e
            r3.add(r2)
            goto L_0x025c
        L_0x0288:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            r0.<init>((java.lang.String) r11)
            throw r0
        L_0x028e:
            com.geetest.core.n4 r0 = new com.geetest.core.n4
            int r4 = (int) r2
            int r4 = java.lang.Math.abs(r4)
            r0.<init>(r4)
        L_0x0298:
            int r4 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x02c6
            com.geetest.core.p3 r4 = r1.f6159b
            com.geetest.core.i4 r4 = r4.a()
            com.geetest.core.p3 r9 = r1.f6159b
            com.geetest.core.i4 r9 = r9.a()
            if (r4 == 0) goto L_0x02c0
            if (r9 == 0) goto L_0x02c0
            com.geetest.core.p3 r10 = r1.f6159b
            r10.getClass()
            java.util.LinkedHashMap<com.geetest.core.i4, com.geetest.core.i4> r10 = r0.f6113d
            java.lang.Object r9 = r10.put(r4, r9)
            if (r9 != 0) goto L_0x02be
            java.util.List<com.geetest.core.i4> r9 = r0.f6114e
            r9.add(r4)
        L_0x02be:
            long r7 = r7 + r5
            goto L_0x0298
        L_0x02c0:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            r0.<init>((java.lang.String) r11)
            throw r0
        L_0x02c6:
            return r0
        L_0x02c7:
            com.geetest.core.s3 r1 = r15.f6132f
            long r2 = r1.a((int) r0)
            int r0 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r0 != 0) goto L_0x02ff
            com.geetest.core.f4 r0 = new com.geetest.core.f4
            r0.<init>()
            r0.f6010c = r14
            com.geetest.core.p3 r2 = r1.f6159b
            r2.getClass()
        L_0x02dd:
            com.geetest.core.p3 r2 = r1.f6159b
            com.geetest.core.i4 r2 = r2.a()
            if (r2 == 0) goto L_0x02f9
            com.geetest.core.u4 r3 = com.geetest.core.u4.f6190c
            boolean r4 = r3.equals(r2)
            if (r4 == 0) goto L_0x02f3
            java.util.ArrayList<com.geetest.core.i4> r1 = r0.f5976d
            r1.add(r3)
            goto L_0x0322
        L_0x02f3:
            java.util.ArrayList<com.geetest.core.i4> r3 = r0.f5976d
            r3.add(r2)
            goto L_0x02dd
        L_0x02f9:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            r0.<init>((java.lang.String) r11)
            throw r0
        L_0x02ff:
            com.geetest.core.f4 r0 = new com.geetest.core.f4
            int r4 = (int) r2
            int r4 = java.lang.Math.abs(r4)
            r0.<init>(r4)
        L_0x0309:
            int r4 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0322
            com.geetest.core.p3 r4 = r1.f6159b
            com.geetest.core.i4 r4 = r4.a()
            if (r4 == 0) goto L_0x031c
            java.util.ArrayList<com.geetest.core.i4> r9 = r0.f5976d
            r9.add(r4)
            long r7 = r7 + r5
            goto L_0x0309
        L_0x031c:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            r0.<init>((java.lang.String) r11)
            throw r0
        L_0x0322:
            return r0
        L_0x0323:
            com.geetest.core.b4 r1 = r15.f6131e
            long r2 = r1.a((int) r0)
            int r0 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r0 != 0) goto L_0x038a
            com.geetest.core.p3 r0 = r1.f6159b
            r0.getClass()
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
        L_0x0337:
            com.geetest.core.p3 r2 = r1.f6159b
            com.geetest.core.i4 r2 = r2.a()
            if (r2 == 0) goto L_0x0384
            com.geetest.core.m4 r3 = r2.f6019a
            com.geetest.core.u4 r5 = com.geetest.core.u4.f6190c
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x035a
            com.geetest.core.x4 r1 = new com.geetest.core.x4
            java.lang.String r2 = new java.lang.String
            byte[] r0 = r0.toByteArray()
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8
            r2.<init>(r0, r3)
            r1.<init>(r2)
            goto L_0x039b
        L_0x035a:
            com.geetest.core.m4 r5 = com.geetest.core.m4.UNICODE_STRING
            if (r3 != r5) goto L_0x036f
            com.geetest.core.x4 r2 = (com.geetest.core.x4) r2
            java.lang.String r2 = r2.toString()
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8
            byte[] r2 = r2.getBytes(r3)
            int r3 = r2.length
            r0.write(r2, r12, r3)
            goto L_0x0337
        L_0x036f:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0384:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            r0.<init>((java.lang.String) r11)
            throw r0
        L_0x038a:
            com.geetest.core.x4 r0 = new com.geetest.core.x4
            java.lang.String r4 = new java.lang.String
            byte[] r1 = r1.a((long) r2)
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8
            r4.<init>(r1, r2)
            r0.<init>(r4)
            r1 = r0
        L_0x039b:
            return r1
        L_0x039c:
            com.geetest.core.t3 r2 = r15.f6130d
            long r5 = r2.a((int) r0)
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 != 0) goto L_0x03f9
            com.geetest.core.p3 r0 = r2.f6159b
            r0.getClass()
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
        L_0x03b0:
            com.geetest.core.p3 r3 = r2.f6159b
            com.geetest.core.i4 r3 = r3.a()
            if (r3 == 0) goto L_0x03f3
            com.geetest.core.m4 r5 = r3.f6019a
            com.geetest.core.u4 r6 = com.geetest.core.u4.f6190c
            boolean r6 = r6.equals(r3)
            if (r6 == 0) goto L_0x03cc
            com.geetest.core.g4 r1 = new com.geetest.core.g4
            byte[] r0 = r0.toByteArray()
            r1.<init>(r0)
            goto L_0x0402
        L_0x03cc:
            com.geetest.core.m4 r6 = com.geetest.core.m4.BYTE_STRING
            if (r5 != r6) goto L_0x03de
            com.geetest.core.g4 r3 = (com.geetest.core.g4) r3
            byte[] r3 = r3.f5984d
            if (r3 != 0) goto L_0x03d7
            r3 = r1
        L_0x03d7:
            if (r3 == 0) goto L_0x03b0
            int r5 = r3.length
            r0.write(r3, r12, r5)
            goto L_0x03b0
        L_0x03de:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x03f3:
            com.geetest.core.q3 r0 = new com.geetest.core.q3
            r0.<init>((java.lang.String) r11)
            throw r0
        L_0x03f9:
            com.geetest.core.g4 r1 = new com.geetest.core.g4
            byte[] r0 = r2.a((long) r5)
            r1.<init>(r0)
        L_0x0402:
            return r1
        L_0x0403:
            com.geetest.core.x3 r1 = r15.f6129c
            com.geetest.core.o4 r2 = new com.geetest.core.o4
            java.math.BigInteger r3 = com.geetest.core.x3.f6213c
            java.math.BigInteger r0 = r1.b(r0)
            java.math.BigInteger r0 = r3.subtract(r0)
            r2.<init>(r0)
            return r2
        L_0x0415:
            com.geetest.core.c4 r1 = r15.f6128b
            com.geetest.core.y4 r2 = new com.geetest.core.y4
            java.math.BigInteger r0 = r1.b(r0)
            r2.<init>(r0)
            return r2
        L_0x0421:
            r0 = move-exception
            com.geetest.core.q3 r1 = new com.geetest.core.q3
            r1.<init>((java.lang.Throwable) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.core.p3.a():com.geetest.core.i4");
    }
}
