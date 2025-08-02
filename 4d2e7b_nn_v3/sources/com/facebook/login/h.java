package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.login.LoginClient;
import e2.m;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

class h {

    /* renamed from: d  reason: collision with root package name */
    private static final ScheduledExecutorService f20508d = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: a  reason: collision with root package name */
    private final m f20509a;

    /* renamed from: b  reason: collision with root package name */
    private String f20510b;

    /* renamed from: c  reason: collision with root package name */
    private String f20511c;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bundle f20512a;

        a(Bundle bundle) {
            this.f20512a = bundle;
        }

        public void run() {
            if (!v5.a.d(this)) {
                try {
                    h.a(h.this).g("fb_mobile_login_heartbeat", this.f20512a);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    h(Context context, String str) {
        PackageInfo packageInfo;
        this.f20510b = str;
        this.f20509a = new m(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0)) != null) {
                this.f20511c = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    static /* synthetic */ m a(h hVar) {
        Class<h> cls = h.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return hVar.f20509a;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private void g(String str) {
        if (!v5.a.d(this)) {
            try {
                f20508d.schedule(new a(k(str)), 5, TimeUnit.SECONDS);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    static Bundle k(String str) {
        Class<h> cls = h.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
            bundle.putString("0_auth_logger_id", str);
            bundle.putString("3_method", "");
            bundle.putString("2_result", "");
            bundle.putString("5_error_message", "");
            bundle.putString("4_error_code", "");
            bundle.putString("6_extras", "");
            return bundle;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public String b() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            return this.f20510b;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public void c(String str, String str2, String str3, String str4, String str5, Map map, String str6) {
        if (!v5.a.d(this)) {
            try {
                Bundle k10 = k(str);
                if (str3 != null) {
                    k10.putString("2_result", str3);
                }
                if (str4 != null) {
                    k10.putString("5_error_message", str4);
                }
                if (str5 != null) {
                    k10.putString("4_error_code", str5);
                }
                if (map != null && !map.isEmpty()) {
                    k10.putString("6_extras", new JSONObject(map).toString());
                }
                k10.putString("3_method", str2);
                this.f20509a.g(str6, k10);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void d(String str, String str2, String str3) {
        if (!v5.a.d(this)) {
            try {
                Bundle k10 = k(str);
                k10.putString("3_method", str2);
                this.f20509a.g(str3, k10);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void e(String str, String str2, String str3) {
        if (!v5.a.d(this)) {
            try {
                Bundle k10 = k(str);
                k10.putString("3_method", str2);
                this.f20509a.g(str3, k10);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void f(String str, Map map, LoginClient.Result.b bVar, Map map2, Exception exc, String str2) {
        JSONObject jSONObject;
        if (!v5.a.d(this)) {
            try {
                Bundle k10 = k(str);
                if (bVar != null) {
                    k10.putString("2_result", bVar.a());
                }
                if (!(exc == null || exc.getMessage() == null)) {
                    k10.putString("5_error_message", exc.getMessage());
                }
                if (!map.isEmpty()) {
                    jSONObject = new JSONObject(map);
                } else {
                    jSONObject = null;
                }
                if (map2 != null) {
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    try {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObject.put((String) entry.getKey(), entry.getValue());
                        }
                    } catch (JSONException unused) {
                    }
                }
                if (jSONObject != null) {
                    k10.putString("6_extras", jSONObject.toString());
                }
                this.f20509a.g(str2, k10);
                if (bVar == LoginClient.Result.b.SUCCESS) {
                    g(str);
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.os.Bundle} */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|4|5|6|(1:8)|11|(1:13)|14|15|16|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0077 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(com.facebook.login.LoginClient.Request r6, java.lang.String r7) {
        /*
            r5 = this;
            boolean r0 = v5.a.d(r5)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r0 = r6.b()     // Catch:{ all -> 0x0059 }
            android.os.Bundle r0 = k(r0)     // Catch:{ all -> 0x0059 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0077 }
            r1.<init>()     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r2 = "login_behavior"
            com.facebook.login.e r3 = r6.g()     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0077 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r2 = "request_code"
            int r3 = com.facebook.login.LoginClient.p()     // Catch:{ JSONException -> 0x0077 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r2 = "permissions"
            java.lang.String r3 = ","
            java.util.Set r4 = r6.k()     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r3 = android.text.TextUtils.join(r3, r4)     // Catch:{ JSONException -> 0x0077 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r2 = "default_audience"
            com.facebook.login.b r3 = r6.d()     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0077 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r2 = "isReauthorize"
            boolean r3 = r6.p()     // Catch:{ JSONException -> 0x0077 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r2 = r5.f20511c     // Catch:{ JSONException -> 0x0077 }
            if (r2 == 0) goto L_0x005b
            java.lang.String r3 = "facebookVersion"
            r1.put(r3, r2)     // Catch:{ JSONException -> 0x0077 }
            goto L_0x005b
        L_0x0059:
            r6 = move-exception
            goto L_0x007e
        L_0x005b:
            com.facebook.login.k r2 = r6.h()     // Catch:{ JSONException -> 0x0077 }
            if (r2 == 0) goto L_0x006e
            java.lang.String r2 = "target_app"
            com.facebook.login.k r6 = r6.h()     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x0077 }
            r1.put(r2, r6)     // Catch:{ JSONException -> 0x0077 }
        L_0x006e:
            java.lang.String r6 = "6_extras"
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0077 }
            r0.putString(r6, r1)     // Catch:{ JSONException -> 0x0077 }
        L_0x0077:
            e2.m r6 = r5.f20509a     // Catch:{ all -> 0x0059 }
            r1 = 0
            r6.h(r7, r1, r0)     // Catch:{ all -> 0x0059 }
            return
        L_0x007e:
            v5.a.b(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.h.h(com.facebook.login.LoginClient$Request, java.lang.String):void");
    }

    public void i(String str, String str2) {
        if (!v5.a.d(this)) {
            try {
                j(str, str2, "");
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void j(String str, String str2, String str3) {
        if (!v5.a.d(this)) {
            try {
                Bundle k10 = k("");
                k10.putString("2_result", LoginClient.Result.b.ERROR.a());
                k10.putString("5_error_message", str2);
                k10.putString("3_method", str3);
                this.f20509a.g(str, k10);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }
}
