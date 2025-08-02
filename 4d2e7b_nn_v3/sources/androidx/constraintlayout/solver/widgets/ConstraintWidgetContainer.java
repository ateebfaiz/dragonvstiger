package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph;
import java.util.ArrayList;
import java.util.Arrays;

public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    BasicMeasure mBasicMeasureSolver = new BasicMeasure(this);
    int mDebugSolverPassCount = 0;
    public DependencyGraph mDependencyGraph = new DependencyGraph(this);
    public boolean mGroupsWrapOptimized = false;
    private boolean mHeightMeasuredTooSmall = false;
    ChainHead[] mHorizontalChainsArray = new ChainHead[4];
    int mHorizontalChainsSize = 0;
    public boolean mHorizontalWrapOptimized = false;
    private boolean mIsRtl = false;
    protected BasicMeasure.Measurer mMeasurer = null;
    public Metrics mMetrics;
    private int mOptimizationLevel = Optimizer.OPTIMIZATION_STANDARD;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver = false;
    protected LinearSystem mSystem = new LinearSystem();
    ChainHead[] mVerticalChainsArray = new ChainHead[4];
    int mVerticalChainsSize = 0;
    public boolean mVerticalWrapOptimized = false;
    private boolean mWidthMeasuredTooSmall = false;
    public int mWrapFixedHeight = 0;
    public int mWrapFixedWidth = 0;

    public ConstraintWidgetContainer() {
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        int i10 = this.mHorizontalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
        if (i10 >= chainHeadArr.length) {
            this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        int i10 = this.mVerticalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mVerticalChainsArray;
        if (i10 >= chainHeadArr.length) {
            this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    /* access modifiers changed from: package-private */
    public void addChain(ConstraintWidget constraintWidget, int i10) {
        if (i10 == 0) {
            addHorizontalChain(constraintWidget);
        } else if (i10 == 1) {
            addVerticalChain(constraintWidget);
        }
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        addToSolver(linearSystem);
        int size = this.mChildren.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i10);
            constraintWidget.setInBarrier(0, false);
            constraintWidget.setInBarrier(1, false);
            if (constraintWidget instanceof Barrier) {
                z10 = true;
            }
        }
        if (z10) {
            for (int i11 = 0; i11 < size; i11++) {
                ConstraintWidget constraintWidget2 = this.mChildren.get(i11);
                if (constraintWidget2 instanceof Barrier) {
                    ((Barrier) constraintWidget2).markWidgets();
                }
            }
        }
        for (int i12 = 0; i12 < size; i12++) {
            ConstraintWidget constraintWidget3 = this.mChildren.get(i12);
            if (constraintWidget3.addFirst()) {
                constraintWidget3.addToSolver(linearSystem);
            }
        }
        for (int i13 = 0; i13 < size; i13++) {
            ConstraintWidget constraintWidget4 = this.mChildren.get(i13);
            if (constraintWidget4 instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget4.mListDimensionBehaviors;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour == dimensionBehaviour3) {
                    constraintWidget4.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == dimensionBehaviour3) {
                    constraintWidget4.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget4.addToSolver(linearSystem);
                if (dimensionBehaviour == dimensionBehaviour3) {
                    constraintWidget4.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == dimensionBehaviour3) {
                    constraintWidget4.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            } else {
                Optimizer.checkMatchParent(this, linearSystem, constraintWidget4);
                if (!constraintWidget4.addFirst()) {
                    constraintWidget4.addToSolver(linearSystem);
                }
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            a.a(this, linearSystem, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            a.a(this, linearSystem, 1);
        }
        return true;
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
    }

    public boolean directMeasure(boolean z10) {
        return this.mDependencyGraph.directMeasure(z10);
    }

    public boolean directMeasureSetup(boolean z10) {
        return this.mDependencyGraph.directMeasureSetup(z10);
    }

    public boolean directMeasureWithOrientation(boolean z10, int i10) {
        return this.mDependencyGraph.directMeasureWithOrientation(z10, i10);
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mSystem.fillMetrics(metrics);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i10);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public BasicMeasure.Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i10);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    /* JADX WARNING: type inference failed for: r11v7, types: [boolean] */
    /* JADX WARNING: type inference failed for: r11v11 */
    /* JADX WARNING: type inference failed for: r11v12 */
    public void layout() {
        boolean z10;
        boolean z11;
        boolean z12;
        ? r11;
        boolean z13;
        this.mX = 0;
        this.mY = 0;
        int max = Math.max(0, getWidth());
        int max2 = Math.max(0, getHeight());
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        if (optimizeFor(64) || optimizeFor(128)) {
            z10 = true;
        } else {
            z10 = false;
        }
        LinearSystem linearSystem = this.mSystem;
        linearSystem.graphOptimizer = false;
        linearSystem.newgraphOptimizer = false;
        if (this.mOptimizationLevel != 0 && z10) {
            linearSystem.newgraphOptimizer = true;
        }
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
        ArrayList<ConstraintWidget> arrayList = this.mChildren;
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (horizontalDimensionBehaviour == dimensionBehaviour3 || getVerticalDimensionBehaviour() == dimensionBehaviour3) {
            z11 = true;
        } else {
            z11 = false;
        }
        resetChains();
        int size = this.mChildren.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i10);
            if (constraintWidget instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget).layout();
            }
        }
        int i11 = 0;
        boolean z14 = false;
        boolean z15 = true;
        while (z15) {
            int i12 = i11 + 1;
            try {
                this.mSystem.reset();
                resetChains();
                createObjectVariables(this.mSystem);
                for (int i13 = 0; i13 < size; i13++) {
                    this.mChildren.get(i13).createObjectVariables(this.mSystem);
                }
                z15 = addChildrenToSolver(this.mSystem);
                if (z15) {
                    this.mSystem.minimize();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                System.out.println("EXCEPTION : " + e10);
            }
            if (z15) {
                updateChildrenFromSolver(this.mSystem, Optimizer.flags);
            } else {
                updateFromSolver(this.mSystem);
                for (int i14 = 0; i14 < size; i14++) {
                    this.mChildren.get(i14).updateFromSolver(this.mSystem);
                }
            }
            if (!z11 || i12 >= 8 || !Optimizer.flags[2]) {
                z12 = false;
            } else {
                int i15 = 0;
                int i16 = 0;
                for (int i17 = 0; i17 < size; i17++) {
                    ConstraintWidget constraintWidget2 = this.mChildren.get(i17);
                    i15 = Math.max(i15, constraintWidget2.mX + constraintWidget2.getWidth());
                    i16 = Math.max(i16, constraintWidget2.mY + constraintWidget2.getHeight());
                }
                int max3 = Math.max(this.mMinWidth, i15);
                int max4 = Math.max(this.mMinHeight, i16);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour2 != dimensionBehaviour4 || getWidth() >= max3) {
                    z12 = false;
                } else {
                    setWidth(max3);
                    this.mListDimensionBehaviors[0] = dimensionBehaviour4;
                    z12 = true;
                    z14 = true;
                }
                if (dimensionBehaviour == dimensionBehaviour4 && getHeight() < max4) {
                    setHeight(max4);
                    this.mListDimensionBehaviors[1] = dimensionBehaviour4;
                    z12 = true;
                    z14 = true;
                }
            }
            int max5 = Math.max(this.mMinWidth, getWidth());
            if (max5 > getWidth()) {
                setWidth(max5);
                this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                z12 = true;
                z14 = true;
            }
            int max6 = Math.max(this.mMinHeight, getHeight());
            if (max6 > getHeight()) {
                setHeight(max6);
                r11 = 1;
                this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                z12 = true;
                z13 = true;
            } else {
                r11 = 1;
                z13 = z14;
            }
            if (!z13) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = this.mListDimensionBehaviors[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour5 == dimensionBehaviour6 && max > 0 && getWidth() > max) {
                    this.mWidthMeasuredTooSmall = r11;
                    this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                    setWidth(max);
                    z12 = r11;
                    z13 = z12;
                }
                if (this.mListDimensionBehaviors[r11] == dimensionBehaviour6 && max2 > 0 && getHeight() > max2) {
                    this.mHeightMeasuredTooSmall = r11;
                    this.mListDimensionBehaviors[r11] = ConstraintWidget.DimensionBehaviour.FIXED;
                    setHeight(max2);
                    z15 = true;
                    z14 = true;
                    i11 = i12;
                }
            }
            z15 = z12;
            z14 = z13;
            i11 = i12;
        }
        this.mChildren = arrayList;
        if (z14) {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
            dimensionBehaviourArr2[0] = dimensionBehaviour2;
            dimensionBehaviourArr2[1] = dimensionBehaviour;
        }
        resetSolverVariables(this.mSystem.getCache());
    }

    public long measure(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        int i19 = i17;
        this.mPaddingLeft = i19;
        int i20 = i18;
        this.mPaddingTop = i20;
        return this.mBasicMeasureSolver.solverMeasure(this, i10, i19, i20, i11, i12, i13, i14, i15, i16);
    }

    public boolean optimizeFor(int i10) {
        if ((this.mOptimizationLevel & i10) == i10) {
            return true;
        }
        return false;
    }

    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
        this.mDependencyGraph.setMeasurer(measurer);
    }

    public void setOptimizationLevel(int i10) {
        this.mOptimizationLevel = i10;
        LinearSystem.OPTIMIZED_ENGINE = Optimizer.enabled(i10, 256);
    }

    public void setPadding(int i10, int i11, int i12, int i13) {
        this.mPaddingLeft = i10;
        this.mPaddingTop = i11;
        this.mPaddingRight = i12;
        this.mPaddingBottom = i13;
    }

    public void setRtl(boolean z10) {
        this.mIsRtl = z10;
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        updateFromSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mChildren.get(i10).updateFromSolver(linearSystem);
        }
    }

    public void updateFromRuns(boolean z10, boolean z11) {
        super.updateFromRuns(z10, z11);
        int size = this.mChildren.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mChildren.get(i10).updateFromRuns(z10, z11);
        }
    }

    public void updateHierarchy() {
        this.mBasicMeasureSolver.updateHierarchy(this);
    }

    public ConstraintWidgetContainer(int i10, int i11, int i12, int i13) {
        super(i10, i11, i12, i13);
    }

    public ConstraintWidgetContainer(int i10, int i11) {
        super(i10, i11);
    }
}
