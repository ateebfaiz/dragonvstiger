package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ListPreloader;

public class FixedPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T> {
    private final int[] size;

    public FixedPreloadSizeProvider(int i10, int i11) {
        this.size = new int[]{i10, i11};
    }

    @Nullable
    public int[] getPreloadSize(@NonNull T t10, int i10, int i11) {
        return this.size;
    }
}
