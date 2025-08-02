package cc;

import androidx.core.internal.view.SupportMenu;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.q1;

public abstract class z extends d implements q1 {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f112d = AtomicIntegerFieldUpdater.newUpdater(z.class, "cleanedAndPointers");

    /* renamed from: c  reason: collision with root package name */
    public final long f113c;
    private volatile int cleanedAndPointers;

    public z(long j10, z zVar, int i10) {
        super(zVar);
        this.f113c = j10;
        this.cleanedAndPointers = i10 << 16;
    }

    public boolean h() {
        if (f112d.get(this) != n() || i()) {
            return false;
        }
        return true;
    }

    public final boolean m() {
        if (f112d.addAndGet(this, SupportMenu.CATEGORY_MASK) != n() || i()) {
            return false;
        }
        return true;
    }

    public abstract int n();

    public abstract void o(int i10, Throwable th, CoroutineContext coroutineContext);

    public final void p() {
        if (f112d.incrementAndGet(this) == n()) {
            k();
        }
    }

    public final boolean q() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f112d;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 == n() && !i()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 65536 + i10));
        return true;
    }
}
