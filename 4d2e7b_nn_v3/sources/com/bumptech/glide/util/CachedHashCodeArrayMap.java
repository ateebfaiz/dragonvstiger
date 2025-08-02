package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {
    private int hashCode;

    public void clear() {
        this.hashCode = 0;
        super.clear();
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = super.hashCode();
        }
        return this.hashCode;
    }

    public V put(K k10, V v10) {
        this.hashCode = 0;
        return super.put(k10, v10);
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.hashCode = 0;
        super.putAll(simpleArrayMap);
    }

    public V removeAt(int i10) {
        this.hashCode = 0;
        return super.removeAt(i10);
    }

    public V setValueAt(int i10, V v10) {
        this.hashCode = 0;
        return super.setValueAt(i10, v10);
    }
}
