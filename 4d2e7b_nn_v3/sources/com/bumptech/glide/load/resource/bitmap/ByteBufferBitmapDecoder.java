package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {
    private final Downsampler downsampler;

    public ByteBufferBitmapDecoder(Downsampler downsampler2) {
        this.downsampler = downsampler2;
    }

    public Resource<Bitmap> decode(@NonNull ByteBuffer byteBuffer, int i10, int i11, @NonNull Options options) throws IOException {
        return this.downsampler.decode(byteBuffer, i10, i11, options);
    }

    public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull Options options) {
        return this.downsampler.handles(byteBuffer);
    }
}
