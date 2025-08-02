package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.tabs.TabLayout;

class c {
    c() {
    }

    static RectF a(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.isTabIndicatorFullWidth() || !(view instanceof TabLayout.TabView)) {
            return new RectF((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
        }
        return b((TabLayout.TabView) view, 24);
    }

    static RectF b(TabLayout.TabView tabView, int i10) {
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int dpToPx = (int) ViewUtils.dpToPx(tabView.getContext(), i10);
        if (contentWidth < dpToPx) {
            contentWidth = dpToPx;
        }
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i11 = contentWidth / 2;
        return new RectF((float) (left - i11), (float) (top - (contentHeight / 2)), (float) (i11 + left), (float) (top + (left / 2)));
    }

    /* access modifiers changed from: package-private */
    public void c(TabLayout tabLayout, View view, Drawable drawable) {
        RectF a10 = a(tabLayout, view);
        drawable.setBounds((int) a10.left, drawable.getBounds().top, (int) a10.right, drawable.getBounds().bottom);
    }

    /* access modifiers changed from: package-private */
    public void d(TabLayout tabLayout, View view, View view2, float f10, Drawable drawable) {
        RectF a10 = a(tabLayout, view);
        RectF a11 = a(tabLayout, view2);
        drawable.setBounds(AnimationUtils.lerp((int) a10.left, (int) a11.left, f10), drawable.getBounds().top, AnimationUtils.lerp((int) a10.right, (int) a11.right, f10), drawable.getBounds().bottom);
    }
}
