package kotlin.coroutines;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.o;

public final class SafeContinuation<T> implements d, b {
    private static final a Companion = new a((DefaultConstructorMarker) null);
    private static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, DbParams.KEY_CHANNEL_RESULT);
    private final d delegate;
    private volatile Object result;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SafeContinuation(d dVar, Object obj) {
        m.f(dVar, "delegate");
        this.delegate = dVar;
        this.result = obj;
    }

    public final Object b() {
        Object obj = this.result;
        kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.UNDECIDED;
        if (obj == aVar) {
            if (androidx.concurrent.futures.a.a(RESULT, this, aVar, kotlin.coroutines.intrinsics.b.c())) {
                return kotlin.coroutines.intrinsics.b.c();
            }
            obj = this.result;
        }
        if (obj == kotlin.coroutines.intrinsics.a.RESUMED) {
            return kotlin.coroutines.intrinsics.b.c();
        }
        if (!(obj instanceof o.b)) {
            return obj;
        }
        throw ((o.b) obj).f12594a;
    }

    public b c() {
        d dVar = this.delegate;
        if (dVar instanceof b) {
            return (b) dVar;
        }
        return null;
    }

    public void d(Object obj) {
        while (true) {
            Object obj2 = this.result;
            kotlin.coroutines.intrinsics.a aVar = kotlin.coroutines.intrinsics.a.UNDECIDED;
            if (obj2 == aVar) {
                if (androidx.concurrent.futures.a.a(RESULT, this, aVar, obj)) {
                    return;
                }
            } else if (obj2 != kotlin.coroutines.intrinsics.b.c()) {
                throw new IllegalStateException("Already resumed");
            } else if (androidx.concurrent.futures.a.a(RESULT, this, kotlin.coroutines.intrinsics.b.c(), kotlin.coroutines.intrinsics.a.RESUMED)) {
                this.delegate.d(obj);
                return;
            }
        }
    }

    public CoroutineContext getContext() {
        return this.delegate.getContext();
    }

    public String toString() {
        return "SafeContinuation for " + this.delegate;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SafeContinuation(d dVar) {
        this(dVar, kotlin.coroutines.intrinsics.a.UNDECIDED);
        m.f(dVar, "delegate");
    }
}
