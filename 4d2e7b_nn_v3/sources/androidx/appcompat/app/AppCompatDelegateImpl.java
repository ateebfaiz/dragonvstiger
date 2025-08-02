package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    private static final int[] A1 = {16842836};
    private static final boolean B1 = (!"robolectric".equals(Build.FINGERPRINT));
    private static final boolean C1 = true;

    /* renamed from: y1  reason: collision with root package name */
    private static final SimpleArrayMap f13890y1 = new SimpleArrayMap();

    /* renamed from: z1  reason: collision with root package name */
    private static final boolean f13891z1 = false;
    ActionMode C;
    ViewPropertyAnimatorCompat N0;
    private boolean O0;
    private boolean P0;
    ViewGroup Q0;
    private TextView R0;
    private View S0;
    private boolean T0;
    private boolean U0;
    boolean V0;
    boolean W0;
    ActionBarContextView X;
    boolean X0;
    PopupWindow Y;
    boolean Y0;
    Runnable Z;
    boolean Z0;

    /* renamed from: a  reason: collision with root package name */
    final Object f13892a;

    /* renamed from: a1  reason: collision with root package name */
    private boolean f13893a1;

    /* renamed from: b  reason: collision with root package name */
    final Context f13894b;

    /* renamed from: b1  reason: collision with root package name */
    private PanelFeatureState[] f13895b1;

    /* renamed from: c  reason: collision with root package name */
    Window f13896c;

    /* renamed from: c1  reason: collision with root package name */
    private PanelFeatureState f13897c1;

    /* renamed from: d  reason: collision with root package name */
    private o f13898d;

    /* renamed from: d1  reason: collision with root package name */
    private boolean f13899d1;

    /* renamed from: e  reason: collision with root package name */
    final AppCompatCallback f13900e;

    /* renamed from: e1  reason: collision with root package name */
    private boolean f13901e1;

    /* renamed from: f  reason: collision with root package name */
    ActionBar f13902f;

    /* renamed from: f1  reason: collision with root package name */
    private boolean f13903f1;

    /* renamed from: g  reason: collision with root package name */
    MenuInflater f13904g;

    /* renamed from: g1  reason: collision with root package name */
    boolean f13905g1;

    /* renamed from: h  reason: collision with root package name */
    private CharSequence f13906h;

    /* renamed from: h1  reason: collision with root package name */
    private Configuration f13907h1;

    /* renamed from: i  reason: collision with root package name */
    private DecorContentParent f13908i;

    /* renamed from: i1  reason: collision with root package name */
    private int f13909i1;

    /* renamed from: j  reason: collision with root package name */
    private h f13910j;

    /* renamed from: j1  reason: collision with root package name */
    private int f13911j1;

    /* renamed from: k1  reason: collision with root package name */
    private int f13912k1;

    /* renamed from: l1  reason: collision with root package name */
    private boolean f13913l1;

    /* renamed from: m1  reason: collision with root package name */
    private q f13914m1;

    /* renamed from: n1  reason: collision with root package name */
    private q f13915n1;

    /* renamed from: o1  reason: collision with root package name */
    boolean f13916o1;

    /* renamed from: p1  reason: collision with root package name */
    int f13917p1;

    /* renamed from: q1  reason: collision with root package name */
    private final Runnable f13918q1;

    /* renamed from: r1  reason: collision with root package name */
    private boolean f13919r1;

    /* renamed from: s1  reason: collision with root package name */
    private Rect f13920s1;

    /* renamed from: t1  reason: collision with root package name */
    private Rect f13921t1;

    /* renamed from: u1  reason: collision with root package name */
    private AppCompatViewInflater f13922u1;

    /* renamed from: v1  reason: collision with root package name */
    private t f13923v1;

    /* renamed from: w  reason: collision with root package name */
    private t f13924w;

    /* renamed from: w1  reason: collision with root package name */
    private OnBackInvokedDispatcher f13925w1;

    /* renamed from: x1  reason: collision with root package name */
    private OnBackInvokedCallback f13926x1;

    private class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        private boolean a(int i10, int i11) {
            if (i10 < -5 || i11 < -5 || i10 > getWidth() + 5 || i11 > getHeight() + 5) {
                return true;
            }
            return false;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (AppCompatDelegateImpl.this.q(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.l(0);
            return true;
        }

        public void setBackgroundResource(int i10) {
            setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), i10));
        }
    }

    protected static final class PanelFeatureState {
        int background;
        View createdPanelView;
        ViewGroup decorView;
        int featureId;
        Bundle frozenActionViewState;
        Bundle frozenMenuState;
        int gravity;
        boolean isHandled;
        boolean isOpen;
        boolean isPrepared;
        ListMenuPresenter listMenuPresenter;
        Context listPresenterContext;
        MenuBuilder menu;
        public boolean qwertyMode;
        boolean refreshDecorView = false;
        boolean refreshMenuContent;
        View shownPanelView;
        boolean wasLastOpen;
        int windowAnimations;

        /* renamed from: x  reason: collision with root package name */
        int f13928x;

        /* renamed from: y  reason: collision with root package name */
        int f13929y;

        @SuppressLint({"BanParcelableUsage"})
        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            int f13930a;

            /* renamed from: b  reason: collision with root package name */
            boolean f13931b;

            /* renamed from: c  reason: collision with root package name */
            Bundle f13932c;

            class a implements Parcelable.ClassLoaderCreator {
                a() {
                }

                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, (ClassLoader) null);
                }

                /* renamed from: b */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                /* renamed from: c */
                public SavedState[] newArray(int i10) {
                    return new SavedState[i10];
                }
            }

            SavedState() {
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f13930a = parcel.readInt();
                boolean z10 = true;
                if (parcel.readInt() != 1) {
                    z10 = false;
                }
                savedState.f13931b = z10;
                if (z10) {
                    savedState.f13932c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f13930a);
                parcel.writeInt(this.f13931b ? 1 : 0);
                if (this.f13931b) {
                    parcel.writeBundle(this.f13932c);
                }
            }
        }

        PanelFeatureState(int i10) {
            this.featureId = i10;
        }

        /* access modifiers changed from: package-private */
        public void applyFrozenState() {
            Bundle bundle;
            MenuBuilder menuBuilder = this.menu;
            if (menuBuilder != null && (bundle = this.frozenMenuState) != null) {
                menuBuilder.restorePresenterStates(bundle);
                this.frozenMenuState = null;
            }
        }

        public void clearMenuPresenters() {
            MenuBuilder menuBuilder = this.menu;
            if (menuBuilder != null) {
                menuBuilder.removeMenuPresenter(this.listMenuPresenter);
            }
            this.listMenuPresenter = null;
        }

        /* access modifiers changed from: package-private */
        public MenuView getListMenuView(MenuPresenter.Callback callback) {
            if (this.menu == null) {
                return null;
            }
            if (this.listMenuPresenter == null) {
                ListMenuPresenter listMenuPresenter2 = new ListMenuPresenter(this.listPresenterContext, R.layout.abc_list_menu_item_layout);
                this.listMenuPresenter = listMenuPresenter2;
                listMenuPresenter2.setCallback(callback);
                this.menu.addMenuPresenter(this.listMenuPresenter);
            }
            return this.listMenuPresenter.getMenuView(this.decorView);
        }

        public boolean hasPanelItems() {
            if (this.shownPanelView == null) {
                return false;
            }
            if (this.createdPanelView != null) {
                return true;
            }
            if (this.listMenuPresenter.getAdapter().getCount() > 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void onRestoreInstanceState(Parcelable parcelable) {
            SavedState savedState = (SavedState) parcelable;
            this.featureId = savedState.f13930a;
            this.wasLastOpen = savedState.f13931b;
            this.frozenMenuState = savedState.f13932c;
            this.shownPanelView = null;
            this.decorView = null;
        }

        /* access modifiers changed from: package-private */
        public Parcelable onSaveInstanceState() {
            SavedState savedState = new SavedState();
            savedState.f13930a = this.featureId;
            savedState.f13931b = this.isOpen;
            if (this.menu != null) {
                Bundle bundle = new Bundle();
                savedState.f13932c = bundle;
                this.menu.savePresenterStates(bundle);
            }
            return savedState;
        }

        /* access modifiers changed from: package-private */
        public void setMenu(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter2;
            MenuBuilder menuBuilder2 = this.menu;
            if (menuBuilder != menuBuilder2) {
                if (menuBuilder2 != null) {
                    menuBuilder2.removeMenuPresenter(this.listMenuPresenter);
                }
                this.menu = menuBuilder;
                if (menuBuilder != null && (listMenuPresenter2 = this.listMenuPresenter) != null) {
                    menuBuilder.addMenuPresenter(listMenuPresenter2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setStyle(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                newTheme.applyStyle(i10, true);
            }
            newTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                newTheme.applyStyle(i11, true);
            } else {
                newTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.listPresenterContext = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.background = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.windowAnimations = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.f13917p1 & 1) != 0) {
                appCompatDelegateImpl.r(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.f13917p1 & 4096) != 0) {
                appCompatDelegateImpl2.r(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.f13916o1 = false;
            appCompatDelegateImpl3.f13917p1 = 0;
        }
    }

    class b implements OnApplyWindowInsetsListener {
        b() {
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int m02 = AppCompatDelegateImpl.this.m0(windowInsetsCompat, (Rect) null);
            if (systemWindowInsetTop != m02) {
                windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), m02, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            }
            return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        }
    }

    class c implements ContentFrameLayout.OnAttachListener {
        c() {
        }

        public void onAttachedFromWindow() {
        }

        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.p();
        }
    }

    class d implements Runnable {

        class a extends ViewPropertyAnimatorListenerAdapter {
            a() {
            }

            public void onAnimationEnd(View view) {
                AppCompatDelegateImpl.this.X.setAlpha(1.0f);
                AppCompatDelegateImpl.this.N0.setListener((ViewPropertyAnimatorListener) null);
                AppCompatDelegateImpl.this.N0 = null;
            }

            public void onAnimationStart(View view) {
                AppCompatDelegateImpl.this.X.setVisibility(0);
            }
        }

        d() {
        }

        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.Y.showAtLocation(appCompatDelegateImpl.X, 55, 0, 0);
            AppCompatDelegateImpl.this.s();
            if (AppCompatDelegateImpl.this.c0()) {
                AppCompatDelegateImpl.this.X.setAlpha(0.0f);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.N0 = ViewCompat.animate(appCompatDelegateImpl2.X).alpha(1.0f);
                AppCompatDelegateImpl.this.N0.setListener(new a());
                return;
            }
            AppCompatDelegateImpl.this.X.setAlpha(1.0f);
            AppCompatDelegateImpl.this.X.setVisibility(0);
        }
    }

    class e extends ViewPropertyAnimatorListenerAdapter {
        e() {
        }

        public void onAnimationEnd(View view) {
            AppCompatDelegateImpl.this.X.setAlpha(1.0f);
            AppCompatDelegateImpl.this.N0.setListener((ViewPropertyAnimatorListener) null);
            AppCompatDelegateImpl.this.N0 = null;
        }

        public void onAnimationStart(View view) {
            AppCompatDelegateImpl.this.X.setVisibility(0);
            if (AppCompatDelegateImpl.this.X.getParent() instanceof View) {
                ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.X.getParent());
            }
        }
    }

    private class f implements ActionBarDrawerToggle.Delegate {
        f() {
        }

        public Context getActionBarThemedContext() {
            return AppCompatDelegateImpl.this.x();
        }

        public Drawable getThemeUpIndicator() {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), (AttributeSet) null, new int[]{R.attr.homeAsUpIndicator});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public boolean isNavigationVisible() {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) {
                return false;
            }
            return true;
        }

        public void setActionBarDescription(int i10) {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i10);
            }
        }

        public void setActionBarUpIndicator(Drawable drawable, int i10) {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeAsUpIndicator(drawable);
                supportActionBar.setHomeActionContentDescription(i10);
            }
        }
    }

    interface g {
        boolean a(int i10);

        View onCreatePanelView(int i10);
    }

    private final class h implements MenuPresenter.Callback {
        h() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
            AppCompatDelegateImpl.this.j(menuBuilder);
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback E = AppCompatDelegateImpl.this.E();
            if (E == null) {
                return true;
            }
            E.onMenuOpened(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, menuBuilder);
            return true;
        }
    }

    class i implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        private ActionMode.Callback f13941a;

        class a extends ViewPropertyAnimatorListenerAdapter {
            a() {
            }

            public void onAnimationEnd(View view) {
                AppCompatDelegateImpl.this.X.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.Y;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.X.getParent() instanceof View) {
                    ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.X.getParent());
                }
                AppCompatDelegateImpl.this.X.killMode();
                AppCompatDelegateImpl.this.N0.setListener((ViewPropertyAnimatorListener) null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.N0 = null;
                ViewCompat.requestApplyInsets(appCompatDelegateImpl2.Q0);
            }
        }

        public i(ActionMode.Callback callback) {
            this.f13941a = callback;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f13941a.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f13941a.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f13941a.onDestroyActionMode(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.Y != null) {
                appCompatDelegateImpl.f13896c.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.Z);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.X != null) {
                appCompatDelegateImpl2.s();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.N0 = ViewCompat.animate(appCompatDelegateImpl3.X).alpha(0.0f);
                AppCompatDelegateImpl.this.N0.setListener(new a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            AppCompatCallback appCompatCallback = appCompatDelegateImpl4.f13900e;
            if (appCompatCallback != null) {
                appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl4.C);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.C = null;
            ViewCompat.requestApplyInsets(appCompatDelegateImpl5.Q0);
            AppCompatDelegateImpl.this.k0();
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            ViewCompat.requestApplyInsets(AppCompatDelegateImpl.this.Q0);
            return this.f13941a.onPrepareActionMode(actionMode, menu);
        }
    }

    static class j {
        static Context a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        static void b(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i10 = configuration.densityDpi;
            int i11 = configuration2.densityDpi;
            if (i10 != i11) {
                configuration3.densityDpi = i11;
            }
        }

        @DoNotInline
        static void c(Configuration configuration, Locale locale) {
            configuration.setLayoutDirection(locale);
        }

        @DoNotInline
        static void d(Configuration configuration, Locale locale) {
            configuration.setLocale(locale);
        }
    }

    static class k {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        @DoNotInline
        static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    static class l {
        @DoNotInline
        static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            LocaleList a10 = configuration.getLocales();
            LocaleList a11 = configuration2.getLocales();
            if (!a10.equals(a11)) {
                configuration3.setLocales(a11);
                configuration3.locale = configuration2.locale;
            }
        }

        @DoNotInline
        static LocaleListCompat b(Configuration configuration) {
            return LocaleListCompat.forLanguageTags(configuration.getLocales().toLanguageTags());
        }

        @DoNotInline
        public static void c(LocaleListCompat localeListCompat) {
            LocaleList.setDefault(LocaleList.forLanguageTags(localeListCompat.toLanguageTags()));
        }

        @DoNotInline
        static void d(Configuration configuration, LocaleListCompat localeListCompat) {
            configuration.setLocales(LocaleList.forLanguageTags(localeListCompat.toLanguageTags()));
        }
    }

    static class m {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode = configuration3.colorMode | (configuration2.colorMode & 3);
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode = configuration3.colorMode | (configuration2.colorMode & 12);
            }
        }
    }

    static class n {
        @DoNotInline
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        @DoNotInline
        static OnBackInvokedCallback b(Object obj, AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            p pVar = new p(appCompatDelegateImpl);
            l.a(obj).registerOnBackInvokedCallback(1000000, pVar);
            return pVar;
        }

        @DoNotInline
        static void c(Object obj, Object obj2) {
            l.a(obj).unregisterOnBackInvokedCallback(k.a(obj2));
        }
    }

    class o extends WindowCallbackWrapper {

        /* renamed from: a  reason: collision with root package name */
        private g f13944a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f13945b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f13946c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f13947d;

        o(Window.Callback callback) {
            super(callback);
        }

        /* JADX INFO: finally extract failed */
        public boolean a(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f13946c = true;
                boolean dispatchKeyEvent = callback.dispatchKeyEvent(keyEvent);
                this.f13946c = false;
                return dispatchKeyEvent;
            } catch (Throwable th) {
                this.f13946c = false;
                throw th;
            }
        }

        /* JADX INFO: finally extract failed */
        public void b(Window.Callback callback) {
            try {
                this.f13945b = true;
                callback.onContentChanged();
                this.f13945b = false;
            } catch (Throwable th) {
                this.f13945b = false;
                throw th;
            }
        }

        /* JADX INFO: finally extract failed */
        public void c(Window.Callback callback, int i10, Menu menu) {
            try {
                this.f13947d = true;
                callback.onPanelClosed(i10, menu);
                this.f13947d = false;
            } catch (Throwable th) {
                this.f13947d = false;
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public void d(g gVar) {
            this.f13944a = gVar;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.f13946c) {
                return getWrapped().dispatchKeyEvent(keyEvent);
            }
            if (AppCompatDelegateImpl.this.q(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.O(keyEvent.getKeyCode(), keyEvent)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final android.view.ActionMode e(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImpl.this.f13894b, callback);
            androidx.appcompat.view.ActionMode startSupportActionMode = AppCompatDelegateImpl.this.startSupportActionMode(callbackWrapper);
            if (startSupportActionMode != null) {
                return callbackWrapper.getActionModeWrapper(startSupportActionMode);
            }
            return null;
        }

        public void onContentChanged() {
            if (this.f13945b) {
                getWrapped().onContentChanged();
            }
        }

        public boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i10, menu);
            }
            return false;
        }

        public View onCreatePanelView(int i10) {
            View onCreatePanelView;
            g gVar = this.f13944a;
            if (gVar == null || (onCreatePanelView = gVar.onCreatePanelView(i10)) == null) {
                return super.onCreatePanelView(i10);
            }
            return onCreatePanelView;
        }

        public boolean onMenuOpened(int i10, Menu menu) {
            super.onMenuOpened(i10, menu);
            AppCompatDelegateImpl.this.R(i10);
            return true;
        }

        public void onPanelClosed(int i10, Menu menu) {
            if (this.f13947d) {
                getWrapped().onPanelClosed(i10, menu);
                return;
            }
            super.onPanelClosed(i10, menu);
            AppCompatDelegateImpl.this.S(i10);
        }

        public boolean onPreparePanel(int i10, View view, Menu menu) {
            MenuBuilder menuBuilder;
            if (menu instanceof MenuBuilder) {
                menuBuilder = (MenuBuilder) menu;
            } else {
                menuBuilder = null;
            }
            if (i10 == 0 && menuBuilder == null) {
                return false;
            }
            boolean z10 = true;
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            g gVar = this.f13944a;
            if (gVar == null || !gVar.a(i10)) {
                z10 = false;
            }
            if (!z10) {
                z10 = super.onPreparePanel(i10, view, menu);
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return z10;
        }

        public void onProvideKeyboardShortcuts(List list, Menu menu, int i10) {
            MenuBuilder menuBuilder;
            PanelFeatureState C = AppCompatDelegateImpl.this.C(0, true);
            if (C == null || (menuBuilder = C.menu) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i10);
            } else {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i10);
            }
        }

        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
            if (!AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled() || i10 != 0) {
                return super.onWindowStartingActionMode(callback, i10);
            }
            return e(callback);
        }
    }

    private class p extends q {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f13949c;

        p(Context context) {
            super();
            this.f13949c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        /* access modifiers changed from: package-private */
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        public int c() {
            if (k.a(this.f13949c)) {
                return 2;
            }
            return 1;
        }

        public void d() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    abstract class q {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f13951a;

        class a extends BroadcastReceiver {
            a() {
            }

            public void onReceive(Context context, Intent intent) {
                q.this.d();
            }
        }

        q() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            BroadcastReceiver broadcastReceiver = this.f13951a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f13894b.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f13951a = null;
            }
        }

        /* access modifiers changed from: package-private */
        public abstract IntentFilter b();

        /* access modifiers changed from: package-private */
        public abstract int c();

        /* access modifiers changed from: package-private */
        public abstract void d();

        /* access modifiers changed from: package-private */
        public void e() {
            a();
            IntentFilter b10 = b();
            if (b10 != null && b10.countActions() != 0) {
                if (this.f13951a == null) {
                    this.f13951a = new a();
                }
                AppCompatDelegateImpl.this.f13894b.registerReceiver(this.f13951a, b10);
            }
        }
    }

    private class r extends q {

        /* renamed from: c  reason: collision with root package name */
        private final y f13954c;

        r(y yVar) {
            super();
            this.f13954c = yVar;
        }

        /* access modifiers changed from: package-private */
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        public int c() {
            if (this.f13954c.d()) {
                return 2;
            }
            return 1;
        }

        public void d() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    private static class s {
        static void a(android.view.ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    private final class t implements MenuPresenter.Callback {
        t() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
            boolean z11;
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            if (rootMenu != menuBuilder) {
                z11 = true;
            } else {
                z11 = false;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z11) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState v10 = appCompatDelegateImpl.v(menuBuilder);
            if (v10 == null) {
                return;
            }
            if (z11) {
                AppCompatDelegateImpl.this.i(v10.featureId, v10, rootMenu);
                AppCompatDelegateImpl.this.m(v10, true);
                return;
            }
            AppCompatDelegateImpl.this.m(v10, z10);
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback E;
            if (menuBuilder != menuBuilder.getRootMenu()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.V0 || (E = appCompatDelegateImpl.E()) == null || AppCompatDelegateImpl.this.f13905g1) {
                return true;
            }
            E.onMenuOpened(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, menuBuilder);
            return true;
        }
    }

    AppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this(activity, (Window) null, appCompatCallback, activity);
    }

    private q A(Context context) {
        if (this.f13914m1 == null) {
            this.f13914m1 = new r(y.a(context));
        }
        return this.f13914m1;
    }

    private void F() {
        t();
        if (this.V0 && this.f13902f == null) {
            Object obj = this.f13892a;
            if (obj instanceof Activity) {
                this.f13902f = new WindowDecorActionBar((Activity) this.f13892a, this.W0);
            } else if (obj instanceof Dialog) {
                this.f13902f = new WindowDecorActionBar((Dialog) this.f13892a);
            }
            ActionBar actionBar = this.f13902f;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.f13919r1);
            }
        }
    }

    private boolean G(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.createdPanelView;
        if (view != null) {
            panelFeatureState.shownPanelView = view;
            return true;
        } else if (panelFeatureState.menu == null) {
            return false;
        } else {
            if (this.f13924w == null) {
                this.f13924w = new t();
            }
            View view2 = (View) panelFeatureState.getListMenuView(this.f13924w);
            panelFeatureState.shownPanelView = view2;
            if (view2 != null) {
                return true;
            }
            return false;
        }
    }

    private boolean H(PanelFeatureState panelFeatureState) {
        panelFeatureState.setStyle(x());
        panelFeatureState.decorView = new ListMenuDecorView(panelFeatureState.listPresenterContext);
        panelFeatureState.gravity = 81;
        return true;
    }

    private boolean I(PanelFeatureState panelFeatureState) {
        Resources.Theme theme;
        Context context = this.f13894b;
        int i10 = panelFeatureState.featureId;
        if ((i10 == 0 || i10 == 108) && this.f13908i != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme2 = context.getTheme();
            theme2.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme = context.getResources().newTheme();
                theme.setTo(theme2);
                theme.applyStyle(typedValue.resourceId, true);
                theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                theme = null;
            }
            if (typedValue.resourceId != 0) {
                if (theme == null) {
                    theme = context.getResources().newTheme();
                    theme.setTo(theme2);
                }
                theme.applyStyle(typedValue.resourceId, true);
            }
            if (theme != null) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme);
                context = contextThemeWrapper;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.setCallback(this);
        panelFeatureState.setMenu(menuBuilder);
        return true;
    }

    private void J(int i10) {
        this.f13917p1 = (1 << i10) | this.f13917p1;
        if (!this.f13916o1) {
            ViewCompat.postOnAnimation(this.f13896c.getDecorView(), this.f13918q1);
            this.f13916o1 = true;
        }
    }

    private boolean N(int i10, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState C2 = C(i10, true);
        if (!C2.isOpen) {
            return X(C2, keyEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean Q(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            androidx.appcompat.view.ActionMode r0 = r4.C
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r4.C(r5, r0)
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.DecorContentParent r5 = r4.f13908i
            if (r5 == 0) goto L_0x0043
            boolean r5 = r5.canShowOverflowMenu()
            if (r5 == 0) goto L_0x0043
            android.content.Context r5 = r4.f13894b
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.DecorContentParent r5 = r4.f13908i
            boolean r5 = r5.isOverflowMenuShowing()
            if (r5 != 0) goto L_0x003c
            boolean r5 = r4.f13905g1
            if (r5 != 0) goto L_0x0062
            boolean r5 = r4.X(r2, r6)
            if (r5 == 0) goto L_0x0062
            androidx.appcompat.widget.DecorContentParent r5 = r4.f13908i
            boolean r0 = r5.showOverflowMenu()
            goto L_0x0068
        L_0x003c:
            androidx.appcompat.widget.DecorContentParent r5 = r4.f13908i
            boolean r0 = r5.hideOverflowMenu()
            goto L_0x0068
        L_0x0043:
            boolean r5 = r2.isOpen
            if (r5 != 0) goto L_0x0064
            boolean r3 = r2.isHandled
            if (r3 == 0) goto L_0x004c
            goto L_0x0064
        L_0x004c:
            boolean r5 = r2.isPrepared
            if (r5 == 0) goto L_0x0062
            boolean r5 = r2.refreshMenuContent
            if (r5 == 0) goto L_0x005b
            r2.isPrepared = r1
            boolean r5 = r4.X(r2, r6)
            goto L_0x005c
        L_0x005b:
            r5 = r0
        L_0x005c:
            if (r5 == 0) goto L_0x0062
            r4.U(r2, r6)
            goto L_0x0068
        L_0x0062:
            r0 = r1
            goto L_0x0068
        L_0x0064:
            r4.m(r2, r0)
            r0 = r5
        L_0x0068:
            if (r0 == 0) goto L_0x0085
            android.content.Context r5 = r4.f13894b
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r6 = "audio"
            java.lang.Object r5 = r5.getSystemService(r6)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x007e
            r5.playSoundEffect(r1)
            goto L_0x0085
        L_0x007e:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r6 = "Couldn't get audio manager"
            android.util.Log.w(r5, r6)
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.Q(int, android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void U(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r12, android.view.KeyEvent r13) {
        /*
            r11 = this;
            boolean r0 = r12.isOpen
            if (r0 != 0) goto L_0x00f3
            boolean r0 = r11.f13905g1
            if (r0 == 0) goto L_0x000a
            goto L_0x00f3
        L_0x000a:
            int r0 = r12.featureId
            if (r0 != 0) goto L_0x0020
            android.content.Context r0 = r11.f13894b
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.screenLayout
            r0 = r0 & 15
            r1 = 4
            if (r0 != r1) goto L_0x0020
            return
        L_0x0020:
            android.view.Window$Callback r0 = r11.E()
            r1 = 1
            if (r0 == 0) goto L_0x0035
            int r2 = r12.featureId
            androidx.appcompat.view.menu.MenuBuilder r3 = r12.menu
            boolean r0 = r0.onMenuOpened(r2, r3)
            if (r0 != 0) goto L_0x0035
            r11.m(r12, r1)
            return
        L_0x0035:
            android.content.Context r0 = r11.f13894b
            java.lang.String r2 = "window"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            if (r0 != 0) goto L_0x0042
            return
        L_0x0042:
            boolean r13 = r11.X(r12, r13)
            if (r13 != 0) goto L_0x0049
            return
        L_0x0049:
            android.view.ViewGroup r13 = r12.decorView
            r2 = -2
            if (r13 == 0) goto L_0x0064
            boolean r3 = r12.refreshDecorView
            if (r3 == 0) goto L_0x0053
            goto L_0x0064
        L_0x0053:
            android.view.View r13 = r12.createdPanelView
            if (r13 == 0) goto L_0x00c6
            android.view.ViewGroup$LayoutParams r13 = r13.getLayoutParams()
            if (r13 == 0) goto L_0x00c6
            int r13 = r13.width
            r3 = -1
            if (r13 != r3) goto L_0x00c6
            r4 = r3
            goto L_0x00c7
        L_0x0064:
            if (r13 != 0) goto L_0x0071
            boolean r13 = r11.H(r12)
            if (r13 == 0) goto L_0x0070
            android.view.ViewGroup r13 = r12.decorView
            if (r13 != 0) goto L_0x0080
        L_0x0070:
            return
        L_0x0071:
            boolean r3 = r12.refreshDecorView
            if (r3 == 0) goto L_0x0080
            int r13 = r13.getChildCount()
            if (r13 <= 0) goto L_0x0080
            android.view.ViewGroup r13 = r12.decorView
            r13.removeAllViews()
        L_0x0080:
            boolean r13 = r11.G(r12)
            if (r13 == 0) goto L_0x00f1
            boolean r13 = r12.hasPanelItems()
            if (r13 != 0) goto L_0x008d
            goto L_0x00f1
        L_0x008d:
            android.view.View r13 = r12.shownPanelView
            android.view.ViewGroup$LayoutParams r13 = r13.getLayoutParams()
            if (r13 != 0) goto L_0x009a
            android.view.ViewGroup$LayoutParams r13 = new android.view.ViewGroup$LayoutParams
            r13.<init>(r2, r2)
        L_0x009a:
            int r3 = r12.background
            android.view.ViewGroup r4 = r12.decorView
            r4.setBackgroundResource(r3)
            android.view.View r3 = r12.shownPanelView
            android.view.ViewParent r3 = r3.getParent()
            boolean r4 = r3 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x00b2
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            android.view.View r4 = r12.shownPanelView
            r3.removeView(r4)
        L_0x00b2:
            android.view.ViewGroup r3 = r12.decorView
            android.view.View r4 = r12.shownPanelView
            r3.addView(r4, r13)
            android.view.View r13 = r12.shownPanelView
            boolean r13 = r13.hasFocus()
            if (r13 != 0) goto L_0x00c6
            android.view.View r13 = r12.shownPanelView
            r13.requestFocus()
        L_0x00c6:
            r4 = r2
        L_0x00c7:
            r13 = 0
            r12.isHandled = r13
            android.view.WindowManager$LayoutParams r13 = new android.view.WindowManager$LayoutParams
            int r6 = r12.f13928x
            int r7 = r12.f13929y
            r9 = 8519680(0x820000, float:1.1938615E-38)
            r10 = -3
            r5 = -2
            r8 = 1002(0x3ea, float:1.404E-42)
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            int r2 = r12.gravity
            r13.gravity = r2
            int r2 = r12.windowAnimations
            r13.windowAnimations = r2
            android.view.ViewGroup r2 = r12.decorView
            r0.addView(r2, r13)
            r12.isOpen = r1
            int r12 = r12.featureId
            if (r12 != 0) goto L_0x00f0
            r11.k0()
        L_0x00f0:
            return
        L_0x00f1:
            r12.refreshDecorView = r1
        L_0x00f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.U(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    private boolean W(PanelFeatureState panelFeatureState, int i10, KeyEvent keyEvent, int i11) {
        MenuBuilder menuBuilder;
        boolean z10 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.isPrepared || X(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.menu) != null) {
            z10 = menuBuilder.performShortcut(i10, keyEvent, i11);
        }
        if (z10 && (i11 & 1) == 0 && this.f13908i == null) {
            m(panelFeatureState, true);
        }
        return z10;
    }

    private boolean X(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        boolean z10;
        int i10;
        boolean z11;
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        if (this.f13905g1) {
            return false;
        }
        if (panelFeatureState.isPrepared) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.f13897c1;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            m(panelFeatureState2, false);
        }
        Window.Callback E = E();
        if (E != null) {
            panelFeatureState.createdPanelView = E.onCreatePanelView(panelFeatureState.featureId);
        }
        int i11 = panelFeatureState.featureId;
        if (i11 == 0 || i11 == 108) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && (decorContentParent3 = this.f13908i) != null) {
            decorContentParent3.setMenuPrepared();
        }
        if (panelFeatureState.createdPanelView == null && (!z10 || !(V() instanceof ToolbarActionBar))) {
            MenuBuilder menuBuilder = panelFeatureState.menu;
            if (menuBuilder == null || panelFeatureState.refreshMenuContent) {
                if (menuBuilder == null && (!I(panelFeatureState) || panelFeatureState.menu == null)) {
                    return false;
                }
                if (z10 && this.f13908i != null) {
                    if (this.f13910j == null) {
                        this.f13910j = new h();
                    }
                    this.f13908i.setMenu(panelFeatureState.menu, this.f13910j);
                }
                panelFeatureState.menu.stopDispatchingItemsChanged();
                if (!E.onCreatePanelMenu(panelFeatureState.featureId, panelFeatureState.menu)) {
                    panelFeatureState.setMenu((MenuBuilder) null);
                    if (z10 && (decorContentParent2 = this.f13908i) != null) {
                        decorContentParent2.setMenu((Menu) null, this.f13910j);
                    }
                    return false;
                }
                panelFeatureState.refreshMenuContent = false;
            }
            panelFeatureState.menu.stopDispatchingItemsChanged();
            Bundle bundle = panelFeatureState.frozenActionViewState;
            if (bundle != null) {
                panelFeatureState.menu.restoreActionViewStates(bundle);
                panelFeatureState.frozenActionViewState = null;
            }
            if (!E.onPreparePanel(0, panelFeatureState.createdPanelView, panelFeatureState.menu)) {
                if (z10 && (decorContentParent = this.f13908i) != null) {
                    decorContentParent.setMenu((Menu) null, this.f13910j);
                }
                panelFeatureState.menu.startDispatchingItemsChanged();
                return false;
            }
            if (keyEvent != null) {
                i10 = keyEvent.getDeviceId();
            } else {
                i10 = -1;
            }
            if (KeyCharacterMap.load(i10).getKeyboardType() != 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            panelFeatureState.qwertyMode = z11;
            panelFeatureState.menu.setQwertyMode(z11);
            panelFeatureState.menu.startDispatchingItemsChanged();
        }
        panelFeatureState.isPrepared = true;
        panelFeatureState.isHandled = false;
        this.f13897c1 = panelFeatureState;
        return true;
    }

    private void Y(boolean z10) {
        DecorContentParent decorContentParent = this.f13908i;
        if (decorContentParent == null || !decorContentParent.canShowOverflowMenu() || (ViewConfiguration.get(this.f13894b).hasPermanentMenuKey() && !this.f13908i.isOverflowMenuShowPending())) {
            PanelFeatureState C2 = C(0, true);
            C2.refreshDecorView = true;
            m(C2, false);
            U(C2, (KeyEvent) null);
            return;
        }
        Window.Callback E = E();
        if (this.f13908i.isOverflowMenuShowing() && z10) {
            this.f13908i.hideOverflowMenu();
            if (!this.f13905g1) {
                E.onPanelClosed(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, C(0, true).menu);
            }
        } else if (E != null && !this.f13905g1) {
            if (this.f13916o1 && (this.f13917p1 & 1) != 0) {
                this.f13896c.getDecorView().removeCallbacks(this.f13918q1);
                this.f13918q1.run();
            }
            PanelFeatureState C3 = C(0, true);
            MenuBuilder menuBuilder = C3.menu;
            if (menuBuilder != null && !C3.refreshMenuContent && E.onPreparePanel(0, C3.createdPanelView, menuBuilder)) {
                E.onMenuOpened(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, C3.menu);
                this.f13908i.showOverflowMenu();
            }
        }
    }

    private int Z(int i10) {
        if (i10 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR;
        } else if (i10 != 9) {
            return i10;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
        }
    }

    private boolean c(boolean z10) {
        return d(z10, true);
    }

    private boolean d(boolean z10, boolean z11) {
        LocaleListCompat localeListCompat;
        if (this.f13905g1) {
            return false;
        }
        int h10 = h();
        int K = K(this.f13894b, h10);
        if (Build.VERSION.SDK_INT < 33) {
            localeListCompat = g(this.f13894b);
        } else {
            localeListCompat = null;
        }
        if (!z11 && localeListCompat != null) {
            localeListCompat = B(this.f13894b.getResources().getConfiguration());
        }
        boolean j02 = j0(K, localeListCompat, z10);
        if (h10 == 0) {
            A(this.f13894b).e();
        } else {
            q qVar = this.f13914m1;
            if (qVar != null) {
                qVar.a();
            }
        }
        if (h10 == 3) {
            z(this.f13894b).e();
        } else {
            q qVar2 = this.f13915n1;
            if (qVar2 != null) {
                qVar2.a();
            }
        }
        return j02;
    }

    private boolean d0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f13896c.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.isAttachedToWindow((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void e() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.Q0.findViewById(16908290);
        View decorView = this.f13896c.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f13894b.obtainStyledAttributes(R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void f(Window window) {
        if (this.f13896c == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof o)) {
                o oVar = new o(callback);
                this.f13898d = oVar;
                window.setCallback(oVar);
                TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f13894b, (AttributeSet) null, A1);
                Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
                if (drawableIfKnown != null) {
                    window.setBackgroundDrawable(drawableIfKnown);
                }
                obtainStyledAttributes.recycle();
                this.f13896c = window;
                if (Build.VERSION.SDK_INT >= 33 && this.f13925w1 == null) {
                    setOnBackInvokedDispatcher((OnBackInvokedDispatcher) null);
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private void g0() {
        if (this.P0) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int h() {
        int i10 = this.f13909i1;
        if (i10 != -100) {
            return i10;
        }
        return AppCompatDelegate.getDefaultNightMode();
    }

    private AppCompatActivity h0() {
        Context context = this.f13894b;
        while (context != null) {
            if (!(context instanceof AppCompatActivity)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (AppCompatActivity) context;
            }
        }
        return null;
    }

    private void i0(Configuration configuration) {
        Activity activity = (Activity) this.f13892a;
        if (activity instanceof LifecycleOwner) {
            if (((LifecycleOwner) activity).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else if (this.f13903f1 && !this.f13905g1) {
            activity.onConfigurationChanged(configuration);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean j0(int r9, androidx.core.os.LocaleListCompat r10, boolean r11) {
        /*
            r8 = this;
            android.content.Context r1 = r8.f13894b
            r4 = 0
            r5 = 0
            r0 = r8
            r2 = r9
            r3 = r10
            android.content.res.Configuration r0 = r0.n(r1, r2, r3, r4, r5)
            android.content.Context r1 = r8.f13894b
            int r1 = r8.y(r1)
            android.content.res.Configuration r2 = r8.f13907h1
            if (r2 != 0) goto L_0x001f
            android.content.Context r2 = r8.f13894b
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L_0x001f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            androidx.core.os.LocaleListCompat r2 = r8.B(r2)
            r5 = 0
            if (r10 != 0) goto L_0x0030
            r0 = r5
            goto L_0x0034
        L_0x0030:
            androidx.core.os.LocaleListCompat r0 = r8.B(r0)
        L_0x0034:
            r6 = 0
            if (r3 == r4) goto L_0x003a
            r3 = 512(0x200, float:7.175E-43)
            goto L_0x003b
        L_0x003a:
            r3 = r6
        L_0x003b:
            if (r0 == 0) goto L_0x0045
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0045
            r3 = r3 | 8196(0x2004, float:1.1485E-41)
        L_0x0045:
            int r2 = ~r1
            r2 = r2 & r3
            r7 = 1
            if (r2 == 0) goto L_0x006f
            if (r11 == 0) goto L_0x006f
            boolean r11 = r8.f13901e1
            if (r11 == 0) goto L_0x006f
            boolean r11 = B1
            if (r11 != 0) goto L_0x0058
            boolean r11 = r8.f13903f1
            if (r11 == 0) goto L_0x006f
        L_0x0058:
            java.lang.Object r11 = r8.f13892a
            boolean r2 = r11 instanceof android.app.Activity
            if (r2 == 0) goto L_0x006f
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r11 = r11.isChild()
            if (r11 != 0) goto L_0x006f
            java.lang.Object r11 = r8.f13892a
            android.app.Activity r11 = (android.app.Activity) r11
            androidx.core.app.ActivityCompat.recreate(r11)
            r11 = r7
            goto L_0x0070
        L_0x006f:
            r11 = r6
        L_0x0070:
            if (r11 != 0) goto L_0x007d
            if (r3 == 0) goto L_0x007d
            r11 = r3 & r1
            if (r11 != r3) goto L_0x0079
            r6 = r7
        L_0x0079:
            r8.l0(r4, r0, r6, r5)
            goto L_0x007e
        L_0x007d:
            r7 = r11
        L_0x007e:
            if (r7 == 0) goto L_0x009a
            java.lang.Object r11 = r8.f13892a
            boolean r1 = r11 instanceof androidx.appcompat.app.AppCompatActivity
            if (r1 == 0) goto L_0x009a
            r1 = r3 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x008f
            androidx.appcompat.app.AppCompatActivity r11 = (androidx.appcompat.app.AppCompatActivity) r11
            r11.onNightModeChanged(r9)
        L_0x008f:
            r9 = r3 & 4
            if (r9 == 0) goto L_0x009a
            java.lang.Object r9 = r8.f13892a
            androidx.appcompat.app.AppCompatActivity r9 = (androidx.appcompat.app.AppCompatActivity) r9
            r9.onLocalesChanged(r10)
        L_0x009a:
            if (r7 == 0) goto L_0x00af
            if (r0 == 0) goto L_0x00af
            android.content.Context r9 = r8.f13894b
            android.content.res.Resources r9 = r9.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            androidx.core.os.LocaleListCompat r9 = r8.B(r9)
            r8.b0(r9)
        L_0x00af:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.j0(int, androidx.core.os.LocaleListCompat, boolean):boolean");
    }

    private void k() {
        q qVar = this.f13914m1;
        if (qVar != null) {
            qVar.a();
        }
        q qVar2 = this.f13915n1;
        if (qVar2 != null) {
            qVar2.a();
        }
    }

    private void l0(int i10, LocaleListCompat localeListCompat, boolean z10, Configuration configuration) {
        Resources resources = this.f13894b.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i10 | (resources.getConfiguration().uiMode & -49);
        if (localeListCompat != null) {
            a0(configuration2, localeListCompat);
        }
        resources.updateConfiguration(configuration2, (DisplayMetrics) null);
        if (Build.VERSION.SDK_INT < 26) {
            w.a(resources);
        }
        int i11 = this.f13911j1;
        if (i11 != 0) {
            this.f13894b.setTheme(i11);
            this.f13894b.getTheme().applyStyle(this.f13911j1, true);
        }
        if (z10 && (this.f13892a instanceof Activity)) {
            i0(configuration2);
        }
    }

    private Configuration n(Context context, int i10, LocaleListCompat localeListCompat, Configuration configuration, boolean z10) {
        int i11;
        if (i10 == 1) {
            i11 = 16;
        } else if (i10 == 2) {
            i11 = 32;
        } else if (z10) {
            i11 = 0;
        } else {
            i11 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i11 | (configuration2.uiMode & -49);
        if (localeListCompat != null) {
            a0(configuration2, localeListCompat);
        }
        return configuration2;
    }

    private void n0(View view) {
        int i10;
        if ((ViewCompat.getWindowSystemUiVisibility(view) & 8192) != 0) {
            i10 = ContextCompat.getColor(this.f13894b, R.color.abc_decor_view_status_guard_light);
        } else {
            i10 = ContextCompat.getColor(this.f13894b, R.color.abc_decor_view_status_guard);
        }
        view.setBackgroundColor(i10);
    }

    private ViewGroup o() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f13894b.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
                requestWindowFeature(1);
            } else if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
                requestWindowFeature(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                requestWindowFeature(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                requestWindowFeature(10);
            }
            this.Y0 = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            u();
            this.f13896c.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f13894b);
            if (this.Z0) {
                viewGroup = this.X0 ? (ViewGroup) from.inflate(R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R.layout.abc_screen_simple, (ViewGroup) null);
            } else if (this.Y0) {
                viewGroup = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
                this.W0 = false;
                this.V0 = false;
            } else if (this.V0) {
                TypedValue typedValue = new TypedValue();
                this.f13894b.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new ContextThemeWrapper(this.f13894b, typedValue.resourceId);
                } else {
                    context = this.f13894b;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
                DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(R.id.decor_content_parent);
                this.f13908i = decorContentParent;
                decorContentParent.setWindowCallback(E());
                if (this.W0) {
                    this.f13908i.initFeature(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                }
                if (this.T0) {
                    this.f13908i.initFeature(2);
                }
                if (this.U0) {
                    this.f13908i.initFeature(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new b());
                if (this.f13908i == null) {
                    this.R0 = (TextView) viewGroup.findViewById(R.id.title);
                }
                ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f13896c.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.f13896c.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new c());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.V0 + ", windowActionBarOverlay: " + this.W0 + ", android:windowIsFloating: " + this.Y0 + ", windowActionModeOverlay: " + this.X0 + ", windowNoTitle: " + this.Z0 + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void t() {
        if (!this.P0) {
            this.Q0 = o();
            CharSequence D = D();
            if (!TextUtils.isEmpty(D)) {
                DecorContentParent decorContentParent = this.f13908i;
                if (decorContentParent != null) {
                    decorContentParent.setWindowTitle(D);
                } else if (V() != null) {
                    V().setWindowTitle(D);
                } else {
                    TextView textView = this.R0;
                    if (textView != null) {
                        textView.setText(D);
                    }
                }
            }
            e();
            T(this.Q0);
            this.P0 = true;
            PanelFeatureState C2 = C(0, false);
            if (this.f13905g1) {
                return;
            }
            if (C2 == null || C2.menu == null) {
                J(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
            }
        }
    }

    private void u() {
        if (this.f13896c == null) {
            Object obj = this.f13892a;
            if (obj instanceof Activity) {
                f(((Activity) obj).getWindow());
            }
        }
        if (this.f13896c == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration w(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (!(configuration2 == null || configuration.diff(configuration2) == 0)) {
            float f10 = configuration.fontScale;
            float f11 = configuration2.fontScale;
            if (f10 != f11) {
                configuration3.fontScale = f11;
            }
            int i10 = configuration.mcc;
            int i11 = configuration2.mcc;
            if (i10 != i11) {
                configuration3.mcc = i11;
            }
            int i12 = configuration.mnc;
            int i13 = configuration2.mnc;
            if (i12 != i13) {
                configuration3.mnc = i13;
            }
            int i14 = Build.VERSION.SDK_INT;
            if (i14 >= 24) {
                l.a(configuration, configuration2, configuration3);
            } else if (!ObjectsCompat.equals(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i15 = configuration.touchscreen;
            int i16 = configuration2.touchscreen;
            if (i15 != i16) {
                configuration3.touchscreen = i16;
            }
            int i17 = configuration.keyboard;
            int i18 = configuration2.keyboard;
            if (i17 != i18) {
                configuration3.keyboard = i18;
            }
            int i19 = configuration.keyboardHidden;
            int i20 = configuration2.keyboardHidden;
            if (i19 != i20) {
                configuration3.keyboardHidden = i20;
            }
            int i21 = configuration.navigation;
            int i22 = configuration2.navigation;
            if (i21 != i22) {
                configuration3.navigation = i22;
            }
            int i23 = configuration.navigationHidden;
            int i24 = configuration2.navigationHidden;
            if (i23 != i24) {
                configuration3.navigationHidden = i24;
            }
            int i25 = configuration.orientation;
            int i26 = configuration2.orientation;
            if (i25 != i26) {
                configuration3.orientation = i26;
            }
            int i27 = configuration.screenLayout & 15;
            int i28 = configuration2.screenLayout;
            if (i27 != (i28 & 15)) {
                configuration3.screenLayout |= i28 & 15;
            }
            int i29 = configuration.screenLayout & 192;
            int i30 = configuration2.screenLayout;
            if (i29 != (i30 & 192)) {
                configuration3.screenLayout |= i30 & 192;
            }
            int i31 = configuration.screenLayout & 48;
            int i32 = configuration2.screenLayout;
            if (i31 != (i32 & 48)) {
                configuration3.screenLayout |= i32 & 48;
            }
            int i33 = configuration.screenLayout & 768;
            int i34 = configuration2.screenLayout;
            if (i33 != (i34 & 768)) {
                configuration3.screenLayout |= i34 & 768;
            }
            if (i14 >= 26) {
                m.a(configuration, configuration2, configuration3);
            }
            int i35 = configuration.uiMode & 15;
            int i36 = configuration2.uiMode;
            if (i35 != (i36 & 15)) {
                configuration3.uiMode |= i36 & 15;
            }
            int i37 = configuration.uiMode & 48;
            int i38 = configuration2.uiMode;
            if (i37 != (i38 & 48)) {
                configuration3.uiMode |= i38 & 48;
            }
            int i39 = configuration.screenWidthDp;
            int i40 = configuration2.screenWidthDp;
            if (i39 != i40) {
                configuration3.screenWidthDp = i40;
            }
            int i41 = configuration.screenHeightDp;
            int i42 = configuration2.screenHeightDp;
            if (i41 != i42) {
                configuration3.screenHeightDp = i42;
            }
            int i43 = configuration.smallestScreenWidthDp;
            int i44 = configuration2.smallestScreenWidthDp;
            if (i43 != i44) {
                configuration3.smallestScreenWidthDp = i44;
            }
            j.b(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    private int y(Context context) {
        int i10;
        if (!this.f13913l1 && (this.f13892a instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                int i11 = Build.VERSION.SDK_INT;
                if (i11 >= 29) {
                    i10 = 269221888;
                } else if (i11 >= 24) {
                    i10 = 786432;
                } else {
                    i10 = 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f13892a.getClass()), i10);
                if (activityInfo != null) {
                    this.f13912k1 = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e10) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e10);
                this.f13912k1 = 0;
            }
        }
        this.f13913l1 = true;
        return this.f13912k1;
    }

    private q z(Context context) {
        if (this.f13915n1 == null) {
            this.f13915n1 = new p(context);
        }
        return this.f13915n1;
    }

    /* access modifiers changed from: package-private */
    public LocaleListCompat B(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return l.b(configuration);
        }
        return LocaleListCompat.forLanguageTags(k.b(configuration.locale));
    }

    /* access modifiers changed from: protected */
    public PanelFeatureState C(int i10, boolean z10) {
        PanelFeatureState[] panelFeatureStateArr = this.f13895b1;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i10) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i10 + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.f13895b1 = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i10);
        panelFeatureStateArr[i10] = panelFeatureState2;
        return panelFeatureState2;
    }

    /* access modifiers changed from: package-private */
    public final CharSequence D() {
        Object obj = this.f13892a;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.f13906h;
    }

    /* access modifiers changed from: package-private */
    public final Window.Callback E() {
        return this.f13896c.getCallback();
    }

    /* access modifiers changed from: package-private */
    public int K(Context context, int i10) {
        if (i10 == -100) {
            return -1;
        }
        if (i10 != -1) {
            if (i10 != 0) {
                if (!(i10 == 1 || i10 == 2)) {
                    if (i10 == 3) {
                        return z(context).c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                return -1;
            } else {
                return A(context).c();
            }
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public boolean L() {
        boolean z10 = this.f13899d1;
        this.f13899d1 = false;
        PanelFeatureState C2 = C(0, false);
        if (C2 == null || !C2.isOpen) {
            androidx.appcompat.view.ActionMode actionMode = this.C;
            if (actionMode != null) {
                actionMode.finish();
                return true;
            }
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar == null || !supportActionBar.collapseActionView()) {
                return false;
            }
            return true;
        }
        if (!z10) {
            m(C2, true);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean M(int i10, KeyEvent keyEvent) {
        boolean z10 = true;
        if (i10 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z10 = false;
            }
            this.f13899d1 = z10;
        } else if (i10 == 82) {
            N(0, keyEvent);
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean O(int i10, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i10, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.f13897c1;
        if (panelFeatureState == null || !W(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f13897c1 == null) {
                PanelFeatureState C2 = C(0, true);
                X(C2, keyEvent);
                boolean W = W(C2, keyEvent.getKeyCode(), keyEvent, 1);
                C2.isPrepared = false;
                if (W) {
                    return true;
                }
            }
            return false;
        }
        PanelFeatureState panelFeatureState2 = this.f13897c1;
        if (panelFeatureState2 != null) {
            panelFeatureState2.isHandled = true;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean P(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            if (i10 == 82) {
                Q(0, keyEvent);
                return true;
            }
        } else if (L()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void R(int i10) {
        ActionBar supportActionBar;
        if (i10 == 108 && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.dispatchMenuVisibilityChanged(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void S(int i10) {
        if (i10 == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(false);
            }
        } else if (i10 == 0) {
            PanelFeatureState C2 = C(i10, true);
            if (C2.isOpen) {
                m(C2, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void T(ViewGroup viewGroup) {
    }

    /* access modifiers changed from: package-private */
    public final ActionBar V() {
        return this.f13902f;
    }

    /* access modifiers changed from: package-private */
    public void a0(Configuration configuration, LocaleListCompat localeListCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            l.d(configuration, localeListCompat);
            return;
        }
        j.d(configuration, localeListCompat.get(0));
        j.c(configuration, localeListCompat.get(0));
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        t();
        ((ViewGroup) this.Q0.findViewById(16908290)).addView(view, layoutParams);
        this.f13898d.b(this.f13896c.getCallback());
    }

    /* access modifiers changed from: package-private */
    public boolean applyAppLocales() {
        if (AppCompatDelegate.isAutoStorageOptedIn(this.f13894b) && AppCompatDelegate.getRequestedAppLocales() != null && !AppCompatDelegate.getRequestedAppLocales().equals(AppCompatDelegate.getStoredAppLocales())) {
            asyncExecuteSyncRequestedAndStoredLocales(this.f13894b);
        }
        return c(true);
    }

    public boolean applyDayNight() {
        return c(true);
    }

    public Context attachBaseContext2(Context context) {
        Configuration configuration;
        this.f13901e1 = true;
        int K = K(context, h());
        if (AppCompatDelegate.isAutoStorageOptedIn(context)) {
            AppCompatDelegate.syncRequestedAndStoredLocales(context);
        }
        LocaleListCompat g10 = g(context);
        if (C1 && (context instanceof android.view.ContextThemeWrapper)) {
            try {
                s.a((android.view.ContextThemeWrapper) context, n(context, K, g10, (Configuration) null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(n(context, K, g10, (Configuration) null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!B1) {
            return super.attachBaseContext2(context);
        }
        Configuration configuration2 = new Configuration();
        configuration2.uiMode = -1;
        configuration2.fontScale = 0.0f;
        Configuration configuration3 = j.a(context, configuration2).getResources().getConfiguration();
        Configuration configuration4 = context.getResources().getConfiguration();
        configuration3.uiMode = configuration4.uiMode;
        if (!configuration3.equals(configuration4)) {
            configuration = w(configuration3, configuration4);
        } else {
            configuration = null;
        }
        Configuration n10 = n(context, K, g10, configuration, true);
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, R.style.Theme_AppCompat_Empty);
        contextThemeWrapper.applyOverrideConfiguration(n10);
        try {
            if (context.getTheme() != null) {
                ResourcesCompat.ThemeCompat.rebase(contextThemeWrapper.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.attachBaseContext2(contextThemeWrapper);
    }

    /* access modifiers changed from: package-private */
    public void b0(LocaleListCompat localeListCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            l.c(localeListCompat);
        } else {
            Locale.setDefault(localeListCompat.get(0));
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean c0() {
        ViewGroup viewGroup;
        if (!this.P0 || (viewGroup = this.Q0) == null || !ViewCompat.isLaidOut(viewGroup)) {
            return false;
        }
        return true;
    }

    public View createView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z10;
        if (this.f13922u1 == null) {
            String string = this.f13894b.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.f13922u1 = new AppCompatViewInflater();
            } else {
                try {
                    this.f13922u1 = (AppCompatViewInflater) this.f13894b.getClassLoader().loadClass(string).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f13922u1 = new AppCompatViewInflater();
                }
            }
        }
        boolean z11 = f13891z1;
        boolean z12 = false;
        if (z11) {
            if (this.f13923v1 == null) {
                this.f13923v1 = new t();
            }
            if (this.f13923v1.a(attributeSet)) {
                z10 = true;
                return this.f13922u1.createView(view, str, context, attributeSet, z10, z11, true, VectorEnabledTintResources.shouldBeUsed());
            } else if (!(attributeSet instanceof XmlPullParser)) {
                z12 = d0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z12 = true;
            }
        }
        z10 = z12;
        return this.f13922u1.createView(view, str, context, attributeSet, z10, z11, true, VectorEnabledTintResources.shouldBeUsed());
    }

    /* access modifiers changed from: package-private */
    public boolean e0() {
        if (this.f13925w1 == null) {
            return false;
        }
        PanelFeatureState C2 = C(0, false);
        if ((C2 == null || !C2.isOpen) && this.C == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.view.ActionMode f0(androidx.appcompat.view.ActionMode.Callback r8) {
        /*
            r7 = this;
            r7.s()
            androidx.appcompat.view.ActionMode r0 = r7.C
            if (r0 == 0) goto L_0x000a
            r0.finish()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatDelegateImpl.i
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.AppCompatDelegateImpl$i r0 = new androidx.appcompat.app.AppCompatDelegateImpl$i
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.AppCompatCallback r0 = r7.f13900e
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r2 = r7.f13905g1
            if (r2 != 0) goto L_0x0022
            androidx.appcompat.view.ActionMode r0 = r0.onWindowStartingSupportActionMode(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0029
            r7.C = r0
            goto L_0x015b
        L_0x0029:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.X
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d4
            boolean r0 = r7.Y0
            if (r0 == 0) goto L_0x00b5
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.f13894b
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.R.attr.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0068
            android.content.Context r5 = r7.f13894b
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            androidx.appcompat.view.ContextThemeWrapper r4 = new androidx.appcompat.view.ContextThemeWrapper
            android.content.Context r6 = r7.f13894b
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006a
        L_0x0068:
            android.content.Context r4 = r7.f13894b
        L_0x006a:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.X = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.R.attr.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.Y = r5
            r6 = 2
            androidx.core.widget.PopupWindowCompat.setWindowLayoutType(r5, r6)
            android.widget.PopupWindow r5 = r7.Y
            androidx.appcompat.widget.ActionBarContextView r6 = r7.X
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.Y
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.R.attr.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.X
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.Y
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.AppCompatDelegateImpl$d r0 = new androidx.appcompat.app.AppCompatDelegateImpl$d
            r0.<init>()
            r7.Z = r0
            goto L_0x00d4
        L_0x00b5:
            android.view.ViewGroup r0 = r7.Q0
            int r4 = androidx.appcompat.R.id.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d4
            android.content.Context r4 = r7.x()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.inflate()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.X = r0
        L_0x00d4:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.X
            if (r0 == 0) goto L_0x015b
            r7.s()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.X
            r0.killMode()
            androidx.appcompat.view.StandaloneActionMode r0 = new androidx.appcompat.view.StandaloneActionMode
            androidx.appcompat.widget.ActionBarContextView r4 = r7.X
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.X
            android.widget.PopupWindow r6 = r7.Y
            if (r6 != 0) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            r3 = r2
        L_0x00f0:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.getMenu()
            boolean r8 = r8.onCreateActionMode(r0, r3)
            if (r8 == 0) goto L_0x0159
            r0.invalidate()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.X
            r8.initForMode(r0)
            r7.C = r0
            boolean r8 = r7.c0()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012a
            androidx.appcompat.widget.ActionBarContextView r8 = r7.X
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.X
            androidx.core.view.ViewPropertyAnimatorCompat r8 = androidx.core.view.ViewCompat.animate(r8)
            androidx.core.view.ViewPropertyAnimatorCompat r8 = r8.alpha(r0)
            r7.N0 = r8
            androidx.appcompat.app.AppCompatDelegateImpl$e r0 = new androidx.appcompat.app.AppCompatDelegateImpl$e
            r0.<init>()
            r8.setListener(r0)
            goto L_0x0149
        L_0x012a:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.X
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.X
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.X
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0149
            androidx.appcompat.widget.ActionBarContextView r8 = r7.X
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.view.ViewCompat.requestApplyInsets(r8)
        L_0x0149:
            android.widget.PopupWindow r8 = r7.Y
            if (r8 == 0) goto L_0x015b
            android.view.Window r8 = r7.f13896c
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.Z
            r8.post(r0)
            goto L_0x015b
        L_0x0159:
            r7.C = r1
        L_0x015b:
            androidx.appcompat.view.ActionMode r8 = r7.C
            if (r8 == 0) goto L_0x0166
            androidx.appcompat.app.AppCompatCallback r0 = r7.f13900e
            if (r0 == 0) goto L_0x0166
            r0.onSupportActionModeStarted(r8)
        L_0x0166:
            r7.k0()
            androidx.appcompat.view.ActionMode r8 = r7.C
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.f0(androidx.appcompat.view.ActionMode$Callback):androidx.appcompat.view.ActionMode");
    }

    public View findViewById(int i10) {
        t();
        return this.f13896c.findViewById(i10);
    }

    /* access modifiers changed from: package-private */
    public LocaleListCompat g(Context context) {
        LocaleListCompat requestedAppLocales;
        LocaleListCompat localeListCompat;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33 || (requestedAppLocales = AppCompatDelegate.getRequestedAppLocales()) == null) {
            return null;
        }
        LocaleListCompat B = B(context.getApplicationContext().getResources().getConfiguration());
        if (i10 >= 24) {
            localeListCompat = u.b(requestedAppLocales, B);
        } else if (requestedAppLocales.isEmpty()) {
            localeListCompat = LocaleListCompat.getEmptyLocaleList();
        } else {
            localeListCompat = LocaleListCompat.forLanguageTags(requestedAppLocales.get(0).toString());
        }
        if (localeListCompat.isEmpty()) {
            return B;
        }
        return localeListCompat;
    }

    public Context getContextForDelegate() {
        return this.f13894b;
    }

    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new f();
    }

    public int getLocalNightMode() {
        return this.f13909i1;
    }

    public MenuInflater getMenuInflater() {
        Context context;
        if (this.f13904g == null) {
            F();
            ActionBar actionBar = this.f13902f;
            if (actionBar != null) {
                context = actionBar.getThemedContext();
            } else {
                context = this.f13894b;
            }
            this.f13904g = new SupportMenuInflater(context);
        }
        return this.f13904g;
    }

    public ActionBar getSupportActionBar() {
        F();
        return this.f13902f;
    }

    public boolean hasWindowFeature(int i10) {
        boolean z10;
        int Z2 = Z(i10);
        if (Z2 == 1) {
            z10 = this.Z0;
        } else if (Z2 == 2) {
            z10 = this.T0;
        } else if (Z2 == 5) {
            z10 = this.U0;
        } else if (Z2 == 10) {
            z10 = this.X0;
        } else if (Z2 == 108) {
            z10 = this.V0;
        } else if (Z2 != 109) {
            z10 = false;
        } else {
            z10 = this.W0;
        }
        if (z10 || this.f13896c.hasFeature(i10)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void i(int i10, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i10 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.f13895b1;
                if (i10 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i10];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.menu;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen) && !this.f13905g1) {
            this.f13898d.c(this.f13896c.getCallback(), i10, menu);
        }
    }

    public void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.f13894b);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void invalidateOptionsMenu() {
        if (V() != null && !getSupportActionBar().invalidateOptionsMenu()) {
            J(0);
        }
    }

    public boolean isHandleNativeActionModesEnabled() {
        return this.O0;
    }

    /* access modifiers changed from: package-private */
    public void j(MenuBuilder menuBuilder) {
        if (!this.f13893a1) {
            this.f13893a1 = true;
            this.f13908i.dismissPopups();
            Window.Callback E = E();
            if (E != null && !this.f13905g1) {
                E.onPanelClosed(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, menuBuilder);
            }
            this.f13893a1 = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void k0() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean e02 = e0();
            if (e02 && this.f13926x1 == null) {
                this.f13926x1 = n.b(this.f13925w1, this);
            } else if (!e02 && (onBackInvokedCallback = this.f13926x1) != null) {
                n.c(this.f13925w1, onBackInvokedCallback);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l(int i10) {
        m(C(i10, true), true);
    }

    /* access modifiers changed from: package-private */
    public void m(PanelFeatureState panelFeatureState, boolean z10) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (!z10 || panelFeatureState.featureId != 0 || (decorContentParent = this.f13908i) == null || !decorContentParent.isOverflowMenuShowing()) {
            WindowManager windowManager = (WindowManager) this.f13894b.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.isOpen || (viewGroup = panelFeatureState.decorView) == null)) {
                windowManager.removeView(viewGroup);
                if (z10) {
                    i(panelFeatureState.featureId, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.isPrepared = false;
            panelFeatureState.isHandled = false;
            panelFeatureState.isOpen = false;
            panelFeatureState.shownPanelView = null;
            panelFeatureState.refreshDecorView = true;
            if (this.f13897c1 == panelFeatureState) {
                this.f13897c1 = null;
            }
            if (panelFeatureState.featureId == 0) {
                k0();
                return;
            }
            return;
        }
        j(panelFeatureState.menu);
    }

    /* access modifiers changed from: package-private */
    public final int m0(WindowInsetsCompat windowInsetsCompat, Rect rect) {
        int i10;
        boolean z10;
        int i11;
        int i12;
        boolean z11;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i13;
        int i14 = 0;
        if (windowInsetsCompat != null) {
            i10 = windowInsetsCompat.getSystemWindowInsetTop();
        } else if (rect != null) {
            i10 = rect.top;
        } else {
            i10 = 0;
        }
        ActionBarContextView actionBarContextView = this.X;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.X.getLayoutParams();
            boolean z12 = true;
            if (this.X.isShown()) {
                if (this.f13920s1 == null) {
                    this.f13920s1 = new Rect();
                    this.f13921t1 = new Rect();
                }
                Rect rect2 = this.f13920s1;
                Rect rect3 = this.f13921t1;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                }
                ViewUtils.computeFitSystemWindows(this.Q0, rect2, rect3);
                int i15 = rect2.top;
                int i16 = rect2.left;
                int i17 = rect2.right;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.Q0);
                if (rootWindowInsets == null) {
                    i11 = 0;
                } else {
                    i11 = rootWindowInsets.getSystemWindowInsetLeft();
                }
                if (rootWindowInsets == null) {
                    i12 = 0;
                } else {
                    i12 = rootWindowInsets.getSystemWindowInsetRight();
                }
                if (marginLayoutParams2.topMargin == i15 && marginLayoutParams2.leftMargin == i16 && marginLayoutParams2.rightMargin == i17) {
                    z11 = false;
                } else {
                    marginLayoutParams2.topMargin = i15;
                    marginLayoutParams2.leftMargin = i16;
                    marginLayoutParams2.rightMargin = i17;
                    z11 = true;
                }
                if (i15 <= 0 || this.S0 != null) {
                    View view = this.S0;
                    if (!(view == null || ((marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()).height == (i13 = marginLayoutParams2.topMargin) && marginLayoutParams.leftMargin == i11 && marginLayoutParams.rightMargin == i12))) {
                        marginLayoutParams.height = i13;
                        marginLayoutParams.leftMargin = i11;
                        marginLayoutParams.rightMargin = i12;
                        this.S0.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    View view2 = new View(this.f13894b);
                    this.S0 = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams2.topMargin, 51);
                    layoutParams.leftMargin = i11;
                    layoutParams.rightMargin = i12;
                    this.Q0.addView(this.S0, -1, layoutParams);
                }
                View view3 = this.S0;
                if (view3 == null) {
                    z12 = false;
                }
                if (z12 && view3.getVisibility() != 0) {
                    n0(this.S0);
                }
                if (!this.X0 && z12) {
                    i10 = 0;
                }
                z10 = z12;
                z12 = z11;
            } else if (marginLayoutParams2.topMargin != 0) {
                marginLayoutParams2.topMargin = 0;
                z10 = false;
            } else {
                z10 = false;
                z12 = false;
            }
            if (z12) {
                this.X.setLayoutParams(marginLayoutParams2);
            }
        }
        View view4 = this.S0;
        if (view4 != null) {
            if (!z10) {
                i14 = 8;
            }
            view4.setVisibility(i14);
        }
        return i10;
    }

    public void onConfigurationChanged(Configuration configuration) {
        ActionBar supportActionBar;
        if (this.V0 && this.P0 && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.onConfigurationChanged(configuration);
        }
        AppCompatDrawableManager.get().onConfigurationChanged(this.f13894b);
        this.f13907h1 = new Configuration(this.f13894b.getResources().getConfiguration());
        d(false, false);
    }

    public void onCreate(Bundle bundle) {
        String str;
        this.f13901e1 = true;
        c(false);
        u();
        Object obj = this.f13892a;
        if (obj instanceof Activity) {
            try {
                str = NavUtils.getParentActivityName((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                ActionBar V = V();
                if (V == null) {
                    this.f13919r1 = true;
                } else {
                    V.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            AppCompatDelegate.addActiveDelegate(this);
        }
        this.f13907h1 = new Configuration(this.f13894b.getResources().getConfiguration());
        this.f13903f1 = true;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return createView(view, str, context, attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f13892a
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0009
            androidx.appcompat.app.AppCompatDelegate.removeActivityDelegate(r3)
        L_0x0009:
            boolean r0 = r3.f13916o1
            if (r0 == 0) goto L_0x0018
            android.view.Window r0 = r3.f13896c
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f13918q1
            r0.removeCallbacks(r1)
        L_0x0018:
            r0 = 1
            r3.f13905g1 = r0
            int r0 = r3.f13909i1
            r1 = -100
            if (r0 == r1) goto L_0x0045
            java.lang.Object r0 = r3.f13892a
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0045
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x0045
            androidx.collection.SimpleArrayMap r0 = f13890y1
            java.lang.Object r1 = r3.f13892a
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f13909i1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x0054
        L_0x0045:
            androidx.collection.SimpleArrayMap r0 = f13890y1
            java.lang.Object r1 = r3.f13892a
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x0054:
            androidx.appcompat.app.ActionBar r0 = r3.f13902f
            if (r0 == 0) goto L_0x005b
            r0.onDestroy()
        L_0x005b:
            r3.k()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.onDestroy():void");
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState v10;
        Window.Callback E = E();
        if (E == null || this.f13905g1 || (v10 = v(menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return E.onMenuItemSelected(v10.featureId, menuItem);
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        Y(true);
    }

    public void onPostCreate(Bundle bundle) {
        t();
    }

    public void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        d(true, false);
    }

    public void onStop() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        MenuBuilder menuBuilder;
        DecorContentParent decorContentParent = this.f13908i;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (this.Y != null) {
            this.f13896c.getDecorView().removeCallbacks(this.Z);
            if (this.Y.isShowing()) {
                try {
                    this.Y.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.Y = null;
        }
        s();
        PanelFeatureState C2 = C(0, false);
        if (C2 != null && (menuBuilder = C2.menu) != null) {
            menuBuilder.close();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean q(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f13892a;
        if (((obj instanceof KeyEventDispatcher.Component) || (obj instanceof AppCompatDialog)) && (decorView = this.f13896c.getDecorView()) != null && KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f13898d.a(this.f13896c.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            return M(keyCode, keyEvent);
        }
        return P(keyCode, keyEvent);
    }

    /* access modifiers changed from: package-private */
    public void r(int i10) {
        PanelFeatureState C2;
        PanelFeatureState C3 = C(i10, true);
        if (C3.menu != null) {
            Bundle bundle = new Bundle();
            C3.menu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                C3.frozenActionViewState = bundle;
            }
            C3.menu.stopDispatchingItemsChanged();
            C3.menu.clear();
        }
        C3.refreshMenuContent = true;
        C3.refreshDecorView = true;
        if ((i10 == 108 || i10 == 0) && this.f13908i != null && (C2 = C(0, false)) != null) {
            C2.isPrepared = false;
            X(C2, (KeyEvent) null);
        }
    }

    public boolean requestWindowFeature(int i10) {
        int Z2 = Z(i10);
        if (this.Z0 && Z2 == 108) {
            return false;
        }
        if (this.V0 && Z2 == 1) {
            this.V0 = false;
        }
        if (Z2 == 1) {
            g0();
            this.Z0 = true;
            return true;
        } else if (Z2 == 2) {
            g0();
            this.T0 = true;
            return true;
        } else if (Z2 == 5) {
            g0();
            this.U0 = true;
            return true;
        } else if (Z2 == 10) {
            g0();
            this.X0 = true;
            return true;
        } else if (Z2 == 108) {
            g0();
            this.V0 = true;
            return true;
        } else if (Z2 != 109) {
            return this.f13896c.requestFeature(Z2);
        } else {
            g0();
            this.W0 = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.N0;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    public void setContentView(View view) {
        t();
        ViewGroup viewGroup = (ViewGroup) this.Q0.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f13898d.b(this.f13896c.getCallback());
    }

    public void setHandleNativeActionModesEnabled(boolean z10) {
        this.O0 = z10;
    }

    public void setLocalNightMode(int i10) {
        if (this.f13909i1 != i10) {
            this.f13909i1 = i10;
            if (this.f13901e1) {
                applyDayNight();
            }
        }
    }

    public void setOnBackInvokedDispatcher(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.setOnBackInvokedDispatcher(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.f13925w1;
        if (!(onBackInvokedDispatcher2 == null || (onBackInvokedCallback = this.f13926x1) == null)) {
            n.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.f13926x1 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.f13892a;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                this.f13925w1 = n.a((Activity) this.f13892a);
                k0();
            }
        }
        this.f13925w1 = onBackInvokedDispatcher;
        k0();
    }

    public void setSupportActionBar(Toolbar toolbar) {
        if (this.f13892a instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (!(supportActionBar instanceof WindowDecorActionBar)) {
                this.f13904g = null;
                if (supportActionBar != null) {
                    supportActionBar.onDestroy();
                }
                this.f13902f = null;
                if (toolbar != null) {
                    ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, D(), this.f13898d);
                    this.f13902f = toolbarActionBar;
                    this.f13898d.d(toolbarActionBar.mMenuCallback);
                    toolbar.setBackInvokedCallbackEnabled(true);
                } else {
                    this.f13898d.d((g) null);
                }
                invalidateOptionsMenu();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    public void setTheme(int i10) {
        this.f13911j1 = i10;
    }

    public final void setTitle(CharSequence charSequence) {
        this.f13906h = charSequence;
        DecorContentParent decorContentParent = this.f13908i;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
        } else if (V() != null) {
            V().setWindowTitle(charSequence);
        } else {
            TextView textView = this.R0;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public androidx.appcompat.view.ActionMode startSupportActionMode(ActionMode.Callback callback) {
        AppCompatCallback appCompatCallback;
        if (callback != null) {
            androidx.appcompat.view.ActionMode actionMode = this.C;
            if (actionMode != null) {
                actionMode.finish();
            }
            i iVar = new i(callback);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                androidx.appcompat.view.ActionMode startActionMode = supportActionBar.startActionMode(iVar);
                this.C = startActionMode;
                if (!(startActionMode == null || (appCompatCallback = this.f13900e) == null)) {
                    appCompatCallback.onSupportActionModeStarted(startActionMode);
                }
            }
            if (this.C == null) {
                this.C = f0(iVar);
            }
            k0();
            return this.C;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* access modifiers changed from: package-private */
    public PanelFeatureState v(Menu menu) {
        int i10;
        PanelFeatureState[] panelFeatureStateArr = this.f13895b1;
        if (panelFeatureStateArr != null) {
            i10 = panelFeatureStateArr.length;
        } else {
            i10 = 0;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i11];
            if (panelFeatureState != null && panelFeatureState.menu == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final Context x() {
        Context context;
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            context = supportActionBar.getThemedContext();
        } else {
            context = null;
        }
        if (context == null) {
            return this.f13894b;
        }
        return context;
    }

    AppCompatDelegateImpl(Dialog dialog, AppCompatCallback appCompatCallback) {
        this(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback) {
        this(context, window, appCompatCallback, context);
    }

    AppCompatDelegateImpl(Context context, Activity activity, AppCompatCallback appCompatCallback) {
        this(context, (Window) null, appCompatCallback, activity);
    }

    private AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        AppCompatActivity h02;
        this.N0 = null;
        this.O0 = true;
        this.f13909i1 = -100;
        this.f13918q1 = new a();
        this.f13894b = context;
        this.f13900e = appCompatCallback;
        this.f13892a = obj;
        if (this.f13909i1 == -100 && (obj instanceof Dialog) && (h02 = h0()) != null) {
            this.f13909i1 = h02.getDelegate().getLocalNightMode();
        }
        if (this.f13909i1 == -100) {
            SimpleArrayMap simpleArrayMap = f13890y1;
            Integer num = (Integer) simpleArrayMap.get(obj.getClass().getName());
            if (num != null) {
                this.f13909i1 = num.intValue();
                simpleArrayMap.remove(obj.getClass().getName());
            }
        }
        if (window != null) {
            f(window);
        }
        AppCompatDrawableManager.preload();
    }

    public void setContentView(int i10) {
        t();
        ViewGroup viewGroup = (ViewGroup) this.Q0.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f13894b).inflate(i10, viewGroup);
        this.f13898d.b(this.f13896c.getCallback());
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        t();
        ViewGroup viewGroup = (ViewGroup) this.Q0.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f13898d.b(this.f13896c.getCallback());
    }
}
