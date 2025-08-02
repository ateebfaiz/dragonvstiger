package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    static class a {
        @DoNotInline
        static boolean a(ViewParent viewParent, View view, float f10, float f11, boolean z10) {
            return viewParent.onNestedFling(view, f10, f11, z10);
        }

        @DoNotInline
        static boolean b(ViewParent viewParent, View view, float f10, float f11) {
            return viewParent.onNestedPreFling(view, f10, f11);
        }

        @DoNotInline
        static void c(ViewParent viewParent, View view, int i10, int i11, int[] iArr) {
            viewParent.onNestedPreScroll(view, i10, i11, iArr);
        }

        @DoNotInline
        static void d(ViewParent viewParent, View view, int i10, int i11, int i12, int i13) {
            viewParent.onNestedScroll(view, i10, i11, i12, i13);
        }

        @DoNotInline
        static void e(ViewParent viewParent, View view, View view2, int i10) {
            viewParent.onNestedScrollAccepted(view, view2, i10);
        }

        @DoNotInline
        static boolean f(ViewParent viewParent, View view, View view2, int i10) {
            return viewParent.onStartNestedScroll(view, view2, i10);
        }

        @DoNotInline
        static void g(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    private ViewParentCompat() {
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] iArr = sTempNestedScrollConsumed;
        if (iArr == null) {
            sTempNestedScrollConsumed = new int[2];
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return sTempNestedScrollConsumed;
    }

    public static void notifySubtreeAccessibilityStateChanged(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i10) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i10);
    }

    public static boolean onNestedFling(@NonNull ViewParent viewParent, @NonNull View view, float f10, float f11, boolean z10) {
        try {
            return a.a(viewParent, view, f10, f11, z10);
        } catch (AbstractMethodError e10) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedFling", e10);
            return false;
        }
    }

    public static boolean onNestedPreFling(@NonNull ViewParent viewParent, @NonNull View view, float f10, float f11) {
        try {
            return a.b(viewParent, view, f10, f11);
        } catch (AbstractMethodError e10) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e10);
            return false;
        }
    }

    public static void onNestedPreScroll(@NonNull ViewParent viewParent, @NonNull View view, int i10, int i11, @NonNull int[] iArr) {
        onNestedPreScroll(viewParent, view, i10, i11, iArr, 0);
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i10, int i11, int i12, int i13) {
        onNestedScroll(viewParent, view, i10, i11, i12, i13, 0, getTempNestedScrollConsumed());
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i10) {
        onNestedScrollAccepted(viewParent, view, view2, i10, 0);
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i10) {
        return onStartNestedScroll(viewParent, view, view2, i10, 0);
    }

    public static void onStopNestedScroll(@NonNull ViewParent viewParent, @NonNull View view) {
        onStopNestedScroll(viewParent, view, 0);
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void onNestedPreScroll(@NonNull ViewParent viewParent, @NonNull View view, int i10, int i11, @NonNull int[] iArr, int i12) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, i10, i11, iArr, i12);
        } else if (i12 == 0) {
            try {
                a.c(viewParent, view, i10, i11, iArr);
            } catch (AbstractMethodError e10) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e10);
            }
        }
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i10, int i11) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, i10, i11);
        } else if (i11 == 0) {
            try {
                a.e(viewParent, view, view2, i10);
            } catch (AbstractMethodError e10) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e10);
            }
        }
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i10, int i11) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, i10, i11);
        }
        if (i11 != 0) {
            return false;
        }
        try {
            return a.f(viewParent, view, view2, i10);
        } catch (AbstractMethodError e10) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e10);
            return false;
        }
    }

    public static void onStopNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i10) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onStopNestedScroll(view, i10);
        } else if (i10 == 0) {
            try {
                a.g(viewParent, view);
            } catch (AbstractMethodError e10) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e10);
            }
        }
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i10, int i11, int i12, int i13, int i14) {
        onNestedScroll(viewParent, view, i10, i11, i12, i13, i14, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i10, int i11, int i12, int i13, int i14, @NonNull int[] iArr) {
        ViewParent viewParent2 = viewParent;
        if (viewParent2 instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) viewParent2).onNestedScroll(view, i10, i11, i12, i13, i14, iArr);
            return;
        }
        iArr[0] = iArr[0] + i12;
        iArr[1] = iArr[1] + i13;
        if (viewParent2 instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent2).onNestedScroll(view, i10, i11, i12, i13, i14);
        } else if (i14 == 0) {
            try {
                a.d(viewParent, view, i10, i11, i12, i13);
            } catch (AbstractMethodError e10) {
                AbstractMethodError abstractMethodError = e10;
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScroll", abstractMethodError);
            }
        }
    }
}
