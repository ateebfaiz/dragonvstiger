package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;

public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {
    private final BitmapPool bitmapPool;
    private final ResourceDrawableDecoder drawableDecoder;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool bitmapPool2) {
        this.drawableDecoder = resourceDrawableDecoder;
        this.bitmapPool = bitmapPool2;
    }

    @Nullable
    public Resource<Bitmap> decode(@NonNull Uri uri, int i10, int i11, @NonNull Options options) {
        Resource<Drawable> decode = this.drawableDecoder.decode(uri, i10, i11, options);
        if (decode == null) {
            return null;
        }
        return DrawableToBitmapConverter.convert(this.bitmapPool, decode.get(), i10, i11);
    }

    public boolean handles(@NonNull Uri uri, @NonNull Options options) {
        return "android.resource".equals(uri.getScheme());
    }
}
