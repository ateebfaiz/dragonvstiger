package e2;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.o;
import e2.g;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class m {

    /* renamed from: b  reason: collision with root package name */
    public static final a f21204b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final h f21205a;

    public static final class a {
        private a() {
        }

        public final Executor a() {
            return h.f21178j.f();
        }

        public final g.b b() {
            return h.f21178j.h();
        }

        public final String c() {
            return h.f21178j.j();
        }

        public final void d(Map map) {
            kotlin.jvm.internal.m.f(map, "ud");
            p.i(map);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public m(h hVar) {
        kotlin.jvm.internal.m.f(hVar, "loggerImpl");
        this.f21205a = hVar;
    }

    public final void a() {
        this.f21205a.j();
    }

    public final void b(Bundle bundle) {
        boolean z10;
        kotlin.jvm.internal.m.f(bundle, "parameters");
        if ((bundle.getInt("previous") & 2) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || o.k()) {
            this.f21205a.o("fb_sdk_settings_changed", (Double) null, bundle);
        }
    }

    public final void c(String str, double d10, Bundle bundle) {
        if (o.k()) {
            this.f21205a.k(str, d10, bundle);
        }
    }

    public final void d(String str, Bundle bundle) {
        if (o.k()) {
            this.f21205a.l(str, bundle);
        }
    }

    public final void e(String str, String str2) {
        this.f21205a.n(str, str2);
    }

    public final void f(String str) {
        if (o.k()) {
            this.f21205a.o(str, (Double) null, (Bundle) null);
        }
    }

    public final void g(String str, Bundle bundle) {
        if (o.k()) {
            this.f21205a.o(str, (Double) null, bundle);
        }
    }

    public final void h(String str, Double d10, Bundle bundle) {
        if (o.k()) {
            this.f21205a.o(str, d10, bundle);
        }
    }

    public final void i(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (o.k()) {
            this.f21205a.p(str, bigDecimal, currency, bundle);
        }
    }

    public final void j(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (o.k()) {
            this.f21205a.r(bigDecimal, currency, bundle);
        }
    }

    public m(Context context) {
        this(new h(context, (String) null, (AccessToken) null));
    }

    public m(Context context, String str) {
        this(new h(context, str, (AccessToken) null));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public m(String str, String str2, AccessToken accessToken) {
        this(new h(str, str2, accessToken));
        kotlin.jvm.internal.m.f(str, "activityName");
    }
}
