package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.widget.SearchView;
import cb.k;
import cb.l;
import cb.o;
import cb.p;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.k1;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.n;

@SuppressLint({"ViewConstructor"})
public final class SearchBarView extends ReactViewGroup {
    private boolean C;
    private final int N0 = k1.f(this);

    /* renamed from: a  reason: collision with root package name */
    private b f11582a = b.f11599a;

    /* renamed from: b  reason: collision with root package name */
    private a f11583b = a.NONE;

    /* renamed from: c  reason: collision with root package name */
    private Integer f11584c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f11585d;

    /* renamed from: e  reason: collision with root package name */
    private Integer f11586e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f11587f;

    /* renamed from: g  reason: collision with root package name */
    private String f11588g = "";

    /* renamed from: h  reason: collision with root package name */
    private boolean f11589h = true;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11590i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11591j = true;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public a0 f11592w;

    public enum a {
        NONE,
        WORDS,
        SENTENCES,
        CHARACTERS;

        static {
            a[] a10;
            f11598f = pb.a.a(a10);
        }
    }

    public enum b {
        ;

        static final class a extends b {
            a(String str, int i10) {
                super(str, i10, (DefaultConstructorMarker) null);
            }

            public int b(a aVar) {
                m.f(aVar, "capitalize");
                return 32;
            }
        }

        /* renamed from: com.swmansion.rnscreens.SearchBarView$b$b  reason: collision with other inner class name */
        static final class C0130b extends b {
            C0130b(String str, int i10) {
                super(str, i10, (DefaultConstructorMarker) null);
            }

            public int b(a aVar) {
                m.f(aVar, "capitalize");
                return 2;
            }
        }

        static final class c extends b {
            c(String str, int i10) {
                super(str, i10, (DefaultConstructorMarker) null);
            }

            public int b(a aVar) {
                m.f(aVar, "capitalize");
                return 3;
            }
        }

        static final class d extends b {

