package kotlin.text;

import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;

public final class MatchGroup {

    /* renamed from: a  reason: collision with root package name */
    private final String f794a;

    /* renamed from: b  reason: collision with root package name */
    private final IntRange f795b;

    public MatchGroup(String str, IntRange intRange) {
        m.f(str, "value");
        m.f(intRange, "range");
        this.f794a = str;
        this.f795b = intRange;
    }

    public final String a() {
        return this.f794a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchGroup)) {
            return false;
        }
        MatchGroup matchGroup = (MatchGroup) obj;
        return m.b(this.f794a, matchGroup.f794a) && m.b(this.f795b, matchGroup.f795b);
    }

    public int hashCode() {
        return (this.f794a.hashCode() * 31) + this.f795b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f794a + ", range=" + this.f795b + ')';
    }
}
