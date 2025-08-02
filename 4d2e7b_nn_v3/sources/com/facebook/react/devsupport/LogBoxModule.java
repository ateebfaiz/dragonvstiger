package com.facebook.react.devsupport;

import com.facebook.fbreact.specs.NativeLogBoxSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import e6.i;
import k6.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@s6.a(name = "LogBox")
public final class LogBoxModule extends NativeLogBoxSpec {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String NAME = "LogBox";
    private final e devSupportManager;
    private final i surfaceDelegate;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LogBoxModule(ReactApplicationContext reactApplicationContext, e eVar) {
        super(reactApplicationContext);
        m.f(eVar, "devSupportManager");
        this.devSupportManager = eVar;
        i c10 = eVar.c("LogBox");
        this.surfaceDelegate = c10 == null ? new l0(eVar) : c10;
        UiThreadUtil.runOnUiThread(new n0(this));
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(LogBoxModule logBoxModule) {
        m.f(logBoxModule, "this$0");
        logBoxModule.surfaceDelegate.d("LogBox");
    }

    /* access modifiers changed from: private */
    public static final void hide$lambda$2(LogBoxModule logBoxModule) {
        m.f(logBoxModule, "this$0");
        logBoxModule.surfaceDelegate.a();
    }

    /* access modifiers changed from: private */
    public static final void invalidate$lambda$3(LogBoxModule logBoxModule) {
        m.f(logBoxModule, "this$0");
        logBoxModule.surfaceDelegate.c();
    }

    /* access modifiers changed from: private */
    public static final void show$lambda$1(LogBoxModule logBoxModule) {
        m.f(logBoxModule, "this$0");
        logBoxModule.surfaceDelegate.show();
    }

    public void hide() {
        UiThreadUtil.runOnUiThread(new m0(this));
    }

    public void invalidate() {
        UiThreadUtil.runOnUiThread(new o0(this));
    }

    public void show() {
        if (this.surfaceDelegate.b()) {
            UiThreadUtil.runOnUiThread(new p0(this));
        }
    }
}