            public /* synthetic */ class a {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f11605a = null;

                /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
                static {
                    /*
                        com.swmansion.rnscreens.SearchBarView$a[] r0 = com.swmansion.rnscreens.SearchBarView.a.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        com.swmansion.rnscreens.SearchBarView$a r1 = com.swmansion.rnscreens.SearchBarView.a.NONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                        r2 = 1
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                    L_0x0010:
                        com.swmansion.rnscreens.SearchBarView$a r1 = com.swmansion.rnscreens.SearchBarView.a.WORDS     // Catch:{ NoSuchFieldError -> 0x0019 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                        r2 = 2
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                    L_0x0019:
                        com.swmansion.rnscreens.SearchBarView$a r1 = com.swmansion.rnscreens.SearchBarView.a.SENTENCES     // Catch:{ NoSuchFieldError -> 0x0022 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                        r2 = 3
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                    L_0x0022:
                        com.swmansion.rnscreens.SearchBarView$a r1 = com.swmansion.rnscreens.SearchBarView.a.CHARACTERS     // Catch:{ NoSuchFieldError -> 0x002b }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                        r2 = 4
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                    L_0x002b:
                        f11605a = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.SearchBarView.b.d.a.<clinit>():void");
                }
            }

            d(String str, int i10) {
                super(str, i10, (DefaultConstructorMarker) null);
            }

            public int b(a aVar) {
                m.f(aVar, "capitalize");
                int i10 = a.f11605a[aVar.ordinal()];
                if (i10 == 1) {
                    return 1;
                }
                if (i10 == 2) {
                    return 8192;
                }
                if (i10 == 3) {
                    return 16384;
                }
                if (i10 == 4) {
                    return 4096;
                }
                throw new n();
            }
        }

        static {
            b[] a10;
            f11604f = pb.a.a(a10);
        }

        public abstract int b(a aVar);
    }

    static final class c extends kotlin.jvm.internal.n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchBarView f11606a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(SearchBarView searchBarView) {
            super(1);
            this.f11606a = searchBarView;
        }

        public final void a(CustomSearchView customSearchView) {
            ScreenStackFragment s10;
            CustomSearchView G;
            m.f(customSearchView, "newSearchView");
            if (this.f11606a.f11592w == null) {
                this.f11606a.f11592w = new a0(customSearchView);
            }
            this.f11606a.N();
            if (this.f11606a.getAutoFocus() && (s10 = this.f11606a.getScreenStackFragment()) != null && (G = s10.G()) != null) {
                G.f();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((CustomSearchView) obj);
            return Unit.f12577a;
        }
    }

    public static final class d implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchBarView f11607a;

        d(SearchBarView searchBarView) {
            this.f11607a = searchBarView;
        }

        public boolean onQueryTextChange(String str) {
            this.f11607a.F(str);
            return true;
        }

        public boolean onQueryTextSubmit(String str) {
            this.f11607a.G(str);
            return true;
        }
    }

    public SearchBarView(ReactContext reactContext) {
        super(reactContext);
    }

    private final void A() {
        J(new cb.m(this.N0, getId()));
        setToolbarElementsVisibility(0);
    }

    private final void B(boolean z10) {
        com.facebook.react.uimanager.events.d dVar;
        if (z10) {
            dVar = new cb.n(this.N0, getId());
        } else {
            dVar = new k(this.N0, getId());
        }
        J(dVar);
    }

    private final void D() {
        J(new o(this.N0, getId()));
        setToolbarElementsVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void F(String str) {
        J(new l(this.N0, getId(), str));
    }

    /* access modifiers changed from: private */
    public final void G(String str) {
        J(new p(this.N0, getId(), str));
    }

    private final void J(com.facebook.react.uimanager.events.d dVar) {
        Context context = getContext();
        m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        e c10 = k1.c((ReactContext) context, getId());
        if (c10 != null) {
            c10.c(dVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void K(SearchBarView searchBarView, View view, boolean z10) {
        m.f(searchBarView, "this$0");
        searchBarView.B(z10);
    }

    /* access modifiers changed from: private */
    public static final boolean L(SearchBarView searchBarView) {
        m.f(searchBarView, "this$0");
        searchBarView.A();
        return false;
    }

    /* access modifiers changed from: private */
    public static final void M(SearchBarView searchBarView, View view) {
        m.f(searchBarView, "this$0");
        searchBarView.D();
    }

    /* access modifiers changed from: private */
    public final void N() {
        CustomSearchView customSearchView;
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        if (screenStackFragment != null) {
            customSearchView = screenStackFragment.G();
        } else {
            customSearchView = null;
        }
        if (customSearchView != null) {
            if (!this.C) {
                setSearchViewListeners(customSearchView);
                this.C = true;
            }
            customSearchView.setInputType(this.f11582a.b(this.f11583b));
            a0 a0Var = this.f11592w;
            if (a0Var != null) {
                a0Var.h(this.f11584c);
            }
            a0 a0Var2 = this.f11592w;
            if (a0Var2 != null) {
                a0Var2.i(this.f11585d);
            }
            a0 a0Var3 = this.f11592w;
            if (a0Var3 != null) {
                a0Var3.e(this.f11586e);
            }
            a0 a0Var4 = this.f11592w;
            if (a0Var4 != null) {
                a0Var4.f(this.f11587f);
            }
            a0 a0Var5 = this.f11592w;
            if (a0Var5 != null) {
                a0Var5.g(this.f11588g, this.f11591j);
            }
            customSearchView.setOverrideBackAction(this.f11589h);
        }
    }

    private final ScreenStackHeaderConfig getHeaderConfig() {
        ViewParent parent = getParent();
        if (parent instanceof ScreenStackHeaderSubview) {
            return ((ScreenStackHeaderSubview) parent).getConfig();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final ScreenStackFragment getScreenStackFragment() {
        ScreenStackHeaderConfig headerConfig = getHeaderConfig();
        if (headerConfig != null) {
            return headerConfig.getScreenFragment();
        }
        return null;
    }

    private final void setSearchViewListeners(SearchView searchView) {
        searchView.setOnQueryTextListener(new d(this));
        searchView.setOnQueryTextFocusChangeListener(new x(this));
        searchView.setOnCloseListener(new y(this));
        searchView.setOnSearchClickListener(new z(this));
    }

    private final void setToolbarElementsVisibility(int i10) {
        int i11;
        ScreenStackHeaderSubview screenStackHeaderSubview;
        ScreenStackHeaderConfig headerConfig = getHeaderConfig();
        int i12 = 0;
        if (headerConfig != null) {
            i11 = headerConfig.getConfigSubviewsCount() - 1;
        } else {
            i11 = 0;
        }
        if (i11 >= 0) {
            while (true) {
                ScreenStackHeaderConfig headerConfig2 = getHeaderConfig();
                ScreenStackHeaderSubview.a aVar = null;
                if (headerConfig2 != null) {
                    screenStackHeaderSubview = headerConfig2.e(i12);
                } else {
                    screenStackHeaderSubview = null;
                }
                if (screenStackHeaderSubview != null) {
                    aVar = screenStackHeaderSubview.getType();
                }
                if (!(aVar == ScreenStackHeaderSubview.a.SEARCH_BAR || screenStackHeaderSubview == null)) {
                    screenStackHeaderSubview.setVisibility(i10);
                }
                if (i12 != i11) {
                    i12++;
                } else {
                    return;
                }
            }
        }
    }

    public final void C() {
        CustomSearchView G;
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        if (screenStackFragment != null && (G = screenStackFragment.G()) != null) {
            G.f();
        }
    }

    public final void E(String str) {
        ScreenStackFragment screenStackFragment;
        CustomSearchView G;
        if (str != null && (screenStackFragment = getScreenStackFragment()) != null && (G = screenStackFragment.G()) != null) {
            G.setText(str);
        }
    }

    public final void H(boolean z10) {
    }

    public final void I() {
        N();
    }

    public final a getAutoCapitalize() {
        return this.f11583b;
    }

    public final boolean getAutoFocus() {
        return this.f11590i;
    }

    public final Integer getHeaderIconColor() {
        return this.f11586e;
    }

    public final Integer getHintTextColor() {
        return this.f11587f;
    }

    public final b getInputType() {
        return this.f11582a;
    }

    public final String getPlaceholder() {
        return this.f11588g;
    }

    public final boolean getShouldOverrideBackButton() {
        return this.f11589h;
    }

    public final boolean getShouldShowHintSearchIcon() {
        return this.f11591j;
    }

    public final Integer getTextColor() {
        return this.f11584c;
    }

    public final Integer getTintColor() {
        return this.f11585d;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        if (screenStackFragment != null) {
            screenStackFragment.J(new c(this));
        }
    }

    public final void setAutoCapitalize(a aVar) {
        m.f(aVar, "<set-?>");
        this.f11583b = aVar;
    }

    public final void setAutoFocus(boolean z10) {
        this.f11590i = z10;
    }

    public final void setHeaderIconColor(Integer num) {
        this.f11586e = num;
    }

    public final void setHintTextColor(Integer num) {
        this.f11587f = num;
    }

    public final void setInputType(b bVar) {
        m.f(bVar, "<set-?>");
        this.f11582a = bVar;
    }

    public final void setPlaceholder(String str) {
        m.f(str, "<set-?>");
        this.f11588g = str;
    }

    public final void setShouldOverrideBackButton(boolean z10) {
        this.f11589h = z10;
    }

    public final void setShouldShowHintSearchIcon(boolean z10) {
        this.f11591j = z10;
    }

    public final void setTextColor(Integer num) {
        this.f11584c = num;
    }

    public final void setTintColor(Integer num) {
        this.f11585d = num;
    }

    public final void y() {
        CustomSearchView G;
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        if (screenStackFragment != null && (G = screenStackFragment.G()) != null) {
            G.clearFocus();
        }
    }

    public final void z() {
        CustomSearchView G;
        ScreenStackFragment screenStackFragment = getScreenStackFragment();
        if (screenStackFragment != null && (G = screenStackFragment.G()) != null) {
            G.e();
        }
    }
}
