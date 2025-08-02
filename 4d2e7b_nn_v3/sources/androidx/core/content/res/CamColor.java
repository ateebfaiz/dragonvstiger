package androidx.core.content.res;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    CamColor(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.mHue = f10;
        this.mChroma = f11;
        this.mJ = f12;
        this.mQ = f13;
        this.mM = f14;
        this.mS = f15;
        this.mJstar = f16;
        this.mAstar = f17;
        this.mBstar = f18;
    }

    @Nullable
    private static CamColor findCamByJ(@FloatRange(from = 0.0d, to = 360.0d) float f10, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f11, @FloatRange(from = 0.0d, to = 100.0d) float f12) {
        float f13 = 100.0f;
        float f14 = 1000.0f;
        float f15 = 0.0f;
        CamColor camColor = null;
        float f16 = 1000.0f;
        while (Math.abs(f15 - f13) > LIGHTNESS_SEARCH_ENDPOINT) {
            float f17 = ((f13 - f15) / 2.0f) + f15;
            int viewedInSrgb = fromJch(f17, f11, f10).viewedInSrgb();
            float b10 = a.b(viewedInSrgb);
            float abs = Math.abs(f12 - b10);
            if (abs < 0.2f) {
                CamColor fromColor = fromColor(viewedInSrgb);
                float distance = fromColor.distance(fromJch(fromColor.getJ(), fromColor.getChroma(), f10));
                if (distance <= 1.0f) {
                    camColor = fromColor;
                    f14 = abs;
                    f16 = distance;
                }
            }
            if (f14 == 0.0f && f16 == 0.0f) {
                break;
            } else if (b10 < f12) {
                f15 = f17;
            } else {
                f13 = f17;
            }
        }
        return camColor;
    }

    @NonNull
    static CamColor fromColor(@ColorInt int i10) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        fromColorInViewingConditions(i10, g.f14907k, fArr, fArr2);
        return new CamColor(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    static void fromColorInViewingConditions(@ColorInt int i10, @NonNull g gVar, @Size(7) @Nullable float[] fArr, @Size(3) @NonNull float[] fArr2) {
        float f10;
        float[] fArr3 = fArr2;
        a.f(i10, fArr3);
        float[][] fArr4 = a.f14896a;
        float f11 = fArr3[0];
        float[] fArr5 = fArr4[0];
        float f12 = fArr3[1];
        float f13 = fArr3[2];
        float f14 = (fArr5[0] * f11) + (fArr5[1] * f12) + (fArr5[2] * f13);
        float[] fArr6 = fArr4[1];
        float f15 = (fArr6[0] * f11) + (fArr6[1] * f12) + (fArr6[2] * f13);
        float[] fArr7 = fArr4[2];
        float f16 = gVar.i()[0] * f14;
        float f17 = gVar.i()[1] * f15;
        float f18 = gVar.i()[2] * ((f11 * fArr7[0]) + (f12 * fArr7[1]) + (f13 * fArr7[2]));
        float pow = (float) Math.pow(((double) (gVar.c() * Math.abs(f16))) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow(((double) (gVar.c() * Math.abs(f17))) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow(((double) (gVar.c() * Math.abs(f18))) / 100.0d, 0.42d);
        float signum = ((Math.signum(f16) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f17) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f18) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d10 = (double) signum3;
        float f19 = ((float) (((((double) signum) * 11.0d) + (((double) signum2) * -12.0d)) + d10)) / 11.0f;
        float f20 = ((float) (((double) (signum + signum2)) - (d10 * 2.0d))) / 9.0f;
        float f21 = signum2 * 20.0f;
        float f22 = (((signum * 20.0f) + f21) + (21.0f * signum3)) / 20.0f;
        float f23 = (((signum * 40.0f) + f21) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2((double) f20, (double) f19)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f24 = (3.1415927f * atan2) / 180.0f;
        float f25 = f22;
        float f26 = f20;
        float pow4 = ((float) Math.pow((double) ((f23 * gVar.f()) / gVar.a()), (double) (gVar.b() * gVar.j()))) * 100.0f;
        float b10 = (4.0f / gVar.b()) * ((float) Math.sqrt((double) (pow4 / 100.0f))) * (gVar.a() + 4.0f) * gVar.d();
        if (((double) atan2) < 20.14d) {
            f10 = 360.0f + atan2;
        } else {
            f10 = atan2;
        }
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, (double) gVar.e()), 0.73d)) * ((float) Math.pow((double) ((((((((float) (Math.cos(((((double) f10) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * gVar.g()) * gVar.h()) * ((float) Math.sqrt((double) ((f19 * f19) + (f26 * f26))))) / (f25 + 0.305f)), 0.9d));
        float sqrt = ((float) Math.sqrt(((double) pow4) / 100.0d)) * pow5;
        float d11 = gVar.d() * sqrt;
        float sqrt2 = ((float) Math.sqrt((double) ((pow5 * gVar.b()) / (gVar.a() + 4.0f)))) * 50.0f;
        float f27 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((double) ((0.0228f * d11) + 1.0f))) * 43.85965f;
        double d12 = (double) f24;
        float cos = ((float) Math.cos(d12)) * log;
        float sin = log * ((float) Math.sin(d12));
        fArr3[0] = atan2;
        fArr3[1] = sqrt;
        if (fArr != null) {
            fArr[0] = pow4;
            fArr[1] = b10;
            fArr[2] = d11;
            fArr[3] = sqrt2;
            fArr[4] = f27;
            fArr[5] = cos;
            fArr[6] = sin;
        }
    }

    @NonNull
    private static CamColor fromJch(@FloatRange(from = 0.0d, to = 100.0d) float f10, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f11, @FloatRange(from = 0.0d, to = 360.0d) float f12) {
        return fromJchInFrame(f10, f11, f12, g.f14907k);
    }

    @NonNull
    private static CamColor fromJchInFrame(@FloatRange(from = 0.0d, to = 100.0d) float f10, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f11, @FloatRange(from = 0.0d, to = 360.0d) float f12, g gVar) {
        float f13 = f10;
        double d10 = ((double) f13) / 100.0d;
        float b10 = (4.0f / gVar.b()) * ((float) Math.sqrt(d10)) * (gVar.a() + 4.0f) * gVar.d();
        float d11 = f11 * gVar.d();
        float sqrt = ((float) Math.sqrt((double) (((f11 / ((float) Math.sqrt(d10))) * gVar.b()) / (gVar.a() + 4.0f)))) * 50.0f;
        float f14 = (1.7f * f13) / ((0.007f * f13) + 1.0f);
        float log = ((float) Math.log((((double) d11) * 0.0228d) + 1.0d)) * 43.85965f;
        double d12 = (double) ((3.1415927f * f12) / 180.0f);
        return new CamColor(f12, f11, f13, b10, d11, sqrt, f14, log * ((float) Math.cos(d12)), log * ((float) Math.sin(d12)));
    }

    public static void getM3HCTfromColor(@ColorInt int i10, @Size(3) @NonNull float[] fArr) {
        fromColorInViewingConditions(i10, g.f14907k, (float[]) null, fArr);
        fArr[2] = a.b(i10);
    }

    public static int toColor(@FloatRange(from = 0.0d, to = 360.0d) float f10, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f11, @FloatRange(from = 0.0d, to = 100.0d) float f12) {
        return toColor(f10, f11, f12, g.f14907k);
    }

    /* access modifiers changed from: package-private */
    public float distance(@NonNull CamColor camColor) {
        float jStar = getJStar() - camColor.getJStar();
        float aStar = getAStar() - camColor.getAStar();
        float bStar = getBStar() - camColor.getBStar();
        return (float) (Math.pow(Math.sqrt((double) ((jStar * jStar) + (aStar * aStar) + (bStar * bStar))), 0.63d) * 1.41d);
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = Double.NEGATIVE_INFINITY, fromInclusive = false, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getAStar() {
        return this.mAstar;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = Double.NEGATIVE_INFINITY, fromInclusive = false, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getBStar() {
        return this.mBstar;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getChroma() {
        return this.mChroma;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = 360.0d, toInclusive = false)
    public float getHue() {
        return this.mHue;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = 100.0d)
    public float getJ() {
        return this.mJ;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = 100.0d)
    public float getJStar() {
        return this.mJstar;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getM() {
        return this.mM;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getQ() {
        return this.mQ;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getS() {
        return this.mS;
    }

    /* access modifiers changed from: package-private */
    @ColorInt
    public int viewed(@NonNull g gVar) {
        float f10;
        if (((double) getChroma()) == 0.0d || ((double) getJ()) == 0.0d) {
            f10 = 0.0f;
        } else {
            f10 = getChroma() / ((float) Math.sqrt(((double) getJ()) / 100.0d));
        }
        float pow = (float) Math.pow(((double) f10) / Math.pow(1.64d - Math.pow(0.29d, (double) gVar.e()), 0.73d), 1.1111111111111112d);
        double hue = (double) ((getHue() * 3.1415927f) / 180.0f);
        float a10 = gVar.a() * ((float) Math.pow(((double) getJ()) / 100.0d, (1.0d / ((double) gVar.b())) / ((double) gVar.j())));
        float cos = ((float) (Math.cos(2.0d + hue) + 3.8d)) * 0.25f * 3846.1538f * gVar.g() * gVar.h();
        float f11 = a10 / gVar.f();
        float sin = (float) Math.sin(hue);
        float cos2 = (float) Math.cos(hue);
        float f12 = (((0.305f + f11) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f13 = cos2 * f12;
        float f14 = f12 * sin;
        float f15 = f11 * 460.0f;
        float f16 = (((451.0f * f13) + f15) + (288.0f * f14)) / 1403.0f;
        float f17 = ((f15 - (891.0f * f13)) - (261.0f * f14)) / 1403.0f;
        float f18 = ((f15 - (f13 * 220.0f)) - (f14 * 6300.0f)) / 1403.0f;
        float signum = Math.signum(f16) * (100.0f / gVar.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f16)) * 27.13d) / (400.0d - ((double) Math.abs(f16))))), 2.380952380952381d));
        float signum2 = Math.signum(f17) * (100.0f / gVar.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f17)) * 27.13d) / (400.0d - ((double) Math.abs(f17))))), 2.380952380952381d));
        float signum3 = Math.signum(f18) * (100.0f / gVar.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f18)) * 27.13d) / (400.0d - ((double) Math.abs(f18))))), 2.380952380952381d));
        float f19 = signum / gVar.i()[0];
        float f20 = signum2 / gVar.i()[1];
        float f21 = signum3 / gVar.i()[2];
        float[][] fArr = a.f14897b;
        float[] fArr2 = fArr[0];
        float f22 = (fArr2[0] * f19) + (fArr2[1] * f20) + (fArr2[2] * f21);
        float[] fArr3 = fArr[1];
        float[] fArr4 = fArr[2];
        return ColorUtils.XYZToColor((double) f22, (double) ((fArr3[0] * f19) + (fArr3[1] * f20) + (fArr3[2] * f21)), (double) ((f19 * fArr4[0]) + (f20 * fArr4[1]) + (f21 * fArr4[2])));
    }

    /* access modifiers changed from: package-private */
    @ColorInt
    public int viewedInSrgb() {
        return viewed(g.f14907k);
    }

    @ColorInt
    static int toColor(@FloatRange(from = 0.0d, to = 360.0d) float f10, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f11, @FloatRange(from = 0.0d, to = 100.0d) float f12, @NonNull g gVar) {
        float f13;
        if (((double) f11) < 1.0d || ((double) Math.round(f12)) <= 0.0d || ((double) Math.round(f12)) >= 100.0d) {
            return a.a(f12);
        }
        if (f10 < 0.0f) {
            f13 = 0.0f;
        } else {
            f13 = Math.min(360.0f, f10);
        }
        CamColor camColor = null;
        boolean z10 = true;
        float f14 = 0.0f;
        float f15 = f11;
        while (Math.abs(f14 - f11) >= CHROMA_SEARCH_ENDPOINT) {
            CamColor findCamByJ = findCamByJ(f13, f15, f12);
            if (!z10) {
                if (findCamByJ == null) {
                    f11 = f15;
                } else {
                    f14 = f15;
                    camColor = findCamByJ;
                }
                f15 = ((f11 - f14) / 2.0f) + f14;
            } else if (findCamByJ != null) {
                return findCamByJ.viewed(gVar);
            } else {
                f15 = ((f11 - f14) / 2.0f) + f14;
                z10 = false;
            }
        }
        if (camColor == null) {
            return a.a(f12);
        }
        return camColor.viewed(gVar);
    }
}
