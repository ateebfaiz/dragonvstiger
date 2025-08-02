package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ImageViewCompat {

    static class a {
        @DoNotInline
        static ColorStateList a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        @DoNotInline
        static PorterDuff.Mode b(ImageView imageView) {
            return imageView.getImageTintMode();
        }

        @DoNotInline
        static void c(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
        }

        @DoNotInline
        static void d(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
        }
    }

    private ImageViewCompat() {
    }

    @Nullable
    public static ColorStateList getImageTintList(@NonNull ImageView imageView) {
        return a.a(imageView);
    }

    @Nullable
    public static PorterDuff.Mode getImageTintMode(@NonNull ImageView imageView) {
        return a.b(imageView);
    }

    public static void setImageTintList(@NonNull ImageView imageView, @Nullable ColorStateList colorStateList) {
        a.c(imageView, colorStateList);
    }

    public static void setImageTintMode(@NonNull ImageView imageView, @Nullable PorterDuff.Mode mode) {
        a.d(imageView, mode);
    }
}
