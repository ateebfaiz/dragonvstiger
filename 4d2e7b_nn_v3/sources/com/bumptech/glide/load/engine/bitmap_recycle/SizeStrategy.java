package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;
import java.util.NavigableMap;

@RequiresApi(19)
final class SizeStrategy implements LruPoolStrategy {
    private static final int MAX_SIZE_MULTIPLE = 8;
    private final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap<>();
    private final KeyPool keyPool = new KeyPool();
    private final NavigableMap<Integer, Integer> sortedSizes = new PrettyPrintTreeMap();

    @VisibleForTesting
    static final class Key implements Poolable {
        private final KeyPool pool;
        int size;

        Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key) || this.size != ((Key) obj).size) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.size;
        }

        public void init(int i10) {
            this.size = i10;
        }

        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return SizeStrategy.getBitmapString(this.size);
        }
    }

    @VisibleForTesting
    static class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        public Key get(int i10) {
            Key key = (Key) super.get();
            key.init(i10);
            return key;
        }

        /* access modifiers changed from: protected */
        public Key create() {
            return new Key(this);
        }
    }

    SizeStrategy() {
    }

    private void decrementBitmapOfSize(Integer num) {
        Integer num2 = this.sortedSizes.get(num);
        if (num2.intValue() == 1) {
            this.sortedSizes.remove(num);
        } else {
            this.sortedSizes.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private static String getBitmapString(Bitmap bitmap) {
        return getBitmapString(Util.getBitmapByteSize(bitmap));
    }

    @Nullable
    public Bitmap get(int i10, int i11, Bitmap.Config config) {
        int bitmapByteSize = Util.getBitmapByteSize(i10, i11, config);
        Key key = this.keyPool.get(bitmapByteSize);
        Integer ceilingKey = this.sortedSizes.ceilingKey(Integer.valueOf(bitmapByteSize));
        if (!(ceilingKey == null || ceilingKey.intValue() == bitmapByteSize || ceilingKey.intValue() > bitmapByteSize * 8)) {
            this.keyPool.offer(key);
            key = this.keyPool.get(ceilingKey.intValue());
        }
        Bitmap bitmap = this.groupedMap.get(key);
        if (bitmap != null) {
            bitmap.reconfigure(i10, i11, config);
            decrementBitmapOfSize(ceilingKey);
        }
        return bitmap;
    }

    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(bitmap);
    }

    public void put(Bitmap bitmap) {
        Key key = this.keyPool.get(Util.getBitmapByteSize(bitmap));
        this.groupedMap.put(key, bitmap);
        Integer num = this.sortedSizes.get(Integer.valueOf(key.size));
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes;
        Integer valueOf = Integer.valueOf(key.size);
        int i10 = 1;
        if (num != null) {
            i10 = 1 + num.intValue();
        }
        navigableMap.put(valueOf, Integer.valueOf(i10));
    }

    @Nullable
    public Bitmap removeLast() {
        Bitmap removeLast = this.groupedMap.removeLast();
        if (removeLast != null) {
            decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(removeLast)));
        }
        return removeLast;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.groupedMap + "\n  SortedSizes" + this.sortedSizes;
    }

    public String logBitmap(int i10, int i11, Bitmap.Config config) {
        return getBitmapString(Util.getBitmapByteSize(i10, i11, config));
    }

    static String getBitmapString(int i10) {
        return "[" + i10 + "]";
    }
}
