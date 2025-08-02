package com.bumptech.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import java.util.Arrays;

public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {
    private int[] size;
    private SizeViewTarget viewTarget;

    static final class SizeViewTarget extends CustomViewTarget<View, Object> {
        SizeViewTarget(@NonNull View view) {
            super(view);
        }

        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        /* access modifiers changed from: protected */
        public void onResourceCleared(@Nullable Drawable drawable) {
        }

        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }
    }

    public ViewPreloadSizeProvider() {
    }

    @Nullable
    public int[] getPreloadSize(@NonNull T t10, int i10, int i11) {
        int[] iArr = this.size;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public void onSizeReady(int i10, int i11) {
        this.size = new int[]{i10, i11};
        this.viewTarget = null;
    }

    public void setView(@NonNull View view) {
        if (this.size == null && this.viewTarget == null) {
            SizeViewTarget sizeViewTarget = new SizeViewTarget(view);
            this.viewTarget = sizeViewTarget;
            sizeViewTarget.getSize(this);
        }
    }

    public ViewPreloadSizeProvider(@NonNull View view) {
        SizeViewTarget sizeViewTarget = new SizeViewTarget(view);
        this.viewTarget = sizeViewTarget;
        sizeViewTarget.getSize(this);
    }
}
