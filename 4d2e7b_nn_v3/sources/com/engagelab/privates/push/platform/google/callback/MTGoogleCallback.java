package com.engagelab.privates.push.platform.google.callback;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.engagelab.privates.push.api.CustomMessage;
import com.engagelab.privates.push.api.NotificationMessage;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import d2.i;
import java.util.Map;
import org.json.JSONObject;
import z1.a;

public class MTGoogleCallback extends FirebaseMessagingService {
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str;
        String str2;
        String str3;
        String str4;
        try {
            String messageId = remoteMessage.getMessageId();
            Map<String, String> data = remoteMessage.getData();
            Bundle bundle = new Bundle();
            for (Map.Entry next : data.entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
            if (data.containsKey("JMessageExtra")) {
                str2 = data.get("JMessageExtra");
            } else {
                str2 = data.get("MTMessageExtra");
            }
            if (str2 != null) {
                a.a(this);
                JSONObject jSONObject = new JSONObject(str2);
                s1.a.a("MTGoogleCallback", "onMessage:" + s1.a.g(jSONObject));
                String j10 = i.j(jSONObject);
                RemoteMessage.Notification notification = remoteMessage.getNotification();
                if (notification == null) {
                    s1.a.a("MTGoogleCallback", "is data");
                    String optString = jSONObject.optString("title");
                    String optString2 = jSONObject.optString("message");
                    String optString3 = jSONObject.optString(FirebaseAnalytics.Param.CONTENT_TYPE);
                    CustomMessage f10 = new CustomMessage().g(j10).h((byte) 8).i(messageId).j(optString).d(optString2).e(optString3).f(i.b(jSONObject.optJSONObject("extras")));
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("message", f10);
                    h1.a.i(getApplicationContext(), AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN, bundle2);
                    return;
                }
                s1.a.a("MTGoogleCallback", "is notification");
                int k10 = i.k(j10);
                String title = notification.getTitle();
                String body = notification.getBody();
                Bundle b10 = i.b(jSONObject.optJSONObject("n_extras"));
                int optInt = jSONObject.optInt("n_alert_type");
                int optInt2 = jSONObject.optInt("n_priority");
                String optString4 = jSONObject.optString("n_sound");
                String optString5 = jSONObject.optString("n_channel_id");
                str = "MTGoogleCallback";
                try {
                    if (a.f24997a.startsWith(ExifInterface.GPS_MEASUREMENT_3D)) {
                        String clickAction = notification.getClickAction();
                        if (!TextUtils.isEmpty(clickAction)) {
                            Intent intent = new Intent();
                            intent.setAction(clickAction);
                            intent.putExtras(bundle);
                            intent.setPackage(getApplicationContext().getPackageName());
                            str4 = intent.toURI();
                        } else {
                            str4 = "";
                        }
                        str3 = null;
                    } else {
                        str4 = jSONObject.optString("n_intent_uri");
                        str3 = jSONObject.optString("n_intent_ssl");
                    }
                    NotificationMessage H = new NotificationMessage().K(j10).N((byte) 8).O(messageId).L(k10).T(title).D(body).F(b10).E(optInt).P(optInt2).R(optString4).C(optString5).I(str4).H(str3);
                    Bundle bundle3 = new Bundle();
                    bundle3.putParcelable("message", H);
                    bundle3.putBoolean("message_limit", true);
                    h1.a.j(getApplicationContext(), 3895, bundle3);
                    h1.a.i(getApplicationContext(), AuthApiStatusCodes.AUTH_API_CLIENT_ERROR, bundle3);
                } catch (Throwable th) {
                    th = th;
                    s1.a.h(str, "onMessage failed " + th.getMessage());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            str = "MTGoogleCallback";
            s1.a.h(str, "onMessage failed " + th.getMessage());
        }
    }

    public void onNewToken(String str) {
        if (TextUtils.isEmpty(str)) {
            s1.a.a("MTGoogleCallback", "onTokenFailed:get token is empty");
            b2.a.a().c(getApplicationContext(), AuthApiStatusCodes.AUTH_TOKEN_ERROR, 0, 3900, 2);
            return;
        }
        s1.a.a("MTGoogleCallback", "onTokenSuccess:callback token is " + str);
        b2.a.a().d(getApplicationContext(), str, 2);
    }
}
