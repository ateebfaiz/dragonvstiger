package com.facebook.react.modules.devloading;

import com.facebook.fbreact.specs.NativeDevLoadingViewSpec;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.a0;
import k6.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import y6.b;

@s6.a(name = "DevLoadingView")
public final class DevLoadingModule extends NativeDevLoadingViewSpec {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String NAME = "DevLoadingView";
    private c devLoadingViewManager;
    private final JSExceptionHandler jsExceptionHandler;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DevLoadingModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        m.f(reactApplicationContext, "reactContext");
        JSExceptionHandler jSExceptionHandler = reactApplicationContext.getJSExceptionHandler();
        this.jsExceptionHandler = jSExceptionHandler;
        if (jSExceptionHandler != null && (jSExceptionHandler instanceof a0)) {
            this.devLoadingViewManager = ((a0) jSExceptionHandler).j0();
        }
    }

    /* access modifiers changed from: private */
    public static final void hide$lambda$1(DevLoadingModule devLoadingModule) {
        m.f(devLoadingModule, "this$0");
        c cVar = devLoadingModule.devLoadingViewManager;
        if (cVar != null) {
            cVar.a();
        }
    }

    /* access modifiers changed from: private */
    public static final void showMessage$lambda$0(DevLoadingModule devLoadingModule, String str) {
        m.f(devLoadingModule, "this$0");
        m.f(str, "$message");
        c cVar = devLoadingModule.devLoadingViewManager;
        if (cVar != null) {
            cVar.b(str);
        }
    }

    public void hide() {
        UiThreadUtil.runOnUiThread(new y6.a(this));
    }

    public void showMessage(String str, Double d10, Double d11) {
        m.f(str, "message");
        UiThreadUtil.runOnUiThread(new b(this, str));
    }
}
