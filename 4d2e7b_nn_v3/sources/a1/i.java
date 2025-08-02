package a1;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class i extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue f13610a;

    /* renamed from: b  reason: collision with root package name */
    private final h f13611b;

    /* renamed from: c  reason: collision with root package name */
    private final b f13612c;

    /* renamed from: d  reason: collision with root package name */
    private final q f13613d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f13614e = false;

    public i(BlockingQueue blockingQueue, h hVar, b bVar, q qVar) {
        this.f13610a = blockingQueue;
        this.f13611b = hVar;
        this.f13612c = bVar;
        this.f13613d = qVar;
    }

    private void a(n nVar) {
        TrafficStats.setThreadStatsTag(nVar.r());
    }

    private void b(n nVar, u uVar) {
        this.f13613d.a(nVar, nVar.y(uVar));
    }

    private void c() throws InterruptedException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        n nVar = (n) this.f13610a.take();
        try {
            nVar.b("network-queue-take");
            if (nVar.u()) {
                nVar.g("network-discard-cancelled");
                nVar.w();
                return;
            }
            a(nVar);
            k a10 = this.f13611b.a(nVar);
            nVar.b("network-http-complete");
            if (!a10.f13619e || !nVar.t()) {
                p z10 = nVar.z(a10);
                nVar.b("network-parse-complete");
                if (nVar.F() && z10.f13651b != null) {
                    this.f13612c.a(nVar.k(), z10.f13651b);
                    nVar.b("network-cache-written");
                }
                nVar.v();
                this.f13613d.c(nVar, z10);
                nVar.x(z10);
                return;
            }
            nVar.g("not-modified");
            nVar.w();
        } catch (u e10) {
            e10.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            b(nVar, e10);
            nVar.w();
        } catch (Exception e11) {
            v.d(e11, "Unhandled exception %s", e11.toString());
            u uVar = new u((Throwable) e11);
            uVar.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f13613d.a(nVar, uVar);
            nVar.w();
        }
    }

    public void d() {
        this.f13614e = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                c();
            } catch (InterruptedException unused) {
                if (this.f13614e) {
                    return;
                }
            }
        }
    }
}
