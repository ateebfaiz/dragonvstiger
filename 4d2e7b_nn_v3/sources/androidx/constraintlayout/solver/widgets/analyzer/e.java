package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

class e {

    /* renamed from: h  reason: collision with root package name */
    public static int f14737h;

    /* renamed from: a  reason: collision with root package name */
    public int f14738a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f14739b = false;

    /* renamed from: c  reason: collision with root package name */
    WidgetRun f14740c = null;

    /* renamed from: d  reason: collision with root package name */
    WidgetRun f14741d = null;

    /* renamed from: e  reason: collision with root package name */
    ArrayList f14742e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    int f14743f;

    /* renamed from: g  reason: collision with root package name */
    int f14744g;

    public e(WidgetRun widgetRun, int i10) {
        int i11 = f14737h;
        this.f14743f = i11;
        f14737h = i11 + 1;
        this.f14740c = widgetRun;
        this.f14741d = widgetRun;
        this.f14744g = i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0072, code lost:
        r2 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r2 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r6, int r7) {
        /*
            r5 = this;
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r6.widget
            boolean[] r0 = r0.isTerminalWidget
            boolean r0 = r0[r7]
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r6.start
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.Dependency> r0 = r0.dependencies
            java.util.Iterator r0 = r0.iterator()
        L_0x0012:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x005a
            java.lang.Object r2 = r0.next()
            androidx.constraintlayout.solver.widgets.analyzer.Dependency r2 = (androidx.constraintlayout.solver.widgets.analyzer.Dependency) r2
            boolean r3 = r2 instanceof androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
            if (r3 == 0) goto L_0x0012
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r2
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r3 = r2.run
            if (r3 != r6) goto L_0x0029
            goto L_0x0012
        L_0x0029:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r3.start
            if (r2 != r3) goto L_0x0012
            boolean r3 = r6 instanceof androidx.constraintlayout.solver.widgets.analyzer.ChainRun
            if (r3 == 0) goto L_0x004a
            r3 = r6
            androidx.constraintlayout.solver.widgets.analyzer.ChainRun r3 = (androidx.constraintlayout.solver.widgets.analyzer.ChainRun) r3
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r3 = r3.widgets
            java.util.Iterator r3 = r3.iterator()
        L_0x003a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0054
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r4 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r4
            r5.c(r4, r7)
            goto L_0x003a
        L_0x004a:
            boolean r3 = r6 instanceof androidx.constraintlayout.solver.widgets.analyzer.d
            if (r3 != 0) goto L_0x0054
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r6.widget
            boolean[] r3 = r3.isTerminalWidget
            r3[r7] = r1
        L_0x0054:
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r2 = r2.run
            r5.c(r2, r7)
            goto L_0x0012
        L_0x005a:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r6.end
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.Dependency> r0 = r0.dependencies
            java.util.Iterator r0 = r0.iterator()
        L_0x0062:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00aa
            java.lang.Object r2 = r0.next()
            androidx.constraintlayout.solver.widgets.analyzer.Dependency r2 = (androidx.constraintlayout.solver.widgets.analyzer.Dependency) r2
            boolean r3 = r2 instanceof androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
            if (r3 == 0) goto L_0x0062
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r2
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r3 = r2.run
            if (r3 != r6) goto L_0x0079
            goto L_0x0062
        L_0x0079:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r3.start
            if (r2 != r3) goto L_0x0062
            boolean r3 = r6 instanceof androidx.constraintlayout.solver.widgets.analyzer.ChainRun
            if (r3 == 0) goto L_0x009a
            r3 = r6
            androidx.constraintlayout.solver.widgets.analyzer.ChainRun r3 = (androidx.constraintlayout.solver.widgets.analyzer.ChainRun) r3
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r3 = r3.widgets
            java.util.Iterator r3 = r3.iterator()
        L_0x008a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00a4
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r4 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r4
            r5.c(r4, r7)
            goto L_0x008a
        L_0x009a:
            boolean r3 = r6 instanceof androidx.constraintlayout.solver.widgets.analyzer.d
            if (r3 != 0) goto L_0x00a4
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r6.widget
            boolean[] r3 = r3.isTerminalWidget
            r3[r7] = r1
        L_0x00a4:
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r2 = r2.run
            r5.c(r2, r7)
            goto L_0x0062
        L_0x00aa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.e.c(androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, int):boolean");
    }

    private long e(DependencyNode dependencyNode, long j10) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof d) {
            return j10;
        }
        int size = dependencyNode.dependencies.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            Dependency dependency = dependencyNode.dependencies.get(i10);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j11 = Math.min(j11, e(dependencyNode2, ((long) dependencyNode2.margin) + j10));
                }
            }
        }
        if (dependencyNode != widgetRun.end) {
            return j11;
        }
        long wrapDimension = j10 - widgetRun.getWrapDimension();
        return Math.min(Math.min(j11, e(widgetRun.start, wrapDimension)), wrapDimension - ((long) widgetRun.start.margin));
    }

    private long f(DependencyNode dependencyNode, long j10) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof d) {
            return j10;
        }
        int size = dependencyNode.dependencies.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            Dependency dependency = dependencyNode.dependencies.get(i10);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j11 = Math.max(j11, f(dependencyNode2, ((long) dependencyNode2.margin) + j10));
                }
            }
        }
        if (dependencyNode != widgetRun.start) {
            return j11;
        }
        long wrapDimension = j10 + widgetRun.getWrapDimension();
        return Math.max(Math.max(j11, f(widgetRun.end, wrapDimension)), wrapDimension - ((long) widgetRun.end.margin));
    }

    public void a(WidgetRun widgetRun) {
        this.f14742e.add(widgetRun);
        this.f14741d = widgetRun;
    }

    public long b(ConstraintWidgetContainer constraintWidgetContainer, int i10) {
        WidgetRun widgetRun;
        WidgetRun widgetRun2;
        long wrapDimension;
        int i11;
        WidgetRun widgetRun3 = this.f14740c;
        long j10 = 0;
        if (widgetRun3 instanceof ChainRun) {
            if (((ChainRun) widgetRun3).orientation != i10) {
                return 0;
            }
        } else if (i10 == 0) {
            if (!(widgetRun3 instanceof HorizontalWidgetRun)) {
                return 0;
            }
        } else if (!(widgetRun3 instanceof VerticalWidgetRun)) {
            return 0;
        }
        if (i10 == 0) {
            widgetRun = constraintWidgetContainer.horizontalRun;
        } else {
            widgetRun = constraintWidgetContainer.verticalRun;
        }
        DependencyNode dependencyNode = widgetRun.start;
        if (i10 == 0) {
            widgetRun2 = constraintWidgetContainer.horizontalRun;
        } else {
            widgetRun2 = constraintWidgetContainer.verticalRun;
        }
        DependencyNode dependencyNode2 = widgetRun2.end;
        boolean contains = widgetRun3.start.targets.contains(dependencyNode);
        boolean contains2 = this.f14740c.end.targets.contains(dependencyNode2);
        long wrapDimension2 = this.f14740c.getWrapDimension();
        if (contains && contains2) {
            long f10 = f(this.f14740c.start, 0);
            long e10 = e(this.f14740c.end, 0);
            long j11 = f10 - wrapDimension2;
            WidgetRun widgetRun4 = this.f14740c;
            int i12 = widgetRun4.end.margin;
            if (j11 >= ((long) (-i12))) {
                j11 += (long) i12;
            }
            int i13 = widgetRun4.start.margin;
            long j12 = ((-e10) - wrapDimension2) - ((long) i13);
            if (j12 >= ((long) i13)) {
                j12 -= (long) i13;
            }
            float biasPercent = widgetRun4.widget.getBiasPercent(i10);
            if (biasPercent > 0.0f) {
                j10 = (long) ((((float) j12) / biasPercent) + (((float) j11) / (1.0f - biasPercent)));
            }
            float f11 = (float) j10;
            long j13 = ((long) ((f11 * biasPercent) + 0.5f)) + wrapDimension2 + ((long) ((f11 * (1.0f - biasPercent)) + 0.5f));
            WidgetRun widgetRun5 = this.f14740c;
            wrapDimension = ((long) widgetRun5.start.margin) + j13;
            i11 = widgetRun5.end.margin;
        } else if (contains) {
            DependencyNode dependencyNode3 = this.f14740c.start;
            return Math.max(f(dependencyNode3, (long) dependencyNode3.margin), ((long) this.f14740c.start.margin) + wrapDimension2);
        } else if (contains2) {
            DependencyNode dependencyNode4 = this.f14740c.end;
            return Math.max(-e(dependencyNode4, (long) dependencyNode4.margin), ((long) (-this.f14740c.end.margin)) + wrapDimension2);
        } else {
            WidgetRun widgetRun6 = this.f14740c;
            wrapDimension = ((long) widgetRun6.start.margin) + widgetRun6.getWrapDimension();
            i11 = this.f14740c.end.margin;
        }
        return wrapDimension - ((long) i11);
    }

    public void d(boolean z10, boolean z11) {
        if (z10) {
            WidgetRun widgetRun = this.f14740c;
            if (widgetRun instanceof HorizontalWidgetRun) {
                c(widgetRun, 0);
            }
        }
        if (z11) {
            WidgetRun widgetRun2 = this.f14740c;
            if (widgetRun2 instanceof VerticalWidgetRun) {
                c(widgetRun2, 1);
            }
        }
    }
}
