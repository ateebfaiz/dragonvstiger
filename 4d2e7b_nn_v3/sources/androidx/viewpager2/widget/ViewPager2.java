package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R;
import androidx.viewpager2.adapter.StatefulAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ViewPager2 extends ViewGroup {
    public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = -1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static boolean sFeatureEnhancedA11yEnabled = true;
    e mAccessibilityProvider;
    int mCurrentItem;
    private RecyclerView.AdapterDataObserver mCurrentItemDataSetChangeObserver = new a();
    boolean mCurrentItemDirty = false;
    private b mExternalPageChangeCallbacks = new b(3);
    private c mFakeDragger;
    LinearLayoutManager mLayoutManager;
    private int mOffscreenPageLimit = -1;
    private b mPageChangeEventDispatcher;
    private d mPageTransformerAdapter;
    private PagerSnapHelper mPagerSnapHelper;
    private Parcelable mPendingAdapterState;
    private int mPendingCurrentItem = -1;
    RecyclerView mRecyclerView;
    private RecyclerView.ItemAnimator mSavedItemAnimator = null;
    private boolean mSavedItemAnimatorPresent = false;
    e mScrollEventAdapter;
    private final Rect mTmpChildRect = new Rect();
    private final Rect mTmpContainerRect = new Rect();
    private boolean mUserInputEnabled = true;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    public @interface OffscreenPageLimit {
    }

    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i10) {
        }

        public void onPageScrolled(int i10, float f10, @Px int i11) {
        }

        public void onPageSelected(int i10) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public interface PageTransformer {
        void transformPage(@NonNull View view, float f10);
    }

    private class RecyclerViewImpl extends RecyclerView {
        RecyclerViewImpl(Context context) {
            super(context);
        }

        public CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.mAccessibilityProvider.d()) {
                return ViewPager2.this.mAccessibilityProvider.o();
            }
            return super.getAccessibilityClassName();
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.mCurrentItem);
            accessibilityEvent.setToIndex(ViewPager2.this.mCurrentItem);
            ViewPager2.this.mAccessibilityProvider.p(accessibilityEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!ViewPager2.this.isUserInputEnabled() || !super.onInterceptTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!ViewPager2.this.isUserInputEnabled() || !super.onTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollState {
    }

    class a extends g {
        a() {
            super((a) null);
        }

        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.mCurrentItemDirty = true;
            viewPager2.mScrollEventAdapter.l();
        }
    }

    class b extends OnPageChangeCallback {
        b() {
        }

        public void onPageScrollStateChanged(int i10) {
            if (i10 == 0) {
                ViewPager2.this.updateCurrentItem();
            }
        }

        public void onPageSelected(int i10) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.mCurrentItem != i10) {
                viewPager2.mCurrentItem = i10;
                viewPager2.mAccessibilityProvider.r();
            }
        }
    }

    class c extends OnPageChangeCallback {
        c() {
        }

        public void onPageSelected(int i10) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.mRecyclerView.requestFocus(2);
            }
        }
    }

    class d implements RecyclerView.OnChildAttachStateChangeListener {
        d() {
        }

        public void onChildViewAttachedToWindow(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (layoutParams.width != -1 || layoutParams.height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }

        public void onChildViewDetachedFromWindow(View view) {
        }
    }

    private abstract class e {
        private e() {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i10) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean c(int i10, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void e(RecyclerView.Adapter adapter) {
        }

        /* access modifiers changed from: package-private */
        public void f(RecyclerView.Adapter adapter) {
        }

        /* access modifiers changed from: package-private */
        public String g() {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void h(b bVar, RecyclerView recyclerView) {
        }

        /* access modifiers changed from: package-private */
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        /* access modifiers changed from: package-private */
        public void j(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        /* access modifiers changed from: package-private */
        public void k(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        /* access modifiers changed from: package-private */
        public boolean l(int i10) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public boolean m(int i10, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void n() {
        }

        /* access modifiers changed from: package-private */
        public CharSequence o() {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void p(AccessibilityEvent accessibilityEvent) {
        }

        /* access modifiers changed from: package-private */
        public void q() {
        }

        /* access modifiers changed from: package-private */
        public void r() {
        }

        /* access modifiers changed from: package-private */
        public void s() {
        }

        /* access modifiers changed from: package-private */
        public void t() {
        }

        /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this();
        }
    }

    class f extends e {
        f() {
            super(ViewPager2.this, (a) null);
        }

        public boolean b(int i10) {
            if ((i10 == 8192 || i10 == 4096) && !ViewPager2.this.isUserInputEnabled()) {
                return true;
            }
            return false;
        }

        public boolean d() {
            return true;
        }

        public void j(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (!ViewPager2.this.isUserInputEnabled()) {
                accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfoCompat.setScrollable(false);
            }
        }

        public boolean l(int i10) {
            if (b(i10)) {
                return false;
            }
            throw new IllegalStateException();
        }

        public CharSequence o() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    private static abstract class g extends RecyclerView.AdapterDataObserver {
        private g() {
        }

        public abstract void onChanged();

        public final void onItemRangeChanged(int i10, int i11) {
            onChanged();
        }

        public final void onItemRangeInserted(int i10, int i11) {
            onChanged();
        }

        public final void onItemRangeMoved(int i10, int i11, int i12) {
            onChanged();
        }

        public final void onItemRangeRemoved(int i10, int i11) {
            onChanged();
        }

        /* synthetic */ g(a aVar) {
            this();
        }

        public final void onItemRangeChanged(int i10, int i11, Object obj) {
            onChanged();
        }
    }

    private class h extends LinearLayoutManager {
        h(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(state, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.mAccessibilityProvider.j(accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewPager2.this.mAccessibilityProvider.k(view, accessibilityNodeInfoCompat);
        }

        public boolean performAccessibilityAction(RecyclerView.Recycler recycler, RecyclerView.State state, int i10, Bundle bundle) {
            if (ViewPager2.this.mAccessibilityProvider.b(i10)) {
                return ViewPager2.this.mAccessibilityProvider.l(i10);
            }
            return super.performAccessibilityAction(recycler, state, i10, bundle);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            return false;
        }
    }

    class i extends e {

        /* renamed from: b  reason: collision with root package name */
        private final AccessibilityViewCommand f16880b = new a();

        /* renamed from: c  reason: collision with root package name */
        private final AccessibilityViewCommand f16881c = new b();

        /* renamed from: d  reason: collision with root package name */
        private RecyclerView.AdapterDataObserver f16882d;

        class a implements AccessibilityViewCommand {
            a() {
            }

            public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                i.this.x(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        class b implements AccessibilityViewCommand {
            b() {
            }

            public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                i.this.x(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        class c extends g {
            c() {
                super((a) null);
            }

            public void onChanged() {
                i.this.y();
            }
        }

        i() {
            super(ViewPager2.this, (a) null);
        }

        private void u(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int i10;
            int i11;
            if (ViewPager2.this.getAdapter() != null) {
                i10 = 1;
                if (ViewPager2.this.getOrientation() == 1) {
                    i10 = ViewPager2.this.getAdapter().getItemCount();
                    i11 = 1;
                } else {
                    i11 = ViewPager2.this.getAdapter().getItemCount();
                }
            } else {
                i11 = 0;
                i10 = 0;
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i10, i11, false, 0));
        }

        private void v(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int i10;
            int i11 = 0;
            if (ViewPager2.this.getOrientation() == 1) {
                i10 = ViewPager2.this.mLayoutManager.getPosition(view);
            } else {
                i10 = 0;
            }
            if (ViewPager2.this.getOrientation() == 0) {
                i11 = ViewPager2.this.mLayoutManager.getPosition(view);
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i10, 1, i11, 1, false, false));
        }

        private void w(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int itemCount;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter != null && (itemCount = adapter.getItemCount()) != 0 && ViewPager2.this.isUserInputEnabled()) {
                if (ViewPager2.this.mCurrentItem > 0) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
                accessibilityNodeInfoCompat.setScrollable(true);
            }
        }

        public boolean a() {
            return true;
        }

        public boolean c(int i10, Bundle bundle) {
            return i10 == 8192 || i10 == 4096;
        }

        public void e(RecyclerView.Adapter adapter) {
            y();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.f16882d);
            }
        }

        public void f(RecyclerView.Adapter adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.f16882d);
            }
        }

        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        public void h(b bVar, RecyclerView recyclerView) {
            recyclerView.setImportantForAccessibility(2);
            this.f16882d = new c();
            if (ViewPager2.this.getImportantForAccessibility() == 0) {
                ViewPager2.this.setImportantForAccessibility(1);
            }
        }

        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            u(wrap);
            w(wrap);
        }

        /* access modifiers changed from: package-private */
        public void k(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            v(view, accessibilityNodeInfoCompat);
        }

        public boolean m(int i10, Bundle bundle) {
            int i11;
            if (c(i10, bundle)) {
                if (i10 == 8192) {
                    i11 = ViewPager2.this.getCurrentItem() - 1;
                } else {
                    i11 = ViewPager2.this.getCurrentItem() + 1;
                }
                x(i11);
                return true;
            }
            throw new IllegalStateException();
        }

        public void n() {
            y();
        }

        public void p(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        public void q() {
            y();
        }

        public void r() {
            y();
        }

        public void s() {
            y();
        }

        public void t() {
            y();
        }

        /* access modifiers changed from: package-private */
        public void x(int i10) {
            if (ViewPager2.this.isUserInputEnabled()) {
                ViewPager2.this.setCurrentItemInternal(i10, true);
            }
        }

        /* access modifiers changed from: package-private */
        public void y() {
            int itemCount;
            int i10;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i11 = 16908360;
            ViewCompat.removeAccessibilityAction(viewPager2, 16908360);
            ViewCompat.removeAccessibilityAction(viewPager2, 16908361);
            ViewCompat.removeAccessibilityAction(viewPager2, 16908358);
            ViewCompat.removeAccessibilityAction(viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() != null && (itemCount = ViewPager2.this.getAdapter().getItemCount()) != 0 && ViewPager2.this.isUserInputEnabled()) {
                if (ViewPager2.this.getOrientation() == 0) {
                    boolean isRtl = ViewPager2.this.isRtl();
                    if (isRtl) {
                        i10 = 16908360;
                    } else {
                        i10 = 16908361;
                    }
                    if (isRtl) {
                        i11 = 16908361;
                    }
                    if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                        ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i10, (CharSequence) null), (CharSequence) null, this.f16880b);
                    }
                    if (ViewPager2.this.mCurrentItem > 0) {
                        ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i11, (CharSequence) null), (CharSequence) null, this.f16881c);
                        return;
                    }
                    return;
                }
                if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                    ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, (CharSequence) null), (CharSequence) null, this.f16880b);
                }
                if (ViewPager2.this.mCurrentItem > 0) {
                    ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, (CharSequence) null), (CharSequence) null, this.f16881c);
                }
            }
        }
    }

    private class j extends PagerSnapHelper {
        j() {
        }

        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    private static class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f16888a;

        /* renamed from: b  reason: collision with root package name */
        private final RecyclerView f16889b;

        k(int i10, RecyclerView recyclerView) {
            this.f16888a = i10;
            this.f16889b = recyclerView;
        }

        public void run() {
            this.f16889b.smoothScrollToPosition(this.f16888a);
        }
    }

    public ViewPager2(@NonNull Context context) {
        super(context);
        initialize(context, (AttributeSet) null);
    }

    private RecyclerView.OnChildAttachStateChangeListener enforceChildFillListener() {
        return new d();
    }

    private void initialize(Context context, AttributeSet attributeSet) {
        e eVar;
        if (sFeatureEnhancedA11yEnabled) {
            eVar = new i();
        } else {
            eVar = new f();
        }
        this.mAccessibilityProvider = eVar;
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.mRecyclerView = recyclerViewImpl;
        recyclerViewImpl.setId(View.generateViewId());
        this.mRecyclerView.setDescendantFocusability(131072);
        h hVar = new h(context);
        this.mLayoutManager = hVar;
        this.mRecyclerView.setLayoutManager(hVar);
        this.mRecyclerView.setScrollingTouchSlop(1);
        setOrientation(context, attributeSet);
        this.mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRecyclerView.addOnChildAttachStateChangeListener(enforceChildFillListener());
        e eVar2 = new e(this);
        this.mScrollEventAdapter = eVar2;
        this.mFakeDragger = new c(this, eVar2, this.mRecyclerView);
        j jVar = new j();
        this.mPagerSnapHelper = jVar;
        jVar.attachToRecyclerView(this.mRecyclerView);
        this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
        b bVar = new b(3);
        this.mPageChangeEventDispatcher = bVar;
        this.mScrollEventAdapter.p(bVar);
        b bVar2 = new b();
        c cVar = new c();
        this.mPageChangeEventDispatcher.a(bVar2);
        this.mPageChangeEventDispatcher.a(cVar);
        this.mAccessibilityProvider.h(this.mPageChangeEventDispatcher, this.mRecyclerView);
        this.mPageChangeEventDispatcher.a(this.mExternalPageChangeCallbacks);
        d dVar = new d(this.mLayoutManager);
        this.mPageTransformerAdapter = dVar;
        this.mPageChangeEventDispatcher.a(dVar);
        RecyclerView recyclerView = this.mRecyclerView;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void registerCurrentItemDataSetTracker(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        }
    }

    private void restorePendingState() {
        RecyclerView.Adapter adapter;
        if (this.mPendingCurrentItem != -1 && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.mPendingAdapterState;
            if (parcelable != null) {
                if (adapter instanceof StatefulAdapter) {
                    ((StatefulAdapter) adapter).restoreState(parcelable);
                }
                this.mPendingAdapterState = null;
            }
            int max = Math.max(0, Math.min(this.mPendingCurrentItem, adapter.getItemCount() - 1));
            this.mCurrentItem = max;
            this.mPendingCurrentItem = -1;
            this.mRecyclerView.scrollToPosition(max);
            this.mAccessibilityProvider.n();
        }
    }

    private void setOrientation(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewPager2);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.ViewPager2, attributeSet, obtainStyledAttributes, 0, 0);
        try {
            setOrientation(obtainStyledAttributes.getInt(R.styleable.ViewPager2_android_orientation, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void unregisterCurrentItemDataSetTracker(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        }
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.mRecyclerView.addItemDecoration(itemDecoration);
    }

    public boolean beginFakeDrag() {
        return this.mFakeDragger.b();
    }

    public boolean canScrollHorizontally(int i10) {
        return this.mRecyclerView.canScrollHorizontally(i10);
    }

    public boolean canScrollVertically(int i10) {
        return this.mRecyclerView.canScrollVertically(i10);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i10 = ((SavedState) parcelable).f16870a;
            sparseArray.put(this.mRecyclerView.getId(), sparseArray.get(i10));
            sparseArray.remove(i10);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        restorePendingState();
    }

    public boolean endFakeDrag() {
        return this.mFakeDragger.d();
    }

    public boolean fakeDragBy(@Px @SuppressLint({"SupportAnnotationUsage"}) float f10) {
        return this.mFakeDragger.e(f10);
    }

    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        if (this.mAccessibilityProvider.a()) {
            return this.mAccessibilityProvider.g();
        }
        return super.getAccessibilityClassName();
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return this.mRecyclerView.getAdapter();
    }

    public int getCurrentItem() {
        return this.mCurrentItem;
    }

    @NonNull
    public RecyclerView.ItemDecoration getItemDecorationAt(int i10) {
        return this.mRecyclerView.getItemDecorationAt(i10);
    }

    public int getItemDecorationCount() {
        return this.mRecyclerView.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getOrientation() {
        if (this.mLayoutManager.getOrientation() == 1) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.mRecyclerView;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.mScrollEventAdapter.f();
    }

    public void invalidateItemDecorations() {
        this.mRecyclerView.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragger.f();
    }

    /* access modifiers changed from: package-private */
    public boolean isRtl() {
        if (this.mLayoutManager.getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public boolean isUserInputEnabled() {
        return this.mUserInputEnabled;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.mAccessibilityProvider.i(accessibilityNodeInfo);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        this.mTmpContainerRect.left = getPaddingLeft();
        this.mTmpContainerRect.right = (i12 - i10) - getPaddingRight();
        this.mTmpContainerRect.top = getPaddingTop();
        this.mTmpContainerRect.bottom = (i13 - i11) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.mTmpContainerRect, this.mTmpChildRect);
        RecyclerView recyclerView = this.mRecyclerView;
        Rect rect = this.mTmpChildRect;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.mCurrentItemDirty) {
            updateCurrentItem();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        measureChild(this.mRecyclerView, i10, i11);
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        int measuredState = this.mRecyclerView.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, measuredState << 16));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mPendingCurrentItem = savedState.f16871b;
        this.mPendingAdapterState = savedState.f16872c;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f16870a = this.mRecyclerView.getId();
        int i10 = this.mPendingCurrentItem;
        if (i10 == -1) {
            i10 = this.mCurrentItem;
        }
        savedState.f16871b = i10;
        Parcelable parcelable = this.mPendingAdapterState;
        if (parcelable != null) {
            savedState.f16872c = parcelable;
        } else {
            RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.f16872c = ((StatefulAdapter) adapter).saveState();
            }
        }
        return savedState;
    }

    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    public boolean performAccessibilityAction(int i10, @Nullable Bundle bundle) {
        if (this.mAccessibilityProvider.c(i10, bundle)) {
            return this.mAccessibilityProvider.m(i10, bundle);
        }
        return super.performAccessibilityAction(i10, bundle);
    }

    public void registerOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.mExternalPageChangeCallbacks.a(onPageChangeCallback);
    }

    public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.mRecyclerView.removeItemDecoration(itemDecoration);
    }

    public void removeItemDecorationAt(int i10) {
        this.mRecyclerView.removeItemDecorationAt(i10);
    }

    public void requestTransform() {
        if (this.mPageTransformerAdapter.a() != null) {
            double e10 = this.mScrollEventAdapter.e();
            int i10 = (int) e10;
            float f10 = (float) (e10 - ((double) i10));
            this.mPageTransformerAdapter.onPageScrolled(i10, f10, Math.round(((float) getPageSize()) * f10));
        }
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.mRecyclerView.getAdapter();
        this.mAccessibilityProvider.f(adapter2);
        unregisterCurrentItemDataSetTracker(adapter2);
        this.mRecyclerView.setAdapter(adapter);
        this.mCurrentItem = 0;
        restorePendingState();
        this.mAccessibilityProvider.e(adapter);
        registerCurrentItemDataSetTracker(adapter);
    }

    public void setCurrentItem(int i10) {
        setCurrentItem(i10, true);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i10, boolean z10) {
        int i11;
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.mPendingCurrentItem != -1) {
                this.mPendingCurrentItem = Math.max(i10, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i10, 0), adapter.getItemCount() - 1);
            if (min != this.mCurrentItem || !this.mScrollEventAdapter.i()) {
                int i12 = this.mCurrentItem;
                if (min != i12 || !z10) {
                    double d10 = (double) i12;
                    this.mCurrentItem = min;
                    this.mAccessibilityProvider.r();
                    if (!this.mScrollEventAdapter.i()) {
                        d10 = this.mScrollEventAdapter.e();
                    }
                    this.mScrollEventAdapter.n(min, z10);
                    if (!z10) {
                        this.mRecyclerView.scrollToPosition(min);
                        return;
                    }
                    double d11 = (double) min;
                    if (Math.abs(d11 - d10) > 3.0d) {
                        RecyclerView recyclerView = this.mRecyclerView;
                        if (d11 > d10) {
                            i11 = min - 3;
                        } else {
                            i11 = min + 3;
                        }
                        recyclerView.scrollToPosition(i11);
                        RecyclerView recyclerView2 = this.mRecyclerView;
                        recyclerView2.post(new k(min, recyclerView2));
                        return;
                    }
                    this.mRecyclerView.smoothScrollToPosition(min);
                }
            }
        }
    }

    public void setLayoutDirection(int i10) {
        super.setLayoutDirection(i10);
        this.mAccessibilityProvider.q();
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 >= 1 || i10 == -1) {
            this.mOffscreenPageLimit = i10;
            this.mRecyclerView.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setPageTransformer(@Nullable PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.mSavedItemAnimatorPresent) {
                this.mSavedItemAnimator = this.mRecyclerView.getItemAnimator();
                this.mSavedItemAnimatorPresent = true;
            }
            this.mRecyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        } else if (this.mSavedItemAnimatorPresent) {
            this.mRecyclerView.setItemAnimator(this.mSavedItemAnimator);
            this.mSavedItemAnimator = null;
            this.mSavedItemAnimatorPresent = false;
        }
        if (pageTransformer != this.mPageTransformerAdapter.a()) {
            this.mPageTransformerAdapter.b(pageTransformer);
            requestTransform();
        }
    }

    public void setUserInputEnabled(boolean z10) {
        this.mUserInputEnabled = z10;
        this.mAccessibilityProvider.t();
    }

    /* access modifiers changed from: package-private */
    public void snapToPage() {
        View findSnapView = this.mPagerSnapHelper.findSnapView(this.mLayoutManager);
        if (findSnapView != null) {
            int[] calculateDistanceToFinalSnap = this.mPagerSnapHelper.calculateDistanceToFinalSnap(this.mLayoutManager, findSnapView);
            int i10 = calculateDistanceToFinalSnap[0];
            if (i10 != 0 || calculateDistanceToFinalSnap[1] != 0) {
                this.mRecyclerView.smoothScrollBy(i10, calculateDistanceToFinalSnap[1]);
            }
        }
    }

    public void unregisterOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.mExternalPageChangeCallbacks.b(onPageChangeCallback);
    }

    /* access modifiers changed from: package-private */
    public void updateCurrentItem() {
        PagerSnapHelper pagerSnapHelper = this.mPagerSnapHelper;
        if (pagerSnapHelper != null) {
            View findSnapView = pagerSnapHelper.findSnapView(this.mLayoutManager);
            if (findSnapView != null) {
                int position = this.mLayoutManager.getPosition(findSnapView);
                if (position != this.mCurrentItem && getScrollState() == 0) {
                    this.mPageChangeEventDispatcher.onPageSelected(position);
                }
                this.mCurrentItemDirty = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f16870a;

        /* renamed from: b  reason: collision with root package name */
        int f16871b;

        /* renamed from: c  reason: collision with root package name */
        Parcelable f16872c;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return new SavedState(parcel, classLoader);
                }
                return new SavedState(parcel);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f16870a = parcel.readInt();
            this.f16871b = parcel.readInt();
            this.f16872c = parcel.readParcelable(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f16870a);
            parcel.writeInt(this.f16871b);
            parcel.writeParcelable(this.f16872c, i10);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, (ClassLoader) null);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration, int i10) {
        this.mRecyclerView.addItemDecoration(itemDecoration, i10);
    }

    public void setCurrentItem(int i10, boolean z10) {
        if (!isFakeDragging()) {
            setCurrentItemInternal(i10, z10);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public void setOrientation(int i10) {
        this.mLayoutManager.setOrientation(i10);
        this.mAccessibilityProvider.s();
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context, attributeSet);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        initialize(context, attributeSet);
    }

    @RequiresApi(21)
    @SuppressLint({"ClassVerificationFailure"})
    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        initialize(context, attributeSet);
    }
}
