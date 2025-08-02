package c1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.adjust.sdk.AdjustConfig;
import com.bugsnag.android.d3;
import com.bugsnag.android.d4;
import com.bugsnag.android.f0;
import com.bugsnag.android.g0;
import com.bugsnag.android.j1;
import com.bugsnag.android.n1;
import com.bugsnag.android.o0;
import com.bugsnag.android.p0;
import com.bugsnag.android.r0;
import com.bugsnag.android.s2;
import d1.d;
import d1.e;
import d1.g;
import java.io.File;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.r;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.o;
import kotlin.p;

public abstract class k {

    public static final class a extends e {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ApplicationInfo f17257e;

        public a(ApplicationInfo applicationInfo) {
            this.f17257e = applicationInfo;
        }

        public Object e() {
            return g.f17218a.c(this.f17257e);
        }
    }

    static final class b extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f0 f17258a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f17259b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(f0 f0Var, Context context) {
            super(0);
            this.f17258a = f0Var;
            this.f17259b = context;
        }

        /* renamed from: a */
        public final File invoke() {
            File w10 = this.f17258a.w();
            if (w10 == null) {
                return this.f17259b.getCacheDir();
            }
            return w10;
        }
    }

    private static final d a(ApplicationInfo applicationInfo, a aVar) {
        Bundle bundle;
        String str = null;
        if (applicationInfo == null) {
            bundle = null;
        } else {
            bundle = applicationInfo.metaData;
        }
        if (bundle != null && bundle.containsKey("com.bugsnag.android.BUILD_UUID")) {
            String string = bundle.getString("com.bugsnag.android.BUILD_UUID");
            if (string == null) {
                string = String.valueOf(bundle.getInt("com.bugsnag.android.BUILD_UUID"));
            }
            if (string.length() > 0) {
                str = string;
            }
            return new g(str);
        } else if (applicationInfo == null) {
            return null;
        } else {
            s sVar = s.IO;
            a aVar2 = new a(applicationInfo);
            aVar.b(sVar, aVar2);
            return aVar2;
        }
    }

    public static final j b(f0 f0Var, d dVar, PackageInfo packageInfo, ApplicationInfo applicationInfo, Lazy lazy) {
        n1 n1Var;
        Set set;
        if (f0Var.d()) {
            n1Var = f0Var.j().a();
        } else {
            n1Var = new n1(false);
        }
        n1 n1Var2 = n1Var;
        String a10 = f0Var.a();
        boolean d10 = f0Var.d();
        boolean e10 = f0Var.e();
        d4 C = f0Var.C();
        Set A0 = r.A0(f0Var.h());
        Set k10 = f0Var.k();
        Set set2 = null;
        if (k10 == null) {
            set = null;
        } else {
            set = r.A0(k10);
        }
        Set A02 = r.A0(f0Var.y());
        String A = f0Var.A();
        String c10 = f0Var.c();
        Integer G = f0Var.G();
        String b10 = f0Var.b();
        r0 g10 = f0Var.g();
        j1 l10 = f0Var.l();
        boolean v10 = f0Var.v();
        boolean m10 = f0Var.m();
        long n10 = f0Var.n();
        s2 o10 = f0Var.o();
        m.c(o10);
        int p10 = f0Var.p();
        int q10 = f0Var.q();
        int r10 = f0Var.r();
        int s10 = f0Var.s();
        int t10 = f0Var.t();
        long E = f0Var.E();
        Set i10 = f0Var.i();
        if (i10 != null) {
            set2 = r.A0(i10);
        }
        return new j(a10, d10, n1Var2, e10, C, A0, set, A02, set2, r.A0(f0Var.D()), A, dVar, c10, G, b10, g10, l10, v10, n10, o10, p10, q10, r10, s10, t10, E, lazy, f0Var.B(), f0Var.H(), m10, packageInfo, applicationInfo, r.A0(f0Var.z()));
    }

    public static final boolean c(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("No Bugsnag API Key set");
        } else if (str.length() != 32) {
            return true;
        } else {
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= str.length()) {
                    z10 = true;
                    break;
                }
                char charAt = str.charAt(i10);
                i10++;
                if (!Character.isDigit(charAt) && ('a' > charAt || charAt >= 'g')) {
                    break;
                }
            }
            return !z10;
        }
    }

    public static final j d(Context context, f0 f0Var, g0 g0Var, a aVar) {
        Object obj;
        Object obj2;
        Integer G;
        e(f0Var.a());
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        try {
            o.a aVar2 = o.f12592b;
            obj = o.b(packageManager.getPackageInfo(packageName, 0));
        } catch (Throwable th) {
            o.a aVar3 = o.f12592b;
            obj = o.b(p.a(th));
        }
        Integer num = null;
        if (o.f(obj)) {
            obj = null;
        }
        PackageInfo packageInfo = (PackageInfo) obj;
        try {
            obj2 = o.b(packageManager.getApplicationInfo(packageName, 128));
        } catch (Throwable th2) {
            o.a aVar4 = o.f12592b;
            obj2 = o.b(p.a(th2));
        }
        if (o.f(obj2)) {
            obj2 = null;
        }
        ApplicationInfo applicationInfo = (ApplicationInfo) obj2;
        if (f0Var.A() == null) {
            f0Var.d0((applicationInfo == null || (applicationInfo.flags & 2) == 0) ? AdjustConfig.ENVIRONMENT_PRODUCTION : "development");
        }
        if (f0Var.o() == null || m.b(f0Var.o(), o0.f18889a)) {
            if (!m.b(AdjustConfig.ENVIRONMENT_PRODUCTION, f0Var.A())) {
                f0Var.V(o0.f18889a);
            } else {
                f0Var.V(d3.f18705a);
            }
        }
        if (f0Var.G() == null || ((G = f0Var.G()) != null && G.intValue() == 0)) {
            if (packageInfo != null) {
                num = Integer.valueOf(packageInfo.versionCode);
            }
            f0Var.h0(num);
        }
        if (f0Var.y().isEmpty()) {
            f0Var.b0(kotlin.collections.r0.c(packageName));
        }
        d a10 = a(applicationInfo, aVar);
        if (f0Var.g() == null) {
            s2 o10 = f0Var.o();
            m.c(o10);
            f0Var.P(new p0(g0Var, o10));
        }
        return b(f0Var, a10, packageInfo, applicationInfo, i.b(new b(f0Var, context)));
    }

    private static final void e(String str) {
        if (c(str)) {
            o0.f18889a.g(m.n("Invalid configuration. apiKey should be a 32-character hexademical string, got ", str));
        }
    }
}
