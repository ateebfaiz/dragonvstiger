package com.onesignal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.onesignal.g2;
import com.onesignal.o3;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class l0 {

    class a implements g2.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f10748a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f10749b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f10750c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f10751d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f10752e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f10753f;

        a(boolean z10, JSONObject jSONObject, Context context, int i10, String str, long j10) {
            this.f10748a = z10;
            this.f10749b = jSONObject;
            this.f10750c = context;
            this.f10751d = i10;
            this.f10752e = str;
            this.f10753f = j10;
        }

        public void a(boolean z10) {
            if (this.f10748a || !z10) {
                OSNotificationWorkManager.b(this.f10750c, h2.b(this.f10749b), this.f10751d, this.f10752e, this.f10753f, this.f10748a, false);
                if (this.f10748a) {
                    OSUtils.V(100);
                }
            }
        }
    }

    class b implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f10754a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f10755b;

        b(f fVar, e eVar) {
            this.f10754a = fVar;
            this.f10755b = eVar;
        }

        public void a(boolean z10) {
            if (!z10) {
                this.f10754a.d(true);
            }
            this.f10755b.a(this.f10754a);
        }
    }

    class c implements g2.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f10756a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f10757b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Bundle f10758c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d f10759d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ JSONObject f10760e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f10761f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f10762g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ f f10763h;

        c(boolean z10, Context context, Bundle bundle, d dVar, JSONObject jSONObject, long j10, boolean z11, f fVar) {
            this.f10756a = z10;
            this.f10757b = context;
            this.f10758c = bundle;
            this.f10759d = dVar;
            this.f10760e = jSONObject;
            this.f10761f = j10;
            this.f10762g = z11;
            this.f10763h = fVar;
        }

        public void a(boolean z10) {
            int i10 = 0;
            if (this.f10756a || !z10) {
                String b10 = h2.b(this.f10760e);
                if (this.f10758c.containsKey("android_notif_id")) {
                    i10 = this.f10758c.getInt("android_notif_id");
                }
                OSNotificationWorkManager.b(this.f10757b, b10, i10, this.f10760e.toString(), this.f10761f, this.f10756a, this.f10762g);
                this.f10763h.g(true);
                this.f10759d.a(true);
                return;
            }
            o3.v vVar = o3.v.DEBUG;
            o3.a(vVar, "startNotificationProcessing returning, with context: " + this.f10757b + " and bundle: " + this.f10758c);
            this.f10759d.a(false);
        }
    }

    interface d {
        void a(boolean z10);
    }

    interface e {
        void a(f fVar);
    }

    static class f {

        /* renamed from: a  reason: collision with root package name */
        private boolean f10764a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f10765b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10766c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f10767d;

        f() {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f10765b;
        }

        public boolean b() {
            return this.f10767d;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            if (!this.f10764a || this.f10765b || this.f10766c || this.f10767d) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z10) {
            this.f10765b = z10;
        }

        public void e(boolean z10) {
            this.f10766c = z10;
        }

        /* access modifiers changed from: package-private */
        public void f(boolean z10) {
            this.f10764a = z10;
        }

        public void g(boolean z10) {
            this.f10767d = z10;
        }
    }

    static JSONObject a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String next : bundle.keySet()) {
            try {
                jSONObject.put(next, bundle.get(next));
            } catch (JSONException e10) {
                o3.v vVar = o3.v.ERROR;
                o3.b(vVar, "bundleAsJSONObject error for key: " + next, e10);
            }
        }
        return jSONObject;
    }

    static JSONObject b(JSONObject jSONObject) {
        return new JSONObject(jSONObject.optString("custom"));
    }

    static boolean c(Bundle bundle) {
        if (d(bundle, "licon") || d(bundle, "bicon") || bundle.getString("bg_img", (String) null) != null) {
            return true;
        }
        return false;
    }

    private static boolean d(Bundle bundle, String str) {
        String trim = bundle.getString(str, "").trim();
        if (trim.startsWith(com.alibaba.pdns.s.e.c.f18246k) || trim.startsWith(com.alibaba.pdns.s.e.c.f18247l)) {
            return true;
        }
        return false;
    }

    static void e(i2 i2Var) {
        if (i2Var.m()) {
            o3.a(o3.v.DEBUG, "Marking restored or disabled notifications as dismissed: " + i2Var.toString());
            v3 n10 = v3.n(i2Var.d());
            ContentValues contentValues = new ContentValues();
            contentValues.put("dismissed", 1);
            n10.a("notification", contentValues, "android_notification_id = " + i2Var.a(), (String[]) null);
            l.c(n10, i2Var.d());
        }
    }

    private static void f(Bundle bundle) {
        JSONObject jSONObject;
        String str;
        if (bundle.containsKey("o")) {
            try {
                JSONObject jSONObject2 = new JSONObject(bundle.getString("custom"));
                if (jSONObject2.has("a")) {
                    jSONObject = jSONObject2.getJSONObject("a");
                } else {
                    jSONObject = new JSONObject();
                }
                JSONArray jSONArray = new JSONArray(bundle.getString("o"));
                bundle.remove("o");
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i10);
                    String string = jSONObject3.getString("n");
                    jSONObject3.remove("n");
                    if (jSONObject3.has("i")) {
                        str = jSONObject3.getString("i");
                        jSONObject3.remove("i");
                    } else {
                        str = string;
                    }
                    jSONObject3.put("id", str);
                    jSONObject3.put("text", string);
                    if (jSONObject3.has("p")) {
                        jSONObject3.put("icon", jSONObject3.getString("p"));
                        jSONObject3.remove("p");
                    }
                }
                jSONObject.put("actionButtons", jSONArray);
                jSONObject.put("actionId", "__DEFAULT__");
                if (!jSONObject2.has("a")) {
                    jSONObject2.put("a", jSONObject);
                }
                bundle.putString("custom", jSONObject2.toString());
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
    }

    static JSONArray g(JSONObject jSONObject) {
        return new JSONArray().put(jSONObject);
    }

    static void h(Context context, Bundle bundle, e eVar) {
        f fVar = new f();
        if (!h2.d(bundle)) {
            eVar.a(fVar);
            return;
        }
        fVar.f(true);
        f(bundle);
        if (u1.c(context, bundle)) {
            fVar.e(true);
            eVar.a(fVar);
            return;
        }
        q(context, bundle, fVar, new b(fVar, eVar));
    }

    private static void i(i2 i2Var) {
        if (!i2Var.n() && i2Var.e().has(Constants.MessagePayloadKeys.COLLAPSE_KEY) && !"do_not_collapse".equals(i2Var.e().optString(Constants.MessagePayloadKeys.COLLAPSE_KEY))) {
            Cursor h10 = v3.n(i2Var.d()).h("notification", new String[]{"android_notification_id"}, "collapse_id = ? AND dismissed = 0 AND opened = 0 ", new String[]{i2Var.e().optString(Constants.MessagePayloadKeys.COLLAPSE_KEY)}, (String) null, (String) null, (String) null);
            if (h10.moveToFirst()) {
                i2Var.f().r(h10.getInt(h10.getColumnIndex("android_notification_id")));
            }
            h10.close();
        }
    }

    static void j(Context context, m mVar) {
        int i10;
        o3.L0(context);
        try {
            String string = mVar.getString("json_payload");
            if (string == null) {
                o3.a(o3.v.ERROR, "json_payload key is nonexistent from mBundle passed to ProcessFromFCMIntentService: " + mVar);
                return;
            }
            JSONObject jSONObject = new JSONObject(string);
            boolean a10 = mVar.a("is_restoring", false);
            long longValue = mVar.getLong("timestamp").longValue();
            if (mVar.c("android_notif_id")) {
                i10 = mVar.getInt("android_notif_id").intValue();
            } else {
                i10 = 0;
            }
            o3.W0(context, jSONObject, new a(a10, jSONObject, context, i10, string, longValue));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    static int k(f2 f2Var, boolean z10) {
        return l(f2Var, false, z10);
    }

    private static int l(f2 f2Var, boolean z10, boolean z11) {
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "Starting processJobForDisplay opened: " + z10 + " fromBackgroundLogic: " + z11);
        i2 b10 = f2Var.b();
        i(b10);
        int intValue = b10.a().intValue();
        boolean z12 = false;
        if (p(b10)) {
            b10.p(true);
            if (!z11 || !o3.J1(b10)) {
                z12 = v.n(b10);
            } else {
                f2Var.g(false);
                o3.J(f2Var);
                return intValue;
            }
        }
        if (!b10.n()) {
            n(b10, z10, z12);
            OSNotificationWorkManager.c(h2.b(f2Var.b().e()));
            o3.F0(b10);
        }
        return intValue;
    }

    static int m(i2 i2Var, boolean z10) {
        return l(new f2(i2Var, i2Var.n(), true), false, z10);
    }

    static void n(i2 i2Var, boolean z10, boolean z11) {
        o(i2Var, z10);
        if (!z11) {
            e(i2Var);
            return;
        }
        String b10 = i2Var.b();
        OSReceiveReceiptController.c().a(i2Var.d(), b10);
        o3.s0().l(b10);
    }

    private static void o(i2 i2Var, boolean z10) {
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "Saving Notification job: " + i2Var.toString());
        Context d10 = i2Var.d();
        JSONObject e10 = i2Var.e();
        try {
            JSONObject b10 = b(i2Var.e());
            v3 n10 = v3.n(i2Var.d());
            if (i2Var.m()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("dismissed", 1);
                n10.a("notification", contentValues, "android_notification_id = " + i2Var.a(), (String[]) null);
                l.c(n10, d10);
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("notification_id", b10.optString("i"));
            if (e10.has("grp")) {
                contentValues2.put(FirebaseAnalytics.Param.GROUP_ID, e10.optString("grp"));
            }
            if (e10.has(Constants.MessagePayloadKeys.COLLAPSE_KEY) && !"do_not_collapse".equals(e10.optString(Constants.MessagePayloadKeys.COLLAPSE_KEY))) {
                contentValues2.put("collapse_id", e10.optString(Constants.MessagePayloadKeys.COLLAPSE_KEY));
            }
            contentValues2.put("opened", Integer.valueOf(z10 ? 1 : 0));
            if (!z10) {
                contentValues2.put("android_notification_id", i2Var.a());
            }
            if (i2Var.k() != null) {
                contentValues2.put("title", i2Var.k().toString());
            }
            if (i2Var.c() != null) {
                contentValues2.put("message", i2Var.c().toString());
            }
            contentValues2.put("expire_time", Long.valueOf((e10.optLong(Constants.MessagePayloadKeys.SENT_TIME, o3.w0().b()) / 1000) + ((long) e10.optInt(Constants.MessagePayloadKeys.TTL, 259200))));
            contentValues2.put("full_data", e10.toString());
            n10.w("notification", (String) null, contentValues2);
            o3.a(vVar, "Notification saved values: " + contentValues2.toString());
            if (!z10) {
                l.c(n10, d10);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    private static boolean p(i2 i2Var) {
        if (i2Var.l() || OSUtils.I(i2Var.e().optString("alert"))) {
            return true;
        }
        return false;
    }

    private static void q(Context context, Bundle bundle, f fVar, d dVar) {
        boolean z10;
        JSONObject a10 = a(bundle);
        long b10 = o3.w0().b() / 1000;
        boolean z11 = bundle.getBoolean("is_restoring", false);
        if (Integer.parseInt(bundle.getString("pri", "0")) > 9) {
            z10 = true;
        } else {
            z10 = false;
        }
        o3.W0(context, a10, new c(z11, context, bundle, dVar, a10, b10, z10, fVar));
    }
}
