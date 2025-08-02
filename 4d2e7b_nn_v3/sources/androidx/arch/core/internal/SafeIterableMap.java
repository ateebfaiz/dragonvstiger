package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {
    private c mEnd;
    private final WeakHashMap<SupportRemove<K, V>, Boolean> mIterators = new WeakHashMap<>();
    private int mSize = 0;
    c mStart;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class IteratorWithAdditions extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
        private boolean mBeforeStart = true;
        private c mCurrent;

        IteratorWithAdditions() {
        }

        public boolean hasNext() {
            if (!this.mBeforeStart) {
                c cVar = this.mCurrent;
                if (cVar == null || cVar.f14401c == null) {
                    return false;
                }
                return true;
            } else if (SafeIterableMap.this.mStart != null) {
                return true;
            } else {
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public void supportRemove(@NonNull c cVar) {
            boolean z10;
            c cVar2 = this.mCurrent;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f14402d;
                this.mCurrent = cVar3;
                if (cVar3 == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.mBeforeStart = z10;
            }
        }

        public Map.Entry<K, V> next() {
            if (this.mBeforeStart) {
                this.mBeforeStart = false;
                this.mCurrent = SafeIterableMap.this.mStart;
            } else {
                c cVar = this.mCurrent;
                this.mCurrent = cVar != null ? cVar.f14401c : null;
            }
            return this.mCurrent;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class SupportRemove<K, V> {
        /* access modifiers changed from: package-private */
        public abstract void supportRemove(@NonNull c cVar);
    }

    static class a extends d {
        a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c a(c cVar) {
            return cVar.f14402d;
        }

        /* access modifiers changed from: package-private */
        public c b(c cVar) {
            return cVar.f14401c;
        }
    }

    private static class b extends d {
        b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c a(c cVar) {
            return cVar.f14401c;
        }

        /* access modifiers changed from: package-private */
        public c b(c cVar) {
            return cVar.f14402d;
        }
    }

    static class c implements Map.Entry {

        /* renamed from: a  reason: collision with root package name */
        final Object f14399a;

        /* renamed from: b  reason: collision with root package name */
        final Object f14400b;

        /* renamed from: c  reason: collision with root package name */
        c f14401c;

        /* renamed from: d  reason: collision with root package name */
        c f14402d;

        c(Object obj, Object obj2) {
            this.f14399a = obj;
            this.f14400b = obj2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.f14399a.equals(cVar.f14399a) || !this.f14400b.equals(cVar.f14400b)) {
                return false;
            }
            return true;
        }

        public Object getKey() {
            return this.f14399a;
        }

        public Object getValue() {
            return this.f14400b;
        }

        public int hashCode() {
            return this.f14399a.hashCode() ^ this.f14400b.hashCode();
        }

        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f14399a + "=" + this.f14400b;
        }
    }

    private static abstract class d extends SupportRemove implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        c f14403a;

        /* renamed from: b  reason: collision with root package name */
        c f14404b;

        d(c cVar, c cVar2) {
            this.f14403a = cVar2;
            this.f14404b = cVar;
        }

        private c c() {
            c cVar = this.f14404b;
            c cVar2 = this.f14403a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return b(cVar);
        }

        /* access modifiers changed from: package-private */
        public abstract c a(c cVar);

        /* access modifiers changed from: package-private */
        public abstract c b(c cVar);

        public boolean hasNext() {
            if (this.f14404b != null) {
                return true;
            }
            return false;
        }

        public void supportRemove(c cVar) {
            if (this.f14403a == cVar && cVar == this.f14404b) {
                this.f14404b = null;
                this.f14403a = null;
            }
            c cVar2 = this.f14403a;
            if (cVar2 == cVar) {
                this.f14403a = a(cVar2);
            }
            if (this.f14404b == cVar) {
                this.f14404b = c();
            }
        }

        public Map.Entry next() {
            c cVar = this.f14404b;
            this.f14404b = c();
            return cVar;
        }
    }

    @NonNull
    public Iterator<Map.Entry<K, V>> descendingIterator() {
        b bVar = new b(this.mEnd, this.mStart);
        this.mIterators.put(bVar, Boolean.FALSE);
        return bVar;
    }

    @Nullable
    public Map.Entry<K, V> eldest() {
        return this.mStart;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (size() != safeIterableMap.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = safeIterableMap.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public c get(K k10) {
        c cVar = this.mStart;
        while (cVar != null && !cVar.f14399a.equals(k10)) {
            cVar = cVar.f14401c;
        }
        return cVar;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += ((Map.Entry) it.next()).hashCode();
        }
        return i10;
    }

    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.mStart, this.mEnd);
        this.mIterators.put(aVar, Boolean.FALSE);
        return aVar;
    }

    @NonNull
    public SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions() {
        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions();
        this.mIterators.put(iteratorWithAdditions, Boolean.FALSE);
        return iteratorWithAdditions;
    }

    @Nullable
    public Map.Entry<K, V> newest() {
        return this.mEnd;
    }

    /* access modifiers changed from: package-private */
    public c put(@NonNull K k10, @NonNull V v10) {
        c cVar = new c(k10, v10);
        this.mSize++;
        c cVar2 = this.mEnd;
        if (cVar2 == null) {
            this.mStart = cVar;
            this.mEnd = cVar;
            return cVar;
        }
        cVar2.f14401c = cVar;
        cVar.f14402d = cVar2;
        this.mEnd = cVar;
        return cVar;
    }

    public V putIfAbsent(@NonNull K k10, @NonNull V v10) {
        c cVar = get(k10);
        if (cVar != null) {
            return cVar.f14400b;
        }
        put(k10, v10);
        return null;
    }

    public V remove(@NonNull K k10) {
        c cVar = get(k10);
        if (cVar == null) {
            return null;
        }
        this.mSize--;
        if (!this.mIterators.isEmpty()) {
            for (SupportRemove<K, V> supportRemove : this.mIterators.keySet()) {
                supportRemove.supportRemove(cVar);
            }
        }
        c cVar2 = cVar.f14402d;
        if (cVar2 != null) {
            cVar2.f14401c = cVar.f14401c;
        } else {
            this.mStart = cVar.f14401c;
        }
        c cVar3 = cVar.f14401c;
        if (cVar3 != null) {
            cVar3.f14402d = cVar2;
        } else {
            this.mEnd = cVar2;
        }
        cVar.f14401c = null;
        cVar.f14402d = null;
        return cVar.f14400b;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb2.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
