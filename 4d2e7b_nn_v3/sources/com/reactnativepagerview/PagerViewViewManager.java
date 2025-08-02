package com.reactnativepagerview;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.events.e;
import e6.f;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import wa.c;

public final class PagerViewViewManager extends ViewGroupManager<NestedScrollableHost> {
    private static final String COMMAND_SET_PAGE = "setPage";
    private static final String COMMAND_SET_PAGE_WITHOUT_ANIMATION = "setPageWithoutAnimation";
    private static final String COMMAND_SET_SCROLL_ENABLED = "setScrollEnabledImperatively";
    public static final a Companion = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public e eventDispatcher;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PagerViewViewManager f11333a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NestedScrollableHost f11334b;

        b(PagerViewViewManager pagerViewViewManager, NestedScrollableHost nestedScrollableHost) {
            this.f11333a = pagerViewViewManager;
            this.f11334b = nestedScrollableHost;
        }

        public void onPageScrollStateChanged(int i10) {
            String str;
            super.onPageScrollStateChanged(i10);
            if (i10 == 0) {
                str = "idle";
            } else if (i10 == 1) {
                str = "dragging";
            } else if (i10 == 2) {
                str = "settling";
            } else {
                throw new IllegalStateException("Unsupported pageScrollState");
            }
            e access$getEventDispatcher$p = this.f11333a.eventDispatcher;
            if (access$getEventDispatcher$p == null) {
                m.u("eventDispatcher");
                access$getEventDispatcher$p = null;
            }
            access$getEventDispatcher$p.c(new wa.b(this.f11334b.getId(), str));
        }

        public void onPageScrolled(int i10, float f10, int i11) {
            super.onPageScrolled(i10, f10, i11);
            e access$getEventDispatcher$p = this.f11333a.eventDispatcher;
            if (access$getEventDispatcher$p == null) {
                m.u("eventDispatcher");
                access$getEventDispatcher$p = null;
            }
            access$getEventDispatcher$p.c(new wa.a(this.f11334b.getId(), i10, f10));
        }

