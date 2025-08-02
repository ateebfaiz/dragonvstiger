package com.bumptech.glide.load.resource;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.graphics.ImageDecoder$OnPartialImageListener;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;

@RequiresApi(api = 28)
public final class DefaultOnHeaderDecodedListener implements ImageDecoder$OnHeaderDecodedListener {
    private static final String TAG = "ImageDecoder";
    private final DecodeFormat decodeFormat;
    private final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();
    private final boolean isHardwareConfigAllowed;
    private final PreferredColorSpace preferredColorSpace;
    private final int requestedHeight;
    private final int requestedWidth;
    private final DownsampleStrategy strategy;

    public DefaultOnHeaderDecodedListener(int i10, int i11, @NonNull Options options) {
        boolean z10;
        this.requestedWidth = i10;
        this.requestedHeight = i11;
        this.decodeFormat = (DecodeFormat) options.get(Downsampler.DECODE_FORMAT);
        this.strategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        Option option = Downsampler.ALLOW_HARDWARE_CONFIG;
        if (options.get(option) == null || !((Boolean) options.get(option)).booleanValue()) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.isHardwareConfigAllowed = z10;
        this.preferredColorSpace = (PreferredColorSpace) options.get(Downsampler.PREFERRED_COLOR_SPACE);
    }

    public void onHeaderDecoded(@NonNull ImageDecoder imageDecoder, @NonNull ImageDecoder.ImageInfo imageInfo, @NonNull ImageDecoder.Source source) {
        ColorSpace.Named named;
        if (this.hardwareConfigState.isHardwareConfigAllowed(this.requestedWidth, this.requestedHeight, this.isHardwareConfigAllowed, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.decodeFormat == DecodeFormat.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new ImageDecoder$OnPartialImageListener() {
            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                return false;
            }
        });
        Size a10 = imageInfo.getSize();
        int i10 = this.requestedWidth;
        if (i10 == Integer.MIN_VALUE) {
            i10 = a10.getWidth();
        }
        int i11 = this.requestedHeight;
        if (i11 == Integer.MIN_VALUE) {
            i11 = a10.getHeight();
        }
        float scaleFactor = this.strategy.getScaleFactor(a10.getWidth(), a10.getHeight(), i10, i11);
        int round = Math.round(((float) a10.getWidth()) * scaleFactor);
        int round2 = Math.round(((float) a10.getHeight()) * scaleFactor);
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Resizing from [" + a10.getWidth() + "x" + a10.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + scaleFactor);
        }
        imageDecoder.setTargetSize(round, round2);
        PreferredColorSpace preferredColorSpace2 = this.preferredColorSpace;
        if (preferredColorSpace2 != null) {
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 28) {
                if (preferredColorSpace2 != PreferredColorSpace.DISPLAY_P3 || imageInfo.getColorSpace() == null || !imageInfo.getColorSpace().isWideGamut()) {
                    named = ColorSpace.Named.SRGB;
                } else {
                    named = ColorSpace.Named.DISPLAY_P3;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(named));
            } else if (i12 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }
}
