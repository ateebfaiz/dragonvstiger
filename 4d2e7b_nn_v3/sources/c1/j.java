package c1;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.bugsnag.android.BreadcrumbType;
import com.bugsnag.android.d4;
import com.bugsnag.android.g4;
import com.bugsnag.android.j1;
import com.bugsnag.android.l3;
import com.bugsnag.android.n1;
import com.bugsnag.android.r0;
import com.bugsnag.android.s1;
import com.bugsnag.android.s2;
import com.bugsnag.android.t0;
import com.bugsnag.android.u0;
import d1.d;
import g0.c;
import java.util.Collection;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.collections.r;
import kotlin.jvm.internal.m;

public final class j {
    private final Lazy A;
    private final boolean B;
    private final boolean C;
    private final boolean D;
    private final PackageInfo E;
    private final ApplicationInfo F;
    private final Collection G;

    /* renamed from: a  reason: collision with root package name */
    private final String f17231a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17232b;

    /* renamed from: c  reason: collision with root package name */
    private final n1 f17233c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f17234d;

    /* renamed from: e  reason: collision with root package name */
    private final d4 f17235e;

    /* renamed from: f  reason: collision with root package name */
    private final Collection f17236f;

    /* renamed from: g  reason: collision with root package name */
    private final Collection f17237g;

    /* renamed from: h  reason: collision with root package name */
    private final Collection f17238h;

    /* renamed from: i  reason: collision with root package name */
    private final Set f17239i;

    /* renamed from: j  reason: collision with root package name */
    private final Set f17240j;

    /* renamed from: k  reason: collision with root package name */
    private final String f17241k;

    /* renamed from: l  reason: collision with root package name */
    private final d f17242l;

    /* renamed from: m  reason: collision with root package name */
    private final String f17243m;

    /* renamed from: n  reason: collision with root package name */
    private final Integer f17244n;

    /* renamed from: o  reason: collision with root package name */
    private final String f17245o;

    /* renamed from: p  reason: collision with root package name */
    private final r0 f17246p;

    /* renamed from: q  reason: collision with root package name */
    private final j1 f17247q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f17248r;

    /* renamed from: s  reason: collision with root package name */
    private final long f17249s;

    /* renamed from: t  reason: collision with root package name */
    private final s2 f17250t;

    /* renamed from: u  reason: collision with root package name */
    private final int f17251u;

    /* renamed from: v  reason: collision with root package name */
    private final int f17252v;

    /* renamed from: w  reason: collision with root package name */
    private final int f17253w;

    /* renamed from: x  reason: collision with root package name */
    private final int f17254x;

    /* renamed from: y  reason: collision with root package name */
    private final int f17255y;

    /* renamed from: z  reason: collision with root package name */
    private final long f17256z;

    public j(String str, boolean z10, n1 n1Var, boolean z11, d4 d4Var, Collection collection, Collection collection2, Collection collection3, Set set, Set set2, String str2, d dVar, String str3, Integer num, String str4, r0 r0Var, j1 j1Var, boolean z12, long j10, s2 s2Var, int i10, int i11, int i12, int i13, int i14, long j11, Lazy lazy, boolean z13, boolean z14, boolean z15, PackageInfo packageInfo, ApplicationInfo applicationInfo, Collection collection4) {
        this.f17231a = str;
        this.f17232b = z10;
        this.f17233c = n1Var;
        this.f17234d = z11;
        this.f17235e = d4Var;
        this.f17236f = collection;
        this.f17237g = collection2;
        this.f17238h = collection3;
        this.f17239i = set;
        this.f17240j = set2;
        this.f17241k = str2;
        this.f17242l = dVar;
        this.f17243m = str3;
        this.f17244n = num;
        this.f17245o = str4;
        this.f17246p = r0Var;
        this.f17247q = j1Var;
        this.f17248r = z12;
        this.f17249s = j10;
        this.f17250t = s2Var;
        this.f17251u = i10;
        this.f17252v = i11;
        this.f17253w = i12;
        this.f17254x = i13;
        this.f17255y = i14;
        this.f17256z = j11;
        this.A = lazy;
        this.B = z13;
        this.C = z14;
        this.D = z15;
        this.E = packageInfo;
        this.F = applicationInfo;
        this.G = collection4;
    }

    public final Collection A() {
        return this.f17238h;
    }

    public final Collection B() {
        return this.G;
    }

    public final String C() {
        return this.f17241k;
    }

    public final boolean D() {
        return this.B;
    }

    public final d4 E() {
        return this.f17235e;
    }

    public final u0 F(l3 l3Var) {
        return new u0(this.f17247q.b(), t0.c(l3Var.c()));
    }

    public final Set G() {
        return this.f17240j;
    }

