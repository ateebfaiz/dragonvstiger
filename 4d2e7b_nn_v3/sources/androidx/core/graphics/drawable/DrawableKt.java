package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;

public final class DrawableKt {
    public static final Bitmap toBitmap(Drawable drawable, @Px int i10, @Px int i11, Bitmap.Config config) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() == null) {
                throw new IllegalArgumentException("bitmap is null");
            } else if (config == null || bitmapDrawable.getBitmap().getConfig() == config) {
                if (i10 == bitmapDrawable.getBitmap().getWidth() && i11 == bitmapDrawable.getBitmap().getHeight()) {
                    return bitmapDrawable.getBitmap();
                }
                return Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i10, i11, true);
            }
        }
        Rect bounds = drawable.getBounds();
        int i12 = bounds.left;
        int i13 = bounds.top;
        int i14 = bounds.right;
        int i15 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i10, i11, config);
        drawable.setBounds(0, 0, i10, i11);
        drawable.draw(new Canvas(createBitmap));
        drawable.setBounds(i12, i13, i14, i15);
        return createBitmap;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable drawable, int i10, int i11, Bitmap.Config config, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = drawable.getIntrinsicWidth();
        }
        if ((i12 & 2) != 0) {
            i11 = drawable.getIntrinsicHeight();
        }
        if ((i12 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i10, i11, config);
    }

    public static final Bitmap toBitmapOrNull(Drawable drawable, @Px int i10, @Px int i11, Bitmap.Config config) {
        if (!(drawable instanceof BitmapDrawable) || ((BitmapDrawable) drawable).getBitmap() != null) {
            return toBitmap(drawable, i10, i11, config);
        }
        return null;
    }

    public static /* synthetic */ Bitmap toBitmapOrNull$default(Drawable drawable, int i10, int i11, Bitmap.Config config, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = drawable.getIntrinsicWidth();
        }
        if ((i12 & 2) != 0) {
            i11 = drawable.getIntrinsicHeight();
        }
        if ((i12 & 4) != 0) {
            config = null;
        }
        return toBitmapOrNull(drawable, i10, i11, config);
    }

    public static final void updateBounds(Drawable drawable, @Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        drawable.setBounds(i10, i11, i12, i13);
    }

    public static /* synthetic */ void updateBounds$default(Drawable drawable, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = drawable.getBounds().left;
        }
        if ((i14 & 2) != 0) {
            i11 = drawable.getBounds().top;
        }
        if ((i14 & 4) != 0) {
            i12 = drawable.getBounds().right;
        }
        if ((i14 & 8) != 0) {
            i13 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i10, i11, i12, i13);
    }
}
