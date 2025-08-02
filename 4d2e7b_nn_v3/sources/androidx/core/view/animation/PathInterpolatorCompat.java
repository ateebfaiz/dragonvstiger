package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

public final class PathInterpolatorCompat {

    static class a {
        @DoNotInline
        static Interpolator a(float f10, float f11) {
            return new PathInterpolator(f10, f11);
        }

        @DoNotInline
        static Interpolator b(float f10, float f11, float f12, float f13) {
            return new PathInterpolator(f10, f11, f12, f13);
        }

        @DoNotInline
        static Interpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator create(@NonNull Path path) {
        return a.c(path);
    }

    @NonNull
    public static Interpolator create(float f10, float f11) {
        return a.a(f10, f11);
    }

    @NonNull
    public static Interpolator create(float f10, float f11, float f12, float f13) {
        return a.b(f10, f11, f12, f13);
    }
}
