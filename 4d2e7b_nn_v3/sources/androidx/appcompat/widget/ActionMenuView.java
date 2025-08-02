package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty
        public int cellsUsed;
        @ViewDebug.ExportedProperty
        public boolean expandable;
        boolean expanded;
        @ViewDebug.ExportedProperty
        public int extraPixels;
        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;
        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.isOverflowButton = false;
        }

        LayoutParams(int i10, int i11, boolean z10) {
            super(i10, i11);
            this.isOverflowButton = z10;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    private static class a implements MenuPresenter.Callback {
        a() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            return false;
        }
    }

    private class b implements MenuBuilder.Callback {
        b() {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = ActionMenuView.this.mOnMenuItemClickListener;
            if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(menuItem)) {
                return false;
            }
            return true;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            MenuBuilder.Callback callback = ActionMenuView.this.mMenuBuilderCallback;
            if (callback != null) {
                callback.onMenuModeChange(menuBuilder);
            }
        }
    }

    public ActionMenuView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    static int measureChildForCells(View view, int i10, int i11, int i12, int i13) {
        ActionMenuItemView actionMenuItemView;
        boolean z10;
        int i14;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i12) - i13, View.MeasureSpec.getMode(i12));
        if (view instanceof ActionMenuItemView) {
            actionMenuItemView = (ActionMenuItemView) view;
        } else {
            actionMenuItemView = null;
        }
        boolean z11 = false;
        if (actionMenuItemView == null || !actionMenuItemView.hasText()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (i11 > 0) {
            i14 = 2;
            if (!z10 || i11 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i11 * i10, Integer.MIN_VALUE), makeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i15 = measuredWidth / i10;
                if (measuredWidth % i10 != 0) {
                    i15++;
                }
                if (!z10 || i15 >= 2) {
                    i14 = i15;
                }
                if (!layoutParams.isOverflowButton && z10) {
                    z11 = true;
                }
                layoutParams.expandable = z11;
                layoutParams.cellsUsed = i14;
                view.measure(View.MeasureSpec.makeMeasureSpec(i10 * i14, 1073741824), makeMeasureSpec);
                return i14;
            }
        }
        i14 = 0;
        z11 = true;
        layoutParams.expandable = z11;
        layoutParams.cellsUsed = i14;
        view.measure(View.MeasureSpec.makeMeasureSpec(i10 * i14, 1073741824), makeMeasureSpec);
        return i14;
    }

    private void onMeasureExactFormat(int i10, int i11) {
        boolean z10;
        int i12;
        boolean z11;
        int i13;
        int i14;
        boolean z12;
        int i15;
        boolean z13;
        int i16;
        int i17;
        boolean z14;
        int i18;
        boolean z15;
        boolean z16;
        int i19;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
        int i20 = size - paddingLeft;
        int i21 = this.mMinCellSize;
        int i22 = i20 / i21;
        int i23 = i20 % i21;
        if (i22 == 0) {
            setMeasuredDimension(i20, 0);
            return;
        }
        int i24 = i21 + (i23 / i22);
        int childCount = getChildCount();
        int i25 = 0;
        int i26 = 0;
        boolean z17 = false;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        long j10 = 0;
        while (i26 < childCount) {
            View childAt = getChildAt(i26);
            int i30 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z18 = childAt instanceof ActionMenuItemView;
                int i31 = i27 + 1;
                if (z18) {
                    int i32 = this.mGeneratedItemPadding;
                    i18 = i31;
                    z15 = false;
                    childAt.setPadding(i32, 0, i32, 0);
                } else {
                    i18 = i31;
                    z15 = false;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.expanded = z15;
                layoutParams.extraPixels = z15 ? 1 : 0;
                layoutParams.cellsUsed = z15;
                layoutParams.expandable = z15;
                layoutParams.leftMargin = z15;
                layoutParams.rightMargin = z15;
                if (!z18 || !((ActionMenuItemView) childAt).hasText()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                layoutParams.preventEdgeOffset = z16;
                if (layoutParams.isOverflowButton) {
                    i19 = 1;
                } else {
                    i19 = i22;
                }
                int measureChildForCells = measureChildForCells(childAt, i24, i19, childMeasureSpec, paddingTop);
                i28 = Math.max(i28, measureChildForCells);
                if (layoutParams.expandable) {
                    i29++;
                }
                if (layoutParams.isOverflowButton) {
                    z17 = true;
                }
                i22 -= measureChildForCells;
                i25 = Math.max(i25, childAt.getMeasuredHeight());
                if (measureChildForCells == 1) {
                    j10 |= (long) (1 << i26);
                    i25 = i25;
                } else {
                    int i33 = i25;
                }
                i27 = i18;
            }
            i26++;
            size2 = i30;
        }
        int i34 = size2;
        if (!z17 || i27 != 2) {
            z10 = false;
        } else {
            z10 = true;
        }
        boolean z19 = false;
        while (true) {
            if (i29 <= 0 || i22 <= 0) {
                i14 = mode;
                i12 = i20;
                z11 = z19;
                i13 = i25;
            } else {
                int i35 = Integer.MAX_VALUE;
                int i36 = 0;
                int i37 = 0;
                long j11 = 0;
                while (i37 < childCount) {
                    boolean z20 = z19;
                    LayoutParams layoutParams2 = (LayoutParams) getChildAt(i37).getLayoutParams();
                    int i38 = i25;
                    if (layoutParams2.expandable) {
                        int i39 = layoutParams2.cellsUsed;
                        if (i39 < i35) {
                            j11 = 1 << i37;
                            i35 = i39;
                            i36 = 1;
                        } else if (i39 == i35) {
                            i36++;
                            j11 |= 1 << i37;
                        }
                    }
                    i37++;
                    i25 = i38;
                    z19 = z20;
                }
                z11 = z19;
                i13 = i25;
                j10 |= j11;
                if (i36 > i22) {
                    i14 = mode;
                    i12 = i20;
                    break;
                }
                int i40 = i35 + 1;
                int i41 = 0;
                while (i41 < childCount) {
                    View childAt2 = getChildAt(i41);
                    LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                    int i42 = i20;
                    int i43 = mode;
                    long j12 = (long) (1 << i41);
                    if ((j11 & j12) == 0) {
                        if (layoutParams3.cellsUsed == i40) {
                            j10 |= j12;
                        }
                        z14 = z10;
                    } else {
                        if (!z10 || !layoutParams3.preventEdgeOffset || i22 != 1) {
                            z14 = z10;
                        } else {
                            int i44 = this.mGeneratedItemPadding;
                            z14 = z10;
                            childAt2.setPadding(i44 + i24, 0, i44, 0);
                        }
                        layoutParams3.cellsUsed++;
                        layoutParams3.expanded = true;
                        i22--;
                    }
                    i41++;
                    mode = i43;
                    i20 = i42;
                    z10 = z14;
                }
                i25 = i13;
                z19 = true;
            }
        }
        if (z17 || i27 != 1) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (i22 <= 0 || j10 == 0 || (i22 >= i27 - 1 && !z12 && i28 <= 1)) {
            i15 = 0;
            z13 = z11;
        } else {
            float bitCount = (float) Long.bitCount(j10);
            if (!z12) {
                i15 = 0;
                if ((j10 & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                    bitCount -= 0.5f;
                }
                int i45 = childCount - 1;
                if ((j10 & ((long) (1 << i45))) != 0 && !((LayoutParams) getChildAt(i45).getLayoutParams()).preventEdgeOffset) {
                    bitCount -= 0.5f;
                }
            } else {
                i15 = 0;
            }
            if (bitCount > 0.0f) {
                i17 = (int) (((float) (i22 * i24)) / bitCount);
            } else {
                i17 = i15;
            }
            z13 = z11;
            for (int i46 = i15; i46 < childCount; i46++) {
                if ((j10 & ((long) (1 << i46))) != 0) {
                    View childAt3 = getChildAt(i46);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.extraPixels = i17;
                        layoutParams4.expanded = true;
                        if (i46 == 0 && !layoutParams4.preventEdgeOffset) {
                            layoutParams4.leftMargin = (-i17) / 2;
                        }
                        z13 = true;
                    } else if (layoutParams4.isOverflowButton) {
                        layoutParams4.extraPixels = i17;
                        layoutParams4.expanded = true;
                        layoutParams4.rightMargin = (-i17) / 2;
                        z13 = true;
                    } else {
                        if (i46 != 0) {
                            layoutParams4.leftMargin = i17 / 2;
                        }
                        if (i46 != childCount - 1) {
                            layoutParams4.rightMargin = i17 / 2;
                        }
                    }
                }
            }
        }
        if (z13) {
            for (int i47 = i15; i47 < childCount; i47++) {
                View childAt4 = getChildAt(i47);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.expanded) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.cellsUsed * i24) + layoutParams5.extraPixels, 1073741824), childMeasureSpec);
                }
            }
        }
        if (i14 != 1073741824) {
            i16 = i13;
        } else {
            i16 = i34;
        }
        setMeasuredDimension(i12, i16);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.h();
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.isOverflowButton = true;
        return generateDefaultLayoutParams;
    }

    public Menu getMenu() {
        if (this.mMenu == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.mMenu = menuBuilder;
            menuBuilder.setCallback(new b());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.mPresenter = actionMenuPresenter;
            actionMenuPresenter.t(true);
            ActionMenuPresenter actionMenuPresenter2 = this.mPresenter;
            MenuPresenter.Callback callback = this.mActionMenuPresenterCallback;
            if (callback == null) {
                callback = new a();
            }
            actionMenuPresenter2.setCallback(callback);
            this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
            this.mPresenter.r(this);
        }
        return this.mMenu;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.mPresenter.j();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getWindowAnimations() {
        return 0;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean hasSupportDividerBeforeChildAt(int i10) {
        boolean z10 = false;
        if (i10 == 0) {
            return false;
        }
        View childAt = getChildAt(i10 - 1);
        View childAt2 = getChildAt(i10);
        if (i10 < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z10 = ((ActionMenuChildView) childAt).needsDividerAfter();
        }
        if (i10 <= 0 || !(childAt2 instanceof ActionMenuChildView)) {
            return z10;
        }
        return z10 | ((ActionMenuChildView) childAt2).needsDividerBefore();
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter == null || !actionMenuPresenter.k()) {
            return false;
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter == null || !actionMenuPresenter.m()) {
            return false;
        }
        return true;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter == null || !actionMenuPresenter.n()) {
            return false;
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.mPresenter.n()) {
                this.mPresenter.k();
                this.mPresenter.u();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        if (!this.mFormatItems) {
            super.onLayout(z10, i10, i11, i12, i13);
            return;
        }
        int childCount = getChildCount();
        int i17 = (i13 - i11) / 2;
        int dividerWidth = getDividerWidth();
        int i18 = i12 - i10;
        int paddingRight = (i18 - getPaddingRight()) - getPaddingLeft();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i19 = 0;
        int i20 = 0;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt = getChildAt(i21);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isOverflowButton) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i21)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (isLayoutRtl) {
                        i15 = getPaddingLeft() + layoutParams.leftMargin;
                        i16 = i15 + measuredWidth;
                    } else {
                        i16 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i15 = i16 - measuredWidth;
                    }
                    int i22 = i17 - (measuredHeight / 2);
                    childAt.layout(i15, i22, i16, measuredHeight + i22);
                    paddingRight -= measuredWidth;
                    i19 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    hasSupportDividerBeforeChildAt(i21);
                    i20++;
                }
            }
        }
        if (childCount == 1 && i19 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i23 = (i18 / 2) - (measuredWidth2 / 2);
            int i24 = i17 - (measuredHeight2 / 2);
            childAt2.layout(i23, i24, measuredWidth2 + i23, measuredHeight2 + i24);
            return;
        }
        int i25 = i20 - (i19 ^ 1);
        if (i25 > 0) {
            i14 = paddingRight / i25;
        } else {
            i14 = 0;
        }
        int max = Math.max(0, i14);
        if (isLayoutRtl) {
            int width = getWidth() - getPaddingRight();
            for (int i26 = 0; i26 < childCount; i26++) {
                View childAt3 = getChildAt(i26);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.isOverflowButton) {
                    int i27 = width - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i28 = i17 - (measuredHeight3 / 2);
                    childAt3.layout(i27 - measuredWidth3, i28, i27, measuredHeight3 + i28);
                    width = i27 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i29 = 0; i29 < childCount; i29++) {
            View childAt4 = getChildAt(i29);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.isOverflowButton) {
                int i30 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i31 = i17 - (measuredHeight4 / 2);
                childAt4.layout(i30, i31, i30 + measuredWidth4, measuredHeight4 + i31);
                paddingLeft = i30 + measuredWidth4 + layoutParams3.rightMargin + max;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        boolean z10;
        MenuBuilder menuBuilder;
        boolean z11 = this.mFormatItems;
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.mFormatItems = z10;
        if (z11 != z10) {
            this.mFormatItemsWidth = 0;
        }
        int size = View.MeasureSpec.getSize(i10);
        if (!(!this.mFormatItems || (menuBuilder = this.mMenu) == null || size == this.mFormatItemsWidth)) {
            this.mFormatItemsWidth = size;
            menuBuilder.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.mFormatItems || childCount <= 0) {
            for (int i12 = 0; i12 < childCount; i12++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i12).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i10, i11);
            return;
        }
        onMeasureExactFormat(i10, i11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setExpandedActionViewsExclusive(boolean z10) {
        this.mPresenter.q(z10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        this.mPresenter.s(drawable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverflowReserved(boolean z10) {
        this.mReserveOverflow = z10;
    }

    public void setPopupTheme(@StyleRes int i10) {
        if (this.mPopupTheme != i10) {
            this.mPopupTheme = i10;
            if (i10 == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        actionMenuPresenter.r(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter == null || !actionMenuPresenter.u()) {
            return false;
        }
        return true;
    }

    public ActionMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f10);
        this.mGeneratedItemPadding = (int) (f10 * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        if (layoutParams instanceof LayoutParams) {
            layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
        } else {
            layoutParams2 = new LayoutParams(layoutParams);
        }
        if (layoutParams2.gravity <= 0) {
            layoutParams2.gravity = 16;
        }
        return layoutParams2;
    }
}
