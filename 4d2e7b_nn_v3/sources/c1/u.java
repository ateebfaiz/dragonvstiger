package c1;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    private final int f17277a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17278b;

    public u(int i10, int i11) {
        this.f17277a = i10;
        this.f17278b = i11;
    }

    public final int a() {
        return this.f17277a;
    }

    public final int b() {
        return this.f17278b;
    }

    public final int c() {
        return this.f17278b;
    }

    public final int d() {
        return this.f17277a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        if (this.f17277a == uVar.f17277a && this.f17278b == uVar.f17278b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f17277a * 31) + this.f17278b;
    }

    public String toString() {
        return "TrimMetrics(itemsTrimmed=" + this.f17277a + ", dataTrimmed=" + this.f17278b + ')';
    }
}
