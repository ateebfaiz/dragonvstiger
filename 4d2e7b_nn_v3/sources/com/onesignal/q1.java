package com.onesignal;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class q1 extends l1 {

    /* renamed from: b  reason: collision with root package name */
    public HashMap f10973b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f10974c;

    /* renamed from: d  reason: collision with root package name */
    private Set f10975d;

    /* renamed from: e  reason: collision with root package name */
    private y1 f10976e;

    /* renamed from: f  reason: collision with root package name */
    private double f10977f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10978g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10979h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10980i;

    /* renamed from: j  reason: collision with root package name */
    private Date f10981j;

    /* renamed from: k  reason: collision with root package name */
    boolean f10982k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10983l;

    q1(boolean z10) {
        super("");
        this.f10976e = new y1();
        this.f10978g = false;
        this.f10979h = false;
        this.f10982k = z10;
    }

    private Date j(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("end_time");
            if (string.equals("null")) {
                return null;
            }
            try {
                return d4.a().parse(string);
            } catch (ParseException e10) {
                e10.printStackTrace();
                return null;
            }
        } catch (JSONException unused) {
            return null;
        }
    }

    private HashMap l(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            HashMap hashMap2 = new HashMap();
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                hashMap2.put(next2, jSONObject2.getString(next2));
            }
            hashMap.put(next, hashMap2);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.f10975d.add(str);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f10975d.clear();
    }

    /* access modifiers changed from: package-private */
    public Set c() {
        return this.f10975d;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f10983l;
    }

    /* access modifiers changed from: package-private */
    public y1 e() {
        return this.f10976e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f10768a.equals(((q1) obj).f10768a);
    }

    /* access modifiers changed from: package-private */
    public boolean f(String str) {
        return !this.f10975d.contains(str);
    }

    public boolean g() {
        return this.f10978g;
    }

    public boolean h() {
        if (this.f10981j == null) {
            return false;
        }
        return this.f10981j.before(new Date());
    }

    public int hashCode() {
        return this.f10768a.hashCode();
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.f10979h;
    }

    /* access modifiers changed from: protected */
    public ArrayList k(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i10);
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                arrayList2.add(new j3(jSONArray2.getJSONObject(i11)));
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void m(String str) {
        this.f10975d.remove(str);
    }

    /* access modifiers changed from: package-private */
    public void n(double d10) {
        this.f10977f = d10;
    }

    public void o(boolean z10) {
        this.f10978g = z10;
    }

    /* access modifiers changed from: package-private */
    public void p(boolean z10) {
        this.f10979h = z10;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        if (this.f10980i) {
            return false;
        }
        this.f10980i = true;
        return true;
    }

    public String toString() {
        return "OSInAppMessage{messageId='" + this.f10768a + '\'' + ", variants=" + this.f10973b + ", triggers=" + this.f10974c + ", clickedClickIds=" + this.f10975d + ", redisplayStats=" + this.f10976e + ", displayDuration=" + this.f10977f + ", displayedInSession=" + this.f10978g + ", triggerChanged=" + this.f10979h + ", actionTaken=" + this.f10980i + ", isPreview=" + this.f10982k + ", endTime=" + this.f10981j + ", hasLiquid=" + this.f10983l + '}';
    }

    q1(String str, Set set, boolean z10, y1 y1Var) {
        super(str);
        new y1();
        this.f10979h = false;
        this.f10975d = set;
        this.f10978g = z10;
        this.f10976e = y1Var;
    }

    q1(JSONObject jSONObject) {
        super(jSONObject.getString("id"));
        this.f10976e = new y1();
        this.f10978g = false;
        this.f10979h = false;
        this.f10973b = l(jSONObject.getJSONObject("variants"));
        this.f10974c = k(jSONObject.getJSONArray("triggers"));
        this.f10975d = new HashSet();
        this.f10981j = j(jSONObject);
        if (jSONObject.has("has_liquid")) {
            this.f10983l = jSONObject.getBoolean("has_liquid");
        }
        if (jSONObject.has("redisplay")) {
            this.f10976e = new y1(jSONObject.getJSONObject("redisplay"));
        }
    }
}
