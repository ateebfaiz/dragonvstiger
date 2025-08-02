package y8;

import androidx.work.WorkRequest;
import g0.c;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final Function0 f13346a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13347b;

    /* renamed from: c  reason: collision with root package name */
    private final long f13348c;

    /* renamed from: d  reason: collision with root package name */
    private final long f13349d;

    /* renamed from: e  reason: collision with root package name */
    private final ConcurrentLinkedQueue f13350e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f13351f;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f13352a;

        /* renamed from: b  reason: collision with root package name */
        private long f13353b;

        public a(Object obj, long j10) {
            this.f13352a = obj;
            this.f13353b = j10;
        }

        public final long a() {
            return this.f13353b;
        }

        public final Object b() {
            return this.f13352a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (m.b(this.f13352a, aVar.f13352a) && this.f13353b == aVar.f13353b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            Object obj = this.f13352a;
            if (obj == null) {
                i10 = 0;
            } else {
                i10 = obj.hashCode();
            }
            return (i10 * 31) + c.a(this.f13353b);
        }

        public String toString() {
            Object obj = this.f13352a;
            long j10 = this.f13353b;
            return "Wrapper(obj=" + obj + ", lastUsed=" + j10 + ")";
        }
    }

    public g(Function0 function0, int i10, long j10, long j11) {
        m.f(function0, "creator");
        this.f13346a = function0;
        this.f13347b = i10;
        this.f13348c = j10;
        this.f13349d = j11;
        this.f13350e = new ConcurrentLinkedQueue();
        this.f13351f = new AtomicInteger(0);
        Executors.newSingleThreadScheduledExecutor(new e()).scheduleAtFixedRate(new f(this), j11, j11, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    public static final Thread c(Runnable runnable) {
        Thread thread = new Thread(runnable, "ObjectPool-Cleaner");
        thread.setDaemon(true);
        return thread;
    }

    /* access modifiers changed from: private */
    public static final void d(g gVar) {
        m.f(gVar, "this$0");
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = gVar.f13350e.iterator();
        m.e(it, "pool.iterator()");
        while (it.hasNext()) {
            if (currentTimeMillis - ((a) it.next()).a() > gVar.f13348c) {
                it.remove();
                gVar.f13351f.decrementAndGet();
            }
        }
    }

    public final Object e() {
        a aVar = (a) this.f13350e.poll();
        if (aVar == null) {
            return this.f13346a.invoke();
        }
        this.f13351f.decrementAndGet();
        return aVar.b();
    }

    public final void f(Object obj) {
        if (this.f13351f.get() < this.f13347b) {
            this.f13350e.offer(new a(obj, System.currentTimeMillis()));
            this.f13351f.incrementAndGet();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Function0 function0, int i10, long j10, long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i11 & 2) != 0 ? Integer.MAX_VALUE : i10, (i11 & 4) != 0 ? WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS : j10, (i11 & 8) != 0 ? WorkRequest.MIN_BACKOFF_MILLIS : j11);
    }
}
