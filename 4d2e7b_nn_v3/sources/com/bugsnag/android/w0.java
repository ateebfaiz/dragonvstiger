package com.bugsnag.android;

import com.alibaba.pdns.f;
import com.bugsnag.android.k2;
import java.util.LinkedHashMap;
import java.util.Map;

public class w0 implements k2.a {

    /* renamed from: a  reason: collision with root package name */
    private String[] f19080a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f19081b;

    /* renamed from: c  reason: collision with root package name */
    private String f19082c;

    /* renamed from: d  reason: collision with root package name */
    private String f19083d;

    /* renamed from: e  reason: collision with root package name */
    private Long f19084e;

    /* renamed from: f  reason: collision with root package name */
    private String f19085f;

    /* renamed from: g  reason: collision with root package name */
    private String f19086g;

    /* renamed from: h  reason: collision with root package name */
    private String f19087h = f.f17924q;

    /* renamed from: i  reason: collision with root package name */
    private String f19088i;

    /* renamed from: j  reason: collision with root package name */
    private Map f19089j;

    public w0(x0 x0Var, String[] strArr, Boolean bool, String str, String str2, Long l10, Map map) {
        this.f19080a = strArr;
        this.f19081b = bool;
        this.f19082c = str;
        this.f19083d = str2;
        this.f19084e = l10;
        this.f19085f = x0Var.e();
        this.f19086g = x0Var.f();
        this.f19088i = x0Var.h();
        this.f19089j = k(map);
    }

    private final Map k(Map map) {
        if (map == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    public final String[] a() {
        return this.f19080a;
    }

    public final String b() {
        return this.f19082c;
    }

    public final Boolean c() {
        return this.f19081b;
    }

    public final String d() {
        return this.f19083d;
    }

    public final String e() {
        return this.f19085f;
    }

    public final String f() {
        return this.f19086g;
    }

    public final String g() {
        return this.f19087h;
    }

    public final String h() {
        return this.f19088i;
    }

    public final Map i() {
        return this.f19089j;
    }

    public final Long j() {
        return this.f19084e;
    }

    public void l(k2 k2Var) {
        k2Var.v("cpuAbi").P(this.f19080a);
        k2Var.v("jailbroken").I(this.f19081b);
        k2Var.v("id").K(this.f19082c);
        k2Var.v("locale").K(this.f19083d);
        k2Var.v("manufacturer").K(this.f19085f);
        k2Var.v("model").K(this.f19086g);
        k2Var.v("osName").K(this.f19087h);
        k2Var.v("osVersion").K(this.f19088i);
        k2Var.v("runtimeVersions").P(this.f19089j);
        k2Var.v("totalMemory").J(this.f19084e);
    }

    public void toStream(k2 k2Var) {
        k2Var.j();
        l(k2Var);
        k2Var.n();
    }
}
