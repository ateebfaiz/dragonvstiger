package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {
    private static final GifDecoderFactory GIF_DECODER_FACTORY = new GifDecoderFactory();
    private static final GifHeaderParserPool PARSER_POOL = new GifHeaderParserPool();
    private static final String TAG = "BufferGifDecoder";
    private final Context context;
    private final GifDecoderFactory gifDecoderFactory;
    private final GifHeaderParserPool parserPool;
    private final List<ImageHeaderParser> parsers;
    private final GifBitmapProvider provider;

    @VisibleForTesting
    static class GifDecoderFactory {
        GifDecoderFactory() {
        }

        /* access modifiers changed from: package-private */
        public GifDecoder build(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i10) {
            return new StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i10);
        }
    }

    @VisibleForTesting
    static class GifHeaderParserPool {
        private final Queue<GifHeaderParser> pool = Util.createQueue(0);

        GifHeaderParserPool() {
        }

        /* access modifiers changed from: package-private */
        public synchronized GifHeaderParser obtain(ByteBuffer byteBuffer) {
            GifHeaderParser poll;
            try {
                poll = this.pool.poll();
                if (poll == null) {
                    poll = new GifHeaderParser();
                }
            } catch (Throwable th) {
                throw th;
            }
            return poll.setData(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        public synchronized void release(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.clear();
            this.pool.offer(gifHeaderParser);
        }
    }

    public ByteBufferGifDecoder(Context context2) {
        this(context2, Glide.get(context2).getRegistry().getImageHeaderParsers(), Glide.get(context2).getBitmapPool(), Glide.get(context2).getArrayPool());
    }

    private static int getSampleSize(GifHeader gifHeader, int i10, int i11) {
        int i12;
        int min = Math.min(gifHeader.getHeight() / i11, gifHeader.getWidth() / i10);
        if (min == 0) {
            i12 = 0;
        } else {
            i12 = Integer.highestOneBit(min);
        }
        int max = Math.max(1, i12);
        if (Log.isLoggable(TAG, 2) && max > 1) {
            Log.v(TAG, "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i10 + "x" + i11 + "], actual dimens: [" + gifHeader.getWidth() + "x" + gifHeader.getHeight() + "]");
        }
        return max;
    }

    public GifDrawableResource decode(@NonNull ByteBuffer byteBuffer, int i10, int i11, @NonNull Options options) {
        GifHeaderParser obtain = this.parserPool.obtain(byteBuffer);
        try {
            return decode(byteBuffer, i10, i11, obtain, options);
        } finally {
            this.parserPool.release(obtain);
        }
    }

    public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull Options options) throws IOException {
        return !((Boolean) options.get(GifOptions.DISABLE_ANIMATION)).booleanValue() && ImageHeaderParserUtils.getType(this.parsers, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public ByteBufferGifDecoder(Context context2, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context2, list, bitmapPool, arrayPool, PARSER_POOL, GIF_DECODER_FACTORY);
    }

    @VisibleForTesting
    ByteBufferGifDecoder(Context context2, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, GifHeaderParserPool gifHeaderParserPool, GifDecoderFactory gifDecoderFactory2) {
        this.context = context2.getApplicationContext();
        this.parsers = list;
        this.gifDecoderFactory = gifDecoderFactory2;
        this.provider = new GifBitmapProvider(bitmapPool, arrayPool);
        this.parserPool = gifHeaderParserPool;
    }

    @Nullable
    private GifDrawableResource decode(ByteBuffer byteBuffer, int i10, int i11, GifHeaderParser gifHeaderParser, Options options) {
        Bitmap.Config config;
        long logTime = LogTime.getLogTime();
        try {
            GifHeader parseHeader = gifHeaderParser.parseHeader();
            if (parseHeader.getNumFrames() > 0) {
                if (parseHeader.getStatus() == 0) {
                    if (options.get(GifOptions.DECODE_FORMAT) == DecodeFormat.PREFER_RGB_565) {
                        config = Bitmap.Config.RGB_565;
                    } else {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    GifDecoder build = this.gifDecoderFactory.build(this.provider, parseHeader, byteBuffer, getSampleSize(parseHeader, i10, i11));
                    build.setDefaultBitmapConfig(config);
                    build.advance();
                    Bitmap nextFrame = build.getNextFrame();
                    if (nextFrame == null) {
                        if (Log.isLoggable(TAG, 2)) {
                            Log.v(TAG, "Decoded GIF from stream in " + LogTime.getElapsedMillis(logTime));
                        }
                        return null;
                    }
                    GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.context, build, UnitTransformation.get(), i10, i11, nextFrame));
                    if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, "Decoded GIF from stream in " + LogTime.getElapsedMillis(logTime));
                    }
                    return gifDrawableResource;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Decoded GIF from stream in " + LogTime.getElapsedMillis(logTime));
            }
        }
    }
}
