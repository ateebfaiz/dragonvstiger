package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

public class AsyncListUtil<T> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
    final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    final DataCallback<T> mDataCallback;
    int mDisplayedGeneration = 0;
    int mItemCount = 0;
    private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
    final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    final SparseIntArray mMissingPositions = new SparseIntArray();
    final int[] mPrevRange = new int[2];
    int mRequestedGeneration = 0;
    private int mScrollHint = 0;
    final Class<T> mTClass;
    final TileList mTileList;
    final int mTileSize;
    final int[] mTmpRange = new int[2];
    final int[] mTmpRangeExtended = new int[2];
    final ViewCallback mViewCallback;

    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void fillData(@NonNull T[] tArr, int i10, int i11);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(@NonNull T[] tArr, int i10) {
        }

        @WorkerThread
        public abstract int refreshData();
    }

    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @UiThread
        public void extendRangeInto(@NonNull int[] iArr, @NonNull int[] iArr2, int i10) {
            int i11;
            int i12 = iArr[1];
            int i13 = iArr[0];
            int i14 = (i12 - i13) + 1;
            int i15 = i14 / 2;
            if (i10 == 1) {
                i11 = i14;
            } else {
                i11 = i15;
            }
            iArr2[0] = i13 - i11;
            if (i10 != 2) {
                i14 = i15;
            }
            iArr2[1] = i12 + i14;
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i10);
    }

    class a implements ThreadUtil.MainThreadCallback {
        a() {
        }

        private boolean a(int i10) {
            if (i10 == AsyncListUtil.this.mRequestedGeneration) {
                return true;
            }
            return false;
        }

        private void b() {
            for (int i10 = 0; i10 < AsyncListUtil.this.mTileList.f(); i10++) {
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.mBackgroundProxy.recycleTile(asyncListUtil.mTileList.c(i10));
            }
            AsyncListUtil.this.mTileList.b();
        }

        public void addTile(int i10, TileList.Tile tile) {
            if (!a(i10)) {
                AsyncListUtil.this.mBackgroundProxy.recycleTile(tile);
                return;
            }
            TileList.Tile a10 = AsyncListUtil.this.mTileList.a(tile);
            if (a10 != null) {
                Log.e(AsyncListUtil.TAG, "duplicate tile @" + a10.mStartPosition);
                AsyncListUtil.this.mBackgroundProxy.recycleTile(a10);
            }
            int i11 = tile.mStartPosition + tile.mItemCount;
            int i12 = 0;
            while (i12 < AsyncListUtil.this.mMissingPositions.size()) {
                int keyAt = AsyncListUtil.this.mMissingPositions.keyAt(i12);
                if (tile.mStartPosition > keyAt || keyAt >= i11) {
                    i12++;
                } else {
                    AsyncListUtil.this.mMissingPositions.removeAt(i12);
                    AsyncListUtil.this.mViewCallback.onItemLoaded(keyAt);
                }
            }
        }

        public void removeTile(int i10, int i11) {
            if (a(i10)) {
                TileList.Tile e10 = AsyncListUtil.this.mTileList.e(i11);
                if (e10 == null) {
                    Log.e(AsyncListUtil.TAG, "tile not found @" + i11);
                    return;
                }
                AsyncListUtil.this.mBackgroundProxy.recycleTile(e10);
            }
        }

        public void updateItemCount(int i10, int i11) {
            if (a(i10)) {
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.mItemCount = i11;
                asyncListUtil.mViewCallback.onDataRefresh();
                AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                asyncListUtil2.mDisplayedGeneration = asyncListUtil2.mRequestedGeneration;
                b();
                AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                asyncListUtil3.mAllowScrollHints = false;
                asyncListUtil3.updateRange();
            }
        }
    }

    class b implements ThreadUtil.BackgroundCallback {

        /* renamed from: a  reason: collision with root package name */
        private TileList.Tile f16120a;

        /* renamed from: b  reason: collision with root package name */
        final SparseBooleanArray f16121b = new SparseBooleanArray();

        /* renamed from: c  reason: collision with root package name */
        private int f16122c;

        /* renamed from: d  reason: collision with root package name */
        private int f16123d;

        /* renamed from: e  reason: collision with root package name */
        private int f16124e;

        /* renamed from: f  reason: collision with root package name */
        private int f16125f;

        b() {
        }

        private TileList.Tile a() {
            TileList.Tile tile = this.f16120a;
            if (tile != null) {
                this.f16120a = tile.mNext;
                return tile;
            }
            AsyncListUtil asyncListUtil = AsyncListUtil.this;
            return new TileList.Tile(asyncListUtil.mTClass, asyncListUtil.mTileSize);
        }

        private void b(TileList.Tile tile) {
            this.f16121b.put(tile.mStartPosition, true);
            AsyncListUtil.this.mMainThreadProxy.addTile(this.f16122c, tile);
        }

        private void c(int i10) {
            int maxCachedTiles = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
            while (this.f16121b.size() >= maxCachedTiles) {
                int keyAt = this.f16121b.keyAt(0);
                SparseBooleanArray sparseBooleanArray = this.f16121b;
                int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                int i11 = this.f16124e - keyAt;
                int i12 = keyAt2 - this.f16125f;
                if (i11 > 0 && (i11 >= i12 || i10 == 2)) {
                    f(keyAt);
                } else if (i12 <= 0) {
                    return;
                } else {
                    if (i11 < i12 || i10 == 1) {
                        f(keyAt2);
                    } else {
                        return;
                    }
                }
            }
        }

        private int d(int i10) {
            return i10 - (i10 % AsyncListUtil.this.mTileSize);
        }

        private boolean e(int i10) {
            return this.f16121b.get(i10);
        }

        private void f(int i10) {
            this.f16121b.delete(i10);
            AsyncListUtil.this.mMainThreadProxy.removeTile(this.f16122c, i10);
        }

        private void g(int i10, int i11, int i12, boolean z10) {
            int i13;
            int i14 = i10;
            while (i14 <= i11) {
                if (z10) {
                    i13 = (i11 + i10) - i14;
                } else {
                    i13 = i14;
                }
                AsyncListUtil.this.mBackgroundProxy.loadTile(i13, i12);
                i14 += AsyncListUtil.this.mTileSize;
            }
        }

        public void loadTile(int i10, int i11) {
            if (!e(i10)) {
                TileList.Tile a10 = a();
                a10.mStartPosition = i10;
                int min = Math.min(AsyncListUtil.this.mTileSize, this.f16123d - i10);
                a10.mItemCount = min;
                AsyncListUtil.this.mDataCallback.fillData(a10.mItems, a10.mStartPosition, min);
                c(i11);
                b(a10);
            }
        }

        public void recycleTile(TileList.Tile tile) {
            AsyncListUtil.this.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
            tile.mNext = this.f16120a;
            this.f16120a = tile;
        }

        public void refresh(int i10) {
            this.f16122c = i10;
            this.f16121b.clear();
            int refreshData = AsyncListUtil.this.mDataCallback.refreshData();
            this.f16123d = refreshData;
            AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.f16122c, refreshData);
        }

        public void updateRange(int i10, int i11, int i12, int i13, int i14) {
            if (i10 <= i11) {
                int d10 = d(i10);
                int d11 = d(i11);
                this.f16124e = d(i12);
                int d12 = d(i13);
                this.f16125f = d12;
                if (i14 == 1) {
                    g(this.f16124e, d11, i14, true);
                    g(d11 + AsyncListUtil.this.mTileSize, this.f16125f, i14, false);
                    return;
                }
                g(d10, d12, i14, false);
                g(this.f16124e, d10 - AsyncListUtil.this.mTileSize, i14, true);
            }
        }
    }

    public AsyncListUtil(@NonNull Class<T> cls, int i10, @NonNull DataCallback<T> dataCallback, @NonNull ViewCallback viewCallback) {
        a aVar = new a();
        this.mMainThreadCallback = aVar;
        b bVar = new b();
        this.mBackgroundCallback = bVar;
        this.mTClass = cls;
        this.mTileSize = i10;
        this.mDataCallback = dataCallback;
        this.mViewCallback = viewCallback;
        this.mTileList = new TileList(i10);
        h hVar = new h();
        this.mMainThreadProxy = hVar.b(aVar);
        this.mBackgroundProxy = hVar.a(bVar);
        refresh();
    }

    private boolean isRefreshPending() {
        if (this.mRequestedGeneration != this.mDisplayedGeneration) {
            return true;
        }
        return false;
    }

    @Nullable
    public T getItem(int i10) {
        if (i10 < 0 || i10 >= this.mItemCount) {
            throw new IndexOutOfBoundsException(i10 + " is not within 0 and " + this.mItemCount);
        }
        T d10 = this.mTileList.d(i10);
        if (d10 == null && !isRefreshPending()) {
            this.mMissingPositions.put(i10, 0);
        }
        return d10;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    /* access modifiers changed from: package-private */
    public void log(String str, Object... objArr) {
        Log.d(TAG, "[MAIN] " + String.format(str, objArr));
    }

    public void onRangeChanged() {
        if (!isRefreshPending()) {
            updateRange();
            this.mAllowScrollHints = true;
        }
    }

    public void refresh() {
        this.mMissingPositions.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        int i10 = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = i10;
        backgroundCallback.refresh(i10);
    }

    /* access modifiers changed from: package-private */
    public void updateRange() {
        int i10;
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        int[] iArr = this.mTmpRange;
        int i11 = iArr[0];
        int i12 = iArr[1];
        if (i11 <= i12 && i11 >= 0 && i12 < this.mItemCount) {
            if (!this.mAllowScrollHints) {
                this.mScrollHint = 0;
            } else {
                int[] iArr2 = this.mPrevRange;
                if (i11 > iArr2[1] || (i10 = iArr2[0]) > i12) {
                    this.mScrollHint = 0;
                } else if (i11 < i10) {
                    this.mScrollHint = 1;
                } else if (i11 > i10) {
                    this.mScrollHint = 2;
                }
            }
            int[] iArr3 = this.mPrevRange;
            iArr3[0] = i11;
            iArr3[1] = i12;
            this.mViewCallback.extendRangeInto(iArr, this.mTmpRangeExtended, this.mScrollHint);
            int[] iArr4 = this.mTmpRangeExtended;
            iArr4[0] = Math.min(this.mTmpRange[0], Math.max(iArr4[0], 0));
            int[] iArr5 = this.mTmpRangeExtended;
            iArr5[1] = Math.max(this.mTmpRange[1], Math.min(iArr5[1], this.mItemCount - 1));
            ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
            int[] iArr6 = this.mTmpRange;
            int i13 = iArr6[0];
            int i14 = iArr6[1];
            int[] iArr7 = this.mTmpRangeExtended;
            backgroundCallback.updateRange(i13, i14, iArr7[0], iArr7[1], this.mScrollHint);
        }
    }
}
