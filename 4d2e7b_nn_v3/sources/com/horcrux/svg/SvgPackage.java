package com.horcrux.svg;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.w0;
import com.horcrux.svg.RenderableViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;

public class SvgPackage extends com.facebook.react.b implements w0 {
    @Nullable
    private Map<String, ModuleSpec> mViewManagers;

    class a implements Provider {
        a() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.ImageViewManager();
        }
    }

    class a0 implements Provider {
        a0() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.RectViewManager();
        }
    }

    class b implements Provider {
        b() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.ClipPathViewManager();
        }
    }

    class b0 implements Provider {
        b0() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.TextViewManager();
        }
    }

    class c implements Provider {
        c() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.DefsViewManager();
        }
    }

    class c0 implements Provider {
        c0() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.TSpanViewManager();
        }
    }

    class d implements Provider {
        d() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.UseViewManager();
        }
    }

    class d0 implements Provider {
        d0() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.TextPathViewManager();
        }
    }

    class e implements Provider {
        e() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.SymbolManager();
        }
    }

    class f implements Provider {
        f() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.LinearGradientManager();
        }
    }

    class g implements Provider {
        g() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.RadialGradientManager();
        }
    }

    class h implements Provider {
        h() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.PatternManager();
        }
    }

    class i implements Provider {
        i() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.MaskManager();
        }
    }

    class j implements Provider {
        j() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.FilterManager();
        }
    }

    class k implements Provider {
        k() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.GroupViewManager();
        }
    }

    class l implements Provider {
        l() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.FeBlendManager();
        }
    }

    class m implements Provider {
        m() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.FeColorMatrixManager();
        }
    }

    class n implements Provider {
        n() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.FeCompositeManager();
        }
    }

    class o implements Provider {
        o() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.FeFloodManager();
        }
    }

    class p implements Provider {
        p() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.FeGaussianBlurManager();
        }
    }

    class q implements Provider {
        q() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.FeMergeManager();
        }
    }

    class r implements Provider {
        r() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.FeOffsetManager();
        }
    }

    class s implements Provider {
        s() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.ForeignObjectManager();
        }
    }

    class t implements Provider {
        t() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.MarkerManager();
        }
    }

    class u implements Provider {
        u() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new SvgViewManager();
        }
    }

    class v implements Provider {
        v() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.PathViewManager();
        }
    }

    class w implements t6.a {
        w() {
        }

        public Map a() {
            HashMap hashMap = new HashMap();
            Class[] clsArr = {SvgViewModule.class, RNSVGRenderableManager.class};
            for (int i10 = 0; i10 < 2; i10++) {
                Class cls = clsArr[i10];
                s6.a aVar = (s6.a) cls.getAnnotation(s6.a.class);
                hashMap.put(aVar.name(), new ReactModuleInfo(aVar.name(), cls.getName(), aVar.canOverrideExistingModule(), aVar.needsEagerInit(), aVar.isCxxModule(), true));
            }
            return hashMap;
        }
    }

    class x implements Provider {
        x() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.CircleViewManager();
        }
    }

    class y implements Provider {
        y() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.EllipseViewManager();
        }
    }

    class z implements Provider {
        z() {
        }

        /* renamed from: a */
        public NativeModule get() {
            return new RenderableViewManager.LineViewManager();
        }
    }

    private Map<String, ModuleSpec> getViewManagersMap(ReactApplicationContext reactApplicationContext) {
        if (this.mViewManagers == null) {
            HashMap b10 = e6.f.b();
            b10.put(RenderableViewManager.GroupViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new k()));
            b10.put(RenderableViewManager.PathViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new v()));
            b10.put(RenderableViewManager.CircleViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new x()));
            b10.put(RenderableViewManager.EllipseViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new y()));
            b10.put(RenderableViewManager.LineViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new z()));
            b10.put(RenderableViewManager.RectViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new a0()));
            b10.put(RenderableViewManager.TextViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new b0()));
            b10.put(RenderableViewManager.TSpanViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new c0()));
            b10.put(RenderableViewManager.TextPathViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new d0()));
            b10.put(RenderableViewManager.ImageViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new a()));
            b10.put(RenderableViewManager.ClipPathViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new b()));
            b10.put(RenderableViewManager.DefsViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new c()));
            b10.put(RenderableViewManager.UseViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new d()));
            b10.put(RenderableViewManager.SymbolManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new e()));
            b10.put(RenderableViewManager.LinearGradientManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new f()));
            b10.put(RenderableViewManager.RadialGradientManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new g()));
            b10.put(RenderableViewManager.PatternManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new h()));
            b10.put(RenderableViewManager.MaskManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new i()));
            b10.put(RenderableViewManager.FilterManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new j()));
            b10.put(RenderableViewManager.FeBlendManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new l()));
            b10.put(RenderableViewManager.FeColorMatrixManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new m()));
            b10.put(RenderableViewManager.FeCompositeManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new n()));
            b10.put(RenderableViewManager.FeFloodManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new o()));
            b10.put(RenderableViewManager.FeGaussianBlurManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new p()));
            b10.put(RenderableViewManager.FeMergeManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new q()));
            b10.put(RenderableViewManager.FeOffsetManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new r()));
            b10.put(RenderableViewManager.ForeignObjectManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new s()));
            b10.put(RenderableViewManager.MarkerManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new t()));
            b10.put(SvgViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new u()));
            this.mViewManagers = b10;
        }
        return this.mViewManagers;
    }

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Nullable
    public ViewManager createViewManager(ReactApplicationContext reactApplicationContext, String str) {
        ModuleSpec moduleSpec = getViewManagersMap(reactApplicationContext).get(str);
        if (moduleSpec != null) {
            return (ViewManager) moduleSpec.getProvider().get();
        }
        return null;
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        str.hashCode();
        if (str.equals("RNSVGRenderableModule")) {
            return new RNSVGRenderableManager(reactApplicationContext);
        }
        if (!str.equals("RNSVGSvgViewModule")) {
            return null;
        }
        return new SvgViewModule(reactApplicationContext);
    }

    public t6.a getReactModuleInfoProvider() {
        try {
            return (t6.a) Class.forName("com.horcrux.svg.SvgPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            return new w();
        } catch (IllegalAccessException | InstantiationException e10) {
            throw new RuntimeException("No ReactModuleInfoProvider for MyPackage$$ReactModuleInfoProvider", e10);
        }
    }

    /* access modifiers changed from: protected */
    public List<ModuleSpec> getViewManagers(ReactApplicationContext reactApplicationContext) {
        return new ArrayList(getViewManagersMap(reactApplicationContext).values());
    }

    public List<String> getViewManagerNames(ReactApplicationContext reactApplicationContext) {
        return new ArrayList(getViewManagersMap(reactApplicationContext).keySet());
    }
}
