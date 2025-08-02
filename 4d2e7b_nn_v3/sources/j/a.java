package j;

import i.u;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import w.d;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final String f22132c = d.f("");

    /* renamed from: d  reason: collision with root package name */
    public static final a f22133d = new a();

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f22134a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f22135b = new AtomicBoolean(false);

    public a() {
        ScheduledThreadPoolExecutor a10 = u.a("MahScheduled-Thread", 2);
        this.f22134a = a10;
        a10.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        a10.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
    }

    public static a a() {
        return f22133d;
    }

    public b b(c cVar) {
        if (d()) {
            return null;
        }
        if (cVar != null) {
            try {
                return new b(this.f22134a.scheduleAtFixedRate(cVar, cVar.a(), cVar.b(), TimeUnit.MILLISECONDS), cVar);
            } catch (Exception | IllegalArgumentException unused) {
                return null;
            }
        } else {
            throw new IllegalArgumentException("task can not be null");
        }
    }

    public b c(Runnable runnable, long j10) {
        if (d()) {
            return null;
        }
        if (runnable != null) {
            try {
                return new b(this.f22134a.schedule(runnable, j10, TimeUnit.MILLISECONDS), runnable);
            } catch (Exception | IllegalArgumentException unused) {
                return null;
            }
        } else {
            throw new IllegalArgumentException("task can not be null");
        }
    }

    public final boolean d() {
        if (this.f22135b.get()) {
            return true;
        }
        return false;
    }

    public void e() {
        if (this.f22135b.compareAndSet(false, true)) {
            this.f22134a.shutdownNow();
        }
    }
}
