package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "StaggeredGridLManager";
    public static final int VERTICAL = 1;
    private final b mAnchorInfo = new b();
    private final Runnable mCheckForGapsRunnable = new a();
    private int mFullSizeSpec;
    private int mGapStrategy = 2;
    private boolean mLaidOutInvalidFullSpan = false;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;
    @NonNull
    private final g mLayoutState;
    LazySpanLookup mLazySpanLookup = new LazySpanLookup();
    private int mOrientation;
    private SavedState mPendingSavedState;
    int mPendingScrollPosition = -1;
    int mPendingScrollPositionOffset = Integer.MIN_VALUE;
    private int[] mPrefetchDistances;
    @NonNull
    OrientationHelper mPrimaryOrientation;
    private BitSet mRemainingSpans;
    boolean mReverseLayout = false;
    @NonNull
    OrientationHelper mSecondaryOrientation;
    boolean mShouldReverseLayout = false;
    private int mSizePerSpan;
    private boolean mSmoothScrollbarEnabled = true;
    private int mSpanCount = -1;
    c[] mSpans;
    private final Rect mTmpRect = new Rect();

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        boolean mFullSpan;
        c mSpan;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int getSpanIndex() {
            c cVar = this.mSpan;
            if (cVar == null) {
                return -1;
            }
            return cVar.f16274e;
        }

        public boolean isFullSpan() {
            return this.mFullSpan;
        }

        public void setFullSpan(boolean z10) {
            this.mFullSpan = z10;
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

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean mAnchorLayoutFromEnd;
        int mAnchorPosition;
        List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

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
        public void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        /* access modifiers changed from: package-private */
        public void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
            parcel.writeList(this.mFullSpanItems);
        }

        SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            int readInt = parcel.readInt();
            this.mSpanOffsetsSize = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.mSpanOffsets = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.mSpanLookupSize = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.mSpanLookup = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z10 = false;
            this.mReverseLayout = parcel.readInt() == 1;
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
            this.mLastLayoutRTL = parcel.readInt() == 1 ? true : z10;
            this.mFullSpanItems = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            StaggeredGridLayoutManager.this.checkForGaps();
        }
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        int f16263a;

        /* renamed from: b  reason: collision with root package name */
        int f16264b;

        /* renamed from: c  reason: collision with root package name */
        boolean f16265c;

        /* renamed from: d  reason: collision with root package name */
        boolean f16266d;

        /* renamed from: e  reason: collision with root package name */
        boolean f16267e;

        /* renamed from: f  reason: collision with root package name */
        int[] f16268f;

        b() {
            c();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i10;
            if (this.f16265c) {
                i10 = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            } else {
                i10 = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            }
            this.f16264b = i10;
        }

        /* access modifiers changed from: package-private */
        public void b(int i10) {
            if (this.f16265c) {
                this.f16264b = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding() - i10;
            } else {
                this.f16264b = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding() + i10;
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f16263a = -1;
            this.f16264b = Integer.MIN_VALUE;
            this.f16265c = false;
            this.f16266d = false;
            this.f16267e = false;
            int[] iArr = this.f16268f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(c[] cVarArr) {
            int length = cVarArr.length;
            int[] iArr = this.f16268f;
            if (iArr == null || iArr.length < length) {
                this.f16268f = new int[StaggeredGridLayoutManager.this.mSpans.length];
            }
            for (int i10 = 0; i10 < length; i10++) {
                this.f16268f[i10] = cVarArr[i10].u(Integer.MIN_VALUE);
            }
        }
    }

    class c {

        /* renamed from: a  reason: collision with root package name */
        ArrayList f16270a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        int f16271b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f16272c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        int f16273d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int f16274e;

        c(int i10) {
            this.f16274e = i10;
        }

        /* access modifiers changed from: package-private */
        public void A(int i10) {
            this.f16271b = i10;
            this.f16272c = i10;
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            LayoutParams s10 = s(view);
            s10.mSpan = this;
            this.f16270a.add(view);
            this.f16272c = Integer.MIN_VALUE;
            if (this.f16270a.size() == 1) {
                this.f16271b = Integer.MIN_VALUE;
            }
            if (s10.isItemRemoved() || s10.isItemChanged()) {
                this.f16273d += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(boolean z10, int i10) {
            int i11;
            if (z10) {
                i11 = q(Integer.MIN_VALUE);
            } else {
                i11 = u(Integer.MIN_VALUE);
            }
            e();
            if (i11 != Integer.MIN_VALUE) {
                if (z10 && i11 < StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding()) {
                    return;
                }
                if (z10 || i11 <= StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding()) {
                    if (i10 != Integer.MIN_VALUE) {
                        i11 += i10;
                    }
                    this.f16272c = i11;
                    this.f16271b = i11;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            LazySpanLookup.FullSpanItem f10;
            ArrayList arrayList = this.f16270a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            LayoutParams s10 = s(view);
            this.f16272c = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
            if (s10.mFullSpan && (f10 = StaggeredGridLayoutManager.this.mLazySpanLookup.f(s10.getViewLayoutPosition())) != null && f10.f16259b == 1) {
                this.f16272c += f10.a(this.f16274e);
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            LazySpanLookup.FullSpanItem f10;
            View view = (View) this.f16270a.get(0);
            LayoutParams s10 = s(view);
            this.f16271b = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
            if (s10.mFullSpan && (f10 = StaggeredGridLayoutManager.this.mLazySpanLookup.f(s10.getViewLayoutPosition())) != null && f10.f16259b == -1) {
                this.f16271b -= f10.a(this.f16274e);
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f16270a.clear();
            v();
            this.f16273d = 0;
        }

        public int f() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return n(this.f16270a.size() - 1, -1, true);
            }
            return n(0, this.f16270a.size(), true);
        }

        public int g() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return m(this.f16270a.size() - 1, -1, true);
            }
            return m(0, this.f16270a.size(), true);
        }

        public int h() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return n(this.f16270a.size() - 1, -1, false);
            }
            return n(0, this.f16270a.size(), false);
        }

        public int i() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return n(0, this.f16270a.size(), true);
            }
            return n(this.f16270a.size() - 1, -1, true);
        }

        public int j() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return m(0, this.f16270a.size(), true);
            }
            return m(this.f16270a.size() - 1, -1, true);
        }

        public int k() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return n(0, this.f16270a.size(), false);
            }
            return n(this.f16270a.size() - 1, -1, false);
        }

        /* access modifiers changed from: package-private */
        public int l(int i10, int i11, boolean z10, boolean z11, boolean z12) {
            int i12;
            boolean z13;
            int startAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            if (i11 > i10) {
                i12 = 1;
            } else {
                i12 = -1;
            }
            while (i10 != i11) {
                View view = (View) this.f16270a.get(i10);
                int decoratedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
                boolean z14 = false;
                if (!z12 ? decoratedStart >= endAfterPadding : decoratedStart > endAfterPadding) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (!z12 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                    z14 = true;
                }
                if (z13 && z14) {
                    if (!z10 || !z11) {
                        if (z11) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i10 += i12;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int m(int i10, int i11, boolean z10) {
            return l(i10, i11, false, false, z10);
        }

        /* access modifiers changed from: package-private */
        public int n(int i10, int i11, boolean z10) {
            return l(i10, i11, z10, true, false);
        }

        public int o() {
            return this.f16273d;
        }

        /* access modifiers changed from: package-private */
        public int p() {
            int i10 = this.f16272c;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            c();
            return this.f16272c;
        }

        /* access modifiers changed from: package-private */
        public int q(int i10) {
            int i11 = this.f16272c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f16270a.size() == 0) {
                return i10;
            }
            c();
            return this.f16272c;
        }

        public View r(int i10, int i11) {
            View view = null;
            if (i11 != -1) {
                int size = this.f16270a.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.f16270a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view2) >= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.mReverseLayout && staggeredGridLayoutManager2.getPosition(view2) <= i10) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f16270a.size();
                int i12 = 0;
                while (i12 < size2) {
                    View view3 = (View) this.f16270a.get(i12);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.mReverseLayout && staggeredGridLayoutManager3.getPosition(view3) <= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.mReverseLayout && staggeredGridLayoutManager4.getPosition(view3) >= i10) || !view3.hasFocusable()) {
                        break;
                    }
                    i12++;
                    view = view3;
                }
            }
            return view;
        }

        /* access modifiers changed from: package-private */
        public LayoutParams s(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        public int t() {
            int i10 = this.f16271b;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            d();
            return this.f16271b;
        }

        /* access modifiers changed from: package-private */
        public int u(int i10) {
            int i11 = this.f16271b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f16270a.size() == 0) {
                return i10;
            }
            d();
            return this.f16271b;
        }

        /* access modifiers changed from: package-private */
        public void v() {
            this.f16271b = Integer.MIN_VALUE;
            this.f16272c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void w(int i10) {
            int i11 = this.f16271b;
            if (i11 != Integer.MIN_VALUE) {
                this.f16271b = i11 + i10;
            }
            int i12 = this.f16272c;
            if (i12 != Integer.MIN_VALUE) {
                this.f16272c = i12 + i10;
            }
        }

        /* access modifiers changed from: package-private */
        public void x() {
            int size = this.f16270a.size();
            View view = (View) this.f16270a.remove(size - 1);
            LayoutParams s10 = s(view);
            s10.mSpan = null;
            if (s10.isItemRemoved() || s10.isItemChanged()) {
                this.f16273d -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
            if (size == 1) {
                this.f16271b = Integer.MIN_VALUE;
            }
            this.f16272c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void y() {
            View view = (View) this.f16270a.remove(0);
            LayoutParams s10 = s(view);
            s10.mSpan = null;
            if (this.f16270a.size() == 0) {
                this.f16272c = Integer.MIN_VALUE;
            }
            if (s10.isItemRemoved() || s10.isItemChanged()) {
                this.f16273d -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
            this.f16271b = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void z(View view) {
            LayoutParams s10 = s(view);
            s10.mSpan = this;
            this.f16270a.add(0, view);
            this.f16271b = Integer.MIN_VALUE;
            if (this.f16270a.size() == 1) {
                this.f16272c = Integer.MIN_VALUE;
            }
            if (s10.isItemRemoved() || s10.isItemChanged()) {
                this.f16273d += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i10, i11);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        this.mLayoutState = new g();
        createOrientationHelpers();
    }

    private void appendViewToAllSpans(View view) {
        for (int i10 = this.mSpanCount - 1; i10 >= 0; i10--) {
            this.mSpans[i10].a(view);
        }
    }

    private void applyPendingSavedState(b bVar) {
        int startAfterPadding;
        SavedState savedState = this.mPendingSavedState;
        int i10 = savedState.mSpanOffsetsSize;
        if (i10 > 0) {
            if (i10 == this.mSpanCount) {
                for (int i11 = 0; i11 < this.mSpanCount; i11++) {
                    this.mSpans[i11].e();
                    SavedState savedState2 = this.mPendingSavedState;
                    int i12 = savedState2.mSpanOffsets[i11];
                    if (i12 != Integer.MIN_VALUE) {
                        if (savedState2.mAnchorLayoutFromEnd) {
                            startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                        } else {
                            startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                        }
                        i12 += startAfterPadding;
                    }
                    this.mSpans[i11].A(i12);
                }
            } else {
                savedState.invalidateSpanInfo();
                SavedState savedState3 = this.mPendingSavedState;
                savedState3.mAnchorPosition = savedState3.mVisibleAnchorPosition;
            }
        }
        SavedState savedState4 = this.mPendingSavedState;
        this.mLastLayoutRTL = savedState4.mLastLayoutRTL;
        setReverseLayout(savedState4.mReverseLayout);
        resolveShouldLayoutReverse();
        SavedState savedState5 = this.mPendingSavedState;
        int i13 = savedState5.mAnchorPosition;
        if (i13 != -1) {
            this.mPendingScrollPosition = i13;
            bVar.f16265c = savedState5.mAnchorLayoutFromEnd;
        } else {
            bVar.f16265c = this.mShouldReverseLayout;
        }
        if (savedState5.mSpanLookupSize > 1) {
            LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
            lazySpanLookup.f16256a = savedState5.mSpanLookup;
            lazySpanLookup.f16257b = savedState5.mFullSpanItems;
        }
    }

    private void attachViewToSpans(View view, LayoutParams layoutParams, g gVar) {
        if (gVar.f16371e == 1) {
            if (layoutParams.mFullSpan) {
                appendViewToAllSpans(view);
            } else {
                layoutParams.mSpan.a(view);
            }
        } else if (layoutParams.mFullSpan) {
            prependViewToAllSpans(view);
        } else {
            layoutParams.mSpan.z(view);
        }
    }

    private int calculateScrollDirectionForPosition(int i10) {
        boolean z10;
        if (getChildCount() != 0) {
            if (i10 < getFirstChildPosition()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 != this.mShouldReverseLayout) {
                return -1;
            }
            return 1;
        } else if (this.mShouldReverseLayout) {
            return 1;
        } else {
            return -1;
        }
    }

    private boolean checkSpanForGap(c cVar) {
        if (this.mShouldReverseLayout) {
            if (cVar.p() < this.mPrimaryOrientation.getEndAfterPadding()) {
                ArrayList arrayList = cVar.f16270a;
                return !cVar.s((View) arrayList.get(arrayList.size() - 1)).mFullSpan;
            }
        } else if (cVar.t() > this.mPrimaryOrientation.getStartAfterPadding()) {
            return !cVar.s((View) cVar.f16270a.get(0)).mFullSpan;
        }
        return false;
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return k.a(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return k.b(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return k.c(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int convertFocusDirectionToLayoutDirection(int i10) {
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

    private LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f16260c = new int[this.mSpanCount];
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            fullSpanItem.f16260c[i11] = i10 - this.mSpans[i11].q(i10);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f16260c = new int[this.mSpanCount];
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            fullSpanItem.f16260c[i11] = this.mSpans[i11].u(i10) - i10;
        }
        return fullSpanItem;
    }

    private void createOrientationHelpers() {
        this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r9v5 */
    private int fill(RecyclerView.Recycler recycler, g gVar, RecyclerView.State state) {
        int i10;
        int startAfterPadding;
        int i11;
        boolean z10;
        c cVar;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z11;
        int i16;
        int i17;
        boolean areAllStartsEqual;
        int i18;
        int i19;
        RecyclerView.Recycler recycler2 = recycler;
        g gVar2 = gVar;
        ? r92 = 0;
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        if (this.mLayoutState.f16375i) {
            if (gVar2.f16371e == 1) {
                i10 = Integer.MAX_VALUE;
            } else {
                i10 = Integer.MIN_VALUE;
            }
        } else if (gVar2.f16371e == 1) {
            i10 = gVar2.f16373g + gVar2.f16368b;
        } else {
            i10 = gVar2.f16372f - gVar2.f16368b;
        }
        int i20 = i10;
        updateAllRemainingSpans(gVar2.f16371e, i20);
        if (this.mShouldReverseLayout) {
            startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        } else {
            startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        }
        int i21 = startAfterPadding;
        boolean z12 = false;
        while (gVar.a(state) && (this.mLayoutState.f16375i || !this.mRemainingSpans.isEmpty())) {
            View b10 = gVar2.b(recycler2);
            LayoutParams layoutParams = (LayoutParams) b10.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int g10 = this.mLazySpanLookup.g(viewLayoutPosition);
            if (g10 == -1) {
                z10 = true;
            } else {
                z10 = r92;
            }
            if (z10) {
                if (layoutParams.mFullSpan) {
                    cVar = this.mSpans[r92];
                } else {
                    cVar = getNextSpan(gVar2);
                }
                this.mLazySpanLookup.n(viewLayoutPosition, cVar);
            } else {
                cVar = this.mSpans[g10];
            }
            c cVar2 = cVar;
            layoutParams.mSpan = cVar2;
            if (gVar2.f16371e == 1) {
                addView(b10);
            } else {
                addView(b10, r92);
            }
            measureChildWithDecorationsAndMargin(b10, layoutParams, r92);
            if (gVar2.f16371e == 1) {
                if (layoutParams.mFullSpan) {
                    i19 = getMaxEnd(i21);
                } else {
                    i19 = cVar2.q(i21);
                }
                int decoratedMeasurement = this.mPrimaryOrientation.getDecoratedMeasurement(b10) + i19;
                if (z10 && layoutParams.mFullSpan) {
                    LazySpanLookup.FullSpanItem createFullSpanItemFromEnd = createFullSpanItemFromEnd(i19);
                    createFullSpanItemFromEnd.f16259b = -1;
                    createFullSpanItemFromEnd.f16258a = viewLayoutPosition;
                    this.mLazySpanLookup.a(createFullSpanItemFromEnd);
                }
                i12 = decoratedMeasurement;
                i13 = i19;
            } else {
                if (layoutParams.mFullSpan) {
                    i18 = getMinStart(i21);
                } else {
                    i18 = cVar2.u(i21);
                }
                i13 = i18 - this.mPrimaryOrientation.getDecoratedMeasurement(b10);
                if (z10 && layoutParams.mFullSpan) {
                    LazySpanLookup.FullSpanItem createFullSpanItemFromStart = createFullSpanItemFromStart(i18);
                    createFullSpanItemFromStart.f16259b = 1;
                    createFullSpanItemFromStart.f16258a = viewLayoutPosition;
                    this.mLazySpanLookup.a(createFullSpanItemFromStart);
                }
                i12 = i18;
            }
            if (layoutParams.mFullSpan && gVar2.f16370d == -1) {
                if (z10) {
                    this.mLaidOutInvalidFullSpan = true;
                } else {
                    if (gVar2.f16371e == 1) {
                        areAllStartsEqual = areAllEndsEqual();
                    } else {
                        areAllStartsEqual = areAllStartsEqual();
                    }
                    if (!areAllStartsEqual) {
                        LazySpanLookup.FullSpanItem f10 = this.mLazySpanLookup.f(viewLayoutPosition);
                        if (f10 != null) {
                            f10.f16261d = true;
                        }
                        this.mLaidOutInvalidFullSpan = true;
                    }
                }
            }
            attachViewToSpans(b10, layoutParams, gVar2);
            if (!isLayoutRTL() || this.mOrientation != 1) {
                if (layoutParams.mFullSpan) {
                    i16 = this.mSecondaryOrientation.getStartAfterPadding();
                } else {
                    i16 = (cVar2.f16274e * this.mSizePerSpan) + this.mSecondaryOrientation.getStartAfterPadding();
                }
                i15 = i16;
                i14 = this.mSecondaryOrientation.getDecoratedMeasurement(b10) + i16;
            } else {
                if (layoutParams.mFullSpan) {
                    i17 = this.mSecondaryOrientation.getEndAfterPadding();
                } else {
                    i17 = this.mSecondaryOrientation.getEndAfterPadding() - (((this.mSpanCount - 1) - cVar2.f16274e) * this.mSizePerSpan);
                }
                i14 = i17;
                i15 = i17 - this.mSecondaryOrientation.getDecoratedMeasurement(b10);
            }
            if (this.mOrientation == 1) {
                layoutDecoratedWithMargins(b10, i15, i13, i14, i12);
            } else {
                layoutDecoratedWithMargins(b10, i13, i15, i12, i14);
            }
            if (layoutParams.mFullSpan) {
                updateAllRemainingSpans(this.mLayoutState.f16371e, i20);
            } else {
                updateRemainingSpans(cVar2, this.mLayoutState.f16371e, i20);
            }
            recycle(recycler2, this.mLayoutState);
            if (this.mLayoutState.f16374h && b10.hasFocusable()) {
                if (layoutParams.mFullSpan) {
                    this.mRemainingSpans.clear();
                } else {
                    z11 = false;
                    this.mRemainingSpans.set(cVar2.f16274e, false);
                    r92 = z11;
                    z12 = true;
                }
            }
            z11 = false;
            r92 = z11;
            z12 = true;
        }
        int i22 = r92;
        if (!z12) {
            recycle(recycler2, this.mLayoutState);
        }
        if (this.mLayoutState.f16371e == -1) {
            i11 = this.mPrimaryOrientation.getStartAfterPadding() - getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
        } else {
            i11 = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
        }
        if (i11 > 0) {
            return Math.min(gVar2.f16368b, i11);
        }
        return i22;
    }

    private int findFirstReferenceChildPosition(int i10) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            int position = getPosition(getChildAt(i11));
            if (position >= 0 && position < i10) {
                return position;
            }
        }
        return 0;
    }

    private int findLastReferenceChildPosition(int i10) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i10) {
                return position;
            }
        }
        return 0;
    }

    private void fixEndGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z10) {
        int endAfterPadding;
        int maxEnd = getMaxEnd(Integer.MIN_VALUE);
        if (maxEnd != Integer.MIN_VALUE && (endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - maxEnd) > 0) {
            int i10 = endAfterPadding - (-scrollBy(-endAfterPadding, recycler, state));
            if (z10 && i10 > 0) {
                this.mPrimaryOrientation.offsetChildren(i10);
            }
        }
    }

    private void fixStartGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z10) {
        int startAfterPadding;
        int minStart = getMinStart(Integer.MAX_VALUE);
        if (minStart != Integer.MAX_VALUE && (startAfterPadding = minStart - this.mPrimaryOrientation.getStartAfterPadding()) > 0) {
            int scrollBy = startAfterPadding - scrollBy(startAfterPadding, recycler, state);
            if (z10 && scrollBy > 0) {
                this.mPrimaryOrientation.offsetChildren(-scrollBy);
            }
        }
    }

    private int getMaxEnd(int i10) {
        int q10 = this.mSpans[0].q(i10);
        for (int i11 = 1; i11 < this.mSpanCount; i11++) {
            int q11 = this.mSpans[i11].q(i10);
            if (q11 > q10) {
                q10 = q11;
            }
        }
        return q10;
    }

    private int getMaxStart(int i10) {
        int u10 = this.mSpans[0].u(i10);
        for (int i11 = 1; i11 < this.mSpanCount; i11++) {
            int u11 = this.mSpans[i11].u(i10);
            if (u11 > u10) {
                u10 = u11;
            }
        }
        return u10;
    }

    private int getMinEnd(int i10) {
        int q10 = this.mSpans[0].q(i10);
        for (int i11 = 1; i11 < this.mSpanCount; i11++) {
            int q11 = this.mSpans[i11].q(i10);
            if (q11 < q10) {
                q10 = q11;
            }
        }
        return q10;
    }

    private int getMinStart(int i10) {
        int u10 = this.mSpans[0].u(i10);
        for (int i11 = 1; i11 < this.mSpanCount; i11++) {
            int u11 = this.mSpans[i11].u(i10);
            if (u11 < u10) {
                u10 = u11;
            }
        }
        return u10;
    }

    private c getNextSpan(g gVar) {
        int i10;
        int i11;
        int i12;
        if (preferLastSpan(gVar.f16371e)) {
            i12 = this.mSpanCount - 1;
            i11 = -1;
            i10 = -1;
        } else {
            i11 = this.mSpanCount;
            i12 = 0;
            i10 = 1;
        }
        c cVar = null;
        if (gVar.f16371e == 1) {
            int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
            int i13 = Integer.MAX_VALUE;
            while (i12 != i11) {
                c cVar2 = this.mSpans[i12];
                int q10 = cVar2.q(startAfterPadding);
                if (q10 < i13) {
                    cVar = cVar2;
                    i13 = q10;
                }
                i12 += i10;
            }
            return cVar;
        }
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int i14 = Integer.MIN_VALUE;
        while (i12 != i11) {
            c cVar3 = this.mSpans[i12];
            int u10 = cVar3.u(endAfterPadding);
            if (u10 > i14) {
                cVar = cVar3;
                i14 = u10;
            }
            i12 += i10;
        }
        return cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleUpdate(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.mShouldReverseLayout
            if (r0 == 0) goto L_0x0009
            int r0 = r6.getLastChildPosition()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.getFirstChildPosition()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001b
            if (r7 >= r8) goto L_0x0017
            int r2 = r8 + 1
        L_0x0015:
            r3 = r7
            goto L_0x001e
        L_0x0017:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001e
        L_0x001b:
            int r2 = r7 + r8
            goto L_0x0015
        L_0x001e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.mLazySpanLookup
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003d
            r5 = 2
            if (r9 == r5) goto L_0x0037
            if (r9 == r1) goto L_0x002c
            goto L_0x0042
        L_0x002c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.mLazySpanLookup
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.mLazySpanLookup
            r7.j(r8, r4)
            goto L_0x0042
        L_0x0037:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.mLazySpanLookup
            r9.k(r7, r8)
            goto L_0x0042
        L_0x003d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.mLazySpanLookup
            r9.j(r7, r8)
        L_0x0042:
            if (r2 > r0) goto L_0x0045
            return
        L_0x0045:
            boolean r7 = r6.mShouldReverseLayout
            if (r7 == 0) goto L_0x004e
            int r7 = r6.getFirstChildPosition()
            goto L_0x0052
        L_0x004e:
            int r7 = r6.getLastChildPosition()
        L_0x0052:
            if (r3 > r7) goto L_0x0057
            r6.requestLayout()
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.handleUpdate(int, int, int):void");
    }

    private void measureChildWithDecorationsAndMargin(View view, LayoutParams layoutParams, boolean z10) {
        if (layoutParams.mFullSpan) {
            if (this.mOrientation == 1) {
                measureChildWithDecorationsAndMargin(view, this.mFullSizeSpec, RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true), z10);
            } else {
                measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), this.mFullSizeSpec, z10);
            }
        } else if (this.mOrientation == 1) {
            measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, layoutParams.width, false), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true), z10);
        } else {
            measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, layoutParams.height, false), z10);
        }
    }

    private boolean preferLastSpan(int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        if (this.mOrientation == 0) {
            if (i10 == -1) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12 != this.mShouldReverseLayout) {
                return true;
            }
            return false;
        }
        if (i10 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 == this.mShouldReverseLayout) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 == isLayoutRTL()) {
            return true;
        }
        return false;
    }

    private void prependViewToAllSpans(View view) {
        for (int i10 = this.mSpanCount - 1; i10 >= 0; i10--) {
            this.mSpans[i10].z(view);
        }
    }

    private void recycle(RecyclerView.Recycler recycler, g gVar) {
        int i10;
        int i11;
        if (gVar.f16367a && !gVar.f16375i) {
            if (gVar.f16368b == 0) {
                if (gVar.f16371e == -1) {
                    recycleFromEnd(recycler, gVar.f16373g);
                } else {
                    recycleFromStart(recycler, gVar.f16372f);
                }
            } else if (gVar.f16371e == -1) {
                int i12 = gVar.f16372f;
                int maxStart = i12 - getMaxStart(i12);
                if (maxStart < 0) {
                    i11 = gVar.f16373g;
                } else {
                    i11 = gVar.f16373g - Math.min(maxStart, gVar.f16368b);
                }
                recycleFromEnd(recycler, i11);
            } else {
                int minEnd = getMinEnd(gVar.f16373g) - gVar.f16373g;
                if (minEnd < 0) {
                    i10 = gVar.f16372f;
                } else {
                    i10 = Math.min(minEnd, gVar.f16368b) + gVar.f16372f;
                }
                recycleFromStart(recycler, i10);
            }
        }
    }

    private void recycleFromEnd(RecyclerView.Recycler recycler, int i10) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.mPrimaryOrientation.getDecoratedStart(childAt) >= i10 && this.mPrimaryOrientation.getTransformedStartWithDecoration(childAt) >= i10) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mFullSpan) {
                    int i11 = 0;
                    while (i11 < this.mSpanCount) {
                        if (this.mSpans[i11].f16270a.size() != 1) {
                            i11++;
                        } else {
                            return;
                        }
                    }
                    for (int i12 = 0; i12 < this.mSpanCount; i12++) {
                        this.mSpans[i12].x();
                    }
                } else if (layoutParams.mSpan.f16270a.size() != 1) {
                    layoutParams.mSpan.x();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
                childCount--;
            } else {
                return;
            }
        }
    }

    private void recycleFromStart(RecyclerView.Recycler recycler, int i10) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) <= i10 && this.mPrimaryOrientation.getTransformedEndWithDecoration(childAt) <= i10) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mFullSpan) {
                    int i11 = 0;
                    while (i11 < this.mSpanCount) {
                        if (this.mSpans[i11].f16270a.size() != 1) {
                            i11++;
                        } else {
                            return;
                        }
                    }
                    for (int i12 = 0; i12 < this.mSpanCount; i12++) {
                        this.mSpans[i12].y();
                    }
                } else if (layoutParams.mSpan.f16270a.size() != 1) {
                    layoutParams.mSpan.y();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    private void repositionToWrapContentIfNecessary() {
        if (this.mSecondaryOrientation.getMode() != 1073741824) {
            int childCount = getChildCount();
            float f10 = 0.0f;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                float decoratedMeasurement = (float) this.mSecondaryOrientation.getDecoratedMeasurement(childAt);
                if (decoratedMeasurement >= f10) {
                    if (((LayoutParams) childAt.getLayoutParams()).isFullSpan()) {
                        decoratedMeasurement = (decoratedMeasurement * 1.0f) / ((float) this.mSpanCount);
                    }
                    f10 = Math.max(f10, decoratedMeasurement);
                }
            }
            int i11 = this.mSizePerSpan;
            int round = Math.round(f10 * ((float) this.mSpanCount));
            if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
                round = Math.min(round, this.mSecondaryOrientation.getTotalSpace());
            }
            updateMeasureSpecs(round);
            if (this.mSizePerSpan != i11) {
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt2 = getChildAt(i12);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (!layoutParams.mFullSpan) {
                        if (!isLayoutRTL() || this.mOrientation != 1) {
                            int i13 = layoutParams.mSpan.f16274e;
                            int i14 = this.mSizePerSpan * i13;
                            int i15 = i13 * i11;
                            if (this.mOrientation == 1) {
                                childAt2.offsetLeftAndRight(i14 - i15);
                            } else {
                                childAt2.offsetTopAndBottom(i14 - i15);
                            }
                        } else {
                            int i16 = this.mSpanCount;
                            int i17 = layoutParams.mSpan.f16274e;
                            childAt2.offsetLeftAndRight(((-((i16 - 1) - i17)) * this.mSizePerSpan) - ((-((i16 - 1) - i17)) * i11));
                        }
                    }
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

    private void setLayoutStateDirection(int i10) {
        boolean z10;
        g gVar = this.mLayoutState;
        gVar.f16371e = i10;
        boolean z11 = this.mShouldReverseLayout;
        int i11 = 1;
        if (i10 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z11 != z10) {
            i11 = -1;
        }
        gVar.f16370d = i11;
    }

    private void updateAllRemainingSpans(int i10, int i11) {
        for (int i12 = 0; i12 < this.mSpanCount; i12++) {
            if (!this.mSpans[i12].f16270a.isEmpty()) {
                updateRemainingSpans(this.mSpans[i12], i10, i11);
            }
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.State state, b bVar) {
        int i10;
        if (this.mLastLayoutFromEnd) {
            i10 = findLastReferenceChildPosition(state.getItemCount());
        } else {
            i10 = findFirstReferenceChildPosition(state.getItemCount());
        }
        bVar.f16263a = i10;
        bVar.f16264b = Integer.MIN_VALUE;
        return true;
    }

    private void updateLayoutState(int i10, RecyclerView.State state) {
        int i11;
        int i12;
        int targetScrollPosition;
        boolean z10;
        g gVar = this.mLayoutState;
        boolean z11 = false;
        gVar.f16368b = 0;
        gVar.f16369c = i10;
        if (!isSmoothScrolling() || (targetScrollPosition = state.getTargetScrollPosition()) == -1) {
            i12 = 0;
            i11 = 0;
        } else {
            boolean z12 = this.mShouldReverseLayout;
            if (targetScrollPosition < i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z12 == z10) {
                i12 = this.mPrimaryOrientation.getTotalSpace();
                i11 = 0;
            } else {
                i11 = this.mPrimaryOrientation.getTotalSpace();
                i12 = 0;
            }
        }
        if (getClipToPadding()) {
            this.mLayoutState.f16372f = this.mPrimaryOrientation.getStartAfterPadding() - i11;
            this.mLayoutState.f16373g = this.mPrimaryOrientation.getEndAfterPadding() + i12;
        } else {
            this.mLayoutState.f16373g = this.mPrimaryOrientation.getEnd() + i12;
            this.mLayoutState.f16372f = -i11;
        }
        g gVar2 = this.mLayoutState;
        gVar2.f16374h = false;
        gVar2.f16367a = true;
        if (this.mPrimaryOrientation.getMode() == 0 && this.mPrimaryOrientation.getEnd() == 0) {
            z11 = true;
        }
        gVar2.f16375i = z11;
    }

    private void updateRemainingSpans(c cVar, int i10, int i11) {
        int o10 = cVar.o();
        if (i10 == -1) {
            if (cVar.t() + o10 <= i11) {
                this.mRemainingSpans.set(cVar.f16274e, false);
            }
        } else if (cVar.p() - o10 >= i11) {
            this.mRemainingSpans.set(cVar.f16274e, false);
        }
    }

    private int updateSpecWithExtra(int i10, int i11, int i12) {
        if (i11 == 0 && i12 == 0) {
            return i10;
        }
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i10) - i11) - i12), mode);
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public boolean areAllEndsEqual() {
        int q10 = this.mSpans[0].q(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.mSpanCount; i10++) {
            if (this.mSpans[i10].q(Integer.MIN_VALUE) != q10) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean areAllStartsEqual() {
        int u10 = this.mSpans[0].u(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.mSpanCount; i10++) {
            if (this.mSpans[i10].u(Integer.MIN_VALUE) != u10) {
                return false;
            }
        }
        return true;
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
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

    /* access modifiers changed from: package-private */
    public boolean checkForGaps() {
        int i10;
        int i11;
        int i12;
        if (getChildCount() == 0 || this.mGapStrategy == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.mShouldReverseLayout) {
            i11 = getLastChildPosition();
            i10 = getFirstChildPosition();
        } else {
            i11 = getFirstChildPosition();
            i10 = getLastChildPosition();
        }
        if (i11 == 0 && hasGapsToFix() != null) {
            this.mLazySpanLookup.b();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.mLaidOutInvalidFullSpan) {
            return false;
        } else {
            if (this.mShouldReverseLayout) {
                i12 = -1;
            } else {
                i12 = 1;
            }
            int i13 = i10 + 1;
            LazySpanLookup.FullSpanItem e10 = this.mLazySpanLookup.e(i11, i13, i12, true);
            if (e10 == null) {
                this.mLaidOutInvalidFullSpan = false;
                this.mLazySpanLookup.d(i13);
                return false;
            }
            LazySpanLookup.FullSpanItem e11 = this.mLazySpanLookup.e(i11, e10.f16258a, i12 * -1, true);
            if (e11 == null) {
                this.mLazySpanLookup.d(e10.f16258a);
            } else {
                this.mLazySpanLookup.d(e11.f16258a + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int q10;
        int i12;
        if (this.mOrientation != 0) {
            i10 = i11;
        }
        if (getChildCount() != 0 && i10 != 0) {
            prepareLayoutStateForDelta(i10, state);
            int[] iArr = this.mPrefetchDistances;
            if (iArr == null || iArr.length < this.mSpanCount) {
                this.mPrefetchDistances = new int[this.mSpanCount];
            }
            int i13 = 0;
            for (int i14 = 0; i14 < this.mSpanCount; i14++) {
                g gVar = this.mLayoutState;
                if (gVar.f16370d == -1) {
                    q10 = gVar.f16372f;
                    i12 = this.mSpans[i14].u(q10);
                } else {
                    q10 = this.mSpans[i14].q(gVar.f16373g);
                    i12 = this.mLayoutState.f16373g;
                }
                int i15 = q10 - i12;
                if (i15 >= 0) {
                    this.mPrefetchDistances[i13] = i15;
                    i13++;
                }
            }
            Arrays.sort(this.mPrefetchDistances, 0, i13);
            for (int i16 = 0; i16 < i13 && this.mLayoutState.a(state); i16++) {
                layoutPrefetchRegistry.addPosition(this.mLayoutState.f16369c, this.mPrefetchDistances[i16]);
                g gVar2 = this.mLayoutState;
                gVar2.f16369c += gVar2.f16370d;
            }
        }
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public PointF computeScrollVectorForPosition(int i10) {
        int calculateScrollDirectionForPosition = calculateScrollDirectionForPosition(i10);
        PointF pointF = new PointF();
        if (calculateScrollDirectionForPosition == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = (float) calculateScrollDirectionForPosition;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) calculateScrollDirectionForPosition;
        }
        return pointF;
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i10 = 0; i10 < this.mSpanCount; i10++) {
            iArr[i10] = this.mSpans[i10].f();
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleItemClosestToEnd(boolean z10) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z10) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleItemClosestToStart(boolean z10) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z10) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public int findFirstVisibleItemPositionInt() {
        View view;
        if (this.mShouldReverseLayout) {
            view = findFirstVisibleItemClosestToEnd(true);
        } else {
            view = findFirstVisibleItemClosestToStart(true);
        }
        if (view == null) {
            return -1;
        }
        return getPosition(view);
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i10 = 0; i10 < this.mSpanCount; i10++) {
            iArr[i10] = this.mSpans[i10].h();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i10 = 0; i10 < this.mSpanCount; i10++) {
            iArr[i10] = this.mSpans[i10].i();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i10 = 0; i10 < this.mSpanCount; i10++) {
            iArr[i10] = this.mSpans[i10].k();
        }
        return iArr;
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

    /* access modifiers changed from: package-private */
    public int getFirstChildPosition() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    /* access modifiers changed from: package-private */
    public int getLastChildPosition() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    /* access modifiers changed from: package-private */
    public View hasGapsToFix() {
        char c10;
        int i10;
        boolean z10;
        boolean z11;
        int childCount = getChildCount();
        int i11 = childCount - 1;
        BitSet bitSet = new BitSet(this.mSpanCount);
        bitSet.set(0, this.mSpanCount, true);
        int i12 = -1;
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            c10 = 65535;
        } else {
            c10 = 1;
        }
        if (this.mShouldReverseLayout) {
            childCount = -1;
        } else {
            i11 = 0;
        }
        if (i11 < childCount) {
            i12 = 1;
        }
        while (i11 != childCount) {
            View childAt = getChildAt(i11);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.mSpan.f16274e)) {
                if (checkSpanForGap(layoutParams.mSpan)) {
                    return childAt;
                }
                bitSet.clear(layoutParams.mSpan.f16274e);
            }
            if (!layoutParams.mFullSpan && (i10 = i11 + i12) != childCount) {
                View childAt2 = getChildAt(i10);
                if (this.mShouldReverseLayout) {
                    int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
                    int decoratedEnd2 = this.mPrimaryOrientation.getDecoratedEnd(childAt2);
                    if (decoratedEnd < decoratedEnd2) {
                        return childAt;
                    }
                    if (decoratedEnd != decoratedEnd2) {
                        continue;
                    }
                } else {
                    int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
                    int decoratedStart2 = this.mPrimaryOrientation.getDecoratedStart(childAt2);
                    if (decoratedStart > decoratedStart2) {
                        return childAt;
                    }
                    if (decoratedStart != decoratedStart2) {
                        continue;
                    }
                }
                if (layoutParams.mSpan.f16274e - ((LayoutParams) childAt2.getLayoutParams()).mSpan.f16274e < 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (c10 < 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z10 != z11) {
                    return childAt;
                }
            }
            i11 += i12;
        }
        return null;
    }

    public void invalidateSpanAssignments() {
        this.mLazySpanLookup.b();
        requestLayout();
    }

    public boolean isAutoMeasureEnabled() {
        if (this.mGapStrategy != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public void offsetChildrenHorizontal(int i10) {
        super.offsetChildrenHorizontal(i10);
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            this.mSpans[i11].w(i10);
        }
    }

    public void offsetChildrenVertical(int i10) {
        super.offsetChildrenVertical(i10);
        for (int i11 = 0; i11 < this.mSpanCount; i11++) {
            this.mSpans[i11].w(i10);
        }
    }

    public void onAdapterChanged(@Nullable RecyclerView.Adapter adapter, @Nullable RecyclerView.Adapter adapter2) {
        this.mLazySpanLookup.b();
        for (int i10 = 0; i10 < this.mSpanCount; i10++) {
            this.mSpans[i10].e();
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.mCheckForGapsRunnable);
        for (int i10 = 0; i10 < this.mSpanCount; i10++) {
            this.mSpans[i10].e();
        }
        recyclerView.requestLayout();
    }

    @Nullable
    public View onFocusSearchFailed(View view, int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View findContainingItemView;
        int i11;
        boolean z10;
        boolean z11;
        int i12;
        int i13;
        int i14;
        View r10;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i10);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        boolean z12 = layoutParams.mFullSpan;
        c cVar = layoutParams.mSpan;
        if (convertFocusDirectionToLayoutDirection == 1) {
            i11 = getLastChildPosition();
        } else {
            i11 = getFirstChildPosition();
        }
        updateLayoutState(i11, state);
        setLayoutStateDirection(convertFocusDirectionToLayoutDirection);
        g gVar = this.mLayoutState;
        gVar.f16369c = gVar.f16370d + i11;
        gVar.f16368b = (int) (((float) this.mPrimaryOrientation.getTotalSpace()) * MAX_SCROLL_FACTOR);
        g gVar2 = this.mLayoutState;
        gVar2.f16374h = true;
        gVar2.f16367a = false;
        fill(recycler, gVar2, state);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        if (!z12 && (r10 = cVar.r(i11, convertFocusDirectionToLayoutDirection)) != null && r10 != findContainingItemView) {
            return r10;
        }
        if (preferLastSpan(convertFocusDirectionToLayoutDirection)) {
            for (int i15 = this.mSpanCount - 1; i15 >= 0; i15--) {
                View r11 = this.mSpans[i15].r(i11, convertFocusDirectionToLayoutDirection);
                if (r11 != null && r11 != findContainingItemView) {
                    return r11;
                }
            }
        } else {
            for (int i16 = 0; i16 < this.mSpanCount; i16++) {
                View r12 = this.mSpans[i16].r(i11, convertFocusDirectionToLayoutDirection);
                if (r12 != null && r12 != findContainingItemView) {
                    return r12;
                }
            }
        }
        boolean z13 = !this.mReverseLayout;
        if (convertFocusDirectionToLayoutDirection == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z13 == z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z12) {
            if (z11) {
                i14 = cVar.g();
            } else {
                i14 = cVar.j();
            }
            View findViewByPosition = findViewByPosition(i14);
            if (!(findViewByPosition == null || findViewByPosition == findContainingItemView)) {
                return findViewByPosition;
            }
        }
        if (preferLastSpan(convertFocusDirectionToLayoutDirection)) {
            for (int i17 = this.mSpanCount - 1; i17 >= 0; i17--) {
                if (i17 != cVar.f16274e) {
                    if (z11) {
                        i13 = this.mSpans[i17].g();
                    } else {
                        i13 = this.mSpans[i17].j();
                    }
                    View findViewByPosition2 = findViewByPosition(i13);
                    if (!(findViewByPosition2 == null || findViewByPosition2 == findContainingItemView)) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i18 = 0; i18 < this.mSpanCount; i18++) {
                if (z11) {
                    i12 = this.mSpans[i18].g();
                } else {
                    i12 = this.mSpans[i18].j();
                }
                View findViewByPosition3 = findViewByPosition(i12);
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(false);
            View findFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(false);
            if (findFirstVisibleItemClosestToStart != null && findFirstVisibleItemClosestToEnd != null) {
                int position = getPosition(findFirstVisibleItemClosestToStart);
                int position2 = getPosition(findFirstVisibleItemClosestToEnd);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        handleUpdate(i10, i11, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mLazySpanLookup.b();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        handleUpdate(i10, i11, 8);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        handleUpdate(i10, i11, 2);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
        handleUpdate(i10, i11, 4);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        onLayoutChildren(recycler, state, true);
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.c();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.invalidateAnchorPositionInfo();
                this.mPendingSavedState.invalidateSpanInfo();
            }
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        int i10;
        int i11;
        int startAfterPadding;
        int[] iArr;
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        savedState.mReverseLayout = this.mReverseLayout;
        savedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        savedState.mLastLayoutRTL = this.mLastLayoutRTL;
        LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f16256a) == null) {
            savedState.mSpanLookupSize = 0;
        } else {
            savedState.mSpanLookup = iArr;
            savedState.mSpanLookupSize = iArr.length;
            savedState.mFullSpanItems = lazySpanLookup.f16257b;
        }
        if (getChildCount() > 0) {
            if (this.mLastLayoutFromEnd) {
                i10 = getLastChildPosition();
            } else {
                i10 = getFirstChildPosition();
            }
            savedState.mAnchorPosition = i10;
            savedState.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
            int i12 = this.mSpanCount;
            savedState.mSpanOffsetsSize = i12;
            savedState.mSpanOffsets = new int[i12];
            for (int i13 = 0; i13 < this.mSpanCount; i13++) {
                if (this.mLastLayoutFromEnd) {
                    i11 = this.mSpans[i13].q(Integer.MIN_VALUE);
                    if (i11 != Integer.MIN_VALUE) {
                        startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                    } else {
                        savedState.mSpanOffsets[i13] = i11;
                    }
                } else {
                    i11 = this.mSpans[i13].u(Integer.MIN_VALUE);
                    if (i11 != Integer.MIN_VALUE) {
                        startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                    } else {
                        savedState.mSpanOffsets[i13] = i11;
                    }
                }
                i11 -= startAfterPadding;
                savedState.mSpanOffsets[i13] = i11;
            }
        } else {
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
            savedState.mSpanOffsetsSize = 0;
        }
        return savedState;
    }

    public void onScrollStateChanged(int i10) {
        if (i10 == 0) {
            checkForGaps();
        }
    }

    /* access modifiers changed from: package-private */
    public void prepareLayoutStateForDelta(int i10, RecyclerView.State state) {
        int i11;
        int i12;
        if (i10 > 0) {
            i12 = getLastChildPosition();
            i11 = 1;
        } else {
            i12 = getFirstChildPosition();
            i11 = -1;
        }
        this.mLayoutState.f16367a = true;
        updateLayoutState(i12, state);
        setLayoutStateDirection(i11);
        g gVar = this.mLayoutState;
        gVar.f16369c = i12 + gVar.f16370d;
        gVar.f16368b = Math.abs(i10);
    }

    /* access modifiers changed from: package-private */
    public int scrollBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        prepareLayoutStateForDelta(i10, state);
        int fill = fill(recycler, this.mLayoutState, state);
        if (this.mLayoutState.f16368b >= fill) {
            if (i10 < 0) {
                i10 = -fill;
            } else {
                i10 = fill;
            }
        }
        this.mPrimaryOrientation.offsetChildren(-i10);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        g gVar = this.mLayoutState;
        gVar.f16368b = 0;
        recycle(recycler, gVar);
        return i10;
    }

    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i10, recycler, state);
    }

    public void scrollToPosition(int i10) {
        SavedState savedState = this.mPendingSavedState;
        if (!(savedState == null || savedState.mAnchorPosition == i10)) {
            savedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i10;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i10, int i11) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i10;
        this.mPendingScrollPositionOffset = i11;
        requestLayout();
    }

    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i10, recycler, state);
    }

    public void setGapStrategy(int i10) {
        assertNotInLayoutOrScroll((String) null);
        if (i10 != this.mGapStrategy) {
            if (i10 == 0 || i10 == 2) {
                this.mGapStrategy = i10;
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
    }

    public void setMeasuredDimension(Rect rect, int i10, int i11) {
        int i12;
        int i13;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            i13 = RecyclerView.LayoutManager.chooseSize(i11, rect.height() + paddingTop, getMinimumHeight());
            i12 = RecyclerView.LayoutManager.chooseSize(i10, (this.mSizePerSpan * this.mSpanCount) + paddingLeft, getMinimumWidth());
        } else {
            i12 = RecyclerView.LayoutManager.chooseSize(i10, rect.width() + paddingLeft, getMinimumWidth());
            i13 = RecyclerView.LayoutManager.chooseSize(i11, (this.mSizePerSpan * this.mSpanCount) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i12, i13);
    }

    public void setOrientation(int i10) {
        if (i10 == 0 || i10 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i10 != this.mOrientation) {
                this.mOrientation = i10;
                OrientationHelper orientationHelper = this.mPrimaryOrientation;
                this.mPrimaryOrientation = this.mSecondaryOrientation;
                this.mSecondaryOrientation = orientationHelper;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean z10) {
        assertNotInLayoutOrScroll((String) null);
        SavedState savedState = this.mPendingSavedState;
        if (!(savedState == null || savedState.mReverseLayout == z10)) {
            savedState.mReverseLayout = z10;
        }
        this.mReverseLayout = z10;
        requestLayout();
    }

    public void setSpanCount(int i10) {
        assertNotInLayoutOrScroll((String) null);
        if (i10 != this.mSpanCount) {
            invalidateSpanAssignments();
            this.mSpanCount = i10;
            this.mRemainingSpans = new BitSet(this.mSpanCount);
            this.mSpans = new c[this.mSpanCount];
            for (int i11 = 0; i11 < this.mSpanCount; i11++) {
                this.mSpans[i11] = new c(i11);
            }
            requestLayout();
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i10);
        startSmoothScroll(linearSmoothScroller);
    }

    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean updateAnchorFromPendingData(RecyclerView.State state, b bVar) {
        int i10;
        int i11;
        int i12;
        boolean z10 = false;
        if (!state.isPreLayout() && (i10 = this.mPendingScrollPosition) != -1) {
            if (i10 < 0 || i10 >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                SavedState savedState = this.mPendingSavedState;
                if (savedState == null || savedState.mAnchorPosition == -1 || savedState.mSpanOffsetsSize < 1) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition != null) {
                        if (this.mShouldReverseLayout) {
                            i11 = getLastChildPosition();
                        } else {
                            i11 = getFirstChildPosition();
                        }
                        bVar.f16263a = i11;
                        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                            if (bVar.f16265c) {
                                bVar.f16264b = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                            } else {
                                bVar.f16264b = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(findViewByPosition);
                            }
                            return true;
                        } else if (this.mPrimaryOrientation.getDecoratedMeasurement(findViewByPosition) > this.mPrimaryOrientation.getTotalSpace()) {
                            if (bVar.f16265c) {
                                i12 = this.mPrimaryOrientation.getEndAfterPadding();
                            } else {
                                i12 = this.mPrimaryOrientation.getStartAfterPadding();
                            }
                            bVar.f16264b = i12;
                            return true;
                        } else {
                            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(findViewByPosition) - this.mPrimaryOrientation.getStartAfterPadding();
                            if (decoratedStart < 0) {
                                bVar.f16264b = -decoratedStart;
                                return true;
                            }
                            int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                            if (endAfterPadding < 0) {
                                bVar.f16264b = endAfterPadding;
                                return true;
                            }
                            bVar.f16264b = Integer.MIN_VALUE;
                        }
                    } else {
                        int i13 = this.mPendingScrollPosition;
                        bVar.f16263a = i13;
                        int i14 = this.mPendingScrollPositionOffset;
                        if (i14 == Integer.MIN_VALUE) {
                            if (calculateScrollDirectionForPosition(i13) == 1) {
                                z10 = true;
                            }
                            bVar.f16265c = z10;
                            bVar.a();
                        } else {
                            bVar.b(i14);
                        }
                        bVar.f16266d = true;
                    }
                } else {
                    bVar.f16264b = Integer.MIN_VALUE;
                    bVar.f16263a = this.mPendingScrollPosition;
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void updateAnchorInfoForLayout(RecyclerView.State state, b bVar) {
        if (!updateAnchorFromPendingData(state, bVar) && !updateAnchorFromChildren(state, bVar)) {
            bVar.a();
            bVar.f16263a = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void updateMeasureSpecs(int i10) {
        this.mSizePerSpan = i10 / this.mSpanCount;
        this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(i10, this.mSecondaryOrientation.getMode());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0152, code lost:
        if (checkForGaps() != false) goto L_0x0156;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler r9, androidx.recyclerview.widget.RecyclerView.State r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r0 = r8.mAnchorInfo
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.mPendingSavedState
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.mPendingScrollPosition
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.getItemCount()
            if (r1 != 0) goto L_0x0018
            r8.removeAndRecycleAllViews(r9)
            r0.c()
            return
        L_0x0018:
            boolean r1 = r0.f16267e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.mPendingScrollPosition
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.mPendingSavedState
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = r3
            goto L_0x002a
        L_0x0029:
            r1 = r4
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.c()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.mPendingSavedState
            if (r5 == 0) goto L_0x0037
            r8.applyPendingSavedState(r0)
            goto L_0x003e
        L_0x0037:
            r8.resolveShouldLayoutReverse()
            boolean r5 = r8.mShouldReverseLayout
            r0.f16265c = r5
        L_0x003e:
            r8.updateAnchorInfoForLayout(r10, r0)
            r0.f16267e = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.mPendingSavedState
            if (r5 != 0) goto L_0x0060
            int r5 = r8.mPendingScrollPosition
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.f16265c
            boolean r6 = r8.mLastLayoutFromEnd
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.isLayoutRTL()
            boolean r6 = r8.mLastLayoutRTL
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r5 = r8.mLazySpanLookup
            r5.b()
            r0.f16266d = r4
        L_0x0060:
            int r5 = r8.getChildCount()
            if (r5 <= 0) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.mPendingSavedState
            if (r5 == 0) goto L_0x006e
            int r5 = r5.mSpanOffsetsSize
            if (r5 >= r4) goto L_0x00c9
        L_0x006e:
            boolean r5 = r0.f16266d
            if (r5 == 0) goto L_0x008e
            r1 = r3
        L_0x0073:
            int r5 = r8.mSpanCount
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.mSpans
            r5 = r5[r1]
            r5.e()
            int r5 = r0.f16264b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008b
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r6 = r8.mSpans
            r6 = r6[r1]
            r6.A(r5)
        L_0x008b:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x008e:
            if (r1 != 0) goto L_0x00af
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r1 = r8.mAnchorInfo
            int[] r1 = r1.f16268f
            if (r1 != 0) goto L_0x0097
            goto L_0x00af
        L_0x0097:
            r1 = r3
        L_0x0098:
            int r5 = r8.mSpanCount
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.mSpans
            r5 = r5[r1]
            r5.e()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r6 = r8.mAnchorInfo
            int[] r6 = r6.f16268f
            r6 = r6[r1]
            r5.A(r6)
            int r1 = r1 + 1
            goto L_0x0098
        L_0x00af:
            r1 = r3
        L_0x00b0:
            int r5 = r8.mSpanCount
            if (r1 >= r5) goto L_0x00c2
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.mSpans
            r5 = r5[r1]
            boolean r6 = r8.mShouldReverseLayout
            int r7 = r0.f16264b
            r5.b(r6, r7)
            int r1 = r1 + 1
            goto L_0x00b0
        L_0x00c2:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r1 = r8.mAnchorInfo
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.mSpans
            r1.d(r5)
        L_0x00c9:
            r8.detachAndScrapAttachedViews(r9)
            androidx.recyclerview.widget.g r1 = r8.mLayoutState
            r1.f16367a = r3
            r8.mLaidOutInvalidFullSpan = r3
            androidx.recyclerview.widget.OrientationHelper r1 = r8.mSecondaryOrientation
            int r1 = r1.getTotalSpace()
            r8.updateMeasureSpecs(r1)
            int r1 = r0.f16263a
            r8.updateLayoutState(r1, r10)
            boolean r1 = r0.f16265c
            if (r1 == 0) goto L_0x00fc
            r8.setLayoutStateDirection(r2)
            androidx.recyclerview.widget.g r1 = r8.mLayoutState
            r8.fill(r9, r1, r10)
            r8.setLayoutStateDirection(r4)
            androidx.recyclerview.widget.g r1 = r8.mLayoutState
            int r2 = r0.f16263a
            int r5 = r1.f16370d
            int r2 = r2 + r5
            r1.f16369c = r2
            r8.fill(r9, r1, r10)
            goto L_0x0113
        L_0x00fc:
            r8.setLayoutStateDirection(r4)
            androidx.recyclerview.widget.g r1 = r8.mLayoutState
            r8.fill(r9, r1, r10)
            r8.setLayoutStateDirection(r2)
            androidx.recyclerview.widget.g r1 = r8.mLayoutState
            int r2 = r0.f16263a
            int r5 = r1.f16370d
            int r2 = r2 + r5
            r1.f16369c = r2
            r8.fill(r9, r1, r10)
        L_0x0113:
            r8.repositionToWrapContentIfNecessary()
            int r1 = r8.getChildCount()
            if (r1 <= 0) goto L_0x012d
            boolean r1 = r8.mShouldReverseLayout
            if (r1 == 0) goto L_0x0127
            r8.fixEndGap(r9, r10, r4)
            r8.fixStartGap(r9, r10, r3)
            goto L_0x012d
        L_0x0127:
            r8.fixStartGap(r9, r10, r4)
            r8.fixEndGap(r9, r10, r3)
        L_0x012d:
            if (r11 == 0) goto L_0x0155
            boolean r11 = r10.isPreLayout()
            if (r11 != 0) goto L_0x0155
            int r11 = r8.mGapStrategy
            if (r11 == 0) goto L_0x0155
            int r11 = r8.getChildCount()
            if (r11 <= 0) goto L_0x0155
            boolean r11 = r8.mLaidOutInvalidFullSpan
            if (r11 != 0) goto L_0x0149
            android.view.View r11 = r8.hasGapsToFix()
            if (r11 == 0) goto L_0x0155
        L_0x0149:
            java.lang.Runnable r11 = r8.mCheckForGapsRunnable
            r8.removeCallbacks(r11)
            boolean r11 = r8.checkForGaps()
            if (r11 == 0) goto L_0x0155
            goto L_0x0156
        L_0x0155:
            r4 = r3
        L_0x0156:
            boolean r11 = r10.isPreLayout()
            if (r11 == 0) goto L_0x0161
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r11 = r8.mAnchorInfo
            r11.c()
        L_0x0161:
            boolean r11 = r0.f16265c
            r8.mLastLayoutFromEnd = r11
            boolean r11 = r8.isLayoutRTL()
            r8.mLastLayoutRTL = r11
            if (r4 == 0) goto L_0x0175
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r11 = r8.mAnchorInfo
            r11.c()
            r8.onLayoutChildren(r9, r10, r3)
        L_0x0175:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    static class LazySpanLookup {

        /* renamed from: a  reason: collision with root package name */
        int[] f16256a;

        /* renamed from: b  reason: collision with root package name */
        List f16257b;

        LazySpanLookup() {
        }

        private int i(int i10) {
            if (this.f16257b == null) {
                return -1;
            }
            FullSpanItem f10 = f(i10);
            if (f10 != null) {
                this.f16257b.remove(f10);
            }
            int size = this.f16257b.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                } else if (((FullSpanItem) this.f16257b.get(i11)).f16258a >= i10) {
                    break;
                } else {
                    i11++;
                }
            }
            if (i11 == -1) {
                return -1;
            }
            this.f16257b.remove(i11);
            return ((FullSpanItem) this.f16257b.get(i11)).f16258a;
        }

        private void l(int i10, int i11) {
            List list = this.f16257b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.f16257b.get(size);
                    int i12 = fullSpanItem.f16258a;
                    if (i12 >= i10) {
                        fullSpanItem.f16258a = i12 + i11;
                    }
                }
            }
        }

        private void m(int i10, int i11) {
            List list = this.f16257b;
            if (list != null) {
                int i12 = i10 + i11;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.f16257b.get(size);
                    int i13 = fullSpanItem.f16258a;
                    if (i13 >= i10) {
                        if (i13 < i12) {
                            this.f16257b.remove(size);
                        } else {
                            fullSpanItem.f16258a = i13 - i11;
                        }
                    }
                }
            }
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f16257b == null) {
                this.f16257b = new ArrayList();
            }
            int size = this.f16257b.size();
            for (int i10 = 0; i10 < size; i10++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.f16257b.get(i10);
                if (fullSpanItem2.f16258a == fullSpanItem.f16258a) {
                    this.f16257b.remove(i10);
                }
                if (fullSpanItem2.f16258a >= fullSpanItem.f16258a) {
                    this.f16257b.add(i10, fullSpanItem);
                    return;
                }
            }
            this.f16257b.add(fullSpanItem);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f16256a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f16257b = null;
        }

        /* access modifiers changed from: package-private */
        public void c(int i10) {
            int[] iArr = this.f16256a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i10, 10) + 1)];
                this.f16256a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int[] iArr3 = new int[o(i10)];
                this.f16256a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f16256a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public int d(int i10) {
            List list = this.f16257b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.f16257b.get(size)).f16258a >= i10) {
                        this.f16257b.remove(size);
                    }
                }
            }
            return h(i10);
        }

        public FullSpanItem e(int i10, int i11, int i12, boolean z10) {
            List list = this.f16257b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f16257b.get(i13);
                int i14 = fullSpanItem.f16258a;
                if (i14 >= i11) {
                    return null;
                }
                if (i14 >= i10 && (i12 == 0 || fullSpanItem.f16259b == i12 || (z10 && fullSpanItem.f16261d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i10) {
            List list = this.f16257b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f16257b.get(size);
                if (fullSpanItem.f16258a == i10) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int g(int i10) {
            int[] iArr = this.f16256a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            return iArr[i10];
        }

        /* access modifiers changed from: package-private */
        public int h(int i10) {
            int[] iArr = this.f16256a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            int i11 = i(i10);
            if (i11 == -1) {
                int[] iArr2 = this.f16256a;
                Arrays.fill(iArr2, i10, iArr2.length, -1);
                return this.f16256a.length;
            }
            int min = Math.min(i11 + 1, this.f16256a.length);
            Arrays.fill(this.f16256a, i10, min, -1);
            return min;
        }

        /* access modifiers changed from: package-private */
        public void j(int i10, int i11) {
            int[] iArr = this.f16256a;
            if (iArr != null && i10 < iArr.length) {
                int i12 = i10 + i11;
                c(i12);
                int[] iArr2 = this.f16256a;
                System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
                Arrays.fill(this.f16256a, i10, i12, -1);
                l(i10, i11);
            }
        }

        /* access modifiers changed from: package-private */
        public void k(int i10, int i11) {
            int[] iArr = this.f16256a;
            if (iArr != null && i10 < iArr.length) {
                int i12 = i10 + i11;
                c(i12);
                int[] iArr2 = this.f16256a;
                System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
                int[] iArr3 = this.f16256a;
                Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
                m(i10, i11);
            }
        }

        /* access modifiers changed from: package-private */
        public void n(int i10, c cVar) {
            c(i10);
            this.f16256a[i10] = cVar.f16274e;
        }

        /* access modifiers changed from: package-private */
        public int o(int i10) {
            int length = this.f16256a.length;
            while (length <= i10) {
                length *= 2;
            }
            return length;
        }

        @SuppressLint({"BanParcelableUsage"})
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            int f16258a;

            /* renamed from: b  reason: collision with root package name */
            int f16259b;

            /* renamed from: c  reason: collision with root package name */
            int[] f16260c;

            /* renamed from: d  reason: collision with root package name */
            boolean f16261d;

            class a implements Parcelable.Creator {
                a() {
                }

                /* renamed from: a */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* renamed from: b */
                public FullSpanItem[] newArray(int i10) {
                    return new FullSpanItem[i10];
                }
            }

            FullSpanItem(Parcel parcel) {
                this.f16258a = parcel.readInt();
                this.f16259b = parcel.readInt();
                this.f16261d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f16260c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            /* access modifiers changed from: package-private */
            public int a(int i10) {
                int[] iArr = this.f16260c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i10];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f16258a + ", mGapDir=" + this.f16259b + ", mHasUnwantedGapAfter=" + this.f16261d + ", mGapPerSpan=" + Arrays.toString(this.f16260c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f16258a);
                parcel.writeInt(this.f16259b);
                parcel.writeInt(this.f16261d ? 1 : 0);
                int[] iArr = this.f16260c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f16260c);
            }

            FullSpanItem() {
            }
        }
    }

    public StaggeredGridLayoutManager(int i10, int i11) {
        this.mOrientation = i11;
        setSpanCount(i10);
        this.mLayoutState = new g();
        createOrientationHelpers();
    }

    private void measureChildWithDecorationsAndMargin(View view, int i10, int i11, boolean z10) {
        boolean z11;
        calculateItemDecorationsForChild(view, this.mTmpRect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i12 = layoutParams.leftMargin;
        Rect rect = this.mTmpRect;
        int updateSpecWithExtra = updateSpecWithExtra(i10, i12 + rect.left, layoutParams.rightMargin + rect.right);
        int i13 = layoutParams.topMargin;
        Rect rect2 = this.mTmpRect;
        int updateSpecWithExtra2 = updateSpecWithExtra(i11, i13 + rect2.top, layoutParams.bottomMargin + rect2.bottom);
        if (z10) {
            z11 = shouldReMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
        } else {
            z11 = shouldMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
        }
        if (z11) {
            view.measure(updateSpecWithExtra, updateSpecWithExtra2);
        }
    }
}
