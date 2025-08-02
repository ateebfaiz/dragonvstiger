package com.appsflyer.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatDelegate;
import com.alibaba.pdns.DNSResolver;
import com.alibaba.pdns.net.d;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AFLogger;
import com.appsflyer.AFVersionDeclaration;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.PurchaseHandler;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.AFa1rSDK;
import com.appsflyer.internal.AFb1bSDK;
import com.appsflyer.internal.AFb1dSDK;
import com.appsflyer.internal.AFc1oSDK;
import com.appsflyer.internal.AFd1cSDK;
import com.appsflyer.internal.AFf1kSDK;
import com.appsflyer.internal.platform_extension.PluginInfo;
import com.facebook.o;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.messaging.Constants;
import com.zing.zalo.zalosdk.common.Constant;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.NetworkInterface;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFb1xSDK extends AppsFlyerLib {
    public static final String AFInAppEventParameterName;
    public static volatile AppsFlyerConversionListener AFInAppEventType = null;
    public static final String AFKeystoreWrapper;
    private static int AppsFlyerConversionListener = 0;
    @VisibleForTesting
    private static String afDebugLog = "https://%sstats.%s/stats";
    @VisibleForTesting
    private static AFb1xSDK afInfoLog = new AFb1xSDK();
    private static char onConversionDataFail = '\u0000';
    private static char onDeepLinking = '\u0000';
    private static char onResponse = '\u0000';
    private static char onResponseError = '\u0000';
    private static int onValidateInAppFailure = ((AppsFlyerConversionListener + 81) % 128);
    static final String valueOf = "233";
    static AppsFlyerInAppPurchaseValidatorListener values = null;
    public AFa1eSDK AFLogger;
    private long AFLogger$LogLevel = -1;
    private Map<Long, String> AFVersionDeclaration;
    private final AFb1vSDK AppsFlyer2dXConversionCallback = new AFb1vSDK();
    String afErrorLog;
    private boolean afErrorLogForExcManagerOnly = false;
    private long afRDLog = -1;
    private String afWarnLog;
    private long getLevel = TimeUnit.SECONDS.toMillis(5);
    private Application init;
    private final Executor onAppOpenAttribution = Executors.newSingleThreadExecutor();
    private boolean onAppOpenAttributionNative;
    @NonNull
    private final AFc1tSDK onAttributionFailure;
    private String onAttributionFailureNative;
    private AFb1eSDK onConversionDataSuccess;
    private boolean onDeepLinkingNative = false;
    private boolean onInstallConversionDataLoadedNative = false;
    private boolean onInstallConversionFailureNative;
    private Map<String, Object> onResponseErrorNative;
    private SharedPreferences onResponseNative;

    /* renamed from: com.appsflyer.internal.AFb1xSDK$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] AFKeystoreWrapper;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.appsflyer.AppsFlyerProperties$EmailsCryptType[] r0 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                AFKeystoreWrapper = r0
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.SHA256     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = AFKeystoreWrapper     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.NONE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AnonymousClass4.<clinit>():void");
        }
    }

    class AFa1vSDK implements Runnable {
        private final AFa1sSDK AFKeystoreWrapper;

        /* synthetic */ AFa1vSDK(AFb1xSDK aFb1xSDK, AFa1sSDK aFa1sSDK, byte b10) {
            this(aFa1sSDK);
        }

        public final void run() {
            AFb1xSDK.AFInAppEventParameterName(AFb1xSDK.this, this.AFKeystoreWrapper);
        }

        private AFa1vSDK(AFa1sSDK aFa1sSDK) {
            this.AFKeystoreWrapper = aFa1sSDK;
        }
    }

    class AFa1wSDK implements AFd1uSDK {
        private AFa1wSDK() {
        }

        private static boolean valueOf() {
            if (AFb1xSDK.AFInAppEventType != null) {
                return true;
            }
            return false;
        }

        public final void AFInAppEventParameterName(AFd1pSDK<?> aFd1pSDK) {
        }

        public final void AFKeystoreWrapper(AFd1pSDK<?> aFd1pSDK) {
            if (aFd1pSDK instanceof AFd1aSDK) {
                AFb1xSDK.this.AFKeystoreWrapper().AFLogger().AFInAppEventType(((AFe1zSDK) aFd1pSDK).afRDLog.afInfoLog);
            }
        }

        /* synthetic */ AFa1wSDK(AFb1xSDK aFb1xSDK, byte b10) {
            this();
        }

        public final void AFKeystoreWrapper(AFd1pSDK<?> aFd1pSDK, AFd1tSDK aFd1tSDK) {
            JSONObject values;
            AFb1uSDK AFKeystoreWrapper2;
            if (aFd1pSDK instanceof AFe1zSDK) {
                AFe1zSDK aFe1zSDK = (AFe1zSDK) aFd1pSDK;
                boolean z10 = aFd1pSDK instanceof AFd1aSDK;
                if (z10 && valueOf()) {
                    AFd1aSDK aFd1aSDK = (AFd1aSDK) aFd1pSDK;
                    if (aFd1aSDK.valueOf == AFd1tSDK.SUCCESS || aFd1aSDK.AFInAppEventParameterName == 1) {
                        AFe1gSDK aFe1gSDK = new AFe1gSDK(aFd1aSDK, AFb1xSDK.this.AFKeystoreWrapper().afInfoLog());
                        AFd1sSDK afDebugLog = AFb1xSDK.this.AFKeystoreWrapper().afDebugLog();
                        afDebugLog.AFInAppEventType.execute(new Runnable(aFe1gSDK) {
                            private /* synthetic */ AFd1pSDK AFInAppEventType;

                            /*  JADX ERROR: Method generation error
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
                            /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFd1sSDK.3.run():void, class status: UNLOADED
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
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
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
                }
                if (aFd1tSDK == AFd1tSDK.SUCCESS) {
                    AFb1xSDK aFb1xSDK = AFb1xSDK.this;
                    aFb1xSDK.AFInAppEventType((Context) AFb1xSDK.values(aFb1xSDK)).valueOf("sentSuccessfully", "true");
                    if (!(aFd1pSDK instanceof AFd1dSDK) && (AFKeystoreWrapper2 = new AFe1lSDK(AFb1xSDK.values(AFb1xSDK.this)).AFKeystoreWrapper()) != null && AFKeystoreWrapper2.AFKeystoreWrapper()) {
                        String str = AFKeystoreWrapper2.AFKeystoreWrapper;
                        AFLogger.afDebugLog("Resending Uninstall token to AF servers: ".concat(String.valueOf(str)));
                        AFe1lSDK.AFKeystoreWrapper(str);
                    }
                    AFd1zSDK<Result> aFd1zSDK = aFe1zSDK.afErrorLog;
                    if (!(aFd1zSDK == null || (values = AFb1qSDK.values((String) aFd1zSDK.getBody())) == null)) {
                        AFb1xSDK.AFInAppEventType(AFb1xSDK.this, values.optBoolean("send_background", false));
                    }
                    if (z10) {
                        AFb1xSDK.valueOf(AFb1xSDK.this, System.currentTimeMillis());
                    }
                }
            } else if ((aFd1pSDK instanceof AFe1gSDK) && aFd1tSDK != AFd1tSDK.SUCCESS) {
                AFe1mSDK aFe1mSDK = new AFe1mSDK(AFb1xSDK.this.AFKeystoreWrapper());
                AFd1sSDK afDebugLog2 = AFb1xSDK.this.AFKeystoreWrapper().afDebugLog();
                afDebugLog2.AFInAppEventType.execute(new Runnable(aFe1mSDK) {
                    private /* synthetic */ AFd1pSDK AFInAppEventType;

                    /*  JADX ERROR: Method generation error
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
                    /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFd1sSDK.3.run():void, class status: UNLOADED
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
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
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
        }
    }

    class AFa1ySDK implements Runnable {
        private final AFa1sSDK valueOf;

        /* synthetic */ AFa1ySDK(AFb1xSDK aFb1xSDK, AFa1sSDK aFa1sSDK, byte b10) {
            this(aFa1sSDK);
        }

        public final void run() {
            AFd1aSDK aFd1aSDK;
            if (this.valueOf.AFInAppEventParameterName()) {
                AFd1aSDK aFd1aSDK2 = new AFd1aSDK(this.valueOf, AFb1xSDK.this.AFKeystoreWrapper());
                aFd1aSDK2.afErrorLogForExcManagerOnly = AFb1xSDK.valueOf(AFb1xSDK.this);
                aFd1aSDK = aFd1aSDK2;
            } else {
                aFd1aSDK = new AFe1zSDK(this.valueOf, AFb1xSDK.this.AFKeystoreWrapper());
            }
            AFd1sSDK afDebugLog = AFb1xSDK.this.AFKeystoreWrapper().afDebugLog();
            afDebugLog.AFInAppEventType.execute(new Runnable(aFd1aSDK) {
                private /* synthetic */ AFd1pSDK AFInAppEventType;

                /*  JADX ERROR: Method generation error
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
                /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFd1sSDK.3.run():void, class status: UNLOADED
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
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
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

        private AFa1ySDK(AFa1sSDK aFa1sSDK) {
            this.valueOf = aFa1sSDK;
        }
    }

    static {
        AFInAppEventParameterName();
        Object[] objArr = new Object[1];
        values("䩲읐", (ViewConfiguration.getScrollBarSize() >> 8) + 1, objArr);
        String substring = "6.10.2".substring(0, "6.10.2".lastIndexOf(((String) objArr[0]).intern()));
        AFKeystoreWrapper = substring;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(substring);
        sb2.append("/androidevent?buildnumber=6.10.2&app_id=");
        AFInAppEventParameterName = sb2.toString();
    }

    @VisibleForTesting
    public AFb1xSDK() {
        AFVersionDeclaration.init();
        this.onAttributionFailure = new AFc1tSDK();
        AFd1sSDK afDebugLog2 = AFKeystoreWrapper().afDebugLog();
        afDebugLog2.values.add(new AFa1wSDK(this, (byte) 0));
    }

    static void AFInAppEventParameterName() {
        onDeepLinking = 59415;
        onResponseError = 21033;
        onConversionDataFail = 39153;
        onResponse = 61471;
    }

    static /* synthetic */ boolean AFInAppEventType(AFb1xSDK aFb1xSDK, boolean z10) {
        int i10 = AppsFlyerConversionListener;
        onValidateInAppFailure = (i10 + 79) % 128;
        aFb1xSDK.onInstallConversionDataLoadedNative = z10;
        int i11 = i10 + 97;
        onValidateInAppFailure = i11 % 128;
        if (i11 % 2 == 0) {
            int i12 = 17 / 0;
        }
        return z10;
    }

    static /* synthetic */ void AFKeystoreWrapper(AFb1xSDK aFb1xSDK) {
        onValidateInAppFailure = (AppsFlyerConversionListener + 41) % 128;
        aFb1xSDK.AFVersionDeclaration();
        int i10 = AppsFlyerConversionListener + 49;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            int i11 = 22 / 0;
        }
    }

    private void AFLogger() {
        AFf1jSDK AFVersionDeclaration2 = AFKeystoreWrapper().AFVersionDeclaration();
        AFf1pSDK afDebugLog2 = afDebugLog();
        Runnable valueOf2 = valueOf(afDebugLog2);
        AFVersionDeclaration2.AFKeystoreWrapper(afDebugLog2);
        AFVersionDeclaration2.AFKeystoreWrapper(new AFf1gSDK(valueOf2));
        AFVersionDeclaration2.AFKeystoreWrapper(new AFf1mSDK(valueOf2, AFKeystoreWrapper()));
        AFVersionDeclaration2.AFKeystoreWrapper(new AFf1iSDK(valueOf2, AFKeystoreWrapper()));
        if (!afInfoLog()) {
            AppsFlyerConversionListener = (onValidateInAppFailure + 107) % 128;
            AFVersionDeclaration2.valueOf(this.init, valueOf2, AFKeystoreWrapper());
        }
        onValidateInAppFailure = (AppsFlyerConversionListener + 7) % 128;
        for (AFf1kSDK valueOf3 : AFVersionDeclaration2.AFInAppEventParameterName()) {
            valueOf3.valueOf(this.init);
        }
    }

    private boolean AFLogger$LogLevel() {
        onValidateInAppFailure = (AppsFlyerConversionListener + 115) % 128;
        Map<String, Object> map = this.onResponseErrorNative;
        if (map != null && !map.isEmpty()) {
            return true;
        }
        int i10 = AppsFlyerConversionListener + 83;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            int i11 = 17 / 0;
        }
        return false;
    }

    private String AFVersionDeclaration(Context context) {
        int i10 = onValidateInAppFailure + 117;
        AppsFlyerConversionListener = i10 % 128;
        String str = null;
        if (i10 % 2 == 0) {
            SharedPreferences AFKeystoreWrapper2 = AFKeystoreWrapper(context);
            if (AFKeystoreWrapper2.contains("INSTALL_STORE")) {
                return AFKeystoreWrapper2.getString("INSTALL_STORE", (String) null);
            }
            if (afErrorLog(context)) {
                str = AFLogger$LogLevel(context);
            }
            AFInAppEventType(context).valueOf("INSTALL_STORE", str);
            int i11 = AppsFlyerConversionListener + 103;
            onValidateInAppFailure = i11 % 128;
            if (i11 % 2 == 0) {
                int i12 = 83 / 0;
            }
            return str;
        }
        AFKeystoreWrapper(context).contains("INSTALL_STORE");
        throw null;
    }

    private AFf1pSDK afDebugLog() {
        AFf1pSDK aFf1pSDK = new AFf1pSDK(new g(this), AFKeystoreWrapper().AFKeystoreWrapper());
        int i10 = onValidateInAppFailure + 7;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 == 0) {
            return aFf1pSDK;
        }
        throw null;
    }

    private static String afErrorLog() {
        AppsFlyerConversionListener = (onValidateInAppFailure + 25) % 128;
        String AFInAppEventType2 = AFInAppEventType(AppsFlyerProperties.APP_ID);
        int i10 = AppsFlyerConversionListener + 17;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 != 0) {
            return AFInAppEventType2;
        }
        throw null;
    }

    private String afErrorLogForExcManagerOnly(Context context) {
        File afDebugLog2 = afDebugLog(values("ro.appsflyer.preinstall.path"));
        if (values(afDebugLog2)) {
            afDebugLog2 = afDebugLog(AFInAppEventParameterName(context, "AF_PRE_INSTALL_PATH"));
        }
        if (values(afDebugLog2)) {
            int i10 = onValidateInAppFailure + 105;
            AppsFlyerConversionListener = i10 % 128;
            if (i10 % 2 == 0) {
                afDebugLog2 = afDebugLog("/data/local/tmp/pre_install.appsflyer");
            } else {
                afDebugLog("/data/local/tmp/pre_install.appsflyer");
                throw null;
            }
        }
        if (!(!values(afDebugLog2))) {
            afDebugLog2 = afDebugLog("/etc/pre_install.appsflyer");
        }
        if (!values(afDebugLog2)) {
            return AFInAppEventType(afDebugLog2, context.getPackageName());
        }
        int i11 = AppsFlyerConversionListener + 77;
        int i12 = i11 % 128;
        onValidateInAppFailure = i12;
        if (i11 % 2 != 0) {
            AppsFlyerConversionListener = (i12 + 61) % 128;
            return null;
        }
        throw null;
    }

    @VisibleForTesting
    private boolean afInfoLog() {
        int i10 = AppsFlyerConversionListener + 59;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 != 0) {
            boolean valueOf2 = AFKeystoreWrapper().values().valueOf("AF_PREINSTALL_DISABLED");
            AppsFlyerConversionListener = (onValidateInAppFailure + 105) % 128;
            return valueOf2;
        }
        AFKeystoreWrapper().values().valueOf("AF_PREINSTALL_DISABLED");
        throw null;
    }

    private void afRDLog(Context context) {
        Class<Context> cls = Context.class;
        this.onResponseErrorNative = new HashMap();
        final long currentTimeMillis = System.currentTimeMillis();
        AnonymousClass3 r72 = new AFa1rSDK.AFa1vSDK() {
            public final void valueOf(String str) {
                AFb1xSDK.valueOf(AFb1xSDK.this).put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, str);
            }

            public final void values(String str, String str2, String str3) {
                if (str != null) {
                    AFLogger.afInfoLog("Facebook Deferred AppLink data received: ".concat(str));
                    AFb1xSDK.valueOf(AFb1xSDK.this).put("link", str);
                    if (str2 != null) {
                        AFb1xSDK.valueOf(AFb1xSDK.this).put("target_url", str2);
                    }
                    if (str3 != null) {
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("promo_code", str3);
                        hashMap.put("deeplink_context", hashMap2);
                        AFb1xSDK.valueOf(AFb1xSDK.this).put("extras", hashMap);
                    }
                } else {
                    AFb1xSDK.valueOf(AFb1xSDK.this).put("link", "");
                }
                AFb1xSDK.valueOf(AFb1xSDK.this).put("ttr", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        };
        Class<o> cls2 = o.class;
        try {
            boolean z10 = o.f20687p;
            cls2.getMethod("sdkInitialize", new Class[]{cls}).invoke((Object) null, new Object[]{context});
            Class<?> cls3 = Class.forName("com.facebook.applinks.AppLinkData");
            Class<?> cls4 = Class.forName("com.facebook.applinks.AppLinkData$CompletionHandler");
            Method method = cls3.getMethod("fetchDeferredAppLinkData", new Class[]{cls, String.class, cls4});
            AFa1rSDK.AnonymousClass1 r92 = new InvocationHandler(cls3, r72) {
                private /* synthetic */ Class AFInAppEventType;
                private /* synthetic */ AFa1vSDK AFKeystoreWrapper;

                public final java.lang.Object invoke(
/*
Method generation error in method: com.appsflyer.internal.AFa1rSDK.1.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, dex: classes.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFa1rSDK.1.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, class status: UNLOADED
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
            Object newProxyInstance = Proxy.newProxyInstance(cls4.getClassLoader(), new Class[]{cls4}, r92);
            String string = context.getString(context.getResources().getIdentifier("facebook_app_id", "string", context.getPackageName()));
            if (TextUtils.isEmpty(string)) {
                AppsFlyerConversionListener = (onValidateInAppFailure + 77) % 128;
                r72.valueOf("Facebook app id not defined in resources");
                return;
            }
            method.invoke((Object) null, new Object[]{context, string, newProxyInstance});
            AppsFlyerConversionListener = (onValidateInAppFailure + 71) % 128;
        } catch (NoSuchMethodException e10) {
            AFLogger.afErrorLogForExcManagerOnly("FB method missing error", e10);
            r72.valueOf(e10.toString());
        } catch (InvocationTargetException e11) {
            AFLogger.afErrorLogForExcManagerOnly("FB invocation error", e11);
            r72.valueOf(e11.toString());
        } catch (ClassNotFoundException e12) {
            AFLogger.afErrorLogForExcManagerOnly("FB class missing error", e12);
            r72.valueOf(e12.toString());
        } catch (IllegalAccessException e13) {
            AFLogger.afErrorLogForExcManagerOnly("FB illegal access", e13);
            r72.valueOf(e13.toString());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void afWarnLog() {
        AppsFlyerConversionListener = (onValidateInAppFailure + 105) % 128;
        values(AFKeystoreWrapper().AFInAppEventParameterName(), new i(this), 0, TimeUnit.MILLISECONDS);
        int i10 = onValidateInAppFailure + 35;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            int i11 = 11 / 0;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void getLevel() {
        try {
            AFe1eSDK aFe1eSDK = new AFe1eSDK();
            Application application = this.init;
            if (application != null) {
                int i10 = onValidateInAppFailure + 21;
                AppsFlyerConversionListener = i10 % 128;
                if (i10 % 2 == 0) {
                    aFe1eSDK.AFInAppEventType = (Application) application.getApplicationContext();
                    AppsFlyerConversionListener = (onValidateInAppFailure + DNSResolver.GOBACK_LOCAL) % 128;
                } else {
                    aFe1eSDK.AFInAppEventType = (Application) application.getApplicationContext();
                    throw null;
                }
            }
            if (AFInAppEventType((AFa1sSDK) aFe1eSDK, AFKeystoreWrapper((Context) this.init))) {
                valueOf((AFa1sSDK) aFe1eSDK);
                AppsFlyerConversionListener = (onValidateInAppFailure + 81) % 128;
            }
            int i11 = onValidateInAppFailure + 85;
            AppsFlyerConversionListener = i11 % 128;
            if (i11 % 2 != 0) {
                int i12 = 61 / 0;
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
        }
    }

    private static boolean onInstallConversionFailureNative(Context context) {
        NetworkCapabilities networkCapabilities;
        if (context != null) {
            int i10 = onValidateInAppFailure + 87;
            AppsFlyerConversionListener = i10 % 128;
            if (i10 % 2 == 0 || Build.VERSION.SDK_INT >= 67) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    Network[] allNetworks = connectivityManager.getAllNetworks();
                    int length = allNetworks.length;
                    for (int i11 = 0; i11 < length; i11++) {
                        int i12 = AppsFlyerConversionListener + 5;
                        onValidateInAppFailure = i12 % 128;
                        if (i12 % 2 == 0) {
                            networkCapabilities = connectivityManager.getNetworkCapabilities(allNetworks[i11]);
                            if (!networkCapabilities.hasTransport(4)) {
                                continue;
                            }
                        } else {
                            networkCapabilities = connectivityManager.getNetworkCapabilities(allNetworks[i11]);
                            if (!networkCapabilities.hasTransport(4)) {
                                continue;
                            }
                        }
                        if (!networkCapabilities.hasCapability(15)) {
                            AppsFlyerConversionListener = (onValidateInAppFailure + 91) % 128;
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e10) {
                    AFLogger.afErrorLog("Failed collecting ivc data", e10);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                try {
                    Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (it.hasNext()) {
                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                        if (networkInterface.isUp()) {
                            arrayList.add(networkInterface.getName());
                        }
                    }
                    return arrayList.contains("tun0");
                } catch (Exception e11) {
                    AFLogger.afErrorLog("Failed collecting ivc data", e11);
                }
            }
        }
        return false;
    }

    static /* synthetic */ long valueOf(AFb1xSDK aFb1xSDK, long j10) {
        int i10 = (onValidateInAppFailure + 111) % 128;
        AppsFlyerConversionListener = i10;
        aFb1xSDK.AFLogger$LogLevel = j10;
        int i11 = i10 + 49;
        onValidateInAppFailure = i11 % 128;
        if (i11 % 2 == 0) {
            int i12 = 61 / 0;
        }
        return j10;
    }

    static /* synthetic */ Application values(AFb1xSDK aFb1xSDK) {
        int i10 = AppsFlyerConversionListener + 79;
        onValidateInAppFailure = i10 % 128;
        int i11 = i10 % 2;
        Application application = aFb1xSDK.init;
        if (i11 != 0) {
            return application;
        }
        throw null;
    }

    public final void addPushNotificationDeepLinkPath(String... strArr) {
        List asList = Arrays.asList(strArr);
        List<List<String>> list = AFKeystoreWrapper().onInstallConversionDataLoadedNative().afInfoLog;
        if (!list.contains(asList)) {
            int i10 = onValidateInAppFailure + 41;
            AppsFlyerConversionListener = i10 % 128;
            int i11 = i10 % 2;
            list.add(asList);
            if (i11 == 0) {
                onValidateInAppFailure = (AppsFlyerConversionListener + 65) % 128;
                return;
            }
            throw null;
        }
    }

    public final void anonymizeUser(boolean z10) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 65) % 128;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("anonymizeUser", String.valueOf(z10));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z10);
        int i10 = onValidateInAppFailure + 35;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            throw null;
        }
    }

    public final void appendParametersToDeepLinkingURL(String str, Map<String, String> map) {
        int i10 = onValidateInAppFailure + 119;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 == 0) {
            AFa1tSDK onInstallConversionDataLoadedNative2 = AFKeystoreWrapper().onInstallConversionDataLoadedNative();
            onInstallConversionDataLoadedNative2.values = str;
            onInstallConversionDataLoadedNative2.AFInAppEventType = map;
            AppsFlyerConversionListener = (onValidateInAppFailure + 107) % 128;
            return;
        }
        AFa1tSDK onInstallConversionDataLoadedNative3 = AFKeystoreWrapper().onInstallConversionDataLoadedNative();
        onInstallConversionDataLoadedNative3.values = str;
        onInstallConversionDataLoadedNative3.AFInAppEventType = map;
        throw null;
    }

    public final void enableFacebookDeferredApplinks(boolean z10) {
        int i10 = onValidateInAppFailure + 75;
        AppsFlyerConversionListener = i10 % 128;
        int i11 = i10 % 2;
        this.onDeepLinkingNative = z10;
        if (i11 != 0) {
            int i12 = 23 / 0;
        }
    }

    @Nullable
    public final String getAppsFlyerUID(@NonNull Context context) {
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("getAppsFlyerUID", new String[0]);
        if (context == null) {
            int i10 = onValidateInAppFailure + 119;
            AppsFlyerConversionListener = i10 % 128;
            if (i10 % 2 == 0) {
                return null;
            }
            throw null;
        }
        values(context);
        String AFKeystoreWrapper2 = AFb1wSDK.AFKeystoreWrapper(new WeakReference(AFKeystoreWrapper().values().AFKeystoreWrapper.AFKeystoreWrapper));
        int i11 = AppsFlyerConversionListener + 97;
        onValidateInAppFailure = i11 % 128;
        if (i11 % 2 != 0) {
            return AFKeystoreWrapper2;
        }
        throw null;
    }

    public final String getAttributionId(Context context) {
        try {
            String AFInAppEventType2 = new AFa1aSDK(context, AFKeystoreWrapper()).AFInAppEventType();
            int i10 = onValidateInAppFailure + 121;
            AppsFlyerConversionListener = i10 % 128;
            if (i10 % 2 == 0) {
                return AFInAppEventType2;
            }
            throw null;
        } catch (Throwable th) {
            AFLogger.afErrorLog("Could not collect facebook attribution id. ", th);
            return null;
        }
    }

    public final String getHostName() {
        AppsFlyerConversionListener = (onValidateInAppFailure + 81) % 128;
        String values2 = AFKeystoreWrapper().init().values();
        AppsFlyerConversionListener = (onValidateInAppFailure + 71) % 128;
        return values2;
    }

    public final String getHostPrefix() {
        onValidateInAppFailure = (AppsFlyerConversionListener + 99) % 128;
        String AFInAppEventType2 = AFKeystoreWrapper().init().AFInAppEventType();
        onValidateInAppFailure = (AppsFlyerConversionListener + 37) % 128;
        return AFInAppEventType2;
    }

    public final String getOutOfStore(Context context) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 113) % 128;
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            int i10 = onValidateInAppFailure + 55;
            AppsFlyerConversionListener = i10 % 128;
            if (i10 % 2 == 0) {
                return string;
            }
            throw null;
        }
        String AFInAppEventParameterName2 = AFInAppEventParameterName(context, "AF_STORE");
        if (AFInAppEventParameterName2 != null) {
            int i11 = AppsFlyerConversionListener + 97;
            onValidateInAppFailure = i11 % 128;
            if (i11 % 2 != 0) {
                return AFInAppEventParameterName2;
            }
            throw null;
        }
        AFLogger.afInfoLog("No out-of-store value set");
        return null;
    }

    public final String getSdkVersion() {
        AFc1vSDK AFKeystoreWrapper2;
        int i10 = AppsFlyerConversionListener + 81;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            AFKeystoreWrapper2 = AFKeystoreWrapper();
            AFKeystoreWrapper2.afErrorLogForExcManagerOnly().AFInAppEventType("getSdkVersion", new String[0]);
        } else {
            AFKeystoreWrapper2 = AFKeystoreWrapper();
            AFKeystoreWrapper2.afErrorLogForExcManagerOnly().AFInAppEventType("getSdkVersion", new String[0]);
        }
        AFKeystoreWrapper2.values();
        return AFc1zSDK.valueOf();
    }

    public final AppsFlyerLib init(@NonNull String str, AppsFlyerConversionListener appsFlyerConversionListener, @NonNull Context context) {
        String str2;
        if (this.onAppOpenAttributionNative) {
            int i10 = onValidateInAppFailure + 43;
            AppsFlyerConversionListener = i10 % 128;
            if (i10 % 2 == 0) {
                return this;
            }
            throw null;
        }
        this.onAppOpenAttributionNative = true;
        AFKeystoreWrapper().getLevel().values = str;
        AFc1rSDK.AFKeystoreWrapper(str);
        if (context != null) {
            onValidateInAppFailure = (AppsFlyerConversionListener + 125) % 128;
            this.init = (Application) context.getApplicationContext();
            values(context);
            AFKeystoreWrapper().AFLogger().AFKeystoreWrapper = System.currentTimeMillis();
            AFKeystoreWrapper().onConversionDataSuccess().values();
            AFKeystoreWrapper().afRDLog().values(new f(this));
            AFLogger();
            this.onAttributionFailure.getLevel().values();
            AFb1cSDK.AFKeystoreWrapper = this.init;
        } else {
            AFLogger.afWarnLog("context is null, Google Install Referrer will be not initialized");
        }
        AFb1sSDK afErrorLogForExcManagerOnly2 = AFKeystoreWrapper().afErrorLogForExcManagerOnly();
        if (appsFlyerConversionListener == null) {
            onValidateInAppFailure = (AppsFlyerConversionListener + 121) % 128;
            str2 = "null";
        } else {
            str2 = "conversionDataListener";
        }
        afErrorLogForExcManagerOnly2.AFInAppEventType("init", str, str2);
        AFLogger.values(String.format("Initializing AppsFlyer SDK: (v%s.%s)", new Object[]{"6.10.2", valueOf}));
        AFInAppEventType = appsFlyerConversionListener;
        return this;
    }

    public final boolean isPreInstalledApp(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0) {
                int i10 = (AppsFlyerConversionListener + 71) % 128;
                onValidateInAppFailure = i10;
                int i11 = i10 + 37;
                AppsFlyerConversionListener = i11 % 128;
                if (i11 % 2 == 0) {
                    return true;
                }
                throw null;
            }
        } catch (PackageManager.NameNotFoundException e10) {
            AFLogger.afErrorLog("Could not check if app is pre installed", e10);
        }
        return false;
    }

    @Deprecated
    public final boolean isStopped() {
        int i10 = AppsFlyerConversionListener + 97;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 != 0) {
            boolean AFInAppEventParameterName2 = AFKeystoreWrapper().getLevel().AFInAppEventParameterName();
            int i11 = onValidateInAppFailure + 99;
            AppsFlyerConversionListener = i11 % 128;
            if (i11 % 2 != 0) {
                int i12 = 99 / 0;
            }
            return AFInAppEventParameterName2;
        }
        AFKeystoreWrapper().getLevel().AFInAppEventParameterName();
        throw null;
    }

    public final void logEvent(Context context, String str, Map<String, Object> map) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 81) % 128;
        logEvent(context, str, map, (AppsFlyerRequestListener) null);
        int i10 = AppsFlyerConversionListener + DNSResolver.GOBACK_LOCAL;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            throw null;
        }
    }

    public final void logLocation(Context context, double d10, double d11) {
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("logLocation", String.valueOf(d10), String.valueOf(d11));
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGTITUDE, Double.toString(d11));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d10));
        values(context, AFInAppEventType.LOCATION_COORDINATES, (Map<String, Object>) hashMap);
        int i10 = AppsFlyerConversionListener + 47;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            int i11 = 44 / 0;
        }
    }

    public final void logSession(Context context) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 67) % 128;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("logSession", new String[0]);
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().valueOf();
        valueOf(context, AFe1hSDK.logSession);
        values(context, (String) null, (Map<String, Object>) null);
        AppsFlyerConversionListener = (onValidateInAppFailure + 117) % 128;
    }

    public final void onPause(Context context) {
        int i10 = AppsFlyerConversionListener + 53;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            AFKeystoreWrapper().onAttributionFailureNative().AFKeystoreWrapper(context);
            int i11 = 86 / 0;
        } else {
            AFKeystoreWrapper().onAttributionFailureNative().AFKeystoreWrapper(context);
        }
        AppsFlyerConversionListener = (onValidateInAppFailure + 123) % 128;
    }

    @Deprecated
    public final void performOnAppAttribution(@NonNull Context context, @NonNull URI uri) {
        int i10 = (AppsFlyerConversionListener + 27) % 128;
        onValidateInAppFailure = i10;
        if (uri != null) {
            AppsFlyerConversionListener = (i10 + 79) % 128;
            if (!uri.toString().isEmpty()) {
                if (context == null) {
                    StringBuilder sb2 = new StringBuilder("Context is \"");
                    sb2.append(context);
                    sb2.append("\"");
                    AFb1nSDK.AFInAppEventType(sb2.toString(), DeepLinkResult.Error.NETWORK);
                    return;
                }
                AFKeystoreWrapper().onInstallConversionDataLoadedNative();
                AFa1tSDK.values(context, new HashMap(), Uri.parse(uri.toString()));
                return;
            }
        }
        StringBuilder sb3 = new StringBuilder("Link is \"");
        sb3.append(uri);
        sb3.append("\"");
        AFb1nSDK.AFInAppEventType(sb3.toString(), DeepLinkResult.Error.NETWORK);
        int i11 = AppsFlyerConversionListener + 49;
        onValidateInAppFailure = i11 % 128;
        if (i11 % 2 == 0) {
            throw null;
        }
    }

    public final void performOnDeepLinking(@NonNull Intent intent, @NonNull Context context) {
        int i10 = onValidateInAppFailure + 85;
        int i11 = i10 % 128;
        AppsFlyerConversionListener = i11;
        if (i10 % 2 != 0) {
            throw null;
        } else if (intent == null) {
            AFb1nSDK.AFInAppEventType("performOnDeepLinking was called with null intent", DeepLinkResult.Error.DEVELOPER_ERROR);
        } else if (context == null) {
            int i12 = i11 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            onValidateInAppFailure = i12 % 128;
            if (i12 % 2 == 0) {
                AFb1nSDK.AFInAppEventType("performOnDeepLinking was called with null context", DeepLinkResult.Error.DEVELOPER_ERROR);
                int i13 = 61 / 0;
                return;
            }
            AFb1nSDK.AFInAppEventType("performOnDeepLinking was called with null context", DeepLinkResult.Error.DEVELOPER_ERROR);
        } else {
            Context applicationContext = context.getApplicationContext();
            values(applicationContext);
            AFKeystoreWrapper().AFKeystoreWrapper().execute(new j(this, applicationContext, intent));
        }
    }

    public final void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 71) % 128;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("registerConversionListener", new String[0]);
        AFInAppEventParameterName(appsFlyerConversionListener);
        AppsFlyerConversionListener = (onValidateInAppFailure + 11) % 128;
    }

    public final void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        onValidateInAppFailure = (AppsFlyerConversionListener + 11) % 128;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("registerValidatorListener", new String[0]);
        AFLogger.afDebugLog("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener == null) {
            onValidateInAppFailure = (AppsFlyerConversionListener + 15) % 128;
            AFLogger.afDebugLog("registerValidatorListener null listener");
            onValidateInAppFailure = (AppsFlyerConversionListener + 65) % 128;
            return;
        }
        values = appsFlyerInAppPurchaseValidatorListener;
    }

    public final void sendAdRevenue(Context context, Map<String, Object> map) {
        Activity activity;
        values(context);
        AFe1cSDK aFe1cSDK = new AFe1cSDK();
        if (context != null) {
            onValidateInAppFailure = (AppsFlyerConversionListener + 67) % 128;
            aFe1cSDK.AFInAppEventType = (Application) context.getApplicationContext();
            onValidateInAppFailure = (AppsFlyerConversionListener + 117) % 128;
        }
        int AFInAppEventType2 = AFInAppEventType(AFKeystoreWrapper(context));
        aFe1cSDK.AFKeystoreWrapper().put("ad_network", map);
        aFe1cSDK.AFKeystoreWrapper().put("adrevenue_counter", Integer.valueOf(AFInAppEventType2));
        if (context instanceof Activity) {
            onValidateInAppFailure = (AppsFlyerConversionListener + 43) % 128;
            activity = (Activity) context;
        } else {
            activity = null;
        }
        AFKeystoreWrapper((AFa1sSDK) aFe1cSDK, activity);
    }

    public final void sendInAppPurchaseData(Context context, Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        onValidateInAppFailure = (AppsFlyerConversionListener + 67) % 128;
        values(context);
        PurchaseHandler afErrorLog2 = AFKeystoreWrapper().afErrorLog();
        if (afErrorLog2.values(map, purchaseValidationCallback, "purchases")) {
            AFd1hSDK aFd1hSDK = new AFd1hSDK(map, purchaseValidationCallback, afErrorLog2.AFInAppEventParameterName);
            AFd1sSDK aFd1sSDK = afErrorLog2.values;
            aFd1sSDK.AFInAppEventType.execute(new Runnable(aFd1hSDK) {
                private /* synthetic */ AFd1pSDK AFInAppEventType;

                /*  JADX ERROR: Method generation error
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
                /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFd1sSDK.3.run():void, class status: UNLOADED
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
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
            onValidateInAppFailure = (AppsFlyerConversionListener + 125) % 128;
        }
    }

    public final void sendPurchaseData(Context context, Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 39) % 128;
        values(context);
        PurchaseHandler afErrorLog2 = AFKeystoreWrapper().afErrorLog();
        if (afErrorLog2.values(map, purchaseValidationCallback, "subscriptions")) {
            AFd1nSDK aFd1nSDK = new AFd1nSDK(map, purchaseValidationCallback, afErrorLog2.AFInAppEventParameterName);
            AFd1sSDK aFd1sSDK = afErrorLog2.values;
            aFd1sSDK.AFInAppEventType.execute(new Runnable(aFd1nSDK) {
                private /* synthetic */ AFd1pSDK AFInAppEventType;

                /*  JADX ERROR: Method generation error
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
                /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFd1sSDK.3.run():void, class status: UNLOADED
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
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
            AppsFlyerConversionListener = (onValidateInAppFailure + 123) % 128;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x017b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendPushNotificationData(@androidx.annotation.NonNull android.app.Activity r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "c"
            java.lang.String r2 = "pid"
            java.lang.String r3 = "sendPushNotificationData"
            if (r17 == 0) goto L_0x003a
            android.content.Intent r4 = r17.getIntent()
            if (r4 == 0) goto L_0x003a
            com.appsflyer.internal.AFc1vSDK r4 = r16.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1sSDK r4 = r4.afErrorLogForExcManagerOnly()
            java.lang.String r5 = r17.getLocalClassName()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "activity_intent_"
            r6.<init>(r7)
            android.content.Intent r7 = r17.getIntent()
            java.lang.String r7 = r7.toString()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String[] r5 = new java.lang.String[]{r5, r6}
            r4.AFInAppEventType(r3, r5)
            goto L_0x0063
        L_0x003a:
            if (r17 == 0) goto L_0x0052
            com.appsflyer.internal.AFc1vSDK r4 = r16.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1sSDK r4 = r4.afErrorLogForExcManagerOnly()
            java.lang.String r5 = r17.getLocalClassName()
            java.lang.String r6 = "activity_intent_null"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6}
            r4.AFInAppEventType(r3, r5)
            goto L_0x0063
        L_0x0052:
            com.appsflyer.internal.AFc1vSDK r4 = r16.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1sSDK r4 = r4.afErrorLogForExcManagerOnly()
            java.lang.String r5 = "activity_null"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r4.AFInAppEventType(r3, r5)
        L_0x0063:
            java.lang.String r3 = AFInAppEventParameterName((android.app.Activity) r17)
            r1.afWarnLog = r3
            if (r3 == 0) goto L_0x01a6
            int r3 = onValidateInAppFailure
            int r3 = r3 + 21
            int r3 = r3 % 128
            AppsFlyerConversionListener = r3
            long r3 = java.lang.System.currentTimeMillis()
            java.util.Map<java.lang.Long, java.lang.String> r5 = r1.AFVersionDeclaration
            java.lang.String r6 = ")"
            if (r5 != 0) goto L_0x008c
            java.lang.String r0 = "pushes: initializing pushes history.."
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r1.AFVersionDeclaration = r0
            r10 = r3
            goto L_0x0168
        L_0x008c:
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x014d }
            java.lang.String r8 = "pushPayloadMaxAging"
            r9 = 1800000(0x1b7740, double:8.89318E-318)
            long r8 = r5.getLong(r8, r9)     // Catch:{ all -> 0x014d }
            java.util.Map<java.lang.Long, java.lang.String> r5 = r1.AFVersionDeclaration     // Catch:{ all -> 0x014d }
            java.util.Set r5 = r5.keySet()     // Catch:{ all -> 0x014d }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x014d }
            r10 = r3
        L_0x00a4:
            boolean r12 = r5.hasNext()     // Catch:{ all -> 0x0108 }
            if (r12 == 0) goto L_0x0168
            java.lang.Object r12 = r5.next()     // Catch:{ all -> 0x0108 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0108 }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x0108 }
            java.lang.String r14 = r1.afWarnLog     // Catch:{ all -> 0x0108 }
            r13.<init>(r14)     // Catch:{ all -> 0x0108 }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ all -> 0x0108 }
            java.util.Map<java.lang.Long, java.lang.String> r15 = r1.AFVersionDeclaration     // Catch:{ all -> 0x0108 }
            java.lang.Object r15 = r15.get(r12)     // Catch:{ all -> 0x0108 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x0108 }
            r14.<init>(r15)     // Catch:{ all -> 0x0108 }
            java.lang.Object r15 = r13.opt(r2)     // Catch:{ all -> 0x0108 }
            java.lang.Object r7 = r14.opt(r2)     // Catch:{ all -> 0x0108 }
            boolean r7 = r15.equals(r7)     // Catch:{ all -> 0x0108 }
            if (r7 == 0) goto L_0x010a
            java.lang.Object r7 = r13.opt(r0)     // Catch:{ all -> 0x0108 }
            java.lang.Object r15 = r14.opt(r0)     // Catch:{ all -> 0x0108 }
            boolean r7 = r7.equals(r15)     // Catch:{ all -> 0x0108 }
            if (r7 == 0) goto L_0x010a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0108 }
            java.lang.String r2 = "PushNotificationMeasurement: A previous payload with same PID and campaign was already acknowledged! (old: "
            r0.<init>(r2)     // Catch:{ all -> 0x0108 }
            r0.append(r14)     // Catch:{ all -> 0x0108 }
            java.lang.String r2 = ", new: "
            r0.append(r2)     // Catch:{ all -> 0x0108 }
            r0.append(r13)     // Catch:{ all -> 0x0108 }
            r0.append(r6)     // Catch:{ all -> 0x0108 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0108 }
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ all -> 0x0108 }
            r0 = 0
            r1.afWarnLog = r0     // Catch:{ all -> 0x0108 }
            int r0 = AppsFlyerConversionListener
            int r0 = r0 + 101
            int r0 = r0 % 128
            onValidateInAppFailure = r0
            return
        L_0x0108:
            r0 = move-exception
            goto L_0x014f
        L_0x010a:
            long r13 = r12.longValue()     // Catch:{ all -> 0x0108 }
            long r13 = r3 - r13
            int r7 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r7 <= 0) goto L_0x012d
            int r7 = AppsFlyerConversionListener
            int r7 = r7 + 13
            int r13 = r7 % 128
            onValidateInAppFailure = r13
            r13 = 2
            int r7 = r7 % r13
            if (r7 == 0) goto L_0x0126
            java.util.Map<java.lang.Long, java.lang.String> r7 = r1.AFVersionDeclaration     // Catch:{ all -> 0x0108 }
            r7.remove(r12)     // Catch:{ all -> 0x0108 }
            goto L_0x012d
        L_0x0126:
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.AFVersionDeclaration     // Catch:{ all -> 0x0108 }
            r0.remove(r12)     // Catch:{ all -> 0x0108 }
            r0 = 0
            throw r0     // Catch:{ all -> 0x0108 }
        L_0x012d:
            long r13 = r12.longValue()     // Catch:{ all -> 0x0108 }
            int r7 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r7 > 0) goto L_0x00a4
            int r7 = AppsFlyerConversionListener
            int r7 = r7 + 19
            int r13 = r7 % 128
            onValidateInAppFailure = r13
            r13 = 2
            int r7 = r7 % r13
            if (r7 == 0) goto L_0x0147
            long r10 = r12.longValue()     // Catch:{ all -> 0x0108 }
            goto L_0x00a4
        L_0x0147:
            long r10 = r12.longValue()     // Catch:{ all -> 0x0108 }
            r0 = 0
            throw r0     // Catch:{ all -> 0x0108 }
        L_0x014d:
            r0 = move-exception
            r10 = r3
        L_0x014f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "Error while handling push notification measurement: "
            r2.<init>(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.appsflyer.AFLogger.afErrorLog(r2, r0)
        L_0x0168:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "pushPayloadHistorySize"
            r5 = 2
            int r0 = r0.getInt(r2, r5)
            java.util.Map<java.lang.Long, java.lang.String> r2 = r1.AFVersionDeclaration
            int r2 = r2.size()
            if (r2 != r0) goto L_0x0198
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "pushes: removing oldest overflowing push (oldest push:"
            r0.<init>(r2)
            r0.append(r10)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.AFVersionDeclaration
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            r0.remove(r2)
        L_0x0198:
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.AFVersionDeclaration
            java.lang.Long r2 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = r1.afWarnLog
            r0.put(r2, r3)
            r16.start(r17)
        L_0x01a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.sendPushNotificationData(android.app.Activity):void");
    }

    public final void setAdditionalData(Map<String, Object> map) {
        int i10 = onValidateInAppFailure + 9;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 == 0) {
            if (map != null) {
                AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setAdditionalData", map.toString());
                AppsFlyerProperties.getInstance().setCustomData(new JSONObject(map).toString());
            }
            onValidateInAppFailure = (AppsFlyerConversionListener + 113) % 128;
            return;
        }
        throw null;
    }

    public final void setAndroidIdData(String str) {
        int i10 = AppsFlyerConversionListener + 25;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            AFb1sSDK afErrorLogForExcManagerOnly2 = AFKeystoreWrapper().afErrorLogForExcManagerOnly();
            String[] strArr = new String[0];
            strArr[1] = str;
            afErrorLogForExcManagerOnly2.AFInAppEventType("setAndroidIdData", strArr);
        } else {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setAndroidIdData", str);
        }
        this.afErrorLog = str;
    }

    public final void setAppId(String str) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 105) % 128;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setAppId", str);
        valueOf(AppsFlyerProperties.APP_ID, str);
        int i10 = AppsFlyerConversionListener + 49;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0042, code lost:
        if (r4.equals(com.appsflyer.AppsFlyerProperties.getInstance().getString(com.appsflyer.AppsFlyerProperties.ONELINK_ID)) == false) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setAppInviteOneLink(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = onValidateInAppFailure
            int r0 = r0 + 95
            int r0 = r0 % 128
            AppsFlyerConversionListener = r0
            com.appsflyer.internal.AFc1vSDK r0 = r3.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1sSDK r0 = r0.afErrorLogForExcManagerOnly()
            java.lang.String r1 = "setAppInviteOneLink"
            java.lang.String[] r2 = new java.lang.String[]{r4}
            r0.AFInAppEventType(r1, r2)
            java.lang.String r0 = java.lang.String.valueOf(r4)
            java.lang.String r1 = "setAppInviteOneLink = "
            java.lang.String r0 = r1.concat(r0)
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.lang.String r0 = "oneLinkSlug"
            if (r4 == 0) goto L_0x0052
            int r1 = onValidateInAppFailure
            int r1 = r1 + 47
            int r2 = r1 % 128
            AppsFlyerConversionListener = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L_0x0045
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = r1.getString(r0)
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x006d
            goto L_0x0052
        L_0x0045:
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r1.getString(r0)
            r4.equals(r0)
            r4 = 0
            throw r4
        L_0x0052:
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "onelinkDomain"
            r1.remove(r2)
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "onelinkVersion"
            r1.remove(r2)
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "onelinkScheme"
            r1.remove(r2)
        L_0x006d:
            valueOf((java.lang.String) r0, (java.lang.String) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.setAppInviteOneLink(java.lang.String):void");
    }

    public final void setCollectAndroidID(boolean z10) {
        int i10 = AppsFlyerConversionListener + 47;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setCollectAndroidID", String.valueOf(z10));
        } else {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setCollectAndroidID", String.valueOf(z10));
        }
        valueOf(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z10));
        valueOf(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z10));
        int i11 = AppsFlyerConversionListener + 49;
        onValidateInAppFailure = i11 % 128;
        if (i11 % 2 == 0) {
            throw null;
        }
    }

    public final void setCollectIMEI(boolean z10) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 5) % 128;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setCollectIMEI", String.valueOf(z10));
        valueOf(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z10));
        valueOf(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z10));
        int i10 = AppsFlyerConversionListener + 73;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            int i11 = 96 / 0;
        }
    }

    @Deprecated
    public final void setCollectOaid(boolean z10) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 39) % 128;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setCollectOaid", String.valueOf(z10));
        valueOf(AppsFlyerProperties.COLLECT_OAID, Boolean.toString(z10));
        AppsFlyerConversionListener = (onValidateInAppFailure + 63) % 128;
    }

    public final void setCurrencyCode(String str) {
        int i10 = AppsFlyerConversionListener + 29;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            AFb1sSDK afErrorLogForExcManagerOnly2 = AFKeystoreWrapper().afErrorLogForExcManagerOnly();
            String[] strArr = new String[0];
            strArr[0] = str;
            afErrorLogForExcManagerOnly2.AFInAppEventType("setCurrencyCode", strArr);
        } else {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setCurrencyCode", str);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.CURRENCY_CODE, str);
        onValidateInAppFailure = (AppsFlyerConversionListener + 9) % 128;
    }

    public final void setCustomerIdAndLogSession(String str, @NonNull Context context) {
        if (context != null) {
            onValidateInAppFailure = (AppsFlyerConversionListener + 53) % 128;
            if (valueOf()) {
                setCustomerUserId(str);
                StringBuilder sb2 = new StringBuilder("CustomerUserId set: ");
                sb2.append(str);
                sb2.append(" - Initializing AppsFlyer Tacking");
                AFLogger.afInfoLog(sb2.toString(), true);
                String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
                valueOf(context, AFe1hSDK.setCustomerIdAndLogSession);
                String str2 = AFKeystoreWrapper().getLevel().values;
                if (referrer == null) {
                    referrer = "";
                }
                String str3 = referrer;
                if (context instanceof Activity) {
                    int i10 = AppsFlyerConversionListener + 63;
                    onValidateInAppFailure = i10 % 128;
                    if (i10 % 2 != 0) {
                        ((Activity) context).getIntent();
                    } else {
                        ((Activity) context).getIntent();
                        throw null;
                    }
                }
                AFKeystoreWrapper(context, (String) null, (Map<String, Object>) null, str3, (String) null);
                return;
            }
            setCustomerUserId(str);
            AFLogger.afInfoLog("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
        }
        onValidateInAppFailure = (AppsFlyerConversionListener + 57) % 128;
    }

    public final void setCustomerUserId(String str) {
        onValidateInAppFailure = (AppsFlyerConversionListener + 31) % 128;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setCustomerUserId", str);
        AFLogger.afInfoLog("setCustomerUserId = ".concat(String.valueOf(str)));
        valueOf(AppsFlyerProperties.APP_USER_ID, str);
        valueOf(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false);
        onValidateInAppFailure = (AppsFlyerConversionListener + 63) % 128;
    }

    public final void setDebugLog(boolean z10) {
        AFLogger.LogLevel logLevel;
        if (z10) {
            AppsFlyerConversionListener = (onValidateInAppFailure + 29) % 128;
            logLevel = AFLogger.LogLevel.DEBUG;
        } else {
            logLevel = AFLogger.LogLevel.NONE;
            onValidateInAppFailure = (AppsFlyerConversionListener + 25) % 128;
        }
        setLogLevel(logLevel);
    }

    public final void setDisableAdvertisingIdentifiers(boolean z10) {
        boolean z11 = true;
        onValidateInAppFailure = (AppsFlyerConversionListener + 1) % 128;
        AFLogger.afDebugLog("setDisableAdvertisingIdentifiers: ".concat(String.valueOf(z10)));
        if (z10) {
            AppsFlyerConversionListener = (onValidateInAppFailure + 107) % 128;
            z11 = false;
        } else {
            AppsFlyerConversionListener = (onValidateInAppFailure + 33) % 128;
        }
        AFa1bSDK.values = Boolean.valueOf(z11);
        AppsFlyerProperties.getInstance().remove("advertiserIdEnabled");
        AppsFlyerProperties.getInstance().remove("advertiserId");
    }

    public final void setDisableNetworkData(boolean z10) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 17) % 128;
        AFLogger.afDebugLog("setDisableNetworkData: ".concat(String.valueOf(z10)));
        valueOf(AppsFlyerProperties.DISABLE_NETWORK_DATA, z10);
        int i10 = AppsFlyerConversionListener + 45;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            int i11 = 61 / 0;
        }
    }

    public final void setExtension(String str) {
        int i10 = onValidateInAppFailure + 13;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            AFb1sSDK afErrorLogForExcManagerOnly2 = AFKeystoreWrapper().afErrorLogForExcManagerOnly();
            String[] strArr = new String[0];
            strArr[0] = str;
            afErrorLogForExcManagerOnly2.AFInAppEventType("setExtension", strArr);
        } else {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setExtension", str);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
    }

    public final void setHost(@Nullable String str, @NonNull String str2) {
        String str3;
        if (!AFb1mSDK.values(str2)) {
            int i10 = onValidateInAppFailure;
            int i11 = i10 + 73;
            int i12 = i11 % 128;
            AppsFlyerConversionListener = i12;
            if (i11 % 2 == 0) {
                if (str != null) {
                    AppsFlyerConversionListener = (i10 + 29) % 128;
                    str3 = str.trim();
                    onValidateInAppFailure = (AppsFlyerConversionListener + 29) % 128;
                } else {
                    onValidateInAppFailure = (i12 + 9) % 128;
                    str3 = "";
                }
                AFd1wSDK.AFInAppEventParameterName(new AFc1aSDK(str3, str2.trim()));
                onValidateInAppFailure = (AppsFlyerConversionListener + 93) % 128;
                return;
            }
            throw null;
        }
        AFLogger.afWarnLog("hostname was empty or null - call for setHost is skipped");
    }

    public final void setImeiData(String str) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 113) % 128;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setImeiData", str);
        AFKeystoreWrapper().getLevel().AFInAppEventType = str;
        int i10 = onValidateInAppFailure + 49;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            throw null;
        }
    }

    public final void setIsUpdate(boolean z10) {
        int i10 = AppsFlyerConversionListener + 39;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            AFb1sSDK afErrorLogForExcManagerOnly2 = AFKeystoreWrapper().afErrorLogForExcManagerOnly();
            String[] strArr = new String[0];
            strArr[1] = String.valueOf(z10);
            afErrorLogForExcManagerOnly2.AFInAppEventType("setIsUpdate", strArr);
        } else {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setIsUpdate", String.valueOf(z10));
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z10);
        int i11 = onValidateInAppFailure + 121;
        AppsFlyerConversionListener = i11 % 128;
        if (i11 % 2 != 0) {
            throw null;
        }
    }

    public final void setLogLevel(@NonNull AFLogger.LogLevel logLevel) {
        boolean z10;
        int i10 = AppsFlyerConversionListener + 5;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 != 0) {
            if (logLevel.getLevel() > AFLogger.LogLevel.NONE.getLevel()) {
                z10 = true;
            } else {
                AppsFlyerConversionListener = (onValidateInAppFailure + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) % 128;
                z10 = false;
            }
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("log", String.valueOf(z10));
            AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
            AppsFlyerConversionListener = (onValidateInAppFailure + 41) % 128;
            return;
        }
        logLevel.getLevel();
        AFLogger.LogLevel.NONE.getLevel();
        throw null;
    }

    public final void setMinTimeBetweenSessions(int i10) {
        onValidateInAppFailure = (AppsFlyerConversionListener + 81) % 128;
        this.getLevel = TimeUnit.SECONDS.toMillis((long) i10);
        AppsFlyerConversionListener = (onValidateInAppFailure + 97) % 128;
    }

    public final void setOaidData(String str) {
        int i10 = onValidateInAppFailure + 119;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            AFb1sSDK afErrorLogForExcManagerOnly2 = AFKeystoreWrapper().afErrorLogForExcManagerOnly();
            String[] strArr = new String[0];
            strArr[1] = str;
            afErrorLogForExcManagerOnly2.AFInAppEventType("setOaidData", strArr);
        } else {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setOaidData", str);
        }
        AFa1bSDK.AFKeystoreWrapper = str;
    }

    public final void setOneLinkCustomDomain(String... strArr) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 107) % 128;
        AFLogger.afDebugLog(String.format("setOneLinkCustomDomain %s", new Object[]{Arrays.toString(strArr)}));
        AFa1tSDK.AFKeystoreWrapper = strArr;
        onValidateInAppFailure = (AppsFlyerConversionListener + 39) % 128;
    }

    public final void setOutOfStore(String str) {
        if (str != null) {
            int i10 = onValidateInAppFailure + 105;
            AppsFlyerConversionListener = i10 % 128;
            int i11 = i10 % 2;
            String lowerCase = str.toLowerCase(Locale.getDefault());
            AppsFlyerProperties.getInstance().set("api_store_value", lowerCase);
            AFLogger.afInfoLog("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
            return;
        }
        AFLogger.AFInAppEventParameterName("Cannot set setOutOfStore with null");
        int i12 = AppsFlyerConversionListener + 57;
        onValidateInAppFailure = i12 % 128;
        if (i12 % 2 == 0) {
            int i13 = 69 / 0;
        }
    }

    public final void setPartnerData(@NonNull String str, Map<String, Object> map) {
        String str2;
        int i10 = onValidateInAppFailure + 11;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 == 0) {
            if (this.onConversionDataSuccess == null) {
                this.onConversionDataSuccess = new AFb1eSDK();
            }
            AFb1eSDK aFb1eSDK = this.onConversionDataSuccess;
            if (str != null) {
                AppsFlyerConversionListener = (onValidateInAppFailure + 7) % 128;
                if (!str.isEmpty()) {
                    if (map == null || map.isEmpty()) {
                        if (aFb1eSDK.valueOf.remove(str) == null) {
                            onValidateInAppFailure = (AppsFlyerConversionListener + 19) % 128;
                            str2 = "Partner data is missing or `null`";
                        } else {
                            str2 = "Cleared partner data for ".concat(str);
                        }
                        AFLogger.afWarnLog(str2);
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder("Setting partner data for ");
                    sb2.append(str);
                    sb2.append(": ");
                    sb2.append(map);
                    AFLogger.afDebugLog(sb2.toString());
                    int length = new JSONObject(map).toString().length();
                    if (length > 1000) {
                        AFLogger.afWarnLog("Partner data 1000 characters limit exceeded");
                        HashMap hashMap = new HashMap();
                        hashMap.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, "limit exceeded: ".concat(String.valueOf(length)));
                        aFb1eSDK.values.put(str, hashMap);
                        AppsFlyerConversionListener = (onValidateInAppFailure + 97) % 128;
                        return;
                    }
                    aFb1eSDK.valueOf.put(str, map);
                    aFb1eSDK.values.remove(str);
                    return;
                }
            }
            AFLogger.afWarnLog("Partner ID is missing or `null`");
            onValidateInAppFailure = (AppsFlyerConversionListener + 113) % 128;
            return;
        }
        throw null;
    }

    public final void setPhoneNumber(String str) {
        int i10 = AppsFlyerConversionListener + 13;
        onValidateInAppFailure = i10 % 128;
        int i11 = i10 % 2;
        this.onAttributionFailureNative = AFb1ySDK.AFInAppEventParameterName(str);
        if (i11 == 0) {
            throw null;
        }
    }

    public final void setPluginInfo(@NonNull PluginInfo pluginInfo) {
        onValidateInAppFailure = (AppsFlyerConversionListener + 43) % 128;
        Objects.requireNonNull(pluginInfo);
        AFKeystoreWrapper().AppsFlyer2dXConversionCallback().values(pluginInfo);
        int i10 = AppsFlyerConversionListener + 61;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            throw null;
        }
    }

    public final void setPreinstallAttribution(String str, String str2, String str3) {
        AFLogger.afDebugLog("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put("pid", str);
            } catch (JSONException e10) {
                AFLogger.afErrorLog(e10.getMessage(), e10);
            }
        }
        if (str2 != null) {
            jSONObject.put(d.f18103f, str2);
        }
        if (str3 != null) {
            int i10 = AppsFlyerConversionListener + 119;
            onValidateInAppFailure = i10 % 128;
            if (i10 % 2 != 0) {
                jSONObject.put("af_siteid", str3);
            } else {
                jSONObject.put("af_siteid", str3);
                throw null;
            }
        }
        if (!jSONObject.has("pid")) {
            AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
            int i11 = AppsFlyerConversionListener + 57;
            onValidateInAppFailure = i11 % 128;
            if (i11 % 2 == 0) {
                throw null;
            }
            return;
        }
        int i12 = onValidateInAppFailure + 37;
        AppsFlyerConversionListener = i12 % 128;
        if (i12 % 2 == 0) {
            valueOf("preInstallName", jSONObject.toString());
        } else {
            valueOf("preInstallName", jSONObject.toString());
            throw null;
        }
    }

    public final void setResolveDeepLinkURLs(String... strArr) {
        String format;
        int i10 = AppsFlyerConversionListener + 45;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            format = String.format("setResolveDeepLinkURLs %s", new Object[]{Arrays.toString(strArr)});
        } else {
            format = String.format("setResolveDeepLinkURLs %s", new Object[]{Arrays.toString(strArr)});
        }
        AFLogger.afDebugLog(format);
        List<String> list = AFa1tSDK.AFInAppEventParameterName;
        list.clear();
        list.addAll(Arrays.asList(strArr));
        AppsFlyerConversionListener = (onValidateInAppFailure + 63) % 128;
    }

    @Deprecated
    public final void setSharingFilter(@NonNull String... strArr) {
        int i10 = onValidateInAppFailure + 107;
        AppsFlyerConversionListener = i10 % 128;
        int i11 = i10 % 2;
        setSharingFilterForPartners(strArr);
        if (i11 == 0) {
            int i12 = AppsFlyerConversionListener + 75;
            onValidateInAppFailure = i12 % 128;
            if (i12 % 2 == 0) {
                throw null;
            }
            return;
        }
        throw null;
    }

    @Deprecated
    public final void setSharingFilterForAllPartners() {
        AppsFlyerConversionListener = (onValidateInAppFailure + 23) % 128;
        setSharingFilterForPartners("all");
        AppsFlyerConversionListener = (onValidateInAppFailure + 63) % 128;
    }

    public final void setSharingFilterForPartners(String... strArr) {
        this.AFLogger = new AFa1eSDK(strArr);
        onValidateInAppFailure = (AppsFlyerConversionListener + 111) % 128;
    }

    public final void setUserEmails(String... strArr) {
        int i10 = AppsFlyerConversionListener + 111;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 != 0) {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setUserEmails", strArr);
            setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
            return;
        }
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setUserEmails", strArr);
        setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
        throw null;
    }

    public final void start(@NonNull Context context) {
        int i10 = onValidateInAppFailure + 17;
        AppsFlyerConversionListener = i10 % 128;
        int i11 = i10 % 2;
        start(context, (String) null);
        if (i11 != 0) {
            int i12 = 85 / 0;
        }
        AppsFlyerConversionListener = (onValidateInAppFailure + 3) % 128;
    }

    public final void stop(boolean z10, Context context) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 1) % 128;
        values(context);
        AFKeystoreWrapper().getLevel().AFKeystoreWrapper = z10;
        AFKeystoreWrapper().afWarnLog().values();
        if (!(!z10)) {
            AppsFlyerConversionListener = (onValidateInAppFailure + 13) % 128;
            AFInAppEventType(context).AFInAppEventType("is_stop_tracking_used", true);
            onValidateInAppFailure = (AppsFlyerConversionListener + 125) % 128;
        }
    }

    public final void subscribeForDeepLink(@NonNull DeepLinkListener deepLinkListener) {
        int i10 = onValidateInAppFailure + 45;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            subscribeForDeepLink(deepLinkListener, TimeUnit.SECONDS.toMillis(3));
            int i11 = 25 / 0;
        } else {
            subscribeForDeepLink(deepLinkListener, TimeUnit.SECONDS.toMillis(3));
        }
        AppsFlyerConversionListener = (onValidateInAppFailure + 69) % 128;
    }

    public final void unregisterConversionListener() {
        int i10 = onValidateInAppFailure + 79;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("unregisterConversionListener", new String[0]);
        } else {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("unregisterConversionListener", new String[0]);
        }
        AFInAppEventType = null;
        AppsFlyerConversionListener = (onValidateInAppFailure + 63) % 128;
    }

    public final void updateServerUninstallToken(Context context, String str) {
        boolean z10;
        values(context);
        AFe1lSDK aFe1lSDK = new AFe1lSDK(context);
        if (str == null || str.trim().isEmpty()) {
            AFLogger.afWarnLog("[register] Firebase Token is either empty or null and was not registered.");
            return;
        }
        AFLogger.afInfoLog("[register] Firebase Refreshed Token = ".concat(str));
        AFb1uSDK AFKeystoreWrapper2 = aFe1lSDK.AFKeystoreWrapper();
        if (AFKeystoreWrapper2 == null || !str.equals(AFKeystoreWrapper2.AFKeystoreWrapper)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (AFKeystoreWrapper2 == null || currentTimeMillis - AFKeystoreWrapper2.AFInAppEventParameterName > TimeUnit.SECONDS.toMillis(2)) {
                z10 = true;
            } else {
                z10 = false;
            }
            AFb1uSDK aFb1uSDK = new AFb1uSDK(str, currentTimeMillis, !z10);
            aFe1lSDK.valueOf.valueOf("afUninstallToken", aFb1uSDK.AFKeystoreWrapper);
            aFe1lSDK.valueOf.AFInAppEventType("afUninstallToken_received_time", aFb1uSDK.AFInAppEventParameterName);
            aFe1lSDK.valueOf.AFInAppEventType("afUninstallToken_queued", aFb1uSDK.AFKeystoreWrapper());
            if (z10) {
                AFe1lSDK.AFKeystoreWrapper(str);
            }
        }
    }

    public final void validateAndLogInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        String obj;
        Intent intent;
        Context context2 = context;
        String str6 = str3;
        String str7 = str4;
        String str8 = str5;
        AFb1sSDK afErrorLogForExcManagerOnly2 = AFKeystoreWrapper().afErrorLogForExcManagerOnly();
        if (map == null) {
            obj = "";
        } else {
            obj = map.toString();
        }
        afErrorLogForExcManagerOnly2.AFInAppEventType("validateAndTrackInAppPurchase", str, str2, str3, str4, str5, obj);
        if (!isStopped()) {
            StringBuilder sb2 = new StringBuilder("Validate in app called with parameters: ");
            sb2.append(str6);
            sb2.append(" ");
            sb2.append(str7);
            sb2.append(" ");
            sb2.append(str8);
            AFLogger.afInfoLog(sb2.toString());
        }
        if (str == null || str7 == null || str2 == null || str8 == null || str6 == null) {
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = values;
            if (appsFlyerInAppPurchaseValidatorListener != null) {
                appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        String str9 = AFKeystoreWrapper().getLevel().values;
        if (context2 instanceof Activity) {
            intent = ((Activity) context2).getIntent();
        } else {
            intent = null;
        }
        new Thread(new AFa1fSDK(applicationContext, str9, str, str2, str3, str4, str5, map, intent)).start();
    }

    public final void waitForCustomerUserId(boolean z10) {
        onValidateInAppFailure = (AppsFlyerConversionListener + 119) % 128;
        AFLogger.afInfoLog("initAfterCustomerUserID: ".concat(String.valueOf(z10)), true);
        valueOf(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, z10);
        int i10 = onValidateInAppFailure + 65;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            int i11 = 97 / 0;
        }
    }

    static /* synthetic */ void AFInAppEventParameterName(AFb1xSDK aFb1xSDK, AFa1sSDK aFa1sSDK) {
        int i10 = AppsFlyerConversionListener + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
        onValidateInAppFailure = i10 % 128;
        int i11 = i10 % 2;
        aFb1xSDK.valueOf(aFa1sSDK);
        if (i11 == 0) {
            throw null;
        }
    }

    public static AFb1xSDK AFInAppEventType() {
        int i10 = onValidateInAppFailure;
        int i11 = i10 + 113;
        AppsFlyerConversionListener = i11 % 128;
        if (i11 % 2 == 0) {
            AFb1xSDK aFb1xSDK = afInfoLog;
            int i12 = i10 + 71;
            AppsFlyerConversionListener = i12 % 128;
            if (i12 % 2 != 0) {
                int i13 = 51 / 0;
            }
            return aFb1xSDK;
        }
        throw null;
    }

    private String AFLogger$LogLevel(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string == null) {
            return AFInAppEventParameterName(context, "AF_STORE");
        }
        AppsFlyerConversionListener = (onValidateInAppFailure + DNSResolver.GOBACK_LOCAL) % 128;
        return string;
    }

    private static boolean afErrorLog(Context context) {
        onValidateInAppFailure = (AppsFlyerConversionListener + 107) % 128;
        if (!AFKeystoreWrapper(context).contains("appsFlyerCount")) {
            return true;
        }
        AppsFlyerConversionListener = (onValidateInAppFailure + 17) % 128;
        return false;
    }

    private static void afInfoLog(Context context) {
        try {
            if ((context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.flags & 32768) != 0) {
                if (context.getResources().getIdentifier("appsflyer_backup_rules", "xml", context.getPackageName()) != 0) {
                    int i10 = onValidateInAppFailure + 27;
                    AppsFlyerConversionListener = i10 % 128;
                    int i11 = i10 % 2;
                    AFLogger.afInfoLog("appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", true);
                    return;
                }
                AFLogger.AFInAppEventParameterName("'allowBackup' is set to true; appsflyer_backup_rules.xml not detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules");
            }
            onValidateInAppFailure = (AppsFlyerConversionListener + 89) % 128;
        } catch (Exception e10) {
            AFLogger.afErrorLogForExcManagerOnly("checkBackupRules Exception", e10);
            AFLogger.afRDLog("checkBackupRules Exception: ".concat(String.valueOf(e10)));
        }
    }

    static /* synthetic */ Map valueOf(AFb1xSDK aFb1xSDK) {
        int i10 = onValidateInAppFailure;
        int i11 = i10 + 63;
        AppsFlyerConversionListener = i11 % 128;
        int i12 = i11 % 2;
        Map<String, Object> map = aFb1xSDK.onResponseErrorNative;
        if (i12 != 0) {
            int i13 = 61 / 0;
        }
        AppsFlyerConversionListener = (i10 + 63) % 128;
        return map;
    }

    public static String values() {
        AppsFlyerConversionListener = (onValidateInAppFailure + 47) % 128;
        String AFInAppEventType2 = AFInAppEventType(AppsFlyerProperties.APP_USER_ID);
        int i10 = AppsFlyerConversionListener + 49;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 != 0) {
            return AFInAppEventType2;
        }
        throw null;
    }

    public final AFc1vSDK AFKeystoreWrapper() {
        int i10 = onValidateInAppFailure;
        AFc1tSDK aFc1tSDK = this.onAttributionFailure;
        AppsFlyerConversionListener = (i10 + 97) % 128;
        return aFc1tSDK;
    }

    public final void logEvent(@NonNull Context context, String str, Map<String, Object> map, AppsFlyerRequestListener appsFlyerRequestListener) {
        Activity activity = null;
        HashMap hashMap = map == null ? null : new HashMap(map);
        values(context);
        AFf1ySDK aFf1ySDK = new AFf1ySDK();
        if (context != null) {
            aFf1ySDK.AFInAppEventType = (Application) context.getApplicationContext();
        }
        aFf1ySDK.afDebugLog = str;
        aFf1ySDK.values = appsFlyerRequestListener;
        if (hashMap != null && hashMap.containsKey(AFInAppEventParameterName.TOUCH_OBJ)) {
            HashMap hashMap2 = new HashMap();
            Object obj = hashMap.get(AFInAppEventParameterName.TOUCH_OBJ);
            if (obj instanceof MotionEvent) {
                MotionEvent motionEvent = (MotionEvent) obj;
                HashMap hashMap3 = new HashMap();
                hashMap3.put("x", Float.valueOf(motionEvent.getX()));
                hashMap3.put("y", Float.valueOf(motionEvent.getY()));
                hashMap2.put("loc", hashMap3);
                hashMap2.put("pf", Float.valueOf(motionEvent.getPressure()));
                hashMap2.put("rad", Float.valueOf(motionEvent.getTouchMajor() / 2.0f));
            } else {
                hashMap2.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Parsing failed due to invalid input in 'af_touch_obj'.");
                AFLogger.AFInAppEventParameterName("Parsing failed due to invalid input in 'af_touch_obj'.");
            }
            Map singletonMap = Collections.singletonMap("tch_data", hashMap2);
            hashMap.remove(AFInAppEventParameterName.TOUCH_OBJ);
            aFf1ySDK.AFKeystoreWrapper((Map<String, ?>) singletonMap);
        }
        aFf1ySDK.AFInAppEventParameterName = hashMap;
        AFb1sSDK afErrorLogForExcManagerOnly2 = AFKeystoreWrapper().afErrorLogForExcManagerOnly();
        Map map2 = aFf1ySDK.AFInAppEventParameterName;
        if (map2 == null) {
            map2 = new HashMap();
        }
        afErrorLogForExcManagerOnly2.AFInAppEventType("logEvent", str, new JSONObject(map2).toString());
        if (str == null) {
            valueOf(context, AFe1hSDK.logEvent);
        }
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        AFKeystoreWrapper((AFa1sSDK) aFf1ySDK, activity);
    }

    public final void start(@NonNull Context context, String str) {
        int i10 = onValidateInAppFailure + 83;
        AppsFlyerConversionListener = i10 % 128;
        int i11 = i10 % 2;
        start(context, str, (AppsFlyerRequestListener) null);
        if (i11 != 0) {
            int i12 = 92 / 0;
        }
    }

    public final void subscribeForDeepLink(@NonNull DeepLinkListener deepLinkListener, long j10) {
        int i10 = AppsFlyerConversionListener + 119;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            AFKeystoreWrapper().onInstallConversionDataLoadedNative().valueOf = deepLinkListener;
            AFb1oSDK.afWarnLog = j10;
            int i11 = 61 / 0;
        } else {
            AFKeystoreWrapper().onInstallConversionDataLoadedNative().valueOf = deepLinkListener;
            AFb1oSDK.afWarnLog = j10;
        }
        int i12 = AppsFlyerConversionListener + 121;
        onValidateInAppFailure = i12 % 128;
        if (i12 % 2 == 0) {
            throw null;
        }
    }

    private static String AFInAppEventType(String str) {
        int i10 = AppsFlyerConversionListener + 71;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 != 0) {
            String string = AppsFlyerProperties.getInstance().getString(str);
            onValidateInAppFailure = (AppsFlyerConversionListener + 59) % 128;
            return string;
        }
        AppsFlyerProperties.getInstance().getString(str);
        throw null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void AFKeystoreWrapper(Context context, Intent intent) {
        values(context);
        AFa1tSDK onInstallConversionDataLoadedNative2 = AFKeystoreWrapper().onInstallConversionDataLoadedNative();
        AFc1ySDK afInfoLog2 = AFKeystoreWrapper().afInfoLog();
        Uri valueOf2 = AFa1tSDK.valueOf(intent);
        boolean z10 = false;
        if (valueOf2 == null || valueOf2.toString().isEmpty()) {
            AppsFlyerConversionListener = (onValidateInAppFailure + 103) % 128;
        } else {
            int i10 = AppsFlyerConversionListener + 87;
            onValidateInAppFailure = i10 % 128;
            if (i10 % 2 != 0) {
                z10 = true;
            }
        }
        if (!afInfoLog2.AFKeystoreWrapper("ddl_sent") || z10) {
            onInstallConversionDataLoadedNative2.valueOf((Map<String, Object>) new HashMap(), intent, context);
            return;
        }
        AppsFlyerConversionListener = (onValidateInAppFailure + 117) % 128;
        AFb1nSDK.AFInAppEventType("No direct deep link", (DeepLinkResult.Error) null);
        int i11 = onValidateInAppFailure + 81;
        AppsFlyerConversionListener = i11 % 128;
        if (i11 % 2 != 0) {
            throw null;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private static void afDebugLog(android.content.Context r4) {
        /*
            boolean r0 = com.appsflyer.internal.AFa1cSDK.AFInAppEventType()
            if (r0 == 0) goto L_0x000e
            java.lang.String r0 = "OPPO device found"
            com.appsflyer.AFLogger.afRDLog(r0)
            r0 = 23
            goto L_0x0010
        L_0x000e:
            r0 = 18
        L_0x0010:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r0) goto L_0x00b8
            java.lang.String r0 = "keyPropDisableAFKeystore"
            r2 = 1
            boolean r0 = AFInAppEventType((java.lang.String) r0, (boolean) r2)
            if (r0 != 0) goto L_0x00b8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "OS SDK is="
            r0.<init>(r3)
            r0.append(r1)
            java.lang.String r1 = "; use KeyStore"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afRDLog(r0)
            com.appsflyer.AFKeystoreWrapper r0 = new com.appsflyer.AFKeystoreWrapper
            r0.<init>(r4)
            boolean r1 = r0.values()
            if (r1 != 0) goto L_0x0054
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r4)
            java.lang.String r4 = com.appsflyer.internal.AFb1wSDK.AFKeystoreWrapper(r1)
            r0.AFInAppEventParameterName = r4
            r4 = 0
            r0.valueOf = r4
            java.lang.String r4 = r0.AFInAppEventParameterName()
            r0.values(r4)
            goto L_0x009f
        L_0x0054:
            java.lang.String r4 = r0.AFInAppEventParameterName()
            java.lang.Object r1 = r0.values
            monitor-enter(r1)
            int r3 = r0.valueOf     // Catch:{ all -> 0x007a }
            int r3 = r3 + r2
            r0.valueOf = r3     // Catch:{ all -> 0x007a }
            java.lang.String r2 = "Deleting key with alias: "
            java.lang.String r3 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x007a }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x007a }
            com.appsflyer.AFLogger.afInfoLog(r2)     // Catch:{ all -> 0x007a }
            java.lang.Object r2 = r0.values     // Catch:{ KeyStoreException -> 0x007c }
            monitor-enter(r2)     // Catch:{ KeyStoreException -> 0x007c }
            java.security.KeyStore r3 = r0.AFInAppEventType     // Catch:{ all -> 0x0077 }
            r3.deleteEntry(r4)     // Catch:{ all -> 0x0077 }
            monitor-exit(r2)     // Catch:{ all -> 0x0077 }
            goto L_0x0097
        L_0x0077:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ KeyStoreException -> 0x007c }
            throw r4     // Catch:{ KeyStoreException -> 0x007c }
        L_0x007a:
            r4 = move-exception
            goto L_0x00b6
        L_0x007c:
            r4 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x007a }
            java.lang.String r3 = "Exception "
            r2.<init>(r3)     // Catch:{ all -> 0x007a }
            java.lang.String r3 = r4.getMessage()     // Catch:{ all -> 0x007a }
            r2.append(r3)     // Catch:{ all -> 0x007a }
            java.lang.String r3 = " occurred"
            r2.append(r3)     // Catch:{ all -> 0x007a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x007a }
            com.appsflyer.AFLogger.afErrorLog(r2, r4)     // Catch:{ all -> 0x007a }
        L_0x0097:
            monitor-exit(r1)     // Catch:{ all -> 0x007a }
            java.lang.String r4 = r0.AFInAppEventParameterName()
            r0.values(r4)
        L_0x009f:
            java.lang.String r4 = "KSAppsFlyerId"
            java.lang.String r1 = r0.AFInAppEventType()
            valueOf((java.lang.String) r4, (java.lang.String) r1)
            java.lang.String r4 = "KSAppsFlyerRICounter"
            int r0 = r0.valueOf()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            valueOf((java.lang.String) r4, (java.lang.String) r0)
            return
        L_0x00b6:
            monitor-exit(r1)
            throw r4
        L_0x00b8:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "OS SDK is="
            r4.<init>(r0)
            r4.append(r1)
            java.lang.String r0 = "; no KeyStore usage"
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.appsflyer.AFLogger.afRDLog(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.afDebugLog(android.content.Context):void");
    }

    public final void AFInAppEventParameterName(Context context, Intent intent) {
        int i10 = onValidateInAppFailure + 35;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 == 0) {
            if (intent.getStringExtra("appsflyer_preinstall") != null) {
                valueOf(intent.getStringExtra("appsflyer_preinstall"));
            }
            AFLogger.afInfoLog("****** onReceive called *******");
            AppsFlyerProperties.getInstance();
            String stringExtra = intent.getStringExtra(com.adjust.sdk.Constants.REFERRER);
            AFLogger.afInfoLog("Play store referrer: ".concat(String.valueOf(stringExtra)));
            if (stringExtra != null) {
                AppsFlyerConversionListener = (onValidateInAppFailure + 87) % 128;
                AFInAppEventType(context).valueOf(com.adjust.sdk.Constants.REFERRER, stringExtra);
                AppsFlyerProperties instance = AppsFlyerProperties.getInstance();
                instance.set("AF_REFERRER", stringExtra);
                instance.valueOf = stringExtra;
                if (AppsFlyerProperties.getInstance().AFKeystoreWrapper()) {
                    int i11 = AppsFlyerConversionListener + 105;
                    onValidateInAppFailure = i11 % 128;
                    if (i11 % 2 == 0) {
                        AFLogger.afInfoLog("onReceive: isLaunchCalled");
                        valueOf(context, AFe1hSDK.onReceive);
                        AFInAppEventType(context, stringExtra);
                        int i12 = 20 / 0;
                        return;
                    }
                    AFLogger.afInfoLog("onReceive: isLaunchCalled");
                    valueOf(context, AFe1hSDK.onReceive);
                    AFInAppEventType(context, stringExtra);
                    return;
                }
                return;
            }
            return;
        }
        intent.getStringExtra("appsflyer_preinstall");
        throw null;
    }

    public final void start(@NonNull Context context, String str, final AppsFlyerRequestListener appsFlyerRequestListener) {
        int i10 = AppsFlyerConversionListener + 21;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            AFKeystoreWrapper().onAttributionFailureNative().valueOf();
            throw null;
        } else if (!AFKeystoreWrapper().onAttributionFailureNative().valueOf()) {
            if (!this.onAppOpenAttributionNative) {
                AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! The API call 'start()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
                if (str == null) {
                    if (appsFlyerRequestListener != null) {
                        AppsFlyerConversionListener = (onValidateInAppFailure + 115) % 128;
                        appsFlyerRequestListener.onError(RequestError.NO_DEV_KEY, AFb1aSDK.valueOf);
                        AppsFlyerConversionListener = (onValidateInAppFailure + 39) % 128;
                        return;
                    }
                    return;
                }
            }
            values(context);
            final AFe1jSDK AFLogger2 = AFKeystoreWrapper().AFLogger();
            AFLogger2.AFInAppEventParameterName(AFa1oSDK.AFInAppEventParameterName(context));
            this.init = (Application) context.getApplicationContext();
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("start", str);
            String str2 = valueOf;
            AFLogger.afInfoLog(String.format("Starting AppsFlyer: (v%s.%s)", new Object[]{"6.10.2", str2}));
            StringBuilder sb2 = new StringBuilder("Build Number: ");
            sb2.append(str2);
            AFLogger.afInfoLog(sb2.toString());
            AppsFlyerProperties.getInstance().loadProperties(this.init.getApplicationContext());
            if (!TextUtils.isEmpty(str)) {
                AFKeystoreWrapper().getLevel().values = str;
                AFc1rSDK.AFKeystoreWrapper(str);
            } else if (TextUtils.isEmpty(AFKeystoreWrapper().getLevel().values)) {
                onValidateInAppFailure = (AppsFlyerConversionListener + 61) % 128;
                AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
                if (appsFlyerRequestListener != null) {
                    appsFlyerRequestListener.onError(RequestError.NO_DEV_KEY, AFb1aSDK.valueOf);
                    return;
                }
                return;
            }
            AFKeystoreWrapper().afRDLog().values((AFe1xSDK) null);
            AFVersionDeclaration();
            afInfoLog(this.init.getBaseContext());
            if (this.onDeepLinkingNative) {
                afRDLog(this.init.getApplicationContext());
                onValidateInAppFailure = (AppsFlyerConversionListener + 49) % 128;
            }
            AFc1tSDK aFc1tSDK = this.onAttributionFailure;
            if (aFc1tSDK.values == null) {
                aFc1tSDK.values = new AFb1gSDK(aFc1tSDK.valueOf(), aFc1tSDK.onInstallConversionDataLoadedNative());
            }
            aFc1tSDK.values.values(context, new AFb1dSDK.AFa1wSDK() {
                public final void AFKeystoreWrapper(@Nullable Context context) {
                    AFLogger.afInfoLog("onBecameBackground");
                    AFe1jSDK aFe1jSDK = AFLogger2;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j10 = aFe1jSDK.AFLogger;
                    if (j10 != 0) {
                        long j11 = currentTimeMillis - j10;
                        if (j11 > 0 && j11 < 1000) {
                            j11 = 1000;
                        }
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(j11);
                        aFe1jSDK.afErrorLogForExcManagerOnly = seconds;
                        aFe1jSDK.values.AFInAppEventType("prev_session_dur", seconds);
                    } else {
                        AFLogger.afInfoLog("Metrics: fg ts is missing");
                    }
                    AFLogger.afInfoLog("callStatsBackground background call");
                    AFb1xSDK.this.values((WeakReference<Context>) new WeakReference(context));
                    AFb1xSDK.this.AFKeystoreWrapper().onConversionDataSuccess().valueOf();
                    AFb1sSDK afErrorLogForExcManagerOnly = AFb1xSDK.this.AFKeystoreWrapper().afErrorLogForExcManagerOnly();
                    if (afErrorLogForExcManagerOnly.afInfoLog()) {
                        afErrorLogForExcManagerOnly.values();
                        if (context != null && !AppsFlyerLib.getInstance().isStopped()) {
                            afErrorLogForExcManagerOnly.AFInAppEventParameterName(context.getPackageName(), context.getPackageManager(), AFb1xSDK.this.AFKeystoreWrapper());
                        }
                        afErrorLogForExcManagerOnly.AFKeystoreWrapper();
                    } else {
                        AFLogger.afDebugLog("RD status is OFF");
                    }
                    AFa1dSDK.AFInAppEventType(context).AFInAppEventType();
                }

                public final void valueOf(@Nullable Activity activity) {
                    AFLogger2.AFKeystoreWrapper();
                    AFb1xSDK.this.AFKeystoreWrapper().afRDLog().values((AFe1xSDK) null);
                    AFb1xSDK.AFKeystoreWrapper(AFb1xSDK.this);
                    int valueOf = AFb1xSDK.this.valueOf(AFb1xSDK.AFKeystoreWrapper((Context) activity), false);
                    AFLogger.afInfoLog("onBecameForeground");
                    if (valueOf < 2) {
                        AFa1dSDK AFInAppEventType2 = AFa1dSDK.AFInAppEventType((Context) activity);
                        AFInAppEventType2.AFKeystoreWrapper.post(AFInAppEventType2.afRDLog);
                        AFInAppEventType2.AFKeystoreWrapper.post(AFInAppEventType2.values);
                    }
                    AFf1xSDK aFf1xSDK = new AFf1xSDK();
                    AFb1xSDK.this.AFKeystoreWrapper().onInstallConversionDataLoadedNative().valueOf(aFf1xSDK.AFKeystoreWrapper(), activity.getIntent(), (Context) activity.getApplication());
                    AFb1xSDK aFb1xSDK = AFb1xSDK.this;
                    aFf1xSDK.AFInAppEventType = (Application) activity.getApplicationContext();
                    aFf1xSDK.values = appsFlyerRequestListener;
                    aFb1xSDK.AFKeystoreWrapper((AFa1sSDK) aFf1xSDK, activity);
                }
            });
        }
    }

    public final void valueOf(Context context, String str) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONArray jSONArray2;
        AFLogger.afDebugLog("received a new (extra) referrer: ".concat(String.valueOf(str)));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String string = AFKeystoreWrapper(context).getString("extraReferrers", (String) null);
            if (string == null) {
                jSONObject = new JSONObject();
                jSONArray = new JSONArray();
            } else {
                JSONObject jSONObject2 = new JSONObject(string);
                if (jSONObject2.has(str)) {
                    jSONArray2 = new JSONArray((String) jSONObject2.get(str));
                } else {
                    jSONArray2 = new JSONArray();
                }
                JSONObject jSONObject3 = jSONObject2;
                jSONArray = jSONArray2;
                jSONObject = jSONObject3;
            }
            if (((long) jSONArray.length()) < 5) {
                jSONArray.put(currentTimeMillis);
            }
            if (((long) jSONObject.length()) >= 4) {
                onValidateInAppFailure = (AppsFlyerConversionListener + 113) % 128;
                AFInAppEventParameterName(jSONObject);
                AppsFlyerConversionListener = (onValidateInAppFailure + 45) % 128;
            }
            jSONObject.put(str, jSONArray.toString());
            AFInAppEventType(context).valueOf("extraReferrers", jSONObject.toString());
        } catch (JSONException e10) {
            AFLogger.afErrorLogForExcManagerOnly("error at addReferrer", e10);
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder("Couldn't save referrer - ");
            sb2.append(str);
            sb2.append(": ");
            AFLogger.afErrorLog(sb2.toString(), th);
        }
    }

    /* access modifiers changed from: package-private */
    public final void values(WeakReference<Context> weakReference) {
        if (weakReference.get() != null) {
            AFLogger.afInfoLog("app went to background");
            SharedPreferences AFKeystoreWrapper2 = AFKeystoreWrapper(weakReference.get());
            AppsFlyerProperties.getInstance().saveProperties(AFKeystoreWrapper2);
            long j10 = AFKeystoreWrapper().AFLogger().afErrorLogForExcManagerOnly;
            HashMap hashMap = new HashMap();
            String str = AFKeystoreWrapper().getLevel().values;
            if (str == null) {
                AppsFlyerConversionListener = (onValidateInAppFailure + 65) % 128;
                AFLogger.afWarnLog("[callStats] AppsFlyer's SDK cannot send any event without providing DevKey.");
                return;
            }
            String AFInAppEventType2 = AFInAppEventType("KSAppsFlyerId");
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
                AppsFlyerConversionListener = (onValidateInAppFailure + 93) % 128;
                hashMap.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
            }
            AFc1oSDK.AFa1xSDK values2 = AFa1bSDK.values(weakReference.get().getContentResolver());
            if (values2 != null) {
                hashMap.put("amazon_aid", values2.AFInAppEventParameterName);
                hashMap.put("amazon_aid_limit", String.valueOf(values2.valueOf));
            }
            String string = AppsFlyerProperties.getInstance().getString("advertiserId");
            if (string != null) {
                hashMap.put("advertiserId", string);
            }
            hashMap.put(Constant.PARAM_APP_ID, weakReference.get().getPackageName());
            hashMap.put("devkey", str);
            hashMap.put("uid", AFb1wSDK.AFKeystoreWrapper(weakReference));
            hashMap.put("time_in_app", String.valueOf(j10));
            hashMap.put("statType", "user_closed_app");
            hashMap.put("platform", "Android");
            hashMap.put("launch_counter", Integer.toString(valueOf(AFKeystoreWrapper2, false)));
            hashMap.put(AppsFlyerProperties.CHANNEL, AFInAppEventParameterName(weakReference.get()));
            if (AFInAppEventType2 != null) {
                int i10 = (AppsFlyerConversionListener + 105) % 128;
                onValidateInAppFailure = i10;
                AppsFlyerConversionListener = (i10 + 51) % 128;
            } else {
                AFInAppEventType2 = "";
            }
            hashMap.put("originalAppsflyerId", AFInAppEventType2);
            if (this.onInstallConversionDataLoadedNative) {
                AFf1zSDK aFf1zSDK = new AFf1zSDK();
                aFf1zSDK.AFVersionDeclaration = isStopped();
                AFe1zSDK aFe1zSDK = new AFe1zSDK((AFf1zSDK) aFf1zSDK.AFInAppEventParameterName(AFKeystoreWrapper().values().valueOf.AFInAppEventType("appsFlyerCount", 0)).AFKeystoreWrapper((Map<String, ?>) hashMap).AFKeystoreWrapper(String.format(afDebugLog, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFInAppEventType().getHostName()})), AFKeystoreWrapper());
                AFd1sSDK afDebugLog2 = AFKeystoreWrapper().afDebugLog();
                afDebugLog2.AFInAppEventType.execute(new Runnable(aFe1zSDK) {
                    private /* synthetic */ AFd1pSDK AFInAppEventType;

                    /*  JADX ERROR: Method generation error
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
                    /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFd1sSDK.3.run():void, class status: UNLOADED
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
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
                return;
            }
            AFLogger.afDebugLog("Stats call is disabled, ignore ...");
        }
    }

    private static boolean AFInAppEventType(String str, boolean z10) {
        int i10 = AppsFlyerConversionListener + 117;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 != 0) {
            boolean z11 = AppsFlyerProperties.getInstance().getBoolean(str, z10);
            int i11 = AppsFlyerConversionListener + 71;
            onValidateInAppFailure = i11 % 128;
            if (i11 % 2 != 0) {
                return z11;
            }
            throw null;
        }
        AppsFlyerProperties.getInstance().getBoolean(str, z10);
        throw null;
    }

    private long afWarnLog(Context context) {
        long j10;
        long j11;
        int i10 = onValidateInAppFailure + 37;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            j11 = AFKeystoreWrapper(context).getLong("AppsFlyerTimePassedSincePrevLaunch", 0);
            j10 = System.currentTimeMillis();
            AFInAppEventType(context).AFInAppEventType("AppsFlyerTimePassedSincePrevLaunch", j10);
            if (j11 <= 1) {
                return -1;
            }
        } else {
            long j12 = AFKeystoreWrapper(context).getLong("AppsFlyerTimePassedSincePrevLaunch", 0);
            long currentTimeMillis = System.currentTimeMillis();
            AFInAppEventType(context).AFInAppEventType("AppsFlyerTimePassedSincePrevLaunch", currentTimeMillis);
            if (j12 <= 0) {
                return -1;
            }
            j11 = j12;
            j10 = currentTimeMillis;
        }
        int i11 = AppsFlyerConversionListener;
        int i12 = i11 + 51;
        onValidateInAppFailure = i12 % 128;
        long j13 = i12 % 2 == 0 ? j11 & j10 : j10 - j11;
        onValidateInAppFailure = (i11 + 95) % 128;
        return j13 / 1000;
    }

    public static String AFInAppEventType(SimpleDateFormat simpleDateFormat, long j10) {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(new Date(j10));
        AppsFlyerConversionListener = (onValidateInAppFailure + 39) % 128;
        return format;
    }

    public final void setUserEmails(AppsFlyerProperties.EmailsCryptType emailsCryptType, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setUserEmails", (String[]) arrayList.toArray(new String[(strArr.length + 1)]));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        String str = null;
        for (String str2 : strArr) {
            AppsFlyerConversionListener = (onValidateInAppFailure + 25) % 128;
            if (AnonymousClass4.AFKeystoreWrapper[emailsCryptType.ordinal()] != 2) {
                arrayList2.add(AFb1ySDK.AFInAppEventParameterName(str2));
                AppsFlyerConversionListener = (onValidateInAppFailure + 19) % 128;
                str = "sha256_el_arr";
            } else {
                arrayList2.add(str2);
                str = "plain_el_arr";
            }
        }
        hashMap.put(str, arrayList2);
        AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(hashMap).toString());
    }

    private void AFInAppEventType(Context context, String str) {
        AFe1dSDK aFe1dSDK = new AFe1dSDK();
        if (context != null) {
            AppsFlyerConversionListener = (onValidateInAppFailure + 13) % 128;
            aFe1dSDK.AFInAppEventType = (Application) context.getApplicationContext();
            AppsFlyerConversionListener = (onValidateInAppFailure + 115) % 128;
        }
        AFa1sSDK AFInAppEventParameterName2 = aFe1dSDK.AFInAppEventParameterName(AFKeystoreWrapper().values().valueOf.AFInAppEventType("appsFlyerCount", 0));
        AFInAppEventParameterName2.AFLogger = str;
        if (str != null) {
            AppsFlyerConversionListener = (onValidateInAppFailure + 17) % 128;
            if (str.length() > 5 && AFInAppEventType(AFInAppEventParameterName2, AFKeystoreWrapper(context))) {
                values(AFKeystoreWrapper().AFInAppEventParameterName(), new AFa1vSDK(this, AFInAppEventParameterName2, (byte) 0), 5, TimeUnit.MILLISECONDS);
            }
        }
    }

    private String getLevel(Context context) {
        String str;
        SharedPreferences AFKeystoreWrapper2 = AFKeystoreWrapper(context);
        String AFInAppEventType2 = AFInAppEventType("preInstallName");
        if (AFInAppEventType2 != null) {
            return AFInAppEventType2;
        }
        if (AFKeystoreWrapper2.contains("preInstallName")) {
            str = AFKeystoreWrapper2.getString("preInstallName", (String) null);
        } else {
            if (afErrorLog(context)) {
                int i10 = onValidateInAppFailure + 43;
                AppsFlyerConversionListener = i10 % 128;
                if (i10 % 2 == 0) {
                    AFInAppEventType2 = afErrorLogForExcManagerOnly(context);
                    if (AFInAppEventType2 == null) {
                        AFInAppEventType2 = AFInAppEventParameterName(context, "AF_PRE_INSTALL_NAME");
                    }
                } else {
                    afErrorLogForExcManagerOnly(context);
                    throw null;
                }
            }
            if (AFInAppEventType2 != null) {
                int i11 = AppsFlyerConversionListener + 111;
                onValidateInAppFailure = i11 % 128;
                if (i11 % 2 != 0) {
                    AFInAppEventType(context).valueOf("preInstallName", AFInAppEventType2);
                } else {
                    AFInAppEventType(context).valueOf("preInstallName", AFInAppEventType2);
                    throw null;
                }
            }
            str = AFInAppEventType2;
        }
        if (str != null) {
            int i12 = onValidateInAppFailure + 31;
            AppsFlyerConversionListener = i12 % 128;
            if (i12 % 2 != 0) {
                valueOf("preInstallName", str);
                int i13 = 84 / 0;
            } else {
                valueOf("preInstallName", str);
            }
        }
        return str;
    }

    private void AFVersionDeclaration() {
        onValidateInAppFailure = (AppsFlyerConversionListener + 19) % 128;
        if (!AFd1gSDK.AFLogger()) {
            AFc1vSDK AFKeystoreWrapper2 = AFKeystoreWrapper();
            AFd1sSDK afDebugLog2 = AFKeystoreWrapper2.afDebugLog();
            afDebugLog2.AFInAppEventType.execute(new Runnable(new AFd1gSDK(AFKeystoreWrapper2)) {
                private /* synthetic */ AFd1pSDK AFInAppEventType;

                /*  JADX ERROR: Method generation error
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
                /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFd1sSDK.3.run():void, class status: UNLOADED
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
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
            int i10 = onValidateInAppFailure + 17;
            AppsFlyerConversionListener = i10 % 128;
            if (i10 % 2 != 0) {
                throw null;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void AFKeystoreWrapper(AFe1vSDK aFe1vSDK) {
        int i10 = AppsFlyerConversionListener + 75;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            AFe1vSDK aFe1vSDK2 = AFe1vSDK.SUCCESS;
            throw null;
        } else if (aFe1vSDK == AFe1vSDK.SUCCESS) {
            AppsFlyerConversionListener = (onValidateInAppFailure + 11) % 128;
            AFKeystoreWrapper().onConversionDataSuccess().AFInAppEventType();
        }
    }

    private static boolean AFLogger(Context context) {
        if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false)) {
            int i10 = onValidateInAppFailure + 19;
            AppsFlyerConversionListener = i10 % 128;
            if (i10 % 2 == 0 ? !AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false) : (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, true))) {
                if (valueOf(context)) {
                    return false;
                }
            }
        }
        onValidateInAppFailure = (AppsFlyerConversionListener + 57) % 128;
        return true;
    }

    @NonNull
    private AFf1kSDK[] afErrorLogForExcManagerOnly() {
        int i10 = onValidateInAppFailure + 1;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 == 0) {
            AFf1kSDK[] AFInAppEventParameterName2 = AFKeystoreWrapper().AFVersionDeclaration().AFInAppEventParameterName();
            int i11 = onValidateInAppFailure + 53;
            AppsFlyerConversionListener = i11 % 128;
            if (i11 % 2 == 0) {
                return AFInAppEventParameterName2;
            }
            throw null;
        }
        AFKeystoreWrapper().AFVersionDeclaration().AFInAppEventParameterName();
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001a, code lost:
        if (r4.trim().isEmpty() != false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
        if (r4.trim().isEmpty() != false) goto L_0x002e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0064 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0065  */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void AFKeystoreWrapper(android.content.Context r3, java.lang.String r4, java.util.Map<java.lang.String, java.lang.Object> r5, java.lang.String r6, java.lang.String r7) {
        /*
            r2 = this;
            if (r4 == 0) goto L_0x002e
            int r0 = AppsFlyerConversionListener
            int r0 = r0 + 87
            int r1 = r0 % 128
            onValidateInAppFailure = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x001d
            java.lang.String r0 = r4.trim()
            boolean r0 = r0.isEmpty()
            r1 = 14
            int r1 = r1 / 0
            if (r0 == 0) goto L_0x0028
            goto L_0x002e
        L_0x001d:
            java.lang.String r0 = r4.trim()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0028
            goto L_0x002e
        L_0x0028:
            com.appsflyer.internal.AFf1ySDK r0 = new com.appsflyer.internal.AFf1ySDK
            r0.<init>()
            goto L_0x0033
        L_0x002e:
            com.appsflyer.internal.AFf1xSDK r0 = new com.appsflyer.internal.AFf1xSDK
            r0.<init>()
        L_0x0033:
            if (r3 == 0) goto L_0x004d
            int r1 = onValidateInAppFailure
            int r1 = r1 + 101
            int r1 = r1 % 128
            AppsFlyerConversionListener = r1
            android.content.Context r3 = r3.getApplicationContext()
            android.app.Application r3 = (android.app.Application) r3
            r0.AFInAppEventType = r3
            int r3 = onValidateInAppFailure
            int r3 = r3 + 67
            int r3 = r3 % 128
            AppsFlyerConversionListener = r3
        L_0x004d:
            r0.afDebugLog = r4
            r0.AFInAppEventParameterName = r5
            r0.AFLogger = r6
            r0.valueOf = r7
            r2.values((com.appsflyer.internal.AFa1sSDK) r0)
            int r3 = onValidateInAppFailure
            int r3 = r3 + 25
            int r4 = r3 % 128
            AppsFlyerConversionListener = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x0065
            return
        L_0x0065:
            r3 = 0
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFKeystoreWrapper(android.content.Context, java.lang.String, java.util.Map, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean AFInAppEventType(com.appsflyer.internal.AFa1sSDK r5, android.content.SharedPreferences r6) {
        /*
            r4 = this;
            r0 = 0
            int r1 = r4.valueOf((android.content.SharedPreferences) r6, (boolean) r0)
            r2 = 1
            if (r1 != r2) goto L_0x0015
            int r3 = AppsFlyerConversionListener
            int r3 = r3 + r2
            int r3 = r3 % 128
            onValidateInAppFailure = r3
            boolean r5 = r5 instanceof com.appsflyer.internal.AFe1eSDK
            if (r5 != 0) goto L_0x0015
            r5 = r2
            goto L_0x0016
        L_0x0015:
            r5 = r0
        L_0x0016:
            java.lang.String r3 = "newGPReferrerSent"
            boolean r6 = r6.getBoolean(r3, r0)
            if (r6 == 0) goto L_0x001f
            goto L_0x0022
        L_0x001f:
            if (r1 != r2) goto L_0x0022
            goto L_0x002c
        L_0x0022:
            int r6 = AppsFlyerConversionListener
            int r6 = r6 + 29
            int r6 = r6 % 128
            onValidateInAppFailure = r6
            if (r5 == 0) goto L_0x002d
        L_0x002c:
            return r2
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFInAppEventType(com.appsflyer.internal.AFa1sSDK, android.content.SharedPreferences):boolean");
    }

    private static void valueOf(String str, String str2) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 21) % 128;
        AppsFlyerProperties.getInstance().set(str, str2);
        int i10 = AppsFlyerConversionListener + 111;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            int i11 = 3 / 0;
        }
    }

    private static void AFInAppEventParameterName(JSONObject jSONObject) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (true) {
            int i10 = 0;
            if (!keys.hasNext()) {
                break;
            }
            try {
                JSONArray jSONArray = new JSONArray((String) jSONObject.get(keys.next()));
                while (i10 < jSONArray.length()) {
                    int i11 = AppsFlyerConversionListener + 61;
                    onValidateInAppFailure = i11 % 128;
                    if (i11 % 2 == 0) {
                        arrayList.add(Long.valueOf(jSONArray.getLong(i10)));
                        i10 += 42;
                    } else {
                        arrayList.add(Long.valueOf(jSONArray.getLong(i10)));
                        i10++;
                    }
                }
            } catch (JSONException e10) {
                AFLogger.afErrorLogForExcManagerOnly("error at timeStampArr", e10);
            }
        }
        Collections.sort(arrayList);
        Iterator<String> keys2 = jSONObject.keys();
        loop2:
        while (true) {
            str = null;
            while (keys2.hasNext() && str == null) {
                String next = keys2.next();
                try {
                    JSONArray jSONArray2 = new JSONArray((String) jSONObject.get(next));
                    onValidateInAppFailure = (AppsFlyerConversionListener + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) % 128;
                    int i12 = 0;
                    while (i12 < jSONArray2.length()) {
                        if (jSONArray2.getLong(i12) != ((Long) arrayList.get(0)).longValue() && jSONArray2.getLong(i12) != ((Long) arrayList.get(1)).longValue() && jSONArray2.getLong(i12) != ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                            i12++;
                            str = next;
                        }
                    }
                    continue;
                } catch (JSONException e11) {
                    AFLogger.afErrorLogForExcManagerOnly("error at manageExtraReferrers", e11);
                }
            }
        }
        if (str != null) {
            jSONObject.remove(str);
        }
    }

    private static void valueOf(String str, boolean z10) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 81) % 128;
        AppsFlyerProperties.getInstance().set(str, z10);
        int i10 = AppsFlyerConversionListener + 59;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            throw null;
        }
    }

    private void AFInAppEventType(Map<String, Object> map) {
        if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false)) {
            int i10 = onValidateInAppFailure + 79;
            AppsFlyerConversionListener = i10 % 128;
            if (i10 % 2 == 0 ? !AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false) : !AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) {
                if (map.get("advertiserId") != null) {
                    try {
                        if (AFb1mSDK.valueOf(this.afErrorLog)) {
                            AppsFlyerConversionListener = (onValidateInAppFailure + 1) % 128;
                            if (map.remove("android_id") != null) {
                                int i11 = AppsFlyerConversionListener + 11;
                                onValidateInAppFailure = i11 % 128;
                                if (i11 % 2 != 0) {
                                    AFLogger.afInfoLog("validateGaidAndIMEI :: removing: android_id");
                                } else {
                                    AFLogger.afInfoLog("validateGaidAndIMEI :: removing: android_id");
                                    throw null;
                                }
                            }
                        }
                        if (AFb1mSDK.valueOf(AFKeystoreWrapper().getLevel().AFInAppEventType) && map.remove("imei") != null) {
                            AFLogger.afInfoLog("validateGaidAndIMEI :: removing: imei");
                            AppsFlyerConversionListener = (onValidateInAppFailure + 5) % 128;
                            return;
                        }
                        return;
                    } catch (Exception e10) {
                        AFLogger.afErrorLog("failed to remove IMEI or AndroidID key from params; ", e10);
                    }
                }
            }
        }
        onValidateInAppFailure = (AppsFlyerConversionListener + 7) % 128;
    }

    public final boolean valueOf() {
        if (AFInAppEventType(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            onValidateInAppFailure = (AppsFlyerConversionListener + 23) % 128;
            if (values() == null) {
                onValidateInAppFailure = (AppsFlyerConversionListener + 39) % 128;
                return true;
            }
        }
        return false;
    }

    private boolean afRDLog() {
        String format;
        if (this.afRDLog > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.afRDLog;
            Locale locale = Locale.US;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", locale);
            String AFInAppEventType2 = AFInAppEventType(simpleDateFormat, this.afRDLog);
            String AFInAppEventType3 = AFInAppEventType(simpleDateFormat, this.AFLogger$LogLevel);
            if (currentTimeMillis < this.getLevel) {
                onValidateInAppFailure = (AppsFlyerConversionListener + 43) % 128;
                if (!isStopped()) {
                    int i10 = onValidateInAppFailure + 125;
                    AppsFlyerConversionListener = i10 % 128;
                    if (i10 % 2 != 0) {
                        Object[] objArr = new Object[4];
                        objArr[0] = AFInAppEventType2;
                        objArr[0] = AFInAppEventType3;
                        objArr[3] = Long.valueOf(currentTimeMillis);
                        objArr[2] = Long.valueOf(this.getLevel);
                        format = String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", objArr);
                    } else {
                        format = String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", new Object[]{AFInAppEventType2, AFInAppEventType3, Long.valueOf(currentTimeMillis), Long.valueOf(this.getLevel)});
                    }
                    AFLogger.afInfoLog(format);
                    return true;
                }
            }
            if (!isStopped()) {
                onValidateInAppFailure = (AppsFlyerConversionListener + 93) % 128;
                AFLogger.afInfoLog(String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", new Object[]{AFInAppEventType2, AFInAppEventType3, Long.valueOf(currentTimeMillis)}));
            }
        } else if (!isStopped()) {
            AFLogger.afInfoLog("Sending first launch for this session!");
            AppsFlyerConversionListener = (onValidateInAppFailure + 63) % 128;
        }
        return false;
    }

    private Runnable valueOf(AFf1pSDK aFf1pSDK) {
        h hVar;
        int i10 = onValidateInAppFailure + 41;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            hVar = new h(this, aFf1pSDK);
            int i11 = 38 / 0;
        } else {
            hVar = new h(this, aFf1pSDK);
        }
        int i12 = onValidateInAppFailure + 59;
        AppsFlyerConversionListener = i12 % 128;
        if (i12 % 2 == 0) {
            return hVar;
        }
        throw null;
    }

    private static File afDebugLog(String str) {
        int i10 = (AppsFlyerConversionListener + 59) % 128;
        onValidateInAppFailure = i10;
        if (str != null) {
            AppsFlyerConversionListener = (i10 + 107) % 128;
            try {
                if (str.trim().length() > 0) {
                    return new File(str.trim());
                }
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getMessage(), th);
                return null;
            }
        }
        AppsFlyerConversionListener = (onValidateInAppFailure + 51) % 128;
        return null;
    }

    private void valueOf(Context context, AFe1hSDK aFe1hSDK) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 81) % 128;
        values(context);
        AFe1jSDK AFLogger2 = AFKeystoreWrapper().AFLogger();
        AFe1fSDK AFInAppEventParameterName2 = AFa1oSDK.AFInAppEventParameterName(context);
        if (AFLogger2.AFInAppEventParameterName()) {
            AFLogger2.valueOf.put("api_name", aFe1hSDK.toString());
            AFLogger2.AFInAppEventParameterName(AFInAppEventParameterName2);
        }
        AFLogger2.AFKeystoreWrapper();
        onValidateInAppFailure = (AppsFlyerConversionListener + 119) % 128;
    }

    private void AFKeystoreWrapper(Map<String, Object> map, boolean z10) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 57) % 128;
        map.put("platformextension", this.AppsFlyer2dXConversionCallback.AFKeystoreWrapper());
        if (!(!z10)) {
            AppsFlyerConversionListener = (onValidateInAppFailure + 1) % 128;
            map.put("platform_extension_v2", AFKeystoreWrapper().AppsFlyer2dXConversionCallback().values());
        }
    }

    public static Map<String, Object> AFKeystoreWrapper(Map<String, Object> map) {
        onValidateInAppFailure = (AppsFlyerConversionListener + 71) % 128;
        if (map.containsKey("meta")) {
            return (Map) map.get("meta");
        }
        HashMap hashMap = new HashMap();
        map.put("meta", hashMap);
        onValidateInAppFailure = (AppsFlyerConversionListener + 35) % 128;
        return hashMap;
    }

    public static boolean valueOf(Context context) {
        int i10 = onValidateInAppFailure + 1;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 == 0) {
            try {
                if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
                    AppsFlyerConversionListener = (onValidateInAppFailure + 55) % 128;
                    return true;
                }
            } catch (Throwable th) {
                AFLogger.afErrorLog("WARNING:  Google play services is unavailable. ", th);
            }
        } else {
            GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
            throw null;
        }
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e10) {
            AFLogger.afErrorLog("WARNING:  Google Play Services is unavailable. ", e10);
            return false;
        }
    }

    private static boolean AFKeystoreWrapper(@NonNull SharedPreferences sharedPreferences) {
        int i10 = AppsFlyerConversionListener + 45;
        onValidateInAppFailure = i10 % 128;
        int i11 = i10 % 2;
        String string = sharedPreferences.getString("sentSuccessfully", (String) null);
        if (i11 != 0) {
            return Boolean.parseBoolean(string);
        }
        Boolean.parseBoolean(string);
        throw null;
    }

    private static void AFKeystoreWrapper(Context context, Map<String, Object> map) {
        String str;
        int i10 = onValidateInAppFailure + 107;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 == 0) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                int rotation = windowManager.getDefaultDisplay().getRotation();
                if (rotation == 0) {
                    str = "p";
                } else if (rotation == 1) {
                    str = "l";
                } else if (rotation == 2) {
                    str = "pr";
                } else if (rotation != 3) {
                    str = "";
                } else {
                    AppsFlyerConversionListener = (onValidateInAppFailure + 123) % 128;
                    str = "lr";
                }
                map.put("sc_o", str);
                return;
            }
            return;
        }
        WindowManager windowManager2 = (WindowManager) context.getSystemService("window");
        throw null;
    }

    private static void valueOf(String str) {
        try {
            if (new JSONObject(str).has("pid")) {
                int i10 = onValidateInAppFailure + 9;
                AppsFlyerConversionListener = i10 % 128;
                if (i10 % 2 != 0) {
                    valueOf("preInstallName", str);
                    int i11 = 31 / 0;
                    return;
                }
                valueOf("preInstallName", str);
                return;
            }
            AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
            AppsFlyerConversionListener = (onValidateInAppFailure + 47) % 128;
        } catch (JSONException e10) {
            AFLogger.afErrorLog("Error parsing JSON for preinstall", e10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void AFInAppEventParameterName(AFf1pSDK aFf1pSDK) {
        boolean z10;
        SharedPreferences AFKeystoreWrapper2 = AFKeystoreWrapper((Context) this.init);
        int AFInAppEventType2 = AFKeystoreWrapper().values().valueOf.AFInAppEventType("appsFlyerCount", 0);
        boolean z11 = AFKeystoreWrapper2.getBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, false);
        if (aFf1pSDK.afRDLog == AFf1kSDK.AFa1wSDK.NOT_STARTED) {
            z10 = true;
        } else {
            AppsFlyerConversionListener = (onValidateInAppFailure + 37) % 128;
            z10 = false;
        }
        if (AFInAppEventType2 == 1) {
            int i10 = AppsFlyerConversionListener + 65;
            onValidateInAppFailure = i10 % 128;
            if (i10 % 2 == 0) {
                throw null;
            } else if (z10 || z11) {
                AFe1eSDK aFe1eSDK = new AFe1eSDK();
                Application application = this.init;
                if (application != null) {
                    int i11 = AppsFlyerConversionListener + 113;
                    onValidateInAppFailure = i11 % 128;
                    if (i11 % 2 == 0) {
                        aFe1eSDK.AFInAppEventType = (Application) application.getApplicationContext();
                        int i12 = 26 / 0;
                    } else {
                        aFe1eSDK.AFInAppEventType = (Application) application.getApplicationContext();
                    }
                }
                valueOf((AFa1sSDK) aFe1eSDK);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0026, code lost:
        if (r0 == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003f, code lost:
        if (r0 == false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void AFInAppEventType(android.content.Context r6, java.util.Map<java.lang.String, ? super java.lang.String> r7) {
        /*
            r5 = this;
            int r0 = onValidateInAppFailure
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            AppsFlyerConversionListener = r2
            int r0 = r0 % 2
            r2 = 0
            java.lang.String r3 = "network"
            java.lang.String r4 = "disableCollectNetworkData"
            if (r0 == 0) goto L_0x0029
            boolean r0 = AFInAppEventType((java.lang.String) r4, (boolean) r1)
            com.appsflyer.internal.AFc1vSDK r1 = r5.AFKeystoreWrapper()
            com.appsflyer.internal.AFa1hSDK r1 = r1.onInstallConversionFailureNative()
            com.appsflyer.internal.AFa1hSDK$AFa1zSDK r6 = r1.valueOf(r6)
            java.lang.String r1 = r6.AFKeystoreWrapper
            r7.put(r3, r1)
            if (r0 != 0) goto L_0x0058
            goto L_0x0041
        L_0x0029:
            r0 = 0
            boolean r0 = AFInAppEventType((java.lang.String) r4, (boolean) r0)
            com.appsflyer.internal.AFc1vSDK r1 = r5.AFKeystoreWrapper()
            com.appsflyer.internal.AFa1hSDK r1 = r1.onInstallConversionFailureNative()
            com.appsflyer.internal.AFa1hSDK$AFa1zSDK r6 = r1.valueOf(r6)
            java.lang.String r1 = r6.AFKeystoreWrapper
            r7.put(r3, r1)
            if (r0 != 0) goto L_0x0058
        L_0x0041:
            int r1 = AppsFlyerConversionListener
            int r1 = r1 + 65
            int r3 = r1 % 128
            onValidateInAppFailure = r3
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x0057
            java.lang.String r1 = r6.AFInAppEventParameterName
            if (r1 == 0) goto L_0x0058
            java.lang.String r3 = "operator"
            r7.put(r3, r1)
            goto L_0x0058
        L_0x0057:
            throw r2
        L_0x0058:
            if (r0 != 0) goto L_0x007f
            int r0 = onValidateInAppFailure
            int r1 = r0 + 115
            int r1 = r1 % 128
            AppsFlyerConversionListener = r1
            java.lang.String r6 = r6.AFInAppEventType
            if (r6 == 0) goto L_0x007f
            int r0 = r0 + 73
            int r1 = r0 % 128
            AppsFlyerConversionListener = r1
            int r0 = r0 % 2
            java.lang.String r1 = "carrier"
            r7.put(r1, r6)
            if (r0 != 0) goto L_0x007e
            int r6 = AppsFlyerConversionListener
            int r6 = r6 + 119
            int r6 = r6 % 128
            onValidateInAppFailure = r6
            goto L_0x007f
        L_0x007e:
            throw r2
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFInAppEventType(android.content.Context, java.util.Map):void");
    }

    private void AFKeystoreWrapper(Context context, boolean z10, Map<String, Object> map, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("cpu_abi", values("ro.product.cpu.abi"));
        hashMap.put("cpu_abi2", values("ro.product.cpu.abi2"));
        hashMap.put("arch", values("os.arch"));
        hashMap.put("build_display_id", values("ro.build.display.id"));
        if (z10) {
            AppsFlyerConversionListener = (onValidateInAppFailure + 69) % 128;
            AFInAppEventParameterName(context, (Map<String, Object>) hashMap);
            if (i10 <= 2) {
                onValidateInAppFailure = (AppsFlyerConversionListener + 63) % 128;
                hashMap.putAll(AFa1dSDK.AFInAppEventType(context).AFInAppEventParameterName());
                AppsFlyerConversionListener = (onValidateInAppFailure + 123) % 128;
            }
        }
        hashMap.put("dim", AFc1lSDK.AFInAppEventType(context));
        map.put("deviceData", hashMap);
        AppsFlyerConversionListener = (onValidateInAppFailure + 111) % 128;
    }

    private void values(Context context, String str, Map<String, Object> map) {
        AFf1ySDK aFf1ySDK = new AFf1ySDK();
        Activity activity = null;
        if (context != null) {
            int i10 = onValidateInAppFailure + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            AppsFlyerConversionListener = i10 % 128;
            if (i10 % 2 == 0) {
                aFf1ySDK.AFInAppEventType = (Application) context.getApplicationContext();
            } else {
                aFf1ySDK.AFInAppEventType = (Application) context.getApplicationContext();
                throw null;
            }
        }
        aFf1ySDK.afDebugLog = str;
        aFf1ySDK.AFInAppEventParameterName = map;
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        AFKeystoreWrapper((AFa1sSDK) aFf1ySDK, activity);
        onValidateInAppFailure = (AppsFlyerConversionListener + 69) % 128;
    }

    public final int valueOf(SharedPreferences sharedPreferences, boolean z10) {
        int i10 = AppsFlyerConversionListener + 97;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 != 0) {
            return AFInAppEventType(sharedPreferences, "appsFlyerCount", z10);
        }
        AFInAppEventType(sharedPreferences, "appsFlyerCount", z10);
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x01d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void valueOf(com.appsflyer.internal.AFa1sSDK r13) {
        /*
            r12 = this;
            android.app.Application r0 = r13.AFInAppEventType
            if (r0 != 0) goto L_0x0012
            int r13 = onValidateInAppFailure
            int r13 = r13 + 75
            int r13 = r13 % 128
            AppsFlyerConversionListener = r13
            java.lang.String r13 = "sendWithEvent - got null context. skipping event/launch."
            com.appsflyer.AFLogger.afDebugLog(r13)
            return
        L_0x0012:
            android.content.SharedPreferences r1 = AFKeystoreWrapper((android.content.Context) r0)
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            r2.saveProperties(r1)
            com.appsflyer.internal.AFc1vSDK r2 = r12.AFKeystoreWrapper()
            com.appsflyer.internal.AFe1nSDK r2 = r2.getLevel()
            boolean r2 = r2.AFInAppEventParameterName()
            if (r2 != 0) goto L_0x0044
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "sendWithEvent from activity: "
            r2.<init>(r3)
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
        L_0x0044:
            boolean r0 = r13.AFInAppEventParameterName()
            java.util.Map r2 = r12.AFInAppEventType((com.appsflyer.internal.AFa1sSDK) r13)
            java.lang.String r3 = "appsflyerKey"
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r4 = 0
            r5 = 2
            if (r3 == 0) goto L_0x01ea
            int r6 = onValidateInAppFailure
            int r6 = r6 + 35
            int r6 = r6 % 128
            AppsFlyerConversionListener = r6
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0068
            goto L_0x01ea
        L_0x0068:
            boolean r3 = r12.isStopped()
            if (r3 != 0) goto L_0x0073
            java.lang.String r3 = "AppsFlyerLib.sendWithEvent"
            com.appsflyer.AFLogger.afInfoLog(r3)
        L_0x0073:
            r3 = 0
            int r1 = r12.valueOf((android.content.SharedPreferences) r1, (boolean) r3)
            com.appsflyer.internal.AFf1hSDK r6 = new com.appsflyer.internal.AFf1hSDK
            com.appsflyer.internal.AFc1tSDK r7 = r12.onAttributionFailure
            r6.<init>(r7)
            java.lang.String r7 = ""
            kotlin.jvm.internal.m.f(r13, r7)
            boolean r8 = r13.AFInAppEventParameterName()
            boolean r9 = r13 instanceof com.appsflyer.internal.AFe1cSDK
            boolean r10 = r13 instanceof com.appsflyer.internal.AFe1dSDK
            boolean r11 = r13 instanceof com.appsflyer.internal.AFe1eSDK
            if (r11 != 0) goto L_0x00f0
            if (r10 == 0) goto L_0x0093
            goto L_0x00f0
        L_0x0093:
            if (r9 == 0) goto L_0x00a2
            java.lang.String r8 = com.appsflyer.internal.AFf1hSDK.afInfoLog
            if (r8 != 0) goto L_0x00fc
            com.appsflyer.internal.AFf1fSDK r8 = r6.AFInAppEventType
            java.lang.String r10 = com.appsflyer.internal.AFf1hSDK.valueOf
            java.lang.String r8 = r8.AFKeystoreWrapper(r10)
            goto L_0x00fc
        L_0x00a2:
            if (r8 == 0) goto L_0x00d0
            int r8 = onValidateInAppFailure
            int r8 = r8 + 119
            int r8 = r8 % 128
            AppsFlyerConversionListener = r8
            if (r1 >= r5) goto L_0x00bb
            java.lang.String r8 = com.appsflyer.internal.AFf1hSDK.afRDLog
            if (r8 != 0) goto L_0x00fc
            com.appsflyer.internal.AFf1fSDK r8 = r6.AFInAppEventType
            java.lang.String r10 = com.appsflyer.internal.AFf1hSDK.values
            java.lang.String r8 = r8.AFKeystoreWrapper(r10)
            goto L_0x00fc
        L_0x00bb:
            java.lang.String r8 = com.appsflyer.internal.AFf1hSDK.getLevel
            if (r8 != 0) goto L_0x00fc
            com.appsflyer.internal.AFf1fSDK r8 = r6.AFInAppEventType
            java.lang.String r10 = com.appsflyer.internal.AFf1hSDK.AFLogger
            java.lang.String r8 = r8.AFKeystoreWrapper(r10)
            int r10 = onValidateInAppFailure
            int r10 = r10 + 105
            int r10 = r10 % 128
            AppsFlyerConversionListener = r10
            goto L_0x00fc
        L_0x00d0:
            java.lang.String r8 = com.appsflyer.internal.AFf1hSDK.AFVersionDeclaration
            if (r8 != 0) goto L_0x00fc
            int r8 = AppsFlyerConversionListener
            int r8 = r8 + 57
            int r10 = r8 % 128
            onValidateInAppFailure = r10
            int r8 = r8 % r5
            if (r8 == 0) goto L_0x00e8
            com.appsflyer.internal.AFf1fSDK r8 = r6.AFInAppEventType
            java.lang.String r10 = com.appsflyer.internal.AFf1hSDK.afErrorLog
            java.lang.String r8 = r8.AFKeystoreWrapper(r10)
            goto L_0x00fc
        L_0x00e8:
            com.appsflyer.internal.AFf1fSDK r13 = r6.AFInAppEventType
            java.lang.String r0 = com.appsflyer.internal.AFf1hSDK.afErrorLog
            r13.AFKeystoreWrapper(r0)
            throw r4
        L_0x00f0:
            java.lang.String r8 = com.appsflyer.internal.AFf1hSDK.afDebugLog
            if (r8 != 0) goto L_0x00fc
            com.appsflyer.internal.AFf1fSDK r8 = r6.AFInAppEventType
            java.lang.String r10 = com.appsflyer.internal.AFf1hSDK.AFKeystoreWrapper
            java.lang.String r8 = r8.AFKeystoreWrapper(r10)
        L_0x00fc:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r8)
            com.appsflyer.internal.AFc1vSDK r8 = r6.AFInAppEventParameterName
            com.appsflyer.internal.AFc1zSDK r8 = r8.values()
            com.appsflyer.internal.AFc1sSDK r8 = r8.AFKeystoreWrapper
            android.content.Context r8 = r8.AFKeystoreWrapper
            java.lang.String r8 = r8.getPackageName()
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            java.lang.String r8 = com.appsflyer.internal.AFf1hSDK.AFInAppEventType(r8, r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r8)
            com.appsflyer.internal.AFc1vSDK r6 = r6.AFInAppEventParameterName
            com.appsflyer.internal.AFc1zSDK r6 = r6.values()
            java.lang.String r6 = r6.AFInAppEventType()
            if (r6 == 0) goto L_0x0138
            java.lang.String r8 = "&channel="
            java.lang.String r6 = r8.concat(r6)
            goto L_0x0139
        L_0x0138:
            r6 = r4
        L_0x0139:
            if (r6 != 0) goto L_0x0148
            int r6 = AppsFlyerConversionListener
            int r6 = r6 + 81
            int r8 = r6 % 128
            onValidateInAppFailure = r8
            int r6 = r6 % r5
            if (r6 == 0) goto L_0x0147
            goto L_0x0149
        L_0x0147:
            throw r4
        L_0x0148:
            r7 = r6
        L_0x0149:
            r9.append(r7)
            java.lang.String r6 = r9.toString()
            r12.AFInAppEventType((java.util.Map<java.lang.String, java.lang.Object>) r2)
            com.appsflyer.internal.AFb1xSDK$AFa1ySDK r7 = new com.appsflyer.internal.AFb1xSDK$AFa1ySDK
            com.appsflyer.internal.AFa1sSDK r13 = r13.AFKeystoreWrapper((java.lang.String) r6)
            com.appsflyer.internal.AFa1sSDK r13 = r13.AFKeystoreWrapper((java.util.Map<java.lang.String, ?>) r2)
            com.appsflyer.internal.AFa1sSDK r13 = r13.AFInAppEventParameterName(r1)
            r7.<init>(r12, r13, r3)
            r13 = 1
            if (r0 == 0) goto L_0x01d5
            com.appsflyer.internal.AFf1kSDK[] r0 = r12.afErrorLogForExcManagerOnly()
            int r1 = r0.length
            r2 = r3
            r6 = r2
        L_0x016e:
            if (r2 >= r1) goto L_0x0194
            r8 = r0[r2]
            com.appsflyer.internal.AFf1kSDK$AFa1wSDK r9 = r8.afRDLog
            com.appsflyer.internal.AFf1kSDK$AFa1wSDK r10 = com.appsflyer.internal.AFf1kSDK.AFa1wSDK.STARTED
            if (r9 != r10) goto L_0x0191
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r9 = "Failed to get "
            r6.<init>(r9)
            java.lang.String r8 = r8.valueOf
            r6.append(r8)
            java.lang.String r8 = " referrer, wait ..."
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            com.appsflyer.AFLogger.afDebugLog(r6)
            r6 = r13
        L_0x0191:
            int r2 = r2 + 1
            goto L_0x016e
        L_0x0194:
            boolean r0 = r12.onDeepLinkingNative
            if (r0 == 0) goto L_0x01c5
            int r0 = onValidateInAppFailure
            int r0 = r0 + 123
            int r1 = r0 % 128
            AppsFlyerConversionListener = r1
            int r0 = r0 % r5
            if (r0 != 0) goto L_0x01c1
            boolean r0 = r12.AFLogger$LogLevel()
            r0 = r0 ^ r13
            if (r0 == r13) goto L_0x01ab
            goto L_0x01c5
        L_0x01ab:
            int r0 = AppsFlyerConversionListener
            int r0 = r0 + 63
            int r1 = r0 % 128
            onValidateInAppFailure = r1
            int r0 = r0 % r5
            java.lang.String r1 = "fetching Facebook deferred AppLink data, wait ..."
            if (r0 != 0) goto L_0x01bc
            com.appsflyer.AFLogger.afDebugLog(r1)
            goto L_0x01c6
        L_0x01bc:
            com.appsflyer.AFLogger.afDebugLog(r1)
            r3 = r13
            goto L_0x01c6
        L_0x01c1:
            r12.AFLogger$LogLevel()
            throw r4
        L_0x01c5:
            r3 = r6
        L_0x01c6:
            com.appsflyer.internal.AFc1vSDK r0 = r12.AFKeystoreWrapper()
            com.appsflyer.internal.AFe1nSDK r0 = r0.getLevel()
            boolean r0 = r0.AFKeystoreWrapper()
            if (r0 == 0) goto L_0x01d5
            r3 = r13
        L_0x01d5:
            com.appsflyer.internal.AFc1vSDK r0 = r12.AFKeystoreWrapper()
            java.util.concurrent.ScheduledExecutorService r0 = r0.AFInAppEventParameterName()
            if (r3 == r13) goto L_0x01e2
            r1 = 0
            goto L_0x01e4
        L_0x01e2:
            r1 = 500(0x1f4, double:2.47E-321)
        L_0x01e4:
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.MILLISECONDS
            values(r0, r7, r1, r13)
            return
        L_0x01ea:
            java.lang.String r0 = "Not sending data yet, waiting for dev key"
            com.appsflyer.AFLogger.afDebugLog(r0)
            com.appsflyer.attribution.AppsFlyerRequestListener r13 = r13.values
            if (r13 == 0) goto L_0x020e
            int r0 = AppsFlyerConversionListener
            int r0 = r0 + 109
            int r1 = r0 % 128
            onValidateInAppFailure = r1
            int r0 = r0 % r5
            if (r0 == 0) goto L_0x0206
            int r0 = com.appsflyer.attribution.RequestError.NO_DEV_KEY
            java.lang.String r1 = com.appsflyer.internal.AFb1aSDK.valueOf
            r13.onError(r0, r1)
            goto L_0x020e
        L_0x0206:
            int r0 = com.appsflyer.attribution.RequestError.NO_DEV_KEY
            java.lang.String r1 = com.appsflyer.internal.AFb1aSDK.valueOf
            r13.onError(r0, r1)
            throw r4
        L_0x020e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.valueOf(com.appsflyer.internal.AFa1sSDK):void");
    }

    private static void AFInAppEventParameterName(AppsFlyerConversionListener appsFlyerConversionListener) {
        int i10 = onValidateInAppFailure + 113;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            throw null;
        } else if (appsFlyerConversionListener != null) {
            AFInAppEventType = appsFlyerConversionListener;
            int i11 = AppsFlyerConversionListener + 39;
            onValidateInAppFailure = i11 % 128;
            if (i11 % 2 == 0) {
                int i12 = 48 / 0;
            }
        }
    }

    private void AFInAppEventParameterName(Context context, Map<String, Object> map) {
        int i10 = onValidateInAppFailure + 5;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 == 0) {
            AFb1bSDK.AFa1ySDK AFInAppEventType2 = AFKeystoreWrapper().onAppOpenAttributionNative().AFInAppEventType(context);
            map.put("btl", Float.toString(AFInAppEventType2.AFKeystoreWrapper));
            String str = AFInAppEventType2.values;
            if (str != null) {
                map.put("btch", str);
                onValidateInAppFailure = (AppsFlyerConversionListener + 65) % 128;
                return;
            }
            return;
        }
        map.put("btl", Float.toString(AFKeystoreWrapper().onAppOpenAttributionNative().AFInAppEventType(context).AFKeystoreWrapper));
        throw null;
    }

    private static void values(Map<String, Object> map) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
        String string2 = AppsFlyerProperties.getInstance().getString("onelinkVersion");
        if (string != null) {
            int i10 = AppsFlyerConversionListener + 93;
            onValidateInAppFailure = i10 % 128;
            if (i10 % 2 != 0) {
                map.put("onelink_id", string);
            } else {
                map.put("onelink_id", string);
                throw null;
            }
        }
        if (string2 != null) {
            int i11 = AppsFlyerConversionListener + 93;
            onValidateInAppFailure = i11 % 128;
            if (i11 % 2 != 0) {
                map.put("onelink_ver", string2);
            } else {
                map.put("onelink_ver", string2);
                throw null;
            }
        }
    }

    private int AFInAppEventType(SharedPreferences sharedPreferences) {
        int i10 = onValidateInAppFailure + 53;
        AppsFlyerConversionListener = i10 % 128;
        return AFInAppEventType(sharedPreferences, "appsFlyerAdRevenueCount", i10 % 2 == 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        if ((!r9.matches("fb\\d*?://authorize.*")) == false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        r0 = AppsFlyerConversionListener + 11;
        onValidateInAppFailure = r0 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        if ((r0 % 2) != 0) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        r3 = 76 / 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        if (r9.contains("access_token") == false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        if ((!r9.contains("access_token")) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        r0 = AFInAppEventParameterName(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0057, code lost:
        if (r0.length() != 0) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
        r3 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0065, code lost:
        if (r0.contains("&") == false) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0067, code lost:
        r3 = new java.util.ArrayList(java.util.Arrays.asList(r0.split("&")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0075, code lost:
        r3.add(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0078, code lost:
        r5 = new java.lang.StringBuilder();
        r3 = r3.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0085, code lost:
        if (r3.hasNext() == false) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0087, code lost:
        r6 = AppsFlyerConversionListener + 31;
        onValidateInAppFailure = r6 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0091, code lost:
        if ((r6 % 2) == 0) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0093, code lost:
        r6 = (java.lang.String) r3.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009d, code lost:
        if (r6.contains("access_token") == false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009f, code lost:
        r3.remove();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a7, code lost:
        if (r5.length() == 0) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a9, code lost:
        onValidateInAppFailure = (AppsFlyerConversionListener + 35) % 128;
        r5.append("&");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bb, code lost:
        if (r6.startsWith("?") != false) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bd, code lost:
        r5.append("?");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c0, code lost:
        r5.append(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        if (r9 == null) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c4, code lost:
        ((java.lang.String) r3.next()).contains("access_token");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00cd, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d6, code lost:
        return r9.replace(r0, r5.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        if (r9 == null) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String AFKeystoreWrapper(@androidx.annotation.Nullable java.lang.String r9) {
        /*
            int r0 = onValidateInAppFailure
            int r1 = r0 + 29
            int r2 = r1 % 128
            AppsFlyerConversionListener = r2
            int r1 = r1 % 2
            r2 = 0
            if (r1 == 0) goto L_0x0014
            r1 = 42
            int r1 = r1 / 0
            if (r9 != 0) goto L_0x0022
            goto L_0x0016
        L_0x0014:
            if (r9 != 0) goto L_0x0022
        L_0x0016:
            int r0 = r0 + 63
            int r9 = r0 % 128
            AppsFlyerConversionListener = r9
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0021
            return r2
        L_0x0021:
            throw r2
        L_0x0022:
            java.lang.String r0 = "fb\\d*?://authorize.*"
            boolean r0 = r9.matches(r0)
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x002d
            goto L_0x004e
        L_0x002d:
            int r0 = AppsFlyerConversionListener
            int r0 = r0 + 11
            int r1 = r0 % 128
            onValidateInAppFailure = r1
            int r0 = r0 % 2
            java.lang.String r1 = "access_token"
            if (r0 != 0) goto L_0x0046
            boolean r0 = r9.contains(r1)
            r3 = 76
            int r3 = r3 / 0
            if (r0 == 0) goto L_0x004e
            goto L_0x004f
        L_0x0046:
            boolean r0 = r9.contains(r1)
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x004f
        L_0x004e:
            return r9
        L_0x004f:
            java.lang.String r0 = AFInAppEventParameterName((java.lang.String) r9)
            int r3 = r0.length()
            if (r3 != 0) goto L_0x005a
            return r9
        L_0x005a:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r4 = "&"
            boolean r5 = r0.contains(r4)
            if (r5 == 0) goto L_0x0075
            java.util.ArrayList r3 = new java.util.ArrayList
            java.lang.String[] r5 = r0.split(r4)
            java.util.List r5 = java.util.Arrays.asList(r5)
            r3.<init>(r5)
            goto L_0x0078
        L_0x0075:
            r3.add(r0)
        L_0x0078:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x0081:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x00ce
            int r6 = AppsFlyerConversionListener
            int r6 = r6 + 31
            int r7 = r6 % 128
            onValidateInAppFailure = r7
            int r6 = r6 % 2
            if (r6 == 0) goto L_0x00c4
            java.lang.Object r6 = r3.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean r7 = r6.contains(r1)
            if (r7 == 0) goto L_0x00a3
            r3.remove()
            goto L_0x0081
        L_0x00a3:
            int r7 = r5.length()
            if (r7 == 0) goto L_0x00b5
            int r7 = AppsFlyerConversionListener
            int r7 = r7 + 35
            int r7 = r7 % 128
            onValidateInAppFailure = r7
            r5.append(r4)
            goto L_0x00c0
        L_0x00b5:
            java.lang.String r7 = "?"
            boolean r8 = r6.startsWith(r7)
            if (r8 != 0) goto L_0x00c0
            r5.append(r7)
        L_0x00c0:
            r5.append(r6)
            goto L_0x0081
        L_0x00c4:
            java.lang.Object r9 = r3.next()
            java.lang.String r9 = (java.lang.String) r9
            r9.contains(r1)
            throw r2
        L_0x00ce:
            java.lang.String r1 = r5.toString()
            java.lang.String r9 = r9.replace(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFKeystoreWrapper(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0052 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031 A[SYNTHETIC, Splitter:B:16:0x0031] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:25:0x0052=Splitter:B:25:0x0052, B:13:0x0028=Splitter:B:13:0x0028} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String AFInAppEventType(java.io.File r4, java.lang.String r5) {
        /*
            r0 = 0
            java.util.Properties r1 = new java.util.Properties     // Catch:{ FileNotFoundException -> 0x0051, all -> 0x0026 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x0051, all -> 0x0026 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0051, all -> 0x0026 }
            r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0051, all -> 0x0026 }
            r1.load(r2)     // Catch:{ FileNotFoundException -> 0x0052, all -> 0x0024 }
            java.lang.String r3 = "Found PreInstall property!"
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ FileNotFoundException -> 0x0052, all -> 0x0024 }
            java.lang.String r4 = r1.getProperty(r5)     // Catch:{ FileNotFoundException -> 0x0052, all -> 0x0024 }
            r2.close()     // Catch:{ all -> 0x001b }
            goto L_0x0023
        L_0x001b:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x0023:
            return r4
        L_0x0024:
            r4 = move-exception
            goto L_0x0028
        L_0x0026:
            r4 = move-exception
            r2 = r0
        L_0x0028:
            java.lang.String r5 = r4.getMessage()     // Catch:{ all -> 0x004f }
            com.appsflyer.AFLogger.afErrorLog(r5, r4)     // Catch:{ all -> 0x004f }
            if (r2 == 0) goto L_0x0046
            r2.close()     // Catch:{ all -> 0x003d }
            int r4 = AppsFlyerConversionListener
            int r4 = r4 + 13
            int r4 = r4 % 128
            onValidateInAppFailure = r4
            goto L_0x0046
        L_0x003d:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r5, r4)
            goto L_0x006c
        L_0x0046:
            int r4 = onValidateInAppFailure
            int r4 = r4 + 123
            int r4 = r4 % 128
            AppsFlyerConversionListener = r4
            goto L_0x006c
        L_0x004f:
            r4 = move-exception
            goto L_0x006d
        L_0x0051:
            r2 = r0
        L_0x0052:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            java.lang.String r1 = "PreInstall file wasn't found: "
            r5.<init>(r1)     // Catch:{ all -> 0x004f }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x004f }
            r5.append(r4)     // Catch:{ all -> 0x004f }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x004f }
            com.appsflyer.AFLogger.afDebugLog(r4)     // Catch:{ all -> 0x004f }
            if (r2 == 0) goto L_0x006c
            r2.close()     // Catch:{ all -> 0x003d }
        L_0x006c:
            return r0
        L_0x006d:
            if (r2 == 0) goto L_0x007b
            r2.close()     // Catch:{ all -> 0x0073 }
            goto L_0x007b
        L_0x0073:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x007b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFInAppEventType(java.io.File, java.lang.String):java.lang.String");
    }

    public final void values(Context context, Map<String, Object> map, Uri uri) {
        values(context);
        if (!map.containsKey("af_deeplink")) {
            AppsFlyerConversionListener = (onValidateInAppFailure + 41) % 128;
            String AFKeystoreWrapper2 = AFKeystoreWrapper(uri.toString());
            AFa1tSDK onInstallConversionDataLoadedNative2 = AFKeystoreWrapper().onInstallConversionDataLoadedNative();
            String str = onInstallConversionDataLoadedNative2.values;
            if (!(str == null || onInstallConversionDataLoadedNative2.AFInAppEventType == null || !AFKeystoreWrapper2.contains(str))) {
                int i10 = onValidateInAppFailure + 11;
                AppsFlyerConversionListener = i10 % 128;
                if (i10 % 2 == 0) {
                    Uri.Builder buildUpon = Uri.parse(AFKeystoreWrapper2).buildUpon();
                    Uri.Builder buildUpon2 = Uri.EMPTY.buildUpon();
                    for (Map.Entry next : onInstallConversionDataLoadedNative2.AFInAppEventType.entrySet()) {
                        buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                        buildUpon2.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                    }
                    AFKeystoreWrapper2 = buildUpon.build().toString();
                    map.put("appended_query_params", buildUpon2.build().getEncodedQuery());
                } else {
                    Uri.parse(AFKeystoreWrapper2).buildUpon();
                    Uri.EMPTY.buildUpon();
                    onInstallConversionDataLoadedNative2.AFInAppEventType.entrySet().iterator();
                    throw null;
                }
            }
            map.put("af_deeplink", AFKeystoreWrapper2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("link", uri.toString());
        AFd1cSDK aFd1cSDK = new AFd1cSDK(AFKeystoreWrapper(), UUID.randomUUID(), uri);
        if (aFd1cSDK.AFVersionDeclaration()) {
            map.put("isBrandedDomain", Boolean.TRUE);
        }
        AFa1cSDK.AFInAppEventParameterName(context, hashMap, uri);
        if (aFd1cSDK.afErrorLogForExcManagerOnly()) {
            aFd1cSDK.afRDLog = AFInAppEventParameterName((Map<String, String>) hashMap);
            AFd1sSDK afDebugLog2 = AFKeystoreWrapper().afDebugLog();
            afDebugLog2.AFInAppEventType.execute(new Runnable(aFd1cSDK) {
                private /* synthetic */ AFd1pSDK AFInAppEventType;

                /*  JADX ERROR: Method generation error
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
                /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFd1sSDK.3.run():void, class status: UNLOADED
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
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
            return;
        }
        AFb1nSDK.AFKeystoreWrapper(hashMap);
        AppsFlyerConversionListener = (onValidateInAppFailure + 107) % 128;
    }

    private static String AFInAppEventParameterName(Activity activity) {
        String str = null;
        if (activity != null) {
            onValidateInAppFailure = (AppsFlyerConversionListener + 119) % 128;
            Intent intent = activity.getIntent();
            if (intent != null) {
                int i10 = AppsFlyerConversionListener + 69;
                onValidateInAppFailure = i10 % 128;
                if (i10 % 2 != 0) {
                    try {
                        Bundle extras = intent.getExtras();
                        if (!(extras == null || (str = extras.getString("af")) == null)) {
                            AFLogger.afInfoLog("Push Notification received af payload = ".concat(str));
                            extras.remove("af");
                            activity.setIntent(intent.putExtras(extras));
                        }
                    } catch (Throwable th) {
                        AFLogger.afErrorLog(th.getMessage(), th);
                    }
                } else {
                    intent.getExtras();
                    throw null;
                }
            }
        }
        return str;
    }

    public static String AFInAppEventType(AFc1ySDK aFc1ySDK, String str) {
        AppsFlyerConversionListener = (onValidateInAppFailure + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) % 128;
        String values2 = aFc1ySDK.values("CACHED_CHANNEL", (String) null);
        if (values2 != null) {
            onValidateInAppFailure = (AppsFlyerConversionListener + 9) % 128;
            return values2;
        }
        aFc1ySDK.valueOf("CACHED_CHANNEL", str);
        return str;
    }

    private static String AFInAppEventParameterName(String str) {
        onValidateInAppFailure = (AppsFlyerConversionListener + 9) % 128;
        int indexOf = str.indexOf(63);
        if (indexOf == -1) {
            return "";
        }
        String substring = str.substring(indexOf);
        int i10 = AppsFlyerConversionListener + 41;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 != 0) {
            return substring;
        }
        throw null;
    }

    public final AFc1ySDK AFInAppEventType(Context context) {
        int i10 = onValidateInAppFailure + 75;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            values(context);
            int i11 = 92 / 0;
            return AFKeystoreWrapper().afInfoLog();
        }
        values(context);
        return AFKeystoreWrapper().afInfoLog();
    }

    private AFd1cSDK.AFa1vSDK AFInAppEventParameterName(final Map<String, String> map) {
        AnonymousClass5 r02 = new AFd1cSDK.AFa1vSDK() {
            public final void valueOf(Map<String, String> map) {
                for (String next : map.keySet()) {
                    map.put(next, map.get(next));
                }
                AFb1nSDK.AFKeystoreWrapper(map);
            }

            public final void valueOf(String str) {
                AFb1nSDK.AFInAppEventType(str, DeepLinkResult.Error.NETWORK);
            }
        };
        int i10 = AppsFlyerConversionListener + 85;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            int i11 = 66 / 0;
        }
        return r02;
    }

    private static void AFInAppEventParameterName(Context context, Map<String, Object> map, String str) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 111) % 128;
        SharedPreferences AFKeystoreWrapper2 = AFKeystoreWrapper(context);
        SharedPreferences.Editor edit = AFKeystoreWrapper2.edit();
        try {
            String string = AFKeystoreWrapper2.getString("prev_event_name", (String) null);
            if (string != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("prev_event_timestamp", AFKeystoreWrapper2.getLong("prev_event_timestamp", -1));
                jSONObject.put("prev_event_name", string);
                map.put("prev_event", jSONObject);
                AppsFlyerConversionListener = (onValidateInAppFailure + 75) % 128;
            }
            edit.putString("prev_event_name", str).putLong("prev_event_timestamp", System.currentTimeMillis()).apply();
        } catch (Exception e10) {
            AFLogger.afErrorLog("Error while processing previous event.", e10);
        }
    }

    private int AFInAppEventType(SharedPreferences sharedPreferences, String str, boolean z10) {
        int i10 = sharedPreferences.getInt(str, 0);
        if (!(!z10)) {
            i10++;
            sharedPreferences.edit().putInt(str, i10).apply();
        }
        if (AFKeystoreWrapper().afErrorLogForExcManagerOnly().afInfoLog()) {
            int i11 = onValidateInAppFailure + 93;
            AppsFlyerConversionListener = i11 % 128;
            if (i11 % 2 == 0) {
                AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFKeystoreWrapper(String.valueOf(i10));
            } else {
                AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFKeystoreWrapper(String.valueOf(i10));
                throw null;
            }
        }
        int i12 = onValidateInAppFailure + 49;
        AppsFlyerConversionListener = i12 % 128;
        if (i12 % 2 == 0) {
            return i10;
        }
        throw null;
    }

    public static synchronized SharedPreferences AFKeystoreWrapper(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (AFb1xSDK.class) {
            try {
                if (AFInAppEventType().onResponseNative == null) {
                    onValidateInAppFailure = (AppsFlyerConversionListener + 9) % 128;
                    AFInAppEventType().onResponseNative = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
                    AppsFlyerConversionListener = (onValidateInAppFailure + 117) % 128;
                }
                sharedPreferences = AFInAppEventType().onResponseNative;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sharedPreferences;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0092, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0093, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"HardwareIds"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void values(android.content.Context r9, java.util.Map<java.lang.String, java.lang.Object> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "use cached AndroidId: "
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "deviceTrackingDisabled"
            r3 = 0
            boolean r4 = r1.getBoolean(r2, r3)
            if (r4 == 0) goto L_0x0015
            java.lang.String r9 = "true"
            r10.put(r2, r9)
            return
        L_0x0015:
            com.appsflyer.internal.AFc1vSDK r2 = r8.AFKeystoreWrapper()
            com.appsflyer.internal.AFc1ySDK r2 = r2.afInfoLog()
            com.appsflyer.internal.AFc1vSDK r4 = r8.AFKeystoreWrapper()
            com.appsflyer.internal.AFe1nSDK r4 = r4.getLevel()
            java.lang.String r4 = r4.values(r2)
            boolean r5 = com.appsflyer.internal.AFb1mSDK.valueOf(r4)
            if (r5 != 0) goto L_0x0034
            java.lang.String r5 = "imei"
            r10.put(r5, r4)
        L_0x0034:
            java.lang.String r4 = "collectAndroidId"
            boolean r1 = r1.getBoolean(r4, r3)
            java.lang.String r3 = "androidIdCached"
            r4 = 0
            java.lang.String r5 = r2.values(r3, r4)
            java.lang.String r6 = "android_id"
            if (r1 == 0) goto L_0x00a6
            java.lang.String r1 = r8.afErrorLog
            boolean r1 = com.appsflyer.internal.AFb1mSDK.valueOf(r1)
            if (r1 == 0) goto L_0x00a6
            int r1 = AppsFlyerConversionListener
            int r1 = r1 + 37
            int r1 = r1 % 128
            onValidateInAppFailure = r1
            boolean r1 = AFLogger(r9)
            if (r1 == 0) goto L_0x00ab
            android.content.ContentResolver r1 = r9.getContentResolver()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r1 = android.provider.Settings.Secure.getString(r1, r6)     // Catch:{ Exception -> 0x0086 }
            if (r1 == 0) goto L_0x006f
            int r0 = AppsFlyerConversionListener
            int r0 = r0 + 107
            int r0 = r0 % 128
            onValidateInAppFailure = r0
            r4 = r1
            goto L_0x00ab
        L_0x006f:
            if (r5 == 0) goto L_0x00ab
            int r1 = AppsFlyerConversionListener
            int r1 = r1 + 79
            int r7 = r1 % 128
            onValidateInAppFailure = r7
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x0088
            java.lang.String r1 = r0.concat(r5)     // Catch:{ Exception -> 0x0086 }
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ Exception -> 0x0086 }
            r4 = r5
            goto L_0x00ab
        L_0x0086:
            r1 = move-exception
            goto L_0x0094
        L_0x0088:
            java.lang.String r1 = r0.concat(r5)     // Catch:{ Exception -> 0x0086 }
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ Exception -> 0x0086 }
            throw r4     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
        L_0x0090:
            r9 = move-exception
            throw r9
        L_0x0092:
            r1 = move-exception
            r4 = r5
        L_0x0094:
            if (r5 == 0) goto L_0x009e
            java.lang.String r0 = r0.concat(r5)
            com.appsflyer.AFLogger.afDebugLog(r0)
            r4 = r5
        L_0x009e:
            java.lang.String r0 = r1.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r1)
            goto L_0x00ab
        L_0x00a6:
            java.lang.String r0 = r8.afErrorLog
            if (r0 == 0) goto L_0x00ab
            r4 = r0
        L_0x00ab:
            if (r4 == 0) goto L_0x00bc
            int r0 = AppsFlyerConversionListener
            int r0 = r0 + 23
            int r0 = r0 % 128
            onValidateInAppFailure = r0
            r2.valueOf(r3, r4)
            r10.put(r6, r4)
            goto L_0x00c1
        L_0x00bc:
            java.lang.String r0 = "Android ID was not collected."
            com.appsflyer.AFLogger.afInfoLog(r0)
        L_0x00c1:
            com.appsflyer.internal.AFc1oSDK$AFa1xSDK r9 = com.appsflyer.internal.AFa1bSDK.valueOf(r9)
            if (r9 == 0) goto L_0x00f0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "isManual"
            java.lang.Boolean r2 = r9.AFInAppEventType
            r0.put(r1, r2)
            java.lang.String r1 = "val"
            java.lang.String r2 = r9.AFInAppEventParameterName
            r0.put(r1, r2)
            java.lang.Boolean r9 = r9.valueOf
            if (r9 == 0) goto L_0x00eb
            int r1 = onValidateInAppFailure
            int r1 = r1 + 55
            int r1 = r1 % 128
            AppsFlyerConversionListener = r1
            java.lang.String r1 = "isLat"
            r0.put(r1, r9)
        L_0x00eb:
            java.lang.String r9 = "oaid"
            r10.put(r9, r0)
        L_0x00f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.values(android.content.Context, java.util.Map):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v0, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v1, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v2, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v4, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v5, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v6, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v7, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v8, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v10, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v11, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v12, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v13, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v14, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v17, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v18, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v37, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v38, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v39, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v63, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v49, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v50, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v51, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v52, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v53, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v44, resolved type: com.appsflyer.internal.AFb1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v62, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v63, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v64, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v65, resolved type: android.app.Application} */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.util.Map<java.lang.String, java.lang.Object>, java.util.Map] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.util.Map<java.lang.String, java.lang.Object>] */
    /* JADX WARNING: type inference failed for: r1v6, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v14, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r2v21 */
    /* JADX WARNING: type inference failed for: r16v10 */
    /* JADX WARNING: type inference failed for: r10v12, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v24 */
    /* JADX WARNING: type inference failed for: r18v14 */
    /* JADX WARNING: type inference failed for: r2v33 */
    /* JADX WARNING: type inference failed for: r18v20 */
    /* JADX WARNING: type inference failed for: r18v21 */
    /* JADX WARNING: type inference failed for: r1v31 */
    /* JADX WARNING: type inference failed for: r1v35 */
    /* JADX WARNING: type inference failed for: r1v36 */
    /* JADX WARNING: type inference failed for: r1v37 */
    /* JADX WARNING: type inference failed for: r1v39 */
    /* JADX WARNING: type inference failed for: r1v42 */
    /* JADX WARNING: type inference failed for: r16v29 */
    /* JADX WARNING: type inference failed for: r16v32 */
    /* JADX WARNING: type inference failed for: r16v34 */
    /* JADX WARNING: type inference failed for: r16v36 */
    /* JADX WARNING: type inference failed for: r16v38 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02fb, code lost:
        if (r8.equals(r7) != false) goto L_0x02fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02ff, code lost:
        if (r7 != null) goto L_0x0301;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0301, code lost:
        r2.put("af_latestchannel", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0405, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:?, code lost:
        com.appsflyer.AFLogger.afErrorLog(r22, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x07a8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x07b6, code lost:
        r0 = e;
        r16 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:392:0x07d7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:393:0x07d8, code lost:
        r30 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:394:0x07db, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:395:0x07dc, code lost:
        r30 = r2;
        r16 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:406:0x0921, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:407:0x0922, code lost:
        r30 = r2;
        r18 = r4;
        r16 = r16;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0375  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x037b  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x038e A[Catch:{ NameNotFoundException -> 0x040a, all -> 0x0405, all -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x03a0 A[SYNTHETIC, Splitter:B:188:0x03a0] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x03b2 A[SYNTHETIC, Splitter:B:195:0x03b2] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x03db  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x03f6 A[SYNTHETIC, Splitter:B:210:0x03f6] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0405 A[ExcHandler: all (r0v40 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:210:0x03f6] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0424 A[Catch:{ NameNotFoundException -> 0x040a, all -> 0x0405, all -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0437 A[Catch:{ Exception -> 0x043d }] */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x04d9 A[Catch:{ all -> 0x04e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x05b7  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x05c0 A[Catch:{ NameNotFoundException -> 0x040a, all -> 0x0405, all -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x05f4 A[SYNTHETIC, Splitter:B:315:0x05f4] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x07a8 A[Catch:{ Exception -> 0x07b0, all -> 0x07a8 }, ExcHandler: all (th java.lang.Throwable), PHI: r30 
      PHI: (r30v8 android.app.Application) = (r30v15 android.app.Application), (r30v15 android.app.Application), (r30v15 android.app.Application), (r30v19 android.app.Application), (r30v19 android.app.Application) binds: [B:343:0x066b, B:348:0x067b, B:370:0x06da, B:373:0x06e2, B:378:0x074a] A[DONT_GENERATE, DONT_INLINE], Splitter:B:373:0x06e2] */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x07d7 A[Catch:{ Exception -> 0x07b0, all -> 0x07a8 }, ExcHandler: all (th java.lang.Throwable), PHI: r2 
      PHI: (r2v21 ?) = (r2v1 ?), (r2v24 ?), (r2v24 ?), (r2v24 ?), (r2v24 ?), (r2v24 ?), (r2v24 ?), (r2v24 ?), (r2v24 ?), (r2v24 ?), (r2v24 ?) binds: [B:318:0x0607, B:341:0x0668, B:342:?, B:343:0x066b, B:348:0x067b, B:349:?, B:363:0x06be, B:364:?, B:367:0x06c4, B:368:?, B:357:0x0691] A[DONT_GENERATE, DONT_INLINE], Splitter:B:318:0x0607] */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x099c A[Catch:{ all -> 0x096c }] */
    /* JADX WARNING: Removed duplicated region for block: B:435:0x09aa A[Catch:{ all -> 0x096c }] */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x09cb A[Catch:{ all -> 0x096c }] */
    /* JADX WARNING: Removed duplicated region for block: B:448:0x0a01 A[Catch:{ all -> 0x0a19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:449:0x0a03 A[Catch:{ all -> 0x0a19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:458:0x0a5e A[Catch:{ all -> 0x0a19 }] */
    /* JADX WARNING: Removed duplicated region for block: B:461:0x0b0d A[Catch:{ all -> 0x0a19 }] */
    /* JADX WARNING: Unknown variable types count: 5 */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.Object> AFInAppEventType(com.appsflyer.internal.AFa1sSDK r38) {
        /*
            r37 = this;
            r1 = r37
            r2 = r38
            java.lang.String r3 = "sVE"
            java.lang.String r4 = "sVS"
            java.lang.String r5 = "af_deeplink"
            java.lang.String r6 = "versionCode"
            java.lang.String r7 = "Exception while collecting facebook's attribution ID. "
            java.lang.String r8 = "appid"
            java.lang.String r9 = "sdkExtension"
            java.lang.String r10 = "extraReferrers"
            java.lang.String r11 = "yyyy-MM-dd_HHmmssZ"
            android.app.Application r12 = r2.AFInAppEventType
            com.appsflyer.internal.AFc1vSDK r13 = r37.AFKeystoreWrapper()
            com.appsflyer.internal.AFe1nSDK r13 = r13.getLevel()
            java.lang.String r13 = r13.values
            java.lang.String r14 = r2.afDebugLog
            org.json.JSONObject r15 = new org.json.JSONObject
            r16 = r3
            java.util.Map<java.lang.String, java.lang.Object> r3 = r2.AFInAppEventParameterName
            if (r3 != 0) goto L_0x0031
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
        L_0x0031:
            r15.<init>(r3)
            java.lang.String r3 = r15.toString()
            java.lang.String r15 = r2.AFLogger
            r17 = r4
            android.content.SharedPreferences r4 = AFKeystoreWrapper((android.content.Context) r12)
            r18 = r5
            boolean r5 = r38.AFInAppEventParameterName()
            r19 = r6
            java.lang.String r6 = r2.valueOf
            java.util.Map<java.lang.String, java.lang.Object> r2 = r2.AFKeystoreWrapper
            com.appsflyer.internal.AFa1bSDK.values((android.content.Context) r12, (java.util.Map<java.lang.String, java.lang.Object>) r2)
            java.lang.Boolean r20 = com.appsflyer.internal.AFa1bSDK.values
            if (r20 == 0) goto L_0x006b
            boolean r20 = r20.booleanValue()
            if (r20 != 0) goto L_0x006b
            r20 = r6
            java.util.Map r6 = AFKeystoreWrapper((java.util.Map<java.lang.String, java.lang.Object>) r2)
            r21 = r11
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            r22 = r7
            java.lang.String r7 = "ad_ids_disabled"
            r6.put(r7, r11)
            goto L_0x0071
        L_0x006b:
            r20 = r6
            r22 = r7
            r21 = r11
        L_0x0071:
            java.util.Date r6 = new java.util.Date
            r6.<init>()
            long r6 = r6.getTime()
            r11 = 0
            int r23 = android.view.View.getDefaultSize(r11, r11)
            int r11 = r23 + 12
            r23 = r8
            r8 = 1
            r24 = r3
            java.lang.Object[] r3 = new java.lang.Object[r8]
            java.lang.String r8 = "琦㝙㻯쟸쿦㍑垐ᵱᡧﻪ"
            values((java.lang.String) r8, (int) r11, (java.lang.Object[]) r3)
            r8 = 0
            r3 = r3[r8]
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = r3.intern()
            java.lang.String r8 = java.lang.Long.toString(r6)
            r2.put(r3, r8)
            java.lang.String r3 = com.appsflyer.internal.AFa1ySDK.AFInAppEventType(r12, r6)
            if (r3 == 0) goto L_0x00a8
            java.lang.String r6 = "cksm_v1"
            r2.put(r6, r3)
        L_0x00a8:
            boolean r3 = r37.isStopped()     // Catch:{ all -> 0x0b17 }
            if (r3 != 0) goto L_0x00cf
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            java.lang.String r6 = "******* sendTrackingWithEvent: "
            r3.<init>(r6)     // Catch:{ all -> 0x00ba }
            if (r5 == 0) goto L_0x00c3
            java.lang.String r6 = "Launch"
            goto L_0x00c4
        L_0x00ba:
            r0 = move-exception
            r3 = r0
            r36 = r2
            r2 = r1
            r1 = r36
            goto L_0x0b30
        L_0x00c3:
            r6 = r14
        L_0x00c4:
            r3.append(r6)     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00ba }
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ all -> 0x00ba }
            goto L_0x00d4
        L_0x00cf:
            java.lang.String r3 = "Reporting has been stopped"
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ all -> 0x0b17 }
        L_0x00d4:
            com.appsflyer.internal.AFc1vSDK r3 = r37.AFKeystoreWrapper()     // Catch:{ all -> 0x0b17 }
            com.appsflyer.internal.AFb1zSDK r3 = r3.afWarnLog()     // Catch:{ all -> 0x0b17 }
            r3.AFInAppEventType()     // Catch:{ all -> 0x0b17 }
            android.content.pm.PackageManager r3 = r12.getPackageManager()     // Catch:{ Exception -> 0x0101 }
            java.lang.String r6 = r12.getPackageName()     // Catch:{ Exception -> 0x0101 }
            r7 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r6, r7)     // Catch:{ Exception -> 0x0101 }
            java.lang.String[] r3 = r3.requestedPermissions     // Catch:{ Exception -> 0x0101 }
            java.util.List r3 = java.util.Arrays.asList(r3)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r6 = "android.permission.INTERNET"
            boolean r6 = r3.contains(r6)     // Catch:{ Exception -> 0x0101 }
            if (r6 != 0) goto L_0x0104
            java.lang.String r6 = "Permission android.permission.INTERNET is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r6)     // Catch:{ Exception -> 0x0101 }
            goto L_0x0104
        L_0x0101:
            r0 = move-exception
            r3 = r0
            goto L_0x0125
        L_0x0104:
            java.lang.String r6 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r6 = r3.contains(r6)     // Catch:{ Exception -> 0x0101 }
            if (r6 != 0) goto L_0x0111
            java.lang.String r6 = "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r6)     // Catch:{ Exception -> 0x0101 }
        L_0x0111:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0101 }
            r7 = 32
            if (r6 <= r7) goto L_0x012a
            java.lang.String r6 = "com.google.android.gms.permission.AD_ID"
            boolean r3 = r3.contains(r6)     // Catch:{ Exception -> 0x0101 }
            if (r3 != 0) goto L_0x012a
            java.lang.String r3 = "Permission com.google.android.gms.permission.AD_ID is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r3)     // Catch:{ Exception -> 0x0101 }
            goto L_0x012a
        L_0x0125:
            java.lang.String r6 = "Exception while validation permissions. "
            com.appsflyer.AFLogger.afErrorLog(r6, r3)     // Catch:{ all -> 0x0b17 }
        L_0x012a:
            java.lang.String r3 = "af_events_api"
            java.lang.String r6 = "福좩"
            r7 = 0
            int r8 = android.graphics.Color.alpha(r7)     // Catch:{ all -> 0x0b17 }
            r11 = 1
            int r8 = 1 - r8
            java.lang.Object[] r7 = new java.lang.Object[r11]     // Catch:{ all -> 0x0b17 }
            values((java.lang.String) r6, (int) r8, (java.lang.Object[]) r7)     // Catch:{ all -> 0x0b17 }
            r6 = 0
            r7 = r7[r6]     // Catch:{ all -> 0x0b17 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0b17 }
            java.lang.String r6 = r7.intern()     // Catch:{ all -> 0x0b17 }
            r2.put(r3, r6)     // Catch:{ all -> 0x0b17 }
            java.lang.String r3 = "뎅ꎕꉵ醇"
            long r6 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0b17 }
            r11 = r9
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            r7 = 4
            int r6 = r6 + r7
            r8 = 1
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x0b17 }
            values((java.lang.String) r3, (int) r6, (java.lang.Object[]) r9)     // Catch:{ all -> 0x0b17 }
            r3 = 0
            r6 = r9[r3]     // Catch:{ all -> 0x0b17 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0b17 }
            java.lang.String r3 = r6.intern()     // Catch:{ all -> 0x0b17 }
            java.lang.String r6 = android.os.Build.BRAND     // Catch:{ all -> 0x0b17 }
            r2.put(r3, r6)     // Catch:{ all -> 0x0b17 }
            java.lang.String r3 = "device"
            java.lang.String r6 = android.os.Build.DEVICE     // Catch:{ all -> 0x0b17 }
            r2.put(r3, r6)     // Catch:{ all -> 0x0b17 }
            java.lang.String r3 = "product"
            java.lang.String r6 = android.os.Build.PRODUCT     // Catch:{ all -> 0x0b17 }
            r2.put(r3, r6)     // Catch:{ all -> 0x0b17 }
            java.lang.String r3 = "sdk"
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0b17 }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0b17 }
            r2.put(r3, r6)     // Catch:{ all -> 0x0b17 }
            java.lang.String r3 = "model"
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ all -> 0x0b17 }
            r2.put(r3, r6)     // Catch:{ all -> 0x0b17 }
            java.lang.String r3 = "deviceType"
            java.lang.String r6 = android.os.Build.TYPE     // Catch:{ all -> 0x0b17 }
            r2.put(r3, r6)     // Catch:{ all -> 0x0b17 }
            AFKeystoreWrapper((android.content.Context) r12, (java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0b17 }
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b17 }
            com.appsflyer.internal.AFb1kSDK r6 = new com.appsflyer.internal.AFb1kSDK     // Catch:{ all -> 0x0b17 }
            r6.<init>(r12)     // Catch:{ all -> 0x0b17 }
            com.appsflyer.internal.AFc1vSDK r8 = r37.AFKeystoreWrapper()     // Catch:{ all -> 0x0b17 }
            com.appsflyer.internal.AFe1jSDK r8 = r8.AFLogger()     // Catch:{ all -> 0x0b17 }
            if (r5 == 0) goto L_0x028b
            boolean r26 = afErrorLog(r12)     // Catch:{ all -> 0x00ba }
            if (r26 == 0) goto L_0x01f0
            boolean r26 = r3.isOtherSdkStringDisabled()     // Catch:{ all -> 0x00ba }
            if (r26 != 0) goto L_0x01c8
            com.appsflyer.internal.AFc1vSDK r26 = r37.AFKeystoreWrapper()     // Catch:{ all -> 0x00ba }
            com.appsflyer.internal.AFb1bSDK r9 = r26.onAppOpenAttributionNative()     // Catch:{ all -> 0x00ba }
            com.appsflyer.internal.AFb1bSDK$AFa1ySDK r9 = r9.AFInAppEventType(r12)     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = "batteryLevel"
            float r9 = r9.AFKeystoreWrapper     // Catch:{ all -> 0x00ba }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00ba }
            r2.put(r7, r9)     // Catch:{ all -> 0x00ba }
        L_0x01c8:
            afDebugLog((android.content.Context) r12)     // Catch:{ all -> 0x00ba }
            java.lang.Class<android.app.UiModeManager> r7 = android.app.UiModeManager.class
            java.lang.Object r7 = r12.getSystemService(r7)     // Catch:{ all -> 0x00ba }
            android.app.UiModeManager r7 = (android.app.UiModeManager) r7     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x01e3
            int r7 = r7.getCurrentModeType()     // Catch:{ all -> 0x00ba }
            r9 = 4
            if (r7 != r9) goto L_0x01e3
            java.lang.String r7 = "tv"
            java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00ba }
            r2.put(r7, r9)     // Catch:{ all -> 0x00ba }
        L_0x01e3:
            boolean r7 = com.appsflyer.internal.AFe1iSDK.valueOf(r12)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x01f0
            java.lang.String r7 = "inst_app"
            java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00ba }
            r2.put(r7, r9)     // Catch:{ all -> 0x00ba }
        L_0x01f0:
            java.lang.String r7 = "timepassedsincelastlaunch"
            long r28 = r1.afWarnLog(r12)     // Catch:{ all -> 0x00ba }
            java.lang.String r9 = java.lang.Long.toString(r28)     // Catch:{ all -> 0x00ba }
            r2.put(r7, r9)     // Catch:{ all -> 0x00ba }
            values((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x00ba }
            AFInAppEventType((java.util.Map<java.lang.String, java.lang.Object>) r2, (com.appsflyer.internal.AFe1jSDK) r8)     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = r1.onAttributionFailureNative     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x020c
            java.lang.String r9 = "phone"
            r2.put(r9, r7)     // Catch:{ all -> 0x00ba }
        L_0x020c:
            boolean r7 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x00ba }
            java.lang.String r9 = "referrer"
            if (r7 != 0) goto L_0x0217
            r2.put(r9, r15)     // Catch:{ all -> 0x00ba }
        L_0x0217:
            r7 = 0
            java.lang.String r15 = r4.getString(r10, r7)     // Catch:{ all -> 0x00ba }
            if (r15 == 0) goto L_0x0221
            r2.put(r10, r15)     // Catch:{ all -> 0x00ba }
        L_0x0221:
            java.lang.String r7 = r3.getReferrer(r12)     // Catch:{ all -> 0x00ba }
            boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00ba }
            if (r10 != 0) goto L_0x0234
            java.lang.Object r10 = r2.get(r9)     // Catch:{ all -> 0x00ba }
            if (r10 != 0) goto L_0x0234
            r2.put(r9, r7)     // Catch:{ all -> 0x00ba }
        L_0x0234:
            long r7 = r8.afErrorLogForExcManagerOnly     // Catch:{ all -> 0x00ba }
            r9 = 0
            int r15 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r15 == 0) goto L_0x0245
            java.lang.String r9 = "prev_session_dur"
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x00ba }
            r2.put(r9, r7)     // Catch:{ all -> 0x00ba }
        L_0x0245:
            android.app.Application r7 = com.appsflyer.internal.AFb1cSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00ba }
            java.lang.String r8 = "exception_number"
            if (r7 != 0) goto L_0x024e
            r9 = -1
            goto L_0x0258
        L_0x024e:
            android.content.SharedPreferences r7 = AFKeystoreWrapper((android.content.Context) r7)     // Catch:{ all -> 0x00ba }
            r9 = 0
            long r9 = r7.getLong(r8, r9)     // Catch:{ all -> 0x00ba }
        L_0x0258:
            java.lang.Long r7 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x00ba }
            r2.put(r8, r7)     // Catch:{ all -> 0x00ba }
            com.appsflyer.internal.AFb1eSDK r7 = r1.onConversionDataSuccess     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x028e
            java.util.Map<java.lang.String, java.lang.Object> r8 = r7.valueOf     // Catch:{ all -> 0x00ba }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x00ba }
            java.lang.String r9 = "partner_data"
            if (r8 != 0) goto L_0x0272
            java.util.Map<java.lang.String, java.lang.Object> r8 = r7.valueOf     // Catch:{ all -> 0x00ba }
            r2.put(r9, r8)     // Catch:{ all -> 0x00ba }
        L_0x0272:
            java.util.Map<java.lang.String, java.lang.Object> r8 = r7.values     // Catch:{ all -> 0x00ba }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x00ba }
            if (r8 != 0) goto L_0x028e
            java.util.Map r8 = AFKeystoreWrapper((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x00ba }
            java.util.Map<java.lang.String, java.lang.Object> r10 = r7.values     // Catch:{ all -> 0x00ba }
            r8.put(r9, r10)     // Catch:{ all -> 0x00ba }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x00ba }
            r8.<init>()     // Catch:{ all -> 0x00ba }
            r7.values = r8     // Catch:{ all -> 0x00ba }
            goto L_0x028e
        L_0x028b:
            AFInAppEventParameterName(r12, r2, r14)     // Catch:{ all -> 0x0b17 }
        L_0x028e:
            java.lang.String r7 = "KSAppsFlyerId"
            java.lang.String r7 = AFInAppEventType((java.lang.String) r7)     // Catch:{ all -> 0x0b17 }
            java.lang.String r8 = "KSAppsFlyerRICounter"
            java.lang.String r8 = AFInAppEventType((java.lang.String) r8)     // Catch:{ all -> 0x0b17 }
            if (r7 == 0) goto L_0x02b2
            if (r8 == 0) goto L_0x02b2
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x00ba }
            int r9 = r9.intValue()     // Catch:{ all -> 0x00ba }
            if (r9 <= 0) goto L_0x02b2
            java.lang.String r9 = "reinstallCounter"
            r2.put(r9, r8)     // Catch:{ all -> 0x00ba }
            java.lang.String r8 = "originalAppsflyerId"
            r2.put(r8, r7)     // Catch:{ all -> 0x00ba }
        L_0x02b2:
            java.lang.String r7 = "additionalCustomData"
            java.lang.String r7 = AFInAppEventType((java.lang.String) r7)     // Catch:{ all -> 0x0b17 }
            if (r7 == 0) goto L_0x02bf
            java.lang.String r8 = "customData"
            r2.put(r8, r7)     // Catch:{ all -> 0x00ba }
        L_0x02bf:
            android.content.pm.PackageManager r7 = r12.getPackageManager()     // Catch:{ Exception -> 0x02d3 }
            java.lang.String r8 = r12.getPackageName()     // Catch:{ Exception -> 0x02d3 }
            java.lang.String r7 = r7.getInstallerPackageName(r8)     // Catch:{ Exception -> 0x02d3 }
            if (r7 == 0) goto L_0x02da
            java.lang.String r8 = "installer_package"
            r2.put(r8, r7)     // Catch:{ Exception -> 0x02d3 }
            goto L_0x02da
        L_0x02d3:
            r0 = move-exception
            r7 = r0
            java.lang.String r8 = "Exception while getting the app's installer package. "
            com.appsflyer.AFLogger.afErrorLog(r8, r7)     // Catch:{ all -> 0x0b17 }
        L_0x02da:
            java.lang.String r7 = r3.getString(r11)     // Catch:{ all -> 0x0b17 }
            if (r7 == 0) goto L_0x02e9
            int r8 = r7.length()     // Catch:{ all -> 0x00ba }
            if (r8 <= 0) goto L_0x02e9
            r2.put(r11, r7)     // Catch:{ all -> 0x00ba }
        L_0x02e9:
            java.lang.String r7 = r1.AFInAppEventParameterName((android.content.Context) r12)     // Catch:{ all -> 0x0b17 }
            com.appsflyer.internal.AFc1ySDK r8 = r1.AFInAppEventType((android.content.Context) r12)     // Catch:{ all -> 0x0b17 }
            java.lang.String r8 = AFInAppEventType((com.appsflyer.internal.AFc1ySDK) r8, (java.lang.String) r7)     // Catch:{ all -> 0x0b17 }
            if (r8 == 0) goto L_0x02fd
            boolean r9 = r8.equals(r7)     // Catch:{ all -> 0x00ba }
            if (r9 == 0) goto L_0x0301
        L_0x02fd:
            if (r8 != 0) goto L_0x0306
            if (r7 == 0) goto L_0x0306
        L_0x0301:
            java.lang.String r8 = "af_latestchannel"
            r2.put(r8, r7)     // Catch:{ all -> 0x00ba }
        L_0x0306:
            java.lang.String r7 = r1.AFVersionDeclaration(r12)     // Catch:{ all -> 0x0b17 }
            if (r7 == 0) goto L_0x0319
            java.lang.String r8 = "af_installstore"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = r7.toLowerCase(r9)     // Catch:{ all -> 0x00ba }
            r2.put(r8, r7)     // Catch:{ all -> 0x00ba }
        L_0x0319:
            java.lang.String r7 = r1.getLevel(r12)     // Catch:{ all -> 0x0b17 }
            if (r7 == 0) goto L_0x032c
            java.lang.String r8 = "af_preinstall_name"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = r7.toLowerCase(r9)     // Catch:{ all -> 0x00ba }
            r2.put(r8, r7)     // Catch:{ all -> 0x00ba }
        L_0x032c:
            java.lang.String r7 = r1.AFLogger$LogLevel(r12)     // Catch:{ all -> 0x0b17 }
            if (r7 == 0) goto L_0x033f
            java.lang.String r8 = "af_currentstore"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = r7.toLowerCase(r9)     // Catch:{ all -> 0x00ba }
            r2.put(r8, r7)     // Catch:{ all -> 0x00ba }
        L_0x033f:
            java.lang.String r7 = "appsflyerKey"
            if (r13 == 0) goto L_0x034d
            int r8 = r13.length()     // Catch:{ all -> 0x00ba }
            if (r8 <= 0) goto L_0x034d
            r2.put(r7, r13)     // Catch:{ all -> 0x00ba }
            goto L_0x0362
        L_0x034d:
            com.appsflyer.internal.AFc1vSDK r8 = r37.AFKeystoreWrapper()     // Catch:{ all -> 0x0b17 }
            com.appsflyer.internal.AFe1nSDK r8 = r8.getLevel()     // Catch:{ all -> 0x0b17 }
            java.lang.String r8 = r8.values     // Catch:{ all -> 0x0b17 }
            if (r8 == 0) goto L_0x0b1f
            int r9 = r8.length()     // Catch:{ all -> 0x0b17 }
            if (r9 <= 0) goto L_0x0b1f
            r2.put(r7, r8)     // Catch:{ all -> 0x0b17 }
        L_0x0362:
            java.lang.String r7 = values()     // Catch:{ all -> 0x0b17 }
            if (r7 == 0) goto L_0x036d
            java.lang.String r8 = "appUserId"
            r2.put(r8, r7)     // Catch:{ all -> 0x00ba }
        L_0x036d:
            java.lang.String r7 = "userEmails"
            java.lang.String r7 = r3.getString(r7)     // Catch:{ all -> 0x0b17 }
            if (r7 == 0) goto L_0x037b
            java.lang.String r8 = "user_emails"
            r2.put(r8, r7)     // Catch:{ all -> 0x00ba }
            goto L_0x038c
        L_0x037b:
            java.lang.String r7 = "userEmail"
            java.lang.String r7 = AFInAppEventType((java.lang.String) r7)     // Catch:{ all -> 0x0b17 }
            if (r7 == 0) goto L_0x038c
            java.lang.String r8 = "sha1_el"
            java.lang.String r7 = com.appsflyer.internal.AFb1ySDK.AFKeystoreWrapper((java.lang.String) r7)     // Catch:{ all -> 0x00ba }
            r2.put(r8, r7)     // Catch:{ all -> 0x00ba }
        L_0x038c:
            if (r14 == 0) goto L_0x039a
            java.lang.String r7 = "eventName"
            r2.put(r7, r14)     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = "eventValue"
            r8 = r24
            r2.put(r7, r8)     // Catch:{ all -> 0x00ba }
        L_0x039a:
            java.lang.String r7 = afErrorLog()     // Catch:{ all -> 0x0b17 }
            if (r7 == 0) goto L_0x03a9
            java.lang.String r7 = AFInAppEventType((java.lang.String) r23)     // Catch:{ all -> 0x00ba }
            r8 = r23
            r2.put(r8, r7)     // Catch:{ all -> 0x00ba }
        L_0x03a9:
            java.lang.String r7 = "currencyCode"
            java.lang.String r7 = AFInAppEventType((java.lang.String) r7)     // Catch:{ all -> 0x0b17 }
            r8 = 3
            if (r7 == 0) goto L_0x03d3
            int r9 = r7.length()     // Catch:{ all -> 0x00ba }
            if (r9 == r8) goto L_0x03ce
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            java.lang.String r10 = "WARNING: currency code should be 3 characters!!! '"
            r9.<init>(r10)     // Catch:{ all -> 0x00ba }
            r9.append(r7)     // Catch:{ all -> 0x00ba }
            java.lang.String r10 = "' is not a legal value."
            r9.append(r10)     // Catch:{ all -> 0x00ba }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00ba }
            com.appsflyer.AFLogger.afWarnLog(r9)     // Catch:{ all -> 0x00ba }
        L_0x03ce:
            java.lang.String r9 = "currency"
            r2.put(r9, r7)     // Catch:{ all -> 0x00ba }
        L_0x03d3:
            java.lang.String r7 = "IS_UPDATE"
            java.lang.String r7 = AFInAppEventType((java.lang.String) r7)     // Catch:{ all -> 0x0b17 }
            if (r7 == 0) goto L_0x03e0
            java.lang.String r9 = "isUpdate"
            r2.put(r9, r7)     // Catch:{ all -> 0x00ba }
        L_0x03e0:
            boolean r7 = r1.isPreInstalledApp(r12)     // Catch:{ all -> 0x0b17 }
            java.lang.String r9 = "af_preinstalled"
            java.lang.String r7 = java.lang.Boolean.toString(r7)     // Catch:{ all -> 0x0b17 }
            r2.put(r9, r7)     // Catch:{ all -> 0x0b17 }
            java.lang.String r7 = "collectFacebookAttrId"
            r9 = 1
            boolean r7 = r3.getBoolean(r7, r9)     // Catch:{ all -> 0x0b17 }
            if (r7 == 0) goto L_0x0429
            android.content.pm.PackageManager r7 = r12.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0414, all -> 0x0405 }
            java.lang.String r9 = "com.facebook.katana"
            r10 = 0
            r7.getApplicationInfo(r9, r10)     // Catch:{ NameNotFoundException -> 0x040a, all -> 0x0405 }
            java.lang.String r7 = r1.getAttributionId(r12)     // Catch:{ NameNotFoundException -> 0x040a, all -> 0x0405 }
            goto L_0x0422
        L_0x0405:
            r0 = move-exception
            r9 = r0
            r7 = r22
            goto L_0x040f
        L_0x040a:
            r0 = move-exception
            r9 = r0
            r7 = r22
            goto L_0x0418
        L_0x040f:
            com.appsflyer.AFLogger.afErrorLog(r7, r9)     // Catch:{ all -> 0x00ba }
        L_0x0412:
            r7 = 0
            goto L_0x0422
        L_0x0414:
            r0 = move-exception
            r7 = r22
            r9 = r0
        L_0x0418:
            java.lang.String r10 = "com.facebook.katana not found"
            r11 = 1
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r10, r9, r11)     // Catch:{ all -> 0x00ba }
            com.appsflyer.AFLogger.afWarnLog(r7)     // Catch:{ all -> 0x00ba }
            goto L_0x0412
        L_0x0422:
            if (r7 == 0) goto L_0x0429
            java.lang.String r9 = "fb"
            r2.put(r9, r7)     // Catch:{ all -> 0x00ba }
        L_0x0429:
            r1.values(r12, r2)     // Catch:{ all -> 0x0b17 }
            java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x043d }
            r7.<init>(r12)     // Catch:{ Exception -> 0x043d }
            java.lang.String r7 = com.appsflyer.internal.AFb1wSDK.AFKeystoreWrapper(r7)     // Catch:{ Exception -> 0x043d }
            if (r7 == 0) goto L_0x0454
            java.lang.String r9 = "uid"
            r2.put(r9, r7)     // Catch:{ Exception -> 0x043d }
            goto L_0x0454
        L_0x043d:
            r0 = move-exception
            r7 = r0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b17 }
            java.lang.String r10 = "ERROR: could not get uid "
            r9.<init>(r10)     // Catch:{ all -> 0x0b17 }
            java.lang.String r10 = r7.getMessage()     // Catch:{ all -> 0x0b17 }
            r9.append(r10)     // Catch:{ all -> 0x0b17 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0b17 }
            com.appsflyer.AFLogger.afErrorLog(r9, r7)     // Catch:{ all -> 0x0b17 }
        L_0x0454:
            java.lang.String r7 = "lang"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0462 }
            java.lang.String r9 = r9.getDisplayLanguage()     // Catch:{ Exception -> 0x0462 }
            r2.put(r7, r9)     // Catch:{ Exception -> 0x0462 }
            goto L_0x0469
        L_0x0462:
            r0 = move-exception
            r7 = r0
            java.lang.String r9 = "Exception while collecting display language name. "
            com.appsflyer.AFLogger.afErrorLog(r9, r7)     // Catch:{ all -> 0x0b17 }
        L_0x0469:
            java.lang.String r7 = "lang_code"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0477 }
            java.lang.String r9 = r9.getLanguage()     // Catch:{ Exception -> 0x0477 }
            r2.put(r7, r9)     // Catch:{ Exception -> 0x0477 }
            goto L_0x047e
        L_0x0477:
            r0 = move-exception
            r7 = r0
            java.lang.String r9 = "Exception while collecting display language code. "
            com.appsflyer.AFLogger.afErrorLog(r9, r7)     // Catch:{ all -> 0x0b17 }
        L_0x047e:
            java.lang.String r7 = "country"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x048c }
            java.lang.String r9 = r9.getCountry()     // Catch:{ Exception -> 0x048c }
            r2.put(r7, r9)     // Catch:{ Exception -> 0x048c }
            goto L_0x0493
        L_0x048c:
            r0 = move-exception
            r7 = r0
            java.lang.String r9 = "Exception while collecting country name. "
            com.appsflyer.AFLogger.afErrorLog(r9, r7)     // Catch:{ all -> 0x0b17 }
        L_0x0493:
            r1.AFKeystoreWrapper((java.util.Map<java.lang.String, java.lang.Object>) r2, (boolean) r5)     // Catch:{ all -> 0x0b17 }
            r1.AFInAppEventType((android.content.Context) r12, (java.util.Map<java.lang.String, ? super java.lang.String>) r2)     // Catch:{ all -> 0x0b17 }
            java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0b17 }
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ all -> 0x0b17 }
            r10 = r21
            r7.<init>(r10, r9)     // Catch:{ all -> 0x0b17 }
            android.content.pm.PackageManager r9 = r12.getPackageManager()     // Catch:{ Exception -> 0x04bb }
            java.lang.String r11 = r12.getPackageName()     // Catch:{ Exception -> 0x04bb }
            r13 = 0
            android.content.pm.PackageInfo r9 = r9.getPackageInfo(r11, r13)     // Catch:{ Exception -> 0x04bb }
            long r8 = r9.firstInstallTime     // Catch:{ Exception -> 0x04bb }
            java.lang.String r13 = "installDate"
            java.lang.String r8 = AFInAppEventType((java.text.SimpleDateFormat) r7, (long) r8)     // Catch:{ Exception -> 0x04bb }
            r2.put(r13, r8)     // Catch:{ Exception -> 0x04bb }
            goto L_0x04c2
        L_0x04bb:
            r0 = move-exception
            r8 = r0
            java.lang.String r9 = "Exception while collecting install date. "
            com.appsflyer.AFLogger.afErrorLog(r9, r8)     // Catch:{ all -> 0x0b17 }
        L_0x04c2:
            android.content.pm.PackageManager r8 = r12.getPackageManager()     // Catch:{ all -> 0x04e3 }
            java.lang.String r9 = r12.getPackageName()     // Catch:{ all -> 0x04e3 }
            r13 = 0
            android.content.pm.PackageInfo r8 = r8.getPackageInfo(r9, r13)     // Catch:{ all -> 0x04e3 }
            r9 = r19
            int r15 = r4.getInt(r9, r13)     // Catch:{ all -> 0x04e3 }
            int r13 = r8.versionCode     // Catch:{ all -> 0x04e3 }
            if (r13 <= r15) goto L_0x04ed
            com.appsflyer.internal.AFc1ySDK r13 = r1.AFInAppEventType((android.content.Context) r12)     // Catch:{ all -> 0x04e3 }
            int r15 = r8.versionCode     // Catch:{ all -> 0x04e3 }
            r13.AFKeystoreWrapper(r9, r15)     // Catch:{ all -> 0x04e3 }
            goto L_0x04ed
        L_0x04e3:
            r0 = move-exception
            r22 = r3
            r21 = r6
            r23 = r14
        L_0x04ea:
            r3 = r0
            goto L_0x0594
        L_0x04ed:
            com.appsflyer.internal.AFc1vSDK r9 = r37.AFKeystoreWrapper()     // Catch:{ all -> 0x04e3 }
            com.appsflyer.internal.AFc1zSDK r9 = r9.values()     // Catch:{ all -> 0x04e3 }
            java.lang.String r13 = "app_version_code"
            int r15 = r8.versionCode     // Catch:{ all -> 0x04e3 }
            java.lang.String r15 = java.lang.Integer.toString(r15)     // Catch:{ all -> 0x04e3 }
            r2.put(r13, r15)     // Catch:{ all -> 0x04e3 }
            java.lang.String r13 = "app_version_name"
            com.appsflyer.internal.AFc1sSDK r15 = r9.AFKeystoreWrapper     // Catch:{ all -> 0x04e3 }
            android.content.Context r15 = r15.AFKeystoreWrapper     // Catch:{ all -> 0x04e3 }
            java.lang.String r11 = r15.getPackageName()     // Catch:{ all -> 0x04e3 }
            java.lang.String r11 = com.appsflyer.internal.AFa1cSDK.values((android.content.Context) r15, (java.lang.String) r11)     // Catch:{ all -> 0x04e3 }
            r2.put(r13, r11)     // Catch:{ all -> 0x04e3 }
            java.lang.String r11 = "targetSDKver"
            com.appsflyer.internal.AFc1sSDK r9 = r9.AFKeystoreWrapper     // Catch:{ all -> 0x04e3 }
            android.content.Context r9 = r9.AFKeystoreWrapper     // Catch:{ all -> 0x04e3 }
            android.content.pm.ApplicationInfo r9 = r9.getApplicationInfo()     // Catch:{ all -> 0x04e3 }
            int r9 = r9.targetSdkVersion     // Catch:{ all -> 0x04e3 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x04e3 }
            r2.put(r11, r9)     // Catch:{ all -> 0x04e3 }
            r9 = r14
            long r13 = r8.firstInstallTime     // Catch:{ all -> 0x058b }
            r15 = r9
            long r8 = r8.lastUpdateTime     // Catch:{ all -> 0x0585 }
            java.lang.String r11 = "date1"
            r21 = r6
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0581 }
            r22 = r3
            java.util.Locale r3 = java.util.Locale.US     // Catch:{ all -> 0x057c }
            r6.<init>(r10, r3)     // Catch:{ all -> 0x057c }
            r23 = r15
            java.util.Date r15 = new java.util.Date     // Catch:{ all -> 0x0579 }
            r15.<init>(r13)     // Catch:{ all -> 0x0579 }
            java.lang.String r6 = r6.format(r15)     // Catch:{ all -> 0x0579 }
            r2.put(r11, r6)     // Catch:{ all -> 0x0579 }
            java.lang.String r6 = "date2"
            java.text.SimpleDateFormat r11 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0579 }
            r11.<init>(r10, r3)     // Catch:{ all -> 0x0579 }
            java.util.Date r3 = new java.util.Date     // Catch:{ all -> 0x0579 }
            r3.<init>(r8)     // Catch:{ all -> 0x0579 }
            java.lang.String r3 = r11.format(r3)     // Catch:{ all -> 0x0579 }
            r2.put(r6, r3)     // Catch:{ all -> 0x0579 }
            java.lang.String r3 = r1.AFInAppEventParameterName((java.text.SimpleDateFormat) r7, (android.content.Context) r12)     // Catch:{ all -> 0x0579 }
            java.lang.String r6 = "鱅稙钑馎靵撟ᩬ嬍敎鈍ߓ멮米注"
            java.lang.String r7 = ""
            r8 = 0
            int r7 = android.text.TextUtils.getCapsMode(r7, r8, r8)     // Catch:{ all -> 0x0579 }
            int r7 = r7 + 15
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x0579 }
            values((java.lang.String) r6, (int) r7, (java.lang.Object[]) r10)     // Catch:{ all -> 0x0579 }
            r6 = r10[r8]     // Catch:{ all -> 0x0579 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0579 }
            java.lang.String r6 = r6.intern()     // Catch:{ all -> 0x0579 }
            r2.put(r6, r3)     // Catch:{ all -> 0x0579 }
            goto L_0x059a
        L_0x0579:
            r0 = move-exception
            goto L_0x04ea
        L_0x057c:
            r0 = move-exception
        L_0x057d:
            r23 = r15
            goto L_0x04ea
        L_0x0581:
            r0 = move-exception
            r22 = r3
            goto L_0x057d
        L_0x0585:
            r0 = move-exception
            r22 = r3
            r21 = r6
            goto L_0x057d
        L_0x058b:
            r0 = move-exception
            r22 = r3
            r21 = r6
            r23 = r9
            goto L_0x04ea
        L_0x0594:
            java.lang.String r6 = "Exception while collecting app version data "
            r7 = 1
            com.appsflyer.AFLogger.afErrorLog(r6, r3, r7)     // Catch:{ all -> 0x0b17 }
        L_0x059a:
            boolean r3 = com.appsflyer.internal.AFe1lSDK.values(r12)     // Catch:{ all -> 0x0b17 }
            r1.onInstallConversionFailureNative = r3     // Catch:{ all -> 0x0b17 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b17 }
            java.lang.String r6 = "didConfigureTokenRefreshService="
            r3.<init>(r6)     // Catch:{ all -> 0x0b17 }
            boolean r6 = r1.onInstallConversionFailureNative     // Catch:{ all -> 0x0b17 }
            r3.append(r6)     // Catch:{ all -> 0x0b17 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0b17 }
            com.appsflyer.AFLogger.afDebugLog(r3)     // Catch:{ all -> 0x0b17 }
            boolean r3 = r1.onInstallConversionFailureNative     // Catch:{ all -> 0x0b17 }
            if (r3 != 0) goto L_0x05be
            java.lang.String r3 = "tokenRefreshConfigured"
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00ba }
            r2.put(r3, r6)     // Catch:{ all -> 0x00ba }
        L_0x05be:
            if (r5 == 0) goto L_0x05f2
            java.lang.String r3 = r1.afWarnLog     // Catch:{ all -> 0x00ba }
            if (r3 == 0) goto L_0x05d1
            r3 = r18
            java.lang.Object r6 = r2.get(r3)     // Catch:{ all -> 0x00ba }
            if (r6 == 0) goto L_0x05d3
            java.lang.String r3 = "Skip 'af' payload as deeplink was found by path"
            com.appsflyer.AFLogger.afDebugLog(r3)     // Catch:{ all -> 0x00ba }
        L_0x05d1:
            r3 = 0
            goto L_0x05e9
        L_0x05d3:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = r1.afWarnLog     // Catch:{ all -> 0x00ba }
            r6.<init>(r7)     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = "isPush"
            java.lang.String r8 = "true"
            r6.put(r7, r8)     // Catch:{ all -> 0x00ba }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00ba }
            r2.put(r3, r6)     // Catch:{ all -> 0x00ba }
            goto L_0x05d1
        L_0x05e9:
            r1.afWarnLog = r3     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = "open_referrer"
            r6 = r20
            r2.put(r3, r6)     // Catch:{ all -> 0x00ba }
        L_0x05f2:
            if (r5 != 0) goto L_0x099c
            com.appsflyer.internal.AFa1dSDK r3 = com.appsflyer.internal.AFa1dSDK.AFInAppEventType((android.content.Context) r12)     // Catch:{ all -> 0x097e }
            java.util.concurrent.ConcurrentHashMap r6 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x097e }
            r6.<init>()     // Catch:{ all -> 0x097e }
            java.util.List r3 = r3.AFKeystoreWrapper()     // Catch:{ all -> 0x097e }
            boolean r7 = r3.isEmpty()     // Catch:{ all -> 0x097e }
            if (r7 != 0) goto L_0x0958
            com.appsflyer.internal.AFa1uSDK r7 = new com.appsflyer.internal.AFa1uSDK     // Catch:{ Exception -> 0x093b, all -> 0x07d7 }
            r7.<init>()     // Catch:{ Exception -> 0x093b, all -> 0x07d7 }
            java.lang.String r7 = "n"
            java.lang.String r8 = "v"
            java.lang.String r9 = "er"
            java.lang.String r10 = "uk"
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x093b, all -> 0x07d7 }
            r13.<init>()     // Catch:{ Exception -> 0x093b, all -> 0x07d7 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x093b, all -> 0x07d7 }
        L_0x061d:
            boolean r11 = r3.hasNext()     // Catch:{ Exception -> 0x093b, all -> 0x07d7 }
            if (r11 == 0) goto L_0x0944
            java.lang.Object r11 = r3.next()     // Catch:{ Exception -> 0x093b, all -> 0x07d7 }
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Exception -> 0x093b, all -> 0x07d7 }
            java.util.HashMap r14 = new java.util.HashMap     // Catch:{ Exception -> 0x093b, all -> 0x07d7 }
            r14.<init>()     // Catch:{ Exception -> 0x093b, all -> 0x07d7 }
            r15 = r17
            java.lang.Object r17 = r11.get(r15)     // Catch:{ Exception -> 0x093b, all -> 0x07d7 }
            if (r17 == 0) goto L_0x063d
            r17 = r3
            r3 = r16
            r16 = 1
            goto L_0x0643
        L_0x063d:
            r17 = r3
            r3 = r16
            r16 = 0
        L_0x0643:
            java.lang.Object r18 = r11.get(r3)     // Catch:{ Exception -> 0x093b, all -> 0x07d7 }
            if (r18 == 0) goto L_0x064c
            r18 = 1
            goto L_0x064e
        L_0x064c:
            r18 = 0
        L_0x064e:
            if (r16 == 0) goto L_0x0663
            if (r18 == 0) goto L_0x0663
            com.appsflyer.internal.AFa1uSDK$AFa1ySDK r16 = com.appsflyer.internal.AFa1uSDK.AFa1ySDK.ALL     // Catch:{ Exception -> 0x0659 }
        L_0x0654:
            r1 = r16
            r16 = r5
            goto L_0x066b
        L_0x0659:
            r0 = move-exception
            r1 = r2
            r18 = r4
            r16 = r5
        L_0x065f:
            r10 = r12
        L_0x0660:
            r2 = r0
            goto L_0x0981
        L_0x0663:
            if (r16 == 0) goto L_0x0668
            com.appsflyer.internal.AFa1uSDK$AFa1ySDK r16 = com.appsflyer.internal.AFa1uSDK.AFa1ySDK.FIRST     // Catch:{ Exception -> 0x0659 }
            goto L_0x0654
        L_0x0668:
            com.appsflyer.internal.AFa1uSDK$AFa1ySDK r16 = com.appsflyer.internal.AFa1uSDK.AFa1ySDK.NONE     // Catch:{ Exception -> 0x093b, all -> 0x07d7 }
            goto L_0x0654
        L_0x066b:
            com.appsflyer.internal.AFa1uSDK$AFa1ySDK r5 = com.appsflyer.internal.AFa1uSDK.AFa1ySDK.NONE     // Catch:{ Exception -> 0x0921, all -> 0x07d7 }
            if (r1 == r5) goto L_0x0928
            java.lang.String r5 = "sT"
            java.lang.Object r5 = r11.get(r5)     // Catch:{ Exception -> 0x0921, all -> 0x07d7 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x0921, all -> 0x07d7 }
            r18 = r4
            java.lang.String r4 = "sN"
            java.lang.Object r4 = r11.get(r4)     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            if (r4 == 0) goto L_0x0691
            r14.put(r7, r4)     // Catch:{ Exception -> 0x068e, all -> 0x0687 }
            goto L_0x0694
        L_0x0687:
            r0 = move-exception
            r3 = r0
            r1 = r2
            r2 = r37
            goto L_0x0b30
        L_0x068e:
            r0 = move-exception
            r1 = r2
            goto L_0x065f
        L_0x0691:
            r14.put(r7, r10)     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
        L_0x0694:
            com.appsflyer.internal.AFa1uSDK$AFa1wSDK[] r4 = com.appsflyer.internal.AFa1uSDK.AFa1wSDK.values()     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            int r20 = r5.intValue()     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            r4 = r4[r20]     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            r20 = r7
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            java.lang.Object r24 = r11.get(r15)     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            r25 = r10
            java.util.List r10 = com.appsflyer.internal.AFa1uSDK.AFInAppEventType(r24)     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            r7.<init>(r10)     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            com.appsflyer.internal.AFa1uSDK$AFa1ySDK r10 = com.appsflyer.internal.AFa1uSDK.AFa1ySDK.ALL     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            if (r1 != r10) goto L_0x06be
            java.lang.Object r10 = r11.get(r3)     // Catch:{ Exception -> 0x068e, all -> 0x0687 }
            java.util.List r10 = com.appsflyer.internal.AFa1uSDK.AFInAppEventType(r10)     // Catch:{ Exception -> 0x068e, all -> 0x0687 }
            r7.addAll(r10)     // Catch:{ Exception -> 0x068e, all -> 0x0687 }
        L_0x06be:
            com.appsflyer.internal.AFa1uSDK$AFa1wSDK r10 = com.appsflyer.internal.AFa1uSDK.AFa1wSDK.MAGNETOMETER     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            java.lang.String r11 = "##.#"
            if (r4 != r10) goto L_0x07df
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            r4.<init>()     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            r10 = 0
            java.lang.Object r27 = r7.get(r10)     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            java.math.BigDecimal r27 = (java.math.BigDecimal) r27     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            r10 = 1
            java.lang.Object r28 = r7.get(r10)     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            java.math.BigDecimal r28 = (java.math.BigDecimal) r28     // Catch:{ Exception -> 0x07db, all -> 0x07d7 }
            r10 = r2
            r29 = r3
            double r2 = r27.doubleValue()     // Catch:{ Exception -> 0x07d3, all -> 0x07cf }
            r27 = r9
            r30 = r10
            double r9 = r28.doubleValue()     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            double r2 = java.lang.Math.atan2(r9, r2)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            r9 = 4633260481411531256(0x404ca5dc1a63c1f8, double:57.29577951308232)
            double r2 = r2 * r9
            java.math.BigDecimal r2 = java.math.BigDecimal.valueOf(r2)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            java.text.DecimalFormat r3 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            r3.<init>(r11)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            java.math.RoundingMode r9 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            r3.setRoundingMode(r9)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            java.lang.String r3 = r3.format(r2)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            double r31 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventType(r3)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            java.lang.Double r3 = java.lang.Double.valueOf(r31)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            r4.add(r3)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            r3 = 2
            java.lang.Object r10 = r7.get(r3)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            java.math.BigDecimal r10 = (java.math.BigDecimal) r10     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            java.text.DecimalFormat r3 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            r3.<init>(r11)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            r3.setRoundingMode(r9)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            java.lang.String r3 = r3.format(r10)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            double r31 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventType(r3)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            java.lang.Double r3 = java.lang.Double.valueOf(r31)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            r4.add(r3)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            r3.<init>()     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            int r10 = r7.size()     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            r28 = r15
            r15 = 5
            if (r10 <= r15) goto L_0x07b9
            r10 = 3
            java.lang.Object r19 = r7.get(r10)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            java.math.BigDecimal r19 = (java.math.BigDecimal) r19     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            r10 = 4
            java.lang.Object r31 = r7.get(r10)     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            java.math.BigDecimal r31 = (java.math.BigDecimal) r31     // Catch:{ Exception -> 0x07b6, all -> 0x07a8 }
            r10 = r12
            r32 = r13
            double r12 = r19.doubleValue()     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r33 = r5
            r19 = r6
            double r5 = r31.doubleValue()     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            double r5 = java.lang.Math.atan2(r5, r12)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r12 = 4633260481411531256(0x404ca5dc1a63c1f8, double:57.29577951308232)
            double r5 = r5 * r12
            java.math.BigDecimal r5 = java.math.BigDecimal.valueOf(r5)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.BigDecimal r2 = r5.subtract(r2)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.text.DecimalFormat r5 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r5.<init>(r11)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r5.setRoundingMode(r9)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.String r2 = r5.format(r2)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            double r5 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventType(r2)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.Double r2 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r3.add(r2)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.Object r2 = r7.get(r15)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.BigDecimal r2 = (java.math.BigDecimal) r2     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r5 = 2
            java.lang.Object r5 = r7.get(r5)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.BigDecimal r5 = (java.math.BigDecimal) r5     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.BigDecimal r2 = r2.subtract(r5)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.text.DecimalFormat r5 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r5.<init>(r11)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r5.setRoundingMode(r9)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.String r2 = r5.format(r2)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            double r5 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventType(r2)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.Double r2 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r3.add(r2)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            goto L_0x07c0
        L_0x07a8:
            r0 = move-exception
        L_0x07a9:
            r2 = r37
            r3 = r0
            r1 = r30
            goto L_0x0b30
        L_0x07b0:
            r0 = move-exception
        L_0x07b1:
            r2 = r0
            r1 = r30
            goto L_0x0981
        L_0x07b6:
            r0 = move-exception
        L_0x07b7:
            r10 = r12
            goto L_0x07b1
        L_0x07b9:
            r33 = r5
            r19 = r6
            r10 = r12
            r32 = r13
        L_0x07c0:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r2.<init>()     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r2.add(r4)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r2.add(r3)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r3 = 3
            r4 = 4
            goto L_0x08e6
        L_0x07cf:
            r0 = move-exception
            r30 = r10
            goto L_0x07a9
        L_0x07d3:
            r0 = move-exception
            r30 = r10
            goto L_0x07b7
        L_0x07d7:
            r0 = move-exception
            r30 = r2
            goto L_0x07a9
        L_0x07db:
            r0 = move-exception
            r30 = r2
            goto L_0x07b7
        L_0x07df:
            r30 = r2
            r29 = r3
            r33 = r5
            r19 = r6
            r27 = r9
            r10 = r12
            r32 = r13
            r28 = r15
            r15 = 5
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r2.<init>()     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            int r3 = r7.size()     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            if (r3 <= r15) goto L_0x0877
            r3 = 3
            java.lang.Object r4 = r7.get(r3)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.BigDecimal r4 = (java.math.BigDecimal) r4     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r5 = 0
            java.lang.Object r6 = r7.get(r5)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.BigDecimal r6 = (java.math.BigDecimal) r6     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.BigDecimal r4 = r4.subtract(r6)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.text.DecimalFormat r5 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r5.<init>(r11)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.RoundingMode r6 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r5.setRoundingMode(r6)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.String r4 = r5.format(r4)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            double r4 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventType(r4)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r2.add(r4)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r4 = 4
            java.lang.Object r5 = r7.get(r4)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.BigDecimal r5 = (java.math.BigDecimal) r5     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r9 = 1
            java.lang.Object r12 = r7.get(r9)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.BigDecimal r12 = (java.math.BigDecimal) r12     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.BigDecimal r5 = r5.subtract(r12)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.text.DecimalFormat r9 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r9.<init>(r11)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r9.setRoundingMode(r6)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.String r5 = r9.format(r5)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            double r12 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventType(r5)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.Double r5 = java.lang.Double.valueOf(r12)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r2.add(r5)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.Object r5 = r7.get(r15)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.BigDecimal r5 = (java.math.BigDecimal) r5     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r9 = 2
            java.lang.Object r12 = r7.get(r9)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.BigDecimal r12 = (java.math.BigDecimal) r12     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.BigDecimal r5 = r5.subtract(r12)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.text.DecimalFormat r9 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r9.<init>(r11)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r9.setRoundingMode(r6)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.String r5 = r9.format(r5)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            double r5 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventType(r5)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r2.add(r5)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            goto L_0x0879
        L_0x0877:
            r3 = 3
            r4 = 4
        L_0x0879:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r5.<init>()     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r6 = 0
            java.lang.Object r9 = r7.get(r6)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.BigDecimal r9 = (java.math.BigDecimal) r9     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.text.DecimalFormat r6 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r6.<init>(r11)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.RoundingMode r12 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r6.setRoundingMode(r12)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.String r6 = r6.format(r9)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            double r34 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventType(r6)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.Double r6 = java.lang.Double.valueOf(r34)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r5.add(r6)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r6 = 1
            java.lang.Object r9 = r7.get(r6)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.BigDecimal r9 = (java.math.BigDecimal) r9     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.text.DecimalFormat r6 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r6.<init>(r11)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r6.setRoundingMode(r12)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.String r6 = r6.format(r9)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            double r34 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventType(r6)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.Double r6 = java.lang.Double.valueOf(r34)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r5.add(r6)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r6 = 2
            java.lang.Object r6 = r7.get(r6)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.math.BigDecimal r6 = (java.math.BigDecimal) r6     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.text.DecimalFormat r7 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r7.<init>(r11)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r7.setRoundingMode(r12)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.String r6 = r7.format(r6)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            double r6 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventType(r6)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r5.add(r6)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r6.<init>()     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r6.add(r5)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r6.add(r2)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r2 = r6
        L_0x08e6:
            r14.put(r8, r2)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            com.appsflyer.internal.AFa1uSDK$AFa1xSDK[] r2 = com.appsflyer.internal.AFa1uSDK.AFa1xSDK.values()     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            int r5 = r33.intValue()     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r2 = r2[r5]     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.String r2 = r2.values     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r5 = r32
            r5.put(r2, r14)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            com.appsflyer.internal.AFa1uSDK$AFa1ySDK r2 = com.appsflyer.internal.AFa1uSDK.AFa1ySDK.FIRST     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            if (r1 != r2) goto L_0x0906
            java.lang.String r1 = "no_svs"
            r2 = r27
            r5.put(r2, r1)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            goto L_0x0908
        L_0x0906:
            r2 = r27
        L_0x0908:
            r1 = r37
            r9 = r2
            r13 = r5
            r12 = r10
            r5 = r16
            r3 = r17
            r4 = r18
            r6 = r19
            r7 = r20
            r10 = r25
            r17 = r28
            r16 = r29
            r2 = r30
            goto L_0x061d
        L_0x0921:
            r0 = move-exception
            r30 = r2
            r18 = r4
            goto L_0x07b7
        L_0x0928:
            r30 = r2
            r18 = r4
            r19 = r6
            r2 = r9
            r10 = r12
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            r13.<init>()     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            java.lang.String r1 = "na"
            r13.put(r2, r1)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
            goto L_0x094e
        L_0x093b:
            r0 = move-exception
            r30 = r2
            r18 = r4
            r16 = r5
            goto L_0x07b7
        L_0x0944:
            r30 = r2
            r18 = r4
            r16 = r5
            r19 = r6
            r10 = r12
            r5 = r13
        L_0x094e:
            java.lang.String r1 = "sensors"
            r2 = r19
            r2.put(r1, r13)     // Catch:{ Exception -> 0x07b0, all -> 0x07a8 }
        L_0x0955:
            r1 = r30
            goto L_0x0968
        L_0x0958:
            r30 = r2
            r18 = r4
            r16 = r5
            r2 = r6
            r10 = r12
            java.lang.String r1 = "sensors"
            java.lang.String r3 = "na"
            r2.put(r1, r3)     // Catch:{ Exception -> 0x0979, all -> 0x0975 }
            goto L_0x0955
        L_0x0968:
            r1.putAll(r2)     // Catch:{ Exception -> 0x0972 }
            goto L_0x09a2
        L_0x096c:
            r0 = move-exception
        L_0x096d:
            r2 = r37
        L_0x096f:
            r3 = r0
            goto L_0x0b30
        L_0x0972:
            r0 = move-exception
            goto L_0x0660
        L_0x0975:
            r0 = move-exception
            r1 = r30
            goto L_0x096d
        L_0x0979:
            r0 = move-exception
            r1 = r30
            goto L_0x0660
        L_0x097e:
            r0 = move-exception
            r1 = r2
            goto L_0x096d
        L_0x0981:
            java.lang.String r3 = "error while getting sensors data"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r3, r2)     // Catch:{ all -> 0x096c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x096c }
            java.lang.String r4 = "Unexpected exception from AFSensorManager: "
            r3.<init>(r4)     // Catch:{ all -> 0x096c }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x096c }
            r3.append(r2)     // Catch:{ all -> 0x096c }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x096c }
            com.appsflyer.AFLogger.afRDLog(r2)     // Catch:{ all -> 0x096c }
            goto L_0x09a2
        L_0x099c:
            r1 = r2
            r18 = r4
            r16 = r5
            r10 = r12
        L_0x09a2:
            java.lang.String r2 = "advertiserId"
            java.lang.String r2 = AFInAppEventType((java.lang.String) r2)     // Catch:{ all -> 0x096c }
            if (r2 != 0) goto L_0x09c1
            com.appsflyer.internal.AFa1bSDK.values((android.content.Context) r10, (java.util.Map<java.lang.String, java.lang.Object>) r1)     // Catch:{ all -> 0x096c }
            java.lang.String r2 = "GAID_retry"
            java.lang.String r3 = "advertiserId"
            java.lang.String r3 = AFInAppEventType((java.lang.String) r3)     // Catch:{ all -> 0x096c }
            if (r3 == 0) goto L_0x09b9
            r3 = 1
            goto L_0x09ba
        L_0x09b9:
            r3 = 0
        L_0x09ba:
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x096c }
            r1.put(r2, r3)     // Catch:{ all -> 0x096c }
        L_0x09c1:
            android.content.ContentResolver r2 = r10.getContentResolver()     // Catch:{ all -> 0x096c }
            com.appsflyer.internal.AFc1oSDK$AFa1xSDK r2 = com.appsflyer.internal.AFa1bSDK.values(r2)     // Catch:{ all -> 0x096c }
            if (r2 == 0) goto L_0x09dd
            java.lang.String r3 = "amazon_aid"
            java.lang.String r4 = r2.AFInAppEventParameterName     // Catch:{ all -> 0x096c }
            r1.put(r3, r4)     // Catch:{ all -> 0x096c }
            java.lang.String r3 = "amazon_aid_limit"
            java.lang.Boolean r2 = r2.valueOf     // Catch:{ all -> 0x096c }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x096c }
            r1.put(r3, r2)     // Catch:{ all -> 0x096c }
        L_0x09dd:
            boolean r2 = com.appsflyer.internal.AFe1lSDK.AFKeystoreWrapper((android.content.SharedPreferences) r18)     // Catch:{ all -> 0x096c }
            java.lang.String r3 = "registeredUninstall"
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x096c }
            r1.put(r3, r2)     // Catch:{ all -> 0x096c }
            r2 = r37
            r4 = r16
            r3 = r18
            int r5 = r2.valueOf((android.content.SharedPreferences) r3, (boolean) r4)     // Catch:{ all -> 0x0a19 }
            java.lang.String r6 = "counter"
            java.lang.String r7 = java.lang.Integer.toString(r5)     // Catch:{ all -> 0x0a19 }
            r1.put(r6, r7)     // Catch:{ all -> 0x0a19 }
            java.lang.String r6 = "iaecounter"
            if (r23 == 0) goto L_0x0a03
            r7 = 1
            goto L_0x0a04
        L_0x0a03:
            r7 = 0
        L_0x0a04:
            int r7 = r2.AFKeystoreWrapper((android.content.SharedPreferences) r3, (boolean) r7)     // Catch:{ all -> 0x0a19 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x0a19 }
            r1.put(r6, r7)     // Catch:{ all -> 0x0a19 }
            r6 = 1
            if (r4 == 0) goto L_0x0a1c
            if (r5 != r6) goto L_0x0a1c
            r7 = r22
            r7.values = r6     // Catch:{ all -> 0x0a19 }
            goto L_0x0a1c
        L_0x0a19:
            r0 = move-exception
            goto L_0x096f
        L_0x0a1c:
            java.lang.String r7 = "isFirstCall"
            boolean r8 = AFKeystoreWrapper((android.content.SharedPreferences) r3)     // Catch:{ all -> 0x0a19 }
            r8 = r8 ^ r6
            java.lang.String r6 = java.lang.Boolean.toString(r8)     // Catch:{ all -> 0x0a19 }
            r1.put(r7, r6)     // Catch:{ all -> 0x0a19 }
            r2.AFKeystoreWrapper(r10, r4, r1, r5)     // Catch:{ all -> 0x0a19 }
            com.appsflyer.internal.AFb1ySDK r4 = new com.appsflyer.internal.AFb1ySDK     // Catch:{ all -> 0x0a19 }
            r4.<init>()     // Catch:{ all -> 0x0a19 }
            java.lang.String r4 = com.appsflyer.internal.AFb1ySDK.values((java.util.Map<java.lang.String, java.lang.Object>) r1)     // Catch:{ all -> 0x0a19 }
            java.lang.String r5 = "af_v"
            r1.put(r5, r4)     // Catch:{ all -> 0x0a19 }
            com.appsflyer.internal.AFb1ySDK r4 = new com.appsflyer.internal.AFb1ySDK     // Catch:{ all -> 0x0a19 }
            r4.<init>()     // Catch:{ all -> 0x0a19 }
            java.lang.String r4 = com.appsflyer.internal.AFb1ySDK.AFInAppEventParameterName((java.util.Map<java.lang.String, java.lang.Object>) r1)     // Catch:{ all -> 0x0a19 }
            java.lang.String r5 = "af_v2"
            r1.put(r5, r4)     // Catch:{ all -> 0x0a19 }
            boolean r4 = onInstallConversionFailureNative(r10)     // Catch:{ all -> 0x0a19 }
            java.lang.String r5 = "ivc"
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0a19 }
            r1.put(r5, r4)     // Catch:{ all -> 0x0a19 }
            java.lang.String r4 = "is_stop_tracking_used"
            boolean r4 = r3.contains(r4)     // Catch:{ all -> 0x0a19 }
            if (r4 == 0) goto L_0x0a6e
            java.lang.String r4 = "istu"
            java.lang.String r5 = "is_stop_tracking_used"
            r6 = 0
            boolean r3 = r3.getBoolean(r5, r6)     // Catch:{ all -> 0x0a19 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0a19 }
            r1.put(r4, r3)     // Catch:{ all -> 0x0a19 }
        L_0x0a6e:
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0a19 }
            r3.<init>()     // Catch:{ all -> 0x0a19 }
            java.lang.String r4 = "mcc"
            android.content.res.Resources r5 = r10.getResources()     // Catch:{ all -> 0x0a19 }
            android.content.res.Configuration r5 = r5.getConfiguration()     // Catch:{ all -> 0x0a19 }
            int r5 = r5.mcc     // Catch:{ all -> 0x0a19 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0a19 }
            r3.put(r4, r5)     // Catch:{ all -> 0x0a19 }
            java.lang.String r4 = "mnc"
            android.content.res.Resources r5 = r10.getResources()     // Catch:{ all -> 0x0a19 }
            android.content.res.Configuration r5 = r5.getConfiguration()     // Catch:{ all -> 0x0a19 }
            int r5 = r5.mnc     // Catch:{ all -> 0x0a19 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0a19 }
            r3.put(r4, r5)     // Catch:{ all -> 0x0a19 }
            java.lang.String r4 = "cell"
            r1.put(r4, r3)     // Catch:{ all -> 0x0a19 }
            java.lang.String r3 = "sig"
            r4 = r21
            android.app.Application r5 = r4.AFInAppEventParameterName     // Catch:{ all -> 0x0a19 }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ all -> 0x0a19 }
            android.app.Application r4 = r4.AFInAppEventParameterName     // Catch:{ all -> 0x0a19 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x0a19 }
            java.lang.String r4 = com.appsflyer.internal.AFa1cSDK.valueOf(r5, r4)     // Catch:{ all -> 0x0a19 }
            r1.put(r3, r4)     // Catch:{ all -> 0x0a19 }
            java.lang.String r3 = "last_boot_time"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0a19 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0a19 }
            long r4 = r4 - r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0a19 }
            r1.put(r3, r4)     // Catch:{ all -> 0x0a19 }
            java.lang.String r3 = "disk"
            android.os.StatFs r4 = new android.os.StatFs     // Catch:{ all -> 0x0a19 }
            java.io.File r5 = android.os.Environment.getDataDirectory()     // Catch:{ all -> 0x0a19 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x0a19 }
            r4.<init>(r5)     // Catch:{ all -> 0x0a19 }
            long r5 = r4.getBlockSizeLong()     // Catch:{ all -> 0x0a19 }
            long r7 = r4.getAvailableBlocksLong()     // Catch:{ all -> 0x0a19 }
            long r7 = r7 * r5
            long r9 = r4.getBlockCountLong()     // Catch:{ all -> 0x0a19 }
            long r9 = r9 * r5
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            r11 = 4626322717216342016(0x4034000000000000, double:20.0)
            double r4 = java.lang.Math.pow(r4, r11)     // Catch:{ all -> 0x0a19 }
            double r6 = (double) r7     // Catch:{ all -> 0x0a19 }
            double r6 = r6 / r4
            long r6 = (long) r6     // Catch:{ all -> 0x0a19 }
            double r8 = (double) r9     // Catch:{ all -> 0x0a19 }
            double r8 = r8 / r4
            long r4 = (long) r8     // Catch:{ all -> 0x0a19 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0a19 }
            r8.<init>()     // Catch:{ all -> 0x0a19 }
            r8.append(r6)     // Catch:{ all -> 0x0a19 }
            java.lang.String r6 = "/"
            r8.append(r6)     // Catch:{ all -> 0x0a19 }
            r8.append(r4)     // Catch:{ all -> 0x0a19 }
            java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x0a19 }
            r1.put(r3, r4)     // Catch:{ all -> 0x0a19 }
            com.appsflyer.internal.AFa1eSDK r3 = r2.AFLogger     // Catch:{ all -> 0x0a19 }
            if (r3 == 0) goto L_0x0b38
            java.lang.String[] r3 = r3.AFInAppEventType     // Catch:{ all -> 0x0a19 }
            if (r3 == 0) goto L_0x0b38
            java.lang.String r4 = "sharing_filter"
            r1.put(r4, r3)     // Catch:{ all -> 0x0a19 }
            goto L_0x0b38
        L_0x0b17:
            r0 = move-exception
            r36 = r2
            r2 = r1
            r1 = r36
            goto L_0x096f
        L_0x0b1f:
            r36 = r2
            r2 = r1
            r1 = r36
            java.lang.String r3 = "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. "
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ all -> 0x0a19 }
            java.lang.String r3 = "AppsFlyer will not track this event."
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ all -> 0x0a19 }
            r1 = 0
            return r1
        L_0x0b30:
            java.lang.String r4 = r3.getLocalizedMessage()
            r5 = 1
            com.appsflyer.AFLogger.afErrorLog(r4, r3, r5)
        L_0x0b38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFInAppEventType(com.appsflyer.internal.AFa1sSDK):java.util.Map");
    }

    private int AFKeystoreWrapper(SharedPreferences sharedPreferences, boolean z10) {
        int i10 = AppsFlyerConversionListener + 123;
        onValidateInAppFailure = i10 % 128;
        int i11 = i10 % 2;
        int AFInAppEventType2 = AFInAppEventType(sharedPreferences, "appsFlyerInAppEventCount", z10);
        if (i11 == 0) {
            int i12 = 57 / 0;
        }
        return AFInAppEventType2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0077 A[SYNTHETIC, Splitter:B:34:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007c A[Catch:{ all -> 0x0056 }] */
    @androidx.annotation.NonNull
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String AFKeystoreWrapper(java.net.HttpURLConnection r8) {
        /*
            java.lang.String r0 = "readServerResponse error"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
            java.io.InputStream r3 = r8.getErrorStream()     // Catch:{ all -> 0x001b }
            if (r3 != 0) goto L_0x001e
            int r3 = onValidateInAppFailure
            int r3 = r3 + 107
            int r3 = r3 % 128
            AppsFlyerConversionListener = r3
            java.io.InputStream r3 = r8.getInputStream()     // Catch:{ all -> 0x001b }
            goto L_0x001e
        L_0x001b:
            r3 = move-exception
            r4 = r2
            goto L_0x005c
        L_0x001e:
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x001b }
            r4.<init>(r3)     // Catch:{ all -> 0x001b }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x005b }
            r3.<init>(r4)     // Catch:{ all -> 0x005b }
            r2 = 0
        L_0x0029:
            java.lang.String r5 = r3.readLine()     // Catch:{ all -> 0x0040 }
            if (r5 == 0) goto L_0x004f
            int r6 = AppsFlyerConversionListener
            int r6 = r6 + 95
            int r6 = r6 % 128
            onValidateInAppFailure = r6
            if (r2 == 0) goto L_0x0045
            r2 = 10
            java.lang.Character r2 = java.lang.Character.valueOf(r2)     // Catch:{ all -> 0x0040 }
            goto L_0x0047
        L_0x0040:
            r2 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
            goto L_0x005c
        L_0x0045:
            java.lang.String r2 = ""
        L_0x0047:
            r1.append(r2)     // Catch:{ all -> 0x0040 }
            r1.append(r5)     // Catch:{ all -> 0x0040 }
            r2 = 1
            goto L_0x0029
        L_0x004f:
            r3.close()     // Catch:{ all -> 0x0056 }
            r4.close()     // Catch:{ all -> 0x0056 }
            goto L_0x007f
        L_0x0056:
            r8 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r8)
            goto L_0x007f
        L_0x005b:
            r3 = move-exception
        L_0x005c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            java.lang.String r6 = "Could not read connection response from: "
            r5.<init>(r6)     // Catch:{ all -> 0x00ae }
            java.net.URL r8 = r8.getURL()     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00ae }
            r5.append(r8)     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x00ae }
            com.appsflyer.AFLogger.afErrorLog(r8, r3)     // Catch:{ all -> 0x00ae }
            if (r2 == 0) goto L_0x007a
            r2.close()     // Catch:{ all -> 0x0056 }
        L_0x007a:
            if (r4 == 0) goto L_0x007f
            r4.close()     // Catch:{ all -> 0x0056 }
        L_0x007f:
            java.lang.String r8 = r1.toString()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0089 }
            r0.<init>(r8)     // Catch:{ JSONException -> 0x0089 }
            return r8
        L_0x0089:
            r0 = move-exception
            java.lang.String r1 = "error while parsing readServerResponse"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r1, r0)
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "string_response"
            r0.put(r1, r8)     // Catch:{ JSONException -> 0x009e }
            java.lang.String r8 = r0.toString()     // Catch:{ JSONException -> 0x009e }
            return r8
        L_0x009e:
            r8 = move-exception
            java.lang.String r0 = "RESPONSE_NOT_JSON error"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r8)
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            java.lang.String r8 = r8.toString()
            return r8
        L_0x00ae:
            r8 = move-exception
            if (r2 == 0) goto L_0x00b7
            r2.close()     // Catch:{ all -> 0x00b5 }
            goto L_0x00b7
        L_0x00b5:
            r1 = move-exception
            goto L_0x00c5
        L_0x00b7:
            if (r4 == 0) goto L_0x00c8
            int r1 = AppsFlyerConversionListener
            int r1 = r1 + 89
            int r1 = r1 % 128
            onValidateInAppFailure = r1
            r4.close()     // Catch:{ all -> 0x00b5 }
            goto L_0x00c8
        L_0x00c5:
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r1)
        L_0x00c8:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFKeystoreWrapper(java.net.HttpURLConnection):java.lang.String");
    }

    @VisibleForTesting
    @Nullable
    private String AFInAppEventParameterName(Context context, String str) {
        int i10 = AppsFlyerConversionListener;
        onValidateInAppFailure = (i10 + 119) % 128;
        if (context == null) {
            onValidateInAppFailure = (i10 + 7) % 128;
            return null;
        }
        values(context);
        return AFKeystoreWrapper().values().AFInAppEventType(str);
    }

    @Deprecated
    @Nullable
    public final String AFInAppEventParameterName(Context context) {
        AppsFlyerConversionListener = (onValidateInAppFailure + 15) % 128;
        values(context);
        String AFInAppEventType2 = AFKeystoreWrapper().values().AFInAppEventType();
        onValidateInAppFailure = (AppsFlyerConversionListener + 11) % 128;
        return AFInAppEventType2;
    }

    private String AFInAppEventParameterName(SimpleDateFormat simpleDateFormat, Context context) {
        String str;
        String string = AFKeystoreWrapper(context).getString("appsFlyerFirstInstall", (String) null);
        if (string == null) {
            AppsFlyerConversionListener = (onValidateInAppFailure + 39) % 128;
            if (afErrorLog(context)) {
                AFLogger.afDebugLog("AppsFlyer: first launch detected");
                str = simpleDateFormat.format(new Date());
                AppsFlyerConversionListener = (onValidateInAppFailure + 13) % 128;
            } else {
                str = "";
            }
            string = str;
            AFInAppEventType(context).valueOf("appsFlyerFirstInstall", string);
            onValidateInAppFailure = (AppsFlyerConversionListener + 107) % 128;
        }
        AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string)));
        return string;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r5 = com.appsflyer.internal.AFb1iSDK.values(r5);
     */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void AFKeystoreWrapper(@androidx.annotation.NonNull com.appsflyer.internal.AFa1sSDK r4, @androidx.annotation.Nullable android.app.Activity r5) {
        /*
            r3 = this;
            android.app.Application r0 = r4.AFInAppEventType
            java.lang.String r1 = ""
            if (r5 == 0) goto L_0x0017
            android.content.Intent r2 = r5.getIntent()
            if (r2 == 0) goto L_0x0017
            android.net.Uri r5 = com.appsflyer.internal.AFb1iSDK.values(r5)
            if (r5 == 0) goto L_0x0017
            java.lang.String r5 = r5.toString()
            goto L_0x0018
        L_0x0017:
            r5 = r1
        L_0x0018:
            com.appsflyer.internal.AFc1vSDK r2 = r3.AFKeystoreWrapper()
            com.appsflyer.internal.AFe1nSDK r2 = r2.getLevel()
            java.lang.String r2 = r2.values
            if (r2 != 0) goto L_0x005b
            int r5 = onValidateInAppFailure
            int r5 = r5 + 93
            int r5 = r5 % 128
            AppsFlyerConversionListener = r5
            java.lang.String r5 = "[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey."
            com.appsflyer.AFLogger.afWarnLog(r5)
            com.appsflyer.attribution.AppsFlyerRequestListener r4 = r4.values
            if (r4 == 0) goto L_0x005a
            int r5 = AppsFlyerConversionListener
            int r5 = r5 + 41
            int r0 = r5 % 128
            onValidateInAppFailure = r0
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x0051
            int r5 = com.appsflyer.attribution.RequestError.NO_DEV_KEY
            java.lang.String r0 = com.appsflyer.internal.AFb1aSDK.valueOf
            r4.onError(r5, r0)
            int r4 = onValidateInAppFailure
            int r4 = r4 + 47
            int r4 = r4 % 128
            AppsFlyerConversionListener = r4
            goto L_0x005a
        L_0x0051:
            int r5 = com.appsflyer.attribution.RequestError.NO_DEV_KEY
            java.lang.String r0 = com.appsflyer.internal.AFb1aSDK.valueOf
            r4.onError(r5, r0)
            r4 = 0
            throw r4
        L_0x005a:
            return
        L_0x005b:
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r2.getReferrer(r0)
            if (r0 != 0) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r1 = r0
        L_0x0067:
            r4.AFLogger = r1
            r4.valueOf = r5
            r3.values((com.appsflyer.internal.AFa1sSDK) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFKeystoreWrapper(com.appsflyer.internal.AFa1sSDK, android.app.Activity):void");
    }

    @SuppressLint({"PrivateApi"})
    private static String values(String str) {
        String str2 = null;
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
            AppsFlyerConversionListener = (onValidateInAppFailure + 67) % 128;
            str2 = str3;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
        }
        onValidateInAppFailure = (AppsFlyerConversionListener + 11) % 128;
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001c, code lost:
        if (r2 == false) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001f, code lost:
        if (r2 == false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean values(java.io.File r2) {
        /*
            int r0 = AppsFlyerConversionListener
            int r0 = r0 + 21
            int r0 = r0 % 128
            onValidateInAppFailure = r0
            if (r2 == 0) goto L_0x0023
            int r0 = r0 + 41
            int r1 = r0 % 128
            AppsFlyerConversionListener = r1
            int r0 = r0 % 2
            r1 = 0
            boolean r2 = r2.exists()
            if (r0 == 0) goto L_0x001f
            r0 = 96
            int r0 = r0 / r1
            if (r2 != 0) goto L_0x0022
            goto L_0x0023
        L_0x001f:
            if (r2 != 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            return r1
        L_0x0023:
            int r2 = AppsFlyerConversionListener
            int r2 = r2 + 103
            int r2 = r2 % 128
            onValidateInAppFailure = r2
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.values(java.io.File):boolean");
    }

    private static void values(@NonNull ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j10, TimeUnit timeUnit) {
        int i10 = AppsFlyerConversionListener + 31;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            try {
                scheduledExecutorService.schedule(runnable, j10, timeUnit);
                int i11 = 12 / 0;
            } catch (RejectedExecutionException e10) {
                AFLogger.afErrorLog("scheduleJob failed with RejectedExecutionException Exception", e10);
                return;
            } catch (Throwable th) {
                AFLogger.afErrorLog("scheduleJob failed with Exception", th);
                return;
            }
        } else {
            scheduledExecutorService.schedule(runnable, j10, timeUnit);
        }
        onValidateInAppFailure = (AppsFlyerConversionListener + 17) % 128;
    }

    public final void values(@NonNull Context context) {
        int i10 = AppsFlyerConversionListener;
        onValidateInAppFailure = (i10 + 17) % 128;
        AFc1tSDK aFc1tSDK = this.onAttributionFailure;
        if (context != null) {
            onValidateInAppFailure = (i10 + 51) % 128;
            AFc1sSDK aFc1sSDK = aFc1tSDK.AFKeystoreWrapper;
            if (context != null) {
                onValidateInAppFailure = (i10 + 63) % 128;
                aFc1sSDK.AFKeystoreWrapper = context.getApplicationContext();
            }
        }
        int i11 = onValidateInAppFailure + 115;
        AppsFlyerConversionListener = i11 % 128;
        if (i11 % 2 != 0) {
            throw null;
        }
    }

    private void values(AFa1sSDK aFa1sSDK) {
        boolean z10 = aFa1sSDK.afDebugLog == null;
        if (valueOf()) {
            int i10 = AppsFlyerConversionListener + 65;
            onValidateInAppFailure = i10 % 128;
            if (i10 % 2 == 0) {
                AFLogger.afInfoLog("CustomerUserId not set, reporting is disabled", false);
            } else {
                AFLogger.afInfoLog("CustomerUserId not set, reporting is disabled", true);
            }
            AppsFlyerConversionListener = (onValidateInAppFailure + 45) % 128;
            return;
        }
        if (!(!z10)) {
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.LAUNCH_PROTECT_ENABLED, true)) {
                onValidateInAppFailure = (AppsFlyerConversionListener + 87) % 128;
                if (afRDLog()) {
                    AppsFlyerRequestListener appsFlyerRequestListener = aFa1sSDK.values;
                    if (appsFlyerRequestListener != null) {
                        appsFlyerRequestListener.onError(RequestError.EVENT_TIMEOUT, AFb1aSDK.values);
                    }
                    int i11 = onValidateInAppFailure + 97;
                    AppsFlyerConversionListener = i11 % 128;
                    if (i11 % 2 != 0) {
                        throw null;
                    }
                    return;
                }
            } else {
                AFLogger.afInfoLog("Allowing multiple launches within a 5 second time window.");
                onValidateInAppFailure = (AppsFlyerConversionListener + 27) % 128;
            }
            this.afRDLog = System.currentTimeMillis();
        }
        values(AFKeystoreWrapper().AFInAppEventParameterName(), new AFa1vSDK(this, aFa1sSDK, (byte) 0), 0, TimeUnit.MILLISECONDS);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void values(java.lang.String r12, int r13, java.lang.Object[] r14) {
        /*
            if (r12 == 0) goto L_0x0006
            char[] r12 = r12.toCharArray()
        L_0x0006:
            char[] r12 = (char[]) r12
            java.lang.Object r0 = com.appsflyer.internal.AFg1nSDK.values
            monitor-enter(r0)
            int r1 = r12.length     // Catch:{ all -> 0x005b }
            char[] r1 = new char[r1]     // Catch:{ all -> 0x005b }
            r2 = 0
            com.appsflyer.internal.AFg1nSDK.AFKeystoreWrapper = r2     // Catch:{ all -> 0x005b }
            r3 = 2
            char[] r3 = new char[r3]     // Catch:{ all -> 0x005b }
        L_0x0014:
            int r4 = com.appsflyer.internal.AFg1nSDK.AFKeystoreWrapper     // Catch:{ all -> 0x005b }
            int r5 = r12.length     // Catch:{ all -> 0x005b }
            if (r4 >= r5) goto L_0x006e
            char r5 = r12[r4]     // Catch:{ all -> 0x005b }
            r3[r2] = r5     // Catch:{ all -> 0x005b }
            int r4 = r4 + 1
            char r4 = r12[r4]     // Catch:{ all -> 0x005b }
            r5 = 1
            r3[r5] = r4     // Catch:{ all -> 0x005b }
            r4 = 58224(0xe370, float:8.1589E-41)
            r6 = r2
        L_0x0028:
            r7 = 16
            if (r6 >= r7) goto L_0x005d
            char r7 = r3[r5]     // Catch:{ all -> 0x005b }
            char r8 = r3[r2]     // Catch:{ all -> 0x005b }
            int r9 = r8 + r4
            int r10 = r8 << 4
            char r11 = onResponse     // Catch:{ all -> 0x005b }
            int r10 = r10 + r11
            r9 = r9 ^ r10
            int r10 = r8 >>> 5
            char r11 = onResponseError     // Catch:{ all -> 0x005b }
            int r10 = r10 + r11
            r9 = r9 ^ r10
            int r7 = r7 - r9
            char r7 = (char) r7     // Catch:{ all -> 0x005b }
            r3[r5] = r7     // Catch:{ all -> 0x005b }
            int r9 = r7 + r4
            int r10 = r7 << 4
            char r11 = onDeepLinking     // Catch:{ all -> 0x005b }
            int r10 = r10 + r11
            r9 = r9 ^ r10
            int r7 = r7 >>> 5
            char r10 = onConversionDataFail     // Catch:{ all -> 0x005b }
            int r7 = r7 + r10
            r7 = r7 ^ r9
            int r8 = r8 - r7
            char r7 = (char) r8     // Catch:{ all -> 0x005b }
            r3[r2] = r7     // Catch:{ all -> 0x005b }
            r7 = 40503(0x9e37, float:5.6757E-41)
            int r4 = r4 - r7
            int r6 = r6 + 1
            goto L_0x0028
        L_0x005b:
            r12 = move-exception
            goto L_0x0077
        L_0x005d:
            int r4 = com.appsflyer.internal.AFg1nSDK.AFKeystoreWrapper     // Catch:{ all -> 0x005b }
            char r6 = r3[r2]     // Catch:{ all -> 0x005b }
            r1[r4] = r6     // Catch:{ all -> 0x005b }
            int r6 = r4 + 1
            char r5 = r3[r5]     // Catch:{ all -> 0x005b }
            r1[r6] = r5     // Catch:{ all -> 0x005b }
            int r4 = r4 + 2
            com.appsflyer.internal.AFg1nSDK.AFKeystoreWrapper = r4     // Catch:{ all -> 0x005b }
            goto L_0x0014
        L_0x006e:
            java.lang.String r12 = new java.lang.String     // Catch:{ all -> 0x005b }
            r12.<init>(r1, r2, r13)     // Catch:{ all -> 0x005b }
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            r14[r2] = r12
            return
        L_0x0077:
            monitor-exit(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.values(java.lang.String, int, java.lang.Object[]):void");
    }

    private static void AFInAppEventType(Map<String, Object> map, AFe1jSDK aFe1jSDK) {
        HashMap hashMap = new HashMap(aFe1jSDK.AFInAppEventType);
        aFe1jSDK.AFInAppEventType.clear();
        aFe1jSDK.values.valueOf("gcd");
        if (!hashMap.isEmpty()) {
            int i10 = onValidateInAppFailure + 49;
            AppsFlyerConversionListener = i10 % 128;
            if (i10 % 2 == 0) {
                AFKeystoreWrapper(map).put("gcd", hashMap);
            } else {
                AFKeystoreWrapper(map).put("gcd", hashMap);
                throw null;
            }
        }
    }
}
