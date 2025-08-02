package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.HashMap;
import java.util.Map;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private final ReactApplicationContext f20810a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f20811b = new HashMap();

    public j(ReactApplicationContext reactApplicationContext, g0 g0Var) {
        this.f20810a = reactApplicationContext;
    }

    public NativeModuleRegistry a() {
        return new NativeModuleRegistry(this.f20810a, this.f20811b);
    }

    public void b(m0 m0Var) {
        Iterable<ModuleHolder> iterable;
        if (m0Var instanceof b) {
            iterable = ((b) m0Var).getNativeModuleIterator(this.f20810a);
        } else {
            iterable = o0.b(m0Var, this.f20810a);
        }
        for (ModuleHolder next : iterable) {
            String name = next.getName();
            if (this.f20811b.containsKey(name)) {
                ModuleHolder moduleHolder = (ModuleHolder) this.f20811b.get(name);
                if (next.getCanOverrideExistingModule()) {
                    this.f20811b.remove(moduleHolder);
                } else {
                    throw new IllegalStateException("Native module " + name + " tried to override " + moduleHolder.getClassName() + ". Check the getPackages() method in MainApplication.java, it might be that module is being created twice. If this was your intention, set canOverrideExistingModule=true. This error may also be present if the package is present only once in getPackages() but is also automatically added later during build time by autolinking. Try removing the existing entry and rebuild.");
                }
            }
            this.f20811b.put(name, next);
        }
    }
}
