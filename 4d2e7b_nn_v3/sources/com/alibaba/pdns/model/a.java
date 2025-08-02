package com.alibaba.pdns.model;

import com.alibaba.pdns.o;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f17975a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f17976b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f17977c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f17978d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f17979e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f17980f = "1";

    /* renamed from: g  reason: collision with root package name */
    public String f17981g = "";

    /* renamed from: h  reason: collision with root package name */
    public int f17982h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f17983i = 0;

    /* renamed from: j  reason: collision with root package name */
    public String f17984j = "";

    /* renamed from: k  reason: collision with root package name */
    public float f17985k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    public int f17986l;

    /* renamed from: m  reason: collision with root package name */
    public float f17987m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    public CopyOnWriteArrayList<c> f17988n = null;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a() {
        /*
            r7 = this;
            java.lang.String r0 = "{}"
            org.json.JSONStringer r1 = new org.json.JSONStringer
            r1.<init>()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            r2.<init>()     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            java.lang.String r3 = "["
            r2.append(r3)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r3 = r7.f17988n     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            java.lang.String r4 = ","
            if (r3 == 0) goto L_0x0044
            java.util.Iterator r3 = r3.iterator()     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
        L_0x001b:
            boolean r5 = r3.hasNext()     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            if (r5 == 0) goto L_0x0044
            java.lang.Object r5 = r3.next()     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            com.alibaba.pdns.model.c r5 = (com.alibaba.pdns.model.c) r5     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            r6.<init>()     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            java.lang.String r5 = r5.a()     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            r6.append(r5)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            r6.append(r4)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            java.lang.String r5 = r6.toString()     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            r2.append(r5)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            goto L_0x001b
        L_0x003e:
            r1 = move-exception
            goto L_0x00a7
        L_0x0040:
            r1 = move-exception
            goto L_0x00a7
        L_0x0042:
            r1 = move-exception
            goto L_0x00af
        L_0x0044:
            java.lang.String r3 = r2.toString()     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            boolean r3 = r3.endsWith(r4)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            if (r3 == 0) goto L_0x0057
            int r3 = r2.length()     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            int r3 = r3 + -1
            r2.deleteCharAt(r3)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
        L_0x0057:
            java.lang.String r3 = "]"
            r2.append(r3)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            org.json.JSONStringer r3 = r1.object()     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            java.lang.String r4 = "domain"
            org.json.JSONStringer r3 = r3.key(r4)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            java.lang.String r4 = r7.f17976b     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            org.json.JSONStringer r3 = r3.value(r4)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            java.lang.String r4 = "sp"
            org.json.JSONStringer r3 = r3.key(r4)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            java.lang.String r4 = r7.f17977c     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            org.json.JSONStringer r3 = r3.value(r4)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            java.lang.String r4 = "ttl"
            org.json.JSONStringer r3 = r3.key(r4)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            int r4 = r7.f17978d     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            long r4 = (long) r4     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            org.json.JSONStringer r3 = r3.value(r4)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            java.lang.String r4 = "time"
            org.json.JSONStringer r3 = r3.key(r4)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            long r4 = r7.f17979e     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            org.json.JSONStringer r3 = r3.value(r4)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            java.lang.String r4 = "ipModelArr"
            org.json.JSONStringer r3 = r3.key(r4)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            org.json.JSONStringer r2 = r3.value(r2)     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            r2.endObject()     // Catch:{ JSONException -> 0x0042, Exception -> 0x0040, Error -> 0x003e }
            java.lang.String r0 = r1.toString()
            return r0
        L_0x00a7:
            boolean r2 = com.alibaba.pdns.u.a.f18279a
            if (r2 == 0) goto L_0x00ae
            r1.printStackTrace()
        L_0x00ae:
            return r0
        L_0x00af:
            boolean r2 = com.alibaba.pdns.u.a.f18279a
            if (r2 == 0) goto L_0x00b6
            r1.printStackTrace()
        L_0x00b6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.model.a.a():java.lang.String");
    }

    public String toString() {
        String str = (((((((("" + "域名:" + this.f17976b + "\n") + "运营商ID:" + this.f17977c + "\n") + "域名解析类型：" + this.f17981g + "\n") + "域名解析的IP：" + this.f17984j + "\n") + "域名解析数据记录类型：type= " + this.f17980f + "\n") + "域名解析耗时时间：" + this.f17985k + "μs\n") + "域名历史成功次数：" + this.f17982h + "次\n") + "域名历史失败次数：" + this.f17983i + "次\n") + "域名最后查询时间：" + o.a(this.f17979e) + "\n";
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f17988n;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<c> it = this.f17988n.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    str = str + "-- " + next.toString();
                }
            }
        }
        return str + "------------------------------------------------------\n\n";
    }
}
