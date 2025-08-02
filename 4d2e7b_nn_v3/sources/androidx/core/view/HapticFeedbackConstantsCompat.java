package androidx.core.view;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class HapticFeedbackConstantsCompat {
    public static final int CLOCK_TICK = 4;
    public static final int CONFIRM = 16;
    public static final int CONTEXT_CLICK = 6;
    public static final int DRAG_START = 25;
    @VisibleForTesting
    static final int FIRST_CONSTANT_INT = 0;
    public static final int FLAG_IGNORE_VIEW_SETTING = 1;
    public static final int GESTURE_END = 13;
    public static final int GESTURE_START = 12;
    public static final int GESTURE_THRESHOLD_ACTIVATE = 23;
    public static final int GESTURE_THRESHOLD_DEACTIVATE = 24;
    public static final int KEYBOARD_PRESS = 3;
    public static final int KEYBOARD_RELEASE = 7;
    public static final int KEYBOARD_TAP = 3;
    @VisibleForTesting
    static final int LAST_CONSTANT_INT = 27;
    public static final int LONG_PRESS = 0;
    public static final int NO_HAPTICS = -1;
    public static final int REJECT = 17;
    public static final int SEGMENT_FREQUENT_TICK = 27;
    public static final int SEGMENT_TICK = 26;
    public static final int TEXT_HANDLE_MOVE = 9;
    public static final int TOGGLE_OFF = 22;
    public static final int TOGGLE_ON = 21;
    public static final int VIRTUAL_KEY = 1;
    public static final int VIRTUAL_KEY_RELEASE = 8;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HapticFeedbackFlags {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HapticFeedbackType {
    }

    private HapticFeedbackConstantsCompat() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int getFeedbackConstantOrFallback(int r5) {
        /*
            r0 = -1
            if (r5 != r0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 34
            r3 = 6
            r4 = 0
            if (r1 >= r2) goto L_0x0015
            switch(r5) {
                case 21: goto L_0x0014;
                case 22: goto L_0x0012;
                case 23: goto L_0x0014;
                case 24: goto L_0x0012;
                case 25: goto L_0x0010;
                case 26: goto L_0x0014;
                case 27: goto L_0x0012;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0015
        L_0x0010:
            r5 = r4
            goto L_0x0015
        L_0x0012:
            r5 = 4
            goto L_0x0015
        L_0x0014:
            r5 = r3
        L_0x0015:
            r2 = 30
            if (r1 >= r2) goto L_0x002e
            r2 = 12
            if (r5 == r2) goto L_0x002c
            r2 = 13
            if (r5 == r2) goto L_0x002f
            r2 = 16
            if (r5 == r2) goto L_0x002c
            r2 = 17
            if (r5 == r2) goto L_0x002a
            goto L_0x002e
        L_0x002a:
            r3 = r4
            goto L_0x002f
        L_0x002c:
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = r5
        L_0x002f:
            r5 = 27
            if (r1 >= r5) goto L_0x003e
            r5 = 7
            if (r3 == r5) goto L_0x003f
            r5 = 8
            if (r3 == r5) goto L_0x003f
            r5 = 9
            if (r3 == r5) goto L_0x003f
        L_0x003e:
            r0 = r3
        L_0x003f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(int):int");
    }
}
