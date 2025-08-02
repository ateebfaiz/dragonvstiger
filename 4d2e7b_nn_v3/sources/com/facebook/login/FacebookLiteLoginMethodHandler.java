package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.facebook.login.LoginClient;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import q5.f0;

public final class FacebookLiteLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Parcelable.Creator<FacebookLiteLoginMethodHandler> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public static final b f20411e = new b((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    private final String f20412d = "fb_lite_login";

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public FacebookLiteLoginMethodHandler createFromParcel(Parcel parcel) {
            m.f(parcel, "source");
            return new FacebookLiteLoginMethodHandler(parcel);
        }

        /* renamed from: b */
        public FacebookLiteLoginMethodHandler[] newArray(int i10) {
            return new FacebookLiteLoginMethodHandler[i10];
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FacebookLiteLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        m.f(loginClient, "loginClient");
    }

    public int describeContents() {
        return 0;
    }

    public String h() {
        return this.f20412d;
    }

    public int o(LoginClient.Request request) {
        m.f(request, "request");
        String k10 = LoginClient.k();
        FragmentActivity i10 = f().i();
        m.e(i10, "loginClient.activity");
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
        Intent k12 = f0.k(i10, a10, k11, k10, p10, m10, d10, e10, c10, request.i(), request.l(), request.n(), request.x());
        a("e2e", k10);
        return w(k12, LoginClient.p()) ? 1 : 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        m.f(parcel, "dest");
        super.writeToParcel(parcel, i10);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FacebookLiteLoginMethodHandler(Parcel parcel) {
        super(parcel);
        m.f(parcel, "source");
    }
}
