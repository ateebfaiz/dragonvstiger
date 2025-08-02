package kotlinx.coroutines.selects;

import cc.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.g;
import kotlinx.coroutines.m0;
import vb.n;

public class SelectImplementation extends g implements c, j, b2 {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1131f = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state");

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineContext f1132a;

    /* renamed from: b  reason: collision with root package name */
    private List f1133b = new ArrayList(2);

    /* renamed from: c  reason: collision with root package name */
    private Object f1134c;

    /* renamed from: d  reason: collision with root package name */
    private int f1135d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Object f1136e = k.f1162e;
    private volatile Object state = k.f1159b;

    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f1137a;

        /* renamed from: b  reason: collision with root package name */
        private final n f1138b;

        /* renamed from: c  reason: collision with root package name */
        private final n f1139c;

        /* renamed from: d  reason: collision with root package name */
        private final Object f1140d;

        /* renamed from: e  reason: collision with root package name */
        private final Object f1141e;

        /* renamed from: f  reason: collision with root package name */
        public final n f1142f;

        /* renamed from: g  reason: collision with root package name */
        public Object f1143g;

        /* renamed from: h  reason: collision with root package name */
        public int f1144h = -1;

        public a(Object obj, n nVar, n nVar2, Object obj2, Object obj3, n nVar3) {
            this.f1137a = obj;
            this.f1138b = nVar;
            this.f1139c = nVar2;
            this.f1140d = obj2;
            this.f1141e = obj3;
            this.f1142f = nVar3;
        }

        public final Function1 a(j jVar, Object obj) {
            n nVar = this.f1142f;
            if (nVar != null) {
                return (Function1) nVar.e(jVar, this.f1140d, obj);
            }
            return null;
        }

        public final void b() {
            Object obj = this.f1143g;
            SelectImplementation selectImplementation = SelectImplementation.this;
            m0 m0Var = null;
            if (obj instanceof z) {
                ((z) obj).o(this.f1144h, (Throwable) null, selectImplementation.getContext());
                return;
            }
            if (obj instanceof m0) {
                m0Var = (m0) obj;
            }
            if (m0Var != null) {
                m0Var.dispose();
            }
        }

        public final Object c(Object obj, d dVar) {
            Object obj2 = this.f1141e;
            if (this.f1140d == k.i()) {
                m.d(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((Function1) obj2).invoke(dVar);
            }
            m.d(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function2) obj2).invoke(obj, dVar);
        }

        public final Object d(Object obj) {
            return this.f1139c.e(this.f1137a, this.f1140d, obj);
        }

