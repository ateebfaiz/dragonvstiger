package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.e;
import kotlin.coroutines.g;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.y;

public abstract class x {

    static final class a extends n implements Function2 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f1201a = new a();

        a() {
            super(2);
        }

        /* renamed from: a */
        public final CoroutineContext invoke(CoroutineContext coroutineContext, CoroutineContext.Element element) {
            return coroutineContext.plus(element);
        }
    }

    static final class b extends n implements Function2 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f1202a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f1203b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(y yVar, boolean z10) {
            super(2);
            this.f1202a = yVar;
            this.f1203b = z10;
        }

        /* renamed from: a */
        public final CoroutineContext invoke(CoroutineContext coroutineContext, CoroutineContext.Element element) {
            return coroutineContext.plus(element);
        }
    }

    static final class c extends n implements Function2 {

        /* renamed from: a  reason: collision with root package name */
        public static final c f1204a = new c();

        c() {
            super(2);
        }

        public final Boolean a(boolean z10, CoroutineContext.Element element) {
            return Boolean.valueOf(z10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Boolean) obj).booleanValue(), (CoroutineContext.Element) obj2);
        }
    }

    private static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean z10) {
        boolean c10 = c(coroutineContext);
        boolean c11 = c(coroutineContext2);
        if (!c10 && !c11) {
            return coroutineContext.plus(coroutineContext2);
        }
        y yVar = new y();
        yVar.f725a = coroutineContext2;
        g gVar = g.f679a;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(gVar, new b(yVar, z10));
        if (c11) {
            yVar.f725a = ((CoroutineContext) yVar.f725a).fold(gVar, a.f1201a);
        }
        return coroutineContext3.plus((CoroutineContext) yVar.f725a);
    }

    public static final String b(CoroutineContext coroutineContext) {
        return null;
    }

    private static final boolean c(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.fold(Boolean.FALSE, c.f1204a)).booleanValue();
    }

    public static final CoroutineContext d(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        if (!c(coroutineContext2)) {
            return coroutineContext.plus(coroutineContext2);
        }
        return a(coroutineContext, coroutineContext2, false);
    }

    public static final CoroutineContext e(b0 b0Var, CoroutineContext coroutineContext) {
        CoroutineContext a10 = a(b0Var.getCoroutineContext(), coroutineContext, true);
        if (a10 == l0.a() || a10.get(e.f677p) != null) {
            return a10;
        }
        return a10.plus(l0.a());
    }

    public static final UndispatchedCoroutine f(kotlin.coroutines.jvm.internal.b bVar) {
        while (!(bVar instanceof DispatchedCoroutine) && (bVar = bVar.c()) != null) {
            if (bVar instanceof UndispatchedCoroutine) {
                return (UndispatchedCoroutine) bVar;
            }
        }
        return null;
    }

    public static final UndispatchedCoroutine g(d dVar, CoroutineContext coroutineContext, Object obj) {
        if (!(dVar instanceof kotlin.coroutines.jvm.internal.b) || coroutineContext.get(a2.f848a) == null) {
            return null;
        }
        UndispatchedCoroutine f10 = f((kotlin.coroutines.jvm.internal.b) dVar);
        if (f10 != null) {
            f10.N0(coroutineContext, obj);
        }
        return f10;
    }
}
