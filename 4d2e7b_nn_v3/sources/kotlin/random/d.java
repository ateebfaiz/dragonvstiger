package kotlin.random;

import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;

public abstract class d {
    public static final String a(Object obj, Object obj2) {
        m.f(obj, Constants.MessagePayloadKeys.FROM);
        m.f(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }

    public static final void b(int i10, int i11) {
        if (i11 <= i10) {
            throw new IllegalArgumentException(a(Integer.valueOf(i10), Integer.valueOf(i11)).toString());
        }
    }

    public static final int c(int i10) {
        return 31 - Integer.numberOfLeadingZeros(i10);
    }

    public static final int d(c cVar, IntRange intRange) {
        m.f(cVar, "<this>");
        m.f(intRange, "range");
        if (intRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + intRange);
        } else if (intRange.c() < Integer.MAX_VALUE) {
            return cVar.e(intRange.a(), intRange.c() + 1);
        } else {
            if (intRange.a() > Integer.MIN_VALUE) {
                return cVar.e(intRange.a() - 1, intRange.c()) + 1;
            }
            return cVar.c();
        }
    }

    public static final int e(int i10, int i11) {
        return (i10 >>> (32 - i11)) & ((-i11) >> 31);
    }
}