        public final boolean e(SelectImplementation selectImplementation) {
            this.f1138b.e(this.f1137a, selectImplementation, this.f1140d);
            if (selectImplementation.f1136e == k.f1162e) {
                return true;
            }
            return false;
        }
    }

    public SelectImplementation(CoroutineContext coroutineContext) {
        this.f1132a = coroutineContext;
    }

    private final int A(Object obj, Object obj2) {
        boolean z10;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1131f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof CancellableContinuation) {
                a t10 = t(obj);
                if (t10 == null) {
                    continue;
                } else {
                    Function1 a10 = t10.a(this, obj2);
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj3, t10)) {
                        this.f1136e = obj2;
                        if (k.j((CancellableContinuation) obj3, a10)) {
                            return 0;
                        }
                        this.f1136e = null;
                        return 2;
                    }
                }
            } else {
                if (m.b(obj3, k.f1160c)) {
                    z10 = true;
                } else {
                    z10 = obj3 instanceof a;
                }
                if (z10) {
                    return 3;
                }
                if (m.b(obj3, k.f1161d)) {
                    return 2;
                }
                if (m.b(obj3, k.f1159b)) {
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj3, r.e(obj))) {
                        return 1;
                    }
                } else if (!(obj3 instanceof List)) {
                    throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                } else if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj3, r.k0((Collection) obj3, obj))) {
                    return 1;
                }
            }
        }
    }

    private final Object B(d dVar) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(b.b(dVar), 1);
        cancellableContinuationImpl.E();
        AtomicReferenceFieldUpdater k10 = f1131f;
        while (true) {
            Object obj = k10.get(this);
            if (obj == k.f1159b) {
                if (androidx.concurrent.futures.a.a(f1131f, this, obj, cancellableContinuationImpl)) {
                    cancellableContinuationImpl.j(this);
                    break;
                }
            } else if (obj instanceof List) {
                if (androidx.concurrent.futures.a.a(f1131f, this, obj, k.f1159b)) {
                    for (Object m10 : (Iterable) obj) {
                        y(m10);
                    }
                }
            } else if (obj instanceof a) {
                cancellableContinuationImpl.t(Unit.f12577a, ((a) obj).a(this, this.f1136e));
            } else {
                throw new IllegalStateException(("unexpected state: " + obj).toString());
            }
        }
        Object A = cancellableContinuationImpl.A();
        if (A == b.c()) {
            e.c(dVar);
        }
        if (A == b.c()) {
            return A;
        }
        return Unit.f12577a;
    }

    private final void n(Object obj) {
        List list = this.f1133b;
        m.c(list);
        Iterable<a> iterable = list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (a aVar : iterable) {
                if (aVar.f1137a == obj) {
                    throw new IllegalStateException(("Cannot use select clauses on the same object: " + obj).toString());
                }
            }
        }
    }

    private final void o(a aVar) {
        List<a> list = this.f1133b;
        if (list != null) {
            for (a aVar2 : list) {
                if (aVar2 != aVar) {
                    aVar2.b();
                }
            }
            f1131f.set(this, k.f1160c);
            this.f1136e = k.f1162e;
            this.f1133b = null;
        }
    }

    private final Object p(d dVar) {
        Object obj = f1131f.get(this);
        m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        a aVar = (a) obj;
        Object obj2 = this.f1136e;
        o(aVar);
        return aVar.c(aVar.d(obj2), dVar);
    }

    static /* synthetic */ Object r(SelectImplementation selectImplementation, d dVar) {
        if (selectImplementation.u()) {
            return selectImplementation.p(dVar);
        }
        return selectImplementation.s(dVar);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057 A[PHI: r6 
      PHI: (r6v2 java.lang.Object) = (r6v4 java.lang.Object), (r6v1 java.lang.Object) binds: [B:19:0x0054, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object s(kotlin.coroutines.d r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.p.b(r6)
            goto L_0x0057
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0034:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.selects.SelectImplementation r2 = (kotlinx.coroutines.selects.SelectImplementation) r2
            kotlin.p.b(r6)
            goto L_0x004b
        L_0x003c:
            kotlin.p.b(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.B(r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r2 = r5
        L_0x004b:
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r2.p(r0)
            if (r6 != r1) goto L_0x0057
            return r1
        L_0x0057:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.s(kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: kotlinx.coroutines.selects.SelectImplementation$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: kotlinx.coroutines.selects.SelectImplementation$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlinx.coroutines.selects.SelectImplementation$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.selects.SelectImplementation$a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlinx.coroutines.selects.SelectImplementation.a t(java.lang.Object r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f1133b
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x001e
            java.lang.Object r2 = r0.next()
            r3 = r2
            kotlinx.coroutines.selects.SelectImplementation$a r3 = (kotlinx.coroutines.selects.SelectImplementation.a) r3
            java.lang.Object r3 = r3.f1137a
            if (r3 != r5) goto L_0x000c
            r1 = r2
        L_0x001e:
            kotlinx.coroutines.selects.SelectImplementation$a r1 = (kotlinx.coroutines.selects.SelectImplementation.a) r1
            if (r1 == 0) goto L_0x0023
            return r1
        L_0x0023:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Clause with object "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = " is not found"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            java.lang.String r5 = r5.toString()
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.t(java.lang.Object):kotlinx.coroutines.selects.SelectImplementation$a");
    }

    private final boolean u() {
        return f1131f.get(this) instanceof a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object v(kotlinx.coroutines.selects.SelectImplementation.a r5, java.lang.Object r6, kotlin.coroutines.d r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.p.b(r7)
            goto L_0x0041
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.p.b(r7)
            java.lang.Object r6 = r5.d(r6)
            r0.label = r3
            java.lang.Object r7 = r5.c(r6, r0)
            if (r7 != r1) goto L_0x0041
            return r1
        L_0x0041:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.v(kotlinx.coroutines.selects.SelectImplementation$a, java.lang.Object, kotlin.coroutines.d):java.lang.Object");
    }

    public static /* synthetic */ void x(SelectImplementation selectImplementation, a aVar, boolean z10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            selectImplementation.w(aVar, z10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
    }

    /* access modifiers changed from: private */
    public final void y(Object obj) {
        a t10 = t(obj);
        m.c(t10);
        t10.f1143g = null;
        t10.f1144h = -1;
        w(t10, true);
    }

    public void a(m0 m0Var) {
        this.f1134c = m0Var;
    }

    public void b(e eVar, Function1 function1) {
        x(this, new a(eVar.b(), eVar.a(), eVar.d(), k.i(), function1, eVar.c()), false, 1, (Object) null);
    }

    public boolean c(Object obj, Object obj2) {
        if (A(obj, obj2) == 0) {
            return true;
        }
        return false;
    }

    public void d(g gVar, Function2 function2) {
        x(this, new a(gVar.b(), gVar.a(), gVar.d(), (Object) null, function2, gVar.c()), false, 1, (Object) null);
    }

    public void f(z zVar, int i10) {
        this.f1134c = zVar;
        this.f1135d = i10;
    }

    public void g(Object obj) {
        this.f1136e = obj;
    }

    public CoroutineContext getContext() {
        return this.f1132a;
    }

    public void h(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1131f;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == k.f1160c) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, k.f1161d));
        List<a> list = this.f1133b;
        if (list != null) {
            for (a b10 : list) {
                b10.b();
            }
            this.f1136e = k.f1162e;
            this.f1133b = null;
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        h((Throwable) obj);
        return Unit.f12577a;
    }

    public Object q(d dVar) {
        return r(this, dVar);
    }

    public final void w(a aVar, boolean z10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1131f;
        if (!(atomicReferenceFieldUpdater.get(this) instanceof a)) {
            if (!z10) {
                n(aVar.f1137a);
            }
            if (aVar.e(this)) {
                if (!z10) {
                    List list = this.f1133b;
                    m.c(list);
                    list.add(aVar);
                }
                aVar.f1143g = this.f1134c;
                aVar.f1144h = this.f1135d;
                this.f1134c = null;
                this.f1135d = -1;
                return;
            }
            atomicReferenceFieldUpdater.set(this, aVar);
        }
    }

    public final m z(Object obj, Object obj2) {
        return k.a(A(obj, obj2));
    }
}
