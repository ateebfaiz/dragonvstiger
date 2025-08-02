package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlinx.coroutines.channels.c;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.flow.internal.l;

final class k1 implements t1, c, l {

    /* renamed from: a  reason: collision with root package name */
    private final f1 f1063a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ t1 f1064b;

    public k1(t1 t1Var, f1 f1Var) {
        this.f1063a = f1Var;
        this.f1064b = t1Var;
    }

    public Object a(d dVar, d dVar2) {
        return this.f1064b.a(dVar, dVar2);
    }

    public c c(CoroutineContext coroutineContext, int i10, c cVar) {
        return u1.d(this, coroutineContext, i10, cVar);
    }
}
