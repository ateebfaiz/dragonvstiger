package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

public class BitmapPoolAdapter implements BitmapPool {
    public void clearMemory() {
    }

    @NonNull
    public Bitmap get(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    @NonNull
    public Bitmap getDirty(int i10, int i11, Bitmap.Config config) {
        return get(i10, i11, config);
    }

    public long getMaxSize() {
        return 0;
    }

    public void put(Bitmap bitmap) {
        bitmap.recycle();
    }

    public void setSizeMultiplier(float f10) {
    }

    public void trimMemory(int i10) {
    }
}
