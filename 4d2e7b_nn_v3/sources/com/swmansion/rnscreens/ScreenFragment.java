package com.swmansion.rnscreens;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cb.f;
import cb.g;
import cb.h;
import cb.i;
import cb.j;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.events.d;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.k1;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.n;

public class ScreenFragment extends Fragment implements l {

    /* renamed from: i  reason: collision with root package name */
    public static final a f11530i = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    public Screen f11531b;

    /* renamed from: c  reason: collision with root package name */
    private final List f11532c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f11533d;

    /* renamed from: e  reason: collision with root package name */
    private float f11534e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11535f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11536g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11537h;

    private static final class ScreensFrameLayout extends FrameLayout {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ScreensFrameLayout(Context context) {
            super(context);
            m.f(context, "context");
        }

        public void clearFocus() {
            if (getVisibility() != 4) {
                super.clearFocus();
            }
        }
    }

    public static final class a {
        private a() {
        }

        public final short a(float f10) {
            return (short) (f10 == 0.0f ? 1 : f10 == 1.0f ? 2 : 3);
        }

        /* access modifiers changed from: protected */
        public final View b(View view) {
            m.f(view, "view");
            ViewParent parent = view.getParent();
            if (parent != null) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.endViewTransition(view);
                viewGroup.removeView(view);
            }
            view.setVisibility(0);
            return view;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public enum b {
        DID_APPEAR,
        WILL_APPEAR,
        DID_DISAPPEAR,
        WILL_DISAPPEAR;

        static {
            b[] a10;
            f11543f = pb.a.a(a10);
        }
    }

    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11544a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.swmansion.rnscreens.ScreenFragment$b[] r0 = com.swmansion.rnscreens.ScreenFragment.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.swmansion.rnscreens.ScreenFragment$b r1 = com.swmansion.rnscreens.ScreenFragment.b.WILL_APPEAR     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.swmansion.rnscreens.ScreenFragment$b r1 = com.swmansion.rnscreens.ScreenFragment.b.DID_APPEAR     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.swmansion.rnscreens.ScreenFragment$b r1 = com.swmansion.rnscreens.ScreenFragment.b.WILL_DISAPPEAR     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.swmansion.rnscreens.ScreenFragment$b r1 = com.swmansion.rnscreens.ScreenFragment.b.DID_DISAPPEAR     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f11544a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenFragment.c.<clinit>():void");
        }
    }

    public ScreenFragment() {
        throw new IllegalStateException("Screen fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }

    protected static final View B(View view) {
        return f11530i.b(view);
    }

    private final void D() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            this.f11533d = true;
        } else {
            s.f11656a.w(i(), activity, g());
        }
    }

    private final void s() {
        r(b.DID_APPEAR, this);
        w(1.0f, false);
    }

    private final void t() {
        r(b.DID_DISAPPEAR, this);
        w(1.0f, true);
    }

    private final void u() {
        r(b.WILL_APPEAR, this);
        w(0.0f, false);
    }

    private final void v() {
        r(b.WILL_DISAPPEAR, this);
        w(0.0f, true);
    }

    private final void x(boolean z10) {
        this.f11537h = !z10;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (!(parentFragment instanceof ScreenFragment) || ((ScreenFragment) parentFragment).f11537h)) {
            return;
        }
        if (isResumed()) {
            UiThreadUtil.runOnUiThread(new k(z10, this));
        } else if (z10) {
            t();
        } else {
            v();
        }
    }

    /* access modifiers changed from: private */
    public static final void y(boolean z10, ScreenFragment screenFragment) {
        m.f(screenFragment, "this$0");
        if (z10) {
            screenFragment.s();
        } else {
            screenFragment.u();
        }
    }

    public void A() {
        x(false);
    }

    public void C(Screen screen) {
        m.f(screen, "<set-?>");
        this.f11531b = screen;
    }

    public void b(ScreenContainer screenContainer) {
        m.f(screenContainer, "container");
        l().remove(screenContainer);
    }

    public void c(b bVar) {
        m.f(bVar, NotificationCompat.CATEGORY_EVENT);
        int i10 = c.f11544a[bVar.ordinal()];
        if (i10 == 1) {
            this.f11535f = false;
        } else if (i10 == 2) {
            this.f11536g = false;
        } else if (i10 == 3) {
            this.f11535f = true;
        } else if (i10 == 4) {
            this.f11536g = true;
        }
    }

    public Activity d() {
        Fragment fragment;
        FragmentActivity activity;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            return activity2;
        }
        Context context = i().getContext();
        if (context instanceof ReactContext) {
            ReactContext reactContext = (ReactContext) context;
            if (reactContext.getCurrentActivity() != null) {
                return reactContext.getCurrentActivity();
            }
        }
        for (ViewParent container = i().getContainer(); container != null; container = container.getParent()) {
            if ((container instanceof Screen) && (fragment = ((Screen) container).getFragment()) != null && (activity = fragment.getActivity()) != null) {
                return activity;
            }
        }
        return null;
    }

    public Fragment e() {
        return this;
    }

    public ReactContext g() {
        if (getContext() instanceof ReactContext) {
            Context context = getContext();
            m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            return (ReactContext) context;
        } else if (i().getContext() instanceof ReactContext) {
            Context context2 = i().getContext();
            m.d(context2, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            return (ReactContext) context2;
        } else {
            for (ViewParent container = i().getContainer(); container != null; container = container.getParent()) {
                if (container instanceof Screen) {
                    Screen screen = (Screen) container;
                    if (screen.getContext() instanceof ReactContext) {
                        Context context3 = screen.getContext();
                        m.d(context3, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                        return (ReactContext) context3;
                    }
                }
            }
            return null;
        }
    }

    public Screen i() {
        Screen screen = this.f11531b;
        if (screen != null) {
            return screen;
        }
        m.u("screen");
        return null;
    }

    public void j(b bVar) {
        l fragmentWrapper;
        m.f(bVar, NotificationCompat.CATEGORY_EVENT);
        ArrayList<ScreenContainer> arrayList = new ArrayList<>();
        for (Object next : l()) {
            if (((ScreenContainer) next).getScreenCount() > 0) {
                arrayList.add(next);
            }
        }
        for (ScreenContainer topScreen : arrayList) {
            Screen topScreen2 = topScreen.getTopScreen();
            if (!(topScreen2 == null || (fragmentWrapper = topScreen2.getFragmentWrapper()) == null)) {
                r(bVar, fragmentWrapper);
            }
        }
    }

    public List l() {
        return this.f11532c;
    }

    public void m(ScreenContainer screenContainer) {
        m.f(screenContainer, "container");
        l().add(screenContainer);
    }

    public void n() {
        D();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.f(layoutInflater, "inflater");
        i().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Context context = getContext();
        if (context == null) {
            return null;
        }
        ScreensFrameLayout screensFrameLayout = new ScreensFrameLayout(context);
        screensFrameLayout.addView(B(i()));
        return screensFrameLayout;
    }

    public void onDestroy() {
        super.onDestroy();
        ScreenContainer container = i().getContainer();
        if (container == null || !container.n(this)) {
            Context context = i().getContext();
            if (context instanceof ReactContext) {
                int e10 = k1.e(context);
                e c10 = k1.c((ReactContext) context, i().getId());
                if (c10 != null) {
                    c10.c(new g(e10, i().getId()));
                }
            }
        }
        l().clear();
    }

    public void onResume() {
        super.onResume();
        if (this.f11533d) {
            this.f11533d = false;
            s.f11656a.w(i(), d(), g());
        }
    }

    public boolean p(b bVar) {
        m.f(bVar, NotificationCompat.CATEGORY_EVENT);
        int i10 = c.f11544a[bVar.ordinal()];
        if (i10 == 1) {
            return this.f11535f;
        }
        if (i10 == 2) {
            return this.f11536g;
        }
        if (i10 != 3) {
            if (i10 != 4) {
                throw new n();
            } else if (!this.f11536g) {
                return true;
            }
        } else if (!this.f11535f) {
            return true;
        }
        return false;
    }

    public void q() {
        Context context = i().getContext();
        m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        int e10 = k1.e(reactContext);
        e c10 = k1.c(reactContext, i().getId());
        if (c10 != null) {
            c10.c(new cb.b(e10, i().getId()));
        }
    }

    public void r(b bVar, l lVar) {
        d dVar;
        m.f(bVar, NotificationCompat.CATEGORY_EVENT);
        m.f(lVar, "fragmentWrapper");
        Fragment e10 = lVar.e();
        if (e10 instanceof ScreenStackFragment) {
            ScreenStackFragment screenStackFragment = (ScreenStackFragment) e10;
            if (screenStackFragment.p(bVar)) {
                Screen i10 = screenStackFragment.i();
                lVar.c(bVar);
                int f10 = k1.f(i10);
                int i11 = c.f11544a[bVar.ordinal()];
                if (i11 == 1) {
                    dVar = new i(f10, i10.getId());
                } else if (i11 == 2) {
                    dVar = new cb.e(f10, i10.getId());
                } else if (i11 == 3) {
                    dVar = new j(f10, i10.getId());
                } else if (i11 == 4) {
                    dVar = new f(f10, i10.getId());
                } else {
                    throw new n();
                }
                Context context = i().getContext();
                m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                e c10 = k1.c((ReactContext) context, i().getId());
                if (c10 != null) {
                    c10.c(dVar);
                }
                lVar.j(bVar);
            }
        }
    }

    public void w(float f10, boolean z10) {
        boolean z11;
        if ((this instanceof ScreenStackFragment) && this.f11534e != f10) {
            float max = Math.max(0.0f, Math.min(1.0f, f10));
            this.f11534e = max;
            short a10 = f11530i.a(max);
            ScreenContainer container = i().getContainer();
            if (container instanceof ScreenStack) {
                z11 = ((ScreenStack) container).getGoingForward();
            } else {
                z11 = false;
            }
            boolean z12 = z11;
            Context context = i().getContext();
            m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            ReactContext reactContext = (ReactContext) context;
            e c10 = k1.c(reactContext, i().getId());
            if (c10 != null) {
                c10.c(new h(k1.e(reactContext), i().getId(), this.f11534e, z10, z12, a10));
            }
        }
    }

    public void z() {
        x(true);
    }

    public ScreenFragment(Screen screen) {
        m.f(screen, "screenView");
        C(screen);
    }
}
