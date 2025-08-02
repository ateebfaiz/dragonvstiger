package q5;

import com.facebook.l;
import com.facebook.o;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class s0 {

    /* renamed from: g  reason: collision with root package name */
    public static final a f23465g = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f23466a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public c f23467b;

    /* renamed from: c  reason: collision with root package name */
    private c f23468c;

    /* renamed from: d  reason: collision with root package name */
    private int f23469d;

    /* renamed from: e  reason: collision with root package name */
    private final int f23470e;

    /* renamed from: f  reason: collision with root package name */
    private final Executor f23471f;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final void b(boolean z10) {
            if (!z10) {
                throw new l("Validation failed");
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
        void a();

        boolean cancel();
    }

    private final class c implements b {

        /* renamed from: a  reason: collision with root package name */
        private c f23472a;

        /* renamed from: b  reason: collision with root package name */
        private c f23473b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f23474c;

        /* renamed from: d  reason: collision with root package name */
        private final Runnable f23475d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ s0 f23476e;

        public c(s0 s0Var, Runnable runnable) {
            m.f(runnable, "callback");
            this.f23476e = s0Var;
            this.f23475d = runnable;
        }

        public void a() {
            ReentrantLock c10 = this.f23476e.f23466a;
            c10.lock();
            try {
                if (!d()) {
                    s0 s0Var = this.f23476e;
                    s0Var.f23467b = e(s0Var.f23467b);
                    s0 s0Var2 = this.f23476e;
                    s0Var2.f23467b = b(s0Var2.f23467b, true);
                }
                Unit unit = Unit.f12577a;
                c10.unlock();
            } catch (Throwable th) {
                c10.unlock();
                throw th;
            }
        }

        public final c b(c cVar, boolean z10) {
            boolean z11;
            c cVar2;
            a aVar = s0.f23465g;
            boolean z12 = false;
            if (this.f23472a == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            aVar.b(z11);
            if (this.f23473b == null) {
                z12 = true;
            }
            aVar.b(z12);
            if (cVar == null) {
                this.f23473b = this;
                this.f23472a = this;
                cVar = this;
            } else {
                this.f23472a = cVar;
                c cVar3 = cVar.f23473b;
                this.f23473b = cVar3;
                if (cVar3 != null) {
                    cVar3.f23472a = this;
                }
                c cVar4 = this.f23472a;
                if (cVar4 != null) {
                    if (cVar3 != null) {
                        cVar2 = cVar3.f23472a;
                    } else {
                        cVar2 = null;
                    }
                    cVar4.f23473b = cVar2;
                }
            }
            if (z10) {
                return this;
            }
            return cVar;
        }

        public final Runnable c() {
            return this.f23475d;
        }

        /* JADX INFO: finally extract failed */
        public boolean cancel() {
            ReentrantLock c10 = this.f23476e.f23466a;
            c10.lock();
            try {
                if (!d()) {
                    s0 s0Var = this.f23476e;
                    s0Var.f23467b = e(s0Var.f23467b);
                    c10.unlock();
                    return true;
                }
                Unit unit = Unit.f12577a;
                c10.unlock();
                return false;
            } catch (Throwable th) {
                c10.unlock();
                throw th;
            }
        }

        public boolean d() {
            return this.f23474c;
        }

        public final c e(c cVar) {
            boolean z10;
            a aVar = s0.f23465g;
            boolean z11 = false;
            if (this.f23472a != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            aVar.b(z10);
            if (this.f23473b != null) {
                z11 = true;
            }
            aVar.b(z11);
            if (cVar == this && (cVar = this.f23472a) == this) {
                cVar = null;
            }
            c cVar2 = this.f23472a;
            if (cVar2 != null) {
                cVar2.f23473b = this.f23473b;
            }
            c cVar3 = this.f23473b;
            if (cVar3 != null) {
                cVar3.f23472a = cVar2;
            }
            this.f23473b = null;
            this.f23472a = null;
            return cVar;
        }

        public void f(boolean z10) {
            this.f23474c = z10;
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s0 f23477a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f23478b;

        d(s0 s0Var, c cVar) {
            this.f23477a = s0Var;
            this.f23478b = cVar;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    this.f23478b.c().run();
                    this.f23477a.i(this.f23478b);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    public s0(int i10) {
        this(i10, (Executor) null, 2, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ b g(s0 s0Var, Runnable runnable, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return s0Var.f(runnable, z10);
    }

    private final void h(c cVar) {
        this.f23471f.execute(new d(this, cVar));
    }

    /* access modifiers changed from: private */
    public final void i(c cVar) {
        c cVar2;
        this.f23466a.lock();
        if (cVar != null) {
            this.f23468c = cVar.e(this.f23468c);
            this.f23469d--;
        }
        if (this.f23469d < this.f23470e) {
            cVar2 = this.f23467b;
            if (cVar2 != null) {
                this.f23467b = cVar2.e(cVar2);
                this.f23468c = cVar2.b(this.f23468c, false);
                this.f23469d++;
                cVar2.f(true);
            }
        } else {
            cVar2 = null;
        }
        this.f23466a.unlock();
        if (cVar2 != null) {
            h(cVar2);
        }
    }

    private final void j() {
        i((c) null);
    }

    public final b e(Runnable runnable) {
        return g(this, runnable, false, 2, (Object) null);
    }

    /* JADX INFO: finally extract failed */
    public final b f(Runnable runnable, boolean z10) {
        m.f(runnable, "callback");
        c cVar = new c(this, runnable);
        ReentrantLock reentrantLock = this.f23466a;
        reentrantLock.lock();
        try {
            this.f23467b = cVar.b(this.f23467b, z10);
            Unit unit = Unit.f12577a;
            reentrantLock.unlock();
            j();
            return cVar;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public s0(int i10, Executor executor) {
        m.f(executor, "executor");
        this.f23470e = i10;
        this.f23471f = executor;
        this.f23466a = new ReentrantLock();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s0(int i10, Executor executor, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 8 : i10, (i11 & 2) != 0 ? o.p() : executor);
    }
}
