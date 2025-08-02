package kotlin.coroutines.intrinsics;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.g;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;

class IntrinsicsKt__IntrinsicsJvmKt {
    public static d a(Function2 function2, Object obj, d dVar) {
        m.f(function2, "<this>");
        m.f(dVar, "completion");
        d a10 = e.a(dVar);
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).k(obj, a10);
        }
        CoroutineContext context = a10.getContext();
        if (context == g.f679a) {
            return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3(a10, function2, obj);
        }
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(a10, context, function2, obj);
    }

    public static d b(d dVar) {
        ContinuationImpl continuationImpl;
        d s10;
        m.f(dVar, "<this>");
        if (dVar instanceof ContinuationImpl) {
            continuationImpl = (ContinuationImpl) dVar;
        } else {
            continuationImpl = null;
        }
        if (continuationImpl == null || (s10 = continuationImpl.s()) == null) {
            return dVar;
        }
        return s10;
    }
}
