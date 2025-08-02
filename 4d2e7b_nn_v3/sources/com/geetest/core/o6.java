package com.geetest.core;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.geetest.core.i6;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class o6 extends m6<i6> {

    /* renamed from: d  reason: collision with root package name */
    public h6 f6121d;

    /* renamed from: e  reason: collision with root package name */
    public j6 f6122e;

    public o6(Context context, String str) {
        super(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        if (r1 != 2) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.String> a() {
        /*
            r4 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.geetest.core.h6 r1 = r4.f6121d
            int r1 = r1.ordinal()
            java.lang.String r2 = "Content-Type"
            if (r1 == 0) goto L_0x001c
            r3 = 1
            if (r1 == r3) goto L_0x0016
            r3 = 2
            if (r1 == r3) goto L_0x001c
            goto L_0x0021
        L_0x0016:
            java.lang.String r1 = "application/x-www-form-urlencoded;charset=UTF-8"
            r0.put(r2, r1)
            goto L_0x0021
        L_0x001c:
            java.lang.String r1 = "application/json"
            r0.put(r2, r1)
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.core.o6.a():java.util.Map");
    }

    public boolean b() {
        if (this.f6121d.ordinal() != 2) {
            return true;
        }
        return false;
    }

    public JSONObject c() throws Exception {
        JSONObject jSONObject = new JSONObject();
        int ordinal = this.f6121d.ordinal();
        if (ordinal == 0) {
            jSONObject.put("version", this.f6122e.f6051i);
            jSONObject.put("timestamp", this.f6122e.f6071b);
            jSONObject.put("businessType", this.f6122e.f6052j);
            jSONObject.put("traceId", this.f6122e.f6049g);
            jSONObject.put("msgId", this.f6122e.f6050h);
            jSONObject.put("sign", this.f6122e.f6045c);
            jSONObject.put("appId", this.f6122e.f6070a);
        } else if (ordinal == 1 || ordinal == 2) {
            return null;
        }
        return jSONObject;
    }

    public String d() {
        if (this.f6121d.ordinal() != 1) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("version", this.f6122e.f6051i);
        hashMap.put("clientType", "30100");
        hashMap.put("format", this.f6122e.f6046d);
        hashMap.put("paramKey", this.f6122e.f6047e);
        hashMap.put("paramStr", this.f6122e.f6048f);
        hashMap.put("sign", this.f6122e.f6045c);
        hashMap.put("appId", this.f6122e.f6070a);
        return c.a((Map<String, String>) hashMap).toString();
    }

    public void a(String str, s6<i6> s6Var) {
        if (TextUtils.isEmpty(str)) {
            s6Var.a("-1", "The response result is empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            i6 i6Var = new i6();
            int ordinal = this.f6121d.ordinal();
            if (ordinal == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("header");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("body");
                if (optJSONObject == null || optJSONObject2 == null) {
                    s6Var.a("-40101", str);
                    return;
                }
                String optString = optJSONObject2.optString("token");
                if (TextUtils.isEmpty(optString)) {
                    s6Var.a("-40101", str);
                    return;
                }
                i6.a aVar = new i6.a();
                aVar.f6031f = optString;
                aVar.f6028c = optJSONObject.optString("appId");
                aVar.f6029d = optJSONObject.optString("msgId");
                aVar.f6030e = optJSONObject.optString("timestamp");
                aVar.f6026a = optJSONObject2.optString("resultCode");
                aVar.f6027b = optJSONObject2.optString("resultDesc");
                i6Var.f6023a = aVar;
                s6Var.a(aVar.f6026a, i6Var);
            } else if (ordinal == 1) {
                String optString2 = jSONObject.optString("data");
                if (TextUtils.isEmpty(optString2)) {
                    s6Var.a("-40301", str);
                    return;
                }
                i6.b bVar = new i6.b();
                bVar.f6032a = jSONObject.optInt(DbParams.KEY_CHANNEL_RESULT);
                bVar.f6034c = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                bVar.f6033b = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    s6Var.a("-40301", str);
                }
                i6Var.f6024b = bVar;
                s6Var.a(String.valueOf(bVar.f6032a), i6Var);
            } else if (ordinal == 2) {
                i6.c cVar = new i6.c();
                String optString3 = jSONObject.optString(Constant.PARAM_OAUTH_CODE);
                cVar.f6036b = optString3;
                if (TextUtils.isEmpty(optString3)) {
                    s6Var.a("-40201", str);
                }
                cVar.f6035a = jSONObject.optString("province");
                i6Var.f6025c = cVar;
                s6Var.a("1", i6Var);
            }
        } catch (JSONException unused) {
            s6Var.a("-1", str);
        }
    }
}
