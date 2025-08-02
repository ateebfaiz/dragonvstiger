package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

public class KeyTrigger extends Key {
    public static final int KEY_TYPE = 5;
    static final String NAME = "KeyTrigger";
    private static final String TAG = "KeyTrigger";
    RectF mCollisionRect;
    /* access modifiers changed from: private */
    public String mCross = null;
    private int mCurveFit = -1;
    private Method mFireCross;
    private boolean mFireCrossReset;
    private float mFireLastPos;
    private Method mFireNegativeCross;
    private boolean mFireNegativeReset;
    private Method mFirePositiveCross;
    private boolean mFirePositiveReset;
    /* access modifiers changed from: private */
    public float mFireThreshold;
    /* access modifiers changed from: private */
    public String mNegativeCross;
    /* access modifiers changed from: private */
    public String mPositiveCross;
    /* access modifiers changed from: private */
    public boolean mPostLayout;
    RectF mTargetRect;
    /* access modifiers changed from: private */
    public int mTriggerCollisionId;
    private View mTriggerCollisionView;
    /* access modifiers changed from: private */
    public int mTriggerID;
    /* access modifiers changed from: private */
    public int mTriggerReceiver;
    float mTriggerSlack;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f14564a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f14564a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
            f14564a.append(R.styleable.KeyTrigger_onCross, 4);
            f14564a.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            f14564a.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            f14564a.append(R.styleable.KeyTrigger_motionTarget, 7);
            f14564a.append(R.styleable.KeyTrigger_triggerId, 6);
            f14564a.append(R.styleable.KeyTrigger_triggerSlack, 5);
            f14564a.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            f14564a.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            f14564a.append(R.styleable.KeyTrigger_triggerReceiver, 11);
        }

        public static void a(KeyTrigger keyTrigger, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f14564a.get(index)) {
                    case 1:
                        String unused = keyTrigger.mNegativeCross = typedArray.getString(index);
                        continue;
                    case 2:
                        String unused2 = keyTrigger.mPositiveCross = typedArray.getString(index);
                        continue;
                    case 4:
                        String unused3 = keyTrigger.mCross = typedArray.getString(index);
                        continue;
                    case 5:
                        keyTrigger.mTriggerSlack = typedArray.getFloat(index, keyTrigger.mTriggerSlack);
                        continue;
                    case 6:
                        int unused4 = keyTrigger.mTriggerID = typedArray.getResourceId(index, keyTrigger.mTriggerID);
                        continue;
                    case 7:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyTrigger.mTargetId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                                break;
                            } else {
                                keyTrigger.mTargetString = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                            keyTrigger.mTargetId = resourceId;
                            if (resourceId == -1) {
                                keyTrigger.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                continue;
                            }
                        }
                    case 8:
                        int integer = typedArray.getInteger(index, keyTrigger.mFramePosition);
                        keyTrigger.mFramePosition = integer;
                        float unused5 = keyTrigger.mFireThreshold = (((float) integer) + 0.5f) / 100.0f;
                        continue;
                    case 9:
                        int unused6 = keyTrigger.mTriggerCollisionId = typedArray.getResourceId(index, keyTrigger.mTriggerCollisionId);
                        continue;
                    case 10:
                        boolean unused7 = keyTrigger.mPostLayout = typedArray.getBoolean(index, keyTrigger.mPostLayout);
                        continue;
                    case 11:
                        int unused8 = keyTrigger.mTriggerReceiver = typedArray.getResourceId(index, keyTrigger.mTriggerReceiver);
                        break;
                }
                Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + f14564a.get(index));
            }
        }
    }

    public KeyTrigger() {
        int i10 = Key.UNSET;
        this.mTriggerReceiver = i10;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = i10;
        this.mTriggerCollisionId = i10;
        this.mTriggerCollisionView = null;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.mCollisionRect = new RectF();
        this.mTargetRect = new RectF();
        this.mType = 5;
        this.mCustomConstraints = new HashMap<>();
    }

    private void setUpRect(RectF rectF, View view, boolean z10) {
        rectF.top = (float) view.getTop();
        rectF.bottom = (float) view.getBottom();
        rectF.left = (float) view.getLeft();
        rectF.right = (float) view.getRight();
        if (z10) {
            view.getMatrix().mapRect(rectF);
        }
    }

    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void conditionallyFire(float r11, android.view.View r12) {
        /*
            r10 = this;
            int r0 = r10.mTriggerCollisionId
            int r1 = androidx.constraintlayout.motion.widget.Key.UNSET
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x0063
            android.view.View r0 = r10.mTriggerCollisionView
            if (r0 != 0) goto L_0x001a
            android.view.ViewParent r0 = r12.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r1 = r10.mTriggerCollisionId
            android.view.View r0 = r0.findViewById(r1)
            r10.mTriggerCollisionView = r0
        L_0x001a:
            android.graphics.RectF r0 = r10.mCollisionRect
            android.view.View r1 = r10.mTriggerCollisionView
            boolean r4 = r10.mPostLayout
            r10.setUpRect(r0, r1, r4)
            android.graphics.RectF r0 = r10.mTargetRect
            boolean r1 = r10.mPostLayout
            r10.setUpRect(r0, r12, r1)
            android.graphics.RectF r0 = r10.mCollisionRect
            android.graphics.RectF r1 = r10.mTargetRect
            boolean r0 = r0.intersect(r1)
            if (r0 == 0) goto L_0x004a
            boolean r0 = r10.mFireCrossReset
            if (r0 == 0) goto L_0x003c
            r10.mFireCrossReset = r3
            r0 = r2
            goto L_0x003d
        L_0x003c:
            r0 = r3
        L_0x003d:
            boolean r1 = r10.mFirePositiveReset
            if (r1 == 0) goto L_0x0045
            r10.mFirePositiveReset = r3
            r1 = r2
            goto L_0x0046
        L_0x0045:
            r1 = r3
        L_0x0046:
            r10.mFireNegativeReset = r2
            goto L_0x00df
        L_0x004a:
            boolean r0 = r10.mFireCrossReset
            if (r0 != 0) goto L_0x0052
            r10.mFireCrossReset = r2
            r0 = r2
            goto L_0x0053
        L_0x0052:
            r0 = r3
        L_0x0053:
            boolean r1 = r10.mFireNegativeReset
            if (r1 == 0) goto L_0x005b
            r10.mFireNegativeReset = r3
            r1 = r2
            goto L_0x005c
        L_0x005b:
            r1 = r3
        L_0x005c:
            r10.mFirePositiveReset = r2
            r9 = r3
            r3 = r1
            r1 = r9
            goto L_0x00df
        L_0x0063:
            boolean r0 = r10.mFireCrossReset
            r1 = 0
            if (r0 == 0) goto L_0x0078
            float r0 = r10.mFireThreshold
            float r4 = r11 - r0
            float r5 = r10.mFireLastPos
            float r5 = r5 - r0
            float r4 = r4 * r5
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0088
            r10.mFireCrossReset = r3
            r0 = r2
            goto L_0x0089
        L_0x0078:
            float r0 = r10.mFireThreshold
            float r0 = r11 - r0
            float r0 = java.lang.Math.abs(r0)
            float r4 = r10.mTriggerSlack
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0088
            r10.mFireCrossReset = r2
        L_0x0088:
            r0 = r3
        L_0x0089:
            boolean r4 = r10.mFireNegativeReset
            if (r4 == 0) goto L_0x00a1
            float r4 = r10.mFireThreshold
            float r5 = r11 - r4
            float r6 = r10.mFireLastPos
            float r6 = r6 - r4
            float r6 = r6 * r5
            int r4 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b1
            int r4 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b1
            r10.mFireNegativeReset = r3
            r4 = r2
            goto L_0x00b2
        L_0x00a1:
            float r4 = r10.mFireThreshold
            float r4 = r11 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r10.mTriggerSlack
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b1
            r10.mFireNegativeReset = r2
        L_0x00b1:
            r4 = r3
        L_0x00b2:
            boolean r5 = r10.mFirePositiveReset
            if (r5 == 0) goto L_0x00cd
            float r5 = r10.mFireThreshold
            float r6 = r11 - r5
            float r7 = r10.mFireLastPos
            float r7 = r7 - r5
            float r7 = r7 * r6
            int r5 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x00c9
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x00c9
            r10.mFirePositiveReset = r3
            goto L_0x00ca
        L_0x00c9:
            r2 = r3
        L_0x00ca:
            r1 = r2
        L_0x00cb:
            r3 = r4
            goto L_0x00df
        L_0x00cd:
            float r1 = r10.mFireThreshold
            float r1 = r11 - r1
            float r1 = java.lang.Math.abs(r1)
            float r5 = r10.mTriggerSlack
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x00dd
            r10.mFirePositiveReset = r2
        L_0x00dd:
            r1 = r3
            goto L_0x00cb
        L_0x00df:
            r10.mFireLastPos = r11
            if (r3 != 0) goto L_0x00e7
            if (r0 != 0) goto L_0x00e7
            if (r1 == 0) goto L_0x00f2
        L_0x00e7:
            android.view.ViewParent r2 = r12.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r2 = (androidx.constraintlayout.motion.widget.MotionLayout) r2
            int r4 = r10.mTriggerID
            r2.fireTrigger(r4, r1, r11)
        L_0x00f2:
            int r11 = r10.mTriggerReceiver
            int r2 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r11 != r2) goto L_0x00f9
            goto L_0x0105
        L_0x00f9:
            android.view.ViewParent r11 = r12.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r11 = (androidx.constraintlayout.motion.widget.MotionLayout) r11
            int r12 = r10.mTriggerReceiver
            android.view.View r12 = r11.findViewById(r12)
        L_0x0105:
            java.lang.String r11 = "Exception in call \""
            java.lang.String r2 = "Could not find method \""
            java.lang.String r4 = " "
            java.lang.String r5 = "\"on class "
            java.lang.String r6 = "KeyTrigger"
            r7 = 0
            if (r3 == 0) goto L_0x0185
            java.lang.String r3 = r10.mNegativeCross
            if (r3 == 0) goto L_0x0185
            java.lang.reflect.Method r3 = r10.mFireNegativeCross
            if (r3 != 0) goto L_0x0153
            java.lang.Class r3 = r12.getClass()     // Catch:{ NoSuchMethodException -> 0x0127 }
            java.lang.String r8 = r10.mNegativeCross     // Catch:{ NoSuchMethodException -> 0x0127 }
            java.lang.reflect.Method r3 = r3.getMethod(r8, r7)     // Catch:{ NoSuchMethodException -> 0x0127 }
            r10.mFireNegativeCross = r3     // Catch:{ NoSuchMethodException -> 0x0127 }
            goto L_0x0153
        L_0x0127:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r8 = r10.mNegativeCross
            r3.append(r8)
            r3.append(r5)
            java.lang.Class r8 = r12.getClass()
            java.lang.String r8 = r8.getSimpleName()
            r3.append(r8)
            r3.append(r4)
            java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.getName(r12)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r6, r3)
        L_0x0153:
            java.lang.reflect.Method r3 = r10.mFireNegativeCross     // Catch:{ Exception -> 0x0159 }
            r3.invoke(r12, r7)     // Catch:{ Exception -> 0x0159 }
            goto L_0x0185
        L_0x0159:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r11)
            java.lang.String r8 = r10.mNegativeCross
            r3.append(r8)
            r3.append(r5)
            java.lang.Class r8 = r12.getClass()
            java.lang.String r8 = r8.getSimpleName()
            r3.append(r8)
            r3.append(r4)
            java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.getName(r12)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r6, r3)
        L_0x0185:
            if (r1 == 0) goto L_0x01fa
            java.lang.String r1 = r10.mPositiveCross
            if (r1 == 0) goto L_0x01fa
            java.lang.reflect.Method r1 = r10.mFirePositiveCross
            if (r1 != 0) goto L_0x01c8
            java.lang.Class r1 = r12.getClass()     // Catch:{ NoSuchMethodException -> 0x019c }
            java.lang.String r3 = r10.mPositiveCross     // Catch:{ NoSuchMethodException -> 0x019c }
            java.lang.reflect.Method r1 = r1.getMethod(r3, r7)     // Catch:{ NoSuchMethodException -> 0x019c }
            r10.mFirePositiveCross = r1     // Catch:{ NoSuchMethodException -> 0x019c }
            goto L_0x01c8
        L_0x019c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            java.lang.String r3 = r10.mPositiveCross
            r1.append(r3)
            r1.append(r5)
            java.lang.Class r3 = r12.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r1.append(r3)
            r1.append(r4)
            java.lang.String r3 = androidx.constraintlayout.motion.widget.Debug.getName(r12)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r6, r1)
        L_0x01c8:
            java.lang.reflect.Method r1 = r10.mFirePositiveCross     // Catch:{ Exception -> 0x01ce }
            r1.invoke(r12, r7)     // Catch:{ Exception -> 0x01ce }
            goto L_0x01fa
        L_0x01ce:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r11)
            java.lang.String r3 = r10.mPositiveCross
            r1.append(r3)
            r1.append(r5)
            java.lang.Class r3 = r12.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r1.append(r3)
            r1.append(r4)
            java.lang.String r3 = androidx.constraintlayout.motion.widget.Debug.getName(r12)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r6, r1)
        L_0x01fa:
            if (r0 == 0) goto L_0x026f
            java.lang.String r0 = r10.mCross
            if (r0 == 0) goto L_0x026f
            java.lang.reflect.Method r0 = r10.mFireCross
            if (r0 != 0) goto L_0x023d
            java.lang.Class r0 = r12.getClass()     // Catch:{ NoSuchMethodException -> 0x0211 }
            java.lang.String r1 = r10.mCross     // Catch:{ NoSuchMethodException -> 0x0211 }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r7)     // Catch:{ NoSuchMethodException -> 0x0211 }
            r10.mFireCross = r0     // Catch:{ NoSuchMethodException -> 0x0211 }
            goto L_0x023d
        L_0x0211:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r1 = r10.mCross
            r0.append(r1)
            r0.append(r5)
            java.lang.Class r1 = r12.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = androidx.constraintlayout.motion.widget.Debug.getName(r12)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r6, r0)
        L_0x023d:
            java.lang.reflect.Method r0 = r10.mFireCross     // Catch:{ Exception -> 0x0243 }
            r0.invoke(r12, r7)     // Catch:{ Exception -> 0x0243 }
            goto L_0x026f
        L_0x0243:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            java.lang.String r11 = r10.mCross
            r0.append(r11)
            r0.append(r5)
            java.lang.Class r11 = r12.getClass()
            java.lang.String r11 = r11.getSimpleName()
            r0.append(r11)
            r0.append(r4)
            java.lang.String r11 = androidx.constraintlayout.motion.widget.Debug.getName(r12)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            android.util.Log.e(r6, r11)
        L_0x026f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTrigger.conditionallyFire(float, android.view.View):void");
    }

    public void getAttributeNames(HashSet<String> hashSet) {
    }

    /* access modifiers changed from: package-private */
    public int getCurveFit() {
        return this.mCurveFit;
    }

    public void load(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTrigger), context);
    }

    public void setValue(String str, Object obj) {
    }
}
