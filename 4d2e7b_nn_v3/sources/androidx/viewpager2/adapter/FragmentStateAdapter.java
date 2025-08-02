package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresOptIn;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    d mFragmentEventDispatcher;
    final FragmentManager mFragmentManager;
    private FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    final LongSparseArray<Fragment> mFragments;
    private boolean mHasStaleFragments;
    boolean mIsInGracePeriod;
    private final LongSparseArray<Integer> mItemIdToViewHolder;
    final Lifecycle mLifecycle;
    private final LongSparseArray<Fragment.SavedState> mSavedStates;

    @RequiresOptIn(level = RequiresOptIn.Level.WARNING)
    public @interface ExperimentalFragmentStateAdapterApi {
    }

    class FragmentMaxLifecycleEnforcer {

        /* renamed from: a  reason: collision with root package name */
        private ViewPager2.OnPageChangeCallback f16855a;

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView.AdapterDataObserver f16856b;

        /* renamed from: c  reason: collision with root package name */
        private LifecycleEventObserver f16857c;

        /* renamed from: d  reason: collision with root package name */
        private ViewPager2 f16858d;

        /* renamed from: e  reason: collision with root package name */
        private long f16859e = -1;

        class a extends ViewPager2.OnPageChangeCallback {
            a() {
            }

            public void onPageScrollStateChanged(int i10) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }

            public void onPageSelected(int i10) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }
        }

        class b extends c {
            b() {
                super();
            }

            public void onChanged() {
                FragmentMaxLifecycleEnforcer.this.d(true);
            }
        }

        FragmentMaxLifecycleEnforcer() {
        }

        private ViewPager2 a(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        /* access modifiers changed from: package-private */
        public void b(RecyclerView recyclerView) {
            this.f16858d = a(recyclerView);
            a aVar = new a();
            this.f16855a = aVar;
            this.f16858d.registerOnPageChangeCallback(aVar);
            b bVar = new b();
            this.f16856b = bVar;
            FragmentStateAdapter.this.registerAdapterDataObserver(bVar);
            AnonymousClass3 r22 = new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f16857c = r22;
            FragmentStateAdapter.this.mLifecycle.addObserver(r22);
        }

        /* access modifiers changed from: package-private */
        public void c(RecyclerView recyclerView) {
            a(recyclerView).unregisterOnPageChangeCallback(this.f16855a);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.f16856b);
            FragmentStateAdapter.this.mLifecycle.removeObserver(this.f16857c);
            this.f16858d = null;
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z10) {
            int currentItem;
            Fragment fragment;
            boolean z11;
            if (!FragmentStateAdapter.this.shouldDelayFragmentTransactions() && this.f16858d.getScrollState() == 0 && !FragmentStateAdapter.this.mFragments.isEmpty() && FragmentStateAdapter.this.getItemCount() != 0 && (currentItem = this.f16858d.getCurrentItem()) < FragmentStateAdapter.this.getItemCount()) {
                long itemId = FragmentStateAdapter.this.getItemId(currentItem);
                if ((itemId != this.f16859e || z10) && (fragment = FragmentStateAdapter.this.mFragments.get(itemId)) != null && fragment.isAdded()) {
                    this.f16859e = itemId;
                    FragmentTransaction beginTransaction = FragmentStateAdapter.this.mFragmentManager.beginTransaction();
                    ArrayList<List> arrayList = new ArrayList<>();
                    Fragment fragment2 = null;
                    for (int i10 = 0; i10 < FragmentStateAdapter.this.mFragments.size(); i10++) {
                        long keyAt = FragmentStateAdapter.this.mFragments.keyAt(i10);
                        Fragment valueAt = FragmentStateAdapter.this.mFragments.valueAt(i10);
                        if (valueAt.isAdded()) {
                            if (keyAt != this.f16859e) {
                                Lifecycle.State state = Lifecycle.State.STARTED;
                                beginTransaction.setMaxLifecycle(valueAt, state);
                                arrayList.add(FragmentStateAdapter.this.mFragmentEventDispatcher.a(valueAt, state));
                            } else {
                                fragment2 = valueAt;
                            }
                            if (keyAt == this.f16859e) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            valueAt.setMenuVisibility(z11);
                        }
                    }
                    if (fragment2 != null) {
                        Lifecycle.State state2 = Lifecycle.State.RESUMED;
                        beginTransaction.setMaxLifecycle(fragment2, state2);
                        arrayList.add(FragmentStateAdapter.this.mFragmentEventDispatcher.a(fragment2, state2));
                    }
                    if (!beginTransaction.isEmpty()) {
                        beginTransaction.commitNow();
                        Collections.reverse(arrayList);
                        for (List b10 : arrayList) {
                            FragmentStateAdapter.this.mFragmentEventDispatcher.b(b10);
                        }
                    }
                }
            }
        }
    }

    public static abstract class FragmentTransactionCallback {
        @NonNull
        private static final OnPostEventListener NO_OP = new a();

        public interface OnPostEventListener {
            void onPost();
        }

        class a implements OnPostEventListener {
            a() {
            }

            public void onPost() {
            }
        }

        @NonNull
        public OnPostEventListener onFragmentMaxLifecyclePreUpdated(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
            return NO_OP;
        }

        @NonNull
        public OnPostEventListener onFragmentPreAdded(@NonNull Fragment fragment) {
            return NO_OP;
        }

        @NonNull
        public OnPostEventListener onFragmentPreRemoved(@NonNull Fragment fragment) {
            return NO_OP;
        }

        @NonNull
        @ExperimentalFragmentStateAdapterApi
        public OnPostEventListener onFragmentPreSavedInstanceState(@NonNull Fragment fragment) {
            return NO_OP;
        }
    }

    class a extends FragmentManager.FragmentLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f16864a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FrameLayout f16865b;

        a(Fragment fragment, FrameLayout frameLayout) {
            this.f16864a = fragment;
            this.f16865b = frameLayout;
        }

        public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
            if (fragment == this.f16864a) {
                fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                FragmentStateAdapter.this.addViewToContainer(view, this.f16865b);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
            fragmentStateAdapter.mIsInGracePeriod = false;
            fragmentStateAdapter.gcFragments();
        }
    }

    private static abstract class c extends RecyclerView.AdapterDataObserver {
        private c() {
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

        public final void onItemRangeChanged(int i10, int i11, Object obj) {
            onChanged();
        }
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        private List f16868a = new CopyOnWriteArrayList();

        d() {
        }

        public List a(Fragment fragment, Lifecycle.State state) {
            ArrayList arrayList = new ArrayList();
            for (FragmentTransactionCallback onFragmentMaxLifecyclePreUpdated : this.f16868a) {
                arrayList.add(onFragmentMaxLifecyclePreUpdated.onFragmentMaxLifecyclePreUpdated(fragment, state));
            }
            return arrayList;
        }

        public void b(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((FragmentTransactionCallback.OnPostEventListener) it.next()).onPost();
            }
        }

        public List c(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            for (FragmentTransactionCallback onFragmentPreAdded : this.f16868a) {
                arrayList.add(onFragmentPreAdded.onFragmentPreAdded(fragment));
            }
            return arrayList;
        }

        public List d(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            for (FragmentTransactionCallback onFragmentPreRemoved : this.f16868a) {
                arrayList.add(onFragmentPreRemoved.onFragmentPreRemoved(fragment));
            }
            return arrayList;
        }

        public List e(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            for (FragmentTransactionCallback onFragmentPreSavedInstanceState : this.f16868a) {
                arrayList.add(onFragmentPreSavedInstanceState.onFragmentPreSavedInstanceState(fragment));
            }
            return arrayList;
        }

        public void f(FragmentTransactionCallback fragmentTransactionCallback) {
            this.f16868a.add(fragmentTransactionCallback);
        }

        public void g(FragmentTransactionCallback fragmentTransactionCallback) {
            this.f16868a.remove(fragmentTransactionCallback);
        }
    }

    public FragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    @NonNull
    private static String createKey(@NonNull String str, long j10) {
        return str + j10;
    }

    private void ensureFragment(int i10) {
        long itemId = getItemId(i10);
        if (!this.mFragments.containsKey(itemId)) {
            Fragment createFragment = createFragment(i10);
            createFragment.setInitialSavedState(this.mSavedStates.get(itemId));
            this.mFragments.put(itemId, createFragment);
        }
    }

    private boolean isFragmentViewBound(long j10) {
        View view;
        if (this.mItemIdToViewHolder.containsKey(j10)) {
            return true;
        }
        Fragment fragment = this.mFragments.get(j10);
        if (fragment == null || (view = fragment.getView()) == null) {
            return false;
        }
        if (view.getParent() != null) {
            return true;
        }
        return false;
    }

    private static boolean isValidKey(@NonNull String str, @NonNull String str2) {
        if (!str.startsWith(str2) || str.length() <= str2.length()) {
            return false;
        }
        return true;
    }

    private Long itemForViewHolder(int i10) {
        Long l10 = null;
        for (int i11 = 0; i11 < this.mItemIdToViewHolder.size(); i11++) {
            if (this.mItemIdToViewHolder.valueAt(i11).intValue() == i10) {
                if (l10 == null) {
                    l10 = Long.valueOf(this.mItemIdToViewHolder.keyAt(i11));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l10;
    }

    private static long parseIdFromKey(@NonNull String str, @NonNull String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void removeFragment(long j10) {
        ViewParent parent;
        Fragment fragment = this.mFragments.get(j10);
        if (fragment != null) {
            if (!(fragment.getView() == null || (parent = fragment.getView().getParent()) == null)) {
                ((FrameLayout) parent).removeAllViews();
            }
            if (!containsItem(j10)) {
                this.mSavedStates.remove(j10);
            }
            if (!fragment.isAdded()) {
                this.mFragments.remove(j10);
            } else if (shouldDelayFragmentTransactions()) {
                this.mHasStaleFragments = true;
            } else {
                if (fragment.isAdded() && containsItem(j10)) {
                    List e10 = this.mFragmentEventDispatcher.e(fragment);
                    Fragment.SavedState saveFragmentInstanceState = this.mFragmentManager.saveFragmentInstanceState(fragment);
                    this.mFragmentEventDispatcher.b(e10);
                    this.mSavedStates.put(j10, saveFragmentInstanceState);
                }
                List d10 = this.mFragmentEventDispatcher.d(fragment);
                try {
                    this.mFragmentManager.beginTransaction().remove(fragment).commitNow();
                    this.mFragments.remove(j10);
                } finally {
                    this.mFragmentEventDispatcher.b(d10);
                }
            }
        }
    }

    private void scheduleGracePeriodEnd() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final b bVar = new b();
        this.mLifecycle.addObserver(new LifecycleEventObserver() {
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(bVar);
                    lifecycleOwner.getLifecycle().removeObserver(this);
                }
            }
        });
        handler.postDelayed(bVar, 10000);
    }

    private void scheduleViewAttach(Fragment fragment, @NonNull FrameLayout frameLayout) {
        this.mFragmentManager.registerFragmentLifecycleCallbacks(new a(fragment, frameLayout), false);
    }

    /* access modifiers changed from: package-private */
    public void addViewToContainer(@NonNull View view, @NonNull FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    public boolean containsItem(long j10) {
        if (j10 < 0 || j10 >= ((long) getItemCount())) {
            return false;
        }
        return true;
    }

    @NonNull
    public abstract Fragment createFragment(int i10);

    /* access modifiers changed from: package-private */
    public void gcFragments() {
        if (this.mHasStaleFragments && !shouldDelayFragmentTransactions()) {
            ArraySet<Long> arraySet = new ArraySet<>();
            for (int i10 = 0; i10 < this.mFragments.size(); i10++) {
                long keyAt = this.mFragments.keyAt(i10);
                if (!containsItem(keyAt)) {
                    arraySet.add(Long.valueOf(keyAt));
                    this.mItemIdToViewHolder.remove(keyAt);
                }
            }
            if (!this.mIsInGracePeriod) {
                this.mHasStaleFragments = false;
                for (int i11 = 0; i11 < this.mFragments.size(); i11++) {
                    long keyAt2 = this.mFragments.keyAt(i11);
                    if (!isFragmentViewBound(keyAt2)) {
                        arraySet.add(Long.valueOf(keyAt2));
                    }
                }
            }
            for (Long longValue : arraySet) {
                removeFragment(longValue.longValue());
            }
        }
    }

    public long getItemId(int i10) {
        return (long) i10;
    }

    @CallSuper
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        boolean z10;
        if (this.mFragmentMaxLifecycleEnforcer == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.mFragmentMaxLifecycleEnforcer = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.b(recyclerView);
    }

    @CallSuper
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        this.mFragmentMaxLifecycleEnforcer.c(recyclerView);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    public final boolean onFailedToRecycleView(@NonNull FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void placeFragmentInViewHolder(@NonNull final FragmentViewHolder fragmentViewHolder) {
        Fragment fragment = this.mFragments.get(fragmentViewHolder.getItemId());
        if (fragment != null) {
            FrameLayout container = fragmentViewHolder.getContainer();
            View view = fragment.getView();
            if (!fragment.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            } else if (fragment.isAdded() && view == null) {
                scheduleViewAttach(fragment, container);
            } else if (!fragment.isAdded() || view.getParent() == null) {
                if (fragment.isAdded()) {
                    addViewToContainer(view, container);
                } else if (!shouldDelayFragmentTransactions()) {
                    scheduleViewAttach(fragment, container);
                    List c10 = this.mFragmentEventDispatcher.c(fragment);
                    try {
                        fragment.setMenuVisibility(false);
                        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
                        beginTransaction.add(fragment, "f" + fragmentViewHolder.getItemId()).setMaxLifecycle(fragment, Lifecycle.State.STARTED).commitNow();
                        this.mFragmentMaxLifecycleEnforcer.d(false);
                    } finally {
                        this.mFragmentEventDispatcher.b(c10);
                    }
                } else if (!this.mFragmentManager.isDestroyed()) {
                    this.mLifecycle.addObserver(new LifecycleEventObserver() {
                        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                            if (!FragmentStateAdapter.this.shouldDelayFragmentTransactions()) {
                                lifecycleOwner.getLifecycle().removeObserver(this);
                                if (fragmentViewHolder.getContainer().isAttachedToWindow()) {
                                    FragmentStateAdapter.this.placeFragmentInViewHolder(fragmentViewHolder);
                                }
                            }
                        }
                    });
                }
            } else if (view.getParent() != container) {
                addViewToContainer(view, container);
            }
        } else {
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    public void registerFragmentTransactionCallback(@NonNull FragmentTransactionCallback fragmentTransactionCallback) {
        this.mFragmentEventDispatcher.f(fragmentTransactionCallback);
    }

    public final void restoreState(@NonNull Parcelable parcelable) {
        if (!this.mSavedStates.isEmpty() || !this.mFragments.isEmpty()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String next : bundle.keySet()) {
            if (isValidKey(next, KEY_PREFIX_FRAGMENT)) {
                this.mFragments.put(parseIdFromKey(next, KEY_PREFIX_FRAGMENT), this.mFragmentManager.getFragment(bundle, next));
            } else if (isValidKey(next, KEY_PREFIX_STATE)) {
                long parseIdFromKey = parseIdFromKey(next, KEY_PREFIX_STATE);
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(next);
                if (containsItem(parseIdFromKey)) {
                    this.mSavedStates.put(parseIdFromKey, savedState);
                }
            } else {
                throw new IllegalArgumentException("Unexpected key in savedState: " + next);
            }
        }
        if (!this.mFragments.isEmpty()) {
            this.mHasStaleFragments = true;
            this.mIsInGracePeriod = true;
            gcFragments();
            scheduleGracePeriodEnd();
        }
    }

    @NonNull
    public final Parcelable saveState() {
        Bundle bundle = new Bundle(this.mFragments.size() + this.mSavedStates.size());
        for (int i10 = 0; i10 < this.mFragments.size(); i10++) {
            long keyAt = this.mFragments.keyAt(i10);
            Fragment fragment = this.mFragments.get(keyAt);
            if (fragment != null && fragment.isAdded()) {
                this.mFragmentManager.putFragment(bundle, createKey(KEY_PREFIX_FRAGMENT, keyAt), fragment);
            }
        }
        for (int i11 = 0; i11 < this.mSavedStates.size(); i11++) {
            long keyAt2 = this.mSavedStates.keyAt(i11);
            if (containsItem(keyAt2)) {
                bundle.putParcelable(createKey(KEY_PREFIX_STATE, keyAt2), this.mSavedStates.get(keyAt2));
            }
        }
        return bundle;
    }

    public final void setHasStableIds(boolean z10) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.isStateSaved();
    }

    public void unregisterFragmentTransactionCallback(@NonNull FragmentTransactionCallback fragmentTransactionCallback) {
        this.mFragmentEventDispatcher.g(fragmentTransactionCallback);
    }

    public FragmentStateAdapter(@NonNull Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    public final void onBindViewHolder(@NonNull FragmentViewHolder fragmentViewHolder, int i10) {
        long itemId = fragmentViewHolder.getItemId();
        int id2 = fragmentViewHolder.getContainer().getId();
        Long itemForViewHolder = itemForViewHolder(id2);
        if (!(itemForViewHolder == null || itemForViewHolder.longValue() == itemId)) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.remove(itemForViewHolder.longValue());
        }
        this.mItemIdToViewHolder.put(itemId, Integer.valueOf(id2));
        ensureFragment(i10);
        if (fragmentViewHolder.getContainer().isAttachedToWindow()) {
            placeFragmentInViewHolder(fragmentViewHolder);
        }
        gcFragments();
    }

    @NonNull
    public final FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return FragmentViewHolder.create(viewGroup);
    }

    public final void onViewAttachedToWindow(@NonNull FragmentViewHolder fragmentViewHolder) {
        placeFragmentInViewHolder(fragmentViewHolder);
        gcFragments();
    }

    public final void onViewRecycled(@NonNull FragmentViewHolder fragmentViewHolder) {
        Long itemForViewHolder = itemForViewHolder(fragmentViewHolder.getContainer().getId());
        if (itemForViewHolder != null) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.remove(itemForViewHolder.longValue());
        }
    }

    public FragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        this.mFragments = new LongSparseArray<>();
        this.mSavedStates = new LongSparseArray<>();
        this.mItemIdToViewHolder = new LongSparseArray<>();
        this.mFragmentEventDispatcher = new d();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = fragmentManager;
        this.mLifecycle = lifecycle;
        super.setHasStableIds(true);
    }
}
