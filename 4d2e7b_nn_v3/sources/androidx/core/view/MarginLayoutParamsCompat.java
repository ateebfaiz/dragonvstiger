package androidx.core.view;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

@Deprecated
public final class MarginLayoutParamsCompat {
    private MarginLayoutParamsCompat() {
    }

    @Deprecated
    public static int getLayoutDirection(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        int layoutDirection = marginLayoutParams.getLayoutDirection();
        if (layoutDirection == 0 || layoutDirection == 1) {
            return layoutDirection;
        }
        return 0;
    }

    @Deprecated
    public static int getMarginEnd(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    @Deprecated
    public static int getMarginStart(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    @Deprecated
    public static boolean isMarginRelative(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.isMarginRelative();
    }

    @Deprecated
    public static void resolveLayoutDirection(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        marginLayoutParams.resolveLayoutDirection(i10);
    }

    @Deprecated
    public static void setLayoutDirection(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        marginLayoutParams.setLayoutDirection(i10);
    }

    @Deprecated
    public static void setMarginEnd(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        marginLayoutParams.setMarginEnd(i10);
    }

    @Deprecated
    public static void setMarginStart(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        marginLayoutParams.setMarginStart(i10);
    }
}
