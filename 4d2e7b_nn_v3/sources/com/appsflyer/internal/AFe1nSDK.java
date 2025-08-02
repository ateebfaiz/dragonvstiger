package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFe1pSDK;
import com.google.firebase.messaging.Constants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class AFe1nSDK {
    Map<String, Object> AFInAppEventParameterName;
    @Nullable
    public volatile String AFInAppEventType;
    public volatile boolean AFKeystoreWrapper = false;
    @NonNull
    private final AFe1pSDK afDebugLog;
    private boolean afInfoLog = false;
    @NonNull
    public final AFc1sSDK valueOf;
    public volatile String values;

    public AFe1nSDK(@NonNull AFc1sSDK aFc1sSDK, @NonNull AFe1pSDK aFe1pSDK) {
        this.valueOf = aFc1sSDK;
        this.afDebugLog = aFe1pSDK;
    }

    private boolean AFInAppEventType() {
        Map<String, Object> map = this.AFInAppEventParameterName;
        if (map == null || map.isEmpty()) {
            return false;
        }
        return true;
    }

    public final boolean AFInAppEventParameterName() {
        return this.AFKeystoreWrapper;
    }

    public final boolean AFKeystoreWrapper() {
        if (!this.afInfoLog || AFInAppEventType()) {
            return false;
        }
        return true;
    }

    @NonNull
    public final Map<String, Object> valueOf() {
        HashMap hashMap = new HashMap();
        if (AFInAppEventType()) {
            hashMap.put("lvl", this.AFInAppEventParameterName);
        } else if (this.afInfoLog) {
            HashMap hashMap2 = new HashMap();
            this.AFInAppEventParameterName = hashMap2;
            hashMap2.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, "operation timed out.");
            hashMap.put("lvl", this.AFInAppEventParameterName);
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00aa  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String values(com.appsflyer.internal.AFc1ySDK r8) {
        /*
            r7 = this;
            java.lang.String r0 = "use cached IMEI: "
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "collectIMEI"
            r3 = 0
            boolean r1 = r1.getBoolean(r2, r3)
            java.lang.String r2 = "imeiCached"
            r3 = 0
            java.lang.String r4 = r8.values(r2, r3)
            if (r1 == 0) goto L_0x0098
            java.lang.String r1 = r7.AFInAppEventType
            boolean r1 = com.appsflyer.internal.AFb1mSDK.valueOf(r1)
            if (r1 == 0) goto L_0x0098
            com.appsflyer.internal.AFc1sSDK r1 = r7.valueOf
            android.content.Context r1 = r1.AFKeystoreWrapper
            if (r1 == 0) goto L_0x009f
            boolean r5 = AFInAppEventParameterName(r1)
            if (r5 == 0) goto L_0x009f
            java.lang.String r5 = "phone"
            java.lang.Object r1 = r1.getSystemService(r5)     // Catch:{ InvocationTargetException -> 0x0051, Exception -> 0x004f }
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch:{ InvocationTargetException -> 0x0051, Exception -> 0x004f }
            java.lang.Class r5 = r1.getClass()     // Catch:{ InvocationTargetException -> 0x0051, Exception -> 0x004f }
            java.lang.String r6 = "getDeviceId"
            java.lang.reflect.Method r5 = r5.getMethod(r6, r3)     // Catch:{ InvocationTargetException -> 0x0051, Exception -> 0x004f }
            java.lang.Object r1 = r5.invoke(r1, r3)     // Catch:{ InvocationTargetException -> 0x0051, Exception -> 0x004f }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ InvocationTargetException -> 0x0051, Exception -> 0x004f }
            if (r1 == 0) goto L_0x0045
            goto L_0x00a0
        L_0x0045:
            if (r4 == 0) goto L_0x0053
            java.lang.String r1 = r0.concat(r4)     // Catch:{ InvocationTargetException -> 0x0051, Exception -> 0x004f }
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ InvocationTargetException -> 0x0051, Exception -> 0x004f }
            goto L_0x0054
        L_0x004f:
            r1 = move-exception
            goto L_0x0056
        L_0x0051:
            r1 = move-exception
            goto L_0x0077
        L_0x0053:
            r4 = r3
        L_0x0054:
            r1 = r4
            goto L_0x00a0
        L_0x0056:
            if (r4 == 0) goto L_0x0060
            java.lang.String r0 = r0.concat(r4)
            com.appsflyer.AFLogger.afDebugLog(r0)
            goto L_0x0061
        L_0x0060:
            r4 = r3
        L_0x0061:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = "WARNING: Can't collect IMEI: other reason: "
            r0.<init>(r5)
            java.lang.String r5 = r1.getMessage()
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afErrorLog(r0, r1)
            goto L_0x0054
        L_0x0077:
            if (r4 == 0) goto L_0x0081
            java.lang.String r0 = r0.concat(r4)
            com.appsflyer.AFLogger.afDebugLog(r0)
            goto L_0x0082
        L_0x0081:
            r4 = r3
        L_0x0082:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = "WARNING: Can't collect IMEI because of missing permissions: "
            r0.<init>(r5)
            java.lang.String r5 = r1.getMessage()
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afErrorLog(r0, r1)
            goto L_0x0054
        L_0x0098:
            java.lang.String r0 = r7.AFInAppEventType
            if (r0 == 0) goto L_0x009f
            java.lang.String r1 = r7.AFInAppEventType
            goto L_0x00a0
        L_0x009f:
            r1 = r3
        L_0x00a0:
            boolean r0 = com.appsflyer.internal.AFb1mSDK.valueOf(r1)
            if (r0 != 0) goto L_0x00aa
            r8.valueOf(r2, r1)
            return r1
        L_0x00aa:
            java.lang.String r8 = "IMEI was not collected."
            com.appsflyer.AFLogger.afInfoLog(r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1nSDK.values(com.appsflyer.internal.AFc1ySDK):java.lang.String");
    }

    private static boolean AFInAppEventParameterName(Context context) {
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) {
            return true;
        }
        AFb1xSDK.AFInAppEventType();
        if (!AFb1xSDK.valueOf(context)) {
            return true;
        }
        return false;
    }

    public final boolean values() {
        try {
            Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
            final long currentTimeMillis = System.currentTimeMillis();
            AFe1pSDK aFe1pSDK = this.afDebugLog;
            Context context = this.valueOf.AFKeystoreWrapper;
            AnonymousClass5 r92 = new AFe1pSDK.AFa1vSDK() {
                public final void valueOf(String str, Exception exc) {
                    AFe1nSDK.this.AFInAppEventParameterName = new ConcurrentHashMap();
                    String message = exc.getMessage();
                    if (message == null) {
                        message = "unknown";
                    }
                    AFe1nSDK.this.AFInAppEventParameterName.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, message);
                    AFLogger.afErrorLog(str, exc, true, true, false);
                }

                public final void values(@NonNull String str, @NonNull String str2) {
                    AFe1nSDK.this.AFInAppEventParameterName = new ConcurrentHashMap();
                    AFe1nSDK.this.AFInAppEventParameterName.put("signedData", str);
                    AFe1nSDK.this.AFInAppEventParameterName.put("signature", str2);
                    AFe1nSDK.this.AFInAppEventParameterName.put("ttr", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AFLogger.afInfoLog("Successfully retrieved Google LVL data.");
                }
            };
            try {
                Class<?> cls = Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
                Class<?> cls2 = Class.forName("com.appsflyer.lvl.AppsFlyerLVL$resultListener");
                Method method = cls.getMethod("checkLicense", new Class[]{Long.TYPE, Context.class, cls2});
                AFe1pSDK.AnonymousClass5 r11 = new InvocationHandler(r92) {
                    private /* synthetic */ AFa1vSDK AFInAppEventType;

                    public final java.lang.Object invoke(
/*
Method generation error in method: com.appsflyer.internal.AFe1pSDK.5.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, dex: classes.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1pSDK.5.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                };
                method.invoke((Object) null, new Object[]{Long.valueOf(currentTimeMillis), context, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, r11)});
            } catch (ClassNotFoundException e10) {
                r92.valueOf(e10.getClass().getSimpleName(), e10);
            } catch (NoSuchMethodException e11) {
                r92.valueOf(e11.getClass().getSimpleName(), e11);
            } catch (IllegalAccessException e12) {
                r92.valueOf(e12.getClass().getSimpleName(), e12);
            } catch (InvocationTargetException e13) {
                r92.valueOf(e13.getClass().getSimpleName(), e13);
            }
            this.afInfoLog = true;
        } catch (ClassNotFoundException unused) {
            this.afInfoLog = false;
        }
        return this.afInfoLog;
    }
}
