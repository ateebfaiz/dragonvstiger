package androidx.core.util;

import android.util.Range;
import kotlin.ranges.f;

public final class RangeKt$toClosedRange$1 implements f {
    final /* synthetic */ Range<T> $this_toClosedRange;

    RangeKt$toClosedRange$1(Range<T> range) {
        this.$this_toClosedRange = range;
    }

    public boolean contains(T t10) {
        return f.a.a(this, t10);
    }

    public T getEndInclusive() {
        return this.$this_toClosedRange.getUpper();
    }

    public T getStart() {
        return this.$this_toClosedRange.getLower();
    }

    public boolean isEmpty() {
        return f.a.b(this);
    }
}
