package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.HashMap;

public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private boolean mAllowsGoneWidget = true;
    private int mBarrierType = 0;
    private int mMargin = 0;

    public void addToSolver(LinearSystem linearSystem) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        ConstraintAnchor[] constraintAnchorArr2 = this.mListAnchors;
        constraintAnchorArr2[0] = this.mLeft;
        constraintAnchorArr2[2] = this.mTop;
        constraintAnchorArr2[1] = this.mRight;
        constraintAnchorArr2[3] = this.mBottom;
        int i15 = 0;
        while (true) {
            constraintAnchorArr = this.mListAnchors;
            if (i15 >= constraintAnchorArr.length) {
                break;
            }
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i15];
            constraintAnchor.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor);
            i15++;
        }
        int i16 = this.mBarrierType;
        if (i16 >= 0 && i16 < 4) {
            ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i16];
            int i17 = 0;
            while (true) {
                if (i17 >= this.mWidgetsCount) {
                    z10 = false;
                    break;
                }
                ConstraintWidget constraintWidget = this.mWidgets[i17];
                if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i13 = this.mBarrierType) == 0 || i13 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i14 = this.mBarrierType) == 2 || i14 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                    z10 = true;
                } else {
                    i17++;
                }
            }
            z10 = true;
            if (this.mLeft.hasCenteredDependents() || this.mRight.hasCenteredDependents()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (this.mTop.hasCenteredDependents() || this.mBottom.hasCenteredDependents()) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z10 || (((i12 = this.mBarrierType) != 0 || !z11) && ((i12 != 2 || !z12) && ((i12 != 1 || !z11) && (i12 != 3 || !z12))))) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (!z13) {
                i10 = 4;
            } else {
                i10 = 5;
            }
            for (int i18 = 0; i18 < this.mWidgetsCount; i18++) {
                ConstraintWidget constraintWidget2 = this.mWidgets[i18];
                if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                    SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.mListAnchors;
                    int i19 = this.mBarrierType;
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr3[i19];
                    constraintAnchor3.mSolverVariable = createObjectVariable;
                    ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
                    if (constraintAnchor4 == null || constraintAnchor4.mOwner != this) {
                        i11 = 0;
                    } else {
                        i11 = constraintAnchor3.mMargin;
                    }
                    if (i19 == 0 || i19 == 2) {
                        linearSystem.addLowerBarrier(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin - i11, z10);
                    } else {
                        linearSystem.addGreaterBarrier(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin + i11, z10);
                    }
                    linearSystem.addEquality(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin + i11, i10);
                }
            }
            int i20 = this.mBarrierType;
            if (i20 == 0) {
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
            } else if (i20 == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
            } else if (i20 == 2) {
                linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
            } else if (i20 == 3) {
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
            }
        }
    }

    public boolean allowedInBarrier() {
        return true;
    }

    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Barrier barrier = (Barrier) constraintWidget;
        this.mBarrierType = barrier.mBarrierType;
        this.mAllowsGoneWidget = barrier.mAllowsGoneWidget;
        this.mMargin = barrier.mMargin;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    /* access modifiers changed from: protected */
    public void markWidgets() {
        for (int i10 = 0; i10 < this.mWidgetsCount; i10++) {
            ConstraintWidget constraintWidget = this.mWidgets[i10];
            int i11 = this.mBarrierType;
            if (i11 == 0 || i11 == 1) {
                constraintWidget.setInBarrier(0, true);
            } else if (i11 == 2 || i11 == 3) {
                constraintWidget.setInBarrier(1, true);
            }
        }
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.mAllowsGoneWidget = z10;
    }

    public void setBarrierType(int i10) {
        this.mBarrierType = i10;
    }

    public void setMargin(int i10) {
        this.mMargin = i10;
    }

    public String toString() {
        String str = "[Barrier] " + getDebugName() + " {";
        for (int i10 = 0; i10 < this.mWidgetsCount; i10++) {
            ConstraintWidget constraintWidget = this.mWidgets[i10];
            if (i10 > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.getDebugName();
        }
        return str + "}";
    }
}
