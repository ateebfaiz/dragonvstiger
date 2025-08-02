package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TimeUtils {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static char[] sFormatStr = new char[24];
    private static final Object sFormatSync = new Object();

    private TimeUtils() {
    }

    private static int accumField(int i10, int i11, boolean z10, int i12) {
        if (i10 > 99 || (z10 && i12 >= 3)) {
            return i11 + 3;
        }
        if (i10 > 9 || (z10 && i12 >= 2)) {
            return i11 + 2;
        }
        if (z10 || i10 > 0) {
            return i11 + 1;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j10, StringBuilder sb2) {
        synchronized (sFormatSync) {
            sb2.append(sFormatStr, 0, formatDurationLocked(j10, 0));
        }
    }

    private static int formatDurationLocked(long j10, int i10) {
        char c10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z10;
        boolean z11;
        int i16;
        boolean z12;
        int i17;
        boolean z13;
        int i18;
        int i19;
        boolean z14;
        boolean z15;
        boolean z16;
        int i20;
        long j11 = j10;
        int i21 = i10;
        if (sFormatStr.length < i21) {
            sFormatStr = new char[i21];
        }
        char[] cArr = sFormatStr;
        int i22 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i22 == 0) {
            int i23 = i21 - 1;
            while (i23 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i22 > 0) {
            c10 = '+';
        } else {
            j11 = -j11;
            c10 = '-';
        }
        int i24 = (int) (j11 % 1000);
        int floor = (int) Math.floor((double) (j11 / 1000));
        if (floor > SECONDS_PER_DAY) {
            i11 = floor / SECONDS_PER_DAY;
            floor -= SECONDS_PER_DAY * i11;
        } else {
            i11 = 0;
        }
        if (floor > SECONDS_PER_HOUR) {
            i12 = floor / SECONDS_PER_HOUR;
            floor -= i12 * SECONDS_PER_HOUR;
        } else {
            i12 = 0;
        }
        if (floor > 60) {
            int i25 = floor / 60;
            i13 = floor - (i25 * 60);
            i14 = i25;
        } else {
            i13 = floor;
            i14 = 0;
        }
        if (i21 != 0) {
            int accumField = accumField(i11, 1, false, 0);
            if (accumField > 0) {
                z14 = true;
            } else {
                z14 = false;
            }
            int accumField2 = accumField + accumField(i12, 1, z14, 2);
            if (accumField2 > 0) {
                z15 = true;
            } else {
                z15 = false;
            }
            int accumField3 = accumField2 + accumField(i14, 1, z15, 2);
            if (accumField3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int accumField4 = accumField3 + accumField(i13, 1, z16, 2);
            if (accumField4 > 0) {
                i20 = 3;
            } else {
                i20 = 0;
            }
            i15 = 0;
            for (int accumField5 = accumField4 + accumField(i24, 2, true, i20) + 1; accumField5 < i21; accumField5++) {
                cArr[i15] = ' ';
                i15++;
            }
        } else {
            i15 = 0;
        }
        cArr[i15] = c10;
        int i26 = i15 + 1;
        if (i21 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i27 = i26;
        int printField = printField(cArr, i11, 'd', i26, false, 0);
        if (printField != i27) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10) {
            i16 = 2;
        } else {
            i16 = 0;
        }
        int printField2 = printField(cArr, i12, 'h', printField, z11, i16);
        if (printField2 != i27) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z10) {
            i17 = 2;
        } else {
            i17 = 0;
        }
        int printField3 = printField(cArr, i14, 'm', printField2, z12, i17);
        if (printField3 != i27) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z10) {
            i18 = 2;
        } else {
            i18 = 0;
        }
        int printField4 = printField(cArr, i13, 's', printField3, z13, i18);
        if (!z10 || printField4 == i27) {
            i19 = 0;
        } else {
            i19 = 3;
        }
        int printField5 = printField(cArr, i24, 'm', printField4, true, i19);
        cArr[printField5] = 's';
        return printField5 + 1;
    }

    private static int printField(char[] cArr, int i10, char c10, int i11, boolean z10, int i12) {
        int i13;
        if (!z10 && i10 <= 0) {
            return i11;
        }
        if ((!z10 || i12 < 3) && i10 <= 99) {
            i13 = i11;
        } else {
            int i14 = i10 / 100;
            cArr[i11] = (char) (i14 + 48);
            i13 = i11 + 1;
            i10 -= i14 * 100;
        }
        if ((z10 && i12 >= 2) || i10 > 9 || i11 != i13) {
            int i15 = i10 / 10;
            cArr[i13] = (char) (i15 + 48);
            i13++;
            i10 -= i15 * 10;
        }
        cArr[i13] = (char) (i10 + 48);
        cArr[i13 + 1] = c10;
        return i13 + 2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j10, PrintWriter printWriter, int i10) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j10, i10)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j10, PrintWriter printWriter) {
        formatDuration(j10, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j10, long j11, PrintWriter printWriter) {
        if (j10 == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j10 - j11, printWriter, 0);
        }
    }
}
