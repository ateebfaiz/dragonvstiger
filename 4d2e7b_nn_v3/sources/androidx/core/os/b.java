package androidx.core.os;

import android.os.OutcomeReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.d;
import kotlin.o;
import kotlin.p;

final class b extends AtomicBoolean implements OutcomeReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final d f15043a;

    public b(d dVar) {
        super(false);
        this.f15043a = dVar;
    }

    public void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            d dVar = this.f15043a;
            o.a aVar = o.f12592b;
            dVar.d(o.b(p.a(th)));
        }
    }

    public void onResult(Object obj) {
        if (compareAndSet(false, true)) {
            this.f15043a.d(o.b(obj));
        }
    }

    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
