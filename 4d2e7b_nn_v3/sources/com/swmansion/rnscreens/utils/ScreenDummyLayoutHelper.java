package com.swmansion.rnscreens.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.facebook.jni.annotations.DoNotStrip;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.g0;
import com.google.android.material.appbar.AppBarLayout;
import com.swmansion.rnscreens.ScreenStackHeaderConfig;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

@DoNotStrip
public final class ScreenDummyLayoutHelper implements LifecycleEventListener {

    /* renamed from: j  reason: collision with root package name */
    public static final a f11668j = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public static WeakReference f11669w = new WeakReference((Object) null);

    /* renamed from: a  reason: collision with root package name */
    private CoordinatorLayout f11670a;

    /* renamed from: b  reason: collision with root package name */
    private AppBarLayout f11671b;

    /* renamed from: c  reason: collision with root package name */
    private View f11672c;

    /* renamed from: d  reason: collision with root package name */
    private Toolbar f11673d;

    /* renamed from: e  reason: collision with root package name */
    private float f11674e;

    /* renamed from: f  reason: collision with root package name */
    private int f11675f;

    /* renamed from: g  reason: collision with root package name */
    private a f11676g;

    /* renamed from: h  reason: collision with root package name */
    private WeakReference f11677h;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f11678i;

    public static final class a {
        private a() {
        }

        @DoNotStrip
        public final ScreenDummyLayoutHelper getInstance() {
            return (ScreenDummyLayoutHelper) ScreenDummyLayoutHelper.f11669w.get();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f11679a = new b();

        b() {
            super(0);
        }

        public final Object invoke() {
            return "[RNScreens] Context was null-ed before dummy layout was initialized";
        }
    }

    static final class c extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final c f11680a = new c();

        c() {
            super(0);
        }

        public final Object invoke() {
            return "[RNScreens] ReactContext missing in onHostResume! This should not happen.";
        }
    }

