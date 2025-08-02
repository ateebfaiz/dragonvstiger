package com.facebook.react.runtime;

import com.facebook.fbreact.specs.NativeDevSettingsSpec;
import com.facebook.fbreact.specs.NativeDeviceEventManagerSpec;
import com.facebook.fbreact.specs.NativeDeviceInfoSpec;
import com.facebook.fbreact.specs.NativeExceptionsManagerSpec;
import com.facebook.fbreact.specs.NativePlatformConstantsAndroidSpec;
import com.facebook.fbreact.specs.NativeSourceCodeSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.LogBoxModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.debug.DevSettingsModule;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import com.facebook.react.v0;
import java.util.HashMap;
import java.util.Map;
import k6.e;
import t6.a;
import w6.b;

class f extends v0 {

    /* renamed from: a  reason: collision with root package name */
    private final e f3459a;

    /* renamed from: b  reason: collision with root package name */
    private final b f3460b;

    public f(e eVar, b bVar) {
        this.f3459a = eVar;
        this.f3460b = bVar;
    }

    private a f() {
        Class[] clsArr = {AndroidInfoModule.class, DeviceInfoModule.class, SourceCodeModule.class, DevSettingsModule.class, DeviceEventManagerModule.class, LogBoxModule.class, ExceptionsManagerModule.class};
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < 7; i10++) {
            Class cls = clsArr[i10];
            s6.a aVar = (s6.a) cls.getAnnotation(s6.a.class);
            if (aVar != null) {
                hashMap.put(aVar.name(), new ReactModuleInfo(aVar.name(), cls.getName(), aVar.canOverrideExistingModule(), aVar.needsEagerInit(), aVar.isCxxModule(), ReactModuleInfo.b(cls)));
            }
        }
        return new e(hashMap);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Map g(Map map) {
        return map;
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
            case -1633589448:
                if (str.equals(NativeDevSettingsSpec.NAME)) {
                    c10 = 1;
                    break;
                }
                break;
            case -1520650172:
                if (str.equals(NativeDeviceInfoSpec.NAME)) {
                    c10 = 2;
                    break;
                }
                break;
            case -1037217463:
                if (str.equals(NativeDeviceEventManagerSpec.NAME)) {
                    c10 = 3;
                    break;
                }
                break;
            case -790603268:
                if (str.equals(NativePlatformConstantsAndroidSpec.NAME)) {
                    c10 = 4;
                    break;
                }
                break;
            case 512434409:
                if (str.equals(NativeExceptionsManagerSpec.NAME)) {
                    c10 = 5;
                    break;
                }
                break;
            case 881516744:
                if (str.equals(NativeSourceCodeSpec.NAME)) {
                    c10 = 6;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return new LogBoxModule(reactApplicationContext, this.f3459a);
            case 1:
                return new DevSettingsModule(reactApplicationContext, this.f3459a);
            case 2:
                return new DeviceInfoModule(reactApplicationContext);
            case 3:
                return new DeviceEventManagerModule(reactApplicationContext, this.f3460b);
            case 4:
                return new AndroidInfoModule(reactApplicationContext);
            case 5:
                return new ExceptionsManagerModule(this.f3459a);
            case 6:
                return new SourceCodeModule(reactApplicationContext);
            default:
                return null;
        }
    }

    public a getReactModuleInfoProvider() {
        Class<f> cls = f.class;
        if (!e6.a.a()) {
            return f();
        }
        try {
            return (a) ((Class) p5.a.c(e6.a.b(cls.getName() + "$$ReactModuleInfoProvider"))).newInstance();
        } catch (ClassNotFoundException unused) {
            return f();
        } catch (InstantiationException e10) {
            throw new RuntimeException("No ReactModuleInfoProvider for " + cls.getName() + "$$ReactModuleInfoProvider", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("No ReactModuleInfoProvider for " + cls.getName() + "$$ReactModuleInfoProvider", e11);
        }
    }
}
