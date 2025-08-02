package org.cocos2dx.javascript;

public final class PasskeyManagerKt {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        tb.c.a(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String readFromAsset(android.content.Context r1, java.lang.String r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.m.f(r1, r0)
            java.lang.String r0 = "fileName"
            kotlin.jvm.internal.m.f(r2, r0)
            android.content.res.AssetManager r1 = r1.getAssets()
            java.io.InputStream r1 = r1.open(r2)
            java.lang.String r2 = "open(...)"
            kotlin.jvm.internal.m.e(r1, r2)
            java.nio.charset.Charset r2 = kotlin.text.d.f797b
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r1, r2)
            boolean r1 = r0 instanceof java.io.BufferedReader
            if (r1 == 0) goto L_0x0025
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x002d
        L_0x0025:
            java.io.BufferedReader r1 = new java.io.BufferedReader
            r2 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r0, r2)
            r0 = r1
        L_0x002d:
            java.lang.String r1 = tb.o.f(r0)     // Catch:{ all -> 0x0038 }
            kotlin.Unit r2 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0038 }
            r2 = 0
            tb.c.a(r0, r2)
            return r1
        L_0x0038:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x003a }
        L_0x003a:
            r2 = move-exception
            tb.c.a(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.javascript.PasskeyManagerKt.readFromAsset(android.content.Context, java.lang.String):java.lang.String");
    }
}