    public final long H() {
        return this.f17256z;
    }

    public final Integer I() {
        return this.f17244n;
    }

    public final boolean J(BreadcrumbType breadcrumbType) {
        Set set = this.f17239i;
        if (set == null || set.contains(breadcrumbType)) {
            return false;
        }
        return true;
    }

    public final boolean K(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Iterable<Pattern> iterable = this.f17236f;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (Pattern matcher : iterable) {
            if (matcher.matcher(str.toString()).matches()) {
                return true;
            }
        }
        return false;
    }

    public final boolean L(Throwable th) {
        Iterable<Throwable> a10 = g4.a(th);
        if ((a10 instanceof Collection) && ((Collection) a10).isEmpty()) {
            return false;
        }
        for (Throwable th2 : a10) {
            if (K(th2.getClass().getName())) {
                return true;
            }
        }
        return false;
    }

    public final boolean M() {
        Collection collection = this.f17237g;
        if (collection == null || r.S(collection, this.f17241k)) {
            return false;
        }
        return true;
    }

    public final boolean N(String str) {
        if (M() || K(str)) {
            return true;
        }
        return false;
    }

    public final boolean O(Throwable th) {
        if (M() || L(th)) {
            return true;
        }
        return false;
    }

    public final boolean P(boolean z10) {
        if (M() || (z10 && !this.f17234d)) {
            return true;
        }
        return false;
    }

    public final String a() {
        return this.f17231a;
    }

    public final ApplicationInfo b() {
        return this.F;
    }

    public final String c() {
        return this.f17245o;
    }

    public final String d() {
        return this.f17243m;
    }

