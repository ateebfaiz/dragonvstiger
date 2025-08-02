package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import cb.q;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.k1;
import com.swmansion.rnscreens.Screen;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;

public final class ScreenStack extends ScreenContainer {
    public static final a S0 = new a((DefaultConstructorMarker) null);
    private n C;
    private boolean N0;
    private boolean O0;
    private boolean P0;
    private int Q0;
    private boolean R0;

    /* renamed from: h  reason: collision with root package name */
    private final ArrayList f11545h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private final Set f11546i = new HashSet();

    /* renamed from: j  reason: collision with root package name */
    private final List f11547j = new ArrayList();

    /* renamed from: w  reason: collision with root package name */
    private List f11548w = new ArrayList();

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final boolean b(l lVar) {
            if (Build.VERSION.SDK_INT >= 33 || lVar.i().getStackAnimation() == Screen.c.SLIDE_FROM_BOTTOM || lVar.i().getStackAnimation() == Screen.c.FADE_FROM_BOTTOM || lVar.i().getStackAnimation() == Screen.c.IOS || lVar.i().getStackAnimation() == Screen.c.IOS_FROM_RIGHT || lVar.i().getStackAnimation() == Screen.c.IOS_FROM_LEFT) {
                return true;
            }
            return false;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final class b {

        /* renamed from: a  reason: collision with root package name */
        private Canvas f11549a;

        /* renamed from: b  reason: collision with root package name */
        private View f11550b;

        /* renamed from: c  reason: collision with root package name */
        private long f11551c;

        public b() {
        }

        public final void a() {
            ScreenStack.this.J(this);
            this.f11549a = null;
            this.f11550b = null;
            this.f11551c = 0;
        }

        public final Canvas b() {
            return this.f11549a;
        }

        public final View c() {
            return this.f11550b;
        }

        public final long d() {
            return this.f11551c;
        }

        public final void e(Canvas canvas) {
            this.f11549a = canvas;
        }

        public final void f(View view) {
            this.f11550b = view;
        }

        public final void g(long j10) {
            this.f11551c = j10;
        }
    }

    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11553a;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(2:19|20)|21|23) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|23) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.swmansion.rnscreens.Screen$c[] r0 = com.swmansion.rnscreens.Screen.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.swmansion.rnscreens.Screen$c r1 = com.swmansion.rnscreens.Screen.c.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.swmansion.rnscreens.Screen$c r1 = com.swmansion.rnscreens.Screen.c.NONE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.swmansion.rnscreens.Screen$c r1 = com.swmansion.rnscreens.Screen.c.FADE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.swmansion.rnscreens.Screen$c r1 = com.swmansion.rnscreens.Screen.c.SLIDE_FROM_RIGHT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.swmansion.rnscreens.Screen$c r1 = com.swmansion.rnscreens.Screen.c.SLIDE_FROM_LEFT     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.swmansion.rnscreens.Screen$c r1 = com.swmansion.rnscreens.Screen.c.SLIDE_FROM_BOTTOM     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.swmansion.rnscreens.Screen$c r1 = com.swmansion.rnscreens.Screen.c.FADE_FROM_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.swmansion.rnscreens.Screen$c r1 = com.swmansion.rnscreens.Screen.c.IOS     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.swmansion.rnscreens.Screen$c r1 = com.swmansion.rnscreens.Screen.c.IOS_FROM_RIGHT     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.swmansion.rnscreens.Screen$c r1 = com.swmansion.rnscreens.Screen.c.IOS_FROM_LEFT     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                f11553a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenStack.c.<clinit>():void");
        }
    }

    public ScreenStack(Context context) {
        super(context);
    }

    private final void E() {
        int f10 = k1.f(this);
        Context context = getContext();
        m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        e c10 = k1.c((ReactContext) context, getId());
        if (c10 != null) {
            c10.c(new q(f10, getId()));
        }
    }

    private final void F() {
        List<b> list = this.f11548w;
        this.f11548w = new ArrayList();
        for (b bVar : list) {
            bVar.a();
            this.f11547j.add(bVar);
        }
    }

    private final b G() {
        if (this.f11547j.isEmpty()) {
            return new b();
        }
        List list = this.f11547j;
        return (b) list.remove(r.n(list));
    }

    /* access modifiers changed from: private */
    public static final void H(l lVar) {
        Screen i10;
        if (lVar != null && (i10 = lVar.i()) != null) {
            i10.bringToFront();
        }
    }

    /* access modifiers changed from: private */
    public final void J(b bVar) {
        Canvas b10 = bVar.b();
        m.c(b10);
        super.drawChild(b10, bVar.c(), bVar.d());
    }

    private final void K(l lVar) {
        n nVar;
        if (this.f11522a.size() > 1 && lVar != null && (nVar = this.C) != null && nVar.i().i()) {
            ArrayList arrayList = this.f11522a;
            for (l lVar2 : r.K(r.q0(arrayList, l.l(0, arrayList.size() - 1)))) {
                lVar2.i().a(4);
                if (m.b(lVar2, lVar)) {
                    break;
                }
            }
        }
        Screen topScreen = getTopScreen();
        if (topScreen != null) {
            topScreen.a(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public ScreenStackFragment c(Screen screen) {
        m.f(screen, "screen");
        return new ScreenStackFragment(screen);
    }

    public final void D(n nVar) {
        m.f(nVar, "screenFragment");
        this.f11546i.add(nVar);
        v();
    }

    public final void I() {
        if (!this.N0) {
            E();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        m.f(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.f11548w.size() < this.Q0) {
            this.P0 = false;
        }
        this.Q0 = this.f11548w.size();
        if (this.P0 && this.f11548w.size() >= 2) {
            List list = this.f11548w;
            Collections.swap(list, list.size() - 1, this.f11548w.size() - 2);
        }
        F();
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j10) {
        m.f(canvas, "canvas");
        m.f(view, "child");
        List list = this.f11548w;
        b G = G();
        G.e(canvas);
        G.f(view);
        G.g(j10);
        list.add(G);
        return true;
    }

    public void endViewTransition(View view) {
        m.f(view, "view");
        super.endViewTransition(view);
        if (this.N0) {
            this.N0 = false;
            E();
        }
    }

    public final ArrayList<n> getFragments() {
        return this.f11545h;
    }

    public final boolean getGoingForward() {
        return this.R0;
    }

    public final Screen getRootScreen() {
        int screenCount = getScreenCount();
        for (int i10 = 0; i10 < screenCount; i10++) {
            l m10 = m(i10);
            if (!r.S(this.f11546i, m10)) {
                return m10.i();
            }
        }
        throw new IllegalStateException("Stack has no root screen set");
    }

    public Screen getTopScreen() {
        n nVar = this.C;
        if (nVar != null) {
            return nVar.i();
        }
        return null;
    }

    public boolean n(l lVar) {
        if (!super.n(lVar) || r.S(this.f11546i, lVar)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void p() {
        for (n n10 : this.f11545h) {
            n10.n();
        }
    }

    public void removeView(View view) {
        m.f(view, "view");
        if (this.O0) {
            this.O0 = false;
            this.P0 = true;
        }
        super.removeView(view);
    }

    public final void setGoingForward(boolean z10) {
        this.R0 = z10;
    }

    public void startViewTransition(View view) {
        m.f(view, "view");
        super.startViewTransition(view);
        this.N0 = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01be A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x020a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0248 A[LOOP:4: B:123:0x0242->B:125:0x0248, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x018b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void t() {
        /*
            r9 = this;
            r0 = 0
            r9.O0 = r0
            java.util.ArrayList r1 = r9.f11522a
            int r1 = r1.size()
            int r1 = r1 + -1
            r2 = 0
            r3 = r2
            r4 = r3
            if (r1 < 0) goto L_0x0035
        L_0x0010:
            int r5 = r1 + -1
            com.swmansion.rnscreens.l r1 = r9.m(r1)
            java.util.Set r6 = r9.f11546i
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r6 = kotlin.collections.r.S(r6, r1)
            if (r6 != 0) goto L_0x0030
            if (r3 != 0) goto L_0x0024
            r3 = r1
            goto L_0x0025
        L_0x0024:
            r4 = r1
        L_0x0025:
            com.swmansion.rnscreens.Screen r1 = r1.i()
            boolean r1 = r1.i()
            if (r1 != 0) goto L_0x0030
            goto L_0x0035
        L_0x0030:
            if (r5 >= 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r1 = r5
            goto L_0x0010
        L_0x0035:
            java.util.ArrayList r1 = r9.f11545h
            boolean r1 = kotlin.collections.r.S(r1, r3)
            r5 = 1
            if (r1 != 0) goto L_0x008a
            com.swmansion.rnscreens.n r1 = r9.C
            if (r1 == 0) goto L_0x0080
            if (r3 == 0) goto L_0x0080
            if (r1 == 0) goto L_0x0050
            java.util.ArrayList r6 = r9.f11522a
            boolean r1 = r6.contains(r1)
            if (r1 != r5) goto L_0x0050
            r1 = r5
            goto L_0x0051
        L_0x0050:
            r1 = r0
        L_0x0051:
            com.swmansion.rnscreens.Screen r6 = r3.i()
            com.swmansion.rnscreens.Screen$b r6 = r6.getReplaceAnimation()
            com.swmansion.rnscreens.Screen$b r7 = com.swmansion.rnscreens.Screen.b.PUSH
            if (r6 != r7) goto L_0x005f
            r6 = r5
            goto L_0x0060
        L_0x005f:
            r6 = r0
        L_0x0060:
            if (r1 != 0) goto L_0x0067
            if (r6 == 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r1 = r0
            goto L_0x0068
        L_0x0067:
            r1 = r5
        L_0x0068:
            if (r1 == 0) goto L_0x0073
            com.swmansion.rnscreens.Screen r6 = r3.i()
        L_0x006e:
            com.swmansion.rnscreens.Screen$c r6 = r6.getStackAnimation()
            goto L_0x00a9
        L_0x0073:
            com.swmansion.rnscreens.n r6 = r9.C
            if (r6 == 0) goto L_0x007e
            com.swmansion.rnscreens.Screen r6 = r6.i()
            if (r6 == 0) goto L_0x007e
            goto L_0x006e
        L_0x007e:
            r6 = r2
            goto L_0x00a9
        L_0x0080:
            if (r1 != 0) goto L_0x00a7
            if (r3 == 0) goto L_0x00a7
            com.swmansion.rnscreens.Screen$c r6 = com.swmansion.rnscreens.Screen.c.NONE
            r9.R0 = r5
        L_0x0088:
            r1 = r5
            goto L_0x00a9
        L_0x008a:
            com.swmansion.rnscreens.n r1 = r9.C
            if (r1 == 0) goto L_0x00a7
            boolean r1 = kotlin.jvm.internal.m.b(r1, r3)
            if (r1 != 0) goto L_0x00a7
            com.swmansion.rnscreens.n r1 = r9.C
            if (r1 == 0) goto L_0x00a4
            com.swmansion.rnscreens.Screen r1 = r1.i()
            if (r1 == 0) goto L_0x00a4
            com.swmansion.rnscreens.Screen$c r1 = r1.getStackAnimation()
            r6 = r1
            goto L_0x00a5
        L_0x00a4:
            r6 = r2
        L_0x00a5:
            r1 = r0
            goto L_0x00a9
        L_0x00a7:
            r6 = r2
            goto L_0x0088
        L_0x00a9:
            androidx.fragment.app.FragmentTransaction r7 = r9.g()
            if (r6 == 0) goto L_0x016d
            if (r1 == 0) goto L_0x0114
            int[] r8 = com.swmansion.rnscreens.ScreenStack.c.f11553a
            int r6 = r6.ordinal()
            r6 = r8[r6]
            switch(r6) {
                case 1: goto L_0x010c;
                case 2: goto L_0x0106;
                case 3: goto L_0x00fd;
                case 4: goto L_0x00f4;
                case 5: goto L_0x00eb;
                case 6: goto L_0x00e2;
                case 7: goto L_0x00d9;
                case 8: goto L_0x00d0;
                case 9: goto L_0x00c7;
                case 10: goto L_0x00be;
                default: goto L_0x00bc;
            }
        L_0x00bc:
            goto L_0x016d
        L_0x00be:
            int r6 = com.swmansion.rnscreens.f.f11629l
            int r8 = com.swmansion.rnscreens.f.f11627j
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x00c7:
            int r6 = com.swmansion.rnscreens.f.f11633p
            int r8 = com.swmansion.rnscreens.f.f11631n
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x00d0:
            int r6 = com.swmansion.rnscreens.f.f11633p
            int r8 = com.swmansion.rnscreens.f.f11631n
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x00d9:
            int r6 = com.swmansion.rnscreens.f.f11622e
            int r8 = com.swmansion.rnscreens.f.f11636s
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x00e2:
            int r6 = com.swmansion.rnscreens.f.f11638u
            int r8 = com.swmansion.rnscreens.f.f11637t
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x00eb:
            int r6 = com.swmansion.rnscreens.f.f11639v
            int r8 = com.swmansion.rnscreens.f.f11643z
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x00f4:
            int r6 = com.swmansion.rnscreens.f.f11640w
            int r8 = com.swmansion.rnscreens.f.f11642y
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x00fd:
            int r6 = com.swmansion.rnscreens.f.f11623f
            int r8 = com.swmansion.rnscreens.f.f11624g
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x0106:
            int r6 = com.swmansion.rnscreens.f.f11634q
            r7.setCustomAnimations(r6, r6)
            goto L_0x016d
        L_0x010c:
            int r6 = com.swmansion.rnscreens.f.f11618a
            int r8 = com.swmansion.rnscreens.f.f11619b
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x0114:
            int[] r8 = com.swmansion.rnscreens.ScreenStack.c.f11553a
            int r6 = r6.ordinal()
            r6 = r8[r6]
            switch(r6) {
                case 1: goto L_0x0166;
                case 2: goto L_0x0160;
                case 3: goto L_0x0158;
                case 4: goto L_0x0150;
                case 5: goto L_0x0148;
                case 6: goto L_0x0140;
                case 7: goto L_0x0138;
                case 8: goto L_0x0130;
                case 9: goto L_0x0128;
                case 10: goto L_0x0120;
                default: goto L_0x011f;
            }
        L_0x011f:
            goto L_0x016d
        L_0x0120:
            int r6 = com.swmansion.rnscreens.f.f11626i
            int r8 = com.swmansion.rnscreens.f.f11628k
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x0128:
            int r6 = com.swmansion.rnscreens.f.f11630m
            int r8 = com.swmansion.rnscreens.f.f11632o
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x0130:
            int r6 = com.swmansion.rnscreens.f.f11632o
            int r8 = com.swmansion.rnscreens.f.f11630m
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x0138:
            int r6 = com.swmansion.rnscreens.f.f11635r
            int r8 = com.swmansion.rnscreens.f.f11625h
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x0140:
            int r6 = com.swmansion.rnscreens.f.f11637t
            int r8 = com.swmansion.rnscreens.f.f11641x
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x0148:
            int r6 = com.swmansion.rnscreens.f.f11640w
            int r8 = com.swmansion.rnscreens.f.f11642y
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x0150:
            int r6 = com.swmansion.rnscreens.f.f11639v
            int r8 = com.swmansion.rnscreens.f.f11643z
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x0158:
            int r6 = com.swmansion.rnscreens.f.f11623f
            int r8 = com.swmansion.rnscreens.f.f11624g
            r7.setCustomAnimations(r6, r8)
            goto L_0x016d
        L_0x0160:
            int r6 = com.swmansion.rnscreens.f.f11634q
            r7.setCustomAnimations(r6, r6)
            goto L_0x016d
        L_0x0166:
            int r6 = com.swmansion.rnscreens.f.f11620c
            int r8 = com.swmansion.rnscreens.f.f11621d
            r7.setCustomAnimations(r6, r8)
        L_0x016d:
            r9.R0 = r1
            if (r1 == 0) goto L_0x017f
            if (r3 == 0) goto L_0x017f
            com.swmansion.rnscreens.ScreenStack$a r1 = S0
            boolean r1 = r1.b(r3)
            if (r1 == 0) goto L_0x017f
            if (r4 != 0) goto L_0x017f
            r9.O0 = r5
        L_0x017f:
            java.util.ArrayList r1 = r9.f11545h
            java.util.Iterator r1 = r1.iterator()
        L_0x0185:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x01a9
            java.lang.Object r6 = r1.next()
            com.swmansion.rnscreens.n r6 = (com.swmansion.rnscreens.n) r6
            java.util.ArrayList r8 = r9.f11522a
            boolean r8 = r8.contains(r6)
            if (r8 == 0) goto L_0x01a1
            java.util.Set r8 = r9.f11546i
            boolean r8 = r8.contains(r6)
            if (r8 == 0) goto L_0x0185
        L_0x01a1:
            androidx.fragment.app.Fragment r6 = r6.e()
            r7.remove(r6)
            goto L_0x0185
        L_0x01a9:
            java.util.ArrayList r1 = r9.f11522a
            java.util.Iterator r1 = r1.iterator()
        L_0x01af:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x01d2
            java.lang.Object r6 = r1.next()
            com.swmansion.rnscreens.l r6 = (com.swmansion.rnscreens.l) r6
            if (r6 != r4) goto L_0x01be
            goto L_0x01d2
        L_0x01be:
            if (r6 == r3) goto L_0x01af
            java.util.Set r8 = r9.f11546i
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            boolean r8 = kotlin.collections.r.S(r8, r6)
            if (r8 != 0) goto L_0x01af
            androidx.fragment.app.Fragment r6 = r6.e()
            r7.remove(r6)
            goto L_0x01af
        L_0x01d2:
            if (r4 == 0) goto L_0x020a
            androidx.fragment.app.Fragment r1 = r4.e()
            boolean r1 = r1.isAdded()
            if (r1 != 0) goto L_0x020a
            java.util.ArrayList r1 = r9.f11522a
            java.util.Iterator r1 = r1.iterator()
        L_0x01e4:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0221
            java.lang.Object r6 = r1.next()
            com.swmansion.rnscreens.l r6 = (com.swmansion.rnscreens.l) r6
            if (r5 == 0) goto L_0x01f5
            if (r6 != r4) goto L_0x01e4
            r5 = r0
        L_0x01f5:
            int r8 = r9.getId()
            androidx.fragment.app.Fragment r6 = r6.e()
            androidx.fragment.app.FragmentTransaction r6 = r7.add((int) r8, (androidx.fragment.app.Fragment) r6)
            com.swmansion.rnscreens.m r8 = new com.swmansion.rnscreens.m
            r8.<init>(r3)
            r6.runOnCommit(r8)
            goto L_0x01e4
        L_0x020a:
            if (r3 == 0) goto L_0x0221
            androidx.fragment.app.Fragment r0 = r3.e()
            boolean r0 = r0.isAdded()
            if (r0 != 0) goto L_0x0221
            int r0 = r9.getId()
            androidx.fragment.app.Fragment r1 = r3.e()
            r7.add((int) r0, (androidx.fragment.app.Fragment) r1)
        L_0x0221:
            boolean r0 = r3 instanceof com.swmansion.rnscreens.n
            if (r0 == 0) goto L_0x0228
            r2 = r3
            com.swmansion.rnscreens.n r2 = (com.swmansion.rnscreens.n) r2
        L_0x0228:
            r9.C = r2
            java.util.ArrayList r0 = r9.f11545h
            r0.clear()
            java.util.ArrayList r0 = r9.f11545h
            java.util.ArrayList r1 = r9.f11522a
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.r.v(r1, r3)
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0242:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0259
            java.lang.Object r3 = r1.next()
            com.swmansion.rnscreens.l r3 = (com.swmansion.rnscreens.l) r3
            java.lang.String r5 = "null cannot be cast to non-null type com.swmansion.rnscreens.ScreenStackFragmentWrapper"
            kotlin.jvm.internal.m.d(r3, r5)
            com.swmansion.rnscreens.n r3 = (com.swmansion.rnscreens.n) r3
            r2.add(r3)
            goto L_0x0242
        L_0x0259:
            r0.addAll(r2)
            r9.K(r4)
            r7.commitNowAllowingStateLoss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenStack.t():void");
    }

    public void w() {
        this.f11546i.clear();
        super.w();
    }

    public void y(int i10) {
        c0.a(this.f11546i).remove(m(i10));
        super.y(i10);
    }
}
