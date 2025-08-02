package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.collections.f;
import kotlin.collections.g;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.ranges.l;
import kotlinx.coroutines.channels.h;

public final class a extends f {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f937b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f938c;
    private volatile int _size;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ReferenceQueue f939a;
    private volatile Object core;

    /* renamed from: kotlinx.coroutines.debug.internal.a$a  reason: collision with other inner class name */
    private final class C0015a {

        /* renamed from: g  reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f940g = AtomicIntegerFieldUpdater.newUpdater(C0015a.class, "load");
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f941a;

        /* renamed from: b  reason: collision with root package name */
        private final int f942b;

        /* renamed from: c  reason: collision with root package name */
        private final int f943c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceArray f944d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceArray f945e;
        private volatile int load;

        /* renamed from: kotlinx.coroutines.debug.internal.a$a$a  reason: collision with other inner class name */
        private final class C0016a implements Iterator, wb.a {

            /* renamed from: a  reason: collision with root package name */
            private final Function2 f947a;

            /* renamed from: b  reason: collision with root package name */
            private int f948b = -1;

            /* renamed from: c  reason: collision with root package name */
            private Object f949c;

            /* renamed from: d  reason: collision with root package name */
            private Object f950d;

            public C0016a(Function2 function2) {
                this.f947a = function2;
                a();
            }

            private final void a() {
                Object obj;
                while (true) {
                    int i10 = this.f948b + 1;
                    this.f948b = i10;
                    if (i10 < C0015a.this.f941a) {
                        d dVar = (d) C0015a.this.f944d.get(this.f948b);
                        if (!(dVar == null || (obj = dVar.get()) == null)) {
                            this.f949c = obj;
                            Object obj2 = C0015a.this.f945e.get(this.f948b);
                            if (obj2 instanceof e) {
                                obj2 = ((e) obj2).f962a;
                            }
                            if (obj2 != null) {
                                this.f950d = obj2;
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }

            /* renamed from: c */
            public Void remove() {
                Void unused = b.e();
                throw new kotlin.f();
            }

            public boolean hasNext() {
                if (this.f948b < C0015a.this.f941a) {
                    return true;
                }
                return false;
            }

            public Object next() {
                if (this.f948b < C0015a.this.f941a) {
                    Function2 function2 = this.f947a;
                    Object obj = this.f949c;
                    if (obj == null) {
                        m.u("key");
                        obj = Unit.f12577a;
                    }
                    Object obj2 = this.f950d;
                    if (obj2 == null) {
                        m.u("value");
                        obj2 = Unit.f12577a;
                    }
                    Object invoke = function2.invoke(obj, obj2);
                    a();
                    return invoke;
                }
                throw new NoSuchElementException();
            }
        }

        public C0015a(int i10) {
            this.f941a = i10;
            this.f942b = Integer.numberOfLeadingZeros(i10) + 1;
            this.f943c = (i10 * 2) / 3;
            this.f944d = new AtomicReferenceArray(i10);
            this.f945e = new AtomicReferenceArray(i10);
        }

        private final int e(int i10) {
            return (i10 * -1640531527) >>> this.f942b;
        }

        public static /* synthetic */ Object h(C0015a aVar, Object obj, Object obj2, d dVar, int i10, Object obj3) {
            if ((i10 & 4) != 0) {
                dVar = null;
            }
            return aVar.g(obj, obj2, dVar);
        }

        private final void j(int i10) {
            Object obj;
            do {
                obj = this.f945e.get(i10);
                if (obj == null || (obj instanceof e)) {
                    return;
                }
            } while (!h.a(this.f945e, i10, obj, (Object) null));
            a.this.j();
        }

        public final Object d(Object obj) {
            int e10 = e(obj.hashCode());
            while (true) {
                d dVar = (d) this.f944d.get(e10);
                if (dVar == null) {
                    return null;
                }
                Object obj2 = dVar.get();
                if (m.b(obj, obj2)) {
                    Object obj3 = this.f945e.get(e10);
                    if (obj3 instanceof e) {
                        return ((e) obj3).f962a;
                    }
                    return obj3;
                }
                if (obj2 == null) {
                    j(e10);
                }
                if (e10 == 0) {
                    e10 = this.f941a;
                }
                e10--;
            }
        }

        public final Iterator f(Function2 function2) {
            return new C0016a(function2);
        }

        public final Object g(Object obj, Object obj2, d dVar) {
            Object obj3;
            int i10;
            int e10 = e(obj.hashCode());
            boolean z10 = false;
            while (true) {
                d dVar2 = (d) this.f944d.get(e10);
                if (dVar2 == null) {
                    if (obj2 != null) {
                        if (!z10) {
                            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f940g;
                            do {
                                i10 = atomicIntegerFieldUpdater.get(this);
                                if (i10 >= this.f943c) {
                                    return b.f958a;
                                }
                            } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 + 1));
                            z10 = true;
                        }
                        if (dVar == null) {
                            dVar = new d(obj, a.this.f939a);
                        }
                        if (h.a(this.f944d, e10, (Object) null, dVar)) {
                            break;
                        }
                    } else {
                        return null;
                    }
                } else {
                    Object obj4 = dVar2.get();
                    if (!m.b(obj, obj4)) {
                        if (obj4 == null) {
                            j(e10);
                        }
                        if (e10 == 0) {
                            e10 = this.f941a;
                        }
                        e10--;
                    } else if (z10) {
                        f940g.decrementAndGet(this);
                    }
                }
            }
            do {
                obj3 = this.f945e.get(e10);
                if (obj3 instanceof e) {
                    return b.f958a;
                }
            } while (!h.a(this.f945e, e10, obj3, obj2));
            return obj3;
        }

        public final C0015a i() {
            Object obj;
            Object obj2;
            while (true) {
                C0015a aVar = new C0015a(Integer.highestOneBit(l.c(a.this.size(), 4)) * 4);
                int i10 = this.f941a;
                int i11 = 0;
                while (true) {
                    if (i11 >= i10) {
                        return aVar;
                    }
                    d dVar = (d) this.f944d.get(i11);
                    if (dVar != null) {
                        obj = dVar.get();
                    } else {
                        obj = null;
                    }
                    if (dVar != null && obj == null) {
                        j(i11);
                    }
                    while (true) {
                        obj2 = this.f945e.get(i11);
                        if (!(obj2 instanceof e)) {
                            if (h.a(this.f945e, i11, obj2, b.d(obj2))) {
                                break;
                            }
                        } else {
                            obj2 = ((e) obj2).f962a;
                            break;
                        }
                    }
                    if (obj == null || obj2 == null || aVar.g(obj, obj2, dVar) != b.f958a) {
                        i11++;
                    }
                }
            }
        }
    }

