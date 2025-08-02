package com.onesignal;

import com.onesignal.b4;
import com.onesignal.o3;
import com.zing.zalo.zalosdk.common.Constant;
import org.json.JSONException;
import org.json.JSONObject;

class t2 {
    t2() {
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2, Integer num, String str3, b4.g gVar) {
        try {
            JSONObject put = new JSONObject().put(Constant.PARAM_APP_ID, str).put("player_id", str2);
            if (num != null) {
                put.put("device_type", num);
            }
            b4.l("notifications/" + str3 + "/report_received", put, gVar);
        } catch (JSONException e10) {
            o3.b(o3.v.ERROR, "Generating direct receive receipt:JSON Failed.", e10);
        }
    }
}
