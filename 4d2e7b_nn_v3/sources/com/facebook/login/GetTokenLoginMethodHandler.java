package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.facebook.l;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import com.google.android.gms.common.Scopes;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;
import q5.g0;
import q5.p0;

public final class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR = new a();

    /* renamed from: f  reason: collision with root package name */
    public static final b f20413f = new b((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    private d f20414d;

    /* renamed from: e  reason: collision with root package name */
    private final String f20415e = "get_token";

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public GetTokenLoginMethodHandler createFromParcel(Parcel parcel) {
            m.f(parcel, "source");
            return new GetTokenLoginMethodHandler(parcel);
        }

        /* renamed from: b */
        public GetTokenLoginMethodHandler[] newArray(int i10) {
            return new GetTokenLoginMethodHandler[i10];
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class c implements p0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GetTokenLoginMethodHandler f20416a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bundle f20417b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LoginClient.Request f20418c;

        c(GetTokenLoginMethodHandler getTokenLoginMethodHandler, Bundle bundle, LoginClient.Request request) {
            this.f20416a = getTokenLoginMethodHandler;
            this.f20417b = bundle;
            this.f20418c = request;
        }

        public void a(JSONObject jSONObject) {
            String str;
            try {
                Bundle bundle = this.f20417b;
                if (jSONObject != null) {
                    str = jSONObject.getString("id");
                } else {
                    str = null;
                }
                bundle.putString("com.facebook.platform.extra.USER_ID", str);
                this.f20416a.r(this.f20418c, this.f20417b);
            } catch (JSONException e10) {
                this.f20416a.f().f(LoginClient.Result.c(this.f20416a.f().q(), "Caught exception", e10.getMessage()));
            }
        }

        public void b(l lVar) {
            String str;
            LoginClient f10 = this.f20416a.f();
            LoginClient.Request q10 = this.f20416a.f().q();
            if (lVar != null) {
                str = lVar.getMessage();
            } else {
                str = null;
            }
            f10.f(LoginClient.Result.c(q10, "Caught exception", str));
        }
    }

    static final class d implements g0.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GetTokenLoginMethodHandler f20419a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LoginClient.Request f20420b;

        d(GetTokenLoginMethodHandler getTokenLoginMethodHandler, LoginClient.Request request) {
            this.f20419a = getTokenLoginMethodHandler;
            this.f20420b = request;
        }

        public final void completed(Bundle bundle) {
            this.f20419a.q(this.f20420b, bundle);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        m.f(loginClient, "loginClient");
    }

    public void b() {
        d dVar = this.f20414d;
        if (dVar != null) {
            dVar.b();
            dVar.f((g0.b) null);
            this.f20414d = null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String h() {
        return this.f20415e;
    }

    public int o(LoginClient.Request request) {
        m.f(request, "request");
        FragmentActivity i10 = f().i();
        m.e(i10, "loginClient.activity");
        d dVar = new d(i10, request);
        this.f20414d = dVar;
        if (!dVar.g()) {
            return 0;
        }
        f().t();
        d dVar2 = new d(this, request);
        d dVar3 = this.f20414d;
        if (dVar3 == null) {
            return 1;
        }
        dVar3.f(dVar2);
        return 1;
    }

    public final void p(LoginClient.Request request, Bundle bundle) {
        m.f(request, "request");
        m.f(bundle, DbParams.KEY_CHANNEL_RESULT);
        String string = bundle.getString("com.facebook.platform.extra.USER_ID");
        if (string == null || string.length() == 0) {
            f().t();
            String string2 = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
            if (string2 != null) {
                p0.D(string2, new c(this, bundle, request));
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        r(request, bundle);
    }

    public final void q(LoginClient.Request request, Bundle bundle) {
        m.f(request, "request");
        d dVar = this.f20414d;
        if (dVar != null) {
            dVar.f((g0.b) null);
        }
        this.f20414d = null;
        f().u();
        if (bundle != null) {
            List stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            if (stringArrayList == null) {
                stringArrayList = r.l();
            }
            Set<String> k10 = request.k();
            if (k10 == null) {
                k10 = r0.d();
            }
            String string = bundle.getString("com.facebook.platform.extra.ID_TOKEN");
            if (k10.contains(Scopes.OPEN_ID) && (string == null || string.length() == 0)) {
                f().C();
                return;
            } else if (stringArrayList.containsAll(k10)) {
                p(request, bundle);
                return;
            } else {
                HashSet hashSet = new HashSet();
                for (String str : k10) {
                    if (!stringArrayList.contains(str)) {
                        hashSet.add(str);
                    }
                }
                if (!hashSet.isEmpty()) {
                    a("new_permissions", TextUtils.join(",", hashSet));
                }
                request.t(hashSet);
            }
        }
        f().C();
    }

    public final void r(LoginClient.Request request, Bundle bundle) {
        LoginClient.Result result;
        m.f(request, "request");
        m.f(bundle, DbParams.KEY_CHANNEL_RESULT);
        try {
            LoginMethodHandler.a aVar = LoginMethodHandler.f20460c;
            com.facebook.d dVar = com.facebook.d.FACEBOOK_APPLICATION_SERVICE;
            String a10 = request.a();
            m.e(a10, "request.applicationId");
            result = LoginClient.Result.b(request, aVar.a(bundle, dVar, a10), aVar.c(bundle, request.j()));
        } catch (l e10) {
            result = LoginClient.Result.c(f().q(), (String) null, e10.getMessage());
        }
        f().g(result);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(Parcel parcel) {
        super(parcel);
        m.f(parcel, "source");
    }
}