    public final boolean e() {
        return this.C;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (m.b(this.f17231a, jVar.f17231a) && this.f17232b == jVar.f17232b && m.b(this.f17233c, jVar.f17233c) && this.f17234d == jVar.f17234d && this.f17235e == jVar.f17235e && m.b(this.f17236f, jVar.f17236f) && m.b(this.f17237g, jVar.f17237g) && m.b(this.f17238h, jVar.f17238h) && m.b(this.f17239i, jVar.f17239i) && m.b(this.f17240j, jVar.f17240j) && m.b(this.f17241k, jVar.f17241k) && m.b(this.f17242l, jVar.f17242l) && m.b(this.f17243m, jVar.f17243m) && m.b(this.f17244n, jVar.f17244n) && m.b(this.f17245o, jVar.f17245o) && m.b(this.f17246p, jVar.f17246p) && m.b(this.f17247q, jVar.f17247q) && this.f17248r == jVar.f17248r && this.f17249s == jVar.f17249s && m.b(this.f17250t, jVar.f17250t) && this.f17251u == jVar.f17251u && this.f17252v == jVar.f17252v && this.f17253w == jVar.f17253w && this.f17254x == jVar.f17254x && this.f17255y == jVar.f17255y && this.f17256z == jVar.f17256z && m.b(this.A, jVar.A) && this.B == jVar.B && this.C == jVar.C && this.D == jVar.D && m.b(this.E, jVar.E) && m.b(this.F, jVar.F) && m.b(this.G, jVar.G)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        return this.f17232b;
    }

    public final boolean g() {
        return this.f17234d;
    }

    public final d h() {
        return this.f17242l;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int hashCode = this.f17231a.hashCode() * 31;
        boolean z10 = this.f17232b;
        boolean z11 = true;
        if (z10) {
            z10 = true;
        }
        int hashCode2 = (((hashCode + (z10 ? 1 : 0)) * 31) + this.f17233c.hashCode()) * 31;
        boolean z12 = this.f17234d;
        if (z12) {
            z12 = true;
        }
        int hashCode3 = (((((hashCode2 + (z12 ? 1 : 0)) * 31) + this.f17235e.hashCode()) * 31) + this.f17236f.hashCode()) * 31;
        Collection collection = this.f17237g;
        int i18 = 0;
        if (collection == null) {
            i10 = 0;
        } else {
            i10 = collection.hashCode();
        }
        int hashCode4 = (((hashCode3 + i10) * 31) + this.f17238h.hashCode()) * 31;
        Set set = this.f17239i;
        if (set == null) {
            i11 = 0;
        } else {
            i11 = set.hashCode();
        }
        int hashCode5 = (((hashCode4 + i11) * 31) + this.f17240j.hashCode()) * 31;
        String str = this.f17241k;
        if (str == null) {
            i12 = 0;
        } else {
            i12 = str.hashCode();
        }
        int i19 = (hashCode5 + i12) * 31;
        d dVar = this.f17242l;
        if (dVar == null) {
            i13 = 0;
        } else {
            i13 = dVar.hashCode();
        }
        int i20 = (i19 + i13) * 31;
        String str2 = this.f17243m;
        if (str2 == null) {
            i14 = 0;
        } else {
            i14 = str2.hashCode();
        }
        int i21 = (i20 + i14) * 31;
        Integer num = this.f17244n;
        if (num == null) {
            i15 = 0;
        } else {
            i15 = num.hashCode();
        }
        int i22 = (i21 + i15) * 31;
        String str3 = this.f17245o;
        if (str3 == null) {
            i16 = 0;
        } else {
            i16 = str3.hashCode();
        }
        int hashCode6 = (((((i22 + i16) * 31) + this.f17246p.hashCode()) * 31) + this.f17247q.hashCode()) * 31;
        boolean z13 = this.f17248r;
        if (z13) {
            z13 = true;
        }
        int a10 = (((((((((((((((((((hashCode6 + (z13 ? 1 : 0)) * 31) + c.a(this.f17249s)) * 31) + this.f17250t.hashCode()) * 31) + this.f17251u) * 31) + this.f17252v) * 31) + this.f17253w) * 31) + this.f17254x) * 31) + this.f17255y) * 31) + c.a(this.f17256z)) * 31) + this.A.hashCode()) * 31;
        boolean z14 = this.B;
        if (z14) {
            z14 = true;
        }
        int i23 = (a10 + (z14 ? 1 : 0)) * 31;
        boolean z15 = this.C;
        if (z15) {
            z15 = true;
        }
        int i24 = (i23 + (z15 ? 1 : 0)) * 31;
        boolean z16 = this.D;
        if (!z16) {
            z11 = z16;
        }
        int i25 = (i24 + (z11 ? 1 : 0)) * 31;
        PackageInfo packageInfo = this.E;
        if (packageInfo == null) {
            i17 = 0;
        } else {
            i17 = packageInfo.hashCode();
        }
        int i26 = (i25 + i17) * 31;
        ApplicationInfo applicationInfo = this.F;
        if (applicationInfo != null) {
            i18 = applicationInfo.hashCode();
        }
        return ((i26 + i18) * 31) + this.G.hashCode();
    }

    public final r0 i() {
        return this.f17246p;
    }

    public final Collection j() {
        return this.f17236f;
    }

    public final Set k() {
        return this.f17239i;
    }

    public final n1 l() {
        return this.f17233c;
    }

    public final Collection m() {
        return this.f17237g;
    }

    public final j1 n() {
        return this.f17247q;
    }

    public final u0 o(s1 s1Var) {
        return new u0(this.f17247q.a(), t0.a(s1Var));
    }

    public final boolean p() {
        return this.D;
    }

    public final long q() {
        return this.f17249s;
    }

    public final s2 r() {
        return this.f17250t;
    }

    public final int s() {
        return this.f17251u;
    }

    public final int t() {
        return this.f17252v;
    }

    public String toString() {
        return "ImmutableConfig(apiKey=" + this.f17231a + ", autoDetectErrors=" + this.f17232b + ", enabledErrorTypes=" + this.f17233c + ", autoTrackSessions=" + this.f17234d + ", sendThreads=" + this.f17235e + ", discardClasses=" + this.f17236f + ", enabledReleaseStages=" + this.f17237g + ", projectPackages=" + this.f17238h + ", enabledBreadcrumbTypes=" + this.f17239i + ", telemetry=" + this.f17240j + ", releaseStage=" + this.f17241k + ", buildUuid=" + this.f17242l + ", appVersion=" + this.f17243m + ", versionCode=" + this.f17244n + ", appType=" + this.f17245o + ", delivery=" + this.f17246p + ", endpoints=" + this.f17247q + ", persistUser=" + this.f17248r + ", launchDurationMillis=" + this.f17249s + ", logger=" + this.f17250t + ", maxBreadcrumbs=" + this.f17251u + ", maxPersistedEvents=" + this.f17252v + ", maxPersistedSessions=" + this.f17253w + ", maxReportedThreads=" + this.f17254x + ", maxStringValueLength=" + this.f17255y + ", threadCollectionTimeLimitMillis=" + this.f17256z + ", persistenceDirectory=" + this.A + ", sendLaunchCrashesSynchronously=" + this.B + ", attemptDeliveryOnCrash=" + this.C + ", generateAnonymousId=" + this.D + ", packageInfo=" + this.E + ", appInfo=" + this.F + ", redactedKeys=" + this.G + ')';
    }

    public final int u() {
        return this.f17253w;
    }

    public final int v() {
        return this.f17254x;
    }

    public final int w() {
        return this.f17255y;
    }

    public final PackageInfo x() {
        return this.E;
    }

    public final boolean y() {
        return this.f17248r;
    }

    public final Lazy z() {
        return this.A;
    }
}