    static final class d extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final d f11681a = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "[RNScreens] Attempt to require missing react context";
        }
    }

    private final void b(Context context) {
        this.f11670a = new CoordinatorLayout(context);
        AppBarLayout appBarLayout = new AppBarLayout(context);
        appBarLayout.setLayoutParams(new CoordinatorLayout.LayoutParams(-1, -2));
        this.f11671b = appBarLayout;
        Toolbar toolbar = new Toolbar(context);
        toolbar.setTitle((CharSequence) "FontSize123!#$");
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, -2);
        layoutParams.setScrollFlags(0);
        toolbar.setLayoutParams(layoutParams);
        this.f11673d = toolbar;
        TextView a10 = ScreenStackHeaderConfig.X0.a(toolbar);
        m.c(a10);
        this.f11674e = a10.getTextSize();
        Toolbar toolbar2 = this.f11673d;
        View view = null;
        if (toolbar2 == null) {
            m.u("toolbar");
            toolbar2 = null;
        }
        this.f11675f = toolbar2.getContentInsetStartWithNavigation();
        AppBarLayout appBarLayout2 = this.f11671b;
        if (appBarLayout2 == null) {
            m.u("appBarLayout");
            appBarLayout2 = null;
        }
        Toolbar toolbar3 = this.f11673d;
        if (toolbar3 == null) {
            m.u("toolbar");
            toolbar3 = null;
        }
        appBarLayout2.addView(toolbar3);
        View view2 = new View(context);
        view2.setLayoutParams(new CoordinatorLayout.LayoutParams(-1, -1));
        this.f11672c = view2;
        CoordinatorLayout coordinatorLayout = this.f11670a;
        if (coordinatorLayout == null) {
            m.u("coordinatorLayout");
            coordinatorLayout = null;
        }
        AppBarLayout appBarLayout3 = this.f11671b;
        if (appBarLayout3 == null) {
            m.u("appBarLayout");
            appBarLayout3 = null;
        }
        coordinatorLayout.addView(appBarLayout3);
        View view3 = this.f11672c;
        if (view3 == null) {
            m.u("dummyContentView");
        } else {
            view = view3;
        }
        coordinatorLayout.addView(view);
        this.f11678i = true;
    }

    private final boolean c(ReactApplicationContext reactApplicationContext) {
        if (this.f11678i) {
            return true;
        }
        if (!reactApplicationContext.hasCurrentActivity()) {
            return false;
        }
        Activity currentActivity = reactApplicationContext.getCurrentActivity();
        if (currentActivity != null) {
            m.e(currentActivity, "requireNotNull(...)");
            synchronized (this) {
                if (this.f11678i) {
                    return true;
                }
                b(currentActivity);
                Unit unit = Unit.f12577a;
                return true;
            }
        }
        throw new IllegalArgumentException("[RNScreens] Attempt to use context detached from activity. This could happen only due to race-condition.".toString());
    }

    @DoNotStrip
    private final float computeDummyLayout(int i10, boolean z10) {
        float f10;
        if (!this.f11678i && !c(e(b.f11679a))) {
            Log.e("ScreenDummyLayoutHelper", "[RNScreens] Failed to late-init layout while computing header height. This is most likely a race-condition-bug in react-native-screens, please file an issue at https://github.com/software-mansion/react-native-screens/issues");
            return 0.0f;
        } else if (this.f11676g.b(new b(i10, z10))) {
            return this.f11676g.a();
        } else {
            View decorView = d().getWindow().getDecorView();
            m.e(decorView, "getDecorView(...)");
            int width = decorView.getWidth();
            int height = decorView.getHeight();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
            AppBarLayout appBarLayout = null;
            if (z10) {
                Toolbar toolbar = this.f11673d;
                if (toolbar == null) {
                    m.u("toolbar");
                    toolbar = null;
                }
                toolbar.setTitle((CharSequence) "");
                Toolbar toolbar2 = this.f11673d;
                if (toolbar2 == null) {
                    m.u("toolbar");
                    toolbar2 = null;
                }
                toolbar2.setContentInsetStartWithNavigation(0);
            } else {
                Toolbar toolbar3 = this.f11673d;
                if (toolbar3 == null) {
                    m.u("toolbar");
                    toolbar3 = null;
                }
                toolbar3.setTitle((CharSequence) "FontSize123!#$");
                Toolbar toolbar4 = this.f11673d;
                if (toolbar4 == null) {
                    m.u("toolbar");
                    toolbar4 = null;
                }
                toolbar4.setContentInsetStartWithNavigation(this.f11675f);
            }
            ScreenStackHeaderConfig.a aVar = ScreenStackHeaderConfig.X0;
            Toolbar toolbar5 = this.f11673d;
            if (toolbar5 == null) {
                m.u("toolbar");
                toolbar5 = null;
            }
            TextView a10 = aVar.a(toolbar5);
            if (a10 != null) {
                if (i10 != -1) {
                    f10 = (float) i10;
                } else {
                    f10 = this.f11674e;
                }
                a10.setTextSize(f10);
            }
            CoordinatorLayout coordinatorLayout = this.f11670a;
            if (coordinatorLayout == null) {
                m.u("coordinatorLayout");
                coordinatorLayout = null;
            }
            coordinatorLayout.measure(makeMeasureSpec, makeMeasureSpec2);
            CoordinatorLayout coordinatorLayout2 = this.f11670a;
            if (coordinatorLayout2 == null) {
                m.u("coordinatorLayout");
                coordinatorLayout2 = null;
            }
            coordinatorLayout2.layout(0, 0, width, height);
            AppBarLayout appBarLayout2 = this.f11671b;
            if (appBarLayout2 == null) {
                m.u("appBarLayout");
            } else {
                appBarLayout = appBarLayout2;
            }
            float b10 = g0.b((float) appBarLayout.getHeight());
            this.f11676g = new a(new b(i10, z10), b10);
            return b10;
        }
    }

    private final Activity d() {
        Activity currentActivity = f(this, (Function0) null, 1, (Object) null).getCurrentActivity();
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new IllegalArgumentException("[RNScreens] Attempt to use context detached from activity".toString());
    }

    private final ReactApplicationContext e(Function0 function0) {
        Object obj = this.f11677h.get();
        if (function0 == null) {
            function0 = d.f11681a;
        }
        if (obj != null) {
            return (ReactApplicationContext) obj;
        }
        throw new IllegalArgumentException(function0.invoke().toString());
    }

    static /* synthetic */ ReactApplicationContext f(ScreenDummyLayoutHelper screenDummyLayoutHelper, Function0 function0, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function0 = null;
        }
        return screenDummyLayoutHelper.e(function0);
    }

    @DoNotStrip
    public static final ScreenDummyLayoutHelper getInstance() {
        return f11668j.getInstance();
    }

    public void onHostDestroy() {
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.f11677h.get();
        if (reactApplicationContext != null) {
            reactApplicationContext.removeLifecycleEventListener(this);
        }
    }

    public void onHostPause() {
    }

    public void onHostResume() {
        ReactApplicationContext e10 = e(c.f11680a);
        if (c(e10)) {
            e10.removeLifecycleEventListener(this);
        } else {
            Log.w("ScreenDummyLayoutHelper", "[RNScreens] Failed to initialise dummy layout in onHostResume.");
        }
    }
}
