package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public abstract class BaseProgressIndicator<S extends BaseProgressIndicatorSpec> extends ProgressBar {
    static final float DEFAULT_OPACITY = 0.2f;
    static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_ProgressIndicator;
    public static final int HIDE_INWARD = 2;
    public static final int HIDE_NONE = 0;
    public static final int HIDE_OUTWARD = 1;
    static final int MAX_ALPHA = 255;
    static final int MAX_HIDE_DELAY = 1000;
    public static final int SHOW_INWARD = 2;
    public static final int SHOW_NONE = 0;
    public static final int SHOW_OUTWARD = 1;
    AnimatorDurationScaleProvider animatorDurationScaleProvider;
    private final Runnable delayedHide = new b();
    private final Runnable delayedShow = new a();
    private final Animatable2Compat.AnimationCallback hideAnimationCallback = new d();
    /* access modifiers changed from: private */
    public boolean isIndeterminateModeChangeRequested = false;
    private boolean isParentDoneInitializing;
    /* access modifiers changed from: private */
    public long lastShowStartTime = -1;
    private final int minHideDelay;
    private final int showDelay;
    S spec;
    /* access modifiers changed from: private */
    public int storedProgress;
    /* access modifiers changed from: private */
    public boolean storedProgressAnimated;
    private final Animatable2Compat.AnimationCallback switchIndeterminateModeCallback = new c();
    /* access modifiers changed from: private */
    public int visibilityAfterHide = 4;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HideAnimationBehavior {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowAnimationBehavior {
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            BaseProgressIndicator.this.internalShow();
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            BaseProgressIndicator.this.internalHide();
            long unused = BaseProgressIndicator.this.lastShowStartTime = -1;
        }
    }

    class c extends Animatable2Compat.AnimationCallback {
        c() {
        }

        public void onAnimationEnd(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setProgressCompat(baseProgressIndicator.storedProgress, BaseProgressIndicator.this.storedProgressAnimated);
        }
    }

    class d extends Animatable2Compat.AnimationCallback {
        d() {
        }

        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            if (!BaseProgressIndicator.this.isIndeterminateModeChangeRequested) {
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                baseProgressIndicator.setVisibility(baseProgressIndicator.visibilityAfterHide);
            }
        }
    }

    protected BaseProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10, @StyleRes int i11) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i10, DEF_STYLE_RES), attributeSet, i10);
        Context context2 = getContext();
        this.spec = createSpec(context2, attributeSet);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.BaseProgressIndicator, i10, i11, new int[0]);
        this.showDelay = obtainStyledAttributes.getInt(R.styleable.BaseProgressIndicator_showDelay, -1);
        this.minHideDelay = Math.min(obtainStyledAttributes.getInt(R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        obtainStyledAttributes.recycle();
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        this.isParentDoneInitializing = true;
    }

    @Nullable
    private d getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().getDrawingDelegate();
        } else if (getProgressDrawable() == null) {
            return null;
        } else {
            return getProgressDrawable().getDrawingDelegate();
        }
    }

    /* access modifiers changed from: private */
    public void internalHide() {
        ((c) getCurrentDrawable()).setVisible(false, false, true);
        if (isNoLongerNeedToBeVisible()) {
            setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public void internalShow() {
        if (this.minHideDelay > 0) {
            this.lastShowStartTime = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean isNoLongerNeedToBeVisible() {
        if ((getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible())) {
            return true;
        }
        return false;
    }

    private void registerAnimationCallbacks() {
        if (!(getProgressDrawable() == null || getIndeterminateDrawable() == null)) {
            getIndeterminateDrawable().getAnimatorDelegate().d(this.switchIndeterminateModeCallback);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().registerAnimationCallback(this.hideAnimationCallback);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().registerAnimationCallback(this.hideAnimationCallback);
        }
    }

    private void unregisterAnimationCallbacks() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
            getIndeterminateDrawable().getAnimatorDelegate().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
        }
    }

    /* access modifiers changed from: protected */
    public void applyNewVisibility(boolean z10) {
        if (this.isParentDoneInitializing) {
            ((c) getCurrentDrawable()).setVisible(visibleToUser(), false, z10);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract S createSpec(@NonNull Context context, @NonNull AttributeSet attributeSet);

    @Nullable
    public Drawable getCurrentDrawable() {
        if (isIndeterminate()) {
            return getIndeterminateDrawable();
        }
        return getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.spec.hideAnimationBehavior;
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.spec.indicatorColors;
    }

    public int getShowAnimationBehavior() {
        return this.spec.showAnimationBehavior;
    }

    @ColorInt
    public int getTrackColor() {
        return this.spec.trackColor;
    }

    @Px
    public int getTrackCornerRadius() {
        return this.spec.trackCornerRadius;
    }

    @Px
    public int getTrackThickness() {
        return this.spec.trackThickness;
    }

    public void hide() {
        if (getVisibility() != 0) {
            removeCallbacks(this.delayedShow);
            return;
        }
        removeCallbacks(this.delayedHide);
        long uptimeMillis = SystemClock.uptimeMillis() - this.lastShowStartTime;
        int i10 = this.minHideDelay;
        if (uptimeMillis >= ((long) i10)) {
            this.delayedHide.run();
        } else {
            postDelayed(this.delayedHide, ((long) i10) - uptimeMillis);
        }
    }

    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isEffectivelyVisible() {
        View view = this;
        while (view.getVisibility() == 0) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                if (getWindowVisibility() == 0) {
                    return true;
                }
                return false;
            } else if (!(parent instanceof View)) {
                return true;
            } else {
                view = (View) parent;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerAnimationCallbacks();
        if (visibleToUser()) {
            internalShow();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.delayedHide);
        removeCallbacks(this.delayedShow);
        ((c) getCurrentDrawable()).hideNow();
        unregisterAnimationCallbacks();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(@NonNull Canvas canvas) {
        try {
            int save = canvas.save();
            if (getPaddingLeft() == 0) {
                if (getPaddingTop() != 0) {
                }
                if (!(getPaddingRight() == 0 && getPaddingBottom() == 0)) {
                    canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
                }
                getCurrentDrawable().draw(canvas);
                canvas.restoreToCount(save);
            }
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(save);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        try {
            super.onMeasure(i10, i11);
            d currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate != null) {
                int e10 = currentDrawingDelegate.e();
                int d10 = currentDrawingDelegate.d();
                if (e10 < 0) {
                    i12 = getMeasuredWidth();
                } else {
                    i12 = e10 + getPaddingLeft() + getPaddingRight();
                }
                if (d10 < 0) {
                    i13 = getMeasuredHeight();
                } else {
                    i13 = d10 + getPaddingTop() + getPaddingBottom();
                }
                setMeasuredDimension(i12, i13);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i10) {
        boolean z10;
        super.onVisibilityChanged(view, i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        applyNewVisibility(z10);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        applyNewVisibility(false);
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setAnimatorDurationScaleProvider(@NonNull AnimatorDurationScaleProvider animatorDurationScaleProvider2) {
        this.animatorDurationScaleProvider = animatorDurationScaleProvider2;
        if (getProgressDrawable() != null) {
            getProgressDrawable().animatorDurationScaleProvider = animatorDurationScaleProvider2;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().animatorDurationScaleProvider = animatorDurationScaleProvider2;
        }
    }

    public void setHideAnimationBehavior(int i10) {
        this.spec.hideAnimationBehavior = i10;
        invalidate();
    }

    public synchronized void setIndeterminate(boolean z10) {
        try {
            if (z10 != isIndeterminate()) {
                c cVar = (c) getCurrentDrawable();
                if (cVar != null) {
                    cVar.hideNow();
                }
                super.setIndeterminate(z10);
                c cVar2 = (c) getCurrentDrawable();
                if (cVar2 != null) {
                    cVar2.setVisible(visibleToUser(), false, false);
                }
                if ((cVar2 instanceof IndeterminateDrawable) && visibleToUser()) {
                    ((IndeterminateDrawable) cVar2).getAnimatorDelegate().g();
                }
                this.isIndeterminateModeChangeRequested = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setIndeterminateDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable((Drawable) null);
        } else if (drawable instanceof IndeterminateDrawable) {
            ((c) drawable).hideNow();
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(@ColorInt int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{MaterialColors.getColor(getContext(), R.attr.colorPrimary, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.spec.indicatorColors = iArr;
            getIndeterminateDrawable().getAnimatorDelegate().c();
            invalidate();
        }
    }

    public synchronized void setProgress(int i10) {
        if (!isIndeterminate()) {
            setProgressCompat(i10, false);
        }
    }

    public void setProgressCompat(int i10, boolean z10) {
        if (!isIndeterminate()) {
            super.setProgress(i10);
            if (getProgressDrawable() != null && !z10) {
                getProgressDrawable().jumpToCurrentState();
            }
        } else if (getProgressDrawable() != null) {
            this.storedProgress = i10;
            this.storedProgressAnimated = z10;
            this.isIndeterminateModeChangeRequested = true;
            if (!getIndeterminateDrawable().isVisible() || this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(getContext().getContentResolver()) == 0.0f) {
                this.switchIndeterminateModeCallback.onAnimationEnd(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().getAnimatorDelegate().f();
            }
        }
    }

    public void setProgressDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable((Drawable) null);
        } else if (drawable instanceof DeterminateDrawable) {
            DeterminateDrawable determinateDrawable = (DeterminateDrawable) drawable;
            determinateDrawable.hideNow();
            super.setProgressDrawable(determinateDrawable);
            determinateDrawable.setLevelByFraction(((float) getProgress()) / ((float) getMax()));
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i10) {
        this.spec.showAnimationBehavior = i10;
        invalidate();
    }

    public void setTrackColor(@ColorInt int i10) {
        S s10 = this.spec;
        if (s10.trackColor != i10) {
            s10.trackColor = i10;
            invalidate();
        }
    }

    public void setTrackCornerRadius(@Px int i10) {
        S s10 = this.spec;
        if (s10.trackCornerRadius != i10) {
            s10.trackCornerRadius = Math.min(i10, s10.trackThickness / 2);
        }
    }

    public void setTrackThickness(@Px int i10) {
        S s10 = this.spec;
        if (s10.trackThickness != i10) {
            s10.trackThickness = i10;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i10) {
        if (i10 == 0 || i10 == 4 || i10 == 8) {
            this.visibilityAfterHide = i10;
            return;
        }
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }

    public void show() {
        if (this.showDelay > 0) {
            removeCallbacks(this.delayedShow);
            postDelayed(this.delayedShow, (long) this.showDelay);
            return;
        }
        this.delayedShow.run();
    }

    /* access modifiers changed from: package-private */
    public boolean visibleToUser() {
        if (!ViewCompat.isAttachedToWindow(this) || getWindowVisibility() != 0 || !isEffectivelyVisible()) {
            return false;
        }
        return true;
    }

    @Nullable
    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @Nullable
    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }
}
