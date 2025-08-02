package com.onesignal;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.onesignal.b4;
import com.onesignal.o3;
import com.zing.zalo.zalosdk.common.Constant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a4 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static int f10348a;

    class a extends b4.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10349a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f10350b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f10351c;

        /* renamed from: com.onesignal.a4$a$a  reason: collision with other inner class name */
        class C0125a implements Runnable {
            C0125a() {
            }

            public void run() {
                int a10 = (a4.f10348a * 10000) + 30000;
                if (a10 > 90000) {
                    a10 = 90000;
                }
                o3.a(o3.v.INFO, "Failed to get Android parameters, trying again in " + (a10 / 1000) + " seconds.");
                try {
                    Thread.sleep((long) a10);
                    a4.b();
                    a aVar = a.this;
                    a4.e(aVar.f10349a, aVar.f10350b, aVar.f10351c);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
        }

        a(String str, String str2, c cVar) {
            this.f10349a = str;
            this.f10350b = str2;
            this.f10351c = cVar;
        }

        /* access modifiers changed from: package-private */
        public void a(int i10, String str, Throwable th) {
            if (i10 == 403) {
                o3.a(o3.v.FATAL, "403 error getting OneSignal params, omitting further retries!");
            } else {
                new Thread(new C0125a(), "OS_PARAMS_REQUEST").start();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(String str) {
            a4.f(str, this.f10351c);
        }
    }

    class b extends f {

        /* renamed from: p  reason: collision with root package name */
        final /* synthetic */ JSONObject f10353p;

        b(JSONObject jSONObject) {
            Boolean bool;
            Boolean bool2;
            Boolean bool3;
            Boolean bool4;
            this.f10353p = jSONObject;
            this.f10366b = jSONObject.optBoolean("enterp", false);
            this.f10367c = jSONObject.optBoolean("require_email_auth", false);
            this.f10368d = jSONObject.optBoolean("require_user_id_auth", false);
            this.f10369e = jSONObject.optJSONArray("chnl_lst");
            this.f10370f = jSONObject.optBoolean("fba", false);
            this.f10371g = jSONObject.optBoolean("restore_ttl_filter", true);
            this.f10365a = jSONObject.optString("android_sender_id", (String) null);
            this.f10372h = jSONObject.optBoolean("clear_group_on_summary_click", true);
            this.f10373i = jSONObject.optBoolean("receive_receipts_enable", false);
            if (!jSONObject.has("disable_gms_missing_prompt")) {
                bool = null;
            } else {
                bool = Boolean.valueOf(jSONObject.optBoolean("disable_gms_missing_prompt", false));
            }
            this.f10374j = bool;
            if (!jSONObject.has("unsubscribe_on_notifications_disabled")) {
                bool2 = null;
            } else {
                bool2 = Boolean.valueOf(jSONObject.optBoolean("unsubscribe_on_notifications_disabled", true));
            }
            this.f10375k = bool2;
            if (!jSONObject.has("location_shared")) {
                bool3 = null;
            } else {
                bool3 = Boolean.valueOf(jSONObject.optBoolean("location_shared", true));
            }
            this.f10376l = bool3;
            if (!jSONObject.has("requires_user_privacy_consent")) {
                bool4 = null;
            } else {
                bool4 = Boolean.valueOf(jSONObject.optBoolean("requires_user_privacy_consent", false));
            }
            this.f10377m = bool4;
            this.f10378n = new e();
            if (jSONObject.has("outcomes")) {
                a4.g(jSONObject.optJSONObject("outcomes"), this.f10378n);
            }
            this.f10379o = new d();
            if (jSONObject.has("fcm")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("fcm");
                this.f10379o.f10356c = optJSONObject.optString("api_key", (String) null);
                this.f10379o.f10355b = optJSONObject.optString(Constant.PARAM_APP_ID, (String) null);
                this.f10379o.f10354a = optJSONObject.optString("project_id", (String) null);
            }
        }
    }

    interface c {
        void a(f fVar);
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        String f10354a;

        /* renamed from: b  reason: collision with root package name */
        String f10355b;

        /* renamed from: c  reason: collision with root package name */
        String f10356c;

        d() {
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        int f10357a = 1440;

        /* renamed from: b  reason: collision with root package name */
        int f10358b = 10;

        /* renamed from: c  reason: collision with root package name */
        int f10359c = 1440;

        /* renamed from: d  reason: collision with root package name */
        int f10360d = 10;

        /* renamed from: e  reason: collision with root package name */
        boolean f10361e = false;

        /* renamed from: f  reason: collision with root package name */
        boolean f10362f = false;

        /* renamed from: g  reason: collision with root package name */
        boolean f10363g = false;

        /* renamed from: h  reason: collision with root package name */
        boolean f10364h = false;

        public int a() {
            return this.f10360d;
        }

        public int b() {
            return this.f10359c;
        }

        public int c() {
            return this.f10357a;
        }

        public int d() {
            return this.f10358b;
        }

        public boolean e() {
            return this.f10361e;
        }

        public boolean f() {
            return this.f10362f;
        }

        public boolean g() {
            return this.f10363g;
        }

        public String toString() {
            return "InfluenceParams{indirectNotificationAttributionWindow=" + this.f10357a + ", notificationLimit=" + this.f10358b + ", indirectIAMAttributionWindow=" + this.f10359c + ", iamLimit=" + this.f10360d + ", directEnabled=" + this.f10361e + ", indirectEnabled=" + this.f10362f + ", unattributedEnabled=" + this.f10363g + '}';
        }
    }

    static class f {

        /* renamed from: a  reason: collision with root package name */
        String f10365a;

        /* renamed from: b  reason: collision with root package name */
        boolean f10366b;

        /* renamed from: c  reason: collision with root package name */
        boolean f10367c;

        /* renamed from: d  reason: collision with root package name */
        boolean f10368d;

        /* renamed from: e  reason: collision with root package name */
        JSONArray f10369e;

        /* renamed from: f  reason: collision with root package name */
        boolean f10370f;

        /* renamed from: g  reason: collision with root package name */
        boolean f10371g;

        /* renamed from: h  reason: collision with root package name */
        boolean f10372h;

        /* renamed from: i  reason: collision with root package name */
        boolean f10373i;

        /* renamed from: j  reason: collision with root package name */
        Boolean f10374j;

        /* renamed from: k  reason: collision with root package name */
        Boolean f10375k;

        /* renamed from: l  reason: collision with root package name */
        Boolean f10376l;

        /* renamed from: m  reason: collision with root package name */
        Boolean f10377m;

        /* renamed from: n  reason: collision with root package name */
        e f10378n;

        /* renamed from: o  reason: collision with root package name */
        d f10379o;

        f() {
        }
    }

    static /* synthetic */ int b() {
        int i10 = f10348a;
        f10348a = i10 + 1;
        return i10;
    }

    static void e(String str, String str2, c cVar) {
        a aVar = new a(str, str2, cVar);
        String str3 = "apps/" + str + "/android_params.js";
        if (str2 != null) {
            str3 = str3 + "?player_id=" + str2;
        }
        o3.a(o3.v.DEBUG, "Starting request to get Android parameters.");
        b4.e(str3, aVar, "CACHE_KEY_REMOTE_PARAMS");
    }

    /* access modifiers changed from: private */
    public static void f(String str, c cVar) {
        try {
            cVar.a(new b(new JSONObject(str)));
        } catch (NullPointerException | JSONException e10) {
            o3.v vVar = o3.v.FATAL;
            o3.b(vVar, "Error parsing android_params!: ", e10);
            o3.a(vVar, "Response that errored from android_params!: " + str);
        }
    }

    /* access modifiers changed from: private */
    public static void g(JSONObject jSONObject, e eVar) {
        if (jSONObject.has("v2_enabled")) {
            eVar.f10364h = jSONObject.optBoolean("v2_enabled");
        }
        if (jSONObject.has(DevicePublicKeyStringDef.DIRECT)) {
            eVar.f10361e = jSONObject.optJSONObject(DevicePublicKeyStringDef.DIRECT).optBoolean("enabled");
        }
        if (jSONObject.has(DevicePublicKeyStringDef.INDIRECT)) {
            JSONObject optJSONObject = jSONObject.optJSONObject(DevicePublicKeyStringDef.INDIRECT);
            eVar.f10362f = optJSONObject.optBoolean("enabled");
            if (optJSONObject.has("notification_attribution")) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("notification_attribution");
                eVar.f10357a = optJSONObject2.optInt("minutes_since_displayed", 1440);
                eVar.f10358b = optJSONObject2.optInt("limit", 10);
            }
            if (optJSONObject.has("in_app_message_attribution")) {
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("in_app_message_attribution");
                eVar.f10359c = optJSONObject3.optInt("minutes_since_displayed", 1440);
                eVar.f10360d = optJSONObject3.optInt("limit", 10);
            }
        }
        if (jSONObject.has("unattributed")) {
            eVar.f10363g = jSONObject.optJSONObject("unattributed").optBoolean("enabled");
        }
    }
}
