package w3;

import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;

public abstract class e {
    public static void a(Drawable drawable, Drawable drawable2) {
        if (drawable2 != null && drawable != null && drawable != drawable2) {
            drawable.setBounds(drawable2.getBounds());
            drawable.setChangingConfigurations(drawable2.getChangingConfigurations());
            drawable.setLevel(drawable2.getLevel());
            drawable.setVisible(drawable2.isVisible(), false);
            drawable.setState(drawable2.getState());
        }
    }

    public static int b(int i10) {
        int i11 = i10 >>> 24;
        if (i11 == 255) {
            return -1;
        }
        if (i11 == 0) {
            return -2;
        }
        return -3;
    }

    public static int c(int i10, int i11) {
        if (i11 == 255) {
            return i10;
        }
        if (i11 == 0) {
            return i10 & ViewCompat.MEASURED_SIZE_MASK;
        }
        int i12 = i11 + (i11 >> 7);
        return (i10 & ViewCompat.MEASURED_SIZE_MASK) | ((((i10 >>> 24) * i12) >> 8) << 24);
    }

    public static void d(Drawable drawable, Drawable.Callback callback, r rVar) {
        if (drawable != null) {
            drawable.setCallback(callback);
            if (drawable instanceof q) {
                ((q) drawable).c(rVar);
            }
        }
    }

    public static void e(Drawable drawable, d dVar) {
        if (drawable != null && dVar != null) {
            dVar.a(drawable);
        }
    }
}
