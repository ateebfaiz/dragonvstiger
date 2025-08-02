package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class PopupWindowCompat {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    static class a {
        @DoNotInline
        static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        @DoNotInline
        static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        @DoNotInline
        static void c(PopupWindow popupWindow, boolean z10) {
            popupWindow.setOverlapAnchor(z10);
        }

        @DoNotInline
        static void d(PopupWindow popupWindow, int i10) {
            popupWindow.setWindowLayoutType(i10);
        }
    }

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(@NonNull PopupWindow popupWindow) {
        return a.a(popupWindow);
    }

    public static int getWindowLayoutType(@NonNull PopupWindow popupWindow) {
        return a.b(popupWindow);
    }

    public static void setOverlapAnchor(@NonNull PopupWindow popupWindow, boolean z10) {
        a.c(popupWindow, z10);
    }

    public static void setWindowLayoutType(@NonNull PopupWindow popupWindow, int i10) {
        a.d(popupWindow, i10);
    }

    public static void showAsDropDown(@NonNull PopupWindow popupWindow, @NonNull View view, int i10, int i11, int i12) {
        popupWindow.showAsDropDown(view, i10, i11, i12);
    }
}
