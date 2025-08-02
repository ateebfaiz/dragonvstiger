package kotlin.ranges;

import io.jsonwebtoken.JwtParser;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.m;
import kotlin.random.c;
import kotlin.random.d;
import kotlin.ranges.g;

class n extends m {
    public static float b(float f10, float f11) {
        return f10 < f11 ? f11 : f10;
    }

    public static int c(int i10, int i11) {
        return i10 < i11 ? i11 : i10;
    }

    public static long d(long j10, long j11) {
        return j10 < j11 ? j11 : j10;
    }

    public static float e(float f10, float f11) {
        return f10 > f11 ? f11 : f10;
    }

    public static int f(int i10, int i11) {
        return i10 > i11 ? i11 : i10;
    }

    public static long g(long j10, long j11) {
        return j10 > j11 ? j11 : j10;
    }

    public static int h(int i10, int i11, int i12) {
        if (i11 > i12) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + JwtParser.SEPARATOR_CHAR);
        } else if (i10 < i11) {
            return i11;
        } else {
            if (i10 > i12) {
                return i12;
            }
            return i10;
        }
    }

    public static g i(int i10, int i11) {
        return g.f744d.a(i10, i11, -1);
    }

    public static int j(IntRange intRange, c cVar) {
        m.f(intRange, "<this>");
        m.f(cVar, "random");
        try {
            return d.d(cVar, intRange);
        } catch (IllegalArgumentException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    public static g k(g gVar, int i10) {
        boolean z10;
        m.f(gVar, "<this>");
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        m.a(z10, Integer.valueOf(i10));
        g.a aVar = g.f744d;
        int a10 = gVar.a();
        int c10 = gVar.c();
        if (gVar.d() <= 0) {
            i10 = -i10;
        }
        return aVar.a(a10, c10, i10);
    }

    public static IntRange l(int i10, int i11) {
        if (i11 <= Integer.MIN_VALUE) {
            return IntRange.f732e.a();
        }
        return new IntRange(i10, i11 - 1);
    }
}
