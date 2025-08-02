package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.d;
import com.facebook.l;
import com.facebook.login.LoginClient;
import com.facebook.n;
import com.facebook.o;
import com.facebook.q;
import com.google.android.gms.common.Scopes;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.Locale;
import q5.p0;

abstract class WebLoginMethodHandler extends LoginMethodHandler {

    /* renamed from: d  reason: collision with root package name */
    private String f20463d;

    WebLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    private String u() {
        return f().i().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "");
    }

    private void w(String str) {
        f().i().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", str).apply();
    }

    /* access modifiers changed from: protected */
    public Bundle p(Bundle bundle, LoginClient.Request request) {
        String str;
        bundle.putString("redirect_uri", r());
        if (request.o()) {
            bundle.putString(Constant.PARAM_APP_ID, request.a());
        } else {
            bundle.putString("client_id", request.a());
        }
        f();
        bundle.putString("e2e", LoginClient.k());
        if (request.o()) {
            bundle.putString("response_type", "token,signed_request,graph_domain,granted_scopes");
        } else if (request.k().contains(Scopes.OPEN_ID)) {
            bundle.putString("response_type", "id_token,token,signed_request,graph_domain");
            bundle.putString("nonce", request.j());
        } else {
            bundle.putString("response_type", "token,signed_request,graph_domain");
        }
        bundle.putString("return_scopes", "true");
        bundle.putString("auth_type", request.c());
        bundle.putString("login_behavior", request.g().name());
        bundle.putString("sdk", String.format(Locale.ROOT, "android-%s", new Object[]{o.w()}));
        if (s() != null) {
            bundle.putString("sso", s());
        }
        String str2 = "0";
        if (o.f20687p) {
            str = "1";
        } else {
            str = str2;
        }
        bundle.putString("cct_prefetching", str);
        if (request.n()) {
            bundle.putString("fx_app", request.h().toString());
        }
        if (request.x()) {
            bundle.putString("skip_dedupe", "true");
        }
        if (request.i() != null) {
            bundle.putString("messenger_page_id", request.i());
            if (request.l()) {
                str2 = "1";
            }
            bundle.putString("reset_messenger_state", str2);
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    public Bundle q(LoginClient.Request request) {
        String str;
        Bundle bundle = new Bundle();
        if (!p0.Z(request.k())) {
            String join = TextUtils.join(",", request.k());
            bundle.putString("scope", join);
            a("scope", join);
        }
        bundle.putString("default_audience", request.d().a());
        bundle.putString("state", e(request.b()));
        AccessToken d10 = AccessToken.d();
        if (d10 != null) {
            str = d10.m();
        } else {
            str = null;
        }
        String str2 = "0";
        if (str == null || !str.equals(u())) {
            p0.h(f().i());
            a("access_token", str2);
        } else {
            bundle.putString("access_token", str);
            a("access_token", "1");
        }
        bundle.putString("cbt", String.valueOf(System.currentTimeMillis()));
        if (o.k()) {
            str2 = "1";
        }
        bundle.putString("ies", str2);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public String r() {
        return "fb" + o.g() + "://authorize/";
    }

    /* access modifiers changed from: protected */
    public String s() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract d t();

    /* access modifiers changed from: protected */
    public void v(LoginClient.Request request, Bundle bundle, l lVar) {
        LoginClient.Result result;
        String str;
        LoginClient f10 = f();
        this.f20463d = null;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.f20463d = bundle.getString("e2e");
            }
            try {
                AccessToken c10 = LoginMethodHandler.c(request.k(), bundle, t(), request.a());
                result = LoginClient.Result.b(f10.q(), c10, LoginMethodHandler.d(bundle, request.j()));
                CookieSyncManager.createInstance(f10.i()).sync();
                if (c10 != null) {
                    w(c10.m());
                }
            } catch (l e10) {
                result = LoginClient.Result.c(f10.q(), (String) null, e10.getMessage());
            }
        } else if (lVar instanceof n) {
            result = LoginClient.Result.a(f10.q(), "User canceled log in.");
        } else {
            this.f20463d = null;
            String message = lVar.getMessage();
            if (lVar instanceof q) {
                FacebookRequestError a10 = ((q) lVar).a();
                str = String.format(Locale.ROOT, "%d", new Object[]{Integer.valueOf(a10.b())});
                message = a10.toString();
            } else {
                str = null;
            }
            result = LoginClient.Result.d(f10.q(), (String) null, message, str);
        }
        if (!p0.Y(this.f20463d)) {
            i(this.f20463d);
        }
        f10.g(result);
    }

    WebLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }
}
