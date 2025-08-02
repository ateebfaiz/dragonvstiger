package com.onesignal;

import na.c;
import org.json.JSONArray;
import org.json.JSONObject;
import qa.b;
import qa.d;

public class p2 {

    /* renamed from: a  reason: collision with root package name */
    private c f10961a;

    /* renamed from: b  reason: collision with root package name */
    private JSONArray f10962b;

    /* renamed from: c  reason: collision with root package name */
    private String f10963c;

    /* renamed from: d  reason: collision with root package name */
    private long f10964d;

    /* renamed from: e  reason: collision with root package name */
    private Float f10965e;

    public p2(c cVar, JSONArray jSONArray, String str, long j10, float f10) {
        this.f10961a = cVar;
        this.f10962b = jSONArray;
        this.f10963c = str;
        this.f10964d = j10;
        this.f10965e = Float.valueOf(f10);
    }

    public static p2 a(b bVar) {
        JSONArray jSONArray;
        c cVar = c.UNATTRIBUTED;
        if (bVar.b() != null) {
            d b10 = bVar.b();
            if (b10.a() != null && b10.a().b() != null && b10.a().b().length() > 0) {
                cVar = c.DIRECT;
                jSONArray = b10.a().b();
                return new p2(cVar, jSONArray, bVar.a(), bVar.c(), bVar.d());
            } else if (!(b10.b() == null || b10.b().b() == null || b10.b().b().length() <= 0)) {
                cVar = c.INDIRECT;
                jSONArray = b10.b().b();
                return new p2(cVar, jSONArray, bVar.a(), bVar.c(), bVar.d());
            }
        }
        jSONArray = null;
        return new p2(cVar, jSONArray, bVar.a(), bVar.c(), bVar.d());
    }

    public c b() {
        return this.f10961a;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = this.f10962b;
        if (jSONArray != null && jSONArray.length() > 0) {
            jSONObject.put("notification_ids", this.f10962b);
        }
        jSONObject.put("id", this.f10963c);
        if (this.f10965e.floatValue() > 0.0f) {
            jSONObject.put("weight", this.f10965e);
        }
        long j10 = this.f10964d;
        if (j10 > 0) {
            jSONObject.put("timestamp", j10);
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p2 p2Var = (p2) obj;
        if (!this.f10961a.equals(p2Var.f10961a) || !this.f10962b.equals(p2Var.f10962b) || !this.f10963c.equals(p2Var.f10963c) || this.f10964d != p2Var.f10964d || !this.f10965e.equals(p2Var.f10965e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        Object[] objArr = {this.f10961a, this.f10962b, this.f10963c, Long.valueOf(this.f10964d), this.f10965e};
        int i11 = 1;
        for (int i12 = 0; i12 < 5; i12++) {
            Object obj = objArr[i12];
            int i13 = i11 * 31;
            if (obj == null) {
                i10 = 0;
            } else {
                i10 = obj.hashCode();
            }
            i11 = i13 + i10;
        }
        return i11;
    }

    public String toString() {
        return "OutcomeEvent{session=" + this.f10961a + ", notificationIds=" + this.f10962b + ", name='" + this.f10963c + '\'' + ", timestamp=" + this.f10964d + ", weight=" + this.f10965e + '}';
    }
}
