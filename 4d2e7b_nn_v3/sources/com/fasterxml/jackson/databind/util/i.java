package com.fasterxml.jackson.databind.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public abstract class i {

    public static final class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        private final Set f5687a;

        /* renamed from: b  reason: collision with root package name */
        private final Set f5688b;

        private a(Set set, Set set2) {
            this.f5687a = set == null ? Collections.emptySet() : set;
            this.f5688b = set2;
        }

        public static a a(Set set, Set set2) {
            return new a(set, set2);
        }

        public boolean b(Object obj) {
            Set set = this.f5688b;
            if ((set == null || set.contains(obj)) && !this.f5687a.contains(obj)) {
                return false;
            }
            return true;
        }
    }

    public static a a(Set set, Set set2) {
        if (set2 != null || (set != null && !set.isEmpty())) {
            return a.a(set, set2);
        }
        return null;
    }

    public static boolean b(Object obj, Collection collection, Collection collection2) {
        if (collection == null && collection2 == null) {
            return false;
        }
        if (collection2 == null) {
            return collection.contains(obj);
        }
        if (collection == null) {
            return !collection2.contains(obj);
        }
        if (!collection2.contains(obj) || collection.contains(obj)) {
            return true;
        }
        return false;
    }
}
