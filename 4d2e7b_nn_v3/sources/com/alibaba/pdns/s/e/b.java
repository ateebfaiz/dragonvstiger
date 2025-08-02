package com.alibaba.pdns.s.e;

import com.alibaba.pdns.DNSResolver;
import com.alibaba.pdns.model.d;
import com.alibaba.pdns.s.d;
import com.alibaba.pdns.u.a;
import org.json.JSONArray;

public class b implements d {
    public com.alibaba.pdns.model.d a(String str, String str2) throws Exception {
        return null;
    }

    public com.alibaba.pdns.model.d b(String str, String str2) throws Exception {
        if (str == null) {
            return null;
        }
        com.alibaba.pdns.model.d dVar = new com.alibaba.pdns.model.d();
        JSONArray jSONArray = new JSONArray(str);
        a.b("JSonStr", str);
        dVar.f18026a = false;
        if (jSONArray.toString() != null && !"".equals(jSONArray.toString())) {
            dVar.f18030e = new d.a[jSONArray.length()];
            int minTtlCache = DNSResolver.getMinTtlCache();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                dVar.f18030e[i10] = new d.a();
                dVar.f18030e[i10].f18037a = jSONArray.optString(i10);
                d.a aVar = dVar.f18030e[i10];
                aVar.f18039c = str2;
                aVar.f18038b = minTtlCache;
            }
        }
        return dVar;
    }
}
