package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;

public abstract class ThumbnailImageViewTarget<T> extends ImageViewTarget<T> {
    public ThumbnailImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* access modifiers changed from: protected */
    public abstract Drawable getDrawable(T t10);

    /* access modifiers changed from: protected */
    public void setResource(@Nullable T t10) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.view).getLayoutParams();
        Drawable drawable = getDrawable(t10);
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            drawable = new FixedSizeDrawable(drawable, layoutParams.width, layoutParams.height);
        }
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    @Deprecated
    public ThumbnailImageViewTarget(ImageView imageView, boolean z10) {
        super(imageView, z10);
    }
}
