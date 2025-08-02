package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.m;

public interface e extends CoroutineContext.Element {

    /* renamed from: p  reason: collision with root package name */
    public static final b f677p = b.f678a;

    public static final class a {
        public static CoroutineContext.Element a(e eVar, CoroutineContext.b bVar) {
            m.f(bVar, "key");
            if (bVar instanceof b) {
                b bVar2 = (b) bVar;
                if (!bVar2.a(eVar.getKey())) {
                    return null;
                }
                CoroutineContext.Element b10 = bVar2.b(eVar);
                if (b10 instanceof CoroutineContext.Element) {
                    return b10;
                }
                return null;
            } else if (e.f677p != bVar) {
                return null;
            } else {
                m.d(eVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return eVar;
            }
        }

        public static CoroutineContext b(e eVar, CoroutineContext.b bVar) {
            m.f(bVar, "key");
            if (bVar instanceof b) {
                b bVar2 = (b) bVar;
                if (!bVar2.a(eVar.getKey()) || bVar2.b(eVar) == null) {
                    return eVar;
                }
                return g.f679a;
            } else if (e.f677p == bVar) {
                return g.f679a;
            } else {
                return eVar;
            }
        }
    }

    public static final class b implements CoroutineContext.b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f678a = new b();

        private b() {
        }
    }

    d interceptContinuation(d dVar);

    void releaseInterceptedContinuation(d dVar);
}
