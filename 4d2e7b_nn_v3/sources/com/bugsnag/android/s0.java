package com.bugsnag.android;

import c1.j;
import c1.s;
import com.bugsnag.android.v3;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class s0 extends n {

    /* renamed from: g  reason: collision with root package name */
    static long f18974g = 3000;

    /* renamed from: a  reason: collision with root package name */
    final s2 f18975a;

    /* renamed from: b  reason: collision with root package name */
    private final y1 f18976b;

    /* renamed from: c  reason: collision with root package name */
    private final j f18977c;

    /* renamed from: d  reason: collision with root package name */
    private final e3 f18978d;

    /* renamed from: e  reason: collision with root package name */
    private final y f18979e;

    /* renamed from: f  reason: collision with root package name */
    final c1.a f18980f;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s1 f18981a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o1 f18982b;

        a(s1 s1Var, o1 o1Var) {
            this.f18981a = s1Var;
            this.f18982b = o1Var;
        }

        public void run() {
            s0.this.f(this.f18981a, this.f18982b);
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18984a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.bugsnag.android.v0[] r0 = com.bugsnag.android.v0.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f18984a = r0
                com.bugsnag.android.v0 r1 = com.bugsnag.android.v0.DELIVERED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f18984a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bugsnag.android.v0 r1 = com.bugsnag.android.v0.UNDELIVERED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f18984a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bugsnag.android.v0 r1 = com.bugsnag.android.v0.FAILURE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.s0.b.<clinit>():void");
        }
    }

    s0(s2 s2Var, y1 y1Var, j jVar, y yVar, e3 e3Var, c1.a aVar) {
        this.f18975a = s2Var;
        this.f18976b = y1Var;
        this.f18977c = jVar;
        this.f18979e = yVar;
        this.f18978d = e3Var;
        this.f18980f = aVar;
    }

    private void b(o1 o1Var) {
        long currentTimeMillis = System.currentTimeMillis() + f18974g;
        Future J = this.f18976b.J(o1Var);
        long currentTimeMillis2 = currentTimeMillis - System.currentTimeMillis();
        if (J != null && currentTimeMillis2 > 0) {
            try {
                J.get(currentTimeMillis2, TimeUnit.MILLISECONDS);
            } catch (Exception e10) {
                this.f18975a.c("failed to immediately deliver event", e10);
            }
            if (!J.isDone()) {
                J.cancel(true);
            }
        }
    }

    private void c(o1 o1Var, boolean z10) {
        this.f18976b.k(o1Var);
        if (z10) {
            this.f18976b.v();
        }
    }

    private void e(o1 o1Var, s1 s1Var) {
        try {
            this.f18980f.d(s.ERROR_REQUEST, new a(s1Var, o1Var));
        } catch (RejectedExecutionException unused) {
            c(o1Var, false);
            this.f18975a.g("Exceeded max queue count, saving to disk to send later");
        }
    }

    /* access modifiers changed from: package-private */
    public void d(o1 o1Var) {
        this.f18975a.d("DeliveryDelegate#deliver() - event being stored/delivered by Client");
        l3 j10 = o1Var.j();
        if (j10 != null) {
            if (o1Var.m()) {
                o1Var.w(j10.j());
                updateState(v3.k.f19065a);
            } else {
                o1Var.w(j10.i());
                updateState(v3.j.f19064a);
            }
        }
        if (o1Var.i().l()) {
            boolean equals = "unhandledPromiseRejection".equals(o1Var.i().n());
            if (o1Var.i().q(o1Var) || equals) {
                c(o1Var, true);
            } else if (this.f18977c.e()) {
                b(o1Var);
            } else {
                c(o1Var, false);
            }
        } else if (this.f18979e.i(o1Var, this.f18975a)) {
            e(o1Var, new s1(o1Var.e(), o1Var, this.f18978d, this.f18977c));
        }
    }

    /* access modifiers changed from: package-private */
    public v0 f(s1 s1Var, o1 o1Var) {
        this.f18975a.d("DeliveryDelegate#deliverPayloadInternal() - attempting event delivery");
        v0 a10 = this.f18977c.i().a(s1Var, this.f18977c.o(s1Var));
        int i10 = b.f18984a[a10.ordinal()];
        if (i10 == 1) {
            this.f18975a.f("Sent 1 new event to Bugsnag");
        } else if (i10 == 2) {
            this.f18975a.g("Could not send event(s) to Bugsnag, saving to disk to send later");
            c(o1Var, false);
        } else if (i10 == 3) {
            this.f18975a.g("Problem sending event to Bugsnag");
        }
        return a10;
    }
}
