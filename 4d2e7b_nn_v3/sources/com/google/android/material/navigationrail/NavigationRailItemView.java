package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class NavigationRailItemView extends NavigationBarItemView {
    public NavigationRailItemView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_rail_icon_margin;
    }

    /* access modifiers changed from: protected */
    public int getItemLayoutResId() {
        return R.layout.mtrl_navigation_rail_item;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i11) == 0) {
            setMeasuredDimension(getMeasuredWidthAndState(), View.resolveSizeAndState(Math.max(getMeasuredHeight(), View.MeasureSpec.getSize(i11)), i11, 0));
        }
    }
}
