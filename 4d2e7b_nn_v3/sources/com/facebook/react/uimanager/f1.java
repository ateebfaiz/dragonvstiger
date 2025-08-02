package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.UiThreadUtil;
import g7.c;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public abstract class f1 {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f3673a = new float[2];

    /* renamed from: b  reason: collision with root package name */
    private static final PointF f3674b = new PointF();

    /* renamed from: c  reason: collision with root package name */
    private static final float[] f3675c = new float[2];

    /* renamed from: d  reason: collision with root package name */
    private static final Matrix f3676d = new Matrix();

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ int f3677e = 0;

    private enum a {
        SELF,
        CHILD
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f3681a;

        /* renamed from: b  reason: collision with root package name */
        private final View f3682b;

        public View a() {
            return this.f3682b;
        }

        public int b() {
            return this.f3681a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            if (((b) obj).b() == this.f3681a) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Integer.valueOf(this.f3681a).hashCode();
        }

        private b(int i10, View view) {
            this.f3681a = i10;
            this.f3682b = view;
        }
    }

    private static View a(View view) {
        while (view != null && view.getId() <= 0) {
            view = (View) view.getParent();
        }
        return view;
    }

    public static List b(float f10, float f11, ViewGroup viewGroup, float[] fArr) {
        UiThreadUtil.assertOnUiThread();
        fArr[0] = f10;
        fArr[1] = f11;
        List arrayList = new ArrayList();
        View f12 = f(fArr, viewGroup, arrayList);
        if (f12 != null) {
            int i10 = 0;
            while (f12 != null && f12.getId() <= 0) {
                f12 = (View) f12.getParent();
                i10++;
            }
            if (i10 > 0) {
                arrayList = arrayList.subList(i10, arrayList.size());
            }
            int h10 = h(f12, fArr[0], fArr[1]);
            if (h10 != f12.getId()) {
                arrayList.add(0, new b(h10, (View) null));
            }
        }
        return arrayList;
    }

    public static int c(float f10, float f11, ViewGroup viewGroup, float[] fArr, int[] iArr) {
        View a10;
        UiThreadUtil.assertOnUiThread();
        int id2 = viewGroup.getId();
        fArr[0] = f10;
        fArr[1] = f11;
        View f12 = f(fArr, viewGroup, (List) null);
        if (f12 == null || (a10 = a(f12)) == null) {
            return id2;
        }
        if (iArr != null) {
            iArr[0] = a10.getId();
        }
        return h(a10, fArr[0], fArr[1]);
    }

    public static int d(float f10, float f11, ViewGroup viewGroup) {
        return c(f10, f11, viewGroup, f3673a, (int[]) null);
    }

    private static View e(float[] fArr, View view, EnumSet enumSet, List list) {
        x0 x0Var;
        int i10;
        if (enumSet.contains(a.CHILD) && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!i(fArr[0], fArr[1], view)) {
                if (view instanceof p0) {
                    if (i7.a.a(view.getId()) == 2 && !j(fArr[0], fArr[1], view)) {
                        return null;
                    }
                    String overflow = ((p0) view).getOverflow();
                    if ("hidden".equals(overflow) || "scroll".equals(overflow)) {
                        return null;
                    }
                }
                if (viewGroup.getClipChildren()) {
                    return null;
                }
            }
            int childCount = viewGroup.getChildCount();
            if (viewGroup instanceof x0) {
                x0Var = (x0) viewGroup;
            } else {
                x0Var = null;
            }
            for (int i11 = childCount - 1; i11 >= 0; i11--) {
                if (x0Var != null) {
                    i10 = x0Var.getZIndexMappedChildIndex(i11);
                } else {
                    i10 = i11;
                }
                View childAt = viewGroup.getChildAt(i10);
                PointF pointF = f3674b;
                g(fArr[0], fArr[1], viewGroup, childAt, pointF);
                float f10 = fArr[0];
                float f11 = fArr[1];
                fArr[0] = pointF.x;
                fArr[1] = pointF.y;
                View f12 = f(fArr, childAt, list);
                if (f12 != null) {
                    return f12;
                }
                fArr[0] = f10;
                fArr[1] = f11;
            }
        }
        if (!enumSet.contains(a.SELF) || !i(fArr[0], fArr[1], view)) {
            return null;
        }
        return view;
    }

    private static View f(float[] fArr, View view, List list) {
        h0 h0Var;
        if (view instanceof q0) {
            h0Var = ((q0) view).getPointerEvents();
        } else {
            h0Var = h0.AUTO;
        }
        if (!view.isEnabled()) {
            if (h0Var == h0.AUTO) {
                h0Var = h0.BOX_NONE;
            } else if (h0Var == h0.BOX_ONLY) {
                h0Var = h0.NONE;
            }
        }
        if (h0Var == h0.NONE) {
            return null;
        }
        if (h0Var == h0.BOX_ONLY) {
            View e10 = e(fArr, view, EnumSet.of(a.SELF), list);
            if (!(e10 == null || list == null)) {
                list.add(new b(view.getId(), view));
            }
            return e10;
        } else if (h0Var == h0.BOX_NONE) {
            View e11 = e(fArr, view, EnumSet.of(a.CHILD), list);
            if (e11 != null) {
                if (list != null) {
                    list.add(new b(view.getId(), view));
                }
                return e11;
            } else if (!(view instanceof m0) || !i(fArr[0], fArr[1], view) || ((m0) view).reactTagForTouch(fArr[0], fArr[1]) == view.getId()) {
                return null;
            } else {
                if (list != null) {
                    list.add(new b(view.getId(), view));
                }
                return view;
            }
        } else {
            if (h0Var != h0.AUTO) {
                z2.a.G("ReactNative", "Unknown pointer event type: " + h0Var.toString());
            }
            if (!(view instanceof n0) || !i(fArr[0], fArr[1], view) || !((n0) view).interceptsTouchEvent(fArr[0], fArr[1])) {
                View e12 = e(fArr, view, EnumSet.of(a.SELF, a.CHILD), list);
                if (!(e12 == null || list == null)) {
                    list.add(new b(view.getId(), view));
                }
                return e12;
            }
            if (list != null) {
                list.add(new b(view.getId(), view));
            }
            return view;
        }
    }

    private static void g(float f10, float f11, ViewGroup viewGroup, View view, PointF pointF) {
        float scrollX = (f10 + ((float) viewGroup.getScrollX())) - ((float) view.getLeft());
        float scrollY = (f11 + ((float) viewGroup.getScrollY())) - ((float) view.getTop());
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            float[] fArr = f3675c;
            fArr[0] = scrollX;
            fArr[1] = scrollY;
            Matrix matrix2 = f3676d;
            matrix.invert(matrix2);
            matrix2.mapPoints(fArr);
            float f12 = fArr[0];
            scrollY = fArr[1];
            scrollX = f12;
        }
        pointF.set(scrollX, scrollY);
    }

    private static int h(View view, float f10, float f11) {
        if (view instanceof m0) {
            return ((m0) view).reactTagForTouch(f10, f11);
        }
        return view.getId();
    }

    private static boolean i(float f10, float f11, View view) {
        if (view instanceof c) {
            c cVar = (c) view;
            if (cVar.getHitSlopRect() != null) {
                Rect hitSlopRect = cVar.getHitSlopRect();
                if (f10 < ((float) (-hitSlopRect.left)) || f10 >= ((float) (view.getWidth() + hitSlopRect.right)) || f11 < ((float) (-hitSlopRect.top)) || f11 >= ((float) (view.getHeight() + hitSlopRect.bottom))) {
                    return false;
                }
                return true;
            }
        }
        if (f10 < 0.0f || f10 >= ((float) view.getWidth()) || f11 < 0.0f || f11 >= ((float) view.getHeight())) {
            return false;
        }
        return true;
    }

    private static boolean j(float f10, float f11, View view) {
        if (!(view instanceof p0)) {
            return false;
        }
        Rect overflowInset = ((p0) view).getOverflowInset();
        if (f10 < ((float) overflowInset.left) || f10 >= ((float) (view.getWidth() - overflowInset.right)) || f11 < ((float) overflowInset.top) || f11 >= ((float) (view.getHeight() - overflowInset.bottom))) {
            return false;
        }
        return true;
    }
}
