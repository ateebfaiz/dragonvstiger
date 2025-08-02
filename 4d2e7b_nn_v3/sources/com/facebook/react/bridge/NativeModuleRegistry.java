package com.facebook.react.bridge;

import com.facebook.react.uimanager.UIManagerModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import s6.a;

public class NativeModuleRegistry {
    private final String TAG = NativeModuleRegistry.class.getSimpleName();
    private final Map<String, ModuleHolder> mModules;
    private final ReactApplicationContext mReactApplicationContext;

    public NativeModuleRegistry(ReactApplicationContext reactApplicationContext, Map<String, ModuleHolder> map) {
        this.mReactApplicationContext = reactApplicationContext;
        this.mModules = map;
    }

    private Map<String, ModuleHolder> getModuleMap() {
        return this.mModules;
    }

    private ReactApplicationContext getReactApplicationContext() {
        return this.mReactApplicationContext;
    }

    public List<NativeModule> getAllModules() {
        ArrayList arrayList = new ArrayList();
        for (ModuleHolder module : this.mModules.values()) {
            arrayList.add(module.getModule());
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public Collection<ModuleHolder> getCxxModules() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.mModules.entrySet()) {
            if (((ModuleHolder) next.getValue()).isCxxModule()) {
                arrayList.add((ModuleHolder) next.getValue());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public Collection<JavaModuleWrapper> getJavaModules(JSInstance jSInstance) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.mModules.entrySet()) {
            if (!((ModuleHolder) next.getValue()).isCxxModule()) {
                arrayList.add(new JavaModuleWrapper(jSInstance, (ModuleHolder) next.getValue()));
            }
        }
        return arrayList;
    }

    public <T extends NativeModule> T getModule(Class<T> cls) {
        a aVar = (a) cls.getAnnotation(a.class);
        if (aVar != null) {
            return ((ModuleHolder) p5.a.d(this.mModules.get(aVar.name()), aVar.name() + " could not be found. Is it defined in " + cls.getName())).getModule();
        }
        throw new IllegalArgumentException("Could not find @ReactModule annotation in class " + cls.getName());
    }

    public <T extends NativeModule> boolean hasModule(Class<T> cls) {
        return this.mModules.containsKey(((a) cls.getAnnotation(a.class)).name());
    }

    /* access modifiers changed from: package-private */
    public void notifyJSInstanceDestroy() {
        this.mReactApplicationContext.assertOnNativeModulesQueueThread();
        c8.a.c(0, "NativeModuleRegistry_notifyJSInstanceDestroy");
        try {
            for (ModuleHolder destroy : this.mModules.values()) {
                destroy.destroy();
            }
        } finally {
            c8.a.g(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyJSInstanceInitialized() {
        this.mReactApplicationContext.assertOnNativeModulesQueueThread("From version React Native v0.44, native modules are explicitly not initialized on the UI thread.");
        ReactMarker.logMarker(ReactMarkerConstants.NATIVE_MODULE_INITIALIZE_START);
        c8.a.c(0, "NativeModuleRegistry_notifyJSInstanceInitialized");
        try {
            for (ModuleHolder markInitializable : this.mModules.values()) {
                markInitializable.markInitializable();
            }
        } finally {
            c8.a.g(0);
            ReactMarker.logMarker(ReactMarkerConstants.NATIVE_MODULE_INITIALIZE_END);
        }
    }

    public void onBatchComplete() {
        ModuleHolder moduleHolder = this.mModules.get(UIManagerModule.NAME);
        if (moduleHolder != null && moduleHolder.hasInstance()) {
            ((OnBatchCompleteListener) moduleHolder.getModule()).onBatchComplete();
        }
    }

    /* access modifiers changed from: package-private */
    public void registerModules(NativeModuleRegistry nativeModuleRegistry) {
        p5.a.b(this.mReactApplicationContext.equals(nativeModuleRegistry.getReactApplicationContext()), "Extending native modules with non-matching application contexts.");
        for (Map.Entry next : nativeModuleRegistry.getModuleMap().entrySet()) {
            String str = (String) next.getKey();
            if (!this.mModules.containsKey(str)) {
                this.mModules.put(str, (ModuleHolder) next.getValue());
            }
        }
    }

    public boolean hasModule(String str) {
        return this.mModules.containsKey(str);
    }

    public NativeModule getModule(String str) {
        return ((ModuleHolder) p5.a.d(this.mModules.get(str), "Could not find module with name " + str)).getModule();
    }
}
