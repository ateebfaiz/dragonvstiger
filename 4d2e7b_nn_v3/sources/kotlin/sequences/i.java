package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;

class i {

    public static final class a implements Sequence {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function2 f784a;

        public a(Function2 function2) {
            this.f784a = function2;
        }

        public Iterator iterator() {
            return i.a(this.f784a);
        }
    }

    public static final Iterator a(Function2 function2) {
        m.f(function2, "block");
        SequenceBuilderIterator sequenceBuilderIterator = new SequenceBuilderIterator();
        sequenceBuilderIterator.k(b.a(function2, sequenceBuilderIterator, sequenceBuilderIterator));
        return sequenceBuilderIterator;
    }

    public static Sequence b(Function2 function2) {
        m.f(function2, "block");
        return new a(function2);
    }
}
