package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class FitCenter extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.FitCenter";
    private static final byte[] ID_BYTES = ID.getBytes(Key.CHARSET);

    public boolean equals(Object obj) {
        return obj instanceof FitCenter;
    }

    public int hashCode() {
        return 1572326941;
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i10, int i11) {
        return TransformationUtils.fitCenter(bitmapPool, bitmap, i10, i11);
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
