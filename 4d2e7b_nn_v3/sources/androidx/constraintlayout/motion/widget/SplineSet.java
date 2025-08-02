package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int count;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints = new int[10];
    private String mType;
    protected float[] mValues = new float[10];

    static class a extends SplineSet {
        a() {
        }

        public void setProperty(View view, float f10) {
            view.setAlpha(get(f10));
        }
    }

    static class b extends SplineSet {

        /* renamed from: a  reason: collision with root package name */
        String f14621a;

        /* renamed from: b  reason: collision with root package name */
        SparseArray f14622b;

        /* renamed from: c  reason: collision with root package name */
        float[] f14623c;

        public b(String str, SparseArray sparseArray) {
            this.f14621a = str.split(",")[1];
            this.f14622b = sparseArray;
        }

        public void a(int i10, ConstraintAttribute constraintAttribute) {
            this.f14622b.append(i10, constraintAttribute);
        }

        public void setPoint(int i10, float f10) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setProperty(View view, float f10) {
            this.mCurveFit.getPos((double) f10, this.f14623c);
            ((ConstraintAttribute) this.f14622b.valueAt(0)).setInterpolatedValue(view, this.f14623c);
        }

        public void setup(int i10) {
            int size = this.f14622b.size();
            int noOfInterpValues = ((ConstraintAttribute) this.f14622b.valueAt(0)).noOfInterpValues();
            double[] dArr = new double[size];
            this.f14623c = new float[noOfInterpValues];
            int[] iArr = new int[2];
            iArr[1] = noOfInterpValues;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i11 = 0; i11 < size; i11++) {
                dArr[i11] = ((double) this.f14622b.keyAt(i11)) * 0.01d;
                ((ConstraintAttribute) this.f14622b.valueAt(i11)).getValuesToInterpolate(this.f14623c);
                int i12 = 0;
                while (true) {
                    float[] fArr = this.f14623c;
                    if (i12 >= fArr.length) {
                        break;
                    }
                    dArr2[i11][i12] = (double) fArr[i12];
                    i12++;
                }
            }
            this.mCurveFit = CurveFit.get(i10, dArr, dArr2);
        }
    }

    static class c extends SplineSet {
        c() {
        }

        public void setProperty(View view, float f10) {
            view.setElevation(get(f10));
        }
    }

    static class d extends SplineSet {
        d() {
        }

        public void a(View view, float f10, double d10, double d11) {
            view.setRotation(get(f10) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
        }

        public void setProperty(View view, float f10) {
        }
    }

    static class e extends SplineSet {
        e() {
        }

        public void setProperty(View view, float f10) {
            view.setPivotX(get(f10));
        }
    }

    static class f extends SplineSet {
        f() {
        }

        public void setProperty(View view, float f10) {
            view.setPivotY(get(f10));
        }
    }

    static class g extends SplineSet {

        /* renamed from: a  reason: collision with root package name */
        boolean f14624a = false;

        g() {
        }

        public void setProperty(View view, float f10) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f10));
            } else if (!this.f14624a) {
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f14624a = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(get(f10))});
                    } catch (IllegalAccessException e10) {
                        Log.e(SplineSet.TAG, "unable to setProgress", e10);
                    } catch (InvocationTargetException e11) {
                        Log.e(SplineSet.TAG, "unable to setProgress", e11);
                    }
                }
            }
        }
    }

    static class h extends SplineSet {
        h() {
        }

        public void setProperty(View view, float f10) {
            view.setRotation(get(f10));
        }
    }

    static class i extends SplineSet {
        i() {
        }

        public void setProperty(View view, float f10) {
            view.setRotationX(get(f10));
        }
    }

    static class j extends SplineSet {
        j() {
        }

        public void setProperty(View view, float f10) {
            view.setRotationY(get(f10));
        }
    }

    static class k extends SplineSet {
        k() {
        }

        public void setProperty(View view, float f10) {
            view.setScaleX(get(f10));
        }
    }

    static class l extends SplineSet {
        l() {
        }

        public void setProperty(View view, float f10) {
            view.setScaleY(get(f10));
        }
    }

    private static class m {
        static void a(int[] iArr, float[] fArr, int i10, int i11) {
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i11;
            iArr2[1] = i10;
            int i12 = 2;
            while (i12 > 0) {
                int i13 = iArr2[i12 - 1];
                int i14 = i12 - 2;
                int i15 = iArr2[i14];
                if (i13 < i15) {
                    int b10 = b(iArr, fArr, i13, i15);
                    iArr2[i14] = b10 - 1;
                    iArr2[i12 - 1] = i13;
                    int i16 = i12 + 1;
                    iArr2[i12] = i15;
                    i12 += 2;
                    iArr2[i16] = b10 + 1;
                } else {
                    i12 = i14;
                }
            }
        }

        private static int b(int[] iArr, float[] fArr, int i10, int i11) {
            int i12 = iArr[i11];
            int i13 = i10;
            while (i10 < i11) {
                if (iArr[i10] <= i12) {
                    c(iArr, fArr, i13, i10);
                    i13++;
                }
                i10++;
            }
            c(iArr, fArr, i13, i11);
            return i13;
        }

        private static void c(int[] iArr, float[] fArr, int i10, int i11) {
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
            float f10 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = f10;
        }
    }

    static class n extends SplineSet {
        n() {
        }

        public void setProperty(View view, float f10) {
            view.setTranslationX(get(f10));
        }
    }

    static class o extends SplineSet {
        o() {
        }

        public void setProperty(View view, float f10) {
            view.setTranslationY(get(f10));
        }
    }

    static class p extends SplineSet {
        p() {
        }

        public void setProperty(View view, float f10) {
            view.setTranslationZ(get(f10));
        }
    }

    static SplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new b(str, sparseArray);
    }

    static SplineSet makeSpline(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c10 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c10 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    c10 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c10 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c10 = 7;
                    break;
                }
                break;
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c10 = 8;
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c10 = 9;
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c10 = 10;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c10 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c10 = 12;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c10 = 13;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c10 = 14;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c10 = 15;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return new i();
            case 1:
                return new j();
            case 2:
                return new n();
            case 3:
                return new o();
            case 4:
                return new p();
            case 5:
                return new g();
            case 6:
                return new k();
            case 7:
                return new l();
            case 8:
                return new a();
            case 9:
                return new e();
            case 10:
                return new f();
            case 11:
                return new h();
            case 12:
                return new c();
            case 13:
                return new d();
            case 14:
                return new a();
            case 15:
                return new a();
            default:
                return null;
        }
    }

    public float get(float f10) {
        return (float) this.mCurveFit.getPos((double) f10, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f10) {
        return (float) this.mCurveFit.getSlope((double) f10, 0);
    }

    public void setPoint(int i10, float f10) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.count + 1) {
            this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i11 = this.count;
        iArr2[i11] = i10;
        this.mValues[i11] = f10;
        this.count = i11 + 1;
    }

    public abstract void setProperty(View view, float f10);

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i10) {
        int i11 = this.count;
        if (i11 != 0) {
            m.a(this.mTimePoints, this.mValues, 0, i11 - 1);
            int i12 = 1;
            for (int i13 = 1; i13 < this.count; i13++) {
                int[] iArr = this.mTimePoints;
                if (iArr[i13 - 1] != iArr[i13]) {
                    i12++;
                }
            }
            double[] dArr = new double[i12];
            int[] iArr2 = new int[2];
            iArr2[1] = 1;
            iArr2[0] = i12;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr2);
            int i14 = 0;
            for (int i15 = 0; i15 < this.count; i15++) {
                if (i15 > 0) {
                    int[] iArr3 = this.mTimePoints;
                    if (iArr3[i15] == iArr3[i15 - 1]) {
                    }
                }
                dArr[i14] = ((double) this.mTimePoints[i15]) * 0.01d;
                dArr2[i14][0] = (double) this.mValues[i15];
                i14++;
            }
            this.mCurveFit = CurveFit.get(i10, dArr, dArr2);
        }
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.count; i10++) {
            str = str + "[" + this.mTimePoints[i10] + " , " + decimalFormat.format((double) this.mValues[i10]) + "] ";
        }
        return str;
    }
}
