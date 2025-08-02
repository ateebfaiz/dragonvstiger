package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNavigationView extends NavigationBarView {
    static final int MAX_ITEM_COUNT = 5;

    @Deprecated
    public interface OnNavigationItemReselectedListener extends NavigationBarView.OnItemReselectedListener {
    }

    @Deprecated
    public interface OnNavigationItemSelectedListener extends NavigationBarView.OnItemSelectedListener {
    }

    class a implements ViewUtils.OnApplyWindowInsetsListener {
        a() {
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
            int i10;
            relativePadding.bottom += windowInsetsCompat.getSystemWindowInsetBottom();
            boolean z10 = true;
            if (ViewCompat.getLayoutDirection(view) != 1) {
                z10 = false;
            }
            int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
            int systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
            int i11 = relativePadding.start;
            if (z10) {
                i10 = systemWindowInsetRight;
            } else {
                i10 = systemWindowInsetLeft;
            }
            relativePadding.start = i11 + i10;
            int i12 = relativePadding.end;
            if (!z10) {
                systemWindowInsetLeft = systemWindowInsetRight;
            }
            relativePadding.end = i12 + systemWindowInsetLeft;
            relativePadding.applyToView(view);
            return windowInsetsCompat;
        }
    }

    public BottomNavigationView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void addCompatibilityTopDivider(@NonNull Context context) {
        View view = new View(context);
        view.setBackgroundColor(ContextCompat.getColor(context, R.color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new a());
    }

    private int makeMinHeightSpec(int i10) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i10) == 1073741824 || suggestedMinimumHeight <= 0) {
            return i10;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), suggestedMinimumHeight + getPaddingTop() + getPaddingBottom()), 1073741824);
    }

    private boolean shouldDrawCompatibilityTopDivider() {
        return false;
    }

    /* access modifiers changed from: protected */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationBarMenuView createNavigationBarMenuView(@NonNull Context context) {
        return new BottomNavigationMenuView(context);
    }

    public int getMaxItemCount() {
        return 5;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return ((BottomNavigationMenuView) getMenuView()).isItemHorizontalTranslationEnabled();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, makeMinHeightSpec(i11));
    }

    public void setItemHorizontalTranslationEnabled(boolean z10) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) getMenuView();
        if (bottomNavigationMenuView.isItemHorizontalTranslationEnabled() != z10) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z10);
            getPresenter().updateMenuView(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(@Nullable OnNavigationItemReselectedListener onNavigationItemReselectedListener) {
        setOnItemReselectedListener(onNavigationItemReselectedListener);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        setOnItemSelectedListener(onNavigationItemSelectedListener);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, R.style.Widget_Design_BottomNavigationView);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        Context context2 = getContext();
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.BottomNavigationView, i10, i11, new int[0]);
        setItemHorizontalTranslationEnabled(obtainTintedStyledAttributes.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        if (obtainTintedStyledAttributes.hasValue(R.styleable.BottomNavigationView_android_minHeight)) {
            setMinimumHeight(obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.BottomNavigationView_android_minHeight, 0));
        }
        obtainTintedStyledAttributes.recycle();
        if (shouldDrawCompatibilityTopDivider()) {
            addCompatibilityTopDivider(context2);
        }
        applyWindowInsets();
    }
}
