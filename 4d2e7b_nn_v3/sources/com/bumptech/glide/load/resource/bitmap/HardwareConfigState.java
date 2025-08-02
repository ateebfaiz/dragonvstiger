package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public final class HardwareConfigState {
    public static final boolean BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED;
    private static final File FD_SIZE_LIST = new File("/proc/self/fd");
    public static final boolean HARDWARE_BITMAPS_SUPPORTED;
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_O = 700;
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_P = 20000;
    private static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;
    @VisibleForTesting
    static final int MIN_HARDWARE_DIMENSION_O = 128;
    private static final int MIN_HARDWARE_DIMENSION_P = 0;
    public static final int NO_MAX_FD_COUNT = -1;
    private static final String TAG = "HardwareConfig";
    private static volatile HardwareConfigState instance;
    private static volatile int manualOverrideMaxFdCount = -1;
    @GuardedBy("this")
    private int decodesSinceLastFdCheck;
    @GuardedBy("this")
    private boolean isFdSizeBelowHardwareLimit = true;
    private final AtomicBoolean isHardwareConfigAllowedByAppState = new AtomicBoolean(false);
    private final boolean isHardwareConfigAllowedByDeviceModel = isHardwareConfigAllowedByDeviceModel();
    private final int minHardwareDimension;
    private final int sdkBasedMaxFdCount;

    static {
        boolean z10;
        int i10 = Build.VERSION.SDK_INT;
        boolean z11 = false;
        if (i10 < 29) {
            z10 = true;
        } else {
            z10 = false;
        }
        BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED = z10;
        if (i10 >= 26) {
            z11 = true;
        }
        HARDWARE_BITMAPS_SUPPORTED = z11;
    }

    @VisibleForTesting
    HardwareConfigState() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.sdkBasedMaxFdCount = 20000;
            this.minHardwareDimension = 0;
            return;
        }
        this.sdkBasedMaxFdCount = MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_O;
        this.minHardwareDimension = 128;
    }

    private boolean areHardwareBitmapsBlockedByAppState() {
        if (!BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED || this.isHardwareConfigAllowedByAppState.get()) {
            return false;
        }
        return true;
    }

    public static HardwareConfigState getInstance() {
        if (instance == null) {
            synchronized (HardwareConfigState.class) {
                try {
                    if (instance == null) {
                        instance = new HardwareConfigState();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    private int getMaxFdCount() {
        if (manualOverrideMaxFdCount != -1) {
            return manualOverrideMaxFdCount;
        }
        return this.sdkBasedMaxFdCount;
    }

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        try {
            boolean z10 = true;
            int i10 = this.decodesSinceLastFdCheck + 1;
            this.decodesSinceLastFdCheck = i10;
            if (i10 >= 50) {
                this.decodesSinceLastFdCheck = 0;
                int length = FD_SIZE_LIST.list().length;
                long maxFdCount = (long) getMaxFdCount();
                if (((long) length) >= maxFdCount) {
                    z10 = false;
                }
                this.isFdSizeBelowHardwareLimit = z10;
                if (!z10 && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + maxFdCount);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.isFdSizeBelowHardwareLimit;
    }

    private static boolean isHardwareConfigAllowedByDeviceModel() {
        if (isHardwareConfigDisallowedByB112551574() || isHardwareConfigDisallowedByB147430447()) {
            return false;
        }
        return true;
    }

    private static boolean isHardwareConfigDisallowedByB112551574() {
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        for (String startsWith : Arrays.asList(new String[]{"SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play"})) {
            if (Build.MODEL.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isHardwareConfigDisallowedByB147430447() {
        if (Build.VERSION.SDK_INT != 27) {
            return false;
        }
        return Arrays.asList(new String[]{"LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM"}).contains(Build.MODEL);
    }

    public boolean areHardwareBitmapsBlocked() {
        Util.assertMainThread();
        return !this.isHardwareConfigAllowedByAppState.get();
    }

    public void blockHardwareBitmaps() {
        Util.assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(false);
    }

    public boolean isHardwareConfigAllowed(int i10, int i11, boolean z10, boolean z11) {
        if (!z10) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Hardware config disallowed by caller");
            }
            return false;
        } else if (!this.isHardwareConfigAllowedByDeviceModel) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Hardware config disallowed by device model");
            }
            return false;
        } else if (!HARDWARE_BITMAPS_SUPPORTED) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Hardware config disallowed by sdk");
            }
            return false;
        } else if (areHardwareBitmapsBlockedByAppState()) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Hardware config disallowed by app state");
            }
            return false;
        } else if (z11) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Hardware config disallowed because exif orientation is required");
            }
            return false;
        } else {
            int i12 = this.minHardwareDimension;
            if (i10 < i12) {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Hardware config disallowed because width is too small");
                }
                return false;
            } else if (i11 < i12) {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Hardware config disallowed because height is too small");
                }
                return false;
            } else if (isFdSizeBelowHardwareLimit()) {
                return true;
            } else {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Hardware config disallowed because there are insufficient FDs");
                }
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(26)
    public boolean setHardwareConfigIfAllowed(int i10, int i11, BitmapFactory.Options options, boolean z10, boolean z11) {
        boolean isHardwareConfigAllowed = isHardwareConfigAllowed(i10, i11, z10, z11);
        if (isHardwareConfigAllowed) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return isHardwareConfigAllowed;
    }

    public void unblockHardwareBitmaps() {
        Util.assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(true);
    }
}
