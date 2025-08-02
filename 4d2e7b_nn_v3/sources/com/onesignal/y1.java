package com.onesignal;

import com.onesignal.o3;
import org.json.JSONObject;

class y1 {

    /* renamed from: a  reason: collision with root package name */
    private long f11111a;

    /* renamed from: b  reason: collision with root package name */
    private int f11112b;

    /* renamed from: c  reason: collision with root package name */
    private int f11113c;

    /* renamed from: d  reason: collision with root package name */
    private long f11114d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11115e;

    y1() {
        this.f11111a = -1;
        this.f11112b = 0;
        this.f11113c = 1;
        this.f11114d = 0;
        this.f11115e = false;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f11112b;
    }

    /* access modifiers changed from: package-private */
    public long b() {
        return this.f11111a;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f11112b++;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        if (this.f11111a < 0) {
            return true;
        }
        long b10 = o3.w0().b() / 1000;
        long j10 = b10 - this.f11111a;
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "OSInAppMessage lastDisplayTime: " + this.f11111a + " currentTimeInSeconds: " + b10 + " diffInSeconds: " + j10 + " displayDelay: " + this.f11114d);
        if (j10 >= this.f11114d) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f11115e;
    }

    /* access modifiers changed from: package-private */
    public void f(int i10) {
        this.f11112b = i10;
    }

    /* access modifiers changed from: package-private */
    public void g(y1 y1Var) {
        h(y1Var.b());
        f(y1Var.a());
    }

    /* access modifiers changed from: package-private */
    public void h(long j10) {
        this.f11111a = j10;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        boolean z10;
        if (this.f11112b < this.f11113c) {
            z10 = true;
        } else {
            z10 = false;
        }
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "OSInAppMessage shouldDisplayAgain: " + z10);
        return z10;
    }

    public String toString() {
        return "OSInAppMessageDisplayStats{lastDisplayTime=" + this.f11111a + ", displayQuantity=" + this.f11112b + ", displayLimit=" + this.f11113c + ", displayDelay=" + this.f11114d + '}';
    }

    y1(int i10, long j10) {
        this.f11113c = 1;
        this.f11114d = 0;
        this.f11115e = false;
        this.f11112b = i10;
        this.f11111a = j10;
    }

    y1(JSONObject jSONObject) {
        this.f11111a = -1;
        this.f11112b = 0;
        this.f11113c = 1;
        this.f11114d = 0;
        this.f11115e = true;
        Object obj = jSONObject.get("limit");
        Object obj2 = jSONObject.get("delay");
        if (obj instanceof Integer) {
            this.f11113c = ((Integer) obj).intValue();
        }
        if (obj2 instanceof Long) {
            this.f11114d = ((Long) obj2).longValue();
        } else if (obj2 instanceof Integer) {
            this.f11114d = (long) ((Integer) obj2).intValue();
        }
    }
}
