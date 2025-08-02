package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private b mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    protected static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        protected LayoutChunkResult() {
        }

        /* access modifiers changed from: package-private */
        public void resetInternal() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public boolean hasValidAnchor() {
            if (this.mAnchorPosition >= 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
            this.mAnchorLayoutFromEnd = parcel.readInt() != 1 ? false : true;
        }

        @SuppressLint({"UnknownNullness"})
        public SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        OrientationHelper f16208a;

        /* renamed from: b  reason: collision with root package name */
        int f16209b;

        /* renamed from: c  reason: collision with root package name */
        int f16210c;

        /* renamed from: d  reason: collision with root package name */
        boolean f16211d;

        /* renamed from: e  reason: collision with root package name */
        boolean f16212e;

        a() {
            e();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i10;
            if (this.f16211d) {
                i10 = this.f16208a.getEndAfterPadding();
            } else {
                i10 = this.f16208a.getStartAfterPadding();
            }
            this.f16210c = i10;
        }

        public void b(View view, int i10) {
            if (this.f16211d) {
                this.f16210c = this.f16208a.getDecoratedEnd(view) + this.f16208a.getTotalSpaceChange();
            } else {
                this.f16210c = this.f16208a.getDecoratedStart(view);
            }
            this.f16209b = i10;
        }

        public void c(View view, int i10) {
            int totalSpaceChange = this.f16208a.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                b(view, i10);
                return;
            }
            this.f16209b = i10;
            if (this.f16211d) {
                int endAfterPadding = (this.f16208a.getEndAfterPadding() - totalSpaceChange) - this.f16208a.getDecoratedEnd(view);
                this.f16210c = this.f16208a.getEndAfterPadding() - endAfterPadding;
                if (endAfterPadding > 0) {
                    int decoratedMeasurement = this.f16210c - this.f16208a.getDecoratedMeasurement(view);
                    int startAfterPadding = this.f16208a.getStartAfterPadding();
                    int min = decoratedMeasurement - (startAfterPadding + Math.min(this.f16208a.getDecoratedStart(view) - startAfterPadding, 0));
                    if (min < 0) {
                        this.f16210c += Math.min(endAfterPadding, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int decoratedStart = this.f16208a.getDecoratedStart(view);
            int startAfterPadding2 = decoratedStart - this.f16208a.getStartAfterPadding();
            this.f16210c = decoratedStart;
            if (startAfterPadding2 > 0) {
                int endAfterPadding2 = (this.f16208a.getEndAfterPadding() - Math.min(0, (this.f16208a.getEndAfterPadding() - totalSpaceChange) - this.f16208a.getDecoratedEnd(view))) - (decoratedStart + this.f16208a.getDecoratedMeasurement(view));
                if (endAfterPadding2 < 0) {
                    this.f16210c -= Math.min(startAfterPadding2, -endAfterPadding2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (layoutParams.isItemRemoved() || layoutParams.getViewLayoutPosition() < 0 || layoutParams.getViewLayoutPosition() >= state.getItemCount()) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f16209b = -1;
            this.f16210c = Integer.MIN_VALUE;
            this.f16211d = false;
            this.f16212e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f16209b + ", mCoordinate=" + this.f16210c + ", mLayoutFromEnd=" + this.f16211d + ", mValid=" + this.f16212e + '}';
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f16213a = true;

        /* renamed from: b  reason: collision with root package name */
        int f16214b;

        /* renamed from: c  reason: collision with root package name */
        int f16215c;

        /* renamed from: d  reason: collision with root package name */
        int f16216d;

        /* renamed from: e  reason: collision with root package name */
        int f16217e;

        /* renamed from: f  reason: collision with root package name */
        int f16218f;

        /* renamed from: g  reason: collision with root package name */
        int f16219g;

        /* renamed from: h  reason: collision with root package name */
        int f16220h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f16221i = 0;

        /* renamed from: j  reason: collision with root package name */
        boolean f16222j = false;

        /* renamed from: k  reason: collision with root package name */
        int f16223k;

        /* renamed from: l  reason: collision with root package name */
        List f16224l = null;

        /* renamed from: m  reason: collision with root package name */
        boolean f16225m;

        b() {
        }

        private View e() {
            int size = this.f16224l.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = ((RecyclerView.ViewHolder) this.f16224l.get(i10)).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.isItemRemoved() && this.f16216d == layoutParams.getViewLayoutPosition()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b((View) null);
        }

        public void b(View view) {
            View f10 = f(view);
            if (f10 == null) {
                this.f16216d = -1;
            } else {
                this.f16216d = ((RecyclerView.LayoutParams) f10.getLayoutParams()).getViewLayoutPosition();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(RecyclerView.State state) {
            int i10 = this.f16216d;
            if (i10 < 0 || i10 >= state.getItemCount()) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public View d(RecyclerView.Recycler recycler) {
            if (this.f16224l != null) {
                return e();
            }
            View viewForPosition = recycler.getViewForPosition(this.f16216d);
            this.f16216d += this.f16217e;
            return viewForPosition;
        }

        public View f(View view) {
            int viewLayoutPosition;
            int size = this.f16224l.size();
            View view2 = null;
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < size; i11++) {
                View view3 = ((RecyclerView.ViewHolder) this.f16224l.get(i11)).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.isItemRemoved() && (viewLayoutPosition = (layoutParams.getViewLayoutPosition() - this.f16216d) * this.f16217e) >= 0 && viewLayoutPosition < i10) {
                    view2 = view3;
                    if (viewLayoutPosition == 0) {
                        break;
                    }
                    i10 = viewLayoutPosition;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return k.a(state, orientationHelper, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return k.b(state, orientationHelper, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return k.c(state, orientationHelper, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        if (this.mShouldReverseLayout) {
            return findFirstPartiallyOrCompletelyInvisibleChild();
        }
        return findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        if (this.mShouldReverseLayout) {
            return findLastPartiallyOrCompletelyInvisibleChild();
        }
        return findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private int fixLayoutEndGap(int i10, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z10) {
        int endAfterPadding;
        int endAfterPadding2 = this.mOrientationHelper.getEndAfterPadding() - i10;
        if (endAfterPadding2 <= 0) {
            return 0;
        }
        int i11 = -scrollBy(-endAfterPadding2, recycler, state);
        int i12 = i10 + i11;
        if (!z10 || (endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - i12) <= 0) {
            return i11;
        }
        this.mOrientationHelper.offsetChildren(endAfterPadding);
        return endAfterPadding + i11;
    }

    private int fixLayoutStartGap(int i10, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z10) {
        int startAfterPadding;
        int startAfterPadding2 = i10 - this.mOrientationHelper.getStartAfterPadding();
        if (startAfterPadding2 <= 0) {
            return 0;
        }
        int i11 = -scrollBy(startAfterPadding2, recycler, state);
        int i12 = i10 + i11;
        if (!z10 || (startAfterPadding = i12 - this.mOrientationHelper.getStartAfterPadding()) <= 0) {
            return i11;
        }
        this.mOrientationHelper.offsetChildren(-startAfterPadding);
        return i11 - startAfterPadding;
    }

    private View getChildClosestToEnd() {
        int i10;
        if (this.mShouldReverseLayout) {
            i10 = 0;
        } else {
            i10 = getChildCount() - 1;
        }
        return getChildAt(i10);
    }

    private View getChildClosestToStart() {
        int i10;
        if (this.mShouldReverseLayout) {
            i10 = getChildCount() - 1;
        } else {
            i10 = 0;
        }
        return getChildAt(i10);
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler recycler, RecyclerView.State state, int i10, int i11) {
        boolean z10;
        if (state.willRunPredictiveAnimations() && getChildCount() != 0 && !state.isPreLayout() && supportsPredictiveItemAnimations()) {
            List<RecyclerView.ViewHolder> scrapList = recycler.getScrapList();
            int size = scrapList.size();
            int position = getPosition(getChildAt(0));
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < size; i14++) {
                RecyclerView.ViewHolder viewHolder = scrapList.get(i14);
                if (!viewHolder.isRemoved()) {
                    if (viewHolder.getLayoutPosition() < position) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10 != this.mShouldReverseLayout) {
                        i12 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                    } else {
                        i13 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                    }
                }
            }
            this.mLayoutState.f16224l = scrapList;
            if (i12 > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i10);
                b bVar = this.mLayoutState;
                bVar.f16220h = i12;
                bVar.f16215c = 0;
                bVar.a();
                fill(recycler, this.mLayoutState, state, false);
            }
            if (i13 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i11);
                b bVar2 = this.mLayoutState;
                bVar2.f16220h = i13;
                bVar2.f16215c = 0;
                bVar2.a();
                fill(recycler, this.mLayoutState, state, false);
            }
            this.mLayoutState.f16224l = null;
        }
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.getDecoratedStart(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.f16213a && !bVar.f16225m) {
            int i10 = bVar.f16219g;
            int i11 = bVar.f16221i;
            if (bVar.f16218f == -1) {
                recycleViewsFromEnd(recycler, i10, i11);
            } else {
                recycleViewsFromStart(recycler, i10, i11);
            }
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i10, int i11) {
        if (i10 != i11) {
            if (i11 > i10) {
                for (int i12 = i11 - 1; i12 >= i10; i12--) {
                    removeAndRecycleViewAt(i12, recycler);
                }
                return;
            }
            while (i10 > i11) {
                removeAndRecycleViewAt(i10, recycler);
                i10--;
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.Recycler recycler, int i10, int i11) {
        int childCount = getChildCount();
        if (i10 >= 0) {
            int end = (this.mOrientationHelper.getEnd() - i10) + i11;
            if (this.mShouldReverseLayout) {
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt = getChildAt(i12);
                    if (this.mOrientationHelper.getDecoratedStart(childAt) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt) < end) {
                        recycleChildren(recycler, 0, i12);
                        return;
                    }
                }
                return;
            }
            int i13 = childCount - 1;
            for (int i14 = i13; i14 >= 0; i14--) {
                View childAt2 = getChildAt(i14);
                if (this.mOrientationHelper.getDecoratedStart(childAt2) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt2) < end) {
                    recycleChildren(recycler, i13, i14);
                    return;
                }
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.Recycler recycler, int i10, int i11) {
        if (i10 >= 0) {
            int i12 = i10 - i11;
            int childCount = getChildCount();
            if (this.mShouldReverseLayout) {
                int i13 = childCount - 1;
                for (int i14 = i13; i14 >= 0; i14--) {
                    View childAt = getChildAt(i14);
                    if (this.mOrientationHelper.getDecoratedEnd(childAt) > i12 || this.mOrientationHelper.getTransformedEndWithDecoration(childAt) > i12) {
                        recycleChildren(recycler, i13, i14);
                        return;
                    }
                }
                return;
            }
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt2 = getChildAt(i15);
                if (this.mOrientationHelper.getDecoratedEnd(childAt2) > i12 || this.mOrientationHelper.getTransformedEndWithDecoration(childAt2) > i12) {
                    recycleChildren(recycler, 0, i15);
                    return;
                }
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler recycler, RecyclerView.State state, a aVar) {
        View findReferenceChild;
        boolean z10;
        boolean z11 = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild == null || !aVar.d(focusedChild, state)) {
            boolean z12 = this.mLastStackFromEnd;
            boolean z13 = this.mStackFromEnd;
            if (z12 != z13 || (findReferenceChild = findReferenceChild(recycler, state, aVar.f16211d, z13)) == null) {
                return false;
            }
            aVar.b(findReferenceChild, getPosition(findReferenceChild));
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                int decoratedStart = this.mOrientationHelper.getDecoratedStart(findReferenceChild);
                int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(findReferenceChild);
                int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
                int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
                if (decoratedEnd > startAfterPadding || decoratedStart >= startAfterPadding) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (decoratedStart >= endAfterPadding && decoratedEnd > endAfterPadding) {
                    z11 = true;
                }
                if (z10 || z11) {
                    if (aVar.f16211d) {
                        startAfterPadding = endAfterPadding;
                    }
                    aVar.f16210c = startAfterPadding;
                }
            }
            return true;
        }
        aVar.c(focusedChild, getPosition(focusedChild));
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.State state, a aVar) {
        int i10;
        boolean z10;
        int i11;
        boolean z11 = false;
        if (!state.isPreLayout() && (i10 = this.mPendingScrollPosition) != -1) {
            if (i10 < 0 || i10 >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                aVar.f16209b = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.hasValidAnchor()) {
                    boolean z12 = this.mPendingSavedState.mAnchorLayoutFromEnd;
                    aVar.f16211d = z12;
                    if (z12) {
                        aVar.f16210c = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
                    } else {
                        aVar.f16210c = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
                    }
                    return true;
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition == null) {
                        if (getChildCount() > 0) {
                            if (this.mPendingScrollPosition < getPosition(getChildAt(0))) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z10 == this.mShouldReverseLayout) {
                                z11 = true;
                            }
                            aVar.f16211d = z11;
                        }
                        aVar.a();
                    } else if (this.mOrientationHelper.getDecoratedMeasurement(findViewByPosition) > this.mOrientationHelper.getTotalSpace()) {
                        aVar.a();
                        return true;
                    } else if (this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding() < 0) {
                        aVar.f16210c = this.mOrientationHelper.getStartAfterPadding();
                        aVar.f16211d = false;
                        return true;
                    } else if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition) < 0) {
                        aVar.f16210c = this.mOrientationHelper.getEndAfterPadding();
                        aVar.f16211d = true;
                        return true;
                    } else {
                        if (aVar.f16211d) {
                            i11 = this.mOrientationHelper.getDecoratedEnd(findViewByPosition) + this.mOrientationHelper.getTotalSpaceChange();
                        } else {
                            i11 = this.mOrientationHelper.getDecoratedStart(findViewByPosition);
                        }
                        aVar.f16210c = i11;
                    }
                    return true;
                } else {
                    boolean z13 = this.mShouldReverseLayout;
                    aVar.f16211d = z13;
                    if (z13) {
                        aVar.f16210c = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
                    } else {
                        aVar.f16210c = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler recycler, RecyclerView.State state, a aVar) {
        int i10;
        if (!updateAnchorFromPendingData(state, aVar) && !updateAnchorFromChildren(recycler, state, aVar)) {
            aVar.a();
            if (this.mStackFromEnd) {
                i10 = state.getItemCount() - 1;
            } else {
                i10 = 0;
            }
            aVar.f16209b = i10;
        }
    }

    private void updateLayoutState(int i10, int i11, boolean z10, RecyclerView.State state) {
        int i12;
        int i13;
        this.mLayoutState.f16225m = resolveIsInfinite();
        this.mLayoutState.f16218f = i10;
        int[] iArr = this.mReusableIntPair;
        boolean z11 = false;
        iArr[0] = 0;
        int i14 = 1;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        if (i10 == 1) {
            z11 = true;
        }
        b bVar = this.mLayoutState;
        if (z11) {
            i12 = max2;
        } else {
            i12 = max;
        }
        bVar.f16220h = i12;
        if (!z11) {
            max = max2;
        }
        bVar.f16221i = max;
        if (z11) {
            bVar.f16220h = i12 + this.mOrientationHelper.getEndPadding();
            View childClosestToEnd = getChildClosestToEnd();
            b bVar2 = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                i14 = -1;
            }
            bVar2.f16217e = i14;
            int position = getPosition(childClosestToEnd);
            b bVar3 = this.mLayoutState;
            bVar2.f16216d = position + bVar3.f16217e;
            bVar3.f16214b = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
            i13 = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd) - this.mOrientationHelper.getEndAfterPadding();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.f16220h += this.mOrientationHelper.getStartAfterPadding();
            b bVar4 = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i14 = -1;
            }
            bVar4.f16217e = i14;
            int position2 = getPosition(childClosestToStart);
            b bVar5 = this.mLayoutState;
            bVar4.f16216d = position2 + bVar5.f16217e;
            bVar5.f16214b = this.mOrientationHelper.getDecoratedStart(childClosestToStart);
            i13 = (-this.mOrientationHelper.getDecoratedStart(childClosestToStart)) + this.mOrientationHelper.getStartAfterPadding();
        }
        b bVar6 = this.mLayoutState;
        bVar6.f16215c = i11;
        if (z10) {
            bVar6.f16215c = i11 - i13;
        }
        bVar6.f16219g = i13;
    }

    private void updateLayoutStateToFillEnd(a aVar) {
        updateLayoutStateToFillEnd(aVar.f16209b, aVar.f16210c);
    }

    private void updateLayoutStateToFillStart(a aVar) {
        updateLayoutStateToFillStart(aVar.f16209b, aVar.f16210c);
    }

    @SuppressLint({"UnknownNullness"})
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* access modifiers changed from: protected */
    public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
        int i10;
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.mLayoutState.f16218f == -1) {
            i10 = 0;
        } else {
            i10 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i10;
    }

    public boolean canScrollHorizontally() {
        if (this.mOrientation == 0) {
            return true;
        }
        return false;
    }

    public boolean canScrollVertically() {
        if (this.mOrientation == 1) {
            return true;
        }
        return false;
    }

    @SuppressLint({"UnknownNullness"})
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i12;
        if (this.mOrientation != 0) {
            i10 = i11;
        }
        if (getChildCount() != 0 && i10 != 0) {
            ensureLayoutState();
            if (i10 > 0) {
                i12 = 1;
            } else {
                i12 = -1;
            }
            updateLayoutState(i12, Math.abs(i10), true, state);
            collectPrefetchPositionsForLayoutState(state, this.mLayoutState, layoutPrefetchRegistry);
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void collectInitialPrefetchPositions(int i10, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z10;
        int i11;
        SavedState savedState = this.mPendingSavedState;
        int i12 = -1;
        if (savedState == null || !savedState.hasValidAnchor()) {
            resolveShouldLayoutReverse();
            z10 = this.mShouldReverseLayout;
            i11 = this.mPendingScrollPosition;
            if (i11 == -1) {
                if (z10) {
                    i11 = i10 - 1;
                } else {
                    i11 = 0;
                }
            }
        } else {
            SavedState savedState2 = this.mPendingSavedState;
            z10 = savedState2.mAnchorLayoutFromEnd;
            i11 = savedState2.mAnchorPosition;
        }
        if (!z10) {
            i12 = 1;
        }
        for (int i13 = 0; i13 < this.mInitialPrefetchItemCount && i11 >= 0 && i11 < i10; i13++) {
            layoutPrefetchRegistry.addPosition(i11, 0);
            i11 += i12;
        }
    }

    /* access modifiers changed from: package-private */
    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, b bVar, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i10 = bVar.f16216d;
        if (i10 >= 0 && i10 < state.getItemCount()) {
            layoutPrefetchRegistry.addPosition(i10, Math.max(0, bVar.f16219g));
        }
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @SuppressLint({"UnknownNullness"})
    public PointF computeScrollVectorForPosition(int i10) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z10 = false;
        int i11 = 1;
        if (i10 < getPosition(getChildAt(0))) {
            z10 = true;
        }
        if (z10 != this.mShouldReverseLayout) {
            i11 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float) i11, 0.0f);
        }
        return new PointF(0.0f, (float) i11);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    /* access modifiers changed from: package-private */
    public int convertFocusDirectionToLayoutDirection(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 17) {
                    if (i10 != 33) {
                        if (i10 != 66) {
                            if (i10 != 130) {
                                return Integer.MIN_VALUE;
                            }
                            if (this.mOrientation == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        } else if (this.mOrientation == 0) {
                            return 1;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    } else if (this.mOrientation == 1) {
                        return -1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.mOrientation == 0) {
                    return -1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.mOrientation != 1 && isLayoutRTL()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.mOrientation != 1 && isLayoutRTL()) {
            return 1;
        } else {
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public b createLayoutState() {
        return new b();
    }

    /* access modifiers changed from: package-private */
    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    /* access modifiers changed from: package-private */
    public int fill(RecyclerView.Recycler recycler, b bVar, RecyclerView.State state, boolean z10) {
        int i10 = bVar.f16215c;
        int i11 = bVar.f16219g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                bVar.f16219g = i11 + i10;
            }
            recycleByLayoutState(recycler, bVar);
        }
        int i12 = bVar.f16215c + bVar.f16220h;
        LayoutChunkResult layoutChunkResult = this.mLayoutChunkResult;
        while (true) {
            if ((!bVar.f16225m && i12 <= 0) || !bVar.c(state)) {
                break;
            }
            layoutChunkResult.resetInternal();
            layoutChunk(recycler, state, bVar, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                bVar.f16214b += layoutChunkResult.mConsumed * bVar.f16218f;
                if (!layoutChunkResult.mIgnoreConsumed || bVar.f16224l != null || !state.isPreLayout()) {
                    int i13 = bVar.f16215c;
                    int i14 = layoutChunkResult.mConsumed;
                    bVar.f16215c = i13 - i14;
                    i12 -= i14;
                }
                int i15 = bVar.f16219g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + layoutChunkResult.mConsumed;
                    bVar.f16219g = i16;
                    int i17 = bVar.f16215c;
                    if (i17 < 0) {
                        bVar.f16219g = i16 + i17;
                    }
                    recycleByLayoutState(recycler, bVar);
                }
                if (z10 && layoutChunkResult.mFocusable) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - bVar.f16215c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToEnd(boolean z10, boolean z11) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z10, z11);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z10, z11);
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToStart(boolean z10, boolean z11) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z10, z11);
        }
        return findOneVisibleChild(0, getChildCount(), z10, z11);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    /* access modifiers changed from: package-private */
    public View findOnePartiallyOrCompletelyInvisibleChild(int i10, int i11) {
        int i12;
        int i13;
        ensureLayoutState();
        if (i11 <= i10 && i11 >= i10) {
            return getChildAt(i10);
        }
        if (this.mOrientationHelper.getDecoratedStart(getChildAt(i10)) < this.mOrientationHelper.getStartAfterPadding()) {
            i13 = 16644;
            i12 = 16388;
        } else {
            i13 = 4161;
            i12 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i10, i11, i13, i12);
        }
        return this.mVerticalBoundCheck.a(i10, i11, i13, i12);
    }

    /* access modifiers changed from: package-private */
    public View findOneVisibleChild(int i10, int i11, boolean z10, boolean z11) {
        int i12;
        ensureLayoutState();
        int i13 = 320;
        if (z10) {
            i12 = 24579;
        } else {
            i12 = 320;
        }
        if (!z11) {
            i13 = 0;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i10, i11, i12, i13);
        }
        return this.mVerticalBoundCheck.a(i10, i11, i12, i13);
    }

    /* access modifiers changed from: package-private */
    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z10, boolean z11) {
        int i10;
        int i11;
        int i12;
        boolean z12;
        boolean z13;
        ensureLayoutState();
        int childCount = getChildCount();
        if (z11) {
            i12 = getChildCount() - 1;
            i11 = -1;
            i10 = -1;
        } else {
            i11 = childCount;
            i12 = 0;
            i10 = 1;
        }
        int itemCount = state.getItemCount();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i12 != i11) {
            View childAt = getChildAt(i12);
            int position = getPosition(childAt);
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(childAt);
            int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(childAt);
            if (position >= 0 && position < itemCount) {
                if (!((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (decoratedEnd > startAfterPadding || decoratedStart >= startAfterPadding) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (decoratedStart < endAfterPadding || decoratedEnd <= endAfterPadding) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    if (!z12 && !z13) {
                        return childAt;
                    }
                    if (z10) {
                        if (!z13) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                    } else if (!z12) {
                        if (view != null) {
                        }
                        view = childAt;
                    }
                    view2 = childAt;
                } else if (view3 == null) {
                    view3 = childAt;
                }
            }
            i12 += i10;
        }
        if (view != null) {
            return view;
        }
        if (view2 != null) {
            return view2;
        }
        return view3;
    }

    @SuppressLint({"UnknownNullness"})
    public View findViewByPosition(int i10) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i10 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i10) {
                return childAt;
            }
        }
        return super.findViewByPosition(i10);
    }

    @SuppressLint({"UnknownNullness"})
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.State state) {
        if (state.hasTargetScrollPosition()) {
            return this.mOrientationHelper.getTotalSpace();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    /* access modifiers changed from: package-private */
    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, b bVar, LayoutChunkResult layoutChunkResult) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z10;
        boolean z11;
        View d10 = bVar.d(recycler);
        if (d10 == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) d10.getLayoutParams();
        if (bVar.f16224l == null) {
            boolean z12 = this.mShouldReverseLayout;
            if (bVar.f16218f == -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z12 == z11) {
                addView(d10);
            } else {
                addView(d10, 0);
            }
        } else {
            boolean z13 = this.mShouldReverseLayout;
            if (bVar.f16218f == -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z13 == z10) {
                addDisappearingView(d10);
            } else {
                addDisappearingView(d10, 0);
            }
        }
        measureChildWithMargins(d10, 0, 0);
        layoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(d10);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                i14 = getWidth() - getPaddingRight();
                i13 = i14 - this.mOrientationHelper.getDecoratedMeasurementInOther(d10);
            } else {
                i13 = getPaddingLeft();
                i14 = this.mOrientationHelper.getDecoratedMeasurementInOther(d10) + i13;
            }
            if (bVar.f16218f == -1) {
                int i15 = bVar.f16214b;
                i10 = i15;
                i11 = i14;
                i12 = i15 - layoutChunkResult.mConsumed;
            } else {
                int i16 = bVar.f16214b;
                i12 = i16;
                i11 = i14;
                i10 = layoutChunkResult.mConsumed + i16;
            }
        } else {
            int paddingTop = getPaddingTop();
            int decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(d10) + paddingTop;
            if (bVar.f16218f == -1) {
                int i17 = bVar.f16214b;
                i11 = i17;
                i12 = paddingTop;
                i10 = decoratedMeasurementInOther;
                i13 = i17 - layoutChunkResult.mConsumed;
            } else {
                int i18 = bVar.f16214b;
                i12 = paddingTop;
                i11 = layoutChunkResult.mConsumed + i18;
                i10 = decoratedMeasurementInOther;
                i13 = i18;
            }
        }
        layoutDecoratedWithMargins(d10, i13, i12, i11, i10);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = d10.hasFocusable();
    }

    /* access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, a aVar, int i10) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public View onFocusSearchFailed(View view, int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int convertFocusDirectionToLayoutDirection;
        View view2;
        View view3;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (((float) this.mOrientationHelper.getTotalSpace()) * MAX_SCROLL_FACTOR), false, state);
        b bVar = this.mLayoutState;
        bVar.f16219g = Integer.MIN_VALUE;
        bVar.f16213a = false;
        fill(recycler, bVar, state, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            view3 = getChildClosestToStart();
        } else {
            view3 = getChildClosestToEnd();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    @SuppressLint({"UnknownNullness"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int fixLayoutEndGap;
        int i15;
        View findViewByPosition;
        int decoratedStart;
        int i16;
        int i17 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        ensureLayoutState();
        this.mLayoutState.f16213a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        a aVar = this.mAnchorInfo;
        if (!aVar.f16212e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            aVar.e();
            a aVar2 = this.mAnchorInfo;
            aVar2.f16211d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(recycler, state, aVar2);
            this.mAnchorInfo.f16212e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.getDecoratedStart(focusedChild) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(focusedChild) <= this.mOrientationHelper.getStartAfterPadding())) {
            this.mAnchorInfo.c(focusedChild, getPosition(focusedChild));
        }
        b bVar = this.mLayoutState;
        if (bVar.f16223k >= 0) {
            i10 = 1;
        } else {
            i10 = -1;
        }
        bVar.f16218f = i10;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.getStartAfterPadding();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.getEndPadding();
        if (!(!state.isPreLayout() || (i15 = this.mPendingScrollPosition) == -1 || this.mPendingScrollPositionOffset == Integer.MIN_VALUE || (findViewByPosition = findViewByPosition(i15)) == null)) {
            if (this.mShouldReverseLayout) {
                i16 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition);
                decoratedStart = this.mPendingScrollPositionOffset;
            } else {
                decoratedStart = this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding();
                i16 = this.mPendingScrollPositionOffset;
            }
            int i18 = i16 - decoratedStart;
            if (i18 > 0) {
                max += i18;
            } else {
                max2 -= i18;
            }
        }
        a aVar3 = this.mAnchorInfo;
        if (!aVar3.f16211d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i17 = 1;
        }
        onAnchorReady(recycler, state, aVar3, i17);
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.f16225m = resolveIsInfinite();
        this.mLayoutState.f16222j = state.isPreLayout();
        this.mLayoutState.f16221i = 0;
        a aVar4 = this.mAnchorInfo;
        if (aVar4.f16211d) {
            updateLayoutStateToFillStart(aVar4);
            b bVar2 = this.mLayoutState;
            bVar2.f16220h = max;
            fill(recycler, bVar2, state, false);
            b bVar3 = this.mLayoutState;
            i12 = bVar3.f16214b;
            int i19 = bVar3.f16216d;
            int i20 = bVar3.f16215c;
            if (i20 > 0) {
                max2 += i20;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            b bVar4 = this.mLayoutState;
            bVar4.f16220h = max2;
            bVar4.f16216d += bVar4.f16217e;
            fill(recycler, bVar4, state, false);
            b bVar5 = this.mLayoutState;
            i11 = bVar5.f16214b;
            int i21 = bVar5.f16215c;
            if (i21 > 0) {
                updateLayoutStateToFillStart(i19, i12);
                b bVar6 = this.mLayoutState;
                bVar6.f16220h = i21;
                fill(recycler, bVar6, state, false);
                i12 = this.mLayoutState.f16214b;
            }
        } else {
            updateLayoutStateToFillEnd(aVar4);
            b bVar7 = this.mLayoutState;
            bVar7.f16220h = max2;
            fill(recycler, bVar7, state, false);
            b bVar8 = this.mLayoutState;
            i11 = bVar8.f16214b;
            int i22 = bVar8.f16216d;
            int i23 = bVar8.f16215c;
            if (i23 > 0) {
                max += i23;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            b bVar9 = this.mLayoutState;
            bVar9.f16220h = max;
            bVar9.f16216d += bVar9.f16217e;
            fill(recycler, bVar9, state, false);
            b bVar10 = this.mLayoutState;
            i12 = bVar10.f16214b;
            int i24 = bVar10.f16215c;
            if (i24 > 0) {
                updateLayoutStateToFillEnd(i22, i11);
                b bVar11 = this.mLayoutState;
                bVar11.f16220h = i24;
                fill(recycler, bVar11, state, false);
                i11 = this.mLayoutState.f16214b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap2 = fixLayoutEndGap(i11, recycler, state, true);
                i13 = i12 + fixLayoutEndGap2;
                i14 = i11 + fixLayoutEndGap2;
                fixLayoutEndGap = fixLayoutStartGap(i13, recycler, state, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i12, recycler, state, true);
                i13 = i12 + fixLayoutStartGap;
                i14 = i11 + fixLayoutStartGap;
                fixLayoutEndGap = fixLayoutEndGap(i14, recycler, state, false);
            }
            i12 = i13 + fixLayoutEndGap;
            i11 = i14 + fixLayoutEndGap;
        }
        layoutForPredictiveAnimations(recycler, state, i12, i11);
        if (!state.isPreLayout()) {
            this.mOrientationHelper.onLayoutComplete();
        } else {
            this.mAnchorInfo.e();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @SuppressLint({"UnknownNullness"})
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.e();
    }

    @SuppressLint({"UnknownNullness"})
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.invalidateAnchor();
            }
            requestLayout();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z10 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.mAnchorLayoutFromEnd = z10;
            if (z10) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
                savedState.mAnchorPosition = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState.mAnchorPosition = getPosition(childClosestToStart);
                savedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart) - this.mOrientationHelper.getStartAfterPadding();
            }
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    public void prepareForDrop(@NonNull View view, @NonNull View view2, int i10, int i11) {
        boolean z10;
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        if (position < position2) {
            z10 = true;
        } else {
            z10 = true;
        }
        if (this.mShouldReverseLayout) {
            if (z10) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(view2) + this.mOrientationHelper.getDecoratedMeasurement(view)));
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view2));
            }
        } else if (z10) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedEnd(view2) - this.mOrientationHelper.getDecoratedMeasurement(view));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean resolveIsInfinite() {
        if (this.mOrientationHelper.getMode() == 0 && this.mOrientationHelper.getEnd() == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int scrollBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i11;
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f16213a = true;
        if (i10 > 0) {
            i11 = 1;
        } else {
            i11 = -1;
        }
        int abs = Math.abs(i10);
        updateLayoutState(i11, abs, true, state);
        b bVar = this.mLayoutState;
        int fill = bVar.f16219g + fill(recycler, bVar, state, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i10 = i11 * fill;
        }
        this.mOrientationHelper.offsetChildren(-i10);
        this.mLayoutState.f16223k = i10;
        return i10;
    }

    @SuppressLint({"UnknownNullness"})
    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i10, recycler, state);
    }

    public void scrollToPosition(int i10) {
        this.mPendingScrollPosition = i10;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i10, int i11) {
        this.mPendingScrollPosition = i10;
        this.mPendingScrollPositionOffset = i11;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @SuppressLint({"UnknownNullness"})
    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i10, recycler, state);
    }

    public void setInitialPrefetchItemCount(int i10) {
        this.mInitialPrefetchItemCount = i10;
    }

    public void setOrientation(int i10) {
        if (i10 == 0 || i10 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i10 != this.mOrientation || this.mOrientationHelper == null) {
                OrientationHelper createOrientationHelper = OrientationHelper.createOrientationHelper(this, i10);
                this.mOrientationHelper = createOrientationHelper;
                this.mAnchorInfo.f16208a = createOrientationHelper;
                this.mOrientation = i10;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i10);
    }

    public void setRecycleChildrenOnDetach(boolean z10) {
        this.mRecycleChildrenOnDetach = z10;
    }

    public void setReverseLayout(boolean z10) {
        assertNotInLayoutOrScroll((String) null);
        if (z10 != this.mReverseLayout) {
            this.mReverseLayout = z10;
            requestLayout();
        }
    }

    public void setSmoothScrollbarEnabled(boolean z10) {
        this.mSmoothScrollbarEnabled = z10;
    }

    public void setStackFromEnd(boolean z10) {
        assertNotInLayoutOrScroll((String) null);
        if (this.mStackFromEnd != z10) {
            this.mStackFromEnd = z10;
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldMeasureTwice() {
        if (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) {
            return false;
        }
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i10);
        startSmoothScroll(linearSmoothScroller);
    }

    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        boolean z10 = true;
        if (getChildCount() >= 1) {
            int position = getPosition(getChildAt(0));
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
            if (this.mShouldReverseLayout) {
                int i10 = 1;
                while (i10 < getChildCount()) {
                    View childAt = getChildAt(i10);
                    int position2 = getPosition(childAt);
                    int decoratedStart2 = this.mOrientationHelper.getDecoratedStart(childAt);
                    if (position2 < position) {
                        logChildren();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("detected invalid position. loc invalid? ");
                        if (decoratedStart2 >= decoratedStart) {
                            z10 = false;
                        }
                        sb2.append(z10);
                        throw new RuntimeException(sb2.toString());
                    } else if (decoratedStart2 <= decoratedStart) {
                        i10++;
                    } else {
                        logChildren();
                        throw new RuntimeException("detected invalid location");
                    }
                }
                return;
            }
            int i11 = 1;
            while (i11 < getChildCount()) {
                View childAt2 = getChildAt(i11);
                int position3 = getPosition(childAt2);
                int decoratedStart3 = this.mOrientationHelper.getDecoratedStart(childAt2);
                if (position3 < position) {
                    logChildren();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("detected invalid position. loc invalid? ");
                    if (decoratedStart3 >= decoratedStart) {
                        z10 = false;
                    }
                    sb3.append(z10);
                    throw new RuntimeException(sb3.toString());
                } else if (decoratedStart3 >= decoratedStart) {
                    i11++;
                } else {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
        }
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context, int i10, boolean z10) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i10);
        setReverseLayout(z10);
    }

    private void updateLayoutStateToFillEnd(int i10, int i11) {
        this.mLayoutState.f16215c = this.mOrientationHelper.getEndAfterPadding() - i11;
        b bVar = this.mLayoutState;
        bVar.f16217e = this.mShouldReverseLayout ? -1 : 1;
        bVar.f16216d = i10;
        bVar.f16218f = 1;
        bVar.f16214b = i11;
        bVar.f16219g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int i10, int i11) {
        this.mLayoutState.f16215c = i11 - this.mOrientationHelper.getStartAfterPadding();
        b bVar = this.mLayoutState;
        bVar.f16216d = i10;
        bVar.f16217e = this.mShouldReverseLayout ? 1 : -1;
        bVar.f16218f = -1;
        bVar.f16214b = i11;
        bVar.f16219g = Integer.MIN_VALUE;
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i10, i11);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
    }
}
