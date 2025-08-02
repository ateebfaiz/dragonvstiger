package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    private static final int[] CHECKABLE_STATE_SET = {16842911};
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_Button;
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    public static final int ICON_GRAVITY_TEXT_TOP = 32;
    public static final int ICON_GRAVITY_TOP = 16;
    private static final String LOG_TAG = "MaterialButton";
    private boolean broadcasting;
    private boolean checked;
    @Nullable
    private Drawable icon;
    private int iconGravity;
    @Px
    private int iconLeft;
    @Px
    private int iconPadding;
    @Px
    private int iconSize;
    @Nullable
    private ColorStateList iconTint;
    @Nullable
    private PorterDuff.Mode iconTintMode;
    @Px
    private int iconTop;
    @NonNull
    private final a materialButtonHelper;
    @NonNull
    private final LinkedHashSet<OnCheckedChangeListener> onCheckedChangeListeners;
    @Nullable
    private a onPressedChangeListenerInternal;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton materialButton, boolean z10);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        boolean f7979a;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel) {
            boolean z10 = true;
            if (parcel.readInt() != 1) {
                z10 = false;
            }
            this.f7979a = z10;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f7979a ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            a(parcel);
        }
    }

    interface a {
        void a(MaterialButton materialButton, boolean z10);
    }

    public MaterialButton(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @NonNull
    private String getA11yClassName() {
        Class cls;
        if (isCheckable()) {
            cls = CompoundButton.class;
        } else {
            cls = Button.class;
        }
        return cls.getName();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        if (textAlignment == 1) {
            return getGravityTextAlignment();
        }
        if (textAlignment == 6 || textAlignment == 3) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (textAlignment != 4) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (gravity == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (gravity == 5 || gravity == 8388613) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_NORMAL;
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    private boolean isIconEnd() {
        int i10 = this.iconGravity;
        if (i10 == 3 || i10 == 4) {
            return true;
        }
        return false;
    }

    private boolean isIconStart() {
        int i10 = this.iconGravity;
        if (i10 == 1 || i10 == 2) {
            return true;
        }
        return false;
    }

    private boolean isIconTop() {
        int i10 = this.iconGravity;
        if (i10 == 16 || i10 == 32) {
            return true;
        }
        return false;
    }

    private boolean isLayoutRTL() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return true;
        }
        return false;
    }

    private boolean isUsingOriginalBackground() {
        a aVar = this.materialButtonHelper;
        if (aVar == null || aVar.o()) {
            return false;
        }
        return true;
    }

    private void resetIconDrawable() {
        if (isIconStart()) {
            TextViewCompat.setCompoundDrawablesRelative(this, this.icon, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (isIconEnd()) {
            TextViewCompat.setCompoundDrawablesRelative(this, (Drawable) null, (Drawable) null, this.icon, (Drawable) null);
        } else if (isIconTop()) {
            TextViewCompat.setCompoundDrawablesRelative(this, (Drawable) null, this.icon, (Drawable) null, (Drawable) null);
        }
    }

    private void updateIcon(boolean z10) {
        Drawable drawable = this.icon;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.icon = mutate;
            DrawableCompat.setTintList(mutate, this.iconTint);
            PorterDuff.Mode mode = this.iconTintMode;
            if (mode != null) {
                DrawableCompat.setTintMode(this.icon, mode);
            }
            int i10 = this.iconSize;
            if (i10 == 0) {
                i10 = this.icon.getIntrinsicWidth();
            }
            int i11 = this.iconSize;
            if (i11 == 0) {
                i11 = this.icon.getIntrinsicHeight();
            }
            Drawable drawable2 = this.icon;
            int i12 = this.iconLeft;
            int i13 = this.iconTop;
            drawable2.setBounds(i12, i13, i10 + i12, i11 + i13);
            this.icon.setVisible(true, z10);
        }
        if (z10) {
            resetIconDrawable();
            return;
        }
        Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this);
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((isIconStart() && drawable3 != this.icon) || ((isIconEnd() && drawable5 != this.icon) || (isIconTop() && drawable4 != this.icon))) {
            resetIconDrawable();
        }
    }

    private void updateIconPosition(int i10, int i11) {
        if (this.icon != null && getLayout() != null) {
            if (isIconStart() || isIconEnd()) {
                this.iconTop = 0;
                Layout.Alignment actualTextAlignment = getActualTextAlignment();
                int i12 = this.iconGravity;
                boolean z10 = true;
                if (i12 == 1 || i12 == 3 || ((i12 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i12 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
                    this.iconLeft = 0;
                    updateIcon(false);
                    return;
                }
                int i13 = this.iconSize;
                if (i13 == 0) {
                    i13 = this.icon.getIntrinsicWidth();
                }
                int textWidth = ((((i10 - getTextWidth()) - ViewCompat.getPaddingEnd(this)) - i13) - this.iconPadding) - ViewCompat.getPaddingStart(this);
                if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
                    textWidth /= 2;
                }
                boolean isLayoutRTL = isLayoutRTL();
                if (this.iconGravity != 4) {
                    z10 = false;
                }
                if (isLayoutRTL != z10) {
                    textWidth = -textWidth;
                }
                if (this.iconLeft != textWidth) {
                    this.iconLeft = textWidth;
                    updateIcon(false);
                }
            } else if (isIconTop()) {
                this.iconLeft = 0;
                if (this.iconGravity == 16) {
                    this.iconTop = 0;
                    updateIcon(false);
                    return;
                }
                int i14 = this.iconSize;
                if (i14 == 0) {
                    i14 = this.icon.getIntrinsicHeight();
                }
                int textHeight = (((((i11 - getTextHeight()) - getPaddingTop()) - i14) - this.iconPadding) - getPaddingBottom()) / 2;
                if (this.iconTop != textHeight) {
                    this.iconTop = textHeight;
                    updateIcon(false);
                }
            }
        }
    }

    public void addOnCheckedChangeListener(@NonNull OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListeners.add(onCheckedChangeListener);
    }

    public void clearOnCheckedChangeListeners() {
        this.onCheckedChangeListeners.clear();
    }

    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    @Px
    public int getIconPadding() {
        return this.iconPadding;
    }

    @Px
    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    @Dimension
    public int getInsetBottom() {
        return this.materialButtonHelper.c();
    }

    @Dimension
    public int getInsetTop() {
        return this.materialButtonHelper.d();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.h();
        }
        return null;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.j();
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.k();
        }
        return 0;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.l();
        }
        return super.getSupportBackgroundTintList();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.m();
        }
        return super.getSupportBackgroundTintMode();
    }

    public boolean isCheckable() {
        a aVar = this.materialButtonHelper;
        if (aVar == null || !aVar.p()) {
            return false;
        }
        return true;
    }

    public boolean isChecked() {
        return this.checked;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isUsingOriginalBackground()) {
            MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialButtonHelper.f());
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (isCheckable()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f7979a);
    }

    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7979a = this.checked;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.icon != null) {
            if (this.icon.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void removeOnCheckedChangeListener(@NonNull OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListeners.remove(onCheckedChangeListener);
    }

    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(@ColorInt int i10) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.r(i10);
        } else {
            super.setBackgroundColor(i10);
        }
    }

    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (!isUsingOriginalBackground()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable != getBackground()) {
            Log.w(LOG_TAG, "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.materialButtonHelper.s();
            super.setBackgroundDrawable(drawable);
        } else {
            getBackground().setState(drawable.getState());
        }
    }

    public void setBackgroundResource(@DrawableRes int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = AppCompatResources.getDrawable(getContext(), i10);
        } else {
            drawable = null;
        }
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z10) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.t(z10);
        }
    }

    public void setChecked(boolean z10) {
        if (isCheckable() && isEnabled() && this.checked != z10) {
            this.checked = z10;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).onButtonCheckedStateChanged(this, this.checked);
            }
            if (!this.broadcasting) {
                this.broadcasting = true;
                Iterator<OnCheckedChangeListener> it = this.onCheckedChangeListeners.iterator();
                while (it.hasNext()) {
                    it.next().onCheckedChanged(this, this.checked);
                }
                this.broadcasting = false;
            }
        }
    }

    public void setCornerRadius(@Px int i10) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.u(i10);
        }
    }

    public void setCornerRadiusResource(@DimenRes int i10) {
        if (isUsingOriginalBackground()) {
            setCornerRadius(getResources().getDimensionPixelSize(i10));
        }
    }

    @RequiresApi(21)
    public void setElevation(float f10) {
        super.setElevation(f10);
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.f().setElevation(f10);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.icon != drawable) {
            this.icon = drawable;
            updateIcon(true);
            updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i10) {
        if (this.iconGravity != i10) {
            this.iconGravity = i10;
            updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i10) {
        if (this.iconPadding != i10) {
            this.iconPadding = i10;
            setCompoundDrawablePadding(i10);
        }
    }

    public void setIconResource(@DrawableRes int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = AppCompatResources.getDrawable(getContext(), i10);
        } else {
            drawable = null;
        }
        setIcon(drawable);
    }

    public void setIconSize(@Px int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.iconSize != i10) {
            this.iconSize = i10;
            updateIcon(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.iconTint != colorStateList) {
            this.iconTint = colorStateList;
            updateIcon(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.iconTintMode != mode) {
            this.iconTintMode = mode;
            updateIcon(false);
        }
    }

    public void setIconTintResource(@ColorRes int i10) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i10));
    }

    public void setInsetBottom(@Dimension int i10) {
        this.materialButtonHelper.v(i10);
    }

    public void setInsetTop(@Dimension int i10) {
        this.materialButtonHelper.w(i10);
    }

    /* access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    /* access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(@Nullable a aVar) {
        this.onPressedChangeListenerInternal = aVar;
    }

    public void setPressed(boolean z10) {
        a aVar = this.onPressedChangeListenerInternal;
        if (aVar != null) {
            aVar.a(this, z10);
        }
        super.setPressed(z10);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.x(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i10) {
        if (isUsingOriginalBackground()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i10));
        }
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.y(shapeAppearanceModel);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    /* access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z10) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.z(z10);
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.A(colorStateList);
        }
    }

    public void setStrokeColorResource(@ColorRes int i10) {
        if (isUsingOriginalBackground()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i10));
        }
    }

    public void setStrokeWidth(@Px int i10) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.B(i10);
        }
    }

    public void setStrokeWidthResource(@DimenRes int i10) {
        if (isUsingOriginalBackground()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i10));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.C(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.D(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @RequiresApi(17)
    public void setTextAlignment(int i10) {
        super.setTextAlignment(i10);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    public void toggle() {
        setChecked(!this.checked);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButton(@androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r6 = DEF_STYLE_RES
            android.content.Context r9 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r9, r10, r11, r6)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.onCheckedChangeListeners = r9
            r9 = 0
            r8.checked = r9
            r8.broadcasting = r9
            android.content.Context r7 = r8.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButton
            int[] r5 = new int[r9]
            r0 = r7
            r1 = r10
            r3 = r11
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconPadding
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.iconPadding = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconTintMode
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.ViewUtils.parseTintMode(r1, r2)
            r8.iconTintMode = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R.styleable.MaterialButton_iconTint
            android.content.res.ColorStateList r1 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r1, (android.content.res.TypedArray) r0, (int) r2)
            r8.iconTint = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R.styleable.MaterialButton_icon
            android.graphics.drawable.Drawable r1 = com.google.android.material.resources.MaterialResources.getDrawable(r1, r0, r2)
            r8.icon = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconGravity
            r2 = 1
            int r1 = r0.getInteger(r1, r2)
            r8.iconGravity = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconSize
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.iconSize = r1
            com.google.android.material.shape.ShapeAppearanceModel$Builder r10 = com.google.android.material.shape.ShapeAppearanceModel.builder((android.content.Context) r7, (android.util.AttributeSet) r10, (int) r11, (int) r6)
            com.google.android.material.shape.ShapeAppearanceModel r10 = r10.build()
            com.google.android.material.button.a r11 = new com.google.android.material.button.a
            r11.<init>(r8, r10)
            r8.materialButtonHelper = r11
            r11.q(r0)
            r0.recycle()
            int r10 = r8.iconPadding
            r8.setCompoundDrawablePadding(r10)
            android.graphics.drawable.Drawable r10 = r8.icon
            if (r10 == 0) goto L_0x0084
            r9 = r2
        L_0x0084:
            r8.updateIcon(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
