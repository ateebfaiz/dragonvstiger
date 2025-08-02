package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener;
import java.io.IOException;

@RequiresApi(api = 28)
public final class BitmapImageDecoderResourceDecoder implements ResourceDecoder<ImageDecoder.Source, Bitmap> {
    private static final String TAG = "BitmapImageDecoder";
    private final BitmapPool bitmapPool = new BitmapPoolAdapter();

    public /* bridge */ /* synthetic */ Resource decode(@NonNull Object obj, int i10, int i11, @NonNull Options options) throws IOException {
        return decode(a.a(obj), i10, i11, options);
    }

    public boolean handles(@NonNull ImageDecoder.Source source, @NonNull Options options) throws IOException {
        return true;
    }

    public Resource<Bitmap> decode(@NonNull ImageDecoder.Source source, int i10, int i11, @NonNull Options options) throws IOException {
        Bitmap a10 = ImageDecoder.decodeBitmap(source, new DefaultOnHeaderDecodedListener(i10, i11, options));
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Decoded [" + a10.getWidth() + "x" + a10.getHeight() + "] for [" + i10 + "x" + i11 + "]");
        }
        return new BitmapResource(a10, this.bitmapPool);
    }

    public /* bridge */ /* synthetic */ boolean handles(@NonNull Object obj, @NonNull Options options) throws IOException {
        return handles(a.a(obj), options);
    }
}
