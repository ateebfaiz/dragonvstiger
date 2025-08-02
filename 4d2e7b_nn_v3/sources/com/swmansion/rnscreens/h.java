package com.swmansion.rnscreens;

import com.alibaba.pdns.model.DomainUhfReportModel;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.v0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class h extends v0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f11644a = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public static final Map f() {
        HashMap hashMap = new HashMap();
        hashMap.put("RNSModule", new ReactModuleInfo("RNSModule", "RNSModule", false, false, true, false, false));
        return hashMap;
    }

    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        m.f(reactApplicationContext, "reactContext");
        return r.o(new ScreenContainerViewManager(), new ScreenViewManager(), new ModalScreenViewManager(), new ScreenStackViewManager(), new ScreenStackHeaderConfigViewManager(), new ScreenStackHeaderSubviewManager(), new SearchBarManager());
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        m.f(str, DomainUhfReportModel.SCENE);
        m.f(reactApplicationContext, "reactApplicationContext");
        if (m.b(str, "RNSModule")) {
            return new ScreensModule(reactApplicationContext);
        }
        return null;
    }

    public t6.a getReactModuleInfoProvider() {
        return new g();
    }
}
