package androidx.constraintlayout.motion.widget;

import android.annotation.TargetApi;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Oscillator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    protected ConstraintAttribute mCustom;
    private d mCycleOscillator;
    private String mType;
    public int mVariesBy = 0;
    ArrayList<p> mWavePoints = new ArrayList<>();
    private int mWaveShape = 0;

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(p pVar, p pVar2) {
            return Integer.compare(pVar.f14558a, pVar2.f14558a);
        }
    }

    static class b extends KeyCycleOscillator {
        b() {
        }

        public void setProperty(View view, float f10) {
            view.setAlpha(get(f10));
        }
    }

    static class c extends KeyCycleOscillator {

        /* renamed from: a  reason: collision with root package name */
        float[] f14543a = new float[1];

        c() {
        }

        public void setProperty(View view, float f10) {
            this.f14543a[0] = get(f10);
            this.mCustom.setInterpolatedValue(view, this.f14543a);
        }
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        private final int f14544a;

        /* renamed from: b  reason: collision with root package name */
        Oscillator f14545b = new Oscillator();

        /* renamed from: c  reason: collision with root package name */
        float[] f14546c;

        /* renamed from: d  reason: collision with root package name */
        double[] f14547d;

        /* renamed from: e  reason: collision with root package name */
        float[] f14548e;

        /* renamed from: f  reason: collision with root package name */
        float[] f14549f;

        /* renamed from: g  reason: collision with root package name */
        float[] f14550g;

        /* renamed from: h  reason: collision with root package name */
        int f14551h;

        /* renamed from: i  reason: collision with root package name */
        CurveFit f14552i;

        /* renamed from: j  reason: collision with root package name */
        double[] f14553j;

        /* renamed from: k  reason: collision with root package name */
        double[] f14554k;

        /* renamed from: l  reason: collision with root package name */
        float f14555l;

        /* renamed from: m  reason: collision with root package name */
        public HashMap f14556m = new HashMap();

        d(int i10, int i11, int i12) {
            this.f14551h = i10;
            this.f14544a = i11;
            this.f14545b.setType(i10);
            this.f14546c = new float[i12];
            this.f14547d = new double[i12];
            this.f14548e = new float[i12];
            this.f14549f = new float[i12];
            this.f14550g = new float[i12];
        }

        public double a(float f10) {
            CurveFit curveFit = this.f14552i;
            if (curveFit != null) {
                double d10 = (double) f10;
                curveFit.getSlope(d10, this.f14554k);
                this.f14552i.getPos(d10, this.f14553j);
            } else {
                double[] dArr = this.f14554k;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
            }
            double d11 = (double) f10;
            double value = this.f14545b.getValue(d11);
            double slope = this.f14545b.getSlope(d11);
            double[] dArr2 = this.f14554k;
            return dArr2[0] + (value * dArr2[1]) + (slope * this.f14553j[1]);
        }

        public double b(float f10) {
            CurveFit curveFit = this.f14552i;
            if (curveFit != null) {
                curveFit.getPos((double) f10, this.f14553j);
            } else {
                double[] dArr = this.f14553j;
                dArr[0] = (double) this.f14549f[0];
                dArr[1] = (double) this.f14546c[0];
            }
            return this.f14553j[0] + (this.f14545b.getValue((double) f10) * this.f14553j[1]);
        }

        public void c(int i10, int i11, float f10, float f11, float f12) {
            this.f14547d[i10] = ((double) i11) / 100.0d;
            this.f14548e[i10] = f10;
            this.f14549f[i10] = f11;
            this.f14546c[i10] = f12;
        }

        public void d(float f10) {
            this.f14555l = f10;
            int length = this.f14547d.length;
            int[] iArr = new int[2];
            iArr[1] = 2;
            iArr[0] = length;
            double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, iArr);
            float[] fArr = this.f14546c;
            this.f14553j = new double[(fArr.length + 1)];
            this.f14554k = new double[(fArr.length + 1)];
            if (this.f14547d[0] > 0.0d) {
                this.f14545b.addPoint(0.0d, this.f14548e[0]);
            }
            double[] dArr2 = this.f14547d;
            int length2 = dArr2.length - 1;
            if (dArr2[length2] < 1.0d) {
                this.f14545b.addPoint(1.0d, this.f14548e[length2]);
            }
            for (int i10 = 0; i10 < dArr.length; i10++) {
                dArr[i10][0] = (double) this.f14549f[i10];
                int i11 = 0;
                while (true) {
                    float[] fArr2 = this.f14546c;
                    if (i11 >= fArr2.length) {
                        break;
                    }
                    dArr[i11][1] = (double) fArr2[i11];
                    i11++;
                }
                this.f14545b.addPoint(this.f14547d[i10], this.f14548e[i10]);
            }
            this.f14545b.normalize();
            double[] dArr3 = this.f14547d;
            if (dArr3.length > 1) {
                this.f14552i = CurveFit.get(0, dArr3, dArr);
            } else {
                this.f14552i = null;
            }
        }
    }

    static class e extends KeyCycleOscillator {
        e() {
        }

        public void setProperty(View view, float f10) {
            view.setElevation(get(f10));
        }
    }

    static class f extends KeyCycleOscillator {
        f() {
        }

        public void a(View view, float f10, double d10, double d11) {
            view.setRotation(get(f10) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
        }

        public void setProperty(View view, float f10) {
        }
    }

    static class g extends KeyCycleOscillator {

        /* renamed from: a  reason: collision with root package name */
        boolean f14557a = false;

        g() {
        }

        public void setProperty(View view, float f10) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f10));
            } else if (!this.f14557a) {
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.f14557a = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(get(f10))});
                    } catch (IllegalAccessException e10) {
                        Log.e(KeyCycleOscillator.TAG, "unable to setProgress", e10);
                    } catch (InvocationTargetException e11) {
                        Log.e(KeyCycleOscillator.TAG, "unable to setProgress", e11);
                    }
                }
            }
        }
    }

    static class h extends KeyCycleOscillator {
        h() {
        }

        public void setProperty(View view, float f10) {
            view.setRotation(get(f10));
        }
    }

    static class i extends KeyCycleOscillator {
        i() {
        }

        public void setProperty(View view, float f10) {
            view.setRotationX(get(f10));
        }
    }

    static class j extends KeyCycleOscillator {
        j() {
        }

        public void setProperty(View view, float f10) {
            view.setRotationY(get(f10));
        }
    }

    static class k extends KeyCycleOscillator {
        k() {
        }

        public void setProperty(View view, float f10) {
            view.setScaleX(get(f10));
        }
    }

    static class l extends KeyCycleOscillator {
        l() {
        }

        public void setProperty(View view, float f10) {
            view.setScaleY(get(f10));
        }
    }

    static class m extends KeyCycleOscillator {
        m() {
        }

        public void setProperty(View view, float f10) {
            view.setTranslationX(get(f10));
        }
    }

    static class n extends KeyCycleOscillator {
        n() {
        }

        public void setProperty(View view, float f10) {
            view.setTranslationY(get(f10));
        }
    }

    static class o extends KeyCycleOscillator {
        o() {
        }

        public void setProperty(View view, float f10) {
            view.setTranslationZ(get(f10));
        }
    }

    static class p {

        /* renamed from: a  reason: collision with root package name */
        int f14558a;

        /* renamed from: b  reason: collision with root package name */
        float f14559b;

        /* renamed from: c  reason: collision with root package name */
        float f14560c;

        /* renamed from: d  reason: collision with root package name */
        float f14561d;

        public p(int i10, float f10, float f11, float f12) {
            this.f14558a = i10;
            this.f14559b = f12;
            this.f14560c = f11;
            this.f14561d = f10;
        }
    }

    static KeyCycleOscillator makeSpline(String str) {
        if (str.startsWith("CUSTOM")) {
            return new c();
        }
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
            case -40300674:
                if (str.equals("rotation")) {
                    c10 = 9;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c10 = 10;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c10 = 11;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c10 = 12;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c10 = 13;
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
                return new m();
            case 3:
                return new n();
            case 4:
                return new o();
            case 5:
                return new g();
            case 6:
                return new k();
            case 7:
                return new l();
            case 8:
                return new b();
            case 9:
                return new h();
            case 10:
                return new e();
            case 11:
                return new f();
            case 12:
                return new b();
            case 13:
                return new b();
            default:
                return null;
        }
    }

    public float get(float f10) {
        return (float) this.mCycleOscillator.b(f10);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f10) {
        return (float) this.mCycleOscillator.a(f10);
    }

    public void setPoint(int i10, int i11, int i12, float f10, float f11, float f12, ConstraintAttribute constraintAttribute) {
        this.mWavePoints.add(new p(i10, f10, f11, f12));
        if (i12 != -1) {
            this.mVariesBy = i12;
        }
        this.mWaveShape = i11;
        this.mCustom = constraintAttribute;
    }

    public abstract void setProperty(View view, float f10);

    public void setType(String str) {
        this.mType = str;
    }

    @TargetApi(19)
    public void setup(float f10) {
        int size = this.mWavePoints.size();
        if (size != 0) {
            Collections.sort(this.mWavePoints, new a());
            double[] dArr = new double[size];
            int[] iArr = new int[2];
            iArr[1] = 2;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            this.mCycleOscillator = new d(this.mWaveShape, this.mVariesBy, size);
            Iterator<p> it = this.mWavePoints.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                p next = it.next();
                float f11 = next.f14561d;
                dArr[i10] = ((double) f11) * 0.01d;
                double[] dArr3 = dArr2[i10];
                float f12 = next.f14559b;
                dArr3[0] = (double) f12;
                float f13 = next.f14560c;
                dArr3[1] = (double) f13;
                this.mCycleOscillator.c(i10, next.f14558a, f11, f13, f12);
                i10++;
            }
            this.mCycleOscillator.d(f10);
            this.mCurveFit = CurveFit.get(0, dArr, dArr2);
        }
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<p> it = this.mWavePoints.iterator();
        while (it.hasNext()) {
            p next = it.next();
            str = str + "[" + next.f14558a + " , " + decimalFormat.format((double) next.f14559b) + "] ";
        }
        return str;
    }

    public boolean variesByPath() {
        if (this.mVariesBy == 1) {
            return true;
        }
        return false;
    }

    public void setPoint(int i10, int i11, int i12, float f10, float f11, float f12) {
        this.mWavePoints.add(new p(i10, f10, f11, f12));
        if (i12 != -1) {
            this.mVariesBy = i12;
        }
        this.mWaveShape = i11;
    }
}
