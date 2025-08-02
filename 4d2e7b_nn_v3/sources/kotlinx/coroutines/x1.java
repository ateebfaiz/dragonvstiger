package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.f;
import kotlin.jvm.functions.Function1;

final class x1 implements Function1 {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f1206d = AtomicIntegerFieldUpdater.newUpdater(x1.class, "_state");
    private volatile int _state;

    /* renamed from: a  reason: collision with root package name */
    private final f1 f1207a;

    /* renamed from: b  reason: collision with root package name */
    private final Thread f1208b = Thread.currentThread();

    /* renamed from: c  reason: collision with root package name */
    private m0 f1209c;

    public x1(f1 f1Var) {
        this.f1207a = f1Var;
    }

    private final Void b(int i10) {
        throw new IllegalStateException(("Illegal state " + i10).toString());
    }

    public final void a() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f1206d;
        while (true) {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        b(i10);
                        throw new f();
                    }
                }
            } else if (f1206d.compareAndSet(this, i10, 1)) {
                m0 m0Var = this.f1209c;
                if (m0Var != null) {
                    m0Var.dispose();
                    return;
                }
                return;
            }
        }
    }

    public void c(Throwable th) {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = f1206d;
        do {
            i10 = atomicIntegerFieldUpdater2.get(this);
            if (i10 == 0) {
                atomicIntegerFieldUpdater = f1206d;
            } else if (i10 != 1 && i10 != 2 && i10 != 3) {
                b(i10);
                throw new f();
            } else {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 2));
        this.f1208b.interrupt();
        atomicIntegerFieldUpdater.set(this, 3);
    }

    public final void d() {
        int i10;
        this.f1209c = this.f1207a.m(true, true, this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f1206d;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 != 2 && i10 != 3) {
                    b(i10);
                    throw new f();
                }
                return;
            }
        } while (!f1206d.compareAndSet(this, i10, 0));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        c((Throwable) obj);
        return Unit.f12577a;
    }
}
