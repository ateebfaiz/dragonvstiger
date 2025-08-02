package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public class SidePropagation extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;
    private int mSide = 80;

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (androidx.core.view.ViewCompat.getLayoutDirection(r6) == 1) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r0 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (androidx.core.view.ViewCompat.getLayoutDirection(r6) == 1) goto L_0x0012;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int distance(android.view.View r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14) {
        /*
            r5 = this;
            int r0 = r5.mSide
            r1 = 8388611(0x800003, float:1.1754948E-38)
            r2 = 1
            r3 = 3
            r4 = 5
            if (r0 != r1) goto L_0x0014
            int r6 = androidx.core.view.ViewCompat.getLayoutDirection(r6)
            if (r6 != r2) goto L_0x0012
        L_0x0010:
            r0 = r4
            goto L_0x0020
        L_0x0012:
            r0 = r3
            goto L_0x0020
        L_0x0014:
            r1 = 8388613(0x800005, float:1.175495E-38)
            if (r0 != r1) goto L_0x0020
            int r6 = androidx.core.view.ViewCompat.getLayoutDirection(r6)
            if (r6 != r2) goto L_0x0010
            goto L_0x0012
        L_0x0020:
            if (r0 == r3) goto L_0x0046
            if (r0 == r4) goto L_0x003e
            r6 = 48
            if (r0 == r6) goto L_0x0036
            r6 = 80
            if (r0 == r6) goto L_0x002e
            r6 = 0
            goto L_0x004d
        L_0x002e:
            int r8 = r8 - r12
            int r9 = r9 - r7
            int r6 = java.lang.Math.abs(r9)
            int r6 = r6 + r8
            goto L_0x004d
        L_0x0036:
            int r14 = r14 - r8
            int r9 = r9 - r7
            int r6 = java.lang.Math.abs(r9)
            int r6 = r6 + r14
            goto L_0x004d
        L_0x003e:
            int r7 = r7 - r11
            int r10 = r10 - r8
            int r6 = java.lang.Math.abs(r10)
            int r6 = r6 + r7
            goto L_0x004d
        L_0x0046:
            int r13 = r13 - r7
            int r10 = r10 - r8
            int r6 = java.lang.Math.abs(r10)
            int r6 = r6 + r13
        L_0x004d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.SidePropagation.distance(android.view.View, int, int, int, int, int, int, int, int):int");
    }

    private int getMaxDistance(ViewGroup viewGroup) {
        int i10 = this.mSide;
        if (i10 == 3 || i10 == 5 || i10 == 8388611 || i10 == 8388613) {
            return viewGroup.getWidth();
        }
        return viewGroup.getHeight();
    }

    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i10;
        int i11;
        int i12;
        TransitionValues transitionValues3 = transitionValues;
        if (transitionValues3 == null && transitionValues2 == null) {
            return 0;
        }
        Rect epicenter = transition.getEpicenter();
        if (transitionValues2 == null || getViewVisibility(transitionValues3) == 0) {
            i10 = -1;
        } else {
            transitionValues3 = transitionValues2;
            i10 = 1;
        }
        int viewX = getViewX(transitionValues3);
        int viewY = getViewY(transitionValues3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(viewGroup.getTranslationX());
        int round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = round + viewGroup.getWidth();
        int height = round2 + viewGroup.getHeight();
        if (epicenter != null) {
            i12 = epicenter.centerX();
            i11 = epicenter.centerY();
        } else {
            i12 = (round + width) / 2;
            i11 = (round2 + height) / 2;
        }
        float distance = ((float) distance(viewGroup, viewX, viewY, i12, i11, round, round2, width, height)) / ((float) getMaxDistance(viewGroup));
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

    public void setSide(int i10) {
        this.mSide = i10;
    }
}
