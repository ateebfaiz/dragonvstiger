package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.CustomTabMainActivity;
import com.facebook.l;
import com.facebook.o;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import q5.d;
import q5.p0;
import q5.q0;
import u2.f;

@VisibleForTesting(otherwise = 3)
public class LoginClient implements Parcelable {
    public static final Parcelable.Creator<LoginClient> CREATOR = new a();
    private int C;

    /* renamed from: a  reason: collision with root package name */
    LoginMethodHandler[] f20425a;

    /* renamed from: b  reason: collision with root package name */
    int f20426b;

    /* renamed from: c  reason: collision with root package name */
    Fragment f20427c;

    /* renamed from: d  reason: collision with root package name */
    c f20428d;

    /* renamed from: e  reason: collision with root package name */
    b f20429e;

    /* renamed from: f  reason: collision with root package name */
    boolean f20430f;

    /* renamed from: g  reason: collision with root package name */
    Request f20431g;

    /* renamed from: h  reason: collision with root package name */
    Map f20432h;

    /* renamed from: i  reason: collision with root package name */
    Map f20433i;

    /* renamed from: j  reason: collision with root package name */
    private h f20434j;

    /* renamed from: w  reason: collision with root package name */
    private int f20435w;

    public static class Request implements Parcelable {
        public static final Parcelable.Creator<Request> CREATOR = new a();
        private final k C;
        private boolean X;
        private boolean Y;
        private String Z;

        /* renamed from: a  reason: collision with root package name */
        private final e f20436a;

        /* renamed from: b  reason: collision with root package name */
        private Set f20437b;

        /* renamed from: c  reason: collision with root package name */
        private final b f20438c;

        /* renamed from: d  reason: collision with root package name */
        private final String f20439d;

        /* renamed from: e  reason: collision with root package name */
        private String f20440e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f20441f;

        /* renamed from: g  reason: collision with root package name */
        private String f20442g;

        /* renamed from: h  reason: collision with root package name */
        private String f20443h;

        /* renamed from: i  reason: collision with root package name */
        private String f20444i;

        /* renamed from: j  reason: collision with root package name */
        private String f20445j;

        /* renamed from: w  reason: collision with root package name */
        private boolean f20446w;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public Request createFromParcel(Parcel parcel) {
                return new Request(parcel, (a) null);
            }

            /* renamed from: b */
            public Request[] newArray(int i10) {
                return new Request[i10];
            }
        }

        /* synthetic */ Request(Parcel parcel, a aVar) {
            this(parcel);
        }

        /* access modifiers changed from: package-private */
        public String a() {
            return this.f20439d;
        }

        /* access modifiers changed from: package-private */
        public String b() {
            return this.f20440e;
        }

        /* access modifiers changed from: package-private */
        public String c() {
            return this.f20443h;
        }

        /* access modifiers changed from: package-private */
        public b d() {
            return this.f20438c;
        }

        public int describeContents() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public String e() {
            return this.f20444i;
        }

        /* access modifiers changed from: package-private */
        public String f() {
            return this.f20442g;
        }

        /* access modifiers changed from: package-private */
        public e g() {
            return this.f20436a;
        }

        /* access modifiers changed from: package-private */
        public k h() {
            return this.C;
        }

        public String i() {
            return this.f20445j;
        }

        public String j() {
            return this.Z;
        }

        /* access modifiers changed from: package-private */
        public Set k() {
            return this.f20437b;
        }

        public boolean l() {
            return this.f20446w;
        }

