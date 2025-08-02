package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {
    public static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_LinearProgressIndicator;
    public static final int INDETERMINATE_ANIMATION_TYPE_CONTIGUOUS = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_DISJOINT = 1;
    public static final int INDICATOR_DIRECTION_END_TO_START = 3;
    public static final int INDICATOR_DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int INDICATOR_DIRECTION_RIGHT_TO_LEFT = 1;
    public static final int INDICATOR_DIRECTION_START_TO_END = 2;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IndeterminateAnimationType {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorDirection {
    }

    public LinearProgressIndicator(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void initializeDrawables() {
        setIndeterminateDrawable(IndeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.spec));
        setProgressDrawable(DeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.spec));
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        S s10 = this.spec;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s10;
        boolean z11 = true;
        if (!(((LinearProgressIndicatorSpec) s10).indicatorDirection == 1 || ((ViewCompat.getLayoutDirection(this) == 1 && ((LinearProgressIndicatorSpec) this.spec).indicatorDirection == 2) || (ViewCompat.getLayoutDirection(this) == 0 && ((LinearProgressIndicatorSpec) this.spec).indicatorDirection == 3)))) {
            z11 = false;
        }
        linearProgressIndicatorSpec.drawHorizontallyInverse = z11;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        int paddingLeft = i10 - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i11 - (getPaddingTop() + getPaddingBottom());
        IndeterminateDrawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        DeterminateDrawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    public void setIndeterminateAnimationType(int i10) {
        if (((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType != i10) {
            if (!visibleToUser() || !isIndeterminate()) {
                S s10 = this.spec;
                ((LinearProgressIndicatorSpec) s10).indeterminateAnimationType = i10;
                ((LinearProgressIndicatorSpec) s10).validateSpec();
                if (i10 == 0) {
                    getIndeterminateDrawable().setAnimatorDelegate(new g((LinearProgressIndicatorSpec) this.spec));
                } else {
                    getIndeterminateDrawable().setAnimatorDelegate(new h(getContext(), (LinearProgressIndicatorSpec) this.spec));
                }
                invalidate();
                return;
            }
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
    }

    public void setIndicatorColor(@NonNull int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
    }

    public void setIndicatorDirection(int i10) {
        S s10 = this.spec;
        ((LinearProgressIndicatorSpec) s10).indicatorDirection = i10;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s10;
        boolean z10 = true;
        if (!(i10 == 1 || ((ViewCompat.getLayoutDirection(this) == 1 && ((LinearProgressIndicatorSpec) this.spec).indicatorDirection == 2) || (ViewCompat.getLayoutDirection(this) == 0 && i10 == 3)))) {
            z10 = false;
        }
        linearProgressIndicatorSpec.drawHorizontallyInverse = z10;
        invalidate();
    }

    public void setProgressCompat(int i10, boolean z10) {
        S s10 = this.spec;
        if (s10 == null || ((LinearProgressIndicatorSpec) s10).indeterminateAnimationType != 0 || !isIndeterminate()) {
            super.setProgressCompat(i10, z10);
        }
    }

    public void setTrackCornerRadius(int i10) {
        super.setTrackCornerRadius(i10);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
        invalidate();
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    /* access modifiers changed from: package-private */
    public LinearProgressIndicatorSpec createSpec(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10) {
        super(context, attributeSet, i10, DEF_STYLE_RES);
        initializeDrawables();
    }
}
