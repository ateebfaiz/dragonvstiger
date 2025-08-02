package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.internal.ScopeCoroutine;

public abstract class p {

    static final class a extends n implements Function2 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SafeCollector f1061a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(SafeCollector safeCollector) {
            super(2);
            this.f1061a = safeCollector;
        }

        public final Integer a(int i10, CoroutineContext.Element element) {
            int i11;
            CoroutineContext.b key = element.getKey();
            CoroutineContext.Element element2 = this.f1061a.collectContext.get(key);
            if (key != f1.f964r) {
                if (element != element2) {
                    i11 = Integer.MIN_VALUE;
                } else {
                    i11 = i10 + 1;
                }
                return Integer.valueOf(i11);
            }
            f1 f1Var = (f1) element2;
            m.d(element, "null cannot be cast to non-null type kotlinx.coroutines.Job");
            f1 b10 = p.b((f1) element, f1Var);
            if (b10 == f1Var) {
                if (f1Var != null) {
                    i10++;
                }
                return Integer.valueOf(i10);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b10 + ", expected child of " + f1Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (CoroutineContext.Element) obj2);
        }
    }

    public static final void a(SafeCollector safeCollector, CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.fold(0, new a(safeCollector))).intValue() != safeCollector.collectContextSize) {
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
        }
    }

    public static final f1 b(f1 f1Var, f1 f1Var2) {
        while (f1Var != null) {
            if (f1Var == f1Var2 || !(f1Var instanceof ScopeCoroutine)) {
                return f1Var;
            }
            f1Var = f1Var.getParent();
        }
        return null;
    }
}
