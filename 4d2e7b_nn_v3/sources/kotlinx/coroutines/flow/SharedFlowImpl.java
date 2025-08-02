package kotlinx.coroutines.flow;

import cc.c0;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.c;
import kotlinx.coroutines.flow.internal.l;
import kotlinx.coroutines.j;
import kotlinx.coroutines.m0;

public abstract class SharedFlowImpl extends kotlinx.coroutines.flow.internal.b implements i1, c, l {
    /* access modifiers changed from: private */
    public int C;

    /* renamed from: e  reason: collision with root package name */
    private final int f1006e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final int f1007f;

    /* renamed from: g  reason: collision with root package name */
    private final c f1008g;

    /* renamed from: h  reason: collision with root package name */
    private Object[] f1009h;

    /* renamed from: i  reason: collision with root package name */
    private long f1010i;

    /* renamed from: j  reason: collision with root package name */
    private long f1011j;

    /* renamed from: w  reason: collision with root package name */
    private int f1012w;

    private static final class a implements m0 {

        /* renamed from: a  reason: collision with root package name */
        public final SharedFlowImpl f1013a;

        /* renamed from: b  reason: collision with root package name */
        public long f1014b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f1015c;

        /* renamed from: d  reason: collision with root package name */
        public final d f1016d;

        public a(SharedFlowImpl sharedFlowImpl, long j10, Object obj, d dVar) {
            this.f1013a = sharedFlowImpl;
            this.f1014b = j10;
            this.f1015c = obj;
            this.f1016d = dVar;
        }

        public void dispose() {
            this.f1013a.z(this);
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1017a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlinx.coroutines.channels.c[] r0 = kotlinx.coroutines.channels.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.coroutines.channels.c r1 = kotlinx.coroutines.channels.c.SUSPEND     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.coroutines.channels.c r1 = kotlinx.coroutines.channels.c.DROP_LATEST     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.coroutines.channels.c r1 = kotlinx.coroutines.channels.c.DROP_OLDEST     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f1017a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.b.<clinit>():void");
        }
    }

    public SharedFlowImpl(int i10, int i11, c cVar) {
        this.f1006e = i10;
        this.f1007f = i11;
        this.f1008g = cVar;
    }

