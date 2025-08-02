package ec;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.channels.h;

public final class n {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f215b;

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f216c;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f217d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f218e;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReferenceArray f219a = new AtomicReferenceArray(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    static {
        Class<n> cls = n.class;
        f215b = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        f216c = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        f217d = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        f218e = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    private final h b(h hVar) {
        if (d() == 127) {
            return hVar;
        }
        if (hVar.taskContext.b() == 1) {
            f218e.incrementAndGet(this);
        }
        int i10 = f216c.get(this) & 127;
        while (this.f219a.get(i10) != null) {
            Thread.yield();
        }
        this.f219a.lazySet(i10, hVar);
        f216c.incrementAndGet(this);
        return null;
    }

    private final void c(h hVar) {
        if (hVar != null && hVar.taskContext.b() == 1) {
            f218e.decrementAndGet(this);
        }
    }

    private final int d() {
        return f216c.get(this) - f217d.get(this);
    }

    private final h i() {
        h hVar;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f217d;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 - f216c.get(this) == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 + 1) && (hVar = (h) this.f219a.getAndSet(i11, (Object) null)) != null) {
                c(hVar);
                return hVar;
            }
        }
    }

    private final boolean j(d dVar) {
        h i10 = i();
        if (i10 == null) {
            return false;
        }
        dVar.a(i10);
        return true;
    }

    private final h k(boolean z10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        h hVar;
        do {
            atomicReferenceFieldUpdater = f215b;
            hVar = (h) atomicReferenceFieldUpdater.get(this);
            if (hVar != null) {
                boolean z11 = true;
                if (hVar.taskContext.b() != 1) {
                    z11 = false;
                }
                if (z11 == z10) {
                }
            }
            int i10 = f217d.get(this);
            int i11 = f216c.get(this);
            while (i10 != i11) {
                if (z10 && f218e.get(this) == 0) {
                    return null;
                }
                i11--;
                h m10 = m(i11, z10);
                if (m10 != null) {
                    return m10;
                }
            }
            return null;
        } while (!a.a(atomicReferenceFieldUpdater, this, hVar, (Object) null));
        return hVar;
    }

    private final h l(int i10) {
        int i11 = f217d.get(this);
        int i12 = f216c.get(this);
        boolean z10 = true;
        if (i10 != 1) {
            z10 = false;
        }
        while (i11 != i12) {
            if (z10 && f218e.get(this) == 0) {
                return null;
            }
            int i13 = i11 + 1;
            h m10 = m(i11, z10);
            if (m10 != null) {
                return m10;
            }
            i11 = i13;
        }
        return null;
    }

    private final h m(int i10, boolean z10) {
        int i11 = i10 & 127;
        h hVar = (h) this.f219a.get(i11);
        if (hVar != null) {
            boolean z11 = true;
            if (hVar.taskContext.b() != 1) {
                z11 = false;
            }
            if (z11 == z10 && h.a(this.f219a, i11, hVar, (Object) null)) {
                if (z10) {
                    f218e.decrementAndGet(this);
                }
                return hVar;
            }
        }
        return null;
    }

    private final long o(int i10, y yVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        h hVar;
        do {
            atomicReferenceFieldUpdater = f215b;
            hVar = (h) atomicReferenceFieldUpdater.get(this);
            if (hVar == null) {
                return -2;
            }
            int i11 = 1;
            if (hVar.taskContext.b() != 1) {
                i11 = 2;
            }
            if ((i11 & i10) == 0) {
                return -2;
            }
            long a10 = l.f211f.a() - hVar.submissionTime;
            long j10 = l.f207b;
            if (a10 < j10) {
                return j10 - a10;
            }
        } while (!a.a(atomicReferenceFieldUpdater, this, hVar, (Object) null));
        yVar.f725a = hVar;
        return -1;
    }

    public final h a(h hVar, boolean z10) {
        if (z10) {
            return b(hVar);
        }
        h hVar2 = (h) f215b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return b(hVar2);
    }

    public final int e() {
        if (f215b.get(this) != null) {
            return d() + 1;
        }
        return d();
    }

    public final void f(d dVar) {
        h hVar = (h) f215b.getAndSet(this, (Object) null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        do {
        } while (j(dVar));
    }

    public final h g() {
        h hVar = (h) f215b.getAndSet(this, (Object) null);
        if (hVar == null) {
            return i();
        }
        return hVar;
    }

    public final h h() {
        return k(true);
    }

    public final long n(int i10, y yVar) {
        h hVar;
        if (i10 == 3) {
            hVar = i();
        } else {
            hVar = l(i10);
        }
        if (hVar == null) {
            return o(i10, yVar);
        }
        yVar.f725a = hVar;
        return -1;
    }
}
