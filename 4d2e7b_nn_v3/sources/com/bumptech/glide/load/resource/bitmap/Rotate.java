package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class Rotate extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.Rotate";
    private static final byte[] ID_BYTES = ID.getBytes(Key.CHARSET);
    private final int degreesToRotate;

    public Rotate(int i10) {
        this.degreesToRotate = i10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Rotate) || this.degreesToRotate != ((Rotate) obj).degreesToRotate) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Util.hashCode(-950519196, Util.hashCode(this.degreesToRotate));
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i10, int i11) {
        return TransformationUtils.rotateImage(bitmap, this.degreesToRotate);
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.degreesToRotate).array());
    }
}
