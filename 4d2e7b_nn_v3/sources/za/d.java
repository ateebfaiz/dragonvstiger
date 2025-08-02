package za;

import com.facebook.react.b;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.w0;
import com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootViewManager;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.t;

public final class d extends b implements w0 {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f13463a = i.b(a.f13464a);

    static final class a extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f13464a = new a();

        a() {
            super(0);
        }

        /* access modifiers changed from: private */
        public static final NativeModule d() {
            return new RNGestureHandlerRootViewManager();
        }

        /* access modifiers changed from: private */
        public static final NativeModule f() {
            return new RNGestureHandlerButtonViewManager();
        }

        /* renamed from: c */
        public final Map invoke() {
            return i0.i(t.a(RNGestureHandlerRootViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new b())), t.a(RNGestureHandlerButtonViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new c())));
        }
    }

    /* access modifiers changed from: private */
    public static final Map f() {
        Class<RNGestureHandlerModule> cls = RNGestureHandlerModule.class;
        Annotation annotation = cls.getAnnotation(s6.a.class);
        m.c(annotation);
        s6.a aVar = (s6.a) annotation;
        String name = aVar.name();
        String name2 = cls.getName();
        m.e(name2, "getName(...)");
        return i0.j(t.a("RNGestureHandlerModule", new ReactModuleInfo(name, name2, aVar.canOverrideExistingModule(), aVar.needsEagerInit(), aVar.isCxxModule(), true)));
    }

    private final Map g() {
        return (Map) this.f13463a.getValue();
    }

    public ViewManager createViewManager(ReactApplicationContext reactApplicationContext, String str) {
        NativeModule nativeModule;
        Provider provider;
        ModuleSpec moduleSpec = (ModuleSpec) g().get(str);
        if (moduleSpec == null || (provider = moduleSpec.getProvider()) == null) {
            nativeModule = null;
        } else {
            nativeModule = (NativeModule) provider.get();
        }
        if (nativeModule instanceof ViewManager) {
            return (ViewManager) nativeModule;
        }
        return null;
    }

    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        m.f(reactApplicationContext, "reactContext");
        return r.o(new RNGestureHandlerRootViewManager(), new RNGestureHandlerButtonViewManager());
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        m.f(str, "name");
        m.f(reactApplicationContext, "reactContext");
        if (m.b(str, "RNGestureHandlerModule")) {
            return new RNGestureHandlerModule(reactApplicationContext);
        }
        return null;
    }

    public t6.a getReactModuleInfoProvider() {
        try {
            Object newInstance = Class.forName("com.swmansion.gesturehandler.RNGestureHandlerPackage$$ReactModuleInfoProvider").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            m.d(newInstance, "null cannot be cast to non-null type com.facebook.react.module.model.ReactModuleInfoProvider");
            return (t6.a) newInstance;
        } catch (ClassNotFoundException unused) {
            return new a();
        } catch (InstantiationException e10) {
            throw new RuntimeException("No ReactModuleInfoProvider for RNGestureHandlerPackage$$ReactModuleInfoProvider", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("No ReactModuleInfoProvider for RNGestureHandlerPackage$$ReactModuleInfoProvider", e11);
        }
    }

    /* access modifiers changed from: protected */
    public List getViewManagers(ReactApplicationContext reactApplicationContext) {
        return r.y0(g().values());
    }

    public List getViewManagerNames(ReactApplicationContext reactApplicationContext) {
        return r.w0(g().keySet());
    }
}
