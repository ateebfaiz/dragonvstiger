package com.fasterxml.jackson.core.io;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f5149a = a.c();

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f5150b = a.b();

    /* renamed from: c  reason: collision with root package name */
    private static final d f5151c = new d();

    private int a(int i10, char[] cArr) {
        cArr[1] = (char) i10;
        return 2;
    }

    private int b(int i10, char[] cArr) {
        cArr[1] = 'u';
        char[] cArr2 = f5149a;
        cArr[4] = cArr2[i10 >> 4];
        cArr[5] = cArr2[i10 & 15];
        return 6;
    }

    static int c(int i10) {
        return Math.min(Math.max(16, i10 + Math.min((i10 >> 3) + 6, 1000)), 32000);
    }

    private char[] d() {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[2] = '0';
        cArr[3] = '0';
        return cArr;
    }

    public static d e() {
        return f5151c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        r7 = b(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        r7 = a(r10, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        r10 = r8 + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        if (r10 <= r1.length) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        r10 = r1.length - r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r10 <= 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        java.lang.System.arraycopy(r6, 0, r1, r8, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r5 != null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        r5 = j8.j.k(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        r1 = r5.j();
        r7 = r7 - r10;
        java.lang.System.arraycopy(r6, r10, r1, 0, r7);
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0055, code lost:
        java.lang.System.arraycopy(r6, 0, r1, r8, r7);
        r8 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        if (r6 != null) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0022, code lost:
        r6 = d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r9 = r7 + 1;
        r7 = r13.charAt(r7);
        r10 = r2[r7];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        if (r10 >= 0) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public char[] f(java.lang.String r13) {
        /*
            r12 = this;
            int r0 = r13.length()
            int r1 = c(r0)
            char[] r1 = new char[r1]
            int[] r2 = com.fasterxml.jackson.core.io.a.d()
            int r3 = r2.length
            r4 = 0
            r5 = 0
            r7 = r4
            r8 = r7
            r6 = r5
        L_0x0014:
            if (r7 >= r0) goto L_0x0075
        L_0x0016:
            char r9 = r13.charAt(r7)
            if (r9 >= r3) goto L_0x005b
            r10 = r2[r9]
            if (r10 == 0) goto L_0x005b
            if (r6 != 0) goto L_0x0026
            char[] r6 = r12.d()
        L_0x0026:
            int r9 = r7 + 1
            char r7 = r13.charAt(r7)
            r10 = r2[r7]
            if (r10 >= 0) goto L_0x0035
            int r7 = r12.b(r7, r6)
            goto L_0x0039
        L_0x0035:
            int r7 = r12.a(r10, r6)
        L_0x0039:
            int r10 = r8 + r7
            int r11 = r1.length
            if (r10 <= r11) goto L_0x0055
            int r10 = r1.length
            int r10 = r10 - r8
            if (r10 <= 0) goto L_0x0045
            java.lang.System.arraycopy(r6, r4, r1, r8, r10)
        L_0x0045:
            if (r5 != 0) goto L_0x004b
            j8.j r5 = j8.j.k(r1)
        L_0x004b:
            char[] r1 = r5.j()
            int r7 = r7 - r10
            java.lang.System.arraycopy(r6, r10, r1, r4, r7)
            r8 = r7
            goto L_0x0059
        L_0x0055:
            java.lang.System.arraycopy(r6, r4, r1, r8, r7)
            r8 = r10
        L_0x0059:
            r7 = r9
            goto L_0x0014
        L_0x005b:
            int r10 = r1.length
            if (r8 < r10) goto L_0x0069
            if (r5 != 0) goto L_0x0064
            j8.j r5 = j8.j.k(r1)
        L_0x0064:
            char[] r1 = r5.j()
            r8 = r4
        L_0x0069:
            int r10 = r8 + 1
            r1[r8] = r9
            int r7 = r7 + 1
            if (r7 < r0) goto L_0x0073
            r8 = r10
            goto L_0x0075
        L_0x0073:
            r8 = r10
            goto L_0x0016
        L_0x0075:
            if (r5 != 0) goto L_0x007c
            char[] r13 = java.util.Arrays.copyOfRange(r1, r4, r8)
            return r13
        L_0x007c:
            r5.n(r8)
            char[] r13 = r5.g()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.d.f(java.lang.String):char[]");
    }
}
