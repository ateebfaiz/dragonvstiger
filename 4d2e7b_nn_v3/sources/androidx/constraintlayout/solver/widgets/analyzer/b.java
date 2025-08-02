package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;

class b extends DependencyNode {

    /* renamed from: a  reason: collision with root package name */
    public int f14736a;

    public b(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof HorizontalWidgetRun) {
            this.type = DependencyNode.a.HORIZONTAL_DIMENSION;
        } else {
            this.type = DependencyNode.a.VERTICAL_DIMENSION;
        }
    }

    public void resolve(int i10) {
        if (!this.resolved) {
            this.resolved = true;
            this.value = i10;
            for (Dependency next : this.dependencies) {
                next.update(next);
            }
        }
    }
}
