package com.onesignal;

import kotlin.jvm.internal.m;
import org.json.JSONObject;

public class t1 {

    /* renamed from: a  reason: collision with root package name */
    private String f11064a;

    /* renamed from: b  reason: collision with root package name */
    private String f11065b;

    public t1(JSONObject jSONObject) {
        m.f(jSONObject, "jsonObject");
        this.f11064a = jSONObject.optString("pageId", (String) null);
        this.f11065b = jSONObject.optString("pageIndex", (String) null);
    }

    public final String a() {
        return this.f11064a;
    }
}
