package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.FirebaseMessagingServiceListener;
import com.google.firebase.messaging.FirebaseMessagingService;

public final class AFe1lSDK {
    @VisibleForTesting
    public static String values;
    public final AFc1ySDK valueOf;

    static {
        StringBuilder sb2 = new StringBuilder("https://%sregister.%s/api/v");
        sb2.append(AFb1xSDK.AFInAppEventParameterName);
        values = sb2.toString();
    }

    public AFe1lSDK(@NonNull Context context) {
        this.valueOf = AFb1xSDK.AFInAppEventType().AFInAppEventType(context);
    }

    public static boolean AFKeystoreWrapper(@NonNull SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean("sentRegisterRequestToAF", false);
    }

    public static boolean values(Context context) {
        if (AppsFlyerLib.getInstance().isStopped()) {
            return false;
        }
        try {
            String str = FirebaseMessagingService.ACTION_DIRECT_BOOT_REMOTE_INTENT;
            if (AFa1cSDK.values(context, new Intent("com.google.firebase.MESSAGING_EVENT", (Uri) null, context, FirebaseMessagingServiceListener.class))) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to verify manifest declarations: ", th);
        }
    }

    public static void AFKeystoreWrapper(String str) {
        AFc1vSDK AFKeystoreWrapper = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper();
        AFd1dSDK aFd1dSDK = new AFd1dSDK(str, AFKeystoreWrapper);
        AFd1sSDK afDebugLog = AFKeystoreWrapper.afDebugLog();
        afDebugLog.AFInAppEventType.execute(new Runnable(aFd1dSDK) {
            private /* synthetic */ AFd1pSDK AFInAppEventType;

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFd1sSDK.3.run():void, dex: classes.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1sSDK.3.run():void, class status: UNLOADED
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
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
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
        });
    }

    @Nullable
    public final AFb1uSDK AFKeystoreWrapper() {
        String string;
        String string2;
        String values2 = this.valueOf.values("afUninstallToken", (String) null);
        long AFInAppEventParameterName = this.valueOf.AFInAppEventParameterName("afUninstallToken_received_time", 0);
        boolean AFKeystoreWrapper = this.valueOf.AFKeystoreWrapper("afUninstallToken_queued");
        this.valueOf.AFInAppEventType("afUninstallToken_queued", false);
        if (values2 == null && (string2 = AppsFlyerProperties.getInstance().getString("afUninstallToken")) != null) {
            String[] split = string2.split(",");
            values2 = split[split.length - 1];
        }
        if (AFInAppEventParameterName == 0 && (string = AppsFlyerProperties.getInstance().getString("afUninstallToken")) != null) {
            String[] split2 = string.split(",");
            if (split2.length >= 2) {
                try {
                    AFInAppEventParameterName = Long.parseLong(split2[split2.length - 2]);
                } catch (NumberFormatException unused) {
                }
            }
        }
        if (values2 != null) {
            return new AFb1uSDK(values2, AFInAppEventParameterName, AFKeystoreWrapper);
        }
        return null;
    }
}
