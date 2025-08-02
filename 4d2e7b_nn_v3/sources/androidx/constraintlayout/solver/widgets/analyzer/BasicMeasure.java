package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;

public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private Measure mMeasure = new Measure();
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();

    public static class Measure {
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public boolean useCurrentDimensions;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    public enum MeasureType {
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer2) {
        this.constraintWidgetContainer = constraintWidgetContainer2;
    }

    private boolean measure(Measurer measurer, ConstraintWidget constraintWidget, boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        Measure measure = this.mMeasure;
        measure.measuredNeedsSolverPass = false;
        measure.useCurrentDimensions = z10;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (measure.verticalBehavior == dimensionBehaviour2) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z11 || constraintWidget.mDimensionRatio <= 0.0f) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (!z12 || constraintWidget.mDimensionRatio <= 0.0f) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (z13 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z14 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        Measure measure2 = this.mMeasure;
        measure2.useCurrentDimensions = false;
        return measure2.measuredNeedsSolverPass;
    }

    private void measureChildren(ConstraintWidgetContainer constraintWidgetContainer2) {
        int size = constraintWidgetContainer2.mChildren.size();
        Measurer measurer = constraintWidgetContainer2.getMeasurer();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer2.mChildren.get(i10);
            if (!(constraintWidget instanceof Guideline) && (!constraintWidget.horizontalRun.dimension.resolved || !constraintWidget.verticalRun.dimension.resolved)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getDimensionBehaviour(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour != dimensionBehaviour3 || constraintWidget.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != dimensionBehaviour3 || constraintWidget.mMatchConstraintDefaultHeight == 1) {
                    measure(measurer, constraintWidget, false);
                    Metrics metrics = constraintWidgetContainer2.mMetrics;
                    if (metrics != null) {
                        metrics.measuredWidgets++;
                    }
                }
            }
        }
        measurer.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer2, String str, int i10, int i11) {
        int minWidth = constraintWidgetContainer2.getMinWidth();
        int minHeight = constraintWidgetContainer2.getMinHeight();
        constraintWidgetContainer2.setMinWidth(0);
        constraintWidgetContainer2.setMinHeight(0);
        constraintWidgetContainer2.setWidth(i10);
        constraintWidgetContainer2.setHeight(i11);
        constraintWidgetContainer2.setMinWidth(minWidth);
        constraintWidgetContainer2.setMinHeight(minHeight);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        int i19;
        boolean z10;
        int i20;
        ConstraintWidgetContainer constraintWidgetContainer3;
        boolean z11;
        boolean z12;
        int i21;
        int i22;
        ConstraintWidgetContainer constraintWidgetContainer4;
        BasicMeasure basicMeasure;
        int i23;
        int i24;
        int i25;
        boolean z13;
        int i26;
        Metrics metrics;
        BasicMeasure basicMeasure2 = this;
        ConstraintWidgetContainer constraintWidgetContainer5 = constraintWidgetContainer2;
        int i27 = i10;
        int i28 = i13;
        int i29 = i15;
        Measurer measurer = constraintWidgetContainer2.getMeasurer();
        int size = constraintWidgetContainer5.mChildren.size();
        int width = constraintWidgetContainer2.getWidth();
        int height = constraintWidgetContainer2.getHeight();
        boolean enabled = Optimizer.enabled(i27, 128);
        boolean z14 = enabled || Optimizer.enabled(i27, 64);
        if (z14) {
            int i30 = 0;
            while (true) {
                if (i30 >= size) {
                    break;
                }
                ConstraintWidget constraintWidget = constraintWidgetContainer5.mChildren.get(i30);
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z15 = (horizontalDimensionBehaviour == dimensionBehaviour) && (constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) && constraintWidget.getDimensionRatio() > 0.0f;
                if ((!constraintWidget.isInHorizontalChain() || !z15) && ((!constraintWidget.isInVerticalChain() || !z15) && !(constraintWidget instanceof VirtualLayout) && !constraintWidget.isInHorizontalChain() && !constraintWidget.isInVerticalChain())) {
                    i30++;
                }
            }
            z14 = false;
        }
        if (z14 && (metrics = LinearSystem.sMetrics) != null) {
            metrics.measures++;
        }
        int i31 = 2;
        if (z14 && ((i28 == 1073741824 && i29 == 1073741824) || enabled)) {
            int min = Math.min(constraintWidgetContainer2.getMaxWidth(), i14);
            int min2 = Math.min(constraintWidgetContainer2.getMaxHeight(), i16);
            if (i28 == 1073741824 && constraintWidgetContainer2.getWidth() != min) {
                constraintWidgetContainer5.setWidth(min);
                constraintWidgetContainer2.invalidateGraph();
            }
            if (i29 == 1073741824 && constraintWidgetContainer2.getHeight() != min2) {
                constraintWidgetContainer5.setHeight(min2);
                constraintWidgetContainer2.invalidateGraph();
            }
            if (i28 == 1073741824 && i29 == 1073741824) {
                z10 = constraintWidgetContainer5.directMeasure(enabled);
                i19 = 2;
            } else {
                boolean directMeasureSetup = constraintWidgetContainer5.directMeasureSetup(enabled);
                if (i28 == 1073741824) {
                    z13 = directMeasureSetup & constraintWidgetContainer5.directMeasureWithOrientation(enabled, 0);
                    i26 = 1;
                } else {
                    z13 = directMeasureSetup;
                    i26 = 0;
                }
                if (i29 == 1073741824) {
                    boolean directMeasureWithOrientation = constraintWidgetContainer5.directMeasureWithOrientation(enabled, 1) & z13;
                    i19 = i26 + 1;
                    z10 = directMeasureWithOrientation;
                } else {
                    i19 = i26;
                    z10 = z13;
                }
            }
            if (z10) {
                constraintWidgetContainer5.updateFromRuns(i28 == 1073741824, i29 == 1073741824);
            }
        } else {
            z10 = false;
            i19 = 0;
        }
        if (!z10 || i19 != 2) {
            if (size > 0) {
                measureChildren(constraintWidgetContainer2);
            }
            int optimizationLevel = constraintWidgetContainer2.getOptimizationLevel();
            int size2 = basicMeasure2.mVariableDimensionsWidgets.size();
            if (size > 0) {
                basicMeasure2.solveLinearSystem(constraintWidgetContainer5, "First pass", width, height);
            }
            if (size2 > 0) {
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidgetContainer2.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z16 = horizontalDimensionBehaviour2 == dimensionBehaviour2;
                boolean z17 = constraintWidgetContainer2.getVerticalDimensionBehaviour() == dimensionBehaviour2;
                int max = Math.max(constraintWidgetContainer2.getWidth(), basicMeasure2.constraintWidgetContainer.getMinWidth());
                int max2 = Math.max(constraintWidgetContainer2.getHeight(), basicMeasure2.constraintWidgetContainer.getMinHeight());
                int i32 = 0;
                boolean z18 = false;
                while (i32 < size2) {
                    ConstraintWidget constraintWidget2 = basicMeasure2.mVariableDimensionsWidgets.get(i32);
                    if (!(constraintWidget2 instanceof VirtualLayout)) {
                        i23 = optimizationLevel;
                        i25 = width;
                        i24 = height;
                    } else {
                        int width2 = constraintWidget2.getWidth();
                        int height2 = constraintWidget2.getHeight();
                        i23 = optimizationLevel;
                        boolean measure = z18 | basicMeasure2.measure(measurer, constraintWidget2, true);
                        Metrics metrics2 = constraintWidgetContainer5.mMetrics;
                        i25 = width;
                        i24 = height;
                        if (metrics2 != null) {
                            metrics2.measuredMatchWidgets++;
                        }
                        int width3 = constraintWidget2.getWidth();
                        int height3 = constraintWidget2.getHeight();
                        if (width3 != width2) {
                            constraintWidget2.setWidth(width3);
                            if (z16 && constraintWidget2.getRight() > max) {
                                max = Math.max(max, constraintWidget2.getRight() + constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                            }
                            measure = true;
                        }
                        if (height3 != height2) {
                            constraintWidget2.setHeight(height3);
                            if (z17 && constraintWidget2.getBottom() > max2) {
                                max2 = Math.max(max2, constraintWidget2.getBottom() + constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                            }
                            measure = true;
                        }
                        z18 = measure | ((VirtualLayout) constraintWidget2).needSolverPass();
                    }
                    i32++;
                    optimizationLevel = i23;
                    width = i25;
                    height = i24;
                    i31 = 2;
                }
                i20 = optimizationLevel;
                int i33 = width;
                int i34 = height;
                int i35 = 0;
                for (int i36 = i31; i35 < i36; i36 = 2) {
                    int i37 = 0;
                    while (i37 < size2) {
                        ConstraintWidget constraintWidget3 = basicMeasure2.mVariableDimensionsWidgets.get(i37);
                        if ((!(constraintWidget3 instanceof Helper) || (constraintWidget3 instanceof VirtualLayout)) && !(constraintWidget3 instanceof Guideline) && constraintWidget3.getVisibility() != 8 && ((!constraintWidget3.horizontalRun.dimension.resolved || !constraintWidget3.verticalRun.dimension.resolved) && !(constraintWidget3 instanceof VirtualLayout))) {
                            int width4 = constraintWidget3.getWidth();
                            int height4 = constraintWidget3.getHeight();
                            int baselineDistance = constraintWidget3.getBaselineDistance();
                            z18 |= basicMeasure2.measure(measurer, constraintWidget3, true);
                            Metrics metrics3 = constraintWidgetContainer5.mMetrics;
                            if (metrics3 != null) {
                                metrics3.measuredMatchWidgets++;
                            }
                            int width5 = constraintWidget3.getWidth();
                            int height5 = constraintWidget3.getHeight();
                            if (width5 != width4) {
                                constraintWidget3.setWidth(width5);
                                if (z16 && constraintWidget3.getRight() > max) {
                                    max = Math.max(max, constraintWidget3.getRight() + constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                                }
                                z18 = true;
                            }
                            if (height5 != height4) {
                                constraintWidget3.setHeight(height5);
                                if (z17 && constraintWidget3.getBottom() > max2) {
                                    max2 = Math.max(max2, constraintWidget3.getBottom() + constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                                }
                                z18 = true;
                            }
                            if (constraintWidget3.hasBaseline() && baselineDistance != constraintWidget3.getBaselineDistance()) {
                                z18 = true;
                            }
                        }
                        i37++;
                        basicMeasure2 = this;
                        constraintWidgetContainer5 = constraintWidgetContainer2;
                    }
                    if (z18) {
                        basicMeasure = this;
                        constraintWidgetContainer4 = constraintWidgetContainer2;
                        i22 = i33;
                        i21 = i34;
                        basicMeasure.solveLinearSystem(constraintWidgetContainer4, "intermediate pass", i22, i21);
                        z18 = false;
                    } else {
                        basicMeasure = this;
                        constraintWidgetContainer4 = constraintWidgetContainer2;
                        i22 = i33;
                        i21 = i34;
                    }
                    i35++;
                    basicMeasure2 = basicMeasure;
                    constraintWidgetContainer5 = constraintWidgetContainer4;
                    i33 = i22;
                    i34 = i21;
                }
                constraintWidgetContainer3 = constraintWidgetContainer5;
                int i38 = i33;
                int i39 = i34;
                BasicMeasure basicMeasure3 = basicMeasure2;
                if (z18) {
                    basicMeasure3.solveLinearSystem(constraintWidgetContainer3, "2nd pass", i38, i39);
                    if (constraintWidgetContainer2.getWidth() < max) {
                        constraintWidgetContainer3.setWidth(max);
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (constraintWidgetContainer2.getHeight() < max2) {
                        constraintWidgetContainer3.setHeight(max2);
                        z12 = true;
                    } else {
                        z12 = z11;
                    }
                    if (z12) {
                        basicMeasure3.solveLinearSystem(constraintWidgetContainer3, "3rd pass", i38, i39);
                    }
                }
            } else {
                i20 = optimizationLevel;
                constraintWidgetContainer3 = constraintWidgetContainer5;
                BasicMeasure basicMeasure4 = basicMeasure2;
            }
            constraintWidgetContainer3.setOptimizationLevel(i20);
            return 0;
        }
        BasicMeasure basicMeasure5 = basicMeasure2;
        return 0;
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer2) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        this.mVariableDimensionsWidgets.clear();
        int size = constraintWidgetContainer2.mChildren.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer2.mChildren.get(i10);
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (horizontalDimensionBehaviour == dimensionBehaviour2 || constraintWidget.getHorizontalDimensionBehaviour() == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT) || constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour2 || constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) {
                this.mVariableDimensionsWidgets.add(constraintWidget);
            }
        }
        constraintWidgetContainer2.invalidateGraph();
    }
}
