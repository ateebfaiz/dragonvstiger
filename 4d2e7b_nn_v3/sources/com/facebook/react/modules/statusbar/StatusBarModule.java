package com.facebook.react.modules.statusbar;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.alibaba.pdns.model.DomainUhfReportModel;
import com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.g0;
import java.util.Arrays;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.t;

@s6.a(name = "StatusBarManager")
public final class StatusBarModule extends NativeStatusBarManagerAndroidSpec {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final String DEFAULT_BACKGROUND_COLOR_KEY = "DEFAULT_BACKGROUND_COLOR";
    private static final String HEIGHT_KEY = "HEIGHT";
    public static final String NAME = "StatusBarManager";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b extends GuardedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f3349a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f3350b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f3351c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Activity activity, boolean z10, int i10, ReactApplicationContext reactApplicationContext) {
            super((ReactContext) reactApplicationContext);
            this.f3349a = activity;
            this.f3350b = z10;
            this.f3351c = i10;
        }

        /* access modifiers changed from: private */
        public static final void b(Activity activity, ValueAnimator valueAnimator) {
            m.f(valueAnimator, "animator");
            Window window = activity.getWindow();
            if (window != null) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                m.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                window.setStatusBarColor(((Integer) animatedValue).intValue());
            }
        }

        public void runGuarded() {
            Window window = this.f3349a.getWindow();
            if (window != null) {
                window.addFlags(Integer.MIN_VALUE);
                if (this.f3350b) {
                    int statusBarColor = window.getStatusBarColor();
                    ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(statusBarColor), Integer.valueOf(this.f3351c)});
                    ofObject.addUpdateListener(new c(this.f3349a));
                    ofObject.setDuration(300).setStartDelay(0);
                    ofObject.start();
                    return;
                }
                window.setStatusBarColor(this.f3351c);
            }
        }
    }

    public static final class c extends GuardedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f3352a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f3353b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Activity activity, boolean z10, ReactApplicationContext reactApplicationContext) {
            super((ReactContext) reactApplicationContext);
            this.f3352a = activity;
            this.f3353b = z10;
        }

        /* access modifiers changed from: private */
        public static final WindowInsets b(View view, WindowInsets windowInsets) {
            m.f(view, DomainUhfReportModel.ENCRYPTYPE);
            m.f(windowInsets, "insets");
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            return onApplyWindowInsets.replaceSystemWindowInsets(onApplyWindowInsets.getSystemWindowInsetLeft(), 0, onApplyWindowInsets.getSystemWindowInsetRight(), onApplyWindowInsets.getSystemWindowInsetBottom());
        }

        public void runGuarded() {
            Window window = this.f3352a.getWindow();
            if (window != null) {
                View decorView = window.getDecorView();
                m.e(decorView, "getDecorView(...)");
                if (this.f3353b) {
                    decorView.setOnApplyWindowInsetsListener(new d());
                } else {
                    decorView.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
                }
                ViewCompat.requestApplyInsets(decorView);
            }
        }
    }

    public StatusBarModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private final float getStatusBarHeightPx() {
        Window window;
        View decorView;
        WindowInsetsCompat rootWindowInsets;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null || (decorView = window.getDecorView()) == null || (rootWindowInsets = ViewCompat.getRootWindowInsets(decorView)) == null) {
            return 0.0f;
        }
        return (float) rootWindowInsets.getInsets(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.navigationBars() | WindowInsetsCompat.Type.displayCutout()).top;
    }

    /* access modifiers changed from: private */
    public static final void setHidden$lambda$1(Activity activity, boolean z10) {
        Window window = activity.getWindow();
        if (window != null) {
            if (z10) {
                window.addFlags(1024);
                window.clearFlags(2048);
                return;
            }
            window.addFlags(2048);
            window.clearFlags(1024);
        }
    }

    /* access modifiers changed from: private */
    public static final void setStyle$lambda$2(Activity activity, String str) {
        int i10;
        Window window = activity.getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT > 30) {
                WindowInsetsController a10 = window.getInsetsController();
                if (a10 != null) {
                    if (m.b("dark-content", str)) {
                        a10.setSystemBarsAppearance(8, 8);
                    } else {
                        a10.setSystemBarsAppearance(0, 8);
                    }
                }
            } else {
                View decorView = window.getDecorView();
                m.e(decorView, "getDecorView(...)");
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (m.b("dark-content", str)) {
                    i10 = systemUiVisibility | 8192;
                } else {
                    i10 = systemUiVisibility & -8193;
                }
                decorView.setSystemUiVisibility(i10);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getTypedExportedConstants() {
        String str;
        Window window;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null) {
            str = "black";
        } else {
            int statusBarColor = window.getStatusBarColor();
            b0 b0Var = b0.f709a;
            str = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(statusBarColor & ViewCompat.MEASURED_SIZE_MASK)}, 1));
            m.e(str, "format(...)");
        }
        return i0.i(t.a(HEIGHT_KEY, Float.valueOf(g0.b(getStatusBarHeightPx()))), t.a(DEFAULT_BACKGROUND_COLOR_KEY, str));
    }

    public void setColor(double d10, boolean z10) {
        int i10 = (int) d10;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            z2.a.G("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new b(currentActivity, z10, i10, getReactApplicationContext()));
        }
    }

    public void setHidden(boolean z10) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            z2.a.G("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new a(currentActivity, z10));
        }
    }

    public void setStyle(String str) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            z2.a.G("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new b(currentActivity, str));
        }
    }

    public void setTranslucent(boolean z10) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            z2.a.G("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new c(currentActivity, z10, getReactApplicationContext()));
        }
    }
}
