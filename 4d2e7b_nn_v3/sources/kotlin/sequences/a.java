package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.m;

public final class a implements Sequence {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference f766a;

    public a(Sequence sequence) {
        m.f(sequence, "sequence");
        this.f766a = new AtomicReference(sequence);
    }

    public Iterator iterator() {
        Sequence sequence = (Sequence) this.f766a.getAndSet((Object) null);
        if (sequence != null) {
            return sequence.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