        public void onPageSelected(int i10) {
            super.onPageSelected(i10);
            e access$getEventDispatcher$p = this.f11333a.eventDispatcher;
            if (access$getEventDispatcher$p == null) {
                m.u("eventDispatcher");
                access$getEventDispatcher$p = null;
            }
            access$getEventDispatcher$p.c(new c(this.f11334b.getId(), i10));
        }
    }

    /* access modifiers changed from: private */
    public static final void createViewInstance$lambda$0(ViewPager2 viewPager2, PagerViewViewManager pagerViewViewManager, NestedScrollableHost nestedScrollableHost) {
        m.f(viewPager2, "$vp");
        m.f(pagerViewViewManager, "this$0");
        m.f(nestedScrollableHost, "$host");
        viewPager2.registerOnPageChangeCallback(new b(pagerViewViewManager, nestedScrollableHost));
        e eVar = pagerViewViewManager.eventDispatcher;
        if (eVar == null) {
            m.u("eventDispatcher");
            eVar = null;
        }
        eVar.c(new c(nestedScrollableHost.getId(), viewPager2.getCurrentItem()));
    }

    public Map<String, Map<String, String>> getExportedCustomDirectEventTypeConstants() {
        Map<String, Map<String, String>> f10 = f.f("topPageScroll", f.d("registrationName", "onPageScroll"), "topPageScrollStateChanged", f.d("registrationName", "onPageScrollStateChanged"), "topPageSelected", f.d("registrationName", "onPageSelected"));
        m.e(f10, "of(...)");
        return f10;
    }

    public String getName() {
        return "RNCViewPager";
    }

    public boolean needsCustomLayoutForChildren() {
        return f.f11342a.h();
    }

    @h7.a(defaultInt = -1, name = "offscreenPageLimit")
    public final void set(NestedScrollableHost nestedScrollableHost, int i10) {
        m.f(nestedScrollableHost, "host");
        f.f11342a.r(nestedScrollableHost, i10);
    }

    @h7.a(defaultInt = 0, name = "initialPage")
    public final void setInitialPage(NestedScrollableHost nestedScrollableHost, int i10) {
        m.f(nestedScrollableHost, "host");
        f.f11342a.o(nestedScrollableHost, i10);
    }

    @h7.a(name = "layoutDirection")
    public final void setLayoutDirection(NestedScrollableHost nestedScrollableHost, String str) {
        m.f(nestedScrollableHost, "host");
        m.f(str, "value");
        f.f11342a.q(nestedScrollableHost, str);
    }

    @h7.a(name = "orientation")
    public final void setOrientation(NestedScrollableHost nestedScrollableHost, String str) {
        m.f(nestedScrollableHost, "host");
        m.f(str, "value");
        f.f11342a.s(nestedScrollableHost, str);
    }

    @h7.a(name = "overScrollMode")
    public final void setOverScrollMode(NestedScrollableHost nestedScrollableHost, String str) {
        m.f(nestedScrollableHost, "host");
        m.f(str, "value");
        f.f11342a.t(nestedScrollableHost, str);
    }

    @h7.a(defaultInt = 0, name = "pageMargin")
    public final void setPageMargin(NestedScrollableHost nestedScrollableHost, int i10) {
        m.f(nestedScrollableHost, "host");
        f.f11342a.u(nestedScrollableHost, i10);
    }

    @h7.a(defaultBoolean = true, name = "scrollEnabled")
    public final void setScrollEnabled(NestedScrollableHost nestedScrollableHost, boolean z10) {
        m.f(nestedScrollableHost, "host");
        f.f11342a.w(nestedScrollableHost, z10);
    }

    /* access modifiers changed from: protected */
    public NestedScrollableHost createViewInstance(e1 e1Var) {
        m.f(e1Var, "reactContext");
        NestedScrollableHost nestedScrollableHost = new NestedScrollableHost(e1Var);
        nestedScrollableHost.setId(View.generateViewId());
        nestedScrollableHost.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        nestedScrollableHost.setSaveEnabled(false);
        ViewPager2 viewPager2 = new ViewPager2(e1Var);
        viewPager2.setAdapter(new g());
        viewPager2.setSaveEnabled(false);
        NativeModule nativeModule = e1Var.getNativeModule(UIManagerModule.class);
        m.c(nativeModule);
        e eventDispatcher2 = ((UIManagerModule) nativeModule).getEventDispatcher();
        m.e(eventDispatcher2, "getEventDispatcher(...)");
        this.eventDispatcher = eventDispatcher2;
        viewPager2.post(new b(viewPager2, this, nestedScrollableHost));
        nestedScrollableHost.addView(viewPager2);
        return nestedScrollableHost;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        if (r9.equals(COMMAND_SET_PAGE) != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        if (r9.equals(COMMAND_SET_PAGE_WITHOUT_ANIMATION) != false) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveCommand(com.reactnativepagerview.NestedScrollableHost r8, java.lang.String r9, com.facebook.react.bridge.ReadableArray r10) {
        /*
            r7 = this;
            r0 = 2
            r1 = 0
            java.lang.String r2 = "root"
            kotlin.jvm.internal.m.f(r8, r2)
            super.receiveCommand(r8, (java.lang.String) r9, (com.facebook.react.bridge.ReadableArray) r10)
            com.reactnativepagerview.f r2 = com.reactnativepagerview.f.f11342a
            androidx.viewpager2.widget.ViewPager2 r8 = r2.g(r8)
            p5.a.c(r8)
            p5.a.c(r10)
            androidx.recyclerview.widget.RecyclerView$Adapter r3 = r8.getAdapter()
            if (r3 == 0) goto L_0x0025
            int r3 = r3.getItemCount()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0026
        L_0x0025:
            r3 = 0
        L_0x0026:
            if (r9 == 0) goto L_0x007e
            int r4 = r9.hashCode()
            r5 = -445763635(0xffffffffe56e2fcd, float:-7.030031E22)
            java.lang.String r6 = "setPage"
            if (r4 == r5) goto L_0x0057
            r5 = 1747675147(0x682b680b, float:3.2377757E24)
            if (r4 == r5) goto L_0x0044
            r5 = 1984860689(0x764e9211, float:1.0474372E33)
            if (r4 != r5) goto L_0x007e
            boolean r4 = r9.equals(r6)
            if (r4 == 0) goto L_0x007e
            goto L_0x005f
        L_0x0044:
            java.lang.String r2 = "setScrollEnabledImperatively"
            boolean r2 = r9.equals(r2)
            if (r2 == 0) goto L_0x007e
            kotlin.jvm.internal.m.c(r10)
            boolean r9 = r10.getBoolean(r1)
            r8.setUserInputEnabled(r9)
            goto L_0x007d
        L_0x0057:
            java.lang.String r4 = "setPageWithoutAnimation"
            boolean r4 = r9.equals(r4)
            if (r4 == 0) goto L_0x007e
        L_0x005f:
            kotlin.jvm.internal.m.c(r10)
            int r10 = r10.getInt(r1)
            if (r3 == 0) goto L_0x007d
            int r0 = r3.intValue()
            if (r0 <= 0) goto L_0x007d
            if (r10 < 0) goto L_0x007d
            int r0 = r3.intValue()
            if (r10 >= r0) goto L_0x007d
            boolean r9 = kotlin.jvm.internal.m.b(r9, r6)
            r2.n(r8, r10, r9)
        L_0x007d:
            return
        L_0x007e:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            kotlin.jvm.internal.b0 r10 = kotlin.jvm.internal.b0.f709a
            java.lang.Class<com.reactnativepagerview.PagerViewViewManager> r10 = com.reactnativepagerview.PagerViewViewManager.class
            java.lang.String r10 = r10.getSimpleName()
            java.lang.Object[] r2 = new java.lang.Object[r0]
            r2[r1] = r9
            r9 = 1
            r2[r9] = r10
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r2, r0)
            java.lang.String r10 = "Unsupported command %d received by %s."
            java.lang.String r9 = java.lang.String.format(r10, r9)
            java.lang.String r10 = "format(...)"
            kotlin.jvm.internal.m.e(r9, r10)
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativepagerview.PagerViewViewManager.receiveCommand(com.reactnativepagerview.NestedScrollableHost, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }

    public void removeAllViews(NestedScrollableHost nestedScrollableHost) {
        m.f(nestedScrollableHost, "parent");
        f.f11342a.k(nestedScrollableHost);
    }

    public void removeView(NestedScrollableHost nestedScrollableHost, View view) {
        m.f(nestedScrollableHost, "parent");
        m.f(view, "view");
        f.f11342a.l(nestedScrollableHost, view);
    }

    public void addView(NestedScrollableHost nestedScrollableHost, View view, int i10) {
        m.f(nestedScrollableHost, "host");
        m.f(view, "child");
        f.f11342a.d(nestedScrollableHost, view, i10);
    }

    public View getChildAt(NestedScrollableHost nestedScrollableHost, int i10) {
        m.f(nestedScrollableHost, "parent");
        return f.f11342a.e(nestedScrollableHost, i10);
    }

    public int getChildCount(NestedScrollableHost nestedScrollableHost) {
        m.f(nestedScrollableHost, "parent");
        return f.f11342a.f(nestedScrollableHost);
    }

    public void removeViewAt(NestedScrollableHost nestedScrollableHost, int i10) {
        m.f(nestedScrollableHost, "parent");
        f.f11342a.m(nestedScrollableHost, i10);
    }
}
