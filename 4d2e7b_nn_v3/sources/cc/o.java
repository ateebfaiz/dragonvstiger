package cc;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.f0;

public class o {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f91a;

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f92b;

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f93c;
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    public static abstract class a extends b {

        /* renamed from: b  reason: collision with root package name */
        public final o f94b;

        /* renamed from: c  reason: collision with root package name */
        public o f95c;

        public a(o oVar) {
            this.f94b = oVar;
        }

        /* renamed from: e */
        public void b(o oVar, Object obj) {
            boolean z10;
            o oVar2;
            if (obj == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                oVar2 = this.f94b;
            } else {
                oVar2 = this.f95c;
            }
            if (oVar2 != null && androidx.concurrent.futures.a.a(o.f91a, oVar, this, oVar2) && z10) {
                o oVar3 = this.f94b;
                o oVar4 = this.f95c;
                m.c(oVar4);
                oVar3.j(oVar4);
            }
        }
    }

    /* synthetic */ class b extends t {
        b(Object obj) {
            super(obj, f0.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1);
        }

        public Object get() {
            return f0.a(this.receiver);
        }
    }

    static {
        Class<o> cls = o.class;
        Class<Object> cls2 = Object.class;
        f91a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next");
        f92b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev");
        f93c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_removedRef");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: cc.o} */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        if (androidx.concurrent.futures.a.a(r4, r3, r2, ((cc.x) r5).f111a) != false) goto L_0x0045;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final cc.o h(cc.w r9) {
        /*
            r8 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f92b
            java.lang.Object r0 = r0.get(r8)
            cc.o r0 = (cc.o) r0
            r1 = 0
            r2 = r0
        L_0x000a:
            r3 = r1
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f91a
            java.lang.Object r5 = r4.get(r2)
            if (r5 != r8) goto L_0x0020
            if (r0 != r2) goto L_0x0016
            return r2
        L_0x0016:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f92b
            boolean r0 = androidx.concurrent.futures.a.a(r1, r8, r0, r2)
            if (r0 != 0) goto L_0x001f
            goto L_0x0000
        L_0x001f:
            return r2
        L_0x0020:
            boolean r6 = r8.n()
            if (r6 == 0) goto L_0x0027
            return r1
        L_0x0027:
            if (r5 != r9) goto L_0x002a
            return r2
        L_0x002a:
            boolean r6 = r5 instanceof cc.w
            if (r6 == 0) goto L_0x0034
            cc.w r5 = (cc.w) r5
            r5.a(r2)
            goto L_0x0000
        L_0x0034:
            boolean r6 = r5 instanceof cc.x
            if (r6 == 0) goto L_0x0050
            if (r3 == 0) goto L_0x0047
            cc.x r5 = (cc.x) r5
            cc.o r5 = r5.f111a
            boolean r2 = androidx.concurrent.futures.a.a(r4, r3, r2, r5)
            if (r2 != 0) goto L_0x0045
            goto L_0x0000
        L_0x0045:
            r2 = r3
            goto L_0x000a
        L_0x0047:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f92b
            java.lang.Object r2 = r4.get(r2)
            cc.o r2 = (cc.o) r2
            goto L_0x000b
        L_0x0050:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.m.d(r5, r3)
            r3 = r5
            cc.o r3 = (cc.o) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.o.h(cc.w):cc.o");
    }

    private final o i(o oVar) {
        while (oVar.n()) {
            oVar = (o) f92b.get(oVar);
        }
        return oVar;
    }

    /* access modifiers changed from: private */
    public final void j(o oVar) {
        o oVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f92b;
        do {
            oVar2 = (o) atomicReferenceFieldUpdater.get(oVar);
            if (k() != oVar) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(f92b, oVar, oVar2, this));
        if (n()) {
            oVar.h((w) null);
        }
    }

    private final x q() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f93c;
        x xVar = (x) atomicReferenceFieldUpdater.get(this);
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x(this);
        atomicReferenceFieldUpdater.lazySet(this, xVar2);
        return xVar2;
    }

    public final boolean g(o oVar) {
        f92b.lazySet(oVar, this);
        f91a.lazySet(oVar, this);
        while (k() == this) {
            if (androidx.concurrent.futures.a.a(f91a, this, this, oVar)) {
                oVar.j(this);
                return true;
            }
        }
        return false;
    }

    public final Object k() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f91a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof w)) {
                return obj;
            }
            ((w) obj).a(this);
        }
    }

    public final o l() {
        return n.b(k());
    }

    public final o m() {
        o h10 = h((w) null);
        if (h10 == null) {
            return i((o) f92b.get(this));
        }
        return h10;
    }

    public boolean n() {
        return k() instanceof x;
    }

    public boolean o() {
        if (p() == null) {
            return true;
        }
        return false;
    }

    public final o p() {
        Object k10;
        o oVar;
        do {
            k10 = k();
            if (k10 instanceof x) {
                return ((x) k10).f111a;
            }
            if (k10 == this) {
                return (o) k10;
            }
            m.d(k10, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            oVar = (o) k10;
        } while (!androidx.concurrent.futures.a.a(f91a, this, k10, oVar.q()));
        oVar.h((w) null);
        return null;
    }

    public final int r(o oVar, o oVar2, a aVar) {
        f92b.lazySet(oVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f91a;
        atomicReferenceFieldUpdater.lazySet(oVar, oVar2);
        aVar.f95c = oVar2;
        if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, oVar2, aVar)) {
            return 0;
        }
        if (aVar.a(this) == null) {
            return 1;
        }
        return 2;
    }

    public String toString() {
        return new b(this) + '@' + f0.b(this);
    }
}
