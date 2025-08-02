package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

public interface BitmapPool {
    void clearMemory();

    @NonNull
    Bitmap get(int i10, int i11, Bitmap.Config config);

    @NonNull
    Bitmap getDirty(int i10, int i11, Bitmap.Config config);

    long getMaxSize();

    void put(Bitmap bitmap);

    void setSizeMultiplier(float f10);

    void trimMemory(int i10);
}
