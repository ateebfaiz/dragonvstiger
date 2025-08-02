package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.g;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.o;
import kotlin.text.j;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.j1;

public final class SafeCollector<T> extends ContinuationImpl implements d, b {
    public final CoroutineContext collectContext;
    public final int collectContextSize;
    public final d collector;
    private kotlin.coroutines.d completion;
    private CoroutineContext lastEmissionContext;

    static final class a extends n implements Function2 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f1043a = new a();

        a() {
            super(2);
        }

        public final Integer a(int i10, CoroutineContext.Element element) {
            return Integer.valueOf(i10 + 1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (CoroutineContext.Element) obj2);
        }
    }

    public SafeCollector(d dVar, CoroutineContext coroutineContext) {
        super(NoOpContinuation.INSTANCE, g.f679a);
        this.collector = dVar;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.fold(0, a.f1043a)).intValue();
    }

    private final void u(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, Object obj) {
        if (coroutineContext2 instanceof i) {
            w((i) coroutineContext2, obj);
        }
        p.a(this, coroutineContext);
    }

    private final Object v(kotlin.coroutines.d dVar, Object obj) {
        CoroutineContext context = dVar.getContext();
        j1.f(context);
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            u(context, coroutineContext, obj);
            this.lastEmissionContext = context;
        }
        this.completion = dVar;
        vb.n a10 = o.f1059a;
        d dVar2 = this.collector;
        m.d(dVar2, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        m.d(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object e10 = a10.e(dVar2, obj, this);
        if (!m.b(e10, kotlin.coroutines.intrinsics.b.c())) {
            this.completion = null;
        }
        return e10;
    }

    private final void w(i iVar, Object obj) {
        throw new IllegalStateException(j.f("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + iVar.f1053a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    public b c() {
        kotlin.coroutines.d dVar = this.completion;
        if (dVar instanceof b) {
            return (b) dVar;
        }
        return null;
    }

    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext == null) {
            return g.f679a;
        }
        return coroutineContext;
    }

    public Object i(Object obj, kotlin.coroutines.d dVar) {
        try {
            Object v10 = v(dVar, obj);
            if (v10 == kotlin.coroutines.intrinsics.b.c()) {
                e.c(dVar);
            }
            if (v10 == kotlin.coroutines.intrinsics.b.c()) {
                return v10;
            }
            return Unit.f12577a;
        } catch (Throwable th) {
            this.lastEmissionContext = new i(th, dVar.getContext());
            throw th;
        }
    }

    public StackTraceElement m() {
        return null;
    }

    public Object n(Object obj) {
        Throwable d10 = o.d(obj);
        if (d10 != null) {
            this.lastEmissionContext = new i(d10, getContext());
        }
        kotlin.coroutines.d dVar = this.completion;
        if (dVar != null) {
            dVar.d(obj);
        }
        return kotlin.coroutines.intrinsics.b.c();
    }

    public void p() {
        super.p();
    }
}
