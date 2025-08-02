package com.onesignal;

import com.onesignal.o3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class q2 {

    /* renamed from: a  reason: collision with root package name */
    private Set f10984a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final pa.c f10985b;

    /* renamed from: c  reason: collision with root package name */
    private final x2 f10986c;

    class a implements Runnable {
        a() {
        }

        public void run() {
            Thread.currentThread().setPriority(10);
            q2.this.f10985b.b().g("notification", "notification_id");
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            Thread.currentThread().setPriority(10);
            for (qa.b b10 : q2.this.f10985b.b().d()) {
                q2.this.p(b10);
            }
        }
    }

    class c implements r3 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ qa.b f10989a;

        c(qa.b bVar) {
            this.f10989a = bVar;
        }

        public void a(int i10, String str, Throwable th) {
        }

        public void onSuccess(String str) {
            q2.this.f10985b.b().i(this.f10989a);
        }
    }

    class d implements r3 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ qa.b f10991a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f10992b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f10993c;

        class a implements Runnable {
            a() {
            }

            public void run() {
                Thread.currentThread().setPriority(10);
                d dVar = d.this;
                dVar.f10991a.f(dVar.f10992b);
                q2.this.f10985b.b().a(d.this.f10991a);
            }
        }

        d(qa.b bVar, o3.y yVar, long j10, String str) {
            this.f10991a = bVar;
            this.f10992b = j10;
            this.f10993c = str;
        }

        public void a(int i10, String str, Throwable th) {
            new Thread(new a(), "OS_SAVE_OUTCOMES").start();
            o3.v vVar = o3.v.WARN;
            o3.d1(vVar, "Sending outcome with name: " + this.f10993c + " failed with status code: " + i10 + " and response: " + str + "\nOutcome event was cached and will be reattempted on app cold start");
        }

        public void onSuccess(String str) {
            q2.this.k(this.f10991a);
        }
    }

    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ qa.b f10996a;

        e(qa.b bVar) {
            this.f10996a = bVar;
        }

        public void run() {
            Thread.currentThread().setPriority(10);
            q2.this.f10985b.b().b(this.f10996a);
        }
    }

    static /* synthetic */ class f {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10998a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f10999b;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        static {
            /*
                na.b[] r0 = na.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10999b = r0
                r1 = 1
                na.b r2 = na.b.IAM     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f10999b     // Catch:{ NoSuchFieldError -> 0x001d }
                na.b r3 = na.b.NOTIFICATION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                na.c[] r2 = na.c.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f10998a = r2
                na.c r3 = na.c.DIRECT     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f10998a     // Catch:{ NoSuchFieldError -> 0x0038 }
                na.c r2 = na.c.INDIRECT     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = f10998a     // Catch:{ NoSuchFieldError -> 0x0043 }
                na.c r1 = na.c.UNATTRIBUTED     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f10998a     // Catch:{ NoSuchFieldError -> 0x004e }
                na.c r1 = na.c.DISABLED     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.q2.f.<clinit>():void");
        }
    }

    public q2(x2 x2Var, pa.c cVar) {
        this.f10986c = x2Var;
        this.f10985b = cVar;
        g();
    }

    private List f(String str, List list) {
        List c10 = this.f10985b.b().c(str, list);
        if (c10.size() > 0) {
            return c10;
        }
        return null;
    }

    private void g() {
        this.f10984a = OSUtils.K();
        Set h10 = this.f10985b.b().h();
        if (h10 != null) {
            this.f10984a = h10;
        }
    }

    private List h(List list) {
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            na.a aVar = (na.a) it.next();
            if (aVar.d().d()) {
                o3.v vVar = o3.v.DEBUG;
                o3.d1(vVar, "Outcomes disabled for channel: " + aVar.c().toString());
                arrayList.remove(aVar);
            }
        }
        return arrayList;
    }

    private void i(qa.b bVar) {
        new Thread(new e(bVar), "OS_SAVE_UNIQUE_OUTCOME_NOTIFICATIONS").start();
    }

    private void j() {
        this.f10985b.b().e(this.f10984a);
    }

    /* access modifiers changed from: private */
    public void k(qa.b bVar) {
        if (bVar.e()) {
            j();
        } else {
            i(bVar);
        }
    }

    private void l(String str, float f10, List list, o3.y yVar) {
        o3.y yVar2 = yVar;
        long b10 = o3.w0().b() / 1000;
        int e10 = new OSUtils().e();
        String str2 = o3.f10886d;
        Iterator it = list.iterator();
        boolean z10 = false;
        qa.e eVar = null;
        qa.e eVar2 = null;
        while (it.hasNext()) {
            na.a aVar = (na.a) it.next();
            int i10 = f.f10998a[aVar.d().ordinal()];
            if (i10 == 1) {
                if (eVar == null) {
                    eVar = new qa.e();
                }
                eVar = t(aVar, eVar);
            } else if (i10 == 2) {
                if (eVar2 == null) {
                    eVar2 = new qa.e();
                }
                eVar2 = t(aVar, eVar2);
            } else if (i10 == 3) {
                z10 = true;
            } else if (i10 == 4) {
                o3.a(o3.v.VERBOSE, "Outcomes disabled for channel: " + aVar.c());
                if (yVar2 != null) {
                    yVar2.a((p2) null);
                    return;
                }
                return;
            }
        }
        if (eVar == null && eVar2 == null && !z10) {
            o3.a(o3.v.VERBOSE, "Outcomes disabled for all channels");
            if (yVar2 != null) {
                yVar2.a((p2) null);
                return;
            }
            return;
        }
        qa.b bVar = new qa.b(str, new qa.d(eVar, eVar2), f10, 0);
        this.f10985b.b().f(str2, e10, bVar, new d(bVar, yVar, b10, str));
    }

    /* access modifiers changed from: private */
    public void p(qa.b bVar) {
        int e10 = new OSUtils().e();
        this.f10985b.b().f(o3.f10886d, e10, bVar, new c(bVar));
    }

    private void s(String str, List list, o3.y yVar) {
        List<na.a> h10 = h(list);
        if (h10.isEmpty()) {
            o3.a(o3.v.DEBUG, "Unique Outcome disabled for current session");
            return;
        }
        for (na.a d10 : h10) {
            if (d10.d().b()) {
                List f10 = f(str, h10);
                if (f10 == null) {
                    o3.v vVar = o3.v.DEBUG;
                    o3.a(vVar, "Measure endpoint will not send because unique outcome already sent for: \nSessionInfluences: " + h10.toString() + "\nOutcome name: " + str);
                    if (yVar != null) {
                        yVar.a((p2) null);
                        return;
                    }
                    return;
                }
                l(str, 0.0f, f10, yVar);
                return;
            }
        }
        if (this.f10984a.contains(str)) {
            o3.v vVar2 = o3.v.DEBUG;
            o3.a(vVar2, "Measure endpoint will not send because unique outcome already sent for: \nSession: " + na.c.UNATTRIBUTED + "\nOutcome name: " + str);
            if (yVar != null) {
                yVar.a((p2) null);
                return;
            }
            return;
        }
        this.f10984a.add(str);
        l(str, 0.0f, h10, yVar);
    }

    private qa.e t(na.a aVar, qa.e eVar) {
        int i10 = f.f10999b[aVar.c().ordinal()];
        if (i10 == 1) {
            eVar.c(aVar.b());
        } else if (i10 == 2) {
            eVar.d(aVar.b());
        }
        return eVar;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        new Thread(new a(), "OS_DELETE_CACHED_UNIQUE_OUTCOMES_NOTIFICATIONS_THREAD").start();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        o3.a(o3.v.DEBUG, "OneSignal cleanOutcomes for session");
        this.f10984a = OSUtils.K();
        j();
    }

    /* access modifiers changed from: package-private */
    public void m(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            s1 s1Var = (s1) it.next();
            String a10 = s1Var.a();
            if (s1Var.c()) {
                r(a10, (o3.y) null);
            } else if (s1Var.b() > 0.0f) {
                o(a10, s1Var.b(), (o3.y) null);
            } else {
                n(a10, (o3.y) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void n(String str, o3.y yVar) {
        l(str, 0.0f, this.f10986c.e(), yVar);
    }

    /* access modifiers changed from: package-private */
    public void o(String str, float f10, o3.y yVar) {
        l(str, f10, this.f10986c.e(), yVar);
    }

    /* access modifiers changed from: package-private */
    public void q() {
        new Thread(new b(), "OS_SEND_SAVED_OUTCOMES").start();
    }

    /* access modifiers changed from: package-private */
    public void r(String str, o3.y yVar) {
        s(str, this.f10986c.e(), yVar);
    }
}
