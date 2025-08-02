package com.facebook.react.views.view;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.views.view.ReactViewGroup;
import h7.a;

public abstract class ReactClippingViewManager<T extends ReactViewGroup> extends ViewGroupManager<T> {
    @a(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(T t10, boolean z10) {
        UiThreadUtil.assertOnUiThread();
        t10.setRemoveClippedSubviews(z10);
    }

    public void removeAllViews(T t10) {
        UiThreadUtil.assertOnUiThread();
        if (t10.getRemoveClippedSubviews()) {
            t10.removeAllViewsWithSubviewClippingEnabled();
        } else {
            t10.removeAllViews();
        }
    }

    public void addView(T t10, View view, int i10) {
        UiThreadUtil.assertOnUiThread();
        if (t10.getRemoveClippedSubviews()) {
            t10.addViewWithSubviewClippingEnabled(view, i10);
        } else {
            t10.addView(view, i10);
        }
    }

    @Nullable
    public View getChildAt(T t10, int i10) {
        if (t10.getRemoveClippedSubviews()) {
            return t10.getChildAtWithSubviewClippingEnabled(i10);
        }
        return t10.getChildAt(i10);
    }

    public int getChildCount(T t10) {
        if (t10.getRemoveClippedSubviews()) {
            return t10.getAllChildrenCount();
        }
        return t10.getChildCount();
    }

    public void removeViewAt(T t10, int i10) {
        UiThreadUtil.assertOnUiThread();
        if (t10.getRemoveClippedSubviews()) {
            View childAt = getChildAt(t10, i10);
            if (childAt != null) {
                if (childAt.getParent() != null) {
                    t10.removeView(childAt);
                }
                t10.removeViewWithSubviewClippingEnabled(childAt);
                return;
            }
            return;
        }
        t10.removeViewAt(i10);
    }
}
