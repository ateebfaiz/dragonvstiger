package com.facebook.react.devsupport;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.google.android.games.paddleboat.GameControllerManager;

class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final WindowManager f3045a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ReactContext f3046b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f3047c;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f3048a;

        a(boolean z10) {
            this.f3048a = z10;
        }

        public void run() {
            if (!this.f3048a || c.this.f3047c != null) {
                if (!this.f3048a && c.this.f3047c != null) {
                    c.this.f3047c.removeAllViews();
                    c.this.f3045a.removeView(c.this.f3047c);
                    c.this.f3047c = null;
                }
            } else if (!c.g(c.this.f3046b)) {
                z2.a.b("ReactNative", "Wait for overlay permission to be set");
            } else {
                c.this.f3047c = new FpsView(c.this.f3046b);
                c.this.f3045a.addView(c.this.f3047c, new WindowManager.LayoutParams(-1, -1, e1.f3073b, 24, -3));
            }
        }
    }

    public c(ReactContext reactContext) {
        this.f3046b = reactContext;
        this.f3045a = (WindowManager) reactContext.getSystemService("window");
    }

    private static boolean f(Context context, Intent intent) {
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean g(Context context) {
        return Settings.canDrawOverlays(context);
    }

    public static void h(Context context) {
        if (!Settings.canDrawOverlays(context)) {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getPackageName()));
            intent.setFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
            z2.a.G("ReactNative", "Overlay permissions needs to be granted in order for react native apps to run in dev mode");
            if (f(context, intent)) {
                context.startActivity(intent);
            }
        }
    }

    public void i(boolean z10) {
        UiThreadUtil.runOnUiThread(new a(z10));
    }
}
