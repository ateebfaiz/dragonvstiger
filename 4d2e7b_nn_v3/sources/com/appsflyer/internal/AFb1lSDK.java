package com.appsflyer.internal;

public class AFb1lSDK {
    public static final byte[] getOutOfStore = null;
    public static byte[] setAndroidIdData = null;
    private static int setAppInviteOneLink = 1;
    public static byte[] setCustomerIdAndLogSession;
    public static int setCustomerUserId;
    private static Object setDebugLog;
    public static long setImeiData;
    public static byte[] setOaidData;
    public static int setPhoneNumber;
    private static int setUserEmails;
    private static Object updateServerUninstallToken;
    public static final int waitForCustomerUserId = 0;

    /* JADX WARNING: Removed duplicated region for block: B:8:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String $$c(int r6, int r7, int r8) {
        /*
            int r0 = setUserEmails
            r1 = r0 | 23
            int r1 = r1 << 1
            r0 = r0 ^ 23
            int r1 = r1 - r0
            int r1 = r1 % 128
            setAppInviteOneLink = r1
            int r7 = -r7
            r0 = r7 ^ 36
            r7 = r7 & 36
            int r7 = r7 << 1
            int r0 = r0 + r7
            r7 = r6 | -16
            int r7 = r7 << 1
            r6 = r6 ^ -16
            int r7 = r7 - r6
            r6 = r7 & 20
            r7 = r7 | 20
            int r6 = r6 + r7
            byte[] r7 = getOutOfStore
            int r8 = -r8
            r2 = r8 | 119(0x77, float:1.67E-43)
            int r2 = r2 << 1
            r8 = r8 ^ 119(0x77, float:1.67E-43)
            int r2 = r2 - r8
            byte[] r8 = new byte[r0]
            int r0 = r0 + -1
            r3 = 0
            if (r7 != 0) goto L_0x003c
            int r1 = r1 + 63
            int r1 = r1 % 128
            setUserEmails = r1
            r1 = r6
            r2 = r0
            r4 = r3
            goto L_0x0057
        L_0x003c:
            r1 = r3
        L_0x003d:
            byte r4 = (byte) r2
            r8[r1] = r4
            r4 = r1 & 1
            r5 = r1 | 1
            int r4 = r4 + r5
            if (r1 != r0) goto L_0x004d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r8, r3)
            return r6
        L_0x004d:
            byte r1 = r7[r6]
            int r5 = setUserEmails
            int r5 = r5 + 97
            int r5 = r5 % 128
            setAppInviteOneLink = r5
        L_0x0057:
            r5 = r6 & 1
            r6 = r6 | 1
            int r6 = r6 + r5
            int r1 = -r1
            int r1 = -r1
            int r1 = -r1
            r5 = r2 | r1
            int r5 = r5 << 1
            r1 = r1 ^ r2
            int r5 = r5 - r1
            r1 = r5 ^ -3
            r2 = r5 & -3
            int r2 = r2 << 1
            int r2 = r2 + r1
            int r1 = setAppInviteOneLink
            int r1 = r1 + 121
            int r1 = r1 % 128
            setUserEmails = r1
            r1 = r4
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1lSDK.$$c(int, int, int):java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [boolean[], int, byte[]], vars: [r5v4 ?, r5v5 ?, r5v19 ?, r5v21 ?, r5v17 ?, r5v10 ?, r5v8 ?, r5v6 ?, r5v46 ?, r5v25 ?, r5v31 ?, r5v34 ?, r5v42 ?, r5v48 ?, r5v45 ?, r5v16 ?, r5v23 ?, r5v15 ?, r5v20 ?, r5v112 ?, r5v50 ?, r5v49 ?, r5v18 ?, r5v133 ?, r5v138 ?, r5v178 ?, r5v51 ?, r5v111 ?, r5v52 ?, r5v102 ?, r5v109 ?, r5v110 ?, r5v117 ?, r5v113 ?, r5v57 ?, r5v58 ?, r5v54 ?, r5v55 ?, r5v120 ?, r5v56 ?, r5v74 ?, r5v97 ?, r5v53 ?, r5v63 ?, r5v69 ?, r5v73 ?, r5v84 ?, r5v92 ?, r5v126 ?, r5v130 ?, r5v9 ?, r5v141 ?, r5v140 ?, r5v139 ?, r5v146 ?, r5v7 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    static {
        /*
            r1 = 12
            r2 = 66
            java.lang.Class<com.appsflyer.internal.AFb1lSDK> r8 = com.appsflyer.internal.AFb1lSDK.class
            r13 = 125(0x7d, float:1.75E-43)
            r16 = 31
            r3 = 128(0x80, float:1.794E-43)
            r4 = 2
            r5 = 0
            r6 = 1
            java.lang.Class<byte[]> r19 = byte[].class
            init$0()
            setCustomerUserId = r4
            setPhoneNumber = r5
            r20 = 4958500267301879894(0x44d021b8cb354056, double:3.047196883024817E23)
            setImeiData = r20
            r7 = 200(0xc8, float:2.8E-43)
            short r7 = (short) r7
            byte[] r21 = getOutOfStore     // Catch:{ Exception -> 0x0046 }
            byte r9 = r21[r2]     // Catch:{ Exception -> 0x0046 }
            byte r9 = (byte) r9     // Catch:{ Exception -> 0x0046 }
            r22 = 388(0x184, float:5.44E-43)
            byte r2 = r21[r22]     // Catch:{ Exception -> 0x0046 }
            byte r2 = (byte) r2     // Catch:{ Exception -> 0x0046 }
            java.lang.String r2 = $$c(r7, r9, r2)     // Catch:{ Exception -> 0x0046 }
            java.lang.Object r7 = setDebugLog     // Catch:{ Exception -> 0x0046 }
            r9 = 0
            if (r7 != 0) goto L_0x004a
            r7 = 986(0x3da, float:1.382E-42)
            short r7 = (short) r7     // Catch:{ Exception -> 0x0046 }
            r23 = 36
            byte r10 = r21[r23]     // Catch:{ Exception -> 0x0046 }
            int r10 = -r10
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x0046 }
            byte r11 = r21[r22]     // Catch:{ Exception -> 0x0046 }
            byte r11 = (byte) r11     // Catch:{ Exception -> 0x0046 }
            java.lang.String r7 = $$c(r7, r10, r11)     // Catch:{ Exception -> 0x0046 }
            goto L_0x004b
        L_0x0046:
            r0 = move-exception
            r1 = r0
            goto L_0x17c1
        L_0x004a:
            r7 = r9
        L_0x004b:
            r10 = 789(0x315, float:1.106E-42)
            short r10 = (short) r10
            r11 = 111(0x6f, float:1.56E-43)
            r24 = 136(0x88, float:1.9E-43)
            r15 = 896(0x380, float:1.256E-42)
            r25 = 447(0x1bf, float:6.26E-43)
            r26 = 553(0x229, float:7.75E-43)
            byte r14 = r21[r1]     // Catch:{ Exception -> 0x007e }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x007e }
            byte r1 = r21[r25]     // Catch:{ Exception -> 0x007e }
            byte r1 = (byte) r1     // Catch:{ Exception -> 0x007e }
            java.lang.String r1 = $$c(r10, r14, r1)     // Catch:{ Exception -> 0x007e }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x007e }
            byte r10 = r21[r3]     // Catch:{ Exception -> 0x007e }
            short r10 = (short) r10     // Catch:{ Exception -> 0x007e }
            byte r14 = r21[r16]     // Catch:{ Exception -> 0x007e }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x007e }
            byte r12 = r21[r22]     // Catch:{ Exception -> 0x007e }
            byte r12 = (byte) r12     // Catch:{ Exception -> 0x007e }
            java.lang.String r10 = $$c(r10, r14, r12)     // Catch:{ Exception -> 0x007e }
            java.lang.reflect.Method r1 = r1.getMethod(r10, r9)     // Catch:{ Exception -> 0x007e }
            java.lang.Object r1 = r1.invoke(r9, r9)     // Catch:{ Exception -> 0x007e }
            if (r1 == 0) goto L_0x007f
            goto L_0x00a5
        L_0x007e:
            r1 = r9
        L_0x007f:
            r10 = 492(0x1ec, float:6.9E-43)
            short r10 = (short) r10
            byte[] r12 = getOutOfStore     // Catch:{ Exception -> 0x00a5 }
            byte r14 = r12[r24]     // Catch:{ Exception -> 0x00a5 }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x00a5 }
            byte r5 = r12[r25]     // Catch:{ Exception -> 0x00a5 }
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r5 = $$c(r10, r14, r5)     // Catch:{ Exception -> 0x00a5 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ Exception -> 0x00a5 }
            short r10 = (short) r15     // Catch:{ Exception -> 0x00a5 }
            byte r14 = r12[r11]     // Catch:{ Exception -> 0x00a5 }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x00a5 }
            byte r12 = r12[r26]     // Catch:{ Exception -> 0x00a5 }
            byte r12 = (byte) r12     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r10 = $$c(r10, r14, r12)     // Catch:{ Exception -> 0x00a5 }
            java.lang.reflect.Method r5 = r5.getMethod(r10, r9)     // Catch:{ Exception -> 0x00a5 }
            java.lang.Object r1 = r5.invoke(r9, r9)     // Catch:{ Exception -> 0x00a5 }
        L_0x00a5:
            if (r1 == 0) goto L_0x00ca
            int r5 = setAppInviteOneLink
            int r5 = r5 + 109
            int r5 = r5 % r3
            setUserEmails = r5
            java.lang.Class r5 = r1.getClass()     // Catch:{ Exception -> 0x00ca }
            r10 = 240(0xf0, float:3.36E-43)
            short r10 = (short) r10     // Catch:{ Exception -> 0x00ca }
            byte[] r12 = getOutOfStore     // Catch:{ Exception -> 0x00ca }
            byte r14 = r12[r15]     // Catch:{ Exception -> 0x00ca }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x00ca }
            byte r12 = r12[r26]     // Catch:{ Exception -> 0x00ca }
            byte r12 = (byte) r12     // Catch:{ Exception -> 0x00ca }
            java.lang.String r10 = $$c(r10, r14, r12)     // Catch:{ Exception -> 0x00ca }
            java.lang.reflect.Method r5 = r5.getMethod(r10, r9)     // Catch:{ Exception -> 0x00ca }
            java.lang.Object r5 = r5.invoke(r1, r9)     // Catch:{ Exception -> 0x00ca }
            goto L_0x00cb
        L_0x00ca:
            r5 = r9
        L_0x00cb:
            if (r1 == 0) goto L_0x00f6
            int r10 = setUserEmails
            r12 = r10 | 113(0x71, float:1.58E-43)
            int r12 = r12 << r6
            r10 = r10 ^ 113(0x71, float:1.58E-43)
            int r12 = r12 - r10
            int r12 = r12 % r3
            setAppInviteOneLink = r12
            java.lang.Class r10 = r1.getClass()     // Catch:{ Exception -> 0x00f6 }
            r12 = 365(0x16d, float:5.11E-43)
            short r12 = (short) r12     // Catch:{ Exception -> 0x00f6 }
            byte[] r14 = getOutOfStore     // Catch:{ Exception -> 0x00f6 }
            r28 = 418(0x1a2, float:5.86E-43)
            byte r11 = r14[r28]     // Catch:{ Exception -> 0x00f6 }
            byte r11 = (byte) r11     // Catch:{ Exception -> 0x00f6 }
            byte r14 = r14[r26]     // Catch:{ Exception -> 0x00f6 }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r11 = $$c(r12, r11, r14)     // Catch:{ Exception -> 0x00f6 }
            java.lang.reflect.Method r10 = r10.getMethod(r11, r9)     // Catch:{ Exception -> 0x00f6 }
            java.lang.Object r10 = r10.invoke(r1, r9)     // Catch:{ Exception -> 0x00f6 }
            goto L_0x00f7
        L_0x00f6:
            r10 = r9
        L_0x00f7:
            if (r1 == 0) goto L_0x0115
            java.lang.Class r11 = r1.getClass()     // Catch:{ Exception -> 0x0115 }
            r12 = 260(0x104, float:3.64E-43)
            short r12 = (short) r12     // Catch:{ Exception -> 0x0115 }
            byte[] r14 = getOutOfStore     // Catch:{ Exception -> 0x0115 }
            byte r6 = r14[r15]     // Catch:{ Exception -> 0x0115 }
            byte r6 = (byte) r6     // Catch:{ Exception -> 0x0115 }
            byte r14 = r14[r26]     // Catch:{ Exception -> 0x0115 }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x0115 }
            java.lang.String r6 = $$c(r12, r6, r14)     // Catch:{ Exception -> 0x0115 }
            java.lang.reflect.Method r6 = r11.getMethod(r6, r9)     // Catch:{ Exception -> 0x0115 }
            java.lang.Object r1 = r6.invoke(r1, r9)     // Catch:{ Exception -> 0x0115 }
            goto L_0x0116
        L_0x0115:
            r1 = r9
        L_0x0116:
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r11 = 44
            r12 = 623(0x26f, float:8.73E-43)
            if (r5 == 0) goto L_0x011f
            goto L_0x0179
        L_0x011f:
            if (r7 != 0) goto L_0x0134
            int r5 = setUserEmails
            r7 = r5 & 125(0x7d, float:1.75E-43)
            r5 = r5 | r13
            int r7 = r7 + r5
            int r5 = r7 % 128
            setAppInviteOneLink = r5
            int r7 = r7 % r4
            if (r7 == 0) goto L_0x0130
            r5 = r9
            goto L_0x0179
        L_0x0130:
            throw r9     // Catch:{ all -> 0x0131 }
        L_0x0131:
            r0 = move-exception
            r1 = r0
            throw r1
        L_0x0134:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0046 }
            r5.<init>()     // Catch:{ Exception -> 0x0046 }
            r14 = 658(0x292, float:9.22E-43)
            short r14 = (short) r14     // Catch:{ Exception -> 0x0046 }
            byte[] r29 = getOutOfStore     // Catch:{ Exception -> 0x0046 }
            byte r3 = r29[r15]     // Catch:{ Exception -> 0x0046 }
            byte r3 = (byte) r3     // Catch:{ Exception -> 0x0046 }
            r30 = 407(0x197, float:5.7E-43)
            byte r4 = r29[r30]     // Catch:{ Exception -> 0x0046 }
            byte r4 = (byte) r4     // Catch:{ Exception -> 0x0046 }
            java.lang.String r3 = $$c(r14, r3, r4)     // Catch:{ Exception -> 0x0046 }
            r5.append(r3)     // Catch:{ Exception -> 0x0046 }
            r5.append(r7)     // Catch:{ Exception -> 0x0046 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x0046 }
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x17b7 }
            r4 = 0
            r5[r4] = r3     // Catch:{ all -> 0x17b7 }
            r3 = 916(0x394, float:1.284E-42)
            short r3 = (short) r3     // Catch:{ all -> 0x17b7 }
            byte r4 = r29[r11]     // Catch:{ all -> 0x17b7 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x17b7 }
            byte r7 = r29[r12]     // Catch:{ all -> 0x17b7 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x17b7 }
            java.lang.String r3 = $$c(r3, r4, r7)     // Catch:{ all -> 0x17b7 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x17b7 }
            r4 = 1
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ all -> 0x17b7 }
            r4 = 0
            r7[r4] = r6     // Catch:{ all -> 0x17b7 }
            java.lang.reflect.Constructor r3 = r3.getDeclaredConstructor(r7)     // Catch:{ all -> 0x17b7 }
            java.lang.Object r5 = r3.newInstance(r5)     // Catch:{ all -> 0x17b7 }
        L_0x0179:
            if (r1 == 0) goto L_0x017c
            goto L_0x01e1
        L_0x017c:
            r1 = 752(0x2f0, float:1.054E-42)
            short r1 = (short) r1
            byte[] r3 = getOutOfStore     // Catch:{ Exception -> 0x0046 }
            byte r4 = r3[r25]     // Catch:{ Exception -> 0x0046 }
            byte r4 = (byte) r4     // Catch:{ Exception -> 0x0046 }
            byte r7 = r3[r12]     // Catch:{ Exception -> 0x0046 }
            byte r7 = (byte) r7     // Catch:{ Exception -> 0x0046 }
            java.lang.String r1 = $$c(r1, r4, r7)     // Catch:{ Exception -> 0x0046 }
            r4 = 1
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ all -> 0x17ad }
            r4 = 0
            r7[r4] = r1     // Catch:{ all -> 0x17ad }
            byte r1 = r3[r13]     // Catch:{ all -> 0x17ad }
            short r1 = (short) r1     // Catch:{ all -> 0x17ad }
            byte r4 = r3[r22]     // Catch:{ all -> 0x17ad }
            byte r4 = (byte) r4     // Catch:{ all -> 0x17ad }
            byte r14 = r3[r12]     // Catch:{ all -> 0x17ad }
            byte r14 = (byte) r14     // Catch:{ all -> 0x17ad }
            java.lang.String r1 = $$c(r1, r4, r14)     // Catch:{ all -> 0x17ad }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x17ad }
            r4 = 765(0x2fd, float:1.072E-42)
            short r4 = (short) r4     // Catch:{ all -> 0x17ad }
            byte r14 = r3[r15]     // Catch:{ all -> 0x17ad }
            byte r14 = (byte) r14     // Catch:{ all -> 0x17ad }
            byte r15 = r3[r26]     // Catch:{ all -> 0x17ad }
            byte r15 = (byte) r15     // Catch:{ all -> 0x17ad }
            java.lang.String r4 = $$c(r4, r14, r15)     // Catch:{ all -> 0x17ad }
            r14 = 1
            java.lang.Class[] r15 = new java.lang.Class[r14]     // Catch:{ all -> 0x17ad }
            r21 = 0
            r15[r21] = r6     // Catch:{ all -> 0x17ad }
            java.lang.reflect.Method r1 = r1.getMethod(r4, r15)     // Catch:{ all -> 0x17ad }
            java.lang.Object r1 = r1.invoke(r9, r7)     // Catch:{ all -> 0x17ad }
            java.lang.Object[] r4 = new java.lang.Object[r14]     // Catch:{ all -> 0x17a3 }
            r4[r21] = r1     // Catch:{ all -> 0x17a3 }
            r1 = 916(0x394, float:1.284E-42)
            short r1 = (short) r1     // Catch:{ all -> 0x17a3 }
            byte r7 = r3[r11]     // Catch:{ all -> 0x17a3 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x17a3 }
            byte r3 = r3[r12]     // Catch:{ all -> 0x17a3 }
            byte r3 = (byte) r3     // Catch:{ all -> 0x17a3 }
            java.lang.String r1 = $$c(r1, r7, r3)     // Catch:{ all -> 0x17a3 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x17a3 }
            r3 = 1
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ all -> 0x17a3 }
            r3 = 0
            r7[r3] = r6     // Catch:{ all -> 0x17a3 }
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r7)     // Catch:{ all -> 0x17a3 }
            java.lang.Object r1 = r1.newInstance(r4)     // Catch:{ all -> 0x17a3 }
        L_0x01e1:
            if (r10 != 0) goto L_0x0239
            if (r5 == 0) goto L_0x0239
            r3 = 325(0x145, float:4.55E-43)
            short r3 = (short) r3
            byte[] r4 = getOutOfStore     // Catch:{ Exception -> 0x0046 }
            r7 = 0
            byte r10 = r4[r7]     // Catch:{ Exception -> 0x0046 }
            byte r7 = (byte) r10     // Catch:{ Exception -> 0x0046 }
            byte r10 = r4[r22]     // Catch:{ Exception -> 0x0046 }
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x0046 }
            java.lang.String r3 = $$c(r3, r7, r10)     // Catch:{ Exception -> 0x0046 }
            r7 = 2
            java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ all -> 0x022f }
            r7 = 1
            r10[r7] = r3     // Catch:{ all -> 0x022f }
            r3 = 0
            r10[r3] = r5     // Catch:{ all -> 0x022f }
            r3 = 916(0x394, float:1.284E-42)
            short r3 = (short) r3     // Catch:{ all -> 0x022f }
            byte r7 = r4[r11]     // Catch:{ all -> 0x022f }
            byte r7 = (byte) r7     // Catch:{ all -> 0x022f }
            byte r14 = r4[r12]     // Catch:{ all -> 0x022f }
            byte r14 = (byte) r14     // Catch:{ all -> 0x022f }
            java.lang.String r7 = $$c(r3, r7, r14)     // Catch:{ all -> 0x022f }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x022f }
            byte r14 = r4[r11]     // Catch:{ all -> 0x022f }
            byte r14 = (byte) r14     // Catch:{ all -> 0x022f }
            byte r4 = r4[r12]     // Catch:{ all -> 0x022f }
            byte r4 = (byte) r4     // Catch:{ all -> 0x022f }
            java.lang.String r3 = $$c(r3, r14, r4)     // Catch:{ all -> 0x022f }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x022f }
            r4 = 2
            java.lang.Class[] r14 = new java.lang.Class[r4]     // Catch:{ all -> 0x022f }
            r4 = 0
            r14[r4] = r3     // Catch:{ all -> 0x022f }
            r3 = 1
            r14[r3] = r6     // Catch:{ all -> 0x022f }
            java.lang.reflect.Constructor r3 = r7.getDeclaredConstructor(r14)     // Catch:{ all -> 0x022f }
            java.lang.Object r10 = r3.newInstance(r10)     // Catch:{ all -> 0x022f }
            goto L_0x0239
        L_0x022f:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x0046 }
            if (r2 == 0) goto L_0x0238
            throw r2     // Catch:{ Exception -> 0x0046 }
        L_0x0238:
            throw r1     // Catch:{ Exception -> 0x0046 }
        L_0x0239:
            r3 = 595(0x253, float:8.34E-43)
            short r3 = (short) r3
            byte[] r4 = getOutOfStore     // Catch:{ all -> 0x1799 }
            byte r7 = r4[r24]     // Catch:{ all -> 0x1799 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x1799 }
            byte r14 = r4[r25]     // Catch:{ all -> 0x1799 }
            byte r14 = (byte) r14     // Catch:{ all -> 0x1799 }
            java.lang.String r3 = $$c(r3, r7, r14)     // Catch:{ all -> 0x1799 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x1799 }
            r7 = 513(0x201, float:7.19E-43)
            short r7 = (short) r7     // Catch:{ all -> 0x1799 }
            r14 = 2
            byte r15 = r4[r14]     // Catch:{ all -> 0x1799 }
            byte r14 = (byte) r15     // Catch:{ all -> 0x1799 }
            byte r15 = r4[r26]     // Catch:{ all -> 0x1799 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x1799 }
            java.lang.String r7 = $$c(r7, r14, r15)     // Catch:{ all -> 0x1799 }
            java.lang.reflect.Method r3 = r3.getMethod(r7, r9)     // Catch:{ all -> 0x1799 }
            java.lang.Object r3 = r3.invoke(r9, r9)     // Catch:{ all -> 0x1799 }
            r7 = 916(0x394, float:1.284E-42)
            short r7 = (short) r7
            byte r14 = r4[r11]     // Catch:{ Exception -> 0x0046 }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x0046 }
            byte r15 = r4[r12]     // Catch:{ Exception -> 0x0046 }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x0046 }
            java.lang.String r14 = $$c(r7, r14, r15)     // Catch:{ Exception -> 0x0046 }
            java.lang.Class r14 = java.lang.Class.forName(r14)     // Catch:{ Exception -> 0x0046 }
            r15 = 9
            java.lang.Object r14 = java.lang.reflect.Array.newInstance(r14, r15)     // Catch:{ Exception -> 0x0046 }
            java.lang.Object[] r14 = (java.lang.Object[]) r14     // Catch:{ Exception -> 0x0046 }
            r15 = 0
            r14[r15] = r9     // Catch:{ Exception -> 0x0046 }
            r15 = 1
            r14[r15] = r10     // Catch:{ Exception -> 0x0046 }
            r15 = 2
            r14[r15] = r5     // Catch:{ Exception -> 0x0046 }
            r15 = 3
            r14[r15] = r1     // Catch:{ Exception -> 0x0046 }
            r15 = 4
            r14[r15] = r3     // Catch:{ Exception -> 0x0046 }
            r15 = 5
            r14[r15] = r10     // Catch:{ Exception -> 0x0046 }
            r10 = 6
            r14[r10] = r5     // Catch:{ Exception -> 0x0046 }
            r5 = 7
            r14[r5] = r1     // Catch:{ Exception -> 0x0046 }
            r1 = 8
            r14[r1] = r3     // Catch:{ Exception -> 0x0046 }
            r1 = 9
            boolean[] r3 = new boolean[r1]     // Catch:{ Exception -> 0x0046 }
            r3 = {0, 1, 1, 1, 1, 1, 1, 1, 1} // fill-array     // Catch:{ Exception -> 0x0046 }
            boolean[] r5 = new boolean[r1]     // Catch:{ Exception -> 0x0046 }
            r5 = {0, 0, 0, 0, 0, 1, 1, 1, 1} // fill-array     // Catch:{ Exception -> 0x0046 }
            boolean[] r10 = new boolean[r1]     // Catch:{ Exception -> 0x0046 }
            r1 = 0
            r10[r1] = r1     // Catch:{ Exception -> 0x0046 }
            r15 = 1
            r10[r15] = r1     // Catch:{ Exception -> 0x0046 }
            r21 = 2
            r10[r21] = r15     // Catch:{ Exception -> 0x0046 }
            r21 = 3
            r10[r21] = r15     // Catch:{ Exception -> 0x0046 }
            r21 = 4
            r10[r21] = r1     // Catch:{ Exception -> 0x0046 }
            r21 = 5
            r10[r21] = r1     // Catch:{ Exception -> 0x0046 }
            r21 = 6
            r10[r21] = r15     // Catch:{ Exception -> 0x0046 }
            r21 = 7
            r10[r21] = r15     // Catch:{ Exception -> 0x0046 }
            r15 = 8
            r10[r15] = r1     // Catch:{ Exception -> 0x0046 }
            r1 = 21
            int r15 = waitForCustomerUserId     // Catch:{ ClassNotFoundException -> 0x034d }
            r15 = r15 | 81
            short r15 = (short) r15     // Catch:{ ClassNotFoundException -> 0x034d }
            byte r9 = r4[r1]     // Catch:{ ClassNotFoundException -> 0x034d }
            byte r9 = (byte) r9     // Catch:{ ClassNotFoundException -> 0x034d }
            byte r12 = r4[r25]     // Catch:{ ClassNotFoundException -> 0x034d }
            byte r12 = (byte) r12     // Catch:{ ClassNotFoundException -> 0x034d }
            java.lang.String r9 = $$c(r15, r9, r12)     // Catch:{ ClassNotFoundException -> 0x034d }
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ ClassNotFoundException -> 0x034d }
            r12 = 693(0x2b5, float:9.71E-43)
            short r12 = (short) r12     // Catch:{ ClassNotFoundException -> 0x034d }
            r15 = 568(0x238, float:7.96E-43)
            byte r15 = r4[r15]     // Catch:{ ClassNotFoundException -> 0x034d }
            byte r15 = (byte) r15     // Catch:{ ClassNotFoundException -> 0x034d }
            r32 = 198(0xc6, float:2.77E-43)
            byte r4 = r4[r32]     // Catch:{ ClassNotFoundException -> 0x034d }
            byte r4 = (byte) r4     // Catch:{ ClassNotFoundException -> 0x034d }
            java.lang.String r4 = $$c(r12, r15, r4)     // Catch:{ ClassNotFoundException -> 0x034d }
            java.lang.reflect.Field r4 = r9.getDeclaredField(r4)     // Catch:{ ClassNotFoundException -> 0x034d }
            int r4 = r4.getInt(r9)     // Catch:{ ClassNotFoundException -> 0x034d }
            r9 = 29
            if (r4 != r9) goto L_0x02fa
            goto L_0x0302
        L_0x02fa:
            r9 = 26
            if (r4 < r9) goto L_0x0302
            r9 = 0
            r21 = 1
            goto L_0x0305
        L_0x0302:
            r9 = 0
            r21 = 0
        L_0x0305:
            r10[r9] = r21     // Catch:{ ClassNotFoundException -> 0x034d }
            r9 = 1
            if (r4 < r1) goto L_0x030d
            r28 = 1
            goto L_0x030f
        L_0x030d:
            r28 = 0
        L_0x030f:
            r10[r9] = r28     // Catch:{ ClassNotFoundException -> 0x034d }
            if (r4 < r1) goto L_0x0323
            int r12 = setAppInviteOneLink
            r15 = r12 ^ 119(0x77, float:1.67E-43)
            r12 = r12 & 119(0x77, float:1.67E-43)
            int r12 = r12 << r9
            int r15 = r15 + r12
            r9 = 128(0x80, float:1.794E-43)
            int r15 = r15 % r9
            setUserEmails = r15
            r9 = 1
        L_0x0321:
            r12 = 5
            goto L_0x0325
        L_0x0323:
            r9 = 0
            goto L_0x0321
        L_0x0325:
            r10[r12] = r9     // Catch:{ ClassNotFoundException -> 0x034d }
            r9 = 16
            if (r4 >= r9) goto L_0x033c
            int r9 = setAppInviteOneLink
            r12 = r9 & 31
            r9 = r9 | 31
            int r12 = r12 + r9
            r9 = 128(0x80, float:1.794E-43)
            int r15 = r12 % 128
            setUserEmails = r15
            r9 = 2
            int r12 = r12 % r9
            if (r12 == 0) goto L_0x033e
        L_0x033c:
            r9 = 0
            goto L_0x033f
        L_0x033e:
            r9 = 1
        L_0x033f:
            r12 = 4
            r10[r12] = r9     // Catch:{ ClassNotFoundException -> 0x034d }
            r9 = 16
            if (r4 >= r9) goto L_0x0348
            r4 = 1
            goto L_0x0349
        L_0x0348:
            r4 = 0
        L_0x0349:
            r9 = 8
            r10[r9] = r4     // Catch:{ ClassNotFoundException -> 0x034d }
        L_0x034d:
            r4 = 0
            r9 = 0
        L_0x034f:
            if (r4 != 0) goto L_0x1798
            int r12 = setAppInviteOneLink
            r15 = r12 ^ 119(0x77, float:1.67E-43)
            r12 = r12 & 119(0x77, float:1.67E-43)
            r28 = 1
            int r12 = r12 << 1
            int r15 = r15 + r12
            r12 = 128(0x80, float:1.794E-43)
            int r1 = r15 % 128
            setUserEmails = r1
            r1 = 2
            int r15 = r15 % r1
            if (r15 == 0) goto L_0x0369
            if (r9 >= r13) goto L_0x1798
            goto L_0x036d
        L_0x0369:
            r1 = 9
            if (r9 >= r1) goto L_0x1798
        L_0x036d:
            boolean r1 = r10[r9]     // Catch:{ Exception -> 0x0046 }
            if (r1 == 0) goto L_0x175c
            boolean r12 = r3[r9]     // Catch:{ all -> 0x16c7 }
            r15 = r14[r9]     // Catch:{ all -> 0x16c7 }
            boolean r33 = r5[r9]     // Catch:{ all -> 0x16c7 }
            r34 = 375(0x177, float:5.25E-43)
            if (r12 == 0) goto L_0x045d
            if (r15 == 0) goto L_0x03d8
            byte[] r35 = getOutOfStore     // Catch:{ all -> 0x03b8 }
            byte r1 = r35[r11]     // Catch:{ all -> 0x03b8 }
            byte r1 = (byte) r1     // Catch:{ all -> 0x03b8 }
            r31 = 623(0x26f, float:8.73E-43)
            byte r11 = r35[r31]     // Catch:{ all -> 0x03b8 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x03b8 }
            java.lang.String r1 = $$c(r7, r1, r11)     // Catch:{ all -> 0x03b8 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x03b8 }
            r11 = 843(0x34b, float:1.181E-42)
            short r11 = (short) r11     // Catch:{ all -> 0x03b8 }
            r36 = 888(0x378, float:1.244E-42)
            byte r13 = r35[r36]     // Catch:{ all -> 0x03b8 }
            byte r13 = (byte) r13
            r36 = r2
            byte r2 = r35[r22]     // Catch:{ all -> 0x03b5 }
            byte r2 = (byte) r2     // Catch:{ all -> 0x03b5 }
            java.lang.String r2 = $$c(r11, r13, r2)     // Catch:{ all -> 0x03b5 }
            r11 = 0
            java.lang.reflect.Method r1 = r1.getMethod(r2, r11)     // Catch:{ all -> 0x03b5 }
            java.lang.Object r1 = r1.invoke(r15, r11)     // Catch:{ all -> 0x03b5 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x03b5 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x03b5 }
            if (r1 == 0) goto L_0x03da
        L_0x03b1:
            r35 = r3
            goto L_0x0461
        L_0x03b5:
            r0 = move-exception
        L_0x03b6:
            r1 = r0
            goto L_0x03bc
        L_0x03b8:
            r0 = move-exception
            r36 = r2
            goto L_0x03b6
        L_0x03bc:
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x03c3 }
            if (r2 == 0) goto L_0x03d7
            throw r2     // Catch:{ all -> 0x03c3 }
        L_0x03c3:
            r0 = move-exception
            r1 = r0
            r35 = r3
        L_0x03c7:
            r37 = r4
            r41 = r5
            r5 = r8
            r47 = r9
            r42 = r10
            r39 = r14
        L_0x03d2:
            r2 = 1
            r13 = 12
            goto L_0x16d9
        L_0x03d7:
            throw r1     // Catch:{ all -> 0x03c3 }
        L_0x03d8:
            r36 = r2
        L_0x03da:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0459 }
            r1.<init>()     // Catch:{ all -> 0x0459 }
            r2 = 404(0x194, float:5.66E-43)
            short r2 = (short) r2     // Catch:{ all -> 0x0459 }
            byte[] r11 = getOutOfStore     // Catch:{ all -> 0x0459 }
            byte r12 = r11[r34]     // Catch:{ all -> 0x0459 }
            byte r12 = (byte) r12
            r35 = r3
            r13 = 190(0xbe, float:2.66E-43)
            byte r3 = r11[r13]     // Catch:{ all -> 0x0454 }
            byte r3 = (byte) r3     // Catch:{ all -> 0x0454 }
            java.lang.String r2 = $$c(r2, r12, r3)     // Catch:{ all -> 0x0454 }
            r1.append(r2)     // Catch:{ all -> 0x0454 }
            r1.append(r15)     // Catch:{ all -> 0x0454 }
            r2 = 305(0x131, float:4.27E-43)
            short r2 = (short) r2     // Catch:{ all -> 0x0454 }
            int r3 = waitForCustomerUserId     // Catch:{ all -> 0x0454 }
            r12 = 1
            r13 = r3 ^ 1
            r3 = r3 & r12
            int r3 = r3 << r12
            int r13 = r13 + r3
            byte r3 = (byte) r13     // Catch:{ all -> 0x0454 }
            r12 = 78
            byte r12 = (byte) r12     // Catch:{ all -> 0x0454 }
            java.lang.String r2 = $$c(r2, r3, r12)     // Catch:{ all -> 0x0454 }
            r1.append(r2)     // Catch:{ all -> 0x0454 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0454 }
            int r2 = setUserEmails
            r3 = r2 ^ 77
            r2 = r2 & 77
            r12 = 1
            int r2 = r2 << r12
            int r3 = r3 + r2
            r2 = 128(0x80, float:1.794E-43)
            int r3 = r3 % r2
            setAppInviteOneLink = r3
            java.lang.Object[] r2 = new java.lang.Object[r12]     // Catch:{ all -> 0x044b }
            r3 = 0
            r2[r3] = r1     // Catch:{ all -> 0x044b }
            r1 = 850(0x352, float:1.191E-42)
            short r3 = (short) r1     // Catch:{ all -> 0x044b }
            r1 = 15
            byte r12 = r11[r1]     // Catch:{ all -> 0x044b }
            byte r1 = (byte) r12     // Catch:{ all -> 0x044b }
            r12 = 623(0x26f, float:8.73E-43)
            byte r11 = r11[r12]     // Catch:{ all -> 0x044b }
            byte r11 = (byte) r11     // Catch:{ all -> 0x044b }
            java.lang.String r1 = $$c(r3, r1, r11)     // Catch:{ all -> 0x044b }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x044b }
            r3 = 1
            java.lang.Class[] r11 = new java.lang.Class[r3]     // Catch:{ all -> 0x044b }
            r3 = 0
            r11[r3] = r6     // Catch:{ all -> 0x044b }
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r11)     // Catch:{ all -> 0x044b }
            java.lang.Object r1 = r1.newInstance(r2)     // Catch:{ all -> 0x044b }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x044b }
            throw r1     // Catch:{ all -> 0x044b }
        L_0x044b:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0454 }
            if (r2 == 0) goto L_0x0458
            throw r2     // Catch:{ all -> 0x0454 }
        L_0x0454:
            r0 = move-exception
        L_0x0455:
            r1 = r0
            goto L_0x03c7
        L_0x0458:
            throw r1     // Catch:{ all -> 0x0454 }
        L_0x0459:
            r0 = move-exception
            r35 = r3
            goto L_0x0455
        L_0x045d:
            r36 = r2
            goto L_0x03b1
        L_0x0461:
            if (r12 == 0) goto L_0x07d7
            java.util.Random r3 = new java.util.Random     // Catch:{ all -> 0x07d3 }
            r3.<init>()     // Catch:{ all -> 0x07d3 }
            int r11 = setAppInviteOneLink
            r13 = r11 | 121(0x79, float:1.7E-43)
            r28 = 1
            int r13 = r13 << 1
            r11 = r11 ^ 121(0x79, float:1.7E-43)
            int r13 = r13 - r11
            r11 = 128(0x80, float:1.794E-43)
            int r13 = r13 % r11
            setUserEmails = r13
            byte[] r11 = getOutOfStore     // Catch:{ all -> 0x07c7 }
            r13 = 125(0x7d, float:1.75E-43)
            byte r1 = r11[r13]     // Catch:{ all -> 0x07c7 }
            short r1 = (short) r1     // Catch:{ all -> 0x07c7 }
            byte r13 = r11[r22]     // Catch:{ all -> 0x07c7 }
            byte r13 = (byte) r13     // Catch:{ all -> 0x07c7 }
            r31 = 623(0x26f, float:8.73E-43)
            byte r2 = r11[r31]     // Catch:{ all -> 0x07c7 }
            byte r2 = (byte) r2     // Catch:{ all -> 0x07c7 }
            java.lang.String r1 = $$c(r1, r13, r2)     // Catch:{ all -> 0x07c7 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x07c7 }
            int r2 = waitForCustomerUserId     // Catch:{ all -> 0x07c7 }
            r13 = r2 ^ 897(0x381, float:1.257E-42)
            r2 = r2 & 897(0x381, float:1.257E-42)
            r2 = r2 | r13
            short r2 = (short) r2
            r37 = r4
            r13 = 410(0x19a, float:5.75E-43)
            byte r4 = r11[r13]     // Catch:{ all -> 0x07be }
            byte r4 = (byte) r4     // Catch:{ all -> 0x07be }
            byte r11 = r11[r22]     // Catch:{ all -> 0x07be }
            byte r11 = (byte) r11     // Catch:{ all -> 0x07be }
            java.lang.String r2 = $$c(r2, r4, r11)     // Catch:{ all -> 0x07be }
            r4 = 0
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ all -> 0x07be }
            java.lang.Object r1 = r1.invoke(r4, r4)     // Catch:{ all -> 0x07be }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x07be }
            long r1 = r1.longValue()     // Catch:{ all -> 0x07be }
            r38 = -1588804091(0xffffffffa14cc605, double:NaN)
            long r1 = r1 ^ r38
            r3.setSeed(r1)     // Catch:{ all -> 0x07aa }
            r1 = 0
            r2 = 0
            r4 = 0
            r11 = 0
        L_0x04c0:
            if (r1 != 0) goto L_0x07ae
            if (r2 != 0) goto L_0x04d5
            int r13 = setAppInviteOneLink
            r38 = r13 & 51
            r13 = r13 | 51
            int r13 = r38 + r13
            r38 = r1
            r1 = 128(0x80, float:1.794E-43)
            int r13 = r13 % r1
            setUserEmails = r13
            r1 = 6
            goto L_0x04e0
        L_0x04d5:
            r38 = r1
            if (r4 != 0) goto L_0x04db
            r1 = 5
            goto L_0x04e0
        L_0x04db:
            if (r11 != 0) goto L_0x04df
            r1 = 4
            goto L_0x04e0
        L_0x04df:
            r1 = 3
        L_0x04e0:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x07aa }
            r28 = 1
            r39 = r1 | 1
            int r39 = r39 << 1
            r40 = r1 ^ 1
            r41 = r5
            int r5 = r39 - r40
            r13.<init>(r5)     // Catch:{ all -> 0x07a3 }
            r5 = 46
            r13.append(r5)     // Catch:{ all -> 0x07a3 }
            r5 = 0
        L_0x04f7:
            if (r5 >= r1) goto L_0x0558
            int r39 = setUserEmails
            r40 = r1
            int r1 = r39 + 99
            r42 = r10
            r39 = r14
            r14 = 128(0x80, float:1.794E-43)
            int r10 = r1 % 128
            setAppInviteOneLink = r10
            r10 = 2
            int r1 = r1 % r10
            if (r1 == 0) goto L_0x0556
            if (r33 == 0) goto L_0x0541
            r1 = 26
            int r1 = r3.nextInt(r1)     // Catch:{ all -> 0x053a }
            boolean r10 = r3.nextBoolean()     // Catch:{ all -> 0x053a }
            if (r10 == 0) goto L_0x052b
            int r1 = ~r1
            int r1 = 64 - r1
            int r10 = setUserEmails
            r14 = r10 & 103(0x67, float:1.44E-43)
            r10 = r10 | 103(0x67, float:1.44E-43)
            int r14 = r14 + r10
            r10 = 128(0x80, float:1.794E-43)
            int r14 = r14 % r10
            setAppInviteOneLink = r14
            goto L_0x0534
        L_0x052b:
            int r1 = -r1
            int r1 = -r1
            r10 = r1 ^ 96
            r1 = r1 & 96
            r14 = 1
            int r1 = r1 << r14
            int r1 = r1 + r10
        L_0x0534:
            char r1 = (char) r1
            r13.append(r1)     // Catch:{ all -> 0x053a }
        L_0x0538:
            r1 = 1
            goto L_0x054e
        L_0x053a:
            r0 = move-exception
        L_0x053b:
            r1 = r0
            r5 = r8
            r47 = r9
            goto L_0x03d2
        L_0x0541:
            r1 = 12
            int r10 = r3.nextInt(r1)     // Catch:{ all -> 0x053a }
            int r10 = r10 + 8192
            char r1 = (char) r10     // Catch:{ all -> 0x053a }
            r13.append(r1)     // Catch:{ all -> 0x053a }
            goto L_0x0538
        L_0x054e:
            int r5 = r5 + r1
            r14 = r39
            r1 = r40
            r10 = r42
            goto L_0x04f7
        L_0x0556:
            r1 = 0
            throw r1     // Catch:{ all -> 0x053a }
        L_0x0558:
            r42 = r10
            r39 = r14
            java.lang.String r1 = r13.toString()     // Catch:{ all -> 0x053a }
            if (r2 != 0) goto L_0x05bc
            int r2 = setUserEmails
            r5 = r2 | 75
            r10 = 1
            int r5 = r5 << r10
            r2 = r2 ^ 75
            int r5 = r5 - r2
            r2 = 128(0x80, float:1.794E-43)
            int r5 = r5 % r2
            setAppInviteOneLink = r5
            r2 = 2
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x05b2 }
            r5[r10] = r1     // Catch:{ all -> 0x05b2 }
            r1 = 0
            r5[r1] = r15     // Catch:{ all -> 0x05b2 }
            byte[] r1 = getOutOfStore     // Catch:{ all -> 0x05b2 }
            r2 = 44
            byte r10 = r1[r2]     // Catch:{ all -> 0x05b2 }
            byte r10 = (byte) r10     // Catch:{ all -> 0x05b2 }
            r13 = 623(0x26f, float:8.73E-43)
            byte r14 = r1[r13]     // Catch:{ all -> 0x05b2 }
            byte r14 = (byte) r14     // Catch:{ all -> 0x05b2 }
            java.lang.String r10 = $$c(r7, r10, r14)     // Catch:{ all -> 0x05b2 }
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ all -> 0x05b2 }
            byte r14 = r1[r2]     // Catch:{ all -> 0x05b2 }
            byte r2 = (byte) r14     // Catch:{ all -> 0x05b2 }
            byte r1 = r1[r13]     // Catch:{ all -> 0x05b2 }
            byte r1 = (byte) r1     // Catch:{ all -> 0x05b2 }
            java.lang.String r1 = $$c(r7, r2, r1)     // Catch:{ all -> 0x05b2 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x05b2 }
            r2 = 2
            java.lang.Class[] r13 = new java.lang.Class[r2]     // Catch:{ all -> 0x05b2 }
            r2 = 0
            r13[r2] = r1     // Catch:{ all -> 0x05b2 }
            r1 = 1
            r13[r1] = r6     // Catch:{ all -> 0x05b2 }
            java.lang.reflect.Constructor r1 = r10.getDeclaredConstructor(r13)     // Catch:{ all -> 0x05b2 }
            java.lang.Object r1 = r1.newInstance(r5)     // Catch:{ all -> 0x05b2 }
            r2 = r1
        L_0x05ac:
            r43 = r3
            r1 = r38
            goto L_0x0705
        L_0x05b2:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x053a }
            if (r2 == 0) goto L_0x05bb
            throw r2     // Catch:{ all -> 0x053a }
        L_0x05bb:
            throw r1     // Catch:{ all -> 0x053a }
        L_0x05bc:
            if (r4 != 0) goto L_0x0606
            r5 = 2
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ all -> 0x05fc }
            r5 = 1
            r4[r5] = r1     // Catch:{ all -> 0x05fc }
            r1 = 0
            r4[r1] = r15     // Catch:{ all -> 0x05fc }
            byte[] r1 = getOutOfStore     // Catch:{ all -> 0x05fc }
            r5 = 44
            byte r10 = r1[r5]     // Catch:{ all -> 0x05fc }
            byte r10 = (byte) r10     // Catch:{ all -> 0x05fc }
            r13 = 623(0x26f, float:8.73E-43)
            byte r14 = r1[r13]     // Catch:{ all -> 0x05fc }
            byte r14 = (byte) r14     // Catch:{ all -> 0x05fc }
            java.lang.String r10 = $$c(r7, r10, r14)     // Catch:{ all -> 0x05fc }
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ all -> 0x05fc }
            byte r14 = r1[r5]     // Catch:{ all -> 0x05fc }
            byte r5 = (byte) r14     // Catch:{ all -> 0x05fc }
            byte r1 = r1[r13]     // Catch:{ all -> 0x05fc }
            byte r1 = (byte) r1     // Catch:{ all -> 0x05fc }
            java.lang.String r1 = $$c(r7, r5, r1)     // Catch:{ all -> 0x05fc }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x05fc }
            r5 = 2
            java.lang.Class[] r13 = new java.lang.Class[r5]     // Catch:{ all -> 0x05fc }
            r5 = 0
            r13[r5] = r1     // Catch:{ all -> 0x05fc }
            r1 = 1
            r13[r1] = r6     // Catch:{ all -> 0x05fc }
            java.lang.reflect.Constructor r1 = r10.getDeclaredConstructor(r13)     // Catch:{ all -> 0x05fc }
            java.lang.Object r1 = r1.newInstance(r4)     // Catch:{ all -> 0x05fc }
            r4 = r1
            goto L_0x05ac
        L_0x05fc:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x053a }
            if (r2 == 0) goto L_0x0605
            throw r2     // Catch:{ all -> 0x053a }
        L_0x0605:
            throw r1     // Catch:{ all -> 0x053a }
        L_0x0606:
            if (r11 != 0) goto L_0x0651
            r5 = 2
            java.lang.Object[] r10 = new java.lang.Object[r5]     // Catch:{ all -> 0x0647 }
            r5 = 1
            r10[r5] = r1     // Catch:{ all -> 0x0647 }
            r1 = 0
            r10[r1] = r15     // Catch:{ all -> 0x0647 }
            byte[] r1 = getOutOfStore     // Catch:{ all -> 0x0647 }
            r5 = 44
            byte r11 = r1[r5]     // Catch:{ all -> 0x0647 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x0647 }
            r13 = 623(0x26f, float:8.73E-43)
            byte r14 = r1[r13]     // Catch:{ all -> 0x0647 }
            byte r14 = (byte) r14     // Catch:{ all -> 0x0647 }
            java.lang.String r11 = $$c(r7, r11, r14)     // Catch:{ all -> 0x0647 }
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch:{ all -> 0x0647 }
            byte r14 = r1[r5]     // Catch:{ all -> 0x0647 }
            byte r5 = (byte) r14     // Catch:{ all -> 0x0647 }
            byte r1 = r1[r13]     // Catch:{ all -> 0x0647 }
            byte r1 = (byte) r1     // Catch:{ all -> 0x0647 }
            java.lang.String r1 = $$c(r7, r5, r1)     // Catch:{ all -> 0x0647 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0647 }
            r5 = 2
            java.lang.Class[] r13 = new java.lang.Class[r5]     // Catch:{ all -> 0x0647 }
            r5 = 0
            r13[r5] = r1     // Catch:{ all -> 0x0647 }
            r1 = 1
            r13[r1] = r6     // Catch:{ all -> 0x0647 }
            java.lang.reflect.Constructor r1 = r11.getDeclaredConstructor(r13)     // Catch:{ all -> 0x0647 }
            java.lang.Object r1 = r1.newInstance(r10)     // Catch:{ all -> 0x0647 }
            r11 = r1
            goto L_0x05ac
        L_0x0647:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x053a }
            if (r2 == 0) goto L_0x0650
            throw r2     // Catch:{ all -> 0x053a }
        L_0x0650:
            throw r1     // Catch:{ all -> 0x053a }
        L_0x0651:
            r5 = 2
            java.lang.Object[] r10 = new java.lang.Object[r5]     // Catch:{ all -> 0x0799 }
            r5 = 1
            r10[r5] = r1     // Catch:{ all -> 0x0799 }
            r1 = 0
            r10[r1] = r15     // Catch:{ all -> 0x0799 }
            byte[] r1 = getOutOfStore     // Catch:{ all -> 0x0799 }
            r5 = 44
            byte r13 = r1[r5]     // Catch:{ all -> 0x0799 }
            byte r13 = (byte) r13     // Catch:{ all -> 0x0799 }
            r14 = 623(0x26f, float:8.73E-43)
            byte r5 = r1[r14]     // Catch:{ all -> 0x0799 }
            byte r5 = (byte) r5     // Catch:{ all -> 0x0799 }
            java.lang.String r5 = $$c(r7, r13, r5)     // Catch:{ all -> 0x0799 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0799 }
            r13 = 44
            byte r14 = r1[r13]     // Catch:{ all -> 0x0799 }
            byte r13 = (byte) r14     // Catch:{ all -> 0x0799 }
            r40 = r2
            r14 = 623(0x26f, float:8.73E-43)
            byte r2 = r1[r14]     // Catch:{ all -> 0x0799 }
            byte r2 = (byte) r2     // Catch:{ all -> 0x0799 }
            java.lang.String r2 = $$c(r7, r13, r2)     // Catch:{ all -> 0x0799 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0799 }
            r13 = 2
            java.lang.Class[] r14 = new java.lang.Class[r13]     // Catch:{ all -> 0x0799 }
            r13 = 0
            r14[r13] = r2     // Catch:{ all -> 0x0799 }
            r2 = 1
            r14[r2] = r6     // Catch:{ all -> 0x0799 }
            java.lang.reflect.Constructor r5 = r5.getDeclaredConstructor(r14)     // Catch:{ all -> 0x0799 }
            java.lang.Object r5 = r5.newInstance(r10)     // Catch:{ all -> 0x0799 }
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ all -> 0x071c }
            r10[r13] = r5     // Catch:{ all -> 0x071c }
            r2 = 820(0x334, float:1.149E-42)
            short r2 = (short) r2     // Catch:{ all -> 0x071c }
            r13 = 21
            byte r14 = r1[r13]     // Catch:{ all -> 0x071c }
            byte r13 = (byte) r14     // Catch:{ all -> 0x071c }
            r43 = r3
            r14 = 623(0x26f, float:8.73E-43)
            byte r3 = r1[r14]     // Catch:{ all -> 0x071c }
            byte r3 = (byte) r3     // Catch:{ all -> 0x071c }
            java.lang.String r3 = $$c(r2, r13, r3)     // Catch:{ all -> 0x071c }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x071c }
            r13 = 44
            byte r14 = r1[r13]     // Catch:{ all -> 0x071c }
            byte r13 = (byte) r14     // Catch:{ all -> 0x071c }
            r44 = r4
            r14 = 623(0x26f, float:8.73E-43)
            byte r4 = r1[r14]     // Catch:{ all -> 0x071c }
            byte r4 = (byte) r4     // Catch:{ all -> 0x071c }
            java.lang.String r4 = $$c(r7, r13, r4)     // Catch:{ all -> 0x071c }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x071c }
            r13 = 1
            java.lang.Class[] r14 = new java.lang.Class[r13]     // Catch:{ all -> 0x071c }
            r13 = 0
            r14[r13] = r4     // Catch:{ all -> 0x071c }
            java.lang.reflect.Constructor r3 = r3.getDeclaredConstructor(r14)     // Catch:{ all -> 0x071c }
            java.lang.Object r3 = r3.newInstance(r10)     // Catch:{ all -> 0x071c }
            int r4 = setAppInviteOneLink
            int r4 = r4 + 19
            r10 = 128(0x80, float:1.794E-43)
            int r4 = r4 % r10
            setUserEmails = r4
            r4 = 21
            byte r10 = r1[r4]     // Catch:{ all -> 0x070f }
            byte r4 = (byte) r10     // Catch:{ all -> 0x070f }
            r10 = 623(0x26f, float:8.73E-43)
            byte r13 = r1[r10]     // Catch:{ all -> 0x070f }
            byte r10 = (byte) r13     // Catch:{ all -> 0x070f }
            java.lang.String r2 = $$c(r2, r4, r10)     // Catch:{ all -> 0x070f }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x070f }
            r4 = 723(0x2d3, float:1.013E-42)
            short r10 = (short) r4     // Catch:{ all -> 0x070f }
            byte r4 = r1[r34]     // Catch:{ all -> 0x070f }
            byte r4 = (byte) r4     // Catch:{ all -> 0x070f }
            byte r1 = r1[r22]     // Catch:{ all -> 0x070f }
            byte r1 = (byte) r1     // Catch:{ all -> 0x070f }
            java.lang.String r1 = $$c(r10, r4, r1)     // Catch:{ all -> 0x070f }
            r4 = 0
            java.lang.reflect.Method r1 = r2.getMethod(r1, r4)     // Catch:{ all -> 0x070f }
            r1.invoke(r3, r4)     // Catch:{ all -> 0x070f }
            r1 = r5
            r2 = r40
            r4 = r44
        L_0x0705:
            r14 = r39
            r5 = r41
            r10 = r42
            r3 = r43
            goto L_0x04c0
        L_0x070f:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x0718 }
            if (r2 == 0) goto L_0x071b
            throw r2     // Catch:{ Exception -> 0x0718 }
        L_0x0718:
            r0 = move-exception
            r1 = r0
            goto L_0x0726
        L_0x071b:
            throw r1     // Catch:{ Exception -> 0x0718 }
        L_0x071c:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x0718 }
            if (r2 == 0) goto L_0x0725
            throw r2     // Catch:{ Exception -> 0x0718 }
        L_0x0725:
            throw r1     // Catch:{ Exception -> 0x0718 }
        L_0x0726:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x053a }
            r2.<init>()     // Catch:{ all -> 0x053a }
            r3 = 927(0x39f, float:1.299E-42)
            short r3 = (short) r3     // Catch:{ all -> 0x053a }
            byte[] r4 = getOutOfStore     // Catch:{ all -> 0x053a }
            byte r10 = r4[r34]     // Catch:{ all -> 0x053a }
            byte r10 = (byte) r10     // Catch:{ all -> 0x053a }
            r11 = 190(0xbe, float:2.66E-43)
            byte r12 = r4[r11]     // Catch:{ all -> 0x053a }
            byte r11 = (byte) r12     // Catch:{ all -> 0x053a }
            java.lang.String r3 = $$c(r3, r10, r11)     // Catch:{ all -> 0x053a }
            r2.append(r3)     // Catch:{ all -> 0x053a }
            r2.append(r5)     // Catch:{ all -> 0x053a }
            r3 = 305(0x131, float:4.27E-43)
            short r3 = (short) r3     // Catch:{ all -> 0x053a }
            int r5 = waitForCustomerUserId     // Catch:{ all -> 0x053a }
            r10 = 1
            r11 = r5 & 1
            r5 = r5 | r10
            int r11 = r11 + r5
            byte r5 = (byte) r11     // Catch:{ all -> 0x053a }
            r10 = 78
            byte r10 = (byte) r10     // Catch:{ all -> 0x053a }
            java.lang.String r3 = $$c(r3, r5, r10)     // Catch:{ all -> 0x053a }
            r2.append(r3)     // Catch:{ all -> 0x053a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x053a }
            r3 = 2
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x078f }
            r3 = 1
            r5[r3] = r1     // Catch:{ all -> 0x078f }
            r1 = 0
            r5[r1] = r2     // Catch:{ all -> 0x078f }
            r1 = 850(0x352, float:1.191E-42)
            short r2 = (short) r1     // Catch:{ all -> 0x078f }
            r1 = 15
            byte r3 = r4[r1]     // Catch:{ all -> 0x078f }
            byte r1 = (byte) r3     // Catch:{ all -> 0x078f }
            r3 = 623(0x26f, float:8.73E-43)
            byte r4 = r4[r3]     // Catch:{ all -> 0x078f }
            byte r3 = (byte) r4     // Catch:{ all -> 0x078f }
            java.lang.String r1 = $$c(r2, r1, r3)     // Catch:{ all -> 0x078f }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x078f }
            r2 = 2
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ all -> 0x078f }
            r2 = 0
            r3[r2] = r6     // Catch:{ all -> 0x078f }
            java.lang.Class<java.lang.Throwable> r2 = java.lang.Throwable.class
            r4 = 1
            r3[r4] = r2     // Catch:{ all -> 0x078f }
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r3)     // Catch:{ all -> 0x078f }
            java.lang.Object r1 = r1.newInstance(r5)     // Catch:{ all -> 0x078f }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x078f }
            throw r1     // Catch:{ all -> 0x078f }
        L_0x078f:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x053a }
            if (r2 == 0) goto L_0x0798
            throw r2     // Catch:{ all -> 0x053a }
        L_0x0798:
            throw r1     // Catch:{ all -> 0x053a }
        L_0x0799:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x053a }
            if (r2 == 0) goto L_0x07a2
            throw r2     // Catch:{ all -> 0x053a }
        L_0x07a2:
            throw r1     // Catch:{ all -> 0x053a }
        L_0x07a3:
            r0 = move-exception
        L_0x07a4:
            r42 = r10
            r39 = r14
            goto L_0x053b
        L_0x07aa:
            r0 = move-exception
        L_0x07ab:
            r41 = r5
            goto L_0x07a4
        L_0x07ae:
            r38 = r1
            r40 = r2
            r44 = r4
            r41 = r5
            r42 = r10
            r39 = r14
            r1 = r11
            r11 = r40
            goto L_0x07e5
        L_0x07be:
            r0 = move-exception
        L_0x07bf:
            r41 = r5
            r42 = r10
            r39 = r14
            r1 = r0
            goto L_0x07cb
        L_0x07c7:
            r0 = move-exception
            r37 = r4
            goto L_0x07bf
        L_0x07cb:
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x053a }
            if (r2 == 0) goto L_0x07d2
            throw r2     // Catch:{ all -> 0x053a }
        L_0x07d2:
            throw r1     // Catch:{ all -> 0x053a }
        L_0x07d3:
            r0 = move-exception
            r37 = r4
            goto L_0x07ab
        L_0x07d7:
            r37 = r4
            r41 = r5
            r42 = r10
            r39 = r14
            r1 = 0
            r11 = 0
            r38 = 0
            r44 = 0
        L_0x07e5:
            r2 = 6848(0x1ac0, float:9.596E-42)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x167e }
            r3 = 727(0x2d7, float:1.019E-42)
            short r3 = (short) r3     // Catch:{ all -> 0x167e }
            byte[] r4 = getOutOfStore     // Catch:{ all -> 0x167e }
            r5 = 12
            byte r10 = r4[r5]     // Catch:{ all -> 0x16c0 }
            byte r5 = (byte) r10
            r10 = 407(0x197, float:5.7E-43)
            byte r10 = r4[r10]     // Catch:{ all -> 0x167e }
            byte r10 = (byte) r10     // Catch:{ all -> 0x167e }
            java.lang.String r3 = $$c(r3, r5, r10)     // Catch:{ all -> 0x167e }
            java.io.InputStream r3 = r8.getResourceAsStream(r3)     // Catch:{ all -> 0x167e }
            r5 = 1
            java.lang.Object[] r10 = new java.lang.Object[r5]     // Catch:{ all -> 0x16b1 }
            r5 = 0
            r10[r5] = r3     // Catch:{ all -> 0x16b1 }
            r3 = 539(0x21b, float:7.55E-43)
            short r3 = (short) r3     // Catch:{ all -> 0x16b1 }
            r5 = 623(0x26f, float:8.73E-43)
            byte r13 = r4[r5]     // Catch:{ all -> 0x16b1 }
            byte r5 = (byte) r13     // Catch:{ all -> 0x16b1 }
            byte r13 = (byte) r5     // Catch:{ all -> 0x16b1 }
            java.lang.String r5 = $$c(r3, r5, r13)     // Catch:{ all -> 0x16b1 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x16b1 }
            r13 = 1024(0x400, float:1.435E-42)
            short r14 = (short) r13     // Catch:{ all -> 0x16b1 }
            r13 = 15
            byte r15 = r4[r13]     // Catch:{ all -> 0x16b1 }
            byte r13 = (byte) r15     // Catch:{ all -> 0x16b1 }
            r33 = r1
            r15 = 623(0x26f, float:8.73E-43)
            byte r1 = r4[r15]     // Catch:{ all -> 0x16b1 }
            byte r1 = (byte) r1     // Catch:{ all -> 0x16b1 }
            java.lang.String r1 = $$c(r14, r13, r1)     // Catch:{ all -> 0x16b1 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x16b1 }
            r13 = 1
            java.lang.Class[] r14 = new java.lang.Class[r13]     // Catch:{ all -> 0x16b1 }
            r15 = 0
            r14[r15] = r1     // Catch:{ all -> 0x16b1 }
            java.lang.reflect.Constructor r1 = r5.getDeclaredConstructor(r14)     // Catch:{ all -> 0x16b1 }
            java.lang.Object r1 = r1.newInstance(r10)     // Catch:{ all -> 0x16b1 }
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch:{ all -> 0x16a2 }
            r5[r15] = r2     // Catch:{ all -> 0x16a2 }
            r10 = 623(0x26f, float:8.73E-43)
            byte r13 = r4[r10]     // Catch:{ all -> 0x16a2 }
            byte r10 = (byte) r13     // Catch:{ all -> 0x16a2 }
            byte r13 = (byte) r10     // Catch:{ all -> 0x16a2 }
            java.lang.String r10 = $$c(r3, r10, r13)     // Catch:{ all -> 0x16a2 }
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ all -> 0x16a2 }
            r13 = 232(0xe8, float:3.25E-43)
            short r13 = (short) r13     // Catch:{ all -> 0x16a2 }
            r14 = 239(0xef, float:3.35E-43)
            byte r14 = r4[r14]     // Catch:{ all -> 0x16a2 }
            byte r14 = (byte) r14     // Catch:{ all -> 0x16a2 }
            r15 = 118(0x76, float:1.65E-43)
            byte r15 = r4[r15]     // Catch:{ all -> 0x16a2 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x16a2 }
            java.lang.String r13 = $$c(r13, r14, r15)     // Catch:{ all -> 0x16a2 }
            r14 = 1
            java.lang.Class[] r15 = new java.lang.Class[r14]     // Catch:{ all -> 0x16a2 }
            r14 = 0
            r15[r14] = r19     // Catch:{ all -> 0x16a2 }
            java.lang.reflect.Method r10 = r10.getMethod(r13, r15)     // Catch:{ all -> 0x16a2 }
            r10.invoke(r1, r5)     // Catch:{ all -> 0x16a2 }
            r5 = 623(0x26f, float:8.73E-43)
            byte r10 = r4[r5]     // Catch:{ all -> 0x1693 }
            byte r5 = (byte) r10     // Catch:{ all -> 0x1693 }
            byte r10 = (byte) r5     // Catch:{ all -> 0x1693 }
            java.lang.String r3 = $$c(r3, r5, r10)     // Catch:{ all -> 0x1693 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x1693 }
            r5 = 723(0x2d3, float:1.013E-42)
            short r10 = (short) r5     // Catch:{ all -> 0x1693 }
            byte r5 = r4[r34]     // Catch:{ all -> 0x1693 }
            byte r5 = (byte) r5     // Catch:{ all -> 0x1693 }
            byte r4 = r4[r22]     // Catch:{ all -> 0x1693 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x1693 }
            java.lang.String r4 = $$c(r10, r5, r4)     // Catch:{ all -> 0x1693 }
            r5 = 0
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ all -> 0x1693 }
            r3.invoke(r1, r5)     // Catch:{ all -> 0x1693 }
            r1 = 16
            r3 = 6810(0x1a9a, float:9.543E-42)
            r5 = r36
            r4 = 0
        L_0x0896:
            r10 = r1 & 41
            r13 = r1 | 41
            int r10 = r10 + r13
            int r13 = r1 + 3039
            byte r13 = r2[r13]     // Catch:{ all -> 0x167e }
            r14 = r13 ^ -111(0xffffffffffffff91, float:NaN)
            r13 = r13 & -111(0xffffffffffffff91, float:NaN)
            r15 = 1
            int r13 = r13 << r15
            int r14 = r14 + r13
            byte r13 = (byte) r14     // Catch:{ all -> 0x167e }
            r2[r10] = r13     // Catch:{ all -> 0x167e }
            int r10 = r2.length     // Catch:{ all -> 0x167e }
            int r13 = -r1
            r14 = r10 & r13
            r10 = r10 | r13
            int r14 = r14 + r10
            r10 = 3
            java.lang.Object[] r13 = new java.lang.Object[r10]     // Catch:{ all -> 0x1684 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x1684 }
            r14 = 2
            r13[r14] = r10     // Catch:{ all -> 0x1684 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x1684 }
            r14 = 1
            r13[r14] = r10     // Catch:{ all -> 0x1684 }
            r10 = 0
            r13[r10] = r2     // Catch:{ all -> 0x1684 }
            r2 = 138(0x8a, float:1.93E-43)
            short r2 = (short) r2     // Catch:{ all -> 0x1684 }
            byte[] r10 = getOutOfStore     // Catch:{ all -> 0x1684 }
            r14 = 60
            byte r14 = r10[r14]     // Catch:{ all -> 0x1684 }
            byte r14 = (byte) r14     // Catch:{ all -> 0x1684 }
            r40 = r3
            r15 = 623(0x26f, float:8.73E-43)
            byte r3 = r10[r15]     // Catch:{ all -> 0x1684 }
            byte r3 = (byte) r3     // Catch:{ all -> 0x1684 }
            java.lang.String r2 = $$c(r2, r14, r3)     // Catch:{ all -> 0x1684 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x1684 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x1684 }
            r14 = 3
            java.lang.Class[] r15 = new java.lang.Class[r14]     // Catch:{ all -> 0x1684 }
            r14 = 0
            r15[r14] = r19     // Catch:{ all -> 0x1684 }
            r14 = 1
            r15[r14] = r3     // Catch:{ all -> 0x1684 }
            r14 = 2
            r15[r14] = r3     // Catch:{ all -> 0x1684 }
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r15)     // Catch:{ all -> 0x1684 }
            java.lang.Object r2 = r2.newInstance(r13)     // Catch:{ all -> 0x1684 }
            r46 = r2
            java.io.InputStream r46 = (java.io.InputStream) r46     // Catch:{ all -> 0x1684 }
            java.lang.Object r2 = setDebugLog     // Catch:{ all -> 0x167e }
            if (r2 != 0) goto L_0x0978
            r13 = 0
            int r2 = android.graphics.Color.argb(r13, r13, r13, r13)     // Catch:{ all -> 0x053a }
            int r2 = -r2
            r3 = -1546115002(0xffffffffa3d82846, float:-2.3435823E-17)
            r13 = r2 | r3
            r14 = 1
            int r13 = r13 << r14
            r2 = r2 ^ r3
            int r13 = r13 - r2
            r2 = 621(0x26d, float:8.7E-43)
            short r2 = (short) r2
            byte r3 = r10[r24]     // Catch:{ all -> 0x096e }
            byte r3 = (byte) r3     // Catch:{ all -> 0x096e }
            byte r14 = r10[r25]     // Catch:{ all -> 0x096e }
            byte r14 = (byte) r14     // Catch:{ all -> 0x096e }
            java.lang.String r2 = $$c(r2, r3, r14)     // Catch:{ all -> 0x096e }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x096e }
            r3 = 101(0x65, float:1.42E-43)
            short r3 = (short) r3     // Catch:{ all -> 0x096e }
            r14 = 418(0x1a2, float:5.86E-43)
            byte r14 = r10[r14]     // Catch:{ all -> 0x096e }
            byte r14 = (byte) r14     // Catch:{ all -> 0x096e }
            byte r15 = r10[r16]     // Catch:{ all -> 0x096e }
            byte r15 = (byte) r15     // Catch:{ all -> 0x096e }
            java.lang.String r3 = $$c(r3, r14, r15)     // Catch:{ all -> 0x096e }
            r14 = 0
            java.lang.reflect.Method r2 = r2.getMethod(r3, r14)     // Catch:{ all -> 0x096e }
            java.lang.Object r2 = r2.invoke(r14, r14)     // Catch:{ all -> 0x096e }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x096e }
            long r2 = r2.longValue()     // Catch:{ all -> 0x096e }
            r14 = 0
            int r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            int r2 = -r2
            r14 = 6
            r3 = r2 & 6
            r2 = r2 | r14
            int r3 = r3 + r2
            short r2 = (short) r3
            long r14 = setImeiData     // Catch:{ all -> 0x053a }
            r3 = 32
            r43 = r4
            long r3 = r14 >>> r3
            int r3 = (int) r3     // Catch:{ all -> 0x053a }
            int r4 = ~r13     // Catch:{ all -> 0x053a }
            r4 = r4 & r3
            int r3 = ~r3     // Catch:{ all -> 0x053a }
            r3 = r3 & r13
            r3 = r3 | r4
            int r4 = (int) r14     // Catch:{ all -> 0x053a }
            r4 = r4 ^ r13
            int[] r47 = new int[]{r3, r4}     // Catch:{ all -> 0x053a }
            com.appsflyer.internal.AFg1zSDK r3 = new com.appsflyer.internal.AFg1zSDK     // Catch:{ all -> 0x053a }
            int r48 = setPhoneNumber     // Catch:{ all -> 0x053a }
            byte[] r49 = setCustomerIdAndLogSession     // Catch:{ all -> 0x053a }
            int r51 = setCustomerUserId     // Catch:{ all -> 0x053a }
            r45 = r3
            r50 = r2
            r45.<init>(r46, r47, r48, r49, r50, r51)     // Catch:{ all -> 0x053a }
            r46 = r1
            r47 = r9
            r45 = r11
            goto L_0x0a55
        L_0x096e:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x053a }
            if (r2 == 0) goto L_0x0977
            throw r2     // Catch:{ all -> 0x053a }
        L_0x0977:
            throw r1     // Catch:{ all -> 0x053a }
        L_0x0978:
            r43 = r4
            r4 = 0
            r13 = 0
            float r4 = android.graphics.PointF.length(r4, r13)     // Catch:{ all -> 0x167e }
            r13 = 0
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            int r4 = -r4
            r13 = 505401362(0x1e1fd012, float:8.460418E-21)
            r14 = r4 ^ r13
            r4 = r4 & r13
            r13 = 1
            int r4 = r4 << r13
            int r14 = r14 + r4
            java.lang.String r4 = ""
            java.lang.String r15 = ""
            r45 = r11
            r13 = 2
            java.lang.Object[] r11 = new java.lang.Object[r13]     // Catch:{ all -> 0x1671 }
            r13 = 1
            r11[r13] = r15     // Catch:{ all -> 0x1671 }
            r13 = 0
            r11[r13] = r4     // Catch:{ all -> 0x1671 }
            r4 = 868(0x364, float:1.216E-42)
            short r4 = (short) r4     // Catch:{ all -> 0x1671 }
            byte r13 = r10[r24]     // Catch:{ all -> 0x1671 }
            byte r13 = (byte) r13     // Catch:{ all -> 0x1671 }
            byte r15 = r10[r25]     // Catch:{ all -> 0x1671 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x1671 }
            java.lang.String r4 = $$c(r4, r13, r15)     // Catch:{ all -> 0x1671 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x1671 }
            int r13 = waitForCustomerUserId     // Catch:{ all -> 0x1671 }
            r15 = r13 ^ 216(0xd8, float:3.03E-43)
            r13 = r13 & 216(0xd8, float:3.03E-43)
            r13 = r13 | r15
            short r13 = (short) r13     // Catch:{ all -> 0x1671 }
            r15 = 568(0x238, float:7.96E-43)
            byte r15 = r10[r15]     // Catch:{ all -> 0x1671 }
            byte r15 = (byte) r15
            r47 = r9
            byte r9 = r10[r24]     // Catch:{ all -> 0x1668 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x1668 }
            java.lang.String r9 = $$c(r13, r15, r9)     // Catch:{ all -> 0x1668 }
            r13 = 2
            java.lang.Class[] r15 = new java.lang.Class[r13]     // Catch:{ all -> 0x1668 }
            java.lang.Class<java.lang.CharSequence> r13 = java.lang.CharSequence.class
            r21 = 0
            r15[r21] = r13     // Catch:{ all -> 0x1668 }
            r28 = 1
            r15[r28] = r13     // Catch:{ all -> 0x166e }
            java.lang.reflect.Method r4 = r4.getMethod(r9, r15)     // Catch:{ all -> 0x1668 }
            r9 = 0
            java.lang.Object r4 = r4.invoke(r9, r11)     // Catch:{ all -> 0x1668 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x1668 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x1668 }
            int r4 = -r4
            r9 = 5
            r11 = r4 ^ 5
            r4 = r4 & r9
            r13 = 1
            int r4 = r4 << r13
            int r11 = r11 + r4
            short r4 = (short) r11
            r11 = 3
            java.lang.Object[] r13 = new java.lang.Object[r11]     // Catch:{ all -> 0x165b }
            java.lang.Short r4 = java.lang.Short.valueOf(r4)     // Catch:{ all -> 0x165b }
            r11 = 2
            r13[r11] = r4     // Catch:{ all -> 0x165b }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x165b }
            r11 = 1
            r13[r11] = r4     // Catch:{ all -> 0x165b }
            r4 = 0
            r13[r4] = r46     // Catch:{ all -> 0x165b }
            r4 = 273(0x111, float:3.83E-43)
            short r4 = (short) r4     // Catch:{ all -> 0x165b }
            r11 = 66
            byte r14 = r10[r11]     // Catch:{ all -> 0x165b }
            byte r11 = (byte) r14     // Catch:{ all -> 0x165b }
            byte r14 = r10[r22]     // Catch:{ all -> 0x165b }
            byte r14 = (byte) r14     // Catch:{ all -> 0x165b }
            java.lang.String r4 = $$c(r4, r11, r14)     // Catch:{ all -> 0x165b }
            java.lang.Object r11 = updateServerUninstallToken     // Catch:{ all -> 0x165b }
            java.lang.ClassLoader r11 = (java.lang.ClassLoader) r11     // Catch:{ all -> 0x165b }
            r14 = 1
            java.lang.Class r4 = java.lang.Class.forName(r4, r14, r11)     // Catch:{ all -> 0x165b }
            r11 = 616(0x268, float:8.63E-43)
            short r11 = (short) r11     // Catch:{ all -> 0x165b }
            r14 = 49
            byte r15 = r10[r14]     // Catch:{ all -> 0x165b }
            byte r14 = (byte) r15     // Catch:{ all -> 0x165b }
            r15 = 23
            byte r15 = r10[r15]     // Catch:{ all -> 0x165b }
            byte r15 = (byte) r15     // Catch:{ all -> 0x165b }
            java.lang.String r11 = $$c(r11, r14, r15)     // Catch:{ all -> 0x165b }
            r14 = 1024(0x400, float:1.435E-42)
            short r15 = (short) r14     // Catch:{ all -> 0x165b }
            r14 = 15
            byte r9 = r10[r14]     // Catch:{ all -> 0x165b }
            byte r9 = (byte) r9     // Catch:{ all -> 0x165b }
            r46 = r1
            r14 = 623(0x26f, float:8.73E-43)
            byte r1 = r10[r14]     // Catch:{ all -> 0x165b }
            byte r1 = (byte) r1     // Catch:{ all -> 0x165b }
            java.lang.String r1 = $$c(r15, r9, r1)     // Catch:{ all -> 0x165b }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x165b }
            r9 = 3
            java.lang.Class[] r14 = new java.lang.Class[r9]     // Catch:{ all -> 0x165b }
            r9 = 0
            r14[r9] = r1     // Catch:{ all -> 0x165b }
            r1 = 1
            r14[r1] = r3     // Catch:{ all -> 0x165b }
            java.lang.Class r1 = java.lang.Short.TYPE     // Catch:{ all -> 0x165b }
            r3 = 2
            r14[r3] = r1     // Catch:{ all -> 0x165b }
            java.lang.reflect.Method r1 = r4.getMethod(r11, r14)     // Catch:{ all -> 0x165b }
            java.lang.Object r1 = r1.invoke(r2, r13)     // Catch:{ all -> 0x165b }
            r3 = r1
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ all -> 0x165b }
        L_0x0a55:
            r1 = 17
            long r1 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x164e }
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x164e }
            r2 = 0
            r4[r2] = r1     // Catch:{ all -> 0x164e }
            r1 = 1024(0x400, float:1.435E-42)
            short r2 = (short) r1     // Catch:{ all -> 0x164e }
            r1 = 15
            byte r9 = r10[r1]     // Catch:{ all -> 0x164e }
            byte r1 = (byte) r9     // Catch:{ all -> 0x164e }
            r9 = 623(0x26f, float:8.73E-43)
            byte r11 = r10[r9]     // Catch:{ all -> 0x164e }
            byte r9 = (byte) r11     // Catch:{ all -> 0x164e }
            java.lang.String r1 = $$c(r2, r1, r9)     // Catch:{ all -> 0x164e }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x164e }
            r9 = 642(0x282, float:9.0E-43)
            short r9 = (short) r9     // Catch:{ all -> 0x164e }
            r11 = 99
            byte r13 = r10[r11]     // Catch:{ all -> 0x164e }
            byte r11 = (byte) r13     // Catch:{ all -> 0x164e }
            r13 = 62
            byte r13 = r10[r13]     // Catch:{ all -> 0x164e }
            byte r13 = (byte) r13     // Catch:{ all -> 0x164e }
            java.lang.String r9 = $$c(r9, r11, r13)     // Catch:{ all -> 0x164e }
            r11 = 1
            java.lang.Class[] r13 = new java.lang.Class[r11]     // Catch:{ all -> 0x164e }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x164e }
            r14 = 0
            r13[r14] = r11     // Catch:{ all -> 0x164e }
            java.lang.reflect.Method r1 = r1.getMethod(r9, r13)     // Catch:{ all -> 0x164e }
            java.lang.Object r1 = r1.invoke(r3, r4)     // Catch:{ all -> 0x164e }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x164e }
            r1.longValue()     // Catch:{ all -> 0x164e }
            if (r12 == 0) goto L_0x0fae
            java.lang.Object r1 = setDebugLog     // Catch:{ all -> 0x0fa6 }
            if (r1 != 0) goto L_0x0ac0
            int r4 = setAppInviteOneLink
            r9 = r4 ^ 31
            r4 = r4 & 31
            r11 = 1
            int r4 = r4 << r11
            int r9 = r9 + r4
            r4 = 128(0x80, float:1.794E-43)
            int r11 = r9 % 128
            setUserEmails = r11
            r4 = 2
            int r9 = r9 % r4
            if (r9 != 0) goto L_0x0ab9
            r4 = r45
            goto L_0x0ac2
        L_0x0ab9:
            r4 = 0
            throw r4     // Catch:{ all -> 0x0abb }
        L_0x0abb:
            r0 = move-exception
            r1 = r0
            r5 = r8
            goto L_0x03d2
        L_0x0ac0:
            r4 = r44
        L_0x0ac2:
            if (r1 != 0) goto L_0x0ad1
            int r1 = setUserEmails
            int r1 = r1 + 57
            r9 = 128(0x80, float:1.794E-43)
            int r1 = r1 % r9
            setAppInviteOneLink = r1
            r1 = r33
        L_0x0acf:
            r9 = 1
            goto L_0x0ad4
        L_0x0ad1:
            r1 = r38
            goto L_0x0acf
        L_0x0ad4:
            java.lang.Object[] r11 = new java.lang.Object[r9]     // Catch:{ all -> 0x0e8d }
            r9 = 0
            r11[r9] = r4     // Catch:{ all -> 0x0e8d }
            r9 = 820(0x334, float:1.149E-42)
            short r9 = (short) r9     // Catch:{ all -> 0x0e8d }
            r13 = 21
            byte r14 = r10[r13]     // Catch:{ all -> 0x0e8d }
            byte r13 = (byte) r14     // Catch:{ all -> 0x0e8d }
            r14 = 623(0x26f, float:8.73E-43)
            byte r15 = r10[r14]     // Catch:{ all -> 0x0e8d }
            byte r15 = (byte) r15     // Catch:{ all -> 0x0e8d }
            java.lang.String r13 = $$c(r9, r13, r15)     // Catch:{ all -> 0x0e8d }
            java.lang.Class r13 = java.lang.Class.forName(r13)     // Catch:{ all -> 0x0e8d }
            r15 = 44
            byte r14 = r10[r15]     // Catch:{ all -> 0x0e8d }
            byte r14 = (byte) r14     // Catch:{ all -> 0x0e8d }
            r15 = 623(0x26f, float:8.73E-43)
            byte r10 = r10[r15]     // Catch:{ all -> 0x0e8d }
            byte r10 = (byte) r10     // Catch:{ all -> 0x0e8d }
            java.lang.String r10 = $$c(r7, r14, r10)     // Catch:{ all -> 0x0e8d }
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ all -> 0x0e8d }
            r14 = 1
            java.lang.Class[] r15 = new java.lang.Class[r14]     // Catch:{ all -> 0x0e8d }
            r14 = 0
            r15[r14] = r10     // Catch:{ all -> 0x0e8d }
            java.lang.reflect.Constructor r10 = r13.getDeclaredConstructor(r15)     // Catch:{ all -> 0x0e8d }
            java.lang.Object r10 = r10.newInstance(r11)     // Catch:{ all -> 0x0e8d }
            r11 = 1024(0x400, float:1.435E-42)
            byte[] r13 = new byte[r11]     // Catch:{ all -> 0x0b38 }
            r11 = r40
        L_0x0b14:
            if (r11 <= 0) goto L_0x0c2a
            int r14 = setUserEmails
            r15 = r14 | 41
            r28 = 1
            int r15 = r15 << 1
            r14 = r14 ^ 41
            int r15 = r15 - r14
            r40 = r5
            r14 = 128(0x80, float:1.794E-43)
            int r5 = r15 % 128
            setAppInviteOneLink = r5
            r5 = 2
            int r15 = r15 % r5
            if (r15 != 0) goto L_0x0b3e
            r5 = 1024(0x400, float:1.435E-42)
            int r14 = java.lang.Math.min(r5, r11)     // Catch:{ all -> 0x0b38 }
            r48 = r12
            r5 = 1
        L_0x0b36:
            r15 = 3
            goto L_0x0b48
        L_0x0b38:
            r0 = move-exception
            r5 = r8
            r8 = r1
        L_0x0b3b:
            r1 = r0
            goto L_0x0f10
        L_0x0b3e:
            r5 = 1024(0x400, float:1.435E-42)
            int r14 = java.lang.Math.min(r5, r11)     // Catch:{ all -> 0x0c24 }
            r48 = r12
            r5 = 0
            goto L_0x0b36
        L_0x0b48:
            java.lang.Object[] r12 = new java.lang.Object[r15]     // Catch:{ all -> 0x0c16 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x0c16 }
            r15 = 2
            r12[r15] = r14     // Catch:{ all -> 0x0c16 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0c16 }
            r14 = 1
            r12[r14] = r5     // Catch:{ all -> 0x0c16 }
            r5 = 0
            r12[r5] = r13     // Catch:{ all -> 0x0c16 }
            byte[] r5 = getOutOfStore     // Catch:{ all -> 0x0c16 }
            r14 = 15
            byte r15 = r5[r14]     // Catch:{ all -> 0x0c16 }
            byte r14 = (byte) r15
            r49 = r8
            r15 = 623(0x26f, float:8.73E-43)
            byte r8 = r5[r15]     // Catch:{ all -> 0x0c12 }
            byte r8 = (byte) r8     // Catch:{ all -> 0x0c12 }
            java.lang.String r8 = $$c(r2, r14, r8)     // Catch:{ all -> 0x0c12 }
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ all -> 0x0c12 }
            r14 = 270(0x10e, float:3.78E-43)
            short r14 = (short) r14     // Catch:{ all -> 0x0c12 }
            r50 = r2
            r15 = 99
            byte r2 = r5[r15]     // Catch:{ all -> 0x0c12 }
            byte r2 = (byte) r2     // Catch:{ all -> 0x0c12 }
            r15 = 118(0x76, float:1.65E-43)
            byte r15 = r5[r15]     // Catch:{ all -> 0x0c12 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x0c12 }
            java.lang.String r2 = $$c(r14, r2, r15)     // Catch:{ all -> 0x0c12 }
            java.lang.Class r14 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0c12 }
            r51 = r1
            r15 = 3
            java.lang.Class[] r1 = new java.lang.Class[r15]     // Catch:{ all -> 0x0c0f }
            r15 = 0
            r1[r15] = r19     // Catch:{ all -> 0x0c0f }
            r15 = 1
            r1[r15] = r14     // Catch:{ all -> 0x0c0f }
            r15 = 2
            r1[r15] = r14     // Catch:{ all -> 0x0c0f }
            java.lang.reflect.Method r1 = r8.getMethod(r2, r1)     // Catch:{ all -> 0x0c0f }
            java.lang.Object r1 = r1.invoke(r3, r12)     // Catch:{ all -> 0x0c0f }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0c0f }
            int r2 = r1.intValue()     // Catch:{ all -> 0x0c0f }
            r8 = -1
            if (r2 == r8) goto L_0x0c34
            r8 = 3
            java.lang.Object[] r12 = new java.lang.Object[r8]     // Catch:{ all -> 0x0bfd }
            r8 = 2
            r12[r8] = r1     // Catch:{ all -> 0x0bfd }
            r1 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0bfd }
            r15 = 1
            r12[r15] = r8     // Catch:{ all -> 0x0bfd }
            r12[r1] = r13     // Catch:{ all -> 0x0bfd }
            r1 = 21
            byte r8 = r5[r1]     // Catch:{ all -> 0x0bfd }
            byte r1 = (byte) r8     // Catch:{ all -> 0x0bfd }
            r8 = 623(0x26f, float:8.73E-43)
            byte r15 = r5[r8]     // Catch:{ all -> 0x0bfd }
            byte r8 = (byte) r15     // Catch:{ all -> 0x0bfd }
            java.lang.String r1 = $$c(r9, r1, r8)     // Catch:{ all -> 0x0bfd }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0bfd }
            r8 = 256(0x100, float:3.59E-43)
            short r8 = (short) r8     // Catch:{ all -> 0x0bfd }
            byte r15 = r5[r34]     // Catch:{ all -> 0x0bfd }
            byte r15 = (byte) r15     // Catch:{ all -> 0x0bfd }
            r17 = 71
            byte r5 = r5[r17]     // Catch:{ all -> 0x0bfd }
            byte r5 = (byte) r5     // Catch:{ all -> 0x0bfd }
            java.lang.String r5 = $$c(r8, r15, r5)     // Catch:{ all -> 0x0bfd }
            r8 = 3
            java.lang.Class[] r15 = new java.lang.Class[r8]     // Catch:{ all -> 0x0bfd }
            r8 = 0
            r15[r8] = r19     // Catch:{ all -> 0x0bfd }
            r8 = 1
            r15[r8] = r14     // Catch:{ all -> 0x0bfd }
            r28 = 2
            r15[r28] = r14     // Catch:{ all -> 0x0bfd }
            java.lang.reflect.Method r1 = r1.getMethod(r5, r15)     // Catch:{ all -> 0x0bfd }
            r1.invoke(r10, r12)     // Catch:{ all -> 0x0bfd }
            int r1 = -r2
            r2 = r11 | r1
            int r2 = r2 << r8
            r1 = r1 ^ r11
            int r11 = r2 - r1
            r5 = r40
            r12 = r48
            r8 = r49
            r2 = r50
            r1 = r51
            goto L_0x0b14
        L_0x0bfd:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0c06 }
            if (r2 == 0) goto L_0x0c0e
            throw r2     // Catch:{ all -> 0x0c06 }
        L_0x0c06:
            r0 = move-exception
        L_0x0c07:
            r1 = r0
            r5 = r49
            r8 = r51
            goto L_0x0f10
        L_0x0c0e:
            throw r1     // Catch:{ all -> 0x0c06 }
        L_0x0c0f:
            r0 = move-exception
        L_0x0c10:
            r1 = r0
            goto L_0x0c1c
        L_0x0c12:
            r0 = move-exception
            r51 = r1
            goto L_0x0c10
        L_0x0c16:
            r0 = move-exception
            r51 = r1
            r49 = r8
            goto L_0x0c10
        L_0x0c1c:
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0c06 }
            if (r2 == 0) goto L_0x0c23
            throw r2     // Catch:{ all -> 0x0c06 }
        L_0x0c23:
            throw r1     // Catch:{ all -> 0x0c06 }
        L_0x0c24:
            r0 = move-exception
            r51 = r1
            r49 = r8
            goto L_0x0c07
        L_0x0c2a:
            r51 = r1
            r50 = r2
            r40 = r5
            r49 = r8
            r48 = r12
        L_0x0c34:
            byte[] r1 = getOutOfStore     // Catch:{ all -> 0x0e7f }
            r2 = 21
            byte r3 = r1[r2]     // Catch:{ all -> 0x0e7f }
            byte r2 = (byte) r3     // Catch:{ all -> 0x0e7f }
            r3 = 623(0x26f, float:8.73E-43)
            byte r5 = r1[r3]     // Catch:{ all -> 0x0e7f }
            byte r3 = (byte) r5     // Catch:{ all -> 0x0e7f }
            java.lang.String r2 = $$c(r9, r2, r3)     // Catch:{ all -> 0x0e7f }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0e7f }
            r3 = 673(0x2a1, float:9.43E-43)
            short r3 = (short) r3     // Catch:{ all -> 0x0e7f }
            byte r5 = r1[r34]     // Catch:{ all -> 0x0e7f }
            byte r5 = (byte) r5     // Catch:{ all -> 0x0e7f }
            byte r8 = r1[r26]     // Catch:{ all -> 0x0e7f }
            byte r8 = (byte) r8     // Catch:{ all -> 0x0e7f }
            java.lang.String r3 = $$c(r3, r5, r8)     // Catch:{ all -> 0x0e7f }
            r5 = 0
            java.lang.reflect.Method r2 = r2.getMethod(r3, r5)     // Catch:{ all -> 0x0e7f }
            java.lang.Object r2 = r2.invoke(r10, r5)     // Catch:{ all -> 0x0e7f }
            int r3 = waitForCustomerUserId     // Catch:{ all -> 0x0e71 }
            r5 = r3 ^ 913(0x391, float:1.28E-42)
            r8 = r3 & 913(0x391, float:1.28E-42)
            r5 = r5 | r8
            short r5 = (short) r5     // Catch:{ all -> 0x0e71 }
            byte r8 = r1[r24]     // Catch:{ all -> 0x0e71 }
            byte r8 = (byte) r8     // Catch:{ all -> 0x0e71 }
            r11 = 623(0x26f, float:8.73E-43)
            byte r12 = r1[r11]     // Catch:{ all -> 0x0e71 }
            byte r11 = (byte) r12     // Catch:{ all -> 0x0e71 }
            java.lang.String r5 = $$c(r5, r8, r11)     // Catch:{ all -> 0x0e71 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0e71 }
            r8 = r3 ^ 345(0x159, float:4.83E-43)
            r3 = r3 & 345(0x159, float:4.83E-43)
            r3 = r3 | r8
            short r3 = (short) r3     // Catch:{ all -> 0x0e71 }
            r8 = 99
            byte r11 = r1[r8]     // Catch:{ all -> 0x0e71 }
            byte r8 = (byte) r11     // Catch:{ all -> 0x0e71 }
            r11 = 62
            byte r11 = r1[r11]     // Catch:{ all -> 0x0e71 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x0e71 }
            java.lang.String r3 = $$c(r3, r8, r11)     // Catch:{ all -> 0x0e71 }
            r8 = 0
            java.lang.reflect.Method r3 = r5.getMethod(r3, r8)     // Catch:{ all -> 0x0e71 }
            r3.invoke(r2, r8)     // Catch:{ all -> 0x0e71 }
            r2 = 21
            byte r3 = r1[r2]     // Catch:{ all -> 0x0e63 }
            byte r2 = (byte) r3     // Catch:{ all -> 0x0e63 }
            r3 = 623(0x26f, float:8.73E-43)
            byte r5 = r1[r3]     // Catch:{ all -> 0x0e63 }
            byte r3 = (byte) r5     // Catch:{ all -> 0x0e63 }
            java.lang.String r2 = $$c(r9, r2, r3)     // Catch:{ all -> 0x0e63 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0e63 }
            r3 = 723(0x2d3, float:1.013E-42)
            short r5 = (short) r3     // Catch:{ all -> 0x0e63 }
            byte r3 = r1[r34]     // Catch:{ all -> 0x0e63 }
            byte r3 = (byte) r3     // Catch:{ all -> 0x0e63 }
            byte r8 = r1[r22]     // Catch:{ all -> 0x0e63 }
            byte r8 = (byte) r8     // Catch:{ all -> 0x0e63 }
            java.lang.String r3 = $$c(r5, r3, r8)     // Catch:{ all -> 0x0e63 }
            r5 = 0
            java.lang.reflect.Method r2 = r2.getMethod(r3, r5)     // Catch:{ all -> 0x0e63 }
            r2.invoke(r10, r5)     // Catch:{ all -> 0x0e63 }
            r2 = 305(0x131, float:4.27E-43)
            short r3 = (short) r2
            r2 = 111(0x6f, float:1.56E-43)
            byte r5 = r1[r2]     // Catch:{ all -> 0x0e5c }
            byte r2 = (byte) r5     // Catch:{ all -> 0x0e5c }
            r5 = 410(0x19a, float:5.75E-43)
            byte r8 = r1[r5]     // Catch:{ all -> 0x0e5c }
            byte r5 = (byte) r8     // Catch:{ all -> 0x0e5c }
            java.lang.String r2 = $$c(r3, r2, r5)     // Catch:{ all -> 0x0e5c }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0e5c }
            r3 = 561(0x231, float:7.86E-43)
            short r3 = (short) r3     // Catch:{ all -> 0x0e5c }
            r5 = 568(0x238, float:7.96E-43)
            byte r5 = r1[r5]     // Catch:{ all -> 0x0e5c }
            byte r5 = (byte) r5     // Catch:{ all -> 0x0e5c }
            r8 = 109(0x6d, float:1.53E-43)
            byte r9 = r1[r8]     // Catch:{ all -> 0x0e5c }
            byte r8 = (byte) r9     // Catch:{ all -> 0x0e5c }
            java.lang.String r3 = $$c(r3, r5, r8)     // Catch:{ all -> 0x0e5c }
            r5 = 3
            java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch:{ all -> 0x0e5c }
            r5 = 0
            r8[r5] = r6     // Catch:{ all -> 0x0e5c }
            r5 = 1
            r8[r5] = r6     // Catch:{ all -> 0x0e5c }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0e5c }
            r9 = 2
            r8[r9] = r5     // Catch:{ all -> 0x0e5c }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r8)     // Catch:{ all -> 0x0e5c }
            r3 = 44
            byte r5 = r1[r3]     // Catch:{ all -> 0x0e4e }
            byte r3 = (byte) r5     // Catch:{ all -> 0x0e4e }
            r5 = 623(0x26f, float:8.73E-43)
            byte r8 = r1[r5]     // Catch:{ all -> 0x0e4e }
            byte r5 = (byte) r8     // Catch:{ all -> 0x0e4e }
            java.lang.String r3 = $$c(r7, r3, r5)     // Catch:{ all -> 0x0e4e }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x0e4e }
            r5 = 775(0x307, float:1.086E-42)
            short r5 = (short) r5     // Catch:{ all -> 0x0e4e }
            r8 = 418(0x1a2, float:5.86E-43)
            byte r8 = r1[r8]     // Catch:{ all -> 0x0e4e }
            byte r8 = (byte) r8     // Catch:{ all -> 0x0e4e }
            byte r9 = r1[r26]     // Catch:{ all -> 0x0e4e }
            byte r9 = (byte) r9     // Catch:{ all -> 0x0e4e }
            java.lang.String r8 = $$c(r5, r8, r9)     // Catch:{ all -> 0x0e4e }
            r9 = 0
            java.lang.reflect.Method r3 = r3.getMethod(r8, r9)     // Catch:{ all -> 0x0e4e }
            java.lang.Object r3 = r3.invoke(r4, r9)     // Catch:{ all -> 0x0e4e }
            int r8 = setUserEmails
            r9 = 3
            r10 = r8 & 3
            r8 = r8 | r9
            int r10 = r10 + r8
            r8 = 128(0x80, float:1.794E-43)
            int r10 = r10 % r8
            setAppInviteOneLink = r10
            r8 = 44
            byte r9 = r1[r8]     // Catch:{ all -> 0x0e3d }
            byte r8 = (byte) r9     // Catch:{ all -> 0x0e3d }
            r9 = 623(0x26f, float:8.73E-43)
            byte r10 = r1[r9]     // Catch:{ all -> 0x0e3d }
            byte r9 = (byte) r10     // Catch:{ all -> 0x0e3d }
            java.lang.String r8 = $$c(r7, r8, r9)     // Catch:{ all -> 0x0e3d }
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ all -> 0x0e3d }
            r9 = 418(0x1a2, float:5.86E-43)
            byte r9 = r1[r9]     // Catch:{ all -> 0x0e3d }
            byte r9 = (byte) r9     // Catch:{ all -> 0x0e3d }
            byte r10 = r1[r26]     // Catch:{ all -> 0x0e3d }
            byte r10 = (byte) r10     // Catch:{ all -> 0x0e3d }
            java.lang.String r5 = $$c(r5, r9, r10)     // Catch:{ all -> 0x0e3d }
            r9 = 0
            java.lang.reflect.Method r5 = r8.getMethod(r5, r9)     // Catch:{ all -> 0x0e3d }
            r8 = r51
            java.lang.Object r5 = r5.invoke(r8, r9)     // Catch:{ all -> 0x0e38 }
            r9 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0e33 }
            r11 = 3
            java.lang.Object[] r12 = new java.lang.Object[r11]     // Catch:{ all -> 0x0e33 }
            r12[r9] = r3     // Catch:{ all -> 0x0e33 }
            r3 = 1
            r12[r3] = r5     // Catch:{ all -> 0x0e33 }
            r5 = 2
            r12[r5] = r10     // Catch:{ all -> 0x0e33 }
            r5 = 0
            java.lang.Object r2 = r2.invoke(r5, r12)     // Catch:{ all -> 0x0e33 }
            int r5 = setAppInviteOneLink
            r9 = r5 ^ 53
            r5 = r5 & 53
            int r5 = r5 << r3
            int r9 = r9 + r5
            r3 = 128(0x80, float:1.794E-43)
            int r9 = r9 % r3
            setUserEmails = r9
            r3 = 44
            byte r5 = r1[r3]     // Catch:{ all -> 0x0e27 }
            byte r3 = (byte) r5     // Catch:{ all -> 0x0e27 }
            r5 = 623(0x26f, float:8.73E-43)
            byte r9 = r1[r5]     // Catch:{ all -> 0x0e27 }
            byte r5 = (byte) r9     // Catch:{ all -> 0x0e27 }
            java.lang.String r3 = $$c(r7, r3, r5)     // Catch:{ all -> 0x0e27 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x0e27 }
            r5 = 668(0x29c, float:9.36E-43)
            short r5 = (short) r5     // Catch:{ all -> 0x0e27 }
            r9 = 49
            byte r10 = r1[r9]     // Catch:{ all -> 0x0e27 }
            byte r9 = (byte) r10     // Catch:{ all -> 0x0e27 }
            r10 = 410(0x19a, float:5.75E-43)
            byte r11 = r1[r10]     // Catch:{ all -> 0x0e27 }
            byte r10 = (byte) r11     // Catch:{ all -> 0x0e27 }
            java.lang.String r9 = $$c(r5, r9, r10)     // Catch:{ all -> 0x0e27 }
            r10 = 0
            java.lang.reflect.Method r3 = r3.getMethod(r9, r10)     // Catch:{ all -> 0x0e27 }
            java.lang.Object r3 = r3.invoke(r4, r10)     // Catch:{ all -> 0x0e27 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0e27 }
            r3.booleanValue()     // Catch:{ all -> 0x0e27 }
            r3 = 44
            byte r4 = r1[r3]     // Catch:{ all -> 0x0e1b }
            byte r3 = (byte) r4     // Catch:{ all -> 0x0e1b }
            r4 = 623(0x26f, float:8.73E-43)
            byte r9 = r1[r4]     // Catch:{ all -> 0x0e1b }
            byte r4 = (byte) r9     // Catch:{ all -> 0x0e1b }
            java.lang.String r3 = $$c(r7, r3, r4)     // Catch:{ all -> 0x0e1b }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x0e1b }
            r4 = 49
            byte r9 = r1[r4]     // Catch:{ all -> 0x0e1b }
            byte r4 = (byte) r9     // Catch:{ all -> 0x0e1b }
            r9 = 410(0x19a, float:5.75E-43)
            byte r10 = r1[r9]     // Catch:{ all -> 0x0e1b }
            byte r9 = (byte) r10     // Catch:{ all -> 0x0e1b }
            java.lang.String r4 = $$c(r5, r4, r9)     // Catch:{ all -> 0x0e1b }
            r5 = 0
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ all -> 0x0e1b }
            java.lang.Object r3 = r3.invoke(r8, r5)     // Catch:{ all -> 0x0e1b }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0e1b }
            r3.booleanValue()     // Catch:{ all -> 0x0e1b }
            java.lang.Object r3 = updateServerUninstallToken     // Catch:{ all -> 0x0e17 }
            if (r3 != 0) goto L_0x0e05
            java.lang.Class<java.lang.Class> r3 = java.lang.Class.class
            r4 = 645(0x285, float:9.04E-43)
            short r4 = (short) r4     // Catch:{ all -> 0x0df9 }
            byte r5 = r1[r25]     // Catch:{ all -> 0x0df9 }
            byte r5 = (byte) r5     // Catch:{ all -> 0x0df9 }
            byte r1 = r1[r26]     // Catch:{ all -> 0x0df9 }
            byte r1 = (byte) r1     // Catch:{ all -> 0x0df9 }
            java.lang.String r1 = $$c(r4, r5, r1)     // Catch:{ all -> 0x0df9 }
            r4 = 0
            java.lang.reflect.Method r1 = r3.getMethod(r1, r4)     // Catch:{ all -> 0x0df9 }
            r5 = r49
            java.lang.Object r1 = r1.invoke(r5, r4)     // Catch:{ all -> 0x0df6 }
            updateServerUninstallToken = r1     // Catch:{ all -> 0x0df2 }
            goto L_0x0e07
        L_0x0df2:
            r0 = move-exception
        L_0x0df3:
            r1 = r0
            goto L_0x03d2
        L_0x0df6:
            r0 = move-exception
        L_0x0df7:
            r1 = r0
            goto L_0x0dfd
        L_0x0df9:
            r0 = move-exception
            r5 = r49
            goto L_0x0df7
        L_0x0dfd:
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0df2 }
            if (r2 == 0) goto L_0x0e04
            throw r2     // Catch:{ all -> 0x0df2 }
        L_0x0e04:
            throw r1     // Catch:{ all -> 0x0df2 }
        L_0x0e05:
            r5 = r49
        L_0x0e07:
            int r1 = setUserEmails
            r3 = r1 & 79
            r1 = r1 | 79
            int r3 = r3 + r1
            r1 = 128(0x80, float:1.794E-43)
            int r3 = r3 % r1
            setAppInviteOneLink = r3
            r12 = r50
            goto L_0x130f
        L_0x0e17:
            r0 = move-exception
            r5 = r49
            goto L_0x0df3
        L_0x0e1b:
            r0 = move-exception
            r5 = r49
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0df2 }
            if (r2 == 0) goto L_0x0e26
            throw r2     // Catch:{ all -> 0x0df2 }
        L_0x0e26:
            throw r1     // Catch:{ all -> 0x0df2 }
        L_0x0e27:
            r0 = move-exception
            r5 = r49
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0df2 }
            if (r2 == 0) goto L_0x0e32
            throw r2     // Catch:{ all -> 0x0df2 }
        L_0x0e32:
            throw r1     // Catch:{ all -> 0x0df2 }
        L_0x0e33:
            r0 = move-exception
            r5 = r49
            goto L_0x0b3b
        L_0x0e38:
            r0 = move-exception
            r5 = r49
        L_0x0e3b:
            r1 = r0
            goto L_0x0e43
        L_0x0e3d:
            r0 = move-exception
            r5 = r49
            r8 = r51
            goto L_0x0e3b
        L_0x0e43:
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0e4a }
            if (r2 == 0) goto L_0x0e4d
            throw r2     // Catch:{ all -> 0x0e4a }
        L_0x0e4a:
            r0 = move-exception
            goto L_0x0b3b
        L_0x0e4d:
            throw r1     // Catch:{ all -> 0x0e4a }
        L_0x0e4e:
            r0 = move-exception
            r5 = r49
            r8 = r51
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0e4a }
            if (r2 == 0) goto L_0x0e5b
            throw r2     // Catch:{ all -> 0x0e4a }
        L_0x0e5b:
            throw r1     // Catch:{ all -> 0x0e4a }
        L_0x0e5c:
            r0 = move-exception
            r5 = r49
            r8 = r51
            goto L_0x0b3b
        L_0x0e63:
            r0 = move-exception
            r5 = r49
            r8 = r51
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0e4a }
            if (r2 == 0) goto L_0x0e70
            throw r2     // Catch:{ all -> 0x0e4a }
        L_0x0e70:
            throw r1     // Catch:{ all -> 0x0e4a }
        L_0x0e71:
            r0 = move-exception
            r5 = r49
            r8 = r51
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0e4a }
            if (r2 == 0) goto L_0x0e7e
            throw r2     // Catch:{ all -> 0x0e4a }
        L_0x0e7e:
            throw r1     // Catch:{ all -> 0x0e4a }
        L_0x0e7f:
            r0 = move-exception
            r5 = r49
            r8 = r51
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0e4a }
            if (r2 == 0) goto L_0x0e8c
            throw r2     // Catch:{ all -> 0x0e4a }
        L_0x0e8c:
            throw r1     // Catch:{ all -> 0x0e4a }
        L_0x0e8d:
            r0 = move-exception
            r5 = r8
            r8 = r1
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x0e98 }
            if (r2 == 0) goto L_0x0e9b
            throw r2     // Catch:{ Exception -> 0x0e98 }
        L_0x0e98:
            r0 = move-exception
            r1 = r0
            goto L_0x0e9c
        L_0x0e9b:
            throw r1     // Catch:{ Exception -> 0x0e98 }
        L_0x0e9c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0e4a }
            r2.<init>()     // Catch:{ all -> 0x0e4a }
            r3 = 408(0x198, float:5.72E-43)
            short r3 = (short) r3     // Catch:{ all -> 0x0e4a }
            byte[] r9 = getOutOfStore     // Catch:{ all -> 0x0e4a }
            byte r10 = r9[r34]     // Catch:{ all -> 0x0e4a }
            byte r10 = (byte) r10     // Catch:{ all -> 0x0e4a }
            r11 = 190(0xbe, float:2.66E-43)
            byte r12 = r9[r11]     // Catch:{ all -> 0x0e4a }
            byte r11 = (byte) r12     // Catch:{ all -> 0x0e4a }
            java.lang.String r3 = $$c(r3, r10, r11)     // Catch:{ all -> 0x0e4a }
            r2.append(r3)     // Catch:{ all -> 0x0e4a }
            r2.append(r4)     // Catch:{ all -> 0x0e4a }
            r3 = 305(0x131, float:4.27E-43)
            short r3 = (short) r3     // Catch:{ all -> 0x0e4a }
            int r10 = waitForCustomerUserId     // Catch:{ all -> 0x0e4a }
            r11 = 1
            r12 = r10 ^ 1
            r10 = r10 & r11
            int r10 = r10 << r11
            int r12 = r12 + r10
            byte r10 = (byte) r12     // Catch:{ all -> 0x0e4a }
            r11 = 78
            byte r11 = (byte) r11     // Catch:{ all -> 0x0e4a }
            java.lang.String r3 = $$c(r3, r10, r11)     // Catch:{ all -> 0x0e4a }
            r2.append(r3)     // Catch:{ all -> 0x0e4a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0e4a }
            r3 = 2
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ all -> 0x0f06 }
            r3 = 1
            r10[r3] = r1     // Catch:{ all -> 0x0f06 }
            r1 = 0
            r10[r1] = r2     // Catch:{ all -> 0x0f06 }
            r1 = 850(0x352, float:1.191E-42)
            short r2 = (short) r1     // Catch:{ all -> 0x0f06 }
            r1 = 15
            byte r3 = r9[r1]     // Catch:{ all -> 0x0f06 }
            byte r1 = (byte) r3     // Catch:{ all -> 0x0f06 }
            r3 = 623(0x26f, float:8.73E-43)
            byte r9 = r9[r3]     // Catch:{ all -> 0x0f06 }
            byte r3 = (byte) r9     // Catch:{ all -> 0x0f06 }
            java.lang.String r1 = $$c(r2, r1, r3)     // Catch:{ all -> 0x0f06 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0f06 }
            r2 = 2
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ all -> 0x0f06 }
            r2 = 0
            r3[r2] = r6     // Catch:{ all -> 0x0f06 }
            java.lang.Class<java.lang.Throwable> r2 = java.lang.Throwable.class
            r9 = 1
            r3[r9] = r2     // Catch:{ all -> 0x0f06 }
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r3)     // Catch:{ all -> 0x0f06 }
            java.lang.Object r1 = r1.newInstance(r10)     // Catch:{ all -> 0x0f06 }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x0f06 }
            throw r1     // Catch:{ all -> 0x0f06 }
        L_0x0f06:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0e4a }
            if (r2 == 0) goto L_0x0f0f
            throw r2     // Catch:{ all -> 0x0e4a }
        L_0x0f0f:
            throw r1     // Catch:{ all -> 0x0e4a }
        L_0x0f10:
            byte[] r2 = getOutOfStore     // Catch:{ all -> 0x0f8f }
            r3 = 44
            byte r9 = r2[r3]     // Catch:{ all -> 0x0f9b }
            byte r3 = (byte) r9
            r9 = 623(0x26f, float:8.73E-43)
            byte r10 = r2[r9]     // Catch:{ all -> 0x0f8f }
            byte r9 = (byte) r10     // Catch:{ all -> 0x0f8f }
            java.lang.String r3 = $$c(r7, r3, r9)     // Catch:{ all -> 0x0f8f }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x0f8f }
            r9 = 668(0x29c, float:9.36E-43)
            short r9 = (short) r9
            r10 = 49
            byte r11 = r2[r10]     // Catch:{ all -> 0x0f96 }
            byte r10 = (byte) r11
            r11 = 410(0x19a, float:5.75E-43)
            byte r12 = r2[r11]     // Catch:{ all -> 0x0f8f }
            byte r11 = (byte) r12     // Catch:{ all -> 0x0f8f }
            java.lang.String r10 = $$c(r9, r10, r11)     // Catch:{ all -> 0x0f8f }
            r11 = 0
            java.lang.reflect.Method r3 = r3.getMethod(r10, r11)     // Catch:{ all -> 0x0f8f }
            java.lang.Object r3 = r3.invoke(r4, r11)     // Catch:{ all -> 0x0f8f }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0f8f }
            r3.booleanValue()     // Catch:{ all -> 0x0f8f }
            int r3 = setAppInviteOneLink
            r4 = r3 ^ 7
            r3 = r3 & 7
            r10 = 1
            int r3 = r3 << r10
            int r4 = r4 + r3
            r3 = 128(0x80, float:1.794E-43)
            int r4 = r4 % r3
            setUserEmails = r4
            r4 = 44
            byte r3 = r2[r4]     // Catch:{ all -> 0x0f83 }
            byte r3 = (byte) r3     // Catch:{ all -> 0x0f83 }
            r10 = 623(0x26f, float:8.73E-43)
            byte r11 = r2[r10]     // Catch:{ all -> 0x0f83 }
            byte r10 = (byte) r11     // Catch:{ all -> 0x0f83 }
            java.lang.String r3 = $$c(r7, r3, r10)     // Catch:{ all -> 0x0f83 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x0f83 }
            r11 = 49
            byte r10 = r2[r11]     // Catch:{ all -> 0x0f80 }
            byte r10 = (byte) r10     // Catch:{ all -> 0x0f80 }
            r12 = 410(0x19a, float:5.75E-43)
            byte r2 = r2[r12]     // Catch:{ all -> 0x0f80 }
            byte r2 = (byte) r2     // Catch:{ all -> 0x0f80 }
            java.lang.String r2 = $$c(r9, r10, r2)     // Catch:{ all -> 0x0f80 }
            r9 = 0
            java.lang.reflect.Method r2 = r3.getMethod(r2, r9)     // Catch:{ all -> 0x0f80 }
            java.lang.Object r2 = r2.invoke(r8, r9)     // Catch:{ all -> 0x0f80 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x0f80 }
            r2.booleanValue()     // Catch:{ all -> 0x0f80 }
            throw r1     // Catch:{ all -> 0x0df2 }
        L_0x0f80:
            r0 = move-exception
        L_0x0f81:
            r1 = r0
            goto L_0x0f87
        L_0x0f83:
            r0 = move-exception
            r11 = 49
            goto L_0x0f81
        L_0x0f87:
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0df2 }
            if (r2 == 0) goto L_0x0f8e
            throw r2     // Catch:{ all -> 0x0df2 }
        L_0x0f8e:
            throw r1     // Catch:{ all -> 0x0df2 }
        L_0x0f8f:
            r0 = move-exception
            r4 = 44
        L_0x0f92:
            r11 = 49
        L_0x0f94:
            r1 = r0
            goto L_0x0f9e
        L_0x0f96:
            r0 = move-exception
            r11 = r10
            r4 = 44
            goto L_0x0f94
        L_0x0f9b:
            r0 = move-exception
            r4 = r3
            goto L_0x0f92
        L_0x0f9e:
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0df2 }
            if (r2 == 0) goto L_0x0fa5
            throw r2     // Catch:{ all -> 0x0df2 }
        L_0x0fa5:
            throw r1     // Catch:{ all -> 0x0df2 }
        L_0x0fa6:
            r0 = move-exception
            r5 = r8
            r4 = 44
            r11 = 49
            goto L_0x0df3
        L_0x0fae:
            r50 = r2
            r40 = r5
            r5 = r8
            r48 = r12
            r4 = 44
            r11 = 49
            java.util.zip.ZipInputStream r1 = new java.util.zip.ZipInputStream     // Catch:{ all -> 0x1532 }
            r1.<init>(r3)     // Catch:{ all -> 0x1532 }
            java.util.zip.ZipEntry r2 = r1.getNextEntry()     // Catch:{ all -> 0x1532 }
            int r3 = setUserEmails
            int r3 = r3 + 97
            r8 = 128(0x80, float:1.794E-43)
            int r3 = r3 % r8
            setAppInviteOneLink = r3
            r3 = 1
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ all -> 0x1642 }
            r3 = 0
            r8[r3] = r1     // Catch:{ all -> 0x1642 }
            r1 = 896(0x380, float:1.256E-42)
            byte r3 = r10[r1]     // Catch:{ all -> 0x1642 }
            short r1 = (short) r3     // Catch:{ all -> 0x1642 }
            r3 = 2
            byte r9 = r10[r3]     // Catch:{ all -> 0x1642 }
            byte r3 = (byte) r9     // Catch:{ all -> 0x1642 }
            r9 = 623(0x26f, float:8.73E-43)
            byte r12 = r10[r9]     // Catch:{ all -> 0x1642 }
            byte r12 = (byte) r12     // Catch:{ all -> 0x1642 }
            java.lang.String r1 = $$c(r1, r3, r12)     // Catch:{ all -> 0x1642 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x1642 }
            r3 = 15
            byte r12 = r10[r3]     // Catch:{ all -> 0x1642 }
            byte r3 = (byte) r12     // Catch:{ all -> 0x1642 }
            byte r12 = r10[r9]     // Catch:{ all -> 0x1642 }
            byte r9 = (byte) r12     // Catch:{ all -> 0x1642 }
            r12 = r50
            java.lang.String r3 = $$c(r12, r3, r9)     // Catch:{ all -> 0x1642 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x1642 }
            r9 = 1
            java.lang.Class[] r13 = new java.lang.Class[r9]     // Catch:{ all -> 0x1642 }
            r9 = 0
            r13[r9] = r3     // Catch:{ all -> 0x1642 }
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r13)     // Catch:{ all -> 0x1642 }
            java.lang.Object r1 = r1.newInstance(r8)     // Catch:{ all -> 0x1642 }
            int r3 = setUserEmails
            r8 = r3 & 103(0x67, float:1.44E-43)
            r3 = r3 | 103(0x67, float:1.44E-43)
            int r8 = r8 + r3
            r3 = 128(0x80, float:1.794E-43)
            int r8 = r8 % r3
            setAppInviteOneLink = r8
            int r3 = waitForCustomerUserId     // Catch:{ all -> 0x1636 }
            r8 = r3 ^ 533(0x215, float:7.47E-43)
            r3 = r3 & 533(0x215, float:7.47E-43)
            r3 = r3 | r8
            short r3 = (short) r3     // Catch:{ all -> 0x1636 }
            r8 = 120(0x78, float:1.68E-43)
            byte r9 = r10[r8]     // Catch:{ all -> 0x1636 }
            byte r8 = (byte) r9     // Catch:{ all -> 0x1636 }
            r9 = 623(0x26f, float:8.73E-43)
            byte r10 = r10[r9]     // Catch:{ all -> 0x1636 }
            byte r9 = (byte) r10     // Catch:{ all -> 0x1636 }
            java.lang.String r3 = $$c(r3, r8, r9)     // Catch:{ all -> 0x1636 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x1636 }
            r8 = 0
            java.lang.reflect.Constructor r3 = r3.getDeclaredConstructor(r8)     // Catch:{ all -> 0x1636 }
            java.lang.Object r3 = r3.newInstance(r8)     // Catch:{ all -> 0x1636 }
            r8 = 1024(0x400, float:1.435E-42)
            byte[] r9 = new byte[r8]     // Catch:{ all -> 0x1532 }
            r10 = 0
        L_0x103b:
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]     // Catch:{ all -> 0x162a }
            r13 = 0
            r14[r13] = r9     // Catch:{ all -> 0x162a }
            byte[] r13 = getOutOfStore     // Catch:{ all -> 0x162a }
            r15 = 896(0x380, float:1.256E-42)
            byte r4 = r13[r15]     // Catch:{ all -> 0x162a }
            short r4 = (short) r4     // Catch:{ all -> 0x162a }
            r15 = 2
            byte r8 = r13[r15]     // Catch:{ all -> 0x162a }
            byte r8 = (byte) r8     // Catch:{ all -> 0x162a }
            r15 = 623(0x26f, float:8.73E-43)
            byte r11 = r13[r15]     // Catch:{ all -> 0x162a }
            byte r11 = (byte) r11     // Catch:{ all -> 0x162a }
            java.lang.String r4 = $$c(r4, r8, r11)     // Catch:{ all -> 0x162a }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x162a }
            r8 = 270(0x10e, float:3.78E-43)
            short r8 = (short) r8     // Catch:{ all -> 0x162a }
            r11 = 99
            byte r15 = r13[r11]     // Catch:{ all -> 0x162a }
            byte r11 = (byte) r15     // Catch:{ all -> 0x162a }
            r15 = 118(0x76, float:1.65E-43)
            byte r15 = r13[r15]     // Catch:{ all -> 0x162a }
            byte r15 = (byte) r15     // Catch:{ all -> 0x162a }
            java.lang.String r8 = $$c(r8, r11, r15)     // Catch:{ all -> 0x162a }
            r11 = 1
            java.lang.Class[] r15 = new java.lang.Class[r11]     // Catch:{ all -> 0x162a }
            r11 = 0
            r15[r11] = r19     // Catch:{ all -> 0x162a }
            java.lang.reflect.Method r4 = r4.getMethod(r8, r15)     // Catch:{ all -> 0x162a }
            java.lang.Object r4 = r4.invoke(r1, r14)     // Catch:{ all -> 0x162a }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x162a }
            int r8 = r4.intValue()     // Catch:{ all -> 0x162a }
            if (r8 <= 0) goto L_0x10fa
            long r14 = (long) r10
            long r49 = r2.getSize()     // Catch:{ all -> 0x10fc }
            int r11 = (r14 > r49 ? 1 : (r14 == r49 ? 0 : -1))
            if (r11 >= 0) goto L_0x10fa
            r11 = 3
            java.lang.Object[] r14 = new java.lang.Object[r11]     // Catch:{ all -> 0x10ec }
            r11 = 2
            r14[r11] = r4     // Catch:{ all -> 0x10ef }
            r4 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x10ef }
            r15 = 1
            r14[r15] = r11     // Catch:{ all -> 0x10ef }
            r14[r4] = r9     // Catch:{ all -> 0x10ef }
            int r4 = waitForCustomerUserId     // Catch:{ all -> 0x10ef }
            r11 = r4 ^ 533(0x215, float:7.47E-43)
            r4 = r4 & 533(0x215, float:7.47E-43)
            r4 = r4 | r11
            short r4 = (short) r4     // Catch:{ all -> 0x10ef }
            r11 = 120(0x78, float:1.68E-43)
            byte r15 = r13[r11]     // Catch:{ all -> 0x10ef }
            byte r11 = (byte) r15     // Catch:{ all -> 0x10ef }
            r49 = r2
            r15 = 623(0x26f, float:8.73E-43)
            byte r2 = r13[r15]     // Catch:{ all -> 0x10ef }
            byte r2 = (byte) r2     // Catch:{ all -> 0x10ef }
            java.lang.String r2 = $$c(r4, r11, r2)     // Catch:{ all -> 0x10ef }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x10ef }
            r4 = 256(0x100, float:3.59E-43)
            short r4 = (short) r4     // Catch:{ all -> 0x10ef }
            byte r11 = r13[r34]     // Catch:{ all -> 0x10ef }
            byte r11 = (byte) r11     // Catch:{ all -> 0x10ef }
            r15 = 71
            byte r13 = r13[r15]     // Catch:{ all -> 0x10ef }
            byte r13 = (byte) r13     // Catch:{ all -> 0x10ef }
            java.lang.String r4 = $$c(r4, r11, r13)     // Catch:{ all -> 0x10ef }
            r11 = 3
            java.lang.Class[] r13 = new java.lang.Class[r11]     // Catch:{ all -> 0x10ec }
            r15 = 0
            r13[r15] = r19     // Catch:{ all -> 0x10ec }
            java.lang.Class r15 = java.lang.Integer.TYPE     // Catch:{ all -> 0x10ec }
            r27 = 1
            r13[r27] = r15     // Catch:{ all -> 0x10ec }
            r27 = 2
            r13[r27] = r15     // Catch:{ all -> 0x10ec }
            java.lang.reflect.Method r2 = r2.getMethod(r4, r13)     // Catch:{ all -> 0x10ec }
            r2.invoke(r3, r14)     // Catch:{ all -> 0x10ec }
            int r2 = -r8
            int r2 = -r2
            r4 = r10 & r2
            r2 = r2 | r10
            int r10 = r4 + r2
            r2 = r49
            r4 = 44
            r8 = 1024(0x400, float:1.435E-42)
            r11 = 49
            goto L_0x103b
        L_0x10ec:
            r0 = move-exception
        L_0x10ed:
            r1 = r0
            goto L_0x10f2
        L_0x10ef:
            r0 = move-exception
            r11 = 3
            goto L_0x10ed
        L_0x10f2:
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0df2 }
            if (r2 == 0) goto L_0x10f9
            throw r2     // Catch:{ all -> 0x0df2 }
        L_0x10f9:
            throw r1     // Catch:{ all -> 0x0df2 }
        L_0x10fa:
            r11 = 3
            goto L_0x1100
        L_0x10fc:
            r0 = move-exception
            r11 = 3
            goto L_0x0df3
        L_0x1100:
            int r2 = waitForCustomerUserId     // Catch:{ all -> 0x161e }
            r4 = r2 ^ 533(0x215, float:7.47E-43)
            r2 = r2 & 533(0x215, float:7.47E-43)
            r2 = r2 | r4
            short r2 = (short) r2     // Catch:{ all -> 0x161e }
            r4 = 120(0x78, float:1.68E-43)
            byte r8 = r13[r4]     // Catch:{ all -> 0x161e }
            byte r4 = (byte) r8     // Catch:{ all -> 0x161e }
            r8 = 623(0x26f, float:8.73E-43)
            byte r9 = r13[r8]     // Catch:{ all -> 0x161e }
            byte r8 = (byte) r9     // Catch:{ all -> 0x161e }
            java.lang.String r2 = $$c(r2, r4, r8)     // Catch:{ all -> 0x161e }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x161e }
            r4 = 968(0x3c8, float:1.356E-42)
            short r4 = (short) r4     // Catch:{ all -> 0x161e }
            r8 = 896(0x380, float:1.256E-42)
            byte r9 = r13[r8]     // Catch:{ all -> 0x161e }
            byte r8 = (byte) r9     // Catch:{ all -> 0x161e }
            r9 = 66
            byte r10 = r13[r9]     // Catch:{ all -> 0x161e }
            byte r9 = (byte) r10     // Catch:{ all -> 0x161e }
            java.lang.String r4 = $$c(r4, r8, r9)     // Catch:{ all -> 0x161e }
            r8 = 0
            java.lang.reflect.Method r2 = r2.getMethod(r4, r8)     // Catch:{ all -> 0x161e }
            java.lang.Object r2 = r2.invoke(r3, r8)     // Catch:{ all -> 0x161e }
            r4 = 896(0x380, float:1.256E-42)
            byte r8 = r13[r4]     // Catch:{ all -> 0x1160 }
            short r8 = (short) r8     // Catch:{ all -> 0x1160 }
            r9 = 2
            byte r10 = r13[r9]     // Catch:{ all -> 0x1160 }
            byte r9 = (byte) r10     // Catch:{ all -> 0x1160 }
            r10 = 623(0x26f, float:8.73E-43)
            byte r14 = r13[r10]     // Catch:{ all -> 0x1160 }
            byte r10 = (byte) r14     // Catch:{ all -> 0x1160 }
            java.lang.String r8 = $$c(r8, r9, r10)     // Catch:{ all -> 0x1160 }
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ all -> 0x1160 }
            r9 = 723(0x2d3, float:1.013E-42)
            short r10 = (short) r9     // Catch:{ all -> 0x1160 }
            byte r9 = r13[r34]     // Catch:{ all -> 0x1160 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x1160 }
            byte r13 = r13[r22]     // Catch:{ all -> 0x1160 }
            byte r13 = (byte) r13     // Catch:{ all -> 0x1160 }
            java.lang.String r9 = $$c(r10, r9, r13)     // Catch:{ all -> 0x1160 }
            r10 = 0
            java.lang.reflect.Method r8 = r8.getMethod(r9, r10)     // Catch:{ all -> 0x1160 }
            r8.invoke(r1, r10)     // Catch:{ all -> 0x1160 }
            goto L_0x116a
        L_0x1160:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r8 = r1.getCause()     // Catch:{ IOException -> 0x116a }
            if (r8 == 0) goto L_0x1169
            throw r8     // Catch:{ IOException -> 0x116a }
        L_0x1169:
            throw r1     // Catch:{ IOException -> 0x116a }
        L_0x116a:
            int r1 = waitForCustomerUserId     // Catch:{ all -> 0x119c }
            r8 = r1 ^ 533(0x215, float:7.47E-43)
            r1 = r1 & 533(0x215, float:7.47E-43)
            r1 = r1 | r8
            short r1 = (short) r1     // Catch:{ all -> 0x119c }
            byte[] r8 = getOutOfStore     // Catch:{ all -> 0x119c }
            r9 = 120(0x78, float:1.68E-43)
            byte r10 = r8[r9]     // Catch:{ all -> 0x119c }
            byte r9 = (byte) r10     // Catch:{ all -> 0x119c }
            r10 = 623(0x26f, float:8.73E-43)
            byte r13 = r8[r10]     // Catch:{ all -> 0x119c }
            byte r10 = (byte) r13     // Catch:{ all -> 0x119c }
            java.lang.String r1 = $$c(r1, r9, r10)     // Catch:{ all -> 0x119c }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x119c }
            r9 = 723(0x2d3, float:1.013E-42)
            short r10 = (short) r9     // Catch:{ all -> 0x119c }
            byte r9 = r8[r34]     // Catch:{ all -> 0x119c }
            byte r9 = (byte) r9     // Catch:{ all -> 0x119c }
            byte r8 = r8[r22]     // Catch:{ all -> 0x119c }
            byte r8 = (byte) r8     // Catch:{ all -> 0x119c }
            java.lang.String r8 = $$c(r10, r9, r8)     // Catch:{ all -> 0x119c }
            r9 = 0
            java.lang.reflect.Method r1 = r1.getMethod(r8, r9)     // Catch:{ all -> 0x119c }
            r1.invoke(r3, r9)     // Catch:{ all -> 0x119c }
            goto L_0x11a6
        L_0x119c:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r3 = r1.getCause()     // Catch:{ IOException -> 0x11a6 }
            if (r3 == 0) goto L_0x11a5
            throw r3     // Catch:{ IOException -> 0x11a6 }
        L_0x11a5:
            throw r1     // Catch:{ IOException -> 0x11a6 }
        L_0x11a6:
            java.lang.Class<java.lang.Class> r1 = java.lang.Class.class
            r3 = 645(0x285, float:9.04E-43)
            short r3 = (short) r3     // Catch:{ all -> 0x1612 }
            byte[] r8 = getOutOfStore     // Catch:{ all -> 0x1612 }
            byte r9 = r8[r25]     // Catch:{ all -> 0x1612 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x1612 }
            byte r10 = r8[r26]     // Catch:{ all -> 0x1612 }
            byte r10 = (byte) r10     // Catch:{ all -> 0x1612 }
            java.lang.String r3 = $$c(r3, r9, r10)     // Catch:{ all -> 0x1612 }
            r9 = 0
            java.lang.reflect.Method r1 = r1.getMethod(r3, r9)     // Catch:{ all -> 0x1612 }
            java.lang.Object r1 = r1.invoke(r5, r9)     // Catch:{ all -> 0x1612 }
            r3 = 165(0xa5, float:2.31E-43)
            short r3 = (short) r3
            r9 = 71
            byte r10 = r8[r9]     // Catch:{ all -> 0x1532 }
            byte r9 = (byte) r10     // Catch:{ all -> 0x1532 }
            r10 = 410(0x19a, float:5.75E-43)
            byte r13 = r8[r10]     // Catch:{ all -> 0x1532 }
            byte r10 = (byte) r13     // Catch:{ all -> 0x1532 }
            java.lang.String r3 = $$c(r3, r9, r10)     // Catch:{ all -> 0x1532 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x1532 }
            r9 = 83
            short r9 = (short) r9     // Catch:{ all -> 0x1532 }
            r10 = 15
            byte r13 = r8[r10]     // Catch:{ all -> 0x1532 }
            byte r10 = (byte) r13     // Catch:{ all -> 0x1532 }
            r13 = 623(0x26f, float:8.73E-43)
            byte r14 = r8[r13]     // Catch:{ all -> 0x1532 }
            byte r13 = (byte) r14     // Catch:{ all -> 0x1532 }
            java.lang.String r10 = $$c(r9, r10, r13)     // Catch:{ all -> 0x1532 }
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ all -> 0x1532 }
            r13 = 472(0x1d8, float:6.61E-43)
            short r13 = (short) r13     // Catch:{ all -> 0x1532 }
            r14 = 111(0x6f, float:1.56E-43)
            byte r15 = r8[r14]     // Catch:{ all -> 0x1532 }
            byte r14 = (byte) r15     // Catch:{ all -> 0x1532 }
            r15 = 623(0x26f, float:8.73E-43)
            byte r4 = r8[r15]     // Catch:{ all -> 0x1532 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x1532 }
            java.lang.String r4 = $$c(r13, r14, r4)     // Catch:{ all -> 0x1532 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x1532 }
            r13 = 2
            java.lang.Class[] r14 = new java.lang.Class[r13]     // Catch:{ all -> 0x160d }
            r13 = 0
            r14[r13] = r10     // Catch:{ all -> 0x160d }
            r10 = 1
            r14[r10] = r4     // Catch:{ all -> 0x160d }
            java.lang.reflect.Constructor r3 = r3.getDeclaredConstructor(r14)     // Catch:{ all -> 0x1532 }
            java.lang.Object[] r4 = new java.lang.Object[r10]     // Catch:{ all -> 0x1601 }
            r4[r13] = r2     // Catch:{ all -> 0x1601 }
            r2 = 15
            byte r10 = r8[r2]     // Catch:{ all -> 0x1601 }
            byte r2 = (byte) r10     // Catch:{ all -> 0x1601 }
            r10 = 623(0x26f, float:8.73E-43)
            byte r13 = r8[r10]     // Catch:{ all -> 0x1601 }
            byte r10 = (byte) r13     // Catch:{ all -> 0x1601 }
            java.lang.String r2 = $$c(r9, r2, r10)     // Catch:{ all -> 0x1601 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x1601 }
            int r9 = waitForCustomerUserId     // Catch:{ all -> 0x1601 }
            r10 = r9 ^ 964(0x3c4, float:1.351E-42)
            r13 = r9 & 964(0x3c4, float:1.351E-42)
            r10 = r10 | r13
            short r10 = (short) r10     // Catch:{ all -> 0x1601 }
            r13 = 99
            byte r14 = r8[r13]     // Catch:{ all -> 0x1601 }
            byte r14 = (byte) r14     // Catch:{ all -> 0x1601 }
            r15 = 71
            byte r11 = r8[r15]     // Catch:{ all -> 0x1601 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x1601 }
            java.lang.String r10 = $$c(r10, r14, r11)     // Catch:{ all -> 0x1601 }
            r11 = 1
            java.lang.Class[] r14 = new java.lang.Class[r11]     // Catch:{ all -> 0x1601 }
            r11 = 0
            r14[r11] = r19     // Catch:{ all -> 0x1601 }
            java.lang.reflect.Method r2 = r2.getMethod(r10, r14)     // Catch:{ all -> 0x1601 }
            r10 = 0
            java.lang.Object r2 = r2.invoke(r10, r4)     // Catch:{ all -> 0x1601 }
            r4 = 2
            java.lang.Object[] r10 = new java.lang.Object[r4]     // Catch:{ all -> 0x15fc }
            r10[r11] = r2     // Catch:{ all -> 0x15fc }
            r2 = 1
            r10[r2] = r1     // Catch:{ all -> 0x15fc }
            java.lang.Object r2 = r3.newInstance(r10)     // Catch:{ all -> 0x1532 }
            r3 = 334(0x14e, float:4.68E-43)
            short r3 = (short) r3
            r4 = 62
            byte r4 = r8[r4]     // Catch:{ Exception -> 0x1584 }
            byte r4 = (byte) r4     // Catch:{ Exception -> 0x1584 }
            r10 = 410(0x19a, float:5.75E-43)
            byte r11 = r8[r10]     // Catch:{ Exception -> 0x1584 }
            byte r10 = (byte) r11     // Catch:{ Exception -> 0x1584 }
            java.lang.String r3 = $$c(r3, r4, r10)     // Catch:{ Exception -> 0x1584 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ Exception -> 0x1584 }
            r4 = 889(0x379, float:1.246E-42)
            short r4 = (short) r4     // Catch:{ Exception -> 0x1584 }
            r10 = 888(0x378, float:1.244E-42)
            byte r10 = r8[r10]     // Catch:{ Exception -> 0x1584 }
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x1584 }
            r11 = 120(0x78, float:1.68E-43)
            byte r14 = r8[r11]     // Catch:{ Exception -> 0x1584 }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x1584 }
            java.lang.String r4 = $$c(r4, r10, r14)     // Catch:{ Exception -> 0x1584 }
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch:{ Exception -> 0x1584 }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x1584 }
            java.lang.Object r4 = r3.get(r1)     // Catch:{ Exception -> 0x1584 }
            java.lang.Class r10 = r4.getClass()     // Catch:{ Exception -> 0x1584 }
            r14 = 1001(0x3e9, float:1.403E-42)
            short r14 = (short) r14     // Catch:{ Exception -> 0x1584 }
            r15 = 21
            byte r11 = r8[r15]     // Catch:{ Exception -> 0x1584 }
            byte r11 = (byte) r11     // Catch:{ Exception -> 0x1584 }
            r18 = 2
            byte r13 = r8[r18]     // Catch:{ Exception -> 0x1584 }
            byte r13 = (byte) r13     // Catch:{ Exception -> 0x1584 }
            java.lang.String r11 = $$c(r14, r11, r13)     // Catch:{ Exception -> 0x1584 }
            java.lang.reflect.Field r11 = r10.getDeclaredField(r11)     // Catch:{ Exception -> 0x1584 }
            r13 = 1
            r11.setAccessible(r13)     // Catch:{ Exception -> 0x1584 }
            r13 = r9 ^ 665(0x299, float:9.32E-43)
            r9 = r9 & 665(0x299, float:9.32E-43)
            r9 = r9 | r13
            short r9 = (short) r9     // Catch:{ Exception -> 0x1584 }
            r13 = 109(0x6d, float:1.53E-43)
            byte r14 = r8[r13]     // Catch:{ Exception -> 0x1584 }
            byte r13 = (byte) r14     // Catch:{ Exception -> 0x1584 }
            r14 = 2
            byte r8 = r8[r14]     // Catch:{ Exception -> 0x1584 }
            byte r8 = (byte) r8     // Catch:{ Exception -> 0x1584 }
            java.lang.String r8 = $$c(r9, r13, r8)     // Catch:{ Exception -> 0x1584 }
            java.lang.reflect.Field r8 = r10.getDeclaredField(r8)     // Catch:{ Exception -> 0x1584 }
            r9 = 1
            r8.setAccessible(r9)     // Catch:{ Exception -> 0x1584 }
            java.lang.Object r9 = r11.get(r4)     // Catch:{ Exception -> 0x1584 }
            java.lang.Object r4 = r8.get(r4)     // Catch:{ Exception -> 0x1584 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ Exception -> 0x1584 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x1584 }
            java.util.List r9 = (java.util.List) r9     // Catch:{ Exception -> 0x1584 }
            r10.<init>(r9)     // Catch:{ Exception -> 0x1584 }
            java.lang.Class r9 = r4.getClass()     // Catch:{ Exception -> 0x1584 }
            java.lang.Class r9 = r9.getComponentType()     // Catch:{ Exception -> 0x1584 }
            int r13 = java.lang.reflect.Array.getLength(r4)     // Catch:{ Exception -> 0x1584 }
            java.lang.Object r9 = java.lang.reflect.Array.newInstance(r9, r13)     // Catch:{ Exception -> 0x1584 }
            r14 = 0
        L_0x12e1:
            if (r14 >= r13) goto L_0x1303
            java.lang.Object r15 = java.lang.reflect.Array.get(r4, r14)     // Catch:{ Exception -> 0x12fd }
            java.lang.reflect.Array.set(r9, r14, r15)     // Catch:{ Exception -> 0x12fd }
            r15 = r14 | -67
            r28 = 1
            int r15 = r15 << 1
            r14 = r14 ^ -67
            int r15 = r15 - r14
            r14 = r15 | 68
            int r14 = r14 << 1
            r15 = r15 ^ 68
            int r14 = r14 - r15
            r15 = 21
            goto L_0x12e1
        L_0x12fd:
            r0 = move-exception
            r2 = r0
            r13 = 12
            goto L_0x1588
        L_0x1303:
            r11.set(r3, r10)     // Catch:{ Exception -> 0x1584 }
            r8.set(r3, r9)     // Catch:{ Exception -> 0x1584 }
            java.lang.Object r1 = updateServerUninstallToken     // Catch:{ all -> 0x1532 }
            if (r1 != 0) goto L_0x130f
            updateServerUninstallToken = r2     // Catch:{ all -> 0x0df2 }
        L_0x130f:
            if (r48 == 0) goto L_0x13bc
            int r1 = setAppInviteOneLink
            r3 = 109(0x6d, float:1.53E-43)
            r4 = r1 | 109(0x6d, float:1.53E-43)
            r8 = 1
            int r4 = r4 << r8
            r1 = r1 ^ r3
            int r4 = r4 - r1
            r1 = 128(0x80, float:1.794E-43)
            int r4 = r4 % r1
            setUserEmails = r4
            r1 = 305(0x131, float:4.27E-43)
            short r3 = (short) r1
            byte[] r1 = getOutOfStore     // Catch:{ all -> 0x0df2 }
            r4 = 111(0x6f, float:1.56E-43)
            byte r8 = r1[r4]     // Catch:{ all -> 0x0df2 }
            byte r4 = (byte) r8     // Catch:{ all -> 0x0df2 }
            r8 = 410(0x19a, float:5.75E-43)
            byte r9 = r1[r8]     // Catch:{ all -> 0x0df2 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x0df2 }
            java.lang.String r3 = $$c(r3, r4, r9)     // Catch:{ all -> 0x0df2 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x0df2 }
            r4 = 978(0x3d2, float:1.37E-42)
            short r4 = (short) r4     // Catch:{ all -> 0x0df2 }
            r9 = 239(0xef, float:3.35E-43)
            byte r9 = r1[r9]     // Catch:{ all -> 0x0df2 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x0df2 }
            r10 = 109(0x6d, float:1.53E-43)
            byte r11 = r1[r10]     // Catch:{ all -> 0x0df2 }
            byte r10 = (byte) r11     // Catch:{ all -> 0x0df2 }
            java.lang.String r4 = $$c(r4, r9, r10)     // Catch:{ all -> 0x0df2 }
            r9 = 472(0x1d8, float:6.61E-43)
            short r9 = (short) r9     // Catch:{ all -> 0x0df2 }
            r10 = 111(0x6f, float:1.56E-43)
            byte r11 = r1[r10]     // Catch:{ all -> 0x0df2 }
            byte r10 = (byte) r11     // Catch:{ all -> 0x0df2 }
            r11 = 623(0x26f, float:8.73E-43)
            byte r13 = r1[r11]     // Catch:{ all -> 0x0df2 }
            byte r11 = (byte) r13     // Catch:{ all -> 0x0df2 }
            java.lang.String r9 = $$c(r9, r10, r11)     // Catch:{ all -> 0x0df2 }
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ all -> 0x0df2 }
            r10 = 2
            java.lang.Class[] r11 = new java.lang.Class[r10]     // Catch:{ all -> 0x13b9 }
            r10 = 0
            r11[r10] = r6     // Catch:{ all -> 0x13b9 }
            r10 = 1
            r11[r10] = r9     // Catch:{ all -> 0x13b9 }
            java.lang.reflect.Method r4 = r3.getDeclaredMethod(r4, r11)     // Catch:{ all -> 0x0df2 }
            java.lang.Class<java.lang.Class> r9 = java.lang.Class.class
            r10 = 645(0x285, float:9.04E-43)
            short r10 = (short) r10     // Catch:{ all -> 0x13af }
            byte r11 = r1[r25]     // Catch:{ all -> 0x13af }
            byte r11 = (byte) r11     // Catch:{ all -> 0x13af }
            byte r13 = r1[r26]     // Catch:{ all -> 0x13af }
            byte r13 = (byte) r13     // Catch:{ all -> 0x13af }
            java.lang.String r10 = $$c(r10, r11, r13)     // Catch:{ all -> 0x13af }
            r11 = 0
            java.lang.reflect.Method r9 = r9.getMethod(r10, r11)     // Catch:{ all -> 0x13af }
            java.lang.Object r9 = r9.invoke(r5, r11)     // Catch:{ all -> 0x13af }
            r10 = 2
            java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ all -> 0x13ac }
            r10 = 0
            r11[r10] = r40     // Catch:{ all -> 0x13ac }
            r10 = 1
            r11[r10] = r9     // Catch:{ all -> 0x13ac }
            java.lang.Object r4 = r4.invoke(r2, r11)     // Catch:{ all -> 0x0df2 }
            if (r4 == 0) goto L_0x13a6
            r9 = 723(0x2d3, float:1.013E-42)
            short r10 = (short) r9     // Catch:{ all -> 0x0df2 }
            byte r9 = r1[r34]     // Catch:{ all -> 0x0df2 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x0df2 }
            byte r1 = r1[r22]     // Catch:{ all -> 0x0df2 }
            byte r1 = (byte) r1     // Catch:{ all -> 0x0df2 }
            java.lang.String r1 = $$c(r10, r9, r1)     // Catch:{ all -> 0x0df2 }
            r9 = 0
            java.lang.reflect.Method r1 = r3.getDeclaredMethod(r1, r9)     // Catch:{ all -> 0x0df2 }
            r1.invoke(r2, r9)     // Catch:{ all -> 0x0df2 }
        L_0x13a6:
            r1 = r4
            r4 = 111(0x6f, float:1.56E-43)
            r11 = 109(0x6d, float:1.53E-43)
            goto L_0x1407
        L_0x13ac:
            r0 = move-exception
            goto L_0x0df3
        L_0x13af:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0df2 }
            if (r2 == 0) goto L_0x13b8
            throw r2     // Catch:{ all -> 0x0df2 }
        L_0x13b8:
            throw r1     // Catch:{ all -> 0x0df2 }
        L_0x13b9:
            r0 = move-exception
            goto L_0x0df3
        L_0x13bc:
            r8 = 410(0x19a, float:5.75E-43)
            r1 = 472(0x1d8, float:6.61E-43)
            short r1 = (short) r1
            byte[] r3 = getOutOfStore     // Catch:{ all -> 0x1532 }
            r4 = 111(0x6f, float:1.56E-43)
            byte r9 = r3[r4]     // Catch:{ all -> 0x1532 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x1532 }
            r10 = 623(0x26f, float:8.73E-43)
            byte r11 = r3[r10]     // Catch:{ all -> 0x1532 }
            byte r10 = (byte) r11     // Catch:{ all -> 0x1532 }
            java.lang.String r1 = $$c(r1, r9, r10)     // Catch:{ all -> 0x1532 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x1532 }
            r9 = 978(0x3d2, float:1.37E-42)
            short r9 = (short) r9     // Catch:{ all -> 0x1532 }
            r10 = 239(0xef, float:3.35E-43)
            byte r10 = r3[r10]     // Catch:{ all -> 0x1532 }
            byte r10 = (byte) r10     // Catch:{ all -> 0x1532 }
            r11 = 109(0x6d, float:1.53E-43)
            byte r3 = r3[r11]     // Catch:{ all -> 0x1532 }
            byte r3 = (byte) r3     // Catch:{ all -> 0x1532 }
            java.lang.String r3 = $$c(r9, r10, r3)     // Catch:{ all -> 0x1532 }
            r9 = 1
            java.lang.Class[] r10 = new java.lang.Class[r9]     // Catch:{ all -> 0x1580 }
            r13 = 0
            r10[r13] = r6     // Catch:{ all -> 0x1580 }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r3, r10)     // Catch:{ all -> 0x1532 }
            java.lang.Object[] r3 = new java.lang.Object[r9]     // Catch:{ all -> 0x13fc }
            r3[r13] = r40     // Catch:{ all -> 0x13fc }
            java.lang.Object r1 = r1.invoke(r2, r3)     // Catch:{ InvocationTargetException -> 0x13f9 }
            goto L_0x1407
        L_0x13f9:
            r0 = move-exception
            r1 = r0
            goto L_0x13ff
        L_0x13fc:
            r0 = move-exception
            goto L_0x0df3
        L_0x13ff:
            java.lang.Throwable r1 = r1.getCause()     // Catch:{ ClassNotFoundException -> 0x1406 }
            java.lang.Exception r1 = (java.lang.Exception) r1     // Catch:{ ClassNotFoundException -> 0x1406 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x1406 }
        L_0x1406:
            r1 = 0
        L_0x1407:
            if (r1 == 0) goto L_0x153e
            java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ all -> 0x1532 }
            r3 = 416(0x1a0, float:5.83E-43)
            short r3 = (short) r3     // Catch:{ all -> 0x1532 }
            byte[] r9 = getOutOfStore     // Catch:{ all -> 0x1532 }
            r10 = 66
            byte r13 = r9[r10]     // Catch:{ all -> 0x1532 }
            byte r13 = (byte) r13     // Catch:{ all -> 0x1532 }
            byte r14 = r9[r22]     // Catch:{ all -> 0x1532 }
            byte r14 = (byte) r14     // Catch:{ all -> 0x1532 }
            java.lang.String r3 = $$c(r3, r13, r14)     // Catch:{ all -> 0x1532 }
            r13 = 2
            java.lang.Class[] r14 = new java.lang.Class[r13]     // Catch:{ all -> 0x153a }
            java.lang.Class<java.lang.Object> r13 = java.lang.Object.class
            r15 = 0
            r14[r15] = r13     // Catch:{ all -> 0x153a }
            java.lang.Class r13 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x153a }
            r15 = 1
            r14[r15] = r13     // Catch:{ all -> 0x153a }
            java.lang.reflect.Constructor r13 = r1.getDeclaredConstructor(r14)     // Catch:{ all -> 0x1532 }
            r13.setAccessible(r15)     // Catch:{ all -> 0x1532 }
            r14 = r48 ^ 1
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)     // Catch:{ all -> 0x1532 }
            r4 = 2
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ all -> 0x1536 }
            r4 = 0
            r8[r4] = r2     // Catch:{ all -> 0x1536 }
            r8[r15] = r14     // Catch:{ all -> 0x1536 }
            java.lang.Object r2 = r13.newInstance(r8)     // Catch:{ all -> 0x1532 }
            setDebugLog = r2     // Catch:{ all -> 0x1532 }
            r2 = 3056(0xbf0, float:4.282E-42)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x1532 }
            r4 = 71
            byte r8 = r9[r4]     // Catch:{ all -> 0x1532 }
            short r8 = (short) r8
            r13 = 12
            byte r14 = r9[r13]     // Catch:{ all -> 0x150f }
            byte r14 = (byte) r14     // Catch:{ all -> 0x150f }
            r15 = 407(0x197, float:5.7E-43)
            byte r15 = r9[r15]     // Catch:{ all -> 0x150f }
            byte r15 = (byte) r15     // Catch:{ all -> 0x150f }
            java.lang.String r8 = $$c(r8, r14, r15)     // Catch:{ all -> 0x150f }
            java.io.InputStream r8 = r5.getResourceAsStream(r8)     // Catch:{ all -> 0x150f }
            int r14 = setUserEmails
            r15 = r14 ^ 29
            r14 = r14 & 29
            r4 = 1
            int r14 = r14 << r4
            int r15 = r15 + r14
            r14 = 128(0x80, float:1.794E-43)
            int r15 = r15 % r14
            setAppInviteOneLink = r15
            java.lang.Object[] r14 = new java.lang.Object[r4]     // Catch:{ all -> 0x1528 }
            r4 = 0
            r14[r4] = r8     // Catch:{ all -> 0x1528 }
            r4 = 539(0x21b, float:7.55E-43)
            short r4 = (short) r4     // Catch:{ all -> 0x1528 }
            r8 = 623(0x26f, float:8.73E-43)
            byte r15 = r9[r8]     // Catch:{ all -> 0x1528 }
            byte r8 = (byte) r15     // Catch:{ all -> 0x1528 }
            byte r15 = (byte) r8     // Catch:{ all -> 0x1528 }
            java.lang.String r8 = $$c(r4, r8, r15)     // Catch:{ all -> 0x1528 }
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ all -> 0x1528 }
            r15 = 15
            byte r10 = r9[r15]     // Catch:{ all -> 0x1528 }
            byte r10 = (byte) r10     // Catch:{ all -> 0x1528 }
            r15 = 623(0x26f, float:8.73E-43)
            byte r11 = r9[r15]     // Catch:{ all -> 0x1528 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x1528 }
            java.lang.String r10 = $$c(r12, r10, r11)     // Catch:{ all -> 0x1528 }
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ all -> 0x1528 }
            r11 = 1
            java.lang.Class[] r12 = new java.lang.Class[r11]     // Catch:{ all -> 0x1528 }
            r15 = 0
            r12[r15] = r10     // Catch:{ all -> 0x1528 }
            java.lang.reflect.Constructor r8 = r8.getDeclaredConstructor(r12)     // Catch:{ all -> 0x1528 }
            java.lang.Object r8 = r8.newInstance(r14)     // Catch:{ all -> 0x1528 }
            java.lang.Object[] r10 = new java.lang.Object[r11]     // Catch:{ all -> 0x151e }
            r10[r15] = r2     // Catch:{ all -> 0x151e }
            r11 = 623(0x26f, float:8.73E-43)
            byte r12 = r9[r11]     // Catch:{ all -> 0x151e }
            byte r11 = (byte) r12     // Catch:{ all -> 0x151e }
            byte r12 = (byte) r11     // Catch:{ all -> 0x151e }
            java.lang.String r11 = $$c(r4, r11, r12)     // Catch:{ all -> 0x151e }
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch:{ all -> 0x151e }
            r12 = 232(0xe8, float:3.25E-43)
            short r12 = (short) r12     // Catch:{ all -> 0x151e }
            r14 = 239(0xef, float:3.35E-43)
            byte r14 = r9[r14]     // Catch:{ all -> 0x151e }
            byte r14 = (byte) r14     // Catch:{ all -> 0x151e }
            r15 = 118(0x76, float:1.65E-43)
            byte r15 = r9[r15]     // Catch:{ all -> 0x151e }
            byte r15 = (byte) r15     // Catch:{ all -> 0x151e }
            java.lang.String r12 = $$c(r12, r14, r15)     // Catch:{ all -> 0x151e }
            r14 = 1
            java.lang.Class[] r15 = new java.lang.Class[r14]     // Catch:{ all -> 0x151e }
            r14 = 0
            r15[r14] = r19     // Catch:{ all -> 0x151e }
            java.lang.reflect.Method r11 = r11.getMethod(r12, r15)     // Catch:{ all -> 0x151e }
            r11.invoke(r8, r10)     // Catch:{ all -> 0x151e }
            r10 = 623(0x26f, float:8.73E-43)
            byte r11 = r9[r10]     // Catch:{ all -> 0x1514 }
            byte r10 = (byte) r11     // Catch:{ all -> 0x1514 }
            byte r11 = (byte) r10     // Catch:{ all -> 0x1514 }
            java.lang.String r4 = $$c(r4, r10, r11)     // Catch:{ all -> 0x1514 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x1514 }
            r10 = 723(0x2d3, float:1.013E-42)
            short r11 = (short) r10     // Catch:{ all -> 0x1514 }
            byte r12 = r9[r34]     // Catch:{ all -> 0x1514 }
            byte r12 = (byte) r12     // Catch:{ all -> 0x1514 }
            byte r9 = r9[r22]     // Catch:{ all -> 0x1514 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x1514 }
            java.lang.String r9 = $$c(r11, r12, r9)     // Catch:{ all -> 0x1514 }
            r11 = 0
            java.lang.reflect.Method r4 = r4.getMethod(r9, r11)     // Catch:{ all -> 0x1514 }
            r4.invoke(r8, r11)     // Catch:{ all -> 0x1514 }
            int r4 = java.lang.Math.abs(r46)     // Catch:{ all -> 0x150f }
            r8 = 3022(0xbce, float:4.235E-42)
            r11 = r45
            r9 = r47
            r12 = r48
            r52 = r4
            r4 = r1
            r1 = r52
            r53 = r5
            r5 = r3
            r3 = r8
            r8 = r53
            goto L_0x0896
        L_0x150f:
            r0 = move-exception
        L_0x1510:
            r1 = r0
            r2 = 1
            goto L_0x16d9
        L_0x1514:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x151d
            throw r2     // Catch:{ all -> 0x150f }
        L_0x151d:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x151e:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x1527
            throw r2     // Catch:{ all -> 0x150f }
        L_0x1527:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x1528:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x1531
            throw r2     // Catch:{ all -> 0x150f }
        L_0x1531:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x1532:
            r0 = move-exception
        L_0x1533:
            r13 = 12
            goto L_0x1510
        L_0x1536:
            r0 = move-exception
            r13 = 12
            goto L_0x1510
        L_0x153a:
            r0 = move-exception
            r13 = 12
            goto L_0x1510
        L_0x153e:
            r1 = 2
            r13 = 12
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ all -> 0x157e }
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            r4 = 0
            r3[r4] = r1     // Catch:{ all -> 0x157e }
            java.lang.Class r1 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x157e }
            r4 = 1
            r3[r4] = r1     // Catch:{ all -> 0x157e }
            r1 = r43
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r3)     // Catch:{ all -> 0x150f }
            r1.setAccessible(r4)     // Catch:{ all -> 0x150f }
            r3 = r48 ^ 1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x150f }
            r8 = 2
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x157c }
            r8 = 0
            r9[r8] = r2     // Catch:{ all -> 0x157c }
            r9[r4] = r3     // Catch:{ all -> 0x157c }
            java.lang.Object r1 = r1.newInstance(r9)     // Catch:{ all -> 0x150f }
            setDebugLog = r1     // Catch:{ all -> 0x150f }
            r1 = 850(0x352, float:1.191E-42)
            r2 = 128(0x80, float:1.794E-43)
            r3 = 9
            r4 = 0
            r8 = 190(0xbe, float:2.66E-43)
            r9 = 623(0x26f, float:8.73E-43)
            r10 = 2
            r11 = 0
            r12 = 1
            r28 = 1
            goto L_0x177d
        L_0x157c:
            r0 = move-exception
            goto L_0x1510
        L_0x157e:
            r0 = move-exception
            goto L_0x1510
        L_0x1580:
            r0 = move-exception
            r13 = 12
            goto L_0x1510
        L_0x1584:
            r0 = move-exception
            r13 = 12
            r2 = r0
        L_0x1588:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x150f }
            r3.<init>()     // Catch:{ all -> 0x150f }
            r4 = 412(0x19c, float:5.77E-43)
            short r4 = (short) r4     // Catch:{ all -> 0x150f }
            byte[] r8 = getOutOfStore     // Catch:{ all -> 0x150f }
            byte r9 = r8[r34]     // Catch:{ all -> 0x150f }
            byte r9 = (byte) r9     // Catch:{ all -> 0x150f }
            r10 = 190(0xbe, float:2.66E-43)
            byte r11 = r8[r10]     // Catch:{ all -> 0x150f }
            byte r10 = (byte) r11     // Catch:{ all -> 0x150f }
            java.lang.String r4 = $$c(r4, r9, r10)     // Catch:{ all -> 0x150f }
            r3.append(r4)     // Catch:{ all -> 0x150f }
            r3.append(r1)     // Catch:{ all -> 0x150f }
            r1 = 305(0x131, float:4.27E-43)
            short r1 = (short) r1     // Catch:{ all -> 0x150f }
            int r4 = waitForCustomerUserId     // Catch:{ all -> 0x150f }
            r9 = 1
            r10 = r4 ^ 1
            r4 = r4 & r9
            int r4 = r4 << r9
            int r10 = r10 + r4
            byte r4 = (byte) r10     // Catch:{ all -> 0x150f }
            r9 = 78
            byte r9 = (byte) r9     // Catch:{ all -> 0x150f }
            java.lang.String r1 = $$c(r1, r4, r9)     // Catch:{ all -> 0x150f }
            r3.append(r1)     // Catch:{ all -> 0x150f }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x150f }
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x15f2 }
            r3 = 1
            r4[r3] = r2     // Catch:{ all -> 0x15f2 }
            r2 = 0
            r4[r2] = r1     // Catch:{ all -> 0x15f2 }
            r1 = 850(0x352, float:1.191E-42)
            short r2 = (short) r1     // Catch:{ all -> 0x15f2 }
            r1 = 15
            byte r3 = r8[r1]     // Catch:{ all -> 0x15f2 }
            byte r1 = (byte) r3     // Catch:{ all -> 0x15f2 }
            r3 = 623(0x26f, float:8.73E-43)
            byte r8 = r8[r3]     // Catch:{ all -> 0x15f2 }
            byte r3 = (byte) r8     // Catch:{ all -> 0x15f2 }
            java.lang.String r1 = $$c(r2, r1, r3)     // Catch:{ all -> 0x15f2 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x15f2 }
            r2 = 2
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ all -> 0x15f2 }
            r2 = 0
            r3[r2] = r6     // Catch:{ all -> 0x15f2 }
            java.lang.Class<java.lang.Throwable> r2 = java.lang.Throwable.class
            r8 = 1
            r3[r8] = r2     // Catch:{ all -> 0x15f2 }
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r3)     // Catch:{ all -> 0x15f2 }
            java.lang.Object r1 = r1.newInstance(r4)     // Catch:{ all -> 0x15f2 }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x15f2 }
            throw r1     // Catch:{ all -> 0x15f2 }
        L_0x15f2:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x15fb
            throw r2     // Catch:{ all -> 0x150f }
        L_0x15fb:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x15fc:
            r0 = move-exception
            r13 = 12
            goto L_0x1510
        L_0x1601:
            r0 = move-exception
            r13 = 12
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x160c
            throw r2     // Catch:{ all -> 0x150f }
        L_0x160c:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x160d:
            r0 = move-exception
            r13 = 12
            goto L_0x1510
        L_0x1612:
            r0 = move-exception
            r13 = 12
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x161d
            throw r2     // Catch:{ all -> 0x150f }
        L_0x161d:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x161e:
            r0 = move-exception
            r13 = 12
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x1629
            throw r2     // Catch:{ all -> 0x150f }
        L_0x1629:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x162a:
            r0 = move-exception
            r13 = 12
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x1635
            throw r2     // Catch:{ all -> 0x150f }
        L_0x1635:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x1636:
            r0 = move-exception
            r13 = 12
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x1641
            throw r2     // Catch:{ all -> 0x150f }
        L_0x1641:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x1642:
            r0 = move-exception
            r13 = 12
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x164d
            throw r2     // Catch:{ all -> 0x150f }
        L_0x164d:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x164e:
            r0 = move-exception
            r5 = r8
            r13 = 12
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x165a
            throw r2     // Catch:{ all -> 0x150f }
        L_0x165a:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x165b:
            r0 = move-exception
            r5 = r8
            r13 = 12
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x1667
            throw r2     // Catch:{ all -> 0x150f }
        L_0x1667:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x1668:
            r0 = move-exception
            r5 = r8
        L_0x166a:
            r13 = 12
            r1 = r0
            goto L_0x1676
        L_0x166e:
            r0 = move-exception
            r5 = r8
            goto L_0x166a
        L_0x1671:
            r0 = move-exception
            r5 = r8
            r47 = r9
            goto L_0x166a
        L_0x1676:
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x167d
            throw r2     // Catch:{ all -> 0x150f }
        L_0x167d:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x167e:
            r0 = move-exception
            r5 = r8
            r47 = r9
            goto L_0x1533
        L_0x1684:
            r0 = move-exception
            r5 = r8
            r47 = r9
            r13 = 12
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x1692
            throw r2     // Catch:{ all -> 0x150f }
        L_0x1692:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x1693:
            r0 = move-exception
            r5 = r8
            r47 = r9
            r13 = 12
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x16a1
            throw r2     // Catch:{ all -> 0x150f }
        L_0x16a1:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x16a2:
            r0 = move-exception
            r5 = r8
            r47 = r9
            r13 = 12
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x16b0
            throw r2     // Catch:{ all -> 0x150f }
        L_0x16b0:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x16b1:
            r0 = move-exception
            r5 = r8
            r47 = r9
            r13 = 12
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x150f }
            if (r2 == 0) goto L_0x16bf
            throw r2     // Catch:{ all -> 0x150f }
        L_0x16bf:
            throw r1     // Catch:{ all -> 0x150f }
        L_0x16c0:
            r0 = move-exception
            r13 = r5
            r5 = r8
            r47 = r9
            goto L_0x1510
        L_0x16c7:
            r0 = move-exception
            r36 = r2
            r35 = r3
            r37 = r4
            r41 = r5
            r5 = r8
            r47 = r9
            r42 = r10
            r39 = r14
            goto L_0x1533
        L_0x16d9:
            int r9 = r47 + 1
            r3 = 9
        L_0x16dd:
            if (r9 >= r3) goto L_0x1706
            int r4 = setAppInviteOneLink
            r8 = r4 | 1
            int r8 = r8 << r2
            r4 = r4 ^ r2
            int r8 = r8 - r4
            r2 = 128(0x80, float:1.794E-43)
            int r8 = r8 % r2
            setUserEmails = r8
            boolean r4 = r42[r9]     // Catch:{ Exception -> 0x0046 }
            if (r4 == 0) goto L_0x16fe
            r4 = 0
            setDebugLog = r4     // Catch:{ Exception -> 0x0046 }
            updateServerUninstallToken = r4     // Catch:{ Exception -> 0x0046 }
            r1 = 850(0x352, float:1.191E-42)
            r8 = 190(0xbe, float:2.66E-43)
            r9 = 623(0x26f, float:8.73E-43)
            r10 = 2
            r11 = 0
            goto L_0x177a
        L_0x16fe:
            r4 = 0
            r8 = 1
            r10 = r9 & 1
            r9 = r9 | r8
            int r9 = r9 + r10
            r2 = 1
            goto L_0x16dd
        L_0x1706:
            int r2 = waitForCustomerUserId     // Catch:{ Exception -> 0x0046 }
            r3 = r2 ^ 348(0x15c, float:4.88E-43)
            r2 = r2 & 348(0x15c, float:4.88E-43)
            r2 = r2 | r3
            short r2 = (short) r2     // Catch:{ Exception -> 0x0046 }
            byte[] r3 = getOutOfStore     // Catch:{ Exception -> 0x0046 }
            r4 = 623(0x26f, float:8.73E-43)
            byte r5 = r3[r4]     // Catch:{ Exception -> 0x0046 }
            byte r4 = (byte) r5     // Catch:{ Exception -> 0x0046 }
            r8 = 190(0xbe, float:2.66E-43)
            byte r5 = r3[r8]     // Catch:{ Exception -> 0x0046 }
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x0046 }
            java.lang.String r2 = $$c(r2, r4, r5)     // Catch:{ Exception -> 0x0046 }
            r4 = 2
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x1752 }
            r4 = 1
            r5[r4] = r1     // Catch:{ all -> 0x1752 }
            r1 = 0
            r5[r1] = r2     // Catch:{ all -> 0x1752 }
            r1 = 850(0x352, float:1.191E-42)
            short r1 = (short) r1     // Catch:{ all -> 0x1752 }
            r2 = 15
            byte r2 = r3[r2]     // Catch:{ all -> 0x1752 }
            byte r2 = (byte) r2     // Catch:{ all -> 0x1752 }
            r9 = 623(0x26f, float:8.73E-43)
            byte r3 = r3[r9]     // Catch:{ all -> 0x1752 }
            byte r3 = (byte) r3     // Catch:{ all -> 0x1752 }
            java.lang.String r1 = $$c(r1, r2, r3)     // Catch:{ all -> 0x1752 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x1752 }
            r10 = 2
            java.lang.Class[] r2 = new java.lang.Class[r10]     // Catch:{ all -> 0x1752 }
            r11 = 0
            r2[r11] = r6     // Catch:{ all -> 0x1752 }
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            r4 = 1
            r2[r4] = r3     // Catch:{ all -> 0x1752 }
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r2)     // Catch:{ all -> 0x1752 }
            java.lang.Object r1 = r1.newInstance(r5)     // Catch:{ all -> 0x1752 }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x1752 }
            throw r1     // Catch:{ all -> 0x1752 }
        L_0x1752:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x0046 }
            if (r2 == 0) goto L_0x175b
            throw r2     // Catch:{ Exception -> 0x0046 }
        L_0x175b:
            throw r1     // Catch:{ Exception -> 0x0046 }
        L_0x175c:
            r36 = r2
            r35 = r3
            r37 = r4
            r41 = r5
            r5 = r8
            r47 = r9
            r42 = r10
            r39 = r14
            r1 = 850(0x352, float:1.191E-42)
            r2 = 128(0x80, float:1.794E-43)
            r3 = 9
            r4 = 0
            r8 = 190(0xbe, float:2.66E-43)
            r9 = 623(0x26f, float:8.73E-43)
            r10 = 2
            r11 = 0
            r13 = 12
        L_0x177a:
            r28 = r37
            r12 = 1
        L_0x177d:
            r14 = r47 & 1
            r15 = r47 | 1
            int r14 = r14 + r15
            r8 = r5
            r9 = r14
            r4 = r28
            r3 = r35
            r2 = r36
            r14 = r39
            r5 = r41
            r10 = r42
            r1 = 21
            r11 = 44
            r13 = 125(0x7d, float:1.75E-43)
            goto L_0x034f
        L_0x1798:
            return
        L_0x1799:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x0046 }
            if (r2 == 0) goto L_0x17a2
            throw r2     // Catch:{ Exception -> 0x0046 }
        L_0x17a2:
            throw r1     // Catch:{ Exception -> 0x0046 }
        L_0x17a3:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x0046 }
            if (r2 == 0) goto L_0x17ac
            throw r2     // Catch:{ Exception -> 0x0046 }
        L_0x17ac:
            throw r1     // Catch:{ Exception -> 0x0046 }
        L_0x17ad:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x0046 }
            if (r2 == 0) goto L_0x17b6
            throw r2     // Catch:{ Exception -> 0x0046 }
        L_0x17b6:
            throw r1     // Catch:{ Exception -> 0x0046 }
        L_0x17b7:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x0046 }
            if (r2 == 0) goto L_0x17c0
            throw r2     // Catch:{ Exception -> 0x0046 }
        L_0x17c0:
            throw r1     // Catch:{ Exception -> 0x0046 }
        L_0x17c1:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1lSDK.<clinit>():void");
    }

    private AFb1lSDK() {
    }

    public static Object AFInAppEventParameterName(int i10, int i11, char c10) {
        int i12 = setAppInviteOneLink + 31;
        setUserEmails = i12 % 128;
        if (i12 % 2 == 0) {
            Object obj = setDebugLog;
            try {
                Object[] objArr = new Object[3];
                objArr[2] = Character.valueOf(c10);
                objArr[1] = Integer.valueOf(i11);
                objArr[0] = Integer.valueOf(i10);
                byte[] bArr = getOutOfStore;
                Class<?> cls = Class.forName($$c((short) 273, (byte) bArr[66], (byte) bArr[388]), true, (ClassLoader) updateServerUninstallToken);
                String $$c = $$c((short) 448, (byte) bArr[109], (byte) bArr[63]);
                Class cls2 = Integer.TYPE;
                Object invoke = cls.getMethod($$c, new Class[]{cls2, cls2, Character.TYPE}).invoke(obj, objArr);
                int i13 = setAppInviteOneLink;
                setUserEmails = ((i13 ^ 91) + ((i13 & 91) << 1)) % 128;
                return invoke;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } else {
            throw null;
        }
    }

    public static int AFInAppEventType(int i10) {
        int i11 = setAppInviteOneLink;
        int i12 = (i11 & 15) + (i11 | 15);
        int i13 = i12 % 128;
        setUserEmails = i13;
        if (i12 % 2 == 0) {
            Object obj = setDebugLog;
            setAppInviteOneLink = (((i13 | 25) << 1) - (i13 ^ 25)) % 128;
            try {
                Object[] objArr = {Integer.valueOf(i10)};
                byte[] bArr = getOutOfStore;
                Class<?> cls = Class.forName($$c((short) 273, (byte) bArr[66], (byte) bArr[388]), true, (ClassLoader) updateServerUninstallToken);
                int i14 = waitForCustomerUserId;
                int intValue = ((Integer) cls.getMethod($$c((short) ((i14 & 780) | (i14 ^ 780)), (byte) bArr[568], (byte) bArr[23]), new Class[]{Integer.TYPE}).invoke(obj, objArr)).intValue();
                int i15 = setAppInviteOneLink;
                int i16 = ((i15 | 5) << 1) - (i15 ^ 5);
                setUserEmails = i16 % 128;
                if (i16 % 2 == 0) {
                    return intValue;
                }
                throw null;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } else {
            throw null;
        }
    }

    static void init$0() {
        int i10 = setAppInviteOneLink;
        setUserEmails = (((i10 | 79) << 1) - (i10 ^ 79)) % 128;
        byte[] bArr = new byte[1046];
        System.arraycopy("\u001a@\tJÉñÿ;Ëîýú\n÷ð\u0011ð@Ãø÷\fð\u0001\nò:È4\u0006è\u00120Â÷>éÊ\fýþð\nþ\u0018Øûøþ\u001eÜÿ\n\u0001ñ\u0006è\u00120¿\bð\u00046Ø×\u0003ü\fõë\u0000ý\nô÷0Îý\u0001\u0000\u0003ÿê\b÷þ\u0006è\u00120½\u0002÷>éÆ\u0002\f Ê\fýþðö\bîú\u000bþ\u000fê\u0001òõ\bù\u0005ð\u0007ï\u0000\u0003\u00023¼ùBéÊ\tú\u0005=Ë\u000eðü\u0007÷þ\u0006è\u00120Â÷>éÆ\u0002\f!Ìý\u000eå-Øûøþ\u001eÜÿ\n\u0001ñ\u0000òó\nû:¸÷\u0003ü\fõ<âØ\u001eåõûúö2Üê2Ô\bëý$Ú\u000búüðñÿ;Ëîýú\n÷ð\u0011ð@Ãø÷\fð\u0001\nò:ëøá.Æ\u0012\fö$ý\n\u0001ú\u001bÎ\u0006ýðÿî+Úú\u0004ï,Øôø\u0007üê&æ\u0002\u0006ò\fÿî.ßûø\u0000\u001eØô\n\u0001úñÿ<Êîýú\n÷ð\u0011ðAÂø÷\fð\u0001\nò;êøá.Æ\u0012\fö$ý\u0000òó\nû:¸÷\u0003ü\fõ<çÜê/Úú\u0004ñ\bü\u0003ùÿûø\u0000\u0000òó\nû:¸÷\u0003ü\fõ<éÞë\u000b\u001eÜê2Ô\bëý$Ú\u000búüðÿî.Ñ\bü\u001fßûø\u0000\u001eØô÷\b\b\u0012ö\u0014õ·üL·\u0002òý\u0007þûõõP±\u0004üïH\u0012÷\u0013õ\u0012ù\u0011õ\u0012õ\u0015õñÿ;Ëîýú\n÷ð\u0011ð@Ãø÷\fð\u0001\nò:ëøá.Â\u0016\fö$¹øúØ*Îý(Ì\u000eô÷!ìì\u000eñ\u0005î\fð!êñ\u0005\u0006è\u00120¿\bð\u00046èÔ\bëý$Ú\u000búüðð\u0007ï\u0000\u0003\u00023Êîý?êÎý&Øú\nþòöÿî,Ê\u0001\fð\u0001\nò\u0016Ü\u0002ú\u000e÷ÿ\u001eØô\nÿì\u0002úö\u0006è\u00120Â÷>çàê\u0010\u0015Øûøþ\u001eÜÿ\n\u0001ñú\u000bú\u001dÜê\u0006è\u00120Â÷>éÆ\u0002\f!Ìý\u000eå'×þ\u0001øþ\u001eÜÿ\n\u0001ñð\u0007ï\u0000\u0003\u00023¼ùBæÔõ\nô\u0000þþ\u0005ô÷\u0012òô\rïð\u0007ï\u0000\u0003\u00023¼ùBØ×\u0003ü\fõ'Ôú\tõ\u0005ÿöÿî.Ô\bëý$Ú\u000búüðÈ\u0000ê\u0010/È\u0000ê\u0010/üö\u0004î\fÿî+ÿøøãé\u0003ü\u0002ú\n\u000bâ\u000eîý\bð\föé\u0013ø÷\nê\bð\u000e\u0016à\u0004í\u000eìö&ìê\t Ö\u0004õ\u0005ô÷þôúù\u000bÉñÿ;Ëîýú\n÷ð\u0011ð@Ãø÷\fð\u0001\nò:É3\u0006è\u00120Â÷>·\u0004ú\tøôÿî!Û\u0000ü\bðûøÿî0Üì\u0001\u0000ôþ\f\u0012ìê\tð\u0007ï\u0000\u0003\u00023Êîý?êÛì\bð\nòø\"éó\n\u0001ú\u0012òô\r\u0013æ\u0006è\u00120Â÷>åÚú\u0004\u0013×þ\u0001øþ\u001eÜÿ\n\u0001ñÿð\u0014â\u0006ò\f\u0006è\u00120Â÷>â÷\u0007Ê\u0012ûòù\b÷þð\u0007ï\u0000\u0003\u00023·\fê\u0001C×ìê\u0001\u001cÞ\búö\fê\t\u0019àóüÿî(Ø\u0002ò\b\u0005ò(Îý\u0001\u0000\u0003ÿê\b÷þ\u0006è\u00120Â÷>åÚú\u0004\u0012ú\u0010õë\u0000ý\nô÷\u001dèù\u0005\u0015áúý\u0000ó\u0006è\u00120Â÷>åÚú\u0004\u001eÜï\rî\u0006öù\u0002ú\u0002*Æ\u0002\f!Ìý\u000eåú\u000bú\u001eÔ\bëýñÿ<Êîýú\n÷ð\u0011ð\u0002\u000eî\nê\bð\u000e\u0016à\u0004í\u000eìö2Øô\nÿì\u0002ú\u0006\u0001ï\u0006è\u00120Â÷>âØûøþ\u001eÜÿ\n\u0001ñ".getBytes("ISO-8859-1"), 0, bArr, 0, 1046);
        getOutOfStore = bArr;
        waitForCustomerUserId = 34;
        int i11 = setAppInviteOneLink;
        int i12 = ((i11 | 63) << 1) - (i11 ^ 63);
        setUserEmails = i12 % 128;
        if (i12 % 2 != 0) {
            throw null;
        }
    }

    public static int AFInAppEventType(Object obj) {
        int i10 = setAppInviteOneLink;
        Object obj2 = setDebugLog;
        setUserEmails = (i10 + 29) % 128;
        try {
            byte[] bArr = getOutOfStore;
            int intValue = ((Integer) Class.forName($$c((short) 273, (byte) bArr[66], (byte) bArr[388]), true, (ClassLoader) updateServerUninstallToken).getMethod($$c((short) 677, (byte) bArr[410], (byte) bArr[63]), new Class[]{Object.class}).invoke(obj2, new Object[]{obj})).intValue();
            int i11 = setUserEmails;
            setAppInviteOneLink = ((i11 & 47) + (i11 | 47)) % 128;
            return intValue;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
