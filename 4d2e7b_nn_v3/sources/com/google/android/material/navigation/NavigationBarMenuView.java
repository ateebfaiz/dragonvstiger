package com.google.android.material.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.HashSet;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int ITEM_POOL_SIZE = 5;
    private static final int NO_PADDING = -1;
    @NonNull
    private final SparseArray<BadgeDrawable> badgeDrawables = new SparseArray<>(5);
    @Nullable
    private NavigationBarItemView[] buttons;
    private ColorStateList itemActiveIndicatorColor;
    private boolean itemActiveIndicatorEnabled;
    private int itemActiveIndicatorHeight;
    private int itemActiveIndicatorMarginHorizontal;
    private boolean itemActiveIndicatorResizeable = false;
    private ShapeAppearanceModel itemActiveIndicatorShapeAppearance;
    private int itemActiveIndicatorWidth;
    private Drawable itemBackground;
    private int itemBackgroundRes;
    @Dimension
    private int itemIconSize;
    @Nullable
    private ColorStateList itemIconTint;
    private int itemPaddingBottom = -1;
    private int itemPaddingTop = -1;
    private final Pools.Pool<NavigationBarItemView> itemPool = new Pools.SynchronizedPool(5);
    @StyleRes
    private int itemTextAppearanceActive;
    @StyleRes
    private int itemTextAppearanceInactive;
    @Nullable
    private final ColorStateList itemTextColorDefault = createDefaultColorStateList(16842808);
    private ColorStateList itemTextColorFromUser;
    private int labelVisibilityMode;
    /* access modifiers changed from: private */
    public MenuBuilder menu;
    @NonNull
    private final View.OnClickListener onClickListener;
    @NonNull
    private final SparseArray<View.OnTouchListener> onTouchListeners = new SparseArray<>(5);
    /* access modifiers changed from: private */
    public NavigationBarPresenter presenter;
    private int selectedItemId = 0;
    private int selectedItemPosition = 0;
    @Nullable
    private final TransitionSet set;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            MenuItemImpl itemData = ((NavigationBarItemView) view).getItemData();
            if (!NavigationBarMenuView.this.menu.performItemAction(itemData, NavigationBarMenuView.this.presenter, 0)) {
                itemData.setChecked(true);
            }
        }
    }

    public NavigationBarMenuView(@NonNull Context context) {
        super(context);
        if (isInEditMode()) {
            this.set = null;
        } else {
            AutoTransition autoTransition = new AutoTransition();
            this.set = autoTransition;
            autoTransition.setOrdering(0);
            autoTransition.setDuration((long) MotionUtils.resolveThemeDuration(getContext(), R.attr.motionDurationLong1, getResources().getInteger(R.integer.material_motion_duration_long_1)));
            autoTransition.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            autoTransition.addTransition(new TextScale());
        }
        this.onClickListener = new a();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    @Nullable
    private Drawable createItemActiveIndicatorDrawable() {
        if (this.itemActiveIndicatorShapeAppearance == null || this.itemActiveIndicatorColor == null) {
            return null;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.itemActiveIndicatorShapeAppearance);
        materialShapeDrawable.setFillColor(this.itemActiveIndicatorColor);
        return materialShapeDrawable;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView acquire = this.itemPool.acquire();
        if (acquire == null) {
            return createNavigationBarItemView(getContext());
        }
        return acquire;
    }

    private boolean isValidId(int i10) {
        return i10 != -1;
    }

    private void removeUnusedBadges() {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < this.menu.size(); i10++) {
            hashSet.add(Integer.valueOf(this.menu.getItem(i10).getItemId()));
        }
        for (int i11 = 0; i11 < this.badgeDrawables.size(); i11++) {
            int keyAt = this.badgeDrawables.keyAt(i11);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.badgeDrawables.delete(keyAt);
            }
        }
    }

    private void setBadgeIfNeeded(@NonNull NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id2 = navigationBarItemView.getId();
        if (isValidId(id2) && (badgeDrawable = this.badgeDrawables.get(id2)) != null) {
            navigationBarItemView.setBadge(badgeDrawable);
        }
    }

    private void validateMenuItemId(int i10) {
        if (!isValidId(i10)) {
            throw new IllegalArgumentException(i10 + " is not a valid view id");
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void buildMenuView() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.itemPool.release(navigationBarItemView);
                    navigationBarItemView.clear();
                }
            }
        }
        if (this.menu.size() == 0) {
            this.selectedItemId = 0;
            this.selectedItemPosition = 0;
            this.buttons = null;
            return;
        }
        removeUnusedBadges();
        this.buttons = new NavigationBarItemView[this.menu.size()];
        boolean isShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        for (int i10 = 0; i10 < this.menu.size(); i10++) {
            this.presenter.setUpdateSuspended(true);
            this.menu.getItem(i10).setCheckable(true);
            this.presenter.setUpdateSuspended(false);
            NavigationBarItemView newItem = getNewItem();
            this.buttons[i10] = newItem;
            newItem.setIconTintList(this.itemIconTint);
            newItem.setIconSize(this.itemIconSize);
            newItem.setTextColor(this.itemTextColorDefault);
            newItem.setTextAppearanceInactive(this.itemTextAppearanceInactive);
            newItem.setTextAppearanceActive(this.itemTextAppearanceActive);
            newItem.setTextColor(this.itemTextColorFromUser);
            int i11 = this.itemPaddingTop;
            if (i11 != -1) {
                newItem.setItemPaddingTop(i11);
            }
            int i12 = this.itemPaddingBottom;
            if (i12 != -1) {
                newItem.setItemPaddingBottom(i12);
            }
            newItem.setActiveIndicatorWidth(this.itemActiveIndicatorWidth);
            newItem.setActiveIndicatorHeight(this.itemActiveIndicatorHeight);
            newItem.setActiveIndicatorMarginHorizontal(this.itemActiveIndicatorMarginHorizontal);
            newItem.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
            newItem.setActiveIndicatorResizeable(this.itemActiveIndicatorResizeable);
            newItem.setActiveIndicatorEnabled(this.itemActiveIndicatorEnabled);
            Drawable drawable = this.itemBackground;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.itemBackgroundRes);
            }
            newItem.setShifting(isShifting);
            newItem.setLabelVisibilityMode(this.labelVisibilityMode);
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.menu.getItem(i10);
            newItem.initialize(menuItemImpl, 0);
            newItem.setItemPosition(i10);
            int itemId = menuItemImpl.getItemId();
            newItem.setOnTouchListener(this.onTouchListeners.get(itemId));
            newItem.setOnClickListener(this.onClickListener);
            int i13 = this.selectedItemId;
            if (i13 != 0 && itemId == i13) {
                this.selectedItemPosition = i10;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.menu.size() - 1, this.selectedItemPosition);
        this.selectedItemPosition = min;
        this.menu.getItem(min).setChecked(true);
    }

    @Nullable
    public ColorStateList createDefaultColorStateList(int i10) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i10, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i11 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i11, defaultColor});
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract NavigationBarItemView createNavigationBarItemView(@NonNull Context context);

    @Nullable
    public NavigationBarItemView findItemView(int i10) {
        validateMenuItemId(i10);
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr == null) {
            return null;
        }
        for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
            if (navigationBarItemView.getId() == i10) {
                return navigationBarItemView;
            }
        }
        return null;
    }

    @Nullable
    public BadgeDrawable getBadge(int i10) {
        return this.badgeDrawables.get(i10);
    }

    /* access modifiers changed from: package-private */
    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.badgeDrawables;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.itemActiveIndicatorColor;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.itemActiveIndicatorEnabled;
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.itemActiveIndicatorHeight;
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.itemActiveIndicatorMarginHorizontal;
    }

    @Nullable
    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.itemActiveIndicatorShapeAppearance;
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.itemActiveIndicatorWidth;
    }

    @Nullable
    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr == null || navigationBarItemViewArr.length <= 0) {
            return this.itemBackground;
        }
        return navigationBarItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    @Dimension
    public int getItemIconSize() {
        return this.itemIconSize;
    }

    @Px
    public int getItemPaddingBottom() {
        return this.itemPaddingBottom;
    }

    @Px
    public int getItemPaddingTop() {
        return this.itemPaddingTop;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public MenuBuilder getMenu() {
        return this.menu;
    }

    /* access modifiers changed from: package-private */
    public BadgeDrawable getOrCreateBadge(int i10) {
        validateMenuItemId(i10);
        BadgeDrawable badgeDrawable = this.badgeDrawables.get(i10);
        if (badgeDrawable == null) {
            badgeDrawable = BadgeDrawable.create(getContext());
            this.badgeDrawables.put(i10, badgeDrawable);
        }
        NavigationBarItemView findItemView = findItemView(i10);
        if (findItemView != null) {
            findItemView.setBadge(badgeDrawable);
        }
        return badgeDrawable;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    /* access modifiers changed from: protected */
    public int getSelectedItemPosition() {
        return this.selectedItemPosition;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void initialize(@NonNull MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
    }

    /* access modifiers changed from: protected */
    public boolean isItemActiveIndicatorResizeable() {
        return this.itemActiveIndicatorResizeable;
    }

    /* access modifiers changed from: protected */
    public boolean isShifting(int i10, int i11) {
        if (i10 == -1) {
            if (i11 <= 3) {
                return false;
            }
        } else if (i10 != 0) {
            return false;
        }
        return true;
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.menu.getVisibleItems().size(), false, 1));
    }

    /* access modifiers changed from: package-private */
    public void removeBadge(int i10) {
        validateMenuItemId(i10);
        BadgeDrawable badgeDrawable = this.badgeDrawables.get(i10);
        NavigationBarItemView findItemView = findItemView(i10);
        if (findItemView != null) {
            findItemView.removeBadge();
        }
        if (badgeDrawable != null) {
            this.badgeDrawables.remove(i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void restoreBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            int keyAt = sparseArray.keyAt(i10);
            if (this.badgeDrawables.indexOfKey(keyAt) < 0) {
                this.badgeDrawables.append(keyAt, sparseArray.get(keyAt));
            }
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setBadge(this.badgeDrawables.get(navigationBarItemView.getId()));
            }
        }
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        this.itemIconTint = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView iconTintList : navigationBarItemViewArr) {
                iconTintList.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.itemActiveIndicatorColor = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView activeIndicatorDrawable : navigationBarItemViewArr) {
                activeIndicatorDrawable.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z10) {
        this.itemActiveIndicatorEnabled = z10;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView activeIndicatorEnabled : navigationBarItemViewArr) {
                activeIndicatorEnabled.setActiveIndicatorEnabled(z10);
            }
        }
    }

    public void setItemActiveIndicatorHeight(@Px int i10) {
        this.itemActiveIndicatorHeight = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView activeIndicatorHeight : navigationBarItemViewArr) {
                activeIndicatorHeight.setActiveIndicatorHeight(i10);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int i10) {
        this.itemActiveIndicatorMarginHorizontal = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView activeIndicatorMarginHorizontal : navigationBarItemViewArr) {
                activeIndicatorMarginHorizontal.setActiveIndicatorMarginHorizontal(i10);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setItemActiveIndicatorResizeable(boolean z10) {
        this.itemActiveIndicatorResizeable = z10;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView activeIndicatorResizeable : navigationBarItemViewArr) {
                activeIndicatorResizeable.setActiveIndicatorResizeable(z10);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.itemActiveIndicatorShapeAppearance = shapeAppearanceModel;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView activeIndicatorDrawable : navigationBarItemViewArr) {
                activeIndicatorDrawable.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
            }
        }
    }

    public void setItemActiveIndicatorWidth(@Px int i10) {
        this.itemActiveIndicatorWidth = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView activeIndicatorWidth : navigationBarItemViewArr) {
                activeIndicatorWidth.setActiveIndicatorWidth(i10);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.itemBackground = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView itemBackground2 : navigationBarItemViewArr) {
                itemBackground2.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i10) {
        this.itemBackgroundRes = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView itemBackground2 : navigationBarItemViewArr) {
                itemBackground2.setItemBackground(i10);
            }
        }
    }

    public void setItemIconSize(@Dimension int i10) {
        this.itemIconSize = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView iconSize : navigationBarItemViewArr) {
                iconSize.setIconSize(i10);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int i10, @Nullable View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.onTouchListeners.remove(i10);
        } else {
            this.onTouchListeners.put(i10, onTouchListener);
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView.getItemData().getItemId() == i10) {
                    navigationBarItemView.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setItemPaddingBottom(@Px int i10) {
        this.itemPaddingBottom = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView itemPaddingBottom2 : navigationBarItemViewArr) {
                itemPaddingBottom2.setItemPaddingBottom(i10);
            }
        }
    }

    public void setItemPaddingTop(@Px int i10) {
        this.itemPaddingTop = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView itemPaddingTop2 : navigationBarItemViewArr) {
                itemPaddingTop2.setItemPaddingTop(i10);
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i10) {
        this.itemTextAppearanceActive = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i10);
                ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i10) {
        this.itemTextAppearanceInactive = i10;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i10);
                ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.itemTextColorFromUser = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView textColor : navigationBarItemViewArr) {
                textColor.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i10) {
        this.labelVisibilityMode = i10;
    }

    public void setPresenter(@NonNull NavigationBarPresenter navigationBarPresenter) {
        this.presenter = navigationBarPresenter;
    }

    /* access modifiers changed from: package-private */
    public void tryRestoreSelectedItemId(int i10) {
        int size = this.menu.size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = this.menu.getItem(i11);
            if (i10 == item.getItemId()) {
                this.selectedItemId = i10;
                this.selectedItemPosition = i11;
                item.setChecked(true);
                return;
            }
        }
    }

    public void updateMenuView() {
        TransitionSet transitionSet;
        MenuBuilder menuBuilder = this.menu;
        if (menuBuilder != null && this.buttons != null) {
            int size = menuBuilder.size();
            if (size != this.buttons.length) {
                buildMenuView();
                return;
            }
            int i10 = this.selectedItemId;
            for (int i11 = 0; i11 < size; i11++) {
                MenuItem item = this.menu.getItem(i11);
                if (item.isChecked()) {
                    this.selectedItemId = item.getItemId();
                    this.selectedItemPosition = i11;
                }
            }
            if (!(i10 == this.selectedItemId || (transitionSet = this.set) == null)) {
                TransitionManager.beginDelayedTransition(this, transitionSet);
            }
            boolean isShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
            for (int i12 = 0; i12 < size; i12++) {
                this.presenter.setUpdateSuspended(true);
                this.buttons[i12].setLabelVisibilityMode(this.labelVisibilityMode);
                this.buttons[i12].setShifting(isShifting);
                this.buttons[i12].initialize((MenuItemImpl) this.menu.getItem(i12), 0);
                this.presenter.setUpdateSuspended(false);
            }
        }
    }
}
