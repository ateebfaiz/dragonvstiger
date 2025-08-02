package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

public class VerticalWidgetRun extends WidgetRun {
    public DependencyNode baseline;
    b baselineDimension = null;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14729a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$b[] r0 = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14729a = r0
                androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$b r1 = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.b.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14729a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$b r1 = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.b.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14729a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$b r1 = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.b.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun.a.<clinit>():void");
        }
    }

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.baseline = dependencyNode;
        this.start.type = DependencyNode.a.TOP;
        this.end.type = DependencyNode.a.BOTTOM;
        dependencyNode.type = DependencyNode.a.BASELINE;
        this.orientation = 1;
    }

    /* access modifiers changed from: package-private */
    public void apply() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget.measured) {
            this.dimension.resolve(constraintWidget.getHeight());
        }
        if (!this.dimension.resolved) {
            this.dimensionBehavior = this.widget.getVerticalDimensionBehaviour();
            if (this.widget.hasBaseline()) {
                this.baselineDimension = new a(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.dimensionBehavior;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent2 = this.widget.getParent()) != null && parent2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int height = (parent2.getHeight() - this.widget.mTop.getMargin()) - this.widget.mBottom.getMargin();
                    addTarget(this.start, parent2.verticalRun.start, this.widget.mTop.getMargin());
                    addTarget(this.end, parent2.verticalRun.end, -this.widget.mBottom.getMargin());
                    this.dimension.resolve(height);
                    return;
                } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.dimension.resolve(this.widget.getHeight());
                }
            }
        } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent = this.widget.getParent()) != null && parent.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
            addTarget(this.start, parent.verticalRun.start, this.widget.mTop.getMargin());
            addTarget(this.end, parent.verticalRun.end, -this.widget.mBottom.getMargin());
            return;
        }
        b bVar = this.dimension;
        boolean z10 = bVar.resolved;
        if (z10) {
            ConstraintWidget constraintWidget2 = this.widget;
            if (constraintWidget2.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 != null && constraintAnchorArr[3].mTarget != null) {
                    if (constraintWidget2.isInVerticalChain()) {
                        this.start.margin = this.widget.mListAnchors[2].getMargin();
                        this.end.margin = -this.widget.mListAnchors[3].getMargin();
                    } else {
                        DependencyNode target = getTarget(this.widget.mListAnchors[2]);
                        if (target != null) {
                            addTarget(this.start, target, this.widget.mListAnchors[2].getMargin());
                        }
                        DependencyNode target2 = getTarget(this.widget.mListAnchors[3]);
                        if (target2 != null) {
                            addTarget(this.end, target2, -this.widget.mListAnchors[3].getMargin());
                        }
                        this.start.delegateToWidgetRun = true;
                        this.end.delegateToWidgetRun = true;
                    }
                    if (this.widget.hasBaseline()) {
                        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                        return;
                    }
                    return;
                } else if (constraintAnchor2 != null) {
                    DependencyNode target3 = getTarget(constraintAnchor);
                    if (target3 != null) {
                        addTarget(this.start, target3, this.widget.mListAnchors[2].getMargin());
                        addTarget(this.end, this.start, this.dimension.value);
                        if (this.widget.hasBaseline()) {
                            addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                    if (constraintAnchor3.mTarget != null) {
                        DependencyNode target4 = getTarget(constraintAnchor3);
                        if (target4 != null) {
                            addTarget(this.end, target4, -this.widget.mListAnchors[3].getMargin());
                            addTarget(this.start, this.end, -this.dimension.value);
                        }
                        if (this.widget.hasBaseline()) {
                            addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                            return;
                        }
                        return;
                    }
                    ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                    if (constraintAnchor4.mTarget != null) {
                        DependencyNode target5 = getTarget(constraintAnchor4);
                        if (target5 != null) {
                            addTarget(this.baseline, target5, 0);
                            addTarget(this.start, this.baseline, -this.widget.getBaselineDistance());
                            addTarget(this.end, this.start, this.dimension.value);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget2 instanceof Helper) && constraintWidget2.getParent() != null && this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                        addTarget(this.start, this.widget.getParent().verticalRun.start, this.widget.getY());
                        addTarget(this.end, this.start, this.dimension.value);
                        if (this.widget.hasBaseline()) {
                            addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
        if (z10 || this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            bVar.addDependency(this);
        } else {
            ConstraintWidget constraintWidget3 = this.widget;
            int i10 = constraintWidget3.mMatchConstraintDefaultHeight;
            if (i10 == 2) {
                ConstraintWidget parent3 = constraintWidget3.getParent();
                if (parent3 != null) {
                    b bVar2 = parent3.verticalRun.dimension;
                    this.dimension.targets.add(bVar2);
                    bVar2.dependencies.add(this.dimension);
                    b bVar3 = this.dimension;
                    bVar3.delegateToWidgetRun = true;
                    bVar3.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                }
            } else if (i10 == 3 && !constraintWidget3.isInVerticalChain()) {
                ConstraintWidget constraintWidget4 = this.widget;
                if (constraintWidget4.mMatchConstraintDefaultWidth != 3) {
                    b bVar4 = constraintWidget4.horizontalRun.dimension;
                    this.dimension.targets.add(bVar4);
                    bVar4.dependencies.add(this.dimension);
                    b bVar5 = this.dimension;
                    bVar5.delegateToWidgetRun = true;
                    bVar5.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                }
            }
        }
        ConstraintWidget constraintWidget5 = this.widget;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.mListAnchors;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.mTarget;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].mTarget != null) {
            if (constraintWidget5.isInVerticalChain()) {
                this.start.margin = this.widget.mListAnchors[2].getMargin();
                this.end.margin = -this.widget.mListAnchors[3].getMargin();
            } else {
                DependencyNode target6 = getTarget(this.widget.mListAnchors[2]);
                DependencyNode target7 = getTarget(this.widget.mListAnchors[3]);
                target6.addDependency(this);
                target7.addDependency(this);
                this.mRunType = WidgetRun.b.CENTER;
            }
            if (this.widget.hasBaseline()) {
                addTarget(this.baseline, this.start, 1, this.baselineDimension);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode target8 = getTarget(constraintAnchor5);
            if (target8 != null) {
                addTarget(this.start, target8, this.widget.mListAnchors[2].getMargin());
                addTarget(this.end, this.start, 1, this.dimension);
                if (this.widget.hasBaseline()) {
                    addTarget(this.baseline, this.start, 1, this.baselineDimension);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.dimensionBehavior;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.widget.getDimensionRatio() > 0.0f) {
                    HorizontalWidgetRun horizontalWidgetRun = this.widget.horizontalRun;
                    if (horizontalWidgetRun.dimensionBehavior == dimensionBehaviour3) {
                        horizontalWidgetRun.dimension.dependencies.add(this.dimension);
                        this.dimension.targets.add(this.widget.horizontalRun.dimension);
                        this.dimension.updateDelegate = this;
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.mTarget != null) {
                DependencyNode target9 = getTarget(constraintAnchor7);
                if (target9 != null) {
                    addTarget(this.end, target9, -this.widget.mListAnchors[3].getMargin());
                    addTarget(this.start, this.end, -1, this.dimension);
                    if (this.widget.hasBaseline()) {
                        addTarget(this.baseline, this.start, 1, this.baselineDimension);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.mTarget != null) {
                    DependencyNode target10 = getTarget(constraintAnchor8);
                    if (target10 != null) {
                        addTarget(this.baseline, target10, 0);
                        addTarget(this.start, this.baseline, -1, this.baselineDimension);
                        addTarget(this.end, this.start, 1, this.dimension);
                    }
                } else if (!(constraintWidget5 instanceof Helper) && constraintWidget5.getParent() != null) {
                    addTarget(this.start, this.widget.getParent().verticalRun.start, this.widget.getY());
                    addTarget(this.end, this.start, 1, this.dimension);
                    if (this.widget.hasBaseline()) {
                        addTarget(this.baseline, this.start, 1, this.baselineDimension);
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.dimensionBehavior;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour5 && this.widget.getDimensionRatio() > 0.0f) {
                        HorizontalWidgetRun horizontalWidgetRun2 = this.widget.horizontalRun;
                        if (horizontalWidgetRun2.dimensionBehavior == dimensionBehaviour5) {
                            horizontalWidgetRun2.dimension.dependencies.add(this.dimension);
                            this.dimension.targets.add(this.widget.horizontalRun.dimension);
                            this.dimension.updateDelegate = this;
                        }
                    }
                }
            }
        }
        if (this.dimension.targets.size() == 0) {
            this.dimension.readyToSolve = true;
        }
    }

    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.widget.setY(dependencyNode.value);
        }
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.baseline.clear();
        this.baseline.resolved = false;
        this.dimension.resolved = false;
    }

    /* access modifiers changed from: package-private */
    public boolean supportsWrapComputation() {
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultHeight == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "VerticalRun " + this.widget.getDebugName();
    }

    public void update(Dependency dependency) {
        int i10;
        float f10;
        float dimensionRatio;
        float f11;
        int i11 = a.f14729a[this.mRunType.ordinal()];
        if (i11 == 1) {
            updateRunStart(dependency);
        } else if (i11 == 2) {
            updateRunEnd(dependency);
        } else if (i11 == 3) {
            ConstraintWidget constraintWidget = this.widget;
            updateRunCenter(dependency, constraintWidget.mTop, constraintWidget.mBottom, 1);
            return;
        }
        b bVar = this.dimension;
        if (bVar.readyToSolve && !bVar.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.widget;
            int i12 = constraintWidget2.mMatchConstraintDefaultHeight;
            if (i12 == 2) {
                ConstraintWidget parent = constraintWidget2.getParent();
                if (parent != null) {
                    b bVar2 = parent.verticalRun.dimension;
                    if (bVar2.resolved) {
                        this.dimension.resolve((int) ((((float) bVar2.value) * this.widget.mMatchConstraintPercentHeight) + 0.5f));
                    }
                }
            } else if (i12 == 3 && constraintWidget2.horizontalRun.dimension.resolved) {
                int dimensionRatioSide = constraintWidget2.getDimensionRatioSide();
                if (dimensionRatioSide == -1) {
                    ConstraintWidget constraintWidget3 = this.widget;
                    f10 = (float) constraintWidget3.horizontalRun.dimension.value;
                    dimensionRatio = constraintWidget3.getDimensionRatio();
                } else if (dimensionRatioSide == 0) {
                    ConstraintWidget constraintWidget4 = this.widget;
                    f11 = ((float) constraintWidget4.horizontalRun.dimension.value) * constraintWidget4.getDimensionRatio();
                    i10 = (int) (f11 + 0.5f);
                    this.dimension.resolve(i10);
                } else if (dimensionRatioSide != 1) {
                    i10 = 0;
                    this.dimension.resolve(i10);
                } else {
                    ConstraintWidget constraintWidget5 = this.widget;
                    f10 = (float) constraintWidget5.horizontalRun.dimension.value;
                    dimensionRatio = constraintWidget5.getDimensionRatio();
                }
                f11 = f10 / dimensionRatio;
                i10 = (int) (f11 + 0.5f);
                this.dimension.resolve(i10);
            }
        }
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.readyToSolve) {
            DependencyNode dependencyNode2 = this.end;
            if (dependencyNode2.readyToSolve) {
                if (!dependencyNode.resolved || !dependencyNode2.resolved || !this.dimension.resolved) {
                    if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        ConstraintWidget constraintWidget6 = this.widget;
                        if (constraintWidget6.mMatchConstraintDefaultWidth == 0 && !constraintWidget6.isInVerticalChain()) {
                            int i13 = this.start.targets.get(0).value;
                            DependencyNode dependencyNode3 = this.start;
                            int i14 = i13 + dependencyNode3.margin;
                            int i15 = this.end.targets.get(0).value + this.end.margin;
                            dependencyNode3.resolve(i14);
                            this.end.resolve(i15);
                            this.dimension.resolve(i15 - i14);
                            return;
                        }
                    }
                    if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                        int i16 = (this.end.targets.get(0).value + this.end.margin) - (this.start.targets.get(0).value + this.start.margin);
                        b bVar3 = this.dimension;
                        int i17 = bVar3.f14736a;
                        if (i16 < i17) {
                            bVar3.resolve(i16);
                        } else {
                            bVar3.resolve(i17);
                        }
                    }
                    if (this.dimension.resolved && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                        DependencyNode dependencyNode4 = this.start.targets.get(0);
                        DependencyNode dependencyNode5 = this.end.targets.get(0);
                        int i18 = dependencyNode4.value + this.start.margin;
                        int i19 = dependencyNode5.value + this.end.margin;
                        float verticalBiasPercent = this.widget.getVerticalBiasPercent();
                        if (dependencyNode4 == dependencyNode5) {
                            i18 = dependencyNode4.value;
                            i19 = dependencyNode5.value;
                            verticalBiasPercent = 0.5f;
                        }
                        this.start.resolve((int) (((float) i18) + 0.5f + (((float) ((i19 - i18) - this.dimension.value)) * verticalBiasPercent)));
                        this.end.resolve(this.start.value + this.dimension.value);
                    }
                }
            }
        }
    }
}
