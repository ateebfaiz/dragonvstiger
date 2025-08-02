package androidx.constraintlayout.motion.utils;

import android.util.Log;
import java.util.Arrays;

public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = {STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    private static final String STANDARD_NAME = "standard";
    static Easing sDefault = new Easing();
    String str = "identity";

    static class a extends Easing {

        /* renamed from: e  reason: collision with root package name */
        private static double f14513e = 0.01d;

        /* renamed from: f  reason: collision with root package name */
        private static double f14514f = 1.0E-4d;

        /* renamed from: a  reason: collision with root package name */
        double f14515a;

        /* renamed from: b  reason: collision with root package name */
        double f14516b;

        /* renamed from: c  reason: collision with root package name */
        double f14517c;

        /* renamed from: d  reason: collision with root package name */
        double f14518d;

        a(String str) {
            this.str = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f14515a = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i10 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i10);
            this.f14516b = Double.parseDouble(str.substring(i10, indexOf3).trim());
            int i11 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i11);
            this.f14517c = Double.parseDouble(str.substring(i11, indexOf4).trim());
            int i12 = indexOf4 + 1;
            this.f14518d = Double.parseDouble(str.substring(i12, str.indexOf(41, i12)).trim());
        }

        private double a(double d10) {
            double d11 = 1.0d - d10;
            double d12 = 3.0d * d11;
            return (this.f14515a * d11 * d12 * d10) + (this.f14517c * d12 * d10 * d10) + (d10 * d10 * d10);
        }

        private double b(double d10) {
            double d11 = 1.0d - d10;
            double d12 = 3.0d * d11;
            return (this.f14516b * d11 * d12 * d10) + (this.f14518d * d12 * d10 * d10) + (d10 * d10 * d10);
        }

        public double get(double d10) {
            if (d10 <= 0.0d) {
                return 0.0d;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double d11 = 0.5d;
            double d12 = 0.5d;
            while (d11 > f14513e) {
                d11 *= 0.5d;
                if (a(d12) < d10) {
                    d12 += d11;
                } else {
                    d12 -= d11;
                }
            }
            double d13 = d12 - d11;
            double a10 = a(d13);
            double d14 = d12 + d11;
            double a11 = a(d14);
            double b10 = b(d13);
            return (((b(d14) - b10) * (d10 - a10)) / (a11 - a10)) + b10;
        }

        public double getDiff(double d10) {
            double d11 = 0.5d;
            double d12 = 0.5d;
            while (d11 > f14514f) {
                d11 *= 0.5d;
                if (a(d12) < d10) {
                    d12 += d11;
                } else {
                    d12 -= d11;
                }
            }
            double d13 = d12 - d11;
            double a10 = a(d13);
            double d14 = d12 + d11;
            return (b(d14) - b(d13)) / (a(d14) - a10);
        }
    }

    public static Easing getInterpolator(String str2) {
        if (str2 == null) {
            return null;
        }
        if (str2.startsWith("cubic")) {
            return new a(str2);
        }
        char c10 = 65535;
        switch (str2.hashCode()) {
            case -1354466595:
                if (str2.equals(ACCELERATE_NAME)) {
                    c10 = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str2.equals(DECELERATE_NAME)) {
                    c10 = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str2.equals(LINEAR_NAME)) {
                    c10 = 2;
                    break;
                }
                break;
            case 1312628413:
                if (str2.equals(STANDARD_NAME)) {
                    c10 = 3;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return new a(ACCELERATE);
            case 1:
                return new a(DECELERATE);
            case 2:
                return new a(LINEAR);
            case 3:
                return new a(STANDARD);
            default:
                Log.e("ConstraintSet", "transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                return sDefault;
        }
    }

    public double get(double d10) {
        return d10;
    }

    public double getDiff(double d10) {
        return 1.0d;
    }

    public String toString() {
        return this.str;
    }
}
