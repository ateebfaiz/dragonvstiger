package com.swmansion.rnscreens;

import android.animation.StateListAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import com.facebook.react.uimanager.g0;
import com.google.android.material.appbar.AppBarLayout;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;

public final class ScreenStackFragment extends ScreenFragment implements n {
    private boolean C;
    private Function1 N0;
    private boolean X;
    private View Y;
    private CustomSearchView Z;

    /* renamed from: j  reason: collision with root package name */
    private AppBarLayout f11554j;

    /* renamed from: w  reason: collision with root package name */
    private Toolbar f11555w;

    private static final class ScreensCoordinatorLayout extends CoordinatorLayout {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final ScreenFragment f11556a;

        /* renamed from: b  reason: collision with root package name */
        private final Animation.AnimationListener f11557b = new a(this);

        public static final class a implements Animation.AnimationListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ScreensCoordinatorLayout f11558a;

            a(ScreensCoordinatorLayout screensCoordinatorLayout) {
                this.f11558a = screensCoordinatorLayout;
            }

            public void onAnimationEnd(Animation animation) {
                m.f(animation, "animation");
                this.f11558a.f11556a.z();
            }

            public void onAnimationRepeat(Animation animation) {
                m.f(animation, "animation");
            }

            public void onAnimationStart(Animation animation) {
                m.f(animation, "animation");
                this.f11558a.f11556a.A();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ScreensCoordinatorLayout(Context context, ScreenFragment screenFragment) {
            super(context);
            m.f(context, "context");
            m.f(screenFragment, "mFragment");
            this.f11556a = screenFragment;
        }

        public void clearFocus() {
            if (getVisibility() != 4) {
                super.clearFocus();
            }
        }

        public void startAnimation(Animation animation) {
            m.f(animation, "animation");
            a aVar = new a(this.f11556a);
            aVar.setDuration(animation.getDuration());
            if (!(animation instanceof AnimationSet) || this.f11556a.isRemoving()) {
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(animation);
                animationSet.addAnimation(aVar);
                animationSet.setAnimationListener(this.f11557b);
                super.startAnimation(animationSet);
                return;
            }
            AnimationSet animationSet2 = (AnimationSet) animation;
            animationSet2.addAnimation(aVar);
            animationSet2.setAnimationListener(this.f11557b);
            super.startAnimation(animationSet2);
        }
    }

    private static final class a extends Animation {

        /* renamed from: a  reason: collision with root package name */
        private final ScreenFragment f11559a;

        public a(ScreenFragment screenFragment) {
            m.f(screenFragment, "mFragment");
            this.f11559a = screenFragment;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f10, Transformation transformation) {
            m.f(transformation, "t");
            super.applyTransformation(f10, transformation);
            ScreenFragment screenFragment = this.f11559a;
            screenFragment.w(f10, !screenFragment.isResumed());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScreenStackFragment(Screen screen) {
        super(screen);
        m.f(screen, "screenView");
    }

    private final View F() {
        ViewGroup i10 = i();
        while (i10 != null) {
            if (i10.isFocused()) {
                return i10;
            }
            if (i10 instanceof ViewGroup) {
                i10 = i10.getFocusedChild();
            } else {
                i10 = null;
            }
        }
        return null;
    }

    private final void H() {
        ViewParent viewParent;
        View view = getView();
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ScreenStack) {
            ((ScreenStack) viewParent).I();
        }
    }

    private final boolean N() {
        int i10;
        ScreenStackHeaderConfig headerConfig = i().getHeaderConfig();
        if (headerConfig != null) {
            i10 = headerConfig.getConfigSubviewsCount();
        } else {
            i10 = 0;
        }
        if (headerConfig != null && i10 > 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                if (headerConfig.e(i11).getType() == ScreenStackHeaderSubview.a.SEARCH_BAR) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void O(Menu menu) {
        menu.clear();
        if (N()) {
            Context context = getContext();
            if (this.Z == null && context != null) {
                CustomSearchView customSearchView = new CustomSearchView(context, this);
                this.Z = customSearchView;
                Function1 function1 = this.N0;
                if (function1 != null) {
                    function1.invoke(customSearchView);
                }
            }
            MenuItem add = menu.add("");
            add.setShowAsAction(2);
            add.setActionView(this.Z);
        }
    }

    public boolean E() {
        ScreenContainer container = i().getContainer();
        if (!(container instanceof ScreenStack)) {
            throw new IllegalStateException("ScreenStackFragment added into a non-stack container".toString());
        } else if (!m.b(((ScreenStack) container).getRootScreen(), i())) {
            return true;
        } else {
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof ScreenStackFragment) {
                return ((ScreenStackFragment) parentFragment).E();
            }
            return false;
        }
    }

    public final CustomSearchView G() {
        return this.Z;
    }

    public void I() {
        Toolbar toolbar;
        AppBarLayout appBarLayout = this.f11554j;
        if (!(appBarLayout == null || (toolbar = this.f11555w) == null || toolbar.getParent() != appBarLayout)) {
            appBarLayout.removeView(toolbar);
        }
        this.f11555w = null;
    }

    public final void J(Function1 function1) {
        this.N0 = function1;
    }

    public void K(Toolbar toolbar) {
        m.f(toolbar, "toolbar");
        AppBarLayout appBarLayout = this.f11554j;
        if (appBarLayout != null) {
            appBarLayout.addView(toolbar);
        }
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, -2);
        layoutParams.setScrollFlags(0);
        toolbar.setLayoutParams(layoutParams);
        this.f11555w = toolbar;
    }

