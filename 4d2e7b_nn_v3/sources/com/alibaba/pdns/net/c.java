package com.alibaba.pdns.net;

import android.text.TextUtils;
import com.alibaba.pdns.e;
import com.alibaba.pdns.model.f;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18083a = "c";

    /* renamed from: b  reason: collision with root package name */
    private static final String f18084b = "0";

    /* renamed from: c  reason: collision with root package name */
    private static final String f18085c = "3";

    /* renamed from: d  reason: collision with root package name */
    private static final String f18086d = "6";

    /* renamed from: e  reason: collision with root package name */
    private static final String f18087e = "Authority";

    /* renamed from: f  reason: collision with root package name */
    private static final String f18088f = "Answer";

    /* renamed from: g  reason: collision with root package name */
    private static final String f18089g = "TTL";

    /* renamed from: h  reason: collision with root package name */
    private static final String f18090h = "data";

    /* renamed from: i  reason: collision with root package name */
    private static final String f18091i = "Status";

    /* renamed from: j  reason: collision with root package name */
    private static final String f18092j = "type";

    /* renamed from: k  reason: collision with root package name */
    private static final String f18093k = "name";

    /* renamed from: l  reason: collision with root package name */
    private static final String f18094l = ".ipv6.";

    /* renamed from: m  reason: collision with root package name */
    private static final String f18095m = ".ipv4.";

    /* renamed from: n  reason: collision with root package name */
    private static final String f18096n = ".domain.";

    /* renamed from: o  reason: collision with root package name */
    private static final int f18097o = 3600;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "目的优选请求的url:"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.alibaba.pdns.u.a.a((java.lang.String) r0)
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x0065
            java.lang.String r0 = ""
            boolean r1 = android.text.TextUtils.equals(r4, r0)
            if (r1 == 0) goto L_0x0023
            goto L_0x0065
        L_0x0023:
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r1 = com.alibaba.pdns.f.J     // Catch:{ Exception -> 0x0044, Error -> 0x0042 }
            boolean r1 = com.alibaba.pdns.e.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r1)     // Catch:{ Exception -> 0x0044, Error -> 0x0042 }
            if (r1 != 0) goto L_0x0046
            com.alibaba.pdns.model.f r1 = new com.alibaba.pdns.model.f     // Catch:{ Exception -> 0x0044, Error -> 0x0042 }
            r1.<init>()     // Catch:{ Exception -> 0x0044, Error -> 0x0042 }
            r2 = 60
            r1.f18051g = r2     // Catch:{ Exception -> 0x0044, Error -> 0x0042 }
            long r2 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x0044, Error -> 0x0042 }
            r1.f18056l = r2     // Catch:{ Exception -> 0x0044, Error -> 0x0042 }
            r1.f18049e = r0     // Catch:{ Exception -> 0x0044, Error -> 0x0042 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r2 = com.alibaba.pdns.f.J     // Catch:{ Exception -> 0x0044, Error -> 0x0042 }
            r2.add(r1)     // Catch:{ Exception -> 0x0044, Error -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r4 = move-exception
            goto L_0x005e
        L_0x0044:
            r4 = move-exception
            goto L_0x005e
        L_0x0046:
            com.alibaba.pdns.net.d r1 = com.alibaba.pdns.net.d.a()     // Catch:{ Exception -> 0x0044, Error -> 0x0042 }
            java.lang.String r4 = r1.a(r4, r5)     // Catch:{ Exception -> 0x0044, Error -> 0x0042 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0044, Error -> 0x0042 }
            if (r5 != 0) goto L_0x0065
            boolean r5 = android.text.TextUtils.equals(r0, r4)     // Catch:{ Exception -> 0x0044, Error -> 0x0042 }
            if (r5 != 0) goto L_0x0065
            a(r4)     // Catch:{ Exception -> 0x0044, Error -> 0x0042 }
            goto L_0x0065
        L_0x005e:
            boolean r5 = com.alibaba.pdns.u.a.f18279a
            if (r5 == 0) goto L_0x0065
            r4.printStackTrace()
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.net.c.a(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01fe, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01f2 A[Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb, all -> 0x00b8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void a(java.lang.String r13) {
        /*
            java.lang.Class<com.alibaba.pdns.net.c> r0 = com.alibaba.pdns.net.c.class
            monitor-enter(r0)
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r1.<init>(r13)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.lang.String r13 = "Status"
            java.lang.String r13 = r1.optString(r13)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            boolean r2 = android.text.TextUtils.isEmpty(r13)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r2 == 0) goto L_0x0016
            monitor-exit(r0)
            return
        L_0x0016:
            java.util.concurrent.CopyOnWriteArrayList r2 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r2.<init>()     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.util.concurrent.CopyOnWriteArrayList r3 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r3.<init>()     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.util.concurrent.CopyOnWriteArrayList r4 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r4.<init>()     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.lang.String r5 = "0"
            boolean r5 = android.text.TextUtils.equals(r13, r5)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r6 = 60
            r7 = 3600(0xe10, float:5.045E-42)
            r8 = 0
            if (r5 == 0) goto L_0x0163
            java.lang.String r13 = "Answer"
            boolean r13 = r1.has(r13)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r13 == 0) goto L_0x0105
            java.lang.String r13 = "Answer"
            org.json.JSONArray r13 = r1.optJSONArray(r13)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r13 == 0) goto L_0x01c9
            r1 = r8
        L_0x0043:
            int r5 = r13.length()     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r1 >= r5) goto L_0x01c9
            org.json.JSONObject r5 = r13.getJSONObject(r1)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.lang.String r6 = "TTL"
            int r6 = r5.optInt(r6)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.lang.String r7 = "data"
            java.lang.String r5 = r5.optString(r7)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            boolean r7 = com.alibaba.pdns.e.a((java.lang.String) r5)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r7 != 0) goto L_0x0061
            goto L_0x0101
        L_0x0061:
            com.alibaba.pdns.model.f r7 = new com.alibaba.pdns.model.f     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r7.<init>()     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            long r9 = java.lang.System.nanoTime()     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r7.f18056l = r9     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r7.f18051g = r6     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.lang.String r6 = " "
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r5 == 0) goto L_0x0101
            int r6 = r5.length     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r9 = 3
            if (r6 <= r9) goto L_0x0101
            r6 = r5[r8]     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r7.f18046b = r6     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r6 = 1
            r6 = r5[r6]     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r7.f18047c = r6     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r5 = r5[r9]     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            boolean r6 = com.alibaba.pdns.e.a((java.lang.String) r5)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r6 != 0) goto L_0x008d
            goto L_0x0101
        L_0x008d:
            java.lang.String r6 = ".ipv6."
            boolean r6 = r5.endsWith(r6)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r6 == 0) goto L_0x00c4
            java.lang.String r6 = "temp_ipv6"
            r7.f18050f = r6     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.lang.String r6 = ".ipv6."
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r5 == 0) goto L_0x0101
            int r6 = r5.length     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r6 <= 0) goto L_0x0101
            r5 = r5[r8]     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.lang.String r6 = "-"
            java.lang.String r9 = ":"
            java.lang.String r5 = r5.replace(r6, r9)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.lang.String r5 = com.alibaba.pdns.o.a((java.lang.String) r5)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r7.f18049e = r5     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r3.add(r7)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            goto L_0x0101
        L_0x00b8:
            r13 = move-exception
            goto L_0x01ff
        L_0x00bb:
            r13 = move-exception
            goto L_0x01ee
        L_0x00be:
            r13 = move-exception
            goto L_0x01ee
        L_0x00c1:
            r13 = move-exception
            goto L_0x01f6
        L_0x00c4:
            java.lang.String r6 = ".ipv4."
            boolean r6 = r5.endsWith(r6)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r6 == 0) goto L_0x00e3
            java.lang.String r6 = "temp_ipv4"
            r7.f18050f = r6     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.lang.String r6 = ".ipv4."
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r5 == 0) goto L_0x0101
            int r6 = r5.length     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r6 <= 0) goto L_0x0101
            r5 = r5[r8]     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r7.f18049e = r5     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r2.add(r7)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            goto L_0x0101
        L_0x00e3:
            java.lang.String r6 = ".domain."
            boolean r6 = r5.endsWith(r6)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r6 == 0) goto L_0x0101
            java.lang.String r6 = "temp_host"
            r7.f18050f = r6     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.lang.String r6 = ".domain."
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r5 == 0) goto L_0x0101
            int r6 = r5.length     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r6 <= 0) goto L_0x0101
            r5 = r5[r8]     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r7.f18049e = r5     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r4.add(r7)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
        L_0x0101:
            int r1 = r1 + 1
            goto L_0x0043
        L_0x0105:
            java.lang.String r13 = "Authority"
            boolean r13 = r1.has(r13)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r13 == 0) goto L_0x01c9
            java.lang.String r13 = "Authority"
            org.json.JSONArray r13 = r1.optJSONArray(r13)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r13 == 0) goto L_0x01c9
            r1 = r8
        L_0x0116:
            int r5 = r13.length()     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r1 >= r5) goto L_0x01c9
            org.json.JSONObject r5 = r13.getJSONObject(r1)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.lang.String r9 = "type"
            java.lang.String r9 = r5.optString(r9)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.lang.String r10 = "name"
            java.lang.String r10 = r5.optString(r10)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r11 = com.alibaba.pdns.f.J     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            boolean r11 = com.alibaba.pdns.e.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r11)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r11 == 0) goto L_0x0160
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r11 = com.alibaba.pdns.f.J     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.lang.Object r11 = r11.get(r8)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            com.alibaba.pdns.model.f r11 = (com.alibaba.pdns.model.f) r11     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r11 == 0) goto L_0x0160
            java.lang.String r12 = "6"
            boolean r12 = r12.equals(r9)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r12 == 0) goto L_0x0154
            java.lang.String r12 = "TTL"
            int r5 = r5.optInt(r12)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r5 >= r7) goto L_0x0151
            r11.f18051g = r5     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            goto L_0x0156
        L_0x0151:
            r11.f18051g = r7     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            goto L_0x0156
        L_0x0154:
            r11.f18051g = r6     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
        L_0x0156:
            r11.f18045a = r10     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r11.f18050f = r9     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            long r9 = java.lang.System.nanoTime()     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r11.f18056l = r9     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
        L_0x0160:
            int r1 = r1 + 1
            goto L_0x0116
        L_0x0163:
            java.lang.String r5 = "3"
            boolean r13 = android.text.TextUtils.equals(r13, r5)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r13 == 0) goto L_0x01c9
            java.lang.String r13 = "Authority"
            boolean r13 = r1.has(r13)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r13 == 0) goto L_0x01c9
            java.lang.String r13 = "Authority"
            org.json.JSONArray r13 = r1.optJSONArray(r13)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r13 == 0) goto L_0x01c9
            r1 = r8
        L_0x017c:
            int r5 = r13.length()     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r1 >= r5) goto L_0x01c9
            org.json.JSONObject r5 = r13.getJSONObject(r1)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.lang.String r9 = "type"
            java.lang.String r9 = r5.optString(r9)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.lang.String r10 = "name"
            java.lang.String r10 = r5.optString(r10)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r11 = com.alibaba.pdns.f.J     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            boolean r11 = com.alibaba.pdns.e.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r11)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r11 == 0) goto L_0x01c6
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r11 = com.alibaba.pdns.f.J     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.lang.Object r11 = r11.get(r8)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            com.alibaba.pdns.model.f r11 = (com.alibaba.pdns.model.f) r11     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r11 == 0) goto L_0x01c6
            java.lang.String r12 = "6"
            boolean r12 = r12.equals(r9)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r12 == 0) goto L_0x01ba
            java.lang.String r12 = "TTL"
            int r5 = r5.optInt(r12)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            if (r5 >= r7) goto L_0x01b7
            r11.f18051g = r5     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            goto L_0x01bc
        L_0x01b7:
            r11.f18051g = r7     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            goto L_0x01bc
        L_0x01ba:
            r11.f18051g = r6     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
        L_0x01bc:
            r11.f18045a = r10     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r11.f18050f = r9     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            long r9 = java.lang.System.nanoTime()     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r11.f18056l = r9     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
        L_0x01c6:
            int r1 = r1 + 1
            goto L_0x017c
        L_0x01c9:
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r13 = com.alibaba.pdns.f.K     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r13, (java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r2)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r13 = com.alibaba.pdns.f.L     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r13, (java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r3)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r13 = com.alibaba.pdns.f.M     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r13, (java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r4)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r13 = com.alibaba.pdns.f.f17933z     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r2.addAll(r13)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r13 = com.alibaba.pdns.f.A     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r3.addAll(r13)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r13 = com.alibaba.pdns.f.B     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            r4.addAll(r13)     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            com.alibaba.pdns.f.M = r4     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            com.alibaba.pdns.f.K = r2     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            com.alibaba.pdns.f.L = r3     // Catch:{ JSONException -> 0x00c1, Exception -> 0x00be, Error -> 0x00bb }
            goto L_0x01fd
        L_0x01ee:
            boolean r1 = com.alibaba.pdns.u.a.f18279a     // Catch:{ all -> 0x00b8 }
            if (r1 == 0) goto L_0x01fd
            r13.printStackTrace()     // Catch:{ all -> 0x00b8 }
            goto L_0x01fd
        L_0x01f6:
            boolean r1 = com.alibaba.pdns.u.a.f18279a     // Catch:{ all -> 0x00b8 }
            if (r1 == 0) goto L_0x01fd
            r13.printStackTrace()     // Catch:{ all -> 0x00b8 }
        L_0x01fd:
            monitor-exit(r0)
            return
        L_0x01ff:
            monitor-exit(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.net.c.a(java.lang.String):void");
    }

    private static void a(CopyOnWriteArrayList<f> copyOnWriteArrayList, CopyOnWriteArrayList<f> copyOnWriteArrayList2) {
        if (com.alibaba.pdns.f.f17931x && e.a(copyOnWriteArrayList2) && e.a(copyOnWriteArrayList) && copyOnWriteArrayList.size() > 0 && copyOnWriteArrayList2.size() > 0) {
            Iterator<f> it = copyOnWriteArrayList2.iterator();
            while (it.hasNext()) {
                f next = it.next();
                Iterator<f> it2 = copyOnWriteArrayList.iterator();
                while (it2.hasNext()) {
                    f next2 = it2.next();
                    if (!(next == null || next2 == null || !TextUtils.equals(next.f18049e, next2.f18049e))) {
                        next.a(next2.g());
                    }
                }
            }
        }
    }
}
