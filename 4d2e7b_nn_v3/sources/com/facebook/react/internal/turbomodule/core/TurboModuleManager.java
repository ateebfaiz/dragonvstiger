package com.facebook.react.internal.turbomodule.core;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.CxxModuleWrapper;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.internal.turbomodule.core.TurboModuleInteropUtils;
import com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.NativeMethodCallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.turbomodule.core.interfaces.NativeMethodCallInvokerHolder;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurboModuleManager implements TurboModuleRegistry {
    private final TurboModuleManagerDelegate mDelegate;
    private final List<String> mEagerInitModuleNames;
    @a
    private final HybridData mHybridData;
    private final ModuleProvider mLegacyModuleProvider;
    private final Object mModuleCleanupLock = new Object();
    @GuardedBy("mModuleCleanupLock")
    private boolean mModuleCleanupStarted = false;
    @GuardedBy("mModuleCleanupLock")
    private final Map<String, ModuleHolder> mModuleHolders = new HashMap();
    private final ModuleProvider mTurboModuleProvider;

    private static class ModuleHolder {
        private static volatile int sHolderCount;
        private volatile boolean mIsDoneCreatingModule = false;
        private volatile boolean mIsTryingToCreate = false;
        private volatile NativeModule mModule = null;
        private volatile int mModuleId = sHolderCount;

        public ModuleHolder() {
            sHolderCount++;
        }

        /* access modifiers changed from: package-private */
        public void endCreatingModule() {
            this.mIsTryingToCreate = false;
            this.mIsDoneCreatingModule = true;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public NativeModule getModule() {
            return this.mModule;
        }

        /* access modifiers changed from: package-private */
        public int getModuleId() {
            return this.mModuleId;
        }

        /* access modifiers changed from: package-private */
        public boolean isCreatingModule() {
            return this.mIsTryingToCreate;
        }

        /* access modifiers changed from: package-private */
        public boolean isDoneCreatingModule() {
            return this.mIsDoneCreatingModule;
        }

        /* access modifiers changed from: package-private */
        public void setModule(@NonNull NativeModule nativeModule) {
            this.mModule = nativeModule;
        }

        /* access modifiers changed from: package-private */
        public void startCreatingModule() {
            this.mIsTryingToCreate = true;
        }
    }

    private interface ModuleProvider {
        @Nullable
        NativeModule getModule(String str);
    }

    static {
        NativeModuleSoLoader.maybeLoadSoLibrary();
    }

    public TurboModuleManager(RuntimeExecutor runtimeExecutor, @Nullable TurboModuleManagerDelegate turboModuleManagerDelegate, CallInvokerHolder callInvokerHolder, NativeMethodCallInvokerHolder nativeMethodCallInvokerHolder) {
        List<String> list;
        ModuleProvider moduleProvider;
        this.mDelegate = turboModuleManagerDelegate;
        this.mHybridData = initHybrid(runtimeExecutor, (CallInvokerHolderImpl) callInvokerHolder, (NativeMethodCallInvokerHolderImpl) nativeMethodCallInvokerHolder, turboModuleManagerDelegate);
        installJSIBindings(shouldEnableLegacyModuleInterop(), enableSyncVoidMethods());
        if (turboModuleManagerDelegate == null) {
            list = new ArrayList<>();
        } else {
            list = turboModuleManagerDelegate.getEagerInitModuleNames();
        }
        this.mEagerInitModuleNames = list;
        ModuleProvider aVar = new a();
        if (turboModuleManagerDelegate == null) {
            moduleProvider = aVar;
        } else {
            moduleProvider = new b(turboModuleManagerDelegate);
        }
        this.mTurboModuleProvider = moduleProvider;
        if (turboModuleManagerDelegate != null && shouldEnableLegacyModuleInterop()) {
            aVar = new c(turboModuleManagerDelegate);
        }
        this.mLegacyModuleProvider = aVar;
    }

    private boolean enableSyncVoidMethods() {
        TurboModuleManagerDelegate turboModuleManagerDelegate = this.mDelegate;
        if (turboModuleManagerDelegate == null || !turboModuleManagerDelegate.unstable_enableSyncVoidMethods()) {
            return false;
        }
        return true;
    }

    @Nullable
    @a
    private CxxModuleWrapper getLegacyCxxModule(String str) {
        if (shouldRouteTurboModulesThroughLegacyModuleInterop()) {
            NativeModule module = getModule(str);
            if (module instanceof CxxModuleWrapper) {
                return (CxxModuleWrapper) module;
            }
            return null;
        } else if (!isLegacyModule(str)) {
            return null;
        } else {
            NativeModule module2 = getModule(str);
            if (!(module2 instanceof CxxModuleWrapper) || (module2 instanceof TurboModule)) {
                return null;
            }
            return (CxxModuleWrapper) module2;
        }
    }

    @Nullable
    @a
    private NativeModule getLegacyJavaModule(String str) {
        if (shouldRouteTurboModulesThroughLegacyModuleInterop()) {
            NativeModule module = getModule(str);
            if (!(module instanceof CxxModuleWrapper)) {
                return module;
            }
            return null;
        } else if (!isLegacyModule(str)) {
            return null;
        } else {
            NativeModule module2 = getModule(str);
            if ((module2 instanceof CxxModuleWrapper) || (module2 instanceof TurboModule)) {
                return null;
            }
            return module2;
        }
    }

    @a
    private static List<TurboModuleInteropUtils.MethodDescriptor> getMethodDescriptorsFromModule(NativeModule nativeModule) {
        return TurboModuleInteropUtils.getMethodDescriptorsFromModule(nativeModule);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        if (r5 == false) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateConstructStart(r3, r4.getModuleId());
        r5 = r2.mTurboModuleProvider.getModule(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        if (r5 != null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        r5 = r2.mLegacyModuleProvider.getModule(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateConstructEnd(r3, r4.getModuleId());
        com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateSetUpStart(r3, r4.getModuleId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        if (r5 == null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r4.setModule(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        r5.initialize();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005c, code lost:
        logError("getOrCreateModule(): Unable to create module \"" + r3 + "\". Was legacy: " + isLegacyModule(r3) + ". Was turbo: " + isTurboModule(r3) + com.alibaba.pdns.f.G);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008d, code lost:
        com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateSetUpEnd(r3, r4.getModuleId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0094, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r4.endCreatingModule();
        r4.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009b, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009c, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a0, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a5, code lost:
        if (r4.isCreatingModule() == false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r4.wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ad, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00af, code lost:
        if (r1 == false) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b8, code lost:
        r3 = r4.getModule();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00bc, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00bd, code lost:
        return r3;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.react.bridge.NativeModule getOrCreateModule(java.lang.String r3, @androidx.annotation.NonNull com.facebook.react.internal.turbomodule.core.TurboModuleManager.ModuleHolder r4, boolean r5) {
        /*
            r2 = this;
            monitor-enter(r4)
            boolean r0 = r4.isDoneCreatingModule()     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x001a
            if (r5 == 0) goto L_0x0014
            int r5 = r4.getModuleId()     // Catch:{ all -> 0x0011 }
            com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateCacheHit(r3, r5)     // Catch:{ all -> 0x0011 }
            goto L_0x0014
        L_0x0011:
            r3 = move-exception
            goto L_0x00c0
        L_0x0014:
            com.facebook.react.bridge.NativeModule r3 = r4.getModule()     // Catch:{ all -> 0x0011 }
            monitor-exit(r4)     // Catch:{ all -> 0x0011 }
            return r3
        L_0x001a:
            boolean r5 = r4.isCreatingModule()     // Catch:{ all -> 0x0011 }
            r0 = 1
            r1 = 0
            if (r5 != 0) goto L_0x0027
            r4.startCreatingModule()     // Catch:{ all -> 0x0011 }
            r5 = r0
            goto L_0x0028
        L_0x0027:
            r5 = r1
        L_0x0028:
            monitor-exit(r4)     // Catch:{ all -> 0x0011 }
            if (r5 == 0) goto L_0x00a0
            int r5 = r4.getModuleId()
            com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateConstructStart(r3, r5)
            com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleProvider r5 = r2.mTurboModuleProvider
            com.facebook.react.bridge.NativeModule r5 = r5.getModule(r3)
            if (r5 != 0) goto L_0x0040
            com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleProvider r5 = r2.mLegacyModuleProvider
            com.facebook.react.bridge.NativeModule r5 = r5.getModule(r3)
        L_0x0040:
            int r0 = r4.getModuleId()
            com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateConstructEnd(r3, r0)
            int r0 = r4.getModuleId()
            com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateSetUpStart(r3, r0)
            if (r5 == 0) goto L_0x005c
            monitor-enter(r4)
            r4.setModule(r5)     // Catch:{ all -> 0x0059 }
            monitor-exit(r4)     // Catch:{ all -> 0x0059 }
            r5.initialize()
            goto L_0x008d
        L_0x0059:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0059 }
            throw r3
        L_0x005c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getOrCreateModule(): Unable to create module \""
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = "\". Was legacy: "
            r0.append(r1)
            boolean r1 = r2.isLegacyModule(r3)
            r0.append(r1)
            java.lang.String r1 = ". Was turbo: "
            r0.append(r1)
            boolean r1 = r2.isTurboModule(r3)
            r0.append(r1)
            java.lang.String r1 = "."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.logError(r0)
        L_0x008d:
            int r0 = r4.getModuleId()
            com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateSetUpEnd(r3, r0)
            monitor-enter(r4)
            r4.endCreatingModule()     // Catch:{ all -> 0x009d }
            r4.notifyAll()     // Catch:{ all -> 0x009d }
            monitor-exit(r4)     // Catch:{ all -> 0x009d }
            return r5
        L_0x009d:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x009d }
            throw r3
        L_0x00a0:
            monitor-enter(r4)
        L_0x00a1:
            boolean r3 = r4.isCreatingModule()     // Catch:{ all -> 0x00ab }
            if (r3 == 0) goto L_0x00af
            r4.wait()     // Catch:{ InterruptedException -> 0x00ad }
            goto L_0x00a1
        L_0x00ab:
            r3 = move-exception
            goto L_0x00be
        L_0x00ad:
            r1 = r0
            goto L_0x00a1
        L_0x00af:
            if (r1 == 0) goto L_0x00b8
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00ab }
            r3.interrupt()     // Catch:{ all -> 0x00ab }
        L_0x00b8:
            com.facebook.react.bridge.NativeModule r3 = r4.getModule()     // Catch:{ all -> 0x00ab }
            monitor-exit(r4)     // Catch:{ all -> 0x00ab }
            return r3
        L_0x00be:
            monitor-exit(r4)     // Catch:{ all -> 0x00ab }
            throw r3
        L_0x00c0:
            monitor-exit(r4)     // Catch:{ all -> 0x0011 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.internal.turbomodule.core.TurboModuleManager.getOrCreateModule(java.lang.String, com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleHolder, boolean):com.facebook.react.bridge.NativeModule");
    }

    @Nullable
    @a
    private TurboModule getTurboJavaModule(String str) {
        if (shouldRouteTurboModulesThroughLegacyModuleInterop() || !isTurboModule(str)) {
            return null;
        }
        NativeModule module = getModule(str);
        if ((module instanceof CxxModuleWrapper) || !(module instanceof TurboModule)) {
            return null;
        }
        return (TurboModule) module;
    }

    @Nullable
    @a
    private CxxModuleWrapper getTurboLegacyCxxModule(String str) {
        if (shouldRouteTurboModulesThroughLegacyModuleInterop() || !isTurboModule(str)) {
            return null;
        }
        NativeModule module = getModule(str);
        if (!(module instanceof CxxModuleWrapper) || !(module instanceof TurboModule)) {
            return null;
        }
        return (CxxModuleWrapper) module;
    }

    private native HybridData initHybrid(RuntimeExecutor runtimeExecutor, CallInvokerHolderImpl callInvokerHolderImpl, NativeMethodCallInvokerHolderImpl nativeMethodCallInvokerHolderImpl, TurboModuleManagerDelegate turboModuleManagerDelegate);

    private native void installJSIBindings(boolean z10, boolean z11);

    private boolean isLegacyModule(String str) {
        TurboModuleManagerDelegate turboModuleManagerDelegate = this.mDelegate;
        if (turboModuleManagerDelegate == null || !turboModuleManagerDelegate.unstable_isLegacyModuleRegistered(str)) {
            return false;
        }
        return true;
    }

    private boolean isTurboModule(String str) {
        TurboModuleManagerDelegate turboModuleManagerDelegate = this.mDelegate;
        if (turboModuleManagerDelegate == null || !turboModuleManagerDelegate.unstable_isModuleRegistered(str)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ NativeModule lambda$new$0(String str) {
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ NativeModule lambda$new$1(TurboModuleManagerDelegate turboModuleManagerDelegate, String str) {
        return (NativeModule) turboModuleManagerDelegate.getModule(str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ NativeModule lambda$new$2(TurboModuleManagerDelegate turboModuleManagerDelegate, String str) {
        NativeModule legacyModule = turboModuleManagerDelegate.getLegacyModule(str);
        if (legacyModule == null) {
            return null;
        }
        p5.a.b(!(legacyModule instanceof TurboModule), "NativeModule \"" + str + "\" is a TurboModule");
        return legacyModule;
    }

    private void logError(String str) {
        z2.a.j("TurboModuleManager", str);
        if (shouldRouteTurboModulesThroughLegacyModuleInterop()) {
            ReactSoftExceptionLogger.logSoftException("TurboModuleManager", new ReactNoCrashSoftException(str));
        }
    }

    private boolean shouldEnableLegacyModuleInterop() {
        TurboModuleManagerDelegate turboModuleManagerDelegate = this.mDelegate;
        if (turboModuleManagerDelegate == null || !turboModuleManagerDelegate.unstable_shouldEnableLegacyModuleInterop()) {
            return false;
        }
        return true;
    }

    private boolean shouldRouteTurboModulesThroughLegacyModuleInterop() {
        TurboModuleManagerDelegate turboModuleManagerDelegate = this.mDelegate;
        if (turboModuleManagerDelegate == null || !turboModuleManagerDelegate.unstable_shouldRouteTurboModulesThroughLegacyModuleInterop()) {
            return false;
        }
        return true;
    }

    @NonNull
    public List<String> getEagerInitModuleNames() {
        return this.mEagerInitModuleNames;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateStart(r4, r1.getModuleId());
        r0 = getOrCreateModule(r4, r1, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0064, code lost:
        if (r0 == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateEnd(r4, r1.getModuleId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006e, code lost:
        com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateFail(r4, r1.getModuleId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0075, code lost:
        return r0;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.bridge.NativeModule getModule(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mModuleCleanupLock
            monitor-enter(r0)
            boolean r1 = r3.mModuleCleanupStarted     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x003d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003b }
            r1.<init>()     // Catch:{ all -> 0x003b }
            java.lang.String r2 = "getModule(): Tried to get module \""
            r1.append(r2)     // Catch:{ all -> 0x003b }
            r1.append(r4)     // Catch:{ all -> 0x003b }
            java.lang.String r2 = "\", but TurboModuleManager was tearing down. Returning null. Was legacy: "
            r1.append(r2)     // Catch:{ all -> 0x003b }
            boolean r2 = r3.isLegacyModule(r4)     // Catch:{ all -> 0x003b }
            r1.append(r2)     // Catch:{ all -> 0x003b }
            java.lang.String r2 = ". Was turbo: "
            r1.append(r2)     // Catch:{ all -> 0x003b }
            boolean r4 = r3.isTurboModule(r4)     // Catch:{ all -> 0x003b }
            r1.append(r4)     // Catch:{ all -> 0x003b }
            java.lang.String r4 = "."
            r1.append(r4)     // Catch:{ all -> 0x003b }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x003b }
            r3.logError(r4)     // Catch:{ all -> 0x003b }
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            r4 = 0
            return r4
        L_0x003b:
            r4 = move-exception
            goto L_0x0076
        L_0x003d:
            java.util.Map<java.lang.String, com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleHolder> r1 = r3.mModuleHolders     // Catch:{ all -> 0x003b }
            boolean r1 = r1.containsKey(r4)     // Catch:{ all -> 0x003b }
            if (r1 != 0) goto L_0x004f
            java.util.Map<java.lang.String, com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleHolder> r1 = r3.mModuleHolders     // Catch:{ all -> 0x003b }
            com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleHolder r2 = new com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleHolder     // Catch:{ all -> 0x003b }
            r2.<init>()     // Catch:{ all -> 0x003b }
            r1.put(r4, r2)     // Catch:{ all -> 0x003b }
        L_0x004f:
            java.util.Map<java.lang.String, com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleHolder> r1 = r3.mModuleHolders     // Catch:{ all -> 0x003b }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x003b }
            com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleHolder r1 = (com.facebook.react.internal.turbomodule.core.TurboModuleManager.ModuleHolder) r1     // Catch:{ all -> 0x003b }
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            int r0 = r1.getModuleId()
            com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateStart(r4, r0)
            r0 = 1
            com.facebook.react.bridge.NativeModule r0 = r3.getOrCreateModule(r4, r1, r0)
            if (r0 == 0) goto L_0x006e
            int r1 = r1.getModuleId()
            com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateEnd(r4, r1)
            goto L_0x0075
        L_0x006e:
            int r1 = r1.getModuleId()
            com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateFail(r4, r1)
        L_0x0075:
            return r0
        L_0x0076:
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.internal.turbomodule.core.TurboModuleManager.getModule(java.lang.String):com.facebook.react.bridge.NativeModule");
    }

    public Collection<NativeModule> getModules() {
        ArrayList<ModuleHolder> arrayList = new ArrayList<>();
        synchronized (this.mModuleCleanupLock) {
            arrayList.addAll(this.mModuleHolders.values());
        }
        ArrayList arrayList2 = new ArrayList();
        for (ModuleHolder moduleHolder : arrayList) {
            synchronized (moduleHolder) {
                try {
                    if (moduleHolder.getModule() != null) {
                        arrayList2.add(moduleHolder.getModule());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return arrayList2;
    }

    public boolean hasModule(String str) {
        ModuleHolder moduleHolder;
        synchronized (this.mModuleCleanupLock) {
            moduleHolder = this.mModuleHolders.get(str);
        }
        if (moduleHolder == null) {
            return false;
        }
        synchronized (moduleHolder) {
            try {
                if (moduleHolder.getModule() != null) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void invalidate() {
        synchronized (this.mModuleCleanupLock) {
            this.mModuleCleanupStarted = true;
        }
        for (Map.Entry next : this.mModuleHolders.entrySet()) {
            NativeModule orCreateModule = getOrCreateModule((String) next.getKey(), (ModuleHolder) next.getValue(), false);
            if (orCreateModule != null) {
                orCreateModule.invalidate();
            }
        }
        this.mModuleHolders.clear();
        this.mHybridData.resetNative();
    }
}
