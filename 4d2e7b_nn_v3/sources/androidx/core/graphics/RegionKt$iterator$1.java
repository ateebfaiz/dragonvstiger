package androidx.core.graphics;

import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import wb.a;

public final class RegionKt$iterator$1 implements Iterator<Rect>, a {
    private boolean hasMore;
    private final RegionIterator iterator;
    private final Rect rect;

    RegionKt$iterator$1(Region region) {
        RegionIterator regionIterator = new RegionIterator(region);
        this.iterator = regionIterator;
        Rect rect2 = new Rect();
        this.rect = rect2;
        this.hasMore = regionIterator.next(rect2);
    }

    public boolean hasNext() {
        return this.hasMore;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Rect next() {
        if (this.hasMore) {
            Rect rect2 = new Rect(this.rect);
            this.hasMore = this.iterator.next(this.rect);
            return rect2;
        }
        throw new IndexOutOfBoundsException();
    }
}
