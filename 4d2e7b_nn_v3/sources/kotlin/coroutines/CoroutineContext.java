package kotlin.coroutines;

import kotlin.coroutines.e;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public interface CoroutineContext {

    public interface Element extends CoroutineContext {

        public static final class a {
            public static Object a(Element element, Object obj, Function2 function2) {
                m.f(function2, "operation");
                return function2.invoke(obj, element);
            }

            public static Element b(Element element, b bVar) {
                m.f(bVar, "key");
                if (!m.b(element.getKey(), bVar)) {
                    return null;
                }
                m.d(element, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return element;
            }

            public static CoroutineContext c(Element element, b bVar) {
                m.f(bVar, "key");
                if (m.b(element.getKey(), bVar)) {
                    return g.f679a;
                }
                return element;
            }

            public static CoroutineContext d(Element element, CoroutineContext coroutineContext) {
                m.f(coroutineContext, "context");
                return a.a(element, coroutineContext);
            }
        }

        Element get(b bVar);

        b getKey();
    }

    public static final class a {

        /* renamed from: kotlin.coroutines.CoroutineContext$a$a  reason: collision with other inner class name */
        static final class C0008a extends n implements Function2<CoroutineContext, Element, CoroutineContext> {

            /* renamed from: a  reason: collision with root package name */
            public static final C0008a f667a = new C0008a();

            C0008a() {
                super(2);
            }

            /* renamed from: a */
            public final CoroutineContext invoke(CoroutineContext coroutineContext, Element element) {
                c cVar;
                m.f(coroutineContext, "acc");
                m.f(element, "element");
                CoroutineContext minusKey = coroutineContext.minusKey(element.getKey());
                g gVar = g.f679a;
                if (minusKey == gVar) {
                    return element;
                }
                e.b bVar = e.f677p;
                e eVar = (e) minusKey.get(bVar);
                if (eVar == null) {
                    cVar = new c(minusKey, element);
                } else {
                    CoroutineContext minusKey2 = minusKey.minusKey(bVar);
                    if (minusKey2 == gVar) {
                        return new c(element, eVar);
                    }
                    cVar = new c(new c(minusKey2, element), eVar);
                }
                return cVar;
            }
        }

        public static CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
            m.f(coroutineContext2, "context");
            if (coroutineContext2 == g.f679a) {
                return coroutineContext;
            }
            return (CoroutineContext) coroutineContext2.fold(coroutineContext, C0008a.f667a);
        }
    }

    public interface b {
    }

    Object fold(Object obj, Function2 function2);

    Element get(b bVar);

    CoroutineContext minusKey(b bVar);

    CoroutineContext plus(CoroutineContext coroutineContext);
}
