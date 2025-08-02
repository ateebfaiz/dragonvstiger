package com.onesignal;

import com.onesignal.o3;

public class m2 implements o3.t {

    /* renamed from: a  reason: collision with root package name */
    private final i3 f10788a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f10789b;

    /* renamed from: c  reason: collision with root package name */
    private d2 f10790c;

    /* renamed from: d  reason: collision with root package name */
    private e2 f10791d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10792e = false;

    class a implements Runnable {
        a() {
        }

        public void run() {
            o3.a(o3.v.DEBUG, "Running complete from OSNotificationOpenedResult timeout runnable!");
            m2.this.c(false);
        }
    }

    public m2(d2 d2Var, e2 e2Var) {
        this.f10790c = d2Var;
        this.f10791d = e2Var;
        i3 b10 = i3.b();
        this.f10788a = b10;
        a aVar = new a();
        this.f10789b = aVar;
        b10.c(5000, aVar);
    }

    /* access modifiers changed from: private */
    public void c(boolean z10) {
        o3.v vVar = o3.v.DEBUG;
        o3.d1(vVar, "OSNotificationOpenedResult complete called with opened: " + z10);
        this.f10788a.a(this.f10789b);
        if (this.f10792e) {
            o3.d1(vVar, "OSNotificationOpenedResult already completed");
            return;
        }
        this.f10792e = true;
        if (z10) {
            o3.z(this.f10790c.g());
        }
        o3.p1(this);
    }

    public void a(o3.r rVar) {
        o3.v vVar = o3.v.DEBUG;
        o3.d1(vVar, "OSNotificationOpenedResult onEntryStateChange called with appEntryState: " + rVar);
        c(o3.r.APP_CLOSE.equals(rVar));
    }

    public d2 d() {
        return this.f10790c;
    }

    public String toString() {
        return "OSNotificationOpenedResult{notification=" + this.f10790c + ", action=" + this.f10791d + ", isComplete=" + this.f10792e + '}';
    }
}
