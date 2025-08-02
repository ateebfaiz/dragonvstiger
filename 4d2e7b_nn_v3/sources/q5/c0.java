package q5;

import com.facebook.o;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import kotlin.jvm.internal.m;

public final class c0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Object f23264a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public CountDownLatch f23265b = new CountDownLatch(1);

    static final class a implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c0 f23266a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Callable f23267b;

        a(c0 c0Var, Callable callable) {
            this.f23266a = c0Var;
            this.f23267b = callable;
        }

        /* renamed from: a */
        public final Void call() {
            try {
                this.f23266a.f23264a = this.f23267b.call();
            } finally {
                CountDownLatch a10 = this.f23266a.f23265b;
                if (a10 != null) {
                    a10.countDown();
                }
            }
        }
    }

    public c0(Callable callable) {
        m.f(callable, "callable");
        o.p().execute(new FutureTask(new a(this, callable)));
    }

    private final void d() {
        CountDownLatch countDownLatch = this.f23265b;
        if (countDownLatch != null) {
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public final Object c() {
        d();
        return this.f23264a;
    }
}
