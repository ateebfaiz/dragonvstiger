package b2;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.push.api.PlatformTokenMessage;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FirebaseMessaging;
import com.zing.zalo.zalosdk.common.Constant;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f17157a;

    public static a a() {
        if (f17157a == null) {
            synchronized (a.class) {
                f17157a = new a();
            }
        }
        return f17157a;
    }

    public void b(Context context) {
        try {
            int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context);
            if (isGooglePlayServicesAvailable != 0) {
                s1.a.b("MTGoogleBusiness", "not support google push, code:" + isGooglePlayServicesAvailable);
                c(context, AuthApiStatusCodes.AUTH_API_CLIENT_ERROR, isGooglePlayServicesAvailable, 3900, 1);
                return;
            }
            s1.a.a("MTGoogleBusiness", "support google push");
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new c2.a(context));
        } catch (Throwable th) {
            s1.a.b("MTGoogleBusiness", "init failed " + th.getMessage());
        }
    }

    public void c(Context context, int i10, int i11, int i12, int i13) {
        Bundle bundle = new Bundle();
        bundle.putByte("platform", (byte) 8);
        bundle.putInt(Constant.PARAM_OAUTH_CODE, i10);
        bundle.putInt("mCode", i11);
        bundle.putInt("type", i12);
        bundle.putInt(Constants.MessagePayloadKeys.FROM, i13);
        h1.a.i(context, 3022, bundle);
    }

    public void d(Context context, String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            s1.a.a("MTGoogleBusiness", "onToken:token is empty");
            return;
        }
        PlatformTokenMessage e10 = new PlatformTokenMessage().d((byte) 8).e(str);
        Bundle bundle = new Bundle();
        bundle.putParcelable("message", e10);
        z1.a.a(context);
        h1.a.i(context, 3021, bundle);
        c(context, 3008, 0, 3901, i10);
    }
}
