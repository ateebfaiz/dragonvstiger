package e9;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.google.android.games.paddleboat.GameControllerManager;
import java.util.HashMap;
import java.util.Map;

public final class h implements i {
    private boolean C;
    private int N0;
    private int O0;
    private g P0;
    private Map Q0;
    private int R0;
    private boolean S0;
    private boolean T0;
    private boolean U0;
    private int V0;
    private int W0;
    private c X;
    private int X0;
    private a Y;
    private int Y0;
    private int Z;

    /* renamed from: a  reason: collision with root package name */
    private Activity f12016a;

    /* renamed from: b  reason: collision with root package name */
    private Fragment f12017b;

    /* renamed from: c  reason: collision with root package name */
    private android.app.Fragment f12018c;

    /* renamed from: d  reason: collision with root package name */
    private Dialog f12019d;

    /* renamed from: e  reason: collision with root package name */
    private Window f12020e;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f12021f;

    /* renamed from: g  reason: collision with root package name */
    private ViewGroup f12022g;

    /* renamed from: h  reason: collision with root package name */
    private h f12023h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12024i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12025j;

    /* renamed from: w  reason: collision with root package name */
    private boolean f12026w;

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f12027a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f12028b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f12029c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Integer f12030d;

        a(ViewGroup.LayoutParams layoutParams, View view, int i10, Integer num) {
            this.f12027a = layoutParams;
            this.f12028b = view;
            this.f12029c = i10;
            this.f12030d = num;
        }

