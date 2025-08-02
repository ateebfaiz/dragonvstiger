package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

public final class Options implements Key {
    private final ArrayMap<Option<?>, Object> values = new CachedHashCodeArrayMap();

    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.values.equals(((Options) obj).values);
        }
        return false;
    }

    @Nullable
    public <T> T get(@NonNull Option<T> option) {
        if (this.values.containsKey(option)) {
            return this.values.get(option);
        }
        return option.getDefaultValue();
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public void putAll(@NonNull Options options) {
        this.values.putAll(options.values);
    }

    public Options remove(@NonNull Option<?> option) {
        this.values.remove(option);
        return this;
    }

    @NonNull
    public <T> Options set(@NonNull Option<T> option, @NonNull T t10) {
        this.values.put(option, t10);
        return this;
    }

    public String toString() {
        return "Options{values=" + this.values + '}';
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        for (int i10 = 0; i10 < this.values.size(); i10++) {
            updateDiskCacheKey(this.values.keyAt(i10), this.values.valueAt(i10), messageDigest);
        }
    }

    private static <T> void updateDiskCacheKey(@NonNull Option<T> option, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        option.update(obj, messageDigest);
    }
}
