package kotlin.coroutines;

import java.io.Serializable;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.w;

public final class c implements CoroutineContext, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineContext f670a;

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineContext.Element f671b;

    private static final class a implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        public static final C0009a f672b = new C0009a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final CoroutineContext[] f673a;

        /* renamed from: kotlin.coroutines.c$a$a  reason: collision with other inner class name */
        public static final class C0009a {
            private C0009a() {
            }

            public /* synthetic */ C0009a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public a(CoroutineContext[] coroutineContextArr) {
            m.f(coroutineContextArr, "elements");
            this.f673a = coroutineContextArr;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.f673a;
            CoroutineContext coroutineContext = g.f679a;
            for (CoroutineContext plus : coroutineContextArr) {
                coroutineContext = coroutineContext.plus(plus);
            }
            return coroutineContext;
        }
    }

    static final class b extends n implements Function2<String, CoroutineContext.Element, String> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f674a = new b();

        b() {
            super(2);
        }

        /* renamed from: a */
        public final String invoke(String str, CoroutineContext.Element element) {
            m.f(str, "acc");
            m.f(element, "element");
            if (str.length() == 0) {
                return element.toString();
            }
            return str + ", " + element;
        }
    }

    /* renamed from: kotlin.coroutines.c$c  reason: collision with other inner class name */
    static final class C0010c extends n implements Function2<Unit, CoroutineContext.Element, Unit> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CoroutineContext[] f675a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w f676b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0010c(CoroutineContext[] coroutineContextArr, w wVar) {
            super(2);
            this.f675a = coroutineContextArr;
            this.f676b = wVar;
        }

        public final void a(Unit unit, CoroutineContext.Element element) {
            m.f(unit, "<anonymous parameter 0>");
            m.f(element, "element");
            CoroutineContext[] coroutineContextArr = this.f675a;
            w wVar = this.f676b;
            int i10 = wVar.f723a;
            wVar.f723a = i10 + 1;
            coroutineContextArr[i10] = element;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((Unit) obj, (CoroutineContext.Element) obj2);
            return Unit.f12577a;
        }
    }

    public c(CoroutineContext coroutineContext, CoroutineContext.Element element) {
        m.f(coroutineContext, "left");
        m.f(element, "element");
        this.f670a = coroutineContext;
        this.f671b = element;
    }

    private final boolean c(CoroutineContext.Element element) {
        return m.b(get(element.getKey()), element);
    }

    private final boolean d(c cVar) {
        while (c(cVar.f671b)) {
            CoroutineContext coroutineContext = cVar.f670a;
            if (coroutineContext instanceof c) {
                cVar = (c) coroutineContext;
            } else {
                m.d(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return c((CoroutineContext.Element) coroutineContext);
            }
        }
        return false;
    }

    private final int e() {
        int i10 = 2;
        c cVar = this;
        while (true) {
            CoroutineContext coroutineContext = cVar.f670a;
            if (coroutineContext instanceof c) {
                cVar = (c) coroutineContext;
            } else {
                cVar = null;
            }
            if (cVar == null) {
                return i10;
            }
            i10++;
        }
    }

    private final Object writeReplace() {
        int e10 = e();
        CoroutineContext[] coroutineContextArr = new CoroutineContext[e10];
        w wVar = new w();
        fold(Unit.f12577a, new C0010c(coroutineContextArr, wVar));
        if (wVar.f723a == e10) {
            return new a(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.e() != e() || !cVar.d(this)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public Object fold(Object obj, Function2 function2) {
        m.f(function2, "operation");
        return function2.invoke(this.f670a.fold(obj, function2), this.f671b);
    }

    public CoroutineContext.Element get(CoroutineContext.b bVar) {
        m.f(bVar, "key");
        c cVar = this;
        while (true) {
            CoroutineContext.Element element = cVar.f671b.get(bVar);
            if (element != null) {
                return element;
            }
            CoroutineContext coroutineContext = cVar.f670a;
            if (!(coroutineContext instanceof c)) {
                return coroutineContext.get(bVar);
            }
            cVar = (c) coroutineContext;
        }
    }

    public int hashCode() {
        return this.f670a.hashCode() + this.f671b.hashCode();
    }

    public CoroutineContext minusKey(CoroutineContext.b bVar) {
        m.f(bVar, "key");
        if (this.f671b.get(bVar) != null) {
            return this.f670a;
        }
        CoroutineContext minusKey = this.f670a.minusKey(bVar);
        if (minusKey == this.f670a) {
            return this;
        }
        if (minusKey == g.f679a) {
            return this.f671b;
        }
        return new c(minusKey, this.f671b);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.a.a(this, coroutineContext);
    }

    public String toString() {
        return '[' + ((String) fold("", b.f674a)) + ']';
    }
}
