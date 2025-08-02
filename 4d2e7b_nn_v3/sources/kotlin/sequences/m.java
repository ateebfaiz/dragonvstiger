package kotlin.sequences;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.n;
import kotlin.text.j;

class m extends l {

    public static final class a implements Iterable, wb.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Sequence f788a;

        public a(Sequence sequence) {
            this.f788a = sequence;
        }

        public Iterator iterator() {
            return this.f788a.iterator();
        }
    }

    static final class b extends n implements Function1<Object, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f789a = new b();

        b() {
            super(1);
        }

        /* renamed from: a */
        public final Boolean invoke(Object obj) {
            boolean z10;
            if (obj == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    public static boolean g(Sequence sequence) {
        kotlin.jvm.internal.m.f(sequence, "<this>");
        return sequence.iterator().hasNext();
    }

    public static Iterable h(Sequence sequence) {
        kotlin.jvm.internal.m.f(sequence, "<this>");
        return new a(sequence);
    }

    public static Sequence i(Sequence sequence, int i10) {
        kotlin.jvm.internal.m.f(sequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        } else if (i10 == 0) {
            return sequence;
        } else {
            if (sequence instanceof c) {
                return ((c) sequence).a(i10);
            }
            return new b(sequence, i10);
        }
    }

    public static Sequence j(Sequence sequence, Function1 function1) {
        kotlin.jvm.internal.m.f(sequence, "<this>");
        kotlin.jvm.internal.m.f(function1, "predicate");
        return new e(sequence, true, function1);
    }

    public static final Sequence k(Sequence sequence, Function1 function1) {
        kotlin.jvm.internal.m.f(sequence, "<this>");
        kotlin.jvm.internal.m.f(function1, "predicate");
        return new e(sequence, false, function1);
    }

    public static final Sequence l(Sequence sequence) {
        kotlin.jvm.internal.m.f(sequence, "<this>");
        Sequence k10 = k(sequence, b.f789a);
        kotlin.jvm.internal.m.d(k10, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return k10;
    }

    public static Object m(Sequence sequence) {
        kotlin.jvm.internal.m.f(sequence, "<this>");
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    public static final Appendable n(Sequence sequence, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1) {
        kotlin.jvm.internal.m.f(sequence, "<this>");
        kotlin.jvm.internal.m.f(appendable, "buffer");
        kotlin.jvm.internal.m.f(charSequence, "separator");
        kotlin.jvm.internal.m.f(charSequence2, "prefix");
        kotlin.jvm.internal.m.f(charSequence3, "postfix");
        kotlin.jvm.internal.m.f(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i11 = 0;
        for (Object next : sequence) {
            i11++;
            if (i11 > 1) {
                appendable.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            j.a(appendable, next, function1);
        }
        if (i10 >= 0 && i11 > i10) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String o(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1) {
        kotlin.jvm.internal.m.f(sequence, "<this>");
        kotlin.jvm.internal.m.f(charSequence, "separator");
        kotlin.jvm.internal.m.f(charSequence2, "prefix");
        kotlin.jvm.internal.m.f(charSequence3, "postfix");
        kotlin.jvm.internal.m.f(charSequence4, "truncated");
        String sb2 = ((StringBuilder) n(sequence, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, function1)).toString();
        kotlin.jvm.internal.m.e(sb2, "toString(...)");
        return sb2;
    }

    public static /* synthetic */ String p(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        CharSequence charSequence5;
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i11 & 2) != 0) {
            charSequence5 = charSequence6;
        } else {
            charSequence5 = charSequence2;
        }
        if ((i11 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            function1 = null;
        }
        return o(sequence, charSequence, charSequence5, charSequence6, i12, charSequence7, function1);
    }

    public static Sequence q(Sequence sequence, Function1 function1) {
        kotlin.jvm.internal.m.f(sequence, "<this>");
        kotlin.jvm.internal.m.f(function1, "transform");
        return new n(sequence, function1);
    }

    public static Sequence r(Sequence sequence, Function1 function1) {
        kotlin.jvm.internal.m.f(sequence, "<this>");
        kotlin.jvm.internal.m.f(function1, "transform");
        return l(new n(sequence, function1));
    }

    public static Object s(Sequence sequence, Comparator comparator) {
        kotlin.jvm.internal.m.f(sequence, "<this>");
        kotlin.jvm.internal.m.f(comparator, "comparator");
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final Collection t(Sequence sequence, Collection collection) {
        kotlin.jvm.internal.m.f(sequence, "<this>");
        kotlin.jvm.internal.m.f(collection, FirebaseAnalytics.Param.DESTINATION);
        for (Object add : sequence) {
            collection.add(add);
        }
        return collection;
    }

    public static List u(Sequence sequence) {
        kotlin.jvm.internal.m.f(sequence, "<this>");
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            return r.l();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return r.e(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static final List v(Sequence sequence) {
        kotlin.jvm.internal.m.f(sequence, "<this>");
        return (List) t(sequence, new ArrayList());
    }

    public static Set w(Sequence sequence) {
        kotlin.jvm.internal.m.f(sequence, "<this>");
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            return r0.d();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return r0.c(next);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(next);
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }
}
