package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;

public final class i<E> extends e {

    /* renamed from: d  reason: collision with root package name */
    public static final a f643d = new a((DefaultConstructorMarker) null);

    /* renamed from: e  reason: collision with root package name */
    private static final Object[] f644e = new Object[0];

    /* renamed from: a  reason: collision with root package name */
    private int f645a;

    /* renamed from: b  reason: collision with root package name */
    private Object[] f646b = f644e;

    /* renamed from: c  reason: collision with root package name */
    private int f647c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void d(int i10, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f646b.length;
        while (i10 < length && it.hasNext()) {
            this.f646b[i10] = it.next();
            i10++;
        }
        int i11 = this.f645a;
        for (int i12 = 0; i12 < i11 && it.hasNext(); i12++) {
            this.f646b[i12] = it.next();
        }
        this.f647c = size() + collection.size();
    }

    private final void e(int i10) {
        Object[] objArr = new Object[i10];
        Object[] objArr2 = this.f646b;
        j.e(objArr2, objArr, 0, this.f645a, objArr2.length);
        Object[] objArr3 = this.f646b;
        int length = objArr3.length;
        int i11 = this.f645a;
        j.e(objArr3, objArr, length - i11, 0, i11);
        this.f645a = 0;
        this.f646b = objArr;
    }

    private final int f(int i10) {
        if (i10 == 0) {
            return j.A(this.f646b);
        }
        return i10 - 1;
    }

    private final void i(int i10) {
        if (i10 >= 0) {
            Object[] objArr = this.f646b;
            if (i10 > objArr.length) {
                if (objArr == f644e) {
                    this.f646b = new Object[l.c(i10, 10)];
                } else {
                    e(c.Companion.d(objArr.length, i10));
                }
            }
        } else {
            throw new IllegalStateException("Deque is too big.");
        }
    }

    private final int j(int i10) {
        if (i10 == j.A(this.f646b)) {
            return 0;
        }
        return i10 + 1;
    }

    private final int k(int i10) {
        if (i10 < 0) {
            return i10 + this.f646b.length;
        }
        return i10;
    }

    private final int l(int i10) {
        Object[] objArr = this.f646b;
        if (i10 >= objArr.length) {
            return i10 - objArr.length;
        }
        return i10;
    }

