package f4;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f21520a;

    public c(int i10) {
        this.f21520a = i10;
    }

    public final Map a(int i10, int i11, int i12) {
        float b10 = l.b(((float) l.f(l.c(i12, 1), this.f21520a)) * b(i10), 0.0f);
        float f10 = (float) i11;
        float e10 = f10 / l.e(b10, f10);
        int i13 = 0;
        IntRange l10 = l.l(0, i11);
        LinkedHashMap linkedHashMap = new LinkedHashMap(l.c(i0.c(r.v(l10, 10)), 16));
        for (Object next : l10) {
            int intValue = ((Number) next).intValue();
            if (((int) (((float) intValue) % e10)) == 0) {
                i13 = intValue;
            }
            linkedHashMap.put(next, Integer.valueOf(i13));
        }
        return linkedHashMap;
    }

    public final float b(int i10) {
        return ((float) i10) / 1000.0f;
    }
}
