package com.facebook.react.modules.toast;

import android.widget.Toast;
import b7.b;
import b7.c;
import com.facebook.fbreact.specs.NativeToastAndroidSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.t;

@s6.a(name = "ToastAndroid")
public final class ToastModule extends NativeToastAndroidSpec {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final String DURATION_LONG_KEY = "LONG";
    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String GRAVITY_BOTTOM_KEY = "BOTTOM";
    private static final String GRAVITY_CENTER = "CENTER";
    private static final String GRAVITY_TOP_KEY = "TOP";
    public static final String NAME = "ToastAndroid";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToastModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        m.f(reactApplicationContext, "reactContext");
    }

    /* access modifiers changed from: private */
    public static final void show$lambda$0(ToastModule toastModule, String str, int i10) {
        m.f(toastModule, "this$0");
        Toast.makeText(toastModule.getReactApplicationContext(), str, i10).show();
    }

    /* access modifiers changed from: private */
    public static final void showWithGravity$lambda$1(ToastModule toastModule, String str, int i10, int i11) {
        m.f(toastModule, "this$0");
        Toast makeText = Toast.makeText(toastModule.getReactApplicationContext(), str, i10);
        makeText.setGravity(i11, 0, 0);
        makeText.show();
    }

    /* access modifiers changed from: private */
    public static final void showWithGravityAndOffset$lambda$2(ToastModule toastModule, String str, int i10, int i11, int i12, int i13) {
        m.f(toastModule, "this$0");
        Toast makeText = Toast.makeText(toastModule.getReactApplicationContext(), str, i10);
        makeText.setGravity(i11, i12, i13);
        makeText.show();
    }

    public Map<String, Object> getTypedExportedConstants() {
        return i0.j(t.a(DURATION_SHORT_KEY, 0), t.a(DURATION_LONG_KEY, 1), t.a(GRAVITY_TOP_KEY, 49), t.a(GRAVITY_BOTTOM_KEY, 81), t.a(GRAVITY_CENTER, 17));
    }

    public void show(String str, double d10) {
        UiThreadUtil.runOnUiThread(new c(this, str, (int) d10));
    }

    public void showWithGravity(String str, double d10, double d11) {
        UiThreadUtil.runOnUiThread(new b(this, str, (int) d10, (int) d11));
    }

    public void showWithGravityAndOffset(String str, double d10, double d11, double d12, double d13) {
        int i10 = (int) d11;
        UiThreadUtil.runOnUiThread(new b7.a(this, str, (int) d10, i10, (int) d12, (int) d13));
    }
}
