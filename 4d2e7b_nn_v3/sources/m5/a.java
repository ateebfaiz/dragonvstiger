package m5;

import e5.j;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import q4.b;
import y4.f;
import y4.g;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f22612a = new a();

    private a() {
    }

    public static final float a(g gVar, f fVar, j jVar) {
        boolean z10;
        int i10;
        int i11;
        m.f(gVar, "rotationOptions");
        m.f(jVar, "encodedImage");
        if (!j.H(jVar)) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (fVar == null || fVar.f24927b <= 0 || fVar.f24926a <= 0 || jVar.getWidth() == 0 || jVar.getHeight() == 0) {
            return 1.0f;
        } else {
            int d10 = f22612a.d(gVar, jVar);
            if (d10 == 90 || d10 == 270) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                i10 = jVar.getHeight();
            } else {
                i10 = jVar.getWidth();
            }
            if (z10) {
                i11 = jVar.getWidth();
            } else {
                i11 = jVar.getHeight();
            }
            float f10 = ((float) fVar.f24926a) / ((float) i10);
            float f11 = ((float) fVar.f24927b) / ((float) i11);
            float b10 = l.b(f10, f11);
            z2.a.B("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f", Integer.valueOf(fVar.f24926a), Integer.valueOf(fVar.f24927b), Integer.valueOf(i10), Integer.valueOf(i11), Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(b10));
            return b10;
        }
    }

    public static final int b(g gVar, f fVar, j jVar, int i10) {
        int i11;
        float f10;
        int i12;
        m.f(gVar, "rotationOptions");
        m.f(jVar, "encodedImage");
        if (!j.H(jVar)) {
            return 1;
        }
        float a10 = a(gVar, fVar, jVar);
        if (jVar.v() == b.f23216b) {
            i11 = f(a10);
        } else {
            i11 = e(a10);
        }
        int max = Math.max(jVar.getHeight(), jVar.getWidth());
        if (fVar != null) {
            f10 = fVar.f24928c;
        } else {
            f10 = (float) i10;
        }
        while (((float) (max / i11)) > f10) {
            if (jVar.v() == b.f23216b) {
                i12 = i11 * 2;
            } else {
                i12 = i11 + 1;
            }
        }
        return i11;
    }

    public static final int c(j jVar, int i10, int i11) {
        m.f(jVar, "encodedImage");
        int z10 = jVar.z();
        while ((((jVar.getWidth() * jVar.getHeight()) * i10) / z10) / z10 > i11) {
            z10 *= 2;
        }
        return z10;
    }

    private final int d(g gVar, j jVar) {
        if (!gVar.j()) {
            return 0;
        }
        int l10 = jVar.l();
        if (l10 == 0 || l10 == 90 || l10 == 180 || l10 == 270) {
            return l10;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final int e(float f10) {
        if (f10 > 0.6666667f) {
            return 1;
        }
        int i10 = 2;
        while (true) {
            double d10 = (double) i10;
            if ((1.0d / d10) + ((1.0d / (Math.pow(d10, 2.0d) - d10)) * ((double) 0.33333334f)) <= ((double) f10)) {
                return i10 - 1;
            }
            i10++;
        }
    }

    public static final int f(float f10) {
        if (f10 > 0.6666667f) {
            return 1;
        }
        int i10 = 2;
        while (true) {
            int i11 = i10 * 2;
            double d10 = 1.0d / ((double) i11);
            if (d10 + (((double) 0.33333334f) * d10) <= ((double) f10)) {
                return i10;
            }
            i10 = i11;
        }
    }
}
