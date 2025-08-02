package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationRailMenuView extends NavigationBarMenuView {
    @Px
    private int itemMinimumHeight = -1;
    private final FrameLayout.LayoutParams layoutParams;

    public NavigationRailMenuView(@NonNull Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        this.layoutParams = layoutParams2;
        layoutParams2.gravity = 49;
        setLayoutParams(layoutParams2);
        setItemActiveIndicatorResizeable(true);
    }

    private int makeSharedHeightSpec(int i10, int i11, int i12) {
        int max = i11 / Math.max(1, i12);
        int i13 = this.itemMinimumHeight;
        if (i13 == -1) {
            i13 = View.MeasureSpec.getSize(i10);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(i13, max), 0);
    }

    private int measureChildHeight(View view, int i10, int i11) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        view.measure(i10, i11);
        return view.getMeasuredHeight();
    }

    private int measureSharedChildHeights(int i10, int i11, int i12, View view) {
        int i13;
        makeSharedHeightSpec(i10, i11, i12);
        if (view == null) {
            i13 = makeSharedHeightSpec(i10, i11, i12);
        } else {
            i13 = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int childCount = getChildCount();
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt != view) {
                i14 += measureChildHeight(childAt, i10, i13);
            }
        }
        return i14;
    }

    private int measureShiftingChildHeights(int i10, int i11, int i12) {
        int i13;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            i13 = measureChildHeight(childAt, i10, makeSharedHeightSpec(i10, i11, i12));
            i11 -= i13;
            i12--;
        } else {
            i13 = 0;
        }
        return i13 + measureSharedChildHeights(i10, i11, i12, childAt);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public NavigationBarItemView createNavigationBarItemView(@NonNull Context context) {
        return new NavigationRailItemView(context);
    }

    @Px
    public int getItemMinimumHeight() {
        return this.itemMinimumHeight;
    }

    /* access modifiers changed from: package-private */
    public int getMenuGravity() {
        return this.layoutParams.gravity;
    }

    /* access modifiers changed from: package-private */
    public boolean isTopGravity() {
        if ((this.layoutParams.gravity & 112) == 48) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int i14 = i12 - i10;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i15;
                childAt.layout(0, i15, i14, measuredHeight);
                i15 = measuredHeight;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int i12;
        int size = View.MeasureSpec.getSize(i11);
        int size2 = getMenu().getVisibleItems().size();
        if (size2 <= 1 || !isShifting(getLabelVisibilityMode(), size2)) {
            i12 = measureSharedChildHeights(i10, size, size2, (View) null);
        } else {
            i12 = measureShiftingChildHeights(i10, size, size2);
        }
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i10), i10, 0), View.resolveSizeAndState(i12, i11, 0));
    }

    public void setItemMinimumHeight(@Px int i10) {
        if (this.itemMinimumHeight != i10) {
            this.itemMinimumHeight = i10;
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void setMenuGravity(int i10) {
        FrameLayout.LayoutParams layoutParams2 = this.layoutParams;
        if (layoutParams2.gravity != i10) {
            layoutParams2.gravity = i10;
            setLayoutParams(layoutParams2);
        }
    }
}