    public int a() {
        return this.f647c;
    }

    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    public boolean addAll(Collection collection) {
        m.f(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        i(size() + collection.size());
        d(l(this.f645a + size()), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        i(size() + 1);
        int f10 = f(this.f645a);
        this.f645a = f10;
        this.f646b[f10] = obj;
        this.f647c = size() + 1;
    }

    public final void addLast(Object obj) {
        i(size() + 1);
        this.f646b[l(this.f645a + size())] = obj;
        this.f647c = size() + 1;
    }

    public Object c(int i10) {
        c.Companion.a(i10, size());
        if (i10 == r.n(this)) {
            return removeLast();
        }
        if (i10 == 0) {
            return removeFirst();
        }
        int l10 = l(this.f645a + i10);
        Object obj = this.f646b[l10];
        if (i10 < (size() >> 1)) {
            int i11 = this.f645a;
            if (l10 >= i11) {
                Object[] objArr = this.f646b;
                j.e(objArr, objArr, i11 + 1, i11, l10);
            } else {
                Object[] objArr2 = this.f646b;
                j.e(objArr2, objArr2, 1, 0, l10);
                Object[] objArr3 = this.f646b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i12 = this.f645a;
                j.e(objArr3, objArr3, i12 + 1, i12, objArr3.length - 1);
            }
            Object[] objArr4 = this.f646b;
            int i13 = this.f645a;
            objArr4[i13] = null;
            this.f645a = j(i13);
        } else {
            int l11 = l(this.f645a + r.n(this));
            if (l10 <= l11) {
                Object[] objArr5 = this.f646b;
                j.e(objArr5, objArr5, l10, l10 + 1, l11 + 1);
            } else {
                Object[] objArr6 = this.f646b;
                j.e(objArr6, objArr6, l10, l10 + 1, objArr6.length);
                Object[] objArr7 = this.f646b;
                objArr7[objArr7.length - 1] = objArr7[0];
                j.e(objArr7, objArr7, 0, 1, l11 + 1);
            }
            this.f646b[l11] = null;
        }
        this.f647c = size() - 1;
        return obj;
    }

    public void clear() {
        int l10 = l(this.f645a + size());
        int i10 = this.f645a;
        if (i10 < l10) {
            j.k(this.f646b, (Object) null, i10, l10);
        } else if (!isEmpty()) {
            Object[] objArr = this.f646b;
            j.k(objArr, (Object) null, this.f645a, objArr.length);
            j.k(this.f646b, (Object) null, 0, l10);
        }
        this.f645a = 0;
        this.f647c = 0;
    }

    public boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public Object get(int i10) {
        c.Companion.a(i10, size());
        return this.f646b[l(this.f645a + i10)];
    }

    public int indexOf(Object obj) {
        int i10;
        int l10 = l(this.f645a + size());
        int i11 = this.f645a;
        if (i11 < l10) {
            while (i11 < l10) {
                if (m.b(obj, this.f646b[i11])) {
                    i10 = this.f645a;
                } else {
                    i11++;
                }
            }
            return -1;
        } else if (i11 < l10) {
            return -1;
        } else {
            int length = this.f646b.length;
            while (true) {
                if (i11 >= length) {
                    int i12 = 0;
                    while (i12 < l10) {
                        if (m.b(obj, this.f646b[i12])) {
                            i11 = i12 + this.f646b.length;
                            i10 = this.f645a;
                        } else {
                            i12++;
                        }
                    }
                    return -1;
                } else if (m.b(obj, this.f646b[i11])) {
                    i10 = this.f645a;
                    break;
                } else {
                    i11++;
                }
            }
        }
        return i11 - i10;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final Object last() {
        if (!isEmpty()) {
            return this.f646b[l(this.f645a + r.n(this))];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public int lastIndexOf(Object obj) {
        int i10;
        int i11;
        int l10 = l(this.f645a + size());
        int i12 = this.f645a;
        if (i12 < l10) {
            i10 = l10 - 1;
            if (i12 <= i10) {
                while (!m.b(obj, this.f646b[i10])) {
                    if (i10 != i12) {
                        i10--;
                    }
                }
                i11 = this.f645a;
            }
            return -1;
        }
        if (i12 > l10) {
            int i13 = l10 - 1;
            while (true) {
                if (-1 >= i13) {
                    int A = j.A(this.f646b);
                    int i14 = this.f645a;
                    if (i14 <= A) {
                        while (!m.b(obj, this.f646b[i10])) {
                            if (i10 != i14) {
                                A = i10 - 1;
                            }
                        }
                        i11 = this.f645a;
                    }
                } else if (m.b(obj, this.f646b[i13])) {
                    i10 = i13 + this.f646b.length;
                    i11 = this.f645a;
                    break;
                } else {
                    i13--;
                }
            }
        }
        return -1;
        return i10 - i11;
    }

    public final Object m() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeAll(java.util.Collection r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.m.f(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0091
            java.lang.Object[] r0 = r11.f646b
            int r0 = r0.length
            if (r0 != 0) goto L_0x0013
            goto L_0x0091
        L_0x0013:
            int r0 = r11.f645a
            int r2 = r11.size()
            int r0 = r0 + r2
            int r0 = r11.l(r0)
            int r2 = r11.f645a
            r3 = 0
            r4 = 1
            if (r2 >= r0) goto L_0x0044
            r5 = r2
        L_0x0025:
            if (r2 >= r0) goto L_0x003e
            java.lang.Object[] r6 = r11.f646b
            r6 = r6[r2]
            boolean r7 = r12.contains(r6)
            r7 = r7 ^ r4
            if (r7 == 0) goto L_0x003a
            java.lang.Object[] r7 = r11.f646b
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003b
        L_0x003a:
            r1 = r4
        L_0x003b:
            int r2 = r2 + 1
            goto L_0x0025
        L_0x003e:
            java.lang.Object[] r12 = r11.f646b
            kotlin.collections.j.k(r12, r3, r5, r0)
            goto L_0x0086
        L_0x0044:
            java.lang.Object[] r5 = r11.f646b
            int r5 = r5.length
            r7 = r1
            r6 = r2
        L_0x0049:
            if (r2 >= r5) goto L_0x0064
            java.lang.Object[] r8 = r11.f646b
            r9 = r8[r2]
            r8[r2] = r3
            boolean r8 = r12.contains(r9)
            r8 = r8 ^ r4
            if (r8 == 0) goto L_0x0060
            java.lang.Object[] r8 = r11.f646b
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x0061
        L_0x0060:
            r7 = r4
        L_0x0061:
            int r2 = r2 + 1
            goto L_0x0049
        L_0x0064:
            int r2 = r11.l(r6)
            r5 = r2
        L_0x0069:
            if (r1 >= r0) goto L_0x0085
            java.lang.Object[] r2 = r11.f646b
            r6 = r2[r1]
            r2[r1] = r3
            boolean r2 = r12.contains(r6)
            r2 = r2 ^ r4
            if (r2 == 0) goto L_0x0081
            java.lang.Object[] r2 = r11.f646b
            r2[r5] = r6
            int r5 = r11.j(r5)
            goto L_0x0082
        L_0x0081:
            r7 = r4
        L_0x0082:
            int r1 = r1 + 1
            goto L_0x0069
        L_0x0085:
            r1 = r7
        L_0x0086:
            if (r1 == 0) goto L_0x0091
            int r12 = r11.f645a
            int r5 = r5 - r12
            int r12 = r11.k(r5)
            r11.f647c = r12
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.i.removeAll(java.util.Collection):boolean");
    }

    public final Object removeFirst() {
        if (!isEmpty()) {
            Object[] objArr = this.f646b;
            int i10 = this.f645a;
            Object obj = objArr[i10];
            objArr[i10] = null;
            this.f645a = j(i10);
            this.f647c = size() - 1;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final Object removeLast() {
        if (!isEmpty()) {
            int l10 = l(this.f645a + r.n(this));
            Object[] objArr = this.f646b;
            Object obj = objArr[l10];
            objArr[l10] = null;
            this.f647c = size() - 1;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean retainAll(java.util.Collection r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.m.f(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x008e
            java.lang.Object[] r0 = r11.f646b
            int r0 = r0.length
            if (r0 != 0) goto L_0x0013
            goto L_0x008e
        L_0x0013:
            int r0 = r11.f645a
            int r2 = r11.size()
            int r0 = r0 + r2
            int r0 = r11.l(r0)
            int r2 = r11.f645a
            r3 = 0
            r4 = 1
            if (r2 >= r0) goto L_0x0043
            r5 = r2
        L_0x0025:
            if (r2 >= r0) goto L_0x003d
            java.lang.Object[] r6 = r11.f646b
            r6 = r6[r2]
            boolean r7 = r12.contains(r6)
            if (r7 == 0) goto L_0x0039
            java.lang.Object[] r7 = r11.f646b
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003a
        L_0x0039:
            r1 = r4
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x0025
        L_0x003d:
            java.lang.Object[] r12 = r11.f646b
            kotlin.collections.j.k(r12, r3, r5, r0)
            goto L_0x0083
        L_0x0043:
            java.lang.Object[] r5 = r11.f646b
            int r5 = r5.length
            r7 = r1
            r6 = r2
        L_0x0048:
            if (r2 >= r5) goto L_0x0062
            java.lang.Object[] r8 = r11.f646b
            r9 = r8[r2]
            r8[r2] = r3
            boolean r8 = r12.contains(r9)
            if (r8 == 0) goto L_0x005e
            java.lang.Object[] r8 = r11.f646b
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x005f
        L_0x005e:
            r7 = r4
        L_0x005f:
            int r2 = r2 + 1
            goto L_0x0048
        L_0x0062:
            int r2 = r11.l(r6)
            r5 = r2
        L_0x0067:
            if (r1 >= r0) goto L_0x0082
            java.lang.Object[] r2 = r11.f646b
            r6 = r2[r1]
            r2[r1] = r3
            boolean r2 = r12.contains(r6)
            if (r2 == 0) goto L_0x007e
            java.lang.Object[] r2 = r11.f646b
            r2[r5] = r6
            int r5 = r11.j(r5)
            goto L_0x007f
        L_0x007e:
            r7 = r4
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x0067
        L_0x0082:
            r1 = r7
        L_0x0083:
            if (r1 == 0) goto L_0x008e
            int r12 = r11.f645a
            int r5 = r5 - r12
            int r12 = r11.k(r5)
            r11.f647c = r12
        L_0x008e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.i.retainAll(java.util.Collection):boolean");
    }

    public Object set(int i10, Object obj) {
        c.Companion.a(i10, size());
        int l10 = l(this.f645a + i10);
        Object[] objArr = this.f646b;
        Object obj2 = objArr[l10];
        objArr[l10] = obj;
        return obj2;
    }

    public Object[] toArray(Object[] objArr) {
        m.f(objArr, "array");
        if (objArr.length < size()) {
            objArr = k.a(objArr, size());
        }
        int l10 = l(this.f645a + size());
        int i10 = this.f645a;
        if (i10 < l10) {
            j.g(this.f646b, objArr, 0, i10, l10, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f646b;
            j.e(objArr2, objArr, 0, this.f645a, objArr2.length);
            Object[] objArr3 = this.f646b;
            j.e(objArr3, objArr, objArr3.length - this.f645a, 0, l10);
        }
        return r.f(size(), objArr);
    }

    public void add(int i10, Object obj) {
        c.Companion.b(i10, size());
        if (i10 == size()) {
            addLast(obj);
        } else if (i10 == 0) {
            addFirst(obj);
        } else {
            i(size() + 1);
            int l10 = l(this.f645a + i10);
            if (i10 < ((size() + 1) >> 1)) {
                int f10 = f(l10);
                int f11 = f(this.f645a);
                int i11 = this.f645a;
                if (f10 >= i11) {
                    Object[] objArr = this.f646b;
                    objArr[f11] = objArr[i11];
                    j.e(objArr, objArr, i11, i11 + 1, f10 + 1);
                } else {
                    Object[] objArr2 = this.f646b;
                    j.e(objArr2, objArr2, i11 - 1, i11, objArr2.length);
                    Object[] objArr3 = this.f646b;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    j.e(objArr3, objArr3, 0, 1, f10 + 1);
                }
                this.f646b[f10] = obj;
                this.f645a = f11;
            } else {
                int l11 = l(this.f645a + size());
                if (l10 < l11) {
                    Object[] objArr4 = this.f646b;
                    j.e(objArr4, objArr4, l10 + 1, l10, l11);
                } else {
                    Object[] objArr5 = this.f646b;
                    j.e(objArr5, objArr5, 1, 0, l11);
                    Object[] objArr6 = this.f646b;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    j.e(objArr6, objArr6, l10 + 1, l10, objArr6.length - 1);
                }
                this.f646b[l10] = obj;
            }
            this.f647c = size() + 1;
        }
    }

    public boolean addAll(int i10, Collection collection) {
        m.f(collection, "elements");
        c.Companion.b(i10, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i10 == size()) {
            return addAll(collection);
        }
        i(size() + collection.size());
        int l10 = l(this.f645a + size());
        int l11 = l(this.f645a + i10);
        int size = collection.size();
        if (i10 < ((size() + 1) >> 1)) {
            int i11 = this.f645a;
            int i12 = i11 - size;
            if (l11 < i11) {
                Object[] objArr = this.f646b;
                j.e(objArr, objArr, i12, i11, objArr.length);
                if (size >= l11) {
                    Object[] objArr2 = this.f646b;
                    j.e(objArr2, objArr2, objArr2.length - size, 0, l11);
                } else {
                    Object[] objArr3 = this.f646b;
                    j.e(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f646b;
                    j.e(objArr4, objArr4, 0, size, l11);
                }
            } else if (i12 >= 0) {
                Object[] objArr5 = this.f646b;
                j.e(objArr5, objArr5, i12, i11, l11);
            } else {
                Object[] objArr6 = this.f646b;
                i12 += objArr6.length;
                int i13 = l11 - i11;
                int length = objArr6.length - i12;
                if (length >= i13) {
                    j.e(objArr6, objArr6, i12, i11, l11);
                } else {
                    j.e(objArr6, objArr6, i12, i11, i11 + length);
                    Object[] objArr7 = this.f646b;
                    j.e(objArr7, objArr7, 0, this.f645a + length, l11);
                }
            }
            this.f645a = i12;
            d(k(l11 - size), collection);
        } else {
            int i14 = l11 + size;
            if (l11 < l10) {
                int i15 = size + l10;
                Object[] objArr8 = this.f646b;
                if (i15 <= objArr8.length) {
                    j.e(objArr8, objArr8, i14, l11, l10);
                } else if (i14 >= objArr8.length) {
                    j.e(objArr8, objArr8, i14 - objArr8.length, l11, l10);
                } else {
                    int length2 = l10 - (i15 - objArr8.length);
                    j.e(objArr8, objArr8, 0, length2, l10);
                    Object[] objArr9 = this.f646b;
                    j.e(objArr9, objArr9, i14, l11, length2);
                }
            } else {
                Object[] objArr10 = this.f646b;
                j.e(objArr10, objArr10, size, 0, l10);
                Object[] objArr11 = this.f646b;
                if (i14 >= objArr11.length) {
                    j.e(objArr11, objArr11, i14 - objArr11.length, l11, objArr11.length);
                } else {
                    j.e(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f646b;
                    j.e(objArr12, objArr12, i14, l11, objArr12.length - size);
                }
            }
            d(l11, collection);
        }
        return true;
    }

    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
