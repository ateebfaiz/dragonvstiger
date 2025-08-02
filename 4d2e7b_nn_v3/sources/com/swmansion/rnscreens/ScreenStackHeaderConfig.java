package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cb.c;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.k1;
import com.facebook.react.views.text.n;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class ScreenStackHeaderConfig extends ViewGroup {
    public static final a X0 = new a((DefaultConstructorMarker) null);
    private Integer C;
    private boolean N0;
    private boolean O0;
    private boolean P0;
    private boolean Q0;
    private boolean R0 = true;
    private int S0;
    private boolean T0;
    private final int U0;
    private final int V0;
    private final View.OnClickListener W0 = new o(this);

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f11560a = new ArrayList(3);

    /* renamed from: b  reason: collision with root package name */
    private final CustomToolbar f11561b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11562c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11563d;

    /* renamed from: e  reason: collision with root package name */
    private Integer f11564e;

    /* renamed from: f  reason: collision with root package name */
    private String f11565f;

    /* renamed from: g  reason: collision with root package name */
    private int f11566g;

    /* renamed from: h  reason: collision with root package name */
    private String f11567h;

    /* renamed from: i  reason: collision with root package name */
    private String f11568i;

    /* renamed from: j  reason: collision with root package name */
    private float f11569j;

    /* renamed from: w  reason: collision with root package name */
    private int f11570w;

    public static final class a {
        private a() {
        }

        public final TextView a(Toolbar toolbar) {
            m.f(toolbar, "toolbar");
            int childCount = toolbar.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = toolbar.getChildAt(i10);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (m.b(textView.getText(), toolbar.getTitle())) {
                        return textView;
                    }
                }
            }
            return null;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11571a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.swmansion.rnscreens.ScreenStackHeaderSubview$a[] r0 = com.swmansion.rnscreens.ScreenStackHeaderSubview.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.swmansion.rnscreens.ScreenStackHeaderSubview$a r1 = com.swmansion.rnscreens.ScreenStackHeaderSubview.a.LEFT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.swmansion.rnscreens.ScreenStackHeaderSubview$a r1 = com.swmansion.rnscreens.ScreenStackHeaderSubview.a.RIGHT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.swmansion.rnscreens.ScreenStackHeaderSubview$a r1 = com.swmansion.rnscreens.ScreenStackHeaderSubview.a.CENTER     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f11571a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenStackHeaderConfig.b.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScreenStackHeaderConfig(Context context) {
        super(context);
        m.f(context, "context");
        setVisibility(8);
        CustomToolbar customToolbar = new CustomToolbar(context, this);
        this.f11561b = customToolbar;
        this.U0 = customToolbar.getContentInsetStart();
        this.V0 = customToolbar.getContentInsetStartWithNavigation();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16843827, typedValue, true)) {
            customToolbar.setBackgroundColor(typedValue.data);
        }
        customToolbar.setClipChildren(false);
    }

    /* access modifiers changed from: private */
    public static final void c(ScreenStackHeaderConfig screenStackHeaderConfig, View view) {
        m.f(screenStackHeaderConfig, "this$0");
        ScreenStackFragment screenFragment = screenStackHeaderConfig.getScreenFragment();
        if (screenFragment != null) {
            ScreenStack screenStack = screenStackHeaderConfig.getScreenStack();
            if (screenStack != null && m.b(screenStack.getRootScreen(), screenFragment.i())) {
                Fragment parentFragment = screenFragment.getParentFragment();
                if (parentFragment instanceof ScreenStackFragment) {
                    ScreenStackFragment screenStackFragment = (ScreenStackFragment) parentFragment;
                    if (screenStackFragment.i().getNativeBackButtonDismissalEnabled()) {
                        screenStackFragment.dismiss();
                    } else {
                        screenStackFragment.q();
                    }
                }
            } else if (screenFragment.i().getNativeBackButtonDismissalEnabled()) {
                screenFragment.dismiss();
            } else {
                screenFragment.q();
            }
        }
    }

    private final void g() {
        Screen screen;
        if (getParent() != null && !this.P0 && (screen = getScreen()) != null && !screen.c()) {
            h();
        }
    }

    private final Screen getScreen() {
        ViewParent parent = getParent();
        if (parent instanceof Screen) {
            return (Screen) parent;
        }
        return null;
    }

    private final ScreenStack getScreenStack() {
        ViewParent viewParent;
        Screen screen = getScreen();
        if (screen != null) {
            viewParent = screen.getContainer();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ScreenStack) {
            return (ScreenStack) viewParent;
        }
        return null;
    }

    public final void b(ScreenStackHeaderSubview screenStackHeaderSubview, int i10) {
        m.f(screenStackHeaderSubview, "child");
        this.f11560a.add(i10, screenStackHeaderSubview);
        g();
    }

    public final void d() {
        this.P0 = true;
    }

    public final ScreenStackHeaderSubview e(int i10) {
        Object obj = this.f11560a.get(i10);
        m.e(obj, "get(...)");
        return (ScreenStackHeaderSubview) obj;
    }

    public final boolean f() {
        return this.f11562c;
    }

    public final int getConfigSubviewsCount() {
        return this.f11560a.size();
    }

    public final ScreenStackFragment getScreenFragment() {
        ViewParent parent = getParent();
        if (!(parent instanceof Screen)) {
            return null;
        }
        Fragment fragment = ((Screen) parent).getFragment();
        if (fragment instanceof ScreenStackFragment) {
            return (ScreenStackFragment) fragment;
        }
        return null;
    }

    public final CustomToolbar getToolbar() {
        return this.f11561b;
    }

    public final void h() {
        boolean z10;
        FragmentActivity fragmentActivity;
        boolean z11;
        ImageView imageView;
        Drawable navigationIcon;
        int i10;
        ScreenStackFragment screenFragment;
        ScreenStackFragment screenFragment2;
        ReactContext reactContext;
        ScreenStack screenStack = getScreenStack();
        if (screenStack == null || m.b(screenStack.getTopScreen(), getParent())) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.T0 && z10 && !this.P0) {
            ScreenStackFragment screenFragment3 = getScreenFragment();
            if (screenFragment3 != null) {
                fragmentActivity = screenFragment3.getActivity();
            } else {
                fragmentActivity = null;
            }
            AppCompatActivity appCompatActivity = (AppCompatActivity) fragmentActivity;
            if (appCompatActivity != null) {
                String str = this.f11568i;
                if (str != null) {
                    if (m.b(str, "rtl")) {
                        this.f11561b.setLayoutDirection(1);
                    } else if (m.b(this.f11568i, "ltr")) {
                        this.f11561b.setLayoutDirection(0);
                    }
                }
                Screen screen = getScreen();
                if (screen != null) {
                    if (getContext() instanceof ReactContext) {
                        Context context = getContext();
                        m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                        reactContext = (ReactContext) context;
                    } else {
                        l fragmentWrapper = screen.getFragmentWrapper();
                        if (fragmentWrapper != null) {
                            reactContext = fragmentWrapper.g();
                        } else {
                            reactContext = null;
                        }
                    }
                    s.f11656a.w(screen, appCompatActivity, reactContext);
                }
                if (!this.f11562c) {
                    if (this.f11561b.getParent() == null && (screenFragment = getScreenFragment()) != null) {
                        screenFragment.K(this.f11561b);
                    }
                    if (this.R0) {
                        Integer num = this.f11564e;
                        CustomToolbar customToolbar = this.f11561b;
                        if (num != null) {
                            i10 = num.intValue();
                        } else {
                            i10 = 0;
                        }
                        customToolbar.setPadding(0, i10, 0, 0);
                    } else if (this.f11561b.getPaddingTop() > 0) {
                        this.f11561b.setPadding(0, 0, 0, 0);
                    }
                    appCompatActivity.setSupportActionBar(this.f11561b);
                    ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
                    if (supportActionBar != null) {
                        m.e(supportActionBar, "requireNotNull(...)");
                        this.f11561b.setContentInsetStartWithNavigation(this.V0);
                        CustomToolbar customToolbar2 = this.f11561b;
                        int i11 = this.U0;
                        customToolbar2.setContentInsetsRelative(i11, i11);
                        ScreenStackFragment screenFragment4 = getScreenFragment();
                        if (screenFragment4 == null || !screenFragment4.E() || this.N0) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        supportActionBar.setDisplayHomeAsUpEnabled(z11);
                        this.f11561b.setNavigationOnClickListener(this.W0);
                        ScreenStackFragment screenFragment5 = getScreenFragment();
                        if (screenFragment5 != null) {
                            screenFragment5.L(this.O0);
                        }
                        ScreenStackFragment screenFragment6 = getScreenFragment();
                        if (screenFragment6 != null) {
                            screenFragment6.M(this.f11563d);
                        }
                        supportActionBar.setTitle((CharSequence) this.f11565f);
                        if (TextUtils.isEmpty(this.f11565f)) {
                            this.f11561b.setContentInsetStartWithNavigation(0);
                        }
                        TextView a10 = X0.a(this.f11561b);
                        int i12 = this.f11566g;
                        if (i12 != 0) {
                            this.f11561b.setTitleTextColor(i12);
                        }
                        if (a10 != null) {
                            String str2 = this.f11567h;
                            if (str2 != null || this.f11570w > 0) {
                                Typeface a11 = n.a((Typeface) null, 0, this.f11570w, str2, getContext().getAssets());
                                m.e(a11, "applyStyles(...)");
                                a10.setTypeface(a11);
                            }
                            float f10 = this.f11569j;
                            if (f10 > 0.0f) {
                                a10.setTextSize(f10);
                            }
                        }
                        Integer num2 = this.C;
                        if (num2 != null) {
                            this.f11561b.setBackgroundColor(num2.intValue());
                        }
                        if (!(this.S0 == 0 || (navigationIcon = this.f11561b.getNavigationIcon()) == null)) {
                            navigationIcon.setColorFilter(new PorterDuffColorFilter(this.S0, PorterDuff.Mode.SRC_ATOP));
                        }
                        for (int childCount = this.f11561b.getChildCount() - 1; -1 < childCount; childCount--) {
                            if (this.f11561b.getChildAt(childCount) instanceof ScreenStackHeaderSubview) {
                                this.f11561b.removeViewAt(childCount);
                            }
                        }
                        int size = this.f11560a.size();
                        for (int i13 = 0; i13 < size; i13++) {
                            Object obj = this.f11560a.get(i13);
                            m.e(obj, "get(...)");
                            ScreenStackHeaderSubview screenStackHeaderSubview = (ScreenStackHeaderSubview) obj;
                            ScreenStackHeaderSubview.a type = screenStackHeaderSubview.getType();
                            if (type == ScreenStackHeaderSubview.a.BACK) {
                                View childAt = screenStackHeaderSubview.getChildAt(0);
                                if (childAt instanceof ImageView) {
                                    imageView = (ImageView) childAt;
                                } else {
                                    imageView = null;
                                }
                                if (imageView != null) {
                                    supportActionBar.setHomeAsUpIndicator(imageView.getDrawable());
                                } else {
                                    throw new JSApplicationIllegalArgumentException("Back button header config view should have Image as first child");
                                }
                            } else {
                                Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-2, -1);
                                int i14 = b.f11571a[type.ordinal()];
                                if (i14 == 1) {
                                    if (!this.Q0) {
                                        this.f11561b.setNavigationIcon((Drawable) null);
                                    }
                                    this.f11561b.setTitle((CharSequence) null);
                                    layoutParams.gravity = GravityCompat.START;
                                } else if (i14 == 2) {
                                    layoutParams.gravity = GravityCompat.END;
                                } else if (i14 == 3) {
                                    layoutParams.width = -1;
                                    layoutParams.gravity = 1;
                                    this.f11561b.setTitle((CharSequence) null);
                                }
                                screenStackHeaderSubview.setLayoutParams(layoutParams);
                                this.f11561b.addView(screenStackHeaderSubview);
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                } else if (this.f11561b.getParent() != null && (screenFragment2 = getScreenFragment()) != null) {
                    screenFragment2.I();
                }
            }
        }
    }

    public final void i() {
        this.f11560a.clear();
        g();
    }

    public final void j(int i10) {
        this.f11560a.remove(i10);
        g();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        Integer num;
        super.onAttachedToWindow();
        this.T0 = true;
        int f10 = k1.f(this);
        Context context = getContext();
        m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        e c10 = k1.c((ReactContext) context, getId());
        if (c10 != null) {
            c10.c(new cb.a(f10, getId()));
        }
        if (this.f11564e == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                num = Integer.valueOf(getRootWindowInsets().getInsets(WindowInsets.Type.systemBars()).top);
            } else {
                num = Integer.valueOf(getRootWindowInsets().getSystemWindowInsetTop());
            }
            this.f11564e = num;
        }
        h();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.T0 = false;
        int f10 = k1.f(this);
        Context context = getContext();
        m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        e c10 = k1.c((ReactContext) context, getId());
        if (c10 != null) {
            c10.c(new c(f10, getId()));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    public final void setBackButtonInCustomView(boolean z10) {
        this.Q0 = z10;
    }

    public final void setBackgroundColor(Integer num) {
        this.C = num;
    }

    public final void setDirection(String str) {
        this.f11568i = str;
    }

    public final void setHeaderHidden(boolean z10) {
        this.f11562c = z10;
    }

    public final void setHeaderTranslucent(boolean z10) {
        this.f11563d = z10;
    }

    public final void setHidden(boolean z10) {
        this.f11562c = z10;
    }

    public final void setHideBackButton(boolean z10) {
        this.N0 = z10;
    }

    public final void setHideShadow(boolean z10) {
        this.O0 = z10;
    }

    public final void setTintColor(int i10) {
        this.S0 = i10;
    }

    public final void setTitle(String str) {
        this.f11565f = str;
    }

    public final void setTitleColor(int i10) {
        this.f11566g = i10;
    }

    public final void setTitleFontFamily(String str) {
        this.f11567h = str;
    }

    public final void setTitleFontSize(float f10) {
        this.f11569j = f10;
    }

    public final void setTitleFontWeight(String str) {
        this.f11570w = n.d(str);
    }

    public final void setTopInsetEnabled(boolean z10) {
        this.R0 = z10;
    }

    public final void setTranslucent(boolean z10) {
        this.f11563d = z10;
    }
}
