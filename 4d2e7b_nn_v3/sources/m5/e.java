package m5;

import android.graphics.Matrix;
import e5.j;
import kotlin.jvm.internal.m;
import y2.f;
import y4.g;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f22614a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final f f22615b;

    static {
        f a10 = f.a(2, 7, 4, 5);
        m.e(a10, "of(\n          ExifInterf…ce.ORIENTATION_TRANSPOSE)");
        f22615b = a10;
    }

    private e() {
    }

    public static final int a(int i10) {
        return Math.max(1, 8 / i10);
    }

    public static final float b(y4.f fVar, int i10, int i11) {
        if (fVar == null) {
            return 1.0f;
        }
        float f10 = (float) i10;
        float f11 = (float) i11;
        float max = Math.max(((float) fVar.f24926a) / f10, ((float) fVar.f24927b) / f11);
        float f12 = fVar.f24928c;
        if (f10 * max > f12) {
            max = f12 / f10;
        }
        if (f11 * max > f12) {
            return f12 / f11;
        }
        return max;
    }

    private final int c(j jVar) {
        int l10 = jVar.l();
        if (l10 == 90 || l10 == 180 || l10 == 270) {
            return jVar.l();
        }
        return 0;
    }

    public static final int d(g gVar, j jVar) {
        int i10;
        m.f(gVar, "rotationOptions");
        m.f(jVar, "encodedImage");
        int F = jVar.F();
        f fVar = f22615b;
        int indexOf = fVar.indexOf(Integer.valueOf(F));
        if (indexOf >= 0) {
            if (!gVar.j()) {
                i10 = gVar.h();
            } else {
                i10 = 0;
            }
            Object obj = fVar.get((indexOf + (i10 / 90)) % fVar.size());
            m.e(obj, "INVERTED_EXIF_ORIENTATIO…D_EXIF_ORIENTATIONS.size]");
            return ((Number) obj).intValue();
        }
        throw new IllegalArgumentException("Only accepts inverted exif orientations".toString());
    }

    public static final int e(g gVar, j jVar) {
        m.f(gVar, "rotationOptions");
        m.f(jVar, "encodedImage");
        if (!gVar.i()) {
            return 0;
        }
        int c10 = f22614a.c(jVar);
        if (gVar.j()) {
            return c10;
        }
        return (c10 + gVar.h()) % 360;
    }

    public static final int f(g gVar, y4.f fVar, j jVar, boolean z10) {
        int i10;
        int i11;
        int i12;
        m.f(gVar, "rotationOptions");
        m.f(jVar, "encodedImage");
        if (!z10 || fVar == null) {
            return 8;
        }
        int e10 = e(gVar, jVar);
        boolean z11 = false;
        if (f22615b.contains(Integer.valueOf(jVar.F()))) {
            i10 = d(gVar, jVar);
        } else {
            i10 = 0;
        }
        if (e10 == 90 || e10 == 270 || i10 == 5 || i10 == 7) {
            z11 = true;
        }
        if (z11) {
            i11 = jVar.getHeight();
        } else {
            i11 = jVar.getWidth();
        }
        if (z11) {
            i12 = jVar.getWidth();
        } else {
            i12 = jVar.getHeight();
        }
        int k10 = k(b(fVar, i11, i12), fVar.f24929d);
        if (k10 > 8) {
            return 8;
        }
        if (k10 < 1) {
            return 1;
        }
        return k10;
    }

    public static final Matrix g(j jVar, g gVar) {
        m.f(jVar, "encodedImage");
        m.f(gVar, "rotationOptions");
        if (f22615b.contains(Integer.valueOf(jVar.F()))) {
            return f22614a.h(d(gVar, jVar));
        }
        int e10 = e(gVar, jVar);
        if (e10 == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) e10);
        return matrix;
    }

    private final Matrix h(int i10) {
        Matrix matrix = new Matrix();
        if (i10 == 2) {
            matrix.setScale(-1.0f, 1.0f);
        } else if (i10 == 7) {
            matrix.setRotate(-90.0f);
            matrix.postScale(-1.0f, 1.0f);
        } else if (i10 == 4) {
            matrix.setRotate(180.0f);
            matrix.postScale(-1.0f, 1.0f);
        } else if (i10 != 5) {
            return null;
        } else {
            matrix.setRotate(90.0f);
            matrix.postScale(-1.0f, 1.0f);
        }
        return matrix;
    }

    public static final boolean i(int i10) {
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static final boolean j(int i10) {
        if (i10 < 0 || i10 > 270 || i10 % 90 != 0) {
            return false;
        }
        return true;
    }

    public static final int k(float f10, float f11) {
        return (int) (f11 + (f10 * ((float) 8)));
    }
}
