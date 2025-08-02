package com.alibaba.fastjson.util;

import java.lang.reflect.Type;

public class IdentityHashMap<V> {
    private final Entry<V>[] buckets;
    private final int indexMask;

    protected static final class Entry<V> {
        public final int hashCode;
        public final Type key;
        public final Entry<V> next;
        public V value;

        public Entry(Type type, V v10, int i10, Entry<V> entry) {
            this.key = type;
            this.value = v10;
            this.next = entry;
            this.hashCode = i10;
        }
    }

    public IdentityHashMap(int i10) {
        this.indexMask = i10 - 1;
        this.buckets = new Entry[i10];
    }

    public Class findClass(String str) {
        int i10 = 0;
        while (true) {
            Entry<V>[] entryArr = this.buckets;
            if (i10 >= entryArr.length) {
                return null;
            }
            Entry<V> entry = entryArr[i10];
            if (entry != null) {
                for (Entry<V> entry2 = entry; entry2 != null; entry2 = entry2.next) {
                    Type type = entry.key;
                    if (type instanceof Class) {
                        Class cls = (Class) type;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
                continue;
            }
            i10++;
        }
    }

    public final V get(Type type) {
        for (Entry<V> entry = this.buckets[System.identityHashCode(type) & this.indexMask]; entry != null; entry = entry.next) {
            if (type == entry.key) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean put(Type type, V v10) {
        int identityHashCode = System.identityHashCode(type);
        int i10 = this.indexMask & identityHashCode;
        for (Entry<V> entry = this.buckets[i10]; entry != null; entry = entry.next) {
            if (type == entry.key) {
                entry.value = v10;
                return true;
            }
        }
        this.buckets[i10] = new Entry<>(type, v10, identityHashCode, this.buckets[i10]);
        return false;
    }
}
