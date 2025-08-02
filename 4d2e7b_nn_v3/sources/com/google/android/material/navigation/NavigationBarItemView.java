package com.google.android.material.navigation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class NavigationBarItemView extends FrameLayout implements MenuView.ItemView {
    private static final d ACTIVE_INDICATOR_LABELED_TRANSFORM = new d((a) null);
    private static final d ACTIVE_INDICATOR_UNLABELED_TRANSFORM = new e((a) null);
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int INVALID_ITEM_POSITION = -1;
    private ValueAnimator activeIndicatorAnimator;
    private int activeIndicatorDesiredHeight = 0;
    private int activeIndicatorDesiredWidth = 0;
    private boolean activeIndicatorEnabled = false;
    private int activeIndicatorMarginHorizontal = 0;
    private float activeIndicatorProgress = 0.0f;
    private boolean activeIndicatorResizeable = false;
    private d activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
    @Nullable
    private final View activeIndicatorView;
    @Nullable
    private BadgeDrawable badgeDrawable;
    /* access modifiers changed from: private */
    public final ImageView icon;
    @Nullable
    private final FrameLayout iconContainer;
    @Nullable
    private ColorStateList iconTint;
    private boolean initialized = false;
    private boolean isShifting;
    @Nullable
    private MenuItemImpl itemData;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private int itemPosition = -1;
    private final ViewGroup labelGroup;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    @Nullable
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;
    @Nullable
    private Drawable wrappedIconDrawable;

    class a implements View.OnLayoutChangeListener {
        a() {
        }

        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            if (NavigationBarItemView.this.icon.getVisibility() == 0) {
                NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                navigationBarItemView.tryUpdateBadgeBounds(navigationBarItemView.icon);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8359a;

        b(int i10) {
            this.f8359a = i10;
        }

        public void run() {
            NavigationBarItemView.this.updateActiveIndicatorLayoutParams(this.f8359a);
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f8361a;

        c(float f10) {
            this.f8361a = f10;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NavigationBarItemView.this.setActiveIndicatorProgress(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f8361a);
        }
    }

    private static class d {
        private d() {
        }

        /* access modifiers changed from: protected */
        public float a(float f10, float f11) {
            float f12;
            float f13;
            int i10 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
            if (i10 == 0) {
                f12 = 0.8f;
            } else {
                f12 = 0.0f;
            }
            if (i10 == 0) {
                f13 = 1.0f;
            } else {
                f13 = 0.2f;
            }
            return AnimationUtils.lerp(0.0f, 1.0f, f12, f13, f10);
        }

        /* access modifiers changed from: protected */
        public float b(float f10, float f11) {
            return AnimationUtils.lerp(0.4f, 1.0f, f10);
        }

        /* access modifiers changed from: protected */
        public float c(float f10, float f11) {
            return 1.0f;
        }

        public void d(float f10, float f11, View view) {
            view.setScaleX(b(f10, f11));
            view.setScaleY(c(f10, f11));
            view.setAlpha(a(f10, f11));
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    private static class e extends d {
        private e() {
            super((a) null);
        }

        /* access modifiers changed from: protected */
        public float c(float f10, float f11) {
            return b(f10, f11);
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    public NavigationBarItemView(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(getItemLayoutResId(), this, true);
        this.iconContainer = (FrameLayout) findViewById(R.id.navigation_bar_item_icon_container);
        this.activeIndicatorView = findViewById(R.id.navigation_bar_item_active_indicator_view);
        ImageView imageView = (ImageView) findViewById(R.id.navigation_bar_item_icon_view);
        this.icon = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.navigation_bar_item_labels_group);
        this.labelGroup = viewGroup;
        TextView textView = (TextView) findViewById(R.id.navigation_bar_item_small_label_view);
        this.smallLabel = textView;
        TextView textView2 = (TextView) findViewById(R.id.navigation_bar_item_large_label_view);
        this.largeLabel = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.itemPaddingTop = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.itemPaddingBottom = viewGroup.getPaddingBottom();
        ViewCompat.setImportantForAccessibility(textView, 2);
        ViewCompat.setImportantForAccessibility(textView2, 2);
        setFocusable(true);
        calculateTextScaleFactors(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new a());
        }
    }

    private void calculateTextScaleFactors(float f10, float f11) {
        this.shiftAmount = f10 - f11;
        this.scaleUpFactor = (f11 * 1.0f) / f10;
        this.scaleDownFactor = (f10 * 1.0f) / f11;
    }

    @Nullable
    private FrameLayout getCustomParentForBadge(View view) {
        ImageView imageView = this.icon;
        if (view != imageView || !BadgeUtils.USE_COMPAT_PARENT) {
            return null;
        }
        return (FrameLayout) imageView.getParent();
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.iconContainer;
        if (frameLayout != null) {
            return frameLayout;
        }
        return this.icon;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i10 = 0;
        for (int i11 = 0; i11 < indexOfChild; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i10++;
            }
        }
        return i10;
    }

    private int getSuggestedIconHeight() {
        int i10;
        BadgeDrawable badgeDrawable2 = this.badgeDrawable;
        if (badgeDrawable2 != null) {
            i10 = badgeDrawable2.getMinimumHeight() / 2;
        } else {
            i10 = 0;
        }
        return Math.max(i10, ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin) + this.icon.getMeasuredWidth() + i10;
    }

    private int getSuggestedIconWidth() {
        int i10;
        BadgeDrawable badgeDrawable2 = this.badgeDrawable;
        if (badgeDrawable2 == null) {
            i10 = 0;
        } else {
            i10 = badgeDrawable2.getMinimumWidth() - this.badgeDrawable.getHorizontalOffset();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(i10, layoutParams.leftMargin) + this.icon.getMeasuredWidth() + Math.max(i10, layoutParams.rightMargin);
    }

    private boolean hasBadge() {
        if (this.badgeDrawable != null) {
            return true;
        }
        return false;
    }

    private boolean isActiveIndicatorResizeableAndUnlabeled() {
        if (!this.activeIndicatorResizeable || this.labelVisibilityMode != 2) {
            return false;
        }
        return true;
    }

    private void maybeAnimateActiveIndicatorToProgress(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        if (!this.activeIndicatorEnabled || !this.initialized || !ViewCompat.isAttachedToWindow(this)) {
            setActiveIndicatorProgress(f10, f10);
            return;
        }
        ValueAnimator valueAnimator = this.activeIndicatorAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.activeIndicatorAnimator = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.activeIndicatorProgress, f10});
        this.activeIndicatorAnimator = ofFloat;
        ofFloat.addUpdateListener(new c(f10));
        this.activeIndicatorAnimator.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        this.activeIndicatorAnimator.setDuration((long) MotionUtils.resolveThemeDuration(getContext(), R.attr.motionDurationLong1, getResources().getInteger(R.integer.material_motion_duration_long_1)));
        this.activeIndicatorAnimator.start();
    }

    private void refreshChecked() {
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl != null) {
            setChecked(menuItemImpl.isChecked());
        }
    }

    /* access modifiers changed from: private */
    public void setActiveIndicatorProgress(@FloatRange(from = 0.0d, to = 1.0d) float f10, float f11) {
        View view = this.activeIndicatorView;
        if (view != null) {
            this.activeIndicatorTransform.d(f10, f11, view);
        }
        this.activeIndicatorProgress = f10;
    }

    private static void setTextAppearanceWithoutFontScaling(TextView textView, @StyleRes int i10) {
        TextViewCompat.setTextAppearance(textView, i10);
        int unscaledTextSize = MaterialResources.getUnscaledTextSize(textView.getContext(), i10, 0);
        if (unscaledTextSize != 0) {
            textView.setTextSize(0, (float) unscaledTextSize);
        }
    }

    private static void setViewScaleValues(@NonNull View view, float f10, float f11, int i10) {
        view.setScaleX(f10);
        view.setScaleY(f11);
        view.setVisibility(i10);
    }

    private static void setViewTopMarginAndGravity(@NonNull View view, int i10, int i11) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i10;
        layoutParams.bottomMargin = i10;
        layoutParams.gravity = i11;
        view.setLayoutParams(layoutParams);
    }

    private void tryAttachBadgeToAnchor(@Nullable View view) {
        if (hasBadge() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private void tryRemoveBadgeFromAnchor(@Nullable View view) {
        if (hasBadge()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view);
            }
            this.badgeDrawable = null;
        }
    }

    /* access modifiers changed from: private */
    public void tryUpdateBadgeBounds(View view) {
        if (hasBadge()) {
            BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    /* access modifiers changed from: private */
    public void updateActiveIndicatorLayoutParams(int i10) {
        int i11;
        if (this.activeIndicatorView != null) {
            int min = Math.min(this.activeIndicatorDesiredWidth, i10 - (this.activeIndicatorMarginHorizontal * 2));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.activeIndicatorView.getLayoutParams();
            if (isActiveIndicatorResizeableAndUnlabeled()) {
                i11 = min;
            } else {
                i11 = this.activeIndicatorDesiredHeight;
            }
            layoutParams.height = i11;
            layoutParams.width = min;
            this.activeIndicatorView.setLayoutParams(layoutParams);
        }
    }

    private void updateActiveIndicatorTransform() {
        if (isActiveIndicatorResizeableAndUnlabeled()) {
            this.activeIndicatorTransform = ACTIVE_INDICATOR_UNLABELED_TRANSFORM;
        } else {
            this.activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
        }
    }

    private static void updateViewPaddingBottom(@NonNull View view, int i10) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i10);
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        removeBadge();
        this.itemData = null;
        this.activeIndicatorProgress = 0.0f;
        this.initialized = false;
    }

    @Nullable
    public Drawable getActiveIndicatorDrawable() {
        View view = this.activeIndicatorView;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    /* access modifiers changed from: protected */
    @DrawableRes
    public int getItemBackgroundResId() {
        return R.drawable.mtrl_navigation_bar_item_background;
    }

    @Nullable
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    /* access modifiers changed from: protected */
    @DimenRes
    public int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    /* access modifiers changed from: protected */
    @LayoutRes
    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.itemPosition;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        return getSuggestedIconHeight() + layoutParams.topMargin + this.labelGroup.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.labelGroup.getMeasuredWidth() + layoutParams.rightMargin);
    }

    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i10) {
        CharSequence charSequence;
        int i11;
        this.itemData = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        if (!TextUtils.isEmpty(menuItemImpl.getTooltipText())) {
            charSequence = menuItemImpl.getTooltipText();
        } else {
            charSequence = menuItemImpl.getTitle();
        }
        if (Build.VERSION.SDK_INT > 23) {
            TooltipCompat.setTooltipText(this, charSequence);
        }
        if (menuItemImpl.isVisible()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        setVisibility(i11);
        this.initialized = true;
    }

    @NonNull
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.itemData.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable2 = this.badgeDrawable;
        if (badgeDrawable2 != null && badgeDrawable2.isVisible()) {
            CharSequence title = this.itemData.getTitle();
            if (!TextUtils.isEmpty(this.itemData.getContentDescription())) {
                title = this.itemData.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(title + ", " + this.badgeDrawable.getContentDescription());
        }
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            wrap.setClickable(false);
            wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        wrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        post(new b(i10));
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    public void setActiveIndicatorDrawable(@Nullable Drawable drawable) {
        View view = this.activeIndicatorView;
        if (view != null) {
            view.setBackgroundDrawable(drawable);
        }
    }

    public void setActiveIndicatorEnabled(boolean z10) {
        int i10;
        this.activeIndicatorEnabled = z10;
        View view = this.activeIndicatorView;
        if (view != null) {
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            view.setVisibility(i10);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i10) {
        this.activeIndicatorDesiredHeight = i10;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorMarginHorizontal(@Px int i10) {
        this.activeIndicatorMarginHorizontal = i10;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z10) {
        this.activeIndicatorResizeable = z10;
    }

    public void setActiveIndicatorWidth(int i10) {
        this.activeIndicatorDesiredWidth = i10;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    /* access modifiers changed from: package-private */
    public void setBadge(@NonNull BadgeDrawable badgeDrawable2) {
        if (this.badgeDrawable != badgeDrawable2) {
            if (hasBadge() && this.icon != null) {
                Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
                tryRemoveBadgeFromAnchor(this.icon);
            }
            this.badgeDrawable = badgeDrawable2;
            ImageView imageView = this.icon;
            if (imageView != null) {
                tryAttachBadgeToAnchor(imageView);
            }
        }
    }

    public void setCheckable(boolean z10) {
        refreshDrawableState();
    }

    public void setChecked(boolean z10) {
        float f10;
        TextView textView = this.largeLabel;
        textView.setPivotX((float) (textView.getWidth() / 2));
        TextView textView2 = this.largeLabel;
        textView2.setPivotY((float) textView2.getBaseline());
        TextView textView3 = this.smallLabel;
        textView3.setPivotX((float) (textView3.getWidth() / 2));
        TextView textView4 = this.smallLabel;
        textView4.setPivotY((float) textView4.getBaseline());
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = 0.0f;
        }
        maybeAnimateActiveIndicatorToProgress(f10);
        int i10 = this.labelVisibilityMode;
        if (i10 != -1) {
            if (i10 == 0) {
                if (z10) {
                    setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
                    updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
                    this.largeLabel.setVisibility(0);
                } else {
                    setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
                    updateViewPaddingBottom(this.labelGroup, 0);
                    this.largeLabel.setVisibility(4);
                }
                this.smallLabel.setVisibility(4);
            } else if (i10 == 1) {
                updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
                if (z10) {
                    setViewTopMarginAndGravity(getIconOrContainer(), (int) (((float) this.itemPaddingTop) + this.shiftAmount), 49);
                    setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
                    TextView textView5 = this.smallLabel;
                    float f11 = this.scaleUpFactor;
                    setViewScaleValues(textView5, f11, f11, 4);
                } else {
                    setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
                    TextView textView6 = this.largeLabel;
                    float f12 = this.scaleDownFactor;
                    setViewScaleValues(textView6, f12, f12, 4);
                    setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
                }
            } else if (i10 == 2) {
                setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
                this.largeLabel.setVisibility(8);
                this.smallLabel.setVisibility(8);
            }
        } else if (this.isShifting) {
            if (z10) {
                setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
                updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
                this.largeLabel.setVisibility(0);
            } else {
                setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
                updateViewPaddingBottom(this.labelGroup, 0);
                this.largeLabel.setVisibility(4);
            }
            this.smallLabel.setVisibility(4);
        } else {
            updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
            if (z10) {
                setViewTopMarginAndGravity(getIconOrContainer(), (int) (((float) this.itemPaddingTop) + this.shiftAmount), 49);
                setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
                TextView textView7 = this.smallLabel;
                float f13 = this.scaleUpFactor;
                setViewScaleValues(textView7, f13, f13, 4);
            } else {
                setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
                TextView textView8 = this.largeLabel;
                float f14 = this.scaleDownFactor;
                setViewScaleValues(textView8, f14, f14, 4);
                setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z10);
    }

    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.smallLabel.setEnabled(z10);
        this.largeLabel.setEnabled(z10);
        this.icon.setEnabled(z10);
        if (z10) {
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        } else {
            ViewCompat.setPointerIcon(this, (PointerIconCompat) null);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != this.originalIconDrawable) {
            this.originalIconDrawable = drawable;
            if (drawable != null) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.wrap(drawable).mutate();
                this.wrappedIconDrawable = drawable;
                ColorStateList colorStateList = this.iconTint;
                if (colorStateList != null) {
                    DrawableCompat.setTintList(drawable, colorStateList);
                }
            }
            this.icon.setImageDrawable(drawable);
        }
    }

    public void setIconSize(int i10) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i10;
        this.icon.setLayoutParams(layoutParams);
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        this.iconTint = colorStateList;
        if (this.itemData != null && (drawable = this.wrappedIconDrawable) != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
            this.wrappedIconDrawable.invalidateSelf();
        }
    }

    public void setItemBackground(int i10) {
        setItemBackground(i10 == 0 ? null : ContextCompat.getDrawable(getContext(), i10));
    }

    public void setItemPaddingBottom(int i10) {
        if (this.itemPaddingBottom != i10) {
            this.itemPaddingBottom = i10;
            refreshChecked();
        }
    }

    public void setItemPaddingTop(int i10) {
        if (this.itemPaddingTop != i10) {
            this.itemPaddingTop = i10;
            refreshChecked();
        }
    }

    public void setItemPosition(int i10) {
        this.itemPosition = i10;
    }

    public void setLabelVisibilityMode(int i10) {
        if (this.labelVisibilityMode != i10) {
            this.labelVisibilityMode = i10;
            updateActiveIndicatorTransform();
            updateActiveIndicatorLayoutParams(getWidth());
            refreshChecked();
        }
    }

    public void setShifting(boolean z10) {
        if (this.isShifting != z10) {
            this.isShifting = z10;
            refreshChecked();
        }
    }

    public void setShortcut(boolean z10, char c10) {
    }

    public void setTextAppearanceActive(@StyleRes int i10) {
        setTextAppearanceWithoutFontScaling(this.largeLabel, i10);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceInactive(@StyleRes int i10) {
        setTextAppearanceWithoutFontScaling(this.smallLabel, i10);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.smallLabel.setTextColor(colorStateList);
            this.largeLabel.setTextColor(colorStateList);
        }
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.itemData;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.itemData.getTooltipText();
        }
        if (Build.VERSION.SDK_INT > 23) {
            TooltipCompat.setTooltipText(this, charSequence);
        }
    }

    public boolean showsIcon() {
        return true;
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (!(drawable == null || drawable.getConstantState() == null)) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        ViewCompat.setBackground(this, drawable);
    }
}
