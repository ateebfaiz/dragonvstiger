package com.bumptech.glide.load.resource.drawable;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

@RequiresApi(28)
public final class AnimatedImageDecoder {
    private final ArrayPool arrayPool;
    private final List<ImageHeaderParser> imageHeaderParsers;

    private static final class AnimatedImageDrawableResource implements Resource<Drawable> {
        private static final int ESTIMATED_NUMBER_OF_FRAMES = 2;
        private final AnimatedImageDrawable imageDrawable;

        AnimatedImageDrawableResource(AnimatedImageDrawable animatedImageDrawable) {
            this.imageDrawable = animatedImageDrawable;
        }

        @NonNull
        public Class<Drawable> getResourceClass() {
            return Drawable.class;
        }

        public int getSize() {
            return this.imageDrawable.getIntrinsicWidth() * this.imageDrawable.getIntrinsicHeight() * Util.getBytesPerPixel(Bitmap.Config.ARGB_8888) * 2;
        }

        public void recycle() {
            this.imageDrawable.stop();
            this.imageDrawable.clearAnimationCallbacks();
        }

        @NonNull
        public AnimatedImageDrawable get() {
            return this.imageDrawable;
        }
    }

    private static final class ByteBufferAnimatedImageDecoder implements ResourceDecoder<ByteBuffer, Drawable> {
        private final AnimatedImageDecoder delegate;

        ByteBufferAnimatedImageDecoder(AnimatedImageDecoder animatedImageDecoder) {
            this.delegate = animatedImageDecoder;
        }

        public Resource<Drawable> decode(@NonNull ByteBuffer byteBuffer, int i10, int i11, @NonNull Options options) throws IOException {
            return this.delegate.decode(ImageDecoder.createSource(byteBuffer), i10, i11, options);
        }

        public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull Options options) throws IOException {
            return this.delegate.handles(byteBuffer);
        }
    }

    private static final class StreamAnimatedImageDecoder implements ResourceDecoder<InputStream, Drawable> {
        private final AnimatedImageDecoder delegate;

        StreamAnimatedImageDecoder(AnimatedImageDecoder animatedImageDecoder) {
            this.delegate = animatedImageDecoder;
        }

        public Resource<Drawable> decode(@NonNull InputStream inputStream, int i10, int i11, @NonNull Options options) throws IOException {
            return this.delegate.decode(ImageDecoder.createSource(ByteBufferUtil.fromStream(inputStream)), i10, i11, options);
        }

        public boolean handles(@NonNull InputStream inputStream, @NonNull Options options) throws IOException {
            return this.delegate.handles(inputStream);
        }
    }

    private AnimatedImageDecoder(List<ImageHeaderParser> list, ArrayPool arrayPool2) {
        this.imageHeaderParsers = list;
        this.arrayPool = arrayPool2;
    }

    public static ResourceDecoder<ByteBuffer, Drawable> byteBufferDecoder(List<ImageHeaderParser> list, ArrayPool arrayPool2) {
        return new ByteBufferAnimatedImageDecoder(new AnimatedImageDecoder(list, arrayPool2));
    }

    private boolean isHandled(ImageHeaderParser.ImageType imageType) {
        if (imageType == ImageHeaderParser.ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageType == ImageHeaderParser.ImageType.ANIMATED_AVIF)) {
            return true;
        }
        return false;
    }

    public static ResourceDecoder<InputStream, Drawable> streamDecoder(List<ImageHeaderParser> list, ArrayPool arrayPool2) {
        return new StreamAnimatedImageDecoder(new AnimatedImageDecoder(list, arrayPool2));
    }

    /* access modifiers changed from: package-private */
    public Resource<Drawable> decode(@NonNull ImageDecoder.Source source, int i10, int i11, @NonNull Options options) throws IOException {
        Drawable a10 = ImageDecoder.decodeDrawable(source, new DefaultOnHeaderDecodedListener(i10, i11, options));
        if (a.a(a10)) {
            return new AnimatedImageDrawableResource(b.a(a10));
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + a10);
    }

    /* access modifiers changed from: package-private */
    public boolean handles(ByteBuffer byteBuffer) throws IOException {
        return isHandled(ImageHeaderParserUtils.getType(this.imageHeaderParsers, byteBuffer));
    }

    /* access modifiers changed from: package-private */
    public boolean handles(InputStream inputStream) throws IOException {
        return isHandled(ImageHeaderParserUtils.getType(this.imageHeaderParsers, inputStream, this.arrayPool));
    }
}
