package com.th3rdwave.safeareacontext;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import kotlin.jvm.internal.m;

public abstract class g {
    public static final c a(ViewGroup viewGroup, View view) {
        m.f(viewGroup, "rootView");
        m.f(view, "view");
        if (view.getParent() == null) {
            return null;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        try {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            return new c((float) rect.left, (float) rect.top, (float) view.getWidth(), (float) view.getHeight());
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private static final a b(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return d(view);
        }
        return c(view);
    }

    private static final a c(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        return new a((float) rootWindowInsets.getSystemWindowInsetTop(), (float) rootWindowInsets.getSystemWindowInsetRight(), (float) Math.min(rootWindowInsets.getSystemWindowInsetBottom(), rootWindowInsets.getStableInsetBottom()), (float) rootWindowInsets.getSystemWindowInsetLeft());
    }

    private static final a d(View view) {
        Insets a10;
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null || (a10 = rootWindowInsets.getInsets(WindowInsets.Type.statusBars() | WindowInsets.Type.displayCutout() | WindowInsets.Type.navigationBars() | WindowInsets.Type.captionBar())) == null) {
            return null;
        }
        return new a((float) a10.top, (float) a10.right, (float) a10.bottom, (float) a10.left);
    }

    public static final a e(View view) {
        m.f(view, "view");
        if (view.getHeight() == 0) {
            return null;
        }
        View rootView = view.getRootView();
        m.c(rootView);
        a b10 = b(rootView);
        if (b10 == null) {
            return null;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return new a(Math.max(b10.d() - ((float) rect.top), 0.0f), Math.max(Math.min(((float) (rect.left + view.getWidth())) - ((float) rootView.getWidth()), 0.0f) + b10.c(), 0.0f), Math.max(Math.min(((float) (rect.top + view.getHeight())) - ((float) rootView.getHeight()), 0.0f) + b10.a(), 0.0f), Math.max(b10.b() - ((float) rect.left), 0.0f));
    }
}
