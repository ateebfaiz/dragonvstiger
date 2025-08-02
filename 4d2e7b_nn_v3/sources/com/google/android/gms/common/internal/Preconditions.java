package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.pdns.f;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.zzb;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@KeepForSdk
public final class Preconditions {
    private Preconditions() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static void checkArgument(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    @KeepForSdk
    public static double checkArgumentInRange(double d10, double d11, double d12, @NonNull String str) {
        if (d10 < d11) {
            throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too low)", str, Double.valueOf(d11), Double.valueOf(d12)));
        } else if (d10 <= d12) {
            return d10;
        } else {
            throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too high)", str, Double.valueOf(d11), Double.valueOf(d12)));
        }
    }

    @KeepForSdk
    public static void checkHandlerThread(@NonNull Handler handler) {
        String str;
        Looper myLooper = Looper.myLooper();
        if (myLooper != handler.getLooper()) {
            if (myLooper != null) {
                str = myLooper.getThread().getName();
            } else {
                str = "null current looper";
            }
            String name = handler.getLooper().getThread().getName();
            throw new IllegalStateException("Must be called on " + name + " thread, but got " + str + f.G);
        }
    }

    @KeepForSdk
    public static void checkMainThread() {
        checkMainThread("Must be called on the main application thread");
    }

    @CanIgnoreReturnValue
    @EnsuresNonNull({"#1"})
    @NonNull
    @KeepForSdk
    public static String checkNotEmpty(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    @KeepForSdk
    public static void checkNotMainThread() {
        checkNotMainThread("Must not be called on the main application thread");
    }

    @CanIgnoreReturnValue
    @EnsuresNonNull({"#1"})
    @NonNull
    @KeepForSdk
    public static <T> T checkNotNull(@Nullable T t10) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException("null reference");
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    public static int checkNotZero(int i10) {
        if (i10 != 0) {
            return i10;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    @KeepForSdk
    public static void checkState(boolean z10) {
        if (!z10) {
            throw new IllegalStateException();
        }
    }

    static String zza(String str, Object... objArr) {
        int indexOf;
        StringBuilder sb2 = new StringBuilder(str.length() + 48);
        int i10 = 0;
        int i11 = 0;
        while (i10 < 3 && (indexOf = str.indexOf("%s", i11)) != -1) {
            sb2.append(str.substring(i11, indexOf));
            sb2.append(objArr[i10]);
            i11 = indexOf + 2;
            i10++;
        }
        sb2.append(str.substring(i11));
        if (i10 < 3) {
            sb2.append(" [");
            sb2.append(objArr[i10]);
            for (int i12 = i10 + 1; i12 < 3; i12++) {
                sb2.append(", ");
                sb2.append(objArr[i12]);
            }
            sb2.append("]");
        }
        return sb2.toString();
    }

    @KeepForSdk
    public static void checkArgument(boolean z10, @NonNull Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @KeepForSdk
    public static void checkMainThread(@NonNull String str) {
        if (!zzb.zza()) {
            throw new IllegalStateException(str);
        }
    }

    @KeepForSdk
    public static void checkNotMainThread(@NonNull String str) {
        if (zzb.zza()) {
            throw new IllegalStateException(str);
        }
    }

    @CanIgnoreReturnValue
    @EnsuresNonNull({"#1"})
    @NonNull
    @KeepForSdk
    public static <T> T checkNotNull(@NonNull T t10, @NonNull Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    public static int checkNotZero(int i10, @NonNull Object obj) {
        if (i10 != 0) {
            return i10;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @KeepForSdk
    public static void checkState(boolean z10, @NonNull Object obj) {
        if (!z10) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    @KeepForSdk
    public static void checkArgument(boolean z10, @NonNull String str, @NonNull Object... objArr) {
        if (!z10) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    @EnsuresNonNull({"#1"})
    @NonNull
    @KeepForSdk
    public static String checkNotEmpty(@Nullable String str, @NonNull Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    public static long checkNotZero(long j10) {
        if (j10 != 0) {
            return j10;
        }
        throw new IllegalArgumentException("Given Long is zero");
    }

    @KeepForSdk
    public static void checkState(boolean z10, @NonNull String str, @NonNull Object... objArr) {
        if (!z10) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    @KeepForSdk
    public static float checkArgumentInRange(float f10, float f11, float f12, @NonNull String str) {
        if (f10 < f11) {
            throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f11), Float.valueOf(f12)));
        } else if (f10 <= f12) {
            return f10;
        } else {
            throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f11), Float.valueOf(f12)));
        }
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    public static long checkNotZero(long j10, @NonNull Object obj) {
        if (j10 != 0) {
            return j10;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    public static int checkArgumentInRange(int i10, int i11, int i12, @NonNull String str) {
        if (i10 < i11) {
            throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i11), Integer.valueOf(i12)));
        } else if (i10 <= i12) {
            return i10;
        } else {
            throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i11), Integer.valueOf(i12)));
        }
    }

    @KeepForSdk
    public static void checkHandlerThread(@NonNull Handler handler, @NonNull String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    @KeepForSdk
    public static long checkArgumentInRange(long j10, long j11, long j12, @NonNull String str) {
        if (j10 < j11) {
            throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too low)", str, Long.valueOf(j11), Long.valueOf(j12)));
        } else if (j10 <= j12) {
            return j10;
        } else {
            throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too high)", str, Long.valueOf(j11), Long.valueOf(j12)));
        }
    }
}
