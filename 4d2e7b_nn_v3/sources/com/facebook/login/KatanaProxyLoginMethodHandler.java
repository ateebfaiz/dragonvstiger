package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.FragmentActivity;
import com.facebook.login.LoginClient;
import com.facebook.o;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import q5.f;
import q5.f0;

@VisibleForTesting(otherwise = 3)
public final class KatanaProxyLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Parcelable.Creator<KatanaProxyLoginMethodHandler> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public static final b f20423e = new b((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    private final String f20424d = "katana_proxy_auth";

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public KatanaProxyLoginMethodHandler createFromParcel(Parcel parcel) {
            m.f(parcel, "source");
            return new KatanaProxyLoginMethodHandler(parcel);
        }

        /* renamed from: b */
        public KatanaProxyLoginMethodHandler[] newArray(int i10) {
            return new KatanaProxyLoginMethodHandler[i10];
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    public int describeContents() {
        return 0;
    }

    public String h() {
        return this.f20424d;
    }

    public boolean n() {
        return true;
    }

    public int o(LoginClient.Request request) {
        boolean z10;
        m.f(request, "request");
        e g10 = request.g();
        if (!o.f20688q || f.a() == null || !g10.a()) {
            z10 = false;
        } else {
            z10 = true;
        }
        String k10 = LoginClient.k();
        FragmentActivity i10 = f().i();
        String a10 = request.a();
        m.e(a10, "request.applicationId");
        Set k11 = request.k();
        m.e(k11, "request.permissions");
        m.e(k10, "e2e");
        boolean p10 = request.p();
        boolean m10 = request.m();
        b d10 = request.d();
        m.e(d10, "request.defaultAudience");
        String b10 = request.b();
        m.e(b10, "request.authId");
        String e10 = e(b10);
        String c10 = request.c();
        m.e(c10, "request.authType");
        List<Intent> q10 = f0.q(i10, a10, k11, k10, p10, m10, d10, e10, c10, z10, request.i(), request.l(), request.n(), request.x(), request.j());
        a("e2e", k10);
        int i11 = 0;
        for (Intent w10 : q10) {
            if (w(w10, LoginClient.p())) {
                return i11 + 1;
            }
            i11++;
        }
        return 0;
    }

    public KatanaProxyLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }
}
