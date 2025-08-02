package androidx.recyclerview.widget;

import androidx.core.location.LocationRequestCompat;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class e implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    static final ThreadLocal f16351e = new ThreadLocal();

    /* renamed from: f  reason: collision with root package name */
    static Comparator f16352f = new a();

    /* renamed from: a  reason: collision with root package name */
    ArrayList f16353a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    long f16354b;

    /* renamed from: c  reason: collision with root package name */
    long f16355c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f16356d = new ArrayList();

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            boolean z10;
            boolean z11;
            RecyclerView recyclerView = cVar.f16364d;
            if (recyclerView == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (cVar2.f16364d == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z10 == z11) {
                boolean z12 = cVar.f16361a;
                if (z12 == cVar2.f16361a) {
                    int i10 = cVar2.f16362b - cVar.f16362b;
                    if (i10 != 0) {
                        return i10;
                    }
                    int i11 = cVar.f16363c - cVar2.f16363c;
                    if (i11 != 0) {
                        return i11;
                    }
                    return 0;
                } else if (z12) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (recyclerView == null) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    static class b implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {

        /* renamed from: a  reason: collision with root package name */
        int f16357a;

        /* renamed from: b  reason: collision with root package name */
        int f16358b;

        /* renamed from: c  reason: collision with root package name */
        int[] f16359c;

        /* renamed from: d  reason: collision with root package name */
        int f16360d;

        b() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.f16359c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f16360d = 0;
        }

        public void addPosition(int i10, int i11) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i11 >= 0) {
                int i12 = this.f16360d;
                int i13 = i12 * 2;
                int[] iArr = this.f16359c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f16359c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i13 >= iArr.length) {
                    int[] iArr3 = new int[(i12 * 4)];
                    this.f16359c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f16359c;
                iArr4[i13] = i10;
                iArr4[i13 + 1] = i11;
                this.f16360d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: package-private */
        public void b(RecyclerView recyclerView, boolean z10) {
            this.f16360d = 0;
            int[] iArr = this.f16359c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z10) {
                    if (!recyclerView.mAdapterHelper.p()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.f16357a, this.f16358b, recyclerView.mState, this);
                }
                int i10 = this.f16360d;
                if (i10 > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = i10;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z10;
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(int i10) {
            if (this.f16359c != null) {
                int i11 = this.f16360d * 2;
                for (int i12 = 0; i12 < i11; i12 += 2) {
                    if (this.f16359c[i12] == i10) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void d(int i10, int i11) {
            this.f16357a = i10;
            this.f16358b = i11;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f16361a;

        /* renamed from: b  reason: collision with root package name */
        public int f16362b;

        /* renamed from: c  reason: collision with root package name */
        public int f16363c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f16364d;

        /* renamed from: e  reason: collision with root package name */
        public int f16365e;

        c() {
        }

        public void a() {
            this.f16361a = false;
            this.f16362b = 0;
            this.f16363c = 0;
            this.f16364d = null;
            this.f16365e = 0;
        }
    }

    e() {
    }

    private void b() {
        c cVar;
        boolean z10;
        int size = this.f16353a.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            RecyclerView recyclerView = (RecyclerView) this.f16353a.get(i11);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.b(recyclerView, false);
                i10 += recyclerView.mPrefetchRegistry.f16360d;
            }
        }
        this.f16356d.ensureCapacity(i10);
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f16353a.get(i13);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(bVar.f16357a) + Math.abs(bVar.f16358b);
                for (int i14 = 0; i14 < bVar.f16360d * 2; i14 += 2) {
                    if (i12 >= this.f16356d.size()) {
                        cVar = new c();
                        this.f16356d.add(cVar);
                    } else {
                        cVar = (c) this.f16356d.get(i12);
                    }
                    int[] iArr = bVar.f16359c;
                    int i15 = iArr[i14 + 1];
                    if (i15 <= abs) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    cVar.f16361a = z10;
                    cVar.f16362b = abs;
                    cVar.f16363c = i15;
                    cVar.f16364d = recyclerView2;
                    cVar.f16365e = iArr[i14];
                    i12++;
                }
            }
        }
        Collections.sort(this.f16356d, f16352f);
    }

    private void c(c cVar, long j10) {
        long j11;
        if (cVar.f16361a) {
            j11 = LocationRequestCompat.PASSIVE_INTERVAL;
        } else {
            j11 = j10;
        }
        RecyclerView.ViewHolder i10 = i(cVar.f16364d, cVar.f16365e, j11);
        if (i10 != null && i10.mNestedRecyclerView != null && i10.isBound() && !i10.isInvalid()) {
            h(i10.mNestedRecyclerView.get(), j10);
        }
    }

    private void d(long j10) {
        int i10 = 0;
        while (i10 < this.f16356d.size()) {
            c cVar = (c) this.f16356d.get(i10);
            if (cVar.f16364d != null) {
                c(cVar, j10);
                cVar.a();
                i10++;
            } else {
                return;
            }
        }
    }

    static boolean e(RecyclerView recyclerView, int i10) {
        int j10 = recyclerView.mChildHelper.j();
        for (int i11 = 0; i11 < j10; i11++) {
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.i(i11));
            if (childViewHolderInt.mPosition == i10 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j10) {
        if (recyclerView != null) {
            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.j() != 0) {
                recyclerView.removeAndRecycleViews();
            }
            b bVar = recyclerView.mPrefetchRegistry;
            bVar.b(recyclerView, true);
            if (bVar.f16360d != 0) {
                try {
                    TraceCompat.beginSection("RV Nested Prefetch");
                    recyclerView.mState.prepareForNestedPrefetch(recyclerView.mAdapter);
                    for (int i10 = 0; i10 < bVar.f16360d * 2; i10 += 2) {
                        i(recyclerView, bVar.f16359c[i10], j10);
                    }
                } finally {
                    TraceCompat.endSection();
                }
            }
        }
    }

    private RecyclerView.ViewHolder i(RecyclerView recyclerView, int i10, long j10) {
        if (e(recyclerView, i10)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline = recycler.tryGetViewHolderForPositionByDeadline(i10, false, j10);
            if (tryGetViewHolderForPositionByDeadline != null) {
                if (!tryGetViewHolderForPositionByDeadline.isBound() || tryGetViewHolderForPositionByDeadline.isInvalid()) {
                    recycler.addViewHolderToRecycledViewPool(tryGetViewHolderForPositionByDeadline, false);
                } else {
                    recycler.recycleView(tryGetViewHolderForPositionByDeadline.itemView);
                }
            }
            return tryGetViewHolderForPositionByDeadline;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        if (!RecyclerView.sDebugAssertionsEnabled || !this.f16353a.contains(recyclerView)) {
            this.f16353a.add(recyclerView);
            return;
        }
        throw new IllegalStateException("RecyclerView already present in worker list!");
    }

    /* access modifiers changed from: package-private */
    public void f(RecyclerView recyclerView, int i10, int i11) {
        if (recyclerView.isAttachedToWindow()) {
            if (RecyclerView.sDebugAssertionsEnabled && !this.f16353a.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            } else if (this.f16354b == 0) {
                this.f16354b = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        recyclerView.mPrefetchRegistry.d(i10, i11);
    }

    /* access modifiers changed from: package-private */
    public void g(long j10) {
        b();
        d(j10);
    }

    public void j(RecyclerView recyclerView) {
        boolean remove = this.f16353a.remove(recyclerView);
        if (RecyclerView.sDebugAssertionsEnabled && !remove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
    }

    public void run() {
        try {
            TraceCompat.beginSection("RV Prefetch");
            if (!this.f16353a.isEmpty()) {
                int size = this.f16353a.size();
                long j10 = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    RecyclerView recyclerView = (RecyclerView) this.f16353a.get(i10);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j10 = Math.max(recyclerView.getDrawingTime(), j10);
                    }
                }
                if (j10 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j10) + this.f16355c);
                    this.f16354b = 0;
                    TraceCompat.endSection();
                }
            }
        } finally {
            this.f16354b = 0;
            TraceCompat.endSection();
        }
    }
}
