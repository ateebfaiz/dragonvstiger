package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.k1;
import java.util.Iterator;
import kotlin.jvm.internal.m;

@SuppressLint({"ViewConstructor"})
public final class Screen extends FabricEnabledViewGroup {
    private String C;
    private Boolean N0;
    private Boolean O0;
    private Integer P0;
    private Integer Q0;
    private Boolean R0;
    private Boolean S0;
    private boolean T0;

    /* renamed from: a  reason: collision with root package name */
    private l f11471a;

    /* renamed from: b  reason: collision with root package name */
    private ScreenContainer f11472b;

    /* renamed from: c  reason: collision with root package name */
    private a f11473c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11474d;

    /* renamed from: e  reason: collision with root package name */
    private d f11475e = d.PUSH;

    /* renamed from: f  reason: collision with root package name */
    private b f11476f = b.POP;

    /* renamed from: g  reason: collision with root package name */
    private c f11477g = c.DEFAULT;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11478h = true;

    /* renamed from: i  reason: collision with root package name */
    private Integer f11479i;

    /* renamed from: j  reason: collision with root package name */
    private Boolean f11480j;

    /* renamed from: w  reason: collision with root package name */
    private boolean f11481w;

    public enum a {
        INACTIVE,
        TRANSITIONING_OR_BELOW_TOP,
        ON_TOP;

        static {
            a[] a10;
            f11486e = pb.a.a(a10);
        }
    }

    public enum b {
        PUSH,
        POP;

        static {
            b[] a10;
            f11490d = pb.a.a(a10);
        }
    }

    public enum c {
        DEFAULT,
        NONE,
        FADE,
        SLIDE_FROM_BOTTOM,
        SLIDE_FROM_RIGHT,
        SLIDE_FROM_LEFT,
        FADE_FROM_BOTTOM,
        IOS,
        IOS_FROM_RIGHT,
        IOS_FROM_LEFT;

        static {
            c[] a10;
            C = pb.a.a(a10);
        }
    }

    public enum d {
        PUSH,
        MODAL,
        TRANSPARENT_MODAL;

        static {
            d[] a10;
            f11506e = pb.a.a(a10);
        }
    }

    public enum e {
        ORIENTATION,
        COLOR,
        STYLE,
        TRANSLUCENT,
        HIDDEN,
        ANIMATED,
        NAVIGATION_BAR_COLOR,
        NAVIGATION_BAR_TRANSLUCENT,
        NAVIGATION_BAR_HIDDEN;

        static {
            e[] a10;
            f11517w = pb.a.a(a10);
        }
    }

    public static final class f extends GuardedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReactContext f11518a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Screen f11519b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f11520c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f11521d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(ReactContext reactContext, Screen screen, int i10, int i11, JSExceptionHandler jSExceptionHandler) {
            super(jSExceptionHandler);
            this.f11518a = reactContext;
            this.f11519b = screen;
            this.f11520c = i10;
            this.f11521d = i11;
        }

