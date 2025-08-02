package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets = new Rect();
    boolean mPendingSpanCountChange = false;
    final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
    final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
    View[] mSet;
    int mSpanCount = -1;
    SpanSizeLookup mSpanSizeLookup = new DefaultSpanSizeLookup();
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public int getSpanIndex(int i10, int i11) {
            return i10 % i11;
        }

        public int getSpanSize(int i10) {
            return 1;
        }
    }

    public static abstract class SpanSizeLookup {
        private boolean mCacheSpanGroupIndices = false;
        private boolean mCacheSpanIndices = false;
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        final SparseIntArray mSpanIndexCache = new SparseIntArray();

        static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i10) {
            int size = sparseIntArray.size() - 1;
            int i11 = 0;
            while (i11 <= size) {
                int i12 = (i11 + size) >>> 1;
                if (sparseIntArray.keyAt(i12) < i10) {
                    i11 = i12 + 1;
                } else {
                    size = i12 - 1;
                }
            }
            int i13 = i11 - 1;
            if (i13 < 0 || i13 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i13);
        }

        /* access modifiers changed from: package-private */
        public int getCachedSpanGroupIndex(int i10, int i11) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i10, i11);
            }
            int i12 = this.mSpanGroupIndexCache.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int spanGroupIndex = getSpanGroupIndex(i10, i11);
            this.mSpanGroupIndexCache.put(i10, spanGroupIndex);
            return spanGroupIndex;
        }

        /* access modifiers changed from: package-private */
        public int getCachedSpanIndex(int i10, int i11) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i10, i11);
            }
            int i12 = this.mSpanIndexCache.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int spanIndex = getSpanIndex(i10, i11);
            this.mSpanIndexCache.put(i10, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i10, int i11) {
            int i12;
            int i13;
            int i14;
            int findFirstKeyLessThan;
            if (!this.mCacheSpanGroupIndices || (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i10)) == -1) {
                i14 = 0;
                i13 = 0;
                i12 = 0;
            } else {
                i14 = this.mSpanGroupIndexCache.get(findFirstKeyLessThan);
                i13 = findFirstKeyLessThan + 1;
                i12 = getCachedSpanIndex(findFirstKeyLessThan, i11) + getSpanSize(findFirstKeyLessThan);
                if (i12 == i11) {
                    i14++;
                    i12 = 0;
                }
            }
            int spanSize = getSpanSize(i10);
            while (i13 < i10) {
                int spanSize2 = getSpanSize(i13);
                int i15 = i12 + spanSize2;
                if (i15 == i11) {
                    i14++;
                    i15 = 0;
                } else if (i15 > i11) {
                    i14++;
                    i15 = spanSize2;
                }
                i13++;
            }
            if (i12 + spanSize > i11) {
                return i14 + 1;
            }
            return i14;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getSpanIndex(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.getSpanSize(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.mCacheSpanIndices
                if (r2 == 0) goto L_0x0020
                android.util.SparseIntArray r2 = r5.mSpanIndexCache
                int r2 = findFirstKeyLessThan(r2, r6)
                if (r2 < 0) goto L_0x0020
                android.util.SparseIntArray r3 = r5.mSpanIndexCache
                int r3 = r3.get(r2)
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                goto L_0x0030
            L_0x0020:
                r2 = r1
                r3 = r2
            L_0x0022:
                if (r2 >= r6) goto L_0x0033
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x002d
                r3 = r1
                goto L_0x0030
            L_0x002d:
                if (r3 <= r7) goto L_0x0030
                r3 = r4
            L_0x0030:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0033:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x0037
                return r3
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i10);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z10) {
            if (!z10) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z10;
        }

        public void setSpanIndexCacheEnabled(boolean z10) {
            if (!z10) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z10;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        setSpanCount(RecyclerView.LayoutManager.getProperties(context, attributeSet, i10, i11).spanCount);
    }

    private void assignSpans(RecyclerView.Recycler recycler, RecyclerView.State state, int i10, boolean z10) {
        int i11;
        int i12;
        int i13;
        int i14 = 0;
        if (z10) {
            i13 = 1;
            i11 = i10;
            i12 = 0;
        } else {
            i12 = i10 - 1;
            i11 = -1;
            i13 = -1;
        }
        while (i12 != i11) {
            View view = this.mSet[i12];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int spanSize = getSpanSize(recycler, state, getPosition(view));
            layoutParams.mSpanSize = spanSize;
            layoutParams.mSpanIndex = i14;
            i14 += spanSize;
            i12 += i13;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i10).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, layoutParams.getSpanSize());
            this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, layoutParams.getSpanIndex());
        }
    }

    private void calculateItemBorders(int i10) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i10);
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.State state) {
        int i10;
        if (!(getChildCount() == 0 || state.getItemCount() == 0)) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                int cachedSpanGroupIndex2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount);
                int min = Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int max = Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int cachedSpanGroupIndex3 = this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
                if (this.mShouldReverseLayout) {
                    i10 = Math.max(0, (cachedSpanGroupIndex3 - max) - 1);
                } else {
                    i10 = Math.max(0, min);
                }
                if (!isSmoothScrollbarEnabled) {
                    return i10;
                }
                return Math.round((((float) i10) * (((float) Math.abs(this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart))) / ((float) ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount)) + 1)))) + ((float) (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart))));
            }
        }
        return 0;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.State state) {
        if (!(getChildCount() == 0 || state.getItemCount() == 0)) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
                }
                int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart);
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                return (int) ((((float) decoratedEnd) / ((float) ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - cachedSpanGroupIndex) + 1))) * ((float) (this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1)));
            }
        }
        return 0;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.a aVar, int i10) {
        boolean z10;
        if (i10 == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        int spanIndex = getSpanIndex(recycler, state, aVar.f16209b);
        if (z10) {
            while (spanIndex > 0) {
                int i11 = aVar.f16209b;
                if (i11 > 0) {
                    int i12 = i11 - 1;
                    aVar.f16209b = i12;
                    spanIndex = getSpanIndex(recycler, state, i12);
                } else {
                    return;
                }
            }
            return;
        }
        int itemCount = state.getItemCount() - 1;
        int i13 = aVar.f16209b;
        while (i13 < itemCount) {
            int i14 = i13 + 1;
            int spanIndex2 = getSpanIndex(recycler, state, i14);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i13 = i14;
            spanIndex = spanIndex2;
        }
        aVar.f16209b = i13;
    }

    private void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    private int getSpanGroupIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i10) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(i10, this.mSpanCount);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i10);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. " + i10);
        return 0;
    }

    private int getSpanIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i10) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i10, this.mSpanCount);
        }
        int i11 = this.mPreLayoutSpanIndexCache.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i10);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i10);
        return 0;
    }

    private int getSpanSize(RecyclerView.Recycler recycler, RecyclerView.State state, int i10) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(i10);
        }
        int i11 = this.mPreLayoutSpanSizeCache.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i10);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getSpanSize(convertPreLayoutPositionToPostLayout);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i10);
        return 1;
    }

    private void guessMeasurement(float f10, int i10) {
        calculateItemBorders(Math.max(Math.round(f10 * ((float) this.mSpanCount)), i10));
    }

    private void measureChild(View view, int i10, boolean z10) {
        int i11;
        int i12;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i13 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i14 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
        if (this.mOrientation == 1) {
            i11 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i10, i14, layoutParams.width, false);
            i12 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i13, layoutParams.height, true);
        } else {
            int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i10, i13, layoutParams.height, false);
            int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i14, layoutParams.width, true);
            i12 = childMeasureSpec;
            i11 = childMeasureSpec2;
        }
        measureChildWithDecorationsAndMargin(view, i11, i12, z10);
    }

    private void measureChildWithDecorationsAndMargin(View view, int i10, int i11, boolean z10) {
        boolean z11;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z10) {
            z11 = shouldReMeasureChild(view, i10, i11, layoutParams);
        } else {
            z11 = shouldMeasureChild(view, i10, i11, layoutParams);
        }
        if (z11) {
            view.measure(i10, i11);
        }
    }

    private void updateMeasurements() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        calculateItemBorders(height - paddingTop);
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.b bVar, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i10 = this.mSpanCount;
        for (int i11 = 0; i11 < this.mSpanCount && bVar.c(state) && i10 > 0; i11++) {
            int i12 = bVar.f16216d;
            layoutPrefetchRegistry.addPosition(i12, Math.max(0, bVar.f16219g));
            i10 -= this.mSpanSizeLookup.getSpanSize(i12);
            bVar.f16216d += bVar.f16217e;
        }
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(state);
        }
        return super.computeHorizontalScrollOffset(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(state);
        }
        return super.computeHorizontalScrollRange(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(state);
        }
        return super.computeVerticalScrollOffset(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(state);
        }
        return super.computeVerticalScrollRange(state);
    }

    /* access modifiers changed from: package-private */
    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z10, boolean z11) {
        int i10;
        int i11;
        int childCount = getChildCount();
        int i12 = 1;
        if (z11) {
            i11 = getChildCount() - 1;
            i10 = -1;
            i12 = -1;
        } else {
            i10 = childCount;
            i11 = 0;
        }
        int itemCount = state.getItemCount();
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        View view = null;
        View view2 = null;
        while (i11 != i10) {
            View childAt = getChildAt(i11);
            int position = getPosition(childAt);
            if (position >= 0 && position < itemCount && getSpanIndex(recycler, state, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i11 += i12;
        }
        if (view != null) {
            return view;
        }
        return view2;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    /* access modifiers changed from: package-private */
    public int getSpaceForSpanRange(int i10, int i11) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i11 + i10] - iArr[i10];
        }
        int[] iArr2 = this.mCachedBorders;
        int i12 = this.mSpanCount;
        return iArr2[i12 - i10] - iArr2[(i12 - i10) - i11];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    /* access modifiers changed from: package-private */
    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.b bVar, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        boolean z10;
        int i10;
        boolean z11;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        View d10;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        LinearLayoutManager.b bVar2 = bVar;
        LinearLayoutManager.LayoutChunkResult layoutChunkResult2 = layoutChunkResult;
        int modeInOther = this.mOrientationHelper.getModeInOther();
        if (modeInOther != 1073741824) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getChildCount() > 0) {
            i10 = this.mCachedBorders[this.mSpanCount];
        } else {
            i10 = 0;
        }
        if (z10) {
            updateMeasurements();
        }
        if (bVar2.f16217e == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i24 = this.mSpanCount;
        if (!z11) {
            i24 = getSpanIndex(recycler2, state2, bVar2.f16216d) + getSpanSize(recycler2, state2, bVar2.f16216d);
        }
        int i25 = 0;
        while (i25 < this.mSpanCount && bVar2.c(state2) && i24 > 0) {
            int i26 = bVar2.f16216d;
            int spanSize = getSpanSize(recycler2, state2, i26);
            if (spanSize <= this.mSpanCount) {
                i24 -= spanSize;
                if (i24 < 0 || (d10 = bVar2.d(recycler2)) == null) {
                    break;
                }
                this.mSet[i25] = d10;
                i25++;
            } else {
                throw new IllegalArgumentException("Item at position " + i26 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
            }
        }
        if (i25 == 0) {
            layoutChunkResult2.mFinished = true;
            return;
        }
        assignSpans(recycler2, state2, i25, z11);
        float f10 = 0.0f;
        int i27 = 0;
        for (int i28 = 0; i28 < i25; i28++) {
            View view = this.mSet[i28];
            if (bVar2.f16224l == null) {
                if (z11) {
                    addView(view);
                } else {
                    addView(view, 0);
                }
            } else if (z11) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, 0);
            }
            calculateItemDecorationsForChild(view, this.mDecorInsets);
            measureChild(view, modeInOther, false);
            int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view);
            if (decoratedMeasurement > i27) {
                i27 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther = (((float) this.mOrientationHelper.getDecoratedMeasurementInOther(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).mSpanSize);
            if (decoratedMeasurementInOther > f10) {
                f10 = decoratedMeasurementInOther;
            }
        }
        if (z10) {
            guessMeasurement(f10, i10);
            i27 = 0;
            for (int i29 = 0; i29 < i25; i29++) {
                View view2 = this.mSet[i29];
                measureChild(view2, 1073741824, true);
                int decoratedMeasurement2 = this.mOrientationHelper.getDecoratedMeasurement(view2);
                if (decoratedMeasurement2 > i27) {
                    i27 = decoratedMeasurement2;
                }
            }
        }
        for (int i30 = 0; i30 < i25; i30++) {
            View view3 = this.mSet[i30];
            if (this.mOrientationHelper.getDecoratedMeasurement(view3) != i27) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.mDecorInsets;
                int i31 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i32 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
                if (this.mOrientation == 1) {
                    i23 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i32, layoutParams.width, false);
                    i22 = View.MeasureSpec.makeMeasureSpec(i27 - i31, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i27 - i32, 1073741824);
                    i22 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i31, layoutParams.height, false);
                    i23 = makeMeasureSpec;
                }
                measureChildWithDecorationsAndMargin(view3, i23, i22, true);
            }
        }
        layoutChunkResult2.mConsumed = i27;
        if (this.mOrientation == 1) {
            if (bVar2.f16218f == -1) {
                i14 = bVar2.f16214b;
                i21 = i14 - i27;
            } else {
                i21 = bVar2.f16214b;
                i14 = i21 + i27;
            }
            i11 = i21;
            i13 = 0;
            i12 = 0;
        } else {
            if (bVar2.f16218f == -1) {
                i20 = bVar2.f16214b;
                i19 = i20 - i27;
            } else {
                i19 = bVar2.f16214b;
                i20 = i19 + i27;
            }
            i12 = i19;
            i11 = 0;
            i13 = i20;
            i14 = 0;
        }
        int i33 = 0;
        while (i33 < i25) {
            View view4 = this.mSet[i33];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - layoutParams2.mSpanIndex];
                    i18 = i14;
                    i17 = paddingLeft;
                    i16 = paddingLeft - this.mOrientationHelper.getDecoratedMeasurementInOther(view4);
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.mCachedBorders[layoutParams2.mSpanIndex];
                    i18 = i14;
                    i16 = paddingLeft2;
                    i17 = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingLeft2;
                }
                i15 = i11;
            } else {
                int paddingTop = getPaddingTop() + this.mCachedBorders[layoutParams2.mSpanIndex];
                i15 = paddingTop;
                i17 = i13;
                i16 = i12;
                i18 = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingTop;
            }
            layoutDecoratedWithMargins(view4, i16, i15, i17, i18);
            if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                layoutChunkResult2.mIgnoreConsumed = true;
            }
            layoutChunkResult2.mFocusable |= view4.hasFocusable();
            i33++;
            i14 = i18;
            i13 = i17;
            i12 = i16;
            i11 = i15;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.a aVar, int i10) {
        super.onAnchorReady(recycler, state, aVar, i10);
        updateMeasurements();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            ensureAnchorIsInCorrectSpan(recycler, state, aVar, i10);
        }
        ensureViewSet();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d1, code lost:
        if (r13 == r7) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f1, code lost:
        if (r13 == r10) goto L_0x00f3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.Recycler r26, androidx.recyclerview.widget.RecyclerView.State r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            android.view.View r3 = r23.findContainingItemView(r24)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r5 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r5
            int r6 = r5.mSpanIndex
            int r5 = r5.mSpanSize
            int r5 = r5 + r6
            android.view.View r7 = super.onFocusSearchFailed(r24, r25, r26, r27)
            if (r7 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r7 = r25
            int r7 = r0.convertFocusDirectionToLayoutDirection(r7)
            r9 = 1
            if (r7 != r9) goto L_0x002b
            r7 = r9
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            boolean r10 = r0.mShouldReverseLayout
            r11 = -1
            if (r7 == r10) goto L_0x0039
            int r7 = r23.getChildCount()
            int r7 = r7 - r9
            r10 = r11
            r12 = r10
            goto L_0x0040
        L_0x0039:
            int r7 = r23.getChildCount()
            r10 = r7
            r12 = r9
            r7 = 0
        L_0x0040:
            int r13 = r0.mOrientation
            if (r13 != r9) goto L_0x004c
            boolean r13 = r23.isLayoutRTL()
            if (r13 == 0) goto L_0x004c
            r13 = r9
            goto L_0x004d
        L_0x004c:
            r13 = 0
        L_0x004d:
            int r14 = r0.getSpanGroupIndex(r1, r2, r7)
            r15 = r11
            r16 = r15
            r8 = 0
            r17 = 0
            r11 = r7
            r7 = r4
        L_0x0059:
            if (r11 == r10) goto L_0x0065
            int r9 = r0.getSpanGroupIndex(r1, r2, r11)
            android.view.View r1 = r0.getChildAt(r11)
            if (r1 != r3) goto L_0x0069
        L_0x0065:
            r21 = r7
            goto L_0x0137
        L_0x0069:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0082
            if (r9 == r14) goto L_0x0082
            if (r4 == 0) goto L_0x0074
            goto L_0x0065
        L_0x0074:
            r18 = r3
            r21 = r7
        L_0x0078:
            r19 = r8
            r20 = r10
        L_0x007c:
            r7 = r16
            r8 = r17
            goto L_0x0123
        L_0x0082:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r9
            int r2 = r9.mSpanIndex
            r18 = r3
            int r3 = r9.mSpanSize
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x009a
            if (r2 != r6) goto L_0x009a
            if (r3 != r5) goto L_0x009a
            return r1
        L_0x009a:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00a2
            if (r4 == 0) goto L_0x00aa
        L_0x00a2:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto L_0x00b5
            if (r7 != 0) goto L_0x00b5
        L_0x00aa:
            r21 = r7
        L_0x00ac:
            r19 = r8
            r20 = r10
            r7 = r16
            r8 = r17
            goto L_0x00f3
        L_0x00b5:
            int r19 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r5)
            r21 = r7
            int r7 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00d4
            if (r7 <= r8) goto L_0x00ca
        L_0x00c9:
            goto L_0x00ac
        L_0x00ca:
            if (r7 != r8) goto L_0x0078
            if (r2 <= r15) goto L_0x00d0
            r7 = 1
            goto L_0x00d1
        L_0x00d0:
            r7 = 0
        L_0x00d1:
            if (r13 != r7) goto L_0x0078
            goto L_0x00c9
        L_0x00d4:
            if (r4 != 0) goto L_0x0078
            r19 = r8
            r20 = r10
            r8 = 0
            r10 = 1
            boolean r22 = r0.isViewPartiallyVisible(r1, r8, r10)
            if (r22 == 0) goto L_0x007c
            r8 = r17
            if (r7 <= r8) goto L_0x00e9
            r7 = r16
            goto L_0x00f3
        L_0x00e9:
            if (r7 != r8) goto L_0x0121
            r7 = r16
            if (r2 <= r7) goto L_0x00f0
            goto L_0x00f1
        L_0x00f0:
            r10 = 0
        L_0x00f1:
            if (r13 != r10) goto L_0x0123
        L_0x00f3:
            boolean r10 = r1.hasFocusable()
            if (r10 == 0) goto L_0x010f
            int r4 = r9.mSpanIndex
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r2 = r3 - r2
            r15 = r4
            r16 = r7
            r17 = r8
            r7 = r21
            r4 = r1
            r8 = r2
            goto L_0x012b
        L_0x010f:
            int r7 = r9.mSpanIndex
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r17 = r3 - r2
            r16 = r7
            r8 = r19
            r7 = r1
            goto L_0x012b
        L_0x0121:
            r7 = r16
        L_0x0123:
            r16 = r7
            r17 = r8
            r8 = r19
            r7 = r21
        L_0x012b:
            int r11 = r11 + r12
            r1 = r26
            r2 = r27
            r3 = r18
            r10 = r20
            r9 = 1
            goto L_0x0059
        L_0x0137:
            if (r4 == 0) goto L_0x013a
            goto L_0x013c
        L_0x013a:
            r4 = r21
        L_0x013c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(GridView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), spanGroupIndex, 1, false, false));
            return;
        }
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanGroupIndex, 1, layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), false, false));
    }

    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recycler, state);
        clearPreLayoutSpanMappingCache();
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSpanCountChange = false;
    }

    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i10, recycler, state);
    }

    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i10, recycler, state);
    }

    public void setMeasuredDimension(Rect rect, int i10, int i11) {
        int i12;
        int i13;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i10, i11);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            i13 = RecyclerView.LayoutManager.chooseSize(i11, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            i12 = RecyclerView.LayoutManager.chooseSize(i10, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            i12 = RecyclerView.LayoutManager.chooseSize(i10, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            i13 = RecyclerView.LayoutManager.chooseSize(i11, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i12, i13);
    }

    public void setSpanCount(int i10) {
        if (i10 != this.mSpanCount) {
            this.mPendingSpanCountChange = true;
            if (i10 >= 1) {
                this.mSpanCount = i10;
                this.mSpanSizeLookup.invalidateSpanIndexCache();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i10);
        }
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    public void setStackFromEnd(boolean z10) {
        if (!z10) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z10) {
        this.mUsingSpansToEstimateScrollBarDimensions = z10;
    }

    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState != null || this.mPendingSpanCountChange) {
            return false;
        }
        return true;
    }

    static int[] calculateItemBorders(int[] iArr, int i10, int i11) {
        int i12;
        if (!(iArr != null && iArr.length == i10 + 1 && iArr[iArr.length - 1] == i11)) {
            iArr = new int[(i10 + 1)];
        }
        int i13 = 0;
        iArr[0] = 0;
        int i14 = i11 / i10;
        int i15 = i11 % i10;
        int i16 = 0;
        for (int i17 = 1; i17 <= i10; i17++) {
            i13 += i15;
            if (i13 <= 0 || i10 - i13 >= i15) {
                i12 = i14;
            } else {
                i12 = i14 + 1;
                i13 -= i10;
            }
            i16 += i12;
            iArr[i17] = i16;
        }
        return iArr;
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex = -1;
        int mSpanSize = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public GridLayoutManager(Context context, int i10) {
        super(context);
        setSpanCount(i10);
    }

    public GridLayoutManager(Context context, int i10, int i11, boolean z10) {
        super(context, i11, z10);
        setSpanCount(i10);
    }
}
