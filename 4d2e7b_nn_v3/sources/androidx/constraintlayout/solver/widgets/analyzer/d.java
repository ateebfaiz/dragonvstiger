package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;

class d extends WidgetRun {
    public d(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void a(DependencyNode dependencyNode) {
        this.start.dependencies.add(dependencyNode);
        dependencyNode.targets.add(this.start);
    }

    /* access modifiers changed from: package-private */
    public void apply() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget instanceof Barrier) {
            this.start.delegateToWidgetRun = true;
            Barrier barrier = (Barrier) constraintWidget;
            int barrierType = barrier.getBarrierType();
            boolean allowsGoneWidget = barrier.allowsGoneWidget();
            int i10 = 0;
            if (barrierType == 0) {
                this.start.type = DependencyNode.a.LEFT;
                while (i10 < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget2 = barrier.mWidgets[i10];
                    if (allowsGoneWidget || constraintWidget2.getVisibility() != 8) {
                        DependencyNode dependencyNode = constraintWidget2.horizontalRun.start;
                        dependencyNode.dependencies.add(this.start);
                        this.start.targets.add(dependencyNode);
                    }
                    i10++;
                }
                a(this.widget.horizontalRun.start);
                a(this.widget.horizontalRun.end);
            } else if (barrierType == 1) {
                this.start.type = DependencyNode.a.RIGHT;
                while (i10 < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget3 = barrier.mWidgets[i10];
                    if (allowsGoneWidget || constraintWidget3.getVisibility() != 8) {
                        DependencyNode dependencyNode2 = constraintWidget3.horizontalRun.end;
                        dependencyNode2.dependencies.add(this.start);
                        this.start.targets.add(dependencyNode2);
                    }
                    i10++;
                }
                a(this.widget.horizontalRun.start);
                a(this.widget.horizontalRun.end);
            } else if (barrierType == 2) {
                this.start.type = DependencyNode.a.TOP;
                while (i10 < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget4 = barrier.mWidgets[i10];
                    if (allowsGoneWidget || constraintWidget4.getVisibility() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget4.verticalRun.start;
                        dependencyNode3.dependencies.add(this.start);
                        this.start.targets.add(dependencyNode3);
                    }
                    i10++;
                }
                a(this.widget.verticalRun.start);
                a(this.widget.verticalRun.end);
            } else if (barrierType == 3) {
                this.start.type = DependencyNode.a.BOTTOM;
                while (i10 < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget5 = barrier.mWidgets[i10];
                    if (allowsGoneWidget || constraintWidget5.getVisibility() != 8) {
                        DependencyNode dependencyNode4 = constraintWidget5.verticalRun.end;
                        dependencyNode4.dependencies.add(this.start);
                        this.start.targets.add(dependencyNode4);
                    }
                    i10++;
                }
                a(this.widget.verticalRun.start);
                a(this.widget.verticalRun.end);
            }
        }
    }

    public void applyToWidget() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget instanceof Barrier) {
            int barrierType = ((Barrier) constraintWidget).getBarrierType();
            if (barrierType == 0 || barrierType == 1) {
                this.widget.setX(this.start.value);
            } else {
                this.widget.setY(this.start.value);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.runGroup = null;
        this.start.clear();
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.start.resolved = false;
    }

    /* access modifiers changed from: package-private */
    public boolean supportsWrapComputation() {
        return false;
    }

    public void update(Dependency dependency) {
        Barrier barrier = (Barrier) this.widget;
        int barrierType = barrier.getBarrierType();
        int i10 = 0;
        int i11 = -1;
        for (DependencyNode dependencyNode : this.start.targets) {
            int i12 = dependencyNode.value;
            if (i11 == -1 || i12 < i11) {
                i11 = i12;
            }
            if (i10 < i12) {
                i10 = i12;
            }
        }
        if (barrierType == 0 || barrierType == 2) {
            this.start.resolve(i11 + barrier.getMargin());
        } else {
            this.start.resolve(i10 + barrier.getMargin());
        }
    }
}
