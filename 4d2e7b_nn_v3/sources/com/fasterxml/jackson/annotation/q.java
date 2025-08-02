package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Retention(RetentionPolicy.RUNTIME)
public @interface q {

    public static class a implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        protected static final a f5048b = new a((Set) null);

        /* renamed from: a  reason: collision with root package name */
        protected final Set f5049a;

        protected a(Set set) {
            this.f5049a = set;
        }

        private static Set a(String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return Collections.emptySet();
            }
            HashSet hashSet = new HashSet(strArr.length);
            for (String add : strArr) {
                hashSet.add(add);
            }
            return hashSet;
        }

        private static boolean b(Set set, Set set2) {
            if (set != null) {
                return set.equals(set2);
            }
            if (set2 == null) {
                return true;
            }
            return false;
        }

        public static a c() {
            return f5048b;
        }

        public static a d(q qVar) {
            if (qVar == null) {
                return f5048b;
            }
            return new a(a(qVar.value()));
        }

        public Set e() {
            return this.f5049a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (obj.getClass() != getClass() || !b(this.f5049a, ((a) obj).f5049a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            Set set = this.f5049a;
            if (set == null) {
                return 0;
            }
            return set.size();
        }

        public String toString() {
            return String.format("JsonIncludeProperties.Value(included=%s)", new Object[]{this.f5049a});
        }
    }

    String[] value() default {};
}
