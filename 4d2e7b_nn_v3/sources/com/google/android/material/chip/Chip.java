package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.internal.MaterialCheckable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.List;

public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate, Shapeable, MaterialCheckable<Chip> {
    private static final String BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.Button";
    private static final int[] CHECKABLE_STATE_SET = {16842911};
    private static final int CHIP_BODY_VIRTUAL_ID = 0;
    private static final int CLOSE_ICON_VIRTUAL_ID = 1;
    private static final String COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.CompoundButton";
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_Chip_Action;
    /* access modifiers changed from: private */
    public static final Rect EMPTY_BOUNDS = new Rect();
    private static final String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
    private static final int MIN_TOUCH_TARGET_DP = 48;
    private static final String NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    private static final String RADIO_BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.RadioButton";
    private static final int[] SELECTED_STATE = {16842913};
    private static final String TAG = "Chip";
    @Nullable
    private CharSequence accessibilityClassName;
    /* access modifiers changed from: private */
    @Nullable
    public ChipDrawable chipDrawable;
    /* access modifiers changed from: private */
    public boolean closeIconFocused;
    private boolean closeIconHovered;
    private boolean closeIconPressed;
    private boolean deferredCheckedValue;
    private boolean ensureMinTouchTargetSize;
    private final TextAppearanceFontCallback fontCallback;
    @Nullable
    private InsetDrawable insetBackgroundDrawable;
    private int lastLayoutDirection;
    @Dimension(unit = 1)
    private int minTouchTargetSize;
    /* access modifiers changed from: private */
    @Nullable
    public CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
    /* access modifiers changed from: private */
    @Nullable
    public MaterialCheckable.OnCheckedChangeListener<Chip> onCheckedChangeListenerInternal;
    /* access modifiers changed from: private */
    @Nullable
    public View.OnClickListener onCloseIconClickListener;
    private final Rect rect;
    private final RectF rectF;
    @Nullable
    private RippleDrawable ripple;
    @NonNull
    private final d touchHelper;
    private boolean touchHelperEnabled;

    class a extends TextAppearanceFontCallback {
        a() {
        }

        public void onFontRetrievalFailed(int i10) {
        }

        public void onFontRetrieved(Typeface typeface, boolean z10) {
            CharSequence charSequence;
            Chip chip = Chip.this;
            if (chip.chipDrawable.shouldDrawText()) {
                charSequence = Chip.this.chipDrawable.getText();
            } else {
                charSequence = Chip.this.getText();
            }
            chip.setText(charSequence);
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (Chip.this.onCheckedChangeListenerInternal != null) {
                Chip.this.onCheckedChangeListenerInternal.onCheckedChanged(Chip.this, z10);
            }
            if (Chip.this.onCheckedChangeListener != null) {
                Chip.this.onCheckedChangeListener.onCheckedChanged(compoundButton, z10);
            }
        }
    }

    class c extends ViewOutlineProvider {
        c() {
        }

        public void getOutline(View view, Outline outline) {
            if (Chip.this.chipDrawable != null) {
                Chip.this.chipDrawable.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    private class d extends ExploreByTouchHelper {
        d(Chip chip) {
            super(chip);
        }

        /* access modifiers changed from: protected */
        public int getVirtualViewAt(float f10, float f11) {
            if (!Chip.this.hasCloseIcon() || !Chip.this.getCloseIconTouchBounds().contains(f10, f11)) {
                return 0;
            }
            return 1;
        }

        /* access modifiers changed from: protected */
        public void getVisibleVirtualViews(List list) {
            list.add(0);
            if (Chip.this.hasCloseIcon() && Chip.this.isCloseIconVisible() && Chip.this.onCloseIconClickListener != null) {
                list.add(1);
            }
        }

        /* access modifiers changed from: protected */
        public boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle) {
            if (i11 != 16) {
                return false;
            }
            if (i10 == 0) {
                return Chip.this.performClick();
            }
            if (i10 == 1) {
                return Chip.this.performCloseIconClick();
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCheckable(Chip.this.isCheckable());
            accessibilityNodeInfoCompat.setClickable(Chip.this.isClickable());
            accessibilityNodeInfoCompat.setClassName(Chip.this.getAccessibilityClassName());
            accessibilityNodeInfoCompat.setText(Chip.this.getText());
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForVirtualView(int i10, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            CharSequence charSequence = "";
            if (i10 == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    accessibilityNodeInfoCompat.setContentDescription(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i11 = R.string.mtrl_chip_close_icon_content_description;
                    if (!TextUtils.isEmpty(text)) {
                        charSequence = text;
                    }
                    accessibilityNodeInfoCompat.setContentDescription(context.getString(i11, new Object[]{charSequence}).trim());
                }
                accessibilityNodeInfoCompat.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
                accessibilityNodeInfoCompat.setEnabled(Chip.this.isEnabled());
                return;
            }
            accessibilityNodeInfoCompat.setContentDescription(charSequence);
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.EMPTY_BOUNDS);
        }

        /* access modifiers changed from: protected */
        public void onVirtualViewKeyboardFocusChanged(int i10, boolean z10) {
            if (i10 == 1) {
                boolean unused = Chip.this.closeIconFocused = z10;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context) {
        this(context, (AttributeSet) null);
    }

    private void applyChipDrawable(@NonNull ChipDrawable chipDrawable2) {
        chipDrawable2.setDelegate(this);
    }

    @NonNull
    private int[] createCloseIconDrawableState() {
        int isEnabled = isEnabled();
        if (this.closeIconFocused) {
            isEnabled++;
        }
        if (this.closeIconHovered) {
            isEnabled++;
        }
        if (this.closeIconPressed) {
            isEnabled++;
        }
        if (isChecked()) {
            isEnabled++;
        }
        int[] iArr = new int[isEnabled];
        int i10 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i10 = 1;
        }
        if (this.closeIconFocused) {
            iArr[i10] = 16842908;
            i10++;
        }
        if (this.closeIconHovered) {
            iArr[i10] = 16843623;
            i10++;
        }
        if (this.closeIconPressed) {
            iArr[i10] = 16842919;
            i10++;
        }
        if (isChecked()) {
            iArr[i10] = 16842913;
        }
        return iArr;
    }

    private void ensureChipDrawableHasCallback() {
        if (getBackgroundDrawable() == this.insetBackgroundDrawable && this.chipDrawable.getCallback() == null) {
            this.chipDrawable.setCallback(this.insetBackgroundDrawable);
        }
    }

    /* access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        this.rectF.setEmpty();
        if (hasCloseIcon() && this.onCloseIconClickListener != null) {
            this.chipDrawable.getCloseIconTouchBounds(this.rectF);
        }
        return this.rectF;
    }

    /* access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.rect.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.rect;
    }

    @Nullable
    private TextAppearance getTextAppearance() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getTextAppearance();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public boolean hasCloseIcon() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 == null || chipDrawable2.getCloseIcon() == null) {
            return false;
        }
        return true;
    }

    private void initMinTouchTarget(Context context, @Nullable AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Chip, i10, DEF_STYLE_RES, new int[0]);
        this.ensureMinTouchTargetSize = obtainStyledAttributes.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
        this.minTouchTargetSize = (int) Math.ceil((double) obtainStyledAttributes.getDimension(R.styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil((double) ViewUtils.dpToPx(getContext(), MIN_TOUCH_TARGET_DP))));
        obtainStyledAttributes.recycle();
    }

    private void initOutlineProvider() {
        setOutlineProvider(new c());
    }

    private void insetChipBackgroundDrawable(int i10, int i11, int i12, int i13) {
        this.insetBackgroundDrawable = new InsetDrawable(this.chipDrawable, i10, i11, i12, i13);
    }

    private void removeBackgroundInset() {
        if (this.insetBackgroundDrawable != null) {
            this.insetBackgroundDrawable = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            updateBackgroundDrawable();
        }
    }

    private void setCloseIconHovered(boolean z10) {
        if (this.closeIconHovered != z10) {
            this.closeIconHovered = z10;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z10) {
        if (this.closeIconPressed != z10) {
            this.closeIconPressed = z10;
            refreshDrawableState();
        }
    }

    private void unapplyChipDrawable(@Nullable ChipDrawable chipDrawable2) {
        if (chipDrawable2 != null) {
            chipDrawable2.setDelegate((ChipDrawable.Delegate) null);
        }
    }

    private void updateAccessibilityDelegate() {
        if (!hasCloseIcon() || !isCloseIconVisible() || this.onCloseIconClickListener == null) {
            ViewCompat.setAccessibilityDelegate(this, (AccessibilityDelegateCompat) null);
            this.touchHelperEnabled = false;
            return;
        }
        ViewCompat.setAccessibilityDelegate(this, this.touchHelper);
        this.touchHelperEnabled = true;
    }

    private void updateBackgroundDrawable() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
            updateFrameworkRippleBackground();
            return;
        }
        this.chipDrawable.setUseCompatRipple(true);
        ViewCompat.setBackground(this, getBackgroundDrawable());
        updatePaddingInternal();
        ensureChipDrawableHasCallback();
    }

    private void updateFrameworkRippleBackground() {
        this.ripple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.chipDrawable.getRippleColor()), getBackgroundDrawable(), (Drawable) null);
        this.chipDrawable.setUseCompatRipple(false);
        ViewCompat.setBackground(this, this.ripple);
        updatePaddingInternal();
    }

    private void updatePaddingInternal() {
        ChipDrawable chipDrawable2;
        if (!TextUtils.isEmpty(getText()) && (chipDrawable2 = this.chipDrawable) != null) {
            int chipEndPadding = (int) (chipDrawable2.getChipEndPadding() + this.chipDrawable.getTextEndPadding() + this.chipDrawable.calculateCloseIconWidth());
            int chipStartPadding = (int) (this.chipDrawable.getChipStartPadding() + this.chipDrawable.getTextStartPadding() + this.chipDrawable.calculateChipIconWidth());
            if (this.insetBackgroundDrawable != null) {
                Rect rect2 = new Rect();
                this.insetBackgroundDrawable.getPadding(rect2);
                chipStartPadding += rect2.left;
                chipEndPadding += rect2.right;
            }
            ViewCompat.setPaddingRelative(this, chipStartPadding, getPaddingTop(), chipEndPadding, getPaddingBottom());
        }
    }

    private void updateTextPaintDrawState() {
        TextPaint paint = getPaint();
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            paint.drawableState = chipDrawable2.getState();
        }
        TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.updateDrawState(getContext(), paint, this.fontCallback);
        }
    }

    private void validateAttributes(@Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, AppStateModule.APP_STATE_BACKGROUND) != null) {
                Log.w(TAG, "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (!attributeSet.getAttributeBooleanValue(NAMESPACE_ANDROID, "singleLine", true) || attributeSet.getAttributeIntValue(NAMESPACE_ANDROID, "lines", 1) != 1 || attributeSet.getAttributeIntValue(NAMESPACE_ANDROID, "minLines", 1) != 1 || attributeSet.getAttributeIntValue(NAMESPACE_ANDROID, "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            } else if (attributeSet.getAttributeIntValue(NAMESPACE_ANDROID, "gravity", 8388627) != 8388627) {
                Log.w(TAG, "Chip text must be vertically center and start aligned");
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!this.touchHelperEnabled) {
            return super.dispatchHoverEvent(motionEvent);
        }
        if (this.touchHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.touchHelperEnabled) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.touchHelper.dispatchKeyEvent(keyEvent) || this.touchHelper.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        boolean z10;
        super.drawableStateChanged();
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 == null || !chipDrawable2.isCloseIconStateful()) {
            z10 = false;
        } else {
            z10 = this.chipDrawable.setCloseIconState(createCloseIconDrawableState());
        }
        if (z10) {
            invalidate();
        }
    }

    public boolean ensureAccessibleTouchTarget(@Dimension int i10) {
        int i11;
        this.minTouchTargetSize = i10;
        int i12 = 0;
        if (!shouldEnsureMinTouchTargetSize()) {
            if (this.insetBackgroundDrawable != null) {
                removeBackgroundInset();
            } else {
                updateBackgroundDrawable();
            }
            return false;
        }
        int max = Math.max(0, i10 - this.chipDrawable.getIntrinsicHeight());
        int max2 = Math.max(0, i10 - this.chipDrawable.getIntrinsicWidth());
        if (max2 > 0 || max > 0) {
            if (max2 > 0) {
                i11 = max2 / 2;
            } else {
                i11 = 0;
            }
            if (max > 0) {
                i12 = max / 2;
            }
            if (this.insetBackgroundDrawable != null) {
                Rect rect2 = new Rect();
                this.insetBackgroundDrawable.getPadding(rect2);
                if (rect2.top == i12 && rect2.bottom == i12 && rect2.left == i11 && rect2.right == i11) {
                    updateBackgroundDrawable();
                    return true;
                }
            }
            if (getMinHeight() != i10) {
                setMinHeight(i10);
            }
            if (getMinWidth() != i10) {
                setMinWidth(i10);
            }
            insetChipBackgroundDrawable(i11, i12, i11, i12);
            updateBackgroundDrawable();
            return true;
        }
        if (this.insetBackgroundDrawable != null) {
            removeBackgroundInset();
        } else {
            updateBackgroundDrawable();
        }
        return false;
    }

    @NonNull
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.accessibilityClassName)) {
            return this.accessibilityClassName;
        }
        if (isCheckable()) {
            ViewParent parent = getParent();
            if (!(parent instanceof ChipGroup) || !((ChipGroup) parent).isSingleSelection()) {
                return COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME;
            }
            return RADIO_BUTTON_ACCESSIBILITY_CLASS_NAME;
        } else if (isClickable()) {
            return BUTTON_ACCESSIBILITY_CLASS_NAME;
        } else {
            return GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME;
        }
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.insetBackgroundDrawable;
        if (insetDrawable == null) {
            return this.chipDrawable;
        }
        return insetDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getCheckedIcon();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getCheckedIconTint();
        }
        return null;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getChipBackgroundColor();
        }
        return null;
    }

    public float getChipCornerRadius() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return Math.max(0.0f, chipDrawable2.getChipCornerRadius());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.chipDrawable;
    }

    public float getChipEndPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getChipEndPadding();
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getChipIcon() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getChipIcon();
        }
        return null;
    }

    public float getChipIconSize() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getChipIconSize();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getChipIconTint();
        }
        return null;
    }

    public float getChipMinHeight() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getChipMinHeight();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getChipStartPadding();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getChipStrokeColor();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getChipStrokeWidth();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getCloseIcon();
        }
        return null;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getCloseIconContentDescription();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getCloseIconEndPadding();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getCloseIconSize();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getCloseIconStartPadding();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getCloseIconTint();
        }
        return null;
    }

    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getEllipsize();
        }
        return null;
    }

    public void getFocusedRect(@NonNull Rect rect2) {
        if (!this.touchHelperEnabled || !(this.touchHelper.getKeyboardFocusedVirtualViewId() == 1 || this.touchHelper.getAccessibilityFocusedVirtualViewId() == 1)) {
            super.getFocusedRect(rect2);
        } else {
            rect2.set(getCloseIconTouchBoundsInt());
        }
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getHideMotionSpec();
        }
        return null;
    }

    public float getIconEndPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getIconEndPadding();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getIconStartPadding();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getRippleColor();
        }
        return null;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.chipDrawable.getShapeAppearanceModel();
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getShowMotionSpec();
        }
        return null;
    }

    public float getTextEndPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getTextEndPadding();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            return chipDrawable2.getTextStartPadding();
        }
        return 0.0f;
    }

    public boolean isCheckable() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 == null || !chipDrawable2.isCheckable()) {
            return false;
        }
        return true;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 == null || !chipDrawable2.isCheckedIconVisible()) {
            return false;
        }
        return true;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 == null || !chipDrawable2.isChipIconVisible()) {
            return false;
        }
        return true;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public boolean isCloseIconVisible() {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 == null || !chipDrawable2.isCloseIconVisible()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.chipDrawable);
    }

    public void onChipDrawableSizeChange() {
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        requestLayout();
        invalidateOutline();
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, SELECTED_STATE);
        }
        if (isCheckable()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z10, int i10, Rect rect2) {
        super.onFocusChanged(z10, i10, rect2);
        if (this.touchHelperEnabled) {
            this.touchHelper.onFocusChanged(z10, i10, rect2);
        }
    }

    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i10;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            if (chipGroup.isSingleLine()) {
                i10 = chipGroup.getIndexOfChip(this);
            } else {
                i10 = -1;
            }
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(chipGroup.getRowIndex(this), 1, i10, 1, false, isChecked()));
        }
    }

    @TargetApi(24)
    @Nullable
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent motionEvent, int i10) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    @TargetApi(17)
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        if (this.lastLayoutDirection != i10) {
            this.lastLayoutDirection = i10;
            updatePaddingInternal();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x003a
            if (r0 == r2) goto L_0x002c
            r4 = 2
            if (r0 == r4) goto L_0x0021
            r1 = 3
            if (r0 == r1) goto L_0x0035
            goto L_0x0040
        L_0x0021:
            boolean r0 = r5.closeIconPressed
            if (r0 == 0) goto L_0x0040
            if (r1 != 0) goto L_0x002a
            r5.setCloseIconPressed(r3)
        L_0x002a:
            r0 = r2
            goto L_0x0041
        L_0x002c:
            boolean r0 = r5.closeIconPressed
            if (r0 == 0) goto L_0x0035
            r5.performCloseIconClick()
            r0 = r2
            goto L_0x0036
        L_0x0035:
            r0 = r3
        L_0x0036:
            r5.setCloseIconPressed(r3)
            goto L_0x0041
        L_0x003a:
            if (r1 == 0) goto L_0x0040
            r5.setCloseIconPressed(r2)
            goto L_0x002a
        L_0x0040:
            r0 = r3
        L_0x0041:
            if (r0 != 0) goto L_0x004b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r2 = r3
        L_0x004b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @CallSuper
    public boolean performCloseIconClick() {
        boolean z10 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.onCloseIconClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z10 = true;
        }
        if (this.touchHelperEnabled) {
            this.touchHelper.sendEventForVirtualView(1, 1);
        }
        return z10;
    }

    public void setAccessibilityClassName(@Nullable CharSequence charSequence) {
        this.accessibilityClassName = charSequence;
    }

    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.ripple) {
            super.setBackground(drawable);
        } else {
            Log.w(TAG, "Do not set the background; Chip manages its own background drawable.");
        }
    }

    public void setBackgroundColor(int i10) {
        Log.w(TAG, "Do not set the background color; Chip manages its own background drawable.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.ripple) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w(TAG, "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    public void setBackgroundResource(int i10) {
        Log.w(TAG, "Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Log.w(TAG, "Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Log.w(TAG, "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckable(z10);
        }
    }

    public void setCheckableResource(@BoolRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckableResource(i10);
        }
    }

    public void setChecked(boolean z10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 == null) {
            this.deferredCheckedValue = z10;
        } else if (chipDrawable2.isCheckable()) {
            super.setChecked(z10);
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIcon(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z10) {
        setCheckedIconVisible(z10);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i10) {
        setCheckedIconVisible(i10);
    }

    public void setCheckedIconResource(@DrawableRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIconResource(i10);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIconTint(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIconTintResource(i10);
        }
    }

    public void setCheckedIconVisible(@BoolRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIconVisible(i10);
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipBackgroundColor(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(@ColorRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipBackgroundColorResource(i10);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipCornerRadius(f10);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipCornerRadiusResource(i10);
        }
    }

    public void setChipDrawable(@NonNull ChipDrawable chipDrawable2) {
        ChipDrawable chipDrawable3 = this.chipDrawable;
        if (chipDrawable3 != chipDrawable2) {
            unapplyChipDrawable(chipDrawable3);
            this.chipDrawable = chipDrawable2;
            chipDrawable2.setShouldDrawText(false);
            applyChipDrawable(this.chipDrawable);
            ensureAccessibleTouchTarget(this.minTouchTargetSize);
        }
    }

    public void setChipEndPadding(float f10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipEndPadding(f10);
        }
    }

    public void setChipEndPaddingResource(@DimenRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipEndPaddingResource(i10);
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIcon(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z10) {
        setChipIconVisible(z10);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i10) {
        setChipIconVisible(i10);
    }

    public void setChipIconResource(@DrawableRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconResource(i10);
        }
    }

    public void setChipIconSize(float f10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconSize(f10);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconSizeResource(i10);
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconTint(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconTintResource(i10);
        }
    }

    public void setChipIconVisible(@BoolRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconVisible(i10);
        }
    }

    public void setChipMinHeight(float f10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipMinHeight(f10);
        }
    }

    public void setChipMinHeightResource(@DimenRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipMinHeightResource(i10);
        }
    }

    public void setChipStartPadding(float f10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStartPadding(f10);
        }
    }

    public void setChipStartPaddingResource(@DimenRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStartPaddingResource(i10);
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStrokeColor(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStrokeColorResource(i10);
        }
    }

    public void setChipStrokeWidth(float f10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStrokeWidth(f10);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipStrokeWidthResource(i10);
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i10) {
        setText(getResources().getString(i10));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIcon(drawable);
        }
        updateAccessibilityDelegate();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconContentDescription(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z10) {
        setCloseIconVisible(z10);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i10) {
        setCloseIconVisible(i10);
    }

    public void setCloseIconEndPadding(float f10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconEndPadding(f10);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconEndPaddingResource(i10);
        }
    }

    public void setCloseIconResource(@DrawableRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconResource(i10);
        }
        updateAccessibilityDelegate();
    }

    public void setCloseIconSize(float f10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconSize(f10);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconSizeResource(i10);
        }
    }

    public void setCloseIconStartPadding(float f10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconStartPadding(f10);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconStartPaddingResource(i10);
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconTint(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconTintResource(i10);
        }
    }

    public void setCloseIconVisible(@BoolRes int i10) {
        setCloseIconVisible(getResources().getBoolean(i10));
    }

    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i12 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i10, i11, i12, i13);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i12 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i10, i11, i12, i13);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @RequiresApi(21)
    public void setElevation(float f10) {
        super.setElevation(f10);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setElevation(f10);
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.chipDrawable != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                ChipDrawable chipDrawable2 = this.chipDrawable;
                if (chipDrawable2 != null) {
                    chipDrawable2.setEllipsize(truncateAt);
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        this.ensureMinTouchTargetSize = z10;
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
    }

    public void setGravity(int i10) {
        if (i10 != 8388627) {
            Log.w(TAG, "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i10);
        }
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setHideMotionSpec(motionSpec);
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setHideMotionSpecResource(i10);
        }
    }

    public void setIconEndPadding(float f10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setIconEndPadding(f10);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setIconEndPaddingResource(i10);
        }
    }

    public void setIconStartPadding(float f10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setIconStartPadding(f10);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setIconStartPaddingResource(i10);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInternalOnCheckedChangeListener(@Nullable MaterialCheckable.OnCheckedChangeListener<Chip> onCheckedChangeListener2) {
        this.onCheckedChangeListenerInternal = onCheckedChangeListener2;
    }

    public void setLayoutDirection(int i10) {
        if (this.chipDrawable != null) {
            super.setLayoutDirection(i10);
        }
    }

    public void setLines(int i10) {
        if (i10 <= 1) {
            super.setLines(i10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int i10) {
        if (i10 <= 1) {
            super.setMaxLines(i10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(@Px int i10) {
        super.setMaxWidth(i10);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setMaxWidth(i10);
        }
    }

    public void setMinLines(int i10) {
        if (i10 <= 1) {
            super.setMinLines(i10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener2) {
        this.onCheckedChangeListener = onCheckedChangeListener2;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.onCloseIconClickListener = onClickListener;
        updateAccessibilityDelegate();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setRippleColor(colorStateList);
        }
        if (!this.chipDrawable.getUseCompatRipple()) {
            updateFrameworkRippleBackground();
        }
    }

    public void setRippleColorResource(@ColorRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setRippleColorResource(i10);
            if (!this.chipDrawable.getUseCompatRipple()) {
                updateFrameworkRippleBackground();
            }
        }
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.chipDrawable.setShapeAppearanceModel(shapeAppearanceModel);
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setShowMotionSpec(motionSpec);
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setShowMotionSpecResource(i10);
        }
    }

    public void setSingleLine(boolean z10) {
        if (z10) {
            super.setSingleLine(z10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence charSequence2;
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            if (chipDrawable2.shouldDrawText()) {
                charSequence2 = null;
            } else {
                charSequence2 = charSequence;
            }
            super.setText(charSequence2, bufferType);
            ChipDrawable chipDrawable3 = this.chipDrawable;
            if (chipDrawable3 != null) {
                chipDrawable3.setText(charSequence);
            }
        }
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextAppearance(textAppearance);
        }
        updateTextPaintDrawState();
    }

    public void setTextAppearanceResource(@StyleRes int i10) {
        setTextAppearance(getContext(), i10);
    }

    public void setTextEndPadding(float f10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextEndPadding(f10);
        }
    }

    public void setTextEndPaddingResource(@DimenRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextEndPaddingResource(i10);
        }
    }

    public void setTextStartPadding(float f10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextStartPadding(f10);
        }
    }

    public void setTextStartPaddingResource(@DimenRes int i10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextStartPaddingResource(i10);
        }
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipStyle);
    }

    public void setCloseIconVisible(boolean z10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCloseIconVisible(z10);
        }
        updateAccessibilityDelegate();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Chip(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>()
            r6.rect = r7
            android.graphics.RectF r7 = new android.graphics.RectF
            r7.<init>()
            r6.rectF = r7
            com.google.android.material.chip.Chip$a r7 = new com.google.android.material.chip.Chip$a
            r7.<init>()
            r6.fontCallback = r7
            android.content.Context r0 = r6.getContext()
            r6.validateAttributes(r8)
            com.google.android.material.chip.ChipDrawable r7 = com.google.android.material.chip.ChipDrawable.createFromAttributes(r0, r8, r9, r4)
            r6.initMinTouchTarget(r0, r8, r9)
            r6.setChipDrawable(r7)
            float r1 = androidx.core.view.ViewCompat.getElevation(r6)
            r7.setElevation(r1)
            int[] r2 = com.google.android.material.R.styleable.Chip
            r1 = 0
            int[] r5 = new int[r1]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.Chip_shapeAppearance
            boolean r9 = r8.hasValue(r9)
            r8.recycle()
            com.google.android.material.chip.Chip$d r8 = new com.google.android.material.chip.Chip$d
            r8.<init>(r6)
            r6.touchHelper = r8
            r6.updateAccessibilityDelegate()
            if (r9 != 0) goto L_0x0059
            r6.initOutlineProvider()
        L_0x0059:
            boolean r8 = r6.deferredCheckedValue
            r6.setChecked(r8)
            java.lang.CharSequence r8 = r7.getText()
            r6.setText(r8)
            android.text.TextUtils$TruncateAt r7 = r7.getEllipsize()
            r6.setEllipsize(r7)
            r6.updateTextPaintDrawState()
            com.google.android.material.chip.ChipDrawable r7 = r6.chipDrawable
            boolean r7 = r7.shouldDrawText()
            if (r7 != 0) goto L_0x007e
            r7 = 1
            r6.setLines(r7)
            r6.setHorizontallyScrolling(r7)
        L_0x007e:
            r7 = 8388627(0x800013, float:1.175497E-38)
            r6.setGravity(r7)
            r6.updatePaddingInternal()
            boolean r7 = r6.shouldEnsureMinTouchTargetSize()
            if (r7 == 0) goto L_0x0092
            int r7 = r6.minTouchTargetSize
            r6.setMinHeight(r7)
        L_0x0092:
            int r7 = androidx.core.view.ViewCompat.getLayoutDirection(r6)
            r6.lastLayoutDirection = r7
            com.google.android.material.chip.Chip$b r7 = new com.google.android.material.chip.Chip$b
            r7.<init>()
            super.setOnCheckedChangeListener(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedIconVisible(boolean z10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setCheckedIconVisible(z10);
        }
    }

    public void setChipIconVisible(boolean z10) {
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setChipIconVisible(z10);
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextAppearanceResource(i10);
        }
        updateTextPaintDrawState();
    }

    public void setTextAppearance(int i10) {
        super.setTextAppearance(i10);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != null) {
            chipDrawable2.setTextAppearanceResource(i10);
        }
        updateTextPaintDrawState();
    }
}
