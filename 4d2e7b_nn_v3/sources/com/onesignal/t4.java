package com.onesignal;

import com.adjust.sdk.Constants;
import com.onesignal.h0;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

abstract class t4 {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f11068d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f11069e;

    /* renamed from: f  reason: collision with root package name */
    private static final Set f11070f;

    /* renamed from: a  reason: collision with root package name */
    private String f11071a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f11072b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f11073c;

    static {
        String[] strArr = {"lat", Constants.LONG, "loc_acc", "loc_type", "loc_bg", "loc_time_stamp"};
        f11069e = strArr;
        f11070f = new HashSet(Arrays.asList(strArr));
    }

    t4(String str, boolean z10) {
        this.f11071a = str;
        if (z10) {
            n();
            return;
        }
        this.f11072b = new JSONObject();
        this.f11073c = new JSONObject();
    }

    private static JSONObject e(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set set) {
        JSONObject b10;
        synchronized (f11068d) {
            b10 = f0.b(jSONObject, jSONObject2, jSONObject3, set);
        }
        return b10;
    }

    private Set k(t4 t4Var) {
        try {
            if (this.f11072b.optLong("loc_time_stamp") == t4Var.f11072b.getLong("loc_time_stamp")) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("loc_bg", t4Var.f11072b.opt("loc_bg"));
            hashMap.put("loc_time_stamp", t4Var.f11072b.opt("loc_time_stamp"));
            u(t4Var.f11073c, hashMap);
            return f11070f;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void n() {
        int i10;
        boolean z10;
        String str = z3.f11153a;
        String f10 = z3.f(str, "ONESIGNAL_USERSTATE_DEPENDVALYES_" + this.f11071a, (String) null);
        if (f10 == null) {
            x(new JSONObject());
            try {
                int i11 = 1;
                if (this.f11071a.equals("CURRENT_STATE")) {
                    i10 = z3.c(str, "ONESIGNAL_SUBSCRIPTION", 1);
                } else {
                    i10 = z3.c(str, "ONESIGNAL_SYNCED_SUBSCRIPTION", 1);
                }
                if (i10 == -2) {
                    z10 = false;
                } else {
                    i11 = i10;
                    z10 = true;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("subscribableStatus", Integer.valueOf(i11));
                hashMap.put("userSubscribePref", Boolean.valueOf(z10));
                u(this.f11072b, hashMap);
            } catch (JSONException unused) {
            }
        } else {
            try {
                x(new JSONObject(f10));
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        String str2 = z3.f11153a;
        String f11 = z3.f(str2, "ONESIGNAL_USERSTATE_SYNCVALYES_" + this.f11071a, (String) null);
        JSONObject jSONObject = new JSONObject();
        if (f11 == null) {
            try {
                jSONObject.put("identifier", z3.f(str2, "GT_REGISTRATION_ID", (String) null));
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        } else {
            jSONObject = new JSONObject(f11);
        }
        z(jSONObject);
    }

    private void u(JSONObject jSONObject, HashMap hashMap) {
        synchronized (f11068d) {
            try {
                for (Map.Entry entry : hashMap.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: package-private */
    public void b() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("lat", (Object) null);
            hashMap.put(Constants.LONG, (Object) null);
            hashMap.put("loc_acc", (Object) null);
            hashMap.put("loc_type", (Object) null);
            hashMap.put("loc_bg", (Object) null);
            hashMap.put("loc_time_stamp", (Object) null);
            u(this.f11073c, hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("loc_bg", (Object) null);
            hashMap2.put("loc_time_stamp", (Object) null);
            u(this.f11072b, hashMap2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public t4 c(String str) {
        t4 p10 = p(str);
        try {
            p10.f11072b = j();
            p10.f11073c = m();
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return p10;
    }

    /* access modifiers changed from: package-private */
    public JSONObject d(t4 t4Var, boolean z10) {
        a();
        t4Var.a();
        JSONObject e10 = e(this.f11073c, t4Var.f11073c, (JSONObject) null, k(t4Var));
        if (!z10 && e10.toString().equals("{}")) {
            return null;
        }
        try {
            if (!e10.has(Constant.PARAM_APP_ID)) {
                e10.put(Constant.PARAM_APP_ID, this.f11073c.optString(Constant.PARAM_APP_ID));
            }
            if (this.f11073c.has("email_auth_hash")) {
                e10.put("email_auth_hash", this.f11073c.optString("email_auth_hash"));
            }
            if (this.f11073c.has("sms_auth_hash")) {
                e10.put("sms_auth_hash", this.f11073c.optString("sms_auth_hash"));
            }
            if (this.f11073c.has("external_user_id_auth_hash") && !e10.has("external_user_id_auth_hash")) {
                e10.put("external_user_id_auth_hash", this.f11073c.optString("external_user_id_auth_hash"));
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return e10;
    }

    /* access modifiers changed from: package-private */
    public JSONObject f(t4 t4Var, Set set) {
        JSONObject b10;
        synchronized (f11068d) {
            b10 = f0.b(this.f11072b, t4Var.f11072b, (JSONObject) null, set);
        }
        return b10;
    }

    /* access modifiers changed from: package-private */
    public JSONObject g(JSONObject jSONObject, Set set) {
        JSONObject b10;
        synchronized (f11068d) {
            JSONObject jSONObject2 = this.f11072b;
            b10 = f0.b(jSONObject2, jSONObject, jSONObject2, set);
        }
        return b10;
    }

    /* access modifiers changed from: package-private */
    public JSONObject h(JSONObject jSONObject, Set set) {
        JSONObject b10;
        synchronized (f11068d) {
            JSONObject jSONObject2 = this.f11073c;
            b10 = f0.b(jSONObject2, jSONObject, jSONObject2, set);
        }
        return b10;
    }

    public c0 i() {
        try {
            return new c0(j());
        } catch (JSONException e10) {
            e10.printStackTrace();
            return new c0();
        }
    }

    /* access modifiers changed from: package-private */
    public JSONObject j() {
        JSONObject jSONObject;
        synchronized (f11068d) {
            jSONObject = new JSONObject(this.f11072b.toString());
        }
        return jSONObject;
    }

    public c0 l() {
        try {
            return new c0(m());
        } catch (JSONException e10) {
            e10.printStackTrace();
            return new c0();
        }
    }

    public JSONObject m() {
        JSONObject jSONObject;
        synchronized (f11068d) {
            jSONObject = new JSONObject(this.f11073c.toString());
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o(org.json.JSONObject r6, org.json.JSONObject r7) {
        /*
            r5 = this;
            java.lang.String r0 = "tags"
            boolean r0 = r6.has(r0)
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            org.json.JSONObject r0 = r5.m()     // Catch:{ JSONException -> 0x0027 }
            java.lang.String r1 = "tags"
            boolean r1 = r0.has(r1)     // Catch:{ JSONException -> 0x0027 }
            if (r1 == 0) goto L_0x0029
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0021 }
            java.lang.String r2 = "tags"
            java.lang.String r0 = r0.optString(r2)     // Catch:{ JSONException -> 0x0021 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x0021 }
            goto L_0x002e
        L_0x0021:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0027 }
            r1.<init>()     // Catch:{ JSONException -> 0x0027 }
            goto L_0x002e
        L_0x0027:
            r6 = move-exception
            goto L_0x0088
        L_0x0029:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0027 }
            r1.<init>()     // Catch:{ JSONException -> 0x0027 }
        L_0x002e:
            java.lang.String r0 = "tags"
            org.json.JSONObject r6 = r6.optJSONObject(r0)     // Catch:{ JSONException -> 0x0027 }
            java.util.Iterator r0 = r6.keys()     // Catch:{ JSONException -> 0x0027 }
        L_0x0038:
            boolean r2 = r0.hasNext()     // Catch:{ JSONException -> 0x0027 }
            if (r2 == 0) goto L_0x0064
            java.lang.Object r2 = r0.next()     // Catch:{ JSONException -> 0x0027 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x0027 }
            java.lang.String r3 = ""
            java.lang.String r4 = r6.optString(r2)     // Catch:{ JSONException -> 0x0027 }
            boolean r3 = r3.equals(r4)     // Catch:{ JSONException -> 0x0027 }
            if (r3 == 0) goto L_0x0054
            r1.remove(r2)     // Catch:{ JSONException -> 0x0027 }
            goto L_0x0038
        L_0x0054:
            if (r7 == 0) goto L_0x005c
            boolean r3 = r7.has(r2)     // Catch:{ JSONException -> 0x0027 }
            if (r3 != 0) goto L_0x0038
        L_0x005c:
            java.lang.String r3 = r6.optString(r2)     // Catch:{ JSONException -> 0x0027 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0027 }
            goto L_0x0038
        L_0x0064:
            java.lang.Object r6 = f11068d     // Catch:{ JSONException -> 0x0027 }
            monitor-enter(r6)     // Catch:{ JSONException -> 0x0027 }
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x007b }
            java.lang.String r0 = "{}"
            boolean r7 = r7.equals(r0)     // Catch:{ all -> 0x007b }
            if (r7 == 0) goto L_0x007d
            org.json.JSONObject r7 = r5.f11073c     // Catch:{ all -> 0x007b }
            java.lang.String r0 = "tags"
            r7.remove(r0)     // Catch:{ all -> 0x007b }
            goto L_0x0084
        L_0x007b:
            r7 = move-exception
            goto L_0x0086
        L_0x007d:
            org.json.JSONObject r7 = r5.f11073c     // Catch:{ all -> 0x007b }
            java.lang.String r0 = "tags"
            r7.put(r0, r1)     // Catch:{ all -> 0x007b }
        L_0x0084:
            monitor-exit(r6)     // Catch:{ all -> 0x007b }
            goto L_0x008b
        L_0x0086:
            monitor-exit(r6)     // Catch:{ all -> 0x007b }
            throw r7     // Catch:{ JSONException -> 0x0027 }
        L_0x0088:
            r6.printStackTrace()
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.t4.o(org.json.JSONObject, org.json.JSONObject):void");
    }

    /* access modifiers changed from: package-private */
    public abstract t4 p(String str);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        if (r4.f11073c.has("external_user_id") == false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q() {
        /*
            r4 = this;
            java.lang.Object r0 = f11068d
            monitor-enter(r0)
            org.json.JSONObject r1 = r4.f11073c     // Catch:{ JSONException -> 0x002a }
            java.lang.String r2 = "external_user_id_auth_hash"
            boolean r1 = r1.has(r2)     // Catch:{ JSONException -> 0x002a }
            if (r1 == 0) goto L_0x0041
            org.json.JSONObject r1 = r4.f11073c     // Catch:{ JSONException -> 0x002a }
            java.lang.String r2 = "external_user_id"
            boolean r1 = r1.has(r2)     // Catch:{ JSONException -> 0x002a }
            if (r1 == 0) goto L_0x002c
            org.json.JSONObject r1 = r4.f11073c     // Catch:{ JSONException -> 0x002a }
            java.lang.String r2 = "external_user_id"
            java.lang.Object r1 = r1.get(r2)     // Catch:{ JSONException -> 0x002a }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x002a }
            java.lang.String r2 = ""
            if (r1 == r2) goto L_0x0036
            goto L_0x002c
        L_0x0028:
            r1 = move-exception
            goto L_0x007d
        L_0x002a:
            r1 = move-exception
            goto L_0x003e
        L_0x002c:
            org.json.JSONObject r1 = r4.f11073c     // Catch:{ JSONException -> 0x002a }
            java.lang.String r2 = "external_user_id"
            boolean r1 = r1.has(r2)     // Catch:{ JSONException -> 0x002a }
            if (r1 != 0) goto L_0x0041
        L_0x0036:
            org.json.JSONObject r1 = r4.f11073c     // Catch:{ JSONException -> 0x002a }
            java.lang.String r2 = "external_user_id_auth_hash"
            r1.remove(r2)     // Catch:{ JSONException -> 0x002a }
            goto L_0x0041
        L_0x003e:
            r1.printStackTrace()     // Catch:{ all -> 0x0028 }
        L_0x0041:
            java.lang.String r1 = com.onesignal.z3.f11153a     // Catch:{ all -> 0x0028 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
            r2.<init>()     // Catch:{ all -> 0x0028 }
            java.lang.String r3 = "ONESIGNAL_USERSTATE_SYNCVALYES_"
            r2.append(r3)     // Catch:{ all -> 0x0028 }
            java.lang.String r3 = r4.f11071a     // Catch:{ all -> 0x0028 }
            r2.append(r3)     // Catch:{ all -> 0x0028 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0028 }
            org.json.JSONObject r3 = r4.f11073c     // Catch:{ all -> 0x0028 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0028 }
            com.onesignal.z3.m(r1, r2, r3)     // Catch:{ all -> 0x0028 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
            r2.<init>()     // Catch:{ all -> 0x0028 }
            java.lang.String r3 = "ONESIGNAL_USERSTATE_DEPENDVALYES_"
            r2.append(r3)     // Catch:{ all -> 0x0028 }
            java.lang.String r3 = r4.f11071a     // Catch:{ all -> 0x0028 }
            r2.append(r3)     // Catch:{ all -> 0x0028 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0028 }
            org.json.JSONObject r3 = r4.f11072b     // Catch:{ all -> 0x0028 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0028 }
            com.onesignal.z3.m(r1, r2, r3)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x007d:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.t4.q():void");
    }

    /* access modifiers changed from: package-private */
    public void r(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            JSONObject jSONObject3 = this.f11072b;
            e(jSONObject3, jSONObject, jSONObject3, (Set) null);
        }
        if (jSONObject2 != null) {
            JSONObject jSONObject4 = this.f11073c;
            e(jSONObject4, jSONObject2, jSONObject4, (Set) null);
            o(jSONObject2, (JSONObject) null);
        }
        if (jSONObject != null || jSONObject2 != null) {
            q();
        }
    }

    /* access modifiers changed from: package-private */
    public void s(String str, Object obj) {
        synchronized (f11068d) {
            this.f11072b.put(str, obj);
        }
    }

    /* access modifiers changed from: package-private */
    public void t(String str, Object obj) {
        synchronized (f11068d) {
            this.f11073c.put(str, obj);
        }
    }

    public String toString() {
        return "UserState{persistKey='" + this.f11071a + '\'' + ", dependValues=" + this.f11072b + ", syncValues=" + this.f11073c + '}';
    }

    /* access modifiers changed from: package-private */
    public void v(String str) {
        synchronized (f11068d) {
            this.f11072b.remove(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void w(String str) {
        synchronized (f11068d) {
            this.f11073c.remove(str);
        }
    }

    public void x(JSONObject jSONObject) {
        synchronized (f11068d) {
            this.f11072b = jSONObject;
        }
    }

    /* access modifiers changed from: package-private */
    public void y(h0.d dVar) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("lat", dVar.f10658a);
            hashMap.put(Constants.LONG, dVar.f10659b);
            hashMap.put("loc_acc", dVar.f10660c);
            hashMap.put("loc_type", dVar.f10661d);
            u(this.f11073c, hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("loc_bg", dVar.f10662e);
            hashMap2.put("loc_time_stamp", dVar.f10663f);
            u(this.f11072b, hashMap2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    public void z(JSONObject jSONObject) {
        synchronized (f11068d) {
            this.f11073c = jSONObject;
        }
    }
}
