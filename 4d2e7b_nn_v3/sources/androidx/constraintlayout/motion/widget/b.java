package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.NotificationCompat;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

class b implements Comparable {

    /* renamed from: a1  reason: collision with root package name */
    static String[] f14631a1 = {"position", "x", "y", Snapshot.WIDTH, Snapshot.HEIGHT, "pathRotate"};
    private float C = Float.NaN;
    private Easing N0;
    private int O0 = 0;
    private float P0;
    private float Q0;
    private float R0;
    private float S0;
    private float T0;
    private float U0 = Float.NaN;
    private float V0 = Float.NaN;
    LinkedHashMap W0 = new LinkedHashMap();
    private float X = 0.0f;
    int X0 = 0;
    private float Y = 0.0f;
    double[] Y0 = new double[18];
    private float Z = 0.0f;
    double[] Z0 = new double[18];

    /* renamed from: a  reason: collision with root package name */
    private float f14632a = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    int f14633b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f14634c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14635d = false;

    /* renamed from: e  reason: collision with root package name */
    private float f14636e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f14637f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f14638g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f14639h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private float f14640i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    private float f14641j = 1.0f;

    /* renamed from: w  reason: collision with root package name */
    private float f14642w = Float.NaN;

    private boolean e(float f10, float f11) {
        if (Float.isNaN(f10) || Float.isNaN(f11)) {
            if (Float.isNaN(f10) != Float.isNaN(f11)) {
                return true;
            }
            return false;
        } else if (Math.abs(f10 - f11) > 1.0E-6f) {
            return true;
        } else {
            return false;
        }
    }

