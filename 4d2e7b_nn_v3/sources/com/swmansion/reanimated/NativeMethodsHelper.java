package com.swmansion.reanimated;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.uimanager.a1;
import com.facebook.react.uimanager.g0;
import com.facebook.react.views.scroll.ReactHorizontalScrollView;
import com.facebook.react.views.scroll.ReactScrollView;
import com.facebook.react.views.swiperefresh.ReactSwipeRefreshLayout;

public class NativeMethodsHelper {
    private static void computeBoundingBox(View view, int[] iArr) {
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        mapRectFromViewToWindowCoords(view, rectF);
        iArr[0] = Math.round(rectF.left);
        iArr[1] = Math.round(rectF.top);
        iArr[2] = Math.round(rectF.right - rectF.left);
        iArr[3] = Math.round(rectF.bottom - rectF.top);
    }

    private static ReactScrollView findScrollView(ReactSwipeRefreshLayout reactSwipeRefreshLayout) {
        for (int i10 = 0; i10 < reactSwipeRefreshLayout.getChildCount(); i10++) {
            if (reactSwipeRefreshLayout.getChildAt(i10) instanceof ReactScrollView) {
                return (ReactScrollView) reactSwipeRefreshLayout.getChildAt(i10);
            }
        }
        return null;
    }

    private static void mapRectFromViewToWindowCoords(View view, RectF rectF) {
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            matrix.mapRect(rectF);
        }
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            rectF.offset((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
            Matrix matrix2 = view2.getMatrix();
            if (!matrix2.isIdentity()) {
                matrix2.mapRect(rectF);
            }
            rectF.offset((float) view2.getLeft(), (float) view2.getTop());
            parent = view2.getParent();
        }
    }

    public static float[] measure(View view) {
        View view2 = (View) a1.a(view);
        if (view2 == null || view == null) {
            float[] fArr = new float[6];
            fArr[0] = -1234567.0f;
            return fArr;
        }
        int[] iArr = new int[4];
        computeBoundingBox(view2, iArr);
        int i10 = iArr[0];
        int i11 = iArr[1];
        computeBoundingBox(view, iArr);
        iArr[0] = iArr[0] - i10;
        iArr[1] = iArr[1] - i11;
        float[] fArr2 = new float[6];
        fArr2[0] = g0.b((float) view.getLeft());
        fArr2[1] = g0.b((float) view.getTop());
        for (int i12 = 2; i12 < 6; i12++) {
            fArr2[i12] = g0.b((float) iArr[i12 - 2]);
        }
        return fArr2;
    }

    public static void scrollTo(View view, double d10, double d11, boolean z10) {
        int round = Math.round(g0.c(d10));
        int round2 = Math.round(g0.c(d11));
        boolean z11 = view instanceof ReactHorizontalScrollView;
        if (!z11) {
            if (view instanceof ReactSwipeRefreshLayout) {
                view = findScrollView((ReactSwipeRefreshLayout) view);
            }
            if (!(view instanceof ReactScrollView)) {
                Log.w("REANIMATED", "NativeMethodsHelper: Unhandled scroll view type - allowed only {ReactScrollView, ReactHorizontalScrollView}");
                return;
            }
        }
        if (!z10) {
            view.scrollTo(round, round2);
        } else if (z11) {
            view.post(new a(view, round, round2));
        } else {
            view.post(new b(view, round, round2));
        }
    }
}
