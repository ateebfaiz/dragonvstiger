package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.g;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p;
import wb.a;

final class SequenceBuilderIterator<T> extends g implements Iterator<T>, d, a {
    private Iterator<? extends T> nextIterator;
    private d nextStep;
    private T nextValue;
    private int state;

    private final Throwable g() {
        int i10 = this.state;
        if (i10 == 4) {
            return new NoSuchElementException();
        }
        if (i10 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.state);
    }

    private final Object i() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public Object c(Object obj, d dVar) {
        this.nextValue = obj;
        this.state = 3;
        this.nextStep = dVar;
        Object c10 = b.c();
        if (c10 == b.c()) {
            e.c(dVar);
        }
        if (c10 == b.c()) {
            return c10;
        }
        return Unit.f12577a;
    }

    public void d(Object obj) {
        p.b(obj);
        this.state = 4;
    }

    public Object e(Iterator it, d dVar) {
        if (!it.hasNext()) {
            return Unit.f12577a;
        }
        this.nextIterator = it;
        this.state = 2;
        this.nextStep = dVar;
        Object c10 = b.c();
        if (c10 == b.c()) {
            e.c(dVar);
        }
        if (c10 == b.c()) {
            return c10;
        }
        return Unit.f12577a;
    }

    public CoroutineContext getContext() {
        return g.f679a;
    }

    public boolean hasNext() {
        while (true) {
            int i10 = this.state;
            if (i10 != 0) {
                if (i10 == 1) {
                    Iterator<? extends T> it = this.nextIterator;
                    m.c(it);
                    if (it.hasNext()) {
                        this.state = 2;
                        return true;
                    }
                    this.nextIterator = null;
                } else if (i10 == 2 || i10 == 3) {
                    return true;
                } else {
                    if (i10 == 4) {
                        return false;
                    }
                    throw g();
                }
            }
            this.state = 5;
            d dVar = this.nextStep;
            m.c(dVar);
            this.nextStep = null;
            o.a aVar = o.f12592b;
            dVar.d(o.b(Unit.f12577a));
        }
    }

    public final void k(d dVar) {
        this.nextStep = dVar;
    }

    public Object next() {
        int i10 = this.state;
        if (i10 == 0 || i10 == 1) {
            return i();
        }
        if (i10 == 2) {
            this.state = 1;
            Iterator<? extends T> it = this.nextIterator;
            m.c(it);
            return it.next();
        } else if (i10 == 3) {
            this.state = 0;
            T t10 = this.nextValue;
            this.nextValue = null;
            return t10;
        } else {
            throw g();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
