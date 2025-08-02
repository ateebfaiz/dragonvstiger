package com.swmansion.rnscreens;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cb.g;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.a;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.k1;
import com.swmansion.rnscreens.Screen;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.jvm.internal.m;

public class ScreenContainer extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    protected final ArrayList f11522a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    protected FragmentManager f11523b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11524c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11525d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f11526e;

    /* renamed from: f  reason: collision with root package name */
    private final w6.a f11527f = new a(this);

    /* renamed from: g  reason: collision with root package name */
    private l f11528g;

    public static final class a extends w6.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ScreenContainer f11529a;

        a(ScreenContainer screenContainer) {
            this.f11529a = screenContainer;
        }

        public void doFrame(long j10) {
            this.f11529a.f11526e = false;
            ScreenContainer screenContainer = this.f11529a;
            screenContainer.measure(View.MeasureSpec.makeMeasureSpec(screenContainer.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f11529a.getHeight(), 1073741824));
            ScreenContainer screenContainer2 = this.f11529a;
            screenContainer2.layout(screenContainer2.getLeft(), this.f11529a.getTop(), this.f11529a.getRight(), this.f11529a.getBottom());
        }
    }

    public ScreenContainer(Context context) {
        super(context);
    }

    private final void f(FragmentTransaction fragmentTransaction, Fragment fragment) {
        fragmentTransaction.add(getId(), fragment);
    }

    private final void i(FragmentTransaction fragmentTransaction, Fragment fragment) {
        fragmentTransaction.remove(fragment);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.fragment.app.FragmentManager j(com.facebook.react.ReactRootView r4) {
        /*
            r3 = this;
            android.content.Context r0 = r4.getContext()
        L_0x0004:
            boolean r1 = r0 instanceof androidx.fragment.app.FragmentActivity
            if (r1 != 0) goto L_0x0013
            boolean r2 = r0 instanceof android.content.ContextWrapper
            if (r2 == 0) goto L_0x0013
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            android.content.Context r0 = r0.getBaseContext()
            goto L_0x0004
        L_0x0013:
            if (r1 == 0) goto L_0x003e
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            androidx.fragment.app.FragmentManager r1 = r0.getSupportFragmentManager()
            java.util.List r1 = r1.getFragments()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x002d
            androidx.fragment.app.FragmentManager r4 = r0.getSupportFragmentManager()
            kotlin.jvm.internal.m.c(r4)
            goto L_0x003d
        L_0x002d:
            androidx.fragment.app.Fragment r4 = androidx.fragment.app.FragmentManager.findFragment(r4)     // Catch:{ IllegalStateException -> 0x0036 }
            androidx.fragment.app.FragmentManager r4 = r4.getChildFragmentManager()     // Catch:{ IllegalStateException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            androidx.fragment.app.FragmentManager r4 = r0.getSupportFragmentManager()
        L_0x003a:
            kotlin.jvm.internal.m.c(r4)
        L_0x003d:
            return r4
        L_0x003e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "In order to use RNScreens components your app's activity need to extend ReactActivity"
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenContainer.j(com.facebook.react.ReactRootView):androidx.fragment.app.FragmentManager");
    }

    private final Screen.a k(l lVar) {
        return lVar.i().getActivityState();
    }

    private final void r() {
        this.f11525d = true;
        Context context = getContext();
        m.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        ((e1) context).b().runOnUiQueueThread(new i(this));
    }

    /* access modifiers changed from: private */
    public static final void s(ScreenContainer screenContainer) {
        m.f(screenContainer, "this$0");
        screenContainer.u();
    }

    private final void setFragmentManager(FragmentManager fragmentManager) {
        this.f11523b = fragmentManager;
        v();
    }

    private final void x(FragmentManager fragmentManager) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        m.e(beginTransaction, "beginTransaction(...)");
        boolean z10 = false;
        for (Fragment next : fragmentManager.getFragments()) {
            if ((next instanceof ScreenFragment) && ((ScreenFragment) next).i().getContainer() == this) {
                beginTransaction.remove(next);
                z10 = true;
            }
        }
        if (z10) {
            beginTransaction.commitNowAllowingStateLoss();
        }
    }

    private final void z() {
        boolean z10;
        Unit unit;
        ViewParent viewParent = this;
        while (true) {
            z10 = viewParent instanceof ReactRootView;
            if (!z10 && !(viewParent instanceof Screen) && viewParent.getParent() != null) {
                viewParent = viewParent.getParent();
                m.e(viewParent, "getParent(...)");
            }
        }
        if (viewParent instanceof Screen) {
            l fragmentWrapper = ((Screen) viewParent).getFragmentWrapper();
            if (fragmentWrapper != null) {
                this.f11528g = fragmentWrapper;
                fragmentWrapper.m(this);
                FragmentManager childFragmentManager = fragmentWrapper.e().getChildFragmentManager();
                m.e(childFragmentManager, "getChildFragmentManager(...)");
                setFragmentManager(childFragmentManager);
                unit = Unit.f12577a;
            } else {
                unit = null;
            }
            if (unit == null) {
                throw new IllegalStateException("Parent Screen does not have its Fragment attached".toString());
            }
        } else if (z10) {
            setFragmentManager(j((ReactRootView) viewParent));
        } else {
            throw new IllegalStateException("ScreenContainer is not attached under ReactRootView".toString());
        }
    }

    /* access modifiers changed from: protected */
    public l c(Screen screen) {
        m.f(screen, "screen");
        return new ScreenFragment(screen);
    }

    public final void d(Screen screen, int i10) {
        m.f(screen, "screen");
        l c10 = c(screen);
        screen.setFragmentWrapper(c10);
        this.f11522a.add(i10, c10);
        screen.setContainer(this);
        r();
    }

    public final void e() {
        if (this.f11522a.size() >= 2) {
            FragmentTransaction g10 = g();
            Screen topScreen = getTopScreen();
            m.d(topScreen, "null cannot be cast to non-null type com.swmansion.rnscreens.Screen");
            Fragment fragment = topScreen.getFragment();
            m.d(fragment, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            i(g10, fragment);
            ArrayList arrayList = this.f11522a;
            f(g10, ((l) arrayList.get(arrayList.size() - 2)).e());
            Fragment fragment2 = topScreen.getFragment();
            m.d(fragment2, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            f(g10, fragment2);
            g10.commitNowAllowingStateLoss();
            return;
        }
        throw new RuntimeException("[RNScreens] Unable to run transition for less than 2 screens.");
    }

    /* access modifiers changed from: protected */
    public final FragmentTransaction g() {
        FragmentManager fragmentManager = this.f11523b;
        if (fragmentManager != null) {
            FragmentTransaction reorderingAllowed = fragmentManager.beginTransaction().setReorderingAllowed(true);
            m.e(reorderingAllowed, "setReorderingAllowed(...)");
            return reorderingAllowed;
        }
        throw new IllegalArgumentException("fragment manager is null when creating transaction".toString());
    }

    public final int getScreenCount() {
        return this.f11522a.size();
    }

    public Screen getTopScreen() {
        Object obj;
        Iterator it = this.f11522a.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (k((l) obj) == Screen.a.ON_TOP) {
                break;
            }
        }
        l lVar = (l) obj;
        if (lVar != null) {
            return lVar.i();
        }
        return null;
    }

    public final void h() {
        if (this.f11522a.size() >= 2) {
            FragmentTransaction g10 = g();
            ArrayList arrayList = this.f11522a;
            i(g10, ((l) arrayList.get(arrayList.size() - 2)).e());
            g10.commitNowAllowingStateLoss();
            return;
        }
        throw new RuntimeException("[RNScreens] Unable to run transition for less than 2 screens.");
    }

    public final Screen l(int i10) {
        return ((l) this.f11522a.get(i10)).i();
    }

    public final l m(int i10) {
        Object obj = this.f11522a.get(i10);
        m.e(obj, "get(...)");
        return (l) obj;
    }

    public boolean n(l lVar) {
        return r.S(this.f11522a, lVar);
    }

    public final void o() {
        v();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11524c = true;
        z();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        FragmentManager fragmentManager = this.f11523b;
        if (fragmentManager != null && !fragmentManager.isDestroyed()) {
            x(fragmentManager);
            fragmentManager.executePendingTransactions();
        }
        l lVar = this.f11528g;
        if (lVar != null) {
            lVar.b(this);
        }
        this.f11528g = null;
        super.onDetachedFromWindow();
        this.f11524c = false;
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 < childCount) {
                removeViewAt(childCount);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            getChildAt(i14).layout(0, 0, getWidth(), getHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            getChildAt(i12).measure(i10, i11);
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        l fragmentWrapper;
        Screen topScreen = getTopScreen();
        if (topScreen != null && (fragmentWrapper = topScreen.getFragmentWrapper()) != null) {
            fragmentWrapper.n();
        }
    }

    public final void q() {
        Screen topScreen = getTopScreen();
        m.d(topScreen, "null cannot be cast to non-null type com.swmansion.rnscreens.Screen");
        if (getContext() instanceof ReactContext) {
            int e10 = k1.e(getContext());
            Context context = getContext();
            m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            e c10 = k1.c((ReactContext) context, topScreen.getId());
            if (c10 != null) {
                c10.c(new g(e10, topScreen.getId()));
            }
        }
    }

    public void removeView(View view) {
        m.f(view, "view");
        if (view == getFocusedChild()) {
            Object systemService = getContext().getSystemService("input_method");
            m.d(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(getWindowToken(), 2);
        }
        super.removeView(view);
    }

    public void requestLayout() {
        super.requestLayout();
        if (!this.f11526e && this.f11527f != null) {
            this.f11526e = true;
            com.facebook.react.modules.core.a.h().m(a.b.NATIVE_ANIMATED_MODULE, this.f11527f);
        }
    }

    public void t() {
        boolean z10;
        FragmentTransaction g10 = g();
        FragmentManager fragmentManager = this.f11523b;
        if (fragmentManager != null) {
            HashSet hashSet = new HashSet(fragmentManager.getFragments());
            Iterator it = this.f11522a.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                m.c(lVar);
                if (k(lVar) == Screen.a.INACTIVE && lVar.e().isAdded()) {
                    i(g10, lVar.e());
                }
                hashSet.remove(lVar.e());
            }
            boolean z11 = false;
            if (!hashSet.isEmpty()) {
                for (Fragment fragment : (Fragment[]) hashSet.toArray(new Fragment[0])) {
                    if ((fragment instanceof ScreenFragment) && ((ScreenFragment) fragment).i().getContainer() == null) {
                        i(g10, fragment);
                    }
                }
            }
            if (getTopScreen() == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.f11522a.iterator();
            while (it2.hasNext()) {
                l lVar2 = (l) it2.next();
                m.c(lVar2);
                Screen.a k10 = k(lVar2);
                Screen.a aVar = Screen.a.INACTIVE;
                if (k10 != aVar && !lVar2.e().isAdded()) {
                    f(g10, lVar2.e());
                    z11 = true;
                } else if (k10 != aVar && z11) {
                    i(g10, lVar2.e());
                    arrayList.add(lVar2);
                }
                lVar2.i().setTransitioning(z10);
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                f(g10, ((l) it3.next()).e());
            }
            g10.commitNowAllowingStateLoss();
            return;
        }
        throw new IllegalArgumentException("fragment manager is null when performing update in ScreenContainer".toString());
    }

    public final void u() {
        FragmentManager fragmentManager;
        if (this.f11525d && this.f11524c && (fragmentManager = this.f11523b) != null) {
            if (fragmentManager == null || !fragmentManager.isDestroyed()) {
                this.f11525d = false;
                t();
                p();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void v() {
        this.f11525d = true;
        u();
    }

    public void w() {
        Iterator it = this.f11522a.iterator();
        while (it.hasNext()) {
            ((l) it.next()).i().setContainer((ScreenContainer) null);
        }
        this.f11522a.clear();
        r();
    }

    public void y(int i10) {
        ((l) this.f11522a.get(i10)).i().setContainer((ScreenContainer) null);
        this.f11522a.remove(i10);
        r();
    }
}
