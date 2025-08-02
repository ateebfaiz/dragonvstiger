package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.HashSet;

public class KeyTimeCycle extends Key {
    public static final int KEY_TYPE = 3;
    static final String NAME = "KeyTimeCycle";
    private static final String TAG = "KeyTimeCycle";
    /* access modifiers changed from: private */
    public float mAlpha = Float.NaN;
    /* access modifiers changed from: private */
    public int mCurveFit = -1;
    /* access modifiers changed from: private */
    public float mElevation = Float.NaN;
    /* access modifiers changed from: private */
    public float mProgress = Float.NaN;
    /* access modifiers changed from: private */
    public float mRotation = Float.NaN;
    /* access modifiers changed from: private */
    public float mRotationX = Float.NaN;
    /* access modifiers changed from: private */
    public float mRotationY = Float.NaN;
    /* access modifiers changed from: private */
    public float mScaleX = Float.NaN;
    /* access modifiers changed from: private */
    public float mScaleY = Float.NaN;
    /* access modifiers changed from: private */
    public String mTransitionEasing;
    /* access modifiers changed from: private */
    public float mTransitionPathRotate = Float.NaN;
    /* access modifiers changed from: private */
    public float mTranslationX = Float.NaN;
    /* access modifiers changed from: private */
    public float mTranslationY = Float.NaN;
    /* access modifiers changed from: private */
    public float mTranslationZ = Float.NaN;
    /* access modifiers changed from: private */
    public float mWaveOffset = 0.0f;
    private CurveFit mWaveOffsetSpline;
    /* access modifiers changed from: private */
    public float mWavePeriod = Float.NaN;
    private CurveFit mWavePeriodSpline;
    /* access modifiers changed from: private */
    public int mWaveShape = 0;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f14563a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f14563a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_alpha, 1);
            f14563a.append(R.styleable.KeyTimeCycle_android_elevation, 2);
            f14563a.append(R.styleable.KeyTimeCycle_android_rotation, 4);
            f14563a.append(R.styleable.KeyTimeCycle_android_rotationX, 5);
            f14563a.append(R.styleable.KeyTimeCycle_android_rotationY, 6);
            f14563a.append(R.styleable.KeyTimeCycle_android_scaleX, 7);
            f14563a.append(R.styleable.KeyTimeCycle_transitionPathRotate, 8);
            f14563a.append(R.styleable.KeyTimeCycle_transitionEasing, 9);
            f14563a.append(R.styleable.KeyTimeCycle_motionTarget, 10);
            f14563a.append(R.styleable.KeyTimeCycle_framePosition, 12);
            f14563a.append(R.styleable.KeyTimeCycle_curveFit, 13);
            f14563a.append(R.styleable.KeyTimeCycle_android_scaleY, 14);
            f14563a.append(R.styleable.KeyTimeCycle_android_translationX, 15);
            f14563a.append(R.styleable.KeyTimeCycle_android_translationY, 16);
            f14563a.append(R.styleable.KeyTimeCycle_android_translationZ, 17);
            f14563a.append(R.styleable.KeyTimeCycle_motionProgress, 18);
            f14563a.append(R.styleable.KeyTimeCycle_wavePeriod, 20);
            f14563a.append(R.styleable.KeyTimeCycle_waveOffset, 21);
            f14563a.append(R.styleable.KeyTimeCycle_waveShape, 19);
        }

        public static void a(KeyTimeCycle keyTimeCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f14563a.get(index)) {
                    case 1:
                        float unused = keyTimeCycle.mAlpha = typedArray.getFloat(index, keyTimeCycle.mAlpha);
                        break;
                    case 2:
                        float unused2 = keyTimeCycle.mElevation = typedArray.getDimension(index, keyTimeCycle.mElevation);
                        break;
                    case 4:
                        float unused3 = keyTimeCycle.mRotation = typedArray.getFloat(index, keyTimeCycle.mRotation);
                        break;
                    case 5:
                        float unused4 = keyTimeCycle.mRotationX = typedArray.getFloat(index, keyTimeCycle.mRotationX);
                        break;
                    case 6:
                        float unused5 = keyTimeCycle.mRotationY = typedArray.getFloat(index, keyTimeCycle.mRotationY);
                        break;
                    case 7:
                        float unused6 = keyTimeCycle.mScaleX = typedArray.getFloat(index, keyTimeCycle.mScaleX);
                        break;
                    case 8:
                        float unused7 = keyTimeCycle.mTransitionPathRotate = typedArray.getFloat(index, keyTimeCycle.mTransitionPathRotate);
                        break;
                    case 9:
                        String unused8 = keyTimeCycle.mTransitionEasing = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyTimeCycle.mTargetId = typedArray.getResourceId(index, keyTimeCycle.mTargetId);
                                break;
                            } else {
                                keyTimeCycle.mTargetString = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyTimeCycle.mTargetId);
                            keyTimeCycle.mTargetId = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyTimeCycle.mTargetString = typedArray.getString(index);
                                break;
                            }
                        }
                    case 12:
                        keyTimeCycle.mFramePosition = typedArray.getInt(index, keyTimeCycle.mFramePosition);
                        break;
                    case 13:
                        int unused9 = keyTimeCycle.mCurveFit = typedArray.getInteger(index, keyTimeCycle.mCurveFit);
                        break;
                    case 14:
                        float unused10 = keyTimeCycle.mScaleY = typedArray.getFloat(index, keyTimeCycle.mScaleY);
                        break;
                    case 15:
                        float unused11 = keyTimeCycle.mTranslationX = typedArray.getDimension(index, keyTimeCycle.mTranslationX);
                        break;
                    case 16:
                        float unused12 = keyTimeCycle.mTranslationY = typedArray.getDimension(index, keyTimeCycle.mTranslationY);
                        break;
                    case 17:
                        float unused13 = keyTimeCycle.mTranslationZ = typedArray.getDimension(index, keyTimeCycle.mTranslationZ);
                        break;
                    case 18:
                        float unused14 = keyTimeCycle.mProgress = typedArray.getFloat(index, keyTimeCycle.mProgress);
                        break;
                    case 19:
                        int unused15 = keyTimeCycle.mWaveShape = typedArray.getInt(index, keyTimeCycle.mWaveShape);
                        break;
                    case 20:
                        float unused16 = keyTimeCycle.mWavePeriod = typedArray.getFloat(index, keyTimeCycle.mWavePeriod);
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type != 5) {
                            float unused17 = keyTimeCycle.mWaveOffset = typedArray.getFloat(index, keyTimeCycle.mWaveOffset);
                            break;
                        } else {
                            float unused18 = keyTimeCycle.mWaveOffset = typedArray.getDimension(index, keyTimeCycle.mWaveOffset);
                            break;
                        }
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f14563a.get(index));
                        break;
                }
            }
        }
    }

    public KeyTimeCycle() {
        this.mType = 3;
        this.mCustomConstraints = new HashMap<>();
    }

    public void addTimeValues(HashMap<String, TimeCycleSplineSet> hashMap) {
        for (String next : hashMap.keySet()) {
            TimeCycleSplineSet timeCycleSplineSet = hashMap.get(next);
            if (!next.startsWith("CUSTOM")) {
                char c10 = 65535;
                switch (next.hashCode()) {
                    case -1249320806:
                        if (next.equals("rotationX")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -1249320805:
                        if (next.equals("rotationY")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -1225497657:
                        if (next.equals("translationX")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (next.equals("translationY")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case -1225497655:
                        if (next.equals("translationZ")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case -1001078227:
                        if (next.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case -908189618:
                        if (next.equals("scaleX")) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        if (next.equals("scaleY")) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case -40300674:
                        if (next.equals("rotation")) {
                            c10 = 8;
                            break;
                        }
                        break;
                    case -4379043:
                        if (next.equals("elevation")) {
                            c10 = 9;
                            break;
                        }
                        break;
                    case 37232917:
                        if (next.equals("transitionPathRotate")) {
                            c10 = 10;
                            break;
                        }
                        break;
                    case 92909918:
                        if (next.equals("alpha")) {
                            c10 = 11;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        if (Float.isNaN(this.mRotationX)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mRotationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 1:
                        if (Float.isNaN(this.mRotationY)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mRotationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 2:
                        if (Float.isNaN(this.mTranslationX)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mTranslationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 3:
                        if (Float.isNaN(this.mTranslationY)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mTranslationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 4:
                        if (Float.isNaN(this.mTranslationZ)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 5:
                        if (Float.isNaN(this.mProgress)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mProgress, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 6:
                        if (Float.isNaN(this.mScaleX)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mScaleX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 7:
                        if (Float.isNaN(this.mScaleY)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mScaleY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 8:
                        if (Float.isNaN(this.mRotation)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mRotation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 9:
                        if (Float.isNaN(this.mElevation)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mElevation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 10:
                        if (Float.isNaN(this.mTransitionPathRotate)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 11:
                        if (Float.isNaN(this.mAlpha)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mAlpha, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    default:
                        Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + next + "\"");
                        break;
                }
            } else {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(next.substring(7));
                if (constraintAttribute != null) {
                    ((TimeCycleSplineSet.b) timeCycleSplineSet).a(this.mFramePosition, constraintAttribute, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                }
            }
        }
    }

    public void addValues(HashMap<String, SplineSet> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.mProgress)) {
            hashSet.add(NotificationCompat.CATEGORY_PROGRESS);
        }
        if (this.mCustomConstraints.size() > 0) {
            for (String str : this.mCustomConstraints.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getCurveFit() {
        return this.mCurveFit;
    }

    public void load(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTimeCycle));
    }

    public void setInterpolation(HashMap<String, Integer> hashMap) {
        if (this.mCurveFit != -1) {
            if (!Float.isNaN(this.mAlpha)) {
                hashMap.put("alpha", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mElevation)) {
                hashMap.put("elevation", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mRotation)) {
                hashMap.put("rotation", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mRotationX)) {
                hashMap.put("rotationX", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mRotationY)) {
                hashMap.put("rotationY", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mTranslationX)) {
                hashMap.put("translationX", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mTranslationY)) {
                hashMap.put("translationY", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mTranslationZ)) {
                hashMap.put("translationZ", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mTransitionPathRotate)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mScaleX)) {
                hashMap.put("scaleX", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mScaleX)) {
                hashMap.put("scaleY", Integer.valueOf(this.mCurveFit));
            }
            if (!Float.isNaN(this.mProgress)) {
                hashMap.put(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(this.mCurveFit));
            }
            if (this.mCustomConstraints.size() > 0) {
                for (String str : this.mCustomConstraints.keySet()) {
                    hashMap.put("CUSTOM," + str, Integer.valueOf(this.mCurveFit));
                }
            }
        }
    }

    public void setValue(String str, Object obj) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c10 = 3;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
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
            case 579057826:
                if (str.equals("curveFit")) {
                    c10 = 12;
                    break;
                }
                break;
            case 1317633238:
                if (str.equals("mTranslationZ")) {
                    c10 = 13;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                this.mTransitionEasing = obj.toString();
                return;
            case 1:
                this.mRotationX = toFloat(obj);
                return;
            case 2:
                this.mRotationY = toFloat(obj);
                return;
            case 3:
                this.mTranslationX = toFloat(obj);
                return;
            case 4:
                this.mTranslationY = toFloat(obj);
                return;
            case 5:
                this.mProgress = toFloat(obj);
                return;
            case 6:
                this.mScaleX = toFloat(obj);
                return;
            case 7:
                this.mScaleY = toFloat(obj);
                return;
            case 8:
                this.mRotation = toFloat(obj);
                return;
            case 9:
                this.mElevation = toFloat(obj);
                return;
            case 10:
                this.mTransitionPathRotate = toFloat(obj);
                return;
            case 11:
                this.mAlpha = toFloat(obj);
                return;
            case 12:
                this.mCurveFit = toInt(obj);
                return;
            case 13:
                this.mTranslationZ = toFloat(obj);
                return;
            default:
                return;
        }
    }
}
