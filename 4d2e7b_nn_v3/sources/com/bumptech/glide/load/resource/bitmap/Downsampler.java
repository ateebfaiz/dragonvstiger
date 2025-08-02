package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG;
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;
    private static final DecodeCallbacks EMPTY_CALLBACKS = new DecodeCallbacks() {
        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
        }

        public void onObtainBounds() {
        }
    };
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS;
    private static final String ICO_MIME_TYPE = "image/x-ico";
    private static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{WBMP_MIME_TYPE, ICO_MIME_TYPE})));
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = Util.createQueue(0);
    public static final Option<PreferredColorSpace> PREFERRED_COLOR_SPACE = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");
    static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();
    private final List<ImageHeaderParser> parsers;

    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void onObtainBounds();
    }

    static {
        Boolean bool = Boolean.FALSE;
        FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics2, BitmapPool bitmapPool2, ArrayPool arrayPool) {
        this.parsers = list;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics2);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool2);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    private static int adjustTargetDensityForError(double d10) {
        int densityMultiplier = getDensityMultiplier(d10);
        int round = round(((double) densityMultiplier) * d10);
        return round((d10 / ((double) (((float) round) / ((float) densityMultiplier)))) * ((double) round));
    }

    private void calculateConfig(ImageReader imageReader, DecodeFormat decodeFormat, boolean z10, boolean z11, BitmapFactory.Options options, int i10, int i11) {
        boolean z12;
        Bitmap.Config config;
        if (!this.hardwareConfigState.setHardwareConfigIfAllowed(i10, i11, options, z10, z11)) {
            if (decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
                try {
                    z12 = imageReader.getImageType().hasAlpha();
                } catch (IOException e10) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e10);
                    }
                    z12 = false;
                }
                if (z12) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                options.inPreferredConfig = config;
                if (config == Bitmap.Config.RGB_565) {
                    options.inDither = true;
                    return;
                }
                return;
            }
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        }
    }

    private static void calculateScaling(ImageHeaderParser.ImageType imageType, ImageReader imageReader, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2, DownsampleStrategy downsampleStrategy, int i10, int i11, int i12, int i13, int i14, BitmapFactory.Options options) throws IOException {
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        double floor;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i21 = i11;
        int i22 = i12;
        int i23 = i13;
        int i24 = i14;
        BitmapFactory.Options options2 = options;
        if (i21 <= 0 || i22 <= 0) {
            String str = TAG;
            String str2 = "x";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to determine dimensions for: " + imageType2 + " with target [" + i23 + str2 + i24 + "]");
                return;
            }
            return;
        }
        if (isRotationRequired(i10)) {
            i15 = i21;
            i16 = i22;
        } else {
            i16 = i21;
            i15 = i22;
        }
        float scaleFactor = downsampleStrategy2.getScaleFactor(i16, i15, i23, i24);
        if (scaleFactor > 0.0f) {
            DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy2.getSampleSizeRounding(i16, i15, i23, i24);
            if (sampleSizeRounding != null) {
                float f10 = (float) i16;
                float f11 = (float) i15;
                int round = i16 / round((double) (scaleFactor * f10));
                int round2 = i15 / round((double) (scaleFactor * f11));
                DownsampleStrategy.SampleSizeRounding sampleSizeRounding2 = DownsampleStrategy.SampleSizeRounding.MEMORY;
                if (sampleSizeRounding == sampleSizeRounding2) {
                    i17 = Math.max(round, round2);
                } else {
                    i17 = Math.min(round, round2);
                }
                int i25 = Build.VERSION.SDK_INT;
                String str3 = "x";
                String str4 = TAG;
                if (i25 > 23 || !NO_DOWNSAMPLE_PRE_N_MIME_TYPES.contains(options2.outMimeType)) {
                    int max = Math.max(1, Integer.highestOneBit(i17));
                    if (sampleSizeRounding == sampleSizeRounding2 && ((float) max) < 1.0f / scaleFactor) {
                        max <<= 1;
                    }
                    i18 = max;
                } else {
                    i18 = 1;
                }
                options2.inSampleSize = i18;
                if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                    float min = (float) Math.min(i18, 8);
                    i19 = (int) Math.ceil((double) (f10 / min));
                    i20 = (int) Math.ceil((double) (f11 / min));
                    int i26 = i18 / 8;
                    if (i26 > 0) {
                        i19 /= i26;
                        i20 /= i26;
                    }
                } else {
                    if (imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A) {
                        float f12 = (float) i18;
                        i19 = (int) Math.floor((double) (f10 / f12));
                        floor = Math.floor((double) (f11 / f12));
                    } else if (imageType.isWebp()) {
                        if (i25 >= 24) {
                            float f13 = (float) i18;
                            i19 = Math.round(f10 / f13);
                            i20 = Math.round(f11 / f13);
                        } else {
                            float f14 = (float) i18;
                            i19 = (int) Math.floor((double) (f10 / f14));
                            floor = Math.floor((double) (f11 / f14));
                        }
                    } else if (i16 % i18 == 0 && i15 % i18 == 0) {
                        i19 = i16 / i18;
                        i20 = i15 / i18;
                    } else {
                        int[] dimensions = getDimensions(imageReader, options2, decodeCallbacks, bitmapPool2);
                        i19 = dimensions[0];
                        i20 = dimensions[1];
                    }
                    i20 = (int) floor;
                }
                double scaleFactor2 = (double) downsampleStrategy2.getScaleFactor(i19, i20, i23, i24);
                options2.inTargetDensity = adjustTargetDensityForError(scaleFactor2);
                options2.inDensity = getDensityMultiplier(scaleFactor2);
                if (isScaling(options)) {
                    options2.inScaled = true;
                } else {
                    options2.inTargetDensity = 0;
                    options2.inDensity = 0;
                }
                String str5 = str4;
                if (Log.isLoggable(str5, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Calculate scaling, source: [");
                    sb2.append(i11);
                    String str6 = str3;
                    sb2.append(str6);
                    sb2.append(i12);
                    sb2.append("], degreesToRotate: ");
                    sb2.append(i10);
                    sb2.append(", target: [");
                    sb2.append(i23);
                    sb2.append(str6);
                    sb2.append(i24);
                    sb2.append("], power of two scaled: [");
                    sb2.append(i19);
                    sb2.append(str6);
                    sb2.append(i20);
                    sb2.append("], exact scale factor: ");
                    sb2.append(scaleFactor);
                    sb2.append(", power of 2 sample size: ");
                    sb2.append(i18);
                    sb2.append(", adjusted scale factor: ");
                    sb2.append(scaleFactor2);
                    sb2.append(", target density: ");
                    sb2.append(options2.inTargetDensity);
                    sb2.append(", density: ");
                    sb2.append(options2.inDensity);
                    Log.v(str5, sb2.toString());
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        int i27 = i21;
        String str7 = "x";
        throw new IllegalArgumentException("Cannot scale with factor: " + scaleFactor + " from: " + downsampleStrategy2 + ", source: [" + i27 + str7 + i22 + "], target: [" + i23 + str7 + i24 + "]");
    }

    private Bitmap decodeFromWrappedStreams(ImageReader imageReader, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z10, int i10, int i11, boolean z11, DecodeCallbacks decodeCallbacks) throws IOException {
        boolean z12;
        int i12;
        int i13;
        int i14;
        String str;
        int i15;
        ColorSpace.Named named;
        int i16;
        int i17;
        float f10;
        int i18;
        ImageReader imageReader2 = imageReader;
        BitmapFactory.Options options2 = options;
        PreferredColorSpace preferredColorSpace2 = preferredColorSpace;
        DecodeCallbacks decodeCallbacks2 = decodeCallbacks;
        long logTime = LogTime.getLogTime();
        int[] dimensions = getDimensions(imageReader2, options2, decodeCallbacks2, this.bitmapPool);
        int i19 = dimensions[0];
        int i20 = dimensions[1];
        String str2 = options2.outMimeType;
        if (i19 == -1 || i20 == -1) {
            z12 = false;
        } else {
            z12 = z10;
        }
        int imageOrientation = imageReader.getImageOrientation();
        int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(imageOrientation);
        boolean isExifOrientationRequired = TransformationUtils.isExifOrientationRequired(imageOrientation);
        int i21 = i10;
        if (i21 == Integer.MIN_VALUE) {
            i13 = i11;
            if (isRotationRequired(exifOrientationDegrees)) {
                i12 = i20;
            } else {
                i12 = i19;
            }
        } else {
            i13 = i11;
            i12 = i21;
        }
        if (i13 != Integer.MIN_VALUE) {
            i14 = i13;
        } else if (isRotationRequired(exifOrientationDegrees)) {
            i14 = i19;
        } else {
            i14 = i20;
        }
        ImageHeaderParser.ImageType imageType = imageReader.getImageType();
        ImageHeaderParser.ImageType imageType2 = imageType;
        calculateScaling(imageType, imageReader, decodeCallbacks, this.bitmapPool, downsampleStrategy, exifOrientationDegrees, i19, i20, i12, i14, options);
        String str3 = str2;
        int i22 = i20;
        int i23 = i19;
        DecodeCallbacks decodeCallbacks3 = decodeCallbacks2;
        PreferredColorSpace preferredColorSpace3 = preferredColorSpace2;
        BitmapFactory.Options options3 = options2;
        int i24 = imageOrientation;
        ImageReader imageReader3 = imageReader2;
        calculateConfig(imageReader, decodeFormat, z12, isExifOrientationRequired, options, i12, i14);
        int i25 = Build.VERSION.SDK_INT;
        if (shouldUsePool(imageType2)) {
            if (i23 < 0 || i22 < 0 || !z11) {
                if (isScaling(options)) {
                    f10 = ((float) options3.inTargetDensity) / ((float) options3.inDensity);
                } else {
                    f10 = 1.0f;
                }
                int i26 = options3.inSampleSize;
                float f11 = (float) i26;
                String str4 = TAG;
                int round = Math.round(((float) ((int) Math.ceil((double) (((float) i23) / f11)))) * f10);
                i16 = Math.round(((float) ((int) Math.ceil((double) (((float) i22) / f11)))) * f10);
                str = str4;
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Calculated target [");
                    sb2.append(round);
                    sb2.append("x");
                    sb2.append(i16);
                    i18 = round;
                    sb2.append("] for source [");
                    sb2.append(i23);
                    sb2.append("x");
                    sb2.append(i22);
                    sb2.append("], sampleSize: ");
                    sb2.append(i26);
                    sb2.append(", targetDensity: ");
                    sb2.append(options3.inTargetDensity);
                    sb2.append(", density: ");
                    sb2.append(options3.inDensity);
                    sb2.append(", density multiplier: ");
                    sb2.append(f10);
                    Log.v(str, sb2.toString());
                } else {
                    i18 = round;
                }
                i17 = i18;
            } else {
                str = TAG;
                i17 = i12;
                i16 = i14;
            }
            if (i17 > 0 && i16 > 0) {
                setInBitmap(options3, this.bitmapPool, i17, i16);
            }
        } else {
            str = TAG;
        }
        if (preferredColorSpace3 != null) {
            if (i25 >= 28) {
                if (preferredColorSpace3 != PreferredColorSpace.DISPLAY_P3 || options.outColorSpace == null || !options.outColorSpace.isWideGamut()) {
                    named = ColorSpace.Named.SRGB;
                } else {
                    named = ColorSpace.Named.DISPLAY_P3;
                }
                options3.inPreferredColorSpace = ColorSpace.get(named);
            } else if (i25 >= 26) {
                options3.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
        }
        Bitmap decodeStream = decodeStream(imageReader3, options3, decodeCallbacks3, this.bitmapPool);
        decodeCallbacks3.onDecodeComplete(this.bitmapPool, decodeStream);
        if (Log.isLoggable(str, 2)) {
            i15 = i24;
            logDecode(i23, i22, str3, options, decodeStream, i10, i11, logTime);
        } else {
            i15 = i24;
        }
        if (decodeStream == null) {
            return null;
        }
        decodeStream.setDensity(this.displayMetrics.densityDpi);
        Bitmap rotateImageExif = TransformationUtils.rotateImageExif(this.bitmapPool, decodeStream, i15);
        if (decodeStream.equals(rotateImageExif)) {
            return rotateImageExif;
        }
        this.bitmapPool.put(decodeStream);
        return rotateImageExif;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap decodeStream(com.bumptech.glide.load.resource.bitmap.ImageReader r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r7, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto L_0x000c
            r7.onObtainBounds()
            r5.stopGrowingBuffers()
        L_0x000c:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r4.lock()
            android.graphics.Bitmap r5 = r5.decodeBitmap(r6)     // Catch:{ IllegalArgumentException -> 0x0027 }
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            return r5
        L_0x0025:
            r5 = move-exception
            goto L_0x0050
        L_0x0027:
            r4 = move-exception
            java.io.IOException r1 = newIoExceptionForInBitmapAssertion(r4, r1, r2, r3, r6)     // Catch:{ all -> 0x0025 }
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch:{ all -> 0x0025 }
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch:{ all -> 0x0025 }
        L_0x0038:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x004f
            r8.put(r0)     // Catch:{ IOException -> 0x004e }
            r0 = 0
            r6.inBitmap = r0     // Catch:{ IOException -> 0x004e }
            android.graphics.Bitmap r5 = decodeStream(r5, r6, r7, r8)     // Catch:{ IOException -> 0x004e }
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            return r5
        L_0x004e:
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x004f:
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x0050:
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.decodeStream(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    @TargetApi(19)
    @Nullable
    private static String getBitmapString(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                resetOptions(poll);
            }
        }
        return poll;
    }

    private static int getDensityMultiplier(double d10) {
        if (d10 > 1.0d) {
            d10 = 1.0d / d10;
        }
        return (int) Math.round(d10 * 2.147483647E9d);
    }

    private static int[] getDimensions(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2) throws IOException {
        options.inJustDecodeBounds = true;
        decodeStream(imageReader, options, decodeCallbacks, bitmapPool2);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String getInBitmapString(BitmapFactory.Options options) {
        return getBitmapString(options.inBitmap);
    }

    private static boolean isRotationRequired(int i10) {
        return i10 == 90 || i10 == 270;
    }

    private static boolean isScaling(BitmapFactory.Options options) {
        int i10;
        int i11 = options.inTargetDensity;
        if (i11 <= 0 || (i10 = options.inDensity) <= 0 || i11 == i10) {
            return false;
        }
        return true;
    }

    private static void logDecode(int i10, int i11, String str, BitmapFactory.Options options, Bitmap bitmap, int i12, int i13, long j10) {
        Log.v(TAG, "Decoded " + getBitmapString(bitmap) + " from [" + i10 + "x" + i11 + "] " + str + " with inBitmap " + getInBitmapString(options) + " for [" + i12 + "x" + i13 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.getElapsedMillis(j10));
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException, int i10, int i11, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i10 + ", outHeight: " + i11 + ", outMimeType: " + str + ", inBitmap: " + getInBitmapString(options), illegalArgumentException);
    }

    private static void releaseOptions(BitmapFactory.Options options) {
        resetOptions(options);
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int round(double d10) {
        return (int) (d10 + 0.5d);
    }

    @TargetApi(26)
    private static void setInBitmap(BitmapFactory.Options options, BitmapPool bitmapPool2, int i10, int i11) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool2.getDirty(i10, i11, config);
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i10, int i11, Options options) throws IOException {
        return decode(inputStream, i10, i11, options, EMPTY_CALLBACKS);
    }

    public boolean handles(InputStream inputStream) {
        return true;
    }

    public Resource<Bitmap> decode(ByteBuffer byteBuffer, int i10, int i11, Options options) throws IOException {
        return decode((ImageReader) new ImageReader.ByteBufferReader(byteBuffer, this.parsers, this.byteArrayPool), i10, i11, options, EMPTY_CALLBACKS);
    }

    public boolean handles(ByteBuffer byteBuffer) {
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i10, int i11, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        return decode((ImageReader) new ImageReader.InputStreamImageReader(inputStream, this.parsers, this.byteArrayPool), i10, i11, options, decodeCallbacks);
    }

    public boolean handles(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.isSupported();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void decode(byte[] bArr, int i10, int i11, Options options) throws IOException {
        decode((ImageReader) new ImageReader.ByteArrayReader(bArr, this.parsers, this.byteArrayPool), i10, i11, options, EMPTY_CALLBACKS);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void decode(File file, int i10, int i11, Options options) throws IOException {
        decode((ImageReader) new ImageReader.FileReader(file, this.parsers, this.byteArrayPool), i10, i11, options, EMPTY_CALLBACKS);
    }

    @RequiresApi(21)
    public Resource<Bitmap> decode(ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, Options options) throws IOException {
        return decode((ImageReader) new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.parsers, this.byteArrayPool), i10, i11, options, EMPTY_CALLBACKS);
    }

    private Resource<Bitmap> decode(ImageReader imageReader, int i10, int i11, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        Options options2 = options;
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        BitmapFactory.Options defaultOptions = getDefaultOptions();
        defaultOptions.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options2.get(DECODE_FORMAT);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options2.get(PREFERRED_COLOR_SPACE);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options2.get(DownsampleStrategy.OPTION);
        boolean booleanValue = ((Boolean) options2.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option option = ALLOW_HARDWARE_CONFIG;
        try {
            return BitmapResource.obtain(decodeFromWrappedStreams(imageReader, defaultOptions, downsampleStrategy, decodeFormat, preferredColorSpace, options2.get(option) != null && ((Boolean) options2.get(option)).booleanValue(), i10, i11, booleanValue, decodeCallbacks), this.bitmapPool);
        } finally {
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr);
        }
    }
}
