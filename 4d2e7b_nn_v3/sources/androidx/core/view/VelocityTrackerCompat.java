package androidx.core.view;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class VelocityTrackerCompat {
    private static Map<VelocityTracker, g0> sFallbackTrackers = Collections.synchronizedMap(new WeakHashMap());

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface VelocityTrackableMotionEventAxis {
    }

    private static class a {
        @DoNotInline
        static float a(VelocityTracker velocityTracker, int i10) {
            return velocityTracker.getAxisVelocity(i10);
        }

        @DoNotInline
        static float b(VelocityTracker velocityTracker, int i10, int i11) {
            return velocityTracker.getAxisVelocity(i10, i11);
        }

        @DoNotInline
        static boolean c(VelocityTracker velocityTracker, int i10) {
            return velocityTracker.isAxisSupported(i10);
        }
    }

    private VelocityTrackerCompat() {
    }

    public static void addMovement(@NonNull VelocityTracker velocityTracker, @NonNull MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            if (!sFallbackTrackers.containsKey(velocityTracker)) {
                sFallbackTrackers.put(velocityTracker, new g0());
            }
            sFallbackTrackers.get(velocityTracker).a(motionEvent);
        }
    }

    public static void clear(@NonNull VelocityTracker velocityTracker) {
        velocityTracker.clear();
        removeFallbackForTracker(velocityTracker);
    }

    public static void computeCurrentVelocity(@NonNull VelocityTracker velocityTracker, int i10, float f10) {
        velocityTracker.computeCurrentVelocity(i10, f10);
        g0 fallbackTrackerOrNull = getFallbackTrackerOrNull(velocityTracker);
        if (fallbackTrackerOrNull != null) {
            fallbackTrackerOrNull.c(i10, f10);
        }
    }

    public static float getAxisVelocity(@NonNull VelocityTracker velocityTracker, int i10) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.a(velocityTracker, i10);
        }
        if (i10 == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i10 == 1) {
            return velocityTracker.getYVelocity();
        }
        g0 fallbackTrackerOrNull = getFallbackTrackerOrNull(velocityTracker);
        if (fallbackTrackerOrNull != null) {
            return fallbackTrackerOrNull.d(i10);
        }
        return 0.0f;
    }

    @Nullable
    private static g0 getFallbackTrackerOrNull(VelocityTracker velocityTracker) {
        return sFallbackTrackers.get(velocityTracker);
    }

    @Deprecated
    public static float getXVelocity(VelocityTracker velocityTracker, int i10) {
        return velocityTracker.getXVelocity(i10);
    }

    @Deprecated
    public static float getYVelocity(VelocityTracker velocityTracker, int i10) {
        return velocityTracker.getYVelocity(i10);
    }

    public static boolean isAxisSupported(@NonNull VelocityTracker velocityTracker, int i10) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.c(velocityTracker, i10);
        }
        if (i10 == 26 || i10 == 0 || i10 == 1) {
            return true;
        }
        return false;
    }

    public static void recycle(@NonNull VelocityTracker velocityTracker) {
        velocityTracker.recycle();
        removeFallbackForTracker(velocityTracker);
    }

    private static void removeFallbackForTracker(VelocityTracker velocityTracker) {
        sFallbackTrackers.remove(velocityTracker);
    }

    public static void computeCurrentVelocity(@NonNull VelocityTracker velocityTracker, int i10) {
        computeCurrentVelocity(velocityTracker, i10, Float.MAX_VALUE);
    }

    public static float getAxisVelocity(@NonNull VelocityTracker velocityTracker, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.b(velocityTracker, i10, i11);
        }
        if (i10 == 0) {
            return velocityTracker.getXVelocity(i11);
        }
        if (i10 == 1) {
            return velocityTracker.getYVelocity(i11);
        }
        return 0.0f;
    }
}
