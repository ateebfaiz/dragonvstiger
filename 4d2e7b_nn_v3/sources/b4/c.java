package b4;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class c extends b {

    /* renamed from: e  reason: collision with root package name */
    private final f3.c f17177e;

    /* renamed from: f  reason: collision with root package name */
    private final ScheduledExecutorService f17178f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f17179g = false;

    /* renamed from: h  reason: collision with root package name */
    private long f17180h;

    /* renamed from: i  reason: collision with root package name */
    private long f17181i = 2000;

    /* renamed from: j  reason: collision with root package name */
    private long f17182j = 1000;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public b f17183k;

    /* renamed from: l  reason: collision with root package name */
    private final Runnable f17184l = new a();

    class a implements Runnable {
        a() {
        }

        public void run() {
            synchronized (c.this) {
                try {
                    c.this.f17179g = false;
                    if (!c.this.r()) {
                        c.this.s();
                    } else if (c.this.f17183k != null) {
                        c.this.f17183k.d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public interface b {
        void d();
    }

    private c(a aVar, b bVar, f3.c cVar, ScheduledExecutorService scheduledExecutorService) {
        super(aVar);
        this.f17183k = bVar;
        this.f17177e = cVar;
        this.f17178f = scheduledExecutorService;
    }

    public static b p(a aVar, b bVar, f3.c cVar, ScheduledExecutorService scheduledExecutorService) {
        return new c(aVar, bVar, cVar, scheduledExecutorService);
    }

    public static b q(a aVar, f3.c cVar, ScheduledExecutorService scheduledExecutorService) {
        return p(aVar, (b) aVar, cVar, scheduledExecutorService);
    }

    /* access modifiers changed from: private */
    public boolean r() {
        if (this.f17177e.now() - this.f17180h > this.f17181i) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public synchronized void s() {
        if (!this.f17179g) {
            this.f17179g = true;
            this.f17178f.schedule(this.f17184l, this.f17182j, TimeUnit.MILLISECONDS);
        }
    }

    public boolean l(Drawable drawable, Canvas canvas, int i10) {
        this.f17180h = this.f17177e.now();
        boolean l10 = super.l(drawable, canvas, i10);
        s();
        return l10;
    }
}
