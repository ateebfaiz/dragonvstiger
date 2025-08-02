package com.facebook;

import android.content.SharedPreferences;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONException;

public final class f {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19682b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f19683a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f(SharedPreferences sharedPreferences) {
        m.f(sharedPreferences, "sharedPreferences");
        this.f19683a = sharedPreferences;
    }

    public final void a() {
        this.f19683a.edit().remove("com.facebook.AuthenticationManager.CachedAuthenticationToken").apply();
    }

    public final void b(AuthenticationToken authenticationToken) {
        m.f(authenticationToken, "authenticationToken");
        try {
            this.f19683a.edit().putString("com.facebook.AuthenticationManager.CachedAuthenticationToken", authenticationToken.c().toString()).apply();
        } catch (JSONException unused) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f() {
        /*
            r3 = this;
            android.content.Context r0 = com.facebook.o.f()
            java.lang.String r1 = "com.facebook.AuthenticationTokenManager.SharedPreferences"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            java.lang.String r1 = "FacebookSdk.getApplicati…ME, Context.MODE_PRIVATE)"
            kotlin.jvm.internal.m.e(r0, r1)
            r3.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.f.<init>():void");
    }
}
