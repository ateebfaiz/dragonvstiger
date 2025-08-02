package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import java.util.ArrayList;

public class WidgetContainer extends ConstraintWidget {
    public ArrayList<ConstraintWidget> mChildren = new ArrayList<>();

    public WidgetContainer() {
    }

    public void add(ConstraintWidget constraintWidget) {
        this.mChildren.add(constraintWidget);
        if (constraintWidget.getParent() != null) {
            ((WidgetContainer) constraintWidget.getParent()).remove(constraintWidget);
        }
        constraintWidget.setParent(this);
    }

    public ArrayList<ConstraintWidget> getChildren() {
        return this.mChildren;
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        ConstraintWidgetContainer constraintWidgetContainer;
        ConstraintWidget parent = getParent();
        if (this instanceof ConstraintWidgetContainer) {
            constraintWidgetContainer = (ConstraintWidgetContainer) this;
        } else {
            constraintWidgetContainer = null;
        }
        while (parent != null) {
            ConstraintWidget parent2 = parent.getParent();
            if (parent instanceof ConstraintWidgetContainer) {
                constraintWidgetContainer = (ConstraintWidgetContainer) parent;
            }
            parent = parent2;
        }
        return constraintWidgetContainer;
    }

    public void layout() {
        ArrayList<ConstraintWidget> arrayList = this.mChildren;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i10);
                if (constraintWidget instanceof WidgetContainer) {
                    ((WidgetContainer) constraintWidget).layout();
                }
            }
        }
    }

    public void remove(ConstraintWidget constraintWidget) {
        this.mChildren.remove(constraintWidget);
        constraintWidget.setParent((ConstraintWidget) null);
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }

    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    public void resetSolverVariables(Cache cache) {
        super.resetSolverVariables(cache);
        int size = this.mChildren.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mChildren.get(i10).resetSolverVariables(cache);
        }
    }

    public void setOffset(int i10, int i11) {
        super.setOffset(i10, i11);
        int size = this.mChildren.size();
        for (int i12 = 0; i12 < size; i12++) {
            this.mChildren.get(i12).setOffset(getRootX(), getRootY());
        }
    }

    public WidgetContainer(int i10, int i11, int i12, int i13) {
        super(i10, i11, i12, i13);
    }

    public WidgetContainer(int i10, int i11) {
        super(i10, i11);
    }

    public void add(ConstraintWidget... constraintWidgetArr) {
        for (ConstraintWidget add : constraintWidgetArr) {
            add(add);
        }
    }
}