        /* access modifiers changed from: package-private */
        public boolean m() {
            for (String g10 : this.f20437b) {
                if (i.g(g10)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return this.X;
        }

        /* access modifiers changed from: package-private */
        public boolean o() {
            if (this.C == k.INSTAGRAM) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean p() {
            return this.f20441f;
        }

        /* access modifiers changed from: package-private */
        public void q(String str) {
            this.f20440e = str;
        }

        /* access modifiers changed from: package-private */
        public void r(boolean z10) {
            this.X = z10;
        }

        public void s(String str) {
            this.f20445j = str;
        }

        /* access modifiers changed from: package-private */
        public void t(Set set) {
            q0.m(set, "permissions");
            this.f20437b = set;
        }

        /* access modifiers changed from: package-private */
        public void u(boolean z10) {
            this.f20441f = z10;
        }

        public void v(boolean z10) {
            this.f20446w = z10;
        }

        /* access modifiers changed from: package-private */
        public void w(boolean z10) {
            this.Y = z10;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            String str;
            String str2;
            e eVar = this.f20436a;
            String str3 = null;
            if (eVar != null) {
                str = eVar.name();
            } else {
                str = null;
            }
            parcel.writeString(str);
            parcel.writeStringList(new ArrayList(this.f20437b));
            b bVar = this.f20438c;
            if (bVar != null) {
                str2 = bVar.name();
            } else {
                str2 = null;
            }
            parcel.writeString(str2);
            parcel.writeString(this.f20439d);
            parcel.writeString(this.f20440e);
            parcel.writeByte(this.f20441f ? (byte) 1 : 0);
            parcel.writeString(this.f20442g);
            parcel.writeString(this.f20443h);
            parcel.writeString(this.f20444i);
            parcel.writeString(this.f20445j);
            parcel.writeByte(this.f20446w ? (byte) 1 : 0);
            k kVar = this.C;
            if (kVar != null) {
                str3 = kVar.name();
            }
            parcel.writeString(str3);
            parcel.writeByte(this.X ? (byte) 1 : 0);
            parcel.writeByte(this.Y ? (byte) 1 : 0);
            parcel.writeString(this.Z);
        }

        /* access modifiers changed from: package-private */
        public boolean x() {
            return this.Y;
        }

        Request(e eVar, Set set, b bVar, String str, String str2, String str3, k kVar, String str4) {
            this.f20441f = false;
            this.X = false;
            this.Y = false;
            this.f20436a = eVar;
            this.f20437b = set == null ? new HashSet() : set;
            this.f20438c = bVar;
            this.f20443h = str;
            this.f20439d = str2;
            this.f20440e = str3;
            this.C = kVar;
            if (p0.Y(str4)) {
                this.Z = UUID.randomUUID().toString();
            } else {
                this.Z = str4;
            }
        }

        private Request(Parcel parcel) {
            boolean z10 = false;
            this.f20441f = false;
            this.X = false;
            this.Y = false;
            String readString = parcel.readString();
            k kVar = null;
            this.f20436a = readString != null ? e.valueOf(readString) : null;
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.f20437b = new HashSet(arrayList);
            String readString2 = parcel.readString();
            this.f20438c = readString2 != null ? b.valueOf(readString2) : null;
            this.f20439d = parcel.readString();
            this.f20440e = parcel.readString();
            this.f20441f = parcel.readByte() != 0;
            this.f20442g = parcel.readString();
            this.f20443h = parcel.readString();
            this.f20444i = parcel.readString();
            this.f20445j = parcel.readString();
            this.f20446w = parcel.readByte() != 0;
            String readString3 = parcel.readString();
            this.C = readString3 != null ? k.valueOf(readString3) : kVar;
            this.X = parcel.readByte() != 0;
            this.Y = parcel.readByte() != 0 ? true : z10;
            this.Z = parcel.readString();
        }
    }

    public static class Result implements Parcelable {
        public static final Parcelable.Creator<Result> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        final b f20447a;

        /* renamed from: b  reason: collision with root package name */
        final AccessToken f20448b;

        /* renamed from: c  reason: collision with root package name */
        final AuthenticationToken f20449c;

        /* renamed from: d  reason: collision with root package name */
        final String f20450d;

        /* renamed from: e  reason: collision with root package name */
        final String f20451e;

        /* renamed from: f  reason: collision with root package name */
        final Request f20452f;

        /* renamed from: g  reason: collision with root package name */
        public Map f20453g;

        /* renamed from: h  reason: collision with root package name */
        public Map f20454h;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public Result createFromParcel(Parcel parcel) {
                return new Result(parcel, (a) null);
            }

            /* renamed from: b */
            public Result[] newArray(int i10) {
                return new Result[i10];
            }
        }

        enum b {
            SUCCESS(FirebaseAnalytics.Param.SUCCESS),
            CANCEL("cancel"),
            ERROR(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            

            /* renamed from: a  reason: collision with root package name */
            private final String f20459a;

            private b(String str) {
                this.f20459a = str;
            }

            /* access modifiers changed from: package-private */
            public String a() {
                return this.f20459a;
            }
        }

        /* synthetic */ Result(Parcel parcel, a aVar) {
            this(parcel);
        }

        static Result a(Request request, String str) {
            return new Result(request, b.CANCEL, (AccessToken) null, str, (String) null);
        }

        static Result b(Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
            return new Result(request, b.SUCCESS, accessToken, authenticationToken, (String) null, (String) null);
        }

        static Result c(Request request, String str, String str2) {
            return d(request, str, str2, (String) null);
        }

        static Result d(Request request, String str, String str2, String str3) {
            return new Result(request, b.ERROR, (AccessToken) null, TextUtils.join(": ", p0.d(str, str2)), str3);
        }

        static Result e(Request request, AccessToken accessToken) {
            return new Result(request, b.SUCCESS, accessToken, (String) null, (String) null);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f20447a.name());
            parcel.writeParcelable(this.f20448b, i10);
            parcel.writeParcelable(this.f20449c, i10);
            parcel.writeString(this.f20450d);
            parcel.writeString(this.f20451e);
            parcel.writeParcelable(this.f20452f, i10);
            p0.F0(parcel, this.f20453g);
            p0.F0(parcel, this.f20454h);
        }

        Result(Request request, b bVar, AccessToken accessToken, String str, String str2) {
            this(request, bVar, accessToken, (AuthenticationToken) null, str, str2);
        }

        Result(Request request, b bVar, AccessToken accessToken, AuthenticationToken authenticationToken, String str, String str2) {
            q0.m(bVar, Constant.PARAM_OAUTH_CODE);
            this.f20452f = request;
            this.f20448b = accessToken;
            this.f20449c = authenticationToken;
            this.f20450d = str;
            this.f20447a = bVar;
            this.f20451e = str2;
        }

        private Result(Parcel parcel) {
            this.f20447a = b.valueOf(parcel.readString());
            this.f20448b = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.f20449c = (AuthenticationToken) parcel.readParcelable(AuthenticationToken.class.getClassLoader());
            this.f20450d = parcel.readString();
            this.f20451e = parcel.readString();
            this.f20452f = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.f20453g = p0.q0(parcel);
            this.f20454h = p0.q0(parcel);
        }
    }

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public LoginClient createFromParcel(Parcel parcel) {
            return new LoginClient(parcel);
        }

        /* renamed from: b */
        public LoginClient[] newArray(int i10) {
            return new LoginClient[i10];
        }
    }

