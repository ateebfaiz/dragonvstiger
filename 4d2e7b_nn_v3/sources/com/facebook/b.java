package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    /* renamed from: d  reason: collision with root package name */
    public static final a f19588d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private v f19589a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f19590b;

    /* renamed from: c  reason: collision with root package name */
    private final C0245b f19591c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: com.facebook.b$b  reason: collision with other inner class name */
    public static final class C0245b {
        public final v a() {
            return new v(o.f(), (String) null, 2, (DefaultConstructorMarker) null);
        }
    }

    public b(SharedPreferences sharedPreferences, C0245b bVar) {
        m.f(sharedPreferences, "sharedPreferences");
        m.f(bVar, "tokenCachingStrategyFactory");
        this.f19590b = sharedPreferences;
        this.f19591c = bVar;
    }

    private final AccessToken b() {
        String string = this.f19590b.getString("com.facebook.AccessTokenManager.CachedAccessToken", (String) null);
        if (string == null) {
            return null;
        }
        try {
            return AccessToken.N0.b(new JSONObject(string));
        } catch (JSONException unused) {
            return null;
        }
    }

    private final AccessToken c() {
        Bundle c10 = d().c();
        if (c10 == null || !v.f20961d.g(c10)) {
            return null;
        }
        return AccessToken.N0.c(c10);
    }

    private final v d() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            if (this.f19589a == null) {
                synchronized (this) {
                    if (this.f19589a == null) {
                        this.f19589a = this.f19591c.a();
                    }
                    Unit unit = Unit.f12577a;
                }
            }
            v vVar = this.f19589a;
            if (vVar != null) {
                return vVar;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    private final boolean e() {
        return this.f19590b.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    private final boolean h() {
        return o.B();
    }

    public final void a() {
        this.f19590b.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (h()) {
            d().a();
        }
    }

    public final AccessToken f() {
        if (e()) {
            return b();
        }
        if (!h()) {
            return null;
        }
        AccessToken c10 = c();
        if (c10 == null) {
            return c10;
        }
        g(c10);
        d().a();
        return c10;
    }

    public final void g(AccessToken accessToken) {
        m.f(accessToken, "accessToken");
        try {
            this.f19590b.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken.t().toString()).apply();
        } catch (JSONException unused) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b() {
        /*
            r3 = this;
            android.content.Context r0 = com.facebook.o.f()
            java.lang.String r1 = "com.facebook.AccessTokenManager.SharedPreferences"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            java.lang.String r1 = "FacebookSdk.getApplicati…ME, Context.MODE_PRIVATE)"
            kotlin.jvm.internal.m.e(r0, r1)
            com.facebook.b$b r1 = new com.facebook.b$b
            r1.<init>()
            r3.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.b.<init>():void");
    }
}
