package com.onesignal;

import com.onesignal.c5;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public class n1 {

    /* renamed from: a  reason: collision with root package name */
    private String f10805a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10806b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10807c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10808d;

    /* renamed from: e  reason: collision with root package name */
    private c5.m f10809e;

    /* renamed from: f  reason: collision with root package name */
    private Double f10810f;

    /* renamed from: g  reason: collision with root package name */
    private int f10811g;

    public n1(JSONObject jSONObject) {
        boolean z10;
        m.f(jSONObject, "jsonObject");
        this.f10805a = jSONObject.optString("html");
        this.f10810f = Double.valueOf(jSONObject.optDouble("display_duration"));
        JSONObject optJSONObject = jSONObject.optJSONObject("styles");
        boolean z11 = false;
        if (optJSONObject == null) {
            z10 = false;
        } else {
            z10 = optJSONObject.optBoolean("remove_height_margin", false);
        }
        this.f10806b = !z10;
        this.f10807c = !(optJSONObject != null ? optJSONObject.optBoolean("remove_width_margin", false) : z11);
        this.f10808d = !this.f10806b;
    }

    public final String a() {
        return this.f10805a;
    }

    public final Double b() {
        return this.f10810f;
    }

    public final c5.m c() {
        return this.f10809e;
    }

    public final int d() {
        return this.f10811g;
    }

    public final boolean e() {
        return this.f10806b;
    }

    public final boolean f() {
        return this.f10807c;
    }

    public final boolean g() {
        return this.f10808d;
    }

    public final void h(String str) {
        this.f10805a = str;
    }

    public final void i(c5.m mVar) {
        this.f10809e = mVar;
    }

    public final void j(int i10) {
        this.f10811g = i10;
    }
}
