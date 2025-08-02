package com.botion.captcha;

import androidx.core.app.NotificationCompat;
import com.zing.zalo.zalosdk.common.Constant;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final a f18571a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final String f18572b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18573c;

    /* renamed from: d  reason: collision with root package name */
    private final JSONObject f18574d;

    public static final class a {
        private a() {
        }

        public static t a(String str, String str2, JSONObject jSONObject) {
            m.f(str, Constant.PARAM_OAUTH_CODE);
            m.f(str2, NotificationCompat.CATEGORY_MESSAGE);
            m.f(jSONObject, "desc");
            return new t(str, str2, jSONObject, (byte) 0);
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    private t(String str, String str2, JSONObject jSONObject) {
        this.f18572b = str;
        this.f18573c = str2;
        this.f18574d = jSONObject;
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constant.PARAM_OAUTH_CODE, this.f18572b);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, this.f18573c);
            jSONObject.put("desc", this.f18574d);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        m.e(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    public /* synthetic */ t(String str, String str2, JSONObject jSONObject, byte b10) {
        this(str, str2, jSONObject);
    }
}
