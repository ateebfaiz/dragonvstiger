package com.alibaba.pdns.model;

import com.alibaba.pdns.u.a;
import org.json.JSONException;
import org.json.JSONStringer;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f18011a;

    /* renamed from: b  reason: collision with root package name */
    public Long f18012b;

    /* renamed from: c  reason: collision with root package name */
    public long f18013c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f18014d = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f18015e = "";

    /* renamed from: f  reason: collision with root package name */
    public int f18016f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f18017g = "";

    /* renamed from: h  reason: collision with root package name */
    public int f18018h = 0;

    /* renamed from: i  reason: collision with root package name */
    public String f18019i = "0";

    /* renamed from: j  reason: collision with root package name */
    public float f18020j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    public String f18021k = "0";

    /* renamed from: l  reason: collision with root package name */
    public String f18022l = "0";

    /* renamed from: m  reason: collision with root package name */
    public String f18023m = "0";

    /* renamed from: n  reason: collision with root package name */
    public String f18024n = "0";

    /* renamed from: o  reason: collision with root package name */
    public float f18025o = 0.0f;

    public String a() {
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.object().key("id").value(this.f18013c).key("d_id").value(this.f18014d).key("ip").value(this.f18015e).key("port").value((long) this.f18016f).key("ttl").value((long) this.f18018h).key("priority").value(this.f18019i).key("success_num").value(this.f18021k).key("err_num").value(this.f18022l).key("finally_success_time").value(this.f18023m).key("finally_fail_time").value(this.f18024n).endObject();
            return jSONStringer.toString();
        } catch (JSONException e10) {
            if (a.f18279a) {
                e10.printStackTrace();
            }
            return "{}";
        } catch (Error | Exception e11) {
            if (a.f18279a) {
                e11.printStackTrace();
            }
            return "{}";
        }
    }

    public String toString() {
        return ((((("*\n" + "-- 服务器ip = " + this.f18015e + "\n") + "-- 域名ID索引 = " + this.f18014d + "\n") + "-- 服务器端口 = " + this.f18016f + "\n") + "-- 过期时间 = " + this.f18018h + "\n") + "-- rtt = " + this.f18020j + "\n") + "\n";
    }
}
