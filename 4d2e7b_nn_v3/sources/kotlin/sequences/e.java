package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;

public final class e<T> implements Sequence<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Sequence f772a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final boolean f773b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Function1 f774c;

    public static final class a implements Iterator, wb.a {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator f775a;

        /* renamed from: b  reason: collision with root package name */
        private int f776b = -1;

        /* renamed from: c  reason: collision with root package name */
        private Object f777c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f778d;

        a(e eVar) {
            this.f778d = eVar;
            this.f775a = eVar.f772a.iterator();
        }

        private final void a() {
            while (this.f775a.hasNext()) {
                Object next = this.f775a.next();
                if (((Boolean) this.f778d.f774c.invoke(next)).booleanValue() == this.f778d.f773b) {
                    this.f777c = next;
                    this.f776b = 1;
                    return;
                }
            }
            this.f776b = 0;
        }

        public boolean hasNext() {
            if (this.f776b == -1) {
                a();
            }
            if (this.f776b == 1) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (this.f776b == -1) {
                a();
            }
            if (this.f776b != 0) {
                Object obj = this.f777c;
                this.f777c = null;
                this.f776b = -1;
                return obj;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(Sequence sequence, boolean z10, Function1 function1) {
        m.f(sequence, "sequence");
        m.f(function1, "predicate");
        this.f772a = sequence;
        this.f773b = z10;
        this.f774c = function1;
    }

    public Iterator iterator() {
        return new a(this);
    }
}
