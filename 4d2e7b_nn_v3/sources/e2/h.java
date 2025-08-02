package e2;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.adjust.sdk.Constants;
import com.facebook.AccessToken;
import com.facebook.l;
import com.facebook.o;
import com.facebook.w;
import e2.g;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import q5.a0;
import q5.d0;
import q5.n;
import q5.p0;
import q5.q;
import q5.q0;
import q5.s;

public final class h {

    /* renamed from: c  reason: collision with root package name */
    private static final String f21171c;

    /* renamed from: d  reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f21172d;

    /* renamed from: e  reason: collision with root package name */
    private static g.b f21173e = g.b.AUTO;

    /* renamed from: f  reason: collision with root package name */
    private static final Object f21174f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static String f21175g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f21176h;

    /* renamed from: i  reason: collision with root package name */
    private static String f21177i;

    /* renamed from: j  reason: collision with root package name */
    public static final a f21178j = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f21179a;

    /* renamed from: b  reason: collision with root package name */
    private a f21180b;

    public static final class a {

        /* renamed from: e2.h$a$a  reason: collision with other inner class name */
        public static final class C0265a implements a0.a {
            C0265a() {
            }

            public void a(String str) {
                h.f21178j.p(str);
            }
        }

        static final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f21181a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h f21182b;

            b(Context context, h hVar) {
                this.f21181a = context;
                this.f21182b = hVar;
            }

            public final void run() {
                if (!v5.a.d(this)) {
                    try {
                        Bundle bundle = new Bundle();
                        String[] strArr = {"com.facebook.core.Core", "com.facebook.login.Login", "com.facebook.share.Share", "com.facebook.places.Places", "com.facebook.messenger.Messenger", "com.facebook.applinks.AppLinks", "com.facebook.marketing.Marketing", "com.facebook.gamingservices.GamingServices", "com.facebook.all.All", "com.android.billingclient.api.BillingClient", "com.android.vending.billing.IInAppBillingService"};
                        String[] strArr2 = {"core_lib_included", "login_lib_included", "share_lib_included", "places_lib_included", "messenger_lib_included", "applinks_lib_included", "marketing_lib_included", "gamingservices_lib_included", "all_lib_included", "billing_client_lib_included", "billing_service_lib_included"};
                        int i10 = 0;
                        for (int i11 = 0; i11 < 11; i11++) {
                            String str = strArr[i11];
                            String str2 = strArr2[i11];
                            try {
                                Class.forName(str);
                                bundle.putInt(str2, 1);
                                i10 |= 1 << i11;
                            } catch (ClassNotFoundException unused) {
                            }
                        }
                        SharedPreferences sharedPreferences = this.f21181a.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
                        if (sharedPreferences.getInt("kitsBitmask", 0) != i10) {
                            sharedPreferences.edit().putInt("kitsBitmask", i10).apply();
                            this.f21182b.o("fb_sdk_initialize", (Double) null, bundle);
                        }
                    } catch (Throwable th) {
                        v5.a.b(th, this);
                    }
                }
            }
        }

        static final class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public static final c f21183a = new c();

            c() {
            }

