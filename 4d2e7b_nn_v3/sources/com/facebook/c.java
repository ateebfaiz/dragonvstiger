package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.adjust.sdk.Constants;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.s;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;
import q5.p0;

public final class c {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static c f19599f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f19600g = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private AccessToken f19601a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f19602b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private Date f19603c = new Date(0);

    /* renamed from: d  reason: collision with root package name */
    private final LocalBroadcastManager f19604d;

    /* renamed from: e  reason: collision with root package name */
    private final b f19605e;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final GraphRequest c(AccessToken accessToken, GraphRequest.b bVar) {
            e f10 = f(accessToken);
            Bundle bundle = new Bundle();
            bundle.putString("grant_type", f10.a());
            bundle.putString("client_id", accessToken.c());
            bundle.putString("fields", "access_token,expires_at,expires_in,data_access_expiration_time,graph_domain");
            GraphRequest v10 = GraphRequest.f19541t.v(accessToken, f10.b(), bVar);
            v10.F(bundle);
            v10.E(u.GET);
            return v10;
        }

        /* access modifiers changed from: private */
        public final GraphRequest d(AccessToken accessToken, GraphRequest.b bVar) {
            Bundle bundle = new Bundle();
            bundle.putString("fields", "permission,status");
            GraphRequest v10 = GraphRequest.f19541t.v(accessToken, "me/permissions", bVar);
            v10.F(bundle);
            v10.E(u.GET);
            return v10;
        }

        private final e f(AccessToken accessToken) {
            String i10 = accessToken.i();
            if (i10 == null) {
                i10 = "facebook";
            }
            if (i10.hashCode() == 28903346 && i10.equals("instagram")) {
                return new C0246c();
            }
            return new b();
        }

