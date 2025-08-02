package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SnapHelper extends RecyclerView.OnFlingListener {
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private final RecyclerView.OnScrollListener mScrollListener = new a();

    class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f16249a = false;

        a() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            if (i10 == 0 && this.f16249a) {
                this.f16249a = false;
                SnapHelper.this.snapToTargetExistingView();
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            if (i10 != 0 || i11 != 0) {
                this.f16249a = true;
            }
        }
    }

    class b extends LinearSmoothScroller {
        b(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return SnapHelper.MILLISECONDS_PER_INCH / ((float) displayMetrics.densityDpi);
        }

        /* access modifiers changed from: protected */
        public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            SnapHelper snapHelper = SnapHelper.this;
            RecyclerView recyclerView = snapHelper.mRecyclerView;
            if (recyclerView != null) {
                int[] calculateDistanceToFinalSnap = snapHelper.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), view);
                int i10 = calculateDistanceToFinalSnap[0];
                int i11 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i10), Math.abs(i11)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i10, i11, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        }
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener((RecyclerView.OnFlingListener) null);
    }

    private void setupCallbacks() throws IllegalStateException {
        if (this.mRecyclerView.getOnFlingListener() == null) {
            this.mRecyclerView.addOnScrollListener(this.mScrollListener);
            this.mRecyclerView.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private boolean snapFromFling(@NonNull RecyclerView.LayoutManager layoutManager, int i10, int i11) {
        RecyclerView.SmoothScroller createScroller;
        int findTargetSnapPosition;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (createScroller = createScroller(layoutManager)) == null || (findTargetSnapPosition = findTargetSnapPosition(layoutManager, i10, i11)) == -1) {
            return false;
        }
        createScroller.setTargetPosition(findTargetSnapPosition);
        layoutManager.startSmoothScroll(createScroller);
        return true;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                destroyCallbacks();
            }
            this.mRecyclerView = recyclerView;
            if (recyclerView != null) {
                setupCallbacks();
                this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
                snapToTargetExistingView();
            }
        }
    }

    @Nullable
    public abstract int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view);

    @SuppressLint({"UnknownNullness"})
    public int[] calculateScrollDistance(int i10, int i11) {
        this.mGravityScroller.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    /* access modifiers changed from: protected */
    @Nullable
    public RecyclerView.SmoothScroller createScroller(@NonNull RecyclerView.LayoutManager layoutManager) {
        return createSnapScroller(layoutManager);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    @Nullable
    public LinearSmoothScroller createSnapScroller(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        return new b(this.mRecyclerView.getContext());
    }

    @SuppressLint({"UnknownNullness"})
    @Nullable
    public abstract View findSnapView(RecyclerView.LayoutManager layoutManager);

    @SuppressLint({"UnknownNullness"})
    public abstract int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i10, int i11);

    public boolean onFling(int i10, int i11) {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.mRecyclerView.getMinFlingVelocity();
        if ((Math.abs(i11) > minFlingVelocity || Math.abs(i10) > minFlingVelocity) && snapFromFling(layoutManager, i10, i11)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void snapToTargetExistingView() {
        RecyclerView.LayoutManager layoutManager;
        View findSnapView;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (findSnapView = findSnapView(layoutManager)) != null) {
            int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, findSnapView);
            int i10 = calculateDistanceToFinalSnap[0];
            if (i10 != 0 || calculateDistanceToFinalSnap[1] != 0) {
                this.mRecyclerView.smoothScrollBy(i10, calculateDistanceToFinalSnap[1]);
            }
        }
    }
}
