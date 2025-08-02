package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.d;

public class BlendModeColorFilterCompat {

    static class a {
        @DoNotInline
        static ColorFilter a(int i10, Object obj) {
            return new BlendModeColorFilter(i10, (BlendMode) obj);
        }
    }

    private BlendModeColorFilterCompat() {
    }

    @Nullable
    public static ColorFilter createBlendModeColorFilterCompat(int i10, @NonNull BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            Object a10 = d.b.a(blendModeCompat);
            if (a10 != null) {
                return a.a(i10, a10);
            }
            return null;
        }
        PorterDuff.Mode a11 = d.a(blendModeCompat);
        if (a11 != null) {
            return new PorterDuffColorFilter(i10, a11);
        }
        return null;
    }
}
