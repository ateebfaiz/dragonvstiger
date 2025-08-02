package com.engagelab.privates.common.component;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.push.api.NotificationMessage;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import d2.i;
import h1.a;
import org.json.JSONObject;

public class MTCommonActivity extends Activity {
    private void a(Intent intent) {
        String str;
        String string;
        try {
            Bundle extras = intent.getExtras();
            if (intent.getData() != null) {
                str = intent.getData().toString();
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str) && intent.getExtras() != null) {
                if (extras.containsKey("JMessageExtra")) {
                    string = extras.getString("JMessageExtra");
                } else {
                    string = extras.getString("MTMessageExtra");
                }
                str = string;
            }
            if (TextUtils.isEmpty(str)) {
                a.i(getApplicationContext(), Integer.parseInt(intent.getAction()), extras);
            } else {
                b(str);
            }
        } catch (Throwable th) {
            s1.a.h("MTCommonActivity", "processIntent failed " + th.getMessage());
        } finally {
            finish();
        }
    }

    private void b(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        Bundle bundle;
        try {
            JSONObject jSONObject = new JSONObject(str);
            s1.a.a("MTCommonActivity", "platformMessageJson:" + s1.a.g(jSONObject));
            String j10 = i.j(jSONObject);
            byte optInt = (byte) jSONObject.optInt("rom_type");
            if (jSONObject.has("m_content")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("m_content");
                str5 = optJSONObject.optString("n_title");
                str4 = optJSONObject.optString("n_content");
                str2 = optJSONObject.optString("n_intent_uri");
                str3 = optJSONObject.optString("n_intent_ssl");
                bundle = i.b(optJSONObject.optJSONObject("n_extras"));
            } else {
                String optString = jSONObject.optString("n_title");
                str4 = jSONObject.optString("n_content");
                str2 = jSONObject.optString("n_intent_uri");
                str3 = jSONObject.optString("n_intent_ssl");
                Bundle b10 = i.b(jSONObject.optJSONObject("n_extras"));
                str5 = optString;
                bundle = b10;
            }
            NotificationMessage H = new NotificationMessage().K(j10).N(optInt).T(str5).D(str4).F(bundle).I(str2).H(str3);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("message", H);
            z1.a.a(getApplicationContext());
            a.i(getApplicationContext(), AuthApiStatusCodes.AUTH_API_SERVER_ERROR, bundle2);
        } catch (Throwable th) {
            s1.a.h("MTCommonActivity", "processPlatformMessage failed " + th.getMessage());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent());
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }
}