    private static final class b implements Map.Entry, wb.a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f952a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f953b;

        public b(Object obj, Object obj2) {
            this.f952a = obj;
            this.f953b = obj2;
        }

        public Object getKey() {
            return this.f952a;
        }

        public Object getValue() {
            return this.f953b;
        }

        public Object setValue(Object obj) {
            Void unused = b.e();
            throw new kotlin.f();
        }
    }

    private final class c extends g {

        /* renamed from: a  reason: collision with root package name */
        private final Function2 f954a;

        public c(Function2 function2) {
            this.f954a = function2;
        }

        public int a() {
            return a.this.size();
        }

        public boolean add(Object obj) {
            Void unused = b.e();
            throw new kotlin.f();
        }

        public Iterator iterator() {
            return ((C0015a) a.f938c.get(a.this)).f(this.f954a);
        }
    }

    static final class d extends n implements Function2 {

        /* renamed from: a  reason: collision with root package name */
        public static final d f956a = new d();

        d() {
            super(2);
        }

        /* renamed from: a */
        public final Map.Entry invoke(Object obj, Object obj2) {
            return new b(obj, obj2);
        }
    }

    static final class e extends n implements Function2 {

        /* renamed from: a  reason: collision with root package name */
        public static final e f957a = new e();

        e() {
            super(2);
        }

        public final Object invoke(Object obj, Object obj2) {
            return obj;
        }
    }

    static {
        Class<a> cls = a.class;
        f937b = AtomicIntegerFieldUpdater.newUpdater(cls, "_size");
        f938c = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "core");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10);
    }

    /* access modifiers changed from: private */
    public final void j() {
        f937b.decrementAndGet(this);
    }

    private final synchronized Object k(Object obj, Object obj2) {
        Object h10;
        C0015a aVar = (C0015a) f938c.get(this);
        while (true) {
            h10 = C0015a.h(aVar, obj, obj2, (d) null, 4, (Object) null);
            if (h10 == b.f958a) {
                aVar = aVar.i();
                f938c.set(this, aVar);
            }
        }
        return h10;
    }

    public Set a() {
        return new c(d.f956a);
    }

    public Set c() {
        return new c(e.f957a);
    }

    public void clear() {
        for (Object remove : keySet()) {
            remove(remove);
        }
    }

    public int d() {
        return f937b.get(this);
    }

    public Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return ((C0015a) f938c.get(this)).d(obj);
    }

    public Object put(Object obj, Object obj2) {
        Object h10 = C0015a.h((C0015a) f938c.get(this), obj, obj2, (d) null, 4, (Object) null);
        if (h10 == b.f958a) {
            h10 = k(obj, obj2);
        }
        if (h10 == null) {
            f937b.incrementAndGet(this);
        }
        return h10;
    }

    public Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        Object h10 = C0015a.h((C0015a) f938c.get(this), obj, (Object) null, (d) null, 4, (Object) null);
        if (h10 == b.f958a) {
            h10 = k(obj, (Object) null);
        }
        if (h10 != null) {
            f937b.decrementAndGet(this);
        }
        return h10;
    }

    public a(boolean z10) {
        this.core = new C0015a(16);
        this.f939a = z10 ? new ReferenceQueue() : null;
    }
}
