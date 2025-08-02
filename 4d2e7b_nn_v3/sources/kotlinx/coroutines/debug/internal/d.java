package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public final class d extends WeakReference {

    /* renamed from: a  reason: collision with root package name */
    public final int f961a;

    public d(Object obj, ReferenceQueue referenceQueue) {
        super(obj, referenceQueue);
        int i10;
        if (obj != null) {
            i10 = obj.hashCode();
        } else {
            i10 = 0;
        }
        this.f961a = i10;
    }
}
