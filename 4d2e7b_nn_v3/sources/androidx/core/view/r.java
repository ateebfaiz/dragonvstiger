package androidx.core.view;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.core.view.DifferentialMotionFlingController;

public final /* synthetic */ class r implements DifferentialMotionFlingController.a {
    public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i10) {
        return DifferentialMotionFlingController.getCurrentVelocity(velocityTracker, motionEvent, i10);
    }
}
