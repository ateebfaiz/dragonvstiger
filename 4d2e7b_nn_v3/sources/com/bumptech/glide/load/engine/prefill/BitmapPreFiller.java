package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.util.Util;
import java.util.HashMap;

public final class BitmapPreFiller {
    private final BitmapPool bitmapPool;
    private BitmapPreFillRunner current;
    private final DecodeFormat defaultFormat;
    private final MemoryCache memoryCache;

    public BitmapPreFiller(MemoryCache memoryCache2, BitmapPool bitmapPool2, DecodeFormat decodeFormat) {
        this.memoryCache = memoryCache2;
        this.bitmapPool = bitmapPool2;
        this.defaultFormat = decodeFormat;
    }

    private static int getSizeInBytes(PreFillType preFillType) {
        return Util.getBitmapByteSize(preFillType.getWidth(), preFillType.getHeight(), preFillType.getConfig());
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public PreFillQueue generateAllocationOrder(PreFillType... preFillTypeArr) {
        long maxSize = (this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize()) + this.bitmapPool.getMaxSize();
        int i10 = 0;
        for (PreFillType weight : preFillTypeArr) {
            i10 += weight.getWeight();
        }
        float f10 = ((float) maxSize) / ((float) i10);
        HashMap hashMap = new HashMap();
        for (PreFillType preFillType : preFillTypeArr) {
            hashMap.put(preFillType, Integer.valueOf(Math.round(((float) preFillType.getWeight()) * f10) / getSizeInBytes(preFillType)));
        }
        return new PreFillQueue(hashMap);
    }

    public void preFill(PreFillType.Builder... builderArr) {
        Bitmap.Config config;
        BitmapPreFillRunner bitmapPreFillRunner = this.current;
        if (bitmapPreFillRunner != null) {
            bitmapPreFillRunner.cancel();
        }
        PreFillType[] preFillTypeArr = new PreFillType[builderArr.length];
        for (int i10 = 0; i10 < builderArr.length; i10++) {
            PreFillType.Builder builder = builderArr[i10];
            if (builder.getConfig() == null) {
                if (this.defaultFormat == DecodeFormat.PREFER_ARGB_8888) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                builder.setConfig(config);
            }
            preFillTypeArr[i10] = builder.build();
        }
        BitmapPreFillRunner bitmapPreFillRunner2 = new BitmapPreFillRunner(this.bitmapPool, this.memoryCache, generateAllocationOrder(preFillTypeArr));
        this.current = bitmapPreFillRunner2;
        Util.postOnUiThread(bitmapPreFillRunner2);
    }
}
