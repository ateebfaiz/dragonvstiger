package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

class k extends j {

    public static final class a implements Sequence {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterator f785a;

        public a(Iterator it) {
            this.f785a = it;
        }

        public Iterator iterator() {
            return this.f785a;
        }
    }

    static final class b extends n implements Function1<Object, Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function0 f786a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Function0 function0) {
            super(1);
            this.f786a = function0;
        }

        public final Object invoke(Object obj) {
            m.f(obj, "it");
            return this.f786a.invoke();
        }
    }

    static final class c extends n implements Function0<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f787a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Object obj) {
            super(0);
            this.f787a = obj;
        }

        public final Object invoke() {
            return this.f787a;
        }
    }

    public static Sequence c(Iterator it) {
        m.f(it, "<this>");
        return h.d(new a(it));
    }

    public static Sequence d(Sequence sequence) {
        m.f(sequence, "<this>");
        if (sequence instanceof a) {
            return sequence;
        }
        return new a(sequence);
    }

    public static Sequence e(Object obj, Function1 function1) {
        m.f(function1, "nextFunction");
        if (obj == null) {
            return d.f771a;
        }
        return new f(new c(obj), function1);
    }

    public static Sequence f(Function0 function0) {
        m.f(function0, "nextFunction");
        return h.d(new f(function0, new b(function0)));
    }
}
