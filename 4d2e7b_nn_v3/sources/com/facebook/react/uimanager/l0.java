package com.facebook.react.uimanager;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;

public abstract class l0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Rect f3810a = new Rect();

    public static void a(View view, Rect rect) {
        ViewParent parent = view.getParent();
        if (parent == null) {
            rect.setEmpty();
            return;
        }
        if (parent instanceof k0) {
            k0 k0Var = (k0) parent;
            if (k0Var.getRemoveClippedSubviews()) {
                Rect rect2 = f3810a;
                k0Var.getClippingRect(rect2);
                if (!rect2.intersect(view.getLeft(), view.getTop() + ((int) view.getTranslationY()), view.getRight(), view.getBottom() + ((int) view.getTranslationY()))) {
                    rect.setEmpty();
                    return;
                }
                rect2.offset(-view.getLeft(), -view.getTop());
                rect2.offset(-((int) view.getTranslationX()), -((int) view.getTranslationY()));
                rect2.offset(view.getScrollX(), view.getScrollY());
                rect.set(rect2);
                return;
            }
        }
        view.getDrawingRect(rect);
    }
}
