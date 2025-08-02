package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public class CircularPropagation extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;

    private static float distance(float f10, float f11, float f12, float f13) {
        float f14 = f12 - f10;
        float f15 = f13 - f11;
        return (float) Math.sqrt((double) ((f14 * f14) + (f15 * f15)));
    }

    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i10;
        int i11;
        int i12;
        if (transitionValues == null && transitionValues2 == null) {
            return 0;
        }
        if (transitionValues2 == null || getViewVisibility(transitionValues) == 0) {
            i10 = -1;
        } else {
            transitionValues = transitionValues2;
            i10 = 1;
        }
        int viewX = getViewX(transitionValues);
        int viewY = getViewY(transitionValues);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            i12 = epicenter.centerX();
            i11 = epicenter.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round = Math.round(((float) (iArr[0] + (viewGroup.getWidth() / 2))) + viewGroup.getTranslationX());
            i11 = Math.round(((float) (iArr[1] + (viewGroup.getHeight() / 2))) + viewGroup.getTranslationY());
            i12 = round;
        }
        float distance = distance((float) viewX, (float) viewY, (float) i12, (float) i11) / distance(0.0f, 0.0f, (float) viewGroup.getWidth(), (float) viewGroup.getHeight());
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return (long) Math.round((((float) (duration * ((long) i10))) / this.mPropagationSpeed) * distance);
    }

    public void setPropagationSpeed(float f10) {
        if (f10 != 0.0f) {
            this.mPropagationSpeed = f10;
            return;
        }
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }
}
