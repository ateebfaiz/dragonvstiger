package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.CustomTabMainActivity;
import com.facebook.d;
import com.facebook.login.LoginClient;
import com.facebook.n;
import com.facebook.o;
import org.json.JSONException;
import org.json.JSONObject;
import q5.e;
import q5.f;
import q5.p0;

public class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new a();

    /* renamed from: h  reason: collision with root package name */
    public static boolean f20375h;

    /* renamed from: e  reason: collision with root package name */
    private String f20376e;

    /* renamed from: f  reason: collision with root package name */
    private String f20377f;

    /* renamed from: g  reason: collision with root package name */
    private String f20378g;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public CustomTabLoginMethodHandler createFromParcel(Parcel parcel) {
            return new CustomTabLoginMethodHandler(parcel);
        }

        /* renamed from: b */
        public CustomTabLoginMethodHandler[] newArray(int i10) {
            return new CustomTabLoginMethodHandler[i10];
        }
    }

    CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        this.f20378g = "";
        this.f20377f = p0.s(20);
        f20375h = false;
        this.f20378g = f.c(y());
    }

    private boolean A(Bundle bundle) {
        try {
            String string = bundle.getString("state");
            if (string == null) {
                return false;
            }
            return new JSONObject(string).getString("7_challenge").equals(this.f20377f);
        } catch (JSONException unused) {
            return false;
        }
    }

    private String x() {
        String str = this.f20376e;
        if (str != null) {
            return str;
        }
        String a10 = f.a();
        this.f20376e = a10;
        return a10;
    }

    private String y() {
        return super.r();
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void z(java.lang.String r7, com.facebook.login.LoginClient.Request r8) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x00bb
            java.lang.String r0 = "fbconnect://cct."
            boolean r0 = r7.startsWith(r0)
            if (r0 != 0) goto L_0x0014
            java.lang.String r0 = super.r()
            boolean r0 = r7.startsWith(r0)
            if (r0 == 0) goto L_0x00bb
        L_0x0014:
            android.net.Uri r7 = android.net.Uri.parse(r7)
            java.lang.String r0 = r7.getQuery()
            android.os.Bundle r0 = q5.p0.l0(r0)
            java.lang.String r7 = r7.getFragment()
            android.os.Bundle r7 = q5.p0.l0(r7)
            r0.putAll(r7)
            boolean r7 = r6.A(r0)
            r1 = 0
            if (r7 != 0) goto L_0x003d
            com.facebook.l r7 = new com.facebook.l
            java.lang.String r0 = "Invalid state parameter"
            r7.<init>((java.lang.String) r0)
            super.v(r8, r1, r7)
            return
        L_0x003d:
            java.lang.String r7 = "error"
            java.lang.String r7 = r0.getString(r7)
            if (r7 != 0) goto L_0x004b
            java.lang.String r7 = "error_type"
            java.lang.String r7 = r0.getString(r7)
        L_0x004b:
            java.lang.String r2 = "error_msg"
            java.lang.String r2 = r0.getString(r2)
            if (r2 != 0) goto L_0x0059
            java.lang.String r2 = "error_message"
            java.lang.String r2 = r0.getString(r2)
        L_0x0059:
            if (r2 != 0) goto L_0x0061
            java.lang.String r2 = "error_description"
            java.lang.String r2 = r0.getString(r2)
        L_0x0061:
            java.lang.String r3 = "error_code"
            java.lang.String r3 = r0.getString(r3)
            boolean r4 = q5.p0.Y(r3)
            r5 = -1
            if (r4 != 0) goto L_0x0073
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0073 }
            goto L_0x0074
        L_0x0073:
            r3 = r5
        L_0x0074:
            boolean r4 = q5.p0.Y(r7)
            if (r4 == 0) goto L_0x0086
            boolean r4 = q5.p0.Y(r2)
            if (r4 == 0) goto L_0x0086
            if (r3 != r5) goto L_0x0086
            super.v(r8, r0, r1)
            goto L_0x00bb
        L_0x0086:
            if (r7 == 0) goto L_0x00a1
            java.lang.String r0 = "access_denied"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x0098
            java.lang.String r0 = "OAuthAccessDeniedException"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00a1
        L_0x0098:
            com.facebook.n r7 = new com.facebook.n
            r7.<init>()
            super.v(r8, r1, r7)
            goto L_0x00bb
        L_0x00a1:
            r0 = 4201(0x1069, float:5.887E-42)
            if (r3 != r0) goto L_0x00ae
            com.facebook.n r7 = new com.facebook.n
            r7.<init>()
            super.v(r8, r1, r7)
            goto L_0x00bb
        L_0x00ae:
            com.facebook.FacebookRequestError r0 = new com.facebook.FacebookRequestError
            r0.<init>(r3, r7, r2)
            com.facebook.q r7 = new com.facebook.q
            r7.<init>(r0, r2)
            super.v(r8, r1, r7)
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.CustomTabLoginMethodHandler.z(java.lang.String, com.facebook.login.LoginClient$Request):void");
    }

    public int describeContents() {
        return 0;
    }

    public String h() {
        return "custom_tab";
    }

    public boolean k(int i10, int i11, Intent intent) {
        if (intent != null && intent.getBooleanExtra(CustomTabMainActivity.NO_ACTIVITY_EXCEPTION, false)) {
            return super.k(i10, i11, intent);
        }
        if (i10 != 1) {
            return super.k(i10, i11, intent);
        }
        LoginClient.Request q10 = f().q();
        String str = null;
        if (i11 == -1) {
            if (intent != null) {
                str = intent.getStringExtra(CustomTabMainActivity.EXTRA_URL);
            }
            z(str, q10);
            return true;
        }
        super.v(q10, (Bundle) null, new n());
        return false;
    }

    public void l(JSONObject jSONObject) {
        jSONObject.put("7_challenge", this.f20377f);
    }

    public int o(LoginClient.Request request) {
        LoginClient f10 = f();
        if (r().isEmpty()) {
            return 0;
        }
        Bundle p10 = p(q(request), request);
        if (f20375h) {
            p10.putString("cct_over_app_switch", "1");
        }
        if (o.f20687p) {
            if (request.o()) {
                a.e(e.a("oauth", p10));
            } else {
                a.e(e.a("oauth", p10));
            }
        }
        Intent intent = new Intent(f10.i(), CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, "oauth");
        intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, p10);
        intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, x());
        intent.putExtra(CustomTabMainActivity.EXTRA_TARGET_APP, request.h().toString());
        f10.l().startActivityForResult(intent, 1);
        return 1;
    }

    /* access modifiers changed from: protected */
    public String r() {
        return this.f20378g;
    }

    /* access modifiers changed from: protected */
    public String s() {
        return "chrome_custom_tab";
    }

    /* access modifiers changed from: package-private */
    public d t() {
        return d.CHROME_CUSTOM_TAB;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f20377f);
    }

    CustomTabLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.f20378g = "";
        this.f20377f = parcel.readString();
    }
}
