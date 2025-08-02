package h;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import h.a;
import h.e;
import h.g;
import h.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w.d;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f21774a = d.f("");

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static String c(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(DomExceptionUtils.SEPARATOR);
                if (split.length >= 2) {
                    int parseInt = Integer.parseInt(split[0]);
                    int parseInt2 = Integer.parseInt(split[1]);
                    if (parseInt < 0 || parseInt2 < -1 || (parseInt2 != -1 && parseInt > parseInt2)) {
                        return "0/-1";
                    }
                    return str;
                }
            }
        } catch (Exception unused) {
        }
        return "0/-1";
    }

    public static j.a p(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String c10 = c.c(jSONObject, "regular", true);
        int optInt = jSONObject.optInt("port", -1);
        int optInt2 = jSONObject.optInt("protocol", -1);
        int optInt3 = jSONObject.optInt("matchType", -1);
        int optInt4 = jSONObject.optInt(FirebaseAnalytics.Param.METHOD, -1);
        if (TextUtils.isEmpty(c10) || optInt <= 0 || !c.a(optInt2) || !c.p(optInt3) || !c.r(optInt4)) {
            return null;
        }
        return new j.a(c10, optInt, optInt2, optInt3, optInt4);
    }

    public final h a(JSONObject jSONObject) {
        List list;
        List list2;
        JSONArray optJSONArray = jSONObject.optJSONArray("pingHosts");
        if (optJSONArray != null) {
            list = i.d.d(optJSONArray);
        } else {
            list = null;
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("detectUrls");
        if (optJSONArray2 != null) {
            list2 = i.d.d(optJSONArray2);
        } else {
            list2 = null;
        }
        if (list == null && list2 == null) {
            return null;
        }
        return new h(list, list2);
    }

    public final a b(int i10, JSONObject jSONObject) {
        a.C0284a aVar = new a.C0284a(i10);
        if (jSONObject == null) {
            return new a(aVar);
        }
        int i11 = 3;
        int optInt = jSONObject.optInt("compressionPolicy", 3);
        if (c.k(optInt)) {
            i11 = optInt;
        }
        aVar.f21751b = i11;
        int i12 = 1;
        int optInt2 = jSONObject.optInt("compressionType", 1);
        if (c.l(optInt2)) {
            i12 = optInt2;
        }
        aVar.f21753d = i12;
        String str = "overs.relmahacc.com";
        String d10 = d(jSONObject, "cachePeerHost", str);
        if (!TextUtils.isEmpty(d10)) {
            str = d10;
        }
        aVar.f21752c = str;
        aVar.f21754e = jSONObject.optBoolean("forceGzip", false);
        aVar.f21755f = jSONObject.optBoolean("alwaysBackSource", false);
        String str2 = "";
        String d11 = d(jSONObject, "backupIP", str2);
        if (d11 != null) {
            str2 = d11;
        }
        aVar.f21756g = str2;
        int optInt3 = jSONObject.optInt("websocketProtocol", -1);
        int optInt4 = jSONObject.optInt("websocketPort", -1);
        if (!(optInt3 == -1 || !c.t(optInt3) || optInt4 == -1)) {
            aVar.f21757h = optInt3;
            aVar.f21759j = optInt4;
        }
        int optInt5 = jSONObject.optInt("httpProtocol", -1);
        int optInt6 = jSONObject.optInt("httpPort", -1);
        if (!(optInt5 == -1 || !c.m(optInt5) || optInt6 == -1)) {
            aVar.f21758i = optInt5;
            aVar.f21760k = optInt6;
        }
        return new a(aVar);
    }

    public String d(JSONObject jSONObject, String str, String str2) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, str2);
    }

    public final List e(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            j.a p10 = p(jSONArray.optJSONObject(i10));
            if (p10 != null) {
                arrayList.add(p10);
            }
        }
        return arrayList;
    }

    public final void f(JSONArray jSONArray, g.a aVar) {
        ArrayList arrayList = new ArrayList();
        b bVar = null;
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            b h10 = h(jSONArray.optJSONObject(i10));
            if (h10 != null) {
                arrayList.add(h10);
                if (TextUtils.equals(h10.f21761a, "au.relauservice.com")) {
                    bVar = h10;
                }
            }
        }
        if (bVar != null) {
            TextUtils.join(",", bVar.f21763c);
        }
        aVar.d(arrayList);
    }

    public final void g(JSONObject jSONObject, g.a aVar) {
        if (jSONObject != null) {
            String string = jSONObject.getString("reportUrl");
            int i10 = jSONObject.getInt("num");
            int i11 = jSONObject.getInt("totalNum");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("sampleFrequency");
                int i12 = jSONObject2.getInt("frequency");
                int i13 = jSONObject2.getInt("base");
                if (i12 != 1 || 1 > i13 || i13 > 50) {
                    throw new a("Invalid log sample policy: " + jSONObject2 + ", should frequency:[1], base:[1,50]");
                }
                aVar.b(new e(i10, i11, string, new e.a(i12, i13)));
                return;
            }
            throw new a("Invalid log policy, empty reportUrl: " + jSONObject);
        }
        throw new JSONException("Log policy JSONObject can't be null");
    }

    public final b h(JSONObject jSONObject) {
        String[] strArr;
        if (jSONObject == null) {
            return null;
        }
        boolean optBoolean = jSONObject.optBoolean("cname", false);
        String d10 = d(jSONObject, "domain", "");
        try {
            strArr = i.d.c(jSONObject.optJSONArray("bypassIps"));
        } catch (JSONException unused) {
            strArr = null;
        }
        if (TextUtils.isEmpty(d10)) {
            return null;
        }
        return new b(d10, optBoolean, strArr);
    }

    public final void i(JSONObject jSONObject, g.a aVar) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("multiplatforms")) != null && optJSONArray.length() != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                j n10 = n(optJSONArray.optJSONObject(i10));
                if (n10 != null) {
                    arrayList.add(n10);
                }
            }
            aVar.g(arrayList);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(64:0|1|2|(1:4)|7|(1:9)(1:10)|11|(1:13)|14|(1:16)(1:17)|18|(1:20)(1:21)|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|39|40|(1:42)|43|(1:45)|46|(3:48|(1:50)|51)|52|(3:54|(1:56)(1:57)|58)|59|(1:61)(1:62)|63|(1:65)|66|(1:68)|69|(1:71)|72|(1:74)|75|(1:77)(1:78)|79|(1:81)|82|(1:84)|85|(1:87)|88|(1:90)|91|(1:93)|94|(1:96)|97|(1:99)(1:100)|101|102) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0081 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h.g j(org.json.JSONObject r11) {
        /*
            r10 = this;
            java.lang.String r0 = "filteredUrlRegexType"
            java.lang.String r1 = "allowedUrlRegexType"
            java.lang.String r2 = ""
            h.g$a r3 = new h.g$a     // Catch:{ all -> 0x001d }
            r3.<init>()     // Catch:{ all -> 0x001d }
            r4 = 0
            r3.f21801a = r4     // Catch:{ all -> 0x001d }
            java.lang.String r5 = "contentMD5"
            java.lang.String r5 = h.c.c(r11, r5, r4)     // Catch:{ all -> 0x001d }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x001d }
            if (r6 != 0) goto L_0x0020
            r3.f21802b = r5     // Catch:{ all -> 0x001d }
            goto L_0x0020
        L_0x001d:
            r11 = move-exception
            goto L_0x0226
        L_0x0020:
            java.lang.String r5 = "expiredTime"
            r6 = 0
            long r8 = r11.optLong(r5, r6)     // Catch:{ all -> 0x001d }
            boolean r5 = h.c.e(r8)     // Catch:{ all -> 0x001d }
            if (r5 != 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r6 = r8
        L_0x0030:
            r3.f21812l = r6     // Catch:{ all -> 0x001d }
            java.lang.String r5 = "serviceType"
            int r5 = r11.optInt(r5, r4)     // Catch:{ all -> 0x001d }
            boolean r6 = h.c.u(r5)     // Catch:{ all -> 0x001d }
            if (r6 != 0) goto L_0x003f
            r5 = r4
        L_0x003f:
            r3.f21813m = r5     // Catch:{ all -> 0x001d }
            java.lang.String r5 = "showToast"
            boolean r5 = r11.optBoolean(r5, r4)     // Catch:{ all -> 0x001d }
            r3.f21808h = r5     // Catch:{ all -> 0x001d }
            java.lang.String r5 = "httpReadTimeout"
            r6 = -1
            int r5 = r11.optInt(r5, r6)     // Catch:{ all -> 0x001d }
            boolean r7 = h.c.o(r5)     // Catch:{ all -> 0x001d }
            if (r7 != 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r6 = r5
        L_0x0058:
            r3.f21815o = r6     // Catch:{ all -> 0x001d }
            java.lang.String r5 = "deleteExif"
            r6 = 1
            boolean r5 = r11.optBoolean(r5, r6)     // Catch:{ all -> 0x001d }
            r3.f21809i = r5     // Catch:{ all -> 0x001d }
            java.lang.String r5 = "enableServerPush"
            boolean r5 = r11.optBoolean(r5, r4)     // Catch:{ all -> 0x001d }
            r3.f21810j = r5     // Catch:{ all -> 0x001d }
            java.lang.String r5 = "packageSuffix"
            java.lang.String r5 = r10.d(r11, r5, r2)     // Catch:{ all -> 0x001d }
            if (r5 == 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r5 = r2
        L_0x0075:
            r3.A = r5     // Catch:{ all -> 0x001d }
            java.lang.String r5 = "logPolicy"
            org.json.JSONObject r5 = r11.optJSONObject(r5)     // Catch:{ Exception -> 0x0081 }
            r10.g(r5, r3)     // Catch:{ Exception -> 0x0081 }
            goto L_0x0088
        L_0x0081:
            h.e r5 = new h.e     // Catch:{ all -> 0x001d }
            r5.<init>()     // Catch:{ all -> 0x001d }
            r3.E = r5     // Catch:{ all -> 0x001d }
        L_0x0088:
            java.lang.String r5 = "enableIPDispatch"
            boolean r5 = r11.getBoolean(r5)     // Catch:{ JSONException -> 0x0090 }
            r3.f21811k = r5     // Catch:{ JSONException -> 0x0090 }
        L_0x0090:
            java.lang.String r5 = "optimizationPolicy"
            org.json.JSONObject r5 = r11.optJSONObject(r5)     // Catch:{ all -> 0x001d }
            r10.m(r5, r3)     // Catch:{ Exception -> 0x009c }
            r10.i(r5, r3)     // Catch:{ Exception -> 0x009c }
        L_0x009c:
            java.lang.String r5 = "allowedUrlRegex"
            java.lang.String r5 = h.c.c(r11, r5, r6)     // Catch:{ all -> 0x001d }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x001d }
            if (r7 != 0) goto L_0x00aa
            r3.f21821u = r5     // Catch:{ all -> 0x001d }
        L_0x00aa:
            java.lang.String r5 = "filteredUrlRegex"
            java.lang.String r5 = h.c.c(r11, r5, r6)     // Catch:{ all -> 0x001d }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x001d }
            if (r7 != 0) goto L_0x00b8
            r3.f21820t = r5     // Catch:{ all -> 0x001d }
        L_0x00b8:
            boolean r5 = r11.has(r1)     // Catch:{ all -> 0x001d }
            r7 = 2
            if (r5 == 0) goto L_0x00cc
            int r1 = r11.optInt(r1, r7)     // Catch:{ all -> 0x001d }
            boolean r5 = h.c.q(r1)     // Catch:{ all -> 0x001d }
            if (r5 != 0) goto L_0x00ca
            r1 = r7
        L_0x00ca:
            r3.f21818r = r1     // Catch:{ all -> 0x001d }
        L_0x00cc:
            boolean r1 = r11.has(r0)     // Catch:{ all -> 0x001d }
            if (r1 == 0) goto L_0x00e0
            int r0 = r11.optInt(r0, r7)     // Catch:{ all -> 0x001d }
            boolean r1 = h.c.q(r0)     // Catch:{ all -> 0x001d }
            if (r1 != 0) goto L_0x00dd
            goto L_0x00de
        L_0x00dd:
            r7 = r0
        L_0x00de:
            r3.f21817q = r7     // Catch:{ all -> 0x001d }
        L_0x00e0:
            java.lang.String r0 = "authKey"
            java.lang.String r0 = r10.d(r11, r0, r2)     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x00e9
            goto L_0x00ea
        L_0x00e9:
            r0 = r2
        L_0x00ea:
            r3.B = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "resizeRate"
            java.lang.String r0 = r11.optString(r0, r2)     // Catch:{ all -> 0x001d }
            r3.C = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "picUrlRegex"
            java.lang.String r0 = h.c.c(r11, r0, r6)     // Catch:{ all -> 0x001d }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x001d }
            if (r1 != 0) goto L_0x0102
            r3.f21824x = r0     // Catch:{ all -> 0x001d }
        L_0x0102:
            java.lang.String r0 = "resizeUrlRegex"
            java.lang.String r0 = h.c.c(r11, r0, r6)     // Catch:{ all -> 0x001d }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x001d }
            if (r1 != 0) goto L_0x0110
            r3.f21825y = r0     // Catch:{ all -> 0x001d }
        L_0x0110:
            java.lang.String r0 = "authInterval"
            r1 = 60
            int r0 = r11.optInt(r0, r1)     // Catch:{ all -> 0x001d }
            boolean r5 = h.c.d(r0)     // Catch:{ all -> 0x001d }
            if (r5 != 0) goto L_0x011f
            r0 = r1
        L_0x011f:
            r3.f21814n = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "antiAttackUrlRegex"
            java.lang.String r0 = h.c.c(r11, r0, r6)     // Catch:{ all -> 0x001d }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x001d }
            if (r5 == 0) goto L_0x012e
            r0 = r2
        L_0x012e:
            r3.D = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "enableSDK"
            boolean r0 = r11.optBoolean(r0, r6)     // Catch:{ all -> 0x001d }
            r3.f21803c = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "netChangeAuth"
            boolean r0 = r11.optBoolean(r0, r4)     // Catch:{ all -> 0x001d }
            r3.f21804d = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "serverPushCacheTime"
            int r0 = r11.optInt(r0, r1)     // Catch:{ all -> 0x001d }
            boolean r5 = h.c.s(r0)     // Catch:{ all -> 0x001d }
            if (r5 != 0) goto L_0x014d
            goto L_0x014e
        L_0x014d:
            r1 = r0
        L_0x014e:
            r3.f21819s = r1     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "netDiagnosisConfig"
            org.json.JSONObject r0 = r11.optJSONObject(r0)     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x015b
            r10.k(r0, r3)     // Catch:{ all -> 0x001d }
        L_0x015b:
            java.lang.String r0 = "antiHijackConfigs"
            org.json.JSONArray r0 = r11.optJSONArray(r0)     // Catch:{ all -> 0x001d }
            boolean r1 = i.d.b(r0)     // Catch:{ all -> 0x001d }
            if (r1 == 0) goto L_0x016a
            r10.f(r0, r3)     // Catch:{ all -> 0x001d }
        L_0x016a:
            java.lang.String r0 = "hijackCheckPolicy"
            org.json.JSONObject r0 = r11.optJSONObject(r0)     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0178
            h.d r0 = r10.l(r0)     // Catch:{ all -> 0x001d }
            r3.F = r0     // Catch:{ all -> 0x001d }
        L_0x0178:
            java.lang.String r0 = "debug"
            boolean r0 = r11.optBoolean(r0, r4)     // Catch:{ all -> 0x001d }
            r3.f21805e = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "accesslogToUser"
            boolean r0 = r11.optBoolean(r0, r4)     // Catch:{ all -> 0x001d }
            r3.f21806f = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "rejectUrlRegex"
            java.lang.String r0 = h.c.c(r11, r0, r6)     // Catch:{ all -> 0x001d }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x001d }
            if (r1 != 0) goto L_0x0196
            r3.f21822v = r0     // Catch:{ all -> 0x001d }
        L_0x0196:
            java.lang.String r0 = "passUrlRegex"
            java.lang.String r0 = h.c.c(r11, r0, r6)     // Catch:{ all -> 0x001d }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x001d }
            if (r1 != 0) goto L_0x01a4
            r3.f21823w = r0     // Catch:{ all -> 0x001d }
        L_0x01a4:
            java.lang.String r0 = "trustedSelfSignedCertRegex"
            java.lang.String r0 = h.c.c(r11, r0, r6)     // Catch:{ all -> 0x001d }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x001d }
            if (r1 != 0) goto L_0x01b2
            r3.f21826z = r0     // Catch:{ all -> 0x001d }
        L_0x01b2:
            java.lang.String r0 = "bypassDnsHijack"
            boolean r0 = r11.optBoolean(r0, r6)     // Catch:{ all -> 0x001d }
            r3.f21807g = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "nodeProbeConfig"
            org.json.JSONObject r0 = r11.optJSONObject(r0)     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x01c7
            h.i r0 = r10.o(r0)     // Catch:{ all -> 0x001d }
            goto L_0x01d2
        L_0x01c7:
            h.i r0 = new h.i     // Catch:{ all -> 0x001d }
            r1 = 1070386381(0x3fcccccd, float:1.6)
            r5 = 120(0x78, float:1.68E-43)
            r7 = 3
            r0.<init>(r7, r1, r5)     // Catch:{ all -> 0x001d }
        L_0x01d2:
            r3.G = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "exceptionWatch"
            boolean r0 = r11.optBoolean(r0, r6)     // Catch:{ all -> 0x001d }
            r3.M = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "logsSample"
            boolean r0 = r11.optBoolean(r0, r4)     // Catch:{ all -> 0x001d }
            r3.N = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "enableANRCheck"
            boolean r0 = r11.optBoolean(r0, r4)     // Catch:{ all -> 0x001d }
            r3.O = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "abnAccess"
            java.lang.String r0 = h.c.c(r11, r0, r4)     // Catch:{ all -> 0x001d }
            java.lang.String r0 = c(r0)     // Catch:{ all -> 0x001d }
            r3.P = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "DNSFresh"
            boolean r0 = r11.optBoolean(r0, r4)     // Catch:{ all -> 0x001d }
            r3.Q = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "authUrl"
            java.lang.String r0 = r11.optString(r0, r2)     // Catch:{ all -> 0x001d }
            r3.S = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "ipDispatchUrl"
            java.lang.String r0 = r11.optString(r0, r2)     // Catch:{ all -> 0x001d }
            r3.T = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "enableSwitchProtocol"
            boolean r0 = r11.optBoolean(r0, r4)     // Catch:{ all -> 0x001d }
            r3.U = r0     // Catch:{ all -> 0x001d }
            java.lang.String r0 = "disableSni"
            boolean r11 = r11.optBoolean(r0, r6)     // Catch:{ all -> 0x001d }
            r3.V = r11     // Catch:{ all -> 0x001d }
            h.g r11 = new h.g     // Catch:{ all -> 0x001d }
            r11.<init>(r3)     // Catch:{ all -> 0x001d }
            return r11
        L_0x0226:
            o.g r0 = o.g.a()
            r0.b(r11)
            r11 = 0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: h.f.j(org.json.JSONObject):h.g");
    }

    public final void k(JSONObject jSONObject, g.a aVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject("manual");
        if (optJSONObject != null) {
            aVar.f(a(optJSONObject));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("auto");
        if (optJSONObject2 != null) {
            aVar.c(a(optJSONObject2));
        }
    }

    public final d l(JSONObject jSONObject) {
        String[] strArr;
        int i10 = 30;
        int optInt = jSONObject.optInt("checkInterval", 30);
        if (c.n(optInt)) {
            i10 = optInt;
        }
        try {
            strArr = i.d.c(jSONObject.optJSONArray("domains"));
        } catch (JSONException unused) {
            strArr = null;
        }
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return new d(i10, strArr);
    }

    public final void m(JSONObject jSONObject, g.a aVar) {
        if (jSONObject != null) {
            SparseArray sparseArray = new SparseArray();
            a b10 = b(3, jSONObject.optJSONObject("_2g"));
            sparseArray.put(b10.f21744f, b10);
            a b11 = b(4, jSONObject.optJSONObject("_3g"));
            sparseArray.put(b11.f21744f, b11);
            a b12 = b(5, jSONObject.optJSONObject("_4g"));
            sparseArray.put(b12.f21744f, b12);
            a b13 = b(6, jSONObject.optJSONObject("_5g"));
            sparseArray.put(b13.f21744f, b13);
            a b14 = b(2, jSONObject.optJSONObject("wifi"));
            sparseArray.put(b14.f21744f, b14);
            aVar.a(sparseArray);
            return;
        }
        throw new JSONException("Optimize policy JSONObject can't be null");
    }

    public final j n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("billingType", 0);
        String d10 = d(jSONObject, "domain", "");
        String d11 = d(jSONObject, "prefix", "");
        String d12 = d(jSONObject, "backupIP", "");
        String d13 = d(jSONObject, "serverHost", "");
        List e10 = e(jSONObject.optJSONArray("regexList"));
        if (TextUtils.isEmpty(d10) || TextUtils.isEmpty(d11) || !c.i(optInt) || e10 == null || e10.isEmpty()) {
            return null;
        }
        return new j(d10, d11, optInt, d12, d13, e10);
    }

    public final i o(JSONObject jSONObject) {
        int i10 = 3;
        int optInt = jSONObject.optInt("domainNum", 3);
        float optDouble = (float) jSONObject.optDouble("initProbeTime", 1.600000023841858d);
        int i11 = 120;
        int optInt2 = jSONObject.optInt("maxProbeTime", 120);
        if (optInt >= 1 && optInt <= 100) {
            i10 = optInt;
        }
        if (optDouble < 1.0f || optDouble > 10.0f) {
            optDouble = 1.6f;
        }
        if (optInt2 >= 1 && optInt2 <= 3600) {
            i11 = optInt2;
        }
        return new i(i10, optDouble, i11);
    }
}
