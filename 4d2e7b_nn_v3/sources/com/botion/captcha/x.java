package com.botion.captcha;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static final x f18582a = new x();

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, ? extends JSONObject> f18583b;

    private x() {
    }

    public static void a(Map<String, ? extends JSONObject> map) {
        f18583b = map;
    }

    private static String b(Context context, String str) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("com.botion.core.GeeGuard");
            Class<?> cls3 = Class.forName("com.botion.core.GeeGuardConfiguration");
            Class<?> cls4 = Class.forName("com.botion.core.GeeGuardConfiguration$Builder");
            Object newInstance = cls4.newInstance();
            cls4.getMethod("setAppId", new Class[]{cls}).invoke(newInstance, new Object[]{"54847f3301740c85982a1d3d566bd24e"});
            cls4.getMethod("setExtraInfo", new Class[]{HashMap.class}).invoke(newInstance, new Object[]{f18583b});
            Class cls5 = Boolean.TYPE;
            cls4.getMethod("setAlInfo", new Class[]{cls5}).invoke(newInstance, new Object[]{Boolean.FALSE});
            cls4.getMethod("setDevInfo", new Class[]{cls5}).invoke(newInstance, new Object[]{Boolean.TRUE});
            cls4.getMethod("setLevel", new Class[]{Integer.TYPE}).invoke(newInstance, new Object[]{1});
            cls4.getMethod("addSignature", new Class[]{cls}).invoke(newInstance, new Object[]{str});
            Object invoke = cls4.getMethod("build", (Class[]) null).invoke(newInstance, (Object[]) null);
            Object invoke2 = cls2.getMethod("getData", new Class[]{Context.class, cls3}).invoke((Object) null, new Object[]{context, invoke});
            if (invoke2 != null) {
                return (String) invoke2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        r5 = r5.a().f18473b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "url"
            kotlin.jvm.internal.m.f(r5, r0)
            r0 = 0
            if (r4 == 0) goto L_0x006d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0026 }
            r1.<init>()     // Catch:{ Exception -> 0x0026 }
            com.botion.captcha.ad$b r2 = com.botion.captcha.ad.f18469a     // Catch:{ Exception -> 0x0026 }
            com.botion.captcha.ad r5 = com.botion.captcha.ad.b.a(r5)     // Catch:{ Exception -> 0x0026 }
            if (r5 == 0) goto L_0x0028
            com.botion.captcha.ad$a r5 = r5.a()     // Catch:{ Exception -> 0x0026 }
            java.util.Map<java.lang.String, java.lang.String> r5 = r5.f18473b     // Catch:{ Exception -> 0x0026 }
            if (r5 == 0) goto L_0x0028
            java.lang.String r2 = "data"
            java.lang.Object r5 = r5.get(r2)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0026 }
            goto L_0x0029
        L_0x0026:
            r4 = move-exception
            goto L_0x006a
        L_0x0028:
            r5 = r0
        L_0x0029:
            java.lang.String r2 = "utf-8"
            java.lang.String r5 = java.net.URLDecoder.decode(r5, r2)     // Catch:{ Exception -> 0x0026 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0026 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r5 = "challenge"
            java.lang.String r5 = r2.getString(r5)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r3 = "captchaId"
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x0026 }
            r1.append(r2)     // Catch:{ Exception -> 0x0026 }
            r1.append(r5)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r5 = r4.getPackageName()     // Catch:{ Exception -> 0x0026 }
            r1.append(r5)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r5 = "1.0.3"
            r1.append(r5)     // Catch:{ Exception -> 0x0026 }
            com.botion.captcha.af r5 = com.botion.captcha.af.f18475a     // Catch:{ Exception -> 0x0026 }
            java.lang.String r5 = "Sign content: "
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r5 = r5.concat(r2)     // Catch:{ Exception -> 0x0026 }
            com.botion.captcha.af.a((java.lang.String) r5)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x0026 }
            java.lang.String r4 = b(r4, r5)     // Catch:{ Exception -> 0x0026 }
            return r4
        L_0x006a:
            r4.printStackTrace()
        L_0x006d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.botion.captcha.x.a(android.content.Context, java.lang.String):java.lang.String");
    }
}
