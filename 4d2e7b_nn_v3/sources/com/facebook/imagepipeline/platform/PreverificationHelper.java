package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.soloader.f;

@f
public final class PreverificationHelper {
    @f
    @TargetApi(26)
    public final boolean shouldUseHardwareBitmapConfig(Bitmap.Config config) {
        if (config == Bitmap.Config.HARDWARE) {
            return true;
        }
        return false;
    }
}
