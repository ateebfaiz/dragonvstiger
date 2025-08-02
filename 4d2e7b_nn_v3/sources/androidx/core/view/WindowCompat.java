package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    static class a {
        static void a(Window window, boolean z10) {
            int i10;
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z10) {
                i10 = systemUiVisibility & -1793;
            } else {
                i10 = systemUiVisibility | 1792;
            }
            decorView.setSystemUiVisibility(i10);
        }
    }

    static class b {
        @DoNotInline
        static <T> T a(Window window, int i10) {
            return window.requireViewById(i10);
        }
    }

    static class c {
        @DoNotInline
        static void a(@NonNull Window window, boolean z10) {
            window.setDecorFitsSystemWindows(z10);
        }
    }

    private WindowCompat() {
    }

    @NonNull
    public static WindowInsetsControllerCompat getInsetsController(@NonNull Window window, @NonNull View view) {
        return new WindowInsetsControllerCompat(window, view);
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Window window, @IdRes int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (View) b.a(window, i10);
        }
        T findViewById = window.findViewById(i10);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Window");
    }

    public static void setDecorFitsSystemWindows(@NonNull Window window, boolean z10) {
        if (Build.VERSION.SDK_INT >= 30) {
            c.a(window, z10);
        } else {
            a.a(window, z10);
        }
    }
}
