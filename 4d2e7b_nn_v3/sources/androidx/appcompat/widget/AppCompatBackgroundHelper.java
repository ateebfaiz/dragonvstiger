package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

class AppCompatBackgroundHelper {

    /* renamed from: a  reason: collision with root package name */
    private final View f14177a;

    /* renamed from: b  reason: collision with root package name */
    private final AppCompatDrawableManager f14178b;

    /* renamed from: c  reason: collision with root package name */
    private int f14179c = -1;

    /* renamed from: d  reason: collision with root package name */
    private TintInfo f14180d;

    /* renamed from: e  reason: collision with root package name */
    private TintInfo f14181e;

    /* renamed from: f  reason: collision with root package name */
    private TintInfo f14182f;

    AppCompatBackgroundHelper(View view) {
        this.f14177a = view;
        this.f14178b = AppCompatDrawableManager.get();
    }

    private boolean a(Drawable drawable) {
        if (this.f14182f == null) {
            this.f14182f = new TintInfo();
        }
        TintInfo tintInfo = this.f14182f;
        tintInfo.clear();
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(this.f14177a);
        if (backgroundTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = backgroundTintList;
        }
        PorterDuff.Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(this.f14177a);
        if (backgroundTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = backgroundTintMode;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            return false;
        }
        AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.f14177a.getDrawableState());
        return true;
    }

    private boolean k() {
        if (this.f14180d != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.f14177a.getBackground();
        if (background == null) {
            return;
        }
        if (!k() || !a(background)) {
            TintInfo tintInfo = this.f14181e;
            if (tintInfo != null) {
                AppCompatDrawableManager.tintDrawable(background, tintInfo, this.f14177a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f14180d;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.tintDrawable(background, tintInfo2, this.f14177a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        TintInfo tintInfo = this.f14181e;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        TintInfo tintInfo = this.f14181e;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i10) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f14177a.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i10, 0);
        View view = this.f14177a;
        ViewCompat.saveAttributeDataForStyleable(view, view.getContext(), R.styleable.ViewBackgroundHelper, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i10, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.styleable.ViewBackgroundHelper_android_background)) {
                this.f14179c = obtainStyledAttributes.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList tintList = this.f14178b.getTintList(this.f14177a.getContext(), this.f14179c);
                if (tintList != null) {
                    h(tintList);
                }
            }
            if (obtainStyledAttributes.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.setBackgroundTintList(this.f14177a, obtainStyledAttributes.getColorStateList(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.setBackgroundTintMode(this.f14177a, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), (PorterDuff.Mode) null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f14179c = -1;
        h((ColorStateList) null);
        b();
    }

    /* access modifiers changed from: package-private */
    public void g(int i10) {
        ColorStateList colorStateList;
        this.f14179c = i10;
        AppCompatDrawableManager appCompatDrawableManager = this.f14178b;
        if (appCompatDrawableManager != null) {
            colorStateList = appCompatDrawableManager.getTintList(this.f14177a.getContext(), i10);
        } else {
            colorStateList = null;
        }
        h(colorStateList);
        b();
    }

    /* access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f14180d == null) {
                this.f14180d = new TintInfo();
            }
            TintInfo tintInfo = this.f14180d;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.f14180d = null;
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f14181e == null) {
            this.f14181e = new TintInfo();
        }
        TintInfo tintInfo = this.f14181e;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        b();
    }

    /* access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f14181e == null) {
            this.f14181e = new TintInfo();
        }
        TintInfo tintInfo = this.f14181e;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        b();
    }
}
