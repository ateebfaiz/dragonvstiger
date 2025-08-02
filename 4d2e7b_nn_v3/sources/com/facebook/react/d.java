package com.facebook.react;

import com.facebook.fbreact.specs.NativeDevSettingsSpec;
import com.facebook.fbreact.specs.NativeDeviceEventManagerSpec;
import com.facebook.fbreact.specs.NativeDeviceInfoSpec;
import com.facebook.fbreact.specs.NativeExceptionsManagerSpec;
import com.facebook.fbreact.specs.NativeHeadlessJsTaskSupportSpec;
import com.facebook.fbreact.specs.NativePlatformConstantsAndroidSpec;
import com.facebook.fbreact.specs.NativeSourceCodeSpec;
import com.facebook.fbreact.specs.NativeTimingSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.devsupport.LogBoxModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.core.HeadlessJsTaskSupportModule;
import com.facebook.react.modules.core.TimingModule;
import com.facebook.react.modules.debug.DevSettingsModule;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.j2;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import w6.b;

class d extends v0 implements p0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final g0 f20754a;

    /* renamed from: b  reason: collision with root package name */
    private final b f20755b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20756c;

    /* renamed from: d  reason: collision with root package name */
    private final int f20757d;

    class a implements j2 {
        a() {
        }

        public Collection a() {
            return d.this.f20754a.H();
        }

        public ViewManager b(String str) {
            return d.this.f20754a.y(str);
        }
    }

    public d(g0 g0Var, b bVar, boolean z10, int i10) {
        this.f20754a = g0Var;
        this.f20755b = bVar;
        this.f20756c = z10;
        this.f20757d = i10;
    }

    private UIManagerModule createUIManager(ReactApplicationContext reactApplicationContext) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_START);
        c8.a.c(0, "createUIManagerModule");
        try {
            if (this.f20756c) {
                return new UIManagerModule(reactApplicationContext, (j2) new a(), this.f20757d);
            }
            UIManagerModule uIManagerModule = new UIManagerModule(reactApplicationContext, (List<ViewManager>) this.f20754a.G(reactApplicationContext), this.f20757d);
            c8.a.g(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
            return uIManagerModule;
        } finally {
            c8.a.g(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
        }
    }

    private t6.a g() {
        Class[] clsArr = {AndroidInfoModule.class, DeviceEventManagerModule.class, DeviceInfoModule.class, DevSettingsModule.class, ExceptionsManagerModule.class, LogBoxModule.class, HeadlessJsTaskSupportModule.class, SourceCodeModule.class, TimingModule.class, UIManagerModule.class};
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < 10; i10++) {
            Class cls = clsArr[i10];
            s6.a aVar = (s6.a) cls.getAnnotation(s6.a.class);
            hashMap.put(aVar.name(), new ReactModuleInfo(aVar.name(), cls.getName(), aVar.canOverrideExistingModule(), aVar.needsEagerInit(), aVar.isCxxModule(), ReactModuleInfo.b(cls)));
        }
        return new c(hashMap);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Map h(Map map) {
        return map;
    }

    public void a() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_START);
    }

    public void b() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_END);
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -2013505529:
                if (str.equals("LogBox")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1789797270:
                if (str.equals(NativeTimingSpec.NAME)) {
                    c10 = 1;
                    break;
                }
                break;
            case -1633589448:
                if (str.equals(NativeDevSettingsSpec.NAME)) {
                    c10 = 2;
                    break;
                }
                break;
            case -1520650172:
                if (str.equals(NativeDeviceInfoSpec.NAME)) {
                    c10 = 3;
                    break;
                }
                break;
            case -1037217463:
                if (str.equals(NativeDeviceEventManagerSpec.NAME)) {
                    c10 = 4;
                    break;
                }
                break;
            case -790603268:
                if (str.equals(NativePlatformConstantsAndroidSpec.NAME)) {
                    c10 = 5;
                    break;
                }
                break;
            case 512434409:
                if (str.equals(NativeExceptionsManagerSpec.NAME)) {
                    c10 = 6;
                    break;
                }
                break;
            case 881516744:
                if (str.equals(NativeSourceCodeSpec.NAME)) {
                    c10 = 7;
                    break;
                }
                break;
            case 1256514152:
                if (str.equals(NativeHeadlessJsTaskSupportSpec.NAME)) {
                    c10 = 8;
                    break;
                }
                break;
            case 1861242489:
                if (str.equals(UIManagerModule.NAME)) {
                    c10 = 9;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return new LogBoxModule(reactApplicationContext, this.f20754a.D());
            case 1:
                return new TimingModule(reactApplicationContext, this.f20754a.D());
            case 2:
                return new DevSettingsModule(reactApplicationContext, this.f20754a.D());
            case 3:
                return new DeviceInfoModule(reactApplicationContext);
            case 4:
                return new DeviceEventManagerModule(reactApplicationContext, this.f20755b);
            case 5:
                return new AndroidInfoModule(reactApplicationContext);
            case 6:
                return new ExceptionsManagerModule(this.f20754a.D());
            case 7:
                return new SourceCodeModule(reactApplicationContext);
            case 8:
                return new HeadlessJsTaskSupportModule(reactApplicationContext);
            case 9:
                return createUIManager(reactApplicationContext);
            default:
                throw new IllegalArgumentException("In CoreModulesPackage, could not find Native module for " + str);
        }
    }

    public t6.a getReactModuleInfoProvider() {
        if (!e6.a.a()) {
            return g();
        }
        try {
            return (t6.a) e6.a.b("com.facebook.react.CoreModulesPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            return g();
        } catch (InstantiationException e10) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e11);
        }
    }
}
