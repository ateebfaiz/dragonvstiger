package com.fasterxml.jackson.core.io;

import androidx.exifinterface.media.ExifInterface;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static int f5154a = 1000000;

    /* renamed from: b  reason: collision with root package name */
    private static int f5155b = 1000000000;

    /* renamed from: c  reason: collision with root package name */
    private static long f5156c = 1000000000;

    /* renamed from: d  reason: collision with root package name */
    private static long f5157d = -2147483648L;

    /* renamed from: e  reason: collision with root package name */
    private static long f5158e = 2147483647L;

    /* renamed from: f  reason: collision with root package name */
    static final String f5159f = String.valueOf(Integer.MIN_VALUE);

    /* renamed from: g  reason: collision with root package name */
    static final String f5160g = String.valueOf(Long.MIN_VALUE);

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f5161h = new int[1000];

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f5162i = {"0", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", DbParams.GZIP_DATA_ENCRYPT, "10"};

    /* renamed from: j  reason: collision with root package name */
    private static final String[] f5163j = {"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};

    static {
        int i10 = 0;
        for (int i11 = 0; i11 < 10; i11++) {
            for (int i12 = 0; i12 < 10; i12++) {
                int i13 = 0;
                while (i13 < 10) {
                    f5161h[i10] = ((i11 + 48) << 16) | ((i12 + 48) << 8) | (i13 + 48);
                    i13++;
                    i10++;
                }
            }
        }
    }

    private static int a(int i10, char[] cArr, int i11) {
        int i12 = f5161h[i10];
        cArr[i11] = (char) (i12 >> 16);
        int i13 = i11 + 2;
        cArr[i11 + 1] = (char) ((i12 >> 8) & 127);
        int i14 = i11 + 3;
        cArr[i13] = (char) (i12 & 127);
        return i14;
    }

    private static int b(int i10, char[] cArr, int i11) {
        int i12 = f5161h[i10];
        if (i10 > 9) {
            if (i10 > 99) {
                cArr[i11] = (char) (i12 >> 16);
                i11++;
            }
            cArr[i11] = (char) ((i12 >> 8) & 127);
            i11++;
        }
        int i13 = i11 + 1;
        cArr[i11] = (char) (i12 & 127);
        return i13;
    }

    private static int c(int i10, char[] cArr, int i11) {
        int i12 = i10 / 1000;
        int i13 = i10 - (i12 * 1000);
        int i14 = i12 / 1000;
        int[] iArr = f5161h;
        int i15 = iArr[i14];
        cArr[i11] = (char) (i15 >> 16);
        cArr[i11 + 1] = (char) ((i15 >> 8) & 127);
        cArr[i11 + 2] = (char) (i15 & 127);
        int i16 = iArr[i12 - (i14 * 1000)];
        cArr[i11 + 3] = (char) (i16 >> 16);
        cArr[i11 + 4] = (char) ((i16 >> 8) & 127);
        cArr[i11 + 5] = (char) (i16 & 127);
        int i17 = iArr[i13];
        cArr[i11 + 6] = (char) (i17 >> 16);
        int i18 = i11 + 8;
        cArr[i11 + 7] = (char) ((i17 >> 8) & 127);
        int i19 = i11 + 9;
        cArr[i18] = (char) (i17 & 127);
        return i19;
    }

    private static int d(char[] cArr, int i10) {
        String str = f5159f;
        int length = str.length();
        str.getChars(0, length, cArr, i10);
        return i10 + length;
    }

    private static int e(char[] cArr, int i10) {
        String str = f5160g;
        int length = str.length();
        str.getChars(0, length, cArr, i10);
        return i10 + length;
    }

    private static int f(int i10, char[] cArr, int i11) {
        if (i10 >= f5154a) {
            int i12 = i10 / 1000;
            int i13 = i10 - (i12 * 1000);
            int i14 = i12 / 1000;
            int b10 = b(i14, cArr, i11);
            int[] iArr = f5161h;
            int i15 = iArr[i12 - (i14 * 1000)];
            cArr[b10] = (char) (i15 >> 16);
            cArr[b10 + 1] = (char) ((i15 >> 8) & 127);
            cArr[b10 + 2] = (char) (i15 & 127);
            int i16 = iArr[i13];
            cArr[b10 + 3] = (char) (i16 >> 16);
            int i17 = b10 + 5;
            cArr[b10 + 4] = (char) ((i16 >> 8) & 127);
            int i18 = b10 + 6;
            cArr[i17] = (char) (i16 & 127);
            return i18;
        } else if (i10 < 1000) {
            return b(i10, cArr, i11);
        } else {
            int i19 = i10 / 1000;
            return g(cArr, i11, i19, i10 - (i19 * 1000));
        }
    }

    private static int g(char[] cArr, int i10, int i11, int i12) {
        int[] iArr = f5161h;
        int i13 = iArr[i11];
        if (i11 > 9) {
            if (i11 > 99) {
                cArr[i10] = (char) (i13 >> 16);
                i10++;
            }
            cArr[i10] = (char) ((i13 >> 8) & 127);
            i10++;
        }
        cArr[i10] = (char) (i13 & 127);
        int i14 = iArr[i12];
        cArr[i10 + 1] = (char) (i14 >> 16);
        int i15 = i10 + 3;
        cArr[i10 + 2] = (char) ((i14 >> 8) & 127);
        int i16 = i10 + 4;
        cArr[i15] = (char) (i14 & 127);
        return i16;
    }

    public static boolean h(double d10) {
        if (Double.isNaN(d10) || Double.isInfinite(d10)) {
            return true;
        }
        return false;
    }

    public static boolean i(float f10) {
        if (Float.isNaN(f10) || Float.isInfinite(f10)) {
            return true;
        }
        return false;
    }

    public static int j(int i10, char[] cArr, int i11) {
        int i12;
        if (i10 < 0) {
            if (i10 == Integer.MIN_VALUE) {
                return d(cArr, i11);
            }
            cArr[i11] = '-';
            i10 = -i10;
            i11++;
        }
        if (i10 >= f5154a) {
            int i13 = f5155b;
            if (i10 >= i13) {
                int i14 = i10 - i13;
                if (i14 >= i13) {
                    i14 -= i13;
                    i12 = i11 + 1;
                    cArr[i11] = '2';
                } else {
                    i12 = i11 + 1;
                    cArr[i11] = '1';
                }
                return c(i14, cArr, i12);
            }
            int i15 = i10 / 1000;
            int i16 = i15 / 1000;
            return a(i10 - (i15 * 1000), cArr, a(i15 - (i16 * 1000), cArr, b(i16, cArr, i11)));
        } else if (i10 >= 1000) {
            int i17 = i10 / 1000;
            return a(i10 - (i17 * 1000), cArr, b(i17, cArr, i11));
        } else if (i10 >= 10) {
            return b(i10, cArr, i11);
        } else {
            cArr[i11] = (char) (i10 + 48);
            return i11 + 1;
        }
    }

    public static int k(long j10, char[] cArr, int i10) {
        int i11;
        if (j10 < 0) {
            if (j10 > f5157d) {
                return j((int) j10, cArr, i10);
            }
            if (j10 == Long.MIN_VALUE) {
                return e(cArr, i10);
            }
            cArr[i10] = '-';
            j10 = -j10;
            i10++;
        } else if (j10 <= f5158e) {
            return j((int) j10, cArr, i10);
        }
        long j11 = f5156c;
        long j12 = j10 / j11;
        long j13 = j10 - (j12 * j11);
        if (j12 < j11) {
            i11 = f((int) j12, cArr, i10);
        } else {
            long j14 = j12 / j11;
            int b10 = b((int) j14, cArr, i10);
            i11 = c((int) (j12 - (j11 * j14)), cArr, b10);
        }
        return c((int) j13, cArr, i11);
    }
}
