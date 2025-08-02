package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.VisibleForTesting;
import com.facebook.d;
import com.facebook.l;
import com.facebook.login.LoginClient;
import com.google.firebase.messaging.Constants;
import q5.i0;
import q5.p0;

@VisibleForTesting(otherwise = 3)
public abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
    NativeAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    private void p(LoginClient.Result result) {
        if (result != null) {
            f().g(result);
        } else {
            f().C();
        }
    }

    public boolean k(int i10, int i11, Intent intent) {
        LoginClient.Request q10 = f().q();
        if (intent == null) {
            p(LoginClient.Result.a(q10, "Operation canceled"));
        } else if (i11 == 0) {
            t(q10, intent);
        } else {
            String str = null;
            if (i11 != -1) {
                p(LoginClient.Result.c(q10, "Unexpected resultCode from authorization.", (String) null));
            } else {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    p(LoginClient.Result.c(q10, "Unexpected null from returned authorization data.", (String) null));
                    return true;
                }
                String q11 = q(extras);
                if (extras.get("error_code") != null) {
                    str = extras.get("error_code").toString();
                }
                String r10 = r(extras);
                String string = extras.getString("e2e");
                if (!p0.Y(string)) {
                    i(string);
                }
                if (q11 == null && str == null && r10 == null) {
                    v(q10, extras);
                } else {
                    u(q10, q11, r10, str);
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public String q(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        if (string == null) {
            return bundle.getString("error_type");
        }
        return string;
    }

    /* access modifiers changed from: protected */
    public String r(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("error_message");
        if (string == null) {
            return bundle.getString("error_description");
        }
        return string;
    }

    public d s() {
        return d.FACEBOOK_APPLICATION_WEB;
    }

    /* access modifiers changed from: protected */
    public void t(LoginClient.Request request, Intent intent) {
        String str;
        Bundle extras = intent.getExtras();
        String q10 = q(extras);
        if (extras.get("error_code") != null) {
            str = extras.get("error_code").toString();
        } else {
            str = null;
        }
        if (i0.c().equals(str)) {
            p(LoginClient.Result.d(request, q10, r(extras), str));
        }
        p(LoginClient.Result.a(request, q10));
    }

    /* access modifiers changed from: protected */
    public void u(LoginClient.Request request, String str, String str2, String str3) {
        if (str != null && str.equals("logged_out")) {
            CustomTabLoginMethodHandler.f20375h = true;
            p((LoginClient.Result) null);
        } else if (i0.d().contains(str)) {
            p((LoginClient.Result) null);
        } else if (i0.e().contains(str)) {
            p(LoginClient.Result.a(request, (String) null));
        } else {
            p(LoginClient.Result.d(request, str, str2, str3));
        }
    }

    /* access modifiers changed from: protected */
    public void v(LoginClient.Request request, Bundle bundle) {
        try {
            p(LoginClient.Result.b(request, LoginMethodHandler.c(request.k(), bundle, s(), request.a()), LoginMethodHandler.d(bundle, request.j())));
        } catch (l e10) {
            p(LoginClient.Result.c(request, (String) null, e10.getMessage()));
        }
    }

    /* access modifiers changed from: protected */
    public boolean w(Intent intent, int i10) {
        if (intent == null) {
            return false;
        }
        try {
            f().l().startActivityForResult(intent, i10);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    NativeAppLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }
}
