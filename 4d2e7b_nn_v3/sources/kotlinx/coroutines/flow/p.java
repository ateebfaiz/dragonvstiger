package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.c;

abstract /* synthetic */ class p {

    public static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f1069a;

        public a(Object obj) {
            this.f1069a = obj;
        }

        public Object a(d dVar, d dVar2) {
            Object i10 = dVar.i(this.f1069a, dVar2);
            if (i10 == b.c()) {
                return i10;
            }
            return Unit.f12577a;
        }
    }

    public static final c a(Function2 function2) {
        return new CallbackFlowBuilder(function2, (CoroutineContext) null, 0, (c) null, 14, (DefaultConstructorMarker) null);
    }

    public static final c b(Function2 function2) {
        return new l1(function2);
    }

    public static final c c(Object obj) {
        return new a(obj);
    }
}
