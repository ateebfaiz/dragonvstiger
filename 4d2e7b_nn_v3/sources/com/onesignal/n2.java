package com.onesignal;

import com.onesignal.o3;

public class n2 {

    /* renamed from: a  reason: collision with root package name */
    private final f2 f10812a;

    /* renamed from: b  reason: collision with root package name */
    private final i3 f10813b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f10814c;

    /* renamed from: d  reason: collision with root package name */
    private final d2 f10815d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10816e = false;

    class a implements Runnable {
        a() {
        }

        public void run() {
            o3.a(o3.v.DEBUG, "Running complete from OSNotificationReceivedEvent timeout runnable!");
            n2 n2Var = n2.this;
            n2Var.b(n2Var.c());
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2 f10818a;

        b(d2 d2Var) {
            this.f10818a = d2Var;
        }

        public void run() {
            n2.this.e(this.f10818a);
        }
    }

    n2(f2 f2Var, d2 d2Var) {
        this.f10815d = d2Var;
        this.f10812a = f2Var;
        i3 b10 = i3.b();
        this.f10813b = b10;
        a aVar = new a();
        this.f10814c = aVar;
        b10.c(25000, aVar);
    }

    static boolean d() {
        return OSUtils.H();
    }

    /* access modifiers changed from: private */
    public void e(d2 d2Var) {
        d2 d2Var2;
        f2 f2Var = this.f10812a;
        d2 c10 = this.f10815d.c();
        if (d2Var != null) {
            d2Var2 = d2Var.c();
        } else {
            d2Var2 = null;
        }
        f2Var.f(c10, d2Var2);
    }

    public synchronized void b(d2 d2Var) {
        this.f10813b.a(this.f10814c);
        if (this.f10816e) {
            o3.d1(o3.v.DEBUG, "OSNotificationReceivedEvent already completed");
            return;
        }
        this.f10816e = true;
        if (d()) {
            new Thread(new b(d2Var), "OS_COMPLETE_NOTIFICATION").start();
        } else {
            e(d2Var);
        }
    }

    public d2 c() {
        return this.f10815d;
    }

    public String toString() {
        return "OSNotificationReceivedEvent{isComplete=" + this.f10816e + ", notification=" + this.f10815d + '}';
    }
}
