package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.Arrays;
import java.util.LinkedHashMap;

class c implements Comparable {
    static String[] N0 = {"position", "x", "y", Snapshot.WIDTH, Snapshot.HEIGHT, "pathRotate"};
    LinkedHashMap C = new LinkedHashMap();
    int X = 0;
    double[] Y = new double[18];
    double[] Z = new double[18];

    /* renamed from: a  reason: collision with root package name */
    Easing f14643a;

    /* renamed from: b  reason: collision with root package name */
    int f14644b = 0;

    /* renamed from: c  reason: collision with root package name */
    float f14645c;

    /* renamed from: d  reason: collision with root package name */
    float f14646d;

    /* renamed from: e  reason: collision with root package name */
    float f14647e;

    /* renamed from: f  reason: collision with root package name */
    float f14648f;

    /* renamed from: g  reason: collision with root package name */
    float f14649g;

    /* renamed from: h  reason: collision with root package name */
    float f14650h;

    /* renamed from: i  reason: collision with root package name */
    float f14651i = Float.NaN;

    /* renamed from: j  reason: collision with root package name */
    float f14652j = Float.NaN;

    /* renamed from: w  reason: collision with root package name */
    int f14653w = Key.UNSET;

    public c() {
    }

    private boolean c(float f10, float f11) {
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

    public void a(ConstraintSet.Constraint constraint) {
        this.f14643a = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.f14653w = motion.mPathMotionArc;
        this.f14651i = motion.mPathRotate;
        this.f14644b = motion.mDrawPath;
        this.f14652j = constraint.propertySet.mProgress;
        for (String next : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(next);
            if (constraintAttribute.getType() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.C.put(next, constraintAttribute);
            }
        }
    }

    /* renamed from: b */
    public int compareTo(c cVar) {
        return Float.compare(this.f14646d, cVar.f14646d);
    }

    /* access modifiers changed from: package-private */
    public void d(c cVar, boolean[] zArr, String[] strArr, boolean z10) {
        zArr[0] = zArr[0] | c(this.f14646d, cVar.f14646d);
        zArr[1] = zArr[1] | c(this.f14647e, cVar.f14647e) | z10;
        zArr[2] = z10 | c(this.f14648f, cVar.f14648f) | zArr[2];
        zArr[3] = zArr[3] | c(this.f14649g, cVar.f14649g);
        zArr[4] = c(this.f14650h, cVar.f14650h) | zArr[4];
    }

    /* access modifiers changed from: package-private */
    public void e(double[] dArr, int[] iArr) {
        float[] fArr = {this.f14646d, this.f14647e, this.f14648f, this.f14649g, this.f14650h, this.f14651i};
        int i10 = 0;
        for (int i11 : iArr) {
            if (i11 < 6) {
                dArr[i10] = (double) fArr[i11];
                i10++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f14649g;
        float f11 = this.f14650h;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f12 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 3) {
                f10 = f12;
            } else if (i12 == 4) {
                f11 = f12;
            }
        }
        fArr[i10] = f10;
        fArr[i10 + 1] = f11;
    }

    /* access modifiers changed from: package-private */
    public void g(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f14647e;
        float f11 = this.f14648f;
        float f12 = this.f14649g;
        float f13 = this.f14650h;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f14 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f10 = f14;
            } else if (i12 == 2) {
                f11 = f14;
            } else if (i12 == 3) {
                f12 = f14;
            } else if (i12 == 4) {
                f13 = f14;
            }
        }
        fArr[i10] = f10 + (f12 / 2.0f) + 0.0f;
        fArr[i10 + 1] = f11 + (f13 / 2.0f) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int h(String str, double[] dArr, int i10) {
        ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.C.get(str);
        if (constraintAttribute.noOfInterpValues() == 1) {
            dArr[i10] = (double) constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int noOfInterpValues = constraintAttribute.noOfInterpValues();
        float[] fArr = new float[noOfInterpValues];
        constraintAttribute.getValuesToInterpolate(fArr);
        int i11 = 0;
        while (i11 < noOfInterpValues) {
            dArr[i10] = (double) fArr[i11];
            i11++;
            i10++;
        }
        return noOfInterpValues;
    }

    /* access modifiers changed from: package-private */
    public int i(String str) {
        return ((ConstraintAttribute) this.C.get(str)).noOfInterpValues();
    }

    /* access modifiers changed from: package-private */
    public void j(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f14647e;
        float f11 = this.f14648f;
        float f12 = this.f14649g;
        float f13 = this.f14650h;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f14 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f10 = f14;
            } else if (i12 == 2) {
                f11 = f14;
            } else if (i12 == 3) {
                f12 = f14;
            } else if (i12 == 4) {
                f13 = f14;
            }
        }
        float f15 = f12 + f10;
        float f16 = f13 + f11;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i10] = f10 + 0.0f;
        fArr[i10 + 1] = f11 + 0.0f;
        fArr[i10 + 2] = f15 + 0.0f;
        fArr[i10 + 3] = f11 + 0.0f;
        fArr[i10 + 4] = f15 + 0.0f;
        int i13 = i10 + 6;
        fArr[i10 + 5] = f16 + 0.0f;
        fArr[i13] = f10 + 0.0f;
        fArr[i10 + 7] = f16 + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public boolean k(String str) {
        return this.C.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public void l(KeyPosition keyPosition, c cVar, c cVar2) {
        float f10;
        float f11;
        float f12;
        float f13;
        KeyPosition keyPosition2 = keyPosition;
        c cVar3 = cVar;
        c cVar4 = cVar2;
        float f14 = ((float) keyPosition2.mFramePosition) / 100.0f;
        this.f14645c = f14;
        this.f14644b = keyPosition2.mDrawPath;
        if (Float.isNaN(keyPosition2.mPercentWidth)) {
            f10 = f14;
        } else {
            f10 = keyPosition2.mPercentWidth;
        }
        if (Float.isNaN(keyPosition2.mPercentHeight)) {
            f11 = f14;
        } else {
            f11 = keyPosition2.mPercentHeight;
        }
        float f15 = cVar4.f14649g;
        float f16 = cVar3.f14649g;
        float f17 = cVar4.f14650h;
        float f18 = cVar3.f14650h;
        this.f14646d = this.f14645c;
        float f19 = cVar3.f14647e;
        float f20 = cVar3.f14648f;
        float f21 = (cVar4.f14647e + (f15 / 2.0f)) - ((f16 / 2.0f) + f19);
        float f22 = (cVar4.f14648f + (f17 / 2.0f)) - (f20 + (f18 / 2.0f));
        float f23 = (f15 - f16) * f10;
        float f24 = f23 / 2.0f;
        this.f14647e = (float) ((int) ((f19 + (f21 * f14)) - f24));
        float f25 = (f17 - f18) * f11;
        float f26 = f25 / 2.0f;
        this.f14648f = (float) ((int) ((f20 + (f22 * f14)) - f26));
        this.f14649g = (float) ((int) (f16 + f23));
        this.f14650h = (float) ((int) (f18 + f25));
        KeyPosition keyPosition3 = keyPosition;
        if (Float.isNaN(keyPosition3.mPercentX)) {
            f12 = f14;
        } else {
            f12 = keyPosition3.mPercentX;
        }
        float f27 = 0.0f;
        if (Float.isNaN(keyPosition3.mAltPercentY)) {
            f13 = 0.0f;
        } else {
            f13 = keyPosition3.mAltPercentY;
        }
        if (!Float.isNaN(keyPosition3.mPercentY)) {
            f14 = keyPosition3.mPercentY;
        }
        if (!Float.isNaN(keyPosition3.mAltPercentX)) {
            f27 = keyPosition3.mAltPercentX;
        }
        this.X = 2;
        c cVar5 = cVar;
        this.f14647e = (float) ((int) (((cVar5.f14647e + (f12 * f21)) + (f27 * f22)) - f24));
        this.f14648f = (float) ((int) (((cVar5.f14648f + (f21 * f13)) + (f22 * f14)) - f26));
        this.f14643a = Easing.getInterpolator(keyPosition3.mTransitionEasing);
        this.f14653w = keyPosition3.mPathMotionArc;
    }

    /* access modifiers changed from: package-private */
    public void m(KeyPosition keyPosition, c cVar, c cVar2) {
        float f10;
        float f11;
        float f12;
        KeyPosition keyPosition2 = keyPosition;
        c cVar3 = cVar;
        c cVar4 = cVar2;
        float f13 = ((float) keyPosition2.mFramePosition) / 100.0f;
        this.f14645c = f13;
        this.f14644b = keyPosition2.mDrawPath;
        if (Float.isNaN(keyPosition2.mPercentWidth)) {
            f10 = f13;
        } else {
            f10 = keyPosition2.mPercentWidth;
        }
        if (Float.isNaN(keyPosition2.mPercentHeight)) {
            f11 = f13;
        } else {
            f11 = keyPosition2.mPercentHeight;
        }
        float f14 = cVar4.f14649g - cVar3.f14649g;
        float f15 = cVar4.f14650h - cVar3.f14650h;
        this.f14646d = this.f14645c;
        if (!Float.isNaN(keyPosition2.mPercentX)) {
            f13 = keyPosition2.mPercentX;
        }
        float f16 = cVar3.f14647e;
        float f17 = cVar3.f14649g;
        float f18 = cVar3.f14648f;
        float f19 = cVar3.f14650h;
        float f20 = cVar4.f14647e + (cVar4.f14649g / 2.0f);
        float f21 = f20 - ((f17 / 2.0f) + f16);
        float f22 = (cVar4.f14648f + (cVar4.f14650h / 2.0f)) - ((f19 / 2.0f) + f18);
        float f23 = f21 * f13;
        float f24 = f14 * f10;
        float f25 = f24 / 2.0f;
        this.f14647e = (float) ((int) ((f16 + f23) - f25));
        float f26 = f13 * f22;
        float f27 = f15 * f11;
        float f28 = f27 / 2.0f;
        this.f14648f = (float) ((int) ((f18 + f26) - f28));
        this.f14649g = (float) ((int) (f17 + f24));
        this.f14650h = (float) ((int) (f19 + f27));
        KeyPosition keyPosition3 = keyPosition;
        if (Float.isNaN(keyPosition3.mPercentY)) {
            f12 = 0.0f;
        } else {
            f12 = keyPosition3.mPercentY;
        }
        float f29 = (-f22) * f12;
        float f30 = f21 * f12;
        this.X = 1;
        c cVar5 = cVar;
        this.f14647e = ((float) ((int) ((cVar5.f14647e + f23) - f25))) + f29;
        this.f14648f = ((float) ((int) ((cVar5.f14648f + f26) - f28))) + f30;
        this.f14643a = Easing.getInterpolator(keyPosition3.mTransitionEasing);
        this.f14653w = keyPosition3.mPathMotionArc;
    }

    /* access modifiers changed from: package-private */
    public void n(int i10, int i11, KeyPosition keyPosition, c cVar, c cVar2) {
        float f10;
        float f11;
        KeyPosition keyPosition2 = keyPosition;
        c cVar3 = cVar;
        c cVar4 = cVar2;
        float f12 = ((float) keyPosition2.mFramePosition) / 100.0f;
        this.f14645c = f12;
        this.f14644b = keyPosition2.mDrawPath;
        if (Float.isNaN(keyPosition2.mPercentWidth)) {
            f10 = f12;
        } else {
            f10 = keyPosition2.mPercentWidth;
        }
        if (Float.isNaN(keyPosition2.mPercentHeight)) {
            f11 = f12;
        } else {
            f11 = keyPosition2.mPercentHeight;
        }
        float f13 = cVar4.f14649g;
        float f14 = cVar3.f14649g;
        float f15 = cVar4.f14650h;
        float f16 = cVar3.f14650h;
        this.f14646d = this.f14645c;
        float f17 = cVar3.f14647e;
        float f18 = cVar3.f14648f;
        float f19 = cVar4.f14647e + (f13 / 2.0f);
        float f20 = cVar4.f14648f + (f15 / 2.0f);
        float f21 = (f13 - f14) * f10;
        this.f14647e = (float) ((int) ((f17 + ((f19 - ((f14 / 2.0f) + f17)) * f12)) - (f21 / 2.0f)));
        float f22 = (f15 - f16) * f11;
        this.f14648f = (float) ((int) ((f18 + ((f20 - (f18 + (f16 / 2.0f))) * f12)) - (f22 / 2.0f)));
        this.f14649g = (float) ((int) (f14 + f21));
        this.f14650h = (float) ((int) (f16 + f22));
        this.X = 3;
        KeyPosition keyPosition3 = keyPosition;
        if (!Float.isNaN(keyPosition3.mPercentX)) {
            this.f14647e = (float) ((int) (keyPosition3.mPercentX * ((float) ((int) (((float) i10) - this.f14649g)))));
        }
        if (!Float.isNaN(keyPosition3.mPercentY)) {
            this.f14648f = (float) ((int) (keyPosition3.mPercentY * ((float) ((int) (((float) i11) - this.f14650h)))));
        }
        this.f14643a = Easing.getInterpolator(keyPosition3.mTransitionEasing);
        this.f14653w = keyPosition3.mPathMotionArc;
    }

    /* access modifiers changed from: package-private */
    public void o(float f10, float f11, float f12, float f13) {
        this.f14647e = f10;
        this.f14648f = f11;
        this.f14649g = f12;
        this.f14650h = f13;
    }

    /* access modifiers changed from: package-private */
    public void p(float f10, float f11, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        int[] iArr2 = iArr;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        for (int i10 = 0; i10 < iArr2.length; i10++) {
            float f16 = (float) dArr[i10];
            double d10 = dArr2[i10];
            int i11 = iArr2[i10];
            if (i11 == 1) {
                f12 = f16;
            } else if (i11 == 2) {
                f14 = f16;
            } else if (i11 == 3) {
                f13 = f16;
            } else if (i11 == 4) {
                f15 = f16;
            }
        }
        float f17 = f12 - ((0.0f * f13) / 2.0f);
        float f18 = f14 - ((0.0f * f15) / 2.0f);
        fArr[0] = (f17 * (1.0f - f10)) + (((f13 * 1.0f) + f17) * f10) + 0.0f;
        fArr[1] = (f18 * (1.0f - f11)) + (((f15 * 1.0f) + f18) * f11) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void q(View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        boolean z10;
        float f10;
        View view2 = view;
        int[] iArr2 = iArr;
        float f11 = this.f14647e;
        float f12 = this.f14648f;
        float f13 = this.f14649g;
        float f14 = this.f14650h;
        boolean z11 = true;
        if (iArr2.length != 0 && this.Y.length <= iArr2[iArr2.length - 1]) {
            int i10 = iArr2[iArr2.length - 1] + 1;
            this.Y = new double[i10];
            this.Z = new double[i10];
        }
        Arrays.fill(this.Y, Double.NaN);
        int i11 = 0;
        for (int i12 = 0; i12 < iArr2.length; i12++) {
            double[] dArr4 = this.Y;
            int i13 = iArr2[i12];
            dArr4[i13] = dArr[i12];
            this.Z[i13] = dArr2[i12];
        }
        float f15 = Float.NaN;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        while (true) {
            double[] dArr5 = this.Y;
            if (i11 >= dArr5.length) {
                break;
            }
            boolean isNaN = Double.isNaN(dArr5[i11]);
            double d10 = 0.0d;
            if (!isNaN || !(dArr3 == null || dArr3[i11] == 0.0d)) {
                if (dArr3 != null) {
                    d10 = dArr3[i11];
                }
                if (!Double.isNaN(this.Y[i11])) {
                    d10 = this.Y[i11] + d10;
                }
                f10 = f15;
                float f20 = (float) d10;
                float f21 = (float) this.Z[i11];
                z10 = true;
                if (i11 == 1) {
                    f15 = f10;
                    f11 = f20;
                    f16 = f21;
                } else if (i11 == 2) {
                    f15 = f10;
                    f12 = f20;
                    f18 = f21;
                } else if (i11 == 3) {
                    f15 = f10;
                    f13 = f20;
                    f17 = f21;
                } else if (i11 == 4) {
                    f15 = f10;
                    f14 = f20;
                    f19 = f21;
                } else if (i11 == 5) {
                    f15 = f20;
                }
                i11++;
                z11 = z10;
            } else {
                z10 = z11;
                f10 = f15;
            }
            f15 = f10;
            i11++;
            z11 = z10;
        }
        float f22 = f15;
        if (!Float.isNaN(f22)) {
            float f23 = Float.NaN;
            if (Float.isNaN(Float.NaN)) {
                f23 = 0.0f;
            }
            view2.setRotation((float) (((double) f23) + ((double) f22) + Math.toDegrees(Math.atan2((double) (f18 + (f19 / 2.0f)), (double) (f16 + (f17 / 2.0f))))));
        } else if (!Float.isNaN(Float.NaN)) {
            view2.setRotation(Float.NaN);
        }
        float f24 = f11 + 0.5f;
        int i14 = (int) f24;
        float f25 = f12 + 0.5f;
        int i15 = (int) f25;
        int i16 = (int) (f24 + f13);
        int i17 = (int) (f25 + f14);
        int i18 = i16 - i14;
        int i19 = i17 - i15;
        if (!(i18 == view.getMeasuredWidth() && i19 == view.getMeasuredHeight())) {
            view2.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i19, 1073741824));
        }
        view2.layout(i14, i15, i16, i17);
    }

    public c(int i10, int i11, KeyPosition keyPosition, c cVar, c cVar2) {
        int i12 = keyPosition.mPositionType;
        if (i12 == 1) {
            m(keyPosition, cVar, cVar2);
        } else if (i12 != 2) {
            l(keyPosition, cVar, cVar2);
        } else {
            n(i10, i11, keyPosition, cVar, cVar2);
        }
    }
}
