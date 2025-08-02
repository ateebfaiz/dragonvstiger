package com.botion.captcha;

import android.content.Context;
import android.util.Pair;
import com.alibaba.pdns.f;
import com.alibaba.pdns.model.DomainUhfReportModel;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public final class g {

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final g f18529a = new g((byte) 0);
    }

    /* synthetic */ g(byte b10) {
        this();
    }

    public static String a(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context == null) {
            return jSONObject.toString();
        }
        String a10 = h.a(context, "boc_fp");
        long b10 = h.b(context, "boc_ts");
        if (b10 == 0) {
            b10 = System.currentTimeMillis();
            try {
                context.getSharedPreferences("boc_fp", 0).edit().putLong("boc_ts", b10).apply();
            } catch (Exception unused) {
            }
        }
        try {
            jSONObject.put("bd", "$unknown");
            Pair<String, String> a11 = i.a(context);
            if (a11 != null) {
                jSONObject.put(DomainUhfReportModel.ENCRYPTDATA, a11.first);
                jSONObject.put("e", a11.second);
                if (h.a(a10) && !h.a((String) a11.first)) {
                    a10 = h.c(context, (String) a11.first);
                }
            } else {
                jSONObject.put(DomainUhfReportModel.ENCRYPTDATA, "$unknown");
                jSONObject.put("e", "$unknown");
            }
            if (h.a(a10)) {
                a10 = h.c(context, UUID.randomUUID().toString());
            }
            jSONObject.put("fp", a10);
            jSONObject.put("ts", String.valueOf(b10));
            jSONObject.put("ver", "1.0.0");
            jSONObject.put("client_type", f.f17924q);
        } catch (JSONException unused2) {
        }
        return jSONObject.toString();
    }

    private g() {
    }
}
