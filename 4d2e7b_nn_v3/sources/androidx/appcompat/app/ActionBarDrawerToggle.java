package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mDrawerSlideAnimationEnabled;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private DrawerArrowDrawable mSlider;
    View.OnClickListener mToolbarNavigationClickListener;
    private boolean mWarnedForDisplayHomeAsUp;

    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(@StringRes int i10);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i10);
    }

    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            ActionBarDrawerToggle actionBarDrawerToggle = ActionBarDrawerToggle.this;
            if (actionBarDrawerToggle.mDrawerIndicatorEnabled) {
                actionBarDrawerToggle.toggle();
                return;
            }
            View.OnClickListener onClickListener = actionBarDrawerToggle.mToolbarNavigationClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    private static class b implements Delegate {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f13843a;

        static class a {
            @DoNotInline
            static void a(ActionBar actionBar, int i10) {
                actionBar.setHomeActionContentDescription(i10);
            }

            @DoNotInline
            static void b(ActionBar actionBar, Drawable drawable) {
                actionBar.setHomeAsUpIndicator(drawable);
            }
        }

        b(Activity activity) {
            this.f13843a = activity;
        }

        public Context getActionBarThemedContext() {
            ActionBar actionBar = this.f13843a.getActionBar();
            if (actionBar != null) {
                return actionBar.getThemedContext();
            }
            return this.f13843a;
        }

        public Drawable getThemeUpIndicator() {
            TypedArray obtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes((AttributeSet) null, new int[]{16843531}, 16843470, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public boolean isNavigationVisible() {
            ActionBar actionBar = this.f13843a.getActionBar();
            if (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) {
                return false;
            }
            return true;
        }

        public void setActionBarDescription(int i10) {
            ActionBar actionBar = this.f13843a.getActionBar();
            if (actionBar != null) {
                a.a(actionBar, i10);
            }
        }

        public void setActionBarUpIndicator(Drawable drawable, int i10) {
            ActionBar actionBar = this.f13843a.getActionBar();
            if (actionBar != null) {
                a.b(actionBar, drawable);
                a.a(actionBar, i10);
            }
        }
    }

    static class c implements Delegate {

        /* renamed from: a  reason: collision with root package name */
        final Toolbar f13844a;

        /* renamed from: b  reason: collision with root package name */
        final Drawable f13845b;

        /* renamed from: c  reason: collision with root package name */
        final CharSequence f13846c;

        c(Toolbar toolbar) {
            this.f13844a = toolbar;
            this.f13845b = toolbar.getNavigationIcon();
            this.f13846c = toolbar.getNavigationContentDescription();
        }

        public Context getActionBarThemedContext() {
            return this.f13844a.getContext();
        }

        public Drawable getThemeUpIndicator() {
            return this.f13845b;
        }

        public boolean isNavigationVisible() {
            return true;
        }

        public void setActionBarDescription(int i10) {
            if (i10 == 0) {
                this.f13844a.setNavigationContentDescription(this.f13846c);
            } else {
                this.f13844a.setNavigationContentDescription(i10);
            }
        }

        public void setActionBarUpIndicator(Drawable drawable, int i10) {
            this.f13844a.setNavigationIcon(drawable);
            setActionBarDescription(i10);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @StringRes int i10, @StringRes int i11) {
        this(activity, (Toolbar) null, drawerLayout, (DrawerArrowDrawable) null, i10, i11);
    }

    private void setPosition(float f10) {
        if (f10 == 1.0f) {
            this.mSlider.setVerticalMirror(true);
        } else if (f10 == 0.0f) {
            this.mSlider.setVerticalMirror(false);
        }
        this.mSlider.setProgress(f10);
    }

    @NonNull
    public DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.mSlider;
    }

    /* access modifiers changed from: package-private */
    public Drawable getThemeUpIndicator() {
        return this.mActivityImpl.getThemeUpIndicator();
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.mToolbarNavigationClickListener;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        return this.mDrawerSlideAnimationEnabled;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
        }
        syncState();
    }

    public void onDrawerClosed(View view) {
        setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }

    public void onDrawerOpened(View view) {
        setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }

    public void onDrawerSlide(View view, float f10) {
        if (this.mDrawerSlideAnimationEnabled) {
            setPosition(Math.min(1.0f, Math.max(0.0f, f10)));
        } else {
            setPosition(0.0f);
        }
    }

    public void onDrawerStateChanged(int i10) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.mDrawerIndicatorEnabled) {
            return false;
        }
        toggle();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void setActionBarDescription(int i10) {
        this.mActivityImpl.setActionBarDescription(i10);
    }

    /* access modifiers changed from: package-private */
    public void setActionBarUpIndicator(Drawable drawable, int i10) {
        if (!this.mWarnedForDisplayHomeAsUp && !this.mActivityImpl.isNavigationVisible()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.mWarnedForDisplayHomeAsUp = true;
        }
        this.mActivityImpl.setActionBarUpIndicator(drawable, i10);
    }

    public void setDrawerArrowDrawable(@NonNull DrawerArrowDrawable drawerArrowDrawable) {
        this.mSlider = drawerArrowDrawable;
        syncState();
    }

    public void setDrawerIndicatorEnabled(boolean z10) {
        int i10;
        if (z10 != this.mDrawerIndicatorEnabled) {
            if (z10) {
                DrawerArrowDrawable drawerArrowDrawable = this.mSlider;
                if (this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START)) {
                    i10 = this.mCloseDrawerContentDescRes;
                } else {
                    i10 = this.mOpenDrawerContentDescRes;
                }
                setActionBarUpIndicator(drawerArrowDrawable, i10);
            } else {
                setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
            }
            this.mDrawerIndicatorEnabled = z10;
        }
    }

    public void setDrawerSlideAnimationEnabled(boolean z10) {
        this.mDrawerSlideAnimationEnabled = z10;
        if (!z10) {
            setPosition(0.0f);
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
            this.mHasCustomUpIndicator = false;
        } else {
            this.mHomeAsUpIndicator = drawable;
            this.mHasCustomUpIndicator = true;
        }
        if (!this.mDrawerIndicatorEnabled) {
            setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        }
    }

    public void setToolbarNavigationClickListener(View.OnClickListener onClickListener) {
        this.mToolbarNavigationClickListener = onClickListener;
    }

    public void syncState() {
        int i10;
        if (this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START)) {
            setPosition(1.0f);
        } else {
            setPosition(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            DrawerArrowDrawable drawerArrowDrawable = this.mSlider;
            if (this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START)) {
                i10 = this.mCloseDrawerContentDescRes;
            } else {
                i10 = this.mOpenDrawerContentDescRes;
            }
            setActionBarUpIndicator(drawerArrowDrawable, i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void toggle() {
        int drawerLockMode = this.mDrawerLayout.getDrawerLockMode((int) GravityCompat.START);
        if (this.mDrawerLayout.isDrawerVisible((int) GravityCompat.START) && drawerLockMode != 2) {
            this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
        } else if (drawerLockMode != 1) {
            this.mDrawerLayout.openDrawer((int) GravityCompat.START);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, @StringRes int i10, @StringRes int i11) {
        this(activity, toolbar, drawerLayout, (DrawerArrowDrawable) null, i10, i11);
    }

    ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, DrawerArrowDrawable drawerArrowDrawable, @StringRes int i10, @StringRes int i11) {
        this.mDrawerSlideAnimationEnabled = true;
        this.mDrawerIndicatorEnabled = true;
        this.mWarnedForDisplayHomeAsUp = false;
        if (toolbar != null) {
            this.mActivityImpl = new c(toolbar);
            toolbar.setNavigationOnClickListener(new a());
        } else if (activity instanceof DelegateProvider) {
            this.mActivityImpl = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.mActivityImpl = new b(activity);
        }
        this.mDrawerLayout = drawerLayout;
        this.mOpenDrawerContentDescRes = i10;
        this.mCloseDrawerContentDescRes = i11;
        if (drawerArrowDrawable == null) {
            this.mSlider = new DrawerArrowDrawable(this.mActivityImpl.getActionBarThemedContext());
        } else {
            this.mSlider = drawerArrowDrawable;
        }
        this.mHomeAsUpIndicator = getThemeUpIndicator();
    }

    public void setHomeAsUpIndicator(int i10) {
        setHomeAsUpIndicator(i10 != 0 ? this.mDrawerLayout.getResources().getDrawable(i10) : null);
    }
}
