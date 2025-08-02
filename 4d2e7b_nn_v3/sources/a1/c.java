package a1;

import a1.b;
import a1.n;
import android.os.Process;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class c extends Thread {

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f13586g = v.f13657b;

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue f13587a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue f13588b;

    /* renamed from: c  reason: collision with root package name */
    private final b f13589c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final q f13590d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f13591e = false;

    /* renamed from: f  reason: collision with root package name */
    private final b f13592f;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f13593a;

        a(n nVar) {
            this.f13593a = nVar;
        }

        public void run() {
            try {
                c.this.f13588b.put(this.f13593a);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private static class b implements n.b {

        /* renamed from: a  reason: collision with root package name */
        private final Map f13595a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final c f13596b;

        b(c cVar) {
            this.f13596b = cVar;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean d(a1.n r6) {
            /*
                r5 = this;
                r0 = 0
                r1 = 1
                monitor-enter(r5)
                java.lang.String r2 = r6.k()     // Catch:{ all -> 0x001f }
                java.util.Map r3 = r5.f13595a     // Catch:{ all -> 0x001f }
                boolean r3 = r3.containsKey(r2)     // Catch:{ all -> 0x001f }
                if (r3 == 0) goto L_0x003d
                java.util.Map r3 = r5.f13595a     // Catch:{ all -> 0x001f }
                java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x001f }
                java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x001f }
                if (r3 != 0) goto L_0x0021
                java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x001f }
                r3.<init>()     // Catch:{ all -> 0x001f }
                goto L_0x0021
            L_0x001f:
                r6 = move-exception
                goto L_0x0055
            L_0x0021:
                java.lang.String r4 = "waiting-for-response"
                r6.b(r4)     // Catch:{ all -> 0x001f }
                r3.add(r6)     // Catch:{ all -> 0x001f }
                java.util.Map r6 = r5.f13595a     // Catch:{ all -> 0x001f }
                r6.put(r2, r3)     // Catch:{ all -> 0x001f }
                boolean r6 = a1.v.f13657b     // Catch:{ all -> 0x001f }
                if (r6 == 0) goto L_0x003b
                java.lang.String r6 = "Request for cacheKey=%s is in flight, putting on hold."
                java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x001f }
                r3[r0] = r2     // Catch:{ all -> 0x001f }
                a1.v.b(r6, r3)     // Catch:{ all -> 0x001f }
            L_0x003b:
                monitor-exit(r5)
                return r1
            L_0x003d:
                java.util.Map r3 = r5.f13595a     // Catch:{ all -> 0x001f }
                r4 = 0
                r3.put(r2, r4)     // Catch:{ all -> 0x001f }
                r6.B(r5)     // Catch:{ all -> 0x001f }
                boolean r6 = a1.v.f13657b     // Catch:{ all -> 0x001f }
                if (r6 == 0) goto L_0x0053
                java.lang.String r6 = "new request, sending to network %s"
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x001f }
                r1[r0] = r2     // Catch:{ all -> 0x001f }
                a1.v.b(r6, r1)     // Catch:{ all -> 0x001f }
            L_0x0053:
                monitor-exit(r5)
                return r0
            L_0x0055:
                monitor-exit(r5)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: a1.c.b.d(a1.n):boolean");
        }

        public synchronized void a(n nVar) {
            try {
                String k10 = nVar.k();
                List list = (List) this.f13595a.remove(k10);
                if (list != null && !list.isEmpty()) {
                    if (v.f13657b) {
                        v.e("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), k10);
                    }
                    n nVar2 = (n) list.remove(0);
                    this.f13595a.put(k10, list);
                    nVar2.B(this);
                    this.f13596b.f13588b.put(nVar2);
                }
            } catch (InterruptedException e10) {
                v.c("Couldn't add request to queue. %s", e10.toString());
                Thread.currentThread().interrupt();
                this.f13596b.d();
            } catch (Throwable th) {
                throw th;
            }
        }

        public void b(n nVar, p pVar) {
            List<n> list;
            b.a aVar = pVar.f13651b;
            if (aVar == null || aVar.a()) {
                a(nVar);
                return;
            }
            String k10 = nVar.k();
            synchronized (this) {
                list = (List) this.f13595a.remove(k10);
            }
            if (list != null) {
                if (v.f13657b) {
                    v.e("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), k10);
                }
                for (n c10 : list) {
                    this.f13596b.f13590d.c(c10, pVar);
                }
            }
        }
    }

    public c(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, b bVar, q qVar) {
        this.f13587a = blockingQueue;
        this.f13588b = blockingQueue2;
        this.f13589c = bVar;
        this.f13590d = qVar;
        this.f13592f = new b(this);
    }

    private void c() throws InterruptedException {
        n nVar = (n) this.f13587a.take();
        nVar.b("cache-queue-take");
        if (nVar.u()) {
            nVar.g("cache-discard-canceled");
            return;
        }
        b.a aVar = this.f13589c.get(nVar.k());
        if (aVar == null) {
            nVar.b("cache-miss");
            if (!this.f13592f.d(nVar)) {
                this.f13588b.put(nVar);
            }
        } else if (aVar.a()) {
            nVar.b("cache-hit-expired");
            nVar.A(aVar);
            if (!this.f13592f.d(nVar)) {
                this.f13588b.put(nVar);
            }
        } else {
            nVar.b("cache-hit");
            p z10 = nVar.z(new k(aVar.f13578a, aVar.f13584g));
            nVar.b("cache-hit-parsed");
            if (!aVar.b()) {
                this.f13590d.c(nVar, z10);
                return;
            }
            nVar.b("cache-hit-refresh-needed");
            nVar.A(aVar);
            z10.f13653d = true;
            if (!this.f13592f.d(nVar)) {
                this.f13590d.b(nVar, z10, new a(nVar));
            } else {
                this.f13590d.c(nVar, z10);
            }
        }
    }

    public void d() {
        this.f13591e = true;
        interrupt();
    }

    public void run() {
        if (f13586g) {
            v.e("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f13589c.initialize();
        while (true) {
            try {
                c();
            } catch (InterruptedException unused) {
                if (this.f13591e) {
                    return;
                }
            }
        }
    }
}
