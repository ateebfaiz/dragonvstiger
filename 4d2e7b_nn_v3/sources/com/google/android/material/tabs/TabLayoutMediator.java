package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

public final class TabLayoutMediator {
    @Nullable
    private RecyclerView.Adapter<?> adapter;
    private boolean attached;
    private final boolean autoRefresh;
    @Nullable
    private b onPageChangeCallback;
    @Nullable
    private TabLayout.OnTabSelectedListener onTabSelectedListener;
    @Nullable
    private RecyclerView.AdapterDataObserver pagerAdapterObserver;
    private final boolean smoothScroll;
    private final TabConfigurationStrategy tabConfigurationStrategy;
    @NonNull
    private final TabLayout tabLayout;
    @NonNull
    private final ViewPager2 viewPager;

    public interface TabConfigurationStrategy {
        void onConfigureTab(@NonNull TabLayout.Tab tab, int i10);
    }

    private class a extends RecyclerView.AdapterDataObserver {
        a() {
        }

        public void onChanged() {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeChanged(int i10, int i11) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeInserted(int i10, int i11) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeMoved(int i10, int i11, int i12) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeRemoved(int i10, int i11) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeChanged(int i10, int i11, Object obj) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }
    }

    private static class b extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference f8543a;

        /* renamed from: b  reason: collision with root package name */
        private int f8544b;

        /* renamed from: c  reason: collision with root package name */
        private int f8545c;

        b(TabLayout tabLayout) {
            this.f8543a = new WeakReference(tabLayout);
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f8545c = 0;
            this.f8544b = 0;
        }

        public void onPageScrollStateChanged(int i10) {
            this.f8544b = this.f8545c;
            this.f8545c = i10;
        }

        public void onPageScrolled(int i10, float f10, int i11) {
            boolean z10;
            TabLayout tabLayout = (TabLayout) this.f8543a.get();
            if (tabLayout != null) {
                int i12 = this.f8545c;
                boolean z11 = false;
                if (i12 != 2 || this.f8544b == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!(i12 == 2 && this.f8544b == 0)) {
                    z11 = true;
                }
                tabLayout.setScrollPosition(i10, f10, z10, z11);
            }
        }

        public void onPageSelected(int i10) {
            boolean z10;
            TabLayout tabLayout = (TabLayout) this.f8543a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i10 && i10 < tabLayout.getTabCount()) {
                int i11 = this.f8545c;
                if (i11 == 0 || (i11 == 2 && this.f8544b == 0)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                tabLayout.selectTab(tabLayout.getTabAt(i10), z10);
            }
        }
    }

    private static class c implements TabLayout.OnTabSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager2 f8546a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f8547b;

        c(ViewPager2 viewPager2, boolean z10) {
            this.f8546a = viewPager2;
            this.f8547b = z10;
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        public void onTabSelected(TabLayout.Tab tab) {
            this.f8546a.setCurrentItem(tab.getPosition(), this.f8547b);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout2, @NonNull ViewPager2 viewPager2, @NonNull TabConfigurationStrategy tabConfigurationStrategy2) {
        this(tabLayout2, viewPager2, true, tabConfigurationStrategy2);
    }

    public void attach() {
        if (!this.attached) {
            RecyclerView.Adapter<?> adapter2 = this.viewPager.getAdapter();
            this.adapter = adapter2;
            if (adapter2 != null) {
                this.attached = true;
                b bVar = new b(this.tabLayout);
                this.onPageChangeCallback = bVar;
                this.viewPager.registerOnPageChangeCallback(bVar);
                c cVar = new c(this.viewPager, this.smoothScroll);
                this.onTabSelectedListener = cVar;
                this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) cVar);
                if (this.autoRefresh) {
                    a aVar = new a();
                    this.pagerAdapterObserver = aVar;
                    this.adapter.registerAdapterDataObserver(aVar);
                }
                populateTabsFromPagerAdapter();
                this.tabLayout.setScrollPosition(this.viewPager.getCurrentItem(), 0.0f, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public void detach() {
        RecyclerView.Adapter<?> adapter2;
        if (this.autoRefresh && (adapter2 = this.adapter) != null) {
            adapter2.unregisterAdapterDataObserver(this.pagerAdapterObserver);
            this.pagerAdapterObserver = null;
        }
        this.tabLayout.removeOnTabSelectedListener(this.onTabSelectedListener);
        this.viewPager.unregisterOnPageChangeCallback(this.onPageChangeCallback);
        this.onTabSelectedListener = null;
        this.onPageChangeCallback = null;
        this.adapter = null;
        this.attached = false;
    }

    public boolean isAttached() {
        return this.attached;
    }

    /* access modifiers changed from: package-private */
    public void populateTabsFromPagerAdapter() {
        int min;
        this.tabLayout.removeAllTabs();
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 != null) {
            int itemCount = adapter2.getItemCount();
            for (int i10 = 0; i10 < itemCount; i10++) {
                TabLayout.Tab newTab = this.tabLayout.newTab();
                this.tabConfigurationStrategy.onConfigureTab(newTab, i10);
                this.tabLayout.addTab(newTab, false);
            }
            if (itemCount > 0 && (min = Math.min(this.viewPager.getCurrentItem(), this.tabLayout.getTabCount() - 1)) != this.tabLayout.getSelectedTabPosition()) {
                TabLayout tabLayout2 = this.tabLayout;
                tabLayout2.selectTab(tabLayout2.getTabAt(min));
            }
        }
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout2, @NonNull ViewPager2 viewPager2, boolean z10, @NonNull TabConfigurationStrategy tabConfigurationStrategy2) {
        this(tabLayout2, viewPager2, z10, true, tabConfigurationStrategy2);
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout2, @NonNull ViewPager2 viewPager2, boolean z10, boolean z11, @NonNull TabConfigurationStrategy tabConfigurationStrategy2) {
        this.tabLayout = tabLayout2;
        this.viewPager = viewPager2;
        this.autoRefresh = z10;
        this.smoothScroll = z11;
        this.tabConfigurationStrategy = tabConfigurationStrategy2;
    }
}