        public void runGuarded() {
            UIManagerModule uIManagerModule = (UIManagerModule) this.f11518a.getNativeModule(UIManagerModule.class);
            if (uIManagerModule != null) {
                uIManagerModule.updateNodeSize(this.f11519b.getId(), this.f11520c, this.f11521d);
            }
        }
    }

    public Screen(ReactContext reactContext) {
        super(reactContext);
        setLayoutParams(new WindowManager.LayoutParams(2));
        this.T0 = true;
    }

    private final boolean b(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof WebView) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && b((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    private final void j(int i10) {
        Context context = getContext();
        m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        int e10 = k1.e(reactContext);
        com.facebook.react.uimanager.events.e c10 = k1.c(reactContext, getId());
        if (c10 != null) {
            c10.c(new cb.d(e10, getId(), i10));
        }
    }

    private final void l(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if ((viewGroup instanceof SwipeRefreshLayout) && (childAt instanceof ImageView)) {
                    viewGroup.addView(new View(getContext()), i10);
                } else if (childAt != null) {
                    m.c(childAt);
                    viewGroup.startViewTransition(childAt);
                }
                if (childAt instanceof ScreenStackHeaderConfig) {
                    l(((ScreenStackHeaderConfig) childAt).getToolbar());
                }
                if (childAt instanceof ViewGroup) {
                    if (db.a.a(childAt)) {
                        ViewGroup viewGroup2 = (ViewGroup) childAt;
                        int childCount2 = viewGroup2.getChildCount();
                        for (int i11 = 0; i11 < childCount2; i11++) {
                            viewGroup2.addView(new View(getContext()));
                        }
                    }
                    l((ViewGroup) childAt);
                }
            }
        }
    }

    private final void m(int i10, int i11) {
        Context context = getContext();
        m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        reactContext.runOnNativeModulesQueueThread(new f(reactContext, this, i10, i11, reactContext.getExceptionHandler()));
    }

    public final void a(int i10) {
        CustomToolbar customToolbar;
        setImportantForAccessibility(i10);
        ScreenStackHeaderConfig headerConfig = getHeaderConfig();
        if (headerConfig != null) {
            customToolbar = headerConfig.getToolbar();
        } else {
            customToolbar = null;
        }
        if (customToolbar != null) {
            customToolbar.setImportantForAccessibility(i10);
        }
    }

    public final boolean c() {
        return this.f11481w;
    }

    public final Boolean d() {
        return this.S0;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        m.f(sparseArray, "container");
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray sparseArray) {
        m.f(sparseArray, "container");
    }

    public final Boolean e() {
        return this.R0;
    }

    public final Boolean f() {
        return this.f11480j;
    }

    public final Boolean g() {
        return this.N0;
    }

    public final a getActivityState() {
        return this.f11473c;
    }

    public final ScreenContainer getContainer() {
        return this.f11472b;
    }

    public final Fragment getFragment() {
        l lVar = this.f11471a;
        if (lVar != null) {
            return lVar.e();
        }
        return null;
    }

    public final l getFragmentWrapper() {
        return this.f11471a;
    }

    public final ScreenStackHeaderConfig getHeaderConfig() {
        Object obj;
        Iterator it = ViewGroupKt.getChildren(this).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((View) obj) instanceof ScreenStackHeaderConfig) {
                break;
            }
        }
        if (obj instanceof ScreenStackHeaderConfig) {
            return (ScreenStackHeaderConfig) obj;
        }
        return null;
    }

    public final boolean getNativeBackButtonDismissalEnabled() {
        return this.T0;
    }

    public final Integer getNavigationBarColor() {
        return this.Q0;
    }

    public final b getReplaceAnimation() {
        return this.f11476f;
    }

    public final Integer getScreenOrientation() {
        return this.f11479i;
    }

    public final c getStackAnimation() {
        return this.f11477g;
    }

    public final d getStackPresentation() {
        return this.f11475e;
    }

    public final Integer getStatusBarColor() {
        return this.P0;
    }

    public final String getStatusBarStyle() {
        return this.C;
    }

    public final Boolean h() {
        return this.O0;
    }

    public final boolean i() {
        if (this.f11475e == d.TRANSPARENT_MODAL) {
            return true;
        }
        return false;
    }

    public final void k() {
        if (!this.f11481w) {
            this.f11481w = true;
            l(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if ((this.f11472b instanceof ScreenStack) && z10) {
            m(i12 - i10, i13 - i11);
            j(i11);
        }
    }

    public final void setActivityState(a aVar) {
        m.f(aVar, "activityState");
        if (aVar != this.f11473c) {
            this.f11473c = aVar;
            ScreenContainer screenContainer = this.f11472b;
            if (screenContainer != null) {
                screenContainer.o();
            }
        }
    }

    public final void setBeingRemoved(boolean z10) {
        this.f11481w = z10;
    }

    public final void setContainer(ScreenContainer screenContainer) {
        this.f11472b = screenContainer;
    }

    public final void setFragmentWrapper(l lVar) {
        this.f11471a = lVar;
    }

    public final void setGestureEnabled(boolean z10) {
        this.f11478h = z10;
    }

    public void setLayerType(int i10, Paint paint) {
    }

    public final void setNativeBackButtonDismissalEnabled(boolean z10) {
        this.T0 = z10;
    }

    public final void setNavigationBarColor(Integer num) {
        if (num != null) {
            s.f11656a.d();
        }
        this.Q0 = num;
        l lVar = this.f11471a;
        if (lVar != null) {
            s.f11656a.p(this, lVar.d());
        }
    }

    public final void setNavigationBarHidden(Boolean bool) {
        if (bool != null) {
            s.f11656a.d();
        }
        this.S0 = bool;
        l lVar = this.f11471a;
        if (lVar != null) {
            s.f11656a.q(this, lVar.d());
        }
    }

    public final void setNavigationBarTranslucent(Boolean bool) {
        if (bool != null) {
            s.f11656a.d();
        }
        this.R0 = bool;
        l lVar = this.f11471a;
        if (lVar != null) {
            s.f11656a.r(this, lVar.d());
        }
    }

    public final void setReplaceAnimation(b bVar) {
        m.f(bVar, "<set-?>");
        this.f11476f = bVar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setScreenOrientation(java.lang.String r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0006
            r3 = 0
            r2.f11479i = r3
            return
        L_0x0006:
            com.swmansion.rnscreens.s r0 = com.swmansion.rnscreens.s.f11656a
            r0.e()
            int r1 = r3.hashCode()
            switch(r1) {
                case -1894896954: goto L_0x0071;
                case 96673: goto L_0x0061;
                case 729267099: goto L_0x0052;
                case 1430647483: goto L_0x0043;
                case 1651658175: goto L_0x0034;
                case 1730732811: goto L_0x0024;
                case 2118770584: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0079
        L_0x0014:
            java.lang.String r1 = "landscape_right"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x001d
            goto L_0x0079
        L_0x001d:
            r3 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0085
        L_0x0024:
            java.lang.String r1 = "landscape_left"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x002d
            goto L_0x0079
        L_0x002d:
            r3 = 8
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0085
        L_0x0034:
            java.lang.String r1 = "portrait_up"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x003d
            goto L_0x0079
        L_0x003d:
            r3 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0085
        L_0x0043:
            java.lang.String r1 = "landscape"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x004c
            goto L_0x0079
        L_0x004c:
            r3 = 6
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0085
        L_0x0052:
            java.lang.String r1 = "portrait"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x005b
            goto L_0x0079
        L_0x005b:
            r3 = 7
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0085
        L_0x0061:
            java.lang.String r1 = "all"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x006a
            goto L_0x0079
        L_0x006a:
            r3 = 10
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0085
        L_0x0071:
            java.lang.String r1 = "portrait_down"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x007f
        L_0x0079:
            r3 = -1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0085
        L_0x007f:
            r3 = 9
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0085:
            r2.f11479i = r3
            com.swmansion.rnscreens.l r3 = r2.f11471a
            if (r3 == 0) goto L_0x0092
            android.app.Activity r3 = r3.d()
            r0.s(r2, r3)
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.Screen.setScreenOrientation(java.lang.String):void");
    }

    public final void setStackAnimation(c cVar) {
        m.f(cVar, "<set-?>");
        this.f11477g = cVar;
    }

    public final void setStackPresentation(d dVar) {
        m.f(dVar, "<set-?>");
        this.f11475e = dVar;
    }

    public final void setStatusBarAnimated(Boolean bool) {
        this.f11480j = bool;
    }

    public final void setStatusBarColor(Integer num) {
        if (num != null) {
            s.f11656a.f();
        }
        this.P0 = num;
        l lVar = this.f11471a;
        if (lVar != null) {
            s.f11656a.l(this, lVar.d(), lVar.g());
        }
    }

    public final void setStatusBarHidden(Boolean bool) {
        if (bool != null) {
            s.f11656a.f();
        }
        this.N0 = bool;
        l lVar = this.f11471a;
        if (lVar != null) {
            s.f11656a.n(this, lVar.d());
        }
    }

    public final void setStatusBarStyle(String str) {
        if (str != null) {
            s.f11656a.f();
        }
        this.C = str;
        l lVar = this.f11471a;
        if (lVar != null) {
            s.f11656a.u(this, lVar.d(), lVar.g());
        }
    }

    public final void setStatusBarTranslucent(Boolean bool) {
        if (bool != null) {
            s.f11656a.f();
        }
        this.O0 = bool;
        l lVar = this.f11471a;
        if (lVar != null) {
            s.f11656a.v(this, lVar.d(), lVar.g());
        }
    }

    public final void setTransitioning(boolean z10) {
        if (this.f11474d != z10) {
            this.f11474d = z10;
            boolean b10 = b(this);
            int i10 = 2;
            if (!b10 || getLayerType() == 2) {
                if (!z10 || b10) {
                    i10 = 0;
                }
                super.setLayerType(i10, (Paint) null);
            }
        }
    }
}
