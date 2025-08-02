package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

class f implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f16478a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque f16479b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    private Runnable f16480c;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f16481a;

        a(Runnable runnable) {
            this.f16481a = runnable;
        }

        public void run() {
            try {
                this.f16481a.run();
            } finally {
                f.this.a();
            }
        }
    }

    f(Executor executor) {
        this.f16478a = executor;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        Runnable runnable = (Runnable) this.f16479b.poll();
        this.f16480c = runnable;
        if (runnable != null) {
            this.f16478a.execute(runnable);
        }
    }

    public synchronized void execute(Runnable runnable) {
        this.f16479b.offer(new a(runnable));
        if (this.f16480c == null) {
            a();
        }
    }
}
