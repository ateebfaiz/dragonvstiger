package com.facebook.react.modules.i18nmanager;

import android.os.Build;
import com.facebook.fbreact.specs.NativeI18nManagerSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.i18nmanager.a;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.m;
import kotlin.t;
import s6.a;

@a(name = "I18nManager")
public final class I18nManagerModule extends NativeI18nManagerSpec {
    public I18nManagerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void allowRTL(boolean z10) {
        a a10 = a.f3290a.a();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        a10.b(reactApplicationContext, z10);
    }

    public void forceRTL(boolean z10) {
        a a10 = a.f3290a.a();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        a10.e(reactApplicationContext, z10);
    }

    public Map<String, Object> getTypedExportedConstants() {
        Locale locale;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (Build.VERSION.SDK_INT >= 24) {
            locale = reactApplicationContext.getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = reactApplicationContext.getResources().getConfiguration().locale;
        }
        a.C0053a aVar = a.f3290a;
        a a10 = aVar.a();
        m.c(reactApplicationContext);
        return i0.i(t.a("isRTL", Boolean.valueOf(a10.i(reactApplicationContext))), t.a("doLeftAndRightSwapInRTL", Boolean.valueOf(aVar.a().d(reactApplicationContext))), t.a("localeIdentifier", locale.toString()));
    }

    public void swapLeftAndRightInRTL(boolean z10) {
        a a10 = a.f3290a.a();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        a10.m(reactApplicationContext, z10);
    }
}