    public void L(boolean z10) {
        float f10;
        if (this.C != z10) {
            AppBarLayout appBarLayout = this.f11554j;
            if (appBarLayout != null) {
                if (z10) {
                    f10 = 0.0f;
                } else {
                    f10 = g0.d(4.0f);
                }
                appBarLayout.setElevation(f10);
            }
            AppBarLayout appBarLayout2 = this.f11554j;
            if (appBarLayout2 != null) {
                appBarLayout2.setStateListAnimator((StateListAnimator) null);
            }
            this.C = z10;
        }
    }

    public void M(boolean z10) {
        AppBarLayout.ScrollingViewBehavior scrollingViewBehavior;
        if (this.X != z10) {
            ViewGroup.LayoutParams layoutParams = i().getLayoutParams();
            m.d(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
            if (z10) {
                scrollingViewBehavior = null;
            } else {
                scrollingViewBehavior = new AppBarLayout.ScrollingViewBehavior();
            }
            layoutParams2.setBehavior(scrollingViewBehavior);
            this.X = z10;
        }
    }

    public void dismiss() {
        ScreenContainer container = i().getContainer();
        if (container instanceof ScreenStack) {
            ((ScreenStack) container).D(this);
            return;
        }
        throw new IllegalStateException("ScreenStackFragment added into a non-stack container".toString());
    }

    public void n() {
        super.n();
        ScreenStackHeaderConfig headerConfig = i().getHeaderConfig();
        if (headerConfig != null) {
            headerConfig.h();
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        m.f(menu, "menu");
        m.f(menuInflater, "inflater");
        O(menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ScreensCoordinatorLayout screensCoordinatorLayout;
        AppBarLayout.ScrollingViewBehavior scrollingViewBehavior;
        AppBarLayout appBarLayout;
        AppBarLayout appBarLayout2;
        m.f(layoutInflater, "inflater");
        Context context = getContext();
        if (context != null) {
            screensCoordinatorLayout = new ScreensCoordinatorLayout(context, this);
        } else {
            screensCoordinatorLayout = null;
        }
        Screen i10 = i();
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        if (this.X) {
            scrollingViewBehavior = null;
        } else {
            scrollingViewBehavior = new AppBarLayout.ScrollingViewBehavior();
        }
        layoutParams.setBehavior(scrollingViewBehavior);
        i10.setLayoutParams(layoutParams);
        if (screensCoordinatorLayout != null) {
            screensCoordinatorLayout.addView(ScreenFragment.B(i()));
        }
        Context context2 = getContext();
        if (context2 != null) {
            appBarLayout = new AppBarLayout(context2);
            appBarLayout.setBackgroundColor(0);
            appBarLayout.setLayoutParams(new AppBarLayout.LayoutParams(-1, -2));
        } else {
            appBarLayout = null;
        }
        this.f11554j = appBarLayout;
        if (screensCoordinatorLayout != null) {
            screensCoordinatorLayout.addView(appBarLayout);
        }
        if (this.C) {
            AppBarLayout appBarLayout3 = this.f11554j;
            if (appBarLayout3 != null) {
                appBarLayout3.setElevation(0.0f);
            }
            AppBarLayout appBarLayout4 = this.f11554j;
            if (appBarLayout4 != null) {
                appBarLayout4.setStateListAnimator((StateListAnimator) null);
            }
        }
        Toolbar toolbar = this.f11555w;
        if (!(toolbar == null || (appBarLayout2 = this.f11554j) == null)) {
            appBarLayout2.addView(ScreenFragment.B(toolbar));
        }
        setHasOptionsMenu(true);
        return screensCoordinatorLayout;
    }

    public void onPrepareOptionsMenu(Menu menu) {
        ScreenStackHeaderConfig headerConfig;
        m.f(menu, "menu");
        if (!i().i() || ((headerConfig = i().getHeaderConfig()) != null && !headerConfig.f())) {
            O(menu);
        }
        super.onPrepareOptionsMenu(menu);
    }

    public void onStart() {
        View view = this.Y;
        if (view != null) {
            view.requestFocus();
        }
        super.onStart();
    }

    public void onStop() {
        if (eb.a.f12066a.a(getContext())) {
            this.Y = F();
        }
        super.onStop();
    }

    public void z() {
        super.z();
        H();
    }

    public ScreenStackFragment() {
        throw new IllegalStateException("ScreenStack fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }
}
