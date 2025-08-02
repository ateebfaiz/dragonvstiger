package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(@Nullable Context context) {
        super(context);
    }

    private void forceUniformWidth(int i10, int i11) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i12 = 0; i12 < i10; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i13 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i11, 0);
                    layoutParams.height = i13;
                }
            }
        }
    }

    private static int resolveMinimumHeight(View view) {
        int minimumHeight = ViewCompat.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return resolveMinimumHeight(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private void setChildFrame(View view, int i10, int i11, int i12, int i13) {
        view.layout(i10, i11, i12 + i10, i13 + i11);
    }

    private boolean tryOnMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = i10;
        int i18 = i11;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8) {
                int id2 = childAt.getId();
                if (id2 == R.id.topPanel) {
                    view = childAt;
                } else if (id2 == R.id.buttonPanel) {
                    view2 = childAt;
                } else if ((id2 != R.id.contentPanel && id2 != R.id.customPanel) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i10);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i17, 0);
            paddingTop += view.getMeasuredHeight();
            i12 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            i12 = 0;
        }
        if (view2 != null) {
            view2.measure(i17, 0);
            i14 = resolveMinimumHeight(view2);
            i13 = view2.getMeasuredHeight() - i14;
            paddingTop += i14;
            i12 = View.combineMeasuredStates(i12, view2.getMeasuredState());
        } else {
            i14 = 0;
            i13 = 0;
        }
        if (view3 != null) {
            if (mode == 0) {
                i16 = 0;
            } else {
                i16 = View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode);
            }
            view3.measure(i17, i16);
            i15 = view3.getMeasuredHeight();
            paddingTop += i15;
            i12 = View.combineMeasuredStates(i12, view3.getMeasuredState());
        } else {
            i15 = 0;
        }
        int i20 = size - paddingTop;
        if (view2 != null) {
            int i21 = paddingTop - i14;
            int min = Math.min(i20, i13);
            if (min > 0) {
                i20 -= min;
                i14 += min;
            }
            view2.measure(i17, View.MeasureSpec.makeMeasureSpec(i14, 1073741824));
            paddingTop = i21 + view2.getMeasuredHeight();
            i12 = View.combineMeasuredStates(i12, view2.getMeasuredState());
        }
        if (view3 != null && i20 > 0) {
            view3.measure(i17, View.MeasureSpec.makeMeasureSpec(i15 + i20, mode));
            paddingTop = (paddingTop - i15) + view3.getMeasuredHeight();
            i12 = View.combineMeasuredStates(i12, view3.getMeasuredState());
        }
        int i22 = 0;
        for (int i23 = 0; i23 < childCount; i23++) {
            View childAt2 = getChildAt(i23);
            if (childAt2.getVisibility() != 8) {
                i22 = Math.max(i22, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i22 + getPaddingLeft() + getPaddingRight(), i17, i12), View.resolveSizeAndState(paddingTop, i18, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        forceUniformWidth(childCount, i18);
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r21 - r19
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r0 = r17.getMeasuredHeight()
            int r10 = r17.getChildCount()
            int r1 = r17.getGravity()
            r2 = r1 & 112(0x70, float:1.57E-43)
            r3 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r1 & r3
            r1 = 16
            if (r2 == r1) goto L_0x0040
            r1 = 80
            if (r2 == r1) goto L_0x0035
            int r0 = r17.getPaddingTop()
            goto L_0x004b
        L_0x0035:
            int r1 = r17.getPaddingTop()
            int r1 = r1 + r22
            int r1 = r1 - r20
            int r0 = r1 - r0
            goto L_0x004b
        L_0x0040:
            int r1 = r17.getPaddingTop()
            int r2 = r22 - r20
            int r2 = r2 - r0
            int r2 = r2 / 2
            int r0 = r1 + r2
        L_0x004b:
            android.graphics.drawable.Drawable r1 = r17.getDividerDrawable()
            r2 = 0
            if (r1 != 0) goto L_0x0054
            r12 = r2
            goto L_0x0059
        L_0x0054:
            int r1 = r1.getIntrinsicHeight()
            r12 = r1
        L_0x0059:
            r13 = r2
        L_0x005a:
            if (r13 >= r10) goto L_0x00c0
            android.view.View r1 = r6.getChildAt(r13)
            if (r1 == 0) goto L_0x00bd
            int r2 = r1.getVisibility()
            r3 = 8
            if (r2 == r3) goto L_0x00bd
            int r4 = r1.getMeasuredWidth()
            int r14 = r1.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            r15 = r2
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r15 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r15
            int r2 = r15.gravity
            if (r2 >= 0) goto L_0x007e
            r2 = r11
        L_0x007e:
            int r3 = androidx.core.view.ViewCompat.getLayoutDirection(r17)
            int r2 = androidx.core.view.GravityCompat.getAbsoluteGravity(r2, r3)
            r2 = r2 & 7
            r3 = 1
            if (r2 == r3) goto L_0x0098
            r3 = 5
            if (r2 == r3) goto L_0x0092
            int r2 = r15.leftMargin
            int r2 = r2 + r7
            goto L_0x00a3
        L_0x0092:
            int r2 = r8 - r4
            int r3 = r15.rightMargin
        L_0x0096:
            int r2 = r2 - r3
            goto L_0x00a3
        L_0x0098:
            int r2 = r9 - r4
            int r2 = r2 / 2
            int r2 = r2 + r7
            int r3 = r15.leftMargin
            int r2 = r2 + r3
            int r3 = r15.rightMargin
            goto L_0x0096
        L_0x00a3:
            boolean r3 = r6.hasDividerBeforeChildAt(r13)
            if (r3 == 0) goto L_0x00aa
            int r0 = r0 + r12
        L_0x00aa:
            int r3 = r15.topMargin
            int r16 = r0 + r3
            r0 = r17
            r3 = r16
            r5 = r14
            r0.setChildFrame(r1, r2, r3, r4, r5)
            int r0 = r15.bottomMargin
            int r14 = r14 + r0
            int r16 = r16 + r14
            r0 = r16
        L_0x00bd:
            int r13 = r13 + 1
            goto L_0x005a
        L_0x00c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AlertDialogLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (!tryOnMeasure(i10, i11)) {
            super.onMeasure(i10, i11);
        }
    }

    public AlertDialogLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
