package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;

final class q0 extends c implements RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f654a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f655b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f656c;

    /* renamed from: d  reason: collision with root package name */
    private int f657d;

    public static final class a extends b {

        /* renamed from: c  reason: collision with root package name */
        private int f658c;

        /* renamed from: d  reason: collision with root package name */
        private int f659d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ q0 f660e;

        a(q0 q0Var) {
            this.f660e = q0Var;
            this.f658c = q0Var.size();
            this.f659d = q0Var.f656c;
        }

        /* access modifiers changed from: protected */
        public void a() {
            if (this.f658c == 0) {
                c();
                return;
            }
            d(this.f660e.f654a[this.f659d]);
            this.f659d = (this.f659d + 1) % this.f660e.f655b;
            this.f658c--;
        }
    }

    public q0(Object[] objArr, int i10) {
        m.f(objArr, "buffer");
        this.f654a = objArr;
        if (i10 < 0) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i10).toString());
        } else if (i10 <= objArr.length) {
            this.f655b = objArr.length;
            this.f657d = i10;
        } else {
            throw new IllegalArgumentException(("ring buffer filled size: " + i10 + " cannot be larger than the buffer size: " + objArr.length).toString());
        }
    }

    public final void e(Object obj) {
        if (!i()) {
            this.f654a[(this.f656c + size()) % this.f655b] = obj;
            this.f657d = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    public final q0 f(int i10) {
        Object[] objArr;
        int i11 = this.f655b;
        int f10 = l.f(i11 + (i11 >> 1) + 1, i10);
        if (this.f656c == 0) {
            objArr = Arrays.copyOf(this.f654a, f10);
            m.e(objArr, "copyOf(...)");
        } else {
            objArr = toArray(new Object[f10]);
        }
        return new q0(objArr, size());
    }

    public Object get(int i10) {
        c.Companion.a(i10, size());
        return this.f654a[(this.f656c + i10) % this.f655b];
    }

    public int getSize() {
        return this.f657d;
    }

    public final boolean i() {
        if (size() == this.f655b) {
            return true;
        }
        return false;
    }

    public Iterator iterator() {
        return new a(this);
    }

    public final void j(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i10).toString());
        } else if (i10 > size()) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i10 + ", size = " + size()).toString());
        } else if (i10 > 0) {
            int i11 = this.f656c;
            int c10 = (i11 + i10) % this.f655b;
            if (i11 > c10) {
                j.k(this.f654a, (Object) null, i11, this.f655b);
                j.k(this.f654a, (Object) null, 0, c10);
            } else {
                j.k(this.f654a, (Object) null, i11, c10);
            }
            this.f656c = c10;
            this.f657d = size() - i10;
        }
    }

    public Object[] toArray(Object[] objArr) {
        m.f(objArr, "array");
        if (objArr.length < size()) {
            objArr = Arrays.copyOf(objArr, size());
            m.e(objArr, "copyOf(...)");
        }
        int size = size();
        int i10 = this.f656c;
        int i11 = 0;
        int i12 = 0;
        while (i12 < size && i10 < this.f655b) {
            objArr[i12] = this.f654a[i10];
            i12++;
            i10++;
        }
        while (i12 < size) {
            objArr[i12] = this.f654a[i11];
            i12++;
            i11++;
        }
        return r.f(size, objArr);
    }

    public q0(int i10) {
        this(new Object[i10], 0);
    }

    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
