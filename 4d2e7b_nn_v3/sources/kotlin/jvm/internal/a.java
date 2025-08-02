package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class a implements Iterator, wb.a {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f707a;

    /* renamed from: b  reason: collision with root package name */
    private int f708b;

    public a(Object[] objArr) {
        m.f(objArr, "array");
        this.f707a = objArr;
    }

    public boolean hasNext() {
        if (this.f708b < this.f707a.length) {
            return true;
        }
        return false;
    }

    public Object next() {
        try {
            Object[] objArr = this.f707a;
            int i10 = this.f708b;
            this.f708b = i10 + 1;
            return objArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f708b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
