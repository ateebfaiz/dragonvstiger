package com.bugsnag.android;

import android.content.Context;
import com.alibaba.pdns.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.t;

public final class d0 {
    public static final a K = new a((DefaultConstructorMarker) null);
    private String A;
    private Set B = r0.d();
    private Set C;
    private Set D;
    private Set E = EnumSet.of(z3.INTERNAL_ERRORS, z3.USAGE);
    private Set F = r0.d();
    private File G;
    private boolean H;
    private final e3 I = new e3((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    private final HashSet J = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    private String f18671a;

    /* renamed from: b  reason: collision with root package name */
    private k4 f18672b = new k4((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    public final y f18673c = new y((Collection) null, (Collection) null, (Collection) null, (List) null, 15, (DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    public final z2 f18674d = new z2((y2) null, 1, (DefaultConstructorMarker) null);

    /* renamed from: e  reason: collision with root package name */
    public final b2 f18675e = new b2((c2) null, 1, (DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private String f18676f;

    /* renamed from: g  reason: collision with root package name */
    private Integer f18677g = 0;

    /* renamed from: h  reason: collision with root package name */
    private String f18678h;

    /* renamed from: i  reason: collision with root package name */
    private d4 f18679i = d4.ALWAYS;

    /* renamed from: j  reason: collision with root package name */
    private boolean f18680j = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f18681k = true;

    /* renamed from: l  reason: collision with root package name */
    private long f18682l = 5000;

    /* renamed from: m  reason: collision with root package name */
    private boolean f18683m = true;

    /* renamed from: n  reason: collision with root package name */
    private boolean f18684n = true;

    /* renamed from: o  reason: collision with root package name */
    private n1 f18685o = new n1(false, false, false, false, 15, (DefaultConstructorMarker) null);

    /* renamed from: p  reason: collision with root package name */
    private boolean f18686p = true;

    /* renamed from: q  reason: collision with root package name */
    private String f18687q = f.f17924q;

    /* renamed from: r  reason: collision with root package name */
    private s2 f18688r = o0.f18889a;

    /* renamed from: s  reason: collision with root package name */
    private r0 f18689s;

    /* renamed from: t  reason: collision with root package name */
    private j1 f18690t = new j1((String) null, (String) null, 3, (DefaultConstructorMarker) null);

    /* renamed from: u  reason: collision with root package name */
    private int f18691u = 100;

    /* renamed from: v  reason: collision with root package name */
    private int f18692v = 32;

    /* renamed from: w  reason: collision with root package name */
    private int f18693w = 128;

    /* renamed from: x  reason: collision with root package name */
    private int f18694x = 200;

    /* renamed from: y  reason: collision with root package name */
    private long f18695y = 5000;

    /* renamed from: z  reason: collision with root package name */
    private int f18696z = 10000;

    public static final class a {
        private a() {
        }

        public final f0 a(Context context) {
            return d0.K(context, (String) null);
        }

        /* access modifiers changed from: protected */
        public final f0 b(Context context, String str) {
            return new t2().c(context, str);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d0(String str) {
        this.f18671a = str;
    }

    public static final f0 J(Context context) {
        return K.a(context);
    }

    protected static final f0 K(Context context, String str) {
        return K.b(context, str);
    }

    private final String j0(Collection collection) {
        String f02;
        if (collection == null) {
            return "";
        }
        Iterable<Object> iterable = collection;
        ArrayList arrayList = new ArrayList(r.v(iterable, 10));
        for (Object obj : iterable) {
            arrayList.add(obj.toString());
        }
        List r02 = r.r0(arrayList);
        if (r02 == null || (f02 = r.f0(r02, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)) == null) {
            return "";
        }
        return f02;
    }

    public final Set A() {
        return this.F;
    }

    public final Set B() {
        return this.f18674d.h().j();
    }

    public final String C() {
        return this.f18678h;
    }

    public final boolean D() {
        return this.f18684n;
    }

    public final d4 E() {
        return this.f18679i;
    }

    public final Set F() {
        return this.E;
    }

    public final long G() {
        return this.f18695y;
    }

    public k4 H() {
        return this.f18672b;
    }

    public final Integer I() {
        return this.f18677g;
    }

    public final void L(String str) {
        this.f18687q = str;
    }

    public final void M(String str) {
        this.f18676f = str;
    }

    public final void N(boolean z10) {
        this.H = z10;
    }

    public final void O(boolean z10) {
        this.f18686p = z10;
    }

    public final void P(boolean z10) {
        this.f18683m = z10;
    }

    public final void Q(r0 r0Var) {
        this.f18689s = r0Var;
    }

    public final void R(Set set) {
        this.B = set;
    }

    public final void S(Set set) {
        this.C = set;
    }

    public final void T(j1 j1Var) {
        this.f18690t = j1Var;
    }

    public final void U(boolean z10) {
        this.f18681k = z10;
    }

    public final void V(long j10) {
        this.f18682l = j10;
    }

    public final void W(s2 s2Var) {
        if (s2Var == null) {
            s2Var = d3.f18705a;
        }
        this.f18688r = s2Var;
    }

    public final void X(int i10) {
        this.f18691u = i10;
    }

    public final void Y(int i10) {
        this.f18692v = i10;
    }

    public final void Z(int i10) {
        this.f18693w = i10;
    }

    public final String a() {
        return this.f18671a;
    }

    public final void a0(int i10) {
        this.f18694x = i10;
    }

    public final String b() {
        return this.f18687q;
    }

    public final void b0(boolean z10) {
        this.f18680j = z10;
    }

    public final String c() {
        return this.f18676f;
    }

    public final void c0(Set set) {
        this.F = set;
    }

    public final boolean d() {
        return this.H;
    }

    public final void d0(Set set) {
        this.f18674d.h().m(set);
    }

    public final boolean e() {
        return this.f18686p;
    }

    public final void e0(String str) {
        this.f18678h = str;
    }

    public final boolean f() {
        return this.f18683m;
    }

    public final void f0(boolean z10) {
        this.f18684n = z10;
    }

    public final Map g() {
        Pair pair;
        Pair pair2;
        Pair pair3;
        Pair pair4;
        Pair pair5;
        Pair pair6;
        Pair pair7;
        Pair pair8;
        Pair pair9;
        Pair pair10;
        Pair pair11;
        Pair pair12;
        Pair pair13;
        Pair pair14;
        Pair pair15;
        Pair pair16;
        Pair pair17;
        String str;
        String str2;
        String str3;
        String str4;
        d0 d0Var = new d0("");
        if (this.J.size() > 0) {
            pair = t.a("pluginCount", Integer.valueOf(this.J.size()));
        } else {
            pair = null;
        }
        boolean z10 = this.f18686p;
        if (z10 != d0Var.f18686p) {
            pair2 = t.a("autoDetectErrors", Boolean.valueOf(z10));
        } else {
            pair2 = null;
        }
        boolean z11 = this.f18683m;
        if (z11 != d0Var.f18683m) {
            pair3 = t.a("autoTrackSessions", Boolean.valueOf(z11));
        } else {
            pair3 = null;
        }
        if (this.B.size() > 0) {
            pair4 = t.a("discardClassesCount", Integer.valueOf(this.B.size()));
        } else {
            pair4 = null;
        }
        if (!m.b(this.D, d0Var.D)) {
            pair5 = t.a("enabledBreadcrumbTypes", j0(this.D));
        } else {
            pair5 = null;
        }
        if (!m.b(this.f18685o, d0Var.f18685o)) {
            if (this.f18685o.b()) {
                str = "anrs";
            } else {
                str = null;
            }
            if (this.f18685o.c()) {
                str2 = "ndkCrashes";
            } else {
                str2 = null;
            }
            if (this.f18685o.d()) {
                str3 = "unhandledExceptions";
            } else {
                str3 = null;
            }
            if (this.f18685o.e()) {
                str4 = "unhandledRejections";
            } else {
                str4 = null;
            }
            pair6 = t.a("enabledErrorTypes", j0(r.p(str, str2, str3, str4)));
        } else {
            pair6 = null;
        }
        long j10 = this.f18682l;
        if (j10 != 0) {
            pair7 = t.a("launchDurationMillis", Long.valueOf(j10));
        } else {
            pair7 = null;
        }
        if (!m.b(this.f18688r, d3.f18705a)) {
            pair8 = t.a("logger", Boolean.TRUE);
        } else {
            pair8 = null;
        }
        int i10 = this.f18691u;
        if (i10 != d0Var.f18691u) {
            pair9 = t.a("maxBreadcrumbs", Integer.valueOf(i10));
        } else {
            pair9 = null;
        }
        int i11 = this.f18692v;
        if (i11 != d0Var.f18692v) {
            pair10 = t.a("maxPersistedEvents", Integer.valueOf(i11));
        } else {
            pair10 = null;
        }
        int i12 = this.f18693w;
        if (i12 != d0Var.f18693w) {
            pair11 = t.a("maxPersistedSessions", Integer.valueOf(i12));
        } else {
            pair11 = null;
        }
        int i13 = this.f18694x;
        if (i13 != d0Var.f18694x) {
            pair13 = t.a("maxReportedThreads", Integer.valueOf(i13));
            pair12 = pair2;
        } else {
            pair12 = pair2;
            pair13 = null;
        }
        long j11 = this.f18695y;
        Pair pair18 = pair13;
        if (j11 != d0Var.f18695y) {
            pair14 = t.a("threadCollectionTimeLimitMillis", Long.valueOf(j11));
        } else {
            pair14 = null;
        }
        if (this.G != null) {
            pair15 = t.a("persistenceDirectorySet", Boolean.TRUE);
        } else {
            pair15 = null;
        }
        d4 d4Var = this.f18679i;
        if (d4Var != d0Var.f18679i) {
            pair16 = t.a("sendThreads", d4Var);
        } else {
            pair16 = null;
        }
        boolean z12 = this.H;
        if (z12 != d0Var.H) {
            pair17 = t.a("attemptDeliveryOnCrash", Boolean.valueOf(z12));
        } else {
            pair17 = null;
        }
        return i0.n(r.p(pair, pair12, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, pair18, pair14, pair15, pair16, pair17));
    }

    public final void g0(d4 d4Var) {
        this.f18679i = d4Var;
    }

    public final String h() {
        return this.A;
    }

    public final void h0(long j10) {
        this.f18695y = j10;
    }

    public final r0 i() {
        return this.f18689s;
    }

    public final void i0(Integer num) {
        this.f18677g = num;
    }

    public final Set j() {
        return this.B;
    }

    public final Set k() {
        return this.D;
    }

    public final n1 l() {
        return this.f18685o;
    }

    public final Set m() {
        return this.C;
    }

    public final j1 n() {
        return this.f18690t;
    }

    public final boolean o() {
        return this.f18681k;
    }

    public final long p() {
        return this.f18682l;
    }

    public final s2 q() {
        return this.f18688r;
    }

    public final int r() {
        return this.f18691u;
    }

    public final int s() {
        return this.f18692v;
    }

    public final int t() {
        return this.f18693w;
    }

    public final int u() {
        return this.f18694x;
    }

    public final int v() {
        return this.f18696z;
    }

    public final e3 w() {
        return this.I;
    }

    public final boolean x() {
        return this.f18680j;
    }

    public final File y() {
        return this.G;
    }

    /* access modifiers changed from: protected */
    public final HashSet z() {
        return this.J;
    }
}
