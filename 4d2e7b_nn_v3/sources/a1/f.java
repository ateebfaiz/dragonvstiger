package a1;

import android.os.Handler;
import java.util.concurrent.Executor;

public class f implements q {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f13601a;

    class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Handler f13602a;

        a(Handler handler) {
            this.f13602a = handler;
        }

        public void execute(Runnable runnable) {
            this.f13602a.post(runnable);
        }
    }

    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final n f13604a;

        /* renamed from: b  reason: collision with root package name */
        private final p f13605b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f13606c;

        public b(n nVar, p pVar, Runnable runnable) {
            this.f13604a = nVar;
            this.f13605b = pVar;
            this.f13606c = runnable;
        }

        public void run() {
            if (this.f13604a.u()) {
                this.f13604a.g("canceled-at-delivery");
                return;
            }
            if (this.f13605b.b()) {
                this.f13604a.e(this.f13605b.f13650a);
            } else {
                this.f13604a.d(this.f13605b.f13652c);
            }
            if (this.f13605b.f13653d) {
                this.f13604a.b("intermediate-response");
            } else {
                this.f13604a.g("done");
            }
            Runnable runnable = this.f13606c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public f(Handler handler) {
        this.f13601a = new a(handler);
    }

    public void a(n nVar, u uVar) {
        nVar.b("post-error");
        this.f13601a.execute(new b(nVar, p.a(uVar), (Runnable) null));
    }

    public void b(n nVar, p pVar, Runnable runnable) {
        nVar.v();
        nVar.b("post-response");
        this.f13601a.execute(new b(nVar, pVar, runnable));
    }

    public void c(n nVar, p pVar) {
        b(nVar, pVar, (Runnable) null);
    }
}
