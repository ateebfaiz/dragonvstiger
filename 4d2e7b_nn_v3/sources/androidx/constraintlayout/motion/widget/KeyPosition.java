package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

public class KeyPosition extends a {
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    private static final String PERCENT_X = "percentX";
    private static final String PERCENT_Y = "percentY";
    private static final String TAG = "KeyPosition";
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    float mAltPercentX = Float.NaN;
    float mAltPercentY = Float.NaN;
    private float mCalculatedPositionX = Float.NaN;
    private float mCalculatedPositionY = Float.NaN;
    int mDrawPath = 0;
    int mPathMotionArc = Key.UNSET;
    float mPercentHeight = Float.NaN;
    float mPercentWidth = Float.NaN;
    float mPercentX = Float.NaN;
    float mPercentY = Float.NaN;
    int mPositionType = 0;
    String mTransitionEasing = null;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f14562a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f14562a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            f14562a.append(R.styleable.KeyPosition_framePosition, 2);
            f14562a.append(R.styleable.KeyPosition_transitionEasing, 3);
            f14562a.append(R.styleable.KeyPosition_curveFit, 4);
            f14562a.append(R.styleable.KeyPosition_drawPath, 5);
            f14562a.append(R.styleable.KeyPosition_percentX, 6);
            f14562a.append(R.styleable.KeyPosition_percentY, 7);
            f14562a.append(R.styleable.KeyPosition_keyPositionType, 9);
            f14562a.append(R.styleable.KeyPosition_sizePercent, 8);
            f14562a.append(R.styleable.KeyPosition_percentWidth, 11);
            f14562a.append(R.styleable.KeyPosition_percentHeight, 12);
            f14562a.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        /* access modifiers changed from: private */
        public static void b(KeyPosition keyPosition, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f14562a.get(index)) {
                    case 1:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyPosition.mTargetId = typedArray.getResourceId(index, keyPosition.mTargetId);
                                break;
                            } else {
                                keyPosition.mTargetString = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyPosition.mTargetId);
                            keyPosition.mTargetId = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyPosition.mTargetString = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        keyPosition.mFramePosition = typedArray.getInt(index, keyPosition.mFramePosition);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type != 3) {
                            keyPosition.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                            break;
                        } else {
                            keyPosition.mTransitionEasing = typedArray.getString(index);
                            break;
                        }
                    case 4:
                        keyPosition.mCurveFit = typedArray.getInteger(index, keyPosition.mCurveFit);
                        break;
                    case 5:
                        keyPosition.mDrawPath = typedArray.getInt(index, keyPosition.mDrawPath);
                        break;
                    case 6:
                        keyPosition.mPercentX = typedArray.getFloat(index, keyPosition.mPercentX);
                        break;
                    case 7:
                        keyPosition.mPercentY = typedArray.getFloat(index, keyPosition.mPercentY);
                        break;
                    case 8:
                        float f10 = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        keyPosition.mPercentWidth = f10;
                        keyPosition.mPercentHeight = f10;
                        break;
                    case 9:
                        keyPosition.mPositionType = typedArray.getInt(index, keyPosition.mPositionType);
                        break;
                    case 10:
                        keyPosition.mPathMotionArc = typedArray.getInt(index, keyPosition.mPathMotionArc);
                        break;
                    case 11:
                        keyPosition.mPercentWidth = typedArray.getFloat(index, keyPosition.mPercentWidth);
                        break;
                    case 12:
                        keyPosition.mPercentHeight = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + f14562a.get(index));
                        break;
                }
            }
            if (keyPosition.mFramePosition == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public KeyPosition() {
        this.mType = 2;
    }

    private void calcCartesianPosition(float f10, float f11, float f12, float f13) {
        float f14;
        float f15;
        float f16;
        float f17 = f12 - f10;
        float f18 = f13 - f11;
        float f19 = 0.0f;
        if (Float.isNaN(this.mPercentX)) {
            f14 = 0.0f;
        } else {
            f14 = this.mPercentX;
        }
        if (Float.isNaN(this.mAltPercentY)) {
            f15 = 0.0f;
        } else {
            f15 = this.mAltPercentY;
        }
        if (Float.isNaN(this.mPercentY)) {
            f16 = 0.0f;
        } else {
            f16 = this.mPercentY;
        }
        if (!Float.isNaN(this.mAltPercentX)) {
            f19 = this.mAltPercentX;
        }
        this.mCalculatedPositionX = (float) ((int) (f10 + (f14 * f17) + (f19 * f18)));
        this.mCalculatedPositionY = (float) ((int) (f11 + (f17 * f15) + (f18 * f16)));
    }

    private void calcPathPosition(float f10, float f11, float f12, float f13) {
        float f14 = f12 - f10;
        float f15 = f13 - f11;
        float f16 = this.mPercentX;
        float f17 = this.mPercentY;
        this.mCalculatedPositionX = f10 + (f14 * f16) + ((-f15) * f17);
        this.mCalculatedPositionY = f11 + (f15 * f16) + (f14 * f17);
    }

    private void calcScreenPosition(int i10, int i11) {
        float f10 = this.mPercentX;
        float f11 = (float) 0;
        this.mCalculatedPositionX = (((float) i10) * f10) + f11;
        this.mCalculatedPositionY = (((float) i11) * f10) + f11;
    }

    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    /* access modifiers changed from: package-private */
    public void calcPosition(int i10, int i11, float f10, float f11, float f12, float f13) {
        int i12 = this.mPositionType;
        if (i12 == 1) {
            calcPathPosition(f10, f11, f12, f13);
        } else if (i12 != 2) {
            calcCartesianPosition(f10, f11, f12, f13);
        } else {
            calcScreenPosition(i10, i11);
        }
    }

    /* access modifiers changed from: package-private */
    public float getPositionX() {
        return this.mCalculatedPositionX;
    }

    /* access modifiers changed from: package-private */
    public float getPositionY() {
        return this.mCalculatedPositionY;
    }

    public boolean intersects(int i10, int i11, RectF rectF, RectF rectF2, float f10, float f11) {
        calcPosition(i10, i11, rectF.centerX(), rectF.centerY(), rectF2.centerX(), rectF2.centerY());
        if (Math.abs(f10 - this.mCalculatedPositionX) >= 20.0f || Math.abs(f11 - this.mCalculatedPositionY) >= 20.0f) {
            return false;
        }
        return true;
    }

    public void load(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition));
    }

    public void positionAttributes(View view, RectF rectF, RectF rectF2, float f10, float f11, String[] strArr, float[] fArr) {
        int i10 = this.mPositionType;
        if (i10 == 1) {
            positionPathAttributes(rectF, rectF2, f10, f11, strArr, fArr);
        } else if (i10 != 2) {
            positionCartAttributes(rectF, rectF2, f10, f11, strArr, fArr);
        } else {
            positionScreenAttributes(view, rectF, rectF2, f10, f11, strArr, fArr);
        }
    }

    /* access modifiers changed from: package-private */
    public void positionCartAttributes(RectF rectF, RectF rectF2, float f10, float f11, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
        String str = strArr[0];
        if (str == null) {
            strArr[0] = PERCENT_X;
            fArr[0] = (f10 - centerX) / centerX2;
            strArr[1] = PERCENT_Y;
            fArr[1] = (f11 - centerY) / centerY2;
        } else if (PERCENT_X.equals(str)) {
            fArr[0] = (f10 - centerX) / centerX2;
            fArr[1] = (f11 - centerY) / centerY2;
        } else {
            fArr[1] = (f10 - centerX) / centerX2;
            fArr[0] = (f11 - centerY) / centerY2;
        }
    }

    /* access modifiers changed from: package-private */
    public void positionPathAttributes(RectF rectF, RectF rectF2, float f10, float f11, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
        float hypot = (float) Math.hypot((double) centerX2, (double) centerY2);
        if (((double) hypot) < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f12 = centerX2 / hypot;
        float f13 = centerY2 / hypot;
        float f14 = f11 - centerY;
        float f15 = f10 - centerX;
        float f16 = ((f12 * f14) - (f15 * f13)) / hypot;
        float f17 = ((f12 * f15) + (f13 * f14)) / hypot;
        String str = strArr[0];
        if (str == null) {
            strArr[0] = PERCENT_X;
            strArr[1] = PERCENT_Y;
            fArr[0] = f17;
            fArr[1] = f16;
        } else if (PERCENT_X.equals(str)) {
            fArr[0] = f17;
            fArr[1] = f16;
        }
    }

    /* access modifiers changed from: package-private */
    public void positionScreenAttributes(View view, RectF rectF, RectF rectF2, float f10, float f11, String[] strArr, float[] fArr) {
        rectF.centerX();
        rectF.centerY();
        rectF2.centerX();
        rectF2.centerY();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        String str = strArr[0];
        if (str == null) {
            strArr[0] = PERCENT_X;
            fArr[0] = f10 / ((float) width);
            strArr[1] = PERCENT_Y;
            fArr[1] = f11 / ((float) height);
        } else if (PERCENT_X.equals(str)) {
            fArr[0] = f10 / ((float) width);
            fArr[1] = f11 / ((float) height);
        } else {
            fArr[1] = f10 / ((float) width);
            fArr[0] = f11 / ((float) height);
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
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c10 = 2;
                    break;
                }
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c10 = 3;
                    break;
                }
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c10 = 4;
                    break;
                }
                break;
            case 428090547:
                if (str.equals(PERCENT_X)) {
                    c10 = 5;
                    break;
                }
                break;
            case 428090548:
                if (str.equals(PERCENT_Y)) {
                    c10 = 6;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                this.mTransitionEasing = obj.toString();
                return;
            case 1:
                this.mPercentWidth = toFloat(obj);
                return;
            case 2:
                this.mPercentHeight = toFloat(obj);
                return;
            case 3:
                this.mDrawPath = toInt(obj);
                return;
            case 4:
                float f10 = toFloat(obj);
                this.mPercentWidth = f10;
                this.mPercentHeight = f10;
                return;
            case 5:
                this.mPercentX = toFloat(obj);
                return;
            case 6:
                this.mPercentY = toFloat(obj);
                return;
            default:
                return;
        }
    }
}
