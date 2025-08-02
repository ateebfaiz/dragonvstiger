package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class TextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_TextInputLayout;
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private static final int NO_WIDTH = -1;
    private static final long PLACEHOLDER_FADE_DURATION = 87;
    private static final long PLACEHOLDER_START_DELAY = 67;
    private ValueAnimator animator;
    private boolean areCornerRadiiRtl;
    @Nullable
    private MaterialShapeDrawable boxBackground;
    @ColorInt
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private int boxCollapsedPaddingTopPx;
    private final int boxLabelCutoutPaddingPx;
    @ColorInt
    private int boxStrokeColor;
    private int boxStrokeWidthDefaultPx;
    private int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    @Nullable
    private MaterialShapeDrawable boxUnderlineDefault;
    @Nullable
    private MaterialShapeDrawable boxUnderlineFocused;
    final CollapsingTextHelper collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;
    @Nullable
    private ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;
    @Nullable
    private ColorStateList counterTextColor;
    @Nullable
    private TextView counterView;
    @ColorInt
    private int defaultFilledBackgroundColor;
    private ColorStateList defaultHintTextColor;
    @ColorInt
    private int defaultStrokeColor;
    @ColorInt
    private int disabledColor;
    @ColorInt
    private int disabledFilledBackgroundColor;
    EditText editText;
    private final LinkedHashSet<OnEditTextAttachedListener> editTextAttachedListeners;
    @Nullable
    private Drawable endDummyDrawable;
    private int endDummyDrawableWidth;
    private final LinkedHashSet<OnEndIconChangedListener> endIconChangedListeners;
    private final SparseArray<f> endIconDelegates;
    @NonNull
    private final FrameLayout endIconFrame;
    private int endIconMode;
    private View.OnLongClickListener endIconOnLongClickListener;
    private ColorStateList endIconTintList;
    private PorterDuff.Mode endIconTintMode;
    /* access modifiers changed from: private */
    @NonNull
    public final CheckableImageButton endIconView;
    @NonNull
    private final LinearLayout endLayout;
    private View.OnLongClickListener errorIconOnLongClickListener;
    private ColorStateList errorIconTintList;
    private PorterDuff.Mode errorIconTintMode;
    @NonNull
    private final CheckableImageButton errorIconView;
    private boolean expandedHintEnabled;
    @ColorInt
    private int focusedFilledBackgroundColor;
    @ColorInt
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    @ColorInt
    private int hoveredFilledBackgroundColor;
    @ColorInt
    private int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    /* access modifiers changed from: private */
    public final h indicatorViewController;
    @NonNull
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private int maxEms;
    private int maxWidth;
    private int minEms;
    private int minWidth;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    /* access modifiers changed from: private */
    public boolean placeholderEnabled;
    @Nullable
    private Fade placeholderFadeIn;
    @Nullable
    private Fade placeholderFadeOut;
    private CharSequence placeholderText;
    private int placeholderTextAppearance;
    @Nullable
    private ColorStateList placeholderTextColor;
    private TextView placeholderTextView;
    /* access modifiers changed from: private */
    public boolean restoringSavedState;
    @NonNull
    private ShapeAppearanceModel shapeAppearanceModel;
    @Nullable
    private Drawable startDummyDrawable;
    private int startDummyDrawableWidth;
    /* access modifiers changed from: private */
    @NonNull
    public final StartCompoundLayout startLayout;
    private ColorStateList strokeErrorColor;
    @Nullable
    private CharSequence suffixText;
    @NonNull
    private final TextView suffixTextView;
    private final Rect tmpBoundsRect;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final TextInputLayout layout;

        public AccessibilityDelegate(@NonNull TextInputLayout textInputLayout) {
            this.layout = textInputLayout;
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Editable editable;
            String str;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.layout.getEditText();
            if (editText != null) {
                editable = editText.getText();
            } else {
                editable = null;
            }
            CharSequence hint = this.layout.getHint();
            CharSequence error = this.layout.getError();
            CharSequence placeholderText = this.layout.getPlaceholderText();
            int counterMaxLength = this.layout.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.layout.getCounterOverflowDescription();
            boolean isEmpty = TextUtils.isEmpty(editable);
            boolean z10 = !isEmpty;
            boolean z11 = true;
            boolean z12 = !TextUtils.isEmpty(hint);
            boolean z13 = !this.layout.isHintExpanded();
            boolean z14 = !TextUtils.isEmpty(error);
            if (!z14 && TextUtils.isEmpty(counterOverflowDescription)) {
                z11 = false;
            }
            if (z12) {
                str = hint.toString();
            } else {
                str = "";
            }
            this.layout.startLayout.w(accessibilityNodeInfoCompat);
            if (z10) {
                accessibilityNodeInfoCompat.setText(editable);
            } else if (!TextUtils.isEmpty(str)) {
                accessibilityNodeInfoCompat.setText(str);
                if (z13 && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(str + ", " + placeholderText);
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(str)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(str);
                } else {
                    if (z10) {
                        str = editable + ", " + str;
                    }
                    accessibilityNodeInfoCompat.setText(str);
                }
                accessibilityNodeInfoCompat.setShowingHintText(isEmpty);
            }
            if (editable == null || editable.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
            if (z11) {
                if (!z14) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
            View s10 = this.layout.indicatorViewController.s();
            if (s10 != null) {
                accessibilityNodeInfoCompat.setLabelFor(s10);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EndIconMode {
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(@NonNull TextInputLayout textInputLayout);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i10);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        CharSequence f8557a;

        /* renamed from: b  reason: collision with root package name */
        boolean f8558b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f8559c;

        /* renamed from: d  reason: collision with root package name */
        CharSequence f8560d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f8561e;

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

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.f8557a + " hint=" + this.f8559c + " helperText=" + this.f8560d + " placeholderText=" + this.f8561e + "}";
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            TextUtils.writeToParcel(this.f8557a, parcel, i10);
            parcel.writeInt(this.f8558b ? 1 : 0);
            TextUtils.writeToParcel(this.f8559c, parcel, i10);
            TextUtils.writeToParcel(this.f8560d, parcel, i10);
            TextUtils.writeToParcel(this.f8561e, parcel, i10);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
            this.f8557a = (CharSequence) creator.createFromParcel(parcel);
            this.f8558b = parcel.readInt() != 1 ? false : true;
            this.f8559c = (CharSequence) creator.createFromParcel(parcel);
            this.f8560d = (CharSequence) creator.createFromParcel(parcel);
            this.f8561e = (CharSequence) creator.createFromParcel(parcel);
        }
    }

    class a implements TextWatcher {
        a() {
        }

        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.updateLabelState(!textInputLayout.restoringSavedState);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.counterEnabled) {
                textInputLayout2.updateCounter(editable.length());
            }
            if (TextInputLayout.this.placeholderEnabled) {
                TextInputLayout.this.updatePlaceholderText(editable.length());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            TextInputLayout.this.endIconView.performClick();
            TextInputLayout.this.endIconView.jumpDrawablesToCurrentState();
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            TextInputLayout.this.editText.requestLayout();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void addPlaceholderTextView() {
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            this.inputFrame.addView(textView);
            this.placeholderTextView.setVisibility(0);
        }
    }

    private void adjustFilledEditTextPaddingForLargeFont() {
        if (this.editText != null && this.boxBackgroundMode == 1) {
            if (MaterialResources.isFontScaleAtLeast2_0(getContext())) {
                EditText editText2 = this.editText;
                ViewCompat.setPaddingRelative(editText2, ViewCompat.getPaddingStart(editText2), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
                EditText editText3 = this.editText;
                ViewCompat.setPaddingRelative(editText3, ViewCompat.getPaddingStart(editText3), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
    }

    private void applyBoxAttributes() {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable != null) {
            ShapeAppearanceModel shapeAppearanceModel2 = materialShapeDrawable.getShapeAppearanceModel();
            ShapeAppearanceModel shapeAppearanceModel3 = this.shapeAppearanceModel;
            if (shapeAppearanceModel2 != shapeAppearanceModel3) {
                this.boxBackground.setShapeAppearanceModel(shapeAppearanceModel3);
                updateDropdownMenuBackground();
            }
            if (canDrawOutlineStroke()) {
                this.boxBackground.setStroke((float) this.boxStrokeWidthPx, this.boxStrokeColor);
            }
            int calculateBoxBackgroundColor = calculateBoxBackgroundColor();
            this.boxBackgroundColor = calculateBoxBackgroundColor;
            this.boxBackground.setFillColor(ColorStateList.valueOf(calculateBoxBackgroundColor));
            if (this.endIconMode == 3) {
                this.editText.getBackground().invalidateSelf();
            }
            applyBoxUnderlineAttributes();
            invalidate();
        }
    }

    private void applyBoxUnderlineAttributes() {
        ColorStateList colorStateList;
        if (this.boxUnderlineDefault != null && this.boxUnderlineFocused != null) {
            if (canDrawStroke()) {
                MaterialShapeDrawable materialShapeDrawable = this.boxUnderlineDefault;
                if (this.editText.isFocused()) {
                    colorStateList = ColorStateList.valueOf(this.defaultStrokeColor);
                } else {
                    colorStateList = ColorStateList.valueOf(this.boxStrokeColor);
                }
                materialShapeDrawable.setFillColor(colorStateList);
                this.boxUnderlineFocused.setFillColor(ColorStateList.valueOf(this.boxStrokeColor));
            }
            invalidate();
        }
    }

    private void applyCutoutPadding(@NonNull RectF rectF) {
        float f10 = rectF.left;
        int i10 = this.boxLabelCutoutPaddingPx;
        rectF.left = f10 - ((float) i10);
        rectF.right += (float) i10;
    }

    private void assignBoxBackgroundByMode() {
        int i10 = this.boxBackgroundMode;
        if (i10 == 0) {
            this.boxBackground = null;
            this.boxUnderlineDefault = null;
            this.boxUnderlineFocused = null;
        } else if (i10 == 1) {
            this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.boxUnderlineDefault = new MaterialShapeDrawable();
            this.boxUnderlineFocused = new MaterialShapeDrawable();
        } else if (i10 == 2) {
            if (!this.hintEnabled || (this.boxBackground instanceof d)) {
                this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            } else {
                this.boxBackground = new d(this.shapeAppearanceModel);
            }
            this.boxUnderlineDefault = null;
            this.boxUnderlineFocused = null;
        } else {
            throw new IllegalArgumentException(this.boxBackgroundMode + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
    }

    private int calculateBoxBackgroundColor() {
        int i10 = this.boxBackgroundColor;
        if (this.boxBackgroundMode == 1) {
            return MaterialColors.layer(MaterialColors.getColor((View) this, R.attr.colorSurface, 0), this.boxBackgroundColor);
        }
        return i10;
    }

    @NonNull
    private Rect calculateCollapsedTextBounds(@NonNull Rect rect) {
        if (this.editText != null) {
            Rect rect2 = this.tmpBoundsRect;
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            rect2.bottom = rect.bottom;
            int i10 = this.boxBackgroundMode;
            if (i10 == 1) {
                rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, isLayoutRtl);
                rect2.top = rect.top + this.boxCollapsedPaddingTopPx;
                rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, isLayoutRtl);
                return rect2;
            } else if (i10 != 2) {
                rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, isLayoutRtl);
                rect2.top = getPaddingTop();
                rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, isLayoutRtl);
                return rect2;
            } else {
                rect2.left = rect.left + this.editText.getPaddingLeft();
                rect2.top = rect.top - calculateLabelMarginTop();
                rect2.right = rect.right - this.editText.getPaddingRight();
                return rect2;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    private int calculateExpandedLabelBottom(@NonNull Rect rect, @NonNull Rect rect2, float f10) {
        if (isSingleLineFilledTextField()) {
            return (int) (((float) rect2.top) + f10);
        }
        return rect.bottom - this.editText.getCompoundPaddingBottom();
    }

    private int calculateExpandedLabelTop(@NonNull Rect rect, float f10) {
        if (isSingleLineFilledTextField()) {
            return (int) (((float) rect.centerY()) - (f10 / 2.0f));
        }
        return rect.top + this.editText.getCompoundPaddingTop();
    }

    @NonNull
    private Rect calculateExpandedTextBounds(@NonNull Rect rect) {
        if (this.editText != null) {
            Rect rect2 = this.tmpBoundsRect;
            float expandedTextHeight = this.collapsingTextHelper.getExpandedTextHeight();
            rect2.left = rect.left + this.editText.getCompoundPaddingLeft();
            rect2.top = calculateExpandedLabelTop(rect, expandedTextHeight);
            rect2.right = rect.right - this.editText.getCompoundPaddingRight();
            rect2.bottom = calculateExpandedLabelBottom(rect, rect2, expandedTextHeight);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private int calculateLabelMarginTop() {
        float collapsedTextHeight;
        if (!this.hintEnabled) {
            return 0;
        }
        int i10 = this.boxBackgroundMode;
        if (i10 == 0) {
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight();
        } else if (i10 != 2) {
            return 0;
        } else {
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        }
        return (int) collapsedTextHeight;
    }

    private boolean canDrawOutlineStroke() {
        if (this.boxBackgroundMode != 2 || !canDrawStroke()) {
            return false;
        }
        return true;
    }

    private boolean canDrawStroke() {
        if (this.boxStrokeWidthPx <= -1 || this.boxStrokeColor == 0) {
            return false;
        }
        return true;
    }

    private void closeCutout() {
        if (cutoutEnabled()) {
            ((d) this.boxBackground).b();
        }
    }

    private void collapseHint(boolean z10) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (!z10 || !this.hintAnimationEnabled) {
            this.collapsingTextHelper.setExpansionFraction(1.0f);
        } else {
            animateToExpansionFraction(1.0f);
        }
        this.hintExpanded = false;
        if (cutoutEnabled()) {
            openCutout();
        }
        updatePlaceholderText();
        this.startLayout.j(false);
        updateSuffixTextVisibility();
    }

    private Fade createPlaceholderFadeTransition() {
        Fade fade = new Fade();
        fade.setDuration(PLACEHOLDER_FADE_DURATION);
        fade.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return fade;
    }

    private boolean cutoutEnabled() {
        if (!this.hintEnabled || TextUtils.isEmpty(this.hint) || !(this.boxBackground instanceof d)) {
            return false;
        }
        return true;
    }

    private void dispatchOnEditTextAttached() {
        Iterator<OnEditTextAttachedListener> it = this.editTextAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEditTextAttached(this);
        }
    }

    private void dispatchOnEndIconChanged(int i10) {
        Iterator<OnEndIconChangedListener> it = this.endIconChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEndIconChanged(this, i10);
        }
    }

    private void drawBoxUnderline(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable;
        if (this.boxUnderlineFocused != null && (materialShapeDrawable = this.boxUnderlineDefault) != null) {
            materialShapeDrawable.draw(canvas);
            if (this.editText.isFocused()) {
                Rect bounds = this.boxUnderlineFocused.getBounds();
                Rect bounds2 = this.boxUnderlineDefault.getBounds();
                float expansionFraction = this.collapsingTextHelper.getExpansionFraction();
                int centerX = bounds2.centerX();
                bounds.left = AnimationUtils.lerp(centerX, bounds2.left, expansionFraction);
                bounds.right = AnimationUtils.lerp(centerX, bounds2.right, expansionFraction);
                this.boxUnderlineFocused.draw(canvas);
            }
        }
    }

    private void drawHint(@NonNull Canvas canvas) {
        if (this.hintEnabled) {
            this.collapsingTextHelper.draw(canvas);
        }
    }

    private void expandHint(boolean z10) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (!z10 || !this.hintAnimationEnabled) {
            this.collapsingTextHelper.setExpansionFraction(0.0f);
        } else {
            animateToExpansionFraction(0.0f);
        }
        if (cutoutEnabled() && ((d) this.boxBackground).a()) {
            closeCutout();
        }
        this.hintExpanded = true;
        hidePlaceholderText();
        this.startLayout.j(true);
        updateSuffixTextVisibility();
    }

    private f getEndIconDelegate() {
        f fVar = this.endIconDelegates.get(this.endIconMode);
        if (fVar != null) {
            return fVar;
        }
        return this.endIconDelegates.get(0);
    }

    @Nullable
    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.errorIconView.getVisibility() == 0) {
            return this.errorIconView;
        }
        if (!hasEndIcon() || !isEndIconVisible()) {
            return null;
        }
        return this.endIconView;
    }

    private int getLabelLeftBoundAlightWithPrefix(int i10, boolean z10) {
        int compoundPaddingLeft = i10 + this.editText.getCompoundPaddingLeft();
        if (getPrefixText() == null || z10) {
            return compoundPaddingLeft;
        }
        return (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
    }

    private int getLabelRightBoundAlignedWithSuffix(int i10, boolean z10) {
        int compoundPaddingRight = i10 - this.editText.getCompoundPaddingRight();
        if (getPrefixText() == null || !z10) {
            return compoundPaddingRight;
        }
        return compoundPaddingRight + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
    }

    private boolean hasEndIcon() {
        if (this.endIconMode != 0) {
            return true;
        }
        return false;
    }

    private void hidePlaceholderText() {
        TextView textView = this.placeholderTextView;
        if (textView != null && this.placeholderEnabled) {
            textView.setText((CharSequence) null);
            TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeOut);
            this.placeholderTextView.setVisibility(4);
        }
    }

    private boolean isErrorIconVisible() {
        if (this.errorIconView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    private boolean isSingleLineFilledTextField() {
        if (this.boxBackgroundMode != 1 || this.editText.getMinLines() > 1) {
            return false;
        }
        return true;
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        setEditTextBoxBackground();
        updateTextInputBoxState();
        updateBoxCollapsedPaddingTop();
        adjustFilledEditTextPaddingForLargeFont();
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
    }

    private void openCutout() {
        if (cutoutEnabled()) {
            RectF rectF = this.tmpRectF;
            this.collapsingTextHelper.getCollapsedTextActualBounds(rectF, this.editText.getWidth(), this.editText.getGravity());
            applyCutoutPadding(rectF);
            rectF.offset((float) (-getPaddingLeft()), (((float) (-getPaddingTop())) - (rectF.height() / 2.0f)) + ((float) this.boxStrokeWidthPx));
            ((d) this.boxBackground).d(rectF);
        }
    }

    private void recalculateCutout() {
        if (cutoutEnabled() && !this.hintExpanded) {
            closeCutout();
            openCutout();
        }
    }

    private static void recursiveSetEnabled(@NonNull ViewGroup viewGroup, boolean z10) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            childAt.setEnabled(z10);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z10);
            }
        }
    }

    private void removePlaceholderTextView() {
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void setEditText(EditText editText2) {
        if (this.editText == null) {
            if (this.endIconMode != 3 && !(editText2 instanceof TextInputEditText)) {
                Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.editText = editText2;
            int i10 = this.minEms;
            if (i10 != -1) {
                setMinEms(i10);
            } else {
                setMinWidth(this.minWidth);
            }
            int i11 = this.maxEms;
            if (i11 != -1) {
                setMaxEms(i11);
            } else {
                setMaxWidth(this.maxWidth);
            }
            onApplyBoxBackgroundMode();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
            this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
            this.collapsingTextHelper.setExpandedLetterSpacing(this.editText.getLetterSpacing());
            int gravity = this.editText.getGravity();
            this.collapsingTextHelper.setCollapsedTextGravity((gravity & -113) | 48);
            this.collapsingTextHelper.setExpandedTextGravity(gravity);
            this.editText.addTextChangedListener(new a());
            if (this.defaultHintTextColor == null) {
                this.defaultHintTextColor = this.editText.getHintTextColors();
            }
            if (this.hintEnabled) {
                if (TextUtils.isEmpty(this.hint)) {
                    CharSequence hint2 = this.editText.getHint();
                    this.originalHint = hint2;
                    setHint(hint2);
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.counterView != null) {
                updateCounter(this.editText.getText().length());
            }
            updateEditTextBackground();
            this.indicatorViewController.f();
            this.startLayout.bringToFront();
            this.endLayout.bringToFront();
            this.endIconFrame.bringToFront();
            this.errorIconView.bringToFront();
            dispatchOnEditTextAttached();
            updateSuffixTextViewPadding();
            if (!isEnabled()) {
                editText2.setEnabled(false);
            }
            updateLabelState(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setEditTextBoxBackground() {
        if (shouldUseEditTextBackgroundForBoxBackground()) {
            ViewCompat.setBackground(this.editText, this.boxBackground);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.hint)) {
            this.hint = charSequence;
            this.collapsingTextHelper.setText(charSequence);
            if (!this.hintExpanded) {
                openCutout();
            }
        }
    }

    private static void setIconClickable(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        boolean z10;
        boolean hasOnClickListeners = ViewCompat.hasOnClickListeners(checkableImageButton);
        boolean z11 = false;
        int i10 = 1;
        if (onLongClickListener != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (hasOnClickListeners || z10) {
            z11 = true;
        }
        checkableImageButton.setFocusable(z11);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z10);
        if (!z11) {
            i10 = 2;
        }
        ViewCompat.setImportantForAccessibility(checkableImageButton, i10);
    }

    private static void setIconOnClickListener(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnClickListener onClickListener, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private static void setIconOnLongClickListener(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private void setPlaceholderTextEnabled(boolean z10) {
        if (this.placeholderEnabled != z10) {
            if (z10) {
                addPlaceholderTextView();
            } else {
                removePlaceholderTextView();
                this.placeholderTextView = null;
            }
            this.placeholderEnabled = z10;
        }
    }

    private boolean shouldUpdateEndDummyDrawable() {
        if ((this.errorIconView.getVisibility() == 0 || ((hasEndIcon() && isEndIconVisible()) || this.suffixText != null)) && this.endLayout.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    private boolean shouldUpdateStartDummyDrawable() {
        if ((getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.startLayout.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    private boolean shouldUseEditTextBackgroundForBoxBackground() {
        EditText editText2 = this.editText;
        if (editText2 == null || this.boxBackground == null || editText2.getBackground() != null || this.boxBackgroundMode == 0) {
            return false;
        }
        return true;
    }

    private void showPlaceholderText() {
        if (this.placeholderTextView != null && this.placeholderEnabled && !TextUtils.isEmpty(this.placeholderText)) {
            this.placeholderTextView.setText(this.placeholderText);
            TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeIn);
            this.placeholderTextView.setVisibility(0);
            this.placeholderTextView.bringToFront();
            announceForAccessibility(this.placeholderText);
        }
    }

    private void tintEndIconOnError(boolean z10) {
        if (!z10 || getEndIconDrawable() == null) {
            g.a(this, this.endIconView, this.endIconTintList, this.endIconTintMode);
            return;
        }
        Drawable mutate = DrawableCompat.wrap(getEndIconDrawable()).mutate();
        DrawableCompat.setTint(mutate, this.indicatorViewController.p());
        this.endIconView.setImageDrawable(mutate);
    }

    private void updateBoxCollapsedPaddingTop() {
        if (this.boxBackgroundMode != 1) {
            return;
        }
        if (MaterialResources.isFontScaleAtLeast2_0(getContext())) {
            this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
        } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
            this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
        }
    }

    private void updateBoxUnderlineBounds(@NonNull Rect rect) {
        MaterialShapeDrawable materialShapeDrawable = this.boxUnderlineDefault;
        if (materialShapeDrawable != null) {
            int i10 = rect.bottom;
            materialShapeDrawable.setBounds(rect.left, i10 - this.boxStrokeWidthDefaultPx, rect.right, i10);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.boxUnderlineFocused;
        if (materialShapeDrawable2 != null) {
            int i11 = rect.bottom;
            materialShapeDrawable2.setBounds(rect.left, i11 - this.boxStrokeWidthFocusedPx, rect.right, i11);
        }
    }

    private void updateCounter() {
        if (this.counterView != null) {
            EditText editText2 = this.editText;
            updateCounter(editText2 == null ? 0 : editText2.getText().length());
        }
    }

    private static void updateCounterContentDescription(@NonNull Context context, @NonNull TextView textView, int i10, int i11, boolean z10) {
        int i12;
        if (z10) {
            i12 = R.string.character_counter_overflowed_content_description;
        } else {
            i12 = R.string.character_counter_content_description;
        }
        textView.setContentDescription(context.getString(i12, new Object[]{Integer.valueOf(i10), Integer.valueOf(i11)}));
    }

    private void updateCounterTextAppearanceAndColor() {
        int i10;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.counterView;
        if (textView != null) {
            if (this.counterOverflowed) {
                i10 = this.counterOverflowTextAppearance;
            } else {
                i10 = this.counterTextAppearance;
            }
            setTextAppearanceCompatWithErrorFallback(textView, i10);
            if (!this.counterOverflowed && (colorStateList2 = this.counterTextColor) != null) {
                this.counterView.setTextColor(colorStateList2);
            }
            if (this.counterOverflowed && (colorStateList = this.counterOverflowTextColor) != null) {
                this.counterView.setTextColor(colorStateList);
            }
        }
    }

    private void updateDropdownMenuBackground() {
        if (this.endIconMode == 3 && this.boxBackgroundMode == 2) {
            ((e) this.endIconDelegates.get(3)).O((AutoCompleteTextView) this.editText);
        }
    }

    private boolean updateEditTextHeightBasedOnIcon() {
        int max;
        if (this.editText == null || this.editText.getMeasuredHeight() >= (max = Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight()))) {
            return false;
        }
        this.editText.setMinimumHeight(max);
        return true;
    }

    private void updateEndLayoutVisibility() {
        int i10;
        boolean z10;
        boolean z11;
        FrameLayout frameLayout = this.endIconFrame;
        int i11 = 8;
        if (this.endIconView.getVisibility() != 0 || isErrorIconVisible()) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        frameLayout.setVisibility(i10);
        if (this.suffixText == null || isHintExpanded()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (isEndIconVisible() || isErrorIconVisible() || !z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        LinearLayout linearLayout = this.endLayout;
        if (z11) {
            i11 = 0;
        }
        linearLayout.setVisibility(i11);
    }

    private void updateErrorIconVisibility() {
        boolean z10;
        int i10 = 0;
        if (getErrorIconDrawable() == null || !this.indicatorViewController.B() || !this.indicatorViewController.l()) {
            z10 = false;
        } else {
            z10 = true;
        }
        CheckableImageButton checkableImageButton = this.errorIconView;
        if (!z10) {
            i10 = 8;
        }
        checkableImageButton.setVisibility(i10);
        updateEndLayoutVisibility();
        updateSuffixTextViewPadding();
        if (!hasEndIcon()) {
            updateDummyDrawables();
        }
    }

    private void updateInputLayoutMargins() {
        if (this.boxBackgroundMode != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
            int calculateLabelMarginTop = calculateLabelMarginTop();
            if (calculateLabelMarginTop != layoutParams.topMargin) {
                layoutParams.topMargin = calculateLabelMarginTop;
                this.inputFrame.requestLayout();
            }
        }
    }

    private void updatePlaceholderMeasurementsBasedOnEditText() {
        EditText editText2;
        if (this.placeholderTextView != null && (editText2 = this.editText) != null) {
            this.placeholderTextView.setGravity(editText2.getGravity());
            this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
        }
    }

    private void updatePlaceholderText() {
        EditText editText2 = this.editText;
        updatePlaceholderText(editText2 == null ? 0 : editText2.getText().length());
    }

    private void updateStrokeErrorColor(boolean z10, boolean z11) {
        int defaultColor = this.strokeErrorColor.getDefaultColor();
        int colorForState = this.strokeErrorColor.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.strokeErrorColor.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z10) {
            this.boxStrokeColor = colorForState2;
        } else if (z11) {
            this.boxStrokeColor = colorForState;
        } else {
            this.boxStrokeColor = defaultColor;
        }
    }

    private void updateSuffixTextViewPadding() {
        int i10;
        if (this.editText != null) {
            if (isEndIconVisible() || isErrorIconVisible()) {
                i10 = 0;
            } else {
                i10 = ViewCompat.getPaddingEnd(this.editText);
            }
            ViewCompat.setPaddingRelative(this.suffixTextView, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.editText.getPaddingTop(), i10, this.editText.getPaddingBottom());
        }
    }

    private void updateSuffixTextVisibility() {
        int i10;
        int visibility = this.suffixTextView.getVisibility();
        boolean z10 = false;
        if (this.suffixText == null || isHintExpanded()) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        if (visibility != i10) {
            f endIconDelegate = getEndIconDelegate();
            if (i10 == 0) {
                z10 = true;
            }
            endIconDelegate.c(z10);
        }
        updateEndLayoutVisibility();
        this.suffixTextView.setVisibility(i10);
        updateDummyDrawables();
    }

    public void addOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.add(onEditTextAttachedListener);
        if (this.editText != null) {
            onEditTextAttachedListener.onEditTextAttached(this);
        }
    }

    public void addOnEndIconChangedListener(@NonNull OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.add(onEndIconChangedListener);
    }

    public void addView(@NonNull View view, int i10, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.inputFrame.addView(view, layoutParams2);
            this.inputFrame.setLayoutParams(layoutParams);
            updateInputLayoutMargins();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i10, layoutParams);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void animateToExpansionFraction(float f10) {
        if (this.collapsingTextHelper.getExpansionFraction() != f10) {
            if (this.animator == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.animator = valueAnimator;
                valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                this.animator.setDuration(167);
                this.animator.addUpdateListener(new d());
            }
            this.animator.setFloatValues(new float[]{this.collapsingTextHelper.getExpansionFraction(), f10});
            this.animator.start();
        }
    }

    public void clearOnEditTextAttachedListeners() {
        this.editTextAttachedListeners.clear();
    }

    public void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean cutoutIsOpen() {
        if (!cutoutEnabled() || !((d) this.boxBackground).a()) {
            return false;
        }
        return true;
    }

    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i10) {
        EditText editText2 = this.editText;
        if (editText2 == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i10);
            return;
        }
        if (this.originalHint != null) {
            boolean z10 = this.isProvidingHint;
            this.isProvidingHint = false;
            CharSequence hint2 = editText2.getHint();
            this.editText.setHint(this.originalHint);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i10);
            } finally {
                this.editText.setHint(hint2);
                this.isProvidingHint = z10;
            }
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i10);
            onProvideAutofillVirtualStructure(viewStructure, i10);
            viewStructure.setChildCount(this.inputFrame.getChildCount());
            for (int i11 = 0; i11 < this.inputFrame.getChildCount(); i11++) {
                View childAt = this.inputFrame.getChildAt(i11);
                ViewStructure newChild = viewStructure.newChild(i11);
                childAt.dispatchProvideAutofillStructure(newChild, i10);
                if (childAt == this.editText) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        drawHint(canvas);
        drawBoxUnderline(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        boolean z10;
        if (!this.inDrawableStateChanged) {
            boolean z11 = true;
            this.inDrawableStateChanged = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
            if (collapsingTextHelper2 != null) {
                z10 = collapsingTextHelper2.setState(drawableState);
            } else {
                z10 = false;
            }
            if (this.editText != null) {
                if (!ViewCompat.isLaidOut(this) || !isEnabled()) {
                    z11 = false;
                }
                updateLabelState(z11);
            }
            updateEditTextBackground();
            updateTextInputBoxState();
            if (z10) {
                invalidate();
            }
            this.inDrawableStateChanged = false;
        }
    }

    public int getBaseline() {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            return editText2.getBaseline() + getPaddingTop() + calculateLabelMarginTop();
        }
        return super.getBaseline();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public MaterialShapeDrawable getBoxBackground() {
        int i10 = this.boxBackgroundMode;
        if (i10 == 1 || i10 == 2) {
            return this.boxBackground;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.boxCollapsedPaddingTopPx;
    }

    public float getBoxCornerRadiusBottomEnd() {
        if (ViewUtils.isLayoutRtl(this)) {
            return this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
        }
        return this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        if (ViewUtils.isLayoutRtl(this)) {
            return this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
        }
        return this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        if (ViewUtils.isLayoutRtl(this)) {
            return this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
        }
        return this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.tmpRectF);
    }

    public float getBoxCornerRadiusTopStart() {
        if (ViewUtils.isLayoutRtl(this)) {
            return this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.tmpRectF);
        }
        return this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.counterEnabled || !this.counterOverflowed || (textView = this.counterView) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    @Nullable
    public EditText getEditText() {
        return this.editText;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    @Nullable
    public CharSequence getError() {
        if (this.indicatorViewController.B()) {
            return this.indicatorViewController.o();
        }
        return null;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.indicatorViewController.n();
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.p();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int getErrorTextCurrentColor() {
        return this.indicatorViewController.p();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.indicatorViewController.C()) {
            return this.indicatorViewController.r();
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.t();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    public int getMaxEms() {
        return this.maxEms;
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getMinEms() {
        return this.minEms;
    }

    @Px
    public int getMinWidth() {
        return this.minWidth;
    }

    @Deprecated
    @Nullable
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Deprecated
    @Nullable
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.placeholderEnabled) {
            return this.placeholderText;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.startLayout.a();
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.startLayout.b();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.startLayout.c();
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.startLayout.d();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.startLayout.e();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.suffixText;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.typeface;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public boolean isEndIconCheckable() {
        return this.endIconView.isCheckable();
    }

    public boolean isEndIconVisible() {
        if (this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.B();
    }

    public boolean isExpandedHintEnabled() {
        return this.expandedHintEnabled;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.v();
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.C();
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    /* access modifiers changed from: package-private */
    public final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        if (this.endIconMode == 1) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public boolean isStartIconCheckable() {
        return this.startLayout.h();
    }

    public boolean isStartIconVisible() {
        return this.startLayout.i();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.collapsingTextHelper.maybeUpdateFontWeightAdjustment(configuration);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        EditText editText2 = this.editText;
        if (editText2 != null) {
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(this, editText2, rect);
            updateBoxUnderlineBounds(rect);
            if (this.hintEnabled) {
                this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
                int gravity = this.editText.getGravity();
                this.collapsingTextHelper.setCollapsedTextGravity((gravity & -113) | 48);
                this.collapsingTextHelper.setExpandedTextGravity(gravity);
                this.collapsingTextHelper.setCollapsedBounds(calculateCollapsedTextBounds(rect));
                this.collapsingTextHelper.setExpandedBounds(calculateExpandedTextBounds(rect));
                this.collapsingTextHelper.recalculate();
                if (cutoutEnabled() && !this.hintExpanded) {
                    openCutout();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        boolean updateEditTextHeightBasedOnIcon = updateEditTextHeightBasedOnIcon();
        boolean updateDummyDrawables = updateDummyDrawables();
        if (updateEditTextHeightBasedOnIcon || updateDummyDrawables) {
            this.editText.post(new c());
        }
        updatePlaceholderMeasurementsBasedOnEditText();
        updateSuffixTextViewPadding();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.f8557a);
        if (savedState.f8558b) {
            this.endIconView.post(new b());
        }
        setHint(savedState.f8559c);
        setHelperText(savedState.f8560d);
        setPlaceholderText(savedState.f8561e);
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i10) {
        boolean z10;
        float f10;
        float f11;
        super.onRtlPropertiesChanged(i10);
        boolean z11 = false;
        if (i10 == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z12 = this.areCornerRadiiRtl;
        if (z10 != z12) {
            if (z10 && !z12) {
                z11 = true;
            }
            float cornerSize = this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
            float cornerSize2 = this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.tmpRectF);
            float cornerSize3 = this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.tmpRectF);
            float cornerSize4 = this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.tmpRectF);
            if (z11) {
                f10 = cornerSize;
            } else {
                f10 = cornerSize2;
            }
            if (z11) {
                cornerSize = cornerSize2;
            }
            if (z11) {
                f11 = cornerSize3;
            } else {
                f11 = cornerSize4;
            }
            if (z11) {
                cornerSize3 = cornerSize4;
            }
            setBoxCornerRadii(f10, cornerSize, f11, cornerSize3);
        }
    }

    @Nullable
    public Parcelable onSaveInstanceState() {
        boolean z10;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.l()) {
            savedState.f8557a = getError();
        }
        if (!hasEndIcon() || !this.endIconView.isChecked()) {
            z10 = false;
        } else {
            z10 = true;
        }
        savedState.f8558b = z10;
        savedState.f8559c = getHint();
        savedState.f8560d = getHelperText();
        savedState.f8561e = getPlaceholderText();
        return savedState;
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean z10) {
        if (this.endIconMode == 1) {
            this.endIconView.performClick();
            if (z10) {
                this.endIconView.jumpDrawablesToCurrentState();
            }
        }
    }

    public void refreshEndIconDrawableState() {
        g.c(this, this.endIconView, this.endIconTintList);
    }

    public void refreshErrorIconDrawableState() {
        g.c(this, this.errorIconView, this.errorIconTintList);
    }

    public void refreshStartIconDrawableState() {
        this.startLayout.k();
    }

    public void removeOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.remove(onEditTextAttachedListener);
    }

    public void removeOnEndIconChangedListener(@NonNull OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.remove(onEndIconChangedListener);
    }

    public void setBoxBackgroundColor(@ColorInt int i10) {
        if (this.boxBackgroundColor != i10) {
            this.boxBackgroundColor = i10;
            this.defaultFilledBackgroundColor = i10;
            this.focusedFilledBackgroundColor = i10;
            this.hoveredFilledBackgroundColor = i10;
            applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i10) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i10));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.defaultFilledBackgroundColor = defaultColor;
        this.boxBackgroundColor = defaultColor;
        this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        applyBoxAttributes();
    }

    public void setBoxBackgroundMode(int i10) {
        if (i10 != this.boxBackgroundMode) {
            this.boxBackgroundMode = i10;
            if (this.editText != null) {
                onApplyBoxBackgroundMode();
            }
        }
    }

    public void setBoxCollapsedPaddingTop(int i10) {
        this.boxCollapsedPaddingTopPx = i10;
    }

    public void setBoxCornerRadii(float f10, float f11, float f12, float f13) {
        float f14;
        float f15;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        this.areCornerRadiiRtl = isLayoutRtl;
        if (isLayoutRtl) {
            f14 = f11;
        } else {
            f14 = f10;
        }
        if (!isLayoutRtl) {
            f10 = f11;
        }
        if (isLayoutRtl) {
            f15 = f13;
        } else {
            f15 = f12;
        }
        if (!isLayoutRtl) {
            f12 = f13;
        }
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable == null || materialShapeDrawable.getTopLeftCornerResolvedSize() != f14 || this.boxBackground.getTopRightCornerResolvedSize() != f10 || this.boxBackground.getBottomLeftCornerResolvedSize() != f15 || this.boxBackground.getBottomRightCornerResolvedSize() != f12) {
            this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCornerSize(f14).setTopRightCornerSize(f10).setBottomLeftCornerSize(f15).setBottomRightCornerSize(f12).build();
            applyBoxAttributes();
        }
    }

    public void setBoxCornerRadiiResources(@DimenRes int i10, @DimenRes int i11, @DimenRes int i12, @DimenRes int i13) {
        setBoxCornerRadii(getContext().getResources().getDimension(i10), getContext().getResources().getDimension(i11), getContext().getResources().getDimension(i13), getContext().getResources().getDimension(i12));
    }

    public void setBoxStrokeColor(@ColorInt int i10) {
        if (this.focusedStrokeColor != i10) {
            this.focusedStrokeColor = i10;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.defaultStrokeColor = colorStateList.getDefaultColor();
            this.disabledColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.hoveredStrokeColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.focusedStrokeColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.focusedStrokeColor != colorStateList.getDefaultColor()) {
            this.focusedStrokeColor = colorStateList.getDefaultColor();
        }
        updateTextInputBoxState();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.strokeErrorColor != colorStateList) {
            this.strokeErrorColor = colorStateList;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeWidth(int i10) {
        this.boxStrokeWidthDefaultPx = i10;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocused(int i10) {
        this.boxStrokeWidthFocusedPx = i10;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i10) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i10));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i10) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    public void setCounterEnabled(boolean z10) {
        if (this.counterEnabled != z10) {
            if (z10) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.counterView = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface2 = this.typeface;
                if (typeface2 != null) {
                    this.counterView.setTypeface(typeface2);
                }
                this.counterView.setMaxLines(1);
                this.indicatorViewController.e(this.counterView, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.counterView.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                updateCounterTextAppearanceAndColor();
                updateCounter();
            } else {
                this.indicatorViewController.D(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z10;
        }
    }

    public void setCounterMaxLength(int i10) {
        if (this.counterMaxLength != i10) {
            if (i10 > 0) {
                this.counterMaxLength = i10;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled) {
                updateCounter();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i10) {
        if (this.counterOverflowTextAppearance != i10) {
            this.counterOverflowTextAppearance = i10;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.counterOverflowTextColor != colorStateList) {
            this.counterOverflowTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextAppearance(int i10) {
        if (this.counterTextAppearance != i10) {
            this.counterTextAppearance = i10;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.counterTextColor != colorStateList) {
            this.counterTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false);
        }
    }

    public void setEnabled(boolean z10) {
        recursiveSetEnabled(this, z10);
        super.setEnabled(z10);
    }

    public void setEndIconActivated(boolean z10) {
        this.endIconView.setActivated(z10);
    }

    public void setEndIconCheckable(boolean z10) {
        this.endIconView.setCheckable(z10);
    }

    public void setEndIconContentDescription(@StringRes int i10) {
        setEndIconContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setEndIconDrawable(@DrawableRes int i10) {
        setEndIconDrawable(i10 != 0 ? AppCompatResources.getDrawable(getContext(), i10) : null);
    }

    public void setEndIconMode(int i10) {
        boolean z10;
        int i11 = this.endIconMode;
        if (i11 != i10) {
            this.endIconMode = i10;
            dispatchOnEndIconChanged(i11);
            if (i10 != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            setEndIconVisible(z10);
            if (getEndIconDelegate().b(this.boxBackgroundMode)) {
                getEndIconDelegate().a();
                g.a(this, this.endIconView, this.endIconTintList, this.endIconTintMode);
                return;
            }
            throw new IllegalStateException("The current box background mode " + this.boxBackgroundMode + " is not supported by the end icon mode " + i10);
        }
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        setIconOnClickListener(this.endIconView, onClickListener, this.endIconOnLongClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.endIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.endIconView, onLongClickListener);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.endIconTintList != colorStateList) {
            this.endIconTintList = colorStateList;
            g.a(this, this.endIconView, colorStateList, this.endIconTintMode);
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.endIconTintMode != mode) {
            this.endIconTintMode = mode;
            g.a(this, this.endIconView, this.endIconTintList, mode);
        }
    }

    public void setEndIconVisible(boolean z10) {
        int i10;
        if (isEndIconVisible() != z10) {
            CheckableImageButton checkableImageButton = this.endIconView;
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            checkableImageButton.setVisibility(i10);
            updateEndLayoutVisibility();
            updateSuffixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.indicatorViewController.B()) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.indicatorViewController.Q(charSequence);
        } else {
            this.indicatorViewController.w();
        }
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        this.indicatorViewController.F(charSequence);
    }

    public void setErrorEnabled(boolean z10) {
        this.indicatorViewController.G(z10);
    }

    public void setErrorIconDrawable(@DrawableRes int i10) {
        setErrorIconDrawable(i10 != 0 ? AppCompatResources.getDrawable(getContext(), i10) : null);
        refreshErrorIconDrawableState();
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        setIconOnClickListener(this.errorIconView, onClickListener, this.errorIconOnLongClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.errorIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.errorIconView, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.errorIconTintList != colorStateList) {
            this.errorIconTintList = colorStateList;
            g.a(this, this.errorIconView, colorStateList, this.errorIconTintMode);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.errorIconTintMode != mode) {
            this.errorIconTintMode = mode;
            g.a(this, this.errorIconView, this.errorIconTintList, mode);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i10) {
        this.indicatorViewController.H(i10);
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        this.indicatorViewController.I(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z10) {
        if (this.expandedHintEnabled != z10) {
            this.expandedHintEnabled = z10;
            updateLabelState(false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.indicatorViewController.R(charSequence);
        } else if (isHelperTextEnabled()) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        this.indicatorViewController.L(colorStateList);
    }

    public void setHelperTextEnabled(boolean z10) {
        this.indicatorViewController.K(z10);
    }

    public void setHelperTextTextAppearance(@StyleRes int i10) {
        this.indicatorViewController.J(i10);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.hintAnimationEnabled = z10;
    }

    public void setHintEnabled(boolean z10) {
        if (z10 != this.hintEnabled) {
            this.hintEnabled = z10;
            if (!z10) {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal((CharSequence) null);
            } else {
                CharSequence hint2 = this.editText.getHint();
                if (!TextUtils.isEmpty(hint2)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint2);
                    }
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i10) {
        this.collapsingTextHelper.setCollapsedTextAppearance(i10);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText != null) {
            updateLabelState(false);
            updateInputLayoutMargins();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.focusedTextColor != colorStateList) {
            if (this.defaultHintTextColor == null) {
                this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
            }
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false);
            }
        }
    }

    public void setMaxEms(int i10) {
        this.maxEms = i10;
        EditText editText2 = this.editText;
        if (editText2 != null && i10 != -1) {
            editText2.setMaxEms(i10);
        }
    }

    public void setMaxWidth(@Px int i10) {
        this.maxWidth = i10;
        EditText editText2 = this.editText;
        if (editText2 != null && i10 != -1) {
            editText2.setMaxWidth(i10);
        }
    }

    public void setMaxWidthResource(@DimenRes int i10) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    public void setMinEms(int i10) {
        this.minEms = i10;
        EditText editText2 = this.editText;
        if (editText2 != null && i10 != -1) {
            editText2.setMinEms(i10);
        }
    }

    public void setMinWidth(@Px int i10) {
        this.minWidth = i10;
        EditText editText2 = this.editText;
        if (editText2 != null && i10 != -1) {
            editText2.setMinWidth(i10);
        }
    }

    public void setMinWidthResource(@DimenRes int i10) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i10) {
        setPasswordVisibilityToggleContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i10) {
        setPasswordVisibilityToggleDrawable(i10 != 0 ? AppCompatResources.getDrawable(getContext(), i10) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z10) {
        if (z10 && this.endIconMode != 1) {
            setEndIconMode(1);
        } else if (!z10) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.endIconTintList = colorStateList;
        g.a(this, this.endIconView, colorStateList, this.endIconTintMode);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.endIconTintMode = mode;
        g.a(this, this.endIconView, this.endIconTintList, mode);
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.placeholderTextView == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.placeholderTextView = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_placeholder);
            ViewCompat.setImportantForAccessibility(this.placeholderTextView, 2);
            Fade createPlaceholderFadeTransition = createPlaceholderFadeTransition();
            this.placeholderFadeIn = createPlaceholderFadeTransition;
            createPlaceholderFadeTransition.setStartDelay(PLACEHOLDER_START_DELAY);
            this.placeholderFadeOut = createPlaceholderFadeTransition();
            setPlaceholderTextAppearance(this.placeholderTextAppearance);
            setPlaceholderTextColor(this.placeholderTextColor);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.placeholderEnabled) {
                setPlaceholderTextEnabled(true);
            }
            this.placeholderText = charSequence;
        }
        updatePlaceholderText();
    }

    public void setPlaceholderTextAppearance(@StyleRes int i10) {
        this.placeholderTextAppearance = i10;
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i10);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.placeholderTextColor != colorStateList) {
            this.placeholderTextColor = colorStateList;
            TextView textView = this.placeholderTextView;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        this.startLayout.l(charSequence);
    }

    public void setPrefixTextAppearance(@StyleRes int i10) {
        this.startLayout.m(i10);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.startLayout.n(colorStateList);
    }

    public void setStartIconCheckable(boolean z10) {
        this.startLayout.o(z10);
    }

    public void setStartIconContentDescription(@StringRes int i10) {
        setStartIconContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i10) {
        setStartIconDrawable(i10 != 0 ? AppCompatResources.getDrawable(getContext(), i10) : null);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.startLayout.r(onClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.startLayout.s(onLongClickListener);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        this.startLayout.t(colorStateList);
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.startLayout.u(mode);
    }

    public void setStartIconVisible(boolean z10) {
        this.startLayout.v(z10);
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.suffixText = charSequence2;
        this.suffixTextView.setText(charSequence);
        updateSuffixTextVisibility();
    }

    public void setSuffixTextAppearance(@StyleRes int i10) {
        TextViewCompat.setTextAppearance(this.suffixTextView, i10);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.suffixTextView.setTextColor(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public void setTextAppearanceCompatWithErrorFallback(@NonNull TextView textView, @StyleRes int i10) {
        try {
            TextViewCompat.setTextAppearance(textView, i10);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        TextViewCompat.setTextAppearance(textView, R.style.TextAppearance_AppCompat_Caption);
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.design_error));
    }

    public void setTextInputAccessibilityDelegate(@Nullable AccessibilityDelegate accessibilityDelegate) {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            ViewCompat.setAccessibilityDelegate(editText2, accessibilityDelegate);
        }
    }

    public void setTypeface(@Nullable Typeface typeface2) {
        if (typeface2 != this.typeface) {
            this.typeface = typeface2;
            this.collapsingTextHelper.setTypefaces(typeface2);
            this.indicatorViewController.N(typeface2);
            TextView textView = this.counterView;
            if (textView != null) {
                textView.setTypeface(typeface2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean updateDummyDrawables() {
        /*
            r10 = this;
            android.widget.EditText r0 = r10.editText
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r10.shouldUpdateStartDummyDrawable()
            r2 = 0
            r3 = 2
            r4 = 3
            r5 = 1
            if (r0 == 0) goto L_0x0049
            com.google.android.material.textfield.StartCompoundLayout r0 = r10.startLayout
            int r0 = r0.getMeasuredWidth()
            android.widget.EditText r6 = r10.editText
            int r6 = r6.getPaddingLeft()
            int r0 = r0 - r6
            android.graphics.drawable.Drawable r6 = r10.startDummyDrawable
            if (r6 == 0) goto L_0x0025
            int r6 = r10.startDummyDrawableWidth
            if (r6 == r0) goto L_0x0031
        L_0x0025:
            android.graphics.drawable.ColorDrawable r6 = new android.graphics.drawable.ColorDrawable
            r6.<init>()
            r10.startDummyDrawable = r6
            r10.startDummyDrawableWidth = r0
            r6.setBounds(r1, r1, r0, r5)
        L_0x0031:
            android.widget.EditText r0 = r10.editText
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(r0)
            r6 = r0[r1]
            android.graphics.drawable.Drawable r7 = r10.startDummyDrawable
            if (r6 == r7) goto L_0x0062
            android.widget.EditText r6 = r10.editText
            r8 = r0[r5]
            r9 = r0[r3]
            r0 = r0[r4]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r6, r7, r8, r9, r0)
            goto L_0x0060
        L_0x0049:
            android.graphics.drawable.Drawable r0 = r10.startDummyDrawable
            if (r0 == 0) goto L_0x0062
            android.widget.EditText r0 = r10.editText
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(r0)
            android.widget.EditText r6 = r10.editText
            r7 = r0[r5]
            r8 = r0[r3]
            r0 = r0[r4]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r6, r2, r7, r8, r0)
            r10.startDummyDrawable = r2
        L_0x0060:
            r0 = r5
            goto L_0x0063
        L_0x0062:
            r0 = r1
        L_0x0063:
            boolean r6 = r10.shouldUpdateEndDummyDrawable()
            if (r6 == 0) goto L_0x00d2
            android.widget.TextView r2 = r10.suffixTextView
            int r2 = r2.getMeasuredWidth()
            android.widget.EditText r6 = r10.editText
            int r6 = r6.getPaddingRight()
            int r2 = r2 - r6
            com.google.android.material.internal.CheckableImageButton r6 = r10.getEndIconToUpdateDummyDrawable()
            if (r6 == 0) goto L_0x008c
            int r7 = r6.getMeasuredWidth()
            int r2 = r2 + r7
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            int r6 = androidx.core.view.MarginLayoutParamsCompat.getMarginStart(r6)
            int r2 = r2 + r6
        L_0x008c:
            android.widget.EditText r6 = r10.editText
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(r6)
            android.graphics.drawable.Drawable r7 = r10.endDummyDrawable
            if (r7 == 0) goto L_0x00ad
            int r8 = r10.endDummyDrawableWidth
            if (r8 == r2) goto L_0x00ad
            r10.endDummyDrawableWidth = r2
            r7.setBounds(r1, r1, r2, r5)
            android.widget.EditText r0 = r10.editText
            r1 = r6[r1]
            r2 = r6[r5]
            android.graphics.drawable.Drawable r3 = r10.endDummyDrawable
            r4 = r6[r4]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r0, r1, r2, r3, r4)
            goto L_0x00d0
        L_0x00ad:
            if (r7 != 0) goto L_0x00bb
            android.graphics.drawable.ColorDrawable r7 = new android.graphics.drawable.ColorDrawable
            r7.<init>()
            r10.endDummyDrawable = r7
            r10.endDummyDrawableWidth = r2
            r7.setBounds(r1, r1, r2, r5)
        L_0x00bb:
            r2 = r6[r3]
            android.graphics.drawable.Drawable r3 = r10.endDummyDrawable
            if (r2 == r3) goto L_0x00cf
            r10.originalEditTextEndDrawable = r2
            android.widget.EditText r0 = r10.editText
            r1 = r6[r1]
            r2 = r6[r5]
            r4 = r6[r4]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r0, r1, r2, r3, r4)
            goto L_0x00d0
        L_0x00cf:
            r5 = r0
        L_0x00d0:
            r0 = r5
            goto L_0x00f4
        L_0x00d2:
            android.graphics.drawable.Drawable r6 = r10.endDummyDrawable
            if (r6 == 0) goto L_0x00f4
            android.widget.EditText r6 = r10.editText
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(r6)
            r3 = r6[r3]
            android.graphics.drawable.Drawable r7 = r10.endDummyDrawable
            if (r3 != r7) goto L_0x00f0
            android.widget.EditText r0 = r10.editText
            r1 = r6[r1]
            r3 = r6[r5]
            android.graphics.drawable.Drawable r7 = r10.originalEditTextEndDrawable
            r4 = r6[r4]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r0, r1, r3, r7, r4)
            goto L_0x00f1
        L_0x00f0:
            r5 = r0
        L_0x00f1:
            r10.endDummyDrawable = r2
            goto L_0x00d0
        L_0x00f4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.updateDummyDrawables():boolean");
    }

    /* access modifiers changed from: package-private */
    public void updateEditTextBackground() {
        Drawable background;
        TextView textView;
        EditText editText2 = this.editText;
        if (editText2 != null && this.boxBackgroundMode == 0 && (background = editText2.getBackground()) != null) {
            if (DrawableUtils.canSafelyMutateDrawable(background)) {
                background = background.mutate();
            }
            if (this.indicatorViewController.l()) {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.indicatorViewController.p(), PorterDuff.Mode.SRC_IN));
            } else if (!this.counterOverflowed || (textView = this.counterView) == null) {
                DrawableCompat.clearColorFilter(background);
                this.editText.refreshDrawableState();
            } else {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateLabelState(boolean z10) {
        updateLabelState(z10, false);
    }

    /* access modifiers changed from: package-private */
    public void updateTextInputBoxState() {
        boolean z10;
        TextView textView;
        EditText editText2;
        EditText editText3;
        if (this.boxBackground != null && this.boxBackgroundMode != 0) {
            boolean z11 = false;
            if (isFocused() || ((editText3 = this.editText) != null && editText3.hasFocus())) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (isHovered() || ((editText2 = this.editText) != null && editText2.isHovered())) {
                z11 = true;
            }
            if (!isEnabled()) {
                this.boxStrokeColor = this.disabledColor;
            } else if (this.indicatorViewController.l()) {
                if (this.strokeErrorColor != null) {
                    updateStrokeErrorColor(z10, z11);
                } else {
                    this.boxStrokeColor = this.indicatorViewController.p();
                }
            } else if (!this.counterOverflowed || (textView = this.counterView) == null) {
                if (z10) {
                    this.boxStrokeColor = this.focusedStrokeColor;
                } else if (z11) {
                    this.boxStrokeColor = this.hoveredStrokeColor;
                } else {
                    this.boxStrokeColor = this.defaultStrokeColor;
                }
            } else if (this.strokeErrorColor != null) {
                updateStrokeErrorColor(z10, z11);
            } else {
                this.boxStrokeColor = textView.getCurrentTextColor();
            }
            updateErrorIconVisibility();
            refreshErrorIconDrawableState();
            refreshStartIconDrawableState();
            refreshEndIconDrawableState();
            if (getEndIconDelegate().d()) {
                tintEndIconOnError(this.indicatorViewController.l());
            }
            if (this.boxBackgroundMode == 2) {
                int i10 = this.boxStrokeWidthPx;
                if (!z10 || !isEnabled()) {
                    this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
                } else {
                    this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
                }
                if (this.boxStrokeWidthPx != i10) {
                    recalculateCutout();
                }
            }
            if (this.boxBackgroundMode == 1) {
                if (!isEnabled()) {
                    this.boxBackgroundColor = this.disabledFilledBackgroundColor;
                } else if (z11 && !z10) {
                    this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
                } else if (z10) {
                    this.boxBackgroundColor = this.focusedFilledBackgroundColor;
                } else {
                    this.boxBackgroundColor = this.defaultFilledBackgroundColor;
                }
            }
            applyBoxAttributes();
        }
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    private void updateLabelState(boolean z10, boolean z11) {
        ColorStateList colorStateList;
        TextView textView;
        int i10;
        boolean isEnabled = isEnabled();
        EditText editText2 = this.editText;
        boolean z12 = false;
        boolean z13 = editText2 != null && !TextUtils.isEmpty(editText2.getText());
        EditText editText3 = this.editText;
        if (editText3 != null && editText3.hasFocus()) {
            z12 = true;
        }
        boolean l10 = this.indicatorViewController.l();
        ColorStateList colorStateList2 = this.defaultHintTextColor;
        if (colorStateList2 != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList2);
            this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.defaultHintTextColor;
            if (colorStateList3 != null) {
                i10 = colorStateList3.getColorForState(new int[]{-16842910}, this.disabledColor);
            } else {
                i10 = this.disabledColor;
            }
            this.collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(i10));
            this.collapsingTextHelper.setExpandedTextColor(ColorStateList.valueOf(i10));
        } else if (l10) {
            this.collapsingTextHelper.setCollapsedTextColor(this.indicatorViewController.q());
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(textView.getTextColors());
        } else if (z12 && (colorStateList = this.focusedTextColor) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
        }
        if (z13 || !this.expandedHintEnabled || (isEnabled() && z12)) {
            if (z11 || this.hintExpanded) {
                collapseHint(z10);
            }
        } else if (z11 || !this.hintExpanded) {
            expandHint(z10);
        }
    }

    /* access modifiers changed from: private */
    public void updatePlaceholderText(int i10) {
        if (i10 != 0 || this.hintExpanded) {
            hidePlaceholderText();
        } else {
            showPlaceholderText();
        }
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.endIconView.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
        if (drawable != null) {
            g.a(this, this.endIconView, this.endIconTintList, this.endIconTintMode);
            refreshEndIconDrawableState();
        }
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        this.startLayout.p(charSequence);
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.startLayout.q(drawable);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputLayout(@androidx.annotation.NonNull android.content.Context r27, @androidx.annotation.Nullable android.util.AttributeSet r28, int r29) {
        /*
            r26 = this;
            r0 = r26
            r7 = r28
            r8 = r29
            int r9 = DEF_STYLE_RES
            r1 = r27
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = -1
            r0.minEms = r10
            r0.maxEms = r10
            r0.minWidth = r10
            r0.maxWidth = r10
            com.google.android.material.textfield.h r1 = new com.google.android.material.textfield.h
            r1.<init>(r0)
            r0.indicatorViewController = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.tmpRect = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.tmpBoundsRect = r1
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r0.tmpRectF = r1
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.editTextAttachedListeners = r1
            r11 = 0
            r0.endIconMode = r11
            android.util.SparseArray r12 = new android.util.SparseArray
            r12.<init>()
            r0.endIconDelegates = r12
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.endIconChangedListeners = r1
            com.google.android.material.internal.CollapsingTextHelper r1 = new com.google.android.material.internal.CollapsingTextHelper
            r1.<init>(r0)
            r0.collapsingTextHelper = r1
            android.content.Context r13 = r26.getContext()
            r14 = 1
            r0.setOrientation(r14)
            r0.setWillNotDraw(r11)
            r0.setAddStatesFromChildren(r14)
            android.widget.FrameLayout r15 = new android.widget.FrameLayout
            r15.<init>(r13)
            r0.inputFrame = r15
            android.widget.FrameLayout r6 = new android.widget.FrameLayout
            r6.<init>(r13)
            r0.endIconFrame = r6
            android.widget.LinearLayout r5 = new android.widget.LinearLayout
            r5.<init>(r13)
            r0.endLayout = r5
            androidx.appcompat.widget.AppCompatTextView r4 = new androidx.appcompat.widget.AppCompatTextView
            r4.<init>(r13)
            r0.suffixTextView = r4
            r2 = 8
            r5.setVisibility(r2)
            r6.setVisibility(r2)
            r4.setVisibility(r2)
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r13)
            int r3 = com.google.android.material.R.layout.design_text_input_end_icon
            android.view.View r3 = r2.inflate(r3, r5, r11)
            com.google.android.material.internal.CheckableImageButton r3 = (com.google.android.material.internal.CheckableImageButton) r3
            r0.errorIconView = r3
            int r10 = com.google.android.material.R.layout.design_text_input_end_icon
            android.view.View r2 = r2.inflate(r10, r6, r11)
            r10 = r2
            com.google.android.material.internal.CheckableImageButton r10 = (com.google.android.material.internal.CheckableImageButton) r10
            r0.endIconView = r10
            r15.setAddStatesFromChildren(r14)
            r5.setOrientation(r11)
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r11 = 8388613(0x800005, float:1.175495E-38)
            r14 = -2
            r16 = r3
            r3 = -1
            r2.<init>(r14, r3, r11)
            r5.setLayoutParams(r2)
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r2.<init>(r14, r3)
            r6.setLayoutParams(r2)
            android.animation.TimeInterpolator r2 = com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR
            r1.setTextSizeInterpolator(r2)
            r1.setPositionInterpolator(r2)
            r2 = 8388659(0x800033, float:1.1755015E-38)
            r1.setCollapsedTextGravity(r2)
            int[] r3 = com.google.android.material.R.styleable.TextInputLayout
            int r1 = com.google.android.material.R.styleable.TextInputLayout_counterTextAppearance
            int r2 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextAppearance
            int r11 = com.google.android.material.R.styleable.TextInputLayout_errorTextAppearance
            int r14 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextAppearance
            r17 = r4
            int r4 = com.google.android.material.R.styleable.TextInputLayout_hintTextAppearance
            int[] r11 = new int[]{r1, r2, r11, r14, r4}
            r1 = r13
            r2 = r28
            r14 = r16
            r16 = r15
            r15 = r17
            r4 = r29
            r18 = r5
            r5 = r9
            r19 = r6
            r6 = r11
            androidx.appcompat.widget.TintTypedArray r1 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r1, r2, r3, r4, r5, r6)
            com.google.android.material.textfield.StartCompoundLayout r2 = new com.google.android.material.textfield.StartCompoundLayout
            r2.<init>(r0, r1)
            r0.startLayout = r2
            int r3 = com.google.android.material.R.styleable.TextInputLayout_hintEnabled
            r4 = 1
            boolean r3 = r1.getBoolean(r3, r4)
            r0.hintEnabled = r3
            int r3 = com.google.android.material.R.styleable.TextInputLayout_android_hint
            java.lang.CharSequence r3 = r1.getText(r3)
            r0.setHint((java.lang.CharSequence) r3)
            int r3 = com.google.android.material.R.styleable.TextInputLayout_hintAnimationEnabled
            boolean r3 = r1.getBoolean(r3, r4)
            r0.hintAnimationEnabled = r3
            int r3 = com.google.android.material.R.styleable.TextInputLayout_expandedHintEnabled
            boolean r3 = r1.getBoolean(r3, r4)
            r0.expandedHintEnabled = r3
            int r3 = com.google.android.material.R.styleable.TextInputLayout_android_minEms
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x0131
            int r3 = com.google.android.material.R.styleable.TextInputLayout_android_minEms
            r4 = -1
            int r3 = r1.getInt(r3, r4)
            r0.setMinEms(r3)
            goto L_0x0143
        L_0x0131:
            r4 = -1
            int r3 = com.google.android.material.R.styleable.TextInputLayout_android_minWidth
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x0143
            int r3 = com.google.android.material.R.styleable.TextInputLayout_android_minWidth
            int r3 = r1.getDimensionPixelSize(r3, r4)
            r0.setMinWidth(r3)
        L_0x0143:
            int r3 = com.google.android.material.R.styleable.TextInputLayout_android_maxEms
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x0155
            int r3 = com.google.android.material.R.styleable.TextInputLayout_android_maxEms
            int r3 = r1.getInt(r3, r4)
            r0.setMaxEms(r3)
            goto L_0x0166
        L_0x0155:
            int r3 = com.google.android.material.R.styleable.TextInputLayout_android_maxWidth
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x0166
            int r3 = com.google.android.material.R.styleable.TextInputLayout_android_maxWidth
            int r3 = r1.getDimensionPixelSize(r3, r4)
            r0.setMaxWidth(r3)
        L_0x0166:
            com.google.android.material.shape.ShapeAppearanceModel$Builder r3 = com.google.android.material.shape.ShapeAppearanceModel.builder((android.content.Context) r13, (android.util.AttributeSet) r7, (int) r8, (int) r9)
            com.google.android.material.shape.ShapeAppearanceModel r3 = r3.build()
            r0.shapeAppearanceModel = r3
            android.content.res.Resources r3 = r13.getResources()
            int r4 = com.google.android.material.R.dimen.mtrl_textinput_box_label_cutout_padding
            int r3 = r3.getDimensionPixelOffset(r4)
            r0.boxLabelCutoutPaddingPx = r3
            int r3 = com.google.android.material.R.styleable.TextInputLayout_boxCollapsedPaddingTop
            r4 = 0
            int r3 = r1.getDimensionPixelOffset(r3, r4)
            r0.boxCollapsedPaddingTopPx = r3
            int r3 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeWidth
            android.content.res.Resources r4 = r13.getResources()
            int r5 = com.google.android.material.R.dimen.mtrl_textinput_box_stroke_width_default
            int r4 = r4.getDimensionPixelSize(r5)
            int r3 = r1.getDimensionPixelSize(r3, r4)
            r0.boxStrokeWidthDefaultPx = r3
            int r3 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeWidthFocused
            android.content.res.Resources r4 = r13.getResources()
            int r5 = com.google.android.material.R.dimen.mtrl_textinput_box_stroke_width_focused
            int r4 = r4.getDimensionPixelSize(r5)
            int r3 = r1.getDimensionPixelSize(r3, r4)
            r0.boxStrokeWidthFocusedPx = r3
            int r3 = r0.boxStrokeWidthDefaultPx
            r0.boxStrokeWidthPx = r3
            int r3 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusTopStart
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r3 = r1.getDimension(r3, r4)
            int r5 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusTopEnd
            float r5 = r1.getDimension(r5, r4)
            int r6 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusBottomEnd
            float r6 = r1.getDimension(r6, r4)
            int r7 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusBottomStart
            float r4 = r1.getDimension(r7, r4)
            com.google.android.material.shape.ShapeAppearanceModel r7 = r0.shapeAppearanceModel
            com.google.android.material.shape.ShapeAppearanceModel$Builder r7 = r7.toBuilder()
            r8 = 0
            int r9 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r9 < 0) goto L_0x01d5
            r7.setTopLeftCornerSize((float) r3)
        L_0x01d5:
            int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x01dc
            r7.setTopRightCornerSize((float) r5)
        L_0x01dc:
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x01e3
            r7.setBottomRightCornerSize((float) r6)
        L_0x01e3:
            int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x01ea
            r7.setBottomLeftCornerSize((float) r4)
        L_0x01ea:
            com.google.android.material.shape.ShapeAppearanceModel r3 = r7.build()
            r0.shapeAppearanceModel = r3
            int r3 = com.google.android.material.R.styleable.TextInputLayout_boxBackgroundColor
            android.content.res.ColorStateList r3 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r13, (androidx.appcompat.widget.TintTypedArray) r1, (int) r3)
            if (r3 == 0) goto L_0x0252
            int r4 = r3.getDefaultColor()
            r0.defaultFilledBackgroundColor = r4
            r0.boxBackgroundColor = r4
            boolean r4 = r3.isStateful()
            r5 = 16843623(0x1010367, float:2.3696E-38)
            r6 = -16842910(0xfffffffffefeff62, float:-1.6947497E38)
            if (r4 == 0) goto L_0x0232
            int[] r4 = new int[]{r6}
            r7 = -1
            int r4 = r3.getColorForState(r4, r7)
            r0.disabledFilledBackgroundColor = r4
            r4 = 16842908(0x101009c, float:2.3693995E-38)
            r6 = 16842910(0x101009e, float:2.3694E-38)
            int[] r4 = new int[]{r4, r6}
            int r4 = r3.getColorForState(r4, r7)
            r0.focusedFilledBackgroundColor = r4
            int[] r4 = new int[]{r5, r6}
            int r3 = r3.getColorForState(r4, r7)
            r0.hoveredFilledBackgroundColor = r3
            goto L_0x025d
        L_0x0232:
            r7 = -1
            int r3 = r0.defaultFilledBackgroundColor
            r0.focusedFilledBackgroundColor = r3
            int r3 = com.google.android.material.R.color.mtrl_filled_background_color
            android.content.res.ColorStateList r3 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r13, r3)
            int[] r4 = new int[]{r6}
            int r4 = r3.getColorForState(r4, r7)
            r0.disabledFilledBackgroundColor = r4
            int[] r4 = new int[]{r5}
            int r3 = r3.getColorForState(r4, r7)
            r0.hoveredFilledBackgroundColor = r3
            goto L_0x025d
        L_0x0252:
            r3 = 0
            r0.boxBackgroundColor = r3
            r0.defaultFilledBackgroundColor = r3
            r0.disabledFilledBackgroundColor = r3
            r0.focusedFilledBackgroundColor = r3
            r0.hoveredFilledBackgroundColor = r3
        L_0x025d:
            int r3 = com.google.android.material.R.styleable.TextInputLayout_android_textColorHint
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x026f
            int r3 = com.google.android.material.R.styleable.TextInputLayout_android_textColorHint
            android.content.res.ColorStateList r3 = r1.getColorStateList(r3)
            r0.focusedTextColor = r3
            r0.defaultHintTextColor = r3
        L_0x026f:
            int r3 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeColor
            android.content.res.ColorStateList r3 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r13, (androidx.appcompat.widget.TintTypedArray) r1, (int) r3)
            int r4 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeColor
            r5 = 0
            int r4 = r1.getColor(r4, r5)
            r0.focusedStrokeColor = r4
            int r4 = com.google.android.material.R.color.mtrl_textinput_default_box_stroke_color
            int r4 = androidx.core.content.ContextCompat.getColor(r13, r4)
            r0.defaultStrokeColor = r4
            int r4 = com.google.android.material.R.color.mtrl_textinput_disabled_color
            int r4 = androidx.core.content.ContextCompat.getColor(r13, r4)
            r0.disabledColor = r4
            int r4 = com.google.android.material.R.color.mtrl_textinput_hovered_box_stroke_color
            int r4 = androidx.core.content.ContextCompat.getColor(r13, r4)
            r0.hoveredStrokeColor = r4
            if (r3 == 0) goto L_0x029b
            r0.setBoxStrokeColorStateList(r3)
        L_0x029b:
            int r3 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeErrorColor
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x02ac
            int r3 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeErrorColor
            android.content.res.ColorStateList r3 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r13, (androidx.appcompat.widget.TintTypedArray) r1, (int) r3)
            r0.setBoxStrokeErrorColor(r3)
        L_0x02ac:
            int r3 = com.google.android.material.R.styleable.TextInputLayout_hintTextAppearance
            r4 = -1
            int r3 = r1.getResourceId(r3, r4)
            if (r3 == r4) goto L_0x02c0
            int r3 = com.google.android.material.R.styleable.TextInputLayout_hintTextAppearance
            r4 = 0
            int r3 = r1.getResourceId(r3, r4)
            r0.setHintTextAppearance(r3)
            goto L_0x02c1
        L_0x02c0:
            r4 = 0
        L_0x02c1:
            int r3 = com.google.android.material.R.styleable.TextInputLayout_errorTextAppearance
            int r3 = r1.getResourceId(r3, r4)
            int r5 = com.google.android.material.R.styleable.TextInputLayout_errorContentDescription
            java.lang.CharSequence r5 = r1.getText(r5)
            int r6 = com.google.android.material.R.styleable.TextInputLayout_errorEnabled
            boolean r6 = r1.getBoolean(r6, r4)
            int r7 = com.google.android.material.R.id.text_input_error_icon
            r14.setId(r7)
            boolean r7 = com.google.android.material.resources.MaterialResources.isFontScaleAtLeast1_3(r13)
            if (r7 == 0) goto L_0x02e7
            android.view.ViewGroup$LayoutParams r7 = r14.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r7 = (android.view.ViewGroup.MarginLayoutParams) r7
            androidx.core.view.MarginLayoutParamsCompat.setMarginStart(r7, r4)
        L_0x02e7:
            int r4 = com.google.android.material.R.styleable.TextInputLayout_errorIconTint
            boolean r4 = r1.hasValue(r4)
            if (r4 == 0) goto L_0x02f7
            int r4 = com.google.android.material.R.styleable.TextInputLayout_errorIconTint
            android.content.res.ColorStateList r4 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r13, (androidx.appcompat.widget.TintTypedArray) r1, (int) r4)
            r0.errorIconTintList = r4
        L_0x02f7:
            int r4 = com.google.android.material.R.styleable.TextInputLayout_errorIconTintMode
            boolean r4 = r1.hasValue(r4)
            r7 = 0
            if (r4 == 0) goto L_0x030d
            int r4 = com.google.android.material.R.styleable.TextInputLayout_errorIconTintMode
            r8 = -1
            int r4 = r1.getInt(r4, r8)
            android.graphics.PorterDuff$Mode r4 = com.google.android.material.internal.ViewUtils.parseTintMode(r4, r7)
            r0.errorIconTintMode = r4
        L_0x030d:
            int r4 = com.google.android.material.R.styleable.TextInputLayout_errorIconDrawable
            boolean r4 = r1.hasValue(r4)
            if (r4 == 0) goto L_0x031e
            int r4 = com.google.android.material.R.styleable.TextInputLayout_errorIconDrawable
            android.graphics.drawable.Drawable r4 = r1.getDrawable(r4)
            r0.setErrorIconDrawable((android.graphics.drawable.Drawable) r4)
        L_0x031e:
            android.content.res.Resources r4 = r26.getResources()
            int r8 = com.google.android.material.R.string.error_icon_content_description
            java.lang.CharSequence r4 = r4.getText(r8)
            r14.setContentDescription(r4)
            r4 = 2
            androidx.core.view.ViewCompat.setImportantForAccessibility(r14, r4)
            r8 = 0
            r14.setClickable(r8)
            r14.setPressable(r8)
            r14.setFocusable(r8)
            int r9 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextAppearance
            int r9 = r1.getResourceId(r9, r8)
            int r11 = com.google.android.material.R.styleable.TextInputLayout_helperTextEnabled
            boolean r11 = r1.getBoolean(r11, r8)
            int r7 = com.google.android.material.R.styleable.TextInputLayout_helperText
            java.lang.CharSequence r7 = r1.getText(r7)
            int r4 = com.google.android.material.R.styleable.TextInputLayout_placeholderTextAppearance
            int r4 = r1.getResourceId(r4, r8)
            int r8 = com.google.android.material.R.styleable.TextInputLayout_placeholderText
            java.lang.CharSequence r8 = r1.getText(r8)
            r17 = r7
            int r7 = com.google.android.material.R.styleable.TextInputLayout_suffixTextAppearance
            r20 = r6
            r6 = 0
            int r7 = r1.getResourceId(r7, r6)
            int r6 = com.google.android.material.R.styleable.TextInputLayout_suffixText
            java.lang.CharSequence r6 = r1.getText(r6)
            r21 = r6
            int r6 = com.google.android.material.R.styleable.TextInputLayout_counterEnabled
            r22 = r11
            r11 = 0
            boolean r6 = r1.getBoolean(r6, r11)
            int r11 = com.google.android.material.R.styleable.TextInputLayout_counterMaxLength
            r23 = r6
            r6 = -1
            int r11 = r1.getInt(r11, r6)
            r0.setCounterMaxLength(r11)
            int r6 = com.google.android.material.R.styleable.TextInputLayout_counterTextAppearance
            r11 = 0
            int r6 = r1.getResourceId(r6, r11)
            r0.counterTextAppearance = r6
            int r6 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextAppearance
            int r6 = r1.getResourceId(r6, r11)
            r0.counterOverflowTextAppearance = r6
            int r6 = com.google.android.material.R.styleable.TextInputLayout_boxBackgroundMode
            int r6 = r1.getInt(r6, r11)
            r0.setBoxBackgroundMode(r6)
            boolean r6 = com.google.android.material.resources.MaterialResources.isFontScaleAtLeast1_3(r13)
            if (r6 == 0) goto L_0x03a8
            android.view.ViewGroup$LayoutParams r6 = r10.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            androidx.core.view.MarginLayoutParamsCompat.setMarginStart(r6, r11)
        L_0x03a8:
            int r6 = com.google.android.material.R.styleable.TextInputLayout_endIconDrawable
            int r6 = r1.getResourceId(r6, r11)
            com.google.android.material.textfield.b r11 = new com.google.android.material.textfield.b
            r11.<init>(r0, r6)
            r24 = r2
            r2 = -1
            r12.append(r2, r11)
            com.google.android.material.textfield.i r2 = new com.google.android.material.textfield.i
            r2.<init>(r0)
            r11 = 0
            r12.append(r11, r2)
            com.google.android.material.textfield.j r2 = new com.google.android.material.textfield.j
            if (r6 != 0) goto L_0x03cf
            r25 = r14
            int r14 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleDrawable
            int r14 = r1.getResourceId(r14, r11)
            goto L_0x03d2
        L_0x03cf:
            r25 = r14
            r14 = r6
        L_0x03d2:
            r2.<init>(r0, r14)
            r11 = 1
            r12.append(r11, r2)
            com.google.android.material.textfield.a r2 = new com.google.android.material.textfield.a
            r2.<init>(r0, r6)
            r11 = 2
            r12.append(r11, r2)
            com.google.android.material.textfield.e r2 = new com.google.android.material.textfield.e
            r2.<init>(r0, r6)
            r6 = 3
            r12.append(r6, r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleEnabled
            boolean r2 = r1.hasValue(r2)
            if (r2 != 0) goto L_0x0419
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconTint
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0403
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconTint
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r13, (androidx.appcompat.widget.TintTypedArray) r1, (int) r2)
            r0.endIconTintList = r2
        L_0x0403:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconTintMode
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0419
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconTintMode
            r6 = -1
            int r2 = r1.getInt(r2, r6)
            r6 = 0
            android.graphics.PorterDuff$Mode r2 = com.google.android.material.internal.ViewUtils.parseTintMode(r2, r6)
            r0.endIconTintMode = r2
        L_0x0419:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconMode
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0447
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconMode
            r6 = 0
            int r2 = r1.getInt(r2, r6)
            r0.setEndIconMode(r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconContentDescription
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x043c
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconContentDescription
            java.lang.CharSequence r2 = r1.getText(r2)
            r0.setEndIconContentDescription((java.lang.CharSequence) r2)
        L_0x043c:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconCheckable
            r6 = 1
            boolean r2 = r1.getBoolean(r2, r6)
            r0.setEndIconCheckable(r2)
            goto L_0x0488
        L_0x0447:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleEnabled
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0488
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleTint
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x045f
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleTint
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r13, (androidx.appcompat.widget.TintTypedArray) r1, (int) r2)
            r0.endIconTintList = r2
        L_0x045f:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleTintMode
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0475
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleTintMode
            r6 = -1
            int r2 = r1.getInt(r2, r6)
            r6 = 0
            android.graphics.PorterDuff$Mode r2 = com.google.android.material.internal.ViewUtils.parseTintMode(r2, r6)
            r0.endIconTintMode = r2
        L_0x0475:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleEnabled
            r6 = 0
            boolean r2 = r1.getBoolean(r2, r6)
            r0.setEndIconMode(r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleContentDescription
            java.lang.CharSequence r2 = r1.getText(r2)
            r0.setEndIconContentDescription((java.lang.CharSequence) r2)
        L_0x0488:
            int r2 = com.google.android.material.R.id.textinput_suffix_text
            r15.setId(r2)
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r6 = 80
            r11 = -2
            r2.<init>(r11, r11, r6)
            r15.setLayoutParams(r2)
            r2 = 1
            androidx.core.view.ViewCompat.setAccessibilityLiveRegion(r15, r2)
            r0.setErrorContentDescription(r5)
            int r2 = r0.counterOverflowTextAppearance
            r0.setCounterOverflowTextAppearance(r2)
            r0.setHelperTextTextAppearance(r9)
            r0.setErrorTextAppearance(r3)
            int r2 = r0.counterTextAppearance
            r0.setCounterTextAppearance(r2)
            r0.setPlaceholderText(r8)
            r0.setPlaceholderTextAppearance(r4)
            r0.setSuffixTextAppearance(r7)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_errorTextColor
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x04c9
            int r2 = com.google.android.material.R.styleable.TextInputLayout_errorTextColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setErrorTextColor(r2)
        L_0x04c9:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextColor
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x04da
            int r2 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setHelperTextColor(r2)
        L_0x04da:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintTextColor
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x04eb
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintTextColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setHintTextColor(r2)
        L_0x04eb:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_counterTextColor
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x04fc
            int r2 = com.google.android.material.R.styleable.TextInputLayout_counterTextColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setCounterTextColor(r2)
        L_0x04fc:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextColor
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x050d
            int r2 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setCounterOverflowTextColor(r2)
        L_0x050d:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_placeholderTextColor
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x051e
            int r2 = com.google.android.material.R.styleable.TextInputLayout_placeholderTextColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setPlaceholderTextColor(r2)
        L_0x051e:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_suffixTextColor
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x052f
            int r2 = com.google.android.material.R.styleable.TextInputLayout_suffixTextColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r0.setSuffixTextColor(r2)
        L_0x052f:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_enabled
            r3 = 1
            boolean r2 = r1.getBoolean(r2, r3)
            r0.setEnabled(r2)
            r1.recycle()
            r1 = 2
            androidx.core.view.ViewCompat.setImportantForAccessibility(r0, r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L_0x0549
            androidx.core.view.ViewCompat.setImportantForAutofill(r0, r3)
        L_0x0549:
            r1 = r19
            r1.addView(r10)
            r2 = r18
            r2.addView(r15)
            r3 = r25
            r2.addView(r3)
            r2.addView(r1)
            r1 = r16
            r3 = r24
            r1.addView(r3)
            r1.addView(r2)
            r0.addView(r1)
            r1 = r22
            r0.setHelperTextEnabled(r1)
            r1 = r20
            r0.setErrorEnabled(r1)
            r1 = r23
            r0.setCounterEnabled(r1)
            r1 = r17
            r0.setHelperText(r1)
            r1 = r21
            r0.setSuffixText(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.errorIconView.setImageDrawable(drawable);
        updateErrorIconVisibility();
        g.a(this, this.errorIconView, this.errorIconTintList, this.errorIconTintMode);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.endIconView.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    /* access modifiers changed from: package-private */
    public void updateCounter(int i10) {
        boolean z10 = this.counterOverflowed;
        int i11 = this.counterMaxLength;
        if (i11 == -1) {
            this.counterView.setText(String.valueOf(i10));
            this.counterView.setContentDescription((CharSequence) null);
            this.counterOverflowed = false;
        } else {
            this.counterOverflowed = i10 > i11;
            updateCounterContentDescription(getContext(), this.counterView, i10, this.counterMaxLength, this.counterOverflowed);
            if (z10 != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
            }
            this.counterView.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R.string.character_counter_pattern, new Object[]{Integer.valueOf(i10), Integer.valueOf(this.counterMaxLength)})));
        }
        if (this.editText != null && z10 != this.counterOverflowed) {
            updateLabelState(false);
            updateTextInputBoxState();
            updateEditTextBackground();
        }
    }

    public void setHint(@StringRes int i10) {
        setHint(i10 != 0 ? getResources().getText(i10) : null);
    }
}
