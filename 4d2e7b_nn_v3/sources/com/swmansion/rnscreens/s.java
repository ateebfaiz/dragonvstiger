package com.swmansion.rnscreens;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.alibaba.pdns.model.DomainUhfReportModel;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.swmansion.rnscreens.Screen;
import kotlin.jvm.internal.m;
import kotlin.n;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final s f11656a = new s();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f11657b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f11658c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f11659d;

    /* renamed from: e  reason: collision with root package name */
    private static Integer f11660e;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11661a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(2:17|18)|19|21) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.swmansion.rnscreens.Screen$e[] r0 = com.swmansion.rnscreens.Screen.e.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.swmansion.rnscreens.Screen$e r1 = com.swmansion.rnscreens.Screen.e.ORIENTATION     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.swmansion.rnscreens.Screen$e r1 = com.swmansion.rnscreens.Screen.e.COLOR     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.swmansion.rnscreens.Screen$e r1 = com.swmansion.rnscreens.Screen.e.STYLE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.swmansion.rnscreens.Screen$e r1 = com.swmansion.rnscreens.Screen.e.TRANSLUCENT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.swmansion.rnscreens.Screen$e r1 = com.swmansion.rnscreens.Screen.e.HIDDEN     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.swmansion.rnscreens.Screen$e r1 = com.swmansion.rnscreens.Screen.e.ANIMATED     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.swmansion.rnscreens.Screen$e r1 = com.swmansion.rnscreens.Screen.e.NAVIGATION_BAR_COLOR     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.swmansion.rnscreens.Screen$e r1 = com.swmansion.rnscreens.Screen.e.NAVIGATION_BAR_TRANSLUCENT     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.swmansion.rnscreens.Screen$e r1 = com.swmansion.rnscreens.Screen.e.NAVIGATION_BAR_HIDDEN     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                f11661a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.s.a.<clinit>():void");
        }
    }

    public static final class b extends GuardedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f11662a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Integer f11663b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f11664c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Activity activity, Integer num, boolean z10, JSExceptionHandler jSExceptionHandler) {
            super(jSExceptionHandler);
            this.f11662a = activity;
            this.f11663b = num;
            this.f11664c = z10;
        }

        /* access modifiers changed from: private */
        public static final void b(Window window, ValueAnimator valueAnimator) {
            m.f(valueAnimator, "animator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            m.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            window.setStatusBarColor(((Integer) animatedValue).intValue());
        }

        public void runGuarded() {
            Window window = this.f11662a.getWindow();
            int statusBarColor = window.getStatusBarColor();
            ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(statusBarColor), this.f11663b});
            ofObject.addUpdateListener(new t(window));
            if (this.f11664c) {
                ofObject.setDuration(300).setStartDelay(0);
            } else {
                ofObject.setDuration(0).setStartDelay(300);
            }
            ofObject.start();
        }
    }

    public static final class c extends GuardedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f11665a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f11666b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Activity activity, boolean z10, JSExceptionHandler jSExceptionHandler) {
            super(jSExceptionHandler);
            this.f11665a = activity;
            this.f11666b = z10;
        }

        /* access modifiers changed from: private */
        public static final WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat) {
            m.f(view, DomainUhfReportModel.ENCRYPTYPE);
            m.f(windowInsetsCompat, "insets");
            WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
            m.e(onApplyWindowInsets, "onApplyWindowInsets(...)");
            if (Build.VERSION.SDK_INT < 30) {
                return onApplyWindowInsets.replaceSystemWindowInsets(onApplyWindowInsets.getSystemWindowInsetLeft(), 0, onApplyWindowInsets.getSystemWindowInsetRight(), onApplyWindowInsets.getSystemWindowInsetBottom());
            }
            Insets insets = onApplyWindowInsets.getInsets(WindowInsetsCompat.Type.statusBars());
            m.e(insets, "getInsets(...)");
            return new WindowInsetsCompat.Builder().setInsets(WindowInsetsCompat.Type.statusBars(), Insets.of(insets.left, 0, insets.right, insets.bottom)).build();
        }

        public void runGuarded() {
            View decorView = this.f11665a.getWindow().getDecorView();
            m.e(decorView, "getDecorView(...)");
            if (this.f11666b) {
                ViewCompat.setOnApplyWindowInsetsListener(decorView, new u());
            } else {
                ViewCompat.setOnApplyWindowInsetsListener(decorView, (OnApplyWindowInsetsListener) null);
            }
            ViewCompat.requestApplyInsets(decorView);
        }
    }

    private s() {
    }

    private final boolean g(Screen screen, Screen.e eVar) {
        switch (a.f11661a[eVar.ordinal()]) {
            case 1:
                if (screen.getScreenOrientation() == null) {
                    return false;
                }
                break;
            case 2:
                if (screen.getStatusBarColor() == null) {
                    return false;
                }
                break;
            case 3:
                if (screen.getStatusBarStyle() == null) {
                    return false;
                }
                break;
            case 4:
                if (screen.h() == null) {
                    return false;
                }
                break;
            case 5:
                if (screen.g() == null) {
                    return false;
                }
                break;
            case 6:
                if (screen.f() == null) {
                    return false;
                }
                break;
            case 7:
                if (screen.getNavigationBarColor() == null) {
                    return false;
                }
                break;
            case 8:
                if (screen.e() == null) {
                    return false;
                }
                break;
            case 9:
                if (screen.d() == null) {
                    return false;
                }
                break;
            default:
                throw new n();
        }
        return true;
    }

    private final Screen h(Screen screen, Screen.e eVar) {
        l fragmentWrapper;
        if (screen == null || (fragmentWrapper = screen.getFragmentWrapper()) == null) {
            return null;
        }
        for (ScreenContainer topScreen : fragmentWrapper.l()) {
            Screen topScreen2 = topScreen.getTopScreen();
            s sVar = f11656a;
            Screen h10 = sVar.h(topScreen2, eVar);
            if (h10 != null) {
                return h10;
            }
            if (topScreen2 != null && sVar.g(topScreen2, eVar)) {
                return topScreen2;
            }
        }
        return null;
    }

    private final Screen i(Screen screen, Screen.e eVar) {
        for (ViewParent container = screen.getContainer(); container != null; container = container.getParent()) {
            if (container instanceof Screen) {
                Screen screen2 = (Screen) container;
                if (g(screen2, eVar)) {
                    return screen2;
                }
            }
        }
        return null;
    }

    private final Screen j(Screen screen, Screen.e eVar) {
        Screen h10 = h(screen, eVar);
        if (h10 != null) {
            return h10;
        }
        if (g(screen, eVar)) {
            return screen;
        }
        return i(screen, eVar);
    }

    private final boolean k(int i10) {
        if (((double) 1) - ((((((double) Color.red(i10)) * 0.299d) + (((double) Color.green(i10)) * 0.587d)) + (((double) Color.blue(i10)) * 0.114d)) / ((double) 255)) < 0.5d) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final void m(boolean z10, WindowInsetsControllerCompat windowInsetsControllerCompat) {
        m.f(windowInsetsControllerCompat, "$controller");
        if (z10) {
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.statusBars());
        } else {
            windowInsetsControllerCompat.show(WindowInsetsCompat.Type.statusBars());
        }
    }

    /* access modifiers changed from: private */
    public static final void o(Window window, int i10) {
        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightNavigationBars(f11656a.k(i10));
    }

    /* access modifiers changed from: private */
    public static final void t(Activity activity, String str) {
        m.f(str, "$style");
        View decorView = activity.getWindow().getDecorView();
        m.e(decorView, "getDecorView(...)");
        new WindowInsetsControllerCompat(activity.getWindow(), decorView).setAppearanceLightStatusBars(m.b(str, "dark"));
    }

    public final void d() {
        f11659d = true;
    }

    public final void e() {
        f11657b = true;
    }

    public final void f() {
        f11658c = true;
    }

    public final void l(Screen screen, Activity activity, ReactContext reactContext) {
        Integer num;
        boolean z10;
        Boolean f10;
        m.f(screen, "screen");
        if (activity != null && reactContext != null) {
            if (f11660e == null) {
                f11660e = Integer.valueOf(activity.getWindow().getStatusBarColor());
            }
            Screen j10 = j(screen, Screen.e.COLOR);
            Screen j11 = j(screen, Screen.e.ANIMATED);
            if (j10 == null || (num = j10.getStatusBarColor()) == null) {
                num = f11660e;
            }
            if (j11 == null || (f10 = j11.f()) == null) {
                z10 = false;
            } else {
                z10 = f10.booleanValue();
            }
            UiThreadUtil.runOnUiThread(new b(activity, num, z10, reactContext.getExceptionHandler()));
        }
    }

    public final void n(Screen screen, Activity activity) {
        boolean z10;
        Boolean g10;
        m.f(screen, "screen");
        if (activity != null) {
            Screen j10 = j(screen, Screen.e.HIDDEN);
            if (j10 == null || (g10 = j10.g()) == null) {
                z10 = false;
            } else {
                z10 = g10.booleanValue();
            }
            Window window = activity.getWindow();
            UiThreadUtil.runOnUiThread(new p(z10, new WindowInsetsControllerCompat(window, window.getDecorView())));
        }
    }

    public final void p(Screen screen, Activity activity) {
        int i10;
        Integer navigationBarColor;
        m.f(screen, "screen");
        if (activity != null) {
            Window window = activity.getWindow();
            Screen j10 = j(screen, Screen.e.NAVIGATION_BAR_COLOR);
            if (j10 == null || (navigationBarColor = j10.getNavigationBarColor()) == null) {
                i10 = window.getNavigationBarColor();
            } else {
                i10 = navigationBarColor.intValue();
            }
            UiThreadUtil.runOnUiThread(new r(window, i10));
            window.setNavigationBarColor(i10);
        }
    }

    public final void q(Screen screen, Activity activity) {
        boolean z10;
        Boolean d10;
        m.f(screen, "screen");
        if (activity != null) {
            Window window = activity.getWindow();
            Screen j10 = j(screen, Screen.e.NAVIGATION_BAR_HIDDEN);
            if (j10 == null || (d10 = j10.d()) == null) {
                z10 = false;
            } else {
                z10 = d10.booleanValue();
            }
            if (z10) {
                WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
                windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.navigationBars());
                windowInsetsControllerCompat.setSystemBarsBehavior(2);
                return;
            }
            new WindowInsetsControllerCompat(window, window.getDecorView()).show(WindowInsetsCompat.Type.navigationBars());
        }
    }

    public final void r(Screen screen, Activity activity) {
        Boolean e10;
        m.f(screen, "screen");
        if (activity != null) {
            Window window = activity.getWindow();
            Screen j10 = j(screen, Screen.e.NAVIGATION_BAR_TRANSLUCENT);
            if (j10 != null && (e10 = j10.e()) != null) {
                WindowCompat.setDecorFitsSystemWindows(window, !e10.booleanValue());
            }
        }
    }

    public final void s(Screen screen, Activity activity) {
        int i10;
        Integer screenOrientation;
        m.f(screen, "screen");
        if (activity != null) {
            Screen j10 = j(screen, Screen.e.ORIENTATION);
            if (j10 == null || (screenOrientation = j10.getScreenOrientation()) == null) {
                i10 = -1;
            } else {
                i10 = screenOrientation.intValue();
            }
            activity.setRequestedOrientation(i10);
        }
    }

    public final void u(Screen screen, Activity activity, ReactContext reactContext) {
        String str;
        m.f(screen, "screen");
        if (activity != null && reactContext != null) {
            Screen j10 = j(screen, Screen.e.STYLE);
            if (j10 == null || (str = j10.getStatusBarStyle()) == null) {
                str = "light";
            }
            UiThreadUtil.runOnUiThread(new q(activity, str));
        }
    }

    public final void v(Screen screen, Activity activity, ReactContext reactContext) {
        boolean z10;
        Boolean h10;
        m.f(screen, "screen");
        if (activity != null && reactContext != null) {
            Screen j10 = j(screen, Screen.e.TRANSLUCENT);
            if (j10 == null || (h10 = j10.h()) == null) {
                z10 = false;
            } else {
                z10 = h10.booleanValue();
            }
            UiThreadUtil.runOnUiThread(new c(activity, z10, reactContext.getExceptionHandler()));
        }
    }

    public final void w(Screen screen, Activity activity, ReactContext reactContext) {
        m.f(screen, "screen");
        if (f11657b) {
            s(screen, activity);
        }
        if (f11658c) {
            l(screen, activity, reactContext);
            u(screen, activity, reactContext);
            v(screen, activity, reactContext);
            n(screen, activity);
        }
        if (f11659d) {
            p(screen, activity);
            r(screen, activity);
            q(screen, activity);
        }
    }
}
