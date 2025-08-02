package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Range;
import androidx.annotation.RequiresApi;
import kotlin.ranges.f;

@SuppressLint({"ClassVerificationFailure"})
public final class RangeKt {
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> range, Range<T> range2) {
        return range.intersect(range2);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, T t10) {
        return range.extend(t10);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T t10, T t11) {
        return new Range<>(t10, t11);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> f toClosedRange(Range<T> range) {
        return new RangeKt$toClosedRange$1(range);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> toRange(f fVar) {
        return new Range<>(fVar.getStart(), fVar.getEndInclusive());
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, Range<T> range2) {
        return range.extend(range2);
    }
}