        public void run() {
            this.f12027a.height = (this.f12028b.getHeight() + this.f12029c) - this.f12030d.intValue();
            View view = this.f12028b;
            view.setPadding(view.getPaddingLeft(), (this.f12028b.getPaddingTop() + this.f12029c) - this.f12030d.intValue(), this.f12028b.getPaddingRight(), this.f12028b.getPaddingBottom());
            this.f12028b.setLayoutParams(this.f12027a);
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12031a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                e9.b[] r0 = e9.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12031a = r0
                e9.b r1 = e9.b.FLAG_HIDE_BAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12031a     // Catch:{ NoSuchFieldError -> 0x001d }
                e9.b r1 = e9.b.FLAG_HIDE_STATUS_BAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12031a     // Catch:{ NoSuchFieldError -> 0x0028 }
                e9.b r1 = e9.b.FLAG_HIDE_NAVIGATION_BAR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12031a     // Catch:{ NoSuchFieldError -> 0x0033 }
                e9.b r1 = e9.b.FLAG_SHOW_BAR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e9.h.b.<clinit>():void");
        }
    }

    h(Activity activity) {
        this.f12024i = false;
        this.f12025j = false;
        this.f12026w = false;
        this.C = false;
        this.Z = 0;
        this.N0 = 0;
        this.O0 = 0;
        this.P0 = null;
        this.Q0 = new HashMap();
        this.R0 = 0;
        this.S0 = false;
        this.T0 = false;
        this.U0 = false;
        this.V0 = 0;
        this.W0 = 0;
        this.X0 = 0;
        this.Y0 = 0;
        this.f12024i = true;
        this.f12016a = activity;
        F(activity.getWindow());
    }

    private int A(int i10) {
        int i11 = b.f12031a[this.X.f11996j.ordinal()];
        if (i11 == 1) {
            i10 |= 518;
        } else if (i11 == 2) {
            i10 |= 1028;
        } else if (i11 == 3) {
            i10 |= 514;
        }
        return i10 | 4096;
    }

    private int D(int i10) {
        if (!this.S0) {
            this.X.f11982c = this.f12020e.getNavigationBarColor();
        }
        int i11 = i10 | 1024;
        c cVar = this.X;
        if (cVar.f11992h && cVar.f11989f1) {
            i11 = i10 | 1536;
        }
        this.f12020e.clearFlags(67108864);
        if (this.Y.k()) {
            this.f12020e.clearFlags(GameControllerManager.DEVICEFLAG_VIBRATION);
        }
        this.f12020e.addFlags(Integer.MIN_VALUE);
        c cVar2 = this.X;
        if (cVar2.O0) {
            this.f12020e.setStatusBarColor(ColorUtils.blendARGB(cVar2.f11978a, cVar2.P0, cVar2.f11984d));
        } else {
            this.f12020e.setStatusBarColor(ColorUtils.blendARGB(cVar2.f11978a, 0, cVar2.f11984d));
        }
        c cVar3 = this.X;
        if (cVar3.f11989f1) {
            this.f12020e.setNavigationBarColor(ColorUtils.blendARGB(cVar3.f11980b, cVar3.Q0, cVar3.f11988f));
        } else {
            this.f12020e.setNavigationBarColor(cVar3.f11982c);
        }
        return i11;
    }

    private void E() {
        this.f12020e.addFlags(67108864);
        Y();
        if (this.Y.k() || o.i()) {
            c cVar = this.X;
            if (!cVar.f11989f1 || !cVar.f11991g1) {
                this.f12020e.clearFlags(GameControllerManager.DEVICEFLAG_VIBRATION);
            } else {
                this.f12020e.addFlags(GameControllerManager.DEVICEFLAG_VIBRATION);
            }
            if (this.Z == 0) {
                this.Z = this.Y.d();
            }
            if (this.N0 == 0) {
                this.N0 = this.Y.f();
            }
            X();
        }
    }

    private void F(Window window) {
        this.f12020e = window;
        this.X = new c();
        ViewGroup viewGroup = (ViewGroup) this.f12020e.getDecorView();
        this.f12021f = viewGroup;
        this.f12022g = (ViewGroup) viewGroup.findViewById(16908290);
    }

    public static boolean I() {
        if (o.m() || Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    public static boolean J() {
        if (o.m()) {
            return true;
        }
        o.k();
        return true;
    }

    private void O() {
        c0();
        m();
        if (!this.f12025j && o.i()) {
            l();
        }
    }

    private int Q(int i10) {
        if (Build.VERSION.SDK_INT < 26 || !this.X.C) {
            return i10;
        }
        return i10 | 16;
    }

    private void R(int i10, int i11, int i12, int i13) {
        ViewGroup viewGroup = this.f12022g;
        if (viewGroup != null) {
            viewGroup.setPadding(i10, i11, i12, i13);
        }
        this.V0 = i10;
        this.W0 = i11;
        this.X0 = i12;
        this.Y0 = i13;
    }

    private void S() {
        if (o.m()) {
            t.b(this.f12020e, "EXTRA_FLAG_STATUS_BAR_DARK_MODE", this.X.f11998w);
            c cVar = this.X;
            if (cVar.f11989f1) {
                t.b(this.f12020e, "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE", cVar.C);
            }
        }
        if (o.k()) {
            c cVar2 = this.X;
            int i10 = cVar2.f11979a1;
            if (i10 != 0) {
                t.d(this.f12016a, i10);
            } else {
                t.e(this.f12016a, cVar2.f11998w);
            }
        }
    }

    private int T(int i10) {
        if (this.X.f11998w) {
            return i10 | 8192;
        }
        return i10;
    }

    public static void U(Activity activity, int i10, View... viewArr) {
        if (activity != null) {
            if (i10 < 0) {
                i10 = 0;
            }
            for (View view : viewArr) {
                if (view != null) {
                    Integer num = (Integer) view.getTag(q.f12040b);
                    if (num == null) {
                        num = 0;
                    }
                    if (num.intValue() != i10) {
                        view.setTag(q.f12040b, Integer.valueOf(i10));
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-1, 0);
                        }
                        layoutParams.height = i10;
                        view.setLayoutParams(layoutParams);
                    }
                }
            }
        }
    }

    public static void V(Activity activity, int i10, View... viewArr) {
        if (activity != null) {
            if (i10 < 0) {
                i10 = 0;
            }
            for (View view : viewArr) {
                if (view != null) {
                    Integer num = (Integer) view.getTag(q.f12040b);
                    if (num == null) {
                        num = 0;
                    }
                    if (num.intValue() != i10) {
                        view.setTag(q.f12040b, Integer.valueOf(i10));
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-1, -2);
                        }
                        int i11 = layoutParams.height;
                        if (i11 == -2 || i11 == -1) {
                            view.post(new a(layoutParams, view, i10, num));
                        } else {
                            layoutParams.height = i11 + (i10 - num.intValue());
                            view.setPadding(view.getPaddingLeft(), (view.getPaddingTop() + i10) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                            view.setLayoutParams(layoutParams);
                        }
                    }
                }
            }
        }
    }

    public static void W(Activity activity, int i10, View... viewArr) {
        if (activity != null) {
            if (i10 < 0) {
                i10 = 0;
            }
            for (View view : viewArr) {
                if (view != null) {
                    Integer num = (Integer) view.getTag(q.f12040b);
                    if (num == null) {
                        num = 0;
                    }
                    if (num.intValue() != i10) {
                        view.setTag(q.f12040b, Integer.valueOf(i10));
                        Object layoutParams = view.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (marginLayoutParams.topMargin + i10) - num.intValue(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                        view.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }

    private void X() {
        FrameLayout.LayoutParams layoutParams;
        ViewGroup viewGroup = this.f12021f;
        int i10 = e.f12000b;
        View findViewById = viewGroup.findViewById(i10);
        if (findViewById == null) {
            findViewById = new View(this.f12016a);
            findViewById.setId(i10);
            this.f12021f.addView(findViewById);
        }
        if (this.Y.l()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.Y.d());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.Y.f(), -1);
            layoutParams.gravity = GravityCompat.END;
        }
        findViewById.setLayoutParams(layoutParams);
        c cVar = this.X;
        findViewById.setBackgroundColor(ColorUtils.blendARGB(cVar.f11980b, cVar.Q0, cVar.f11988f));
        c cVar2 = this.X;
        if (!cVar2.f11989f1 || !cVar2.f11991g1 || cVar2.f11994i) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    private void Y() {
        ViewGroup viewGroup = this.f12021f;
        int i10 = e.f11999a;
        View findViewById = viewGroup.findViewById(i10);
        if (findViewById == null) {
            findViewById = new View(this.f12016a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.Y.i());
            layoutParams.gravity = 48;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
            findViewById.setId(i10);
            this.f12021f.addView(findViewById);
        }
        c cVar = this.X;
        if (cVar.O0) {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(cVar.f11978a, cVar.P0, cVar.f11984d));
        } else {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(cVar.f11978a, 0, cVar.f11984d));
        }
    }

    private void b() {
        int i10;
        int i11;
        boolean z10;
        c cVar = this.X;
        boolean z11 = false;
        if (cVar.X && (i11 = cVar.f11978a) != 0) {
            if (i11 > -4539718) {
                z10 = true;
            } else {
                z10 = false;
            }
            a0(z10, cVar.Z);
        }
        c cVar2 = this.X;
        if (cVar2.Y && (i10 = cVar2.f11980b) != 0) {
            if (i10 > -4539718) {
                z11 = true;
            }
            K(z11, cVar2.N0);
        }
    }

    private void b0() {
        if (this.X.R0.size() != 0) {
            for (Map.Entry entry : this.X.R0.entrySet()) {
                View view = (View) entry.getKey();
                Integer valueOf = Integer.valueOf(this.X.f11978a);
                Integer valueOf2 = Integer.valueOf(this.X.P0);
                for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                    Integer num = (Integer) entry2.getKey();
                    valueOf2 = (Integer) entry2.getValue();
                    valueOf = num;
                }
                if (view != null) {
                    if (Math.abs(this.X.S0 - 0.0f) == 0.0f) {
                        view.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.X.f11984d));
                    } else {
                        view.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.X.S0));
                    }
                }
            }
        }
    }

    private void c() {
        if (this.f12016a != null) {
            g gVar = this.P0;
            if (gVar != null) {
                gVar.a();
                this.P0 = null;
            }
            f.b().d(this);
            k.a().c(this.X.f11997j1);
        }
    }

    private void c0() {
        a aVar = new a(this.f12016a);
        this.Y = aVar;
        if (!this.S0 || this.T0) {
            this.O0 = aVar.a();
        }
    }

    public static boolean d(View view) {
        if (view == null) {
            return false;
        }
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (((childAt instanceof DrawerLayout) && d(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void d0() {
        b();
        c0();
        h hVar = this.f12023h;
        if (hVar != null) {
            if (this.f12025j) {
                hVar.X = this.X;
            }
            if (this.C && hVar.U0) {
                hVar.X.f11985d1 = false;
            }
        }
    }

    private void e() {
        if (this.f12023h == null) {
            this.f12023h = e0(this.f12016a);
        }
        h hVar = this.f12023h;
        if (hVar != null && !hVar.S0) {
            hVar.C();
        }
    }

    public static h e0(Activity activity) {
        return w().b(activity);
    }

    private void f() {
        if (this.f12025j) {
            h hVar = this.f12023h;
            if (hVar == null) {
                return;
            }
            if (hVar.X.f11985d1) {
                if (hVar.P0 == null) {
                    hVar.P0 = new g(hVar);
                }
                h hVar2 = this.f12023h;
                hVar2.P0.c(hVar2.X.f11987e1);
                return;
            }
            g gVar = hVar.P0;
            if (gVar != null) {
                gVar.b();
            }
        } else if (this.X.f11985d1) {
            if (this.P0 == null) {
                this.P0 = new g(this);
            }
            this.P0.c(this.X.f11987e1);
        } else {
            g gVar2 = this.P0;
            if (gVar2 != null) {
                gVar2.b();
            }
        }
    }

    private void g() {
        int i10;
        if (this.X.Z0) {
            i10 = x(this.f12016a);
        } else {
            i10 = 0;
        }
        int i11 = this.R0;
        if (i11 == 1) {
            V(this.f12016a, i10, this.X.X0);
        } else if (i11 == 2) {
            W(this.f12016a, i10, this.X.X0);
        } else if (i11 == 3) {
            U(this.f12016a, i10, this.X.Y0);
        }
    }

    private void h() {
        if (Build.VERSION.SDK_INT >= 28 && !this.S0) {
            WindowManager.LayoutParams attributes = this.f12020e.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            this.f12020e.setAttributes(attributes);
        }
    }

    private void i() {
        if (!o.i()) {
            j();
        } else {
            k();
        }
        g();
    }

    private void j() {
        int i10;
        c0();
        if (d(this.f12021f.findViewById(16908290))) {
            R(0, 0, 0, 0);
            return;
        }
        if (!this.X.W0 || this.R0 != 4) {
            i10 = 0;
        } else {
            i10 = this.Y.i();
        }
        if (this.X.f11983c1) {
            i10 = this.Y.i() + this.O0;
        }
        R(0, i10, 0, 0);
    }

    private void k() {
        if (this.X.f11983c1) {
            this.T0 = true;
            this.f12022g.post(this);
            return;
        }
        this.T0 = false;
        O();
    }

    private void l() {
        View findViewById = this.f12021f.findViewById(e.f12000b);
        c cVar = this.X;
        if (!cVar.f11989f1 || !cVar.f11991g1) {
            f.b().d(this);
            findViewById.setVisibility(8);
        } else if (findViewById != null) {
            f.b().a(this);
            f.b().c(this.f12016a.getApplication());
        }
    }

    private void m() {
        int i10;
        int i11;
        int i12;
        if (d(this.f12021f.findViewById(16908290))) {
            R(0, 0, 0, 0);
            return;
        }
        if (!this.X.W0 || this.R0 != 4) {
            i10 = 0;
        } else {
            i10 = this.Y.i();
        }
        if (this.X.f11983c1) {
            i10 = this.Y.i() + this.O0;
        }
        if (this.Y.k()) {
            c cVar = this.X;
            if (cVar.f11989f1 && cVar.f11991g1) {
                if (cVar.f11992h) {
                    i12 = 0;
                    i11 = 0;
                } else if (this.Y.l()) {
                    i11 = this.Y.d();
                    i12 = 0;
                } else {
                    i12 = this.Y.f();
                    i11 = 0;
                }
                if (this.X.f11994i) {
                    if (this.Y.l()) {
                        i11 = 0;
                    } else {
                        i12 = 0;
                    }
                } else if (!this.Y.l()) {
                    i12 = this.Y.f();
                }
                R(0, i10, i12, i11);
            }
        }
        i12 = 0;
        i11 = 0;
        R(0, i10, i12, i11);
    }

    private static s w() {
        return s.e();
    }

    public static int x(Activity activity) {
        return new a(activity).i();
    }

    public h B(b bVar) {
        boolean z10;
        this.X.f11996j = bVar;
        if (o.i()) {
            c cVar = this.X;
            b bVar2 = cVar.f11996j;
            if (bVar2 == b.FLAG_HIDE_NAVIGATION_BAR || bVar2 == b.FLAG_HIDE_BAR) {
                z10 = true;
            } else {
                z10 = false;
            }
            cVar.f11994i = z10;
        }
        return this;
    }

    public void C() {
        if (this.X.f11995i1) {
            d0();
            P();
            i();
            f();
            b0();
            this.S0 = true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        return this.S0;
    }

    /* access modifiers changed from: package-private */
    public boolean H() {
        return this.f12026w;
    }

    public h K(boolean z10, float f10) {
        this.X.C = z10;
        if (!z10 || I()) {
            c cVar = this.X;
            cVar.f11988f = cVar.f11990g;
        } else {
            this.X.f11988f = f10;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public void L(Configuration configuration) {
        if (!o.i()) {
            i();
        } else if (!this.S0 || this.f12025j || !this.X.f11991g1) {
            i();
        } else {
            C();
        }
    }

    /* access modifiers changed from: package-private */
    public void M() {
        h hVar;
        c();
        if (this.C && (hVar = this.f12023h) != null) {
            c cVar = hVar.X;
            cVar.f11985d1 = hVar.U0;
            if (cVar.f11996j != b.FLAG_SHOW_BAR) {
                hVar.P();
            }
        }
        this.S0 = false;
    }

    /* access modifiers changed from: package-private */
    public void N() {
        if (!this.f12025j && this.S0 && this.X != null) {
            if (o.i() && this.X.f11993h1) {
                C();
            } else if (this.X.f11996j != b.FLAG_SHOW_BAR) {
                P();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void P() {
        int i10 = 256;
        if (!o.i()) {
            h();
            i10 = Q(T(D(256)));
        } else {
            E();
        }
        this.f12021f.setSystemUiVisibility(A(i10));
        S();
        if (this.X.f11997j1 != null) {
            k.a().b(this.f12016a.getApplication());
        }
    }

    public h Z(boolean z10) {
        return a0(z10, 0.2f);
    }

    public void a(boolean z10) {
        View findViewById = this.f12021f.findViewById(e.f12000b);
        if (findViewById != null) {
            this.Y = new a(this.f12016a);
            int paddingBottom = this.f12022g.getPaddingBottom();
            int paddingRight = this.f12022g.getPaddingRight();
            if (!z10) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
                if (!d(this.f12021f.findViewById(16908290))) {
                    if (this.Z == 0) {
                        this.Z = this.Y.d();
                    }
                    if (this.N0 == 0) {
                        this.N0 = this.Y.f();
                    }
                    if (!this.X.f11994i) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
                        if (this.Y.l()) {
                            layoutParams.gravity = 80;
                            paddingBottom = this.Z;
                            layoutParams.height = paddingBottom;
                            if (this.X.f11992h) {
                                paddingBottom = 0;
                            }
                            paddingRight = 0;
                        } else {
                            layoutParams.gravity = GravityCompat.END;
                            int i10 = this.N0;
                            layoutParams.width = i10;
                            if (this.X.f11992h) {
                                i10 = 0;
                            }
                            paddingRight = i10;
                            paddingBottom = 0;
                        }
                        findViewById.setLayoutParams(layoutParams);
                    }
                    R(0, this.f12022g.getPaddingTop(), paddingRight, paddingBottom);
                }
            }
            paddingBottom = 0;
            paddingRight = 0;
            R(0, this.f12022g.getPaddingTop(), paddingRight, paddingBottom);
        }
    }

    public h a0(boolean z10, float f10) {
        this.X.f11998w = z10;
        if (!z10 || J()) {
            c cVar = this.X;
            cVar.f11979a1 = cVar.f11981b1;
            cVar.f11984d = cVar.f11986e;
        } else {
            this.X.f11984d = f10;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public int n() {
        return this.O0;
    }

    /* access modifiers changed from: package-private */
    public Activity o() {
        return this.f12016a;
    }

    /* access modifiers changed from: package-private */
    public a p() {
        if (this.Y == null) {
            this.Y = new a(this.f12016a);
        }
        return this.Y;
    }

    public c q() {
        return this.X;
    }

    /* access modifiers changed from: package-private */
    public android.app.Fragment r() {
        return this.f12018c;
    }

    public void run() {
        O();
    }

    /* access modifiers changed from: package-private */
    public int s() {
        return this.Y0;
    }

    /* access modifiers changed from: package-private */
    public int t() {
        return this.V0;
    }

    /* access modifiers changed from: package-private */
    public int u() {
        return this.X0;
    }

    /* access modifiers changed from: package-private */
    public int v() {
        return this.W0;
    }

    /* access modifiers changed from: package-private */
    public Fragment y() {
        return this.f12017b;
    }

    /* access modifiers changed from: package-private */
    public Window z() {
        return this.f12020e;
    }

    h(Fragment fragment) {
        this.f12024i = false;
        this.f12025j = false;
        this.f12026w = false;
        this.C = false;
        this.Z = 0;
        this.N0 = 0;
        this.O0 = 0;
        this.P0 = null;
        this.Q0 = new HashMap();
        this.R0 = 0;
        this.S0 = false;
        this.T0 = false;
        this.U0 = false;
        this.V0 = 0;
        this.W0 = 0;
        this.X0 = 0;
        this.Y0 = 0;
        this.f12025j = true;
        this.f12016a = fragment.getActivity();
        this.f12017b = fragment;
        e();
        F(this.f12016a.getWindow());
    }

    h(android.app.Fragment fragment) {
        this.f12024i = false;
        this.f12025j = false;
        this.f12026w = false;
        this.C = false;
        this.Z = 0;
        this.N0 = 0;
        this.O0 = 0;
        this.P0 = null;
        this.Q0 = new HashMap();
        this.R0 = 0;
        this.S0 = false;
        this.T0 = false;
        this.U0 = false;
        this.V0 = 0;
        this.W0 = 0;
        this.X0 = 0;
        this.Y0 = 0;
        this.f12025j = true;
        this.f12016a = fragment.getActivity();
        this.f12018c = fragment;
        e();
        F(this.f12016a.getWindow());
    }

    h(DialogFragment dialogFragment) {
        this.f12024i = false;
        this.f12025j = false;
        this.f12026w = false;
        this.C = false;
        this.Z = 0;
        this.N0 = 0;
        this.O0 = 0;
        this.P0 = null;
        this.Q0 = new HashMap();
        this.R0 = 0;
        this.S0 = false;
        this.T0 = false;
        this.U0 = false;
        this.V0 = 0;
        this.W0 = 0;
        this.X0 = 0;
        this.Y0 = 0;
        this.C = true;
        this.f12026w = true;
        this.f12016a = dialogFragment.getActivity();
        this.f12017b = dialogFragment;
        this.f12019d = dialogFragment.getDialog();
        e();
        F(this.f12019d.getWindow());
    }

    h(android.app.DialogFragment dialogFragment) {
        this.f12024i = false;
        this.f12025j = false;
        this.f12026w = false;
        this.C = false;
        this.Z = 0;
        this.N0 = 0;
        this.O0 = 0;
        this.P0 = null;
        this.Q0 = new HashMap();
        this.R0 = 0;
        this.S0 = false;
        this.T0 = false;
        this.U0 = false;
        this.V0 = 0;
        this.W0 = 0;
        this.X0 = 0;
        this.Y0 = 0;
        this.C = true;
        this.f12026w = true;
        this.f12016a = dialogFragment.getActivity();
        this.f12018c = dialogFragment;
        this.f12019d = dialogFragment.getDialog();
        e();
        F(this.f12019d.getWindow());
    }
}
