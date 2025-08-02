package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.VelocityMatrix;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MotionController {
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private int MAX_DIMENSION = 4;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    private int mCurveFitType = -1;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    private c mEndMotionPath = new c();
    private b mEndPoint = new b();
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<Key> mKeyList = new ArrayList<>();
    private KeyTrigger[] mKeyTriggers;
    private ArrayList<c> mMotionPaths = new ArrayList<>();
    float mMotionStagger = Float.NaN;
    private int mPathMotionArc = Key.UNSET;
    private CurveFit[] mSpline;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private c mStartMotionPath = new c();
    private b mStartPoint = new b();
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    private float[] mValuesBuff = new float[4];
    private float[] mVelocity = new float[1];
    View mView;

    MotionController(View view) {
        setView(view);
    }

    private float getAdjustedPosition(float f10, float[] fArr) {
        float f11 = 0.0f;
        float f12 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f13 = this.mStaggerScale;
            if (((double) f13) != 1.0d) {
                float f14 = this.mStaggerOffset;
                if (f10 < f14) {
                    f10 = 0.0f;
                }
                if (f10 > f14 && ((double) f10) < 1.0d) {
                    f10 = (f10 - f14) * f13;
                }
            }
        }
        Easing easing = this.mStartMotionPath.f14643a;
        Iterator<c> it = this.mMotionPaths.iterator();
        float f15 = Float.NaN;
        while (it.hasNext()) {
            c next = it.next();
            Easing easing2 = next.f14643a;
            if (easing2 != null) {
                float f16 = next.f14645c;
                if (f16 < f10) {
                    easing = easing2;
                    f11 = f16;
                } else if (Float.isNaN(f15)) {
                    f15 = next.f14645c;
                }
            }
        }
        if (easing != null) {
            if (!Float.isNaN(f15)) {
                f12 = f15;
            }
            float f17 = f12 - f11;
            double d10 = (double) ((f10 - f11) / f17);
            f10 = (((float) easing.get(d10)) * f17) + f11;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d10);
            }
        }
        return f10;
    }

    private float getPreCycleDistance() {
        float[] fArr = new float[2];
        float f10 = 1.0f / ((float) 99);
        double d10 = 0.0d;
        double d11 = 0.0d;
        int i10 = 0;
        float f11 = 0.0f;
        while (i10 < 100) {
            float f12 = ((float) i10) * f10;
            double d12 = (double) f12;
            Easing easing = this.mStartMotionPath.f14643a;
            Iterator<c> it = this.mMotionPaths.iterator();
            float f13 = Float.NaN;
            float f14 = 0.0f;
            while (it.hasNext()) {
                c next = it.next();
                Easing easing2 = next.f14643a;
                float f15 = f10;
                if (easing2 != null) {
                    float f16 = next.f14645c;
                    if (f16 < f12) {
                        f14 = f16;
                        easing = easing2;
                    } else if (Float.isNaN(f13)) {
                        f13 = next.f14645c;
                    }
                }
                f10 = f15;
            }
            float f17 = f10;
            if (easing != null) {
                if (Float.isNaN(f13)) {
                    f13 = 1.0f;
                }
                float f18 = f13 - f14;
                d12 = (double) ((((float) easing.get((double) ((f12 - f14) / f18))) * f18) + f14);
            }
            this.mSpline[0].getPos(d12, this.mInterpolateData);
            this.mStartMotionPath.g(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i10 > 0) {
                f11 = (float) (((double) f11) + Math.hypot(d11 - ((double) fArr[1]), d10 - ((double) fArr[0])));
            }
            d10 = (double) fArr[0];
            d11 = (double) fArr[1];
            i10++;
            f10 = f17;
        }
        return f11;
    }

    private void insertKey(c cVar) {
        int binarySearch = Collections.binarySearch(this.mMotionPaths, cVar);
        if (binarySearch == 0) {
            Log.e(TAG, " KeyPath positon \"" + cVar.f14646d + "\" outside of range");
        }
        this.mMotionPaths.add((-binarySearch) - 1, cVar);
    }

    private void readView(c cVar) {
        cVar.o((float) ((int) this.mView.getX()), (float) ((int) this.mView.getY()), (float) this.mView.getWidth(), (float) this.mView.getHeight());
    }

    /* access modifiers changed from: package-private */
    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    /* access modifiers changed from: package-private */
    public void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    /* access modifiers changed from: package-private */
    public void buildBounds(float[] fArr, int i10) {
        int i11 = i10;
        float f10 = 1.0f / ((float) (i11 - 1));
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            SplineSet splineSet = hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 != null) {
            SplineSet splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 != null) {
            KeyCycleOscillator keyCycleOscillator = hashMap3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            KeyCycleOscillator keyCycleOscillator2 = hashMap4.get("translationY");
        }
        for (int i12 = 0; i12 < i11; i12++) {
            float f11 = ((float) i12) * f10;
            float f12 = this.mStaggerScale;
            float f13 = 0.0f;
            if (f12 != 1.0f) {
                float f14 = this.mStaggerOffset;
                if (f11 < f14) {
                    f11 = 0.0f;
                }
                if (f11 > f14 && ((double) f11) < 1.0d) {
                    f11 = (f11 - f14) * f12;
                }
            }
            double d10 = (double) f11;
            Easing easing = this.mStartMotionPath.f14643a;
            Iterator<c> it = this.mMotionPaths.iterator();
            float f15 = Float.NaN;
            while (it.hasNext()) {
                c next = it.next();
                Easing easing2 = next.f14643a;
                if (easing2 != null) {
                    float f16 = next.f14645c;
                    if (f16 < f11) {
                        easing = easing2;
                        f13 = f16;
                    } else if (Float.isNaN(f15)) {
                        f15 = next.f14645c;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f15)) {
                    f15 = 1.0f;
                }
                float f17 = f15 - f13;
                d10 = (double) ((((float) easing.get((double) ((f11 - f13) / f17))) * f17) + f13);
            }
            this.mSpline[0].getPos(d10, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d10, dArr);
                }
            }
            this.mStartMotionPath.f(this.mInterpolateVariables, this.mInterpolateData, fArr, i12 * 2);
        }
    }

    /* access modifiers changed from: package-private */
    public int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<c> it = this.mMotionPaths.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                iArr[i10] = it.next().X;
                i10++;
            }
        }
        int i11 = 0;
        for (double pos : timePoints) {
            this.mSpline[0].getPos(pos, this.mInterpolateData);
            this.mStartMotionPath.f(this.mInterpolateVariables, this.mInterpolateData, fArr, i11);
            i11 += 2;
        }
        return i11 / 2;
    }

    /* access modifiers changed from: package-private */
    public int buildKeyFrames(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<c> it = this.mMotionPaths.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                iArr[i10] = it.next().X;
                i10++;
            }
        }
        int i11 = 0;
        for (double pos : timePoints) {
            this.mSpline[0].getPos(pos, this.mInterpolateData);
            this.mStartMotionPath.g(this.mInterpolateVariables, this.mInterpolateData, fArr, i11);
            i11 += 2;
        }
        return i11 / 2;
    }

    /* access modifiers changed from: package-private */
    public void buildPath(float[] fArr, int i10) {
        SplineSet splineSet;
        SplineSet splineSet2;
        KeyCycleOscillator keyCycleOscillator;
        float[] fArr2 = fArr;
        int i11 = i10;
        float f10 = 1.0f;
        float f11 = 1.0f / ((float) (i11 - 1));
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator2 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 == null) {
            keyCycleOscillator = null;
        } else {
            keyCycleOscillator = hashMap3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            keyCycleOscillator2 = hashMap4.get("translationY");
        }
        int i12 = 0;
        while (i12 < i11) {
            float f12 = ((float) i12) * f11;
            float f13 = this.mStaggerScale;
            if (f13 != f10) {
                float f14 = this.mStaggerOffset;
                if (f12 < f14) {
                    f12 = 0.0f;
                }
                if (f12 > f14 && ((double) f12) < 1.0d) {
                    f12 = (f12 - f14) * f13;
                }
            }
            double d10 = (double) f12;
            Easing easing = this.mStartMotionPath.f14643a;
            Iterator<c> it = this.mMotionPaths.iterator();
            float f15 = Float.NaN;
            float f16 = 0.0f;
            while (it.hasNext()) {
                c next = it.next();
                Easing easing2 = next.f14643a;
                if (easing2 != null) {
                    float f17 = next.f14645c;
                    if (f17 < f12) {
                        f16 = f17;
                        easing = easing2;
                    } else if (Float.isNaN(f15)) {
                        f15 = next.f14645c;
                    }
                }
                int i13 = i10;
            }
            if (easing != null) {
                if (Float.isNaN(f15)) {
                    f15 = 1.0f;
                }
                float f18 = f15 - f16;
                d10 = (double) ((((float) easing.get((double) ((f12 - f16) / f18))) * f18) + f16);
            }
            this.mSpline[0].getPos(d10, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d10, dArr);
                }
            }
            int i14 = i12 * 2;
            this.mStartMotionPath.g(this.mInterpolateVariables, this.mInterpolateData, fArr2, i14);
            if (keyCycleOscillator != null) {
                fArr2[i14] = fArr2[i14] + keyCycleOscillator.get(f12);
            } else if (splineSet != null) {
                fArr2[i14] = fArr2[i14] + splineSet.get(f12);
            }
            if (keyCycleOscillator2 != null) {
                int i15 = i14 + 1;
                fArr2[i15] = fArr2[i15] + keyCycleOscillator2.get(f12);
            } else if (splineSet2 != null) {
                int i16 = i14 + 1;
                fArr2[i16] = fArr2[i16] + splineSet2.get(f12);
            }
            i12++;
            i11 = i10;
            f10 = 1.0f;
        }
    }

    /* access modifiers changed from: package-private */
    public void buildRect(float f10, float[] fArr, int i10) {
        this.mSpline[0].getPos((double) getAdjustedPosition(f10, (float[]) null), this.mInterpolateData);
        this.mStartMotionPath.j(this.mInterpolateVariables, this.mInterpolateData, fArr, i10);
    }

    /* access modifiers changed from: package-private */
    public void buildRectangles(float[] fArr, int i10) {
        float f10 = 1.0f / ((float) (i10 - 1));
        for (int i11 = 0; i11 < i10; i11++) {
            this.mSpline[0].getPos((double) getAdjustedPosition(((float) i11) * f10, (float[]) null), this.mInterpolateData);
            this.mStartMotionPath.j(this.mInterpolateVariables, this.mInterpolateData, fArr, i11 * 8);
        }
    }

    /* access modifiers changed from: package-private */
    public int getAttributeValues(String str, float[] fArr, int i10) {
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i11 = 0; i11 < fArr.length; i11++) {
            fArr[i11] = splineSet.get((float) (i11 / (fArr.length - 1)));
        }
        return fArr.length;
    }

    /* access modifiers changed from: package-private */
    public void getDpDt(float f10, float f11, float f12, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f10, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i10 = 0;
        if (curveFitArr != null) {
            double d10 = (double) adjustedPosition;
            curveFitArr[0].getSlope(d10, this.mInterpolateVelocity);
            this.mSpline[0].getPos(d10, this.mInterpolateData);
            float f13 = this.mVelocity[0];
            while (true) {
                dArr = this.mInterpolateVelocity;
                if (i10 >= dArr.length) {
                    break;
                }
                dArr[i10] = dArr[i10] * ((double) f13);
                i10++;
            }
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr2 = this.mInterpolateData;
                if (dArr2.length > 0) {
                    curveFit.getPos(d10, dArr2);
                    this.mArcSpline.getSlope(d10, this.mInterpolateVelocity);
                    this.mStartMotionPath.p(f11, f12, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                    return;
                }
                return;
            }
            this.mStartMotionPath.p(f11, f12, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        c cVar = this.mEndMotionPath;
        float f14 = cVar.f14647e;
        c cVar2 = this.mStartMotionPath;
        float f15 = f14 - cVar2.f14647e;
        float f16 = cVar.f14648f - cVar2.f14648f;
        float f17 = (cVar.f14649g - cVar2.f14649g) + f15;
        float f18 = (cVar.f14650h - cVar2.f14650h) + f16;
        fArr[0] = (f15 * (1.0f - f11)) + (f17 * f11);
        fArr[1] = (f16 * (1.0f - f12)) + (f18 * f12);
    }

    public int getDrawPath() {
        int i10 = this.mStartMotionPath.f14644b;
        Iterator<c> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            i10 = Math.max(i10, it.next().f14644b);
        }
        return Math.max(i10, this.mEndMotionPath.f14644b);
    }

    /* access modifiers changed from: package-private */
    public float getFinalX() {
        return this.mEndMotionPath.f14647e;
    }

    /* access modifiers changed from: package-private */
    public float getFinalY() {
        return this.mEndMotionPath.f14648f;
    }

    /* access modifiers changed from: package-private */
    public c getKeyFrame(int i10) {
        return this.mMotionPaths.get(i10);
    }

    public int getKeyFrameInfo(int i10, int[] iArr) {
        float[] fArr = new float[2];
        Iterator<Key> it = this.mKeyList.iterator();
        int i11 = 0;
        int i12 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            int i13 = next.mType;
            if (i13 == i10 || i10 != -1) {
                iArr[i12] = 0;
                iArr[i12 + 1] = i13;
                int i14 = next.mFramePosition;
                iArr[i12 + 2] = i14;
                this.mSpline[0].getPos((double) (((float) i14) / 100.0f), this.mInterpolateData);
                this.mStartMotionPath.g(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i12 + 3] = Float.floatToIntBits(fArr[0]);
                int i15 = i12 + 4;
                iArr[i15] = Float.floatToIntBits(fArr[1]);
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    iArr[i12 + 5] = keyPosition.mPositionType;
                    iArr[i12 + 6] = Float.floatToIntBits(keyPosition.mPercentX);
                    i15 = i12 + 7;
                    iArr[i15] = Float.floatToIntBits(keyPosition.mPercentY);
                }
                int i16 = i15 + 1;
                iArr[i12] = i16 - i12;
                i11++;
                i12 = i16;
            }
        }
        return i11;
    }

    /* access modifiers changed from: package-private */
    public float getKeyFrameParameter(int i10, float f10, float f11) {
        c cVar = this.mEndMotionPath;
        float f12 = cVar.f14647e;
        c cVar2 = this.mStartMotionPath;
        float f13 = cVar2.f14647e;
        float f14 = f12 - f13;
        float f15 = cVar.f14648f;
        float f16 = cVar2.f14648f;
        float f17 = f15 - f16;
        float f18 = f13 + (cVar2.f14649g / 2.0f);
        float f19 = f16 + (cVar2.f14650h / 2.0f);
        float hypot = (float) Math.hypot((double) f14, (double) f17);
        if (((double) hypot) < 1.0E-7d) {
            return Float.NaN;
        }
        float f20 = f10 - f18;
        float f21 = f11 - f19;
        if (((float) Math.hypot((double) f20, (double) f21)) == 0.0f) {
            return 0.0f;
        }
        float f22 = (f20 * f14) + (f21 * f17);
        if (i10 == 0) {
            return f22 / hypot;
        }
        if (i10 == 1) {
            return (float) Math.sqrt((double) ((hypot * hypot) - (f22 * f22)));
        }
        if (i10 == 2) {
            return f20 / f14;
        }
        if (i10 == 3) {
            return f21 / f14;
        }
        if (i10 == 4) {
            return f20 / f17;
        }
        if (i10 != 5) {
            return 0.0f;
        }
        return f21 / f17;
    }

    /* access modifiers changed from: package-private */
    public a getPositionKeyframe(int i10, int i11, float f10, float f11) {
        RectF rectF = new RectF();
        c cVar = this.mStartMotionPath;
        float f12 = cVar.f14647e;
        rectF.left = f12;
        float f13 = cVar.f14648f;
        rectF.top = f13;
        rectF.right = f12 + cVar.f14649g;
        rectF.bottom = f13 + cVar.f14650h;
        RectF rectF2 = new RectF();
        c cVar2 = this.mEndMotionPath;
        float f14 = cVar2.f14647e;
        rectF2.left = f14;
        float f15 = cVar2.f14648f;
        rectF2.top = f15;
        rectF2.right = f14 + cVar2.f14649g;
        rectF2.bottom = f15 + cVar2.f14650h;
        Iterator<Key> it = this.mKeyList.iterator();
        while (it.hasNext()) {
            Key next = it.next();
            if (next instanceof a) {
                a aVar = (a) next;
                if (aVar.intersects(i10, i11, rectF, rectF2, f10, f11)) {
                    return aVar;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void getPostLayoutDvDp(float f10, int i10, int i11, float f11, float f12, float[] fArr) {
        SplineSet splineSet;
        SplineSet splineSet2;
        SplineSet splineSet3;
        SplineSet splineSet4;
        SplineSet splineSet5;
        KeyCycleOscillator keyCycleOscillator;
        KeyCycleOscillator keyCycleOscillator2;
        KeyCycleOscillator keyCycleOscillator3;
        KeyCycleOscillator keyCycleOscillator4;
        float adjustedPosition = getAdjustedPosition(f10, this.mVelocity);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator5 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
        if (hashMap3 == null) {
            splineSet3 = null;
        } else {
            splineSet3 = hashMap3.get("rotation");
        }
        HashMap<String, SplineSet> hashMap4 = this.mAttributesMap;
        if (hashMap4 == null) {
            splineSet4 = null;
        } else {
            splineSet4 = hashMap4.get("scaleX");
        }
        HashMap<String, SplineSet> hashMap5 = this.mAttributesMap;
        if (hashMap5 == null) {
            splineSet5 = null;
        } else {
            splineSet5 = hashMap5.get("scaleY");
        }
        HashMap<String, KeyCycleOscillator> hashMap6 = this.mCycleMap;
        if (hashMap6 == null) {
            keyCycleOscillator = null;
        } else {
            keyCycleOscillator = hashMap6.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap7 = this.mCycleMap;
        if (hashMap7 == null) {
            keyCycleOscillator2 = null;
        } else {
            keyCycleOscillator2 = hashMap7.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap8 = this.mCycleMap;
        if (hashMap8 == null) {
            keyCycleOscillator3 = null;
        } else {
            keyCycleOscillator3 = hashMap8.get("rotation");
        }
        HashMap<String, KeyCycleOscillator> hashMap9 = this.mCycleMap;
        if (hashMap9 == null) {
            keyCycleOscillator4 = null;
        } else {
            keyCycleOscillator4 = hashMap9.get("scaleX");
        }
        HashMap<String, KeyCycleOscillator> hashMap10 = this.mCycleMap;
        if (hashMap10 != null) {
            keyCycleOscillator5 = hashMap10.get("scaleY");
        }
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d10 = (double) adjustedPosition;
                curveFit.getPos(d10, dArr);
                this.mArcSpline.getSlope(d10, this.mInterpolateVelocity);
                this.mStartMotionPath.p(f11, f12, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f11, f12, i10, i11, fArr);
            return;
        }
        int i12 = 0;
        if (this.mSpline != null) {
            double adjustedPosition2 = (double) getAdjustedPosition(adjustedPosition, this.mVelocity);
            this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
            float f13 = this.mVelocity[0];
            while (true) {
                double[] dArr2 = this.mInterpolateVelocity;
                if (i12 < dArr2.length) {
                    dArr2[i12] = dArr2[i12] * ((double) f13);
                    i12++;
                } else {
                    float f14 = f11;
                    float f15 = f12;
                    this.mStartMotionPath.p(f14, f15, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                    velocityMatrix.applyTransform(f14, f15, i10, i11, fArr);
                    return;
                }
            }
        } else {
            c cVar = this.mEndMotionPath;
            float f16 = cVar.f14647e;
            c cVar2 = this.mStartMotionPath;
            float f17 = f16 - cVar2.f14647e;
            float f18 = cVar.f14648f - cVar2.f14648f;
            KeyCycleOscillator keyCycleOscillator6 = keyCycleOscillator4;
            float f19 = (cVar.f14650h - cVar2.f14650h) + f18;
            fArr[0] = (f17 * (1.0f - f11)) + (((cVar.f14649g - cVar2.f14649g) + f17) * f11);
            fArr[1] = (f18 * (1.0f - f12)) + (f19 * f12);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator6, keyCycleOscillator5, adjustedPosition);
            velocityMatrix.applyTransform(f11, f12, i10, i11, fArr);
        }
    }

    /* access modifiers changed from: package-private */
    public float getStartX() {
        return this.mStartMotionPath.f14647e;
    }

    /* access modifiers changed from: package-private */
    public float getStartY() {
        return this.mStartMotionPath.f14648f;
    }

    public int getkeyFramePositions(int[] iArr, float[] fArr) {
        Iterator<Key> it = this.mKeyList.iterator();
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            int i12 = next.mFramePosition;
            iArr[i10] = (next.mType * 1000) + i12;
            this.mSpline[0].getPos((double) (((float) i12) / 100.0f), this.mInterpolateData);
            this.mStartMotionPath.g(this.mInterpolateVariables, this.mInterpolateData, fArr, i11);
            i11 += 2;
            i10++;
        }
        return i10;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v42, resolved type: androidx.constraintlayout.motion.widget.TimeCycleSplineSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: androidx.constraintlayout.motion.widget.TimeCycleSplineSet$d} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean interpolate(android.view.View r23, float r24, long r25, androidx.constraintlayout.motion.widget.KeyCache r27) {
        /*
            r22 = this;
            r0 = r22
            r11 = r23
            r1 = 0
            r2 = r24
            float r12 = r0.getAdjustedPosition(r2, r1)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> r2 = r0.mAttributesMap
            if (r2 == 0) goto L_0x0027
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x0017:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0027
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.widget.SplineSet r3 = (androidx.constraintlayout.motion.widget.SplineSet) r3
            r3.setProperty(r11, r12)
            goto L_0x0017
        L_0x0027:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.TimeCycleSplineSet> r2 = r0.mTimeCycleAttributesMap
            r13 = 0
            if (r2 == 0) goto L_0x0059
            java.util.Collection r2 = r2.values()
            java.util.Iterator r7 = r2.iterator()
            r8 = r1
            r9 = r13
        L_0x0036:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0057
            java.lang.Object r1 = r7.next()
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet r1 = (androidx.constraintlayout.motion.widget.TimeCycleSplineSet) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.widget.TimeCycleSplineSet.d
            if (r2 == 0) goto L_0x004a
            r8 = r1
            androidx.constraintlayout.motion.widget.TimeCycleSplineSet$d r8 = (androidx.constraintlayout.motion.widget.TimeCycleSplineSet.d) r8
            goto L_0x0036
        L_0x004a:
            r2 = r23
            r3 = r12
            r4 = r25
            r6 = r27
            boolean r1 = r1.setProperty(r2, r3, r4, r6)
            r9 = r9 | r1
            goto L_0x0036
        L_0x0057:
            r14 = r9
            goto L_0x005b
        L_0x0059:
            r8 = r1
            r14 = r13
        L_0x005b:
            androidx.constraintlayout.motion.utils.CurveFit[] r1 = r0.mSpline
            r15 = 1
            if (r1 == 0) goto L_0x013e
            r1 = r1[r13]
            double r9 = (double) r12
            double[] r2 = r0.mInterpolateData
            r1.getPos((double) r9, (double[]) r2)
            androidx.constraintlayout.motion.utils.CurveFit[] r1 = r0.mSpline
            r1 = r1[r13]
            double[] r2 = r0.mInterpolateVelocity
            r1.getSlope((double) r9, (double[]) r2)
            androidx.constraintlayout.motion.utils.CurveFit r1 = r0.mArcSpline
            if (r1 == 0) goto L_0x0084
            double[] r2 = r0.mInterpolateData
            int r3 = r2.length
            if (r3 <= 0) goto L_0x0084
            r1.getPos((double) r9, (double[]) r2)
            androidx.constraintlayout.motion.utils.CurveFit r1 = r0.mArcSpline
            double[] r2 = r0.mInterpolateVelocity
            r1.getSlope((double) r9, (double[]) r2)
        L_0x0084:
            androidx.constraintlayout.motion.widget.c r1 = r0.mStartMotionPath
            int[] r3 = r0.mInterpolateVariables
            double[] r4 = r0.mInterpolateData
            double[] r5 = r0.mInterpolateVelocity
            r6 = 0
            r2 = r23
            r1.q(r2, r3, r4, r5, r6)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> r1 = r0.mAttributesMap
            if (r1 == 0) goto L_0x00bd
            java.util.Collection r1 = r1.values()
            java.util.Iterator r16 = r1.iterator()
        L_0x009e:
            boolean r1 = r16.hasNext()
            if (r1 == 0) goto L_0x00bd
            java.lang.Object r1 = r16.next()
            androidx.constraintlayout.motion.widget.SplineSet r1 = (androidx.constraintlayout.motion.widget.SplineSet) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.widget.SplineSet.d
            if (r2 == 0) goto L_0x009e
            androidx.constraintlayout.motion.widget.SplineSet$d r1 = (androidx.constraintlayout.motion.widget.SplineSet.d) r1
            double[] r2 = r0.mInterpolateVelocity
            r4 = r2[r13]
            r6 = r2[r15]
            r2 = r23
            r3 = r12
            r1.a(r2, r3, r4, r6)
            goto L_0x009e
        L_0x00bd:
            if (r8 == 0) goto L_0x00d9
            double[] r1 = r0.mInterpolateVelocity
            r16 = r1[r13]
            r18 = r1[r15]
            r1 = r8
            r2 = r23
            r3 = r27
            r4 = r12
            r5 = r25
            r7 = r16
            r20 = r9
            r9 = r18
            boolean r1 = r1.a(r2, r3, r4, r5, r7, r9)
            r14 = r14 | r1
            goto L_0x00db
        L_0x00d9:
            r20 = r9
        L_0x00db:
            r1 = r15
        L_0x00dc:
            androidx.constraintlayout.motion.utils.CurveFit[] r2 = r0.mSpline
            int r3 = r2.length
            if (r1 >= r3) goto L_0x0102
            r2 = r2[r1]
            float[] r3 = r0.mValuesBuff
            r4 = r20
            r2.getPos((double) r4, (float[]) r3)
            androidx.constraintlayout.motion.widget.c r2 = r0.mStartMotionPath
            java.util.LinkedHashMap r2 = r2.C
            java.lang.String[] r3 = r0.mAttributeNames
            int r6 = r1 + -1
            r3 = r3[r6]
            java.lang.Object r2 = r2.get(r3)
            androidx.constraintlayout.widget.ConstraintAttribute r2 = (androidx.constraintlayout.widget.ConstraintAttribute) r2
            float[] r3 = r0.mValuesBuff
            r2.setInterpolatedValue(r11, r3)
            int r1 = r1 + 1
            goto L_0x00dc
        L_0x0102:
            androidx.constraintlayout.motion.widget.b r1 = r0.mStartPoint
            int r2 = r1.f14633b
            if (r2 != 0) goto L_0x012c
            r2 = 0
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x0113
            int r1 = r1.f14634c
            r11.setVisibility(r1)
            goto L_0x012c
        L_0x0113:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0121
            androidx.constraintlayout.motion.widget.b r1 = r0.mEndPoint
            int r1 = r1.f14634c
            r11.setVisibility(r1)
            goto L_0x012c
        L_0x0121:
            androidx.constraintlayout.motion.widget.b r2 = r0.mEndPoint
            int r2 = r2.f14634c
            int r1 = r1.f14634c
            if (r2 == r1) goto L_0x012c
            r11.setVisibility(r13)
        L_0x012c:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r1 = r0.mKeyTriggers
            if (r1 == 0) goto L_0x0186
            r1 = r13
        L_0x0131:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r2 = r0.mKeyTriggers
            int r3 = r2.length
            if (r1 >= r3) goto L_0x0186
            r2 = r2[r1]
            r2.conditionallyFire(r12, r11)
            int r1 = r1 + 1
            goto L_0x0131
        L_0x013e:
            androidx.constraintlayout.motion.widget.c r1 = r0.mStartMotionPath
            float r2 = r1.f14647e
            androidx.constraintlayout.motion.widget.c r3 = r0.mEndMotionPath
            float r4 = r3.f14647e
            float r4 = r4 - r2
            float r4 = r4 * r12
            float r2 = r2 + r4
            float r4 = r1.f14648f
            float r5 = r3.f14648f
            float r5 = r5 - r4
            float r5 = r5 * r12
            float r4 = r4 + r5
            float r5 = r1.f14649g
            float r6 = r3.f14649g
            float r7 = r6 - r5
            float r7 = r7 * r12
            float r7 = r7 + r5
            float r1 = r1.f14650h
            float r3 = r3.f14650h
            float r8 = r3 - r1
            float r8 = r8 * r12
            float r8 = r8 + r1
            r9 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r9
            int r10 = (int) r2
            float r4 = r4 + r9
            int r9 = (int) r4
            float r2 = r2 + r7
            int r2 = (int) r2
            float r4 = r4 + r8
            int r4 = (int) r4
            int r7 = r2 - r10
            int r8 = r4 - r9
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x0176
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0183
        L_0x0176:
            r1 = 1073741824(0x40000000, float:2.0)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r1)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r1)
            r11.measure(r3, r1)
        L_0x0183:
            r11.layout(r10, r9, r2, r4)
        L_0x0186:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.KeyCycleOscillator> r1 = r0.mCycleMap
            if (r1 == 0) goto L_0x01b5
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x0192:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x01b5
            java.lang.Object r1 = r8.next()
            androidx.constraintlayout.motion.widget.KeyCycleOscillator r1 = (androidx.constraintlayout.motion.widget.KeyCycleOscillator) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.widget.KeyCycleOscillator.f
            if (r2 == 0) goto L_0x01b1
            androidx.constraintlayout.motion.widget.KeyCycleOscillator$f r1 = (androidx.constraintlayout.motion.widget.KeyCycleOscillator.f) r1
            double[] r2 = r0.mInterpolateVelocity
            r4 = r2[r13]
            r6 = r2[r15]
            r2 = r23
            r3 = r12
            r1.a(r2, r3, r4, r6)
            goto L_0x0192
        L_0x01b1:
            r1.setProperty(r11, r12)
            goto L_0x0192
        L_0x01b5:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.interpolate(android.view.View, float, long, androidx.constraintlayout.motion.widget.KeyCache):boolean");
    }

    /* access modifiers changed from: package-private */
    public String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    /* access modifiers changed from: package-private */
    public void positionKeyframe(View view, a aVar, float f10, float f11, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        c cVar = this.mStartMotionPath;
        float f12 = cVar.f14647e;
        rectF.left = f12;
        float f13 = cVar.f14648f;
        rectF.top = f13;
        rectF.right = f12 + cVar.f14649g;
        rectF.bottom = f13 + cVar.f14650h;
        RectF rectF2 = new RectF();
        c cVar2 = this.mEndMotionPath;
        float f14 = cVar2.f14647e;
        rectF2.left = f14;
        float f15 = cVar2.f14648f;
        rectF2.top = f15;
        rectF2.right = f14 + cVar2.f14649g;
        rectF2.bottom = f15 + cVar2.f14650h;
        aVar.positionAttributes(view, rectF, rectF2, f10, f11, strArr, fArr);
    }

    public void setDrawPath(int i10) {
        this.mStartMotionPath.f14644b = i10;
    }

    /* access modifiers changed from: package-private */
    public void setEndState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        c cVar = this.mEndMotionPath;
        cVar.f14645c = 1.0f;
        cVar.f14646d = 1.0f;
        readView(cVar);
        this.mEndMotionPath.o((float) constraintWidget.getX(), (float) constraintWidget.getY(), (float) constraintWidget.getWidth(), (float) constraintWidget.getHeight());
        this.mEndMotionPath.a(constraintSet.getParameters(this.mId));
        this.mEndPoint.i(constraintWidget, constraintSet, this.mId);
    }

    public void setPathMotionArc(int i10) {
        this.mPathMotionArc = i10;
    }

    /* access modifiers changed from: package-private */
    public void setStartCurrentState(View view) {
        c cVar = this.mStartMotionPath;
        cVar.f14645c = 0.0f;
        cVar.f14646d = 0.0f;
        cVar.o(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.mStartPoint.h(view);
    }

    /* access modifiers changed from: package-private */
    public void setStartState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        c cVar = this.mStartMotionPath;
        cVar.f14645c = 0.0f;
        cVar.f14646d = 0.0f;
        readView(cVar);
        this.mStartMotionPath.o((float) constraintWidget.getX(), (float) constraintWidget.getY(), (float) constraintWidget.getWidth(), (float) constraintWidget.getHeight());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(this.mId);
        this.mStartMotionPath.a(parameters);
        this.mMotionStagger = parameters.motion.mMotionStagger;
        this.mStartPoint.i(constraintWidget, constraintSet, this.mId);
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    public void setup(int i10, int i11, float f10, long j10) {
        ArrayList arrayList;
        String[] strArr;
        boolean z10;
        HashSet hashSet;
        int i12;
        TimeCycleSplineSet timeCycleSplineSet;
        ConstraintAttribute constraintAttribute;
        int i13;
        SplineSet splineSet;
        ConstraintAttribute constraintAttribute2;
        new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashMap hashMap = new HashMap();
        int i14 = this.mPathMotionArc;
        if (i14 != Key.UNSET) {
            this.mStartMotionPath.f14653w = i14;
        }
        this.mStartPoint.f(this.mEndPoint, hashSet3);
        ArrayList<Key> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            Iterator<Key> it = arrayList2.iterator();
            arrayList = null;
            while (it.hasNext()) {
                Key next = it.next();
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    insertKey(new c(i10, i11, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i15 = keyPosition.mCurveFit;
                    if (i15 != Key.UNSET) {
                        this.mCurveFitType = i15;
                    }
                } else if (next instanceof KeyCycle) {
                    next.getAttributeNames(hashSet4);
                } else if (next instanceof KeyTimeCycle) {
                    next.getAttributeNames(hashSet2);
                } else if (next instanceof KeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((KeyTrigger) next);
                } else {
                    next.setInterpolation(hashMap);
                    next.getAttributeNames(hashSet3);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        char c10 = 1;
        if (!hashSet3.isEmpty()) {
            this.mAttributesMap = new HashMap<>();
            Iterator it2 = hashSet3.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(",")[1];
                    Iterator<Key> it3 = this.mKeyList.iterator();
                    while (it3.hasNext()) {
                        Key next2 = it3.next();
                        HashMap<String, ConstraintAttribute> hashMap2 = next2.mCustomConstraints;
                        if (!(hashMap2 == null || (constraintAttribute2 = hashMap2.get(str2)) == null)) {
                            sparseArray.append(next2.mFramePosition, constraintAttribute2);
                        }
                    }
                    splineSet = SplineSet.makeCustomSpline(str, sparseArray);
                } else {
                    splineSet = SplineSet.makeSpline(str);
                }
                if (splineSet != null) {
                    splineSet.setType(str);
                    this.mAttributesMap.put(str, splineSet);
                }
            }
            ArrayList<Key> arrayList3 = this.mKeyList;
            if (arrayList3 != null) {
                Iterator<Key> it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    Key next3 = it4.next();
                    if (next3 instanceof KeyAttributes) {
                        next3.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.a(this.mAttributesMap, 0);
            this.mEndPoint.a(this.mAttributesMap, 100);
            for (String next4 : this.mAttributesMap.keySet()) {
                if (hashMap.containsKey(next4)) {
                    i13 = ((Integer) hashMap.get(next4)).intValue();
                } else {
                    i13 = 0;
                }
                this.mAttributesMap.get(next4).setup(i13);
            }
        }
        if (!hashSet2.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator it5 = hashSet2.iterator();
            while (it5.hasNext()) {
                String str3 = (String) it5.next();
                if (!this.mTimeCycleAttributesMap.containsKey(str3)) {
                    if (str3.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str4 = str3.split(",")[1];
                        Iterator<Key> it6 = this.mKeyList.iterator();
                        while (it6.hasNext()) {
                            Key next5 = it6.next();
                            HashMap<String, ConstraintAttribute> hashMap3 = next5.mCustomConstraints;
                            if (!(hashMap3 == null || (constraintAttribute = hashMap3.get(str4)) == null)) {
                                sparseArray2.append(next5.mFramePosition, constraintAttribute);
                            }
                        }
                        timeCycleSplineSet = TimeCycleSplineSet.makeCustomSpline(str3, sparseArray2);
                        long j11 = j10;
                    } else {
                        timeCycleSplineSet = TimeCycleSplineSet.makeSpline(str3, j10);
                    }
                    if (timeCycleSplineSet != null) {
                        timeCycleSplineSet.setType(str3);
                        this.mTimeCycleAttributesMap.put(str3, timeCycleSplineSet);
                    }
                }
            }
            ArrayList<Key> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                Iterator<Key> it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    Key next6 = it7.next();
                    if (next6 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) next6).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String next7 : this.mTimeCycleAttributesMap.keySet()) {
                if (hashMap.containsKey(next7)) {
                    i12 = ((Integer) hashMap.get(next7)).intValue();
                } else {
                    i12 = 0;
                }
                this.mTimeCycleAttributesMap.get(next7).setup(i12);
            }
        }
        int size = this.mMotionPaths.size();
        int i16 = size + 2;
        c[] cVarArr = new c[i16];
        cVarArr[0] = this.mStartMotionPath;
        cVarArr[size + 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        Iterator<c> it8 = this.mMotionPaths.iterator();
        int i17 = 1;
        while (it8.hasNext()) {
            cVarArr[i17] = it8.next();
            i17++;
        }
        HashSet hashSet5 = new HashSet();
        for (String str5 : this.mEndMotionPath.C.keySet()) {
            if (this.mStartMotionPath.C.containsKey(str5)) {
                if (!hashSet3.contains("CUSTOM," + str5)) {
                    hashSet5.add(str5);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet5.toArray(new String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpCount = new int[strArr2.length];
        int i18 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i18 >= strArr.length) {
                break;
            }
            String str6 = strArr[i18];
            this.mAttributeInterpCount[i18] = 0;
            int i19 = 0;
            while (true) {
                if (i19 >= i16) {
                    break;
                } else if (cVarArr[i19].C.containsKey(str6)) {
                    int[] iArr = this.mAttributeInterpCount;
                    iArr[i18] = iArr[i18] + ((ConstraintAttribute) cVarArr[i19].C.get(str6)).noOfInterpValues();
                    break;
                } else {
                    i19++;
                }
            }
            i18++;
        }
        if (cVarArr[0].f14653w != Key.UNSET) {
            z10 = true;
        } else {
            z10 = false;
        }
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i20 = 1; i20 < i16; i20++) {
            cVarArr[i20].d(cVarArr[i20 - 1], zArr, this.mAttributeNames, z10);
        }
        int i21 = 0;
        for (int i22 = 1; i22 < length; i22++) {
            if (zArr[i22]) {
                i21++;
            }
        }
        int[] iArr2 = new int[i21];
        this.mInterpolateVariables = iArr2;
        this.mInterpolateData = new double[iArr2.length];
        this.mInterpolateVelocity = new double[iArr2.length];
        int i23 = 0;
        for (int i24 = 1; i24 < length; i24++) {
            if (zArr[i24]) {
                this.mInterpolateVariables[i23] = i24;
                i23++;
            }
        }
        int i25 = 2;
        int[] iArr3 = new int[2];
        iArr3[1] = this.mInterpolateVariables.length;
        iArr3[0] = i16;
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, iArr3);
        double[] dArr2 = new double[i16];
        for (int i26 = 0; i26 < i16; i26++) {
            cVarArr[i26].e(dArr[i26], this.mInterpolateVariables);
            dArr2[i26] = (double) cVarArr[i26].f14645c;
        }
        int i27 = 0;
        while (true) {
            int[] iArr4 = this.mInterpolateVariables;
            if (i27 >= iArr4.length) {
                break;
            }
            if (iArr4[i27] < c.N0.length) {
                String str7 = c.N0[this.mInterpolateVariables[i27]] + " [";
                for (int i28 = 0; i28 < i16; i28++) {
                    str7 = str7 + dArr[i28][i27];
                }
            }
            i27++;
        }
        this.mSpline = new CurveFit[(this.mAttributeNames.length + 1)];
        int i29 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i29 >= strArr3.length) {
                break;
            }
            String str8 = strArr3[i29];
            int i30 = 0;
            int i31 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i30 < i16) {
                if (cVarArr[i30].k(str8)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i16];
                        int[] iArr5 = new int[i25];
                        iArr5[c10] = cVarArr[i30].i(str8);
                        iArr5[0] = i16;
                        dArr4 = (double[][]) Array.newInstance(Double.TYPE, iArr5);
                    }
                    c cVar = cVarArr[i30];
                    hashSet = hashSet4;
                    dArr3[i31] = (double) cVar.f14645c;
                    cVar.h(str8, dArr4[i31], 0);
                    i31++;
                } else {
                    hashSet = hashSet4;
                }
                i30++;
                hashSet4 = hashSet;
                i25 = 2;
                c10 = 1;
            }
            i29++;
            this.mSpline[i29] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i31), (double[][]) Arrays.copyOf(dArr4, i31));
            hashSet4 = hashSet4;
            i25 = 2;
            c10 = 1;
        }
        HashSet hashSet6 = hashSet4;
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (cVarArr[0].f14653w != Key.UNSET) {
            int[] iArr6 = new int[i16];
            double[] dArr5 = new double[i16];
            int[] iArr7 = new int[2];
            iArr7[1] = 2;
            iArr7[0] = i16;
            double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, iArr7);
            for (int i32 = 0; i32 < i16; i32++) {
                c cVar2 = cVarArr[i32];
                iArr6[i32] = cVar2.f14653w;
                dArr5[i32] = (double) cVar2.f14645c;
                double[] dArr7 = dArr6[i32];
                dArr7[0] = (double) cVar2.f14647e;
                dArr7[1] = (double) cVar2.f14648f;
            }
            this.mArcSpline = CurveFit.getArc(iArr6, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator it9 = hashSet6.iterator();
            float f11 = Float.NaN;
            while (it9.hasNext()) {
                String str9 = (String) it9.next();
                KeyCycleOscillator makeSpline = KeyCycleOscillator.makeSpline(str9);
                if (makeSpline != null) {
                    if (makeSpline.variesByPath() && Float.isNaN(f11)) {
                        f11 = getPreCycleDistance();
                    }
                    makeSpline.setType(str9);
                    this.mCycleMap.put(str9, makeSpline);
                }
            }
            Iterator<Key> it10 = this.mKeyList.iterator();
            while (it10.hasNext()) {
                Key next8 = it10.next();
                if (next8 instanceof KeyCycle) {
                    ((KeyCycle) next8).addCycleValues(this.mCycleMap);
                }
            }
            for (KeyCycleOscillator upVar : this.mCycleMap.values()) {
                upVar.setup(f11);
            }
        }
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.f14647e + " y: " + this.mStartMotionPath.f14648f + " end: x: " + this.mEndMotionPath.f14647e + " y: " + this.mEndMotionPath.f14648f;
    }
}
