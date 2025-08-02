package j;

import java.util.concurrent.ScheduledFuture;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledFuture f22136a;

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f22137b;

    public b(ScheduledFuture scheduledFuture, Runnable runnable) {
        this.f22136a = scheduledFuture;
        this.f22137b = runnable;
    }

    public boolean a() {
        return this.f22136a.cancel(true);
    }

    public Runnable b() {
        return this.f22137b;
    }

    public boolean c() {
        return this.f22136a.isDone();
    }
}
