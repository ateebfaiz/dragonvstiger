package kotlinx.coroutines.sync;

import cc.z;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;

final class d extends z {

    /* renamed from: e  reason: collision with root package name */
    private final AtomicReferenceArray f1192e = new AtomicReferenceArray(SemaphoreKt.f1182f);

    public d(long j10, d dVar, int i10) {
        super(j10, dVar, i10);
    }

    public int n() {
        return SemaphoreKt.f1182f;
    }

    public void o(int i10, Throwable th, CoroutineContext coroutineContext) {
        r().set(i10, SemaphoreKt.f1181e);
        p();
    }

    public final AtomicReferenceArray r() {
        return this.f1192e;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f113c + ", hashCode=" + hashCode() + ']';
    }
}
