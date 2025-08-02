package com.facebook;

import android.content.SharedPreferences;
import com.google.android.gms.common.Scopes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;

public final class x {

    /* renamed from: b  reason: collision with root package name */
    public static final a f20973b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f20974a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public x() {
        SharedPreferences sharedPreferences = o.f().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
        m.e(sharedPreferences, "FacebookSdk.getApplicati…ME, Context.MODE_PRIVATE)");
        this.f20974a = sharedPreferences;
    }

    public final void a() {
        this.f20974a.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    }

    public final Profile b() {
        String string = this.f20974a.getString("com.facebook.ProfileManager.CachedProfile", (String) null);
        if (string != null) {
            try {
                return new Profile(new JSONObject(string));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final void c(Profile profile) {
        m.f(profile, Scopes.PROFILE);
        JSONObject h10 = profile.h();
        if (h10 != null) {
            this.f20974a.edit().putString("com.facebook.ProfileManager.CachedProfile", h10.toString()).apply();
        }
    }
}
