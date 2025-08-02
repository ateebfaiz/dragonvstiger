package com.geetest.captcha;

import android.content.Context;
import com.geetest.gtc4.GeeGuard;
import com.geetest.gtc4.GeeGuardConfiguration;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, ? extends JSONObject> f5772a;

    /* renamed from: b  reason: collision with root package name */
    public static final a0 f5773b = new a0();

    public final String a(Context context, String str) {
        Object obj;
        Object obj2;
        Class<String> cls = String.class;
        try {
            h0.f5812d.b("isGtc4Available");
            Class<GeeGuard> cls2 = GeeGuard.class;
            Class<GeeGuardConfiguration.Builder> cls3 = GeeGuardConfiguration.Builder.class;
            GeeGuardConfiguration.Builder newInstance = cls3.newInstance();
            Method method = cls3.getMethod("setAppId", new Class[]{cls});
            if (method != null) {
                method.invoke(newInstance, new Object[]{"54847f3301740c85982a1d3d566bd24e"});
            }
            Method method2 = cls3.getMethod("setExtraInfo", new Class[]{HashMap.class});
            if (method2 != null) {
                method2.invoke(newInstance, new Object[]{f5772a});
            }
            Method method3 = cls3.getMethod("setAlInfo", new Class[]{Boolean.TYPE});
            if (method3 != null) {
                method3.invoke(newInstance, new Object[]{Boolean.FALSE});
            }
            Method method4 = cls3.getMethod("setDevInfo", new Class[]{Boolean.TYPE});
            if (method4 != null) {
                method4.invoke(newInstance, new Object[]{Boolean.TRUE});
            }
            Method method5 = cls3.getMethod("setLevel", new Class[]{Integer.TYPE});
            if (method5 != null) {
                method5.invoke(newInstance, new Object[]{1});
            }
            Method method6 = cls3.getMethod("addSignature", new Class[]{cls});
            if (method6 != null) {
                method6.invoke(newInstance, new Object[]{str});
            }
            Method method7 = cls3.getMethod("build", (Class[]) null);
            if (method7 != null) {
                obj = method7.invoke(newInstance, (Object[]) null);
            } else {
                obj = null;
            }
            Method method8 = cls2.getMethod("getData", new Class[]{Context.class, GeeGuardConfiguration.class});
            if (method8 != null) {
                obj2 = method8.invoke((Object) null, new Object[]{context, obj});
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                return (String) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception e10) {
            h0.f5812d.b("gtc4 date:" + e10);
            return null;
        }
    }

    public final String b(Context context, String str) {
        String str2;
        m.f(str, ImagesContract.URL);
        if (context != null) {
            try {
                StringBuilder sb2 = new StringBuilder();
                f0 a10 = f0.f5799c.a(str);
                if (a10 != null) {
                    String str3 = a10.f5800a;
                    Map<String, String> map = a10.f5801b;
                    m.f(str3, "baseUrl");
                    if (map != null) {
                        str2 = map.get("data");
                        JSONObject jSONObject = new JSONObject(URLDecoder.decode(str2, "utf-8"));
                        String string = jSONObject.getString(ClientData.KEY_CHALLENGE);
                        sb2.append(jSONObject.getString("captchaId"));
                        sb2.append(string);
                        sb2.append(context.getPackageName());
                        sb2.append("1.8.3.1");
                        h0.f5812d.a("Sign content: " + sb2);
                        return a(context, sb2.toString());
                    }
                }
                str2 = null;
                JSONObject jSONObject2 = new JSONObject(URLDecoder.decode(str2, "utf-8"));
                String string2 = jSONObject2.getString(ClientData.KEY_CHALLENGE);
                sb2.append(jSONObject2.getString("captchaId"));
                sb2.append(string2);
                sb2.append(context.getPackageName());
                sb2.append("1.8.3.1");
                h0.f5812d.a("Sign content: " + sb2);
                return a(context, sb2.toString());
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }
}
