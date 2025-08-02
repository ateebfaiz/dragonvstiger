package com.facebook.react.bridge;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import c8.b;
import com.facebook.react.module.model.ReactModuleInfo;
import d6.a;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Provider;
import k3.c;

@a
public class ModuleHolder {
    private static final AtomicInteger sInstanceKeyCounter = new AtomicInteger(1);
    @GuardedBy("this")
    private boolean mInitializable;
    private final int mInstanceKey = sInstanceKeyCounter.getAndIncrement();
    @GuardedBy("this")
    private boolean mIsCreating;
    @GuardedBy("this")
    private boolean mIsInitializing;
    @GuardedBy("this")
    @Nullable
    private NativeModule mModule;
    private final String mName;
    @Nullable
    private Provider mProvider;
    private final ReactModuleInfo mReactModuleInfo;

    public ModuleHolder(ReactModuleInfo reactModuleInfo, Provider provider) {
        this.mName = reactModuleInfo.f();
        this.mProvider = provider;
        this.mReactModuleInfo = reactModuleInfo;
        if (reactModuleInfo.g()) {
            this.mModule = create();
        }
    }

    private NativeModule create() {
        boolean z10;
        boolean z11;
        if (this.mModule == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        SoftAssertions.assertCondition(z10, "Creating an already created module.");
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, this.mName, this.mInstanceKey);
        b.a(0, "ModuleHolder.createModule").b("name", this.mName).c();
        c.a().b(l3.a.f22452e, "NativeModule init: %s", this.mName);
        try {
            NativeModule nativeModule = (NativeModule) ((Provider) p5.a.c(this.mProvider)).get();
            this.mProvider = null;
            synchronized (this) {
                this.mModule = nativeModule;
                if (!this.mInitializable || this.mIsInitializing) {
                    z11 = false;
                } else {
                    z11 = true;
                }
            }
            if (z11) {
                doInitialize(nativeModule);
            }
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END, this.mName, this.mInstanceKey);
            b.b(0).c();
            return nativeModule;
        } catch (Throwable th) {
            try {
                z2.a.m("ReactNative", th, "Failed to create NativeModule '%s'", this.mName);
                throw th;
            } catch (Throwable th2) {
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END, this.mName, this.mInstanceKey);
                b.b(0).c();
                throw th2;
            }
        }
    }

    private void doInitialize(NativeModule nativeModule) {
        boolean z10;
        b.a(0, "ModuleHolder.initialize").b("name", this.mName).c();
        ReactMarker.logMarker(ReactMarkerConstants.INITIALIZE_MODULE_START, this.mName, this.mInstanceKey);
        try {
            synchronized (this) {
                if (!this.mInitializable || this.mIsInitializing) {
                    z10 = false;
                } else {
                    z10 = true;
                    this.mIsInitializing = true;
                }
            }
            if (z10) {
                nativeModule.initialize();
                synchronized (this) {
                    this.mIsInitializing = false;
                }
            }
            ReactMarker.logMarker(ReactMarkerConstants.INITIALIZE_MODULE_END, this.mName, this.mInstanceKey);
            b.b(0).c();
        } catch (Throwable th) {
            ReactMarker.logMarker(ReactMarkerConstants.INITIALIZE_MODULE_END, this.mName, this.mInstanceKey);
            b.b(0).c();
            throw th;
        }
    }

    public synchronized void destroy() {
        NativeModule nativeModule = this.mModule;
        if (nativeModule != null) {
            nativeModule.invalidate();
        }
    }

    public boolean getCanOverrideExistingModule() {
        return this.mReactModuleInfo.a();
    }

    public String getClassName() {
        return this.mReactModuleInfo.c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0014, code lost:
        if (r0 == false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0016, code lost:
        r0 = create();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001a, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r2.mIsCreating = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0020, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0021, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0025, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0 = r2.mModule;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0028, code lost:
        if (r0 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r0 = (com.facebook.react.bridge.NativeModule) p5.a.c(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x003a, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x003b, code lost:
        return r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0026 */
    @d6.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.bridge.NativeModule getModule() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.facebook.react.bridge.NativeModule r0 = r2.mModule     // Catch:{ all -> 0x0007 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r2)     // Catch:{ all -> 0x0007 }
            return r0
        L_0x0007:
            r0 = move-exception
            goto L_0x003e
        L_0x0009:
            boolean r0 = r2.mIsCreating     // Catch:{ all -> 0x0007 }
            r1 = 0
            if (r0 != 0) goto L_0x0012
            r0 = 1
            r2.mIsCreating = r0     // Catch:{ all -> 0x0007 }
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            monitor-exit(r2)     // Catch:{ all -> 0x0007 }
            if (r0 == 0) goto L_0x0025
            com.facebook.react.bridge.NativeModule r0 = r2.create()
            monitor-enter(r2)
            r2.mIsCreating = r1     // Catch:{ all -> 0x0022 }
            r2.notifyAll()     // Catch:{ all -> 0x0022 }
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r0
        L_0x0022:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r0
        L_0x0025:
            monitor-enter(r2)
        L_0x0026:
            com.facebook.react.bridge.NativeModule r0 = r2.mModule     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x0034
            boolean r1 = r2.mIsCreating     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0034
            r2.wait()     // Catch:{ InterruptedException -> 0x0026 }
            goto L_0x0026
        L_0x0032:
            r0 = move-exception
            goto L_0x003c
        L_0x0034:
            java.lang.Object r0 = p5.a.c(r0)     // Catch:{ all -> 0x0032 }
            com.facebook.react.bridge.NativeModule r0 = (com.facebook.react.bridge.NativeModule) r0     // Catch:{ all -> 0x0032 }
            monitor-exit(r2)     // Catch:{ all -> 0x0032 }
            return r0
        L_0x003c:
            monitor-exit(r2)     // Catch:{ all -> 0x0032 }
            throw r0
        L_0x003e:
            monitor-exit(r2)     // Catch:{ all -> 0x0007 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.ModuleHolder.getModule():com.facebook.react.bridge.NativeModule");
    }

    @a
    public String getName() {
        return this.mName;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean hasInstance() {
        boolean z10;
        if (this.mModule != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }

    public boolean isCxxModule() {
        return this.mReactModuleInfo.d();
    }

    public boolean isTurboModule() {
        return this.mReactModuleInfo.e();
    }

    /* access modifiers changed from: package-private */
    public void markInitializable() {
        boolean z10;
        NativeModule nativeModule;
        synchronized (this) {
            z10 = true;
            try {
                this.mInitializable = true;
                if (this.mModule != null) {
                    p5.a.a(!this.mIsInitializing);
                    nativeModule = this.mModule;
                } else {
                    nativeModule = null;
                    z10 = false;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (z10) {
            doInitialize(nativeModule);
        }
    }

    public ModuleHolder(NativeModule nativeModule) {
        String name = nativeModule.getName();
        this.mName = name;
        this.mReactModuleInfo = new ReactModuleInfo(nativeModule.getName(), nativeModule.getClass().getSimpleName(), nativeModule.canOverrideExistingModule(), true, CxxModuleWrapper.class.isAssignableFrom(nativeModule.getClass()), ReactModuleInfo.b(nativeModule.getClass()));
        this.mModule = nativeModule;
        c.a().b(l3.a.f22452e, "NativeModule init: %s", name);
    }
}
