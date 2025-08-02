package androidx.legacy.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;

@Deprecated
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    private static final int ID_HOME = 16908332;
    private static final String TAG = "ActionBarDrawerToggle";
    private static final int[] THEME_ATTRS = {16843531};
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334f;
    final Activity mActivity;
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private a mSetIndicatorInfo;
    private b mSlider;

    @Deprecated
    public interface Delegate {
        @Nullable
        Drawable getThemeUpIndicator();

        void setActionBarDescription(@StringRes int i10);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i10);
    }

    @Deprecated
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    private static class a {
    }

    private class b extends InsetDrawable implements Drawable.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f15843a = true;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f15844b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        private float f15845c;

        /* renamed from: d  reason: collision with root package name */
        private float f15846d;

        b(Drawable drawable) {
            super(drawable, 0);
        }

        public float a() {
            return this.f15845c;
        }

        public void b(float f10) {
            this.f15846d = f10;
            invalidateSelf();
        }

        public void c(float f10) {
            this.f15845c = f10;
            invalidateSelf();
        }

        public void draw(Canvas canvas) {
            boolean z10;
            copyBounds(this.f15844b);
            canvas.save();
            int i10 = 1;
            if (ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.mActivity.getWindow().getDecorView()) == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                i10 = -1;
            }
            float width = (float) this.f15844b.width();
            canvas.translate((-this.f15846d) * width * this.f15845c * ((float) i10), 0.0f);
            if (z10 && !this.f15843a) {
                canvas.translate(width, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @DrawableRes int i10, @StringRes int i11, @StringRes int i12) {
        this(activity, drawerLayout, !assumeMaterial(activity), i10, i11, i12);
    }

    private static boolean assumeMaterial(Context context) {
        if (context.getApplicationInfo().targetSdkVersion >= 21) {
            return true;
        }
        return false;
    }

    private Drawable getThemeUpIndicator() {
        Context context;
        Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            return delegate.getThemeUpIndicator();
        }
        ActionBar actionBar = this.mActivity.getActionBar();
        if (actionBar != null) {
            context = actionBar.getThemedContext();
        } else {
            context = this.mActivity;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, THEME_ATTRS, 16843470, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    private void setActionBarDescription(int i10) {
        Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            delegate.setActionBarDescription(i10);
            return;
        }
        ActionBar actionBar = this.mActivity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i10);
        }
    }

    private void setActionBarUpIndicator(Drawable drawable, int i10) {
        Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            delegate.setActionBarUpIndicator(drawable, i10);
            return;
        }
        ActionBar actionBar = this.mActivity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i10);
        }
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
        }
        this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
        syncState();
    }

    public void onDrawerClosed(View view) {
        this.mSlider.c(0.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }

    public void onDrawerOpened(View view) {
        this.mSlider.c(1.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }

    public void onDrawerSlide(View view, float f10) {
        float f11;
        float a10 = this.mSlider.a();
        if (f10 > 0.5f) {
            f11 = Math.max(a10, Math.max(0.0f, f10 - 0.5f) * 2.0f);
        } else {
            f11 = Math.min(a10, f10 * 2.0f);
        }
        this.mSlider.c(f11);
    }

    public void onDrawerStateChanged(int i10) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != ID_HOME || !this.mDrawerIndicatorEnabled) {
            return false;
        }
        if (this.mDrawerLayout.isDrawerVisible((int) GravityCompat.START)) {
            this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
            return true;
        }
        this.mDrawerLayout.openDrawer((int) GravityCompat.START);
        return true;
    }

    public void setDrawerIndicatorEnabled(boolean z10) {
        int i10;
        if (z10 != this.mDrawerIndicatorEnabled) {
            if (z10) {
                b bVar = this.mSlider;
                if (this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START)) {
                    i10 = this.mCloseDrawerContentDescRes;
                } else {
                    i10 = this.mOpenDrawerContentDescRes;
                }
                setActionBarUpIndicator(bVar, i10);
            } else {
                setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
            }
            this.mDrawerIndicatorEnabled = z10;
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

    public void syncState() {
        int i10;
        if (this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START)) {
            this.mSlider.c(1.0f);
        } else {
            this.mSlider.c(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            b bVar = this.mSlider;
            if (this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START)) {
                i10 = this.mCloseDrawerContentDescRes;
            } else {
                i10 = this.mOpenDrawerContentDescRes;
            }
            setActionBarUpIndicator(bVar, i10);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, boolean z10, @DrawableRes int i10, @StringRes int i11, @StringRes int i12) {
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = activity;
        if (activity instanceof DelegateProvider) {
            this.mActivityImpl = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.mActivityImpl = null;
        }
        this.mDrawerLayout = drawerLayout;
        this.mDrawerImageResource = i10;
        this.mOpenDrawerContentDescRes = i11;
        this.mCloseDrawerContentDescRes = i12;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mDrawerImage = ContextCompat.getDrawable(activity, i10);
        b bVar = new b(this.mDrawerImage);
        this.mSlider = bVar;
        bVar.b(z10 ? TOGGLE_DRAWABLE_OFFSET : 0.0f);
    }

    public void setHomeAsUpIndicator(int i10) {
        setHomeAsUpIndicator(i10 != 0 ? ContextCompat.getDrawable(this.mActivity, i10) : null);
    }
}
