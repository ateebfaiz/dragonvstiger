package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;

public class Explode extends Visibility {
    private static final String PROPNAME_SCREEN_BOUNDS = "android:explode:screenBounds";
    private static final TimeInterpolator sAccelerate = new AccelerateInterpolator();
    private static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
    private int[] mTempLoc = new int[2];

    public Explode() {
        setPropagation(new CircularPropagation());
    }

    private static float calculateDistance(float f10, float f11) {
        return (float) Math.sqrt((double) ((f10 * f10) + (f11 * f11)));
    }

    private static float calculateMaxDistance(View view, int i10, int i11) {
        return calculateDistance((float) Math.max(i10, view.getWidth() - i10), (float) Math.max(i11, view.getHeight() - i11));
    }

    private void calculateOut(View view, Rect rect, int[] iArr) {
        int i10;
        int i11;
        View view2 = view;
        view2.getLocationOnScreen(this.mTempLoc);
        int[] iArr2 = this.mTempLoc;
        int i12 = iArr2[0];
        int i13 = iArr2[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            i11 = (view.getWidth() / 2) + i12 + Math.round(view.getTranslationX());
            i10 = (view.getHeight() / 2) + i13 + Math.round(view.getTranslationY());
        } else {
            int centerX = epicenter.centerX();
            i10 = epicenter.centerY();
            i11 = centerX;
        }
        float centerX2 = (float) (rect.centerX() - i11);
        float centerY = (float) (rect.centerY() - i10);
        if (centerX2 == 0.0f && centerY == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float calculateDistance = calculateDistance(centerX2, centerY);
        float calculateMaxDistance = calculateMaxDistance(view2, i11 - i12, i10 - i13);
        iArr[0] = Math.round((centerX2 / calculateDistance) * calculateMaxDistance);
        iArr[1] = Math.round(calculateMaxDistance * (centerY / calculateDistance));
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        view.getLocationOnScreen(this.mTempLoc);
        int[] iArr = this.mTempLoc;
        int i10 = iArr[0];
        int i11 = iArr[1];
        transitionValues.values.put(PROPNAME_SCREEN_BOUNDS, new Rect(i10, i11, view.getWidth() + i10, view.getHeight() + i11));
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.values.get(PROPNAME_SCREEN_BOUNDS);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        calculateOut(viewGroup, rect, this.mTempLoc);
        int[] iArr = this.mTempLoc;
        return t.a(view, transitionValues2, rect.left, rect.top, translationX + ((float) iArr[0]), translationY + ((float) iArr[1]), translationX, translationY, sDecelerate, this);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f10;
        float f11;
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.values.get(PROPNAME_SCREEN_BOUNDS);
        int i10 = rect.left;
        int i11 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(R.id.transition_position);
        if (iArr != null) {
            int i12 = iArr[0];
            f11 = ((float) (i12 - rect.left)) + translationX;
            int i13 = iArr[1];
            f10 = ((float) (i13 - rect.top)) + translationY;
            rect.offsetTo(i12, i13);
        } else {
            f11 = translationX;
            f10 = translationY;
        }
        calculateOut(viewGroup, rect, this.mTempLoc);
        int[] iArr2 = this.mTempLoc;
        return t.a(view, transitionValues, i10, i11, translationX, translationY, f11 + ((float) iArr2[0]), f10 + ((float) iArr2[1]), sAccelerate, this);
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setPropagation(new CircularPropagation());
    }
}
