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

public abstract class TimeCycleSplineSet {
    private static final int CURVE_OFFSET = 2;
    private static final int CURVE_PERIOD = 1;
    private static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    private static float VAL_2PI = 6.2831855f;
    private int count;
    float last_cycle;
    long last_time;
    private float[] mCache;
    protected boolean mContinue;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints = new int[10];
    private String mType;
    protected float[][] mValues;
    protected int mWaveShape = 0;

    static class a extends TimeCycleSplineSet {
        a() {
        }

        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setAlpha(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    static class b extends TimeCycleSplineSet {

        /* renamed from: a  reason: collision with root package name */
        String f14625a;

        /* renamed from: b  reason: collision with root package name */
        SparseArray f14626b;

        /* renamed from: c  reason: collision with root package name */
        SparseArray f14627c = new SparseArray();

        /* renamed from: d  reason: collision with root package name */
        float[] f14628d;

        /* renamed from: e  reason: collision with root package name */
        float[] f14629e;

        public b(String str, SparseArray sparseArray) {
            this.f14625a = str.split(",")[1];
            this.f14626b = sparseArray;
        }

        public void a(int i10, ConstraintAttribute constraintAttribute, float f10, int i11, float f11) {
            this.f14626b.append(i10, constraintAttribute);
            this.f14627c.append(i10, new float[]{f10, f11});
            this.mWaveShape = Math.max(this.mWaveShape, i11);
        }

        public void setPoint(int i10, float f10, float f11, int i11, float f12) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            boolean z10;
            this.mCurveFit.getPos((double) f10, this.f14628d);
            float[] fArr = this.f14628d;
            float f11 = fArr[fArr.length - 2];
            float f12 = fArr[fArr.length - 1];
            float f13 = (float) ((((double) this.last_cycle) + ((((double) (j10 - this.last_time)) * 1.0E-9d) * ((double) f11))) % 1.0d);
            this.last_cycle = f13;
            this.last_time = j10;
            float calcWave = calcWave(f13);
            this.mContinue = false;
            int i10 = 0;
            while (true) {
                float[] fArr2 = this.f14629e;
                if (i10 >= fArr2.length) {
                    break;
                }
                boolean z11 = this.mContinue;
                float f14 = this.f14628d[i10];
                if (((double) f14) != 0.0d) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.mContinue = z11 | z10;
                fArr2[i10] = (f14 * calcWave) + f12;
                i10++;
            }
            ((ConstraintAttribute) this.f14626b.valueAt(0)).setInterpolatedValue(view, this.f14629e);
            if (f11 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        public void setup(int i10) {
            int size = this.f14626b.size();
            int noOfInterpValues = ((ConstraintAttribute) this.f14626b.valueAt(0)).noOfInterpValues();
            double[] dArr = new double[size];
            int i11 = noOfInterpValues + 2;
            this.f14628d = new float[i11];
            this.f14629e = new float[noOfInterpValues];
            int[] iArr = new int[2];
            iArr[1] = i11;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i12 = 0; i12 < size; i12++) {
                int keyAt = this.f14626b.keyAt(i12);
                float[] fArr = (float[]) this.f14627c.valueAt(i12);
                dArr[i12] = ((double) keyAt) * 0.01d;
                ((ConstraintAttribute) this.f14626b.valueAt(i12)).getValuesToInterpolate(this.f14628d);
                int i13 = 0;
                while (true) {
                    float[] fArr2 = this.f14628d;
                    if (i13 >= fArr2.length) {
                        break;
                    }
                    dArr2[i12][i13] = (double) fArr2[i13];
                    i13++;
                }
                double[] dArr3 = dArr2[i12];
                dArr3[noOfInterpValues] = (double) fArr[0];
                dArr3[noOfInterpValues + 1] = (double) fArr[1];
            }
            this.mCurveFit = CurveFit.get(i10, dArr, dArr2);
        }
    }

    static class c extends TimeCycleSplineSet {
        c() {
        }

        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setElevation(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    static class d extends TimeCycleSplineSet {
        d() {
        }

        public boolean a(View view, KeyCache keyCache, float f10, long j10, double d10, double d11) {
            view.setRotation(get(f10, j10, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
            return this.mContinue;
        }

        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            return this.mContinue;
        }
    }

    static class e extends TimeCycleSplineSet {

        /* renamed from: a  reason: collision with root package name */
        boolean f14630a = false;

        e() {
        }

        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            Method method;
            View view2 = view;
            if (view2 instanceof MotionLayout) {
                ((MotionLayout) view2).setProgress(get(f10, j10, view, keyCache));
            } else if (this.f14630a) {
                return false;
            } else {
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f14630a = true;
                    method = null;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, new Object[]{Float.valueOf(get(f10, j10, view, keyCache))});
                    } catch (IllegalAccessException e10) {
                        Log.e(TimeCycleSplineSet.TAG, "unable to setProgress", e10);
                    } catch (InvocationTargetException e11) {
                        Log.e(TimeCycleSplineSet.TAG, "unable to setProgress", e11);
                    }
                }
            }
            return this.mContinue;
        }
    }

