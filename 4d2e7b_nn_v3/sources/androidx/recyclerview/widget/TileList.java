package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.lang.reflect.Array;

class TileList {

    /* renamed from: a  reason: collision with root package name */
    final int f16276a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray f16277b = new SparseArray(10);

    /* renamed from: c  reason: collision with root package name */
    Tile f16278c;

    public static class Tile<T> {
        public int mItemCount;
        public final T[] mItems;
        Tile<T> mNext;
        public int mStartPosition;

        Tile(@NonNull Class<T> cls, int i10) {
            this.mItems = (Object[]) Array.newInstance(cls, i10);
        }

        /* access modifiers changed from: package-private */
        public boolean containsPosition(int i10) {
            int i11 = this.mStartPosition;
            if (i11 > i10 || i10 >= i11 + this.mItemCount) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public T getByPosition(int i10) {
            return this.mItems[i10 - this.mStartPosition];
        }
    }

    public TileList(int i10) {
        this.f16276a = i10;
    }

    public Tile a(Tile tile) {
        int indexOfKey = this.f16277b.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.f16277b.put(tile.mStartPosition, tile);
            return null;
        }
        Tile tile2 = (Tile) this.f16277b.valueAt(indexOfKey);
        this.f16277b.setValueAt(indexOfKey, tile);
        if (this.f16278c == tile2) {
            this.f16278c = tile;
        }
        return tile2;
    }

    public void b() {
        this.f16277b.clear();
    }

    public Tile c(int i10) {
        if (i10 < 0 || i10 >= this.f16277b.size()) {
            return null;
        }
        return (Tile) this.f16277b.valueAt(i10);
    }

    public Object d(int i10) {
        Tile tile = this.f16278c;
        if (tile == null || !tile.containsPosition(i10)) {
            int indexOfKey = this.f16277b.indexOfKey(i10 - (i10 % this.f16276a));
            if (indexOfKey < 0) {
                return null;
            }
            this.f16278c = (Tile) this.f16277b.valueAt(indexOfKey);
        }
        return this.f16278c.getByPosition(i10);
    }

    public Tile e(int i10) {
        Tile tile = (Tile) this.f16277b.get(i10);
        if (this.f16278c == tile) {
            this.f16278c = null;
        }
        this.f16277b.delete(i10);
        return tile;
    }

    public int f() {
        return this.f16277b.size();
    }
}