        public final c e() {
            c a10;
            c a11 = c.f19599f;
            if (a11 != null) {
                return a11;
            }
            synchronized (this) {
                a10 = c.f19599f;
                if (a10 == null) {
                    LocalBroadcastManager instance = LocalBroadcastManager.getInstance(o.f());
                    m.e(instance, "LocalBroadcastManager.ge…tance(applicationContext)");
                    c cVar = new c(instance, new b());
                    c.f19599f = cVar;
                    a10 = cVar;
                }
            }
            return a10;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements e {

        /* renamed from: a  reason: collision with root package name */
        private final String f19606a = "oauth/access_token";

        /* renamed from: b  reason: collision with root package name */
        private final String f19607b = "fb_extend_sso_token";

        public String a() {
            return this.f19607b;
        }

        public String b() {
            return this.f19606a;
        }
    }

    /* renamed from: com.facebook.c$c  reason: collision with other inner class name */
    public static final class C0246c implements e {

        /* renamed from: a  reason: collision with root package name */
        private final String f19608a = "refresh_access_token";

        /* renamed from: b  reason: collision with root package name */
        private final String f19609b = "ig_refresh_token";

        public String a() {
            return this.f19609b;
        }

        public String b() {
            return this.f19608a;
        }
    }

    private static final class d {

        /* renamed from: a  reason: collision with root package name */
        private String f19610a;

        /* renamed from: b  reason: collision with root package name */
        private int f19611b;

        /* renamed from: c  reason: collision with root package name */
        private int f19612c;

        /* renamed from: d  reason: collision with root package name */
        private Long f19613d;

        /* renamed from: e  reason: collision with root package name */
        private String f19614e;

        public final String a() {
            return this.f19610a;
        }

        public final Long b() {
            return this.f19613d;
        }

        public final int c() {
            return this.f19611b;
        }

        public final int d() {
            return this.f19612c;
        }

        public final String e() {
            return this.f19614e;
        }

        public final void f(String str) {
            this.f19610a = str;
        }

        public final void g(Long l10) {
            this.f19613d = l10;
        }

        public final void h(int i10) {
            this.f19611b = i10;
        }

        public final void i(int i10) {
            this.f19612c = i10;
        }

        public final void j(String str) {
            this.f19614e = str;
        }
    }

    public interface e {
        String a();

        String b();
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f19615a;

        f(c cVar, AccessToken.a aVar) {
            this.f19615a = cVar;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    this.f19615a.j((AccessToken.a) null);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static final class g implements s.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f19616a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f19617b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AccessToken f19618c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f19619d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Set f19620e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Set f19621f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Set f19622g;

        g(c cVar, d dVar, AccessToken accessToken, AccessToken.a aVar, AtomicBoolean atomicBoolean, Set set, Set set2, Set set3) {
            this.f19616a = cVar;
            this.f19617b = dVar;
            this.f19618c = accessToken;
            this.f19619d = atomicBoolean;
            this.f19620e = set;
            this.f19621f = set2;
            this.f19622g = set3;
        }

        public final void a(s sVar) {
            String str;
            Set set;
            Set set2;
            Set set3;
            Date e10;
            m.f(sVar, "it");
            String a10 = this.f19617b.a();
            int c10 = this.f19617b.c();
            Long b10 = this.f19617b.b();
            String e11 = this.f19617b.e();
            try {
                a aVar = c.f19600g;
                if (aVar.e().g() != null) {
                    AccessToken g10 = aVar.e().g();
                    if (g10 != null) {
                        str = g10.n();
                    } else {
                        str = null;
                    }
                    if (str == this.f19618c.n()) {
                        if (!this.f19619d.get() && a10 == null && c10 == 0) {
                            this.f19616a.f19602b.set(false);
                            return;
                        }
                        Date h10 = this.f19618c.h();
                        if (this.f19617b.c() != 0) {
                            h10 = new Date(((long) this.f19617b.c()) * 1000);
                        } else if (this.f19617b.d() != 0) {
                            h10 = new Date((((long) this.f19617b.d()) * 1000) + new Date().getTime());
                        }
                        Date date = h10;
                        if (a10 == null) {
                            a10 = this.f19618c.m();
                        }
                        String str2 = a10;
                        String c11 = this.f19618c.c();
                        String n10 = this.f19618c.n();
                        if (this.f19619d.get()) {
                            set = this.f19620e;
                        } else {
                            set = this.f19618c.k();
                        }
                        Collection collection = set;
                        if (this.f19619d.get()) {
                            set2 = this.f19621f;
                        } else {
                            set2 = this.f19618c.f();
                        }
                        Collection collection2 = set2;
                        if (this.f19619d.get()) {
                            set3 = this.f19622g;
                        } else {
                            set3 = this.f19618c.g();
                        }
                        Collection collection3 = set3;
                        d l10 = this.f19618c.l();
                        Date date2 = new Date();
                        if (b10 != null) {
                            e10 = new Date(b10.longValue() * 1000);
                        } else {
                            e10 = this.f19618c.e();
                        }
                        Date date3 = e10;
                        if (e11 == null) {
                            e11 = this.f19618c.i();
                        }
                        aVar.e().l(new AccessToken(str2, c11, n10, collection, collection2, collection3, l10, date, date2, date3, e11));
                        this.f19616a.f19602b.set(false);
                    }
                }
            } finally {
                this.f19616a.f19602b.set(false);
            }
        }
    }

    static final class h implements GraphRequest.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f19623a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Set f19624b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Set f19625c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Set f19626d;

        h(AtomicBoolean atomicBoolean, Set set, Set set2, Set set3) {
            this.f19623a = atomicBoolean;
            this.f19624b = set;
            this.f19625c = set2;
            this.f19626d = set3;
        }

        public final void a(t tVar) {
            JSONArray optJSONArray;
            m.f(tVar, "response");
            JSONObject d10 = tVar.d();
            if (d10 != null && (optJSONArray = d10.optJSONArray("data")) != null) {
                this.f19623a.set(true);
                int length = optJSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("permission");
                        String optString2 = optJSONObject.optString(NotificationCompat.CATEGORY_STATUS);
                        if (!p0.Y(optString) && !p0.Y(optString2)) {
                            m.e(optString2, NotificationCompat.CATEGORY_STATUS);
                            Locale locale = Locale.US;
                            m.e(locale, "Locale.US");
                            if (optString2 != null) {
                                String lowerCase = optString2.toLowerCase(locale);
                                m.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                                if (lowerCase != null) {
                                    int hashCode = lowerCase.hashCode();
                                    if (hashCode != -1309235419) {
                                        if (hashCode != 280295099) {
                                            if (hashCode == 568196142 && lowerCase.equals("declined")) {
                                                this.f19625c.add(optString);
                                            }
                                        } else if (lowerCase.equals("granted")) {
                                            this.f19624b.add(optString);
                                        }
                                    } else if (lowerCase.equals("expired")) {
                                        this.f19626d.add(optString);
                                    }
                                }
                                Log.w("AccessTokenManager", "Unexpected status: " + lowerCase);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                    }
                }
            }
        }
    }

    static final class i implements GraphRequest.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f19627a;

        i(d dVar) {
            this.f19627a = dVar;
        }

        public final void a(t tVar) {
            m.f(tVar, "response");
            JSONObject d10 = tVar.d();
            if (d10 != null) {
                this.f19627a.f(d10.optString("access_token"));
                this.f19627a.h(d10.optInt("expires_at"));
                this.f19627a.i(d10.optInt("expires_in"));
                this.f19627a.g(Long.valueOf(d10.optLong("data_access_expiration_time")));
                this.f19627a.j(d10.optString("graph_domain", (String) null));
            }
        }
    }

