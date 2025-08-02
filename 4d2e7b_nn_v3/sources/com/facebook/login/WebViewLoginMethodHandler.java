package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.facebook.d;
import com.facebook.internal.WebDialog;
import com.facebook.l;
import com.facebook.login.LoginClient;
import q5.j;
import q5.p0;

class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new b();

    /* renamed from: e  reason: collision with root package name */
    private WebDialog f20464e;

    /* renamed from: f  reason: collision with root package name */
    private String f20465f;

    class a implements WebDialog.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LoginClient.Request f20466a;

        a(LoginClient.Request request) {
            this.f20466a = request;
        }

        public void a(Bundle bundle, l lVar) {
            WebViewLoginMethodHandler.this.x(this.f20466a, bundle, lVar);
        }
    }

    static class b implements Parcelable.Creator {
        b() {
        }

        /* renamed from: a */
        public WebViewLoginMethodHandler createFromParcel(Parcel parcel) {
            return new WebViewLoginMethodHandler(parcel);
        }

        /* renamed from: b */
        public WebViewLoginMethodHandler[] newArray(int i10) {
            return new WebViewLoginMethodHandler[i10];
        }
    }

    static class c extends WebDialog.a {

        /* renamed from: h  reason: collision with root package name */
        private String f20468h;

        /* renamed from: i  reason: collision with root package name */
        private String f20469i;

        /* renamed from: j  reason: collision with root package name */
        private String f20470j = "fbconnect://success";

        /* renamed from: k  reason: collision with root package name */
        private e f20471k = e.NATIVE_WITH_FALLBACK;

        /* renamed from: l  reason: collision with root package name */
        private k f20472l = k.FACEBOOK;

        /* renamed from: m  reason: collision with root package name */
        private boolean f20473m = false;

        /* renamed from: n  reason: collision with root package name */
        private boolean f20474n = false;

        public c(Context context, String str, Bundle bundle) {
            super(context, str, "oauth", bundle);
        }

        public WebDialog a() {
            String str;
            Bundle f10 = f();
            f10.putString("redirect_uri", this.f20470j);
            f10.putString("client_id", c());
            f10.putString("e2e", this.f20468h);
            if (this.f20472l == k.INSTAGRAM) {
                str = "token,signed_request,graph_domain,granted_scopes";
            } else {
                str = "token,signed_request,graph_domain";
            }
            f10.putString("response_type", str);
            f10.putString("return_scopes", "true");
            f10.putString("auth_type", this.f20469i);
            f10.putString("login_behavior", this.f20471k.name());
            if (this.f20473m) {
                f10.putString("fx_app", this.f20472l.toString());
            }
            if (this.f20474n) {
                f10.putString("skip_dedupe", "true");
            }
            return WebDialog.q(d(), "oauth", f10, g(), this.f20472l, e());
        }

        public c i(String str) {
            this.f20469i = str;
            return this;
        }

        public c j(String str) {
            this.f20468h = str;
            return this;
        }

        public c k(boolean z10) {
            this.f20473m = z10;
            return this;
        }

        public c l(boolean z10) {
            String str;
            if (z10) {
                str = "fbconnect://chrome_os_success";
            } else {
                str = "fbconnect://success";
            }
            this.f20470j = str;
            return this;
        }

        public c m(e eVar) {
            this.f20471k = eVar;
            return this;
        }

        public c n(k kVar) {
            this.f20472l = kVar;
            return this;
        }

        public c o(boolean z10) {
            this.f20474n = z10;
            return this;
        }
    }

    WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    public void b() {
        WebDialog webDialog = this.f20464e;
        if (webDialog != null) {
            webDialog.cancel();
            this.f20464e = null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String h() {
        return "web_view";
    }

    public boolean j() {
        return true;
    }

    public int o(LoginClient.Request request) {
        Bundle q10 = q(request);
        a aVar = new a(request);
        String k10 = LoginClient.k();
        this.f20465f = k10;
        a("e2e", k10);
        FragmentActivity i10 = f().i();
        this.f20464e = new c(i10, request.a(), q10).j(this.f20465f).l(p0.S(i10)).i(request.c()).m(request.g()).n(request.h()).k(request.n()).o(request.x()).h(aVar).a();
        j jVar = new j();
        jVar.setRetainInstance(true);
        jVar.t(this.f20464e);
        jVar.show(i10.getSupportFragmentManager(), "FacebookDialogFragment");
        return 1;
    }

    /* access modifiers changed from: package-private */
    public d t() {
        return d.WEB_VIEW;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f20465f);
    }

    /* access modifiers changed from: package-private */
    public void x(LoginClient.Request request, Bundle bundle, l lVar) {
        super.v(request, bundle, lVar);
    }

    WebViewLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.f20465f = parcel.readString();
    }
}
