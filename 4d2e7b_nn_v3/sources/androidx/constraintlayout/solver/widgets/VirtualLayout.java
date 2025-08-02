package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

public class VirtualLayout extends HelperWidget {
    protected BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();
    private int mMeasuredHeight = 0;
    private int mMeasuredWidth = 0;
    BasicMeasure.Measurer mMeasurer = null;
    private boolean mNeedsCallFromSolver = false;
    private int mPaddingBottom = 0;
    private int mPaddingEnd = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingStart = 0;
    private int mPaddingTop = 0;
    private int mResolvedPaddingLeft = 0;
    private int mResolvedPaddingRight = 0;

    public void applyRtl(boolean z10) {
        int i10 = this.mPaddingStart;
        if (i10 <= 0 && this.mPaddingEnd <= 0) {
            return;
        }
        if (z10) {
            this.mResolvedPaddingLeft = this.mPaddingEnd;
            this.mResolvedPaddingRight = i10;
            return;
        }
        this.mResolvedPaddingLeft = i10;
        this.mResolvedPaddingRight = this.mPaddingEnd;
    }

    public void captureWidgets() {
        for (int i10 = 0; i10 < this.mWidgetsCount; i10++) {
            ConstraintWidget constraintWidget = this.mWidgets[i10];
            if (constraintWidget != null) {
                constraintWidget.setInVirtualLayout(true);
            }
        }
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mResolvedPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mResolvedPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public void measure(int i10, int i11, int i12, int i13) {
    }

    /* access modifiers changed from: protected */
    public boolean measureChildren() {
        BasicMeasure.Measurer measurer;
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null) {
            measurer = ((ConstraintWidgetContainer) constraintWidget).getMeasurer();
        } else {
            measurer = null;
        }
        if (measurer == null) {
            return false;
        }
        for (int i10 = 0; i10 < this.mWidgetsCount; i10++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i10];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof Guideline)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget2.getDimensionBehaviour(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour != dimensionBehaviour3 || constraintWidget2.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != dimensionBehaviour3 || constraintWidget2.mMatchConstraintDefaultHeight == 1) {
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    BasicMeasure.Measure measure = this.mMeasure;
                    measure.horizontalBehavior = dimensionBehaviour;
                    measure.verticalBehavior = dimensionBehaviour2;
                    measure.horizontalDimension = constraintWidget2.getWidth();
                    this.mMeasure.verticalDimension = constraintWidget2.getHeight();
                    measurer.measure(constraintWidget2, this.mMeasure);
                    constraintWidget2.setWidth(this.mMeasure.measuredWidth);
                    constraintWidget2.setHeight(this.mMeasure.measuredHeight);
                    constraintWidget2.setBaselineDistance(this.mMeasure.measuredBaseline);
                }
            }
        }
        return true;
    }

    public boolean needSolverPass() {
        return this.mNeedsCallFromSolver;
    }

    /* access modifiers changed from: protected */
    public void needsCallbackFromSolver(boolean z10) {
        this.mNeedsCallFromSolver = z10;
    }

    public void setMeasure(int i10, int i11) {
        this.mMeasuredWidth = i10;
        this.mMeasuredHeight = i11;
    }

    public void setPadding(int i10) {
        this.mPaddingLeft = i10;
        this.mPaddingTop = i10;
        this.mPaddingRight = i10;
        this.mPaddingBottom = i10;
        this.mPaddingStart = i10;
        this.mPaddingEnd = i10;
    }

    public void setPaddingBottom(int i10) {
        this.mPaddingBottom = i10;
    }

    public void setPaddingEnd(int i10) {
        this.mPaddingEnd = i10;
    }

    public void setPaddingLeft(int i10) {
        this.mPaddingLeft = i10;
        this.mResolvedPaddingLeft = i10;
    }

    public void setPaddingRight(int i10) {
        this.mPaddingRight = i10;
        this.mResolvedPaddingRight = i10;
    }

    public void setPaddingStart(int i10) {
        this.mPaddingStart = i10;
        this.mResolvedPaddingLeft = i10;
        this.mResolvedPaddingRight = i10;
    }

    public void setPaddingTop(int i10) {
        this.mPaddingTop = i10;
    }

    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
        captureWidgets();
    }

    /* access modifiers changed from: protected */
    public void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i10, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i11) {
        while (this.mMeasurer == null && getParent() != null) {
            this.mMeasurer = ((ConstraintWidgetContainer) getParent()).getMeasurer();
        }
        BasicMeasure.Measure measure = this.mMeasure;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i10;
        measure.verticalDimension = i11;
        this.mMeasurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }
}
