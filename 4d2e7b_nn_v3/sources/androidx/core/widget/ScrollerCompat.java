package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
public final class ScrollerCompat {
    OverScroller mScroller;

    ScrollerCompat(Context context, Interpolator interpolator) {
        OverScroller overScroller;
        if (interpolator != null) {
            overScroller = new OverScroller(context, interpolator);
        } else {
            overScroller = new OverScroller(context);
        }
        this.mScroller = overScroller;
    }

    @Deprecated
    public static ScrollerCompat create(Context context) {
        return create(context, (Interpolator) null);
    }

    @Deprecated
    public void abortAnimation() {
        this.mScroller.abortAnimation();
    }

    @Deprecated
    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }

    @Deprecated
    public void fling(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.mScroller.fling(i10, i11, i12, i13, i14, i15, i16, i17);
    }

    @Deprecated
    public float getCurrVelocity() {
        return this.mScroller.getCurrVelocity();
    }

    @Deprecated
    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    @Deprecated
    public int getCurrY() {
        return this.mScroller.getCurrY();
    }

    @Deprecated
    public int getFinalX() {
        return this.mScroller.getFinalX();
    }

    @Deprecated
    public int getFinalY() {
        return this.mScroller.getFinalY();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    @Deprecated
    public boolean isOverScrolled() {
        return this.mScroller.isOverScrolled();
    }

    @Deprecated
    public void notifyHorizontalEdgeReached(int i10, int i11, int i12) {
        this.mScroller.notifyHorizontalEdgeReached(i10, i11, i12);
    }

    @Deprecated
    public void notifyVerticalEdgeReached(int i10, int i11, int i12) {
        this.mScroller.notifyVerticalEdgeReached(i10, i11, i12);
    }

    @Deprecated
    public boolean springBack(int i10, int i11, int i12, int i13, int i14, int i15) {
        return this.mScroller.springBack(i10, i11, i12, i13, i14, i15);
    }

    @Deprecated
    public void startScroll(int i10, int i11, int i12, int i13) {
        this.mScroller.startScroll(i10, i11, i12, i13);
    }

    @Deprecated
    public static ScrollerCompat create(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
    }

    @Deprecated
    public void fling(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        this.mScroller.fling(i10, i11, i12, i13, i14, i15, i16, i17, i18, i19);
    }

    @Deprecated
    public void startScroll(int i10, int i11, int i12, int i13, int i14) {
        this.mScroller.startScroll(i10, i11, i12, i13, i14);
    }
}
