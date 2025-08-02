package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

public final class DisplayCompat {
    private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    static class a {
        static ModeCompat a(Context context, Display display) {
            Display.Mode mode = display.getMode();
            Point currentDisplaySizeFromWorkarounds = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
            if (currentDisplaySizeFromWorkarounds == null || d(mode, currentDisplaySizeFromWorkarounds)) {
                return new ModeCompat(mode, true);
            }
            return new ModeCompat(mode, currentDisplaySizeFromWorkarounds);
        }

        public static ModeCompat[] b(Context context, Display display) {
            ModeCompat modeCompat;
            Display.Mode[] supportedModes = display.getSupportedModes();
            ModeCompat[] modeCompatArr = new ModeCompat[supportedModes.length];
            Display.Mode mode = display.getMode();
            Point currentDisplaySizeFromWorkarounds = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
            if (currentDisplaySizeFromWorkarounds == null || d(mode, currentDisplaySizeFromWorkarounds)) {
                for (int i10 = 0; i10 < supportedModes.length; i10++) {
                    modeCompatArr[i10] = new ModeCompat(supportedModes[i10], e(supportedModes[i10], mode));
                }
            } else {
                for (int i11 = 0; i11 < supportedModes.length; i11++) {
                    if (e(supportedModes[i11], mode)) {
                        modeCompat = new ModeCompat(supportedModes[i11], currentDisplaySizeFromWorkarounds);
                    } else {
                        modeCompat = new ModeCompat(supportedModes[i11], false);
                    }
                    modeCompatArr[i11] = modeCompat;
                }
            }
            return modeCompatArr;
        }

        static boolean c(Display display) {
            Display.Mode mode = display.getMode();
            for (Display.Mode mode2 : display.getSupportedModes()) {
                if (mode.getPhysicalHeight() < mode2.getPhysicalHeight() || mode.getPhysicalWidth() < mode2.getPhysicalWidth()) {
                    return false;
                }
            }
            return true;
        }

        static boolean d(Display.Mode mode, Point point) {
            if ((mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) || (mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x)) {
                return true;
            }
            return false;
        }

        static boolean e(Display.Mode mode, Display.Mode mode2) {
            if (mode.getPhysicalWidth() == mode2.getPhysicalWidth() && mode.getPhysicalHeight() == mode2.getPhysicalHeight()) {
                return true;
            }
            return false;
        }
    }

    private DisplayCompat() {
    }

    static Point getCurrentDisplaySizeFromWorkarounds(@NonNull Context context, @NonNull Display display) {
        Point point;
        if (Build.VERSION.SDK_INT < 28) {
            point = parsePhysicalDisplaySizeFromSystemProperties("sys.display-size", display);
        } else {
            point = parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", display);
        }
        if (point != null) {
            return point;
        }
        if (!isSonyBravia4kTv(context) || !isCurrentModeTheLargestMode(display)) {
            return null;
        }
        return new Point(DISPLAY_SIZE_4K_WIDTH, DISPLAY_SIZE_4K_HEIGHT);
    }

    @NonNull
    private static Point getDisplaySize(@NonNull Context context, @NonNull Display display) {
        Point currentDisplaySizeFromWorkarounds = getCurrentDisplaySizeFromWorkarounds(context, display);
        if (currentDisplaySizeFromWorkarounds != null) {
            return currentDisplaySizeFromWorkarounds;
        }
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }

    @NonNull
    public static ModeCompat getMode(@NonNull Context context, @NonNull Display display) {
        return a.a(context, display);
    }

    @SuppressLint({"ArrayReturn"})
    @NonNull
    public static ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
        return a.b(context, display);
    }

    @Nullable
    private static String getSystemProperty(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception unused) {
            return null;
        }
    }

    static boolean isCurrentModeTheLargestMode(@NonNull Display display) {
        return a.c(display);
    }

    private static boolean isSonyBravia4kTv(@NonNull Context context) {
        if (!isTv(context) || !"Sony".equals(Build.MANUFACTURER) || !Build.MODEL.startsWith("BRAVIA") || !context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
            return false;
        }
        return true;
    }

    private static boolean isTv(@NonNull Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        if (uiModeManager == null || uiModeManager.getCurrentModeType() != 4) {
            return false;
        }
        return true;
    }

    private static Point parseDisplaySize(@NonNull String str) throws NumberFormatException {
        String[] split = str.trim().split("x", -1);
        if (split.length == 2) {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            if (parseInt > 0 && parseInt2 > 0) {
                return new Point(parseInt, parseInt2);
            }
        }
        throw new NumberFormatException();
    }

    @Nullable
    private static Point parsePhysicalDisplaySizeFromSystemProperties(@NonNull String str, @NonNull Display display) {
        if (display.getDisplayId() != 0) {
            return null;
        }
        String systemProperty = getSystemProperty(str);
        if (!TextUtils.isEmpty(systemProperty) && systemProperty != null) {
            try {
                return parseDisplaySize(systemProperty);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static final class ModeCompat {
        private final boolean mIsNative;
        private final Display.Mode mMode;
        private final Point mPhysicalSize;

        static class a {
            @DoNotInline
            static int a(Display.Mode mode) {
                return mode.getPhysicalHeight();
            }

            @DoNotInline
            static int b(Display.Mode mode) {
                return mode.getPhysicalWidth();
            }
        }

        ModeCompat(@NonNull Point point) {
            Preconditions.checkNotNull(point, "physicalSize == null");
            this.mPhysicalSize = point;
            this.mMode = null;
            this.mIsNative = true;
        }

        public int getPhysicalHeight() {
            return this.mPhysicalSize.y;
        }

        public int getPhysicalWidth() {
            return this.mPhysicalSize.x;
        }

        @Deprecated
        public boolean isNative() {
            return this.mIsNative;
        }

        @RequiresApi(23)
        @Nullable
        public Display.Mode toMode() {
            return this.mMode;
        }

        @RequiresApi(23)
        ModeCompat(@NonNull Display.Mode mode, boolean z10) {
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            this.mPhysicalSize = new Point(a.b(mode), a.a(mode));
            this.mMode = mode;
            this.mIsNative = z10;
        }

        @RequiresApi(23)
        ModeCompat(@NonNull Display.Mode mode, @NonNull Point point) {
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            Preconditions.checkNotNull(point, "physicalSize == null");
            this.mPhysicalSize = point;
            this.mMode = mode;
            this.mIsNative = true;
        }
    }
}
