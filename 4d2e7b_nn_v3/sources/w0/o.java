package w0;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import t0.d;
import x0.c;
import y0.k;

public class o implements n0 {

    /* renamed from: a  reason: collision with root package name */
    private int f24462a;

    public o(int i10) {
        this.f24462a = i10;
    }

    private d b(d dVar, List list) {
        int i10 = this.f24462a * 4;
        if (list.size() <= i10) {
            return dVar;
        }
        float[] e10 = dVar.e();
        int[] d10 = dVar.d();
        int size = (list.size() - i10) / 2;
        float[] fArr = new float[size];
        float[] fArr2 = new float[size];
        int i11 = 0;
        while (i10 < list.size()) {
            if (i10 % 2 == 0) {
                fArr[i11] = ((Float) list.get(i10)).floatValue();
            } else {
                fArr2[i11] = ((Float) list.get(i10)).floatValue();
                i11++;
            }
            i10++;
        }
        float[] e11 = e(dVar.e(), fArr);
        int length = e11.length;
        int[] iArr = new int[length];
        for (int i12 = 0; i12 < length; i12++) {
            float f10 = e11[i12];
            int binarySearch = Arrays.binarySearch(e10, f10);
            int binarySearch2 = Arrays.binarySearch(fArr, f10);
            if (binarySearch < 0 || binarySearch2 > 0) {
                if (binarySearch2 < 0) {
                    binarySearch2 = -(binarySearch2 + 1);
                }
                iArr[i12] = c(f10, fArr2[binarySearch2], e10, d10);
            } else {
                iArr[i12] = d(f10, d10[binarySearch], fArr, fArr2);
            }
        }
        return new d(e11, iArr);
    }

    private int d(float f10, int i10, float[] fArr, float[] fArr2) {
        float i11;
        if (fArr2.length < 2 || f10 <= fArr[0]) {
            return Color.argb((int) (fArr2[0] * 255.0f), Color.red(i10), Color.green(i10), Color.blue(i10));
        }
        for (int i12 = 1; i12 < fArr.length; i12++) {
            float f11 = fArr[i12];
            int i13 = (f11 > f10 ? 1 : (f11 == f10 ? 0 : -1));
            if (i13 >= 0 || i12 == fArr.length - 1) {
                if (i13 <= 0) {
                    i11 = fArr2[i12];
                } else {
                    int i14 = i12 - 1;
                    float f12 = fArr[i14];
                    i11 = k.i(fArr2[i14], fArr2[i12], (f10 - f12) / (f11 - f12));
                }
                return Color.argb((int) (i11 * 255.0f), Color.red(i10), Color.green(i10), Color.blue(i10));
            }
        }
        throw new IllegalArgumentException("Unreachable code.");
    }

    protected static float[] e(float[] fArr, float[] fArr2) {
        float f10;
        if (fArr.length == 0) {
            return fArr2;
        }
        if (fArr2.length == 0) {
            return fArr;
        }
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            float f11 = Float.NaN;
            if (i11 < fArr.length) {
                f10 = fArr[i11];
            } else {
                f10 = Float.NaN;
            }
            if (i12 < fArr2.length) {
                f11 = fArr2[i12];
            }
            if (Float.isNaN(f11) || f10 < f11) {
                fArr3[i13] = f10;
                i11++;
            } else if (Float.isNaN(f10) || f11 < f10) {
                fArr3[i13] = f11;
                i12++;
            } else {
                fArr3[i13] = f10;
                i11++;
                i12++;
                i10++;
            }
        }
        if (i10 == 0) {
            return fArr3;
        }
        return Arrays.copyOf(fArr3, length - i10);
    }

    /* access modifiers changed from: package-private */
    public int c(float f10, float f11, float[] fArr, int[] iArr) {
        if (iArr.length < 2 || f10 == fArr[0]) {
            return iArr[0];
        }
        int i10 = 1;
        while (i10 < fArr.length) {
            float f12 = fArr[i10];
            if (f12 < f10 && i10 != fArr.length - 1) {
                i10++;
            } else if (i10 == fArr.length - 1 && f10 >= f12) {
                return Color.argb((int) (f11 * 255.0f), Color.red(iArr[i10]), Color.green(iArr[i10]), Color.blue(iArr[i10]));
            } else {
                int i11 = i10 - 1;
                float f13 = fArr[i11];
                int c10 = y0.d.c((f10 - f13) / (f12 - f13), iArr[i11], iArr[i10]);
                return Color.argb((int) (f11 * 255.0f), Color.red(c10), Color.green(c10), Color.blue(c10));
            }
        }
        throw new IllegalArgumentException("Unreachable code.");
    }

    /* renamed from: f */
    public d a(c cVar, float f10) {
        boolean z10;
        ArrayList arrayList = new ArrayList();
        if (cVar.A() == c.b.BEGIN_ARRAY) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            cVar.b();
        }
        while (cVar.m()) {
            arrayList.add(Float.valueOf((float) cVar.p()));
        }
        if (arrayList.size() == 4 && ((Float) arrayList.get(0)).floatValue() == 1.0f) {
            arrayList.set(0, Float.valueOf(0.0f));
            arrayList.add(Float.valueOf(1.0f));
            arrayList.add((Float) arrayList.get(1));
            arrayList.add((Float) arrayList.get(2));
            arrayList.add((Float) arrayList.get(3));
            this.f24462a = 2;
        }
        if (z10) {
            cVar.j();
        }
        if (this.f24462a == -1) {
            this.f24462a = arrayList.size() / 4;
        }
        int i10 = this.f24462a;
        float[] fArr = new float[i10];
        int[] iArr = new int[i10];
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < this.f24462a * 4; i13++) {
            int i14 = i13 / 4;
            double floatValue = (double) ((Float) arrayList.get(i13)).floatValue();
            int i15 = i13 % 4;
            if (i15 == 0) {
                if (i14 > 0) {
                    float f11 = (float) floatValue;
                    if (fArr[i14 - 1] >= f11) {
                        fArr[i14] = f11 + 0.01f;
                    }
                }
                fArr[i14] = (float) floatValue;
            } else if (i15 == 1) {
                i11 = (int) (floatValue * 255.0d);
            } else if (i15 == 2) {
                i12 = (int) (floatValue * 255.0d);
            } else if (i15 == 3) {
                iArr[i14] = Color.argb(255, i11, i12, (int) (floatValue * 255.0d));
            }
        }
        return b(new d(fArr, iArr), arrayList);
    }
}