    interface b {
        void a();

        void b();
    }

    public interface c {
        void a(Result result);
    }

    public LoginClient(Fragment fragment) {
        this.f20426b = -1;
        this.f20435w = 0;
        this.C = 0;
        this.f20427c = fragment;
    }

    private void a(String str, String str2, boolean z10) {
        if (this.f20432h == null) {
            this.f20432h = new HashMap();
        }
        if (this.f20432h.containsKey(str) && z10) {
            str2 = ((String) this.f20432h.get(str)) + "," + str2;
        }
        this.f20432h.put(str, str2);
    }

    private void h() {
        f(Result.c(this.f20431g, "Login attempt failed.", (String) null));
    }

    static String k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    private h o() {
        h hVar = this.f20434j;
        if (hVar == null || !hVar.b().equals(this.f20431g.a())) {
            this.f20434j = new h(i(), this.f20431g.a());
        }
        return this.f20434j;
    }

    public static int p() {
        return d.c.Login.a();
    }

    private void r(String str, Result result, Map map) {
        s(str, result.f20447a.a(), result.f20450d, result.f20451e, map);
    }

    private void s(String str, String str2, String str3, String str4, Map map) {
        String str5 = "fb_mobile_login_method_complete";
        if (this.f20431g == null) {
            o().j(str5, "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str);
            return;
        }
        h o10 = o();
        String b10 = this.f20431g.b();
        if (this.f20431g.n()) {
            str5 = "foa_mobile_login_method_complete";
        }
        o10.c(b10, str, str2, str3, str4, map, str5);
    }

    private void v(Result result) {
        c cVar = this.f20428d;
        if (cVar != null) {
            cVar.a(result);
        }
    }

    /* access modifiers changed from: package-private */
    public void A(Request request) {
        if (!n()) {
            b(request);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean B() {
        String str;
        String str2;
        LoginMethodHandler j10 = j();
        if (!j10.j() || d()) {
            int o10 = j10.o(this.f20431g);
            this.f20435w = 0;
            if (o10 > 0) {
                h o11 = o();
                String b10 = this.f20431g.b();
                String h10 = j10.h();
                if (this.f20431g.n()) {
                    str2 = "foa_mobile_login_method_start";
                } else {
                    str2 = "fb_mobile_login_method_start";
                }
                o11.e(b10, h10, str2);
                this.C = o10;
            } else {
                h o12 = o();
                String b11 = this.f20431g.b();
                String h11 = j10.h();
                if (this.f20431g.n()) {
                    str = "foa_mobile_login_method_not_tried";
                } else {
                    str = "fb_mobile_login_method_not_tried";
                }
                o12.d(b11, h11, str);
                a("not_tried", j10.h(), true);
            }
            if (o10 > 0) {
                return true;
            }
            return false;
        }
        a("no_internet_permission", "1", false);
        return false;
    }

    /* access modifiers changed from: package-private */
    public void C() {
        int i10;
        if (this.f20426b >= 0) {
            s(j().h(), "skipped", (String) null, (String) null, j().g());
        }
        do {
            LoginMethodHandler[] loginMethodHandlerArr = this.f20425a;
            if (loginMethodHandlerArr != null && (i10 = this.f20426b) < loginMethodHandlerArr.length - 1) {
                this.f20426b = i10 + 1;
            } else if (this.f20431g != null) {
                h();
                return;
            } else {
                return;
            }
        } while (!B());
    }

    /* access modifiers changed from: package-private */
    public void D(Result result) {
        Result result2;
        if (result.f20448b != null) {
            AccessToken d10 = AccessToken.d();
            AccessToken accessToken = result.f20448b;
            if (!(d10 == null || accessToken == null)) {
                try {
                    if (d10.n().equals(accessToken.n())) {
                        result2 = Result.b(this.f20431g, result.f20448b, result.f20449c);
                        f(result2);
                        return;
                    }
                } catch (Exception e10) {
                    f(Result.c(this.f20431g, "Caught exception", e10.getMessage()));
                    return;
                }
            }
            result2 = Result.c(this.f20431g, "User logged in as different Facebook user.", (String) null);
            f(result2);
            return;
        }
        throw new l("Can't validate without a token");
    }

    /* access modifiers changed from: package-private */
    public void b(Request request) {
        if (request != null) {
            if (this.f20431g != null) {
                throw new l("Attempted to authorize while a request is pending.");
            } else if (!AccessToken.o() || d()) {
                this.f20431g = request;
                this.f20425a = m(request);
                C();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f20426b >= 0) {
            j().b();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        if (this.f20430f) {
            return true;
        }
        if (e("android.permission.INTERNET") != 0) {
            FragmentActivity i10 = i();
            f(Result.c(this.f20431g, i10.getString(f.f24293c), i10.getString(f.f24292b)));
            return false;
        }
        this.f20430f = true;
        return true;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int e(String str) {
        return i().checkCallingOrSelfPermission(str);
    }

    /* access modifiers changed from: package-private */
    public void f(Result result) {
        LoginMethodHandler j10 = j();
        if (j10 != null) {
            r(j10.h(), result, j10.g());
        }
        Map map = this.f20432h;
        if (map != null) {
            result.f20453g = map;
        }
        Map map2 = this.f20433i;
        if (map2 != null) {
            result.f20454h = map2;
        }
        this.f20425a = null;
        this.f20426b = -1;
        this.f20431g = null;
        this.f20432h = null;
        this.f20435w = 0;
        this.C = 0;
        v(result);
    }

    /* access modifiers changed from: package-private */
    public void g(Result result) {
        if (result.f20448b == null || !AccessToken.o()) {
            f(result);
        } else {
            D(result);
        }
    }

    /* access modifiers changed from: package-private */
    public FragmentActivity i() {
        return this.f20427c.getActivity();
    }

    /* access modifiers changed from: package-private */
    public LoginMethodHandler j() {
        int i10 = this.f20426b;
        if (i10 >= 0) {
            return this.f20425a[i10];
        }
        return null;
    }

    public Fragment l() {
        return this.f20427c;
    }

    /* access modifiers changed from: protected */
    public LoginMethodHandler[] m(Request request) {
        ArrayList arrayList = new ArrayList();
        e g10 = request.g();
        if (!request.o()) {
            if (g10.d()) {
                arrayList.add(new GetTokenLoginMethodHandler(this));
            }
            if (!o.f20689r && g10.f()) {
                arrayList.add(new KatanaProxyLoginMethodHandler(this));
            }
            if (!o.f20689r && g10.c()) {
                arrayList.add(new FacebookLiteLoginMethodHandler(this));
            }
        } else if (!o.f20689r && g10.e()) {
            arrayList.add(new InstagramAppLoginMethodHandler(this));
        }
        if (g10.a()) {
            arrayList.add(new CustomTabLoginMethodHandler(this));
        }
        if (g10.h()) {
            arrayList.add(new WebViewLoginMethodHandler(this));
        }
        if (!request.o() && g10.b()) {
            arrayList.add(new DeviceAuthMethodHandler(this));
        }
        LoginMethodHandler[] loginMethodHandlerArr = new LoginMethodHandler[arrayList.size()];
        arrayList.toArray(loginMethodHandlerArr);
        return loginMethodHandlerArr;
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        if (this.f20431g == null || this.f20426b < 0) {
            return false;
        }
        return true;
    }

    public Request q() {
        return this.f20431g;
    }

    /* access modifiers changed from: package-private */
    public void t() {
        b bVar = this.f20429e;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void u() {
        b bVar = this.f20429e;
        if (bVar != null) {
            bVar.b();
        }
    }

    public boolean w(int i10, int i11, Intent intent) {
        this.f20435w++;
        if (this.f20431g != null) {
            if (intent != null && intent.getBooleanExtra(CustomTabMainActivity.NO_ACTIVITY_EXCEPTION, false)) {
                C();
                return false;
            } else if (!j().n() || intent != null || this.f20435w >= this.C) {
                return j().k(i10, i11, intent);
            }
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelableArray(this.f20425a, i10);
        parcel.writeInt(this.f20426b);
        parcel.writeParcelable(this.f20431g, i10);
        p0.F0(parcel, this.f20432h);
        p0.F0(parcel, this.f20433i);
    }

    /* access modifiers changed from: package-private */
    public void x(b bVar) {
        this.f20429e = bVar;
    }

    /* access modifiers changed from: package-private */
    public void y(Fragment fragment) {
        if (this.f20427c == null) {
            this.f20427c = fragment;
            return;
        }
        throw new l("Can't set fragment once it is already set.");
    }

    /* access modifiers changed from: package-private */
    public void z(c cVar) {
        this.f20428d = cVar;
    }

    public LoginClient(Parcel parcel) {
        this.f20426b = -1;
        this.f20435w = 0;
        this.C = 0;
        Parcelable[] readParcelableArray = parcel.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        this.f20425a = new LoginMethodHandler[readParcelableArray.length];
        for (int i10 = 0; i10 < readParcelableArray.length; i10++) {
            LoginMethodHandler[] loginMethodHandlerArr = this.f20425a;
            LoginMethodHandler loginMethodHandler = (LoginMethodHandler) readParcelableArray[i10];
            loginMethodHandlerArr[i10] = loginMethodHandler;
            loginMethodHandler.m(this);
        }
        this.f20426b = parcel.readInt();
        this.f20431g = (Request) parcel.readParcelable(Request.class.getClassLoader());
        this.f20432h = p0.q0(parcel);
        this.f20433i = p0.q0(parcel);
    }
}
