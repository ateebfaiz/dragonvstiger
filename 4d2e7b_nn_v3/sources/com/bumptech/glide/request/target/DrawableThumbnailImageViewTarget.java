package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class DrawableThumbnailImageViewTarget extends ThumbnailImageViewTarget<Drawable> {
    public DrawableThumbnailImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* access modifiers changed from: protected */
    public Drawable getDrawable(Drawable drawable) {
        return drawable;
    }

    @Deprecated
    public DrawableThumbnailImageViewTarget(ImageView imageView, boolean z10) {
        super(imageView, z10);
    }
}
