package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.ArrayList;
import java.util.List;

public class DependencyNode implements Dependency {
    public boolean delegateToWidgetRun = false;
    List<Dependency> dependencies = new ArrayList();
    int margin;
    b marginDependency = null;
    int marginFactor = 1;
    public boolean readyToSolve = false;
    public boolean resolved = false;
    WidgetRun run;
    List<DependencyNode> targets = new ArrayList();
    a type = a.UNKNOWN;
    public Dependency updateDelegate = null;
    public int value;

    enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.run = widgetRun;
    }

    public void addDependency(Dependency dependency) {
        this.dependencies.add(dependency);
        if (this.resolved) {
            dependency.update(dependency);
        }
    }

    public void clear() {
        this.targets.clear();
        this.dependencies.clear();
        this.resolved = false;
        this.value = 0;
        this.readyToSolve = false;
        this.delegateToWidgetRun = false;
    }

    public String name() {
        String str;
        String debugName = this.run.widget.getDebugName();
        a aVar = this.type;
        if (aVar == a.LEFT || aVar == a.RIGHT) {
            str = debugName + "_HORIZONTAL";
        } else {
            str = debugName + "_VERTICAL";
        }
        return str + ":" + this.type.name();
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

    public String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.run.widget.getDebugName());
        sb2.append(":");
        sb2.append(this.type);
        sb2.append("(");
        if (this.resolved) {
            obj = Integer.valueOf(this.value);
        } else {
            obj = "unresolved";
        }
        sb2.append(obj);
        sb2.append(") <t=");
        sb2.append(this.targets.size());
        sb2.append(":d=");
        sb2.append(this.dependencies.size());
        sb2.append(">");
        return sb2.toString();
    }

    public void update(Dependency dependency) {
        for (DependencyNode dependencyNode : this.targets) {
            if (!dependencyNode.resolved) {
                return;
            }
        }
        this.readyToSolve = true;
        Dependency dependency2 = this.updateDelegate;
        if (dependency2 != null) {
            dependency2.update(this);
        }
        if (this.delegateToWidgetRun) {
            this.run.update(this);
            return;
        }
        DependencyNode dependencyNode2 = null;
        int i10 = 0;
        for (DependencyNode next : this.targets) {
            if (!(next instanceof b)) {
                i10++;
                dependencyNode2 = next;
            }
        }
        if (dependencyNode2 != null && i10 == 1 && dependencyNode2.resolved) {
            b bVar = this.marginDependency;
            if (bVar != null) {
                if (bVar.resolved) {
                    this.margin = this.marginFactor * bVar.value;
                } else {
                    return;
                }
            }
            resolve(dependencyNode2.value + this.margin);
        }
        Dependency dependency3 = this.updateDelegate;
        if (dependency3 != null) {
            dependency3.update(this);
        }
    }
}
