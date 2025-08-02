package com.alibaba.pdns.s.e;

import android.text.TextUtils;
import com.alibaba.pdns.DNSResolver;
import com.alibaba.pdns.model.d;
import com.alibaba.pdns.s.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18235a = "0";

    /* renamed from: b  reason: collision with root package name */
    private static final String f18236b = "3";

    /* renamed from: c  reason: collision with root package name */
    private static final String f18237c = "6";

    /* renamed from: d  reason: collision with root package name */
    private static final int f18238d = 60;

    /* renamed from: e  reason: collision with root package name */
    private static final String f18239e = "Authority";

    /* renamed from: f  reason: collision with root package name */
    private static final String f18240f = "Answer";

    /* renamed from: g  reason: collision with root package name */
    private static final String f18241g = "TTL";

    /* renamed from: h  reason: collision with root package name */
    private static final String f18242h = "type";

    /* renamed from: i  reason: collision with root package name */
    private static final String f18243i = "data";

    /* renamed from: j  reason: collision with root package name */
    private static final String f18244j = "Status";

    public com.alibaba.pdns.model.d a(String str, String str2) throws Exception {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        if (str == null || TextUtils.equals(str, "")) {
            return null;
        }
        com.alibaba.pdns.model.d dVar = new com.alibaba.pdns.model.d();
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString(f18244j);
        int i10 = 0;
        if (TextUtils.equals(optString, f18235a)) {
            if (jSONObject.has(f18240f)) {
                JSONArray optJSONArray3 = jSONObject.optJSONArray(f18240f);
                if (optJSONArray3 != null) {
                    dVar.f18030e = new d.a[optJSONArray3.length()];
                    ArrayList arrayList = new ArrayList();
                    while (i10 < optJSONArray3.length()) {
                        JSONObject jSONObject2 = optJSONArray3.getJSONObject(i10);
                        if (str2.equals(jSONObject2.optString(f18242h))) {
                            d.a aVar = new d.a();
                            aVar.f18037a = jSONObject2.optString("data");
                            int optInt = jSONObject2.optInt(f18241g);
                            int maxTtlCache = DNSResolver.getMaxTtlCache();
                            int minTtlCache = DNSResolver.getMinTtlCache();
                            if (optInt >= maxTtlCache) {
                                optInt = maxTtlCache;
                            } else if (optInt <= minTtlCache) {
                                optInt = minTtlCache;
                            }
                            aVar.f18038b = optInt;
                            aVar.f18039c = str2;
                            arrayList.add(aVar);
                        }
                        i10++;
                    }
                    if (arrayList.size() == 0) {
                        dVar.f18026a = true;
                        d.a aVar2 = new d.a();
                        aVar2.f18038b = DNSResolver.maxNegativeCache;
                        aVar2.f18039c = str2;
                        arrayList.add(aVar2);
                    }
                    dVar.f18030e = (d.a[]) arrayList.toArray(new d.a[arrayList.size()]);
                }
            } else if (jSONObject.has(f18239e) && DNSResolver.maxNegativeCache > 0 && (optJSONArray2 = jSONObject.optJSONArray(f18239e)) != null) {
                dVar.f18026a = true;
                dVar.f18030e = new d.a[optJSONArray2.length()];
                ArrayList arrayList2 = new ArrayList();
                while (i10 < optJSONArray2.length()) {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i10);
                    d.a aVar3 = new d.a();
                    if (f18237c.equals(jSONObject3.optString(f18242h))) {
                        int optInt2 = jSONObject3.optInt(f18241g);
                        int i11 = DNSResolver.maxNegativeCache;
                        if (optInt2 < i11) {
                            aVar3.f18038b = optInt2;
                        } else {
                            aVar3.f18038b = i11;
                        }
                    } else {
                        aVar3.f18038b = 60;
                    }
                    aVar3.f18039c = str2;
                    arrayList2.add(aVar3);
                    i10++;
                }
                dVar.f18030e = (d.a[]) arrayList2.toArray(new d.a[arrayList2.size()]);
            }
        } else if (TextUtils.equals(optString, "3") && jSONObject.has(f18239e) && DNSResolver.maxNegativeCache > 0 && (optJSONArray = jSONObject.optJSONArray(f18239e)) != null) {
            dVar.f18026a = true;
            dVar.f18030e = new d.a[optJSONArray.length()];
            ArrayList arrayList3 = new ArrayList();
            while (i10 < optJSONArray.length()) {
                JSONObject jSONObject4 = optJSONArray.getJSONObject(i10);
                d.a aVar4 = new d.a();
                if (f18237c.equals(jSONObject4.optString(f18242h))) {
                    int optInt3 = jSONObject4.optInt(f18241g);
                    int i12 = DNSResolver.maxNegativeCache;
                    if (optInt3 < i12) {
                        aVar4.f18038b = optInt3;
                    } else {
                        aVar4.f18038b = i12;
                    }
                } else {
                    aVar4.f18038b = 60;
                }
                aVar4.f18039c = str2;
                arrayList3.add(aVar4);
                i10++;
            }
            dVar.f18030e = (d.a[]) arrayList3.toArray(new d.a[arrayList3.size()]);
        }
        return dVar;
    }

    public com.alibaba.pdns.model.d b(String str, String str2) throws Exception {
        return null;
    }
}
