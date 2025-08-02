package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class CheckedTextViewCompat {

    private static class a {
        static ColorStateList a(CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkTintList();
        }

        static PorterDuff.Mode b(CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkTintMode();
        }

        static void c(CheckedTextView checkedTextView, ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        static void d(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    private CheckedTextViewCompat() {
    }

    @Nullable
    public static Drawable getCheckMarkDrawable(@NonNull CheckedTextView checkedTextView) {
        return checkedTextView.getCheckMarkDrawable();
    }

    @Nullable
    public static ColorStateList getCheckMarkTintList(@NonNull CheckedTextView checkedTextView) {
        return a.a(checkedTextView);
    }

    @Nullable
    public static PorterDuff.Mode getCheckMarkTintMode(@NonNull CheckedTextView checkedTextView) {
        return a.b(checkedTextView);
    }

    public static void setCheckMarkTintList(@NonNull CheckedTextView checkedTextView, @Nullable ColorStateList colorStateList) {
        a.c(checkedTextView, colorStateList);
    }

    public static void setCheckMarkTintMode(@NonNull CheckedTextView checkedTextView, @Nullable PorterDuff.Mode mode) {
        a.d(checkedTextView, mode);
    }
}