    private final void A() {
        if (this.f1007f != 0 || this.C > 1) {
            Object[] objArr = this.f1009h;
            m.c(objArr);
            while (this.C > 0 && n1.d(objArr, (L() + ((long) Q())) - 1) == n1.f1066a) {
                this.C--;
                n1.e(objArr, L() + ((long) Q()), (Object) null);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: kotlinx.coroutines.flow.o1} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00aa A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ab A[EDGE_INSN: B:48:0x00ab->B:38:0x00ab ?: BREAK  , SYNTHETIC] */
    static /* synthetic */ java.lang.Object B(kotlinx.coroutines.flow.SharedFlowImpl r8, kotlinx.coroutines.flow.d r9, kotlin.coroutines.d r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.SharedFlowImpl$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            if (r2 == 0) goto L_0x0077
            r8 = 1
            if (r2 == r8) goto L_0x0061
            if (r2 == r4) goto L_0x004d
            if (r2 != r3) goto L_0x0045
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.f1 r8 = (kotlinx.coroutines.f1) r8
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.flow.o1 r9 = (kotlinx.coroutines.flow.o1) r9
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.d r2 = (kotlinx.coroutines.flow.d) r2
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.SharedFlowImpl r5 = (kotlinx.coroutines.flow.SharedFlowImpl) r5
            kotlin.p.b(r10)     // Catch:{ all -> 0x0042 }
        L_0x003e:
            r10 = r2
            r2 = r8
            r8 = r5
            goto L_0x008f
        L_0x0042:
            r8 = move-exception
            goto L_0x00c4
        L_0x0045:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004d:
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.f1 r8 = (kotlinx.coroutines.f1) r8
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.flow.o1 r9 = (kotlinx.coroutines.flow.o1) r9
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.d r2 = (kotlinx.coroutines.flow.d) r2
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.SharedFlowImpl r5 = (kotlinx.coroutines.flow.SharedFlowImpl) r5
            kotlin.p.b(r10)     // Catch:{ all -> 0x0042 }
            goto L_0x0092
        L_0x0061:
            java.lang.Object r8 = r0.L$2
            r9 = r8
            kotlinx.coroutines.flow.o1 r9 = (kotlinx.coroutines.flow.o1) r9
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.flow.d r8 = (kotlinx.coroutines.flow.d) r8
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.SharedFlowImpl r2 = (kotlinx.coroutines.flow.SharedFlowImpl) r2
            kotlin.p.b(r10)     // Catch:{ all -> 0x0074 }
            r10 = r8
            r8 = r2
            goto L_0x0083
        L_0x0074:
            r8 = move-exception
            r5 = r2
            goto L_0x00c4
        L_0x0077:
            kotlin.p.b(r10)
            kotlinx.coroutines.flow.internal.d r10 = r8.g()
            kotlinx.coroutines.flow.o1 r10 = (kotlinx.coroutines.flow.o1) r10
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0083:
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()     // Catch:{ all -> 0x00c1 }
            kotlinx.coroutines.f1$b r5 = kotlinx.coroutines.f1.f964r     // Catch:{ all -> 0x00c1 }
            kotlin.coroutines.CoroutineContext$Element r2 = r2.get(r5)     // Catch:{ all -> 0x00c1 }
            kotlinx.coroutines.f1 r2 = (kotlinx.coroutines.f1) r2     // Catch:{ all -> 0x00c1 }
        L_0x008f:
            r5 = r8
            r8 = r2
            r2 = r10
        L_0x0092:
            java.lang.Object r10 = r5.V(r9)     // Catch:{ all -> 0x0042 }
            cc.c0 r6 = kotlinx.coroutines.flow.n1.f1066a     // Catch:{ all -> 0x0042 }
            if (r10 != r6) goto L_0x00ab
            r0.L$0 = r5     // Catch:{ all -> 0x0042 }
            r0.L$1 = r2     // Catch:{ all -> 0x0042 }
            r0.L$2 = r9     // Catch:{ all -> 0x0042 }
            r0.L$3 = r8     // Catch:{ all -> 0x0042 }
            r0.label = r4     // Catch:{ all -> 0x0042 }
            java.lang.Object r10 = r5.y(r9, r0)     // Catch:{ all -> 0x0042 }
            if (r10 != r1) goto L_0x0092
            return r1
        L_0x00ab:
            if (r8 == 0) goto L_0x00b0
            kotlinx.coroutines.j1.g(r8)     // Catch:{ all -> 0x0042 }
        L_0x00b0:
            r0.L$0 = r5     // Catch:{ all -> 0x0042 }
            r0.L$1 = r2     // Catch:{ all -> 0x0042 }
            r0.L$2 = r9     // Catch:{ all -> 0x0042 }
            r0.L$3 = r8     // Catch:{ all -> 0x0042 }
            r0.label = r3     // Catch:{ all -> 0x0042 }
            java.lang.Object r10 = r2.i(r10, r0)     // Catch:{ all -> 0x0042 }
            if (r10 != r1) goto L_0x003e
            return r1
        L_0x00c1:
            r10 = move-exception
            r5 = r8
            r8 = r10
        L_0x00c4:
            r5.l(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.B(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.d, kotlin.coroutines.d):java.lang.Object");
    }

    private final void C(long j10) {
        kotlinx.coroutines.flow.internal.d[] e10;
        if (!(this.f1049b == 0 || (e10 = this.f1048a) == null)) {
            for (kotlinx.coroutines.flow.internal.d dVar : e10) {
                if (dVar != null) {
                    o1 o1Var = (o1) dVar;
                    long j11 = o1Var.f1067a;
                    if (j11 >= 0 && j11 < j10) {
                        o1Var.f1067a = j10;
                    }
                }
            }
        }
        this.f1011j = j10;
    }

    private final void F() {
        Object[] objArr = this.f1009h;
        m.c(objArr);
        n1.e(objArr, L(), (Object) null);
        this.f1012w--;
        long L = L() + 1;
        if (this.f1010i < L) {
            this.f1010i = L;
        }
        if (this.f1011j < L) {
            C(L);
        }
    }

    static /* synthetic */ Object G(SharedFlowImpl sharedFlowImpl, Object obj, d dVar) {
        if (sharedFlowImpl.f(obj)) {
            return Unit.f12577a;
        }
        Object H = sharedFlowImpl.H(obj, dVar);
        if (H == kotlin.coroutines.intrinsics.b.c()) {
            return H;
        }
        return Unit.f12577a;
    }

    private final Object H(Object obj, d dVar) {
        d[] dVarArr;
        a aVar;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.b.b(dVar), 1);
        cancellableContinuationImpl.E();
        d[] dVarArr2 = kotlinx.coroutines.flow.internal.c.f1052a;
        synchronized (this) {
            try {
                if (S(obj)) {
                    o.a aVar2 = o.f12592b;
                    cancellableContinuationImpl.d(o.b(Unit.f12577a));
                    dVarArr = J(dVarArr2);
                    aVar = null;
                } else {
                    a aVar3 = new a(this, ((long) Q()) + L(), obj, cancellableContinuationImpl);
                    I(aVar3);
                    this.C = this.C + 1;
                    if (this.f1007f == 0) {
                        dVarArr2 = J(dVarArr2);
                    }
                    dVarArr = dVarArr2;
                    aVar = aVar3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aVar != null) {
            j.a(cancellableContinuationImpl, aVar);
        }
        for (d dVar2 : dVarArr) {
            if (dVar2 != null) {
                o.a aVar4 = o.f12592b;
                dVar2.d(o.b(Unit.f12577a));
            }
        }
        Object A = cancellableContinuationImpl.A();
        if (A == kotlin.coroutines.intrinsics.b.c()) {
            e.c(dVar);
        }
        if (A == kotlin.coroutines.intrinsics.b.c()) {
            return A;
        }
        return Unit.f12577a;
    }

    /* access modifiers changed from: private */
    public final void I(Object obj) {
        int Q = Q();
        Object[] objArr = this.f1009h;
        if (objArr == null) {
            objArr = R((Object[]) null, 0, 2);
        } else if (Q >= objArr.length) {
            objArr = R(objArr, Q, objArr.length * 2);
        }
        n1.e(objArr, L() + ((long) Q), obj);
    }

    /* JADX WARNING: type inference failed for: r11v6, types: [java.lang.Object[], java.lang.Object] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        r4 = (kotlinx.coroutines.flow.o1) r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.coroutines.d[] J(kotlin.coroutines.d[] r11) {
        /*
            r10 = this;
            int r0 = r11.length
            int r1 = r10.f1049b
            if (r1 == 0) goto L_0x0047
            kotlinx.coroutines.flow.internal.d[] r1 = r10.f1048a
            if (r1 == 0) goto L_0x0047
            int r2 = r1.length
            r3 = 0
        L_0x000f:
            if (r3 >= r2) goto L_0x0047
            r4 = r1[r3]
            if (r4 == 0) goto L_0x0044
            kotlinx.coroutines.flow.o1 r4 = (kotlinx.coroutines.flow.o1) r4
            kotlin.coroutines.d r5 = r4.f1068b
            if (r5 != 0) goto L_0x001c
            goto L_0x0044
        L_0x001c:
            long r6 = r10.U(r4)
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x0044
            int r6 = r11.length
            if (r0 < r6) goto L_0x0039
            int r6 = r11.length
            r7 = 2
            int r6 = r6 * r7
            int r6 = java.lang.Math.max(r7, r6)
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r6)
            java.lang.String r6 = "copyOf(this, newSize)"
            kotlin.jvm.internal.m.e(r11, r6)
        L_0x0039:
            r6 = r11
            kotlin.coroutines.d[] r6 = (kotlin.coroutines.d[]) r6
            int r7 = r0 + 1
            r6[r0] = r5
            r0 = 0
            r4.f1068b = r0
            r0 = r7
        L_0x0044:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0047:
            kotlin.coroutines.d[] r11 = (kotlin.coroutines.d[]) r11
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.J(kotlin.coroutines.d[]):kotlin.coroutines.d[]");
    }

    private final long K() {
        return L() + ((long) this.f1012w);
    }

    /* access modifiers changed from: private */
    public final long L() {
        return Math.min(this.f1011j, this.f1010i);
    }

    private final Object N(long j10) {
        Object[] objArr = this.f1009h;
        m.c(objArr);
        Object a10 = n1.d(objArr, j10);
        if (a10 instanceof a) {
            return ((a) a10).f1015c;
        }
        return a10;
    }

    private final long O() {
        return L() + ((long) this.f1012w) + ((long) this.C);
    }

    private final int P() {
        return (int) ((L() + ((long) this.f1012w)) - this.f1010i);
    }

    /* access modifiers changed from: private */
    public final int Q() {
        return this.f1012w + this.C;
    }

    private final Object[] R(Object[] objArr, int i10, int i11) {
        if (i11 > 0) {
            Object[] objArr2 = new Object[i11];
            this.f1009h = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long L = L();
            for (int i12 = 0; i12 < i10; i12++) {
                long j10 = ((long) i12) + L;
                n1.e(objArr2, j10, n1.d(objArr, j10));
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    /* access modifiers changed from: private */
    public final boolean S(Object obj) {
        if (m() == 0) {
            return T(obj);
        }
        if (this.f1012w >= this.f1007f && this.f1011j <= this.f1010i) {
            int i10 = b.f1017a[this.f1008g.ordinal()];
            if (i10 == 1) {
                return false;
            }
            if (i10 == 2) {
                return true;
            }
        }
        I(obj);
        int i11 = this.f1012w + 1;
        this.f1012w = i11;
        if (i11 > this.f1007f) {
            F();
        }
        if (P() > this.f1006e) {
            W(this.f1010i + 1, this.f1011j, K(), O());
        }
        return true;
    }

    private final boolean T(Object obj) {
        if (this.f1006e == 0) {
            return true;
        }
        I(obj);
        int i10 = this.f1012w + 1;
        this.f1012w = i10;
        if (i10 > this.f1006e) {
            F();
        }
        this.f1011j = L() + ((long) this.f1012w);
        return true;
    }

    /* access modifiers changed from: private */
    public final long U(o1 o1Var) {
        long j10 = o1Var.f1067a;
        if (j10 < K()) {
            return j10;
        }
        if (this.f1007f <= 0 && j10 <= L() && this.C != 0) {
            return j10;
        }
        return -1;
    }

    private final Object V(o1 o1Var) {
        Object obj;
        d[] dVarArr = kotlinx.coroutines.flow.internal.c.f1052a;
        synchronized (this) {
            try {
                long U = U(o1Var);
                if (U < 0) {
                    obj = n1.f1066a;
                } else {
                    long j10 = o1Var.f1067a;
                    Object N = N(U);
                    o1Var.f1067a = U + 1;
                    Object obj2 = N;
                    dVarArr = X(j10);
                    obj = obj2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (d dVar : dVarArr) {
            if (dVar != null) {
                o.a aVar = o.f12592b;
                dVar.d(o.b(Unit.f12577a));
            }
        }
        return obj;
    }

    private final void W(long j10, long j11, long j12, long j13) {
        long min = Math.min(j11, j10);
        for (long L = L(); L < min; L++) {
            Object[] objArr = this.f1009h;
            m.c(objArr);
            n1.e(objArr, L, (Object) null);
        }
        this.f1010i = j10;
        this.f1011j = j11;
        this.f1012w = (int) (j12 - min);
        this.C = (int) (j13 - j12);
    }

    private final Object y(o1 o1Var, d dVar) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.b.b(dVar), 1);
        cancellableContinuationImpl.E();
        synchronized (this) {
            try {
                if (U(o1Var) < 0) {
                    o1Var.f1068b = cancellableContinuationImpl;
                } else {
                    o.a aVar = o.f12592b;
                    cancellableContinuationImpl.d(o.b(Unit.f12577a));
                }
                Unit unit = Unit.f12577a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object A = cancellableContinuationImpl.A();
        if (A == kotlin.coroutines.intrinsics.b.c()) {
            e.c(dVar);
        }
        if (A == kotlin.coroutines.intrinsics.b.c()) {
            return A;
        }
        return Unit.f12577a;
    }

    /* access modifiers changed from: private */
    public final void z(a aVar) {
        synchronized (this) {
            if (aVar.f1014b >= L()) {
                Object[] objArr = this.f1009h;
                m.c(objArr);
                if (n1.d(objArr, aVar.f1014b) == aVar) {
                    n1.e(objArr, aVar.f1014b, n1.f1066a);
                    A();
                    Unit unit = Unit.f12577a;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public o1 j() {
        return new o1();
    }

    /* access modifiers changed from: protected */
    /* renamed from: E */
    public o1[] k(int i10) {
        return new o1[i10];
    }

    /* access modifiers changed from: protected */
    public final Object M() {
        Object[] objArr = this.f1009h;
        m.c(objArr);
        return n1.d(objArr, (this.f1010i + ((long) P())) - 1);
    }

    public final d[] X(long j10) {
        int i10;
        long j11;
        long j12;
        long j13;
        boolean z10;
        long j14;
        kotlinx.coroutines.flow.internal.d[] e10;
        if (j10 > this.f1011j) {
            return kotlinx.coroutines.flow.internal.c.f1052a;
        }
        long L = L();
        long j15 = ((long) this.f1012w) + L;
        if (this.f1007f == 0 && this.C > 0) {
            j15++;
        }
        if (!(this.f1049b == 0 || (e10 = this.f1048a) == null)) {
            for (kotlinx.coroutines.flow.internal.d dVar : e10) {
                if (dVar != null) {
                    long j16 = ((o1) dVar).f1067a;
                    if (j16 >= 0 && j16 < j15) {
                        j15 = j16;
                    }
                }
            }
        }
        if (j15 <= this.f1011j) {
            return kotlinx.coroutines.flow.internal.c.f1052a;
        }
        long K = K();
        if (m() > 0) {
            i10 = Math.min(this.C, this.f1007f - ((int) (K - j15)));
        } else {
            i10 = this.C;
        }
        d[] dVarArr = kotlinx.coroutines.flow.internal.c.f1052a;
        long j17 = ((long) this.C) + K;
        if (i10 > 0) {
            dVarArr = new d[i10];
            Object[] objArr = this.f1009h;
            m.c(objArr);
            long j18 = K;
            int i11 = 0;
            while (true) {
                if (K >= j17) {
                    j12 = j15;
                    j11 = j17;
                    break;
                }
                Object a10 = n1.d(objArr, K);
                j12 = j15;
                c0 c0Var = n1.f1066a;
                if (a10 != c0Var) {
                    m.d(a10, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) a10;
                    int i12 = i11 + 1;
                    j11 = j17;
                    dVarArr[i11] = aVar.f1016d;
                    n1.e(objArr, K, c0Var);
                    n1.e(objArr, j18, aVar.f1015c);
                    j14 = 1;
                    j18++;
                    if (i12 >= i10) {
                        break;
                    }
                    i11 = i12;
                } else {
                    j11 = j17;
                    j14 = 1;
                }
                K += j14;
                j15 = j12;
                j17 = j11;
            }
            K = j18;
        } else {
            j12 = j15;
            j11 = j17;
        }
        int i13 = (int) (K - L);
        if (m() == 0) {
            j13 = K;
        } else {
            j13 = j12;
        }
        long max = Math.max(this.f1010i, K - ((long) Math.min(this.f1006e, i13)));
        if (this.f1007f == 0 && max < j11) {
            Object[] objArr2 = this.f1009h;
            m.c(objArr2);
            if (m.b(n1.d(objArr2, max), n1.f1066a)) {
                K++;
                max++;
            }
        }
        W(max, j13, K, j11);
        A();
        if (dVarArr.length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return J(dVarArr);
        }
        return dVarArr;
    }

    public final long Y() {
        long j10 = this.f1010i;
        if (j10 < this.f1011j) {
            this.f1011j = j10;
        }
        return j10;
    }

    public Object a(d dVar, d dVar2) {
        return B(this, dVar, dVar2);
    }

    public void b() {
        synchronized (this) {
            W(K(), this.f1011j, K(), O());
            Unit unit = Unit.f12577a;
        }
    }

    public c c(CoroutineContext coroutineContext, int i10, c cVar) {
        return n1.c(this, coroutineContext, i10, cVar);
    }

    public boolean f(Object obj) {
        int i10;
        boolean z10;
        d[] dVarArr = kotlinx.coroutines.flow.internal.c.f1052a;
        synchronized (this) {
            if (S(obj)) {
                dVarArr = J(dVarArr);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        for (d dVar : dVarArr) {
            if (dVar != null) {
                o.a aVar = o.f12592b;
                dVar.d(o.b(Unit.f12577a));
            }
        }
        return z10;
    }

    public Object i(Object obj, d dVar) {
        return G(this, obj, dVar);
    }
}
