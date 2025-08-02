package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlinx.coroutines.channels.c;
import kotlinx.coroutines.flow.internal.b;
import kotlinx.coroutines.flow.internal.l;
import kotlinx.coroutines.flow.internal.n;

final class StateFlowImpl extends b implements j1, c, l {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1020f = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");
    private volatile Object _state;

    /* renamed from: e  reason: collision with root package name */
    private int f1021e;

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        r8 = (kotlinx.coroutines.flow.v1[]) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
        if (r8 == null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        r1 = r8.length;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        if (r2 >= r1) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        r4 = r8[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003a, code lost:
        if (r4 == null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003c, code lost:
        r4.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003f, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r8 = r6.f1021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0044, code lost:
        if (r8 != r7) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0046, code lost:
        r6.f1021e = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0049, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r7 = n();
        r1 = kotlin.Unit.f12577a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0053, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0054, code lost:
        r5 = r8;
        r8 = r7;
        r7 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean q(java.lang.Object r7, java.lang.Object r8) {
        /*
            r6 = this;
            r0 = 1
            monitor-enter(r6)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f1020f     // Catch:{ all -> 0x0013 }
            java.lang.Object r2 = r1.get(r6)     // Catch:{ all -> 0x0013 }
            r3 = 0
            if (r7 == 0) goto L_0x0015
            boolean r7 = kotlin.jvm.internal.m.b(r2, r7)     // Catch:{ all -> 0x0013 }
            if (r7 != 0) goto L_0x0015
            monitor-exit(r6)
            return r3
        L_0x0013:
            r7 = move-exception
            goto L_0x0060
        L_0x0015:
            boolean r7 = kotlin.jvm.internal.m.b(r2, r8)     // Catch:{ all -> 0x0013 }
            if (r7 == 0) goto L_0x001d
            monitor-exit(r6)
            return r0
        L_0x001d:
            r1.set(r6, r8)     // Catch:{ all -> 0x0013 }
            int r7 = r6.f1021e     // Catch:{ all -> 0x0013 }
            r8 = r7 & 1
            if (r8 != 0) goto L_0x005a
            int r7 = r7 + r0
            r6.f1021e = r7     // Catch:{ all -> 0x0013 }
            kotlinx.coroutines.flow.internal.d[] r8 = r6.n()     // Catch:{ all -> 0x0013 }
            kotlin.Unit r1 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0013 }
            monitor-exit(r6)
        L_0x0030:
            kotlinx.coroutines.flow.v1[] r8 = (kotlinx.coroutines.flow.v1[]) r8
            if (r8 == 0) goto L_0x0041
            int r1 = r8.length
            r2 = r3
        L_0x0036:
            if (r2 >= r1) goto L_0x0041
            r4 = r8[r2]
            if (r4 == 0) goto L_0x003f
            r4.g()
        L_0x003f:
            int r2 = r2 + r0
            goto L_0x0036
        L_0x0041:
            monitor-enter(r6)
            int r8 = r6.f1021e     // Catch:{ all -> 0x004b }
            if (r8 != r7) goto L_0x004d
            int r7 = r7 + r0
            r6.f1021e = r7     // Catch:{ all -> 0x004b }
            monitor-exit(r6)
            return r0
        L_0x004b:
            r7 = move-exception
            goto L_0x0058
        L_0x004d:
            kotlinx.coroutines.flow.internal.d[] r7 = r6.n()     // Catch:{ all -> 0x004b }
            kotlin.Unit r1 = kotlin.Unit.f12577a     // Catch:{ all -> 0x004b }
            monitor-exit(r6)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x0030
        L_0x0058:
            monitor-exit(r6)
            throw r7
        L_0x005a:
            int r7 = r7 + 2
            r6.f1021e = r7     // Catch:{ all -> 0x0013 }
            monitor-exit(r6)
            return r0
        L_0x0060:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.q(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: kotlinx.coroutines.flow.v1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: kotlinx.coroutines.flow.StateFlowImpl} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0097 A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a6 A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a8 A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bb A[Catch:{ all -> 0x0042 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bc A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c3 A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(kotlinx.coroutines.flow.d r11, kotlin.coroutines.d r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof kotlinx.coroutines.flow.StateFlowImpl$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.StateFlowImpl$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.StateFlowImpl$collect$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            if (r2 == 0) goto L_0x0075
            r11 = 1
            if (r2 == r11) goto L_0x0063
            if (r2 == r5) goto L_0x004d
            if (r2 != r4) goto L_0x0045
            java.lang.Object r11 = r0.L$4
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.f1 r2 = (kotlinx.coroutines.f1) r2
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.flow.v1 r6 = (kotlinx.coroutines.flow.v1) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.flow.d r7 = (kotlinx.coroutines.flow.d) r7
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.flow.StateFlowImpl r8 = (kotlinx.coroutines.flow.StateFlowImpl) r8
            kotlin.p.b(r12)     // Catch:{ all -> 0x0042 }
            goto L_0x008f
        L_0x0042:
            r11 = move-exception
            goto L_0x00d6
        L_0x0045:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x004d:
            java.lang.Object r11 = r0.L$4
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.f1 r2 = (kotlinx.coroutines.f1) r2
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.flow.v1 r6 = (kotlinx.coroutines.flow.v1) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.flow.d r7 = (kotlinx.coroutines.flow.d) r7
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.flow.StateFlowImpl r8 = (kotlinx.coroutines.flow.StateFlowImpl) r8
            kotlin.p.b(r12)     // Catch:{ all -> 0x0042 }
            goto L_0x00bd
        L_0x0063:
            java.lang.Object r11 = r0.L$2
            r6 = r11
            kotlinx.coroutines.flow.v1 r6 = (kotlinx.coroutines.flow.v1) r6
            java.lang.Object r11 = r0.L$1
            kotlinx.coroutines.flow.d r11 = (kotlinx.coroutines.flow.d) r11
            java.lang.Object r2 = r0.L$0
            r8 = r2
            kotlinx.coroutines.flow.StateFlowImpl r8 = (kotlinx.coroutines.flow.StateFlowImpl) r8
            kotlin.p.b(r12)     // Catch:{ all -> 0x0042 }
            goto L_0x0080
        L_0x0075:
            kotlin.p.b(r12)
            kotlinx.coroutines.flow.internal.d r12 = r10.g()
            kotlinx.coroutines.flow.v1 r12 = (kotlinx.coroutines.flow.v1) r12
            r8 = r10
            r6 = r12
        L_0x0080:
            kotlin.coroutines.CoroutineContext r12 = r0.getContext()     // Catch:{ all -> 0x0042 }
            kotlinx.coroutines.f1$b r2 = kotlinx.coroutines.f1.f964r     // Catch:{ all -> 0x0042 }
            kotlin.coroutines.CoroutineContext$Element r12 = r12.get(r2)     // Catch:{ all -> 0x0042 }
            kotlinx.coroutines.f1 r12 = (kotlinx.coroutines.f1) r12     // Catch:{ all -> 0x0042 }
            r7 = r11
            r2 = r12
            r11 = r3
        L_0x008f:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = f1020f     // Catch:{ all -> 0x0042 }
            java.lang.Object r12 = r12.get(r8)     // Catch:{ all -> 0x0042 }
            if (r2 == 0) goto L_0x009a
            kotlinx.coroutines.j1.g(r2)     // Catch:{ all -> 0x0042 }
        L_0x009a:
            if (r11 == 0) goto L_0x00a2
            boolean r9 = kotlin.jvm.internal.m.b(r11, r12)     // Catch:{ all -> 0x0042 }
            if (r9 != 0) goto L_0x00bd
        L_0x00a2:
            cc.c0 r11 = kotlinx.coroutines.flow.internal.n.f1056a     // Catch:{ all -> 0x0042 }
            if (r12 != r11) goto L_0x00a8
            r11 = r3
            goto L_0x00a9
        L_0x00a8:
            r11 = r12
        L_0x00a9:
            r0.L$0 = r8     // Catch:{ all -> 0x0042 }
            r0.L$1 = r7     // Catch:{ all -> 0x0042 }
            r0.L$2 = r6     // Catch:{ all -> 0x0042 }
            r0.L$3 = r2     // Catch:{ all -> 0x0042 }
            r0.L$4 = r12     // Catch:{ all -> 0x0042 }
            r0.label = r5     // Catch:{ all -> 0x0042 }
            java.lang.Object r11 = r7.i(r11, r0)     // Catch:{ all -> 0x0042 }
            if (r11 != r1) goto L_0x00bc
            return r1
        L_0x00bc:
            r11 = r12
        L_0x00bd:
            boolean r12 = r6.h()     // Catch:{ all -> 0x0042 }
            if (r12 != 0) goto L_0x008f
            r0.L$0 = r8     // Catch:{ all -> 0x0042 }
            r0.L$1 = r7     // Catch:{ all -> 0x0042 }
            r0.L$2 = r6     // Catch:{ all -> 0x0042 }
            r0.L$3 = r2     // Catch:{ all -> 0x0042 }
            r0.L$4 = r11     // Catch:{ all -> 0x0042 }
            r0.label = r4     // Catch:{ all -> 0x0042 }
            java.lang.Object r12 = r6.e(r0)     // Catch:{ all -> 0x0042 }
            if (r12 != r1) goto L_0x008f
            return r1
        L_0x00d6:
            r8.l(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.a(kotlinx.coroutines.flow.d, kotlin.coroutines.d):java.lang.Object");
    }

    public void b() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    public c c(CoroutineContext coroutineContext, int i10, c cVar) {
        return u1.d(this, coroutineContext, i10, cVar);
    }

    public boolean f(Object obj) {
        setValue(obj);
        return true;
    }

    public Object i(Object obj, d dVar) {
        setValue(obj);
        return Unit.f12577a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public v1 j() {
        return new v1();
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public v1[] k(int i10) {
        return new v1[i10];
    }

    public void setValue(Object obj) {
        if (obj == null) {
            obj = n.f1056a;
        }
        q((Object) null, obj);
    }
}
