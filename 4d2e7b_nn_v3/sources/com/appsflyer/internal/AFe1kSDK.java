package com.appsflyer.internal;

public final class AFe1kSDK extends AFa1sSDK {
    /* JADX WARNING: Illegal instructions before constructor call */
    @android.annotation.SuppressLint({"VisibleForTests"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AFe1kSDK(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.appsflyer.internal.AFe1lSDK.values
            com.appsflyer.AppsFlyerLib r2 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r2 = r2.getHostPrefix()
            com.appsflyer.internal.AFb1xSDK r3 = com.appsflyer.internal.AFb1xSDK.AFInAppEventType()
            java.lang.String r3 = r3.getHostName()
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            r4[r5] = r2
            r2 = 1
            r4[r2] = r3
            java.lang.String r1 = java.lang.String.format(r1, r4)
            r0.append(r1)
            java.lang.String r1 = r7.getPackageName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            java.lang.String r2 = "Register"
            r6.<init>(r2, r0, r1, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1kSDK.<init>(android.content.Context):void");
    }

    public final AFd1rSDK AFInAppEventType() {
        return AFd1rSDK.REGISTER;
    }

    public final boolean AFLogger() {
        return false;
    }
}
