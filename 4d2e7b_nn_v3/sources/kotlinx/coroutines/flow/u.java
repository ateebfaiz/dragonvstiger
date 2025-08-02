package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

abstract /* synthetic */ class u {

    /* renamed from: a  reason: collision with root package name */
    private static final Function1 f1078a = b.f1081a;

    /* renamed from: b  reason: collision with root package name */
    private static final Function2 f1079b = a.f1080a;

    static final class a extends n implements Function2 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f1080a = new a();

        a() {
            super(2);
        }

        /* renamed from: a */
        public final Boolean invoke(Object obj, Object obj2) {
            return Boolean.valueOf(m.b(obj, obj2));
        }
    }

    static final class b extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f1081a = new b();

        b() {
            super(1);
        }

        public final Object invoke(Object obj) {
            return obj;
        }
    }

    public static final c a(c cVar) {
        if (cVar instanceof t1) {
            return cVar;
        }
        return b(cVar, f1078a, f1079b);
    }

    private static final c b(c cVar, Function1 function1, Function2 function2) {
        if (cVar instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) cVar;
            if (distinctFlowImpl.f968b == function1 && distinctFlowImpl.f969c == function2) {
                return cVar;
            }
        }
        return new DistinctFlowImpl(cVar, function1, function2);
    }
}
