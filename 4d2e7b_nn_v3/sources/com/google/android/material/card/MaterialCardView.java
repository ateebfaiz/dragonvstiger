package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MaterialCardView extends CardView implements Checkable, Shapeable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.cardview.widget.CardView";
    private static final int[] CHECKABLE_STATE_SET = {16842911};
    public static final int CHECKED_ICON_GRAVITY_BOTTOM_END = 8388693;
    public static final int CHECKED_ICON_GRAVITY_BOTTOM_START = 8388691;
    public static final int CHECKED_ICON_GRAVITY_TOP_END = 8388661;
    public static final int CHECKED_ICON_GRAVITY_TOP_START = 8388659;
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_CardView;
    private static final int[] DRAGGED_STATE_SET = {R.attr.state_dragged};
    private static final String LOG_TAG = "MaterialCardView";
    @NonNull
    private final a cardViewHelper;
    private boolean checked;
    private boolean dragged;
    private boolean isParentCardViewDoneInitializing;
    private OnCheckedChangeListener onCheckedChangeListener;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CheckedIconGravity {
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialCardView materialCardView, boolean z10);
    }

    public MaterialCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void forceRippleRedrawIfNeeded() {
        if (Build.VERSION.SDK_INT > 26) {
            this.cardViewHelper.i();
        }
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.cardViewHelper.j().getBounds());
        return rectF;
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.cardViewHelper.k();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.cardViewHelper.l();
    }

    /* access modifiers changed from: package-private */
    public float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.cardViewHelper.m();
    }

    public int getCheckedIconGravity() {
        return this.cardViewHelper.n();
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.cardViewHelper.o();
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.cardViewHelper.p();
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.cardViewHelper.q();
    }

    public int getContentPaddingBottom() {
        return this.cardViewHelper.A().bottom;
    }

    public int getContentPaddingLeft() {
        return this.cardViewHelper.A().left;
    }

    public int getContentPaddingRight() {
        return this.cardViewHelper.A().right;
    }

    public int getContentPaddingTop() {
        return this.cardViewHelper.A().top;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.cardViewHelper.u();
    }

    public float getRadius() {
        return this.cardViewHelper.s();
    }

    public ColorStateList getRippleColor() {
        return this.cardViewHelper.v();
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.cardViewHelper.w();
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        return this.cardViewHelper.x();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.cardViewHelper.y();
    }

    @Dimension
    public int getStrokeWidth() {
        return this.cardViewHelper.z();
    }

    public boolean isCheckable() {
        a aVar = this.cardViewHelper;
        if (aVar == null || !aVar.D()) {
            return false;
        }
        return true;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public boolean isDragged() {
        return this.dragged;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.cardViewHelper.j());
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 3);
        if (isCheckable()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        if (isDragged()) {
            View.mergeDrawableStates(onCreateDrawableState, DRAGGED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.cardViewHelper.H(getMeasuredWidth(), getMeasuredHeight());
    }

    /* access modifiers changed from: package-private */
    public void setAncestorContentPadding(int i10, int i11, int i12, int i13) {
        super.setContentPadding(i10, i11, i12, i13);
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.isParentCardViewDoneInitializing) {
            if (!this.cardViewHelper.C()) {
                Log.i(LOG_TAG, "Setting a custom background is not supported.");
                this.cardViewHelper.I(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setCardBackgroundColor(@ColorInt int i10) {
        this.cardViewHelper.J(ColorStateList.valueOf(i10));
    }

    public void setCardElevation(float f10) {
        super.setCardElevation(f10);
        this.cardViewHelper.d0();
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        this.cardViewHelper.K(colorStateList);
    }

    public void setCheckable(boolean z10) {
        this.cardViewHelper.L(z10);
    }

    public void setChecked(boolean z10) {
        if (this.checked != z10) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.cardViewHelper.N(drawable);
    }

    public void setCheckedIconGravity(int i10) {
        if (this.cardViewHelper.n() != i10) {
            this.cardViewHelper.O(i10);
        }
    }

    public void setCheckedIconMargin(@Dimension int i10) {
        this.cardViewHelper.P(i10);
    }

    public void setCheckedIconMarginResource(@DimenRes int i10) {
        if (i10 != -1) {
            this.cardViewHelper.P(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCheckedIconResource(@DrawableRes int i10) {
        this.cardViewHelper.N(AppCompatResources.getDrawable(getContext(), i10));
    }

    public void setCheckedIconSize(@Dimension int i10) {
        this.cardViewHelper.Q(i10);
    }

    public void setCheckedIconSizeResource(@DimenRes int i10) {
        if (i10 != 0) {
            this.cardViewHelper.Q(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        this.cardViewHelper.R(colorStateList);
    }

    public void setClickable(boolean z10) {
        super.setClickable(z10);
        a aVar = this.cardViewHelper;
        if (aVar != null) {
            aVar.b0();
        }
    }

    public void setContentPadding(int i10, int i11, int i12, int i13) {
        this.cardViewHelper.Y(i10, i11, i12, i13);
    }

    public void setDragged(boolean z10) {
        if (this.dragged != z10) {
            this.dragged = z10;
            refreshDrawableState();
            forceRippleRedrawIfNeeded();
            invalidate();
        }
    }

    public void setMaxCardElevation(float f10) {
        super.setMaxCardElevation(f10);
        this.cardViewHelper.f0();
    }

    public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener onCheckedChangeListener2) {
        this.onCheckedChangeListener = onCheckedChangeListener2;
    }

    public void setPreventCornerOverlap(boolean z10) {
        super.setPreventCornerOverlap(z10);
        this.cardViewHelper.f0();
        this.cardViewHelper.c0();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.cardViewHelper.T(f10);
    }

    public void setRadius(float f10) {
        super.setRadius(f10);
        this.cardViewHelper.S(f10);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        this.cardViewHelper.U(colorStateList);
    }

    public void setRippleColorResource(@ColorRes int i10) {
        this.cardViewHelper.U(AppCompatResources.getColorStateList(getContext(), i10));
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        setClipToOutline(shapeAppearanceModel.isRoundRect(getBoundsAsRectF()));
        this.cardViewHelper.V(shapeAppearanceModel);
    }

    public void setStrokeColor(@ColorInt int i10) {
        setStrokeColor(ColorStateList.valueOf(i10));
    }

    public void setStrokeWidth(@Dimension int i10) {
        this.cardViewHelper.X(i10);
        invalidate();
    }

    public void setUseCompatPadding(boolean z10) {
        super.setUseCompatPadding(z10);
        this.cardViewHelper.f0();
        this.cardViewHelper.c0();
    }

    public void toggle() {
        if (isCheckable() && isEnabled()) {
            this.checked = !this.checked;
            refreshDrawableState();
            forceRippleRedrawIfNeeded();
            this.cardViewHelper.M(this.checked);
            OnCheckedChangeListener onCheckedChangeListener2 = this.onCheckedChangeListener;
            if (onCheckedChangeListener2 != null) {
                onCheckedChangeListener2.onCheckedChanged(this, this.checked);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialCardViewStyle);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.cardViewHelper.J(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.cardViewHelper.W(colorStateList);
        invalidate();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialCardView(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r6 = DEF_STYLE_RES
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r8, r9, r10, r6)
            r7.<init>(r8, r9, r10)
            r8 = 0
            r7.checked = r8
            r7.dragged = r8
            r0 = 1
            r7.isParentCardViewDoneInitializing = r0
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialCardView
            int[] r5 = new int[r8]
            r1 = r9
            r3 = r10
            r4 = r6
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            com.google.android.material.card.a r0 = new com.google.android.material.card.a
            r0.<init>(r7, r9, r10, r6)
            r7.cardViewHelper = r0
            android.content.res.ColorStateList r9 = super.getCardBackgroundColor()
            r0.J(r9)
            int r9 = super.getContentPaddingLeft()
            int r10 = super.getContentPaddingTop()
            int r1 = super.getContentPaddingRight()
            int r2 = super.getContentPaddingBottom()
            r0.Y(r9, r10, r1, r2)
            r0.G(r8)
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
