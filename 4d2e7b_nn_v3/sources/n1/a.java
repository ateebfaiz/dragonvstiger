package n1;

import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;

public abstract class a {
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        if (u1.m.a(r6).equals(u1.k.a(r7)) == false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r5, java.lang.String r6, java.lang.String r7) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            r1 = 0
            if (r0 != 0) goto L_0x0016
            java.lang.String r0 = u1.m.a(r6)     // Catch:{ Exception -> 0x0015 }
            java.lang.String r7 = u1.k.a(r7)     // Catch:{ Exception -> 0x0015 }
            boolean r7 = r0.equals(r7)     // Catch:{ Exception -> 0x0015 }
            if (r7 != 0) goto L_0x0016
        L_0x0015:
            return r1
        L_0x0016:
            java.lang.String r7 = p1.a.y(r5)
            java.lang.String r0 = "null"
            boolean r0 = r0.equals(r7)
            r2 = 1
            if (r0 != 0) goto L_0x006c
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L_0x002a
            goto L_0x006c
        L_0x002a:
            java.lang.String r0 = "/"
            java.lang.String[] r7 = r7.split(r0)     // Catch:{ all -> 0x0050 }
            r0 = r1
        L_0x0031:
            int r3 = r7.length     // Catch:{ all -> 0x0050 }
            if (r0 >= r3) goto L_0x006b
            android.content.pm.PackageManager r3 = r5.getPackageManager()     // Catch:{ all -> 0x0050 }
            android.content.Intent r4 = b(r6)     // Catch:{ all -> 0x0050 }
            android.content.pm.ResolveInfo r3 = r3.resolveActivity(r4, r1)     // Catch:{ all -> 0x0050 }
            android.content.pm.ActivityInfo r3 = r3.activityInfo     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = r3.name     // Catch:{ all -> 0x0050 }
            r4 = r7[r0]     // Catch:{ all -> 0x0050 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0050 }
            if (r3 == 0) goto L_0x004d
            return r2
        L_0x004d:
            int r0 = r0 + 1
            goto L_0x0031
        L_0x0050:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "isAllowTransfer failed "
            r6.append(r7)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "TransferCheck"
            s1.a.h(r6, r5)
        L_0x006b:
            return r1
        L_0x006c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.a.a(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    private static Intent b(String str) {
        if (TextUtils.isEmpty(str)) {
            s1.a.h("TransferCheck", "intent uri is null");
            return null;
        }
        Intent parseUri = Intent.parseUri(str, 4);
        Intent intent = new Intent(parseUri);
        parseUri.addCategory("android.intent.category.BROWSABLE");
        parseUri.setComponent((ComponentName) null);
        parseUri.setSelector((Intent) null);
        return intent;
    }
}
