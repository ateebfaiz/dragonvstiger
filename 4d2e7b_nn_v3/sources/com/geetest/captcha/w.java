package com.geetest.captcha;

import androidx.core.app.NotificationCompat;
import com.zing.zalo.zalosdk.common.Constant;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;

public final class w {

    /* renamed from: d  reason: collision with root package name */
    public static final a f5877d = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f5878a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5879b;

    /* renamed from: c  reason: collision with root package name */
    public final JSONObject f5880c;

    public static final class a {
        public final w a(String str, String str2, JSONObject jSONObject) {
            m.f(str, Constant.PARAM_OAUTH_CODE);
            m.f(str2, NotificationCompat.CATEGORY_MESSAGE);
            m.f(jSONObject, "desc");
            return new w(str, str2, jSONObject);
        }
    }

    public w(String str, String str2, JSONObject jSONObject) {
        this.f5878a = str;
        this.f5879b = str2;
        this.f5880c = jSONObject;
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constant.PARAM_OAUTH_CODE, this.f5878a);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, this.f5879b);
            jSONObject.put("desc", this.f5880c);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        m.e(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }
}
