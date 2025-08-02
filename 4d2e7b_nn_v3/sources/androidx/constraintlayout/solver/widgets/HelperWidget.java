package androidx.constraintlayout.solver.widgets;

import java.util.Arrays;
import java.util.HashMap;

public class HelperWidget extends ConstraintWidget implements Helper {
    public ConstraintWidget[] mWidgets = new ConstraintWidget[4];
    public int mWidgetsCount = 0;

    public void add(ConstraintWidget constraintWidget) {
        if (constraintWidget != this && constraintWidget != null) {
            int i10 = this.mWidgetsCount + 1;
            ConstraintWidget[] constraintWidgetArr = this.mWidgets;
            if (i10 > constraintWidgetArr.length) {
                this.mWidgets = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
            }
            ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
            int i11 = this.mWidgetsCount;
            constraintWidgetArr2[i11] = constraintWidget;
            this.mWidgetsCount = i11 + 1;
        }
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        HelperWidget helperWidget = (HelperWidget) constraintWidget;
        this.mWidgetsCount = 0;
        int i10 = helperWidget.mWidgetsCount;
        for (int i11 = 0; i11 < i10; i11++) {
            add(hashMap.get(helperWidget.mWidgets[i11]));
        }
    }

    public void removeAllIds() {
        this.mWidgetsCount = 0;
        Arrays.fill(this.mWidgets, (Object) null);
    }

    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
    }
}
