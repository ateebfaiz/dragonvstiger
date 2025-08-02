package com.geetest.captcha;

import android.content.Context;
import android.util.Pair;
import com.alibaba.pdns.f;
import com.alibaba.pdns.model.DomainUhfReportModel;
import com.geetest.captcha.k;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public final class j {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final j f5823a = new j();
    }

    public String a(Context context) {
        String str;
        long j10;
        k kVar = k.a.f5825a;
        JSONObject jSONObject = new JSONObject();
        if (context == null) {
            return jSONObject.toString();
        }
        try {
            str = context.getSharedPreferences("gt_fp", 0).getString("gt_fp", (String) null);
        } catch (Exception unused) {
            str = "$unknown";
        }
        try {
            j10 = context.getSharedPreferences("gt_fp", 0).getLong("gt_ts", 0);
        } catch (Exception unused2) {
            j10 = 0;
        }
        if (j10 == 0) {
            j10 = System.currentTimeMillis();
            try {
                context.getSharedPreferences("gt_fp", 0).edit().putLong("gt_ts", j10).apply();
            } catch (Exception unused3) {
            }
        }
        try {
            jSONObject.put("bd", "$unknown");
            Pair<String, String> a10 = l.a(context);
            if (a10 != null) {
                jSONObject.put(DomainUhfReportModel.ENCRYPTDATA, a10.first);
                jSONObject.put("e", a10.second);
                if (i.b(str) && !i.b((String) a10.first)) {
                    str = i.a(context, (String) a10.first);
                }
            } else {
                jSONObject.put(DomainUhfReportModel.ENCRYPTDATA, "$unknown");
                jSONObject.put("e", "$unknown");
            }
            if (i.b(str)) {
                str = i.a(context, UUID.randomUUID().toString());
            }
            jSONObject.put("fp", str);
            jSONObject.put("ts", j10 + "");
            jSONObject.put("ver", "1.0.0");
            jSONObject.put("client_type", f.f17924q);
        } catch (JSONException unused4) {
        }
        return jSONObject.toString();
    }
}
