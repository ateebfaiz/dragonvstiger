package androidx.core.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import wb.a;

public final class TreeIterator<T> implements Iterator<T>, a {
    private final Function1<T, Iterator<T>> getChildIterator;
    private Iterator<? extends T> iterator;
    private final List<Iterator<T>> stack = new ArrayList();

    public TreeIterator(Iterator<? extends T> it, Function1<? super T, ? extends Iterator<? extends T>> function1) {
        this.getChildIterator = function1;
        this.iterator = it;
    }

    private final void prepareNextIterator(T t10) {
        Iterator<? extends T> it = (Iterator) this.getChildIterator.invoke(t10);
        if (it == null || !it.hasNext()) {
            while (!this.iterator.hasNext() && (!this.stack.isEmpty())) {
                this.iterator = (Iterator) r.g0(this.stack);
                r.F(this.stack);
            }
            return;
        }
        this.stack.add(this.iterator);
        this.iterator = it;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public T next() {
        T next = this.iterator.next();
        prepareNextIterator(next);
        return next;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
