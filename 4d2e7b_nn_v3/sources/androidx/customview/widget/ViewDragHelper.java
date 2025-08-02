package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = new a();
    private int mActivePointerId = -1;
    private final Callback mCallback;
    private View mCapturedView;
    private final int mDefaultEdgeSize;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private final Runnable mSetIdleRunnable = new b();
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;

    public static abstract class Callback {
        public int clampViewPositionHorizontal(@NonNull View view, int i10, int i11) {
            return 0;
        }

        public int clampViewPositionVertical(@NonNull View view, int i10, int i11) {
            return 0;
        }

        public int getOrderedChildIndex(int i10) {
            return i10;
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i10, int i11) {
        }

        public boolean onEdgeLock(int i10) {
            return false;
        }

        public void onEdgeTouched(int i10, int i11) {
        }

        public void onViewCaptured(@NonNull View view, int i10) {
        }

        public void onViewDragStateChanged(int i10) {
        }

        public void onViewPositionChanged(@NonNull View view, int i10, int i11, @Px int i12, @Px int i13) {
        }

        public void onViewReleased(@NonNull View view, float f10, float f11) {
        }

        public abstract boolean tryCaptureView(@NonNull View view, int i10);
    }

    class a implements Interpolator {
        a() {
        }

        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            ViewDragHelper.this.setDragState(0);
        }
    }

    private ViewDragHelper(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback != null) {
            this.mParentView = viewGroup;
            this.mCallback = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int i10 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mDefaultEdgeSize = i10;
            this.mEdgeSize = i10;
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.mMaxVelocity = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.mMinVelocity = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.mScroller = new OverScroller(context, sInterpolator);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    private boolean checkNewEdgeDrag(float f10, float f11, int i10, int i11) {
        float abs = Math.abs(f10);
        float abs2 = Math.abs(f11);
        if ((this.mInitialEdgesTouched[i10] & i11) != i11 || (this.mTrackingEdges & i11) == 0 || (this.mEdgeDragsLocked[i10] & i11) == i11 || (this.mEdgeDragsInProgress[i10] & i11) == i11) {
            return false;
        }
        int i12 = this.mTouchSlop;
        if (abs <= ((float) i12) && abs2 <= ((float) i12)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.mCallback.onEdgeLock(i11)) {
            int[] iArr = this.mEdgeDragsLocked;
            iArr[i10] = iArr[i10] | i11;
            return false;
        } else if ((this.mEdgeDragsInProgress[i10] & i11) != 0 || abs <= ((float) this.mTouchSlop)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkTouchSlop(View view, float f10, float f11) {
        if (view == null) {
            return false;
        }
        boolean z10 = this.mCallback.getViewHorizontalDragRange(view) > 0;
        boolean z11 = this.mCallback.getViewVerticalDragRange(view) > 0;
        if (z10 && z11) {
            int i10 = this.mTouchSlop;
            if ((f10 * f10) + (f11 * f11) > ((float) (i10 * i10))) {
                return true;
            }
            return false;
        } else if (z10) {
            if (Math.abs(f10) > ((float) this.mTouchSlop)) {
                return true;
            }
            return false;
        } else if (!z11 || Math.abs(f11) <= ((float) this.mTouchSlop)) {
            return false;
        } else {
            return true;
        }
    }

    private int clampMag(int i10, int i11, int i12) {
        int abs = Math.abs(i10);
        if (abs < i11) {
            return 0;
        }
        if (abs > i12) {
            return i10 > 0 ? i12 : -i12;
        }
        return i10;
    }

    private void clearMotionHistory() {
        float[] fArr = this.mInitialMotionX;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.mInitialMotionY, 0.0f);
            Arrays.fill(this.mLastMotionX, 0.0f);
            Arrays.fill(this.mLastMotionY, 0.0f);
            Arrays.fill(this.mInitialEdgesTouched, 0);
            Arrays.fill(this.mEdgeDragsInProgress, 0);
            Arrays.fill(this.mEdgeDragsLocked, 0);
            this.mPointersDown = 0;
        }
    }

    private int computeAxisDuration(int i10, int i11, int i12) {
        int i13;
        if (i10 == 0) {
            return 0;
        }
        int width = this.mParentView.getWidth();
        float f10 = (float) (width / 2);
        float distanceInfluenceForSnapDuration = f10 + (distanceInfluenceForSnapDuration(Math.min(1.0f, ((float) Math.abs(i10)) / ((float) width))) * f10);
        int abs = Math.abs(i11);
        if (abs > 0) {
            i13 = Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) abs)) * 1000.0f) * 4;
        } else {
            i13 = (int) (((((float) Math.abs(i10)) / ((float) i12)) + 1.0f) * 256.0f);
        }
        return Math.min(i13, MAX_SETTLE_DURATION);
    }

    private int computeSettleDuration(View view, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int clampMag = clampMag(i12, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int clampMag2 = clampMag(i13, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int abs = Math.abs(i10);
        int abs2 = Math.abs(i11);
        int abs3 = Math.abs(clampMag);
        int abs4 = Math.abs(clampMag2);
        int i14 = abs3 + abs4;
        int i15 = abs + abs2;
        if (clampMag != 0) {
            f10 = (float) abs3;
            f11 = (float) i14;
        } else {
            f10 = (float) abs;
            f11 = (float) i15;
        }
        float f14 = f10 / f11;
        if (clampMag2 != 0) {
            f12 = (float) abs4;
            f13 = (float) i14;
        } else {
            f12 = (float) abs2;
            f13 = (float) i15;
        }
        float f15 = f12 / f13;
        return (int) ((((float) computeAxisDuration(i10, clampMag, this.mCallback.getViewHorizontalDragRange(view))) * f14) + (((float) computeAxisDuration(i11, clampMag2, this.mCallback.getViewVerticalDragRange(view))) * f15));
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void dispatchViewReleased(float f10, float f11) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f10, f11);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f10) {
        return (float) Math.sin((double) ((f10 - 0.5f) * 0.47123894f));
    }

    private void dragTo(int i10, int i11, int i12, int i13) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        if (i12 != 0) {
            i10 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i10, i12);
            ViewCompat.offsetLeftAndRight(this.mCapturedView, i10 - left);
        }
        int i14 = i10;
        if (i13 != 0) {
            i11 = this.mCallback.clampViewPositionVertical(this.mCapturedView, i11, i13);
            ViewCompat.offsetTopAndBottom(this.mCapturedView, i11 - top);
        }
        int i15 = i11;
        if (i12 != 0 || i13 != 0) {
            this.mCallback.onViewPositionChanged(this.mCapturedView, i14, i15, i14 - left, i15 - top);
        }
    }

    private void ensureMotionHistorySizeForId(int i10) {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.mInitialMotionY;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.mLastMotionX;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.mLastMotionY;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.mInitialEdgesTouched;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.mEdgeDragsInProgress;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.mEdgeDragsLocked;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.mInitialMotionX = fArr2;
            this.mInitialMotionY = fArr3;
            this.mLastMotionX = fArr4;
            this.mLastMotionY = fArr5;
            this.mInitialEdgesTouched = iArr;
            this.mEdgeDragsInProgress = iArr2;
            this.mEdgeDragsLocked = iArr3;
        }
    }

    private boolean forceSettleCapturedViewAt(int i10, int i11, int i12, int i13) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        if (i14 == 0 && i15 == 0) {
            this.mScroller.abortAnimation();
            setDragState(0);
            return false;
        }
        this.mScroller.startScroll(left, top, i14, i15, computeSettleDuration(this.mCapturedView, i14, i15, i12, i13));
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int i10, int i11) {
        int i12;
        if (i10 < this.mParentView.getLeft() + this.mEdgeSize) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        if (i11 < this.mParentView.getTop() + this.mEdgeSize) {
            i12 |= 4;
        }
        if (i10 > this.mParentView.getRight() - this.mEdgeSize) {
            i12 |= 2;
        }
        if (i11 > this.mParentView.getBottom() - this.mEdgeSize) {
            return i12 | 8;
        }
        return i12;
    }

    private boolean isValidPointerForActionMove(int i10) {
        if (isPointerDown(i10)) {
            return true;
        }
        Log.e(TAG, "Ignoring pointerId=" + i10 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    private void reportNewEdgeDrags(float f10, float f11, int i10) {
        boolean checkNewEdgeDrag = checkNewEdgeDrag(f10, f11, i10, 1);
        if (checkNewEdgeDrag(f11, f10, i10, 4)) {
            checkNewEdgeDrag |= true;
        }
        if (checkNewEdgeDrag(f10, f11, i10, 2)) {
            checkNewEdgeDrag |= true;
        }
        if (checkNewEdgeDrag(f11, f10, i10, 8)) {
            checkNewEdgeDrag |= true;
        }
        if (checkNewEdgeDrag) {
            int[] iArr = this.mEdgeDragsInProgress;
            iArr[i10] = iArr[i10] | checkNewEdgeDrag;
            this.mCallback.onEdgeDragStarted(checkNewEdgeDrag ? 1 : 0, i10);
        }
    }

    private void saveInitialMotion(float f10, float f11, int i10) {
        ensureMotionHistorySizeForId(i10);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[i10] = f10;
        fArr[i10] = f10;
        float[] fArr2 = this.mInitialMotionY;
        this.mLastMotionY[i10] = f11;
        fArr2[i10] = f11;
        this.mInitialEdgesTouched[i10] = getEdgesTouched((int) f10, (int) f11);
        this.mPointersDown |= 1 << i10;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (isValidPointerForActionMove(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.mLastMotionX[pointerId] = x10;
                this.mLastMotionY[pointerId] = y10;
            }
        }
    }

    public void abort() {
        cancel();
        if (this.mDragState == 2) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int currX2 = this.mScroller.getCurrX();
            int currY2 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        setDragState(0);
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(@NonNull View view, boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i15 = i12 + scrollX;
                if (i15 >= childAt.getLeft() && i15 < childAt.getRight() && (i14 = i13 + scrollY) >= childAt.getTop() && i14 < childAt.getBottom()) {
                    if (canScroll(childAt, true, i10, i11, i15 - childAt.getLeft(), i14 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z10 || (!view.canScrollHorizontally(-i10) && !view.canScrollVertically(-i11))) {
            return false;
        }
        return true;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(@NonNull View view, int i10) {
        if (view.getParent() == this.mParentView) {
            this.mCapturedView = view;
            this.mActivePointerId = i10;
            this.mCallback.onViewCaptured(view, i10);
            setDragState(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
    }

    public boolean continueSettling(boolean z10) {
        if (this.mDragState == 2) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.mCapturedView, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.mCapturedView, top);
            }
            if (!(left == 0 && top == 0)) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z10) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    setDragState(0);
                }
            }
        }
        if (this.mDragState == 2) {
            return true;
        }
        return false;
    }

    @Nullable
    public View findTopChildUnder(int i10, int i11) {
        for (int childCount = this.mParentView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i10, int i11, int i12, int i13) {
        if (this.mReleaseInProgress) {
            this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId), i10, i12, i11, i13);
            setDragState(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    @Nullable
    public View getCapturedView() {
        return this.mCapturedView;
    }

    @Px
    public int getDefaultEdgeSize() {
        return this.mDefaultEdgeSize;
    }

    @Px
    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    @Px
    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int i10, int i11) {
        return isViewUnder(this.mCapturedView, i10, i11);
    }

    public boolean isEdgeTouched(int i10) {
        int length = this.mInitialEdgesTouched.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (isEdgeTouched(i10, i11)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i10) {
        if (((1 << i10) & this.mPointersDown) != 0) {
            return true;
        }
        return false;
    }

    public boolean isViewUnder(@Nullable View view, int i10, int i11) {
        if (view != null && i10 >= view.getLeft() && i10 < view.getRight() && i11 >= view.getTop() && i11 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public void processTouchEvent(@NonNull MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i11 = 0;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View findTopChildUnder = findTopChildUnder((int) x10, (int) y10);
            saveInitialMotion(x10, y10, pointerId);
            tryCaptureViewForDrag(findTopChildUnder, pointerId);
            int i12 = this.mInitialEdgesTouched[pointerId];
            int i13 = this.mTrackingEdges;
            if ((i12 & i13) != 0) {
                this.mCallback.onEdgeTouched(i12 & i13, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.mDragState == 1) {
                releaseViewForPointerUp();
            }
            cancel();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.mDragState == 1) {
                    dispatchViewReleased(0.0f, 0.0f);
                }
                cancel();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x11 = motionEvent.getX(actionIndex);
                float y11 = motionEvent.getY(actionIndex);
                saveInitialMotion(x11, y11, pointerId2);
                if (this.mDragState == 0) {
                    tryCaptureViewForDrag(findTopChildUnder((int) x11, (int) y11), pointerId2);
                    int i14 = this.mInitialEdgesTouched[pointerId2];
                    int i15 = this.mTrackingEdges;
                    if ((i14 & i15) != 0) {
                        this.mCallback.onEdgeTouched(i14 & i15, pointerId2);
                    }
                } else if (isCapturedViewUnder((int) x11, (int) y11)) {
                    tryCaptureViewForDrag(this.mCapturedView, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.mDragState == 1 && pointerId3 == this.mActivePointerId) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i11 >= pointerCount) {
                            i10 = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i11);
                        if (pointerId4 != this.mActivePointerId) {
                            View findTopChildUnder2 = findTopChildUnder((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                            View view = this.mCapturedView;
                            if (findTopChildUnder2 == view && tryCaptureViewForDrag(view, pointerId4)) {
                                i10 = this.mActivePointerId;
                                break;
                            }
                        }
                        i11++;
                    }
                    if (i10 == -1) {
                        releaseViewForPointerUp();
                    }
                }
                clearMotionHistory(pointerId3);
            }
        } else if (this.mDragState != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i11 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i11);
                if (isValidPointerForActionMove(pointerId5)) {
                    float x12 = motionEvent.getX(i11);
                    float y12 = motionEvent.getY(i11);
                    float f10 = x12 - this.mInitialMotionX[pointerId5];
                    float f11 = y12 - this.mInitialMotionY[pointerId5];
                    reportNewEdgeDrags(f10, f11, pointerId5);
                    if (this.mDragState != 1) {
                        View findTopChildUnder3 = findTopChildUnder((int) x12, (int) y12);
                        if (checkTouchSlop(findTopChildUnder3, f10, f11) && tryCaptureViewForDrag(findTopChildUnder3, pointerId5)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i11++;
            }
            saveLastMotion(motionEvent);
        } else if (isValidPointerForActionMove(this.mActivePointerId)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
            float x13 = motionEvent.getX(findPointerIndex);
            float y13 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.mLastMotionX;
            int i16 = this.mActivePointerId;
            int i17 = (int) (x13 - fArr[i16]);
            int i18 = (int) (y13 - this.mLastMotionY[i16]);
            dragTo(this.mCapturedView.getLeft() + i17, this.mCapturedView.getTop() + i18, i17, i18);
            saveLastMotion(motionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void setDragState(int i10) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != i10) {
            this.mDragState = i10;
            this.mCallback.onViewDragStateChanged(i10);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeSize(@Px @IntRange(from = 0) int i10) {
        this.mEdgeSize = i10;
    }

    public void setEdgeTrackingEnabled(int i10) {
        this.mTrackingEdges = i10;
    }

    public void setMinVelocity(float f10) {
        this.mMinVelocity = f10;
    }

    public boolean settleCapturedViewAt(int i10, int i11) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i10, i11, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r12 != r11) goto L_0x00e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldInterceptTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r17.getActionMasked()
            int r3 = r17.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r16.cancel()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.mVelocityTracker
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.mVelocityTracker = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.mVelocityTracker
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0104
            if (r2 == r6) goto L_0x00ff
            if (r2 == r4) goto L_0x0070
            r7 = 3
            if (r2 == r7) goto L_0x00ff
            r7 = 5
            if (r2 == r7) goto L_0x003c
            r4 = 6
            if (r2 == r4) goto L_0x0034
        L_0x0031:
            r5 = 0
            goto L_0x0135
        L_0x0034:
            int r1 = r1.getPointerId(r3)
            r0.clearMotionHistory(r1)
            goto L_0x0031
        L_0x003c:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.saveInitialMotion(r7, r1, r2)
            int r3 = r0.mDragState
            if (r3 != 0) goto L_0x0060
            int[] r1 = r0.mInitialEdgesTouched
            r1 = r1[r2]
            int r3 = r0.mTrackingEdges
            r4 = r1 & r3
            if (r4 == 0) goto L_0x0031
            androidx.customview.widget.ViewDragHelper$Callback r4 = r0.mCallback
            r1 = r1 & r3
            r4.onEdgeTouched(r1, r2)
            goto L_0x0031
        L_0x0060:
            if (r3 != r4) goto L_0x0031
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.findTopChildUnder(r3, r1)
            android.view.View r3 = r0.mCapturedView
            if (r1 != r3) goto L_0x0031
            r0.tryCaptureViewForDrag(r1, r2)
            goto L_0x0031
        L_0x0070:
            float[] r2 = r0.mInitialMotionX
            if (r2 == 0) goto L_0x0031
            float[] r2 = r0.mInitialMotionY
            if (r2 != 0) goto L_0x0079
            goto L_0x0031
        L_0x0079:
            int r2 = r17.getPointerCount()
            r3 = 0
        L_0x007e:
            if (r3 >= r2) goto L_0x00fa
            int r4 = r1.getPointerId(r3)
            boolean r7 = r0.isValidPointerForActionMove(r4)
            if (r7 != 0) goto L_0x008c
            goto L_0x00f7
        L_0x008c:
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.mInitialMotionX
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.mInitialMotionY
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.findTopChildUnder(r7, r8)
            if (r7 == 0) goto L_0x00b0
            boolean r8 = r0.checkTouchSlop(r7, r9, r10)
            if (r8 == 0) goto L_0x00b0
            r8 = r6
            goto L_0x00b1
        L_0x00b0:
            r8 = 0
        L_0x00b1:
            if (r8 == 0) goto L_0x00e6
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r13 = r11 + r12
            androidx.customview.widget.ViewDragHelper$Callback r14 = r0.mCallback
            int r12 = r14.clampViewPositionHorizontal(r7, r13, r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r15 = r13 + r14
            androidx.customview.widget.ViewDragHelper$Callback r5 = r0.mCallback
            int r5 = r5.clampViewPositionVertical(r7, r15, r14)
            androidx.customview.widget.ViewDragHelper$Callback r14 = r0.mCallback
            int r14 = r14.getViewHorizontalDragRange(r7)
            androidx.customview.widget.ViewDragHelper$Callback r15 = r0.mCallback
            int r15 = r15.getViewVerticalDragRange(r7)
            if (r14 == 0) goto L_0x00df
            if (r14 <= 0) goto L_0x00e6
            if (r12 != r11) goto L_0x00e6
        L_0x00df:
            if (r15 == 0) goto L_0x00fa
            if (r15 <= 0) goto L_0x00e6
            if (r5 != r13) goto L_0x00e6
            goto L_0x00fa
        L_0x00e6:
            r0.reportNewEdgeDrags(r9, r10, r4)
            int r5 = r0.mDragState
            if (r5 != r6) goto L_0x00ee
            goto L_0x00fa
        L_0x00ee:
            if (r8 == 0) goto L_0x00f7
            boolean r4 = r0.tryCaptureViewForDrag(r7, r4)
            if (r4 == 0) goto L_0x00f7
            goto L_0x00fa
        L_0x00f7:
            int r3 = r3 + 1
            goto L_0x007e
        L_0x00fa:
            r16.saveLastMotion(r17)
            goto L_0x0031
        L_0x00ff:
            r16.cancel()
            goto L_0x0031
        L_0x0104:
            float r2 = r17.getX()
            float r3 = r17.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.saveInitialMotion(r2, r3, r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.findTopChildUnder(r2, r3)
            android.view.View r3 = r0.mCapturedView
            if (r2 != r3) goto L_0x0125
            int r3 = r0.mDragState
            if (r3 != r4) goto L_0x0125
            r0.tryCaptureViewForDrag(r2, r1)
        L_0x0125:
            int[] r2 = r0.mInitialEdgesTouched
            r2 = r2[r1]
            int r3 = r0.mTrackingEdges
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0135
            androidx.customview.widget.ViewDragHelper$Callback r4 = r0.mCallback
            r2 = r2 & r3
            r4.onEdgeTouched(r2, r1)
        L_0x0135:
            int r1 = r0.mDragState
            if (r1 != r6) goto L_0x013a
            r5 = r6
        L_0x013a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean smoothSlideViewTo(@NonNull View view, int i10, int i11) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean forceSettleCapturedViewAt = forceSettleCapturedViewAt(i10, i11, 0, 0);
        if (!forceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return forceSettleCapturedViewAt;
    }

    /* access modifiers changed from: package-private */
    public boolean tryCaptureViewForDrag(View view, int i10) {
        if (view == this.mCapturedView && this.mActivePointerId == i10) {
            return true;
        }
        if (view == null || !this.mCallback.tryCaptureView(view, i10)) {
            return false;
        }
        this.mActivePointerId = i10;
        captureChildView(view, i10);
        return true;
    }

    private float clampMag(float f10, float f11, float f12) {
        float abs = Math.abs(f10);
        if (abs < f11) {
            return 0.0f;
        }
        if (abs > f12) {
            return f10 > 0.0f ? f12 : -f12;
        }
        return f10;
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, float f10, @NonNull Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.mTouchSlop = (int) (((float) create.mTouchSlop) * (1.0f / f10));
        return create;
    }

    public boolean isEdgeTouched(int i10, int i11) {
        return isPointerDown(i11) && (i10 & this.mInitialEdgesTouched[i11]) != 0;
    }

    public boolean checkTouchSlop(int i10) {
        int length = this.mInitialMotionX.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (checkTouchSlop(i10, i11)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i10, int i11) {
        if (!isPointerDown(i11)) {
            return false;
        }
        boolean z10 = (i10 & 1) == 1;
        boolean z11 = (i10 & 2) == 2;
        float f10 = this.mLastMotionX[i11] - this.mInitialMotionX[i11];
        float f11 = this.mLastMotionY[i11] - this.mInitialMotionY[i11];
        if (z10 && z11) {
            int i12 = this.mTouchSlop;
            if ((f10 * f10) + (f11 * f11) > ((float) (i12 * i12))) {
                return true;
            }
            return false;
        } else if (z10) {
            if (Math.abs(f10) > ((float) this.mTouchSlop)) {
                return true;
            }
            return false;
        } else if (!z11 || Math.abs(f11) <= ((float) this.mTouchSlop)) {
            return false;
        } else {
            return true;
        }
    }

    private void clearMotionHistory(int i10) {
        if (this.mInitialMotionX != null && isPointerDown(i10)) {
            this.mInitialMotionX[i10] = 0.0f;
            this.mInitialMotionY[i10] = 0.0f;
            this.mLastMotionX[i10] = 0.0f;
            this.mLastMotionY[i10] = 0.0f;
            this.mInitialEdgesTouched[i10] = 0;
            this.mEdgeDragsInProgress[i10] = 0;
            this.mEdgeDragsLocked[i10] = 0;
            this.mPointersDown = (~(1 << i10)) & this.mPointersDown;
        }
    }
}
