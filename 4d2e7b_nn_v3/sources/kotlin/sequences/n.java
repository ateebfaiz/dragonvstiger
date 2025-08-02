package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;

public final class n implements Sequence {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Sequence f790a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Function1 f791b;

    public static final class a implements Iterator, wb.a {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator f792a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f793b;

        a(n nVar) {
            this.f793b = nVar;
            this.f792a = nVar.f790a.iterator();
        }

        public boolean hasNext() {
            return this.f792a.hasNext();
        }

        public Object next() {
            return this.f793b.f791b.invoke(this.f792a.next());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public n(Sequence sequence, Function1 function1) {
        m.f(sequence, "sequence");
        m.f(function1, "transformer");
        this.f790a = sequence;
        this.f791b = function1;
    }

    public Iterator iterator() {
        return new a(this);
    }
}
