package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import androidx.core.view.DifferentialMotionFlingController;

public final /* synthetic */ class q implements DifferentialMotionFlingController.b {
    public final void a(Context context, int[] iArr, MotionEvent motionEvent, int i10) {
        DifferentialMotionFlingController.calculateFlingVelocityThresholds(context, iArr, motionEvent, i10);
    }
}
