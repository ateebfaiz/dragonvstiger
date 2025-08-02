package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.Locale;

public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    public static final int BOTTOM_END = 8388693;
    public static final int BOTTOM_START = 8388691;
    static final String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
    @StyleRes
    private static final int DEFAULT_STYLE = R.style.Widget_MaterialComponents_Badge;
    @AttrRes
    private static final int DEFAULT_THEME_ATTR = R.attr.badgeStyle;
    private static final int MAX_CIRCULAR_BADGE_NUMBER_COUNT = 9;
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;
    @Nullable
    private WeakReference<View> anchorViewRef;
    @NonNull
    private final Rect badgeBounds = new Rect();
    private float badgeCenterX;
    private float badgeCenterY;
    @NonNull
    private final WeakReference<Context> contextRef;
    private float cornerRadius;
    @Nullable
    private WeakReference<FrameLayout> customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;
    @NonNull
    private final MaterialShapeDrawable shapeDrawable = new MaterialShapeDrawable();
    @NonNull
    private final BadgeState state;
    @NonNull
    private final TextDrawableHelper textDrawableHelper;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f7916a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FrameLayout f7917b;

        a(View view, FrameLayout frameLayout) {
            this.f7916a = view;
            this.f7917b = frameLayout;
        }

        public void run() {
            BadgeDrawable.this.updateBadgeCoordinates(this.f7916a, this.f7917b);
        }
    }

    private BadgeDrawable(@NonNull Context context, @XmlRes int i10, @AttrRes int i11, @StyleRes int i12, @Nullable BadgeState.State state2) {
        this.contextRef = new WeakReference<>(context);
        ThemeEnforcement.checkMaterialTheme(context);
        TextDrawableHelper textDrawableHelper2 = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper2;
        textDrawableHelper2.getTextPaint().setTextAlign(Paint.Align.CENTER);
        setTextAppearanceResource(R.style.TextAppearance_MaterialComponents_Badge);
        this.state = new BadgeState(context, i10, i11, i12, state2);
        restoreState();
    }

    private void calculateCenterAndBounds(@NonNull Context context, @NonNull Rect rect, @NonNull View view) {
        int i10;
        float f10;
        float f11;
        float f12;
        int totalVerticalOffsetForState = getTotalVerticalOffsetForState();
        int badgeGravity = this.state.getBadgeGravity();
        if (badgeGravity == 8388691 || badgeGravity == 8388693) {
            this.badgeCenterY = (float) (rect.bottom - totalVerticalOffsetForState);
        } else {
            this.badgeCenterY = (float) (rect.top + totalVerticalOffsetForState);
        }
        if (getNumber() <= 9) {
            if (!hasNumber()) {
                f12 = this.state.badgeRadius;
            } else {
                f12 = this.state.badgeWithTextRadius;
            }
            this.cornerRadius = f12;
            this.halfBadgeHeight = f12;
            this.halfBadgeWidth = f12;
        } else {
            float f13 = this.state.badgeWithTextRadius;
            this.cornerRadius = f13;
            this.halfBadgeHeight = f13;
            this.halfBadgeWidth = (this.textDrawableHelper.getTextWidth(getBadgeText()) / 2.0f) + this.state.badgeWidePadding;
        }
        Resources resources = context.getResources();
        if (hasNumber()) {
            i10 = R.dimen.mtrl_badge_text_horizontal_edge_offset;
        } else {
            i10 = R.dimen.mtrl_badge_horizontal_edge_offset;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(i10);
        int totalHorizontalOffsetForState = getTotalHorizontalOffsetForState();
        int badgeGravity2 = this.state.getBadgeGravity();
        if (badgeGravity2 == 8388659 || badgeGravity2 == 8388691) {
            if (ViewCompat.getLayoutDirection(view) == 0) {
                f10 = (((float) rect.left) - this.halfBadgeWidth) + ((float) dimensionPixelSize) + ((float) totalHorizontalOffsetForState);
            } else {
                f10 = ((((float) rect.right) + this.halfBadgeWidth) - ((float) dimensionPixelSize)) - ((float) totalHorizontalOffsetForState);
            }
            this.badgeCenterX = f10;
            return;
        }
        if (ViewCompat.getLayoutDirection(view) == 0) {
            f11 = ((((float) rect.right) + this.halfBadgeWidth) - ((float) dimensionPixelSize)) - ((float) totalHorizontalOffsetForState);
        } else {
            f11 = (((float) rect.left) - this.halfBadgeWidth) + ((float) dimensionPixelSize) + ((float) totalHorizontalOffsetForState);
        }
        this.badgeCenterX = f11;
    }

    @NonNull
    public static BadgeDrawable create(@NonNull Context context) {
        return new BadgeDrawable(context, 0, DEFAULT_THEME_ATTR, DEFAULT_STYLE, (BadgeState.State) null);
    }

    @NonNull
    public static BadgeDrawable createFromResource(@NonNull Context context, @XmlRes int i10) {
        return new BadgeDrawable(context, i10, DEFAULT_THEME_ATTR, DEFAULT_STYLE, (BadgeState.State) null);
    }

    @NonNull
    static BadgeDrawable createFromSavedState(@NonNull Context context, @NonNull BadgeState.State state2) {
        return new BadgeDrawable(context, 0, DEFAULT_THEME_ATTR, DEFAULT_STYLE, state2);
    }

    private void drawText(Canvas canvas) {
        Rect rect = new Rect();
        String badgeText = getBadgeText();
        this.textDrawableHelper.getTextPaint().getTextBounds(badgeText, 0, badgeText.length(), rect);
        canvas.drawText(badgeText, this.badgeCenterX, this.badgeCenterY + ((float) (rect.height() / 2)), this.textDrawableHelper.getTextPaint());
    }

    @NonNull
    private String getBadgeText() {
        if (getNumber() <= this.maxBadgeNumber) {
            return NumberFormat.getInstance(this.state.getNumberLocale()).format((long) getNumber());
        }
        Context context = this.contextRef.get();
        if (context == null) {
            return "";
        }
        return String.format(this.state.getNumberLocale(), context.getString(R.string.mtrl_exceed_max_badge_number_suffix), new Object[]{Integer.valueOf(this.maxBadgeNumber), DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX});
    }

    private int getTotalHorizontalOffsetForState() {
        int i10;
        if (hasNumber()) {
            i10 = this.state.getHorizontalOffsetWithText();
        } else {
            i10 = this.state.getHorizontalOffsetWithoutText();
        }
        return i10 + this.state.getAdditionalHorizontalOffset();
    }

    private int getTotalVerticalOffsetForState() {
        int i10;
        if (hasNumber()) {
            i10 = this.state.getVerticalOffsetWithText();
        } else {
            i10 = this.state.getVerticalOffsetWithoutText();
        }
        return i10 + this.state.getAdditionalVerticalOffset();
    }

    private void onAlphaUpdated() {
        this.textDrawableHelper.getTextPaint().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void onBackgroundColorUpdated() {
        ColorStateList valueOf = ColorStateList.valueOf(this.state.getBackgroundColor());
        if (this.shapeDrawable.getFillColor() != valueOf) {
            this.shapeDrawable.setFillColor(valueOf);
            invalidateSelf();
        }
    }

    private void onBadgeGravityUpdated() {
        FrameLayout frameLayout;
        WeakReference<View> weakReference = this.anchorViewRef;
        if (weakReference != null && weakReference.get() != null) {
            View view = this.anchorViewRef.get();
            WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            } else {
                frameLayout = null;
            }
            updateBadgeCoordinates(view, frameLayout);
        }
    }

    private void onBadgeTextColorUpdated() {
        this.textDrawableHelper.getTextPaint().setColor(this.state.getBadgeTextColor());
        invalidateSelf();
    }

    private void onMaxCharacterCountUpdated() {
        updateMaxBadgeNumber();
        this.textDrawableHelper.setTextWidthDirty(true);
        updateCenterAndBounds();
        invalidateSelf();
    }

    private void onNumberUpdated() {
        this.textDrawableHelper.setTextWidthDirty(true);
        updateCenterAndBounds();
        invalidateSelf();
    }

    private void onVisibilityUpdated() {
        boolean isVisible = this.state.isVisible();
        setVisible(isVisible, false);
        if (BadgeUtils.USE_COMPAT_PARENT && getCustomBadgeParent() != null && !isVisible) {
            ((ViewGroup) getCustomBadgeParent().getParent()).invalidate();
        }
    }

    private void restoreState() {
        onMaxCharacterCountUpdated();
        onNumberUpdated();
        onAlphaUpdated();
        onBackgroundColorUpdated();
        onBadgeTextColorUpdated();
        onBadgeGravityUpdated();
        updateCenterAndBounds();
        onVisibilityUpdated();
    }

    private void setTextAppearance(@Nullable TextAppearance textAppearance) {
        Context context;
        if (this.textDrawableHelper.getTextAppearance() != textAppearance && (context = this.contextRef.get()) != null) {
            this.textDrawableHelper.setTextAppearance(textAppearance, context);
            updateCenterAndBounds();
        }
    }

    private void setTextAppearanceResource(@StyleRes int i10) {
        Context context = this.contextRef.get();
        if (context != null) {
            setTextAppearance(new TextAppearance(context, i10));
        }
    }

    private void tryWrapAnchorInCompatParent(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R.id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
            if (weakReference == null || weakReference.get() != viewGroup) {
                updateAnchorParentToNotClip(view);
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R.id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(indexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, indexOfChild);
                this.customBadgeParentRef = new WeakReference<>(frameLayout);
                frameLayout.post(new a(view, frameLayout));
            }
        }
    }

    private static void updateAnchorParentToNotClip(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void updateCenterAndBounds() {
        View view;
        Context context = this.contextRef.get();
        WeakReference<View> weakReference = this.anchorViewRef;
        ViewGroup viewGroup = null;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.badgeBounds);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
            if (weakReference2 != null) {
                viewGroup = weakReference2.get();
            }
            if (viewGroup != null || BadgeUtils.USE_COMPAT_PARENT) {
                if (viewGroup == null) {
                    viewGroup = (ViewGroup) view.getParent();
                }
                viewGroup.offsetDescendantRectToMyCoords(view, rect2);
            }
            calculateCenterAndBounds(context, rect2, view);
            BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
            this.shapeDrawable.setCornerSize(this.cornerRadius);
            if (!rect.equals(this.badgeBounds)) {
                this.shapeDrawable.setBounds(this.badgeBounds);
            }
        }
    }

    private void updateMaxBadgeNumber() {
        this.maxBadgeNumber = ((int) Math.pow(10.0d, ((double) getMaxCharacterCount()) - 1.0d)) - 1;
    }

    public void clearNumber() {
        if (hasNumber()) {
            this.state.clearNumber();
            onNumberUpdated();
        }
    }

    public void draw(@NonNull Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.shapeDrawable.draw(canvas);
            if (hasNumber()) {
                drawText(canvas);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getAdditionalHorizontalOffset() {
        return this.state.getAdditionalHorizontalOffset();
    }

    /* access modifiers changed from: package-private */
    @Px
    public int getAdditionalVerticalOffset() {
        return this.state.getAdditionalVerticalOffset();
    }

    public int getAlpha() {
        return this.state.getAlpha();
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    public int getBadgeGravity() {
        return this.state.getBadgeGravity();
    }

    @NonNull
    public Locale getBadgeNumberLocale() {
        return this.state.getNumberLocale();
    }

    @ColorInt
    public int getBadgeTextColor() {
        return this.textDrawableHelper.getTextPaint().getColor();
    }

    @Nullable
    public CharSequence getContentDescription() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!hasNumber()) {
            return this.state.getContentDescriptionNumberless();
        }
        if (this.state.getContentDescriptionQuantityStrings() == 0 || (context = this.contextRef.get()) == null) {
            return null;
        }
        if (getNumber() <= this.maxBadgeNumber) {
            return context.getResources().getQuantityString(this.state.getContentDescriptionQuantityStrings(), getNumber(), new Object[]{Integer.valueOf(getNumber())});
        }
        return context.getString(this.state.getContentDescriptionExceedsMaxBadgeNumberStringResource(), new Object[]{Integer.valueOf(this.maxBadgeNumber)});
    }

    @Nullable
    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getHorizontalOffset() {
        return this.state.getHorizontalOffsetWithoutText();
    }

    @Px
    public int getHorizontalOffsetWithText() {
        return this.state.getHorizontalOffsetWithText();
    }

    @Px
    public int getHorizontalOffsetWithoutText() {
        return this.state.getHorizontalOffsetWithoutText();
    }

    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    public int getMaxCharacterCount() {
        return this.state.getMaxCharacterCount();
    }

    public int getNumber() {
        if (hasNumber()) {
            return this.state.getNumber();
        }
        return 0;
    }

    public int getOpacity() {
        return -3;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public BadgeState.State getSavedState() {
        return this.state.getOverridingState();
    }

    public int getVerticalOffset() {
        return this.state.getVerticalOffsetWithoutText();
    }

    @Px
    public int getVerticalOffsetWithText() {
        return this.state.getVerticalOffsetWithText();
    }

    @Px
    public int getVerticalOffsetWithoutText() {
        return this.state.getVerticalOffsetWithoutText();
    }

    public boolean hasNumber() {
        return this.state.hasNumber();
    }

    public boolean isStateful() {
        return false;
    }

    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onTextSizeChange() {
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void setAdditionalHorizontalOffset(int i10) {
        this.state.setAdditionalHorizontalOffset(i10);
        updateCenterAndBounds();
    }

    /* access modifiers changed from: package-private */
    public void setAdditionalVerticalOffset(@Px int i10) {
        this.state.setAdditionalVerticalOffset(i10);
        updateCenterAndBounds();
    }

    public void setAlpha(int i10) {
        this.state.setAlpha(i10);
        onAlphaUpdated();
    }

    public void setBackgroundColor(@ColorInt int i10) {
        this.state.setBackgroundColor(i10);
        onBackgroundColorUpdated();
    }

    public void setBadgeGravity(int i10) {
        if (this.state.getBadgeGravity() != i10) {
            this.state.setBadgeGravity(i10);
            onBadgeGravityUpdated();
        }
    }

    public void setBadgeNumberLocale(@NonNull Locale locale) {
        if (!locale.equals(this.state.getNumberLocale())) {
            this.state.setNumberLocale(locale);
            invalidateSelf();
        }
    }

    public void setBadgeTextColor(@ColorInt int i10) {
        if (this.textDrawableHelper.getTextPaint().getColor() != i10) {
            this.state.setBadgeTextColor(i10);
            onBadgeTextColorUpdated();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(@StringRes int i10) {
        this.state.setContentDescriptionExceedsMaxBadgeNumberStringResource(i10);
    }

    public void setContentDescriptionNumberless(CharSequence charSequence) {
        this.state.setContentDescriptionNumberless(charSequence);
    }

    public void setContentDescriptionQuantityStringsResource(@PluralsRes int i10) {
        this.state.setContentDescriptionQuantityStringsResource(i10);
    }

    public void setHorizontalOffset(int i10) {
        setHorizontalOffsetWithoutText(i10);
        setHorizontalOffsetWithText(i10);
    }

    public void setHorizontalOffsetWithText(@Px int i10) {
        this.state.setHorizontalOffsetWithText(i10);
        updateCenterAndBounds();
    }

    public void setHorizontalOffsetWithoutText(@Px int i10) {
        this.state.setHorizontalOffsetWithoutText(i10);
        updateCenterAndBounds();
    }

    public void setMaxCharacterCount(int i10) {
        if (this.state.getMaxCharacterCount() != i10) {
            this.state.setMaxCharacterCount(i10);
            onMaxCharacterCountUpdated();
        }
    }

    public void setNumber(int i10) {
        int max = Math.max(0, i10);
        if (this.state.getNumber() != max) {
            this.state.setNumber(max);
            onNumberUpdated();
        }
    }

    public void setVerticalOffset(int i10) {
        setVerticalOffsetWithoutText(i10);
        setVerticalOffsetWithText(i10);
    }

    public void setVerticalOffsetWithText(@Px int i10) {
        this.state.setVerticalOffsetWithText(i10);
        updateCenterAndBounds();
    }

    public void setVerticalOffsetWithoutText(@Px int i10) {
        this.state.setVerticalOffsetWithoutText(i10);
        updateCenterAndBounds();
    }

    public void setVisible(boolean z10) {
        this.state.setVisible(z10);
        onVisibilityUpdated();
    }

    @Deprecated
    public void updateBadgeCoordinates(@NonNull View view, @Nullable ViewGroup viewGroup) {
        if (viewGroup instanceof FrameLayout) {
            updateBadgeCoordinates(view, (FrameLayout) viewGroup);
            return;
        }
        throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
    }

    public void updateBadgeCoordinates(@NonNull View view) {
        updateBadgeCoordinates(view, (FrameLayout) null);
    }

    public void updateBadgeCoordinates(@NonNull View view, @Nullable FrameLayout frameLayout) {
        this.anchorViewRef = new WeakReference<>(view);
        boolean z10 = BadgeUtils.USE_COMPAT_PARENT;
        if (!z10 || frameLayout != null) {
            this.customBadgeParentRef = new WeakReference<>(frameLayout);
        } else {
            tryWrapAnchorInCompatParent(view);
        }
        if (!z10) {
            updateAnchorParentToNotClip(view);
        }
        updateCenterAndBounds();
        invalidateSelf();
    }
}
