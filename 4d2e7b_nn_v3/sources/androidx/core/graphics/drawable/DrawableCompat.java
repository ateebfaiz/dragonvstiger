package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat {
    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    static class a {
        @DoNotInline
        static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        @DoNotInline
        static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        @DoNotInline
        static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        @DoNotInline
        static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        @DoNotInline
        static void e(Drawable drawable, float f10, float f11) {
            drawable.setHotspot(f10, f11);
        }

        @DoNotInline
        static void f(Drawable drawable, int i10, int i11, int i12, int i13) {
            drawable.setHotspotBounds(i10, i11, i12, i13);
        }

        @DoNotInline
        static void g(Drawable drawable, int i10) {
            drawable.setTint(i10);
        }

        @DoNotInline
        static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        @DoNotInline
        static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    static class b {
        @DoNotInline
        static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        @DoNotInline
        static boolean b(Drawable drawable, int i10) {
            return drawable.setLayoutDirection(i10);
        }
    }

    private DrawableCompat() {
    }

    public static void applyTheme(@NonNull Drawable drawable, @NonNull Resources.Theme theme) {
        a.a(drawable, theme);
    }

    public static boolean canApplyTheme(@NonNull Drawable drawable) {
        return a.b(drawable);
    }

    public static void clearColorFilter(@NonNull Drawable drawable) {
        drawable.clearColorFilter();
    }

    public static int getAlpha(@NonNull Drawable drawable) {
        return drawable.getAlpha();
    }

    @Nullable
    public static ColorFilter getColorFilter(@NonNull Drawable drawable) {
        return a.c(drawable);
    }

    public static int getLayoutDirection(@NonNull Drawable drawable) {
        return b.a(drawable);
    }

    public static void inflate(@NonNull Drawable drawable, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        a.d(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean isAutoMirrored(@NonNull Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    @Deprecated
    public static void jumpToCurrentState(@NonNull Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void setAutoMirrored(@NonNull Drawable drawable, boolean z10) {
        drawable.setAutoMirrored(z10);
    }

    public static void setHotspot(@NonNull Drawable drawable, float f10, float f11) {
        a.e(drawable, f10, f11);
    }

    public static void setHotspotBounds(@NonNull Drawable drawable, int i10, int i11, int i12, int i13) {
        a.f(drawable, i10, i11, i12, i13);
    }

    public static boolean setLayoutDirection(@NonNull Drawable drawable, int i10) {
        return b.b(drawable, i10);
    }

    public static void setTint(@NonNull Drawable drawable, @ColorInt int i10) {
        a.g(drawable, i10);
    }

    public static void setTintList(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList) {
        a.h(drawable, colorStateList);
    }

    public static void setTintMode(@NonNull Drawable drawable, @Nullable PorterDuff.Mode mode) {
        a.i(drawable, mode);
    }

    public static <T extends Drawable> T unwrap(@NonNull Drawable drawable) {
        if (drawable instanceof WrappedDrawable) {
            return ((WrappedDrawable) drawable).getWrappedDrawable();
        }
        return drawable;
    }

    @NonNull
    public static Drawable wrap(@NonNull Drawable drawable) {
        return drawable;
    }
}
