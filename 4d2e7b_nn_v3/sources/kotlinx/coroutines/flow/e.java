package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.c;
import vb.n;

public abstract class e {
    public static final Object A(c cVar, d dVar) {
        return FlowKt__ReduceKt.i(cVar, dVar);
    }

    public static final Object B(c cVar, d dVar) {
        return FlowKt__ReduceKt.j(cVar, dVar);
    }

    public static final Object C(c cVar, Collection collection, d dVar) {
        return FlowKt__CollectionKt.a(cVar, collection, dVar);
    }

    public static final c D(c cVar, n nVar) {
        return FlowKt__MergeKt.b(cVar, nVar);
    }

    public static final t1 a(j1 j1Var) {
        return m0.a(j1Var);
    }

    public static final c b(c cVar, int i10, c cVar2) {
        return t.a(cVar, i10, cVar2);
    }

    public static final c d(Function2 function2) {
        return p.a(function2);
    }

    public static final Object e(c cVar, d dVar, d dVar2) {
        return FlowKt__ErrorsKt.a(cVar, dVar, dVar2);
    }

    public static final Object f(c cVar, d dVar) {
        return s.a(cVar, dVar);
    }

    public static final Object g(c cVar, Function2 function2, d dVar) {
        return s.b(cVar, function2, dVar);
    }

    public static final Object h(c cVar, d dVar) {
        return FlowKt__CountKt.a(cVar, dVar);
    }

    public static final Object i(c cVar, Function2 function2, d dVar) {
        return FlowKt__CountKt.b(cVar, function2, dVar);
    }

    public static final c j(c cVar) {
        return u.a(cVar);
    }

    public static final Object k(d dVar, ReceiveChannel receiveChannel, d dVar2) {
        return FlowKt__ChannelsKt.b(dVar, receiveChannel, dVar2);
    }

    public static final Object l(d dVar, c cVar, d dVar2) {
        return s.c(dVar, cVar, dVar2);
    }

    public static final void m(d dVar) {
        FlowKt__EmittersKt.b(dVar);
    }

    public static final Object n(c cVar, d dVar) {
        return FlowKt__ReduceKt.a(cVar, dVar);
    }

    public static final Object o(c cVar, Function2 function2, d dVar) {
        return FlowKt__ReduceKt.b(cVar, function2, dVar);
    }

    public static final Object p(c cVar, d dVar) {
        return FlowKt__ReduceKt.c(cVar, dVar);
    }

    public static final Object q(c cVar, Function2 function2, d dVar) {
        return FlowKt__ReduceKt.d(cVar, function2, dVar);
    }

    public static final ReceiveChannel r(b0 b0Var, long j10, long j11) {
        return FlowKt__DelayKt.a(b0Var, j10, j11);
    }

    public static final c t(Function2 function2) {
        return p.b(function2);
    }

    public static final c u(Object obj) {
        return p.c(obj);
    }

    public static final Object v(c cVar, d dVar) {
        return FlowKt__ReduceKt.f(cVar, dVar);
    }

    public static final Object w(c cVar, d dVar) {
        return FlowKt__ReduceKt.g(cVar, dVar);
    }

    public static final c x(c cVar, Function2 function2) {
        return FlowKt__MergeKt.a(cVar, function2);
    }

    public static final ReceiveChannel y(c cVar, b0 b0Var) {
        return FlowKt__ChannelsKt.d(cVar, b0Var);
    }

    public static final Object z(c cVar, n nVar, d dVar) {
        return FlowKt__ReduceKt.h(cVar, nVar, dVar);
    }
}
