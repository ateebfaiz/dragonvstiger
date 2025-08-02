package com.facebook.react;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.CxxModuleWrapper;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class s0 extends TurboModuleManagerDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final List f20916a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map f20917b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20918c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f20919d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f20920e;

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private List f20921a;

        /* renamed from: b  reason: collision with root package name */
        private ReactApplicationContext f20922b;

        public s0 a() {
            p5.a.d(this.f20922b, "The ReactApplicationContext must be provided to create ReactPackageTurboModuleManagerDelegate");
            p5.a.d(this.f20921a, "A set of ReactPackages must be provided to create ReactPackageTurboModuleManagerDelegate");
            return b(this.f20922b, this.f20921a);
        }

        /* access modifiers changed from: protected */
        public abstract s0 b(ReactApplicationContext reactApplicationContext, List list);

        public a c(List list) {
            this.f20921a = new ArrayList(list);
            return this;
        }

        public a d(ReactApplicationContext reactApplicationContext) {
            this.f20922b = reactApplicationContext;
            return this;
        }
    }

    interface b {
        NativeModule getModule(String str);
    }

    protected s0(ReactApplicationContext reactApplicationContext, List list, HybridData hybridData) {
        super(hybridData);
        boolean z10;
        boolean z11 = false;
        if (!ReactFeatureFlags.enableBridgelessArchitecture || !ReactFeatureFlags.unstable_useTurboModuleInterop) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f20918c = z10;
        if (z10 && ReactFeatureFlags.unstable_useTurboModuleInteropForAllTurboModules) {
            z11 = true;
        }
        this.f20919d = z11;
        this.f20920e = ReactFeatureFlags.unstable_enableTurboModuleSyncVoidMethods;
        b(reactApplicationContext, list);
    }

    private void b(ReactApplicationContext reactApplicationContext, List list) {
        String str;
        ReactModuleInfo reactModuleInfo;
        ReactApplicationContext reactApplicationContext2 = reactApplicationContext;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m0 m0Var = (m0) it.next();
            if (m0Var instanceof b) {
                b bVar = (b) m0Var;
                q0 q0Var = new q0(bVar, reactApplicationContext2);
                this.f20916a.add(q0Var);
                this.f20917b.put(q0Var, bVar.getReactModuleInfoProvider().a());
            } else {
                d();
                if (d()) {
                    List<NativeModule> createNativeModules = m0Var.createNativeModules(reactApplicationContext2);
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    for (NativeModule nativeModule : createNativeModules) {
                        Class<?> cls = nativeModule.getClass();
                        s6.a aVar = (s6.a) cls.getAnnotation(s6.a.class);
                        if (aVar != null) {
                            str = aVar.name();
                        } else {
                            str = nativeModule.getName();
                        }
                        if (aVar != null) {
                            reactModuleInfo = new ReactModuleInfo(str, cls.getName(), aVar.canOverrideExistingModule(), true, aVar.isCxxModule(), ReactModuleInfo.b(cls));
                        } else {
                            reactModuleInfo = new ReactModuleInfo(str, cls.getName(), nativeModule.canOverrideExistingModule(), true, CxxModuleWrapper.class.isAssignableFrom(cls), ReactModuleInfo.b(cls));
                        }
                        hashMap2.put(str, reactModuleInfo);
                        hashMap.put(str, nativeModule);
                    }
                    r0 r0Var = new r0(hashMap);
                    this.f20916a.add(r0Var);
                    this.f20917b.put(r0Var, hashMap2);
                }
            }
        }
    }

    private boolean d() {
        return unstable_shouldEnableLegacyModuleInterop();
    }

    public List getEagerInitModuleNames() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.f20916a) {
            for (ReactModuleInfo reactModuleInfo : ((Map) this.f20917b.get(bVar)).values()) {
                if (reactModuleInfo.e() && reactModuleInfo.g()) {
                    arrayList.add(reactModuleInfo.f());
                }
            }
        }
        return arrayList;
    }

    public NativeModule getLegacyModule(String str) {
        NativeModule module;
        if (!unstable_shouldEnableLegacyModuleInterop()) {
            return null;
        }
        NativeModule nativeModule = null;
        for (b bVar : this.f20916a) {
            ReactModuleInfo reactModuleInfo = (ReactModuleInfo) ((Map) this.f20917b.get(bVar)).get(str);
            if (reactModuleInfo != null && !reactModuleInfo.e()) {
                if ((nativeModule == null || reactModuleInfo.a()) && (module = bVar.getModule(str)) != null) {
                    nativeModule = module;
                }
            }
        }
        if (!(!(nativeModule instanceof TurboModule))) {
            return null;
        }
        return nativeModule;
    }

    public TurboModule getModule(String str) {
        NativeModule module;
        NativeModule nativeModule = null;
        for (b bVar : this.f20916a) {
            ReactModuleInfo reactModuleInfo = (ReactModuleInfo) ((Map) this.f20917b.get(bVar)).get(str);
            if (reactModuleInfo != null && reactModuleInfo.e()) {
                if ((nativeModule == null || reactModuleInfo.a()) && (module = bVar.getModule(str)) != null) {
                    nativeModule = module;
                }
            }
        }
        if (!(nativeModule instanceof TurboModule)) {
            return null;
        }
        return (TurboModule) nativeModule;
    }

    public boolean unstable_enableSyncVoidMethods() {
        return this.f20920e;
    }

    public boolean unstable_isLegacyModuleRegistered(String str) {
        for (b bVar : this.f20916a) {
            ReactModuleInfo reactModuleInfo = (ReactModuleInfo) ((Map) this.f20917b.get(bVar)).get(str);
            if (reactModuleInfo != null && !reactModuleInfo.e()) {
                return true;
            }
        }
        return false;
    }

    public boolean unstable_isModuleRegistered(String str) {
        for (b bVar : this.f20916a) {
            ReactModuleInfo reactModuleInfo = (ReactModuleInfo) ((Map) this.f20917b.get(bVar)).get(str);
            if (reactModuleInfo != null && reactModuleInfo.e()) {
                return true;
            }
        }
        return false;
    }

    public boolean unstable_shouldEnableLegacyModuleInterop() {
        return this.f20918c;
    }

    public boolean unstable_shouldRouteTurboModulesThroughLegacyModuleInterop() {
        return this.f20919d;
    }
}
