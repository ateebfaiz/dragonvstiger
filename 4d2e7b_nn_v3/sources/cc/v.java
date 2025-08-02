package cc;

import kotlin.Unit;
import kotlin.b;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.n;
import kotlinx.coroutines.a0;

public abstract class v {

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function1 f108a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f109b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CoroutineContext f110c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Function1 function1, Object obj, CoroutineContext coroutineContext) {
            super(1);
            this.f108a = function1;
            this.f109b = obj;
            this.f110c = coroutineContext;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return Unit.f12577a;
        }

        public final void invoke(Throwable th) {
            v.b(this.f108a, this.f109b, this.f110c);
        }
    }

    public static final Function1 a(Function1 function1, Object obj, CoroutineContext coroutineContext) {
        return new a(function1, obj, coroutineContext);
    }

    public static final void b(Function1 function1, Object obj, CoroutineContext coroutineContext) {
        l0 c10 = c(function1, obj, (l0) null);
        if (c10 != null) {
            a0.a(coroutineContext, c10);
        }
    }

    public static final l0 c(Function1 function1, Object obj, l0 l0Var) {
        try {
            function1.invoke(obj);
        } catch (Throwable th) {
            if (l0Var == null || l0Var.getCause() == th) {
                return new l0("Exception in undelivered element handler for " + obj, th);
            }
            b.a(l0Var, th);
        }
        return l0Var;
    }

    public static /* synthetic */ l0 d(Function1 function1, Object obj, l0 l0Var, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            l0Var = null;
        }
        return c(function1, obj, l0Var);
    }
}
