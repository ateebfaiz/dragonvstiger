package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.facebook.GraphRequest;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;
import q5.p0;
import q5.r;
import q5.s;

public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19667a;

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicBoolean f19668b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicBoolean f19669c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private static final a f19670d = new a(true, "com.facebook.sdk.AutoInitEnabled");

    /* renamed from: e  reason: collision with root package name */
    private static final a f19671e = new a(true, "com.facebook.sdk.AutoLogAppEventsEnabled");

    /* renamed from: f  reason: collision with root package name */
    private static final a f19672f = new a(true, "com.facebook.sdk.AdvertiserIDCollectionEnabled");

    /* renamed from: g  reason: collision with root package name */
    private static final a f19673g = new a(false, "auto_event_setup_enabled");

    /* renamed from: h  reason: collision with root package name */
    private static final a f19674h = new a(true, "com.facebook.sdk.MonitorEnabled");

    /* renamed from: i  reason: collision with root package name */
    private static SharedPreferences f19675i;

    /* renamed from: j  reason: collision with root package name */
    public static final e0 f19676j = new e0();

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Boolean f19677a;

        /* renamed from: b  reason: collision with root package name */
        private long f19678b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f19679c;

        /* renamed from: d  reason: collision with root package name */
        private String f19680d;

        public a(boolean z10, String str) {
            m.f(str, "key");
            this.f19679c = z10;
            this.f19680d = str;
        }

        public final boolean a() {
            return this.f19679c;
        }

        public final String b() {
            return this.f19680d;
        }

        public final long c() {
            return this.f19678b;
        }

        public final Boolean d() {
            return this.f19677a;
        }

        public final boolean e() {
            Boolean bool = this.f19677a;
            if (bool != null) {
                return bool.booleanValue();
            }
            return this.f19679c;
        }

        public final void f(long j10) {
            this.f19678b = j10;
        }

        public final void g(Boolean bool) {
            this.f19677a = bool;
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f19681a;

        b(long j10) {
            this.f19681a = j10;
        }

        public final void run() {
            r o10;
            String str;
            JSONObject jSONObject;
            if (!v5.a.d(this)) {
                try {
                    e0 e0Var = e0.f19676j;
                    if (e0.a(e0Var).e() && (o10 = s.o(o.g(), false)) != null && o10.b()) {
                        q5.b e10 = q5.b.f23250h.e(o.f());
                        if (e10 == null || e10.h() == null) {
                            str = null;
                        } else {
                            str = e10.h();
                        }
                        if (str != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("advertiser_id", str);
                            bundle.putString("fields", "auto_event_setup_enabled");
                            if (p0.Y(o.n())) {
                                GraphRequest v10 = GraphRequest.f19541t.v((AccessToken) null, o.g(), (GraphRequest.b) null);
                                v10.G(true);
                                v10.F(bundle);
                                jSONObject = v10.i().c();
                            } else {
                                GraphRequest v11 = GraphRequest.f19541t.v((AccessToken) null, "app", (GraphRequest.b) null);
                                v11.F(bundle);
                                jSONObject = v11.i().c();
                            }
                            if (jSONObject != null) {
                                e0.b(e0Var).g(Boolean.valueOf(jSONObject.optBoolean("auto_event_setup_enabled", false)));
                                e0.b(e0Var).f(this.f19681a);
                                e0.d(e0Var, e0.b(e0Var));
                            }
                        }
                    }
                    e0.c(e0Var).set(false);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static {
        String name = e0.class.getName();
        m.e(name, "UserSettingsManager::class.java.name");
        f19667a = name;
    }

    private e0() {
    }

    public static final /* synthetic */ a a(e0 e0Var) {
        Class<e0> cls = e0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f19672f;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ a b(e0 e0Var) {
        Class<e0> cls = e0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f19673g;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean c(e0 e0Var) {
        Class<e0> cls = e0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f19669c;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void d(e0 e0Var, a aVar) {
        Class<e0> cls = e0.class;
        if (!v5.a.d(cls)) {
            try {
                e0Var.r(aVar);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final boolean e() {
        Class<e0> cls = e0.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            f19676j.j();
            return f19672f.e();
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    public static final boolean f() {
        Class<e0> cls = e0.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            f19676j.j();
            return f19670d.e();
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    public static final boolean g() {
        Class<e0> cls = e0.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            f19676j.j();
            return f19671e.e();
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    public static final boolean h() {
        Class<e0> cls = e0.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            f19676j.j();
            return f19673g.e();
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    private final void i() {
        if (!v5.a.d(this)) {
            try {
                a aVar = f19673g;
                p(aVar);
                long currentTimeMillis = System.currentTimeMillis();
                if (aVar.d() == null || currentTimeMillis - aVar.c() >= 604800000) {
                    aVar.g((Boolean) null);
                    aVar.f(0);
                    if (f19669c.compareAndSet(false, true)) {
                        o.p().execute(new b(currentTimeMillis));
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void j() {
        if (!v5.a.d(this)) {
            try {
                if (o.A() && f19668b.compareAndSet(false, true)) {
                    SharedPreferences sharedPreferences = o.f().getSharedPreferences("com.facebook.sdk.USER_SETTINGS", 0);
                    m.e(sharedPreferences, "FacebookSdk.getApplicati…GS, Context.MODE_PRIVATE)");
                    f19675i = sharedPreferences;
                    k(f19671e, f19672f, f19670d);
                    i();
                    o();
                    n();
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void k(a... aVarArr) {
        if (!v5.a.d(this)) {
            try {
                for (a aVar : aVarArr) {
                    if (aVar == f19673g) {
                        i();
                    } else if (aVar.d() == null) {
                        p(aVar);
                        if (aVar.d() == null) {
                            l(aVar);
                        }
                    } else {
                        r(aVar);
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void l(a aVar) {
        Bundle bundle;
        if (!v5.a.d(this)) {
            try {
                q();
                Context f10 = o.f();
                ApplicationInfo applicationInfo = f10.getPackageManager().getApplicationInfo(f10.getPackageName(), 128);
                if (applicationInfo != null) {
                    bundle = applicationInfo.metaData;
                } else {
                    bundle = null;
                }
                if (bundle != null && applicationInfo.metaData.containsKey(aVar.b())) {
                    aVar.g(Boolean.valueOf(applicationInfo.metaData.getBoolean(aVar.b(), aVar.a())));
                }
            } catch (PackageManager.NameNotFoundException e10) {
                p0.e0(f19667a, e10);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public static final void m() {
        Bundle bundle;
        Class<e0> cls = e0.class;
        if (!v5.a.d(cls)) {
            try {
                Context f10 = o.f();
                ApplicationInfo applicationInfo = f10.getPackageManager().getApplicationInfo(f10.getPackageName(), 128);
                if (applicationInfo != null) {
                    bundle = applicationInfo.metaData;
                } else {
                    bundle = null;
                }
                if (bundle != null && applicationInfo.metaData.getBoolean("com.facebook.sdk.AutoAppLinkEnabled", false)) {
                    e2.m mVar = new e2.m(f10);
                    Bundle bundle2 = new Bundle();
                    if (!p0.Q()) {
                        bundle2.putString("SchemeWarning", "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest");
                        Log.w(f19667a, "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest");
                    }
                    mVar.d("fb_auto_applink", bundle2);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private final void n() {
        int i10;
        int i11;
        Bundle bundle;
        if (!v5.a.d(this)) {
            try {
                if (f19668b.get() && o.A()) {
                    Context f10 = o.f();
                    int i12 = 0;
                    boolean e10 = f19670d.e() | ((f19671e.e() ? 1 : 0) << true) | ((f19672f.e() ? 1 : 0) << true) | ((f19674h.e() ? 1 : 0) << true);
                    SharedPreferences sharedPreferences = f19675i;
                    if (sharedPreferences == null) {
                        m.u("userSettingPref");
                    }
                    int i13 = sharedPreferences.getInt("com.facebook.sdk.USER_SETTINGS_BITMASK", 0);
                    if (i13 != e10) {
                        SharedPreferences sharedPreferences2 = f19675i;
                        if (sharedPreferences2 == null) {
                            m.u("userSettingPref");
                        }
                        sharedPreferences2.edit().putInt("com.facebook.sdk.USER_SETTINGS_BITMASK", e10 ? 1 : 0).apply();
                        try {
                            ApplicationInfo applicationInfo = f10.getPackageManager().getApplicationInfo(f10.getPackageName(), 128);
                            if (applicationInfo != null) {
                                bundle = applicationInfo.metaData;
                            } else {
                                bundle = null;
                            }
                            if (bundle != null) {
                                String[] strArr = {"com.facebook.sdk.AutoInitEnabled", "com.facebook.sdk.AutoLogAppEventsEnabled", "com.facebook.sdk.AdvertiserIDCollectionEnabled", "com.facebook.sdk.MonitorEnabled"};
                                boolean[] zArr = {true, true, true, true};
                                i10 = 0;
                                i11 = 0;
                                while (i12 < 4) {
                                    try {
                                        i11 |= (applicationInfo.metaData.containsKey(strArr[i12]) ? 1 : 0) << i12;
                                        i10 |= (applicationInfo.metaData.getBoolean(strArr[i12], zArr[i12]) ? 1 : 0) << i12;
                                        i12++;
                                    } catch (PackageManager.NameNotFoundException unused) {
                                        i12 = i10;
                                        i10 = i12;
                                        i12 = i11;
                                        e2.m mVar = new e2.m(f10);
                                        Bundle bundle2 = new Bundle();
                                        bundle2.putInt("usage", i12);
                                        bundle2.putInt("initial", i10);
                                        bundle2.putInt("previous", i13);
                                        bundle2.putInt("current", e10);
                                        mVar.b(bundle2);
                                    }
                                }
                                i12 = i11;
                                e2.m mVar2 = new e2.m(f10);
                                Bundle bundle22 = new Bundle();
                                bundle22.putInt("usage", i12);
                                bundle22.putInt("initial", i10);
                                bundle22.putInt("previous", i13);
                                bundle22.putInt("current", e10);
                                mVar2.b(bundle22);
                            }
                            i10 = 0;
                            e2.m mVar22 = new e2.m(f10);
                            Bundle bundle222 = new Bundle();
                            bundle222.putInt("usage", i12);
                            bundle222.putInt("initial", i10);
                            bundle222.putInt("previous", i13);
                            bundle222.putInt("current", e10);
                            mVar22.b(bundle222);
                        } catch (PackageManager.NameNotFoundException unused2) {
                            i11 = 0;
                            i10 = i12;
                            i12 = i11;
                            e2.m mVar222 = new e2.m(f10);
                            Bundle bundle2222 = new Bundle();
                            bundle2222.putInt("usage", i12);
                            bundle2222.putInt("initial", i10);
                            bundle2222.putInt("previous", i13);
                            bundle2222.putInt("current", e10);
                            mVar222.b(bundle2222);
                        }
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void o() {
        Bundle bundle;
        if (!v5.a.d(this)) {
            try {
                Context f10 = o.f();
                ApplicationInfo applicationInfo = f10.getPackageManager().getApplicationInfo(f10.getPackageName(), 128);
                if (applicationInfo != null) {
                    bundle = applicationInfo.metaData;
                } else {
                    bundle = null;
                }
                if (bundle != null) {
                    if (!applicationInfo.metaData.containsKey("com.facebook.sdk.AutoLogAppEventsEnabled")) {
                        Log.w(f19667a, "Please set a value for AutoLogAppEventsEnabled. Set the flag to TRUE if you want to collect app install, app launch and in-app purchase events automatically. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
                    }
                    if (!applicationInfo.metaData.containsKey("com.facebook.sdk.AdvertiserIDCollectionEnabled")) {
                        Log.w(f19667a, "You haven't set a value for AdvertiserIDCollectionEnabled. Set the flag to TRUE if you want to collect Advertiser ID for better advertising and analytics results. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
                    }
                    if (!e()) {
                        Log.w(f19667a, "The value for AdvertiserIDCollectionEnabled is currently set to FALSE so you're sending app events without collecting Advertiser ID. This can affect the quality of your advertising and analytics results.");
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void p(a aVar) {
        String str = "";
        if (!v5.a.d(this)) {
            try {
                q();
                SharedPreferences sharedPreferences = f19675i;
                if (sharedPreferences == null) {
                    m.u("userSettingPref");
                }
                String string = sharedPreferences.getString(aVar.b(), str);
                if (string != null) {
                    str = string;
                }
                m.e(str, "userSettingPref.getStrin…serSetting.key, \"\") ?: \"\"");
                if (str.length() > 0) {
                    JSONObject jSONObject = new JSONObject(str);
                    aVar.g(Boolean.valueOf(jSONObject.getBoolean("value")));
                    aVar.f(jSONObject.getLong("last_timestamp"));
                }
            } catch (JSONException e10) {
                p0.e0(f19667a, e10);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void q() {
        if (!v5.a.d(this)) {
            try {
                if (!f19668b.get()) {
                    throw new p("The UserSettingManager has not been initialized successfully");
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void r(a aVar) {
        if (!v5.a.d(this)) {
            try {
                q();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("value", aVar.d());
                jSONObject.put("last_timestamp", aVar.c());
                SharedPreferences sharedPreferences = f19675i;
                if (sharedPreferences == null) {
                    m.u("userSettingPref");
                }
                sharedPreferences.edit().putString(aVar.b(), jSONObject.toString()).apply();
                n();
            } catch (Exception e10) {
                p0.e0(f19667a, e10);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }
}
