package kotlin.collections;

import kotlin.jvm.internal.m;

public final class IndexedValue<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f623a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f624b;

    public IndexedValue(int i10, Object obj) {
        this.f623a = i10;
        this.f624b = obj;
    }

    public final int a() {
        return this.f623a;
    }

    public final Object b() {
        return this.f624b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndexedValue)) {
            return false;
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        return this.f623a == indexedValue.f623a && m.b(this.f624b, indexedValue.f624b);
    }

    public int hashCode() {
        int i10 = this.f623a * 31;
        Object obj = this.f624b;
        return i10 + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.f623a + ", value=" + this.f624b + ')';
    }
}
