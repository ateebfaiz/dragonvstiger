package com.bugsnag.android;

public interface q0 {

    public static final class a {
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x006f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            tb.c.a(r6, r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String a(com.bugsnag.android.q0 r10) {
            /*
                r0 = 0
                r1 = 1
                r2 = 0
                kotlin.o$a r3 = kotlin.o.f12592b     // Catch:{ all -> 0x006b }
                java.lang.String r3 = "SHA-1"
                java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch:{ all -> 0x006b }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
                java.lang.String r5 = "sha1 "
                r4.<init>(r5)     // Catch:{ all -> 0x006b }
                java.security.DigestOutputStream r5 = new java.security.DigestOutputStream     // Catch:{ all -> 0x006b }
                com.bugsnag.android.f3 r6 = new com.bugsnag.android.f3     // Catch:{ all -> 0x006b }
                r6.<init>()     // Catch:{ all -> 0x006b }
                r5.<init>(r6, r3)     // Catch:{ all -> 0x006b }
                boolean r6 = r5 instanceof java.io.BufferedOutputStream     // Catch:{ all -> 0x0024 }
                if (r6 == 0) goto L_0x0026
                r6 = r5
                java.io.BufferedOutputStream r6 = (java.io.BufferedOutputStream) r6     // Catch:{ all -> 0x0024 }
                goto L_0x002d
            L_0x0024:
                r10 = move-exception
                goto L_0x0074
            L_0x0026:
                java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0024 }
                r7 = 8192(0x2000, float:1.14794E-41)
                r6.<init>(r5, r7)     // Catch:{ all -> 0x0024 }
            L_0x002d:
                byte[] r10 = r10.a()     // Catch:{ all -> 0x006d }
                r6.write(r10)     // Catch:{ all -> 0x006d }
                kotlin.Unit r10 = kotlin.Unit.f12577a     // Catch:{ all -> 0x006d }
                tb.c.a(r6, r2)     // Catch:{ all -> 0x0024 }
                byte[] r10 = r3.digest()     // Catch:{ all -> 0x0024 }
                int r3 = r10.length     // Catch:{ all -> 0x0024 }
                r6 = r0
            L_0x003f:
                if (r6 >= r3) goto L_0x0061
                byte r7 = r10[r6]     // Catch:{ all -> 0x0024 }
                int r6 = r6 + r1
                kotlin.jvm.internal.b0 r8 = kotlin.jvm.internal.b0.f709a     // Catch:{ all -> 0x0024 }
                java.lang.String r8 = "%02x"
                java.lang.Byte r7 = java.lang.Byte.valueOf(r7)     // Catch:{ all -> 0x0024 }
                java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch:{ all -> 0x0024 }
                r9[r0] = r7     // Catch:{ all -> 0x0024 }
                java.lang.Object[] r7 = java.util.Arrays.copyOf(r9, r1)     // Catch:{ all -> 0x0024 }
                java.lang.String r7 = java.lang.String.format(r8, r7)     // Catch:{ all -> 0x0024 }
                java.lang.String r8 = "format(format, *args)"
                kotlin.jvm.internal.m.e(r7, r8)     // Catch:{ all -> 0x0024 }
                r4.append(r7)     // Catch:{ all -> 0x0024 }
                goto L_0x003f
            L_0x0061:
                kotlin.Unit r10 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0024 }
                tb.c.a(r5, r2)     // Catch:{ all -> 0x006b }
                java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x006b }
                return r10
            L_0x006b:
                r10 = move-exception
                goto L_0x007a
            L_0x006d:
                r10 = move-exception
                throw r10     // Catch:{ all -> 0x006f }
            L_0x006f:
                r0 = move-exception
                tb.c.a(r6, r10)     // Catch:{ all -> 0x0024 }
                throw r0     // Catch:{ all -> 0x0024 }
            L_0x0074:
                throw r10     // Catch:{ all -> 0x0075 }
            L_0x0075:
                r0 = move-exception
                tb.c.a(r5, r10)     // Catch:{ all -> 0x006b }
                throw r0     // Catch:{ all -> 0x006b }
            L_0x007a:
                kotlin.o$a r0 = kotlin.o.f12592b
                java.lang.Object r10 = kotlin.p.a(r10)
                java.lang.Object r10 = kotlin.o.b(r10)
                java.lang.Throwable r10 = kotlin.o.d(r10)
                if (r10 == 0) goto L_0x008b
                return r2
            L_0x008b:
                kotlin.f r10 = new kotlin.f
                r10.<init>()
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.q0.a.a(com.bugsnag.android.q0):java.lang.String");
        }
    }

    byte[] a();
}
