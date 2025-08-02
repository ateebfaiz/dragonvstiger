package androidx.core.math;

import androidx.core.location.LocationRequestCompat;

public class MathUtils {
    private MathUtils() {
    }

    public static int addExact(int i10, int i11) {
        int i12 = i10 + i11;
        boolean z10 = false;
        if ((i10 >= 0) == (i11 >= 0)) {
            boolean z11 = i10 >= 0;
            if (i12 >= 0) {
                z10 = true;
            }
            if (z11 != z10) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i12;
    }

    public static double clamp(double d10, double d11, double d12) {
        if (d10 < d11) {
            return d11;
        }
        return d10 > d12 ? d12 : d10;
    }

    public static int decrementExact(int i10) {
        if (i10 != Integer.MIN_VALUE) {
            return i10 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int i10) {
        if (i10 != Integer.MAX_VALUE) {
            return i10 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i10, int i11) {
        int i12 = i10 * i11;
        if (i10 == 0 || i11 == 0 || (i12 / i10 == i11 && i12 / i11 == i10)) {
            return i12;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int negateExact(int i10) {
        if (i10 != Integer.MIN_VALUE) {
            return -i10;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int i10, int i11) {
        int i12 = i10 - i11;
        boolean z10 = false;
        if ((i10 < 0) != (i11 < 0)) {
            boolean z11 = i10 < 0;
            if (i12 < 0) {
                z10 = true;
            }
            if (z11 != z10) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i12;
    }

    public static int toIntExact(long j10) {
        if (j10 <= 2147483647L && j10 >= -2147483648L) {
            return (int) j10;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long addExact(long j10, long j11) {
        long j12 = j10 + j11;
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        boolean z10 = false;
        if ((i10 >= 0) == (j11 >= 0)) {
            boolean z11 = i10 >= 0;
            if (j12 >= 0) {
                z10 = true;
            }
            if (z11 != z10) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j12;
    }

    public static float clamp(float f10, float f11, float f12) {
        if (f10 < f11) {
            return f11;
        }
        return f10 > f12 ? f12 : f10;
    }

    public static long decrementExact(long j10) {
        if (j10 != Long.MIN_VALUE) {
            return j10 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long j10) {
        if (j10 != LocationRequestCompat.PASSIVE_INTERVAL) {
            return j10 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long j10) {
        if (j10 != Long.MIN_VALUE) {
            return -j10;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long j10, long j11) {
        long j12 = j10 - j11;
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        boolean z10 = false;
        if ((i10 < 0) != (j11 < 0)) {
            boolean z11 = i10 < 0;
            if (j12 < 0) {
                z10 = true;
            }
            if (z11 != z10) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j12;
    }

    public static int clamp(int i10, int i11, int i12) {
        if (i10 < i11) {
            return i11;
        }
        return i10 > i12 ? i12 : i10;
    }

    public static long multiplyExact(long j10, long j11) {
        long j12 = j10 * j11;
        if (j10 == 0 || j11 == 0 || (j12 / j10 == j11 && j12 / j11 == j10)) {
            return j12;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long clamp(long j10, long j11, long j12) {
        if (j10 < j11) {
            return j11;
        }
        return j10 > j12 ? j12 : j10;
    }
}
