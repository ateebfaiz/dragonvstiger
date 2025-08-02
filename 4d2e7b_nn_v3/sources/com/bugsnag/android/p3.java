package com.bugsnag.android;

import android.app.Activity;
import androidx.work.WorkRequest;
import c1.f;
import c1.i;
import c1.j;
import c1.s;
import com.bugsnag.android.v3;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Date;
import java.util.Deque;
import java.util.UUID;
import java.util.concurrent.RejectedExecutionException;

class p3 extends n implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private final Deque f18921a;

    /* renamed from: b  reason: collision with root package name */
    private final long f18922b;

    /* renamed from: c  reason: collision with root package name */
    private final j f18923c;

    /* renamed from: d  reason: collision with root package name */
    private final y f18924d;

    /* renamed from: e  reason: collision with root package name */
    private final z f18925e;

    /* renamed from: f  reason: collision with root package name */
    final o3 f18926f;

    /* renamed from: g  reason: collision with root package name */
    private volatile l3 f18927g;

    /* renamed from: h  reason: collision with root package name */
    final c1.a f18928h;

    /* renamed from: i  reason: collision with root package name */
    final s2 f18929i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f18930j;

    class a implements Runnable {
        a() {
        }

        public void run() {
            p3.this.g();
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l3 f18932a;

        b(l3 l3Var) {
            this.f18932a = l3Var;
        }

        public void run() {
            p3.this.b(this.f18932a);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18934a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.bugsnag.android.v0[] r0 = com.bugsnag.android.v0.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f18934a = r0
                com.bugsnag.android.v0 r1 = com.bugsnag.android.v0.DELIVERED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f18934a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bugsnag.android.v0 r1 = com.bugsnag.android.v0.UNDELIVERED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f18934a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bugsnag.android.v0 r1 = com.bugsnag.android.v0.FAILURE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.p3.c.<clinit>():void");
        }
    }

    p3(j jVar, y yVar, z zVar, o3 o3Var, s2 s2Var, c1.a aVar) {
        this(jVar, yVar, zVar, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, o3Var, s2Var, aVar);
    }

    private void e(l3 l3Var) {
        try {
            this.f18928h.d(s.SESSION_REQUEST, new b(l3Var));
        } catch (RejectedExecutionException unused) {
            this.f18926f.k(l3Var);
        }
    }

    private void l(l3 l3Var) {
        updateState(new v3.m(l3Var.e(), f.c(l3Var.g()), l3Var.d(), l3Var.h()));
    }

    private boolean p(boolean z10) {
        if (this.f18925e.m().P(z10)) {
            return true;
        }
        l3 l3Var = this.f18927g;
        if (!z10 || l3Var == null || l3Var.k() || !this.f18930j) {
            if (z10) {
                this.f18930j = false;
            }
            return false;
        }
        this.f18930j = false;
        return true;
    }

    private boolean s(l3 l3Var) {
        this.f18929i.d("SessionTracker#trackSessionIfNeeded() - session captured by Client");
        l3Var.u(this.f18925e.k().d());
        l3Var.v(this.f18925e.p().i());
        if (!this.f18924d.k(l3Var, this.f18929i) || !l3Var.q()) {
            return false;
        }
        this.f18927g = l3Var;
        l(l3Var);
        e(l3Var);
        d();
        return true;
    }

    public void a(boolean z10, long j10) {
        if (z10 && j10 - i.b() >= this.f18922b && this.f18923c.g()) {
            q(new Date(), this.f18925e.z(), true);
        }
        updateState(new v3.o(z10, h()));
    }

    /* access modifiers changed from: package-private */
    public void b(l3 l3Var) {
        try {
            this.f18929i.d("SessionTracker#trackSessionIfNeeded() - attempting initial delivery");
            int i10 = c.f18934a[c(l3Var).ordinal()];
            if (i10 == 1) {
                this.f18929i.d("Sent 1 new session to Bugsnag");
            } else if (i10 == 2) {
                this.f18929i.g("Storing session payload for future delivery");
                this.f18926f.k(l3Var);
            } else if (i10 == 3) {
                this.f18929i.g("Dropping invalid session tracking payload");
            }
        } catch (Exception e10) {
            this.f18929i.c("Session tracking payload failed", e10);
        }
    }

    /* access modifiers changed from: package-private */
    public v0 c(l3 l3Var) {
        return this.f18923c.i().b(l3Var, this.f18923c.F(l3Var));
    }

    /* access modifiers changed from: package-private */
    public void d() {
        try {
            this.f18928h.d(s.SESSION_REQUEST, new a());
        } catch (RejectedExecutionException e10) {
            this.f18929i.c("Failed to flush session reports", e10);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(File file) {
        this.f18929i.d("SessionTracker#flushStoredSession() - attempting delivery");
        l3 l3Var = new l3(file, this.f18925e.w(), this.f18929i, this.f18923c.a());
        if (l3Var.l()) {
            l3Var.u(this.f18925e.k().d());
            l3Var.v(this.f18925e.p().i());
        }
        int i10 = c.f18934a[c(l3Var).ordinal()];
        if (i10 == 1) {
            this.f18926f.b(Collections.singletonList(file));
            this.f18929i.d("Sent 1 new session to Bugsnag");
        } else if (i10 != 2) {
            if (i10 == 3) {
                this.f18929i.g("Deleting invalid session tracking payload");
                this.f18926f.b(Collections.singletonList(file));
            }
        } else if (this.f18926f.o(file)) {
            s2 s2Var = this.f18929i;
            s2Var.g("Discarding historical session (from {" + this.f18926f.n(file) + "}) after failed delivery");
            this.f18926f.b(Collections.singletonList(file));
        } else {
            this.f18926f.a(Collections.singletonList(file));
            this.f18929i.g("Leaving session payload for future delivery");
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        for (File f10 : this.f18926f.e()) {
            f(f10);
        }
    }

    /* access modifiers changed from: package-private */
    public String h() {
        String str;
        synchronized (this.f18921a) {
            str = (String) this.f18921a.peekLast();
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public l3 i() {
        l3 l3Var = this.f18927g;
        if (l3Var == null || l3Var.m()) {
            return null;
        }
        return l3Var;
    }

    /* access modifiers changed from: package-private */
    public long j() {
        return i.a();
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return i.e();
    }

    /* access modifiers changed from: package-private */
    public void m() {
        l3 l3Var = this.f18927g;
        if (l3Var != null) {
            l3Var.o();
            updateState(v3.l.f19066a);
        }
    }

    /* access modifiers changed from: package-private */
    public l3 n(Date date, String str, k4 k4Var, int i10, int i11) {
        l3 l3Var = null;
        if (this.f18925e.m().P(false)) {
            return null;
        }
        if (date == null || str == null) {
            updateState(v3.l.f19066a);
        } else {
            l3Var = new l3(str, date, k4Var, i10, i11, this.f18925e.w(), this.f18929i, this.f18923c.a());
            l(l3Var);
        }
        this.f18927g = l3Var;
        return l3Var;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        boolean z10;
        l3 l3Var = this.f18927g;
        if (l3Var == null) {
            z10 = false;
            l3Var = r(false);
        } else {
            z10 = l3Var.p();
        }
        if (l3Var != null) {
            l(l3Var);
        }
        return z10;
    }

    public void onActivityStarted(Activity activity) {
        t(activity.getClass().getSimpleName(), true);
    }

    public void onActivityStopped(Activity activity) {
        t(activity.getClass().getSimpleName(), false);
    }

    /* access modifiers changed from: package-private */
    public l3 q(Date date, k4 k4Var, boolean z10) {
        if (p(z10)) {
            return null;
        }
        l3 l3Var = new l3(UUID.randomUUID().toString(), date, k4Var, z10, this.f18925e.w(), this.f18929i, this.f18923c.a());
        if (s(l3Var)) {
            return l3Var;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public l3 r(boolean z10) {
        if (p(z10)) {
            return null;
        }
        return q(new Date(), this.f18925e.z(), z10);
    }

    /* access modifiers changed from: package-private */
    public void t(String str, boolean z10) {
        if (z10) {
            synchronized (this.f18921a) {
                this.f18921a.add(str);
            }
        } else {
            synchronized (this.f18921a) {
                this.f18921a.removeLastOccurrence(str);
            }
        }
        this.f18925e.o().d(h());
    }

    p3(j jVar, y yVar, z zVar, long j10, o3 o3Var, s2 s2Var, c1.a aVar) {
        this.f18921a = new ArrayDeque();
        this.f18927g = null;
        this.f18930j = true;
        this.f18923c = jVar;
        this.f18924d = yVar;
        this.f18925e = zVar;
        this.f18922b = j10;
        this.f18926f = o3Var;
        this.f18928h = aVar;
        this.f18929i = s2Var;
    }
}