    static class f extends TimeCycleSplineSet {
        f() {
        }

        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setRotation(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    static class g extends TimeCycleSplineSet {
        g() {
        }

        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setRotationX(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    static class h extends TimeCycleSplineSet {
        h() {
        }

        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setRotationY(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    static class i extends TimeCycleSplineSet {
        i() {
        }

        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setScaleX(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    static class j extends TimeCycleSplineSet {
        j() {
        }

        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setScaleY(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    private static class k {
        static void a(int[] iArr, float[][] fArr, int i10, int i11) {
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

        private static int b(int[] iArr, float[][] fArr, int i10, int i11) {
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

        private static void c(int[] iArr, float[][] fArr, int i10, int i11) {
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
            float[] fArr2 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = fArr2;
        }
    }

    static class l extends TimeCycleSplineSet {
        l() {
        }

        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setTranslationX(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    static class m extends TimeCycleSplineSet {
        m() {
        }

        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setTranslationY(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    static class n extends TimeCycleSplineSet {
        n() {
        }

        public boolean setProperty(View view, float f10, long j10, KeyCache keyCache) {
            view.setTranslationZ(get(f10, j10, view, keyCache));
            return this.mContinue;
        }
    }

    public TimeCycleSplineSet() {
        int[] iArr = new int[2];
        iArr[1] = 3;
        iArr[0] = 10;
        this.mValues = (float[][]) Array.newInstance(Float.TYPE, iArr);
        this.mCache = new float[3];
        this.mContinue = false;
        this.last_cycle = Float.NaN;
    }

    static TimeCycleSplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new b(str, sparseArray);
    }

    static TimeCycleSplineSet makeSpline(String str, long j10) {
        TimeCycleSplineSet timeCycleSplineSet;
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
            case -40300674:
                if (str.equals("rotation")) {
                    c10 = 8;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c10 = 9;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c10 = 10;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c10 = 11;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                timeCycleSplineSet = new g();
                break;
            case 1:
                timeCycleSplineSet = new h();
                break;
            case 2:
                timeCycleSplineSet = new l();
                break;
            case 3:
                timeCycleSplineSet = new m();
                break;
            case 4:
                timeCycleSplineSet = new n();
                break;
            case 5:
                timeCycleSplineSet = new e();
                break;
            case 6:
                timeCycleSplineSet = new i();
                break;
            case 7:
                timeCycleSplineSet = new j();
                break;
            case 8:
                timeCycleSplineSet = new f();
                break;
            case 9:
                timeCycleSplineSet = new c();
                break;
            case 10:
                timeCycleSplineSet = new d();
                break;
            case 11:
                timeCycleSplineSet = new a();
                break;
            default:
                return null;
        }
        timeCycleSplineSet.setStartTime(j10);
        return timeCycleSplineSet;
    }

    /* access modifiers changed from: protected */
    public float calcWave(float f10) {
        float abs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f10 * VAL_2PI);
            case 2:
                abs = Math.abs(f10);
                break;
            case 3:
                return (((f10 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f10 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos((double) (f10 * VAL_2PI));
            case 6:
                float abs2 = 1.0f - Math.abs(((f10 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin((double) (f10 * VAL_2PI));
        }
        return 1.0f - abs;
    }

    public float get(float f10, long j10, View view, KeyCache keyCache) {
        boolean z10;
        long j11 = j10;
        View view2 = view;
        KeyCache keyCache2 = keyCache;
        this.mCurveFit.getPos((double) f10, this.mCache);
        float[] fArr = this.mCache;
        float f11 = fArr[1];
        int i10 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
        if (i10 == 0) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            float floatValue = keyCache2.getFloatValue(view2, this.mType, 0);
            this.last_cycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.last_cycle = 0.0f;
            }
        }
        float f12 = (float) ((((double) this.last_cycle) + ((((double) (j11 - this.last_time)) * 1.0E-9d) * ((double) f11))) % 1.0d);
        this.last_cycle = f12;
        keyCache2.setFloatValue(view2, this.mType, 0, f12);
        this.last_time = j11;
        float f13 = this.mCache[0];
        float calcWave = (calcWave(this.last_cycle) * f13) + this.mCache[2];
        if (f13 == 0.0f && i10 == 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.mContinue = z10;
        return calcWave;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i10, float f10, float f11, int i11, float f12) {
        int[] iArr = this.mTimePoints;
        int i12 = this.count;
        iArr[i12] = i10;
        float[] fArr = this.mValues[i12];
        fArr[0] = f10;
        fArr[1] = f11;
        fArr[2] = f12;
        this.mWaveShape = Math.max(this.mWaveShape, i11);
        this.count++;
    }

    public abstract boolean setProperty(View view, float f10, long j10, KeyCache keyCache);

    /* access modifiers changed from: protected */
    public void setStartTime(long j10) {
        this.last_time = j10;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i10) {
        int i11 = this.count;
        if (i11 == 0) {
            Log.e(TAG, "Error no points added to " + this.mType);
            return;
        }
        k.a(this.mTimePoints, this.mValues, 0, i11 - 1);
        int i12 = 1;
        int i13 = 0;
        while (true) {
            int[] iArr = this.mTimePoints;
            if (i12 >= iArr.length) {
                break;
            }
            if (iArr[i12] != iArr[i12 - 1]) {
                i13++;
            }
            i12++;
        }
        if (i13 == 0) {
            i13 = 1;
        }
        double[] dArr = new double[i13];
        int[] iArr2 = new int[2];
        iArr2[1] = 3;
        iArr2[0] = i13;
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr2);
        int i14 = 0;
        for (int i15 = 0; i15 < this.count; i15++) {
            if (i15 > 0) {
                int[] iArr3 = this.mTimePoints;
                if (iArr3[i15] == iArr3[i15 - 1]) {
                }
            }
            dArr[i14] = ((double) this.mTimePoints[i15]) * 0.01d;
            double[] dArr3 = dArr2[i14];
            float[] fArr = this.mValues[i15];
            dArr3[0] = (double) fArr[0];
            dArr3[1] = (double) fArr[1];
            dArr3[2] = (double) fArr[2];
            i14++;
        }
        this.mCurveFit = CurveFit.get(i10, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.count; i10++) {
            str = str + "[" + this.mTimePoints[i10] + " , " + decimalFormat.format(this.mValues[i10]) + "] ";
        }
        return str;
    }
}
