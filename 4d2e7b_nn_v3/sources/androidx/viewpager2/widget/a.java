package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f16890b;

    /* renamed from: a  reason: collision with root package name */
    private LinearLayoutManager f16891a;

    /* renamed from: androidx.viewpager2.widget.a$a  reason: collision with other inner class name */
    class C0218a implements Comparator {
        C0218a() {
        }

        /* renamed from: a */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f16890b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    a(LinearLayoutManager linearLayoutManager) {
        this.f16891a = linearLayoutManager;
    }

    private boolean a() {
        boolean z10;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int top;
        int i10;
        int bottom;
        int i11;
        int childCount = this.f16891a.getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (this.f16891a.getOrientation() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = childCount;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        int i12 = 0;
        while (i12 < childCount) {
            View childAt = this.f16891a.getChildAt(i12);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = f16890b;
                }
                int[] iArr3 = iArr2[i12];
                if (z10) {
                    top = childAt.getLeft();
                    i10 = marginLayoutParams.leftMargin;
                } else {
                    top = childAt.getTop();
                    i10 = marginLayoutParams.topMargin;
                }
                iArr3[0] = top - i10;
                int[] iArr4 = iArr2[i12];
                if (z10) {
                    bottom = childAt.getRight();
                    i11 = marginLayoutParams.rightMargin;
                } else {
                    bottom = childAt.getBottom();
                    i11 = marginLayoutParams.bottomMargin;
                }
                iArr4[1] = bottom + i11;
                i12++;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr2, new C0218a());
        for (int i13 = 1; i13 < childCount; i13++) {
            if (iArr2[i13 - 1][1] != iArr2[i13][0]) {
                return false;
            }
        }
        int[] iArr5 = iArr2[0];
        int i14 = iArr5[1];
        int i15 = iArr5[0];
        int i16 = i14 - i15;
        if (i15 > 0 || iArr2[childCount - 1][1] < i16) {
            return false;
        }
        return true;
    }

    private boolean b() {
        int childCount = this.f16891a.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (c(this.f16891a.getChildAt(i10))) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (c(viewGroup.getChildAt(i10))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        if ((!a() || this.f16891a.getChildCount() <= 1) && b()) {
            return true;
        }
        return false;
    }
}
