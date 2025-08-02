package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public abstract class WidgetRun implements Dependency {
    b dimension = new b(this);
    protected ConstraintWidget.DimensionBehaviour dimensionBehavior;
    public DependencyNode end = new DependencyNode(this);
    protected b mRunType = b.NONE;
    public int matchConstraintsType;
    public int orientation = 0;
    boolean resolved = false;
    e runGroup;
    public DependencyNode start = new DependencyNode(this);
    ConstraintWidget widget;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14730a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14730a = r0
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14730a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14730a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f14730a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f14730a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.a.<clinit>():void");
        }
    }

    enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.widget = constraintWidget;
    }

    private void resolveDimension(int i10, int i11) {
        WidgetRun widgetRun;
        float f10;
        int i12;
        int i13 = this.matchConstraintsType;
        if (i13 == 0) {
            this.dimension.resolve(getLimitedDimension(i11, i10));
        } else if (i13 == 1) {
            this.dimension.resolve(Math.min(getLimitedDimension(this.dimension.f14736a, i10), i11));
        } else if (i13 == 2) {
            ConstraintWidget parent = this.widget.getParent();
            if (parent != null) {
                if (i10 == 0) {
                    widgetRun = parent.horizontalRun;
                } else {
                    widgetRun = parent.verticalRun;
                }
                b bVar = widgetRun.dimension;
                if (bVar.resolved) {
                    ConstraintWidget constraintWidget = this.widget;
                    if (i10 == 0) {
                        f10 = constraintWidget.mMatchConstraintPercentWidth;
                    } else {
                        f10 = constraintWidget.mMatchConstraintPercentHeight;
                    }
                    this.dimension.resolve(getLimitedDimension((int) ((((float) bVar.value) * f10) + 0.5f), i10));
                }
            }
        } else if (i13 == 3) {
            ConstraintWidget constraintWidget2 = this.widget;
            WidgetRun widgetRun2 = constraintWidget2.horizontalRun;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun2.dimensionBehavior;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && widgetRun2.matchConstraintsType == 3) {
                VerticalWidgetRun verticalWidgetRun = constraintWidget2.verticalRun;
                if (verticalWidgetRun.dimensionBehavior == dimensionBehaviour2 && verticalWidgetRun.matchConstraintsType == 3) {
                    return;
                }
            }
            if (i10 == 0) {
                widgetRun2 = constraintWidget2.verticalRun;
            }
            if (widgetRun2.dimension.resolved) {
                float dimensionRatio = constraintWidget2.getDimensionRatio();
                if (i10 == 1) {
                    i12 = (int) ((((float) widgetRun2.dimension.value) / dimensionRatio) + 0.5f);
                } else {
                    i12 = (int) ((dimensionRatio * ((float) widgetRun2.dimension.value)) + 0.5f);
                }
                this.dimension.resolve(i12);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i10) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.margin = i10;
        dependencyNode2.dependencies.add(dependencyNode);
    }

    /* access modifiers changed from: package-private */
    public abstract void apply();

    /* access modifiers changed from: package-private */
    public abstract void applyToWidget();

    /* access modifiers changed from: package-private */
    public abstract void clear();

    /* access modifiers changed from: protected */
    public final int getLimitedDimension(int i10, int i11) {
        int i12;
        if (i11 == 0) {
            ConstraintWidget constraintWidget = this.widget;
            int i13 = constraintWidget.mMatchConstraintMaxWidth;
            i12 = Math.max(constraintWidget.mMatchConstraintMinWidth, i10);
            if (i13 > 0) {
                i12 = Math.min(i13, i10);
            }
            if (i12 == i10) {
                return i10;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.widget;
            int i14 = constraintWidget2.mMatchConstraintMaxHeight;
            int max = Math.max(constraintWidget2.mMatchConstraintMinHeight, i10);
            if (i14 > 0) {
                max = Math.min(i14, i10);
            }
            if (i12 == i10) {
                return i10;
            }
        }
        return i12;
    }

    /* access modifiers changed from: protected */
    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        int i10 = a.f14730a[constraintAnchor2.mType.ordinal()];
        if (i10 == 1) {
            return constraintWidget.horizontalRun.start;
        }
        if (i10 == 2) {
            return constraintWidget.horizontalRun.end;
        }
        if (i10 == 3) {
            return constraintWidget.verticalRun.start;
        }
        if (i10 == 4) {
            return constraintWidget.verticalRun.baseline;
        }
        if (i10 != 5) {
            return null;
        }
        return constraintWidget.verticalRun.end;
    }

    public long getWrapDimension() {
        b bVar = this.dimension;
        if (bVar.resolved) {
            return (long) bVar.value;
        }
        return 0;
    }

    public boolean isCenterConnection() {
        int size = this.start.targets.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            if (this.start.targets.get(i11).run != this) {
                i10++;
            }
        }
        int size2 = this.end.targets.size();
        for (int i12 = 0; i12 < size2; i12++) {
            if (this.end.targets.get(i12).run != this) {
                i10++;
            }
        }
        if (i10 >= 2) {
            return true;
        }
        return false;
    }

    public boolean isDimensionResolved() {
        return this.dimension.resolved;
    }

    public boolean isResolved() {
        return this.resolved;
    }

    /* access modifiers changed from: package-private */
    public abstract void reset();

    /* access modifiers changed from: package-private */
    public abstract boolean supportsWrapComputation();

    public void update(Dependency dependency) {
    }

    /* access modifiers changed from: protected */
    public void updateRunCenter(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i10) {
        float f10;
        DependencyNode target = getTarget(constraintAnchor);
        DependencyNode target2 = getTarget(constraintAnchor2);
        if (target.resolved && target2.resolved) {
            int margin = target.value + constraintAnchor.getMargin();
            int margin2 = target2.value - constraintAnchor2.getMargin();
            int i11 = margin2 - margin;
            if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                resolveDimension(i10, i11);
            }
            b bVar = this.dimension;
            if (bVar.resolved) {
                if (bVar.value == i11) {
                    this.start.resolve(margin);
                    this.end.resolve(margin2);
                    return;
                }
                ConstraintWidget constraintWidget = this.widget;
                if (i10 == 0) {
                    f10 = constraintWidget.getHorizontalBiasPercent();
                } else {
                    f10 = constraintWidget.getVerticalBiasPercent();
                }
                if (target == target2) {
                    margin = target.value;
                    margin2 = target2.value;
                    f10 = 0.5f;
                }
                this.start.resolve((int) (((float) margin) + 0.5f + (((float) ((margin2 - margin) - this.dimension.value)) * f10)));
                this.end.resolve(this.start.value + this.dimension.value);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateRunEnd(Dependency dependency) {
    }

    /* access modifiers changed from: protected */
    public void updateRunStart(Dependency dependency) {
    }

    public long wrapSize(int i10) {
        int i11;
        b bVar = this.dimension;
        if (!bVar.resolved) {
            return 0;
        }
        long j10 = (long) bVar.value;
        if (isCenterConnection()) {
            i11 = this.start.margin - this.end.margin;
        } else if (i10 != 0) {
            return j10 - ((long) this.end.margin);
        } else {
            i11 = this.start.margin;
        }
        return j10 + ((long) i11);
    }

    /* access modifiers changed from: protected */
    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i10, b bVar) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.targets.add(this.dimension);
        dependencyNode.marginFactor = i10;
        dependencyNode.marginDependency = bVar;
        dependencyNode2.dependencies.add(dependencyNode);
        bVar.dependencies.add(dependencyNode);
    }

    /* access modifiers changed from: protected */
    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i10) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        WidgetRun widgetRun = i10 == 0 ? constraintWidget.horizontalRun : constraintWidget.verticalRun;
        int i11 = a.f14730a[constraintAnchor2.mType.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.end;
        }
        return widgetRun.start;
    }
}
