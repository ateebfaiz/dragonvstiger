package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Retention(RetentionPolicy.RUNTIME)
public @interface n {

    public static class a implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        protected static final a f5021f = new a(Collections.emptySet(), false, false, false, true);

        /* renamed from: a  reason: collision with root package name */
        protected final Set f5022a;

        /* renamed from: b  reason: collision with root package name */
        protected final boolean f5023b;

        /* renamed from: c  reason: collision with root package name */
        protected final boolean f5024c;

        /* renamed from: d  reason: collision with root package name */
        protected final boolean f5025d;

        /* renamed from: e  reason: collision with root package name */
        protected final boolean f5026e;

        protected a(Set set, boolean z10, boolean z11, boolean z12, boolean z13) {
            if (set == null) {
                this.f5022a = Collections.emptySet();
            } else {
                this.f5022a = set;
            }
            this.f5023b = z10;
            this.f5024c = z11;
            this.f5025d = z12;
            this.f5026e = z13;
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

        private static boolean b(Set set, boolean z10, boolean z11, boolean z12, boolean z13) {
            a aVar = f5021f;
            if (z10 != aVar.f5023b || z11 != aVar.f5024c || z12 != aVar.f5025d || z13 != aVar.f5026e) {
                return false;
            }
            if (set == null || set.size() == 0) {
                return true;
            }
            return false;
        }

        private static boolean c(a aVar, a aVar2) {
            if (aVar.f5023b == aVar2.f5023b && aVar.f5026e == aVar2.f5026e && aVar.f5024c == aVar2.f5024c && aVar.f5025d == aVar2.f5025d && aVar.f5022a.equals(aVar2.f5022a)) {
                return true;
            }
            return false;
        }

        private static Set d(Set set, Set set2) {
            if (set.isEmpty()) {
                return set2;
            }
            if (set2.isEmpty()) {
                return set;
            }
            HashSet hashSet = new HashSet(set.size() + set2.size());
            hashSet.addAll(set);
            hashSet.addAll(set2);
            return hashSet;
        }

        public static a e(Set set, boolean z10, boolean z11, boolean z12, boolean z13) {
            if (b(set, z10, z11, z12, z13)) {
                return f5021f;
            }
            return new a(set, z10, z11, z12, z13);
        }

        public static a f() {
            return f5021f;
        }

        public static a i(n nVar) {
            if (nVar == null) {
                return f5021f;
            }
            return e(a(nVar.value()), nVar.ignoreUnknown(), nVar.allowGetters(), nVar.allowSetters(), false);
        }

        public static a j(a aVar, a aVar2) {
            if (aVar == null) {
                return aVar2;
            }
            return aVar.k(aVar2);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (obj.getClass() != getClass() || !c(this, (a) obj)) {
                return false;
            }
            return true;
        }

        public Set h() {
            if (this.f5024c) {
                return Collections.emptySet();
            }
            return this.f5022a;
        }

        public int hashCode() {
            int i10;
            int i11;
            int i12;
            int i13;
            int size = this.f5022a.size();
            if (this.f5023b) {
                i10 = 1;
            } else {
                i10 = -3;
            }
            int i14 = size + i10;
            if (this.f5024c) {
                i11 = 3;
            } else {
                i11 = -7;
            }
            int i15 = i14 + i11;
            if (this.f5025d) {
                i12 = 7;
            } else {
                i12 = -11;
            }
            int i16 = i15 + i12;
            if (this.f5026e) {
                i13 = 11;
            } else {
                i13 = -13;
            }
            return i16 + i13;
        }

        public a k(a aVar) {
            boolean z10;
            boolean z11;
            if (aVar == null || aVar == f5021f) {
                return this;
            }
            if (!aVar.f5026e) {
                return aVar;
            }
            if (c(this, aVar)) {
                return this;
            }
            Set d10 = d(this.f5022a, aVar.f5022a);
            boolean z12 = false;
            if (this.f5023b || aVar.f5023b) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (this.f5024c || aVar.f5024c) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (this.f5025d || aVar.f5025d) {
                z12 = true;
            }
            return e(d10, z10, z11, z12, true);
        }

        /* access modifiers changed from: protected */
        public Object readResolve() {
            if (b(this.f5022a, this.f5023b, this.f5024c, this.f5025d, this.f5026e)) {
                return f5021f;
            }
            return this;
        }

        public String toString() {
            return String.format("JsonIgnoreProperties.Value(ignored=%s,ignoreUnknown=%s,allowGetters=%s,allowSetters=%s,merge=%s)", new Object[]{this.f5022a, Boolean.valueOf(this.f5023b), Boolean.valueOf(this.f5024c), Boolean.valueOf(this.f5025d), Boolean.valueOf(this.f5026e)});
        }
    }

    boolean allowGetters() default false;

    boolean allowSetters() default false;

    boolean ignoreUnknown() default false;

    String[] value() default {};
}
