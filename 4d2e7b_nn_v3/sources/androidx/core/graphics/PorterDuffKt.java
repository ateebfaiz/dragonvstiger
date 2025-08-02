package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;

public final class PorterDuffKt {
    public static final PorterDuffColorFilter toColorFilter(PorterDuff.Mode mode, int i10) {
        return new PorterDuffColorFilter(i10, mode);
    }

    public static final PorterDuffXfermode toXfermode(PorterDuff.Mode mode) {
        return new PorterDuffXfermode(mode);
    }
}
