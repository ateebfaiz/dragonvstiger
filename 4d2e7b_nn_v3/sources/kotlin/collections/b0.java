package kotlin.collections;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.jsonwebtoken.JwtParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.random.c;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;
import kotlin.sequences.Sequence;
import kotlin.t;
import kotlin.text.j;

class b0 extends a0 {

    public static final class a implements Sequence {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterable f629a;

        public a(Iterable iterable) {
            this.f629a = iterable;
        }

        public Iterator iterator() {
            return this.f629a.iterator();
        }
    }

    static final class b extends n implements Function1<Integer, Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f630a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(int i10) {
            super(1);
            this.f630a = i10;
        }

        public final Object a(int i10) {
            throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.f630a + JwtParser.SEPARATOR_CHAR);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static Set A0(Iterable iterable) {
        Object obj;
        m.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return t0.g((Set) u0(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return r0.d();
        }
        if (size != 1) {
            return (Set) u0(iterable, new LinkedHashSet(i0.c(collection.size())));
        }
        if (iterable instanceof List) {
            obj = ((List) iterable).get(0);
        } else {
            obj = iterable.iterator().next();
        }
        return r0.c(obj);
    }

    public static List B0(Iterable iterable, Iterable iterable2) {
        m.f(iterable, "<this>");
        m.f(iterable2, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(r.v(iterable, 10), r.v(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(t.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static Sequence Q(Iterable iterable) {
        m.f(iterable, "<this>");
        return new a(iterable);
    }

    public static double R(Iterable iterable) {
        m.f(iterable, "<this>");
        Iterator it = iterable.iterator();
        double d10 = 0.0d;
        int i10 = 0;
        while (it.hasNext()) {
            d10 += (double) ((Number) it.next()).floatValue();
            i10++;
            if (i10 < 0) {
                r.t();
            }
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return d10 / ((double) i10);
    }

    public static boolean S(Iterable iterable, Object obj) {
        m.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (a0(iterable, obj) >= 0) {
            return true;
        }
        return false;
    }

    public static List T(List list, int i10) {
        m.f(list, "<this>");
        if (i10 >= 0) {
            return r.t0(list, l.c(list.size() - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static final Object U(Iterable iterable, int i10) {
        m.f(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).get(i10);
        }
        return V(iterable, i10, new b(i10));
    }

    public static final Object V(Iterable iterable, int i10, Function1 function1) {
        m.f(iterable, "<this>");
        m.f(function1, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (i10 < 0 || i10 > r.n(list)) {
                return function1.invoke(Integer.valueOf(i10));
            }
            return list.get(i10);
        } else if (i10 < 0) {
            return function1.invoke(Integer.valueOf(i10));
        } else {
            int i11 = 0;
            for (Object next : iterable) {
                int i12 = i11 + 1;
                if (i10 == i11) {
                    return next;
                }
                i11 = i12;
            }
            return function1.invoke(Integer.valueOf(i10));
        }
    }

    public static Collection W(Iterable iterable, Collection collection) {
        m.f(iterable, "<this>");
        m.f(collection, FirebaseAnalytics.Param.DESTINATION);
        for (Object next : iterable) {
            if (next != null) {
                collection.add(next);
            }
        }
        return collection;
    }

    public static Object X(Iterable iterable) {
        m.f(iterable, "<this>");
        if (iterable instanceof List) {
            return r.Y((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object Y(List list) {
        m.f(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static Object Z(List list) {
        m.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final int a0(Iterable iterable, Object obj) {
        m.f(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i10 = 0;
        for (Object next : iterable) {
            if (i10 < 0) {
                r.u();
            }
            if (m.b(obj, next)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static Set b0(Iterable iterable, Iterable iterable2) {
        m.f(iterable, "<this>");
        m.f(iterable2, "other");
        Set z02 = z0(iterable);
        y.G(z02, iterable2);
        return z02;
    }

    public static final Appendable c0(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1) {
        m.f(iterable, "<this>");
        m.f(appendable, "buffer");
        m.f(charSequence, "separator");
        m.f(charSequence2, "prefix");
        m.f(charSequence3, "postfix");
        m.f(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i11 = 0;
        for (Object next : iterable) {
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

    public static /* synthetic */ Appendable d0(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        String str = (i11 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i11 & 4) != 0 ? charSequence5 : charSequence2;
        if ((i11 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return c0(iterable, appendable, str, charSequence6, charSequence5, (i11 & 16) != 0 ? -1 : i10, (i11 & 32) != 0 ? "..." : charSequence4, (i11 & 64) != 0 ? null : function1);
    }

    public static final String e0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1) {
        m.f(iterable, "<this>");
        m.f(charSequence, "separator");
        m.f(charSequence2, "prefix");
        m.f(charSequence3, "postfix");
        m.f(charSequence4, "truncated");
        String sb2 = ((StringBuilder) c0(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, function1)).toString();
        m.e(sb2, "toString(...)");
        return sb2;
    }

    public static /* synthetic */ String f0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
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
        return e0(iterable, charSequence, charSequence5, charSequence6, i12, charSequence7, function1);
    }

    public static Object g0(List list) {
        m.f(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(r.n(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static Comparable h0(Iterable iterable) {
        m.f(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static List i0(Iterable iterable, Iterable iterable2) {
        m.f(iterable, "<this>");
        m.f(iterable2, "elements");
        if (iterable instanceof Collection) {
            return r.j0((Collection) iterable, iterable2);
        }
        ArrayList arrayList = new ArrayList();
        r.z(arrayList, iterable);
        r.z(arrayList, iterable2);
        return arrayList;
    }

    public static List j0(Collection collection, Iterable iterable) {
        m.f(collection, "<this>");
        m.f(iterable, "elements");
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        r.z(arrayList2, iterable);
        return arrayList2;
    }

    public static List k0(Collection collection, Object obj) {
        m.f(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static Object l0(Collection collection, c cVar) {
        m.f(collection, "<this>");
        m.f(cVar, "random");
        if (!collection.isEmpty()) {
            return U(collection, cVar.d(collection.size()));
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static List m0(Iterable iterable) {
        m.f(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return r.w0(iterable);
        }
        List x02 = x0(iterable);
        a0.P(x02);
        return x02;
    }

    public static Object n0(Iterable iterable) {
        m.f(iterable, "<this>");
        if (iterable instanceof List) {
            return o0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final Object o0(List list) {
        m.f(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return list.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static Object p0(Iterable iterable) {
        m.f(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return list.get(0);
            }
            return null;
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static List q0(List list, IntRange intRange) {
        m.f(list, "<this>");
        m.f(intRange, "indices");
        if (intRange.isEmpty()) {
            return r.l();
        }
        return r.w0(list.subList(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    public static List r0(Iterable iterable) {
        m.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return r.w0(iterable);
            }
            Object[] array = collection.toArray(new Comparable[0]);
            j.p((Comparable[]) array);
            return j.c(array);
        }
        List x02 = x0(iterable);
        r.x(x02);
        return x02;
    }

    public static List s0(Iterable iterable, Comparator comparator) {
        m.f(iterable, "<this>");
        m.f(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return r.w0(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            j.q(array, comparator);
            return j.c(array);
        }
        List x02 = x0(iterable);
        r.y(x02, comparator);
        return x02;
    }

    public static List t0(Iterable iterable, int i10) {
        m.f(iterable, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        } else if (i10 == 0) {
            return r.l();
        } else {
            if (iterable instanceof Collection) {
                if (i10 >= ((Collection) iterable).size()) {
                    return r.w0(iterable);
                }
                if (i10 == 1) {
                    return r.e(r.X(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i10);
            int i11 = 0;
            for (Object add : iterable) {
                arrayList.add(add);
                i11++;
                if (i11 == i10) {
                    break;
                }
            }
            return t.r(arrayList);
        }
    }

    public static final Collection u0(Iterable iterable, Collection collection) {
        m.f(iterable, "<this>");
        m.f(collection, FirebaseAnalytics.Param.DESTINATION);
        for (Object add : iterable) {
            collection.add(add);
        }
        return collection;
    }

    public static float[] v0(Collection collection) {
        m.f(collection, "<this>");
        float[] fArr = new float[collection.size()];
        Iterator it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            fArr[i10] = ((Number) it.next()).floatValue();
            i10++;
        }
        return fArr;
    }

    public static List w0(Iterable iterable) {
        Object obj;
        m.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return t.r(x0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return r.l();
        }
        if (size != 1) {
            return r.y0(collection);
        }
        if (iterable instanceof List) {
            obj = ((List) iterable).get(0);
        } else {
            obj = iterable.iterator().next();
        }
        return r.e(obj);
    }

    public static final List x0(Iterable iterable) {
        m.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return r.y0((Collection) iterable);
        }
        return (List) u0(iterable, new ArrayList());
    }

    public static List y0(Collection collection) {
        m.f(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final Set z0(Iterable iterable) {
        m.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        return (Set) u0(iterable, new LinkedHashSet());
    }
}
