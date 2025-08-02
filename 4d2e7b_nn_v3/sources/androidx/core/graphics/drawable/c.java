package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

class c extends RoundedBitmapDrawable {
    protected c(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public void getOutline(Outline outline) {
        updateDstRect();
        outline.setRoundRect(this.mDstRect, getCornerRadius());
    }

    /* access modifiers changed from: package-private */
    public void gravityCompatApply(int i10, int i11, int i12, Rect rect, Rect rect2) {
        Gravity.apply(i10, i11, i12, rect, rect2, 0);
    }

    public boolean hasMipMap() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || !bitmap.hasMipMap()) {
            return false;
        }
        return true;
    }

    public void setMipMap(boolean z10) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.setHasMipMap(z10);
            invalidateSelf();
        }
    }
}
