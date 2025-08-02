package androidx.core.util;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    public static float checkArgumentFinite(float f10, @NonNull String str) {
        if (Float.isNaN(f10)) {
            throw new IllegalArgumentException(str + " must not be NaN");
        } else if (!Float.isInfinite(f10)) {
            return f10;
        } else {
            throw new IllegalArgumentException(str + " must not be infinite");
        }
    }

    public static int checkArgumentInRange(int i10, int i11, int i12, @NonNull String str) {
        if (i10 < i11) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{str, Integer.valueOf(i11), Integer.valueOf(i12)}));
        } else if (i10 <= i12) {
            return i10;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{str, Integer.valueOf(i11), Integer.valueOf(i12)}));
        }
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i10, @Nullable String str) {
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalArgumentException(str);
    }

    public static int checkFlagsArgument(int i10, int i11) {
        if ((i10 & i11) == i10) {
            return i10;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i10) + ", but only 0x" + Integer.toHexString(i11) + " are allowed");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t10) {
        t10.getClass();
        return t10;
    }

    public static void checkState(boolean z10, @Nullable String str) {
        if (!z10) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t10) {
        if (!TextUtils.isEmpty(t10)) {
            return t10;
        }
        throw new IllegalArgumentException();
    }

    public static void checkArgument(boolean z10, @NonNull Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i10) {
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t10, @NonNull Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z10) {
        checkState(z10, (String) null);
    }

    public static void checkArgument(boolean z10, @NonNull String str, @NonNull Object... objArr) {
        if (!z10) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t10, @NonNull Object obj) {
        if (!TextUtils.isEmpty(t10)) {
            return t10;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t10, @NonNull String str, @NonNull Object... objArr) {
        if (!TextUtils.isEmpty(t10)) {
            return t10;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static long checkArgumentInRange(long j10, long j11, long j12, @NonNull String str) {
        if (j10 < j11) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{str, Long.valueOf(j11), Long.valueOf(j12)}));
        } else if (j10 <= j12) {
            return j10;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{str, Long.valueOf(j11), Long.valueOf(j12)}));
        }
    }

    public static float checkArgumentInRange(float f10, float f11, float f12, @NonNull String str) {
        if (f10 < f11) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{str, Float.valueOf(f11), Float.valueOf(f12)}));
        } else if (f10 <= f12) {
            return f10;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{str, Float.valueOf(f11), Float.valueOf(f12)}));
        }
    }

    public static double checkArgumentInRange(double d10, double d11, double d12, @NonNull String str) {
        if (d10 < d11) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{str, Double.valueOf(d11), Double.valueOf(d12)}));
        } else if (d10 <= d12) {
            return d10;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{str, Double.valueOf(d11), Double.valueOf(d12)}));
        }
    }
}
