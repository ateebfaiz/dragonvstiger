package com.alibaba.pdns.net;

import android.text.TextUtils;
import com.alibaba.pdns.DNSResolver;
import com.alibaba.pdns.f;
import com.alibaba.pdns.o;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18071a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static final String f18072b = "acl";

    /* renamed from: c  reason: collision with root package name */
    private static final String f18073c = "bz";

    /* renamed from: d  reason: collision with root package name */
    private static final String f18074d = "bd";

    /* renamed from: e  reason: collision with root package name */
    private static final String f18075e = "wz";

    /* renamed from: f  reason: collision with root package name */
    private static final String f18076f = "wd";

    /* renamed from: g  reason: collision with root package name */
    private static final String f18077g = "v";

    /* renamed from: h  reason: collision with root package name */
    private static final String f18078h = "ttl";

    /* renamed from: i  reason: collision with root package name */
    private static final String f18079i = "uhf";

    /* renamed from: j  reason: collision with root package name */
    private static final String f18080j = "d";

    public static void a(String str, String str2) {
        com.alibaba.pdns.u.a.a("conf接口的url:" + str);
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "")) {
            try {
                String a10 = d.a().a(str, str2);
                com.alibaba.pdns.u.a.a("获取配置信息请求返回的json:" + a10);
                if (!TextUtils.isEmpty(a10) && !TextUtils.equals("", a10)) {
                    JSONObject jSONObject = new JSONObject(a10);
                    if (jSONObject.has("d") && jSONObject.optInt("v") == f.f17929v) {
                        String optString = jSONObject.optString("d");
                        com.alibaba.pdns.u.a.a("配置信息接口返回的data:" + optString);
                        String a11 = o.a(DNSResolver.getAccessKeySecret(), optString);
                        com.alibaba.pdns.u.a.a("解密data数据的json:" + a11);
                        a(a11);
                    }
                }
            } catch (Error | Exception e10) {
                if (com.alibaba.pdns.u.a.f18279a) {
                    e10.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0124, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0135, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0129 A[Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058, all -> 0x0055 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void a(java.lang.String r9) {
        /*
            java.lang.Class<com.alibaba.pdns.net.a> r0 = com.alibaba.pdns.net.a.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r1 != 0) goto L_0x0123
            java.lang.String r1 = ""
            boolean r1 = android.text.TextUtils.equals(r1, r9)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r1 == 0) goto L_0x0013
            goto L_0x0123
        L_0x0013:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            r1.<init>(r9)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            java.lang.String r9 = "acl"
            boolean r9 = r1.has(r9)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r9 == 0) goto L_0x00ec
            java.lang.String r9 = "acl"
            org.json.JSONObject r9 = r1.optJSONObject(r9)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r9 == 0) goto L_0x00ec
            java.lang.String r2 = "bz"
            boolean r2 = r9.has(r2)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            r3 = 0
            if (r2 == 0) goto L_0x0063
            java.lang.String r2 = "bz"
            org.json.JSONArray r2 = r9.getJSONArray(r2)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            com.alibaba.pdns.q r4 = new com.alibaba.pdns.q     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            r4.<init>()     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r2 == 0) goto L_0x0061
            int r5 = r2.length()     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r5 <= 0) goto L_0x0061
            r5 = r3
        L_0x0045:
            int r6 = r2.length()     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r5 >= r6) goto L_0x0061
            java.lang.String r6 = r2.getString(r5)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            r4.a(r6)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            int r5 = r5 + 1
            goto L_0x0045
        L_0x0055:
            r9 = move-exception
            goto L_0x0136
        L_0x0058:
            r9 = move-exception
            goto L_0x0125
        L_0x005b:
            r9 = move-exception
            goto L_0x0125
        L_0x005e:
            r9 = move-exception
            goto L_0x012d
        L_0x0061:
            com.alibaba.pdns.f.T = r4     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
        L_0x0063:
            java.lang.String r2 = "bd"
            boolean r2 = r9.has(r2)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r2 == 0) goto L_0x0091
            java.lang.String r2 = "bd"
            org.json.JSONArray r2 = r9.getJSONArray(r2)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r2 == 0) goto L_0x0091
            java.util.Map<java.lang.String, java.lang.Integer> r4 = com.alibaba.pdns.f.R     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            r4.clear()     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            int r4 = r2.length()     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r4 <= 0) goto L_0x0091
            r5 = r3
        L_0x007f:
            if (r5 >= r4) goto L_0x0091
            java.lang.String r6 = r2.getString(r5)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            java.util.Map<java.lang.String, java.lang.Integer> r7 = com.alibaba.pdns.f.R     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            r7.put(r6, r8)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            int r5 = r5 + 1
            goto L_0x007f
        L_0x0091:
            java.lang.String r2 = "wz"
            boolean r2 = r9.has(r2)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r2 == 0) goto L_0x00bf
            java.lang.String r2 = "wz"
            org.json.JSONArray r2 = r9.getJSONArray(r2)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            com.alibaba.pdns.q r4 = new com.alibaba.pdns.q     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            r4.<init>()     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r2 == 0) goto L_0x00bd
            int r5 = r2.length()     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r5 <= 0) goto L_0x00bd
            r5 = r3
        L_0x00ad:
            int r6 = r2.length()     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r5 >= r6) goto L_0x00bd
            java.lang.String r6 = r2.getString(r5)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            r4.a(r6)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            int r5 = r5 + 1
            goto L_0x00ad
        L_0x00bd:
            com.alibaba.pdns.f.S = r4     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
        L_0x00bf:
            java.lang.String r2 = "wd"
            boolean r2 = r9.has(r2)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r2 == 0) goto L_0x00ec
            java.lang.String r2 = "wd"
            org.json.JSONArray r9 = r9.getJSONArray(r2)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r9 == 0) goto L_0x00ec
            java.util.Map<java.lang.String, java.lang.Integer> r2 = com.alibaba.pdns.f.Q     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            r2.clear()     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            int r2 = r9.length()     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r2 <= 0) goto L_0x00ec
        L_0x00da:
            if (r3 >= r2) goto L_0x00ec
            java.lang.String r4 = r9.getString(r3)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            java.util.Map<java.lang.String, java.lang.Integer> r5 = com.alibaba.pdns.f.Q     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            r5.put(r4, r6)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            int r3 = r3 + 1
            goto L_0x00da
        L_0x00ec:
            java.lang.String r9 = "v"
            boolean r9 = r1.has(r9)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r9 == 0) goto L_0x00fc
            java.lang.String r9 = "v"
            long r2 = r1.optLong(r9)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            com.alibaba.pdns.f.f17918k = r2     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
        L_0x00fc:
            java.lang.String r9 = "ttl"
            boolean r9 = r1.has(r9)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r9 == 0) goto L_0x010c
            java.lang.String r9 = "ttl"
            int r9 = r1.optInt(r9)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            com.alibaba.pdns.f.f17919l = r9     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
        L_0x010c:
            java.lang.String r9 = "uhf"
            boolean r9 = r1.has(r9)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            if (r9 == 0) goto L_0x011c
            java.lang.String r9 = "uhf"
            int r9 = r1.optInt(r9)     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            com.alibaba.pdns.f.f17922o = r9     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
        L_0x011c:
            long r1 = java.lang.System.nanoTime()     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            com.alibaba.pdns.f.f17923p = r1     // Catch:{ JSONException -> 0x005e, Exception -> 0x005b, Error -> 0x0058 }
            goto L_0x0134
        L_0x0123:
            monitor-exit(r0)
            return
        L_0x0125:
            boolean r1 = com.alibaba.pdns.u.a.f18279a     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x0134
            r9.printStackTrace()     // Catch:{ all -> 0x0055 }
            goto L_0x0134
        L_0x012d:
            boolean r1 = com.alibaba.pdns.u.a.f18279a     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x0134
            r9.printStackTrace()     // Catch:{ all -> 0x0055 }
        L_0x0134:
            monitor-exit(r0)
            return
        L_0x0136:
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.net.a.a(java.lang.String):void");
    }
}
