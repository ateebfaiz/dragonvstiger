package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;

final class f implements Sequence {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Function0 f779a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Function1 f780b;

    public static final class a implements Iterator, wb.a {

        /* renamed from: a  reason: collision with root package name */
        private Object f781a;

        /* renamed from: b  reason: collision with root package name */
        private int f782b = -2;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f783c;

        a(f fVar) {
            this.f783c = fVar;
        }

        private final void a() {
            Object obj;
            int i10;
            if (this.f782b == -2) {
                obj = this.f783c.f779a.invoke();
            } else {
                Function1 c10 = this.f783c.f780b;
                Object obj2 = this.f781a;
                m.c(obj2);
                obj = c10.invoke(obj2);
            }
            this.f781a = obj;
            if (obj == null) {
                i10 = 0;
            } else {
                i10 = 1;
            }
            this.f782b = i10;
        }

        public boolean hasNext() {
            if (this.f782b < 0) {
                a();
            }
            if (this.f782b == 1) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (this.f782b < 0) {
                a();
            }
            if (this.f782b != 0) {
                Object obj = this.f781a;
                m.d(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.f782b = -1;
                return obj;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public f(Function0 function0, Function1 function1) {
        m.f(function0, "getInitialValue");
        m.f(function1, "getNextValue");
        this.f779a = function0;
        this.f780b = function1;
    }

    public Iterator iterator() {
        return new a(this);
    }
}