    public void a(HashMap hashMap, int i10) {
        for (String str : hashMap.keySet()) {
            SplineSet splineSet = (SplineSet) hashMap.get(str);
            str.hashCode();
            float f10 = 1.0f;
            float f11 = 0.0f;
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
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        c10 = 8;
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        c10 = 9;
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c10 = 10;
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c10 = 11;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c10 = 12;
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        c10 = 13;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    if (!Float.isNaN(this.f14638g)) {
                        f11 = this.f14638g;
                    }
                    splineSet.setPoint(i10, f11);
                    break;
                case 1:
                    if (!Float.isNaN(this.f14639h)) {
                        f11 = this.f14639h;
                    }
                    splineSet.setPoint(i10, f11);
                    break;
                case 2:
                    if (!Float.isNaN(this.X)) {
                        f11 = this.X;
                    }
                    splineSet.setPoint(i10, f11);
                    break;
                case 3:
                    if (!Float.isNaN(this.Y)) {
                        f11 = this.Y;
                    }
                    splineSet.setPoint(i10, f11);
                    break;
                case 4:
                    if (!Float.isNaN(this.Z)) {
                        f11 = this.Z;
                    }
                    splineSet.setPoint(i10, f11);
                    break;
                case 5:
                    if (!Float.isNaN(this.V0)) {
                        f11 = this.V0;
                    }
                    splineSet.setPoint(i10, f11);
                    break;
                case 6:
                    if (!Float.isNaN(this.f14640i)) {
                        f10 = this.f14640i;
                    }
                    splineSet.setPoint(i10, f10);
                    break;
                case 7:
                    if (!Float.isNaN(this.f14641j)) {
                        f10 = this.f14641j;
                    }
                    splineSet.setPoint(i10, f10);
                    break;
                case 8:
                    if (!Float.isNaN(this.f14642w)) {
                        f11 = this.f14642w;
                    }
                    splineSet.setPoint(i10, f11);
                    break;
                case 9:
                    if (!Float.isNaN(this.C)) {
                        f11 = this.C;
                    }
                    splineSet.setPoint(i10, f11);
                    break;
                case 10:
                    if (!Float.isNaN(this.f14637f)) {
                        f11 = this.f14637f;
                    }
                    splineSet.setPoint(i10, f11);
                    break;
                case 11:
                    if (!Float.isNaN(this.f14636e)) {
                        f11 = this.f14636e;
                    }
                    splineSet.setPoint(i10, f11);
                    break;
                case 12:
                    if (!Float.isNaN(this.U0)) {
                        f11 = this.U0;
                    }
                    splineSet.setPoint(i10, f11);
                    break;
                case 13:
                    if (!Float.isNaN(this.f14632a)) {
                        f10 = this.f14632a;
                    }
                    splineSet.setPoint(i10, f10);
                    break;
                default:
                    if (!str.startsWith("CUSTOM")) {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                        break;
                    } else {
                        String str2 = str.split(",")[1];
                        if (!this.W0.containsKey(str2)) {
                            Log.e("MotionPaths", "UNKNOWN customName " + str2);
                            break;
                        } else {
                            ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.W0.get(str2);
                            if (!(splineSet instanceof SplineSet.b)) {
                                Log.e("MotionPaths", str + " splineSet not a CustomSet frame = " + i10 + ", value" + constraintAttribute.getValueToInterpolate() + splineSet);
                                break;
                            } else {
                                ((SplineSet.b) splineSet).a(i10, constraintAttribute);
                                break;
                            }
                        }
                    }
            }
        }
    }

    public void b(View view) {
        float f10;
        this.f14634c = view.getVisibility();
        if (view.getVisibility() != 0) {
            f10 = 0.0f;
        } else {
            f10 = view.getAlpha();
        }
        this.f14632a = f10;
        this.f14635d = false;
        this.f14636e = view.getElevation();
        this.f14637f = view.getRotation();
        this.f14638g = view.getRotationX();
        this.f14639h = view.getRotationY();
        this.f14640i = view.getScaleX();
        this.f14641j = view.getScaleY();
        this.f14642w = view.getPivotX();
        this.C = view.getPivotY();
        this.X = view.getTranslationX();
        this.Y = view.getTranslationY();
        this.Z = view.getTranslationZ();
    }

    public void c(ConstraintSet.Constraint constraint) {
        float f10;
        ConstraintSet.PropertySet propertySet = constraint.propertySet;
        int i10 = propertySet.mVisibilityMode;
        this.f14633b = i10;
        int i11 = propertySet.visibility;
        this.f14634c = i11;
        if (i11 == 0 || i10 != 0) {
            f10 = propertySet.alpha;
        } else {
            f10 = 0.0f;
        }
        this.f14632a = f10;
        ConstraintSet.Transform transform = constraint.transform;
        this.f14635d = transform.applyElevation;
        this.f14636e = transform.elevation;
        this.f14637f = transform.rotation;
        this.f14638g = transform.rotationX;
        this.f14639h = transform.rotationY;
        this.f14640i = transform.scaleX;
        this.f14641j = transform.scaleY;
        this.f14642w = transform.transformPivotX;
        this.C = transform.transformPivotY;
        this.X = transform.translationX;
        this.Y = transform.translationY;
        this.Z = transform.translationZ;
        this.N0 = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.U0 = motion.mPathRotate;
        this.O0 = motion.mDrawPath;
        this.V0 = constraint.propertySet.mProgress;
        for (String next : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(next);
            if (constraintAttribute.getType() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.W0.put(next, constraintAttribute);
            }
        }
    }

    /* renamed from: d */
    public int compareTo(b bVar) {
        return Float.compare(this.P0, bVar.P0);
    }

    /* access modifiers changed from: package-private */
    public void f(b bVar, HashSet hashSet) {
        if (e(this.f14632a, bVar.f14632a)) {
            hashSet.add("alpha");
        }
        if (e(this.f14636e, bVar.f14636e)) {
            hashSet.add("elevation");
        }
        int i10 = this.f14634c;
        int i11 = bVar.f14634c;
        if (i10 != i11 && this.f14633b == 0 && (i10 == 0 || i11 == 0)) {
            hashSet.add("alpha");
        }
        if (e(this.f14637f, bVar.f14637f)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.U0) || !Float.isNaN(bVar.U0)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.V0) || !Float.isNaN(bVar.V0)) {
            hashSet.add(NotificationCompat.CATEGORY_PROGRESS);
        }
        if (e(this.f14638g, bVar.f14638g)) {
            hashSet.add("rotationX");
        }
        if (e(this.f14639h, bVar.f14639h)) {
            hashSet.add("rotationY");
        }
        if (e(this.f14642w, bVar.f14642w)) {
            hashSet.add("transformPivotX");
        }
        if (e(this.C, bVar.C)) {
            hashSet.add("transformPivotY");
        }
        if (e(this.f14640i, bVar.f14640i)) {
            hashSet.add("scaleX");
        }
        if (e(this.f14641j, bVar.f14641j)) {
            hashSet.add("scaleY");
        }
        if (e(this.X, bVar.X)) {
            hashSet.add("translationX");
        }
        if (e(this.Y, bVar.Y)) {
            hashSet.add("translationY");
        }
        if (e(this.Z, bVar.Z)) {
            hashSet.add("translationZ");
        }
    }

    /* access modifiers changed from: package-private */
    public void g(float f10, float f11, float f12, float f13) {
        this.Q0 = f10;
        this.R0 = f11;
        this.S0 = f12;
        this.T0 = f13;
    }

    public void h(View view) {
        g(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        b(view);
    }

    public void i(ConstraintWidget constraintWidget, ConstraintSet constraintSet, int i10) {
        g((float) constraintWidget.getX(), (float) constraintWidget.getY(), (float) constraintWidget.getWidth(), (float) constraintWidget.getHeight());
        c(constraintSet.getParameters(i10));
    }
}
