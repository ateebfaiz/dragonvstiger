package g4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.g0;
import kotlin.collections.r;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final int f21723a;

    public g(int i10) {
        this.f21723a = i10;
    }

    public final int a(int i10) {
        int i11 = i10 % this.f21723a;
        Integer valueOf = Integer.valueOf(i11);
        if (valueOf.intValue() < 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return i11 + this.f21723a;
    }

    public final int b() {
        return this.f21723a;
    }

    public final boolean c(int i10, int i11, int i12) {
        int a10 = a(i12 + i10);
        if (i10 < a10) {
            if (i10 <= i11 && i11 <= a10) {
                return true;
            }
        } else if (i10 <= i11 && i11 <= this.f21723a) {
            return true;
        } else {
            if (i11 >= 0 && i11 <= a10) {
                return true;
            }
        }
        return false;
    }

    public final List d(int i10, int i11) {
        IntRange l10 = l.l(0, i11);
        ArrayList arrayList = new ArrayList(r.v(l10, 10));
        Iterator it = l10.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(a(((g0) it).nextInt() + i10)));
        }
        return arrayList;
    }
}
