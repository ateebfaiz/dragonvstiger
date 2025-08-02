package com.swmansion.worklets;

public abstract class b {
    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r4 = r4.getClass().getMethod("getCatalystInstance", (java.lang.Class[]) null).invoke(r4, (java.lang.Object[]) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002e, code lost:
        return (com.facebook.react.turbomodule.core.CallInvokerHolderImpl) r4.getClass().getMethod("getJSCallInvokerHolder", (java.lang.Class[]) null).invoke(r4, (java.lang.Object[]) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
        throw new java.lang.RuntimeException("Failed to get JSCallInvokerHolder", r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.react.turbomodule.core.CallInvokerHolderImpl a(com.facebook.react.bridge.ReactApplicationContext r4) {
        /*
            java.lang.String r0 = "getJSCallInvokerHolder"
            r1 = 0
            java.lang.Class r2 = r4.getClass()     // Catch:{ Exception -> 0x0012 }
            java.lang.reflect.Method r2 = r2.getMethod(r0, r1)     // Catch:{ Exception -> 0x0012 }
            java.lang.Object r2 = r2.invoke(r4, r1)     // Catch:{ Exception -> 0x0012 }
            com.facebook.react.turbomodule.core.CallInvokerHolderImpl r2 = (com.facebook.react.turbomodule.core.CallInvokerHolderImpl) r2     // Catch:{ Exception -> 0x0012 }
            return r2
        L_0x0012:
            java.lang.Class r2 = r4.getClass()     // Catch:{ Exception -> 0x002f }
            java.lang.String r3 = "getCatalystInstance"
            java.lang.reflect.Method r2 = r2.getMethod(r3, r1)     // Catch:{ Exception -> 0x002f }
            java.lang.Object r4 = r2.invoke(r4, r1)     // Catch:{ Exception -> 0x002f }
            java.lang.Class r2 = r4.getClass()     // Catch:{ Exception -> 0x002f }
            java.lang.reflect.Method r0 = r2.getMethod(r0, r1)     // Catch:{ Exception -> 0x002f }
            java.lang.Object r4 = r0.invoke(r4, r1)     // Catch:{ Exception -> 0x002f }
            com.facebook.react.turbomodule.core.CallInvokerHolderImpl r4 = (com.facebook.react.turbomodule.core.CallInvokerHolderImpl) r4     // Catch:{ Exception -> 0x002f }
            return r4
        L_0x002f:
            r4 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Failed to get JSCallInvokerHolder"
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.worklets.b.a(com.facebook.react.bridge.ReactApplicationContext):com.facebook.react.turbomodule.core.CallInvokerHolderImpl");
    }
}