    public c(LocalBroadcastManager localBroadcastManager, b bVar) {
        m.f(localBroadcastManager, "localBroadcastManager");
        m.f(bVar, "accessTokenCache");
        this.f19604d = localBroadcastManager;
        this.f19605e = bVar;
    }

    /* access modifiers changed from: private */
    public final void j(AccessToken.a aVar) {
        AccessToken g10 = g();
        if (g10 == null) {
            if (aVar != null) {
                aVar.a(new l("No current access token to refresh"));
            }
        } else if (this.f19602b.compareAndSet(false, true)) {
            this.f19603c = new Date();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            d dVar = new d();
            a aVar2 = f19600g;
            s sVar = new s(aVar2.d(g10, new h(atomicBoolean, hashSet, hashSet2, hashSet3)), aVar2.c(g10, new i(dVar)));
            sVar.d(new g(this, dVar, g10, aVar, atomicBoolean, hashSet, hashSet2, hashSet3));
            sVar.i();
        } else if (aVar != null) {
            aVar.a(new l("Refresh already in progress"));
        }
    }

    private final void k(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent(o.f(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accessToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accessToken2);
        this.f19604d.sendBroadcast(intent);
    }

    private final void m(AccessToken accessToken, boolean z10) {
        AccessToken accessToken2 = this.f19601a;
        this.f19601a = accessToken;
        this.f19602b.set(false);
        this.f19603c = new Date(0);
        if (z10) {
            if (accessToken != null) {
                this.f19605e.g(accessToken);
            } else {
                this.f19605e.a();
                p0.h(o.f());
            }
        }
        if (!p0.c(accessToken2, accessToken)) {
            k(accessToken2, accessToken);
            n();
        }
    }

    private final void n() {
        Date date;
        Context f10 = o.f();
        AccessToken.c cVar = AccessToken.N0;
        AccessToken e10 = cVar.e();
        AlarmManager alarmManager = (AlarmManager) f10.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (cVar.g()) {
            if (e10 != null) {
                date = e10.h();
            } else {
                date = null;
            }
            if (date != null && alarmManager != null) {
                Intent intent = new Intent(f10, CurrentAccessTokenExpirationBroadcastReceiver.class);
                intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
                try {
                    alarmManager.set(1, e10.h().getTime(), PendingIntent.getBroadcast(f10, 0, intent, 67108864));
                } catch (Exception unused) {
                }
            }
        }
    }

    private final boolean o() {
        AccessToken g10 = g();
        if (g10 == null) {
            return false;
        }
        long time = new Date().getTime();
        if (!g10.l().a() || time - this.f19603c.getTime() <= ((long) Constants.ONE_HOUR) || time - g10.j().getTime() <= ((long) 86400000)) {
            return false;
        }
        return true;
    }

    public final void e() {
        k(g(), g());
    }

    public final void f() {
        if (o()) {
            i((AccessToken.a) null);
        }
    }

    public final AccessToken g() {
        return this.f19601a;
    }

    public final boolean h() {
        AccessToken f10 = this.f19605e.f();
        if (f10 == null) {
            return false;
        }
        m(f10, false);
        return true;
    }

    public final void i(AccessToken.a aVar) {
        if (m.b(Looper.getMainLooper(), Looper.myLooper())) {
            j(aVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new f(this, aVar));
        }
    }

    public final void l(AccessToken accessToken) {
        m(accessToken, true);
    }
}
