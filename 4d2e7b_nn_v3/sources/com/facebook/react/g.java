package com.facebook.react;

import com.facebook.fbreact.specs.NativeJSCHeapCaptureSpec;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.JSCHeapCapture;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.debuggingoverlay.DebuggingOverlayManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;
import t6.a;

public class g extends v0 implements w0 {

    /* renamed from: a  reason: collision with root package name */
    private Map f20763a;

    private static void f(Map map, String str, Provider provider) {
        map.put(str, ModuleSpec.viewManagerSpec(provider));
    }

    private a g() {
        HashMap hashMap = new HashMap();
        Class cls = new Class[]{JSCHeapCapture.class}[0];
        s6.a aVar = (s6.a) cls.getAnnotation(s6.a.class);
        hashMap.put(aVar.name(), new ReactModuleInfo(aVar.name(), cls.getName(), aVar.canOverrideExistingModule(), aVar.needsEagerInit(), aVar.isCxxModule(), ReactModuleInfo.b(cls)));
        return new f(hashMap);
    }

    private Map h() {
        if (this.f20763a == null) {
            HashMap hashMap = new HashMap();
            f(hashMap, DebuggingOverlayManager.REACT_CLASS, new e());
            this.f20763a = hashMap;
        }
        return this.f20763a;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Map i(Map map) {
        return map;
    }

    public ViewManager createViewManager(ReactApplicationContext reactApplicationContext, String str) {
        ModuleSpec moduleSpec = (ModuleSpec) h().get(str);
        if (moduleSpec != null) {
            return (ViewManager) moduleSpec.getProvider().get();
        }
        return null;
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        str.hashCode();
        if (!str.equals(NativeJSCHeapCaptureSpec.NAME)) {
            return null;
        }
        return new JSCHeapCapture(reactApplicationContext);
    }

    public a getReactModuleInfoProvider() {
        if (!e6.a.a()) {
            return g();
        }
        try {
            return (a) e6.a.b("com.facebook.react.DebugCorePackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            return g();
        } catch (InstantiationException e10) {
            throw new RuntimeException("No ReactModuleInfoProvider for DebugCorePackage$$ReactModuleInfoProvider", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("No ReactModuleInfoProvider for DebugCorePackage$$ReactModuleInfoProvider", e11);
        }
    }

    public Collection getViewManagerNames(ReactApplicationContext reactApplicationContext) {
        return h().keySet();
    }

    public List getViewManagers(ReactApplicationContext reactApplicationContext) {
        return new ArrayList(h().values());
    }
}