            public final void run() {
                if (!v5.a.d(this)) {
                    try {
                        HashSet<String> hashSet = new HashSet<>();
                        for (a b10 : e.m()) {
                            hashSet.add(b10.b());
                        }
                        for (String o10 : hashSet) {
                            s.o(o10, true);
                        }
                    } catch (Throwable th) {
                        v5.a.b(th, this);
                    }
                }
            }
        }

        private a() {
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            r3 = e2.h.a.c.f21183a;
            r2 = e2.h.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
            if (r2 == null) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
            r2.scheduleAtFixedRate(r3, 0, (long) 86400, java.util.concurrent.TimeUnit.SECONDS);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
            throw new java.lang.IllegalStateException("Required value was null.".toString());
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void l() {
            /*
                r9 = this;
                java.lang.Object r0 = e2.h.e()
                monitor-enter(r0)
                java.util.concurrent.ScheduledThreadPoolExecutor r1 = e2.h.b()     // Catch:{ all -> 0x0039 }
                if (r1 == 0) goto L_0x000d
                monitor-exit(r0)
                return
            L_0x000d:
                java.util.concurrent.ScheduledThreadPoolExecutor r1 = new java.util.concurrent.ScheduledThreadPoolExecutor     // Catch:{ all -> 0x0039 }
                r2 = 1
                r1.<init>(r2)     // Catch:{ all -> 0x0039 }
                e2.h.i(r1)     // Catch:{ all -> 0x0039 }
                kotlin.Unit r1 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0039 }
                monitor-exit(r0)
                e2.h$a$c r3 = e2.h.a.c.f21183a
                java.util.concurrent.ScheduledThreadPoolExecutor r2 = e2.h.b()
                if (r2 == 0) goto L_0x002d
                r0 = 86400(0x15180, float:1.21072E-40)
                long r6 = (long) r0
                java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS
                r4 = 0
                r2.scheduleAtFixedRate(r3, r4, r6, r8)
                return
            L_0x002d:
                java.lang.String r0 = "Required value was null."
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r0 = r0.toString()
                r1.<init>(r0)
                throw r1
            L_0x0039:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: e2.h.a.l():void");
        }

        /* access modifiers changed from: private */
        public final void m(c cVar, a aVar) {
            e.h(aVar, cVar);
            if (n.g(n.b.OnDevicePostInstallEventProcessing) && n2.a.b()) {
                n2.a.c(aVar.b(), cVar);
            }
            if (!cVar.c() && !h.f()) {
                if (m.b(cVar.f(), "fb_mobile_activate_app")) {
                    h.g(true);
                } else {
                    d0.f23283f.b(w.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
                }
            }
        }

        /* access modifiers changed from: private */
        public final void n(String str) {
            d0.f23283f.b(w.DEVELOPER_ERRORS, "AppEvents", str);
        }

        public final void d(Application application, String str) {
            m.f(application, "application");
            if (o.A()) {
                b.d();
                p.g();
                if (str == null) {
                    str = o.g();
                }
                o.F(application, str);
                l2.a.x(application, str);
                return;
            }
            throw new l("The Facebook sdk must be initialized before calling activateApp");
        }

        public final void e() {
            if (h() != g.b.EXPLICIT_ONLY) {
                e.k(j.EAGER_FLUSHING_EVENT);
            }
        }

        public final Executor f() {
            if (h.b() == null) {
                l();
            }
            ScheduledThreadPoolExecutor b10 = h.b();
            if (b10 != null) {
                return b10;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        public final String g(Context context) {
            m.f(context, "context");
            if (h.a() == null) {
                synchronized (h.e()) {
                    try {
                        if (h.a() == null) {
                            h.h(context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", (String) null));
                            if (h.a() == null) {
                                h.h("XZ" + UUID.randomUUID().toString());
                                context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", h.a()).apply();
                            }
                        }
                        Unit unit = Unit.f12577a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            String a10 = h.a();
            if (a10 != null) {
                return a10;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        public final g.b h() {
            g.b c10;
            synchronized (h.e()) {
                c10 = h.c();
            }
            return c10;
        }

        public final String i() {
            a0.d(new C0265a());
            return o.f().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString(Constants.INSTALL_REFERRER, (String) null);
        }

        public final String j() {
            String d10;
            synchronized (h.e()) {
                d10 = h.d();
            }
            return d10;
        }

        public final void k(Context context, String str) {
            m.f(context, "context");
            if (o.k()) {
                h hVar = new h(context, str, (AccessToken) null);
                ScheduledThreadPoolExecutor b10 = h.b();
                if (b10 != null) {
                    b10.execute(new b(context, hVar));
                    return;
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
        }

        public final void o() {
            e.o();
        }

        public final void p(String str) {
            SharedPreferences sharedPreferences = o.f().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            if (str != null) {
                sharedPreferences.edit().putString(Constants.INSTALL_REFERRER, str).apply();
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String canonicalName = h.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "com.facebook.appevents.AppEventsLoggerImpl";
        }
        m.e(canonicalName, "AppEventsLoggerImpl::cla…ents.AppEventsLoggerImpl\"");
        f21171c = canonicalName;
    }

    public h(String str, String str2, AccessToken accessToken) {
        m.f(str, "activityName");
        q0.o();
        this.f21179a = str;
        accessToken = accessToken == null ? AccessToken.N0.e() : accessToken;
        if (accessToken == null || accessToken.p() || (str2 != null && !m.b(str2, accessToken.c()))) {
            str2 = str2 == null ? p0.E(o.f()) : str2;
            if (str2 != null) {
                this.f21180b = new a((String) null, str2);
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        } else {
            this.f21180b = new a(accessToken);
        }
        f21178j.l();
    }

    public static final /* synthetic */ String a() {
        Class<h> cls = h.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21175g;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ ScheduledThreadPoolExecutor b() {
        Class<h> cls = h.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21172d;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ g.b c() {
        Class<h> cls = h.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21173e;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ String d() {
        Class<h> cls = h.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21177i;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Object e() {
        Class<h> cls = h.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21174f;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ boolean f() {
        Class<h> cls = h.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            return f21176h;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    public static final /* synthetic */ void g(boolean z10) {
        Class<h> cls = h.class;
        if (!v5.a.d(cls)) {
            try {
                f21176h = z10;
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final /* synthetic */ void h(String str) {
        Class<h> cls = h.class;
        if (!v5.a.d(cls)) {
            try {
                f21175g = str;
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final /* synthetic */ void i(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        Class<h> cls = h.class;
        if (!v5.a.d(cls)) {
            try {
                f21172d = scheduledThreadPoolExecutor;
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public final void j() {
        if (!v5.a.d(this)) {
            try {
                e.k(j.EXPLICIT);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final void k(String str, double d10, Bundle bundle) {
        if (!v5.a.d(this)) {
            try {
                m(str, Double.valueOf(d10), bundle, false, l2.a.q());
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final void l(String str, Bundle bundle) {
        if (!v5.a.d(this)) {
            try {
                m(str, (Double) null, bundle, false, l2.a.q());
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final void m(String str, Double d10, Bundle bundle, boolean z10, UUID uuid) {
        if (!v5.a.d(this) && str != null) {
            try {
                if (str.length() != 0) {
                    if (q.f("app_events_killswitch", o.g(), false)) {
                        d0.f23283f.c(w.APP_EVENTS, "AppEvents", "KillSwitch is enabled and fail to log app event: %s", str);
                        return;
                    }
                    f21178j.m(new c(this.f21179a, str, d10, bundle, z10, l2.a.s(), uuid), this.f21180b);
                }
            } catch (JSONException e10) {
                d0.f23283f.c(w.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e10.toString());
            } catch (l e11) {
                d0.f23283f.c(w.APP_EVENTS, "AppEvents", "Invalid app event: %s", e11.toString());
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final void n(String str, String str2) {
        if (!v5.a.d(this)) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("_is_suggested_event", "1");
                bundle.putString("_button_text", str2);
                l(str, bundle);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final void o(String str, Double d10, Bundle bundle) {
        if (!v5.a.d(this)) {
            try {
                m(str, d10, bundle, true, l2.a.q());
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final void p(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (!v5.a.d(this)) {
            if (bigDecimal == null || currency == null) {
                p0.f0(f21171c, "purchaseAmount and currency cannot be null");
                return;
            }
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                    return;
                }
            }
            Bundle bundle2 = bundle;
            bundle2.putString("fb_currency", currency.getCurrencyCode());
            m(str, Double.valueOf(bigDecimal.doubleValue()), bundle2, true, l2.a.q());
        }
    }

    public final void q(BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z10) {
        if (!v5.a.d(this)) {
            if (bigDecimal == null) {
                try {
                    f21178j.n("purchaseAmount cannot be null");
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            } else if (currency == null) {
                f21178j.n("currency cannot be null");
            } else {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                Bundle bundle2 = bundle;
                bundle2.putString("fb_currency", currency.getCurrencyCode());
                m("fb_mobile_purchase", Double.valueOf(bigDecimal.doubleValue()), bundle2, z10, l2.a.q());
                f21178j.e();
            }
        }
    }

    public final void r(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (!v5.a.d(this)) {
            try {
                q(bigDecimal, currency, bundle, true);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public h(Context context, String str, AccessToken accessToken) {
        this(p0.t(context), str, accessToken);
    }
}
